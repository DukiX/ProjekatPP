package rs.ac.bg.etf.pp1;

import java_cup.runtime.Symbol;

%%

%{

	// ukljucivanje informacije o poziciji tokena
	private Symbol new_symbol(int type) {
		return new Symbol(type, yyline+1, yycolumn);
	}
	
	// ukljucivanje informacije o poziciji tokena
	private Symbol new_symbol(int type, Object value) {
		return new Symbol(type, yyline+1, yycolumn, value);
	}

%}

%cup
%line
%column

%xstate COMMENT

%eofval{
	return new_symbol(sym.EOF);
%eofval}

%%

" " 	{ }
"\b" 	{ }
"\t" 	{ }
"\r\n" 	{ }
"\f" 	{ }


"program"   { return new_symbol(sym.PROG, yytext()); }
"print" 	{ return new_symbol(sym.PRINT, yytext()); }
"return" 	{ return new_symbol(sym.RETURN, yytext()); }
"void" 		{ return new_symbol(sym.VOID, yytext()); }
<YYINITIAL> "+" 		{ return new_symbol(sym.PLUS, yytext()); }
"=" 		{ return new_symbol(sym.EQUAL, yytext()); }
";" 		{ return new_symbol(sym.SEMI, yytext()); }
"," 		{ return new_symbol(sym.COMMA, yytext()); }
"(" 		{ return new_symbol(sym.LPAREN, yytext()); }
")" 		{ return new_symbol(sym.RPAREN, yytext()); }
"{" 		{ return new_symbol(sym.LBRACE, yytext()); }
"}"			{ return new_symbol(sym.RBRACE, yytext()); }
"++"		{ return new_symbol(sym.INCREMENT, yytext()); }
"--"		{ return new_symbol(sym.DECREMENT, yytext()); }
"read"		{ return new_symbol(sym.READ, yytext()); }
<YYINITIAL> "-" 		{ return new_symbol(sym.MINUS, yytext()); }
<YYINITIAL> "*" 		{ return new_symbol(sym.MUL, yytext()); }
<YYINITIAL> "/" 		{ return new_symbol(sym.DIV, yytext()); }
<YYINITIAL> "%" 		{ return new_symbol(sym.MOD, yytext()); }
"'"[\040-\176]"'" {return new_symbol (sym.CHARCONST, new Character (yytext().charAt(1)));}
"True" 		{ return new_symbol(sym.TRUE, yytext()); }
"False" 		{ return new_symbol(sym.FALSE, yytext()); }
"new"		{ return new_symbol(sym.NEW, yytext()); }
"[" 		{ return new_symbol(sym.LSQUARE, yytext()); }
"]" 		{ return new_symbol(sym.RSQUARE, yytext()); }
"." 		{ return new_symbol(sym.DOT, yytext()); }
"for"		{ return new_symbol(sym.FOR, yytext()); }
"break"		{ return new_symbol(sym.BREAK, yytext()); }
"continue"		{ return new_symbol(sym.CONTINUE, yytext()); }
"&&"		{ return new_symbol(sym.AND, yytext()); }
"||"		{ return new_symbol(sym.OR, yytext()); }

"=="		{ return new_symbol(sym.EQ, yytext()); }
"!="		{ return new_symbol(sym.NE, yytext()); }
">"			{ return new_symbol(sym.GT, yytext()); }
"<"			{ return new_symbol(sym.LT, yytext()); }
">="		{ return new_symbol(sym.GE, yytext()); }
"<="		{ return new_symbol(sym.LE, yytext()); }

"if"		{ return new_symbol(sym.IF, yytext()); }
"else"		{ return new_symbol(sym.ELSE, yytext()); }


<YYINITIAL> "//" 		     { yybegin(COMMENT); }
<COMMENT> .      { yybegin(COMMENT); }
<COMMENT> "\r\n" { yybegin(YYINITIAL); }

[0-9]+  { return new_symbol(sym.NUMBER, new Integer (yytext())); }
([a-z]|[A-Z])[a-z|A-Z|0-9|_]* 	{return new_symbol (sym.IDENT, yytext()); }

. { System.err.println("Leksicka greska ("+yytext()+") u liniji "+(yyline+1)+" u koloni "+(yycolumn+1)); }






