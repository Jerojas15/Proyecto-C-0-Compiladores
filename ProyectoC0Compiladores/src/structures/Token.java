/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structures;

/**
 *
 * @author Scarlet
 */
public class Token {
    
    private final String type;
    private final String lexeme;
    
    public Token(String type, String lexeme){
        this.lexeme = lexeme;
        this.type = type;
    }
    
    @Override
    public String toString(){
        return String.format("<%s,%s>", type, lexeme);
    }
}
