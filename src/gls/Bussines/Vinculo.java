/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gls.Bussines;
import gls.Inventario.DTO.Bodega;
import gls.Inventario.Factory;
import gls.Inventario.Inventario;
import java.util.ArrayList;
/**
 *
 * @author Fredy Arciniegas
 */
public class Vinculo {
        
    protected static ArrayList<Bodega> listBodegas(){
        Inventario i =new Factory();
        return i.listBodegas();
    }
}
