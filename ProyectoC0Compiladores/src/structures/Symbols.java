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
public class Symbols {
    
    private int cod;
    private String id;
    private int direct;
    
    public Symbols(int cod, String id, int direct){
        this.cod = cod;
        this.direct = direct;
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
