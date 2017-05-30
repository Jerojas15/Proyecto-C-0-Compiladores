/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structures;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Objects;

/**
 *
 * @author Scarlet
 */
public class Table {
    
    private HashMap<Integer,Symbol> symbolTable;
    private HashMap<Integer,Type> typeTable;
    private static int symbolCount = 0;
    
    public Table(){
        this.symbolTable = new HashMap<>();
        this.typeTable = new HashMap<>();
        this.typeTable.put(001, new Type(0,"int"));
    }
    
    public boolean ContainedInSymbolTable(String value) {
        for (Entry<Integer, Symbol> entry : symbolTable.entrySet()) {
            if (Objects.equals(value, entry.getValue().getId())) {
                System.out.println("Existing Symbol: "+entry.getValue().getId()+" Code: "+entry.getValue().getCod()+" Direction: "+entry.getValue().getDirect()+" Number: "+ entry.getKey());
                return true;        
            }
        }
        return false;
    }
    public int getSymbolDirection(String id){
        for (Entry<Integer, Symbol> entry : symbolTable.entrySet()) {
            if (Objects.equals(id, entry.getValue().getId())) {
                return entry.getValue().getDirect();
            }
        }
        return 0;
    }
    public void addNewSymbol(int cod, String symbolName, int direction){
        System.out.println("New Symbol added to table: "+symbolName+" Symbol Code: "+cod+" direction: "+direction+" Number: "+ symbolCount);
        symbolTable.put(symbolCount++, new Symbol(cod,symbolName,direction));
    }
}
