/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gls.Bussines;

import gls.Inventario.DTO.Articulo;
import gls.Inventario.DTO.Bodega;
import gls.Inventario.DTO.Factura;
import gls.Inventario.DTO.Limbo;
import gls.Inventario.DTO.Movimiento;
import gls.Personas.DTO.Usuario;
import gls.Util.Carguero;
import java.util.ArrayList;

/**
 *
 * @author Fredy Arciniegas
 */
public class Recepcionista implements Bussines {

    @Override
    public Carguero prepararCompra() {

        Carguero c=new Carguero();/**
=======
        Carguero c = new Carguero();
>>>>>>> bd7c67023434610331052c58fe4c596f30952dbe
        c.add("articulos", Vinculo.listArticulos());
        c.add("bodegas", Vinculo.listBodegas());
<<<<<<< HEAD
        c.add("proveedores", Vinculo.listProveedores());*/

        c.add("grupos", Vinculo.listGrupos());
        c.add("proveedores", Vinculo.listProveedores());

        return c;
    }

    @Override
    public void efectuarCompra(ArrayList<Movimiento> movimientos, double total) {
        //no estoy tocando la tabla Precio todavía. Los precios se están guardando en total factura y precio movimiento
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
            movimiento.setFactura(factura);
            Vinculo.insertMovimiento(movimiento);
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
        //no estoy tocando la tabla Precio todavía. Los precios se están guardando en total factura y precio movimiento
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
            movimiento.setFactura(factura);
            Vinculo.insertMovimiento(movimiento);
        }
    }

    @Override
    public ArrayList<Movimiento> prepararDevolucion(int idFactura) {
        Factura factura = new Factura();
        factura.setId(idFactura);
        return Vinculo.listMovimientosByFactura(factura);
    }

    @Override
    public void efectuarDevolucion(ArrayList<Movimiento> movimientos, Factura factura) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

/**
<<<<<<< HEAD
=======

>>>>>>> bd7c67023434610331052c58fe4c596f30952dbe
    @Override
    public void efectuarDevolucion(ArrayList<Movimiento> movimientos, Factura factura) {
        Vinculo.updateFactura(factura);
        for (Movimiento movimiento : movimientos) {
            movimiento.setFactura(factura);
            Vinculo.insertMovimiento(movimiento);
            if (movimiento.isEnviarAlLimbo()) {
                Limbo limbo = new Limbo();
                limbo.setArticulo(movimiento.getArticulo());
                limbo = Vinculo.selectLimbo(limbo);
                if (limbo == null) {
                    limbo = new Limbo();
                    limbo.setArticulo(movimiento.getArticulo());
                    limbo.setCantidad(movimiento.getCantidad());
                    Vinculo.insertLimbo(limbo);
                } else {
                    limbo.setCantidad(limbo.getCantidad() + movimiento.getCantidad());
                    Vinculo.updateLimbo(limbo);
                }
            }
        }
    }

    @Override
    public Usuario login(Usuario usuario) {
        return Vinculo.login(usuario);
    }
<<<<<<< HEAD
   
=======
>>>>>>> a746853c35c37af60f8d359e6dc801c7cfb2f96c*/
    

}
