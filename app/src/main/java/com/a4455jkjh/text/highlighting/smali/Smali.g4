grammar Smali;

smali
  : '.class' EOF
  ;

CLASS_DIRECTIVE: '.class' ;
SUPER_DIRECTIVE: '.super' ;
IMPLEMENTS_DIRECTIVE: '.implements' ;
SOURCE_DIRECTIVE: '.source' ;
FIELD_DIRECTIVE: '.field' ;
END_FIELD_DIRECTIVE: '.end field' ;
SUBANNOTATION_DIRECTIVE: '.subannotation' ;
END_SUBANNOTATION_DIRECTIVE: '.end subannotation' ;
ANNOTATION_DIRECTIVE: '.annotation' ;
END_ANNOTATION_DIRECTIVE: '.end annotation' ;
ENUM_DIRECTIVE: '.enum' ;
METHOD_DIRECTIVE: '.method' ;
END_METHOD_DIRECTIVE: '.end method' ;
REGISTERS_DIRECTIVE: '.registers' ;
LOCALS_DIRECTIVE: '.locals' ;
ARRAY_DATA_DIRECTIVE: '.array-data' ;
END_ARRAY_DATA_DIRECTIVE: '.end array-data' ;
PACKED_SWITCH_DIRECTIVE: '.packed-switch' ;
END_PACKED_SWITCH_DIRECTIVE: '.end packed-switch' ;
SPARSE_SWITCH_DIRECTIVE: '.sparse-switch' ;
END_SPARSE_SWITCH_DIRECTIVE: '.end sparse-switch' ;
CATCH_DIRECTIVE: '.catch' ;
CATCHALL_DIRECTIVE: '.catchall' ;
LINE_DIRECTIVE: '.line' ;
PARAMETER_DIRECTIVE: '.param' ;
END_PARAMETER_DIRECTIVE: '.end param' ;
LOCAL_DIRECTIVE: '.local' ;
END_LOCAL_DIRECTIVE: '.end local' ;
RESTART_LOCAL_DIRECTIVE: '.restart local' ;
PROLOGUE_DIRECTIVE: '.prologue' ;
EPILOGUE_DIRECTIVE: '.epilogue' ;

INVALID_TOKEN
  : Invalid -> channel(HIDDEN)
  ;

/*Literals*/
POSITIVE_INTEGER_LITERAL
  : Integer
  ;

NEGATIVE_INTEGER_LITERAL
  : '-' Integer
  ;
LONG_LITERAL
  : '-'? Integer [lL]
  ;

SHORT_LITERAL
  : '-'? Integer [sS]
  ;

BYTE_LITERAL
  : '-'? Integer [tT]
  ;

FLOAT_LITERAL_OR_ID
  : FloatOrID [fF]
  | '-'? [0-9]+ [fF] 
  ;

DOUBLE_LITERAL_OR_ID
  : FloatOrID [dD]?
  | '-'? [0-9]+ [dD] 
  ;

FLOAT_LITERAL
  : Float [Ff]
  ;

DOUBLE_LITERAL
  : Float [dD]?
  ;

BOOL_LITERAL
  : 'true'
  | 'false'
  ;

NULL_LITERAL
  : 'null'
  ;
STRING_LITERAL
  : '"' STRING_CHAR* '"'
  ;
CHAR_LITERAL
  : '\'' CHAR_CHAR '\''
  ;
  
/*Misc*/
REGISTER
  : [vp] [0-9]+
  ;

ANNOTATION_VISIBILITY
  : 'build'
  | 'runtime'
  | 'system'
  ;

ACCESS_SPEC
  : 'public'
  | 'private'
  | 'protected'
  | 'static'
  | 'final'
  | 'synchronized'
  | 'bridge'
  | 'varargs'
  | 'native'
  | 'abstract'
  | 'strictfp'
  | 'synthetic'
  | 'constructor'
  | 'declared-synchronized'
  | 'interface'
  | 'enum'
  | 'annotation'
  | 'volatile'
  | 'transient'
  ;

VERIFICATION_ERROR_TYPE
  : 'no-error'
  | 'generic-error'
  | 'no-such-class'
  | 'no-such-field'
  | 'no-such-method'
  | 'illegal-class-access'
  | 'illegal-field-access'
  | 'illegal-method-access'
  | 'class-change-error'
  | 'instantiation-error'
  ;

