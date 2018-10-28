/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */
//    Un generador de código no basta. Ahora debo inventar también un generador de frases tontas  \\
package gls.Inventario.DAO;

import gls.Inventario.DAO.Vinculo;
import gls.Inventario.DTO.Bodega;
import gls.Util.MyLogger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BodegaDao {

    private static Connection cn;

    /**
     * Inicializa una única conexión a la base de datos, que se usará para cada
     * consulta.
     */
    public BodegaDao() {
        cn = getConexion();
    }

    private Connection getConexion() {
        if (cn == null) {
            cn = Vinculo.getConexion("Bodega");
        }
        return cn;
    }

    /**
     * Guarda un objeto Bodega en la base de datos.
     *
     * @param bodega objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves
     * foraneas son null
     */
    public int insert(Bodega bodega) throws NullPointerException {
        int last_inserted_id = -1;
        try {
            PreparedStatement consulta = getConexion().prepareStatement(
                    "INSERT INTO `bodega`( `id`, `nombre`, `detalles`)"
                    + "VALUES (?,?,?)");
            consulta.setInt(1, bodega.getId());
            consulta.setString(2, bodega.getNombre());
            consulta.setString(3, bodega.getDetalles());
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
     * Busca un objeto Bodega en la base de datos.
     *
     * @param bodega objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves
     * foraneas son null
     */
    public Bodega select(Bodega bodega) throws NullPointerException {
        try {
            PreparedStatement consulta = getConexion().prepareStatement(
                    "SELECT `id`, `nombre`, `detalles`"
                    + "FROM `bodega`"
                    + "WHERE `id`=?");
            consulta.setInt(1, bodega.getId());

            ResultSet res = consulta.executeQuery();
            while (res.next()) {
                bodega.setId(res.getInt("id"));
                bodega.setNombre(res.getString("nombre"));
                bodega.setDetalles(res.getString("detalles"));

            }
            res.close();
            consulta.close();
        } catch (SQLException e) {
            MyLogger.escribirLog(e);
            getConexion();
            return null;
        }
        return bodega;
    }

    /**
     * Modifica un objeto Bodega en la base de datos.
     *
     * @param bodega objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves
     * foraneas son null
     */
    public void update(Bodega bodega) throws NullPointerException {
        try {
            PreparedStatement consulta = getConexion().prepareStatement(
                    "UPDATE `bodega` SET`id`=?, `nombre`=?, `detalles`=? WHERE `id`=? ");
            consulta.setInt(1, bodega.getId());
            consulta.setString(2, bodega.getNombre());
            consulta.setString(3, bodega.getDetalles());
            consulta.setInt(4, bodega.getId());

            consulta.executeUpdate();
            consulta.close();
        } catch (SQLException e) {
            MyLogger.escribirLog(e);
            getConexion();
        }
    }

    /**
     * Elimina un objeto Bodega en la base de datos.
     *
     * @param bodega objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves
     * foraneas son null
     */
    public void delete(Bodega bodega) throws NullPointerException {
        try {
            PreparedStatement consulta = getConexion().prepareStatement(
                    "DELETE FROM `bodega` WHERE `id`=?");
            consulta.setInt(1, bodega.getId());

            consulta.executeUpdate();
            consulta.close();
        } catch (SQLException e) {
            MyLogger.escribirLog(e);
            getConexion();
        }
    }

    /**
     * Lista todos los objetos Bodega en la base de datos.
     *
     * @return ArrayList<Bodega> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves
     * foraneas son null
     */
    public ArrayList<Bodega> listAll() throws NullPointerException {
        ArrayList<Bodega> lista = new ArrayList();
        try {
            PreparedStatement consulta = getConexion().prepareStatement(
                    "SELECT `id`, `nombre`, `detalles`"
                    + "FROM `bodega`"
                    + "WHERE 1");
            ResultSet res = consulta.executeQuery();
            while (res.next()) {
                Bodega bodega = new Bodega();
                bodega.setId(res.getInt("id"));
                bodega.setNombre(res.getString("nombre"));
                bodega.setDetalles(res.getString("detalles"));

                lista.add(bodega);
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
            cn = null;
        } catch (SQLException e) {
            MyLogger.escribirLog(e);
        }
    }
}
//That´s all folks!
