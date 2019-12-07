/*******************************************************************************
 * Copyright (c) 2004, 2015 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Stephan Herrmann - Contribution for
 *								Bug 458577 - IClassFile.getWorkingCopy() may lead to NPE in BecomeWorkingCopyOperation
 *******************************************************************************/
package org.eclipse.jdt.core.dom;

import java.util.HashMap;
import java.util.Map;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.compiler.CategorizedProblem;
import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.eclipse.jdt.internal.compiler.ast.ConstructorDeclaration;
import org.eclipse.jdt.internal.compiler.ast.ExplicitConstructorCall;
import org.eclipse.jdt.internal.compiler.parser.RecoveryScanner;
import org.eclipse.jdt.internal.compiler.parser.RecoveryScannerData;
import org.eclipse.jdt.internal.compiler.parser.Scanner;
import org.eclipse.jdt.internal.core.BasicCompilationUnit;
import org.eclipse.jdt.internal.core.util.CodeSnippetParsingUtil;
import org.eclipse.jdt.internal.core.util.RecordedParsingInformation;

/**
 * A Java language parser for creating abstract syntax trees (ASTs).
 * <p>
 * Example: Create basic AST from source string
 * <pre>
 * char[] source = ...;
 * ASTParser parser = ASTParser.newParser(AST.JLS3);  // handles JDK 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6
 * parser.setSource(source);
 * // In order to parse 1.5 code, some compiler options need to be set to 1.5
 * Map options = JavaCore.getOptions();
 * JavaCore.setComplianceOptions(JavaCore.VERSION_1_5, options);
 * parser.setCompilerOptions(options);
 * CompilationUnit result = (CompilationUnit) parser.createAST(null);
 * </pre>
 * Once a configured parser instance has been used to create an AST,
 * the settings are automatically reset to their defaults,
 * ready for the parser instance to be reused.
 * </p>
 * <p>
 * There are a number of configurable features:
 * <ul>
 * <li>Source string from {@link #setSource(char[]) char[]},
 * {@link #setSource(ICompilationUnit) ICompilationUnit},
 * or {@link #setSource(IClassFile) IClassFile}, and limited
 * to a specified {@linkplain #setSourceRange(int,int) subrange}.</li>
 * <li>Whether {@linkplain #setResolveBindings(boolean) bindings} will be created.</li>
 * <li>Which {@linkplain #setWorkingCopyOwner(WorkingCopyOwner)
 * working copy owner} to use when resolving bindings.</li>
 * <li>A hypothetical {@linkplain #setUnitName(String) compilation unit file name}
 * and {@linkplain #setProject(IJavaProject) Java project}
 * for locating a raw source string in the Java model (when
 * resolving bindings)</li>
 * <li>Which {@linkplain #setCompilerOptions(Map) compiler options}
 * to use. This is especially important to use if the parsing/scanning of the source code requires a
 * different version than the default of the workspace. For example, the workspace defaults are 1.4 and
 * you want to create an AST for a source code that is using 1.5 constructs.</li>
 * <li>Whether to parse just {@linkplain #setKind(int) an expression, statements,
 * or body declarations} rather than an entire compilation unit.</li>
 * <li>Whether to return a {@linkplain #setFocalPosition(int) abridged AST}
 * focused on the declaration containing a given source position.</li>
 * </ul>
 * </p>
 *
 * @since 3.0
 * @noinstantiate This class is not intended to be instantiated by clients.
 */
@SuppressWarnings({"rawtypes"})
public class ASTParser {

	/**
	 * Kind constant used to request that the source be parsed
     * as a single expression.
	 */
	public static final int K_EXPRESSION = 0x01;

	/**
	 * Kind constant used to request that the source be parsed
     * as a sequence of statements.
	 */
	public static final int K_STATEMENTS = 0x02;

