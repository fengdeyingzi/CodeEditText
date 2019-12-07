/*******************************************************************************
 * Copyright (c) 2000, 2015 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Stephan Herrmann - Contribution for
 *								bug 363858 - [dom] early throwing of AbortCompilation causes NPE in CompilationUnitResolver
 *								Bug 466279 - [hovering] IAE on hover when annotation-based null analysis is enabled
 *******************************************************************************/
package org.eclipse.jdt.core.dom;

import java.util.Map;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.jdt.core.compiler.CategorizedProblem;
import org.eclipse.jdt.internal.compiler.CompilationResult;
import org.eclipse.jdt.internal.compiler.Compiler;
import org.eclipse.jdt.internal.compiler.DefaultErrorHandlingPolicies;
import org.eclipse.jdt.internal.compiler.ICompilerRequestor;
import org.eclipse.jdt.internal.compiler.IErrorHandlingPolicy;
import org.eclipse.jdt.internal.compiler.IProblemFactory;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.eclipse.jdt.internal.compiler.env.AccessRestriction;
import org.eclipse.jdt.internal.compiler.env.INameEnvironment;
import org.eclipse.jdt.internal.compiler.impl.CompilerOptions;
import org.eclipse.jdt.internal.compiler.lookup.ExtraCompilerModifiers;
import org.eclipse.jdt.internal.compiler.parser.Parser;
import org.eclipse.jdt.internal.compiler.problem.AbortCompilation;
import org.eclipse.jdt.internal.compiler.problem.DefaultProblemFactory;
import org.eclipse.jdt.internal.compiler.problem.ProblemReporter;
import org.eclipse.jdt.internal.compiler.util.HashtableOfObject;
import org.eclipse.jdt.internal.compiler.util.Messages;
import org.eclipse.jdt.internal.core.util.CommentRecorderParser;

@SuppressWarnings({ "rawtypes", "unchecked" })
class CompilationUnitResolver extends Compiler {
	public static final int RESOLVE_BINDING = 0x1;
	public static final int PARTIAL = 0x2;
	public static final int STATEMENT_RECOVERY = 0x4;
	public static final int IGNORE_METHOD_BODIES = 0x8;
	public static final int BINDING_RECOVERY = 0x10;
	public static final int INCLUDE_RUNNING_VM_BOOTCLASSPATH = 0x20;

	/* A list of int */
	static class IntArrayList {
		public int[] list = new int[5];
		public int length = 0;
		public void add(int i) {
			if (this.list.length == this.length) {
				System.arraycopy(this.list, 0, this.list = new int[this.length*2], 0, this.length);
			}
				this.list[this.length++] = i;
			}
		}

	/*
	 * The sources that were requested.
	 * Map from file name (char[]) to org.eclipse.jdt.internal.compiler.env.ICompilationUnit.
	 */
	HashtableOfObject requestedSources;

	boolean hasCompilationAborted;
	CategorizedProblem abortProblem;

	private IProgressMonitor monitor;
	
	/**
	 * Set to <code>true</code> if the receiver was initialized using a java project name environment
	 */
	boolean fromJavaProject;

	/**
	 * Answer a new CompilationUnitVisitor using the given name environment and compiler options.
	 * The environment and options will be in effect for the lifetime of the compiler.
	 * When the compiler is run, compilation results are sent to the given requestor.
	 *
	 *  @param environment org.eclipse.jdt.internal.compiler.api.env.INameEnvironment
	 *      Environment used by the compiler in order to resolve type and package
	 *      names. The name environment implements the actual connection of the compiler
	 *      to the outside world (for example, in batch mode the name environment is performing
	 *      pure file accesses, reuse previous build state or connection to repositories).
	 *      Note: the name environment is responsible for implementing the actual classpath
	 *            rules.
	 *
	 *  @param policy org.eclipse.jdt.internal.compiler.api.problem.IErrorHandlingPolicy
	 *      Configurable part for problem handling, allowing the compiler client to
	 *      specify the rules for handling problems (stop on first error or accumulate
	 *      them all) and at the same time perform some actions such as opening a dialog
	 *      in UI when compiling interactively.
	 *      @see org.eclipse.jdt.internal.compiler.DefaultErrorHandlingPolicies
	 *
	 *	@param compilerOptions The compiler options to use for the resolution.
	 *
	 *  @param requestor org.eclipse.jdt.internal.compiler.api.ICompilerRequestor
	 *      Component which will receive and persist all compilation results and is intended
	 *      to consume them as they are produced. Typically, in a batch compiler, it is
	 *      responsible for writing out the actual .class files to the file system.
	 *      @see org.eclipse.jdt.internal.compiler.CompilationResult
	 *
	 *  @param problemFactory org.eclipse.jdt.internal.compiler.api.problem.IProblemFactory
	 *      Factory used inside the compiler to create problem descriptors. It allows the
	 *      compiler client to supply its own representation of compilation problems in
	 *      order to avoid object conversions. Note that the factory is not supposed
	 *      to accumulate the created problems, the compiler will gather them all and hand
	 *      them back as part of the compilation unit result.
	 */
	public CompilationUnitResolver(
		INameEnvironment environment,
		IErrorHandlingPolicy policy,
		CompilerOptions compilerOptions,
		ICompilerRequestor requestor,
		IProblemFactory problemFactory,
		IProgressMonitor monitor,
		boolean fromJavaProject) {

		super(environment, policy, compilerOptions, requestor, problemFactory);
		this.hasCompilationAborted = false;
		this.monitor =monitor;
		this.fromJavaProject = fromJavaProject;
	}
	