INLINE_INDEX
  : 'inline@0x' HexDigit+
  ;

VTABLE_INDEX
  : 'vtable@0x' HexDigit+
  ;

FIELD_OFFSET
  : 'field@0x' HexDigit+
  ;

METHOD_HANDLE_TYPE_FIELD
  : 'static-put'
  | 'static-get'
  | 'instance-put'
  | 'instance-get'
  ;

METHOD_HANDLE_TYPE_METHOD
  : 'invoke-instance'
  | 'invoke-constructor'
  ;

LINE_COMMENT
  : '#' ~[\r\n]* -> channel(HIDDEN)
  ;

/*Instructions*/
INSTRUCTION_FORMAT10t
  : 'goto'
  ;
INSTRUCTION_FORMAT10x
  : 'return-void'
  | 'nop'
  ;
INSTRUCTION_FORMAT10x_ODEX
  : 'return-void-barrier'
  | 'return-void-no-barrier'
  ;
INSTRUCTION_FORMAT11n
  : 'const/4'
  ;
INSTRUCTION_FORMAT11x
  : 'move-result'
  | 'move-result-wide'
  | 'move-result-object'
  | 'move-exception'
  | 'return'
  | 'return-wide'
  | 'return-object'
  | 'monitor-enter'
  | 'monitor-exit'
  | 'throw'
  ;
INSTRUCTION_FORMAT12x_OR_ID
  : 'move'
  | 'move-wide'
  | 'move-object'
  | 'array-length'
  | 'neg-int'
  | 'not-int'
  | 'neg-long'
  | 'not-long'
  | 'neg-float'
  | 'neg-double'
  | 'int-to-long'
  | 'int-to-float'
  | 'int-to-double'
  | 'long-to-int'
  | 'long-to-float'
  | 'long-to-double'
  | 'float-to-int'
  | 'float-to-long'
  | 'float-to-double'
  | 'double-to-int'
  | 'double-to-long'
  | 'double-to-float'
  | 'int-to-byte'
  | 'int-to-char'
  | 'int-to-short'
  ;
INSTRUCTION_FORMAT12x
  : 'add-int/2addr'
  | 'sub-int/2addr'
  | 'mul-int/2addr'
  | 'div-int/2addr'
  | 'rem-int/2addr'
  | 'and-int/2addr'
  | 'or-int/2addr'
  | 'xor-int/2addr'
  | 'shl-int/2addr'
  | 'shr-int/2addr'
  | 'ushr-int/2addr'
  | 'add-long/2addr'
  | 'sub-long/2addr'
  | 'mul-long/2addr'
  | 'div-long/2addr'
  | 'rem-long/2addr'
  | 'and-long/2addr'
  | 'or-long/2addr'
  | 'xor-long/2addr'
  | 'shl-long/2addr'
  | 'shr-long/2addr'
  | 'ushr-long/2addr'
  | 'add-float/2addr'
  | 'sub-float/2addr'
  | 'mul-float/2addr'
  | 'div-float/2addr'
  | 'rem-float/2addr'
  | 'add-double/2addr'
  | 'sub-double/2addr'
  | 'mul-double/2addr'
  | 'div-double/2addr'
  | 'rem-double/2addr'
  ;
INSTRUCTION_FORMAT20bc
  : 'throw-verification-error'
  ;
INSTRUCTION_FORMAT20t
  : 'goto/16'
  ;
INSTRUCTION_FORMAT21c_FIELD
  : 'sget'
  | 'sget-wide'
  | 'sget-object'
  | 'sget-boolean'
  | 'sget-byte'
  | 'sget-char'
  | 'sget-short'
  | 'sput'
  | 'sput-wide'
  | 'sput-object'
  | 'sput-boolean'
  | 'sput-byte'
  | 'sput-char'
  | 'sput-short'
  ;
INSTRUCTION_FORMAT21c_FIELD_ODEX
  : 'sget-volatile'
  | 'sget-wide-volatile'
  | 'sget-object-volatile'
  | 'sput-volatile'
  | 'sput-wide-volatile'
  | 'sput-object-volatile'
  ;