	/**
	 * Kind constant used to request that the source be parsed
	 * as a sequence of class body declarations.
	 */
	public static final int K_CLASS_BODY_DECLARATIONS = 0x04;

	/**
	 * Kind constant used to request that the source be parsed
	 * as a compilation unit.
	 */
	public static final int K_COMPILATION_UNIT = 0x08;

	/**
	 * Creates a new object for creating a Java abstract syntax tree
     * (AST) following the specified set of API rules.
     *
 	 * @param level the API level; one of the <code>.JLS*</code> level constants
     * declared on {@link AST}
	 * @return new ASTParser instance
	 */
	public static ASTParser newParser(int level) {
		return new ASTParser(level);
	}

	/**
	 * Level of AST API desired.
	 */
	private final int apiLevel;

	/**
	 * Kind of parse requested. Defaults to an entire compilation unit.
	 */
	private int astKind;

	/**
	 * Compiler options. Defaults to JavaCore.getOptions().
	 */
	private Map<String, String> compilerOptions;
	
    /**
	 * The focal point for a partial AST request.
     * Only used when <code>partial</code> is <code>true</code>.
     */
	private int focalPointPosition;

    /**
     * Source string.
     */
    private char[] rawSource = null;

    /**
     * Character-based offset into the source string where parsing is to
     * begin. Defaults to 0.
     */
	private int sourceOffset = 0;

    /**
     * Character-based length limit, or -1 if unlimited.
     * All characters in the source string between <code>offset</code>
     * and <code>offset+length-1</code> inclusive are parsed. Defaults to -1,
     * which means the rest of the source string.
     */
	private int sourceLength = -1;

    /**
	 * Name of the compilation unit for resolving bindings, or
	 * <code>null</code> if none. Defaults to none.
     */
	private String unitName = null;
	
	/**
	 * Classpath entries to use to resolve bindings when no java project are available.
	 */
	private String[] classpaths;

	/**
	 * Sourcepath entries to use to resolve bindings when no java project are available.
	 */
	private String[] sourcepaths;
	
	/**
	 * Encoding of the given sourcepaths entries.
	 */
	private String[] sourcepathsEncodings;
	
	/**
	 * Bits used to set the different values from CompilationUnitResolver values.
	 */
	private int bits;

	/**
	 * Creates a new AST parser for the given API level.
	 * <p>
	 * N.B. This constructor is package-private.
	 * </p>
	 *
	 * @param level the API level; one of the <code>JLS*</code> level constants
	 * declared on {@link AST}
	 */
	ASTParser(int level) {
		switch(level) {
			case AST.JLS2_INTERNAL:
			case AST.JLS3_INTERNAL:
			case AST.JLS4_INTERNAL:
			case AST.JLS8:
				break;
			default:
				throw new IllegalArgumentException();
		}
		this.apiLevel = level;
		initializeDefaults();
	}
	/**
	 * Sets all the setting to their default values.
	 */
	private void initializeDefaults() {
		this.astKind = K_COMPILATION_UNIT;
		this.rawSource = null;
		this.bits = 0;
		this.sourceLength = -1;
		this.sourceOffset = 0;
		this.unitName = null;
		this.classpaths = null;
		this.sourcepaths = null;
		this.sourcepathsEncodings = null;
		Map<String, String> options = JavaCore.getOptions();
		options.remove(JavaCore.COMPILER_TASK_TAGS); // no need to parse task tags
		this.compilerOptions = options;
	}
	/**
	 * Sets the compiler options to be used when parsing.
	 * <p>
	 * Note that {@link #setSource(IClassFile)},
	 * {@link #setSource(ICompilationUnit)},
	 * and {@link #setProject(IJavaProject)} reset the compiler options
	 * based on the Java project. In other cases, compiler options default
	 * to {@link JavaCore#getOptions()}. In either case, and especially
	 * in the latter, the caller should carefully weight the consequences of
	 * allowing compiler options to be defaulted as opposed to being
	 * explicitly specified for the {@link ASTParser} instance.
	 * For instance, there is a compiler option called "Source Compatibility Mode"
	 * which determines which JDK level the source code is expected to meet.
	 * If you specify "1.4", then "assert" is treated as a keyword and disallowed
	 * as an identifier; if you specify "1.3", then "assert" is allowed as an
	 * identifier. So this particular setting has a major bearing on what is
	 * considered syntactically legal. By explicitly specifying the setting,
	 * the client control exactly how the parser works. On the other hand,
	 * allowing default settings means the parsing behaves like other JDT tools.
	 * </p>
	 *
	 * @param options the table of options (key type: <code>String</code>;
	 * value type: <code>String</code>), or <code>null</code>
	 * to set it back to the default
	 */
	public void setCompilerOptions(Map<String, String> options) {
		if (options == null) {
			options = JavaCore.getOptions();
		} else {
			// copy client's options so as to not do any side effect on them
			options = new HashMap<>(options);
		}
		options.remove(JavaCore.COMPILER_TASK_TAGS); // no need to parse task tags
		this.compilerOptions = options;
	}

