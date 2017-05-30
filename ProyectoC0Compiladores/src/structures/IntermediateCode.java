/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structures;

import java.io.IOException;
import java.io.PrintWriter;
import structures.*;
/**
 *
 * @author julio
 */
public class IntermediateCode {
    String name;
    PrintWriter file;
    public IntermediateCode(String name){
        this.name = name;
    }
    
    public void openFile(){
        try{
            file = new PrintWriter(name, "UTF-8");
        } catch (IOException e) {
            System.out.println(ErrorMessage.NOFILE);
        }
    }
    
    public void close(){
        file.close();
    }
    
    public void write(IntermediateLine line){
        file.write(line.getContent());
    }
}
