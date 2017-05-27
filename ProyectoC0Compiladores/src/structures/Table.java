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
    
    private HashMap<Integer,Symbols> symbolTable;
    private HashMap<Integer,Type> typeTable;
    private static int symbolCount = 0;
    private static int direction = 30000;
    public Table(){
        this.symbolTable = new HashMap<>();
        this.typeTable = new HashMap<>();
        this.typeTable.put(001, new Type(0,"int"));
    }
    
    public boolean ContainedInSymbolTable(String sym){
        for(int i = 0;i<symbolTable.size();i++){
            if(symbolTable.get(i).getId().equals(sym)){
                return true;
            }
        }
        return false;
    }
    
    public void addNewSymbol(int cod, String symbolName){
        System.out.println("New Symbol added to table: "+symbolName);
        symbolTable.put(symbolCount++, new Symbols(cod,symbolName,direction++));
    }
}