	/**
	 * Sets the kind of constructs to be parsed from the source.
	 * Defaults to an entire compilation unit.
	 * <p>
	 * When the parse is successful the result returned includes the ASTs for the
	 * requested source:
	 * <ul>
	 * <li>{@link #K_COMPILATION_UNIT K_COMPILATION_UNIT}: The result node
	 * is a {@link CompilationUnit}.</li>
	 * <li>{@link #K_CLASS_BODY_DECLARATIONS K_CLASS_BODY_DECLARATIONS}: The result node
	 * is a {@link TypeDeclaration} whose
	 * {@link TypeDeclaration#bodyDeclarations() bodyDeclarations}
	 * are the new trees. Other aspects of the type declaration are unspecified.</li>
	 * <li>{@link #K_STATEMENTS K_STATEMENTS}: The result node is a
	 * {@link Block Block} whose {@link Block#statements() statements}
	 * are the new trees. Other aspects of the block are unspecified.</li>
	 * <li>{@link #K_EXPRESSION K_EXPRESSION}: The result node is a subclass of
	 * {@link Expression Expression}. Other aspects of the expression are unspecified.</li>
	 * </ul>
	 * The resulting AST node is rooted under (possibly contrived)
	 * {@link CompilationUnit CompilationUnit} node, to allow the
	 * client to retrieve the following pieces of information
	 * available there:
	 * <ul>
	 * <li>{@linkplain CompilationUnit#getLineNumber(int) Line number map}. Line
	 * numbers start at 1 and only cover the subrange scanned
	 * (<code>source[offset]</code> through <code>source[offset+length-1]</code>).</li>
	 * <li>{@linkplain CompilationUnit#getMessages() Compiler messages}
	 * and {@linkplain CompilationUnit#getProblems() detailed problem reports}.
	 * Character positions are relative to the start of
	 * <code>source</code>; line positions are for the subrange scanned.</li>
	 * <li>{@linkplain CompilationUnit#getCommentList() Comment list}
	 * for the subrange scanned.</li>
	 * </ul>
	 * The contrived nodes do not have source positions. Other aspects of the
	 * {@link CompilationUnit CompilationUnit} node are unspecified, including
	 * the exact arrangement of intervening nodes.
	 * </p>
	 * <p>
	 * Lexical or syntax errors detected while parsing can result in
	 * a result node being marked as {@link ASTNode#MALFORMED MALFORMED}.
	 * In more severe failure cases where the parser is unable to
	 * recognize the input, this method returns
	 * a {@link CompilationUnit CompilationUnit} node with at least the
	 * compiler messages.
	 * </p>
	 * <p>Each node in the subtree (other than the contrived nodes)
	 * carries source range(s) information relating back
	 * to positions in the given source (the given source itself
	 * is not remembered with the AST).
	 * The source range usually begins at the first character of the first token
	 * corresponding to the node; leading whitespace and comments are <b>not</b>
	 * included. The source range usually extends through the last character of
	 * the last token corresponding to the node; trailing whitespace and
	 * comments are <b>not</b> included. There are a handful of exceptions
	 * (including the various body declarations); the
	 * specification for these node type spells out the details.
	 * Source ranges nest properly: the source range for a child is always
	 * within the source range of its parent, and the source ranges of sibling
	 * nodes never overlap.
	 * </p>
	 * <p>
	 * Binding information is only computed when <code>kind</code> is
	 * {@link #K_COMPILATION_UNIT}.
	 * </p>
	 * 
	 * <p>This kind is not used when the AST is built using
	 * {@link #createASTs(ICompilationUnit[], String[], ASTRequestor, IProgressMonitor)}.</p>
	 * 
	 * @param kind the kind of construct to parse: one of
	 * {@link #K_COMPILATION_UNIT},
	 * {@link #K_CLASS_BODY_DECLARATIONS},
	 * {@link #K_EXPRESSION},
	 * {@link #K_STATEMENTS}
	 */
	public void setKind(int kind) {
	    if ((kind != K_COMPILATION_UNIT)
		    && (kind != K_CLASS_BODY_DECLARATIONS)
		    && (kind != K_EXPRESSION)
		    && (kind != K_STATEMENTS)) {
	    	throw new IllegalArgumentException();
	    }
		this.astKind = kind;
	}

