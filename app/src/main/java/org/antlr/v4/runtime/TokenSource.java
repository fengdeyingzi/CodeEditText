/*
 * Copyright (c) 2012-2017 The ANTLR Project. All rights reserved.
 * Use of this file is governed by the BSD 3-clause license that
 * can be found in the LICENSE.txt file in the project root.
 */
package org.antlr.v4.runtime;

/**
 * A source of tokens must provide a sequence of tokens via {@link #nextToken()}
 * and also must reveal it's source of characters; {@link CommonToken}'s text is
 * computed from a {@link CharStream}; it only store indices into the char
 * stream.
 *
 * <p>Errors from the lexer are never passed to the parser. Either you want to keep
 * going or you do not upon token recognition error. If you do not want to
 * continue lexing then you do not want to continue parsing. Just throw an
 * exception not under {@link RecognitionException} and Java will naturally toss
 * you all the way out of the recognizers. If you want to continue lexing then
 * you should not throw an exception to the parser--it has already requested a
 * token. Keep lexing until you get a valid one. Just report errors and keep
 * going, looking for a valid token.</p>
 */
public interface TokenSource extends Scanner{

	/**
	 * Get the {@link CharStream} from which this token source is currently
	 * providing tokens.
	 *
	 * @return The {@link CharStream} associated with the current position in
	 * the input, or {@code null} if no input stream is available for the token
	 * source.
	 */
	public CharStream getInputStream();
}