	public synchronized void accept(org.eclipse.jdt.internal.compiler.env.ICompilationUnit sourceUnit, AccessRestriction accessRestriction) {
		super.accept(sourceUnit, accessRestriction);
	}

	/**
	 * Add the initial set of compilation units into the loop
	 *  ->  build compilation unit declarations, their bindings and record their results.
	 */
	protected void beginToCompile(org.eclipse.jdt.internal.compiler.env.ICompilationUnit[] sourceUnits, String[] bindingKeys) {
		int sourceLength = sourceUnits.length;
		int keyLength = bindingKeys.length;
		int maxUnits = sourceLength + keyLength;
		this.totalUnits = 0;
		this.unitsToProcess = new CompilationUnitDeclaration[maxUnits];
		int index = 0;

		// walks the source units
		this.requestedSources = new HashtableOfObject();
		for (int i = 0; i < sourceLength; i++) {
			org.eclipse.jdt.internal.compiler.env.ICompilationUnit sourceUnit = sourceUnits[i];
			CompilationUnitDeclaration parsedUnit;
			CompilationResult unitResult =
				new CompilationResult(sourceUnit, index++, maxUnits, this.options.maxProblemsPerUnit);
			try {
				if (this.options.verbose) {
					this.out.println(
						Messages.bind(Messages.compilation_request,
						new String[] {
							String.valueOf(index++ + 1),
							String.valueOf(maxUnits),
							new String(sourceUnit.getFileName())
						}));
				}
				// diet parsing for large collection of units
				if (this.totalUnits < this.parseThreshold) {
					parsedUnit = this.parser.parse(sourceUnit, unitResult);
				} else {
					parsedUnit = this.parser.dietParse(sourceUnit, unitResult);
				}
				// initial type binding creation
				this.lookupEnvironment.buildTypeBindings(parsedUnit, null /*no access restriction*/);
				addCompilationUnit(sourceUnit, parsedUnit);
				this.requestedSources.put(unitResult.getFileName(), sourceUnit);
				worked(1);
			} finally {
				sourceUnits[i] = null; // no longer hold onto the unit
			}
		}

		// binding resolution
		this.lookupEnvironment.completeTypeBindings();
	}


	protected static CompilerOptions getCompilerOptions(Map options, boolean statementsRecovery) {
		CompilerOptions compilerOptions = new CompilerOptions(options);
		compilerOptions.performMethodsFullRecovery = statementsRecovery;
		compilerOptions.performStatementsRecovery = statementsRecovery;
		compilerOptions.parseLiteralExpressionsAsConstants = false;
		compilerOptions.storeAnnotations = true /*store annotations in the bindings*/;
		compilerOptions.ignoreSourceFolderWarningOption = true;
		return compilerOptions;
	}
	/*
	 *  Low-level API performing the actual compilation
	 */
	protected static IErrorHandlingPolicy getHandlingPolicy() {

		// passes the initial set of files to the batch oracle (to avoid finding more than once the same units when case insensitive match)
		return new IErrorHandlingPolicy() {
			public boolean stopOnFirstError() {
				return false;
			}
			public boolean proceedOnErrors() {
				return false; // stop if there are some errors
			}
			public boolean ignoreAllErrors() {
				return false;
			}
		};
	}