	/**
	 * Sets the source code to be parsed.
	 *
	 * <p>This source is not used when the AST is built using 
	 * {@link #createASTs(ICompilationUnit[], String[], ASTRequestor, IProgressMonitor)}.</p>
	 *
	 * <p>If this method is used, the user needs to specify compiler options explicitly using
	 * {@link #setCompilerOptions(Map)} as 1.5 code will not be properly parsed without setting
	 * the appropriate values for the compiler options: {@link JavaCore#COMPILER_SOURCE},
	 * {@link JavaCore#COMPILER_CODEGEN_TARGET_PLATFORM}, and {@link JavaCore#COMPILER_COMPLIANCE}.</p>
	 * <p>Otherwise the default values for the compiler options will be used to parse the given source.</p>
	 *
	 * @param source the source string to be parsed,
	 * or <code>null</code> if none
	 * @see JavaCore#setComplianceOptions(String, Map)
	 */
	public void setSource(char[] source) {
		this.rawSource = source;;
	}

	/**
     * Sets the subrange of the source code to be parsed.
     * By default, the entire source string will be parsed
     * (<code>offset</code> 0 and <code>length</code> -1).
     *
	 * <p>This range is not used when the AST is built using 
	 * {@link #createASTs(ICompilationUnit[], String[], ASTRequestor, IProgressMonitor)}.</p>
     *
     * @param offset the index of the first character to parse
     * @param length the number of characters to parse, or -1 if
     * the remainder of the source string is to be parsed
     */
	public void setSourceRange(int offset, int length) {
		if (offset < 0 || length < -1) {
			throw new IllegalArgumentException();
		}
		this.sourceOffset = offset;
		this.sourceLength = length;
	}

