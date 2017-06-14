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
public class Symbol {
    
    private int cod;
    private String id;
    private int direct;
    private int size;
    
    public Symbol(int cod, String id, int direct){
        this.cod = cod;
        this.direct = direct;
        this.id = id;
    }
    
    public Symbol(int cod, String id, int direct, int size){
        this.cod = cod;
        this.direct = direct;
        this.id = id;
        this.size = size;
    }
    
    public Symbol(int direct){
        this.direct = direct;
    }

    public int getCod() {
        return cod;
    }

    public int getDirect() {
        return direct;
    }
    
    public String getId(){
        return this.id;
    }
    
    public int getSize(){
        return this.size;
    }
}
