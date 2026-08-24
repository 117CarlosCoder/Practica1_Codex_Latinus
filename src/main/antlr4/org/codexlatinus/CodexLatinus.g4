grammar CodexLatinus;

program: globalVarsSection? functionsSection? mainSection EOF;

globalVarsSection:
	'VARIABILES>' (
		varDecl
		| arrayDecl
		| structDecl
		| structVarDecl
	)*;

functionsSection: 'MUNERA>' functionDecl*;

mainSection: 'MAIOR>' statement* ('FINIS' ';'? | 'finis' ';')?;

varDecl: 'esto' Identifier ':' primitiveType ('='? expr)? ';'?;

arrayDecl:
	'series' Identifier ('[' expr? ']')? (':' primitiveType)? (
		'='? arrayInit
	)? ';'?
	| 'series' Identifier ('[' expr? ']')? ':' arrayInit ';'?;

arrayInit: '{' exprList? '}' | '(' exprList? ')';

structDecl:
	'structura' Identifier '{' structMember* '}' (
		'finis' ';'?
		| ';'
	)?;

structMember: ('esto' | 'series')? Identifier ('[' expr? ']')? ':' primitiveType (
		','
		| ';'
	)?;

structInit: '{' structAttrAssignList? '}';

structVarDecl:
	'esto' Identifier ':' Identifier ('='? structInit)? ';'?;

structAttrAssignList:
	structAttrAssign ((',' | ';') structAttrAssign)* (',' | ';')?;

structAttrAssign:
	Identifier ':' (
		Identifier '[' expr ']' ('='? (structInit | arrayInit))?
		| expr
	)
	| Identifier '=' expr;

primitiveType:
	'numerus'
	| 'decimalis'
	| 'textum'
	| 'littera'
	| 'bool'
	| 'boolean'
	| BOOL_LITERAL
	| Identifier;

functionDecl:
	'actio' Identifier '(' formalParameters? ')' '{' funcVarSection? statement* '}' (
		'finis' ';'?
	)?
	| 'ratio' (primitiveType | 'void') Identifier '(' formalParameters? ')' '{' funcVarSection?
		statement* '}' ('finis' ';'?)?;

funcVarSection:
	'VARIABILES[' (
		varDecl
		| arrayDecl
		| structDecl
		| structVarDecl
	)* ']';

formalParameters: formalParameter (',' formalParameter)*;

formalParameter: 'esto' Identifier ':' primitiveType;

statement:
	blockStmt
	| varDecl
	| arrayDecl
	| structDecl
	| structVarDecl
	| ifStmt
	| whileStmt
	| doWhileStmt
	| forStmt
	| returnStmt
	| breakStmt
	| continueStmt
	| printStmt
	| readStmt
	| assignStmt
	| exprStmt;

blockStmt: '{' statement* '}';

ifStmt:
	'si' '(' expr ')' '{' statement* '}' (
		'aliter' ('si')? '(' expr ')' '{' statement* '}'
	)* ('aliter' '{' statement* '}')? ('finis' ';'?)?;

whileStmt:
	'dum' '(' expr ')' '{' statement* '}' ('finis' ';'?)?;

doWhileStmt:
	'facere' '{' statement* '}' 'dum' '(' expr ')' ';'? (
		'finis' ';'?
	)?;

forStmt:
	'per' '(' forInit? ';' expr? ';' forUpdate? ')' '{' statement* '}' (
		'finis' ';'?
	)?;

forInit:
	'esto' Identifier ':' primitiveType ('='? expr)?
	| lvalue '=' expr
	| expr;

forUpdate: lvalue ('++' | '--') | lvalue '=' expr | expr;

returnStmt: 'reddere' expr? ';'?;

breakStmt: 'interrumpe' ';'?;

continueStmt: 'perge' ';'?;

printStmt: '>>' expr (('>>' | ',') expr)* ';'?;

readStmt:
	'<<' ';'?
	| lvalue '<<' ';'?
	| '<<' lvalue ';'?
	| Identifier '<<' ';'?
	| '<<' Identifier ';'?;

assignStmt: lvalue '=' expr ';'? | lvalue ('++' | '--') ';'?;

lvalue:
	Identifier ('[' expr ']')? ('.' Identifier ('[' expr ']')?)*;

exprStmt: expr ';'?;

expr:
	'(' expr ')'									# ParenExpr
	| Identifier '(' arguments? ')'					# FunctionCallExpr
	| op = ('non' | '!' | '+' | '-') expr			# UnaryExpr
	| expr op = ('*' | '/' | '%') expr				# MultiplicativeExpr
	| expr op = ('+' | '-') expr					# AdditiveExpr
	| expr op = ('<' | '>' | '<=' | '>=') expr		# RelationalExpr
	| expr op = ('===' | '==' | '!=' | '=') expr	# EqualityExpr
	| expr '&&' expr								# LogicalAndExpr
	| expr '||' expr								# LogicalOrExpr
	| lvalue '=' expr								# AssignExpr
	| lvalue ('++' | '--')							# PostIncDecExpr
	| lvalue										# LvalueExpr
	| primary										# PrimaryExpr;

exprList: expr (',' expr)*;

arguments: expr (',' expr)*;

primary:
	literal
	| BOOL_LITERAL
	| Identifier
	| arrayInit
	| structInit;

literal:
	INT_LITERAL
	| DOUBLE_LITERAL
	| STRING_LITERAL
	| CHAR_LITERAL;

BOOL_LITERAL: 'verum' | 'falsus';

INT_LITERAL: [0-9]+;

DOUBLE_LITERAL: [0-9]+ '.' [0-9]+;

STRING_LITERAL:
	'"' (~["\\\r\n] | '\\' .)* '"'
	| '“' (~[”\\\r\n] | '\\' .)* '”';

CHAR_LITERAL:
	'\'' (~['\\\r\n] | '\\' .) '\''
	| '‘' (~[’\\\r\n] | '\\' .) '’';

Identifier: [a-zA-Z_][a-zA-Z0-9_]*;

WS: [ \t\r\n]+ -> skip;

LINE_COMMENT: ('//' | '#') ~[\r\n]* -> skip;

BLOCK_COMMENT: ('/*' .*? '*/' | '##' .*? '##') -> skip;
