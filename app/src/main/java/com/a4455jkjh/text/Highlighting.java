package com.a4455jkjh.text;

public interface Highlighting {
  Span highlighhting(String code);
  public static class DefaultHighlighting implements Highlighting {
    @Override
    public Span highlighhting(String code) {
      return Span.DEFAULT_SPAN;
    }
    private DefaultHighlighting(){}
    public static Highlighting INSTANCE = new DefaultHighlighting();
  }
}
