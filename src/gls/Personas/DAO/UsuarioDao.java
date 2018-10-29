/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */
//    A vote for Bart is a vote for Anarchy!  \\
package gls.Personas.DAO;

import gls.Personas.DTO.Usuario;
import gls.Util.MyLogger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDao {

    private static Connection cn;

    /**
     * Inicializa una única conexión a la base de datos, que se usará para cada
     * consulta.
     */
    public UsuarioDao() {
        cn = getConexion();
    }

    private Connection getConexion() {
        if (cn == null) {
            cn = Vinculo.getConexion("Usuario");
        }
        return cn;
    }

    /**
     * Guarda un objeto Usuario en la base de datos.
     *
     * @param usuario objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves
     * foraneas son null
     */
    public int insert(Usuario usuario) throws NullPointerException {
        int last_inserted_id = -1;
        try {
            PreparedStatement consulta = cn.prepareStatement(
                    "INSERT INTO `usuario`( `user`, `password`, `tipo`)"
                    + "VALUES (?,?,?)");
            consulta.setString(1, usuario.getUser());
            consulta.setString(2, usuario.getPassword());
            consulta.setInt(3, usuario.getTipo());
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
     * Busca un objeto Usuario en la base de datos.
     *
     * @param usuario objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves
     * foraneas son null
     */
    public Usuario select(Usuario usuario) throws NullPointerException {
        try {
            PreparedStatement consulta = cn.prepareStatement(
                    "SELECT `user`, `password`, `tipo`"
                    + "FROM `usuario`"
                    + "WHERE `user`=?");
            consulta.setString(1, usuario.getUser());

            ResultSet res = consulta.executeQuery();
            while (res.next()) {
                usuario.setUser(res.getString("user"));
                usuario.setPassword(res.getString("password"));
                usuario.setTipo(res.getInt("tipo"));

            }
            res.close();
            consulta.close();
        } catch (SQLException e) {
            MyLogger.escribirLog(e);
            getConexion();
            return null;
        }
        return usuario;
    }

    /**
     * Modifica un objeto Usuario en la base de datos.
     *
     * @param usuario objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves
     * foraneas son null
     */
    public void update(Usuario usuario) throws NullPointerException {
        try {
            PreparedStatement consulta = cn.prepareStatement(
                    "UPDATE `usuario` SET`user`=?, `password`=?, `tipo`=? WHERE `user`=? ");
            consulta.setString(1, usuario.getUser());
            consulta.setString(2, usuario.getPassword());
            consulta.setInt(3, usuario.getTipo());
            consulta.setString(4, usuario.getUser());

            consulta.executeUpdate();
            consulta.close();
        } catch (SQLException e) {
            MyLogger.escribirLog(e);
            getConexion();
        }
    }

    /**
     * Elimina un objeto Usuario en la base de datos.
     *
     * @param usuario objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves
     * foraneas son null
     */
    public void delete(Usuario usuario) throws NullPointerException {
        try {
            PreparedStatement consulta = cn.prepareStatement(
                    "DELETE FROM `usuario` WHERE `user`=?");
            consulta.setString(1, usuario.getUser());

            consulta.executeUpdate();
            consulta.close();
        } catch (SQLException e) {
            MyLogger.escribirLog(e);
            getConexion();
        }
    }

    /**
     * Lista todos los objetos Usuario en la base de datos.
     *
     * @return ArrayList<Usuario> Listado de todos los registros en base de
     * datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves
     * foraneas son null
     */
    public ArrayList<Usuario> listAll() throws NullPointerException {
        ArrayList<Usuario> lista = new ArrayList();
        try {
            PreparedStatement consulta = cn.prepareStatement(
                    "SELECT `user`, `password`, `tipo`"
                    + "FROM `usuario`"
                    + "WHERE 1");
            ResultSet res = consulta.executeQuery();
            while (res.next()) {
                Usuario usuario = new Usuario();
                usuario.setUser(res.getString("user"));
                usuario.setPassword(res.getString("password"));
                usuario.setTipo(res.getInt("tipo"));

                lista.add(usuario);
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
