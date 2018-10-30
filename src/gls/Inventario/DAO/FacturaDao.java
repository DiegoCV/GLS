/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */
//    Un generador de código no basta. Ahora debo inventar también un generador de frases tontas  \\
package gls.Inventario.DAO;

import gls.Inventario.DTO.Factura;
import gls.Util.MyLogger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FacturaDao {

    private static Connection cn;

    /**
     * Inicializa una única conexión a la base de datos, que se usará para cada
     * consulta.
     */
    public FacturaDao() {
        cn = getConexion();
    }

    private Connection getConexion() {
        if (cn == null) {
            cn = Vinculo.getConexion("Factura");
        }
        return cn;
    }

    /**
     * Guarda un objeto Factura en la base de datos.
     *
     * @param factura objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves
     * foraneas son null
     */
    public int insert(Factura factura) throws NullPointerException {
        int last_inserted_id = -1;
        try {
            PreparedStatement consulta = getConexion().prepareStatement(
                    "INSERT INTO `factura`( `id`, `total`)"
                    + "VALUES (?,?)");
            consulta.setInt(1, factura.getId());
            consulta.setDouble(2, factura.getTotal());            
            consulta.executeUpdate();
            ResultSet rs = consulta.getGeneratedKeys();
            if (rs.next()) {
                last_inserted_id = rs.getInt(1);
            }
            consulta.close();
        } catch (SQLException e) {
            MyLogger.escribirLog(e);
            getConexion();
        }
        return last_inserted_id;
    }

    /**
     * Busca un objeto Factura en la base de datos.
     *
     * @param factura objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves
     * foraneas son null
     */
    public Factura select(Factura factura) throws NullPointerException {
        try {
            PreparedStatement consulta = getConexion().prepareStatement(
                    "SELECT `id`, `total`, `timestamp`"
                    + "FROM `factura`"
                    + "WHERE `id`=?");
            consulta.setInt(1, factura.getId());

            ResultSet res = consulta.executeQuery();
            while (res.next()) {
                factura.setId(res.getInt("id"));
                factura.setTotal(res.getDouble("total"));
                factura.setTimestamp(res.getString("timestamp"));

            }
            res.close();
            consulta.close();
        } catch (SQLException e) {
            MyLogger.escribirLog(e);
            getConexion();
            return null;
        }
        return factura;
    }

    /**
     * Modifica un objeto Factura en la base de datos.
     *
     * @param factura objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves
     * foraneas son null
     */
    public void update(Factura factura) throws NullPointerException {
        try {
            PreparedStatement consulta = getConexion().prepareStatement(
                    "UPDATE `factura` SET`id`=?, `total`=? WHERE `id`=? ");
            consulta.setInt(1, factura.getId());
            consulta.setDouble(2, factura.getTotal());            
            consulta.setInt(3, factura.getId());

            consulta.executeUpdate();
            consulta.close();
        } catch (SQLException e) {
            MyLogger.escribirLog(e);
            getConexion();
        }
    }

    /**
     * Elimina un objeto Factura en la base de datos.
     *
     * @param factura objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves
     * foraneas son null
     */
    public void delete(Factura factura) throws NullPointerException {
        try {
            PreparedStatement consulta = getConexion().prepareStatement(
                    "DELETE FROM `factura` WHERE `id`=?");
            consulta.setInt(1, factura.getId());

            consulta.executeUpdate();
            consulta.close();
        } catch (SQLException e) {
            MyLogger.escribirLog(e);
            getConexion();
        }
    }

    /**
     * Lista todos los objetos Factura en la base de datos.
     *
     * @return ArrayList<Factura> Listado de todos los registros en base de
     * datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves
     * foraneas son null
     */
    public ArrayList<Factura> listAll() throws NullPointerException {
        ArrayList<Factura> lista = new ArrayList();
        try {
            PreparedStatement consulta = getConexion().prepareStatement(
                    "SELECT `id`, `total`, `timestamp`"
                    + "FROM `factura`"
                    + "WHERE 1");
            ResultSet res = consulta.executeQuery();
            while (res.next()) {
                Factura factura = new Factura();
                factura.setId(res.getInt("id"));
                factura.setTotal(res.getDouble("total"));
                factura.setTimestamp(res.getString("timestamp"));

                lista.add(factura);
            }
            res.close();
            consulta.close();
        } catch (SQLException e) {
            MyLogger.escribirLog(e);
            getConexion();
            return null;
        }
        return lista;
    }

    /**
     * Cierra la conexión actual a la base de datos
     */
    public void close() {
        try {
            cn.close();
        } catch (SQLException e) {
            MyLogger.escribirLog(e);
            getConexion();
        }
    }
}
//That´s all folks!
