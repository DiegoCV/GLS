/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gls.Bussines;

import gls.Inventario.DTO.Articulo;
import gls.Inventario.DTO.Bodega;
import gls.Inventario.DTO.Movimiento;
import gls.Personas.DTO.Proveedor;
import gls.Personas.DTO.Cliente;
import gls.Util.Carguero;
import java.util.ArrayList;
//acuérdese de borrar los imports sin usar ^^^^

/**
 *
 * @author Fredy Arciniegas
 */
public interface Bussines {       
    
    public Carguero prepararCompra(); //listo articulos, grupos, bodegas y proveedores
    public String efectuarCompra(ArrayList<Movimiento> movimientos);
    
    public Carguero prepararVenta(); //listo articulos y clientes
    public String efectuarVenta(ArrayList<Movimiento> movimientos);
    
}
