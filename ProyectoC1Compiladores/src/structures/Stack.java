/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structures;

import java.util.ArrayList;

/**
 *
 * @author julio
 */
public class Stack {
    ArrayList<Integer> stack;
    int cont;
    
    public Stack(){
        stack = new ArrayList<>();
        cont = 0;
    }
    
    public void push(int number){
        stack.add(number);
        cont++;
    }
    
    public void pop(){
        if(cont >0){
            int aux = stack.remove(stack.size()-1);
        }
    }
    
    public int top(){
        if(cont >0){
            return stack.get(stack.size()-1);
        }
        return 0;
        
    }
    
}
