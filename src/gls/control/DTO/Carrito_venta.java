/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gls.control.DTO;

import gls.Inventario.DTO.Articulo;
import gls.Personas.DTO.Cliente;
import gls.Personas.DTO.Usuario;
import java.util.List;

/**
 *
 * @author DiegoCarrascal
 */
public class Carrito_venta {

    private final Usuario usuario;
    private final Cliente cliente;
    private final List<Articulo> articulos;

    public Carrito_venta(Usuario usuario, Cliente cliente, List<Articulo> articulos) {
        this.usuario = usuario;
        this.cliente = cliente;
        this.articulos = articulos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Articulo> getArticulos() {
        return articulos;
    }

    @Override
    public String toString() {
        return "Carrito_venta{" + "usuario=" + usuario + ",\n cliente=" + cliente + ", \n articulos=" + articulos + '}';
    }

    
}