	/**
	 * Sets the name of the compilation unit that would hypothetically contains the
	 * source string.
	 * 
	 *  <p>This is used in conjunction with {@link #setSource(char[])}
	 * and {@link #setProject(IJavaProject)} to locate the compilation unit relative to a Java project.
	 * Defaults to none (<code>null</code>).</p>
	 * <p>
	 * The name of the compilation unit must be supplied for resolving bindings.
	 * This name should be suffixed by a dot ('.') followed by one of the
	 * {@link JavaCore#getJavaLikeExtensions() Java-like extensions}
	 * and match the name of the main (public) class or interface declared in the source.</p>
	 *
	 * <p>This name must represent the full path of the unit inside the given project. For example, if the source
	 * declares a public class named "Foo" in a project "P" where the source folder is the project itself, the name
	 * of the compilation unit must be "/P/Foo.java".
	 * If the source declares a public class name "Bar" in a package "p1.p2" in a project "P" in a source folder "src",
	 * the name of the compilation unit must be "/P/src/p1/p2/Bar.java".</p>
	 *
	 * <p>This unit name is not used when the AST is built using 
	 * {@link #createASTs(ICompilationUnit[], String[], ASTRequestor, IProgressMonitor)}.</p>
	 *
	 * @param unitName the name of the compilation unit that would contain the source
	 *    string, or <code>null</code> if none
	 */
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	/**
	 * Creates an abstract syntax tree.
	 * <p>
	 * A successful call to this method returns all settings to their
	 * default values so the object is ready to be reused.
	 * </p>
	 *
	 * @param monitor the progress monitor used to report progress and request cancellation,
	 *   or <code>null</code> if none
	 * @return an AST node whose type depends on the kind of parse
	 *  requested, with a fallback to a <code>CompilationUnit</code>
	 *  in the case of severe parsing errors
	 * @exception IllegalStateException if the settings provided
	 * are insufficient, contradictory, or otherwise unsupported
	 */
	public ASTNode createAST(IProgressMonitor monitor) {
		ASTNode result = null;
		if (monitor != null) monitor.beginTask("", 1); //$NON-NLS-1$
		try {
			if (this.rawSource == null) {
				throw new IllegalStateException("source not specified"); //$NON-NLS-1$
			}
			result = internalCreateAST(monitor);
		} finally {
			// reset to defaults to allow reuse (and avoid leaking)
			initializeDefaults();
			if (monitor != null) monitor.done();
		}
		return result;
	}

	private ASTNode internalCreateAST(IProgressMonitor monitor) {
		switch(this.astKind) {
			case K_CLASS_BODY_DECLARATIONS :
			case K_EXPRESSION :
			case K_STATEMENTS :
				if (this.rawSource != null) {
					if (this.sourceOffset + this.sourceLength > this.rawSource.length) {
						throw new IllegalStateException();
					}
					return internalCreateASTForKind();
				}
				break;
			case K_COMPILATION_UNIT :
				CompilationUnitDeclaration compilationUnitDeclaration = null;
				try {
					org.eclipse.jdt.internal.compiler.env.ICompilationUnit sourceUnit = null;
					if (this.rawSource != null) {
						sourceUnit = new BasicCompilationUnit(this.rawSource, null, this.unitName == null ? "" : this.unitName); //$NON-NLS-1$
					} else {
						throw new IllegalStateException();
					}
						compilationUnitDeclaration = CompilationUnitResolver.parse(
								sourceUnit,
								this.compilerOptions);
					CompilationUnit result = CompilationUnitResolver.convert(
						compilationUnitDeclaration,
						sourceUnit.getContents(),
						this.apiLevel,
						this.compilerOptions,
						monitor);
					return result;
				} finally {
					if (compilationUnitDeclaration != null
							&& ((this.bits & CompilationUnitResolver.RESOLVE_BINDING) != 0)) {
						compilationUnitDeclaration.cleanUp();
					}
				}
		}
		throw new IllegalStateException();
	}

