/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gls.Inventario;

import gls.Inventario.DTO.Bodega;
import java.util.ArrayList;

/**
 *
 * @author Fredy Arciniegas
 */
public interface Inventario {
    
    public ArrayList<Bodega> listBodegas();
    
    public int insertBodega(int id);
    
}