/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */
//    No quiero morir sin tener cicatrices.  \\
package gls.Inventario.DAO;

import gls.Inventario.DTO.Tiopmovimiento;
import gls.Util.MyLogger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TiopmovimientoDao {

    private static Connection cn;

    /**
     * Inicializa una única conexión a la base de datos, que se usará para cada
     * consulta.
     */
    public TiopmovimientoDao() {
        cn = getConexion();
    }

    private Connection getConexion() {
        if (cn == null) {
            cn = Vinculo.getConexion("Tiopmovimiento");
        }
        return cn;
    }
    
    /**
     * Guarda un objeto Tiopmovimiento en la base de datos.
     *
     * @param tiopmovimiento objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves
     * foraneas son null
     */
    
    public int insert(Tiopmovimiento tiopmovimiento) throws NullPointerException {
        int last_inserted_id = -1;
        try {
            PreparedStatement consulta = cn.prepareStatement(
                    "INSERT INTO `tiopmovimiento`( `id`, `nombre`)"
                    + "VALUES (?,?)");
            consulta.setInt(1, tiopmovimiento.getId());
            consulta.setString(2, tiopmovimiento.getNombre());
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
     * Busca un objeto Tiopmovimiento en la base de datos.
     *
     * @param tiopmovimiento objeto con la(s) llave(s) primaria(s) para
     * consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves
     * foraneas son null
     */
    
    public Tiopmovimiento select(Tiopmovimiento tiopmovimiento) throws NullPointerException {
        try {
            PreparedStatement consulta = cn.prepareStatement(
                    "SELECT `id`, `nombre`"
                    + "FROM `tiopmovimiento`"
                    + "WHERE `id`=?");
            consulta.setInt(1, tiopmovimiento.getId());

            ResultSet res = consulta.executeQuery();
            while (res.next()) {
                tiopmovimiento.setId(res.getInt("id"));
                tiopmovimiento.setNombre(res.getString("nombre"));

            }
            res.close();
            consulta.close();
        } catch (SQLException e) {
            MyLogger.escribirLog(e);
            getConexion();
            return null;
        }
        return tiopmovimiento;
    }

    /**
     * Modifica un objeto Tiopmovimiento en la base de datos.
     *
     * @param tiopmovimiento objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves
     * foraneas son null
     */
    
    public void update(Tiopmovimiento tiopmovimiento) throws NullPointerException {
        try {
            PreparedStatement consulta = cn.prepareStatement(
                    "UPDATE `tiopmovimiento` SET`id`=?, `nombre`=? WHERE `id`=? ");
            consulta.setInt(1, tiopmovimiento.getId());
            consulta.setString(2, tiopmovimiento.getNombre());
            consulta.setInt(3, tiopmovimiento.getId());

            consulta.executeUpdate();
            consulta.close();
        } catch (SQLException e) {
            MyLogger.escribirLog(e);
            getConexion();
        }
    }

    /**
     * Elimina un objeto Tiopmovimiento en la base de datos.
     *
     * @param tiopmovimiento objeto con la(s) llave(s) primaria(s) para
     * consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves
     * foraneas son null
     */
    
    public void delete(Tiopmovimiento tiopmovimiento) throws NullPointerException {
        try {
            PreparedStatement consulta = cn.prepareStatement(
                    "DELETE FROM `tiopmovimiento` WHERE `id`=?");
            consulta.setInt(1, tiopmovimiento.getId());

            consulta.executeUpdate();
            consulta.close();
        } catch (SQLException e) {
            MyLogger.escribirLog(e);
            getConexion();
        }
    }

    /**
     * Lista todos los objetos Tiopmovimiento en la base de datos.
     *
     * @return ArrayList<Tiopmovimiento> Listado de todos los registros en base
     * de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves
     * foraneas son null
     */
    
    public ArrayList<Tiopmovimiento> listAll() throws NullPointerException {
        ArrayList<Tiopmovimiento> lista = new ArrayList();
        try {
            PreparedStatement consulta = cn.prepareStatement(
                    "SELECT `id`, `nombre`"
                    + "FROM `tiopmovimiento`"
                    + "WHERE 1");
            ResultSet res = consulta.executeQuery();
            while (res.next()) {
                Tiopmovimiento tiopmovimiento = new Tiopmovimiento();
                tiopmovimiento.setId(res.getInt("id"));
                tiopmovimiento.setNombre(res.getString("nombre"));

                lista.add(tiopmovimiento);
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