	/**
	 * Parses the given source between the bounds specified by the given offset (inclusive)
	 * and the given length and creates and returns a corresponding abstract syntax tree.
	 * <p>
	 * When the parse is successful the result returned includes the ASTs for the
	 * requested source:
	 * <ul>
	 * <li>{@link #K_CLASS_BODY_DECLARATIONS K_CLASS_BODY_DECLARATIONS}: The result node
	 * is a {@link TypeDeclaration TypeDeclaration} whose
	 * {@link TypeDeclaration#bodyDeclarations() bodyDeclarations}
	 * are the new trees. Other aspects of the type declaration are unspecified.</li>
	 * <li>{@link #K_STATEMENTS K_STATEMENTS}: The result node is a
	 * {@link Block Block} whose {@link Block#statements() statements}
	 * are the new trees. Other aspects of the block are unspecified.</li>
	 * <li>{@link #K_EXPRESSION K_EXPRESSION}: The result node is a subclass of
	 * {@link Expression Expression}. Other aspects of the expression are unspecified.</li>
	 * </ul>
	 * The resulting AST node is rooted under an contrived
	 * {@link CompilationUnit CompilationUnit} node, to allow the
	 * client to retrieve the following pieces of information
	 * available there:
	 * <ul>
	 * <li>{@linkplain CompilationUnit#getLineNumber(int) Line number map}. Line
	 * numbers start at 1 and only cover the subrange scanned
	 * (<code>source[offset]</code> through <code>source[offset+length-1]</code>).</li>
	 * <li>{@linkplain CompilationUnit#getMessages() Compiler messages}
	 * and {@linkplain CompilationUnit#getProblems() detailed problem reports}.
	 * Character positions are relative to the start of
	 * <code>source</code>; line positions are for the subrange scanned.</li>
	 * <li>{@linkplain CompilationUnit#getCommentList() Comment list}
	 * for the subrange scanned.</li>
	 * </ul>
	 * The contrived nodes do not have source positions. Other aspects of the
	 * {@link CompilationUnit CompilationUnit} node are unspecified, including
	 * the exact arrangment of intervening nodes.
	 * </p>
	 * <p>
	 * Lexical or syntax errors detected while parsing can result in
	 * a result node being marked as {@link ASTNode#MALFORMED MALFORMED}.
	 * In more severe failure cases where the parser is unable to
	 * recognize the input, this method returns
	 * a {@link CompilationUnit CompilationUnit} node with at least the
	 * compiler messages.
	 * </p>
	 * <p>Each node in the subtree (other than the contrived nodes)
	 * carries source range(s) information relating back
	 * to positions in the given source (the given source itself
	 * is not remembered with the AST).
	 * The source range usually begins at the first character of the first token
	 * corresponding to the node; leading whitespace and comments are <b>not</b>
	 * included. The source range usually extends through the last character of
	 * the last token corresponding to the node; trailing whitespace and
	 * comments are <b>not</b> included. There are a handful of exceptions
	 * (including the various body declarations); the
	 * specification for these node type spells out the details.
	 * Source ranges nest properly: the source range for a child is always
	 * within the source range of its parent, and the source ranges of sibling
	 * nodes never overlap.
	 * </p>
	 * <p>
	 * This method does not compute binding information; all <code>resolveBinding</code>
	 * methods applied to nodes of the resulting AST return <code>null</code>.
	 * </p>
	 *
	 * @return an AST node whose type depends on the kind of parse
	 *  requested, with a fallback to a <code>CompilationUnit</code>
	 *  in the case of severe parsing errors
	 * @see ASTNode#getStartPosition()
	 * @see ASTNode#getLength()
	 */
	private ASTNode internalCreateASTForKind() {
		final ASTConverter converter = new ASTConverter(this.compilerOptions, null);
		converter.compilationUnitSource = this.rawSource;
		converter.compilationUnitSourceLength = this.rawSource.length;
		converter.scanner.setSource(this.rawSource);

		AST ast = AST.newAST(this.apiLevel);
		ast.setDefaultNodeFlag(ASTNode.ORIGINAL);
		converter.setAST(ast);
		CodeSnippetParsingUtil codeSnippetParsingUtil = new CodeSnippetParsingUtil((this.bits & CompilationUnitResolver.IGNORE_METHOD_BODIES) != 0);
		CompilationUnit compilationUnit = ast.newCompilationUnit();
		if (this.sourceLength == -1) {
			this.sourceLength = this.rawSource.length;
		}
		switch(this.astKind) {
			case K_STATEMENTS :
				ConstructorDeclaration constructorDeclaration = codeSnippetParsingUtil.parseStatements(
						this.rawSource,
						this.sourceOffset,
						this.sourceLength,
						this.compilerOptions,
						true,
						(this.bits & CompilationUnitResolver.STATEMENT_RECOVERY) != 0);
				RecoveryScannerData data = constructorDeclaration.compilationResult.recoveryScannerData;
				if(data != null) {
					Scanner scanner = converter.scanner;
					converter.scanner = new RecoveryScanner(scanner, data.removeUnused());
					converter.docParser.scanner = converter.scanner;
					converter.scanner.setSource(scanner.source);
					
					compilationUnit.setStatementsRecoveryData(data);
				}
				RecordedParsingInformation recordedParsingInformation = codeSnippetParsingUtil.recordedParsingInformation;
				int[][] comments = recordedParsingInformation.commentPositions;
				if (comments != null) {
					converter.buildCommentsTable(compilationUnit, comments);
				}
				compilationUnit.setLineEndTable(recordedParsingInformation.lineEnds);
				Block block = ast.newBlock();
				block.setSourceRange(this.sourceOffset, this.sourceOffset + this.sourceLength);
				ExplicitConstructorCall constructorCall = constructorDeclaration.constructorCall;
				if (constructorCall != null && constructorCall.accessMode != org.eclipse.jdt.internal.compiler.ast.ExplicitConstructorCall.ImplicitSuper) {
					block.statements().add(converter.convert(constructorCall));
				}
				org.eclipse.jdt.internal.compiler.ast.Statement[] statements = constructorDeclaration.statements;
				if (statements != null) {
					int statementsLength = statements.length;
					for (int i = 0; i < statementsLength; i++) {
						if (statements[i] instanceof org.eclipse.jdt.internal.compiler.ast.LocalDeclaration) {
							converter.checkAndAddMultipleLocalDeclaration(statements, i, block.statements());
						} else {
							Statement statement = converter.convert(statements[i]);
							if (statement != null) {
								block.statements().add(statement);
							}
						}
					}
				}
				rootNodeToCompilationUnit(ast, compilationUnit, block, recordedParsingInformation, data);
				ast.setDefaultNodeFlag(0);
				ast.setOriginalModificationCount(ast.modificationCount());
				return block;
			case K_EXPRESSION :
				org.eclipse.jdt.internal.compiler.ast.Expression expression = codeSnippetParsingUtil.parseExpression(this.rawSource, this.sourceOffset, this.sourceLength, this.compilerOptions, true);
				recordedParsingInformation = codeSnippetParsingUtil.recordedParsingInformation;
				comments = recordedParsingInformation.commentPositions;
				if (comments != null) {
					converter.buildCommentsTable(compilationUnit, comments);
				}
				compilationUnit.setLineEndTable(recordedParsingInformation.lineEnds);
				if (expression != null) {
					Expression expression2 = converter.convert(expression);
					rootNodeToCompilationUnit(expression2.getAST(), compilationUnit, expression2, codeSnippetParsingUtil.recordedParsingInformation, null);
					ast.setDefaultNodeFlag(0);
					ast.setOriginalModificationCount(ast.modificationCount());
					return expression2;
				} else {
					CategorizedProblem[] problems = recordedParsingInformation.problems;
					if (problems != null) {
						compilationUnit.setProblems(problems);
					}
					ast.setDefaultNodeFlag(0);
					ast.setOriginalModificationCount(ast.modificationCount());
					return compilationUnit;
				}
			case K_CLASS_BODY_DECLARATIONS :
				final org.eclipse.jdt.internal.compiler.ast.ASTNode[] nodes =
					codeSnippetParsingUtil.parseClassBodyDeclarations(
							this.rawSource,
							this.sourceOffset,
							this.sourceLength,
							this.compilerOptions,
							true,
							(this.bits & CompilationUnitResolver.STATEMENT_RECOVERY) != 0);
				recordedParsingInformation = codeSnippetParsingUtil.recordedParsingInformation;
				comments = recordedParsingInformation.commentPositions;
				if (comments != null) {
					converter.buildCommentsTable(compilationUnit, comments);
				}
				compilationUnit.setLineEndTable(recordedParsingInformation.lineEnds);
				if (nodes != null) {
					// source has no syntax error or the statement recovery is enabled
					TypeDeclaration typeDeclaration = converter.convert(nodes);
					typeDeclaration.setSourceRange(this.sourceOffset, this.sourceOffset + this.sourceLength);
					rootNodeToCompilationUnit(typeDeclaration.getAST(), compilationUnit, typeDeclaration, codeSnippetParsingUtil.recordedParsingInformation, null);
					ast.setDefaultNodeFlag(0);
					ast.setOriginalModificationCount(ast.modificationCount());
					return typeDeclaration;
				} else {
					// source has syntax error and the statement recovery is disabled
					CategorizedProblem[] problems = recordedParsingInformation.problems;
					if (problems != null) {
						compilationUnit.setProblems(problems);
					}
					ast.setDefaultNodeFlag(0);
					ast.setOriginalModificationCount(ast.modificationCount());
					return compilationUnit;
				}
		}
		throw new IllegalStateException();
	}

