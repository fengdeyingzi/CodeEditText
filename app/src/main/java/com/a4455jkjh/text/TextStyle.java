package com.a4455jkjh.text;

public class TextStyle {
  private int backgroundColor;
  private int foregroundColor;
  private int keywordColor;
  private int separatorColor;
  private int operatorColor;
  private int literalColor;
  private int commentColor;
  private int typeColor;
  private int packageColor;
  private int errorColor;
  private int lineNumberColor;
  private int selectionColor;
  private int caretColor;
  private int caretLineColor;

  public void setCaretLineColor(int caretLineColor) {
    this.caretLineColor = caretLineColor;
  }

  public int getCaretLineColor() {
    return caretLineColor;
  }

  public void setCaretColor(int caretColor) {
    this.caretColor = caretColor;
  }

  public int getCaretColor() {
    return caretColor;
  }

  public void setselectionColor(int selectionColor) {
    this.selectionColor = selectionColor;
  }

  public int getselectionColor() {
    return selectionColor;
  }

  public void setLineNumberColor(int lineNumberColor) {
    this.lineNumberColor = lineNumberColor;
  }

  public int getLineNumberColor() {
    return lineNumberColor;
  }

  public void setErrorColor(int errorColor) {
    this.errorColor = errorColor;
  }

  public int getErrorColor() {
    return errorColor;
  }

  public void setPackageColor(int packageColor) {
    this.packageColor = packageColor;
  }

  public int getPackageColor() {
    return packageColor;
  }

  public void setTypeColor(int typeColor) {
    this.typeColor = typeColor;
  }

  public int getTypeColor() {
    return typeColor;
  }

  public void setLiteralColor(int literalColor) {
    this.literalColor = literalColor;
  }

  public int getLiteralColor() {
    return literalColor;
  }

  public void setCommentColor(int commentColor) {
    this.commentColor = commentColor;
  }

  public int getCommentColor() {
    return commentColor;
  }

  public void setOperatorColor(int operatorColor) {
    this.operatorColor = operatorColor;
  }

  public int getOperatorColor() {
    return operatorColor;
  }

  public void setSeparatorColor(int separatorColor) {
    this.separatorColor = separatorColor;
  }

  public int getSeparatorColor() {
    return separatorColor;
  }

  public void setKeywordColor(int keywordColor) {
    this.keywordColor = keywordColor;
  }

  public int getKeywordColor() {
    return keywordColor;
  }

  public void setForegroundColor(int foregroundColor) {
    this.foregroundColor = foregroundColor;
  }

  public int getForegroundColor() {
    return foregroundColor;
  }


  public void setBackgroundColor(int backgroundColor) {
    this.backgroundColor = backgroundColor;
  }

  public int getBackgroundColor() {
    return backgroundColor;
  }
  public static final TextStyle DEFAULT_THEME;
  static{
    TextStyle theme = new TextStyle();
    theme.setBackgroundColor(0xffffffff);
    theme.setForegroundColor(0xff000000);
    theme.setKeywordColor(0xff2c82c8);
    theme.setSeparatorColor(0xff0096ff);
    theme.setOperatorColor(0xff007c1f);
    theme.setLiteralColor(0xffbc0000);
    theme.setCommentColor(0xff009b00);
    theme.setTypeColor(0xff0096ff);
    theme.setPackageColor(0xff5d5d5d);
    theme.setErrorColor(0xffff0000);
    theme.setLineNumberColor(0xffd0d0d0);
    theme.setselectionColor(0xff888888);
    theme.setCaretColor(0xff0099cc);
    theme.setCaretLineColor(0xfff5f5f5);
    DEFAULT_THEME = theme;
  }
}
