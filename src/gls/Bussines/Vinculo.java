/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gls.Bussines;

import gls.Inventario.DTO.Articulo;
import gls.Inventario.DTO.Bodega;
import gls.Inventario.DTO.Grupo;
import gls.Inventario.IFactory;
import gls.Inventario.Inventario;
import gls.Personas.DTO.Proveedor;
import gls.Personas.Personas;
import gls.Personas.PFactory;
import java.util.ArrayList;

/**
 *
 * @author Fredy Arciniegas
 */
public class Vinculo {

    protected static ArrayList<Articulo> listArticulos() {
        Inventario i = new IFactory();
        return i.listArticulos();
    }

    protected static ArrayList<Bodega> listBodegas() {
        Inventario i = new IFactory();
        return i.listBodegas();
    }
    
    protected static ArrayList<Grupo> listGrupos() {
        Inventario i = new IFactory();
        return i.listGrupos();
    }

    protected static ArrayList<Proveedor> listProveedores() {
        Personas p = new PFactory();
        return p.listProveedores();
    }
    
    
}