	private void propagateErrors(ASTNode astNode, CategorizedProblem[] problems, RecoveryScannerData data) {
		astNode.accept(new ASTSyntaxErrorPropagator(problems));
		if (data != null) {
			astNode.accept(new ASTRecoveryPropagator(problems, data));
		}
	}

	private void rootNodeToCompilationUnit(AST ast, CompilationUnit compilationUnit, ASTNode node, RecordedParsingInformation recordedParsingInformation, RecoveryScannerData data) {
		final int problemsCount = recordedParsingInformation.problemsCount;
		switch(node.getNodeType()) {
			case ASTNode.BLOCK :
				{
					Block block = (Block) node;
					if (problemsCount != 0) {
						// propagate and record problems
						final CategorizedProblem[] problems = recordedParsingInformation.problems;
						propagateErrors(block, problems, data);
						compilationUnit.setProblems(problems);
					}
					TypeDeclaration typeDeclaration = ast.newTypeDeclaration();
					Initializer initializer = ast.newInitializer();
					initializer.setBody(block);
					typeDeclaration.bodyDeclarations().add(initializer);
					compilationUnit.types().add(typeDeclaration);
				}
				break;
			case ASTNode.TYPE_DECLARATION :
				{
					TypeDeclaration typeDeclaration = (TypeDeclaration) node;
					if (problemsCount != 0) {
						// propagate and record problems
						final CategorizedProblem[] problems = recordedParsingInformation.problems;
						propagateErrors(typeDeclaration, problems, data);
						compilationUnit.setProblems(problems);
					}
					compilationUnit.types().add(typeDeclaration);
				}
				break;
			default :
				if (node instanceof Expression) {
					Expression expression = (Expression) node;
					if (problemsCount != 0) {
						// propagate and record problems
						final CategorizedProblem[] problems = recordedParsingInformation.problems;
						propagateErrors(expression, problems, data);
						compilationUnit.setProblems(problems);
					}
					ExpressionStatement expressionStatement = ast.newExpressionStatement(expression);
					Block block = ast.newBlock();
					block.statements().add(expressionStatement);
					Initializer initializer = ast.newInitializer();
					initializer.setBody(block);
					TypeDeclaration typeDeclaration = ast.newTypeDeclaration();
					typeDeclaration.bodyDeclarations().add(initializer);
					compilationUnit.types().add(typeDeclaration);
				}
		}
	}
}
