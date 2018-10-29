/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */
//    Cuenta la leyenda que si gritas 'Soy programador' las nenas caerán a tus pies  \\
package gls.Personas.DAO;

import gls.Personas.DTO.Proveedor;
import gls.Util.MyLogger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProveedorDao {

    private static Connection cn;

    /**
     * Inicializa una única conexión a la base de datos, que se usará para cada
     * consulta.
     */
    public ProveedorDao() {
        cn = getConexion();
    }

    private Connection getConexion() {
        if (cn == null) {
            cn = Vinculo.getConexion("Proveedor");
        }
        return cn;
    }

    /**
     * Guarda un objeto Proveedor en la base de datos.
     *
     * @param proveedor objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves
     * foraneas son null
     */
    public int insert(Proveedor proveedor) throws NullPointerException {
        int last_inserted_id = -1;
        try {
            PreparedStatement consulta = cn.prepareStatement(
                    "INSERT INTO `proveedor`( `id`, `nombre`, `telefono`)"
                    + "VALUES (?,?,?)");
            consulta.setInt(1, proveedor.getId());
            consulta.setString(2, proveedor.getNombre());
            consulta.setString(3, proveedor.getTelefono());
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
     * Busca un objeto Proveedor en la base de datos.
     *
     * @param proveedor objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves
     * foraneas son null
     */
    public Proveedor select(Proveedor proveedor) throws NullPointerException {
        try {
            PreparedStatement consulta = cn.prepareStatement(
                    "SELECT `id`, `nombre`, `telefono`"
                    + "FROM `proveedor`"
                    + "WHERE `id`=?");
            consulta.setInt(1, proveedor.getId());

            ResultSet res = consulta.executeQuery();
            while (res.next()) {
                proveedor.setId(res.getInt("id"));
                proveedor.setNombre(res.getString("nombre"));
                proveedor.setTelefono(res.getString("telefono"));

            }
            res.close();
            consulta.close();
        } catch (SQLException e) {
            MyLogger.escribirLog(e);
            getConexion();
            return null;
        }
        return proveedor;
    }

    /**
     * Modifica un objeto Proveedor en la base de datos.
     *
     * @param proveedor objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves
     * foraneas son null
     */
    public void update(Proveedor proveedor) throws NullPointerException {
        try {
            PreparedStatement consulta = cn.prepareStatement(
                    "UPDATE `proveedor` SET`id`=?, `nombre`=?, `telefono`=? WHERE `id`=? ");
            consulta.setInt(1, proveedor.getId());
            consulta.setString(2, proveedor.getNombre());
            consulta.setString(3, proveedor.getTelefono());
            consulta.setInt(4, proveedor.getId());

            consulta.executeUpdate();
            consulta.close();
        } catch (SQLException e) {
            MyLogger.escribirLog(e);
            getConexion();
        }
    }

    /**
     * Elimina un objeto Proveedor en la base de datos.
     *
     * @param proveedor objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves
     * foraneas son null
     */
    public void delete(Proveedor proveedor) throws NullPointerException {
        try {
            PreparedStatement consulta = cn.prepareStatement(
                    "DELETE FROM `proveedor` WHERE `id`=?");
            consulta.setInt(1, proveedor.getId());

            consulta.executeUpdate();
            consulta.close();
        } catch (SQLException e) {
            MyLogger.escribirLog(e);
            getConexion();
        }
    }

    /**
     * Lista todos los objetos Proveedor en la base de datos.
     *
     * @return ArrayList<Proveedor> Listado de todos los registros en base de
     * datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves
     * foraneas son null
     */
    public ArrayList<Proveedor> listAll() throws NullPointerException {
        ArrayList<Proveedor> lista = new ArrayList();
        try {
            PreparedStatement consulta = cn.prepareStatement(
                    "SELECT `id`, `nombre`, `telefono`"
                    + "FROM `proveedor`"
                    + "WHERE 1");
            ResultSet res = consulta.executeQuery();
            while (res.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setId(res.getInt("id"));
                proveedor.setNombre(res.getString("nombre"));
                proveedor.setTelefono(res.getString("telefono"));

                lista.add(proveedor);
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
