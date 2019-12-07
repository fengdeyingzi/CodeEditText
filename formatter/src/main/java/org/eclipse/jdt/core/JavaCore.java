/*******************************************************************************
 * Copyright (c) 2000, 2016 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     IBM Corporation - added the following constants:
 *                                 COMPILER_PB_DEPRECATION_IN_DEPRECATED_CODE
 *                                 COMPILER_PB_STATIC_ACCESS_RECEIVER
 *                                 COMPILER_TASK_TAGS
 *                                 CORE_CIRCULAR_CLASSPATH
 *                                 CORE_INCOMPLETE_CLASSPATH
 *     IBM Corporation - added run(IWorkspaceRunnable, IProgressMonitor)
 *     IBM Corporation - added exclusion patterns to source classpath entries
 *     IBM Corporation - added specific output location to source classpath entries
 *     IBM Corporation - added the following constants:
 *                                 CORE_JAVA_BUILD_CLEAN_OUTPUT_FOLDER
 *                                 CORE_JAVA_BUILD_RECREATE_MODIFIED_CLASS_FILES_IN_OUTPUT_FOLDER
 *                                 CLEAN
 *     IBM Corporation - added getClasspathContainerInitializer(String)
 *     IBM Corporation - added the following constants:
 *                                 CODEASSIST_ARGUMENT_PREFIXES
 *                                 CODEASSIST_ARGUMENT_SUFFIXES
 *                                 CODEASSIST_FIELD_PREFIXES
 *                                 CODEASSIST_FIELD_SUFFIXES
 *                                 CODEASSIST_LOCAL_PREFIXES
 *                                 CODEASSIST_LOCAL_SUFFIXES
 *                                 CODEASSIST_STATIC_FIELD_PREFIXES
 *                                 CODEASSIST_STATIC_FIELD_SUFFIXES
 *                                 COMPILER_PB_CHAR_ARRAY_IN_STRING_CONCATENATION
 *     IBM Corporation - added the following constants:
 *                                 COMPILER_PB_LOCAL_VARIABLE_HIDING
 *                                 COMPILER_PB_SPECIAL_PARAMETER_HIDING_FIELD
 *                                 COMPILER_PB_FIELD_HIDING
 *                                 COMPILER_PB_POSSIBLE_ACCIDENTAL_BOOLEAN_ASSIGNMENT
 *                                 CORE_INCOMPATIBLE_JDK_LEVEL
 *                                 VERSION_1_5
 *                                 COMPILER_PB_EMPTY_STATEMENT
 *     IBM Corporation - added the following constants:
 *                                 COMPILER_PB_INDIRECT_STATIC_ACCESS
 *                                 COMPILER_PB_BOOLEAN_METHOD_THROWING_EXCEPTION
 *                                 COMPILER_PB_UNNECESSARY_CAST
 *     IBM Corporation - added the following constants:
 *                                 COMPILER_PB_INVALID_JAVADOC
 *                                 COMPILER_PB_INVALID_JAVADOC_TAGS
 *                                 COMPILER_PB_INVALID_JAVADOC_TAGS_VISIBILITY
 *                                 COMPILER_PB_MISSING_JAVADOC_TAGS
 *                                 COMPILER_PB_MISSING_JAVADOC_TAGS_VISIBILITY
 *                                 COMPILER_PB_MISSING_JAVADOC_TAGS_OVERRIDING
 *                                 COMPILER_PB_MISSING_JAVADOC_COMMENTS
 *                                 COMPILER_PB_MISSING_JAVADOC_COMMENTS_VISIBILITY
 *                                 COMPILER_PB_MISSING_JAVADOC_COMMENTS_OVERRIDING
 *                                 COMPILER_PB_DEPRECATION_WHEN_OVERRIDING_DEPRECATED_METHOD
 *                                 COMPILER_PB_UNUSED_DECLARED_THROWN_EXCEPTION_WHEN_OVERRIDING
 *     IBM Corporation - added the following constants:
 *                                 TIMEOUT_FOR_PARAMETER_NAME_FROM_ATTACHED_JAVADOC
 *     IBM Corporation - added the following constants:
 *                                 COMPILER_PB_FALLTHROUGH_CASE
 *                                 COMPILER_PB_PARAMETER_ASSIGNMENT
 *                                 COMPILER_PB_NULL_REFERENCE
 *     IBM Corporation - added the following constants:
 *                                 CODEASSIST_DEPRECATION_CHECK
 *     IBM Corporation - added the following constants:
 *                                 COMPILER_PB_POTENTIAL_NULL_REFERENCE
 *                                 COMPILER_PB_REDUNDANT_NULL_CHECK
 *     IBM Corporation - added the following constants:
 *                                 COMPILER_PB_UNUSED_PARAMETER_INCLUDE_DOC_COMMENT_REFERENCE
 *     IBM Corporation - added the following constants:
 *                                 COMPILER_PB_UNUSED_DECLARED_THROWN_EXCEPTION_INCLUDE_DOC_COMMENT_REFERENCE
 *     IBM Corporation - added the following constants:
 *                                 COMPILER_PB_MISSING_JAVADOC_TAG_DESCRIPTION
 *								   COMPILER_PB_MISSING_JAVADOC_TAG_DESCRIPTION_NO_TAG
 *								   COMPILER_PB_MISSING_JAVADOC_TAG_DESCRIPTION_RETURN_TAG
 *								   COMPILER_PB_MISSING_JAVADOC_TAG_DESCRIPTION_ALL_TAGS
 *     IBM Corporation - added the following constants:
 *                                 COMPILER_PB_REDUNDANT_SUPERINTERFACE
 *     IBM Corporation - added the following constant:
 *                                 COMPILER_PB_UNUSED_DECLARED_THROWN_EXCEPTION_EXEMPT_EXCEPTION_AND_THROWABLE
 *     IBM Corporation - added getOptionForConfigurableSeverity(int)
 *     Benjamin Muskalla - added COMPILER_PB_MISSING_SYNCHRONIZED_ON_INHERITED_METHOD
 *     Stephan Herrmann  - added COMPILER_PB_UNUSED_OBJECT_ALLOCATION
 *     Stephan Herrmann  - added COMPILER_PB_SUPPRESS_OPTIONAL_ERRORS
 *     Stephan Herrmann  - added the following constants:
 *     								COMPILER_PB_UNCLOSED_CLOSEABLE,
 *     								COMPILER_PB_POTENTIALLY_UNCLOSED_CLOSEABLE
 *     								COMPILER_PB_EXPLICITLY_CLOSED_AUTOCLOSEABLE
 *     								COMPILER_ANNOTATION_NULL_ANALYSIS
 *     								COMPILER_NULLABLE_ANNOTATION_NAME
 *     								COMPILER_NONNULL_ANNOTATION_NAME
 *     								COMPILER_PB_NULL_SPECIFICATION_VIOLATION
 *     								COMPILER_PB_POTENTIAL_NULL_SPECIFICATION_VIOLATION
 *     								COMPILER_PB_NULL_SPECIFICATION_INSUFFICIENT_INFO
 *									COMPILER_PB_MISSING_ENUM_CASE_DESPITE_DEFAULT
 *									COMPILER_PB_SWITCH_MISSING_DEFAULT_CASE
 *									COMPILER_INHERIT_NULL_ANNOTATIONS
 *									COMPILER_PB_NONNULL_PARAMETER_ANNOTATION_DROPPED
 *									COMPILER_PB_SYNTACTIC_NULL_ANALYSIS_FOR_FIELDS
 *     Jesper S Moller   - Contributions for bug 381345 : [1.8] Take care of the Java 8 major version
 *                       - added the following constants:
 *									COMPILER_CODEGEN_METHOD_PARAMETERS_ATTR
 *     Harry Terkelsen (het@google.com) - Bug 449262 - Allow the use of third-party Java formatters
 *     Gábor Kövesdán - Contribution for Bug 350000 - [content assist] Include non-prefix matches in auto-complete suggestions
 *     
 *******************************************************************************/

package org.eclipse.jdt.core;

import java.util.HashMap;
import java.util.Map;
import org.eclipse.jdt.internal.compiler.classfmt.ClassFileConstants;
import org.eclipse.jdt.internal.compiler.impl.CompilerOptions;
import org.eclipse.jdt.internal.compiler.problem.ProblemReporter;

