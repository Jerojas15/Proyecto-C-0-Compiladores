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
public class Expression {
    int direction;
    public Expression(int direct){
        direction = direct;
        System.out.println("New Direction added: "+direction);
    }

    public int getDirection() {
        return direction;
    }
    
}
