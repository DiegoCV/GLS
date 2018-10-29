/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */
//    Podrías agradecernos con unos cuantos billetes _/(n.n)\_  \\
package gls.Inventario.DAO;

import gls.Inventario.DTO.Articulo;
import gls.Inventario.DTO.Factura;
import gls.Inventario.DTO.Movimiento;
import gls.Inventario.DTO.Tiopmovimiento;
import gls.Personas.DTO.Cliente;
import gls.Personas.DTO.Proveedor;
import gls.Personas.DTO.Usuario;
import gls.Util.MyLogger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MovimientoDao{

    private static Connection cn;

    /**
     * Inicializa una única conexión a la base de datos, que se usará para cada
     * consulta.
     */
    public MovimientoDao() {
        cn = getConexion();
    }

    private Connection getConexion() {
        if (cn == null) {
            cn = Vinculo.getConexion("Movimiento");
        }
        return cn;
    }    
    
    /**
     * Guarda un objeto Movimiento en la base de datos.
     *
     * @param movimiento objeto a guardar
     * @return El id generado para la inserción
     * @throws NullPointerException Si los objetos correspondientes a las llaves
     * foraneas son null
     */
    
    public int insert(Movimiento movimiento) throws NullPointerException {
        int last_inserted_id = -1;
        try {
            PreparedStatement consulta = cn.prepareStatement(
                    "INSERT INTO `movimiento`( `id`, `precioUni`, `cantidad`, `cliente`, `articulo`, `tiopMovimiento`, `proveedor`, `usuario`, `factura_id`)"
                    + "VALUES (?,?,?,?,?,?,?,?,?)");
            consulta.setInt(1, movimiento.getId());
            consulta.setDouble(2, movimiento.getPrecioUni());
            consulta.setInt(3, movimiento.getCantidad());
            consulta.setString(4, movimiento.getCliente().getCedula());
            consulta.setInt(5, movimiento.getArticulo().getId());
            consulta.setInt(6, movimiento.getTiopmovimiento().getId());
            consulta.setInt(7, movimiento.getProveedor().getId());
            consulta.setString(8, movimiento.getUsuario().getUser());
            consulta.setInt(9, movimiento.getFactura().getId());
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
     * Busca un objeto Movimiento en la base de datos.
     *
     * @param movimiento objeto con la(s) llave(s) primaria(s) para consultar
     * @return El objeto consultado o null
     * @throws NullPointerException Si los objetos correspondientes a las llaves
     * foraneas son null
     */
    
    public Movimiento select(Movimiento movimiento) throws NullPointerException {
        try {
            PreparedStatement consulta = cn.prepareStatement(
                    "SELECT `id`, `precioUni`, `cantidad`, `cliente`, `articulo`, `tiopMovimiento`, `proveedor`, `usuario`, `factura_id`"
                    + "FROM `movimiento`"
                    + "WHERE `id`=?");
            consulta.setInt(1, movimiento.getId());

            ResultSet res = consulta.executeQuery();
            while (res.next()) {
                movimiento.setId(res.getInt("id"));
                movimiento.setPrecioUni(res.getDouble("precioUni"));
                movimiento.setCantidad(res.getInt("cantidad"));
                Cliente cliente = new Cliente();
                cliente.setCedula(res.getString("cliente"));
                movimiento.setCliente(cliente);
                Articulo articulo = new Articulo();
                articulo.setId(res.getInt("articulo"));
                movimiento.setArticulo(articulo);
                Tiopmovimiento tiopmovimiento = new Tiopmovimiento();
                tiopmovimiento.setId(res.getInt("tiopMovimiento"));
                movimiento.setTiopmovimiento(tiopmovimiento);
                Proveedor proveedor = new Proveedor();
                proveedor.setId(res.getInt("proveedor"));
                movimiento.setProveedor(proveedor);
                Usuario usuario = new Usuario();
                usuario.setUser(res.getString("usuario"));
                movimiento.setUsuario(usuario);
                Factura factura = new Factura();
                factura.setId(res.getInt("factura_id"));
                movimiento.setFactura(factura);
            }
            res.close();
            consulta.close();
        } catch (SQLException e) {
            MyLogger.escribirLog(e);
            getConexion();
            return null;
        }
        return movimiento;
    }

    /**
     * Modifica un objeto Movimiento en la base de datos.
     *
     * @param movimiento objeto con la información a modificar
     * @throws NullPointerException Si los objetos correspondientes a las llaves
     * foraneas son null
     */
    
    public void update(Movimiento movimiento) throws NullPointerException {
        try {
            PreparedStatement consulta = cn.prepareStatement(
                    "UPDATE `movimiento` SET`id`=?, `precioUni`=?, `cantidad`=?, `cliente`=?, `articulo`=?, `tiopMovimiento`=?, `proveedor`=?, `usuario`=?, `factura_id`=? WHERE `id`=? ");
            consulta.setInt(1, movimiento.getId());
            consulta.setDouble(2, movimiento.getPrecioUni());
            consulta.setInt(3, movimiento.getCantidad());
            consulta.setString(4, movimiento.getCliente().getCedula());
            consulta.setInt(5, movimiento.getArticulo().getId());
            consulta.setInt(6, movimiento.getTiopmovimiento().getId());
            consulta.setInt(7, movimiento.getProveedor().getId());
            consulta.setString(8, movimiento.getUsuario().getUser());
            consulta.setInt(9, movimiento.getFactura().getId());
            consulta.setInt(10, movimiento.getId());

            consulta.executeUpdate();
            consulta.close();
        } catch (SQLException e) {
            MyLogger.escribirLog(e);
            getConexion();
        }
    }

    /**
     * Elimina un objeto Movimiento en la base de datos.
     *
     * @param movimiento objeto con la(s) llave(s) primaria(s) para consultar
     * @throws NullPointerException Si los objetos correspondientes a las llaves
     * foraneas son null
     */
    
    public void delete(Movimiento movimiento) throws NullPointerException {
        try {
            PreparedStatement consulta = cn.prepareStatement(
                    "DELETE FROM `movimiento` WHERE `id`=?");
            consulta.setInt(1, movimiento.getId());

            consulta.executeUpdate();
            consulta.close();
        } catch (SQLException e) {
            MyLogger.escribirLog(e);
            getConexion();
        }
    }

    /**
     * Lista todos los objetos Movimiento en la base de datos.
     *
     * @return ArrayList<Movimiento> Listado de todos los registros en base de
     * datos
     * @throws NullPointerException Si los objetos correspondientes a las llaves
     * foraneas son null
     */
    
    public ArrayList<Movimiento> listAll() throws NullPointerException {
        ArrayList<Movimiento> lista = new ArrayList();
        try {
            PreparedStatement consulta = cn.prepareStatement(
                    "SELECT `id`, `precioUni`, `cantidad`, `cliente`, `articulo`, `tiopMovimiento`, `proveedor`, `usuario`, `factura_id`"
                    + "FROM `movimiento`"
                    + "WHERE 1");
            ResultSet res = consulta.executeQuery();
            while (res.next()) {
                Movimiento movimiento = new Movimiento();
                movimiento.setId(res.getInt("id"));
                movimiento.setPrecioUni(res.getDouble("precioUni"));
                movimiento.setCantidad(res.getInt("cantidad"));
                Cliente cliente = new Cliente();
                cliente.setCedula(res.getString("cliente"));
                movimiento.setCliente(cliente);
                Articulo articulo = new Articulo();
                articulo.setId(res.getInt("articulo"));
                movimiento.setArticulo(articulo);
                Tiopmovimiento tiopmovimiento = new Tiopmovimiento();
                tiopmovimiento.setId(res.getInt("tiopMovimiento"));
                movimiento.setTiopmovimiento(tiopmovimiento);
                Proveedor proveedor = new Proveedor();
                proveedor.setId(res.getInt("proveedor"));
                movimiento.setProveedor(proveedor);
                Usuario usuario = new Usuario();
                usuario.setUser(res.getString("usuario"));
                movimiento.setUsuario(usuario);
                Factura factura = new Factura();
                factura.setId(res.getInt("factura_id"));
                movimiento.setFactura(factura);

                lista.add(movimiento);
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

    public ArrayList<Movimiento> listByFactura(Factura factura) throws NullPointerException{
        ArrayList<Movimiento> lista = new ArrayList();
        try {
            PreparedStatement consulta = cn.prepareStatement(
                    "SELECT `id`, `precioUni`, `cantidad`, `cliente`, `articulo`, `tiopMovimiento`, `proveedor`, `usuario`, `factura_id`"
                    + "FROM `movimiento`"
                    + "WHERE `factura_id` = " + factura.getId());
            ResultSet res = consulta.executeQuery();
            while (res.next()) {
                Movimiento movimiento = new Movimiento();
                movimiento.setId(res.getInt("id"));
                movimiento.setPrecioUni(res.getDouble("precioUni"));
                movimiento.setCantidad(res.getInt("cantidad"));
                Cliente cliente = new Cliente();
                cliente.setCedula(res.getString("cliente"));
                movimiento.setCliente(cliente);
                Articulo articulo = new Articulo();
                articulo.setId(res.getInt("articulo"));
                movimiento.setArticulo(articulo);
                Tiopmovimiento tiopmovimiento = new Tiopmovimiento();
                tiopmovimiento.setId(res.getInt("tiopMovimiento"));
                movimiento.setTiopmovimiento(tiopmovimiento);
                Proveedor proveedor = new Proveedor();
                proveedor.setId(res.getInt("proveedor"));
                movimiento.setProveedor(proveedor);
                Usuario usuario = new Usuario();
                usuario.setUser(res.getString("usuario"));
                movimiento.setUsuario(usuario);                
                movimiento.setFactura(factura);
                lista.add(movimiento);
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
}
//That´s all folks!
