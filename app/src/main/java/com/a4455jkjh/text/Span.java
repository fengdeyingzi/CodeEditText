package com.a4455jkjh.text;

public class Span {

  private Span(int start, int stop, Style style) {
    this.style = style;
    this.start = start;
    this.stop = stop;
    next = null;
  }

  public static void merge(Span span, Span newSpan, int start) {
    // TODO: Implement this method
  }

  public static Span findSpanAtIndex(Span span, int fOffset) {
    while (true) {
      if (span == null)
        break;
      if (span.start <= fOffset && span.stop >= fOffset)
        return span;
      span = span.next;
    }
    return DEFAULT_SPAN;
  }

  public Style getStyle() {
    return style;
  }

  public enum Style {
    NORMAL,
    KEYWORD(true) {
      public int gerColor(TextStyle theme) {
        return theme.getKeywordColor();
      }
    },
    SEPARATOR {
      public int gerColor(TextStyle theme) {
        return theme.getSeparatorColor();
      }
    },
    OPERATOR {
      public int gerColor(TextStyle theme) {
        return theme.getOperatorColor();
      }
    },
    LITERAL {
      public int gerColor(TextStyle theme) {
        return theme.getLiteralColor();
      }
    },
    COMMENT {
      public int gerColor(TextStyle theme) {
        return theme.getCommentColor();
      }
    },
    TYPE {
      public int gerColor(TextStyle theme) {
        return theme.getTypeColor();
      }
    },
    PACKAGE {
      public int gerColor(TextStyle theme) {
        return theme.getPackageColor();
      }
    },
    ERROR {
      public int gerColor(TextStyle theme) {
        return theme.getErrorColor();
      }
    };
    Style(){
      isBold = false;
    }
    Style(boolean isBold) {
      this.isBold = isBold;
    }
    public final boolean isBold;
    public int gerColor(TextStyle theme) {
      return theme.getForegroundColor();
    }
  }
  Style style;

  public int start, stop;
  Span next;
  public static final Span DEFAULT_SPAN;
  static{
    DEFAULT_SPAN = new Span(0, Integer.MAX_VALUE, Style.NORMAL);
  }
  public static class Builder {
    private Span first;
    private Span current;
    public Builder() {
      first = new Span(-1, -1, Style.NORMAL);
      current = first;
    }
    public void add(int start, int stop, Style style) {
      Span span = current;
      int stop1 = span.stop;
      if (start - 1 > stop1) {
        Span span1 = new Span(stop1 + 1, start - 1, Style.NORMAL);
        span.next = span1;
        span = span1;
      }
      Span span1 = new Span(start, stop, style);
      span.next = span1;
      current = span1;
    }
    private void eof(int start) {
      Span span = current;
      int stop = Integer.MAX_VALUE;
      Span span1 = new Span(start, stop, Style.NORMAL);
      span.next = span1;
      current = span1;
    }
    public Span build() {
      eof(current.stop + 1);
      return first;
    }
  }
}
