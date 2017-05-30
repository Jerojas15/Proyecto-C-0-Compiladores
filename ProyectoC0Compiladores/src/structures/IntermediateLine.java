/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structures;

/**
 *
 * @author julio
 */
public class IntermediateLine {
    String command, op1,op2,res;
    public IntermediateLine(String command, String op1, String op2, String res){
        System.out.println("New Line created");
        this.command = command;
        this.op1 = op1;
        this.op2 = op2;
        this.res = res;
    }
    
    public String getContent(){
        String result = "";
        result = result.concat(command);
        result = result.concat(" ");
        result = result.concat(op1);
        result = result.concat(" ");
        result = result.concat(op2);
        result = result.concat(" ");
        result = result.concat(res);
        result = result.concat("\n");
        return result;
    }
}
