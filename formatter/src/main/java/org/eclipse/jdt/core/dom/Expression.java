/*******************************************************************************
 * Copyright (c) 2000, 2013 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

package org.eclipse.jdt.core.dom;

/**
 * Abstract base class of AST nodes that represent expressions.
 * There are several kinds of expressions.
 * <p>
 * <pre>
 * Expression:
 *    {@link Annotation},
 *    {@link ArrayAccess},
 *    {@link ArrayCreation},
 *    {@link ArrayInitializer},
 *    {@link Assignment},
 *    {@link BooleanLiteral},
 *    {@link CastExpression},
 *    {@link CharacterLiteral},
 *    {@link ClassInstanceCreation},
 *    {@link ConditionalExpression},
 *    {@link CreationReference},
 *    {@link ExpressionMethodReference},
 *    {@link FieldAccess},
 *    {@link InfixExpression},
 *    {@link InstanceofExpression},
 *    {@link LambdaExpression},
 *    {@link MethodInvocation},
 *    {@link MethodReference},
 *    {@link Name},
 *    {@link NullLiteral},
 *    {@link NumberLiteral},
 *    {@link ParenthesizedExpression},
 *    {@link PostfixExpression},
 *    {@link PrefixExpression},
 *    {@link StringLiteral},
 *    {@link SuperFieldAccess},
 *    {@link SuperMethodInvocation},
 *    {@link SuperMethodReference},
 *    {@link ThisExpression},
 *    {@link TypeLiteral},
 *    {@link TypeMethodReference},
 *    {@link VariableDeclarationExpression}
 * </pre>
 * </p>
 *
 * @since 2.0
 */
public abstract class Expression extends ASTNode {

	/**
	 * Creates a new AST node for an expression owned by the given AST.
	 * <p>
	 * N.B. This constructor is package-private.
	 * </p>
	 *
	 * @param ast the AST that is to own this node
	 */
	Expression(AST ast) {
		super(ast);
	}
}

