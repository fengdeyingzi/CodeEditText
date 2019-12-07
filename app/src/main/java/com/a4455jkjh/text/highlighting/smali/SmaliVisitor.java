// Generated from Smali.g4 by ANTLR 4.7.2
package com.a4455jkjh.text.highlighting.smali;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SmaliParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SmaliVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SmaliParser#smali}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSmali(SmaliParser.SmaliContext ctx);
}