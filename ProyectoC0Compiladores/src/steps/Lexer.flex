package steps;

import structures.Token.*;
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

%{
public List<Token> tokens;
%}


%%
<YYINITIAL> {
        
        {WHITESPACE} {/* ignore */}
        {KEYWORD} { 
            tokens.add(new Token("KEYWORD",yytext()));
            return KEYWORD;
        }
        {IDENTIFIER} {
            tokens.add(new Token("IDENTIFIER",yytext()));
            return IDENTIFIER;
        }
        {NUMBER} {
            tokens.add(new Token("INTEGER",yytext()));
            return INTEGER;
        }
        {CONSTANT} {
            tokens.add(new Token("CONSTANT",yytext()));
            return CONSTANT;
        }
        "(" { 
            tokens.add(new Token("DELIM",yytext()));
            return LPAR;
        }
        ")" { 
            tokens.add(new Token("DELIM",yytext()));
            return RPAR;
        }
        "{" { 
            tokens.add(new Token("DELIM",yytext()));
            return LKEY;
        }
        "}" { 
            tokens.add(new Token("DELIM",yytext()));
            return RKEY;
        }
        ";" { 
            tokens.add(new Token("DELIM",yytext()));
            return SEMICOLON;
        }
        "+" { 
            tokens.add(new Token("ARITOP",yytext()));
            return PLUS;
        }
        "-" { 
            tokens.add(new Token("ARITOP",yytext()));
            return MINUS;
        }
        "*" { 
            tokens.add(new Token("ARITOP",yytext()));
            return TIMES;
        }
        "/" { 
            tokens.add(new Token("ARITOP",yytext()));
            return DIVIDE;
        }
        "<" { 
            tokens.add(new Token("RELAOP",yytext()));
            return LESS;
        }
        ">" { 
            tokens.add(new Token("RELAOP",yytext()));
            return MORE;
        }
        "==" { 
            tokens.add(new Token("RELAOP",yytext()));
            return EQUAL;
        }
        "¡=" { 
            tokens.add(new Token("RELAOP",yytext()));
            return NOTEQUAL;
        }
        "||" { 
            tokens.add(new Token("LOGIOP",yytext()));
            return OR;
        }
        "&&" { 
            tokens.add(new Token("LOGIOP",yytext()));
            return AND;
        }
        "=" { 
            tokens.add(new Token("ASIGNOP",yytext()));
            return ASIGN;
        }  	      
}
. {System.out.print("error! Character not recognized");}
<<EOF>> { System.out.println("Fin");/*return symbol(sym.EOF);*/ }


