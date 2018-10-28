/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gls.Bussines;

import gls.Inventario.DTO.Articulo;
import gls.Inventario.DTO.Bodega;
import gls.Util.Carguero;
import java.util.ArrayList;

/**
 *
 * @author Fredy Arciniegas
 */
public class Recepcionista implements Bussines{    

    @Override
    public Carguero prepararCompra() {
        Carguero c=new Carguero();
        c.add("articulos", Vinculo.listArticulos());
        c.add("grupos", Vinculo.listGrupos());
        c.add("bodegas", Vinculo.listBodegas());
        c.add("proveedores", Vinculo.listProveedores());
        return c;
    }

    @Override
    public String efectuarCompra(Proveedor proveedor, ArrayList<Articulo> articulos) {
        
    }

    @Override
    public Carguero prepararVenta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String efectuarVenta(Cliente cliente, ArrayList<Articulo> articulos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    
}
