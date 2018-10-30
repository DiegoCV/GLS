/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gls.control.DTO;

import gls.Inventario.DTO.Articulo;
import gls.Personas.DTO.Proveedor;
import gls.Personas.DTO.Usuario;
import java.util.List;

/**
 *
 * @author DiegoCarrascal
 */
public class Carrito_Compra {
    private final Usuario usuario;
    private final Proveedor proveedor;
    private final List<Articulo> articulos;

    public Carrito_Compra(Usuario usuario, Proveedor proveedor, List<Articulo> articulos) {
        this.usuario = usuario;
        this.proveedor = proveedor;
        this.articulos = articulos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public List<Articulo> getArticulos() {
        return articulos;
    }

    @Override
    public String toString() {
        return "Carrito_Compra{" + "usuario=" + usuario + ", proveedor=" + proveedor + ", articulos=" + articulos + '}';
    }
    
    
}
