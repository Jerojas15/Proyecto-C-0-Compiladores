package steps;

import structures.Token;
import java.util.ArrayList;
import java_cup.runtime.*;
%%

%public
%class Lexer
%cup
%char
%line
%column

%{
	private static ArrayList<Token> tokenList = new ArrayList<>();
        
        private void error(String message) {
            System.out.println("Error at line "+(yyline+1)+", column "+(yycolumn+1)+" : "+message);
        }

        public ArrayList<Token> getTokenList() {
            return this.tokenList;
        }
        
        private Symbol symbol(int type) {
            return new Symbol(type, yyline, yycolumn);
        }
        private Symbol symbol(int type, Object value) {
            return new Symbol(type, yyline, yycolumn, value);
        }

%}
%eofval{
    return symbol(sym.EOF, "EOF");
%eofval}

LETTER= [a-zA-Z]
DIGIT = [0-9]
NUMBER = {DIGIT}+
IDENTIFIER = ({LETTER}|"_")({DIGIT}|{LETTER})*
WHITESPACE = [ \r\n\t\f]
CONSTANT = \"([\x20-\x21\x23-\xFE])*\"

%%
<YYINITIAL> {
        
        {WHITESPACE} {/* ignore */}
        {NUMBER} {
            this.tokenList.add(new Token("NUMBER", yytext()));
            return symbol(sym.NUMBER, new Integer(Integer.parseInt(yytext())));
        }
        "true" { 
            this.tokenList.add(new Token("TRUE", yytext()));
            return symbol(sym.BOOLEAN, new Boolean(Boolean.parseBoolean(yytext())));
        }
        "false" { 
            this.tokenList.add(new Token("FALSE", yytext()));
            return symbol(sym.BOOLEAN, new Boolean(Boolean.parseBoolean(yytext())));
        }
        "main" { 
            this.tokenList.add(new Token("MAIN", yytext()));
            return symbol(sym.MAIN);
        }
        "if" { 
            this.tokenList.add(new Token("IF", yytext()));
            return symbol(sym.IF);
        }
        "while" { 
            this.tokenList.add(new Token("WHILE", yytext()));
            return symbol(sym.WHILE);
        }
        "else" { 
            this.tokenList.add(new Token("ELSE", yytext()));
            return symbol(sym.ELSE);
        }
        "putw" {
            this.tokenList.add(new Token("PUTW", yytext())); 
            return symbol(sym.PUTW);
        }
        "puts" { 
            this.tokenList.add(new Token("PUTS", yytext()));
            return symbol(sym.PUTS);
        }
        "int" { 
            this.tokenList.add(new Token("TYPE", yytext()));
            return symbol(sym.INT);
        }
        "break" { 
            this.tokenList.add(new Token("BREAK", yytext()));
            return symbol(sym.BREAK);
        }
        "(" { 
            this.tokenList.add(new Token("LPAR", yytext()));
            return symbol(sym.LPAR);
        }
        ")" { 
            this.tokenList.add(new Token("RPAR", yytext()));
            return symbol(sym.RPAR);
        }
        "{" { 
            this.tokenList.add(new Token("LKEY", yytext()));
            return symbol(sym.LKEY);
        }
        "}" { 
            this.tokenList.add(new Token("RKEY", yytext()));
            return symbol(sym.RKEY);
        }
        ";" { 
            this.tokenList.add(new Token("SEMICOLON", yytext()));
            return symbol(sym.SEMICOLON);
        }
        "+" { 
            this.tokenList.add(new Token("PLUS", yytext()));
            return symbol(sym.PLUS);
        }
        "-" { 
            this.tokenList.add(new Token("MINUS", yytext()));
            return symbol(sym.MINUS);
        }
        "*" { 
            this.tokenList.add(new Token("TIMES", yytext()));
            return symbol(sym.TIMES);
        }
        "/" { 
            this.tokenList.add(new Token("DIVIDE", yytext()));
            return symbol(sym.DIVIDE);
        }
        "<" { 
            this.tokenList.add(new Token("LESS", yytext()));
            return symbol(sym.LESS);
        }
        ">" {
            this.tokenList.add(new Token("MORE", yytext())); 
            return symbol(sym.MORE);
        }
        "==" { 
            this.tokenList.add(new Token("EQUAL", yytext()));
            return symbol(sym.EQUAL);
        }
        "¡=" { 
            this.tokenList.add(new Token("NOTEQUAL", yytext()));
            return symbol(sym.NOTEQUAL);
        }
        "||" { 
            this.tokenList.add(new Token("OR", yytext()));
            return symbol(sym.OR);
        }
        "&&" { 
            this.tokenList.add(new Token("AND", yytext()));
            return symbol(sym.AND);
        }
        "=" { 
            this.tokenList.add(new Token("ASIGN", yytext()));
            return symbol(sym.ASIGN);
        }
        {CONSTANT} {
            this.tokenList.add(new Token("CONSTANT", yytext()));
            return symbol(sym.CONSTANT,yytext());
        }  
        {IDENTIFIER} {
            this.tokenList.add(new Token("IDENTIFIER", yytext()));
            return symbol(sym.IDENTIFIER, yytext());
        }
}
. {
    this.tokenList.add(new Token("ERROR", yytext()));
    error("Character not recognized "+yytext());
}
