/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */
//    Ella existió sólo en un sueño. Él es un poema que el poeta nunca escribió.  \\
package gls.Inventario.DAO;

import gls.Inventario.DTO.Articulo;
import gls.Inventario.DTO.Limbo;
import gls.Util.MyLogger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LimboDao {

    private static Connection cn;

    /**
     * Inicializa una única conexión a la base de datos, que se usará para cada
     * consulta.
     */
    public LimboDao() {
        cn = getConexion();
    }

    private Connection getConexion() {
        if (cn == null) {
            cn = Vinculo.getConexion("Limbo");
        }
        return cn;
    }

    /**
     * Guarda un objeto Limbo en la base de datos.
     *
     * @param limbo objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves
     * foraneas son null
     */
    public int insert(Limbo limbo) throws NullPointerException {
        int last_inserted_id = -1;
        try {
            PreparedStatement consulta = getConexion().prepareStatement(
                    "INSERT INTO `limbo`( `articulo`, `cantidad`, `timestamp`)"
                    + "VALUES (?,?,?)");
            consulta.setInt(1, limbo.getArticulo().getId());
            consulta.setInt(2, limbo.getCantidad());
            consulta.setString(3, limbo.getTimestamp());
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
     * Busca un objeto Limbo en la base de datos.
     *
     * @param limbo objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves
     * foraneas son null
     */
    public Limbo select(Limbo limbo) throws NullPointerException {
        try {
            PreparedStatement consulta = getConexion().prepareStatement(
                    "SELECT `articulo`, `cantidad`, `timestamp`"
                    + "FROM `limbo`"
                    + "WHERE `articulo`=?");
            consulta.setInt(1, limbo.getArticulo().getId());

            ResultSet res = consulta.executeQuery();
            while (res.next()) {
                Articulo articulo = new Articulo();
                articulo.setId(res.getInt("articulo"));
                limbo.setArticulo(articulo);
                limbo.setCantidad(res.getInt("cantidad"));
                limbo.setTimestamp(res.getString("timestamp"));

            }
            res.close();
            consulta.close();
        } catch (SQLException e) {
            MyLogger.escribirLog(e);
            getConexion();
            return null;
        }
        return limbo;
    }

    /**
     * Modifica un objeto Limbo en la base de datos.
     *
     * @param limbo objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves
     * foraneas son null
     */
    public void update(Limbo limbo) throws NullPointerException {
        try {
            PreparedStatement consulta = getConexion().prepareStatement(
                    "UPDATE `limbo` SET`articulo`=?, `cantidad`=?, `timestamp`=? WHERE `articulo`=? ");
            consulta.setInt(1, limbo.getArticulo().getId());
            consulta.setInt(2, limbo.getCantidad());
            consulta.setString(3, limbo.getTimestamp());
            consulta.setInt(4, limbo.getArticulo().getId());

            consulta.executeUpdate();
            consulta.close();
        } catch (SQLException e) {
            MyLogger.escribirLog(e);
            getConexion();
        }
    }

    /**
     * Elimina un objeto Limbo en la base de datos.
     *
     * @param limbo objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves
     * foraneas son null
     */
    public void delete(Limbo limbo) throws NullPointerException {
        try {
            PreparedStatement consulta = getConexion().prepareStatement(
                    "DELETE FROM `limbo` WHERE `articulo`=?");
            consulta.setInt(1, limbo.getArticulo().getId());

            consulta.executeUpdate();
            consulta.close();
        } catch (SQLException e) {
            MyLogger.escribirLog(e);
            getConexion();
        }
    }

    /**
     * Lista todos los objetos Limbo en la base de datos.
     *
     * @return ArrayList<Limbo> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves
     * foraneas son null
     */
    public ArrayList<Limbo> listAll() throws NullPointerException {
        ArrayList<Limbo> lista = new ArrayList();
        try {
            PreparedStatement consulta = getConexion().prepareStatement(
                    "SELECT `articulo`, `cantidad`, `timestamp`"
                    + "FROM `limbo`"
                    + "WHERE 1");
            ResultSet res = consulta.executeQuery();
            while (res.next()) {
                Limbo limbo = new Limbo();
                Articulo articulo = new Articulo();
                articulo.setId(res.getInt("articulo"));
                limbo.setArticulo(articulo);
                limbo.setCantidad(res.getInt("cantidad"));
                limbo.setTimestamp(res.getString("timestamp"));

                lista.add(limbo);
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
