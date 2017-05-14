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
import steps.Lexer;
import steps.Parser;
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
        java_cup.Main.main(in);
        
        new File("Parser.java").renameTo(new File("src/steps/Parser.java"));
        new File("sym.java").renameTo(new File("src/steps/sym.java"));
    }
    
    public static void main(String[] args) throws Exception {
        //new Main().preparedFiles();
        String text= "(5+5)*2";
        Reader in = new BufferedReader(new StringReader(text));
		Lexer l = new Lexer(in);
                Parser p = new Parser(new Lexer(in));
                Object result = p.parse().value;
                System.out.println(result);
    }
    
}
