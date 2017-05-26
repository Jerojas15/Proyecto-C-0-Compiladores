/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structures;

import java.util.HashMap;

/**
 *
 * @author Scarlet
 */
public class Table {
    
    private HashMap<Integer,Symbol> symbolTable;
    private HashMap<Integer,Type> typeTable;
    
    public Table(){
        this.symbolTable = new HashMap<>();
        this.typeTable = new HashMap<>();
        this.typeTable.put(001, new Type(0,"int"));
    }
    
    public boolean ContainedInSymbolTable(Symbol sym){
        return this.symbolTable.containsValue(sym);
    }
}