	/*
	 * Answer the component to which will be handed back compilation results from the compiler
	 */
	protected static ICompilerRequestor getRequestor() {
		return new ICompilerRequestor() {
			public void acceptResult(CompilationResult compilationResult) {
				// do nothing
			}
		};
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jdt.internal.compiler.Compiler#initializeParser()
	 */
	public void initializeParser() {
		this.parser = new CommentRecorderParser(this.problemReporter, false);
	}
	
	/*
	 * Compiler crash recovery in case of unexpected runtime exceptions
	 */
	protected void handleInternalException(
			Throwable internalException,
			CompilationUnitDeclaration unit,
			CompilationResult result) {
		super.handleInternalException(internalException, unit, result);
		if (unit != null) {
			removeUnresolvedBindings(unit);
		}
	}

	/*
	 * Compiler recovery in case of internal AbortCompilation event
	 */
	protected void handleInternalException(
			AbortCompilation abortException,
			CompilationUnitDeclaration unit) {
		super.handleInternalException(abortException, unit);
		if (unit != null) {
			removeUnresolvedBindings(unit);
		}
		this.hasCompilationAborted = true;
		this.abortProblem = abortException.problem;
	}
	
	public static CompilationUnitDeclaration parse(
			org.eclipse.jdt.internal.compiler.env.ICompilationUnit sourceUnit,
			Map settings) {
		if (sourceUnit == null) {
			throw new IllegalStateException();
		}
		CompilerOptions compilerOptions = new CompilerOptions(settings);
		boolean statementsRecovery = false;
		compilerOptions.performMethodsFullRecovery = statementsRecovery;
		compilerOptions.performStatementsRecovery = statementsRecovery;
		compilerOptions.ignoreMethodBodies = false;
		Parser parser = new CommentRecorderParser(
			new ProblemReporter(
					DefaultErrorHandlingPolicies.proceedWithAllProblems(),
					compilerOptions,
					new DefaultProblemFactory()),
			false);
		CompilationResult compilationResult = new CompilationResult(sourceUnit, 0, 0, compilerOptions.maxProblemsPerUnit);
		CompilationUnitDeclaration compilationUnitDeclaration = parser.dietParse(sourceUnit, compilationResult);

		if (compilationUnitDeclaration.ignoreMethodBodies) {
			compilationUnitDeclaration.ignoreFurtherInvestigation = true;
			// if initial diet parse did not work, no need to dig into method bodies.
			return compilationUnitDeclaration;
		}
				//fill the methods bodies in order for the code to be generated
				//real parse of the method....			
				org.eclipse.jdt.internal.compiler.ast.TypeDeclaration[] types = compilationUnitDeclaration.types;
				if (types != null) {
					for (int j = 0, typeLength = types.length; j < typeLength; j++) {
						types[j].parseMethods(parser, compilationUnitDeclaration);
					}
				}
		
		return compilationUnitDeclaration;
  }

	/*
	 * When unit result is about to be accepted, removed back pointers
	 * to unresolved bindings
	 */
	public void removeUnresolvedBindings(CompilationUnitDeclaration compilationUnitDeclaration) {
		final org.eclipse.jdt.internal.compiler.ast.TypeDeclaration[] types = compilationUnitDeclaration.types;
		if (types != null) {
			for (int i = 0, max = types.length; i < max; i++) {
				removeUnresolvedBindings(types[i]);
			}
		}
	}
	private void removeUnresolvedBindings(org.eclipse.jdt.internal.compiler.ast.TypeDeclaration type) {
		final org.eclipse.jdt.internal.compiler.ast.TypeDeclaration[] memberTypes = type.memberTypes;
		if (memberTypes != null) {
			for (int i = 0, max = memberTypes.length; i < max; i++){
				removeUnresolvedBindings(memberTypes[i]);
			}
		}
		if (type.binding != null && (type.binding.modifiers & ExtraCompilerModifiers.AccUnresolved) != 0) {
			type.binding = null;
		}

		final org.eclipse.jdt.internal.compiler.ast.FieldDeclaration[] fields = type.fields;
		if (fields != null) {
			for (int i = 0, max = fields.length; i < max; i++){
				if (fields[i].binding != null && (fields[i].binding.modifiers & ExtraCompilerModifiers.AccUnresolved) != 0) {
					fields[i].binding = null;
				}
			}
		}

		final AbstractMethodDeclaration[] methods = type.methods;
		if (methods != null) {
			for (int i = 0, max = methods.length; i < max; i++){
				if (methods[i].binding !=  null && (methods[i].binding.modifiers & ExtraCompilerModifiers.AccUnresolved) != 0) {
					methods[i].binding = null;
				}
			}
		}
	}

	private void worked(int work) {
		if (this.monitor != null) {
			if (this.monitor.isCanceled())
				throw new OperationCanceledException();
			this.monitor.worked(work);
		}
	}


  public static CompilationUnit convert(
    CompilationUnitDeclaration compilationUnitDeclaration,
    char[] source,
    int apiLevel,
    Map options,
    IProgressMonitor monitor) {
    AST ast = AST.newAST(apiLevel);
    ast.setDefaultNodeFlag(ASTNode.ORIGINAL);
    CompilationUnit compilationUnit = null;
    ASTConverter converter = new ASTConverter(options, monitor);
    converter.setAST(ast);
    compilationUnit = converter.convert(compilationUnitDeclaration, source);
    compilationUnit.setLineEndTable(compilationUnitDeclaration.compilationResult.getLineSeparatorPositions());
    ast.setDefaultNodeFlag(0);
    ast.setOriginalModificationCount(ast.modificationCount());
    return compilationUnit;
	}
}
