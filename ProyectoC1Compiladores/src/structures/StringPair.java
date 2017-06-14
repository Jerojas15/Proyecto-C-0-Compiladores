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
public class StringPair {
    private String id;
    private String value;
    
    public StringPair(String id, String value){
        this.id = id;
        this.value = value;
    }
    
    public String getId(){
        return this.id;
    }
    
    public String getValue(){
        return this.value;
    }
}
