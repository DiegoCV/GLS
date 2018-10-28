/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */
//    gravitaban alrededor del astro de la noche, y por primera vez podía la vista penetrar todos sus misterios.  \\
package gls.Inventario.DAO;

import gls.Inventario.DTO.Grupo;
import gls.Util.MyLogger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GrupoDao {

    private static Connection cn;

    /**
     * Inicializa una única conexión a la base de datos, que se usará para cada
     * consulta.
     */
    public GrupoDao() {
        cn = getConexion();
    }

    private Connection getConexion() {
        if (cn == null) {
            cn = Vinculo.getConexion("Grupo");
        }
        return cn;
    }

    /**
     * Guarda un objeto Grupo en la base de datos.
     *
     * @param grupo objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves
     * foraneas son null
     */
    
    public int insert(Grupo grupo) throws NullPointerException {
        int last_inserted_id = -1;
        try {
            PreparedStatement consulta = getConexion().prepareStatement(
                    "INSERT INTO `grupo`( `id`, `nombre`, `unidadMedida`)"
                    + "VALUES (?,?,?)");
            consulta.setInt(1, grupo.getId());
            consulta.setString(2, grupo.getNombre());
            consulta.setString(3, grupo.getUnidadMedida());
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
     * Busca un objeto Grupo en la base de datos.
     *
     * @param grupo objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves
     * foraneas son null
     */
    
    public Grupo select(Grupo grupo) throws NullPointerException {
        try {
            PreparedStatement consulta = getConexion().prepareStatement(
                    "SELECT `id`, `nombre`, `unidadMedida`"
                    + "FROM `grupo`"
                    + "WHERE `id`=?");
            consulta.setInt(1, grupo.getId());

            ResultSet res = consulta.executeQuery();
            while (res.next()) {
                grupo.setId(res.getInt("id"));
                grupo.setNombre(res.getString("nombre"));
                grupo.setUnidadMedida(res.getString("unidadMedida"));

            }
            res.close();
            consulta.close();
        } catch (SQLException e) {
            MyLogger.escribirLog(e);
            getConexion();
            return null;
        }
        return grupo;
    }

    /**
     * Modifica un objeto Grupo en la base de datos.
     *
     * @param grupo objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves
     * foraneas son null
     */
    
    public void update(Grupo grupo) throws NullPointerException {
        try {
            PreparedStatement consulta = getConexion().prepareStatement(
                    "UPDATE `grupo` SET`id`=?, `nombre`=?, `unidadMedida`=? WHERE `id`=? ");
            consulta.setInt(1, grupo.getId());
            consulta.setString(2, grupo.getNombre());
            consulta.setString(3, grupo.getUnidadMedida());
            consulta.setInt(4, grupo.getId());

            consulta.executeUpdate();
            consulta.close();
        } catch (SQLException e) {
            MyLogger.escribirLog(e);
            getConexion();
        }
    }

    /**
     * Elimina un objeto Grupo en la base de datos.
     *
     * @param grupo objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves
     * foraneas son null
     */
    
    public void delete(Grupo grupo) throws NullPointerException {
        try {
            PreparedStatement consulta = getConexion().prepareStatement(
                    "DELETE FROM `grupo` WHERE `id`=?");
            consulta.setInt(1, grupo.getId());

            consulta.executeUpdate();
            consulta.close();
        } catch (SQLException e) {
            MyLogger.escribirLog(e);
            getConexion();
        }
    }

    /**
     * Lista todos los objetos Grupo en la base de datos.
     *
     * @return ArrayList<Grupo> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves
     * foraneas son null
     */
    
    public ArrayList<Grupo> listAll() throws NullPointerException {
        ArrayList<Grupo> lista = new ArrayList();
        try {
            PreparedStatement consulta = getConexion().prepareStatement(
                    "SELECT `id`, `nombre`, `unidadMedida`"
                    + "FROM `grupo`"
                    + "WHERE 1");
            ResultSet res = consulta.executeQuery();
            while (res.next()) {
                Grupo grupo = new Grupo();
                grupo.setId(res.getInt("id"));
                grupo.setNombre(res.getString("nombre"));
                grupo.setUnidadMedida(res.getString("unidadMedida"));

                lista.add(grupo);
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
