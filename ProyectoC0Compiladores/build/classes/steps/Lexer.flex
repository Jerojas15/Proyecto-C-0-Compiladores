package steps;

import java_cup.runtime.Symbol;
import java_cup.runtime.SymbolFactory;
%%

%public
%class Lexer
%cup
%char
%line
%column

%{
	public Lexer(java.io.Reader in, SymbolFactory sf){
		this(in);
		this.sf=sf;
	}
	private SymbolFactory sf;
%}
%eofval{
    return sf.newSymbol("EOF",sym.EOF);
%eofval}

LETTER= [a-zA-Z]
DIGIT = [0-9]
NUMBER = {DIGIT}+
SYMBOLS = [!*\\\:+-=<>,.;:/]
IDENTIFIER = {LETTER}({DIGIT}|{LETTER})*
WHITESPACE = [ \r\n\t\f]
CONSTANT = \"([a-zA-Z0-9]|{WHITESPACE}|{SYMBOLS})*\"
BOOL = "true" | "false"

%%
<YYINITIAL> {
        
        {WHITESPACE} {/* ignore */}
        {BOOL} {
            return sf.newSymbol("BOOLEAN ",sym.BOOLEAN, new Boolean(yytext()));
        }
        {NUMBER} {
            return sf.newSymbol("INTEGER ",sym.INTEGER,new Integer(yytext()));
        }
        "main" { 
            return sf.newSymbol("MAIN ",sym.MAIN);
        }
        "if" { 
            return sf.newSymbol("IF ",sym.IF);
        }
        "while" { 
            return sf.newSymbol("WHILE ",sym.WHILE);
        }
        "else" { 
            return sf.newSymbol("ELSE ",sym.ELSE);
        }
        "putw" { 
            return sf.newSymbol("PUTW ",sym.PUTW);
        }
        "puts" { 
            return sf.newSymbol("PUTS ",sym.PUTS);
        }
        "int" { 
            return sf.newSymbol("INT ",sym.INT);
        }
        "break" { 
            return sf.newSymbol("BREAK ",sym.BREAK);
        }
        "(" { 
            return sf.newSymbol("LPAR ",sym.LPAR);
        }
        ")" { 
            return sf.newSymbol("RPAR ",sym.RPAR);
        }
        "{" { 
            return sf.newSymbol("LKEY ",sym.LKEY);
        }
        "}" { 
            return sf.newSymbol("RKEY ",sym.RKEY);
        }
        ";" { 
            return sf.newSymbol("SEMICOLON ",sym.SEMICOLON);
        }
        "+" { 
            return sf.newSymbol("PLUS ",sym.PLUS);
        }
        "-" { 
            return sf.newSymbol("MINUS ",sym.MINUS);
        }
        "*" { 
            return sf.newSymbol("TIMES ",sym.TIMES);
        }
        "/" { 
            return sf.newSymbol("DIVIDE ",sym.DIVIDE);
        }
        "<" { 
            return sf.newSymbol("LESS ",sym.LESS);
        }
        ">" { 
            return sf.newSymbol("MORE ",sym.MORE);
        }
        "==" { 
            return sf.newSymbol("EQUAL ",sym.EQUAL);
        }
        "¡=" { 
            return sf.newSymbol("NOTEQUAL ",sym.NOTEQUAL);
        }
        "||" { 
            return sf.newSymbol("OR ",sym.OR);
        }
        "&&" { 
            return sf.newSymbol("AND ",sym.AND);
        }
        "=" { 
            return sf.newSymbol("ASIGN ",sym.ASIGN);
        }
        {CONSTANT} {
            return sf.newSymbol("CONSTANT ",sym.CONSTANT,yytext());
        }  
        {IDENTIFIER} {
            return sf.newSymbol("IDENTIFIER ",sym.IDENTIFIER, yytext());
        }
}
. {System.out.print("error! Character not recognized "+yytext());}
