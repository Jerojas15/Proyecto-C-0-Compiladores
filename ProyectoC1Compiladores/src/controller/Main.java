/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.IOException;
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
    }   
}