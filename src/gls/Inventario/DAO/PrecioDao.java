/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */
//    Los animales, asombrados, pasaron su mirada del cerdo al hombre, y del hombre al cerdo; y, nuevamente, del cerdo al hombre; pero ya era imposible distinguir quién era uno y quién era otro.  \\
package gls.Inventario.DAO;

import gls.Inventario.DTO.Articulo;
import gls.Inventario.DTO.Precio;
import gls.Util.MyLogger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PrecioDao {

    private static Connection cn;

    /**
     * Inicializa una única conexión a la base de datos, que se usará para cada
     * consulta.
     */
    public PrecioDao() {
        cn = getConexion();
    }

    private Connection getConexion() {
        if (cn == null) {
            cn = Vinculo.getConexion("Precio");
        }
        return cn;
    }

    /**
     * Guarda un objeto Precio en la base de datos.
     *
     * @param precio objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves
     * foraneas son null
     */
    public int insert(Precio precio) throws NullPointerException {
        int last_inserted_id = -1;
        try {
            PreparedStatement consulta = cn.prepareStatement(
                    "INSERT INTO `precio`( `articulo`, `precioCompra`, `precioVenta`)"
                    + "VALUES (?,?,?)");
            consulta.setInt(1, precio.getArticulo().getId());
            consulta.setDouble(2, precio.getPrecioCompra());
            consulta.setDouble(3, precio.getPrecioVenta());
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
     * Busca un objeto Precio en la base de datos.
     *
     * @param precio objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves
     * foraneas son null
     */
    public Precio select(Precio precio) throws NullPointerException {
        try {
            PreparedStatement consulta = cn.prepareStatement(
                    "SELECT `articulo`, `precioCompra`, `precioVenta`"
                    + "FROM `precio`"
                    + "WHERE `articulo`=?");
            consulta.setInt(1, precio.getArticulo().getId());

            ResultSet res = consulta.executeQuery();
            while (res.next()) {
                Articulo articulo = new Articulo();
                articulo.setId(res.getInt("articulo"));
                precio.setArticulo(articulo);
                precio.setPrecioCompra(res.getDouble("precioCompra"));
                precio.setPrecioVenta(res.getDouble("precioVenta"));

            }
            res.close();
            consulta.close();
        } catch (SQLException e) {
            MyLogger.escribirLog(e);
            getConexion();
            return null;
        }
        return precio;
    }

    /**
     * Modifica un objeto Precio en la base de datos.
     *
     * @param precio objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves
     * foraneas son null
     */
    public void update(Precio precio) throws NullPointerException {
        try {
            PreparedStatement consulta = cn.prepareStatement(
                    "UPDATE `precio` SET`articulo`=?, `precioCompra`=?, `precioVenta`=? WHERE `articulo`=? ");
            consulta.setInt(1, precio.getArticulo().getId());
            consulta.setDouble(2, precio.getPrecioCompra());
            consulta.setDouble(3, precio.getPrecioVenta());
            consulta.setInt(4, precio.getArticulo().getId());

            consulta.executeUpdate();
            consulta.close();
        } catch (SQLException e) {
            MyLogger.escribirLog(e);
            getConexion();
        }
    }

    /**
     * Elimina un objeto Precio en la base de datos.
     *
     * @param precio objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves
     * foraneas son null
     */
    public void delete(Precio precio) throws NullPointerException {
        try {
            PreparedStatement consulta = cn.prepareStatement(
                    "DELETE FROM `precio` WHERE `articulo`=?");
            consulta.setInt(1, precio.getArticulo().getId());

            consulta.executeUpdate();
            consulta.close();
        } catch (SQLException e) {
            MyLogger.escribirLog(e);
            getConexion();
        }
    }

    /**
     * Lista todos los objetos Precio en la base de datos.
     *
     * @return ArrayList<Precio> Listado de todos los registros en base de datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves
     * foraneas son null
     */
    public ArrayList<Precio> listAll() throws NullPointerException {
        ArrayList<Precio> lista = new ArrayList();
        try {
            PreparedStatement consulta = cn.prepareStatement(
                    "SELECT `articulo`, `precioCompra`, `precioVenta`"
                    + "FROM `precio`"
                    + "WHERE 1");
            ResultSet res = consulta.executeQuery();
            while (res.next()) {
                Precio precio = new Precio();
                Articulo articulo = new Articulo();
                articulo.setId(res.getInt("articulo"));
                precio.setArticulo(articulo);
                precio.setPrecioCompra(res.getDouble("precioCompra"));
                precio.setPrecioVenta(res.getDouble("precioVenta"));

                lista.add(precio);
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
