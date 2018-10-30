/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gls.Personas;

import gls.Personas.DTO.Cliente;
import gls.Personas.DTO.Proveedor;
import gls.Personas.DTO.Usuario;
import java.util.ArrayList;

/**
 *
 * @author Fredy Arciniegas
 */
public interface Personas {

    public ArrayList<Proveedor> listProveedores();

    public void insertCliente(Cliente cliente);

    public void insertProveedor(Proveedor proveedor);

    public ArrayList<Cliente> listClientes();

    public Usuario login(Usuario usuario);
        
    
}
