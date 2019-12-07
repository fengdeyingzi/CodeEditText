package com.a4455jkjh.text.highlighting;
import com.a4455jkjh.text.Highlighting;
import com.a4455jkjh.text.Span;
import com.a4455jkjh.text.highlighting.smali.SmaliLexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Token;

import static com.a4455jkjh.text.highlighting.smali.SmaliLexer.*;

public class SmaliHighlighting implements Highlighting {
  private SmaliLexer lexer;
  public SmaliHighlighting() {
    lexer = new SmaliLexer(null);
  }
  @Override
  public Span highlighhting(String code) {
    CharStream stream = CharStreams.fromString(code);
    Span.Builder builder = new Span.Builder();
    highlighhting(lexer, stream, builder);
    return builder.build();
  }

  private static void highlighhting(SmaliLexer lexer, CharStream stream, Span.Builder builder) {
    lexer.setInputStream(stream);
    boolean isLabel = false;
    while (true) {
      Token token = lexer.nextToken();
      int type = token.getType();
      if (type == Lexer.EOF)
        break;
      Span.Style style;
      style:switch (type) {
        case ANNOTATION_DIRECTIVE:
        case ARRAY_DATA_DIRECTIVE:
        case CATCHALL_DIRECTIVE:
        case CATCH_DIRECTIVE:
        case CLASS_DIRECTIVE:
        case END_ANNOTATION_DIRECTIVE:
        case END_ARRAY_DATA_DIRECTIVE:
        case END_FIELD_DIRECTIVE:
        case END_LOCAL_DIRECTIVE:
        case END_PARAMETER_DIRECTIVE:
        case END_METHOD_DIRECTIVE:
        case END_PACKED_SWITCH_DIRECTIVE:
        case END_SPARSE_SWITCH_DIRECTIVE:
        case END_SUBANNOTATION_DIRECTIVE:
        case ENUM_DIRECTIVE:
        case EPILOGUE_DIRECTIVE:
        case FIELD_DIRECTIVE:
        case IMPLEMENTS_DIRECTIVE:
        case LINE_DIRECTIVE:
        case LOCAL_DIRECTIVE:
        case LOCALS_DIRECTIVE:
        case METHOD_DIRECTIVE:
        case PACKED_SWITCH_DIRECTIVE:
        case PARAMETER_DIRECTIVE:
        case PROLOGUE_DIRECTIVE:
        case REGISTERS_DIRECTIVE:
        case RESTART_LOCAL_DIRECTIVE:
        case SOURCE_DIRECTIVE:
        case SPARSE_SWITCH_DIRECTIVE:
        case SUBANNOTATION_DIRECTIVE:
        case SUPER_DIRECTIVE:
          style = Span.Style.PACKAGE;
          break;
        case ACCESS_SPEC:
        case ANNOTATION_VISIBILITY:
        case INSTRUCTION_FORMAT3rc_CALL_SITE:
        case INSTRUCTION_FORMAT35c_CALL_SITE:
          style = Span.Style.KEYWORD;
          break;
        case CLASS_DESCRIPTOR:
        case VOID_TYPE:
        case PRIMITIVE_TYPE:
        case PARAM_LIST_OR_ID:
        case PARAM_LIST:
        case ARRAY_TYPE_PREFIX:
          style = Span.Style.TYPE;
          break;
        case LINE_COMMENT:
          style = Span.Style.COMMENT;
          break;
        case INVALID_TOKEN:
          style = Span.Style.ERROR;
          break;
        case BOOL_LITERAL:
        case BYTE_LITERAL:
        case CHAR_LITERAL:
        case DOUBLE_LITERAL:
        case DOUBLE_LITERAL_OR_ID:
        case FLOAT_LITERAL_OR_ID:
        case FLOAT_LITERAL:
        case LONG_LITERAL:
        case NULL_LITERAL:
        case POSITIVE_INTEGER_LITERAL:
        case NEGATIVE_INTEGER_LITERAL:
        case SHORT_LITERAL:
        case STRING_LITERAL:
          style = Span.Style.LITERAL;
          break;
        case ARROW:
        case AT:
        case COMMA:
        case DOTDOT:
        case EQUAL:
        case REGISTER:
          style = Span.Style.OPERATOR;
          break;
        case OPEN_BRACE:
        case OPEN_PAREN:
        case CLOSE_BRACE:
        case CLOSE_PAREN:
          style = Span.Style.SEPARATOR;
          break;
        case COLON:
          isLabel = true;
          style = Span.Style.OPERATOR;
          break;
        case SIMPLE_NAME:
          if (isLabel)
            style = Span.Style.OPERATOR;
          else
            style = Span.Style.NORMAL;
          isLabel = false;
          break;
        case WHITE_SPACE:
          isLabel = false;
        default:
          if (type >= INSTRUCTION_FORMAT10t && type <= INSTRUCTION_FORMAT51l)
            style = Span.Style.KEYWORD;
          else
            style = Span.Style.NORMAL;
          break;
      }
      builder.add(token.getStartIndex(),
                  token.getStopIndex(),
                  style);
    }
  }

}
