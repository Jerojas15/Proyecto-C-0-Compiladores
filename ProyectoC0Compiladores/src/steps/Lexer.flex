package steps;

import java_cup.runtime.Symbol;
%%

%public
%class Lexer
%cup
%line
%column

%{
      private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
      }
      private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
      }
%}

LETTER= [a-zA-Z]
DIGIT = [0-9]
NUMBER = {DIGIT}+
IDENTIFIER = {LETTER} | _ ({LETTER} | {DIGIT})*
WHITESPACE = [ \r\n\t\f]
CONSTANT = ".*"

KEYWORD = "main"
|"if"
|"while"
|"else"
|"putw"
|"puts"
|"int"
|"break"


%%
<YYINITIAL> {
        
        {WHITESPACE} {/* ignore */}
        {KEYWORD} { 
            return symbol( sym.KEYWORD, yytext());
        }
        {IDENTIFIER} {
            return symbol( sym.IDENTIFIER, yytext());
        }
        {NUMBER} {
            return symbol( sym.INTEGER , new Integer(yytext()));
        }
        {CONSTANT} {
            return symbol( sym.CONSTANT,yytext());
        }
        "(" { 
            return symbol( sym.LPAR);
        }
        ")" { 
            return symbol( sym.RPAR);
        }
        "{" { 
            return symbol( sym.LKEY);
        }
        "}" { 
            return symbol( sym.RKEY);
        }
        ";" { 
            return symbol( sym.SEMICOLON);
        }
        "+" { 
            return symbol( sym.PLUS);
        }
        "-" { 
            return symbol( sym.MINUS);
        }
        "*" { 
            return symbol( sym.TIMES);
        }
        "/" { 
            return symbol( sym.DIVIDE);
        }
        "<" { 
            return symbol( sym.LESS);
        }
        ">" { 
            return symbol( sym.MORE);
        }
        "==" { 
            return symbol( sym.EQUAL);
        }
        "¡=" { 
            return symbol( sym.NOTEQUAL);
        }
        "||" { 
            return symbol( sym.OR);
        }
        "&&" { 
            return symbol( sym.AND);
        }
        "=" { 
            return symbol( sym.ASIGN);
        }  	      
}
. {System.out.print("error! Character not recognized");}
<<EOF>> { System.out.println("Fin");return symbol(sym.EOF);}
