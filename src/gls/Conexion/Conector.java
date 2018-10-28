/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gls.Conexion;

import gls.Util.MyLogger;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Fredy Arciniegas
 */
public class Conector implements Conexion {

    private final String[] drivers;
    private int driverActual; //NotFinal

    public Conector() {
        drivers = new String[2];
        drivers[0] = "com.mysql.jdbc.Driver%%jdbc:mysql:";
        drivers[1] = "org.postgresql.Driver%%jdbc:postgresql:";
        driverActual = 0;
    }

    @Override
    public Connection getConexion(String tableName) {
        Connection cnx = null;
        try {
            String[] split = drivers[driverActual].split("%%");
            Class.forName(split[0]);
            String dbName = this.getDbName(tableName);
            String[] array = this.leerProperties(dbName);
            cnx = DriverManager.getConnection(split[1] + "//" + Cifrador.cifrar(array[0]) + "/" + dbName,
                    Cifrador.cifrar(array[1]), Cifrador.cifrar(array[2]));
        } catch (SQLException | ClassNotFoundException ex) {
            MyLogger.escribirLog(ex);
        }
        return cnx;
    }

    private String getDbName(String tableName) {
        switch (tableName) {
            case "algoExtra": {
                return "GLSExtra"; //cifrado
            }
            default: {
                return "ﾁﾆﾍｽﾉﾌｿ"; //glscore //quitar el comentario inmediatamente anterior
            }
        }
    }

    /**
     * Busca los parámetros de conexión de la base de datos seleccionada
     *
     * @param bdName Nombre de la base de datos a conectar
     * @return array String[0]=Host, String[1]=username, String[2]=password
     * @throws SQLException
     */
    private String[] leerProperties(String bdName) {
        String SEP = System.getProperty("file.separator");
        File root = new File("");
        File f = new File(root.getAbsolutePath() + SEP + "src" + SEP + "back" + SEP + "dao" + SEP + "properties" + SEP + "Properties.ini");
        String[] array = new String[3];
        Boolean encontrado = false;
        try {
            BufferedReader br = new BufferedReader(new FileReader(f.getAbsolutePath()));
            String linea = br.readLine();
            while (linea != null) {
                if (linea.startsWith(";") || (linea.trim().isEmpty())) {
                    linea = br.readLine();
                    continue;
                }
                if (!encontrado) {
                    if (linea.contains("[" + bdName + "]")) {
                        encontrado = true;
                        linea = br.readLine();
                    }
                } else {
                    if (linea.contains(";")) {
                        linea = linea.substring(0, linea.indexOf(";"));
                    }
                    if (linea.contains("host=")) {
                        linea = linea.trim();
                        linea = linea.replace("host=", "");
                        array[0] = linea;
                    } else if (linea.contains("username=")) {
                        linea = linea.trim();
                        linea = linea.replace("username=", "");
                        array[1] = linea;
                    } else if (linea.contains("password=")) {
                        linea = linea.trim();
                        linea = linea.replace("password=", "");
                        array[2] = linea;
                    }
                    linea = br.readLine();
                }
            }
        } catch (FileNotFoundException ex) {
            MyLogger.escribirLog("Archivo properties.ini no encontrado");
            MyLogger.escribirLog(ex);
        } catch (IOException ex) {
            MyLogger.escribirLog("Archivo properties.ini no pudo ser leido");
            MyLogger.escribirLog(ex);
        }
        return array;
    }

}
