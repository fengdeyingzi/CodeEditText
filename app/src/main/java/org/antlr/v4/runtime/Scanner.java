package org.antlr.v4.runtime;

public interface Scanner {
  /**
   * Return a {@link Token} object from your input stream (usually a
   * {@link CharStream}). Do not fail/return upon lexing error; keep chewing
   * on the characters until you get a good one; errors are not passed through
   * to the parser.
   */
	public Token nextToken();

  /**
   * Set the {@link TokenFactory} this token source should use for creating
   * {@link Token} objects from the input.
   *
   * @param factory The {@link TokenFactory} to use for creating tokens.
   */
  public void setTokenFactory(TokenFactory<?> factory);

  /**
   * Gets the {@link TokenFactory} this token source is currently using for
   * creating {@link Token} objects from the input.
   *
   * @return The {@link TokenFactory} currently used by this token source.
   */
	public TokenFactory<?> getTokenFactory();

  /**
   * Gets the name of the underlying input source. This method returns a
   * non-null, non-empty string. If such a name is not known, this method
   * returns {@link IntStream#UNKNOWN_SOURCE_NAME}.
   */
	public String getSourceName();

  /**
   * Get the line number for the current position in the input stream. The
   * first line in the input is line 1.
   *
   * @return The line number for the current position in the input stream, or
   * 0 if the current token source does not track line numbers.
   */
  public int getLine();

  /**
   * Get the index into the current line for the current position in the input
   * stream. The first character on a line has position 0.
   *
   * @return The line number for the current position in the input stream, or
   * -1 if the current token source does not track character positions.
   */
	public int getCharPositionInLine();
}
