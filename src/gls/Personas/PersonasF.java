/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gls.Personas;

import gls.Personas.DTO.*;
import gls.Personas.DAO.*;
import java.util.ArrayList;

/**
 *
 * @author Fredy Arciniegas
 */
public class PersonasF implements Personas {

    private static ClienteDao clienteDao;
    private static ProveedorDao proveedorDao;
    private static UsuarioDao usuarioDao;

    private static ClienteDao getClienteDao() {
        if (clienteDao == null) {
            clienteDao = new ClienteDao();
        }
        return clienteDao;
    }

    private static ProveedorDao getProveedorDao() {
        if (proveedorDao == null) {
            proveedorDao = new ProveedorDao();
        }
        return proveedorDao;
    }

    private static UsuarioDao getUsuarioDao() {
        if (usuarioDao == null) {
            usuarioDao = new UsuarioDao();
        }
        return usuarioDao;
    }

    @Override
    public ArrayList<Proveedor> listProveedores() {
        return getProveedorDao().listAll();
    }

    @Override
    public void insertCliente(Cliente cliente) {
        getClienteDao().insert(cliente);
    }

    @Override
    public void insertProveedor(Proveedor proveedor) {
        getProveedorDao().insert(proveedor);
    }

    @Override
    public ArrayList<Cliente> listClientes() {
        return getClienteDao().listAll();
    }

}
