/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gls.Conexion;

import java.sql.Connection;

/**
 *
 * @author Fredy Arciniegas
 */
public interface Conexion {
    
    public Connection getConexion(String tableName);       
}
