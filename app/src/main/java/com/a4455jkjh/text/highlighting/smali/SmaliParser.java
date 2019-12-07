// Generated from Smali.g4 by ANTLR 4.7.2
package com.a4455jkjh.text.highlighting.smali;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SmaliParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		CLASS_DIRECTIVE=1, SUPER_DIRECTIVE=2, IMPLEMENTS_DIRECTIVE=3, SOURCE_DIRECTIVE=4, 
		FIELD_DIRECTIVE=5, END_FIELD_DIRECTIVE=6, SUBANNOTATION_DIRECTIVE=7, END_SUBANNOTATION_DIRECTIVE=8, 
		ANNOTATION_DIRECTIVE=9, END_ANNOTATION_DIRECTIVE=10, ENUM_DIRECTIVE=11, 
		METHOD_DIRECTIVE=12, END_METHOD_DIRECTIVE=13, REGISTERS_DIRECTIVE=14, 
		LOCALS_DIRECTIVE=15, ARRAY_DATA_DIRECTIVE=16, END_ARRAY_DATA_DIRECTIVE=17, 
		PACKED_SWITCH_DIRECTIVE=18, END_PACKED_SWITCH_DIRECTIVE=19, SPARSE_SWITCH_DIRECTIVE=20, 
		END_SPARSE_SWITCH_DIRECTIVE=21, CATCH_DIRECTIVE=22, CATCHALL_DIRECTIVE=23, 
		LINE_DIRECTIVE=24, PARAMETER_DIRECTIVE=25, END_PARAMETER_DIRECTIVE=26, 
		LOCAL_DIRECTIVE=27, END_LOCAL_DIRECTIVE=28, RESTART_LOCAL_DIRECTIVE=29, 
		PROLOGUE_DIRECTIVE=30, EPILOGUE_DIRECTIVE=31, INVALID_TOKEN=32, POSITIVE_INTEGER_LITERAL=33, 
		NEGATIVE_INTEGER_LITERAL=34, LONG_LITERAL=35, SHORT_LITERAL=36, BYTE_LITERAL=37, 
		FLOAT_LITERAL_OR_ID=38, DOUBLE_LITERAL_OR_ID=39, FLOAT_LITERAL=40, DOUBLE_LITERAL=41, 
		BOOL_LITERAL=42, NULL_LITERAL=43, STRING_LITERAL=44, CHAR_LITERAL=45, 
		REGISTER=46, ANNOTATION_VISIBILITY=47, ACCESS_SPEC=48, VERIFICATION_ERROR_TYPE=49, 
		INLINE_INDEX=50, VTABLE_INDEX=51, FIELD_OFFSET=52, METHOD_HANDLE_TYPE_FIELD=53, 
		METHOD_HANDLE_TYPE_METHOD=54, LINE_COMMENT=55, INSTRUCTION_FORMAT10t=56, 
		INSTRUCTION_FORMAT10x=57, INSTRUCTION_FORMAT10x_ODEX=58, INSTRUCTION_FORMAT11n=59, 
		INSTRUCTION_FORMAT11x=60, INSTRUCTION_FORMAT12x_OR_ID=61, INSTRUCTION_FORMAT12x=62, 
		INSTRUCTION_FORMAT20bc=63, INSTRUCTION_FORMAT20t=64, INSTRUCTION_FORMAT21c_FIELD=65, 
		INSTRUCTION_FORMAT21c_FIELD_ODEX=66, INSTRUCTION_FORMAT21c_STRING=67, 
		INSTRUCTION_FORMAT21c_TYPE=68, INSTRUCTION_FORMAT21c_METHOD_HANDLE=69, 
		INSTRUCTION_FORMAT21c_METHOD_TYPE=70, INSTRUCTION_FORMAT21ih=71, INSTRUCTION_FORMAT21lh=72, 
		INSTRUCTION_FORMAT21s=73, INSTRUCTION_FORMAT21t=74, INSTRUCTION_FORMAT22b=75, 
		INSTRUCTION_FORMAT22c_FIELD=76, INSTRUCTION_FORMAT22c_FIELD_ODEX=77, INSTRUCTION_FORMAT22c_TYPE=78, 
		INSTRUCTION_FORMAT22cs_FIELD=79, INSTRUCTION_FORMAT22s_OR_ID=80, INSTRUCTION_FORMAT22s=81, 
		INSTRUCTION_FORMAT22t=82, INSTRUCTION_FORMAT22x=83, INSTRUCTION_FORMAT23x=84, 
		INSTRUCTION_FORMAT30t=85, INSTRUCTION_FORMAT31i_OR_ID=86, INSTRUCTION_FORMAT31c=87, 
		INSTRUCTION_FORMAT31i=88, INSTRUCTION_FORMAT31t=89, INSTRUCTION_FORMAT32x=90, 
		INSTRUCTION_FORMAT35c_CALL_SITE=91, INSTRUCTION_FORMAT35c_METHOD=92, INSTRUCTION_FORMAT35c_METHOD_OR_METHOD_HANDLE_TYPE=93, 
		INSTRUCTION_FORMAT35c_METHOD_ODEX=94, INSTRUCTION_FORMAT35c_TYPE=95, INSTRUCTION_FORMAT35mi_METHOD=96, 
		INSTRUCTION_FORMAT35ms_METHOD=97, INSTRUCTION_FORMAT3rc_CALL_SITE=98, 
		INSTRUCTION_FORMAT3rc_METHOD=99, INSTRUCTION_FORMAT3rc_METHOD_ODEX=100, 
		INSTRUCTION_FORMAT3rc_TYPE=101, INSTRUCTION_FORMAT3rmi_METHOD=102, INSTRUCTION_FORMAT3rms_METHOD=103, 
		INSTRUCTION_FORMAT45cc_METHOD=104, INSTRUCTION_FORMAT4rcc_METHOD=105, 
		INSTRUCTION_FORMAT51l=106, PRIMITIVE_TYPE=107, VOID_TYPE=108, CLASS_DESCRIPTOR=109, 
		ARRAY_TYPE_PREFIX=110, PARAM_LIST_OR_ID=111, PARAM_LIST=112, SIMPLE_NAME=113, 
		MEMBER_NAME=114, DOTDOT=115, ARROW=116, EQUAL=117, COLON=118, COMMA=119, 
		OPEN_BRACE=120, CLOSE_BRACE=121, OPEN_PAREN=122, CLOSE_PAREN=123, AT=124, 
		WHITE_SPACE=125;
	public static final int
		RULE_smali = 0;
	private static String[] makeRuleNames() {
		return new String[] {
			"smali"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'.class'", "'.super'", "'.implements'", "'.source'", "'.field'", 
			"'.end field'", "'.subannotation'", "'.end subannotation'", "'.annotation'", 
			"'.end annotation'", "'.enum'", "'.method'", "'.end method'", "'.registers'", 
			"'.locals'", "'.array-data'", "'.end array-data'", "'.packed-switch'", 
			"'.end packed-switch'", "'.sparse-switch'", "'.end sparse-switch'", "'.catch'", 
			"'.catchall'", "'.line'", "'.param'", "'.end param'", "'.local'", "'.end local'", 
			"'.restart local'", "'.prologue'", "'.epilogue'", null, null, null, null, 
			null, null, null, null, null, null, null, "'null'", null, null, null, 
			null, null, null, null, null, null, null, null, null, "'goto'", null, 
			null, "'const/4'", null, null, null, "'throw-verification-error'", "'goto/16'", 
			null, null, "'const-string'", null, "'const-method-handle'", "'const-method-type'", 
			"'const/high16'", "'const-wide/high16'", null, null, null, null, null, 
			null, null, "'rsub-int'", null, null, null, null, "'goto/32'", "'const'", 
			"'const-string/jumbo'", "'const-wide/32'", null, null, "'invoke-custom'", 
			null, null, "'invoke-direct-empty'", "'filled-new-array'", "'execute-inline'", 
			null, "'invoke-custom/range'", null, "'invoke-object-init/range'", "'filled-new-array/range'", 
			"'execute-inline/range'", null, "'invoke-polymorphic'", "'invoke-polymorphic/range'", 
			"'const-wide'", null, "'V'", null, null, null, null, null, null, "'..'", 
			"'->'", "'='", "':'", "','", "'{'", "'}'", "'('", "')'", "'@'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "CLASS_DIRECTIVE", "SUPER_DIRECTIVE", "IMPLEMENTS_DIRECTIVE", "SOURCE_DIRECTIVE", 
			"FIELD_DIRECTIVE", "END_FIELD_DIRECTIVE", "SUBANNOTATION_DIRECTIVE", 
			"END_SUBANNOTATION_DIRECTIVE", "ANNOTATION_DIRECTIVE", "END_ANNOTATION_DIRECTIVE", 
			"ENUM_DIRECTIVE", "METHOD_DIRECTIVE", "END_METHOD_DIRECTIVE", "REGISTERS_DIRECTIVE", 
			"LOCALS_DIRECTIVE", "ARRAY_DATA_DIRECTIVE", "END_ARRAY_DATA_DIRECTIVE", 
			"PACKED_SWITCH_DIRECTIVE", "END_PACKED_SWITCH_DIRECTIVE", "SPARSE_SWITCH_DIRECTIVE", 
			"END_SPARSE_SWITCH_DIRECTIVE", "CATCH_DIRECTIVE", "CATCHALL_DIRECTIVE", 
			"LINE_DIRECTIVE", "PARAMETER_DIRECTIVE", "END_PARAMETER_DIRECTIVE", "LOCAL_DIRECTIVE", 
			"END_LOCAL_DIRECTIVE", "RESTART_LOCAL_DIRECTIVE", "PROLOGUE_DIRECTIVE", 
			"EPILOGUE_DIRECTIVE", "INVALID_TOKEN", "POSITIVE_INTEGER_LITERAL", "NEGATIVE_INTEGER_LITERAL", 
			"LONG_LITERAL", "SHORT_LITERAL", "BYTE_LITERAL", "FLOAT_LITERAL_OR_ID", 
			"DOUBLE_LITERAL_OR_ID", "FLOAT_LITERAL", "DOUBLE_LITERAL", "BOOL_LITERAL", 
			"NULL_LITERAL", "STRING_LITERAL", "CHAR_LITERAL", "REGISTER", "ANNOTATION_VISIBILITY", 
			"ACCESS_SPEC", "VERIFICATION_ERROR_TYPE", "INLINE_INDEX", "VTABLE_INDEX", 
			"FIELD_OFFSET", "METHOD_HANDLE_TYPE_FIELD", "METHOD_HANDLE_TYPE_METHOD", 
			"LINE_COMMENT", "INSTRUCTION_FORMAT10t", "INSTRUCTION_FORMAT10x", "INSTRUCTION_FORMAT10x_ODEX", 
			"INSTRUCTION_FORMAT11n", "INSTRUCTION_FORMAT11x", "INSTRUCTION_FORMAT12x_OR_ID", 
			"INSTRUCTION_FORMAT12x", "INSTRUCTION_FORMAT20bc", "INSTRUCTION_FORMAT20t", 
			"INSTRUCTION_FORMAT21c_FIELD", "INSTRUCTION_FORMAT21c_FIELD_ODEX", "INSTRUCTION_FORMAT21c_STRING", 
			"INSTRUCTION_FORMAT21c_TYPE", "INSTRUCTION_FORMAT21c_METHOD_HANDLE", 
			"INSTRUCTION_FORMAT21c_METHOD_TYPE", "INSTRUCTION_FORMAT21ih", "INSTRUCTION_FORMAT21lh", 
			"INSTRUCTION_FORMAT21s", "INSTRUCTION_FORMAT21t", "INSTRUCTION_FORMAT22b", 
			"INSTRUCTION_FORMAT22c_FIELD", "INSTRUCTION_FORMAT22c_FIELD_ODEX", "INSTRUCTION_FORMAT22c_TYPE", 
			"INSTRUCTION_FORMAT22cs_FIELD", "INSTRUCTION_FORMAT22s_OR_ID", "INSTRUCTION_FORMAT22s", 
			"INSTRUCTION_FORMAT22t", "INSTRUCTION_FORMAT22x", "INSTRUCTION_FORMAT23x", 
			"INSTRUCTION_FORMAT30t", "INSTRUCTION_FORMAT31i_OR_ID", "INSTRUCTION_FORMAT31c", 
			"INSTRUCTION_FORMAT31i", "INSTRUCTION_FORMAT31t", "INSTRUCTION_FORMAT32x", 
			"INSTRUCTION_FORMAT35c_CALL_SITE", "INSTRUCTION_FORMAT35c_METHOD", "INSTRUCTION_FORMAT35c_METHOD_OR_METHOD_HANDLE_TYPE", 
			"INSTRUCTION_FORMAT35c_METHOD_ODEX", "INSTRUCTION_FORMAT35c_TYPE", "INSTRUCTION_FORMAT35mi_METHOD", 
			"INSTRUCTION_FORMAT35ms_METHOD", "INSTRUCTION_FORMAT3rc_CALL_SITE", "INSTRUCTION_FORMAT3rc_METHOD", 
			"INSTRUCTION_FORMAT3rc_METHOD_ODEX", "INSTRUCTION_FORMAT3rc_TYPE", "INSTRUCTION_FORMAT3rmi_METHOD", 
			"INSTRUCTION_FORMAT3rms_METHOD", "INSTRUCTION_FORMAT45cc_METHOD", "INSTRUCTION_FORMAT4rcc_METHOD", 
			"INSTRUCTION_FORMAT51l", "PRIMITIVE_TYPE", "VOID_TYPE", "CLASS_DESCRIPTOR", 
			"ARRAY_TYPE_PREFIX", "PARAM_LIST_OR_ID", "PARAM_LIST", "SIMPLE_NAME", 
			"MEMBER_NAME", "DOTDOT", "ARROW", "EQUAL", "COLON", "COMMA", "OPEN_BRACE", 
			"CLOSE_BRACE", "OPEN_PAREN", "CLOSE_PAREN", "AT", "WHITE_SPACE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Smali.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SmaliParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class SmaliContext extends ParserRuleContext {
		public TerminalNode CLASS_DIRECTIVE() { return getToken(SmaliParser.CLASS_DIRECTIVE, 0); }
		public TerminalNode EOF() { return getToken(SmaliParser.EOF, 0); }
		public SmaliContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_smali; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmaliVisitor ) return ((SmaliVisitor<? extends T>)visitor).visitSmali(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SmaliContext smali() throws RecognitionException {
		SmaliContext _localctx = new SmaliContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_smali);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2);
			match(CLASS_DIRECTIVE);
			setState(3);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\177\b\4\2\t\2\3\2"+
		"\3\2\3\2\3\2\2\2\3\2\2\2\2\6\2\4\3\2\2\2\4\5\7\3\2\2\5\6\7\2\2\3\6\3\3"+
		"\2\2\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}