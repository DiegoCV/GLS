/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */
//    Mátalos a todos, y que dios elija  \\
package gls.Personas.DAO;

import gls.Personas.DTO.Cliente;
import gls.Util.MyLogger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDao {

    private static Connection cn;

    /**
     * Inicializa una única conexión a la base de datos, que se usará para cada
     * consulta.
     */
    public ClienteDao() {
        cn = getConexion();
    }

    private Connection getConexion() {
        if (cn == null) {
            cn = Vinculo.getConexion("Cliente");
        }
        return cn;
    }

    /**
     * Guarda un objeto Cliente en la base de datos.
     *
     * @param cliente objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves
     * foraneas son null
     */
    public int insert(Cliente cliente) throws NullPointerException {
        int last_inserted_id = -1;
        try {
            PreparedStatement consulta = cn.prepareStatement(
                    "INSERT INTO `cliente`( `cedula`, `nombre`, `telefono`)"
                    + "VALUES (?,?,?)");
            consulta.setString(1, cliente.getCedula());
            consulta.setString(2, cliente.getNombre());
            consulta.setString(3, cliente.getTelefono());
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
     * Busca un objeto Cliente en la base de datos.
     *
     * @param cliente objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves
     * foraneas son null
     */
    public Cliente select(Cliente cliente) throws NullPointerException {
        try {
            PreparedStatement consulta = cn.prepareStatement(
                    "SELECT `cedula`, `nombre`, `telefono`"
                    + "FROM `cliente`"
                    + "WHERE `cedula`=?");
            consulta.setString(1, cliente.getCedula());

            ResultSet res = consulta.executeQuery();
            while (res.next()) {
                cliente.setCedula(res.getString("cedula"));
                cliente.setNombre(res.getString("nombre"));
                cliente.setTelefono(res.getString("telefono"));

            }
            res.close();
            consulta.close();
        } catch (SQLException e) {
            MyLogger.escribirLog(e);
            getConexion();
            return null;
        }
        return cliente;
    }

    /**
     * Modifica un objeto Cliente en la base de datos.
     *
     * @param cliente objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves
     * foraneas son null
     */
    public void update(Cliente cliente) throws NullPointerException {
        try {
            PreparedStatement consulta = cn.prepareStatement(
                    "UPDATE `cliente` SET`cedula`=?, `nombre`=?, `telefono`=? WHERE `cedula`=? ");
            consulta.setString(1, cliente.getCedula());
            consulta.setString(2, cliente.getNombre());
            consulta.setString(3, cliente.getTelefono());
            consulta.setString(4, cliente.getCedula());

            consulta.executeUpdate();
            consulta.close();
        } catch (SQLException e) {
            MyLogger.escribirLog(e);
            getConexion();
        }
    }

    /**
     * Elimina un objeto Cliente en la base de datos.
     *
     * @param cliente objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves
     * foraneas son null
     */
    public void delete(Cliente cliente) throws NullPointerException {
        try {
            PreparedStatement consulta = cn.prepareStatement(
                    "DELETE FROM `cliente` WHERE `cedula`=?");
            consulta.setString(1, cliente.getCedula());

            consulta.executeUpdate();
            consulta.close();
        } catch (SQLException e) {
            MyLogger.escribirLog(e);
            getConexion();
        }
    }

    /**
     * Lista todos los objetos Cliente en la base de datos.
     *
     * @return ArrayList<Cliente> Listado de todos los registros en base de
     * datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves
     * foraneas son null
     */
    public ArrayList<Cliente> listAll() throws NullPointerException {
        ArrayList<Cliente> lista = new ArrayList();
        try {
            PreparedStatement consulta = cn.prepareStatement(
                    "SELECT `cedula`, `nombre`, `telefono`"
                    + "FROM `cliente`"
                    + "WHERE 1");
            ResultSet res = consulta.executeQuery();
            while (res.next()) {
                Cliente cliente = new Cliente();
                cliente.setCedula(res.getString("cedula"));
                cliente.setNombre(res.getString("nombre"));
                cliente.setTelefono(res.getString("telefono"));

                lista.add(cliente);
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
