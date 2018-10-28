/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gls.Bussines;

import gls.Inventario.DTO.Articulo;
import gls.Inventario.DTO.Bodega;
import gls.Inventario.DTO.Factura;
import gls.Inventario.DTO.Movimiento;
import gls.Util.Carguero;
import java.util.ArrayList;

/**
 *
 * @author Fredy Arciniegas
 */
public class Recepcionista implements Bussines {

    @Override
    public Carguero prepararCompra() {
        Carguero c = new Carguero();
        c.add("articulos", Vinculo.listArticulos());
        c.add("bodegas", Vinculo.listBodegas());
        c.add("grupos", Vinculo.listGrupos());
        c.add("proveedores", Vinculo.listProveedores());
        return c;
    }

    @Override
    public void efectuarCompra(ArrayList<Movimiento> movimientos, double total) {
        Factura factura = new Factura();
        factura.setTotal(total);
        factura.setId(Vinculo.insertFactura(factura));
        for (Movimiento movimiento : movimientos) {
            if (movimiento.isArticuloNuevo()) {
                Vinculo.insertArticulo(movimiento.getArticulo());
            } else {
                Articulo articulo = movimiento.getArticulo();
                articulo.setCantidad(articulo.getCantidad() + movimiento.getCantidad());
                Vinculo.updateArticulo(articulo);
            }
            if (movimiento.isProveedorNuevo()) {
                Vinculo.insertProveedor(movimiento.getProveedor());
            }
        }
    }

    @Override
    public Carguero prepararVenta() {
         Carguero c = new Carguero();
        c.add("articulos", Vinculo.listArticulos());
        c.add("clientes", Vinculo.listClientes());
        return c;
    }

    @Override
    public void efectuarVenta(ArrayList<Movimiento> movimientos, double total) {
        Factura factura = new Factura();
        factura.setTotal(total);
        factura.setId(Vinculo.insertFactura(factura));
        for (Movimiento movimiento : movimientos) {

            Articulo articulo = movimiento.getArticulo();
            articulo.setCantidad(articulo.getCantidad() - movimiento.getCantidad());
            Vinculo.updateArticulo(articulo);

            if (movimiento.isClienteNuevo()) {
                Vinculo.insertCliente(movimiento.getCliente());
            }
        }
    }

}
