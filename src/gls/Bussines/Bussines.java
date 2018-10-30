/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gls.Bussines;

import gls.Inventario.DTO.Factura;
import gls.Inventario.DTO.Movimiento;

import gls.Personas.DTO.Proveedor;

import gls.Util.Carguero;
import java.util.ArrayList;

/**
 *
 * @author Fredy Arciniegas
 */
public interface Bussines {

    /*
     *listo articulos, grupos, bodegas y proveedores
     */
    public Carguero prepararCompra();

    public void efectuarCompra(ArrayList<Movimiento> movimientos, double total);

    /*
     *listo articulos y clientes
     */
    public Carguero prepararVenta();

    public void efectuarVenta(ArrayList<Movimiento> movimientos, double total);

    /*
     * Lista movimientos por id de factura
     */
    public ArrayList<Movimiento> prepararDevolucion(int idFactura);

    /*
     *factura con id y nuevo total
     *cuando es al proveedor, enviarAlLimbo=false
     */
    public void efectuarDevolucion(ArrayList<Movimiento> movimientos, Factura factura);
    

}