INSTRUCTION_FORMAT21c_STRING
  : 'const-string'
  ;
INSTRUCTION_FORMAT21c_TYPE
  : 'check-cast'
  | 'new-instance'
  | 'const-class'
  ;
INSTRUCTION_FORMAT21c_METHOD_HANDLE
  : 'const-method-handle'
  ;
INSTRUCTION_FORMAT21c_METHOD_TYPE
  : 'const-method-type'
  ;
INSTRUCTION_FORMAT21ih
  : 'const/high16'
  ;
INSTRUCTION_FORMAT21lh
  : 'const-wide/high16'
  ;
INSTRUCTION_FORMAT21s
  : 'const/16'
  | 'const-wide/16'
  ;
INSTRUCTION_FORMAT21t
  : 'if-eqz'
  | 'if-nez'
  | 'if-ltz'
  | 'if-gez'
  | 'if-gtz'
  | 'if-lez'
  ;
INSTRUCTION_FORMAT22b
  : 'add-int/lit8'
  | 'rsub-int/lit8'
  | 'mul-int/lit8'
  | 'div-int/lit8'
  | 'rem-int/lit8'
  | 'and-int/lit8'
  | 'or-int/lit8'
  | 'xor-int/lit8'
  | 'shl-int/lit8'
  | 'shr-int/lit8'
  | 'ushr-int/lit8'
  ;
INSTRUCTION_FORMAT22c_FIELD
  : 'iget'
  | 'iget-wide'
  | 'iget-object'
  | 'iget-boolean'
  | 'iget-byte'
  | 'iget-char'
  | 'iget-short'
  | 'iput'
  | 'iput-wide'
  | 'iput-object'
  | 'iput-boolean'
  | 'iput-byte'
  | 'iput-char'
  | 'iput-short'
  ;
INSTRUCTION_FORMAT22c_FIELD_ODEX
  : 'iget-volatile'
  | 'iget-wide-volatile'
  | 'iget-object-volatile'
  | 'iput-volatile'
  | 'iput-wide-volatile'
  | 'iput-object-volatile'
  ;
INSTRUCTION_FORMAT22c_TYPE
  : 'instance-of'
  | 'new-array'
  ;
INSTRUCTION_FORMAT22cs_FIELD
  : 'iget-quick'
  | 'iget-wide-quick'
  | 'iget-object-quick'
  | 'iput-quick'
  | 'iput-wide-quick'
  | 'iput-object-quick'
  | 'iput-boolean-quick'
  | 'iput-byte-quick'
  | 'iput-char-quick'
  | 'iput-short-quick'
  ;
INSTRUCTION_FORMAT22s_OR_ID
  : 'rsub-int'
  ;
INSTRUCTION_FORMAT22s
  : 'add-int/lit16'
  | 'mul-int/lit16'
  | 'div-int/lit16'
  | 'rem-int/lit16'
  | 'and-int/lit16'
  | 'or-int/lit16'
  | 'xor-int/lit16'
  ;
INSTRUCTION_FORMAT22t
  : 'if-eq'
  | 'if-ne'
  | 'if-lt'
  | 'if-ge'
  | 'if-gt'
  | 'if-le'
  ;
INSTRUCTION_FORMAT22x
  : 'move/from16'
  | 'move-wide/from16'
  | 'move-object/from16'
  ;
INSTRUCTION_FORMAT23x
  : 'cmpl-float'
  | 'cmpg-float'
  | 'cmpl-double'
  | 'cmpg-double'
  | 'cmp-long'
  | 'aget'
  | 'aget-wide'
  | 'aget-object'
  | 'aget-boolean'
  | 'aget-byte'
  | 'aget-char'
  | 'aget-short'
  | 'aput'
  | 'aput-wide'
  | 'aput-object'
  | 'aput-boolean'
  | 'aput-byte'
  | 'aput-char'
  | 'aput-short'
  | 'add-int'
  | 'sub-int'
  | 'mul-int'
  | 'div-int'
  | 'rem-int'
  | 'and-int'
  | 'or-int'
  | 'xor-int'
  | 'shl-int'
  | 'shr-int'
  | 'ushr-int'
  | 'add-long'
  | 'sub-long'
  | 'mul-long'
  | 'div-long'
  | 'rem-long'
  | 'and-long'
  | 'or-long'
  | 'xor-long'
  | 'shl-long'
  | 'shr-long'
  | 'ushr-long'
  | 'add-float'
  | 'sub-float'
  | 'mul-float'
  | 'div-float'
  | 'rem-float'
  | 'add-double'
  | 'sub-double'
  | 'mul-double'
  | 'div-double'
  | 'rem-double'
  ;
