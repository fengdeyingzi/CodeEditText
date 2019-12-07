package org.antlr.v4.runtime;
import java.io.IOException;

public abstract class ScannerImpl implements Scanner {
  /** This character denotes the end of file. */
  public static final int YYEOF = -1;
  private int line;
  private int charPositionInLine;
  private String sourceName;
  private String text;
  private int channel;


  /** Number of newlines encountered up to the start of the matched text. */
  protected int yyline;

  /** Number of characters up to the start of the matched text. */
  protected int yychar;

  /** Number of characters from the last newline up to the start of the matched text. */
  protected int yycolumn;
  protected StringBuilder sb = new StringBuilder();
  private String stringOrCharError = null;

  /** How to create token objects */
	protected TokenFactory<?> _factory = CommonTokenFactory.DEFAULT;

  public void setChannel(int channel) {
    this.channel = channel;
  }

  public  int getChannel() {
    return channel;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getText() {
    if (text == null)
      return yytext();
    return text;
  }

  public void setSourceName(String sourceName) {
    this.sourceName = sourceName;
  }

  @Override
  public void setTokenFactory(TokenFactory<?> factory) {
    this._factory = factory;
  }

  @Override
  public TokenFactory<? extends Token> getTokenFactory() {
    return _factory;
	}

  @Override
  public int getLine() {
    return line;
  }

  @Override
  public int getCharPositionInLine() {
    return charPositionInLine;
  }

  @Override
  public String getSourceName() {
    return sourceName;
  }
  protected void beginStringOrChar(int state) {
    yybegin(state);
    sb.setLength(0);
  }
  protected int endStringOrChar(int type) {
    yybegin(0);
    setText(sb.toString());
    if (stringOrCharError != null) {
      return invalidStringOrChar(stringOrCharError);
    }
    return type;
  }
  protected int invalidStringOrChar(String message) {
    yybegin(0);
    setChannel(Token.HIDDEN_CHANNEL);
    /*InvalidToken token = new InvalidToken(message, sb.toString());
    token.setStartIndex(stringStartChar);
    token.setStopIndex(yychar + yylength() - 1);
    token.setLine(stringStartLine);
    token.setCharPositionInLine(stringStartCol);*/
    return 0;
  }
  protected void setStringOrCharError(String message) {
    if (stringOrCharError == null) {
      stringOrCharError = message;
    }
  }
  protected int invalidToken(String message) {
    setChannel(Token.HIDDEN_CHANNEL);
    return 0;
  }
  @Override
  public Token nextToken() {
    text = null;
    channel = Token.DEFAULT_CHANNEL;
    int line = getLine();
    int column = getCharPositionInLine();
    int start = getCharIndex();
    int type;
    int stop;
    try {
      type = yylex();
      computeEndLineColumn();
      stop = getCharIndex() - 1;
    } catch (IOException ex) {
      type = -1;
      stop = start + 1;
    }
    return _factory.create(
      CommonToken.EMPTY_SOURCE,
      type, getText(),
      getChannel(),
      start, stop,
      line, column);
  }
  protected void hidden() {
    setChannel(Token.HIDDEN_CHANNEL);
  }
  private void computeEndLineColumn() {
    int line = yyline + 1;
    int column = yycolumn;
    String text = yytext();
    int length = text.length();
    boolean zzR = false;
    for (int i = 0; i < length; i++) {
      int cp = text.codePointAt(i);
      int zzCharCount = Character.charCount(cp);
      switch (cp) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          line++;
          column = 0;
          zzR = false;
          break;
        case '\r':
          line++;
          column = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            line++;
            column = 0;
          }
          break;
        default:
          zzR = false;
          column += zzCharCount;
      }
    }
    this.line = line;
    this.charPositionInLine = column + 1;
  }
  public int getCharIndex() {
    return yychar + yylength();
  }
  public abstract int yylex() throws IOException;
  public abstract int yylength();
  public abstract String yytext();
  public abstract void yybegin(int state);
}
