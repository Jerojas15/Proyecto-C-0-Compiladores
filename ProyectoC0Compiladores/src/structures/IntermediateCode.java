/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structures;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
/**
 *
 * @author julio
 */
public class IntermediateCode {
    private String name;
    static private ArrayList<IntermediateLine> lines = new ArrayList<>();
    private PrintWriter file;
    
    public IntermediateCode(String name){
        this.name = name;
    }
    
    public void openFile(){
        try{
            this.file = new PrintWriter(name, "UTF-8");
        } catch (IOException e) {
            System.out.println(ErrorMessage.NOFILE);
        }
    }
    
    public void close(){
        this.file.close();
    }
    
    public ArrayList<IntermediateLine> getLines(){
        return IntermediateCode.lines;   
    }
    
    public void write(IntermediateLine line){
        this.file.write(line.getContent());
        IntermediateCode.lines.add(line);
    }
}
