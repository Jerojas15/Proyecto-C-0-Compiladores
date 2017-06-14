/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structures;

import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Scarlet
 */
public class FinalCode {
    private String name;
    private PrintWriter file;
    
    public FinalCode(String name) {
        this.name = name;
    }
    
    public void openFile(){
        try{
            this.file = new PrintWriter(name, "UTF-8");
        } catch (IOException e) {
            System.out.println(ErrorMessage.NOFILE);
        }
    }
    
    public void closeFile(){
        this.file.close();
    }
    
    private void processLine(IntermediateLine line){
        String space = "        ";
        switch(line.command){
            case "PUT_CONSTANT":
                String temp = line.op1+": DATA ";
                this.file.write(temp+line.res);
                break;
            case "PRINT_CONSTANT":
                this.file.write(space+"WRSTR /"+line.op1);
                break;
            case "PRINT_INT":
                this.file.write(space+"WRINT /"+line.op1);
                break;
            case "LABEL":
                String temp2 = line.res+": ";
                this.file.write(temp2+"NOP");
                break;
            case "JUMP_LABEL":
                this.file.write(space+"BR /"+line.res);
                break;
            case "JUMP_CONDITION":
                this.file.write(space+"CMP #0 , /"+line.op1);
                this.file.write("\n");
                this.file.write(space+"BZ /"+line.res);
                break;
            case "LOAD_DIRECTION":
                this.file.write(space+"MOVE /"+line.op1+" , /"+line.res);
                break;
            case "LESS":
                this.file.write(space+"CMP /"+line.op1+" , /"+line.op2);
                this.file.write("\n");
                this.file.write(space+"BN $5");
                this.file.write("\n");
                this.file.write(space+"MOVE #0 , /"+line.res);
                this.file.write("\n");
                this.file.write(space+"BR $3");
                this.file.write("\n");
                this.file.write(space+"MOVE #1 , /"+line.res);
                break;
            case "MORE":
                this.file.write(space+"CMP /"+line.op2+" , /"+line.op1);
                this.file.write("\n");
                this.file.write(space+"BN $5");
                this.file.write("\n");
                this.file.write(space+"MOVE #0 , /"+line.res);
                this.file.write("\n");
                this.file.write(space+"BR $3");
                this.file.write("\n");
                this.file.write(space+"MOVE #1 , /"+line.res);
                break;
            case "NOTEQUAL":
                this.file.write(space+"CMP /"+line.op1+" , /"+line.op2);
                this.file.write("\n");
                this.file.write(space+"BZ $5");
                this.file.write("\n");
                this.file.write(space+"MOVE #1 , /"+line.res);    
                this.file.write("\n");
                this.file.write(space+"BR $3");
                this.file.write("\n");
                this.file.write(space+"MOVE #0 , /"+line.res);
                break;
            case "EQUAL":
                this.file.write(space+"CMP /"+line.op1+" , /"+line.op2);
                this.file.write("\n");
                this.file.write(space+"BZ $5");
                this.file.write("\n");
                this.file.write(space+"MOVE #0 , /"+line.res);
                this.file.write("\n");
                this.file.write(space+"BR $3");
                this.file.write("\n");
                this.file.write(space+"MOVE #1 , /"+line.res);
                break;
            case "OR":
                this.file.write(space+"OR /"+line.op1+" , /"+line.op2);
                this.file.write("\n");
                this.file.write(space+"MOVE .A , /"+line.res);
                break;
            case "AND":
                this.file.write(space+"AND /"+line.op1+" , /"+line.op2);
                this.file.write("\n");
                this.file.write(space+"MOVE .A , /"+line.res);
                break;
            case "PLUS":
                this.file.write(space+"ADD /"+line.op1+" , /"+line.op2);
                this.file.write("\n");
                this.file.write(space+"MOVE .A , /"+line.res);
                break;
            case "LOAD_NUMBER":
                this.file.write(space+"MOVE #"+line.op1+" , /"+line.res);
                break;
            case "DIVIDE":
                this.file.write(space+"DIV /"+line.op1+" , /"+line.op2);
                this.file.write("\n");
                this.file.write(space+"MOVE .A , /"+line.res);
                break;
            case "TIMES":
                this.file.write(space+"MUL /"+line.op1+" , /"+line.op2);
                this.file.write("\n");
                this.file.write(space+"MOVE .A , /"+line.res);
                break;
            case "MINUS":
                this.file.write(space+"SUB /"+line.op1+" , /"+line.op2);
                this.file.write("\n");
                this.file.write(space+"MOVE .A , /"+line.res);
                break;
        }
        this.file.write("\n");
    }
    
    public void translateCode(IntermediateCode intermediateFile){
        this.openFile();
        intermediateFile.getLines().forEach((line) -> {
            processLine(line);
        });
        this.closeFile();    
    }
    
    
}