INSTRUCTION_FORMAT30t
  : 'goto/32'
  ;
INSTRUCTION_FORMAT31i_OR_ID
  : 'const'
  ;
INSTRUCTION_FORMAT31c
  : 'const-string/jumbo'
  ;
INSTRUCTION_FORMAT31i
  : 'const-wide/32'
  ;
INSTRUCTION_FORMAT31t
  : 'fill-array-data'
  | 'packed-switch'
  | 'sparse-switch'
  ;
INSTRUCTION_FORMAT32x
  : 'move/16'
  | 'move-wide/16'
  | 'move-object/16'
  ;
INSTRUCTION_FORMAT35c_CALL_SITE
  : 'invoke-custom'
  ;
INSTRUCTION_FORMAT35c_METHOD
  : 'invoke-virtual'
  | 'invoke-super'
  ;
INSTRUCTION_FORMAT35c_METHOD_OR_METHOD_HANDLE_TYPE
  : 'invoke-direct'
  | 'invoke-static'
  | 'invoke-interface'
  ;
INSTRUCTION_FORMAT35c_METHOD_ODEX
  : 'invoke-direct-empty'
  ;
INSTRUCTION_FORMAT35c_TYPE
  : 'filled-new-array'
  ;
INSTRUCTION_FORMAT35mi_METHOD
  : 'execute-inline'
  ;
INSTRUCTION_FORMAT35ms_METHOD
  : 'invoke-virtual-quick'
  | 'invoke-super-quick'
  ;
INSTRUCTION_FORMAT3rc_CALL_SITE
  : 'invoke-custom/range'
  ;
INSTRUCTION_FORMAT3rc_METHOD
  : 'invoke-virtual/range'
  | 'invoke-super/range'
  | 'invoke-direct/range'
  | 'invoke-static/range'
  | 'invoke-interface/range'
  ;
INSTRUCTION_FORMAT3rc_METHOD_ODEX
  : 'invoke-object-init/range'
  ;
INSTRUCTION_FORMAT3rc_TYPE
  : 'filled-new-array/range'
  ;
INSTRUCTION_FORMAT3rmi_METHOD
  : 'execute-inline/range'
  ;
INSTRUCTION_FORMAT3rms_METHOD
  : 'invoke-virtual-quick/range'
  | 'invoke-super-quick/range'
  ;
INSTRUCTION_FORMAT45cc_METHOD
  : 'invoke-polymorphic'
  ;
INSTRUCTION_FORMAT4rcc_METHOD
  : 'invoke-polymorphic/range'
  ;
INSTRUCTION_FORMAT51l
  : 'const-wide'
  ;

/*Types*/
PRIMITIVE_TYPE
  : PrimitiveType
  ;
VOID_TYPE
  : 'V'
  ;
CLASS_DESCRIPTOR
  : ClassDescriptor
  ;
ARRAY_TYPE_PREFIX
  : ArrayPrefix
  ;
PARAM_LIST_OR_ID
  : PrimitiveType PrimitiveType+
  ;
PARAM_LIST
  : Type Type+
  ;
SIMPLE_NAME
  : SimpleNameRaw
  | SimpleNameQuoted
  | SimpleNameQuotedWithSpaces
  ;
MEMBER_NAME
  : '<' SimpleNameRaw '>'
  ;
  
/*Symbols/Whitespace/EOF*/
DOTDOT: '..' ;
ARROW: '->' ;
EQUAL: '=' ;
COLON: ':' ;
COMMA: ',' ;
OPEN_BRACE: '{' ;
CLOSE_BRACE: '}' ;
OPEN_PAREN: '(' ;
CLOSE_PAREN: ')' ;
AT: '@' ;
WHITE_SPACE: [\r\n\t ]+ -> skip ;
UNKNOWN
  : ( '.' ([a-zA-Z\-_] [a-zA-Z0-9\-_]?)?
    | .
    ) -> type(INVALID_TOKEN), channel(HIDDEN)
  ;

