/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
//import steps.Lexer;
//import steps.Parser;
/**
 *
 * @author julio
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public void preparedFiles() throws IOException, Exception{
        String[] in = {"-parser", "Parser", "src/steps/parser.cup"};
        jflex.Main.generate(new File("src/steps/Lexer.flex"));
        System.out.println("Flex Ready");
        java_cup.Main.main(in);
        
        new File("Parser.java").renameTo(new File("src/steps/Parser.java"));
        new File("sym.java").renameTo(new File("src/steps/sym.java"));
    }
    
    public static void main(String[] args) throws Exception {
        new Main().preparedFiles();
//        String text= "main(){"
//                + "if(true&&false){"
//                + "puts(\"if verdadero\");"
//                + "}else{"
//                + "if(true){putw(5+6);"
//                + "}}"
//                + "while(true){"
//                + "putw(5);"
//                + "}"
//                + "while(true){"
//                + "putw(5);"
//                + "}while(true){"
//                + "break;"
//                + "}while(true){"
//                + "putw(5);"
//                + "}"
//                + "int hola; "
//                + "hola = 5;"
//                + "}";
//        Reader in = new BufferedReader(new StringReader(text));
//		Lexer l = new Lexer(in);
//                Parser p = new Parser(new Lexer(in));
//                Object result = p.parse().value;
//                System.out.println(result);
    }
    
}
/*

program   ::=  decllist:d stmtlist:s
    ;
decllist  ::=  decl:d decllist:dl
    | /* empty 
    ;
stmtlist  ::= stmtlist:sl stmt:s
    | /* empty 
        ;
decl ::= TYPE IDENT:identifier identlist:il  SEMICOLON
    ;
identlist  ::= identlist:il COMMA IDENT:identifier
    | /* empty 
    ;
stmt ::= SEMICOLON
    | BEGIN stmtlist:sl END
    | IDENT:lhs ASSIGN expr:rhs SEMICOLON
    | IDENT:lhs ASSIGN READ LPAR RPAR SEMICOLON
    | IDENT:lhs ASSIGN READ LPAR STRINGCONST:s RPAR SEMICOLON
    | WRITE LPAR expr:e RPAR SEMICOLON
    | WRITE LPAR STRINGCONST:s RPAR SEMICOLON
    | IF LPAR cond:c RPAR stmt:s
    | IF LPAR cond:c RPAR stmt:t ELSE stmt:e
    | WHILE LPAR cond:c RPAR stmt:s
    ;

*/