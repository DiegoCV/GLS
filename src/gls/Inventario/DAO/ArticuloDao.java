/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */
//    Ojitos de luz de luna  \\
package gls.Inventario.DAO;

import gls.Inventario.DTO.Articulo;
import gls.Inventario.DTO.Bodega;
import gls.Inventario.DTO.Grupo;
import gls.Util.MyLogger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ArticuloDao {

    private static Connection cn;

    /**
     * Inicializa una única conexión a la base de datos, que se usará para cada
     * consulta.
     */
    public ArticuloDao() {
        cn = getConexion();
    }

    private Connection getConexion() {
        if (cn == null) {
            cn = Vinculo.getConexion("Articulo");
        }
        return cn;
    }

    /**
     * Guarda un objeto Articulo en la base de datos.
     *
     * @param articulo objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves
     * foraneas son null
     */
    public int insert(Articulo articulo) throws NullPointerException {
        int last_inserted_id = -1;
        try {
            PreparedStatement consulta = getConexion().prepareStatement(
                    "INSERT INTO `articulo`( `id`, `nombre`, `descripcion`, `grupo`, `cantidad`, `isServicio`, `bodega`)"
                    + "VALUES (?,?,?,?,?,?,?)");
            consulta.setInt(1, articulo.getId());
            consulta.setString(2, articulo.getNombre());
            consulta.setString(3, articulo.getDescripcion());
            consulta.setInt(4, articulo.getGrupo().getId());
            consulta.setInt(5, articulo.getCantidad());
            consulta.setInt(6, articulo.getIsServicio());           
            consulta.setInt(7, articulo.getBodega().getId());
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
     * Busca un objeto Articulo en la base de datos.
     *
     * @param articulo objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves
     * foraneas son null
     */
    public Articulo select(Articulo articulo) throws NullPointerException {
        try {
            PreparedStatement consulta = getConexion().prepareStatement(
                    "SELECT `id`, `nombre`, `descripcion`, `grupo`, `cantidad`, `isServicio`, `parteDe`, `bodega`"
                    + "FROM `articulo`"
                    + "WHERE `id`=?");
            consulta.setInt(1, articulo.getId());

            ResultSet res = consulta.executeQuery();
            while (res.next()) {
                articulo.setId(res.getInt("id"));
                articulo.setNombre(res.getString("nombre"));
                articulo.setDescripcion(res.getString("descripcion"));
                Grupo grupo = new Grupo();
                grupo.setId(res.getInt("grupo"));
                articulo.setGrupo(grupo);
                articulo.setCantidad(res.getInt("cantidad"));
                articulo.setIsServicio(res.getInt("isServicio"));
                Bodega bodega = new Bodega();
                bodega.setId(res.getInt("bodega"));
                articulo.setBodega(bodega);
            }
            res.close();
            consulta.close();
        } catch (SQLException e) {
            MyLogger.escribirLog(e);
            getConexion();
            return null;
        }
        return articulo;
    }

    /**
     * Modifica un objeto Articulo en la base de datos.
     *
     * @param articulo objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves
     * foraneas son null
     */
    public void update(Articulo articulo) throws NullPointerException {
        try {
            PreparedStatement consulta = getConexion().prepareStatement(
                    "UPDATE `articulo` SET`id`=?, `nombre`=?, `descripcion`=?, `grupo`=?, `cantidad`=?, `isServicio`=?, `bodega`=? WHERE `id`=? ");
            consulta.setInt(1, articulo.getId());
            consulta.setString(2, articulo.getNombre());
            consulta.setString(3, articulo.getDescripcion());
            consulta.setInt(4, articulo.getGrupo().getId());
            consulta.setInt(5, articulo.getCantidad());
            consulta.setInt(6, articulo.getIsServicio());            
            consulta.setInt(7, articulo.getBodega().getId());
            consulta.setInt(8, articulo.getId());

            consulta.executeUpdate();
            consulta.close();
        } catch (SQLException e) {
            MyLogger.escribirLog(e);
            getConexion();
        }
    }

    /**
     * Elimina un objeto Articulo en la base de datos.
     *
     * @param articulo objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves
     * foraneas son null
     */
    public void delete(Articulo articulo) throws NullPointerException {
        try {
            PreparedStatement consulta = getConexion().prepareStatement(
                    "DELETE FROM `articulo` WHERE `id`=?");
            consulta.setInt(1, articulo.getId());

            consulta.executeUpdate();
            consulta.close();
        } catch (SQLException e) {
            MyLogger.escribirLog(e);
            getConexion();
        }
    }

    /**
     * Lista todos los objetos Articulo en la base de datos.
     *
     * @return ArrayList<Articulo> Listado de todos los registros en base de
     * datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves
     * foraneas son null
     */
    public ArrayList<Articulo> listAll() throws NullPointerException {
        ArrayList<Articulo> lista = new ArrayList();
        try {
            PreparedStatement consulta = getConexion().prepareStatement(
                    "SELECT `id`, `nombre`, `descripcion`, `grupo`, `cantidad`, `isServicio`, `bodega`"
                    + "FROM `articulo`"
                    + "WHERE 1");
            ResultSet res = consulta.executeQuery();
            while (res.next()) {
                Articulo articulo = new Articulo();
                articulo.setId(res.getInt("id"));
                articulo.setNombre(res.getString("nombre"));
                articulo.setDescripcion(res.getString("descripcion"));
                Grupo grupo = new Grupo();
                grupo.setId(res.getInt("grupo"));
                articulo.setGrupo(grupo);
                articulo.setCantidad(res.getInt("cantidad"));
                articulo.setIsServicio(res.getInt("isServicio"));            
                Bodega bodega = new Bodega();
                bodega.setId(res.getInt("bodega"));
                articulo.setBodega(bodega);

                lista.add(articulo);
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
        }
    }
}
//That´s all folks!
