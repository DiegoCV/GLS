/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gls.Util;

import java.util.HashMap;

/**
 *
 * @author Fredy Arciniegas
 */
public class Carguero {

    private final HashMap<String, Object> misArticulos;
       
    public Carguero() {
        this.misArticulos = new HashMap<>();
    }

    public void add(String key, Object obj) {
        this.misArticulos.put(key, obj);
    }
    
    public Object get(String key){
        return this.misArticulos.get(key);
    }
    
    public void remove(String key){
        this.misArticulos.remove(key);
    }       
}