/**
 * The plug-in runtime class for the Java model plug-in containing the core
 * (UI-free) support for Java projects.
 * <p>
 * Like all plug-in runtime classes (subclasses of <code>Plugin</code>), this
 * class is automatically instantiated by the platform when the plug-in gets
 * activated. Clients must not attempt to instantiate plug-in runtime classes
 * directly.
 * </p>
 * <p>
 * The single instance of this class can be accessed from any plug-in declaring
 * the Java model plug-in as a prerequisite via
 * <code>JavaCore.getJavaCore()</code>. The Java model plug-in will be activated
 * automatically if not already active.
 * </p>
 * @noinstantiate This class is not intended to be instantiated by clients.
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public final class JavaCore {
	/**
	 * The plug-in identifier of the Java core support
	 * (value <code>"org.eclipse.jdt.core"</code>).
	 */
	public static final String PLUGIN_ID = "org.eclipse.jdt.core" ; //$NON-NLS-1$

	/**
	 * The identifier for the Java builder
	 * (value <code>"org.eclipse.jdt.core.javabuilder"</code>).
	 */
	public static final String BUILDER_ID = PLUGIN_ID + ".javabuilder" ; //$NON-NLS-1$

	/**
	 * The identifier for the Java model
	 * (value <code>"org.eclipse.jdt.core.javamodel"</code>).
	 */
	public static final String MODEL_ID = PLUGIN_ID + ".javamodel" ; //$NON-NLS-1$

	/**
	 * The identifier for the Java nature
	 * (value <code>"org.eclipse.jdt.core.javanature"</code>).
	 * The presence of this nature on a project indicates that it is
	 * Java-capable.
	 *
	 * @see org.eclipse.core.resources.IProject#hasNature(java.lang.String)
	 */
	public static final String NATURE_ID = PLUGIN_ID + ".javanature" ; //$NON-NLS-1$

	/**
	 * Name of the handle id attribute in a Java marker.
	 */
	protected static final String ATT_HANDLE_ID =
		"org.eclipse.jdt.internal.core.JavaModelManager.handleId" ; //$NON-NLS-1$

	/**
	 * Name of the User Library Container id.
	 * @since 3.0
	 */
	public static final String USER_LIBRARY_CONTAINER_ID= "org.eclipse.jdt.USER_LIBRARY"; //$NON-NLS-1$

	// Begin configurable option IDs {

	/**
	 * Compiler option ID: Generating Local Variable Debug Attribute.
	 * <p>When generated, this attribute will enable local variable names
	 *    to be displayed in debugger, only in place where variables are
	 *    definitely assigned (.class file is then bigger).</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.debug.localVariable"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "generate", "do not generate" }</code></dd>
	 * <dt>Default:</dt><dd><code>"generate"</code></dd>
	 * </dl>
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_LOCAL_VARIABLE_ATTR = PLUGIN_ID + ".compiler.debug.localVariable"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Generating Line Number Debug Attribute.
	 * <p>When generated, this attribute will enable source code highlighting in debugger
	 *    (.class file is then bigger).</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.debug.lineNumber"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "generate", "do not generate" }</code></dd>
	 * <dt>Default:</dt><dd><code>"generate"</code></dd>
	 * </dl>
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_LINE_NUMBER_ATTR = PLUGIN_ID + ".compiler.debug.lineNumber"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Generating Source Debug Attribute.
	 * <p>When generated, this attribute will enable the debugger to present the
	 *    corresponding source code.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.debug.sourceFile"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "generate", "do not generate" }</code></dd>
	 * <dt>Default:</dt><dd><code>"generate"</code></dd>
	 * </dl>
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_SOURCE_FILE_ATTR = PLUGIN_ID + ".compiler.debug.sourceFile"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Preserving Unused Local Variables.
	 * <p>Unless requested to preserve unused local variables (that is, never read), the
	 *    compiler will optimize them out, potentially altering debugging.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.codegen.unusedLocal"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "preserve", "optimize out" }</code></dd>
	 * <dt>Default:</dt><dd><code>"preserve"</code></dd>
	 * </dl>
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_CODEGEN_UNUSED_LOCAL = PLUGIN_ID + ".compiler.codegen.unusedLocal"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Generating Method Parameters Attribute.
	 * <p>When generated, this attribute will enable information about the formal parameters of a method
	 * (such as their names) to be accessed from reflection libraries, annotation processing,
	 * code weaving, and in the debugger, from platform target level 1.8 and later.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.codegen.methodParameters"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "generate", "do not generate" }</code></dd>
	 * <dt>Default:</dt><dd><code>"do not generate"</code></dd>
	 * </dl>
	 * @since 3.10
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_CODEGEN_METHOD_PARAMETERS_ATTR = PLUGIN_ID + ".compiler.codegen.methodParameters"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Defining Target Java Platform.
	 * <p>For binary compatibility reasons, .class files are tagged with a minimal required VM version.</p>
	 * <p>Note that <code>"1.4"</code> and higher target versions require the compliance mode to be at least as high
	 *    as the target version. Usually, compliance, target, and source versions are set to the same values.</p>
	 * <p><code>"cldc1.1"</code> requires the source version to be <code>"1.3"</code> and the compliance version to be <code>"1.4"</code> or lower.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.codegen.targetPlatform"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "1.1", "cldc1.1", "1.2", "1.3", "1.4", "1.5", "1.6", "1.7", "1.8" }</code></dd>
	 * <dt>Default:</dt><dd><code>"1.2"</code></dd>
	 * </dl>
	 * @category CompilerOptionID
	 * @see #COMPILER_COMPLIANCE
	 * @see #COMPILER_SOURCE
	 * @see #setComplianceOptions(String, Map)
	 */
	public static final String COMPILER_CODEGEN_TARGET_PLATFORM = PLUGIN_ID + ".compiler.codegen.targetPlatform"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Inline JSR Bytecode Instruction.
	 * <p>When enabled, the compiler will no longer generate JSR instructions, but rather inline corresponding
	 *    subroutine code sequences (mostly corresponding to try finally blocks). The generated code will thus
	 *    get bigger, but will load faster on virtual machines since the verification process is then much simpler.</p>
	 * <p>This mode is anticipating support for the Java Specification Request 202.</p>
	 * <p>Note that JSR inlining is optional only for target platform lesser than 1.5. From 1.5 on, the JSR
	 *    inlining is mandatory (also see related setting {@link #COMPILER_CODEGEN_TARGET_PLATFORM}).</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.codegen.inlineJsrBytecode"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "enabled", "disabled" }</code></dd>
	 * <dt>Default:</dt><dd><code>"disabled"</code></dd>
	 * </dl>
	 * @since 3.0
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_CODEGEN_INLINE_JSR_BYTECODE = PLUGIN_ID + ".compiler.codegen.inlineJsrBytecode"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Javadoc Comment Support.
	 * <p>When this support is disabled, the compiler will ignore all javadoc problems options settings
	 *    and will not report any javadoc problem. It will also not find any reference in javadoc comment and
	 *    DOM AST Javadoc node will be only a flat text instead of having structured tag elements.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.doc.comment.support"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "enabled", "disabled" }</code></dd>
	 * <dt>Default:</dt><dd><code>"enabled"</code></dd>
	 * </dl>
	 * @since 3.0
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_DOC_COMMENT_SUPPORT = PLUGIN_ID + ".compiler.doc.comment.support"; //$NON-NLS-1$
	/**
	 * @deprecated Discontinued since turning off would violate language specs.
	 * @category DeprecatedOptionID
	 */
	public static final String COMPILER_PB_UNREACHABLE_CODE = PLUGIN_ID + ".compiler.problem.unreachableCode"; //$NON-NLS-1$
	/**
	 * @deprecated Discontinued since turning off would violate language specs.
	 * @category DeprecatedOptionID
	 */
	public static final String COMPILER_PB_INVALID_IMPORT = PLUGIN_ID + ".compiler.problem.invalidImport"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Attempt to Override Package Visible Method.
	 * <p>A package visible method, which is any method that is not explicitly
	 *    declared as public, protected or private, is not visible from other
	 *    packages, and thus cannot be overridden from another package.
	 *    Attempting to override a package visible method from another package
	 *    introduces a new method that is unrelated to the original one. When
	 *    enabling this option, the compiler will signal such situations as an
	 *    error or a warning.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.overridingPackageDefaultMethod"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"warning"</code></dd>
	 * </dl>
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_OVERRIDING_PACKAGE_DEFAULT_METHOD = PLUGIN_ID + ".compiler.problem.overridingPackageDefaultMethod"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Method With Constructor Name.
	 * <p>Naming a method with a constructor name is generally considered poor
	 *    style programming. When enabling this option, the compiler will signal such
	 *    scenario either as an error or a warning.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.methodWithConstructorName"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"warning"</code></dd>
	 * </dl>
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_METHOD_WITH_CONSTRUCTOR_NAME = PLUGIN_ID + ".compiler.problem.methodWithConstructorName"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Deprecation.
	 * <p>When enabled, the compiler will signal use of deprecated API either as an
	 *    error or a warning.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.deprecation"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"warning"</code></dd>
	 * </dl>
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_DEPRECATION = PLUGIN_ID + ".compiler.problem.deprecation"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Deprecation Inside Deprecated Code.
	 * <p>When enabled, the compiler will signal use of deprecated API inside deprecated code.</p>
	 * <p>The severity of the problem is controlled with option {@link #COMPILER_PB_DEPRECATION}.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.deprecationInDeprecatedCode"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "enabled", "disabled" }</code></dd>
	 * <dt>Default:</dt><dd><code>"disabled"</code></dd>
	 * </dl>
	 * @since 2.1
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_DEPRECATION_IN_DEPRECATED_CODE = PLUGIN_ID + ".compiler.problem.deprecationInDeprecatedCode"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Deprecation When Overriding Deprecated Method.
	 * <p>When enabled, the compiler will signal the declaration of a method overriding a deprecated one.</p>
	 * <p>The severity of the problem is controlled with option {@link #COMPILER_PB_DEPRECATION}.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.deprecationWhenOverridingDeprecatedMethod"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "enabled", "disabled" }</code></dd>
	 * <dt>Default:</dt><dd><code>"disabled"</code></dd>
	 * </dl>
	 * @since 3.0
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_DEPRECATION_WHEN_OVERRIDING_DEPRECATED_METHOD = "org.eclipse.jdt.core.compiler.problem.deprecationWhenOverridingDeprecatedMethod"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Hidden Catch Block.
	 * <p>Locally to a try statement, some catch blocks may hide others. For example,</p>
	 *    <pre>
	 *      try {  throw new java.io.CharConversionException();
	 *      } catch (java.io.CharConversionException e) {
	 *      } catch (java.io.IOException e) {}.
	 *    </pre>
	 * <p>When enabling this option, the compiler will issue an error or a warning for hidden
	 *    catch blocks corresponding to checked exceptions.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.hiddenCatchBlock"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"warning"</code></dd>
	 * </dl>
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_HIDDEN_CATCH_BLOCK = PLUGIN_ID + ".compiler.problem.hiddenCatchBlock"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Unused Local.
	 * <p>When enabled, the compiler will issue an error or a warning for unused local
	 *    variables (that is, variables never read from).</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.unusedLocal"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"warning"</code></dd>
	 * </dl>
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_UNUSED_LOCAL = PLUGIN_ID + ".compiler.problem.unusedLocal"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Unused Parameter.
	 * <p>When enabled, the compiler will issue an error or a warning for unused method
	 *    parameters (that is, parameters never read from).</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.unusedParameter"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"ignore"</code></dd>
	 * </dl>
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_UNUSED_PARAMETER = PLUGIN_ID + ".compiler.problem.unusedParameter"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Unused Exception Parameter.
	 * <p>When enabled, the compiler will issue an error or a warning for unused exception
	 *    parameters (that is, the thrown exception is never read from).</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.unusedExceptionParameter"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"ignore"</code></dd>
	 * </dl>
	 * @category CompilerOptionID
	 * @since 3.11
	 */
	public static final String COMPILER_PB_UNUSED_EXCEPTION_PARAMETER = PLUGIN_ID + ".compiler.problem.unusedExceptionParameter"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Unused Parameter if Implementing Abstract Method.
	 * <p>When enabled, the compiler will signal unused parameters in abstract method implementations.</p>
	 * <p>The severity of the problem is controlled with option {@link #COMPILER_PB_UNUSED_PARAMETER}.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.unusedParameterWhenImplementingAbstract"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "enabled", "disabled" }</code></dd>
	 * <dt>Default:</dt><dd><code>"disabled"</code></dd>
	 * </dl>
	 * @since 2.1
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_UNUSED_PARAMETER_WHEN_IMPLEMENTING_ABSTRACT = PLUGIN_ID + ".compiler.problem.unusedParameterWhenImplementingAbstract"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Unused Parameter if Overriding Concrete Method.
	 * <p>When enabled, the compiler will signal unused parameters in methods overriding concrete ones.</p>
	 * <p>The severity of the problem is controlled with option {@link #COMPILER_PB_UNUSED_PARAMETER}.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.unusedParameterWhenOverridingConcrete"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "enabled", "disabled" }</code></dd>
	 * <dt>Default:</dt><dd><code>"disabled"</code></dd>
	 * </dl>
	 * @since 2.1
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_UNUSED_PARAMETER_WHEN_OVERRIDING_CONCRETE = PLUGIN_ID + ".compiler.problem.unusedParameterWhenOverridingConcrete"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Consider Reference in Doc Comment for Unused Parameter Check.
	 * <p>When enabled, the compiler will consider doc comment references to parameters (i.e. <code>@param</code> clauses) for the unused
	 *    parameter check. Thus, documented parameters will be considered as mandated as per doc contract.</p>
	 * <p>The severity of the unused parameter problem is controlled with option {@link #COMPILER_PB_UNUSED_PARAMETER}.</p>
	 * <p>Note: this option has no effect until the doc comment support is enabled according to the
	 *    option {@link #COMPILER_DOC_COMMENT_SUPPORT}.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.unusedParameterIncludeDocCommentReference"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "enabled", "disabled" }</code></dd>
	 * <dt>Default:</dt><dd><code>"enabled"</code></dd>
	 * </dl>
	 * @since 3.3
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_UNUSED_PARAMETER_INCLUDE_DOC_COMMENT_REFERENCE = PLUGIN_ID + ".compiler.problem.unusedParameterIncludeDocCommentReference"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Unused Import.
	 * <p>When enabled, the compiler will issue an error or a warning for unused import
	 *    reference.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.unusedImport"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"warning"</code></dd>
	 * </dl>
	 * @since 2.0
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_UNUSED_IMPORT = PLUGIN_ID + ".compiler.problem.unusedImport"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Presence of Type Arguments for a Non-Generic Method Invocation.
	 * <p>When enabled, the compiler will issue an error or a warning whenever type arguments are encountered for a
	 *    non-generic method invocation. Note that prior to compliance level is <code>"1.7"</code>, this situation would automatically result
	 *    in an error. From Java7 on, unused type arguments are being tolerated, and optionally warned against.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.unusedTypeArgumentsForMethodInvocation"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"warning"</code></dd>
	 * </dl>
	 * @since 3.4
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_UNUSED_TYPE_ARGUMENTS_FOR_METHOD_INVOCATION = PLUGIN_ID + ".compiler.problem.unusedTypeArgumentsForMethodInvocation"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Synthetic Access Emulation.
	 * <p>When enabled, the compiler will issue an error or a warning whenever it emulates
	 *    access to a non-accessible member of an enclosing type. Such access can have
	 *    performance implications.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.syntheticAccessEmulation"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"ignore"</code></dd>
	 * </dl>
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_SYNTHETIC_ACCESS_EMULATION = PLUGIN_ID + ".compiler.problem.syntheticAccessEmulation"; //$NON-NLS-1$

	/**
	 * Compiler option ID: Reporting Unused Type Parameter.
	 * <p>When enabled, the compiler will issue an error or a warning whenever it encounters an 
	 * unused type parameter. </p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.unusedTypeParameter"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"ignore"</code></dd>
	 * </dl>
	 * @since 3.9
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_UNUSED_TYPE_PARAMETER = PLUGIN_ID + ".compiler.problem.unusedTypeParameter"; //$NON-NLS-1$

	/**
	 * Compiler option ID: Reporting Non-Externalized String Literal.
	 * <p>When enabled, the compiler will issue an error or a warning for non externalized
	 *    String literal (that is, not tagged with <code>//$NON-NLS-&lt;n&gt;$</code>).</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.nonExternalizedStringLiteral"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"ignore"</code></dd>
	 * </dl>
	 * @since 2.0
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_NON_NLS_STRING_LITERAL = PLUGIN_ID + ".compiler.problem.nonExternalizedStringLiteral"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Usage of <code>'assert'</code> Identifier.
	 * <p>When enabled, the compiler will issue an error or a warning whenever <code>'assert'</code> is
	 *    used as an identifier (reserved keyword in 1.4).</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.assertIdentifier"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"warning"</code></dd>
	 * </dl>
	 * @since 2.0
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_ASSERT_IDENTIFIER = PLUGIN_ID + ".compiler.problem.assertIdentifier"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Usage of <code>'enum'</code> Identifier.
	 * <p>When enabled, the compiler will issue an error or a warning whenever <code>'enum'</code> is
	 *    used as an identifier (reserved keyword in 1.5).</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.enumIdentifier"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"warning"</code></dd>
	 * </dl>
	 * @since 3.1
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_ENUM_IDENTIFIER = PLUGIN_ID + ".compiler.problem.enumIdentifier"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Non-Static Reference to a Static Member.
	 * <p>When enabled, the compiler will issue an error or a warning whenever a static field
	 *    or method is accessed with an expression receiver. A reference to a static member should
	 *    be qualified with a type name.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.staticAccessReceiver"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"warning"</code></dd>
	 * </dl>
	 * @since 2.1
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_STATIC_ACCESS_RECEIVER = PLUGIN_ID + ".compiler.problem.staticAccessReceiver"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Indirect Reference to a Static Member.
	 * <p>When enabled, the compiler will issue an error or a warning whenever a static field
	 *    or method is accessed in an indirect way. A reference to a static member should
	 *    preferably be qualified with its declaring type name.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.indirectStaticAccess"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"ignore"</code></dd>
	 * </dl>
	 * @since 3.0
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_INDIRECT_STATIC_ACCESS = PLUGIN_ID + ".compiler.problem.indirectStaticAccess"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Assignment with no Effect.
	 * <p>When enabled, the compiler will issue an error or a warning whenever an assignment
	 *    has no effect (e.g <code>'x = x'</code>).</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.noEffectAssignment"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"warning"</code></dd>
	 * </dl>
	 * @since 2.1
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_NO_EFFECT_ASSIGNMENT = PLUGIN_ID + ".compiler.problem.noEffectAssignment"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Interface Method not Compatible with non-Inherited Methods.
	 * <p>When enabled, the compiler will issue an error or a warning whenever an interface
	 *    defines a method incompatible with a non-inherited <code>Object</code> method. Until this conflict
	 *    is resolved, such an interface cannot be implemented. For example,</p>
	 *    <pre>
	 *      interface I {
	 *         int clone();
	 *      }
	 *    </pre>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.incompatibleNonInheritedInterfaceMethod"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"warning"</code></dd>
	 * </dl>
	 * @since 2.1
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_INCOMPATIBLE_NON_INHERITED_INTERFACE_METHOD = PLUGIN_ID + ".compiler.problem.incompatibleNonInheritedInterfaceMethod"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Unused Private Members.
	 * <p>When enabled, the compiler will issue an error or a warning whenever a private
	 *    method or field is declared but never used within the same unit.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.unusedPrivateMember"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"warning"</code></dd>
	 * </dl>
	 * @since 2.1
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_UNUSED_PRIVATE_MEMBER = PLUGIN_ID + ".compiler.problem.unusedPrivateMember"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Local Variable Declaration Hiding another Variable.
	 * <p>When enabled, the compiler will issue an error or a warning whenever a local variable
	 *    declaration is hiding some field or local variable (either locally, inherited or defined in enclosing type).</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.localVariableHiding"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"ignore"</code></dd>
	 * </dl>
	 * @since 3.0
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_LOCAL_VARIABLE_HIDING = PLUGIN_ID + ".compiler.problem.localVariableHiding"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Special Parameter Hiding another Field.
	 * <p>When enabled, the compiler will signal cases where a constructor or setter method parameter declaration
	 *    is hiding some field (either locally, inherited or defined in enclosing type).</p>
	 * <p>The severity of the problem is controlled with option {@link #COMPILER_PB_LOCAL_VARIABLE_HIDING}.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.specialParameterHidingField"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "enabled", "disabled" }</code></dd>
	 * <dt>Default:</dt><dd><code>"disabled"</code></dd>
	 * </dl>
	 * @since 3.0
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_SPECIAL_PARAMETER_HIDING_FIELD = PLUGIN_ID + ".compiler.problem.specialParameterHidingField"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Field Declaration Hiding another Variable.
	 * <p>When enabled, the compiler will issue an error or a warning whenever a field
	 *    declaration is hiding some field or local variable (either locally, inherited or defined in enclosing type).</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.fieldHiding"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"ignore"</code></dd>
	 * </dl>
	 * @since 3.0
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_FIELD_HIDING = PLUGIN_ID + ".compiler.problem.fieldHiding"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Type Declaration Hiding another Type.
	 * <p>When enabled, the compiler will issue an error or a warning in situations where a type parameter
	 *    declaration is hiding some type, when a nested type is hiding some type parameter, or when
	 *    a nested type is hiding another nested type defined in same unit.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.typeParameterHiding"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"warning"</code></dd>
	 * </dl>
	 * @since 3.1
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_TYPE_PARAMETER_HIDING = PLUGIN_ID + ".compiler.problem.typeParameterHiding"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Possible Accidental Boolean Assignment.
	 * <p>When enabled, the compiler will issue an error or a warning if a boolean assignment is acting as the condition
	 *    of a control statement  (where it probably was meant to be a boolean comparison).</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.possibleAccidentalBooleanAssignment"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"ignore"</code></dd>
	 * </dl>
	 * @since 3.0
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_POSSIBLE_ACCIDENTAL_BOOLEAN_ASSIGNMENT = PLUGIN_ID + ".compiler.problem.possibleAccidentalBooleanAssignment"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Switch Fall-Through Case.
	 * <p>When enabled, the compiler will issue an error or a warning if a case may be
	 *    entered by falling through previous case. Empty cases are allowed.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.fallthroughCase"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"ignore"</code></dd>
	 * </dl>
	 * @since 3.2
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_FALLTHROUGH_CASE = PLUGIN_ID + ".compiler.problem.fallthroughCase"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Empty Statements and Unnecessary Semicolons.
	 * <p>When enabled, the compiler will issue an error or a warning if an empty statement or a
	 *    unnecessary semicolon is encountered.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.emptyStatement"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"ignore"</code></dd>
	 * </dl>
	 * @since 3.0
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_EMPTY_STATEMENT = PLUGIN_ID + ".compiler.problem.emptyStatement"; //$NON-NLS-1$
	/**
	 * Compiler option ID.
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.booleanMethodThrowingException"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"ignore"</code></dd>
	 * </dl>
	 * @since 3.0
	 * @category CompilerOptionID
	 * @deprecated - this option has no effect
	 */
	public static final String COMPILER_PB_BOOLEAN_METHOD_THROWING_EXCEPTION = PLUGIN_ID + ".compiler.problem.booleanMethodThrowingException"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Unnecessary Type Check.
	 * <p>When enabled, the compiler will issue an error or a warning when a cast or an <code>instanceof</code> operation
	 *    is unnecessary.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.unnecessaryTypeCheck"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"ignore"</code></dd>
	 * </dl>
	 * @since 3.0
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_UNNECESSARY_TYPE_CHECK = PLUGIN_ID + ".compiler.problem.unnecessaryTypeCheck"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Unnecessary Else.
	 * <p>When enabled, the compiler will issue an error or a warning when a statement is unnecessarily
	 *    nested within an <code>else</code> clause (in situation where then clause is not completing normally).</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.unnecessaryElse"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"ignore"</code></dd>
	 * </dl>
	 * @since 3.0
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_UNNECESSARY_ELSE = PLUGIN_ID + ".compiler.problem.unnecessaryElse"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Undocumented Empty Block.
	 * <p>When enabled, the compiler will issue an error or a warning when an empty block is detected and it is not
	 *    documented with any comment.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.undocumentedEmptyBlock"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"ignore"</code></dd>
	 * </dl>
	 * @since 3.0
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_UNDOCUMENTED_EMPTY_BLOCK = PLUGIN_ID + ".compiler.problem.undocumentedEmptyBlock"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Finally Blocks Not Completing Normally.
	 * <p>When enabled, the compiler will issue an error or a warning when a finally block does not complete normally.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.finallyBlockNotCompletingNormally"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"warning"</code></dd>
	 * </dl>
	 * @since 3.0
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_FINALLY_BLOCK_NOT_COMPLETING = PLUGIN_ID + ".compiler.problem.finallyBlockNotCompletingNormally"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Unused Declared Thrown Exception.
	 * <p>When enabled, the compiler will issue an error or a warning when a
	 *    method or a constructor is declaring a checked exception as thrown,
	 *    but its body actually raises neither that exception, nor any other
	 *    exception extending it.</p>
	 * <p>This diagnostic is further tuned by options
	 *    {@link #COMPILER_PB_UNUSED_DECLARED_THROWN_EXCEPTION_INCLUDE_DOC_COMMENT_REFERENCE},
	 *    {@link #COMPILER_PB_UNUSED_DECLARED_THROWN_EXCEPTION_EXEMPT_EXCEPTION_AND_THROWABLE},
	 *    and {@link #COMPILER_PB_UNUSED_DECLARED_THROWN_EXCEPTION_WHEN_OVERRIDING}.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.unusedDeclaredThrownException"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"ignore"</code></dd>
	 * </dl>
	 * @since 3.0
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_UNUSED_DECLARED_THROWN_EXCEPTION = PLUGIN_ID + ".compiler.problem.unusedDeclaredThrownException"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Unused Declared Thrown Exception in Overriding Method.
	 * <p>When disabled, the compiler will report unused declared thrown
	 *    exceptions neither on overriding methods nor on implementing methods.</p>
	 * <p>The severity of the unused declared thrown exception problem is
	 *    controlled with option {@link #COMPILER_PB_UNUSED_DECLARED_THROWN_EXCEPTION}.</p>
	 * <p>This diagnostic is further tuned by options
	 *    {@link #COMPILER_PB_UNUSED_DECLARED_THROWN_EXCEPTION_INCLUDE_DOC_COMMENT_REFERENCE} and
	 *    {@link #COMPILER_PB_UNUSED_DECLARED_THROWN_EXCEPTION_EXEMPT_EXCEPTION_AND_THROWABLE}.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.unusedDeclaredThrownExceptionWhenOverriding"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "enabled", "disabled" }</code></dd>
	 * <dt>Default:</dt><dd><code>"disabled"</code></dd>
	 * </dl>
	 * @since 3.0
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_UNUSED_DECLARED_THROWN_EXCEPTION_WHEN_OVERRIDING = PLUGIN_ID + ".compiler.problem.unusedDeclaredThrownExceptionWhenOverriding"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Consider Reference in Doc Comment for Unused Declared Thrown Exception Check.
	 * <p>When enabled, the compiler will consider doc comment references to
	 *    exceptions (i.e. <code>@throws</code> clauses) for the unused
	 *    declared thrown exception check. Thus, documented exceptions will be
	 *    considered as mandated as per doc contract.</p>
	 * <p>The severity of the unused declared thrown exception problem is controlled with option {@link #COMPILER_PB_UNUSED_DECLARED_THROWN_EXCEPTION}.</p>
	 * <p>Note: this option has no effect until the doc comment support is enabled according to the
	 *    option {@link #COMPILER_DOC_COMMENT_SUPPORT}.</p>
	 * <p>This diagnostic is further tuned by options
	 *    {@link #COMPILER_PB_UNUSED_DECLARED_THROWN_EXCEPTION_EXEMPT_EXCEPTION_AND_THROWABLE}
	 *    and {@link #COMPILER_PB_UNUSED_DECLARED_THROWN_EXCEPTION_WHEN_OVERRIDING}.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.unusedDeclaredThrownExceptionIncludeDocCommentReference"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "enabled", "disabled" }</code></dd>
	 * <dt>Default:</dt><dd><code>"enabled"</code></dd>
	 * </dl>
	 * @since 3.4
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_UNUSED_DECLARED_THROWN_EXCEPTION_INCLUDE_DOC_COMMENT_REFERENCE = PLUGIN_ID + ".compiler.problem.unusedDeclaredThrownExceptionIncludeDocCommentReference"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Unused Declared Thrown Exception Exempts Exception And Throwable.
	 * <p>When enabled, the compiler will issue an error or a warning when a
	 *    method or a constructor is declaring a checked exception else than
	 *    {@link java.lang.Throwable} or {@link java.lang.Exception} as thrown,
	 *    but its body actually raises neither that exception, nor any other
	 *    exception extending it. When disabled, the compiler will issue an
	 *    error or a warning when a method or a constructor is declaring a
	 *    checked exception (including {@link java.lang.Throwable} and
	 *    {@link java.lang.Exception}) as thrown, but its body actually raises
	 *    neither that exception, nor any other exception extending it.</p>
	 * <p>The severity of the unused declared thrown exception problem is
	 *    controlled with option
	 *    {@link #COMPILER_PB_UNUSED_DECLARED_THROWN_EXCEPTION}.</p>
	 * <p>This diagnostic is further tuned by options
	 *    {@link #COMPILER_PB_UNUSED_DECLARED_THROWN_EXCEPTION_INCLUDE_DOC_COMMENT_REFERENCE}
	 *    and {@link #COMPILER_PB_UNUSED_DECLARED_THROWN_EXCEPTION_WHEN_OVERRIDING}.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.unusedDeclaredThrownExceptionExemptExceptionAndThrowable"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "enabled", "disabled" }</code></dd>
	 * <dt>Default:</dt><dd><code>"enabled"</code></dd>
	 * </dl>
	 * @since 3.4
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_UNUSED_DECLARED_THROWN_EXCEPTION_EXEMPT_EXCEPTION_AND_THROWABLE = PLUGIN_ID + ".compiler.problem.unusedDeclaredThrownExceptionExemptExceptionAndThrowable"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Unqualified Access to Field.
	 * <p>When enabled, the compiler will issue an error or a warning when a field is access without any qualification.
	 *    In order to improve code readability, it should be qualified, e.g. <code>'x'</code> should rather be written <code>'this.x'</code>.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.unqualifiedFieldAccess"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"ignore"</code></dd>
	 * </dl>
	 * @since 3.0
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_UNQUALIFIED_FIELD_ACCESS = PLUGIN_ID + ".compiler.problem.unqualifiedFieldAccess"; //$NON-NLS-1$
	/**
	 * @deprecated Use {@link #COMPILER_PB_UNCHECKED_TYPE_OPERATION} instead.
	 * @since 3.1
	 * @category DeprecatedOptionID
	 */
	public static final String COMPILER_PB_UNSAFE_TYPE_OPERATION = PLUGIN_ID + ".compiler.problem.uncheckedTypeOperation"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Unchecked Type Operation.
	 * <p>When enabled, the compiler will issue an error or a warning whenever an operation involves generic types, and potentially
	 *    invalidates type safety since involving raw types (e.g. invoking <code>#foo(X&lt;String&gt;)</code> with arguments <code>(X)</code>).</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.uncheckedTypeOperation"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"warning"</code></dd>
	 * </dl>
	 * @since 3.1
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_UNCHECKED_TYPE_OPERATION = PLUGIN_ID + ".compiler.problem.uncheckedTypeOperation"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Raw Type Reference.
	 * <p>When enabled, the compiler will issue an error or a warning when detecting references to raw types. Raw types are
	 *    discouraged, and are intended to help interfacing with legacy code. In the future, the language specification may
	 *    reject raw references to generic types.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.rawTypeReference"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"warning"</code></dd>
	 * </dl>
	 * @since 3.2
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_RAW_TYPE_REFERENCE = PLUGIN_ID + ".compiler.problem.rawTypeReference"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting of Unavoidable Generic Type Problems due to raw APIs.
	 * <p> When enabled, the compiler will issue an error or warning even when it detects a generics-related type problem
	 *     that could not have been avoided by the programmer, because a referenced API already contains raw types.
	 *     As an example, a type may be forced to use raw types
	 *     in its method signatures and return types because the methods it overrides from a super type are declared to
	 *     use raw types in the first place.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.unavoidableGenericTypeProblems"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "enabled", "disabled" }</code></dd>
	 * <dt>Default:</dt><dd><code>"enabled"</code></dd>
	 * </dl>
	 * @since 3.7
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_UNAVOIDABLE_GENERIC_TYPE_PROBLEMS = PLUGIN_ID + ".compiler.problem.unavoidableGenericTypeProblems"; //$NON-NLS-1$

	/**
	 * Compiler option ID: Reporting final Bound for Type Parameter.
	 * <p>When enabled, the compiler will issue an error or a warning whenever a generic type parameter is associated with a
	 *    bound corresponding to a final type; since final types cannot be further extended, the parameter is pretty useless.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.finalParameterBound"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"warning"</code></dd>
	 * </dl>
	 * @since 3.1
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_FINAL_PARAMETER_BOUND = PLUGIN_ID + ".compiler.problem.finalParameterBound"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Missing Declaration of serialVersionUID Field on Serializable Class.
	 * <p>When enabled, the compiler will issue an error or a warning whenever a serializable class is missing a local declaration
	 *    of a <code>serialVersionUID</code> field. This field must be declared as static final and be of type <code>long</code>.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.missingSerialVersion"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"warning"</code></dd>
	 * </dl>
	 * @since 3.1
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_MISSING_SERIAL_VERSION = PLUGIN_ID + ".compiler.problem.missingSerialVersion"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Varargs Argument Needing a Cast in Method/Constructor Invocation.
	 * <p>When enabled, the compiler will issue an error or a warning whenever a varargs arguments should be cast
	 *    when passed to a method/constructor invocation. (e.g. <code>Class.getMethod(String name, Class ... args )</code>
	 *    invoked with arguments <code>("foo", null)</code>).</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.varargsArgumentNeedCast"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"warning"</code></dd>
	 * </dl>
	 * @since 3.1
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_VARARGS_ARGUMENT_NEED_CAST = PLUGIN_ID + ".compiler.problem.varargsArgumentNeedCast"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Boxing/Unboxing Conversion.
	 * <p>When enabled, the compiler will issue an error or a warning whenever a boxing or an unboxing
	 *    conversion is performed.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.autoboxing"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"ignore"</code></dd>
	 * </dl>
	 * @since 3.1
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_AUTOBOXING = PLUGIN_ID + ".compiler.problem.autoboxing"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Use of Annotation Type as Super Interface.
	 * <p>When enabled, the compiler will issue an error or a warning whenever an annotation type is used
	 *    as a super-interface. Though legal, this is discouraged.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.annotationSuperInterface"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"warning"</code></dd>
	 * </dl>
	 * @since 3.1
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_ANNOTATION_SUPER_INTERFACE = PLUGIN_ID + ".compiler.problem.annotationSuperInterface"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Missing <code>@Override</code> Annotation.
	 * <p>When enabled, the compiler will issue an error or a warning whenever encountering a method
	 *    declaration which overrides a superclass method but has no <code>@Override</code> annotation.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.missingOverrideAnnotation"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"ignore"</code></dd>
	 * </dl>
	 * @since 3.1
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_MISSING_OVERRIDE_ANNOTATION = PLUGIN_ID + ".compiler.problem.missingOverrideAnnotation"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Missing <code>@Override</code> Annotation for interface method implementation.
	 * <p>When enabled, the compiler will issue an error or a warning whenever encountering a method
	 *    declaration which overrides or implements a superinterface method but has no <code>@Override</code> annotation.</p>
	 * <p>This option only has an effect if the compiler compliance is 1.6 or greater.</p>
	 * <p>The severity of the problem is controlled with option {@link #COMPILER_PB_MISSING_OVERRIDE_ANNOTATION}.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.missingOverrideAnnotationForInterfaceMethodImplementation"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "enabled", "disabled" }</code></dd>
	 * <dt>Default:</dt><dd><code>"enabled"</code></dd>
	 * </dl>
	 * @since 3.6
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_MISSING_OVERRIDE_ANNOTATION_FOR_INTERFACE_METHOD_IMPLEMENTATION = PLUGIN_ID + ".compiler.problem.missingOverrideAnnotationForInterfaceMethodImplementation"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Missing <code>@Deprecated</code> Annotation.
	 * <p>When enabled, the compiler will issue an error or a warning whenever encountering a declaration
	 *    carrying a <code>@deprecated</code> doc tag but having no corresponding <code>@Deprecated</code> annotation.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.missingDeprecatedAnnotation"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"ignore"</code></dd>
	 * </dl>
	 * @since 3.1
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_MISSING_DEPRECATED_ANNOTATION = PLUGIN_ID + ".compiler.problem.missingDeprecatedAnnotation"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Missing HashCode Method.
	 * <p>When enabled, the compiler will issue an error or a warning if a type
	 * overrides Object.equals(Object) but does not override hashCode().</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.missingHashCodeMethod"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"ignore"</code></dd>
	 * </dl>
	 * @since 3.5
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_MISSING_HASHCODE_METHOD = PLUGIN_ID + ".compiler.problem.missingHashCodeMethod"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Dead Code.
	 * <p>When enabled, the compiler will issue an error or a warning if some non fatal dead code is detected. For instance, <code>if (false) foo();</code>
	 * is not reported as truly unreachable code by the Java Language Specification. If this diagnostic is enabled, then the invocation of <code>foo()</code> is
	 * going to be signaled as being dead code.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.deadCode"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"warning"</code></dd>
	 * </dl>
	 * @since 3.5
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_DEAD_CODE = PLUGIN_ID + ".compiler.problem.deadCode"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Dead Code Inside Trivial If Statement.
	 * <p>When enabled, the compiler will signal presence of dead code inside trivial IF statement, e.g. <code>if (DEBUG)...</code>.</p>
	 * <p>The severity of the problem is controlled with option {@link #COMPILER_PB_DEAD_CODE}.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.deadCodeInTrivialIfStatement"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "enabled", "disabled" }</code></dd>
	 * <dt>Default:</dt><dd><code>"disabled"</code></dd>
	 * </dl>
	 * @since 3.5
	 * @category CompilerOptionID
	 */	
	public static final String COMPILER_PB_DEAD_CODE_IN_TRIVIAL_IF_STATEMENT = PLUGIN_ID + ".compiler.problem.deadCodeInTrivialIfStatement"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Incomplete Enum Switch.
	 * <p>When enabled, the compiler will issue an error or a warning
	 * 		regarding each enum constant for which a corresponding case label is lacking.
	 * 		Reporting is further controlled by the option {@link #COMPILER_PB_MISSING_ENUM_CASE_DESPITE_DEFAULT}.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.incompleteEnumSwitch"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"warning"</code></dd>
	 * </dl>
	 * @since 3.1
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_INCOMPLETE_ENUM_SWITCH = PLUGIN_ID + ".compiler.problem.incompleteEnumSwitch"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Missing Enum Case In Switch Despite An Existing Default Case.
	 * <p>This option further controls the option {@link #COMPILER_PB_INCOMPLETE_ENUM_SWITCH}:</p>
	 * 	<ul>
	 * 	<li>If enabled the compiler will report problems about missing enum constants even if a default case exists
	 * 		in the same switch statement.</li>
	 *  <li>If disabled existence of a default case is considered as sufficient to make a switch statement complete.</li>
	 *  </ul>
	 *  This option has no effect if {@link #COMPILER_PB_INCOMPLETE_ENUM_SWITCH} is set to <code>"ignore"</code>.
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.missingEnumCaseDespiteDefault"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "enabled", "disabled" }</code></dd>
	 * <dt>Default:</dt><dd><code>"disabled"</code></dd>
	 * </dl>
	 * @since 3.8
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_MISSING_ENUM_CASE_DESPITE_DEFAULT = PLUGIN_ID + ".compiler.problem.missingEnumCaseDespiteDefault"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Missing Default Case In Switch.
	 * <p>When enabled, the compiler will issue an error or a warning 
	 * 		against each switch statement that lacks a default case.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.missingDefaultCase"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"ignore"</code></dd>
	 * </dl>
	 * @since 3.8
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_SWITCH_MISSING_DEFAULT_CASE = PLUGIN_ID + ".compiler.problem.missingDefaultCase"; //$NON-NLS-1$
	/**
	 * @since 3.1
	 * @deprecated Use {@link #COMPILER_PB_NULL_REFERENCE} instead.
	 * @category DeprecatedOptionID
	 */
	public static final String COMPILER_PB_INCONSISTENT_NULL_CHECK = PLUGIN_ID + ".compiler.problem.inconsistentNullCheck"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Unreferenced Label.
	 * <p>When enabled, the compiler will issue an error or a warning when encountering a labeled statement which label
	 *    is never explicitly referenced. A label is considered to be referenced if its name explicitly appears behind a break
	 *    or continue statement; for instance the following label would be considered unreferenced:</p>
	 *    <code>LABEL: { break; }</code>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.unusedLabel"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"warning"</code></dd>
	 * </dl>
	 * @since 3.2
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_UNUSED_LABEL = PLUGIN_ID + ".compiler.problem.unusedLabel"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Invalid Javadoc Comment.
	 * <p>This is the generic control for the severity of Javadoc problems.
	 *    When enabled, the compiler will issue an error or a warning for a problem in Javadoc.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.invalidJavadoc"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"ignore"</code></dd>
	 * </dl>
	 * @since 3.0
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_INVALID_JAVADOC = PLUGIN_ID + ".compiler.problem.invalidJavadoc"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Invalid Javadoc Tags.
	 * <p>When enabled, the compiler will signal unbound or unexpected reference tags in Javadoc.
	 *    A <code>@throws</code> tag referencing an undeclared exception would be considered as unexpected.</p>
	 * <p>Note that this diagnosis can be enabled based on the visibility of the construct associated with the Javadoc;
	 *    also see the setting {@link #COMPILER_PB_INVALID_JAVADOC_TAGS_VISIBILITY}.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.invalidJavadocTags"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "enabled", "disabled" }</code></dd>
	 * <dt>Default:</dt><dd><code>"disabled"</code></dd>
	 * </dl>
	 * @since 3.0
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_INVALID_JAVADOC_TAGS = PLUGIN_ID + ".compiler.problem.invalidJavadocTags"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Invalid Javadoc Tags with Deprecated References.
	 * <p>Specify whether the compiler will report deprecated references used in Javadoc tags.</p>
	 * <p>Note that this diagnosis can be enabled based on the visibility of the construct associated with the Javadoc;
	 *    also see the setting {@link #COMPILER_PB_INVALID_JAVADOC_TAGS_VISIBILITY}.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.invalidJavadocTagsDeprecatedRef"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "enabled", "disabled" }</code></dd>
	 * <dt>Default:</dt><dd><code>"disabled"</code></dd>
	 * </dl>
	 * @since 3.1
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_INVALID_JAVADOC_TAGS__DEPRECATED_REF = PLUGIN_ID + ".compiler.problem.invalidJavadocTagsDeprecatedRef"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Invalid Javadoc Tags with Not Visible References.
	 * <p>Specify whether the compiler will report non-visible references used in Javadoc tags.</p>
	 * <p>Note that this diagnosis can be enabled based on the visibility of the construct associated with the Javadoc;
	 *    also see the setting {@link #COMPILER_PB_INVALID_JAVADOC_TAGS_VISIBILITY}.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.invalidJavadocTagsNotVisibleRef"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "enabled", "disabled" }</code></dd>
	 * <dt>Default:</dt><dd><code>"disabled"</code></dd>
	 * </dl>
	 * @since 3.1
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_INVALID_JAVADOC_TAGS__NOT_VISIBLE_REF = PLUGIN_ID + ".compiler.problem.invalidJavadocTagsNotVisibleRef"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Visibility Level For Invalid Javadoc Tags.
	 * <p>Set the minimum visibility level for Javadoc tag problems. Below this level problems will be ignored.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.invalidJavadocTagsVisibility"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "public", "protected", "default", "private" }</code></dd>
	 * <dt>Default:</dt><dd><code>"public"</code></dd>
	 * </dl>
	 * @since 3.0
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_INVALID_JAVADOC_TAGS_VISIBILITY = PLUGIN_ID + ".compiler.problem.invalidJavadocTagsVisibility"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting missing tag description.
	 * <p>When enabled, the compiler will report a warning or an error for any Javadoc tag missing a required description.</p>
	 * <p>The severity of the problem is controlled with option {@link #COMPILER_PB_INVALID_JAVADOC}.</p>
	 * <p>It does not depend on option {@link #COMPILER_PB_INVALID_JAVADOC_TAGS}.</p>
	 * <p>When this option is valued to {@link #COMPILER_PB_MISSING_JAVADOC_TAG_DESCRIPTION_ALL_STANDARD_TAGS},
	 *       a subset of the standard <a href="http://download.oracle.com/javase/6/docs/technotes/tools/windows/javadoc.html#javadoctags">Javadoc tags</a>
	 *       that have a description, text or label are checked. While this set may grow in the future, note that user-defined tags are not and will not be checked.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.missingJavadocTagDescription"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "return_tag", "all_standard_tags", "no_tag" }</code></dd>
	 * <dt>Default:</dt><dd><code>"return_tag"</code></dd>
	 * </dl>
	 * @since 3.4
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_MISSING_JAVADOC_TAG_DESCRIPTION = PLUGIN_ID + ".compiler.problem.missingJavadocTagDescription"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Missing Javadoc Tags.
	 * <p>This is the generic control for the severity of Javadoc missing tag problems.
	 *    When enabled, the compiler will issue an error or a warning when tags are missing in Javadoc comments.</p>
	 * <p>Note that this diagnosis can be enabled based on the visibility of the construct associated with the Javadoc;
	 *    also see the setting {@link #COMPILER_PB_MISSING_JAVADOC_TAGS_VISIBILITY}.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.missingJavadocTags"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"ignore"</code></dd>
	 * </dl>
	 * @since 3.0
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_MISSING_JAVADOC_TAGS = PLUGIN_ID + ".compiler.problem.missingJavadocTags"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Visibility Level For Missing Javadoc Tags.
	 * <p>Set the minimum visibility level for Javadoc missing tag problems. Below this level problems will be ignored.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.missingJavadocTagsVisibility"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "public", "protected", "default", "private" }</code></dd>
	 * <dt>Default:</dt><dd><code>"public"</code></dd>
	 * </dl>
	 * @since 3.0
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_MISSING_JAVADOC_TAGS_VISIBILITY = PLUGIN_ID + ".compiler.problem.missingJavadocTagsVisibility"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Missing Javadoc Tags on Overriding Methods.
	 * <p>Specify whether the compiler will verify overriding methods in order to report Javadoc missing tag problems.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.missingJavadocTagsOverriding"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "enabled", "disabled" }</code></dd>
	 * <dt>Default:</dt><dd><code>"disabled"</code></dd>
	 * </dl>
	 * @since 3.0
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_MISSING_JAVADOC_TAGS_OVERRIDING = PLUGIN_ID + ".compiler.problem.missingJavadocTagsOverriding"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Missing Javadoc Tags for Method Type Parameters.
	 * <p>Specify whether a missing <code>@param</code> for a type parameter in a method declaration should be reported.
	 *    When enabled, the compiler will issue a missing Javadoc tag error or warning for a type parameter without a 
	 *    corresponding <code>@param</code> tag.</p>
	 * <p>This option only has an effect if the compiler compliance is 1.5 or greater.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.missingJavadocTagsMethodTypeParameters"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "enabled", "disabled" }</code></dd>
	 * <dt>Default:</dt><dd><code>"disabled"</code></dd>
	 * </dl>
	 * @since 3.7
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_MISSING_JAVADOC_TAGS_METHOD_TYPE_PARAMETERS = PLUGIN_ID + ".compiler.problem.missingJavadocTagsMethodTypeParameters"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Missing Javadoc Comments.
	 * <p>This is the generic control for the severity of missing Javadoc comment problems.
	 *    When enabled, the compiler will issue an error or a warning when Javadoc comments are missing.</p>
	 * <p>Note that this diagnosis can be enabled based on the visibility of the construct associated with the expected Javadoc;
	 *    also see the setting {@link #COMPILER_PB_MISSING_JAVADOC_COMMENTS_VISIBILITY}.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.missingJavadocComments"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"ignore"</code></dd>
	 * </dl>
	 * @since 3.0
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_MISSING_JAVADOC_COMMENTS = PLUGIN_ID + ".compiler.problem.missingJavadocComments"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Visibility Level For Missing Javadoc Comments.
	 * <p>Set the minimum visibility level for missing Javadoc problems. Below this level problems will be ignored.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.missingJavadocCommentsVisibility"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "public", "protected", "default", "private" }</code></dd>
	 * <dt>Default:</dt><dd><code>"public"</code></dd>
	 * </dl>
	 * @since 3.0
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_MISSING_JAVADOC_COMMENTS_VISIBILITY = PLUGIN_ID + ".compiler.problem.missingJavadocCommentsVisibility"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Missing Javadoc Comments on Overriding Methods.
	 * <p>Specify whether the compiler will verify overriding methods in order to report missing Javadoc comment problems.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.missingJavadocCommentsOverriding"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "enabled", "disabled" }</code></dd>
	 * <dt>Default:</dt><dd><code>"disabled"</code></dd>
	 * </dl>
	 * @since 3.0
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_MISSING_JAVADOC_COMMENTS_OVERRIDING = PLUGIN_ID + ".compiler.problem.missingJavadocCommentsOverriding"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Usage of <code>char[]</code> Expressions in String Concatenations.
	 * <p>When enabled, the compiler will issue an error or a warning whenever a <code>char[]</code> expression
	 *    is used in String concatenations (for example, <code>"hello" + new char[]{'w','o','r','l','d'}</code>).</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.noImplicitStringConversion"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"warning"</code></dd>
	 * </dl>
	 * @since 2.1
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_CHAR_ARRAY_IN_STRING_CONCATENATION = PLUGIN_ID + ".compiler.problem.noImplicitStringConversion"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Maximum Number of Problems Reported per Compilation Unit.
	 * <p>Specify the maximum number of problems reported on each compilation unit.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.maxProblemPerUnit"</code></dd>
	 * <dt>Possible values:</dt><dd><code>"&lt;n&gt;"</code> where <code>&lt;n&gt;</code> is zero or a positive integer (if zero then all problems are reported).</dd>
	 * <dt>Default:</dt><dd><code>"100"</code></dd>
	 * </dl>
	 * @since 2.0
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_MAX_PER_UNIT = PLUGIN_ID + ".compiler.maxProblemPerUnit"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Treating Optional Error as Fatal.
	 * <p>When enabled, optional errors (i.e. optional problems which severity is set to <code>"error"</code>) will be treated as standard
	 *    compiler errors, yielding problem methods/types preventing from running offending code until the issue got resolved.</p>
	 * <p>When disabled, optional errors are only considered as warnings, still carrying an error indication to make them more
	 *    severe. Note that by default, optional errors are not fatal. Non-optional errors are
	 *    always fatal.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.fatalOptionalError"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "enabled", "disabled" }</code></dd>
	 * <dt>Default:</dt><dd><code>"disabled"</code></dd>
	 * </dl>
	 * @since 3.2
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_FATAL_OPTIONAL_ERROR = PLUGIN_ID + ".compiler.problem.fatalOptionalError"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Parameter Assignment.
	 * <p>When enabled, the compiler will issue an error or a warning if a parameter is
	 *    assigned to.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.parameterAssignment"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"ignore"</code></dd>
	 * </dl>
	 * @since 3.2
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_PARAMETER_ASSIGNMENT = PLUGIN_ID + ".compiler.problem.parameterAssignment"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting a method that qualifies as static, but not declared static.
	 * <p>When enabled, the compiler will issue an error or a warning if a method has
	 *    not been declared as <code>static</code>, even though it qualifies as one.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.reportMethodCanBeStatic"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"ignore"</code></dd>
	 * </dl>
	 * @since 3.7
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_MISSING_STATIC_ON_METHOD = PLUGIN_ID + ".compiler.problem.reportMethodCanBeStatic"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting a method that may qualify as static, but not declared static.
	 * <p>When enabled, the compiler will issue an error or a warning if a method has
	 *    not been declared as <code>static</code>, even though it may qualify as one,
	 *    when another method doesn't override it.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.reportMethodCanBePotentiallyStatic"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"ignore"</code></dd>
	 * </dl>
	 * @since 3.7
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_POTENTIALLY_MISSING_STATIC_ON_METHOD = PLUGIN_ID + ".compiler.problem.reportMethodCanBePotentiallyStatic"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting a resource that is not closed properly.
	 * <p>When enabled, the compiler will issue an error or a warning if
	 *    a local variable holds a value of type <code>java.lang.AutoCloseable</code> (compliance>=1.7) 
	 *    or a value of type <code>java.io.Closeable</code> (compliance<=1.6) and if
	 *    flow analysis shows that the method <code>close()</code> is not invoked locally on that value.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.unclosedCloseable"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"warning"</code></dd>
	 * </dl>
	 * @since 3.8
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_UNCLOSED_CLOSEABLE = PLUGIN_ID + ".compiler.problem.unclosedCloseable"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting a resource that may not be closed properly.
	 * <p>When enabled, the compiler will issue an error or a warning if
	 *    a local variable holds a value of type <code>java.lang.AutoCloseable</code> (compliance>=1.7) 
	 *    or a value of type <code>java.io.Closeable</code> (compliance<=1.6) and if
	 *    flow analysis shows that the method <code>close()</code> is 
	 *    not invoked locally on that value for all execution paths.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.potentiallyUnclosedCloseable"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"ignore"</code></dd>
	 * </dl>
	 * @since 3.8
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_POTENTIALLY_UNCLOSED_CLOSEABLE = PLUGIN_ID + ".compiler.problem.potentiallyUnclosedCloseable"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting a resource that is not managed by try-with-resources.
	 * <p>When enabled, the compiler will issue an error or a warning if a local variable 
	 * 	  holds a value of type <code>java.lang.AutoCloseable</code>, and if the method
	 *    <code>close()</code> is explicitly invoked on that resource, but the resource is
	 *    not managed by a try-with-resources block.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.explicitlyClosedAutoCloseable"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"ignore"</code></dd>
	 * </dl>
	 * @since 3.8
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_EXPLICITLY_CLOSED_AUTOCLOSEABLE = PLUGIN_ID + ".compiler.problem.explicitlyClosedAutoCloseable"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Annotation-based Null Analysis.
	 * <p>This option controls whether the compiler will use null annotations for
	 *    improved analysis of (potential) null references.</p>
	 * <p>When enabled, the compiler will interpret the annotation types defined using
	 *    {@link #COMPILER_NONNULL_ANNOTATION_NAME} and {@link #COMPILER_NULLABLE_ANNOTATION_NAME}
	 *    as specifying whether or not a given type includes the value <code>null</code>.</p>
	 * <p>The effect of these analyses is further controlled by the options
	 *    {@link #COMPILER_PB_NULL_SPECIFICATION_VIOLATION},
	 *    {@link #COMPILER_PB_NULL_ANNOTATION_INFERENCE_CONFLICT} and
	 *    {@link #COMPILER_PB_NULL_UNCHECKED_CONVERSION}.
	 * </p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.annotation.nullanalysis"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "disabled", "enabled" }</code></dd>
	 * <dt>Default:</dt><dd><code>"disabled"</code></dd>
	 * </dl>
	 * @since 3.8
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_ANNOTATION_NULL_ANALYSIS = PLUGIN_ID + ".compiler.annotation.nullanalysis"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Name of Annotation Type for Nullable Types.
	 * <p>This option defines a fully qualified Java type name that the compiler may use
	 *    to perform special null analysis.</p>
	 * <p>If the annotation specified by this option is applied to a type in a method
	 *    signature or variable declaration, this will be interpreted as a specification
	 *    that <code>null</code> is a legal value in that position. Currently supported
	 *    positions are: method parameters, method return type, fields and local variables.</p>
	 * <p>If a value whose type
	 *    is annotated with this annotation is dereferenced without checking for null,
	 *    the compiler will trigger a diagnostic as further controlled by
	 *    {@link #COMPILER_PB_POTENTIAL_NULL_REFERENCE}.</p>
	 * <p>The compiler may furthermore check adherence to the null specification as
	 *    further controlled by {@link #COMPILER_PB_NULL_SPECIFICATION_VIOLATION},
	 *    {@link #COMPILER_PB_NULL_ANNOTATION_INFERENCE_CONFLICT} and
	 *    {@link #COMPILER_PB_NULL_UNCHECKED_CONVERSION}.</p>
	 * <p>This option only has an effect if the option {@link #COMPILER_ANNOTATION_NULL_ANALYSIS} is enabled.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.annotation.nullable"</code></dd>
	 * <dt>Possible values:</dt><dd>any legal, fully qualified Java type name; must resolve to an annotation type.</dd>
	 * <dt>Default:</dt><dd><code>"org.eclipse.jdt.annotation.Nullable"</code></dd>
	 * </dl>
	 * @since 3.8
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_NULLABLE_ANNOTATION_NAME = PLUGIN_ID + ".compiler.annotation.nullable"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Names of Secondary Annotation Types for Nullable Types.
	 * <p>This option defines a comma-separated list of fully qualified Java type names
	 *    that the compiler may use to perform special null analysis.</p>
	 * <p>The annotation types identified by the names in this list are interpreted in the same way
	 *    as the annotation identified by {@link #COMPILER_NULLABLE_ANNOTATION_NAME}.
	 *    The intention is to support libraries using different sets of null annotations,
	 *    in addition to those used by the current project. Secondary null annotations should not be
	 *    used in the project's own source code.</p>
	 * <p>JDT will never actively use any secondary annotation names from this list,
	 *    i.e., inferred null annotations and content assist proposals mentioning null annotations
	 *    are always rendered using the primary name from {@link #COMPILER_NULLABLE_ANNOTATION_NAME}.</p>
	 * <p>This option only has an effect if the option {@link #COMPILER_ANNOTATION_NULL_ANALYSIS} is enabled.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.annotation.nullable.secondary"</code></dd>
	 * <dt>Possible values:</dt><dd>a comma-separated list of legal, fully qualified Java type names;
	 *     each name in the list must resolve to an annotation type.</dd>
	 * <dt>Default:</dt><dd><code>""</code></dd>
	 * </dl>
	 * @since 3.12
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_NULLABLE_ANNOTATION_SECONDARY_NAMES = PLUGIN_ID + ".compiler.annotation.nullable.secondary"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Name of Annotation Type for Non-Null Types.
	 * <p>This option defines a fully qualified Java type name that the compiler may use
	 *    to perform special null analysis.</p>
	 * <p>If the annotation specified by this option is applied to a type in a method
	 *    signature or variable declaration, this will be interpreted as a specification
	 *    that <code>null</code> is <b>not</b> a legal value in that position. Currently
	 *    supported positions are: method parameters, method return type, fields and local variables.</p>
	 * <p>For values declared with this annotation, the compiler will never trigger a null
	 *    reference diagnostic (as controlled by {@link #COMPILER_PB_POTENTIAL_NULL_REFERENCE}
	 *    and {@link #COMPILER_PB_NULL_REFERENCE}), because the assumption is made that null
	 *    will never occur at runtime in these positions.</p>
	 * <p>The compiler may furthermore check adherence to the null specification as further
	 *    controlled by {@link #COMPILER_PB_NULL_SPECIFICATION_VIOLATION},
	 *    {@link #COMPILER_PB_NULL_ANNOTATION_INFERENCE_CONFLICT} and
	 *    {@link #COMPILER_PB_NULL_UNCHECKED_CONVERSION}.</p>
	 * <p>This option only has an effect if the option {@link #COMPILER_ANNOTATION_NULL_ANALYSIS} is enabled.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.annotation.nonnull"</code></dd>
	 * <dt>Possible values:</dt><dd>any legal, fully qualified Java type name; must resolve to an annotation type.</dd>
	 * <dt>Default:</dt><dd><code>"org.eclipse.jdt.annotation.NonNull"</code></dd>
	 * </dl>
	 * @since 3.8
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_NONNULL_ANNOTATION_NAME = PLUGIN_ID + ".compiler.annotation.nonnull"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Names of Secondary Annotation Types for Non-Null Types.
	 * <p>This option defines a comma-separated list of fully qualified Java type names
	 *    that the compiler may use to perform special null analysis.</p>
	 * <p>The annotation types identified by the names in this list are interpreted in the same way
	 *    as the annotation identified by {@link #COMPILER_NONNULL_ANNOTATION_NAME}.
	 *    The intention is to support libraries using different sets of null annotations,
	 *    in addition to those used by the current project. Secondary null annotations should not be
	 *    used in the project's own source code.</p>
	 * <p>JDT will never actively use any secondary annotation names from this list,
	 *    i.e., inferred null annotations and content assist proposals mentioning null annotations
	 *    are always rendered using the primary name from {@link #COMPILER_NONNULL_ANNOTATION_NAME}.</p>
	 * <p>This option only has an effect if the option {@link #COMPILER_ANNOTATION_NULL_ANALYSIS} is enabled.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.annotation.nonnull.secondary"</code></dd>
	 * <dt>Possible values:</dt><dd>a comma-separated list of legal, fully qualified Java type names;
	 *     each name in the list must resolve to an annotation type.</dd>
	 * <dt>Default:</dt><dd><code>""</code></dd>
	 * </dl>
	 * @since 3.12
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_NONNULL_ANNOTATION_SECONDARY_NAMES = PLUGIN_ID + ".compiler.annotation.nonnull.secondary"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Name of Annotation Type to specify a nullness default for unannotated types.
	 * <p>This option defines a fully qualified Java type name that the compiler may use
	 *    to perform special null analysis.</p>
	 * <p>If the annotation is applied without an argument, all unannotated types in method signatures
	 *    and field declarations within the annotated element will be treated as if they were specified
	 *    with the non-null annotation (see {@link #COMPILER_NONNULL_ANNOTATION_NAME}).</p>
	 * <p>If the annotation is applied with the constant <code>false</code> as its argument
	 *    all corresponding defaults at outer scopes will be canceled for the annotated element.</p>
	 * <p>This option only has an effect if the option {@link #COMPILER_ANNOTATION_NULL_ANALYSIS} is enabled.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.annotation.nonnullbydefault"</code></dd>
	 * <dt>Possible values:</dt><dd>any legal, fully qualified Java type name; must resolve to an annotation type.
	 *     That annotation type should have exactly one boolean parameter.</dd>
	 * <dt>Default:</dt><dd><code>"org.eclipse.jdt.annotation.NonNullByDefault"</code></dd>
	 * </dl>
	 * @since 3.8
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_NONNULL_BY_DEFAULT_ANNOTATION_NAME = PLUGIN_ID + ".compiler.annotation.nonnullbydefault"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Names of Secondary Annotation Types to specify a nullness default for unannotated types.
	 * <p>This option defines a comma-separated list of fully qualified Java type names
	 *    that the compiler may use to perform special null analysis.</p>
	 * <p>The annotation types identified by the names in this list are interpreted in the same way
	 *    as the annotation identified by {@link #COMPILER_NONNULL_BY_DEFAULT_ANNOTATION_NAME}.
	 *    The intention is to support libraries using different sets of null annotations,
	 *    in addition to those used by the current project. Secondary null annotations should not be
	 *    used in the project's own source code.</p>
	 * <p>This option only has an effect if the option {@link #COMPILER_ANNOTATION_NULL_ANALYSIS} is enabled.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.annotation.nonnullbydefault.secondary"</code></dd>
	 * <dt>Possible values:</dt><dd>a comma-separated list of legal, fully qualified Java type names;
	 *     each name in the list must resolve to an annotation type.</dd>
	 * <dt>Default:</dt><dd><code>""</code></dd>
	 * </dl>
	 * @since 3.12
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_NONNULL_BY_DEFAULT_ANNOTATION_SECONDARY_NAMES = PLUGIN_ID + ".compiler.annotation.nonnullbydefault.secondary"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting missing default nullness annotation.
	 * <p>When enabled, the compiler will issue an error or a warning in the following cases:</p>
	 * <ul>
	 * <li> When a package does not contain a default nullness annotation, as a result of missing package-info.java 
	 * or missing default nullness annotation in package-info.java.</li>
	 * <li> When a type inside a default package does not contain a default nullness annotation.</li>
	 * </ul>
	 * <p>This option only has an effect if the option {@link #COMPILER_ANNOTATION_NULL_ANALYSIS} is enabled.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.annotation.missingNonNullByDefaultAnnotation"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code>.</dd>
	 * <dt>Default:</dt><dd><code>"ignore"</code></dd>
	 * </dl>
	 * @since 3.8
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_MISSING_NONNULL_BY_DEFAULT_ANNOTATION = PLUGIN_ID + ".compiler.annotation.missingNonNullByDefaultAnnotation"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Violations of Null Specifications.
	 * <p>Depending on this option, the compiler will issue either an error or a warning
	 *    whenever one of the following situations is detected:</p>
	 *    <ol>
	 *    <li>A method declared with a nonnull annotation returns a
	 *        <em>nullable</em> expression.</li>
	 *    <li>A <em>nullable</em> expression is passed
     *        as an argument in a method call where the corresponding parameter of the called
     *        method is declared with a nonnull annotation.</li>
	 *    <li>A <em>nullable</em> expression is assigned
     *        to a local variable that is declared with a nonnull annotation.</li>
	 *    <li>A method that overrides an inherited method declared with a nonnull annotation
	 *        tries to relax that contract by specifying a nullable annotation
	 *        (prohibition of contravariant return).</li>
	 *    <li>A method that overrides an inherited method which has a nullable declaration
	 *        for at least one of its parameters, tries to tighten that null contract by
	 *        specifying a nonnull annotation for its corresponding parameter
	 *        (prohibition of covariant parameters).</li>
	 *    <li>A non-static field with a nonnull annotation is not definitely assigned at
	 *        the end of each constructor.</li>
	 *    <li>A static field with a nonnull annotation is not definitely assigned in static initializers.</li>
	 *    </ol>
	 *    In the above an expression is considered as <em>nullable</em> if
	 *    either it is statically known to evaluate to the value <code>null</code>, or if it is
	 *    declared with a nullable annotation.
	 * <p>The compiler options {@link #COMPILER_NONNULL_ANNOTATION_NAME} and
	 *    {@link #COMPILER_NULLABLE_ANNOTATION_NAME} control which annotations the compiler
	 *    shall interpret as nonnull or nullable annotations, respectively.
	 * </p>
	 * <p>This option only has an effect if the option {@link #COMPILER_ANNOTATION_NULL_ANALYSIS} is enabled.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.nullSpecViolation"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning" }</code></dd>
	 * <dt>Default:</dt><dd><code>"error"</code></dd>
	 * </dl>
	 * @since 3.8
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_NULL_SPECIFICATION_VIOLATION = PLUGIN_ID + ".compiler.problem.nullSpecViolation"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting conflicts between declared null annotation and inferred null value 
	 * <p>When enabled, the compiler will issue an error or a warning whenever one of the
	 *    following situations is detected:</p>
	 *    <ol>
	 *    <li>A method declared with a nonnull annotation returns an expression that is
	 *          statically known to evaluate to a null value on some flow.</li>
	 *    <li>An expression that is statically known to evaluate to a null value on some flow
	 *        is passed as an argument in a method call where the corresponding parameter of
	 *        the called method is declared with a nonnull annotation.</li>
	 *    <li>An expression that is statically known to evaluate to a null value on some flow
	 *        is assigned to a local variable that is declared with a nonnull annotation.</li>
	 *    </ol>
	 * <p>The compiler options {@link #COMPILER_NONNULL_ANNOTATION_NAME} and
	 *    {@link #COMPILER_NULLABLE_ANNOTATION_NAME} control which annotations the compiler
	 *    shall interpret as nonnull or nullable annotations, respectively.
	 * </p>
	 * <p>This option only has an effect if the option {@link #COMPILER_ANNOTATION_NULL_ANALYSIS} is enabled.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.nullAnnotationInferenceConflict"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"error"</code></dd>
	 * </dl>
	 * @since 3.8
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_NULL_ANNOTATION_INFERENCE_CONFLICT = PLUGIN_ID + ".compiler.problem.nullAnnotationInferenceConflict"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting unchecked conversion from a type with unknown nullness to a null annotated type
	 * <p>When enabled, the compiler will issue an error or a warning whenever one of the
	 *    following situations is detected:</p>
	 *    <ol>
	 *    <li>A method declared with a nonnull annotation returns an expression for which
	 *        insufficient nullness information is available for statically proving that no
	 *        flow will pass a null value at runtime.</li>
	 *    <li>An expression for which insufficient nullness information is available for
	 *        statically proving that it will never evaluate to a null value at runtime
	 *        is passed as an argument in a method call where the corresponding parameter of
	 *        the called method is declared with a nonnull annotation.</li>
	 *    <li>An expression for which insufficient nullness information is available for
	 *        statically proving that it will never evaluate to a null value at runtime
	 *        is assigned to a local variable that is declared with a nonnull annotation.</li>
	 *    </ol>
	 * <p>Unchecked null conversion is usually a consequence of using other unannotated
	 *    variables or methods.</p>
	 * <p>The compiler options {@link #COMPILER_NONNULL_ANNOTATION_NAME} and
	 *    {@link #COMPILER_NULLABLE_ANNOTATION_NAME} control which annotations the compiler
	 *    shall interpret as nonnull or nullable annotations, respectively.
	 * </p>
	 * <p>This option only has an effect if the option {@link #COMPILER_ANNOTATION_NULL_ANALYSIS} is enabled.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.nullUncheckedConversion"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"warning"</code></dd>
	 * </dl>
	 * @since 3.8
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_NULL_UNCHECKED_CONVERSION = PLUGIN_ID + ".compiler.problem.nullUncheckedConversion"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting problems detected by pessimistic null analysis for free type variables.
	 * <p>Unless set to <code>"ignore"</code>, type variables not affected by any explicit null annotation are pessimistically analyzed
	 * in two directions: When reading a value of this type, it is assumed to be nullable. When this type appears as the required type
	 * (i.e., at the left hand side of an assignment or variable initialization, or as the method return type against which a return statement
	 * is being checked) the type is considered to require the nonnull property.</p>
	 * <p>Problems reported due to this pessimistic analysis are reported with the level given in this option.</p>
	 * @since 3.12
	 * @category CompilerOptionID
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.pessimisticNullAnalysisForFreeTypeVariables"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"warning"</code></dd>
	 * </dl>
	 */
	public static final String COMPILER_PB_PESSIMISTIC_NULL_ANALYSIS_FOR_FREE_TYPE_VARIABLES = PLUGIN_ID + ".compiler.problem.pessimisticNullAnalysisForFreeTypeVariables"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Redundant Null Annotations.
	 * <p>When enabled, the compiler will issue an error or a warning when a non-null annotation
	 *    (see {@link #COMPILER_NONNULL_ANNOTATION_NAME})
	 *    is applied although the same effect is already achieved by a default applicable at the
	 *    current location. Such a default may be set by using the annotation specified by the option
	 *    {@link #COMPILER_NONNULL_BY_DEFAULT_ANNOTATION_NAME}.
	 * </p>
	 * <p>This option only has an effect if the option {@link #COMPILER_ANNOTATION_NULL_ANALYSIS} is enabled.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.redundantNullAnnotation"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"warning"</code></dd>
	 * </dl>
	 * @since 3.8
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_REDUNDANT_NULL_ANNOTATION = PLUGIN_ID + ".compiler.problem.redundantNullAnnotation"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Perform syntactic null analysis for fields.
	 * <p>When enabled, the compiler will detect certain syntactic constellations where a null
	 *	  related warning against a field reference would normally be raised but can be suppressed
	 *    at low risk given that the same field reference was known to be non-null immediately before.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.syntacticNullAnalysisForFields"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "disabled", "enabled" }</code></dd>
	 * <dt>Default:</dt><dd><code>"disabled"</code></dd>
	 * </dl>
	 * @since 3.9
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_SYNTACTIC_NULL_ANALYSIS_FOR_FIELDS = JavaCore.PLUGIN_ID+".compiler.problem.syntacticNullAnalysisForFields"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Inheritance of null annotations.
	 * <p>When enabled, the compiler will check for each method without any explicit null annotations:
	 *    If it overrides a method which has null annotations, it will treat the
	 *    current method as if it had the same annotations as the overridden method.</p>
	 * <p>Annotation inheritance will use the <em>effective</em> nullness of the overridden method
	 *    after transitively applying inheritance and after applying any default nullness
	 *    (see {@link #COMPILER_NONNULL_BY_DEFAULT_ANNOTATION_NAME}) at the site of the overridden method.</p>
	 * <p>If different implicit null annotations (from a nonnull default and/or overridden methods) are applicable
	 *    to the same type in a method signature, this is flagged as an error 
	 *    and an explicit null annotation must be used to disambiguate.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.annotation.inheritNullAnnotations"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "disabled", "enabled" }</code></dd>
	 * <dt>Default:</dt><dd><code>"disabled"</code></dd>
	 * </dl>
	 * @since 3.9
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_INHERIT_NULL_ANNOTATIONS = JavaCore.PLUGIN_ID+".compiler.annotation.inheritNullAnnotations"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Dropped Nonnull Parameter Annotations.
	 * <p>When enabled, the compiler will issue an error or a warning against a parameter of 
	 *    a method that overrides an inherited method
	 *    if all of the following hold:</p>
	 * <ul>
	 *    <li>The overridden method declares the corresponding parameter as non-null (see {@link #COMPILER_NONNULL_ANNOTATION_NAME}).</li>
	 *    <li>The parameter in the overriding method has no null annotation.</li>
	 *    <li>The overriding method is not affected by a nullness default (see {@link #COMPILER_NONNULL_BY_DEFAULT_ANNOTATION_NAME}).</li>
	 *    <li>Inheritance of null annotations is disabled (see {@link #COMPILER_INHERIT_NULL_ANNOTATIONS}).</li>
	 * </ul>
	 * <p>This particular situation bears the same inherent risk as any unannotated method parameter,
	 *    because the compiler's null ananysis cannot decide wither <code>null</code> is or is not a legal value for this parameter.
	 *    However, the annotation in the overridden method <em>suggests</em> that the parameter should also be annotated as non-null.
	 *    If that is not intended or possible, it is recommended to annotate the parameter as nullable,
	 *    in order to make this (legal) change of contract explicit.</p>   
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.nonnullParameterAnnotationDropped"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"warning"</code></dd>
	 * </dl>
	 * @since 3.9
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_NONNULL_PARAMETER_ANNOTATION_DROPPED = JavaCore.PLUGIN_ID+".compiler.problem.nonnullParameterAnnotationDropped"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Unsafe NonNull Interpretation Of Type Variables.
	 * <p>When enabled, the compiler will issue an error or a warning against a method call
	 *    if all of the following hold:</p>
	 * <ul>
	 *    <li>The method's declared return type is a type variable without any null annotation.</li>
	 *    <li>For the given invocation this type variable is substituted with a nonnull type.</li>
	 *    <li>The type declaring the method is provided by a third-party library.</li>
	 *    <li>No null annotations exist for this library type, neither in its class file nor using external annotations.</li>
	 * </ul>
	 * <p>This particular situation leverages the option to consistently substitute all occurrences of a type variable
	 *  with a nonnull type, but it bears the risk that the library type may not be aware of null annotations thus lacking
	 *  a necessary <code>@Nullable</code> annotation for a particular occurrence of a type variable.</p>   
	 * <p>This option only has an effect if the option {@link #COMPILER_ANNOTATION_NULL_ANALYSIS} is enabled and when
	 *  the configured set of null annotations declares the target <code>TYPE_USE</code></p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.nonnullTypeVariableFromLegacyInvocation"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"warning"</code></dd>
	 * </dl>
	 * @since 3.12
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_NONNULL_TYPEVAR_FROM_LEGACY_INVOCATION = JavaCore.PLUGIN_ID+".compiler.problem.nonnullTypeVariableFromLegacyInvocation"; //$NON-NLS-1$

	/**
	 * Compiler option ID: Setting Source Compatibility Mode.
	 * <p>Specify whether which source level compatibility is used. From 1.4 on, <code>'assert'</code> is a keyword
	 *    reserved for assertion support. Also note, than when toggling to 1.4 mode, the target VM
	 *    level should be set to <code>"1.4"</code> and the compliance mode should be <code>"1.4"</code>.</p>
	 * <p>Source level 1.5 is necessary to enable generics, autoboxing, covariance, annotations, enumerations
	 *    enhanced for loop, static imports and varargs.</p>
	 * <p>In source levels <code>"1.5"</code> and higher, the compliance and target settings should be
	 *    set to the same version as the source level.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.source"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "1.3", "1.4", "1.5", "1.6", "1.7", "1.8" }</code></dd>
	 * <dt>Default:</dt><dd><code>"1.3"</code></dd>
	 * </dl>
	 * @since 2.0
	 * @category CompilerOptionID
	 * @see #COMPILER_COMPLIANCE
	 * @see #COMPILER_CODEGEN_TARGET_PLATFORM
	 * @see #setComplianceOptions(String, Map)
	 */
	public static final String COMPILER_SOURCE = PLUGIN_ID + ".compiler.source"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Setting Compliance Level.
	 * <p>Select the compliance level for the compiler.
	 *    {@link #COMPILER_SOURCE} and {@link #COMPILER_CODEGEN_TARGET_PLATFORM} settings cannot be
	 *    higher than the compiler compliance level. In <code>"1.5"</code> and higher compliance, source and target settings
	 *    should match the compliance setting.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.compliance"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "1.3", "1.4", "1.5", "1.6", "1.7", "1.8" }</code></dd>
	 * <dt>Default:</dt><dd><code>"1.4"</code></dd>
	 * </dl>
	 * @since 2.0
	 * @category CompilerOptionID
	 * @see #COMPILER_SOURCE
	 * @see #COMPILER_CODEGEN_TARGET_PLATFORM
	 * @see #setComplianceOptions(String, Map)
	 */
	public static final String COMPILER_COMPLIANCE = PLUGIN_ID + ".compiler.compliance"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Defining the Automatic Task Priorities.
	 * <p>In parallel with the Automatic Task Tags, this list defines the priorities (high, normal or low)
	 *    of the task markers issued by the compiler.
	 *    If the default is specified, the priority of each task marker is <code>"NORMAL"</code>.</p>
	 * <p>Task Priorities and task tags must have the same length. If task priorities are set, then task tags should also
	 * be set.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.taskPriorities"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "&lt;priority&gt;[,&lt;priority&gt;]*" }</code> where <code>&lt;priority&gt;</code> is one of <code>"HIGH"</code>, <code>"NORMAL"</code> or <code>"LOW"</code></dd>
	 * <dt>Default:</dt><dd><code>"NORMAL,HIGH,NORMAL"</code></dd>
	 * </dl>
	 * @since 2.1
	 * @category CompilerOptionID
	 * @see #COMPILER_TASK_TAGS
	 */
	public static final String COMPILER_TASK_PRIORITIES = PLUGIN_ID + ".compiler.taskPriorities"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Defining the Automatic Task Tags.
	 * <p>When the tag list is not empty, the compiler will issue a task marker whenever it encounters
	 *    one of the corresponding tags inside any comment in Java source code.</p>
	 * <p>Generated task messages will start with the tag, and range until the next line separator,
	 *    comment ending, or tag.</p>
	 * <p>When a given line of code bears multiple tags, each tag will be reported separately.
	 *    Moreover, a tag immediately followed by another tag will be reported using the contents of the
	 *    next non-empty tag of the line, if any.</p>
	 * <p>Note that tasks messages are trimmed. If a tag is starting with a letter or digit, then it cannot be leaded by
	 *    another letter or digit to be recognized (<code>"fooToDo"</code> will not be recognized as a task for tag <code>"ToDo"</code>, but <code>"foo#ToDo"</code>
	 *    will be detected for either tag <code>"ToDo"</code> or <code>"#ToDo"</code>). Respectively, a tag ending with a letter or digit cannot be followed
	 *    by a letter or digit to be recognized (<code>"ToDofoo"</code> will not be recognized as a task for tag <code>"ToDo"</code>, but <code>"ToDo:foo"</code> will
	 *    be detected either for tag <code>"ToDo"</code> or <code>"ToDo:"</code>).</p>
	 * <p>Task Priorities and task tags must have the same length. If task tags are set, then task priorities should also
	 * be set.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.taskTags"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "&lt;tag&gt;[,&lt;tag&gt;]*" }</code> where <code>&lt;tag&gt;</code> is a String without any wild-card or leading/trailing spaces</dd>
	 * <dt>Default:</dt><dd><code>"TODO,FIXME,XXX"</code></dd>
	 * </dl>
	 * @since 2.1
	 * @category CompilerOptionID
	 * @see #COMPILER_TASK_PRIORITIES
	 */
	public static final String COMPILER_TASK_TAGS = PLUGIN_ID + ".compiler.taskTags"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Determining whether task tags are case-sensitive.
	 * <p>When enabled, task tags are considered in a case-sensitive way.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.taskCaseSensitive"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "enabled", "disabled" }</code></dd>
	 * <dt>Default:</dt><dd><code>"enabled"</code></dd>
	 * </dl>
	 * @since 3.0
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_TASK_CASE_SENSITIVE = PLUGIN_ID + ".compiler.taskCaseSensitive"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Forbidden Reference to Type with Restricted Access.
	 * <p>When enabled, the compiler will issue an error or a warning when referring to a type that is non accessible, as defined according
	 *    to the access rule specifications.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.forbiddenReference"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"error"</code></dd>
	 * </dl>
	 * @since 3.1
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_FORBIDDEN_REFERENCE = PLUGIN_ID + ".compiler.problem.forbiddenReference"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Discouraged Reference to Type with Restricted Access.
	 * <p>When enabled, the compiler will issue an error or a warning when referring to a type with discouraged access, as defined according
	 *    to the access rule specifications.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.discouragedReference"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"warning"</code></dd>
	 * </dl>
	 * @since 3.1
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_DISCOURAGED_REFERENCE = PLUGIN_ID + ".compiler.problem.discouragedReference"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Determining Effect of <code>@SuppressWarnings</code>.
	 * <p>When enabled, the <code>@SuppressWarnings</code> annotation can be used to suppress some compiler warnings.</p>
	 * <p>When disabled, all <code>@SupressWarnings</code> annotations are ignored; i.e., warnings are reported.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.suppressWarnings"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "enabled", "disabled" }</code></dd>
	 * <dt>Default:</dt><dd><code>"enabled"</code></dd>
	 * </dl>
	 * @since 3.1
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_SUPPRESS_WARNINGS = PLUGIN_ID + ".compiler.problem.suppressWarnings"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Raise null related errors or warnings arising because of assert statements.
	 * <p>When enabled, the compiler will flag all null related errors or warnings that have been enabled by the user,
	 *    irrespective of whether a variable occurred in an assert statement.</p>
	 * <p>When disabled, the compiler will not flag null related errors or warnings on variables that got marked as maybe or definitely
	 *    <code>null</code> in an assert statement upstream.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.includeNullInfoFromAsserts"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "enabled", "disabled" }</code></dd>
	 * <dt>Default:</dt><dd><code>"disabled"</code></dd>
	 * </dl>
	 * @since 3.7
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_INCLUDE_ASSERTS_IN_NULL_ANALYSIS = PLUGIN_ID + ".compiler.problem.includeNullInfoFromAsserts"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Further Determining the Effect of <code>@SuppressWarnings</code> if also
	 * {@link #COMPILER_PB_SUPPRESS_WARNINGS} is enabled.
	 * <p>When enabled, the <code>@SuppressWarnings</code> annotation can additionally be used to suppress 
	 * optional compiler diagnostics that have been configured as {@link #ERROR}.</p>
	 * <p>When disabled, all <code>@SuppressWarnings</code> annotations only affects warnings.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.suppressOptionalErrors"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "enabled", "disabled" }</code></dd>
	 * <dt>Default:</dt><dd><code>"disabled"</code></dd>
	 * </dl>
	 * @since 3.6
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_SUPPRESS_OPTIONAL_ERRORS = PLUGIN_ID + ".compiler.problem.suppressOptionalErrors"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Unhandled Warning Token for <code>@SuppressWarnings</code>.
	 * <p>When enabled, the compiler will issue an error or a warning when encountering a token
	 *    it cannot handle inside a <code>@SuppressWarnings</code> annotation.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.unhandledWarningToken"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"warning"</code></dd>
	 * </dl>
	 * @since 3.1
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_UNHANDLED_WARNING_TOKEN = PLUGIN_ID + ".compiler.problem.unhandledWarningToken"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Unnecessary <code>@SuppressWarnings</code>.
	 * <p>When enabled, the compiler will issue an error or a warning when encountering <code>@SuppressWarnings</code> annotation
	 *    for which no corresponding warning got detected in the code. This diagnostic is provided to help developers to get
	 *    rid of transient <code>@SuppressWarnings</code> no longer needed. Note that <code>@SuppressWarnings("all")</code> is still
	 *    silencing the warning for unnecessary <code>@SuppressWarnings</code>, as it is the master switch to silence ALL warnings.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.unusedWarningToken"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"warning"</code></dd>
	 * </dl>
	 * @since 3.4
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_UNUSED_WARNING_TOKEN = PLUGIN_ID + ".compiler.problem.unusedWarningToken"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Null Dereference.
	 * <p>When enabled, the compiler will issue an error or a warning whenever a
	 *    variable that is statically known to hold a null value is used to
	 *    access a field or method.</p>
	 * <p>Assert statements are ignored unless {@link #COMPILER_PB_INCLUDE_ASSERTS_IN_NULL_ANALYSIS}
	 *    is enabled.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.nullReference"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"warning"</code></dd>
	 * </dl>
	 * @since 3.2
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_NULL_REFERENCE = PLUGIN_ID + ".compiler.problem.nullReference"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Potential Null Dereference.
	 * <p>When enabled, the compiler will issue an error or a warning whenever a
	 *    variable that has formerly been tested against null but is not (no more)
	 *    statically known to hold a non-null value is used to access a field or
	 *    method.</p>
	 * <p>Assert statements are ignored unless {@link #COMPILER_PB_INCLUDE_ASSERTS_IN_NULL_ANALYSIS}
	 *    is enabled.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.potentialNullReference"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"ignore"</code></dd>
	 * </dl>
	 * @since 3.3
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_POTENTIAL_NULL_REFERENCE = PLUGIN_ID + ".compiler.problem.potentialNullReference"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Redundant Null Check.
	 * <p>When enabled, the compiler will issue an error or a warning whenever a
	 *    variable that is statically known to hold a null or a non-null value
	 *    is tested against null.</p>
	 * <p>Assert statements are ignored unless {@link #COMPILER_PB_INCLUDE_ASSERTS_IN_NULL_ANALYSIS}
	 *    is enabled.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.redundantNullCheck"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"ignore"</code></dd>
	 * </dl>
	 * @since 3.3
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_REDUNDANT_NULL_CHECK = PLUGIN_ID + ".compiler.problem.redundantNullCheck"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Overriding method that doesn't call the super method invocation.
	 * <p>When enabled, the compiler will issue an error or a warning if a method is overriding a method without calling
	 *    the super invocation.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.overridingMethodWithoutSuperInvocation"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"ignore"</code></dd>
	 * </dl>
	 * @since 3.3
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_OVERRIDING_METHOD_WITHOUT_SUPER_INVOCATION = PLUGIN_ID + ".compiler.problem.overridingMethodWithoutSuperInvocation"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Redundant Superinterface.
	 * <p>When enabled, the compiler will issue an error or a warning if a type
	 *    explicitly implements an interface that is already implemented by any
	 *    of its supertypes.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.redundantSuperinterface"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"ignore"</code></dd>
	 * </dl>
	 * @since 3.4
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_REDUNDANT_SUPERINTERFACE = PLUGIN_ID + ".compiler.problem.redundantSuperinterface"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Comparison of Identical Expressions.
	 * <p>When enabled, the compiler will issue an error or a warning if a comparison
	 * is involving identical operands (e.g <code>'x == x'</code>).</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.comparingIdentical"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"warning"</code></dd>
	 * </dl>
	 * @since 3.5
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_COMPARING_IDENTICAL = PLUGIN_ID + ".compiler.problem.comparingIdentical"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Missing Synchronized Modifier On Inherited Method.
	 * <p>When enabled, the compiler will issue an error or a warning if a method
	 * overrides a synchronized method without having a synchronized modifier.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.missingSynchronizedOnInheritedMethod"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"ignore"</code></dd>
	 * </dl>
	 * @since 3.5
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_MISSING_SYNCHRONIZED_ON_INHERITED_METHOD = PLUGIN_ID + ".compiler.problem.missingSynchronizedOnInheritedMethod"; //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting Allocation of an Unused Object.
	 * <p>When enabled, the compiler will issue an error or a warning if an object is allocated but never used,
	 * neither by holding a reference nor by invoking one of the object's methods.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.unusedObjectAllocation"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"ignore"</code></dd>
	 * </dl>
	 * @since 3.6
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_UNUSED_OBJECT_ALLOCATION = PLUGIN_ID + ".compiler.problem.unusedObjectAllocation";  //$NON-NLS-1$
	/**
	 * Compiler option ID: Reporting redundant specification of type arguments in class instance creation expressions.
	 * <p>When enabled, the compiler will issue an error or a warning if type arguments are used in a class instance creation,
	 * when the '&lt;&gt;' operator can be used instead.</p>
	 * <p>This option only has an effect if the compiler compliance is 1.7 or greater.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.compiler.problem.redundantSpecificationOfTypeArguments"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "info", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"ignore"</code></dd>
	 * </dl>
	 * @since 3.7.1
	 * @category CompilerOptionID
	 */
	public static final String COMPILER_PB_REDUNDANT_TYPE_ARGUMENTS = PLUGIN_ID + ".compiler.problem.redundantSpecificationOfTypeArguments";  //$NON-NLS-1$
	/**
	 * Core option ID: Computing Project Build Order.
	 * <p>Indicate whether JavaCore should enforce the project build order to be based on
	 *    the classpath prerequisite chain. When requesting to compute, this takes over
	 *    the platform default order (based on project references).</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.computeJavaBuildOrder"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "compute", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"ignore"</code></dd>
	 * </dl>
	 * @category CoreOptionID
	 */
	public static final String CORE_JAVA_BUILD_ORDER = PLUGIN_ID + ".computeJavaBuildOrder"; //$NON-NLS-1$
	/**
	 * Core option ID: Specifying Filters for Resource Copying Control.
	 * <p>Allow to specify some filters to control the resource copy process.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.builder.resourceCopyExclusionFilter"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "&lt;name&gt;[,&lt;name&gt;]* }</code> where <code>&lt;name&gt;</code> is a file name pattern (* and ? wild-cards allowed)
	 *	   or the name of a folder which ends with <code>'/'</code></dd>
	 * <dt>Default:</dt><dd><code>""</code></dd>
	 * </dl>
	 * @since 2.0
	 * @category CoreOptionID
	 */
	public static final String CORE_JAVA_BUILD_RESOURCE_COPY_FILTER = PLUGIN_ID + ".builder.resourceCopyExclusionFilter"; //$NON-NLS-1$
	/**
	 * Core option ID: Reporting Duplicate Resources.
	 * <p>Indicate the severity of the problem reported when more than one occurrence
	 *    of a resource is to be copied into the output location.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.builder.duplicateResourceTask"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning" }</code></dd>
	 * <dt>Default:</dt><dd><code>"warning"</code></dd>
	 * </dl>
	 * @since 2.1
	 * @category CoreOptionID
	 */
	public static final String CORE_JAVA_BUILD_DUPLICATE_RESOURCE = PLUGIN_ID + ".builder.duplicateResourceTask"; //$NON-NLS-1$
	/**
	 * Core option ID: Cleaning Output Folder(s).
	 * <p>Indicate whether the JavaBuilder is allowed to clean the output folders
	 *    when performing full build operations.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.builder.cleanOutputFolder"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "clean", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"clean"</code></dd>
	 * </dl>
	 * @since 2.1
	 * @category CoreOptionID
	 */
	public static final String CORE_JAVA_BUILD_CLEAN_OUTPUT_FOLDER = PLUGIN_ID + ".builder.cleanOutputFolder"; //$NON-NLS-1$
	/**
	 * Core option ID: Recreate Modified class files in Output Folder.
	 * <p>Indicate whether the JavaBuilder should check for any changes to .class files
	 *    in the output folders while performing incremental build operations. If changes
	 *    are detected to managed .class files, then a full build is performed, otherwise
	 *    the changes are left as is. Tools further altering generated .class files, like optimizers,
	 *    should ensure this option remains set in its default state of ignore.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.builder.recreateModifiedClassFileInOutputFolder"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "enabled", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"ignore"</code></dd>
	 * </dl>
	 * @since 3.2
	 * @category CoreOptionID
	 */
	public static final String CORE_JAVA_BUILD_RECREATE_MODIFIED_CLASS_FILES_IN_OUTPUT_FOLDER = PLUGIN_ID + ".builder.recreateModifiedClassFileInOutputFolder"; //$NON-NLS-1$
	/**
	 * Core option ID: Reporting Incomplete Classpath.
	 * <p>Indicate the severity of the problem reported when an entry on the classpath does not exist,
	 *    is not legitimate or is not visible (for example, a referenced project is closed).</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.incompleteClasspath"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning"}</code></dd>
	 * <dt>Default:</dt><dd><code>"error"</code></dd>
	 * </dl>
	 * @since 2.1
	 * @category CoreOptionID
	 */
	public static final String CORE_INCOMPLETE_CLASSPATH = PLUGIN_ID + ".incompleteClasspath"; //$NON-NLS-1$
	/**
	 * Core option ID: Reporting Classpath Cycle.
	 * <p>Indicate the severity of the problem reported when a project is involved in a cycle.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.circularClasspath"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning" }</code></dd>
	 * <dt>Default:</dt><dd><code>"error"</code></dd>
	 * </dl>
	 * @since 2.1
	 * @category CoreOptionID
	 */
	public static final String CORE_CIRCULAR_CLASSPATH = PLUGIN_ID + ".circularClasspath"; //$NON-NLS-1$
	/**
	 * Core option ID: Reporting Incompatible JDK Level for Required Binaries.
	 * <p>Indicate the severity of the problem reported when a project prerequisites another project
	 *    or library with an incompatible target JDK level (e.g. project targeting 1.1 vm, but compiled against 1.4 libraries).</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.incompatibleJDKLevel"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"ignore"</code></dd>
	 * </dl>
	 * @since 3.0
	 * @category CoreOptionID
	 */
	public static final String CORE_INCOMPATIBLE_JDK_LEVEL = PLUGIN_ID + ".incompatibleJDKLevel"; //$NON-NLS-1$
	/**
	 * Core option ID: Abort if Invalid Classpath.
	 * <p>Allow to toggle the builder to abort if the classpath is invalid.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.builder.invalidClasspath"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "abort", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"abort"</code></dd>
	 * </dl>
	 * @since 2.0
	 * @category CoreOptionID
	 */
	public static final String CORE_JAVA_BUILD_INVALID_CLASSPATH = PLUGIN_ID + ".builder.invalidClasspath"; //$NON-NLS-1$
	/**
	 * Core option ID: Default Source Encoding Format.
	 * <p>Get the default encoding format of source files. This value is
	 *    immutable and preset to the result of <code>ResourcesPlugin.getEncoding()</code>.</p>
	 * <p>It is offered as a convenience shortcut only.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.encoding"</code></dd>
	 * <dt>value:</dt><dd><code>&lt;immutable, platform default value&gt;</code></dd>
	 * </dl>
	 * @since 2.0
	 * @category CoreOptionID
	 */
	public static final String CORE_ENCODING = PLUGIN_ID + ".encoding"; //$NON-NLS-1$
	/**
	 * Core option ID: Enabling Usage of Classpath Exclusion Patterns.
	 * <p>When disabled, no entry on a project classpath can be associated with
	 *    an exclusion pattern.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.classpath.exclusionPatterns"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "enabled", "disabled" }</code></dd>
	 * <dt>Default:</dt><dd><code>"enabled"</code></dd>
	 * </dl>
	 * @since 2.1
	 * @category CoreOptionID
	 */
	public static final String CORE_ENABLE_CLASSPATH_EXCLUSION_PATTERNS = PLUGIN_ID + ".classpath.exclusionPatterns"; //$NON-NLS-1$
	/**
	 * Core option ID: Enabling Usage of Classpath Multiple Output Locations.
	 * <p>When disabled, no entry on a project classpath can be associated with
	 *    a specific output location, preventing thus usage of multiple output locations.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.classpath.multipleOutputLocations"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "enabled", "disabled" }</code></dd>
	 * <dt>Default:</dt><dd><code>"enabled"</code></dd>
	 * </dl>
	 * @since 2.1
	 * @category CoreOptionID
	 */
	public static final String CORE_ENABLE_CLASSPATH_MULTIPLE_OUTPUT_LOCATIONS = PLUGIN_ID + ".classpath.multipleOutputLocations"; //$NON-NLS-1$
	/**
	 * Core option ID: Reporting an output location overlapping another source location.
	 * <p> Indicate the severity of the problem reported when a source entry's output location overlaps another
	 * source entry.</p>
	 * 
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.classpath.outputOverlappingAnotherSource"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "error", "warning", "ignore" }</code></dd>
	 * <dt>Default:</dt><dd><code>"error"</code></dd>
	 * </dl>
	 * @since 3.6.4
	 */
	public static final String CORE_OUTPUT_LOCATION_OVERLAPPING_ANOTHER_SOURCE = PLUGIN_ID + ".classpath.outputOverlappingAnotherSource";  //$NON-NLS-1$
	/**
	 * Core option ID: Set the timeout value for retrieving the method's parameter names from javadoc.
	 * <p>Timeout in milliseconds to retrieve the method's parameter names from javadoc.</p>
	 * <p>If the value is <code>0</code>, the parameter names are not fetched and the raw names are returned.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.timeoutForParameterNameFromAttachedJavadoc"</code></dd>
	 * <dt>Possible values:</dt><dd><code>"&lt;n&gt;"</code>, where <code>n</code> is an integer greater than or equal to <code>0</code></dd>
	 * <dt>Default:</dt><dd><code>"50"</code></dd>
	 * </dl>
	 * @since 3.2
	 * @category CoreOptionID
	 */
	public static final String TIMEOUT_FOR_PARAMETER_NAME_FROM_ATTACHED_JAVADOC = PLUGIN_ID + ".timeoutForParameterNameFromAttachedJavadoc"; //$NON-NLS-1$

	/**
	 * Core option ID: The ID of the formatter to use in formatting operations.
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.javaFormatter"</code></dd>
	 * <dt>Default:</dt><dd><code>"org.eclipse.jdt.core.defaultJavaFormatter"</code></dd>
	 * </dl>
	 * @see #DEFAULT_JAVA_FORMATTER
	 * @see #JAVA_FORMATTER_EXTENSION_POINT_ID
	 * @since 3.11
	 * @category CoreOptionID
	 */
	public static final String JAVA_FORMATTER = PLUGIN_ID + ".javaFormatter"; //$NON-NLS-1$

	/**
	 * @since 2.0
	 * @deprecated Use {@link org.eclipse.jdt.core.formatter.DefaultCodeFormatterConstants#FORMATTER_BRACE_POSITION_FOR_ANONYMOUS_TYPE_DECLARATION},
	 * {@link org.eclipse.jdt.core.formatter.DefaultCodeFormatterConstants#FORMATTER_BRACE_POSITION_FOR_BLOCK} ,
	 * {@link org.eclipse.jdt.core.formatter.DefaultCodeFormatterConstants#FORMATTER_BRACE_POSITION_FOR_CONSTRUCTOR_DECLARATION},
	 * {@link org.eclipse.jdt.core.formatter.DefaultCodeFormatterConstants#FORMATTER_BRACE_POSITION_FOR_METHOD_DECLARATION},
	 * {@link org.eclipse.jdt.core.formatter.DefaultCodeFormatterConstants#FORMATTER_BRACE_POSITION_FOR_SWITCH},
	 * {@link org.eclipse.jdt.core.formatter.DefaultCodeFormatterConstants#FORMATTER_BRACE_POSITION_FOR_TYPE_DECLARATION} instead.
	 * @category DeprecatedOptionID
	 */
	public static final String FORMATTER_NEWLINE_OPENING_BRACE = PLUGIN_ID + ".formatter.newline.openingBrace"; //$NON-NLS-1$
	/**
	 * @since 2.0
	 * @deprecated Use {@link org.eclipse.jdt.core.formatter.DefaultCodeFormatterConstants#FORMATTER_INSERT_NEW_LINE_BEFORE_CATCH_IN_TRY_STATEMENT},
	 *  {@link org.eclipse.jdt.core.formatter.DefaultCodeFormatterConstants#FORMATTER_INSERT_NEW_LINE_BEFORE_ELSE_IN_IF_STATEMENT},
	 *  {@link org.eclipse.jdt.core.formatter.DefaultCodeFormatterConstants#FORMATTER_INSERT_NEW_LINE_BEFORE_FINALLY_IN_TRY_STATEMENT},
	 *  {@link org.eclipse.jdt.core.formatter.DefaultCodeFormatterConstants#FORMATTER_INSERT_NEW_LINE_BEFORE_WHILE_IN_DO_STATEMENT} instead.
	 * @category DeprecatedOptionID
	 */
	public static final String FORMATTER_NEWLINE_CONTROL = PLUGIN_ID + ".formatter.newline.controlStatement"; //$NON-NLS-1$
	/**
	 * @since 2.0
	 * @deprecated Use {@link org.eclipse.jdt.core.formatter.DefaultCodeFormatterConstants#FORMATTER_COMPACT_ELSE_IF} instead.
	 * @category DeprecatedOptionID
	 */
	public static final String FORMATTER_NEWLINE_ELSE_IF = PLUGIN_ID + ".formatter.newline.elseIf"; //$NON-NLS-1$
	/**
	 * @since 2.0
	 * @deprecated Use {@link org.eclipse.jdt.core.formatter.DefaultCodeFormatterConstants#FORMATTER_INSERT_NEW_LINE_IN_EMPTY_BLOCK} instead.
	 * @category DeprecatedOptionID
	 */
	public static final String FORMATTER_NEWLINE_EMPTY_BLOCK = PLUGIN_ID + ".formatter.newline.emptyBlock"; //$NON-NLS-1$
	/**
	 * @since 2.0
	 * @deprecated Use {@link org.eclipse.jdt.core.formatter.DefaultCodeFormatterConstants#FORMATTER_NUMBER_OF_EMPTY_LINES_TO_PRESERVE} instead.
	 * @category DeprecatedOptionID
	 */
	public static final String FORMATTER_CLEAR_BLANK_LINES = PLUGIN_ID + ".formatter.newline.clearAll"; //$NON-NLS-1$
	/**
	 * @since 2.0
	 * @deprecated Use {@link org.eclipse.jdt.core.formatter.DefaultCodeFormatterConstants#FORMATTER_LINE_SPLIT} instead
	 * @category DeprecatedOptionID
	 */
	public static final String FORMATTER_LINE_SPLIT = PLUGIN_ID + ".formatter.lineSplit"; //$NON-NLS-1$
	/**
	 * @since 2.0
	 * @deprecated Use {@link org.eclipse.jdt.core.formatter.DefaultCodeFormatterConstants#FORMATTER_INSERT_SPACE_BEFORE_ASSIGNMENT_OPERATOR} instead.
	 * @category DeprecatedOptionID
	 */
	public static final String FORMATTER_COMPACT_ASSIGNMENT = PLUGIN_ID + ".formatter.style.assignment"; //$NON-NLS-1$
	/**
	 * @since 2.0
	 * @deprecated Use {@link org.eclipse.jdt.core.formatter.DefaultCodeFormatterConstants#FORMATTER_TAB_CHAR} instead.
	 * @category DeprecatedOptionID
	 */
	public static final String FORMATTER_TAB_CHAR = PLUGIN_ID + ".formatter.tabulation.char"; //$NON-NLS-1$
	/**
	 * @since 2.0
	 * @deprecated Use {@link org.eclipse.jdt.core.formatter.DefaultCodeFormatterConstants#FORMATTER_TAB_SIZE} instead.
	 * @category DeprecatedOptionID
	 */
	public static final String FORMATTER_TAB_SIZE = PLUGIN_ID + ".formatter.tabulation.size"; //$NON-NLS-1$
	/**
	 * @since 2.1
	 * @deprecated Use {@link org.eclipse.jdt.core.formatter.DefaultCodeFormatterConstants#FORMATTER_INSERT_SPACE_AFTER_CLOSING_PAREN_IN_CAST} instead.
	 * @category DeprecatedOptionID
	 */
	public static final String FORMATTER_SPACE_CASTEXPRESSION = PLUGIN_ID + ".formatter.space.castexpression"; //$NON-NLS-1$
	/**
	 * Code assist option ID: Activate Visibility Sensitive Completion.
	 * <p>When active, completion doesn't show that you can not see
	 *    (for example, you can not see private methods of a super class).</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.codeComplete.visibilityCheck"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "enabled", "disabled" }</code></dd>
	 * <dt>Default:</dt><dd><code>"disabled"</code></dd>
	 * </dl>
	 * @since 2.0
	 * @category CodeAssistOptionID
	 */
	public static final String CODEASSIST_VISIBILITY_CHECK = PLUGIN_ID + ".codeComplete.visibilityCheck"; //$NON-NLS-1$
	/**
	 * Code assist option ID: Activate Deprecation Sensitive Completion.
	 * <p>When enabled, completion doesn't propose deprecated members and types.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.codeComplete.deprecationCheck"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "enabled", "disabled" }</code></dd>
	 * <dt>Default:</dt><dd><code>"disabled"</code></dd>
	 * </dl>
	 * @since 3.2
	 * @category CodeAssistOptionID
	 */
	public static final String CODEASSIST_DEPRECATION_CHECK = PLUGIN_ID + ".codeComplete.deprecationCheck"; //$NON-NLS-1$
	/**
	 * Code assist option ID: Activate Camel Case Sensitive Completion.
	 * <p>When enabled, completion shows proposals whose name match the CamelCase
	 *    pattern.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.codeComplete.camelCaseMatch"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "enabled", "disabled" }</code></dd>
	 * <dt>Default:</dt><dd><code>"enabled"</code></dd>
	 * </dl>
	 * @since 3.2
	 * @category CodeAssistOptionID
	 */
	public static final String CODEASSIST_CAMEL_CASE_MATCH = PLUGIN_ID + ".codeComplete.camelCaseMatch"; //$NON-NLS-1$
	/**
	 * Code assist option ID: Activate Substring Code Completion.
	 * <p>When enabled, completion shows proposals in which the pattern can
	 *    be found as a substring in a case-insensitive way.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.codeComplete.substringMatch"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "enabled", "disabled" }</code></dd>
	 * <dt>Default:</dt><dd><code>"enabled"</code></dd>
	 * </dl>
	 * @since 3.12
	 * @category CodeAssistOptionID
	 */
	public static final String CODEASSIST_SUBSTRING_MATCH = PLUGIN_ID + ".codeComplete.substringMatch"; //$NON-NLS-1$
	/**
	 * Code assist option ID: Automatic Qualification of Implicit Members.
	 * <p>When active, completion automatically qualifies completion on implicit
	 *    field references and message expressions.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.codeComplete.forceImplicitQualification"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "enabled", "disabled" }</code></dd>
	 * <dt>Default:</dt><dd><code>"disabled"</code></dd>
	 * </dl>
	 * @since 2.0
	 * @category CodeAssistOptionID
	 */
	public static final String CODEASSIST_IMPLICIT_QUALIFICATION = PLUGIN_ID + ".codeComplete.forceImplicitQualification"; //$NON-NLS-1$
	/**
	 * Code assist option ID: Define the Prefixes for Field Name.
	 * <p>When the prefixes is non empty, completion for field name will begin with
	 *    one of the proposed prefixes.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.codeComplete.fieldPrefixes"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "&lt;prefix&gt;[,&lt;prefix&gt;]*" }</code> where <code>&lt;prefix&gt;</code> is a String without any wild-card</dd>
	 * <dt>Default:</dt><dd><code>""</code></dd>
	 * </dl>
	 * @since 2.1
	 * @category CodeAssistOptionID
	 */
	public static final String CODEASSIST_FIELD_PREFIXES = PLUGIN_ID + ".codeComplete.fieldPrefixes"; //$NON-NLS-1$
	/**
	 * Code assist option ID: Define the Prefixes for Static Field Name.
	 * <p>When the prefixes is non empty, completion for static field name will begin with
	 *    one of the proposed prefixes.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.codeComplete.staticFieldPrefixes"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "&lt;prefix&gt;[,&lt;prefix&gt;]*" }</code> where <code>&lt;prefix&gt;</code> is a String without any wild-card</dd>
	 * <dt>Default:</dt><dd><code>""</code></dd>
	 * </dl>
	 * @since 2.1
	 * @category CodeAssistOptionID
	 */
	public static final String CODEASSIST_STATIC_FIELD_PREFIXES = PLUGIN_ID + ".codeComplete.staticFieldPrefixes"; //$NON-NLS-1$
	/**
	 * Code assist option ID: Define the Prefixes for Static Final Field Name.
	 * <p>When the prefixes is non empty, completion for static final field name will begin with
	 *    one of the proposed prefixes.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.codeComplete.staticFinalFieldPrefixes"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "&lt;prefix&gt;[,&lt;prefix&gt;]*" }</code> where <code>&lt;prefix&gt;</code> is a String without any wild-card</dd>
	 * <dt>Default:</dt><dd><code>""</code></dd>
	 * </dl>
	 * @since 3.5
	 * @category CodeAssistOptionID
	 */
	public static final String CODEASSIST_STATIC_FINAL_FIELD_PREFIXES = PLUGIN_ID + ".codeComplete.staticFinalFieldPrefixes"; //$NON-NLS-1$
	/**
	 * Code assist option ID: Define the Prefixes for Local Variable Name.
	 * <p>When the prefixes is non empty, completion for local variable name will begin with
	 *    one of the proposed prefixes.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.codeComplete.localPrefixes"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "&lt;prefix&gt;[,&lt;prefix&gt;]*" }</code> where <code>&lt;prefix&gt;</code> is a String without any wild-card</dd>
	 * <dt>Default:</dt><dd><code>""</code></dd>
	 * </dl>
	 * @since 2.1
	 * @category CodeAssistOptionID
	 */
	public static final String CODEASSIST_LOCAL_PREFIXES = PLUGIN_ID + ".codeComplete.localPrefixes"; //$NON-NLS-1$
	/**
	 * Code assist option ID: Define the Prefixes for Argument Name.
	 * <p>When the prefixes is non empty, completion for argument name will begin with
	 *    one of the proposed prefixes.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.codeComplete.argumentPrefixes"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "&lt;prefix&gt;[,&lt;prefix&gt;]*" }</code> where <code>&lt;prefix&gt;</code> is a String without any wild-card</dd>
	 * <dt>Default:</dt><dd><code>""</code></dd>
	 * </dl>
	 * @since 2.1
	 * @category CodeAssistOptionID
	 */
	public static final String CODEASSIST_ARGUMENT_PREFIXES = PLUGIN_ID + ".codeComplete.argumentPrefixes"; //$NON-NLS-1$
	/**
	 * Code assist option ID: Define the Suffixes for Field Name.
	 * <p>When the suffixes is non empty, completion for field name will end with
	 *    one of the proposed suffixes.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.codeComplete.fieldSuffixes"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "&lt;suffix&gt;[,&lt;suffix&gt;]*" }</code> where <code>&lt;suffix&gt;</code> is a String without any wild-card</dd>
	 * <dt>Default:</dt><dd><code>""</code></dd>
	 * </dl>
	 * @since 2.1
	 * @category CodeAssistOptionID
	 */
	public static final String CODEASSIST_FIELD_SUFFIXES = PLUGIN_ID + ".codeComplete.fieldSuffixes"; //$NON-NLS-1$
	/**
	 * Code assist option ID: Define the Suffixes for Static Field Name.
	 * <p>When the suffixes is non empty, completion for static field name will end with
	 *    one of the proposed suffixes.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.codeComplete.staticFieldSuffixes"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "&lt;suffix&gt;[,&lt;suffix&gt;]*" }</code>< where <code>&lt;suffix&gt;</code> is a String without any wild-card</dd>
	 * <dt>Default:</dt><dd><code>""</code></dd>
	 * </dl>
	 * @since 2.1
	 * @category CodeAssistOptionID
	 */
	public static final String CODEASSIST_STATIC_FIELD_SUFFIXES = PLUGIN_ID + ".codeComplete.staticFieldSuffixes"; //$NON-NLS-1$
	/**
	 * Code assist option ID: Define the Suffixes for Static Final Field Name.
	 * <p>When the suffixes is non empty, completion for static final field name will end with
	 *    one of the proposed suffixes.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.codeComplete.staticFinalFieldSuffixes"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "&lt;suffix&gt;[,&lt;suffix&gt;]*" }</code>< where <code>&lt;suffix&gt;</code> is a String without any wild-card</dd>
	 * <dt>Default:</dt><dd><code>""</code></dd>
	 * </dl>
	 * @since 3.5
	 * @category CodeAssistOptionID
	 */
	public static final String CODEASSIST_STATIC_FINAL_FIELD_SUFFIXES = PLUGIN_ID + ".codeComplete.staticFinalFieldSuffixes"; //$NON-NLS-1$
	/**
	 * Code assist option ID: Define the Suffixes for Local Variable Name.
	 * <p>When the suffixes is non empty, completion for local variable name will end with
	 *    one of the proposed suffixes.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.codeComplete.localSuffixes"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "&lt;suffix&gt;[,&lt;suffix&gt;]*" }</code> where <code>&lt;suffix&gt;</code> is a String without any wild-card</dd>
	 * <dt>Default:</dt><dd><code>""</code></dd>
	 * </dl>
	 * @since 2.1
	 * @category CodeAssistOptionID
	 */
	public static final String CODEASSIST_LOCAL_SUFFIXES = PLUGIN_ID + ".codeComplete.localSuffixes"; //$NON-NLS-1$
	/**
	 * Code assist option ID: Define the Suffixes for Argument Name.
	 * <p>When the suffixes is non empty, completion for argument name will end with
	 *    one of the proposed suffixes.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.codeComplete.argumentSuffixes"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "&lt;suffix&gt;[,&lt;suffix&gt;]*" }</code> where <code>&lt;suffix&gt;</code> is a String without any wild-card</dd>
	 * <dt>Default:</dt><dd><code>""</code></dd>
	 * </dl>
	 * @since 2.1
	 * @category CodeAssistOptionID
	 */
	public static final String CODEASSIST_ARGUMENT_SUFFIXES = PLUGIN_ID + ".codeComplete.argumentSuffixes"; //$NON-NLS-1$
	/**
	 * Code assist option ID: Activate Forbidden Reference Sensitive Completion.
	 * <p>When enabled, completion doesn't propose elements which match a
	 *    forbidden reference rule.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.codeComplete.forbiddenReferenceCheck"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "enabled", "disabled" }</code></dd>
	 * <dt>Default:</dt><dd><code>"enabled"</code></dd>
	 * </dl>
	 * @since 3.1
	 * @category CodeAssistOptionID
	 */
	public static final String CODEASSIST_FORBIDDEN_REFERENCE_CHECK= PLUGIN_ID + ".codeComplete.forbiddenReferenceCheck"; //$NON-NLS-1$
	/**
	 * Code assist option ID: Activate Discouraged Reference Sensitive Completion.
	 * <p>When enabled, completion doesn't propose elements which match a
	 *    discouraged reference rule.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.codeComplete.discouragedReferenceCheck"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "enabled", "disabled" }</code></dd>
	 * <dt>Default:</dt><dd><code>"disabled"</code></dd>
	 * </dl>
	 * @since 3.1
	 * @category CodeAssistOptionID
	 */
	public static final String CODEASSIST_DISCOURAGED_REFERENCE_CHECK= PLUGIN_ID + ".codeComplete.discouragedReferenceCheck"; //$NON-NLS-1$
	/**
	 * Code assist option ID: Activate Suggestion of Static Import.
	 * <p>When enabled, completion proposals can contain static import
	 *    pattern.</p>
	 * <dl>
	 * <dt>Option id:</dt><dd><code>"org.eclipse.jdt.core.codeComplete.suggestStaticImports"</code></dd>
	 * <dt>Possible values:</dt><dd><code>{ "enabled", "disabled" }</code></dd>
	 * <dt>Default:</dt><dd><code>"enabled"</code></dd>
	 * </dl>
	 * @since 3.3
	 * @category CodeAssistOptionID
	 */
	public static final String CODEASSIST_SUGGEST_STATIC_IMPORTS= PLUGIN_ID + ".codeComplete.suggestStaticImports"; //$NON-NLS-1$
	// end configurable option IDs }
	// Begin configurable option values {
	/**
	 * @deprecated Use {@link #DEFAULT_TASK_TAGS} instead.
	 * @since 2.1
	 * @category DeprecatedOptionValue
	 */
	public static final String DEFAULT_TASK_TAG = "TODO"; //$NON-NLS-1$
	/**
	 * @deprecated Use {@link #DEFAULT_TASK_PRIORITIES} instead.
	 * @since 2.1
	 * @category DeprecatedOptionValue
	 */
	public static final String DEFAULT_TASK_PRIORITY = "NORMAL"; //$NON-NLS-1$
	/**
	 * Configurable option value: {@value}.
	 * @since 3.0
	 * @category OptionValue
	 */
	public static final String DEFAULT_TASK_TAGS = "TODO,FIXME,XXX"; //$NON-NLS-1$
	/**
	 * Configurable option value: {@value}.
	 * @since 3.0
	 * @category OptionValue
	 */
	public static final String DEFAULT_TASK_PRIORITIES = "NORMAL,HIGH,NORMAL"; //$NON-NLS-1$
	/**
	 * Configurable option value: {@value}.
	 * @category OptionValue
	 */
	public static final String GENERATE = "generate"; //$NON-NLS-1$
	/**
	 * Configurable option value: {@value}.
	 * @category OptionValue
	 */
	public static final String DO_NOT_GENERATE = "do not generate"; //$NON-NLS-1$
	/**
	 * Configurable option value: {@value}.
	 * @category OptionValue
	 */
	public static final String PRESERVE = "preserve"; //$NON-NLS-1$
	/**
	 * Configurable option value: {@value}.
	 * @category OptionValue
	 */
	public static final String OPTIMIZE_OUT = "optimize out"; //$NON-NLS-1$
	/**
	 * Configurable option value for {@link #COMPILER_TASK_PRIORITIES}: {@value}.
	 * @since 2.1
	 * @category OptionValue
	 */
	public static final String COMPILER_TASK_PRIORITY_HIGH = "HIGH"; //$NON-NLS-1$
	/**
	 * Configurable option value for {@link #COMPILER_TASK_PRIORITIES}: {@value}.
	 * @since 2.1
	 * @category OptionValue
	 */
	public static final String COMPILER_TASK_PRIORITY_LOW = "LOW"; //$NON-NLS-1$
	/**
	 * Configurable option value for {@link #COMPILER_TASK_PRIORITIES}: {@value}.
	 * @since 2.1
	 * @category OptionValue
	 */
	public static final String COMPILER_TASK_PRIORITY_NORMAL = "NORMAL"; //$NON-NLS-1$
	/**
	 * Configurable option value: {@value}.
	 * @category OptionValue
	 */
	public static final String VERSION_1_1 = "1.1"; //$NON-NLS-1$
	/**
	 * Configurable option value: {@value}.
	 * @category OptionValue
	 */
	public static final String VERSION_1_2 = "1.2"; //$NON-NLS-1$
	/**
	 * Configurable option value: {@value}.
	 * @since 2.0
	 * @category OptionValue
	 */
	public static final String VERSION_1_3 = "1.3"; //$NON-NLS-1$
	/**
	 * Configurable option value: {@value}.
	 * @since 2.0
	 * @category OptionValue
	 */
	public static final String VERSION_1_4 = "1.4"; //$NON-NLS-1$
	/**
	 * Configurable option value: {@value}.
	 * @since 3.0
	 * @category OptionValue
	 */
	public static final String VERSION_1_5 = "1.5"; //$NON-NLS-1$
	/**
	 * Configurable option value: {@value}.
	 * @since 3.2
	 * @category OptionValue
	 */
	public static final String VERSION_1_6 = "1.6"; //$NON-NLS-1$
	/**
	 * Configurable option value: {@value}.
	 * @since 3.3
	 * @category OptionValue
	 */
	public static final String VERSION_1_7 = "1.7"; //$NON-NLS-1$
	/**
	 * Configurable option value: {@value}.
	 * @since 3.10
	 * @category OptionValue
	 */
	public static final String VERSION_1_8 = "1.8"; //$NON-NLS-1$
	/**
	 * Configurable option value: {@value}.
	 * @since 3.4
	 * @category OptionValue
	 */
	public static final String VERSION_CLDC_1_1 = "cldc1.1"; //$NON-NLS-1$
	/**
	 * Configurable option value: {@value}.
	 * @since 2.0
	 * @category OptionValue
	 */
	public static final String ABORT = "abort"; //$NON-NLS-1$
	/**
	 * Configurable option value: {@value}.
	 * @category OptionValue
	 */
	public static final String ERROR = "error"; //$NON-NLS-1$
	/**
	 * Configurable option value: {@value}.
	 * @category OptionValue
	 */
	public static final String WARNING = "warning"; //$NON-NLS-1$
	/**
	 * Configurable option value: {@value}.
	 * @category OptionValue
	 */
	public static final String IGNORE = "ignore"; //$NON-NLS-1$
	/**
	 * Configurable option value: {@value}.
	 * @category OptionValue
	 * @since 3.12
	 */
	public static final String INFO = "info"; //$NON-NLS-1$
	/**
	 * Configurable option value: {@value}.
	 * @category OptionValue
	 */
	public static final String COMPUTE = "compute"; //$NON-NLS-1$
	/**
	 * Configurable option value: {@value}.
	 * @since 2.0
	 * @category OptionValue
	 */
	public static final String INSERT = "insert"; //$NON-NLS-1$
	/**
	 * Configurable option value: {@value}.
	 * @since 2.0
	 * @category OptionValue
	 */
	public static final String DO_NOT_INSERT = "do not insert"; //$NON-NLS-1$
	/**
	 * Configurable option value: {@value}.
	 * @since 2.0
	 * @category OptionValue
	 */
	public static final String PRESERVE_ONE = "preserve one"; //$NON-NLS-1$
	/**
	 * Configurable option value: {@value}.
	 * @since 2.0
	 * @category OptionValue
	 */
	public static final String CLEAR_ALL = "clear all"; //$NON-NLS-1$
	/**
	 * Configurable option value: {@value}.
	 * @since 2.0
	 * @category OptionValue
	 */
	public static final String NORMAL = "normal"; //$NON-NLS-1$
	/**
	 * Configurable option value: {@value}.
	 * @since 2.0
	 * @category OptionValue
	 */
	public static final String COMPACT = "compact"; //$NON-NLS-1$
	/**
	 * Configurable option value: {@value}.
	 * @since 2.0
	 * @category OptionValue
	 */
	public static final String TAB = "tab"; //$NON-NLS-1$
	/**
	 * Configurable option value: {@value}.
	 * @since 2.0
	 * @category OptionValue
	 */
	public static final String SPACE = "space"; //$NON-NLS-1$
	/**
	 * Configurable option value: {@value}.
	 * @since 2.0
	 * @category OptionValue
	 */
	public static final String ENABLED = "enabled"; //$NON-NLS-1$
	/**
	 * Configurable option value: {@value}.
	 * @since 2.0
	 * @category OptionValue
	 */
	public static final String DISABLED = "disabled"; //$NON-NLS-1$
	/**
	 * Configurable option value: {@value}.
	 * @since 2.1
	 * @category OptionValue
	 */
	public static final String CLEAN = "clean"; //$NON-NLS-1$
	/**
	 * Configurable option value: {@value}.
	 * @since 3.0
	 * @category OptionValue
	 */
	public static final String PUBLIC = "public"; //$NON-NLS-1$
	/**
	 * Configurable option value: {@value}.
	 * @since 3.0
	 * @category OptionValue
	 */
	public static final String PROTECTED = "protected"; //$NON-NLS-1$
	/**
	 * Configurable option value: {@value}.
	 * @since 3.0
	 * @category OptionValue
	 */
	public static final String DEFAULT = "default"; //$NON-NLS-1$
	/**
	 * Configurable option value: {@value}.
	 * @since 3.0
	 * @category OptionValue
	 */
	public static final String PRIVATE = "private"; //$NON-NLS-1$
	/**
	 * Configurable option value: {@value}.
	 * @since 3.1
	 * @category OptionValue
	 */
	public static final String NEVER = "never"; //$NON-NLS-1$
	/**
	 * Configurable option value: {@value}.
	 * @since 3.4
	 * @category OptionValue
	 */
	public static final String COMPILER_PB_MISSING_JAVADOC_TAG_DESCRIPTION_NO_TAG = CompilerOptions.NO_TAG;
	/**
	 * Configurable option value: {@value}.
	 * @since 3.4
	 * @category OptionValue
	 */
	public static final String COMPILER_PB_MISSING_JAVADOC_TAG_DESCRIPTION_RETURN_TAG = CompilerOptions.RETURN_TAG;
	/**
	 * Configurable option value: {@value}.
	 * @since 3.4
	 * @category OptionValue
	 */
	public static final String COMPILER_PB_MISSING_JAVADOC_TAG_DESCRIPTION_ALL_STANDARD_TAGS = CompilerOptions.ALL_STANDARD_TAGS;
	// end configurable option values }

	/**
	 * Value of the content-type for Java source files. Use this value to retrieve the Java content type
	 * from the content type manager, and to add new Java-like extensions to this content type.
	 *
	 * @see org.eclipse.core.runtime.content.IContentTypeManager#getContentType(String)
	 * @see #getJavaLikeExtensions()
	 * @since 3.2
	 */
	public static final String JAVA_SOURCE_CONTENT_TYPE = JavaCore.PLUGIN_ID+".javaSource" ; //$NON-NLS-1$

	/**
	 * The ID of the Eclipse built-in formatter.
	 *
	 * @see #JAVA_FORMATTER
	 * @see #JAVA_FORMATTER_EXTENSION_POINT_ID
	 * @since 3.11
	 */
	public static final String DEFAULT_JAVA_FORMATTER = PLUGIN_ID + ".defaultJavaFormatter"; //$NON-NLS-1$

	/**
	 * Name of the extension point for contributing a source code formatter
	 * @see #JAVA_FORMATTER
	 * @see #DEFAULT_JAVA_FORMATTER
	 * @since 3.11
	 */
	public static final String JAVA_FORMATTER_EXTENSION_POINT_ID = "javaFormatter" ;  //$NON-NLS-1$


	/**
	 * Returns the option that can be used to configure the severity of the
	 * compiler problem identified by <code>problemID</code> if any,
	 * <code>null</code> otherwise. Non-null return values are taken from the
	 * constants defined by this class whose names start with
	 * <code>COMPILER_PB</code> and for which the possible values of the
	 * option are defined by <code>{ "error", "warning", "info", "ignore" }</code>. A
	 * null return value means that the provided problem ID is unknown or that
	 * it matches a problem whose severity cannot be configured.
	 * @param problemID one of the problem IDs defined by {@link IProblem}
	 * @return the option that can be used to configure the severity of the
	 *         compiler problem identified by <code>problemID</code> if any,
	 *         <code>null</code> otherwise
	 * @since 3.4
	 */
	public static String getOptionForConfigurableSeverity(int problemID) {
		return CompilerOptions.optionKeyFromIrritant(ProblemReporter.getIrritant(problemID));
	}

	/**
	 * Sets the default compiler options inside the given options map according
	 * to the given compliance.
	 *
	 * <p>The given compliance must be one of those supported by the compiler,
	 * that is one of the acceptable values for option {@link #COMPILER_COMPLIANCE}.</p>
	 *
	 * <p>The list of modified options is currently:</p>
	 * <ul>
	 * <li>{@link #COMPILER_COMPLIANCE}</li>
	 * <li>{@link #COMPILER_SOURCE}</li>
	 * <li>{@link #COMPILER_CODEGEN_TARGET_PLATFORM}</li>
	 * <li>{@link #COMPILER_PB_ASSERT_IDENTIFIER}</li>
	 * <li>{@link #COMPILER_PB_ENUM_IDENTIFIER}</li>
	 * <li>{@link #COMPILER_CODEGEN_INLINE_JSR_BYTECODE} for compliance levels 1.5 and greater</li>
	 * </ul>
	 *
	 * <p>If the given compliance is unknown, the given map is unmodified.</p>
	 *
	 * @param compliance the given {@link #COMPILER_COMPLIANCE compliance}
	 * @param options the given options map
	 * @since 3.3
	 */
	public static void setComplianceOptions(String compliance, Map<String, String> options) {
		switch((int) (CompilerOptions.versionToJdkLevel(compliance) >>> 16)) {
			case ClassFileConstants.MAJOR_VERSION_1_3:
				options.put(JavaCore.COMPILER_COMPLIANCE, JavaCore.VERSION_1_3);
				options.put(JavaCore.COMPILER_SOURCE, JavaCore.VERSION_1_3);
				options.put(JavaCore.COMPILER_CODEGEN_TARGET_PLATFORM, JavaCore.VERSION_1_1);
				options.put(JavaCore.COMPILER_PB_ASSERT_IDENTIFIER, JavaCore.IGNORE);
				options.put(JavaCore.COMPILER_PB_ENUM_IDENTIFIER, JavaCore.IGNORE);
				break;
			case ClassFileConstants.MAJOR_VERSION_1_4:
				options.put(JavaCore.COMPILER_COMPLIANCE, JavaCore.VERSION_1_4);
				options.put(JavaCore.COMPILER_SOURCE, JavaCore.VERSION_1_3);
				options.put(JavaCore.COMPILER_CODEGEN_TARGET_PLATFORM, JavaCore.VERSION_1_2);
				options.put(JavaCore.COMPILER_PB_ASSERT_IDENTIFIER, JavaCore.WARNING);
				options.put(JavaCore.COMPILER_PB_ENUM_IDENTIFIER, JavaCore.WARNING);
				break;
			case ClassFileConstants.MAJOR_VERSION_1_5:
				options.put(JavaCore.COMPILER_COMPLIANCE, JavaCore.VERSION_1_5);
				options.put(JavaCore.COMPILER_SOURCE, JavaCore.VERSION_1_5);
				options.put(JavaCore.COMPILER_CODEGEN_TARGET_PLATFORM, JavaCore.VERSION_1_5);
				options.put(JavaCore.COMPILER_PB_ASSERT_IDENTIFIER, JavaCore.ERROR);
				options.put(JavaCore.COMPILER_PB_ENUM_IDENTIFIER, JavaCore.ERROR);
				options.put(JavaCore.COMPILER_CODEGEN_INLINE_JSR_BYTECODE, JavaCore.ENABLED);
				break;
			case ClassFileConstants.MAJOR_VERSION_1_6:
				options.put(JavaCore.COMPILER_COMPLIANCE, JavaCore.VERSION_1_6);
				options.put(JavaCore.COMPILER_SOURCE, JavaCore.VERSION_1_6);
				options.put(JavaCore.COMPILER_CODEGEN_TARGET_PLATFORM, JavaCore.VERSION_1_6);
				options.put(JavaCore.COMPILER_PB_ASSERT_IDENTIFIER, JavaCore.ERROR);
				options.put(JavaCore.COMPILER_PB_ENUM_IDENTIFIER, JavaCore.ERROR);
				options.put(JavaCore.COMPILER_CODEGEN_INLINE_JSR_BYTECODE, JavaCore.ENABLED);
				break;
			case ClassFileConstants.MAJOR_VERSION_1_7:
				options.put(JavaCore.COMPILER_COMPLIANCE, JavaCore.VERSION_1_7);
				options.put(JavaCore.COMPILER_SOURCE, JavaCore.VERSION_1_7);
				options.put(JavaCore.COMPILER_CODEGEN_TARGET_PLATFORM, JavaCore.VERSION_1_7);
				options.put(JavaCore.COMPILER_PB_ASSERT_IDENTIFIER, JavaCore.ERROR);
				options.put(JavaCore.COMPILER_PB_ENUM_IDENTIFIER, JavaCore.ERROR);
				options.put(JavaCore.COMPILER_CODEGEN_INLINE_JSR_BYTECODE, JavaCore.ENABLED);
				break;
			case ClassFileConstants.MAJOR_VERSION_1_8:
				options.put(JavaCore.COMPILER_COMPLIANCE, JavaCore.VERSION_1_8);
				options.put(JavaCore.COMPILER_SOURCE, JavaCore.VERSION_1_8);
				options.put(JavaCore.COMPILER_CODEGEN_TARGET_PLATFORM, JavaCore.VERSION_1_8);
				options.put(JavaCore.COMPILER_PB_ASSERT_IDENTIFIER, JavaCore.ERROR);
				options.put(JavaCore.COMPILER_PB_ENUM_IDENTIFIER, JavaCore.ERROR);
				options.put(JavaCore.COMPILER_CODEGEN_INLINE_JSR_BYTECODE, JavaCore.ENABLED);
				break;
		}
	}
  public static Map<String, String> getOptions() {
    return options;
  }
  private static final Map<String, String> options;
  static{
    options=new HashMap<>();
    
  }
}
