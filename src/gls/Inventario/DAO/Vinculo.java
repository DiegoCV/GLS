/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gls.Inventario.DAO;

import gls.Conexion.Conector;
import gls.Conexion.Conexion;
import java.sql.Connection;

/**
 *
 * @author Fredy Arciniegas
 */
public class Vinculo {

    protected static Connection getConexion(String dbName) {
        Conexion c=new Conector();
        return c.getConexion(dbName);
    }
    
    
}