fragment
Invalid
  : '.end'
  | '.end ' [a-zA-Z0-9\-_]+
  | '.restart'
  | '.restart ' [a-zA-Z0-9\-_]+
  ;

fragment
HexPrefix
  : '0' [xX]
  ;

fragment
HexDigit
  : [0-9a-fA-F]
  ;

fragment
HexDigits
  : HexDigit HexDigit HexDigit HexDigit
  ;

fragment
FewerHexDigits
  : HexDigit ( HexDigit HexDigit?)?
  ;

fragment
Integer1 : '0' ;

fragment
Integer2
  : [1-9] [0-9]*
  ;

fragment
Integer3
  : '0' [0-7]+
  ;

fragment
Integer4
  : HexPrefix HexDigit+
  ;

fragment
Integer
  : Integer1
  | Integer2
  | Integer3
  | Integer4
  ;

fragment
DecimalExponent
  : [eE] '-'? [0-9]+
  ;

fragment
BinaryExponent
  : [pP] '-'? [0-9]+
  ;

/*This can either be a floating point number or an identifier*/
fragment
FloatOrID1
  : '-'? [0-9]+ DecimalExponent
  ;

fragment
FloatOrID2
  : '-'? HexPrefix HexDigit+ BinaryExponent
  ;

fragment
FloatOrID3
  : '-'? [iI][nN][fF][iI][nN][iI][tT][yY]
  ;

fragment
FloatOrID4
  : [nN][aA][nN]
  ;

fragment
FloatOrID
  : FloatOrID1
  | FloatOrID2
  | FloatOrID3
  | FloatOrID4
  ;


/*This can only be a float and not an identifier, due to the decimal point*/
fragment
Float1
  : '-'? [0-9]+ '.' [0-9]* DecimalExponent?
  ;

fragment
Float2
  : '-'? '.' [0-9]+ DecimalExponent?
  ;

fragment
Float3
  : '-'? HexPrefix HexDigit+ '.' HexDigit* BinaryExponent
  ;

fragment
Float4
  : '-'? HexPrefix '.' HexDigit+ BinaryExponent
  ;

fragment
Float
  : Float1
  | Float2
  | Float3
  | Float4
  ;

fragment
HighSurrogate 
  : [\ud800-\udbff]
  ;

fragment
LowSurrogate
  : [\udc00-\udfff]
  ;

fragment
SimpleNameCharacter
  : HighSurrogate LowSurrogate
  | [A-Za-z0-9$\-_\u00a1-\u1fff\u2010-\u2027\u2030-\ud7ff\ue000-\uffef]
  ;

fragment
UnicodeSpace
  : [\u0020\u00A0\u1680\u2000-\u200A\u202F\u205F\u3000] /* Zs category */
  ;

fragment
SimpleNameRaw
  : SimpleNameCharacter+
  ;

fragment
SimpleNameQuoted
  : '`' SimpleNameCharacter+ '`'
  ;

fragment
SimpleNameQuotedWithSpaces
  : '`' (SimpleNameCharacter | UnicodeSpace)+ '`'
  ;

fragment
SimpleName
  : SimpleNameRaw
  | SimpleNameQuoted
  | SimpleNameQuotedWithSpaces
  ;

fragment
PrimitiveType
  : [ZBSCIJFD]
  ;

fragment
ClassDescriptor
  : 'L' (SimpleName '/')* SimpleName ';'
  ;

fragment
ArrayPrefix
  : '['+
  ;

fragment
Type
  : PrimitiveType
  | ClassDescriptor
  | ArrayPrefix (ClassDescriptor | PrimitiveType)
  ;

fragment
STRING_CHAR
  : ~[\r\n"\\]
  | '\\' [btnfr'"\\]
  | '\\u' HexDigits
  ;

fragment
CHAR_CHAR
  : ~[\r\n'\\]
  | '\\' [btnfr'"\\]
  | '\\u' HexDigits
  ;

