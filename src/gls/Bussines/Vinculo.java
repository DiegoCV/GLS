/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gls.Bussines;

import gls.Inventario.DTO.Articulo;
import gls.Inventario.DTO.Bodega;
import gls.Inventario.DTO.Factura;
import gls.Inventario.DTO.Grupo;
import gls.Inventario.DTO.Limbo;
import gls.Inventario.DTO.Movimiento;
import gls.Inventario.InventarioF;
import gls.Inventario.Inventario;
import gls.Personas.DTO.Cliente;
import gls.Personas.DTO.Proveedor;
import gls.Personas.DTO.Usuario;
import gls.Personas.Personas;
import gls.Personas.PersonasF;
import java.util.ArrayList;

/**
 *
 * @author Fredy Arciniegas
 */
public class Vinculo {

    protected static ArrayList<Articulo> listArticulos() {
        Inventario i = new InventarioF();
        return i.listArticulos();
    }

    protected static ArrayList<Bodega> listBodegas() {
        Inventario i = new InventarioF();
        return i.listBodegas();
    }

    protected static ArrayList<Grupo> listGrupos() {
        Inventario i = new InventarioF();
        return i.listGrupos();
    }

    protected static ArrayList<Proveedor> listProveedores() {
        Personas p = new PersonasF();
        return p.listProveedores();
    }

    protected static ArrayList<Cliente> listClientes() {
        Personas p = new PersonasF();
        return p.listClientes();
    }

    static void insertCliente(Cliente cliente) {
        Personas p = new PersonasF();
        p.insertCliente(cliente);
    }

    static void insertArticulo(Articulo articulo) {
        Inventario i = new InventarioF();
        i.updateArticulo(articulo);
    }

    static void updateArticulo(Articulo articulo) {
        Inventario i = new InventarioF();
        i.updateArticulo(articulo);
    }

    static int insertFactura(Factura factura) {
        Inventario i = new InventarioF();
        return i.insertFactura(factura);
    }

    static void insertProveedor(Proveedor proveedor) {
        Personas p = new PersonasF();
        p.insertProveedor(proveedor);
    }

    static void insertMovimiento(Movimiento movimiento) {
        Inventario i = new InventarioF();
        i.insertMovimiento(movimiento);
    }

    static ArrayList<Movimiento> listMovimientosByFactura(Factura factura) {
        Inventario i = new InventarioF();
        return i.listMovimientosByFactura(factura);
    }

    static void updateFactura(Factura factura) {
        Inventario i = new InventarioF();
        i.updateFactura(factura);
    }

    static Limbo selectLimbo(Limbo limbo) {
        Inventario i = new InventarioF();
        return i.selectLimbo(limbo);
    }

    static void insertLimbo(Limbo limbo) {
        Inventario i = new InventarioF();
        i.insertLimbo(limbo);
    }

    static void updateLimbo(Limbo limbo) {
        Inventario i = new InventarioF();
        i.updateLimbo(limbo);
    }

    static Usuario login(Usuario usuario) {
        Personas p = new PersonasF();
        return p.login(usuario);
    }
}
