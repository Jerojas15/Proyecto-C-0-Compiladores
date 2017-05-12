package steps;

import java_cup.runtime.Symbol;
%%

%public
%class Lexer
%cup
%line
%column

%{
      /*private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
      }
      private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
      }*/
%}

Int             =	[0-9]+
Identifier      =       [A-Za-z]+[0-9]*
WhiteSpace      =       [ \n\t]+

%%
<YYINITIAL> {

	"+"				{System.out.println("MAS");/*return symbol(sym.PLUS);*/}
	"-"				{System.out.println("MENOS");/*return symbol(sym.MINUS);*/}
	"*"				{System.out.println("POR");/*return symbol(sym.TIMES);*/}
	"/"				{System.out.println("ENTRE");/*return symbol(sym.DIVIDE);*/}
	"("				{System.out.println("LPAR");/*return symbol(sym.LPAREN);*/}
	")"				{System.out.println("RPAR");/*return symbol(sym.RPAREN);*/}
        ">"                             {System.out.println("MAYOR");/*return symbol(sym.MORE);*/}
	"<"                             {System.out.println("MENOR");/*return symbol(sym.LESS);*/}
        "=="                            {System.out.println("IGUAL");/*return symbol(sym.EQUAL);*/}
        "!="                            {System.out.println("DIF");/*return symbol(sym.DIF);*/}
        "&&"                            {System.out.println("AND");/*return symbol(sym.AND);*/}
        "||"                            {System.out.println("OR");/*return symbol(sym.OR);*/}
        "="                             {System.out.println("ASIG");/*return symbol(sym.ASSIGN);*/}
        "{"                             {System.out.println("LKEY");/*return symbol(sym.LKEY);*/}
        "}"                             {System.out.println("RKEY");/*return symbol(sym.RKEY);*/}
        ";"                             {System.out.println("ENDL");/*return symbol(sym.ENDL);*/}
        {Int}                           {System.out.println("INT");/*return symbol(sym.INT, new Integer(yytext()));*/}
	{Identifier}                    {System.out.println("Identifier");/*return symbol(sym.IDEN, yytext();)*/}
	{WhiteSpace}	{}

}
.			{System.out.print("error! Character not recognized");}


<<EOF>> { System.out.println("Fin");/*return symbol(sym.EOF);*/ }


