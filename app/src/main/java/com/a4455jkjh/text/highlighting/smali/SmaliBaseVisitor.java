// Generated from Smali.g4 by ANTLR 4.7.2
package com.a4455jkjh.text.highlighting.smali;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link SmaliVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public class SmaliBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements SmaliVisitor<T> {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitSmali(SmaliParser.SmaliContext ctx) { return visitChildren(ctx); }
}