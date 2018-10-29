/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Hey ¿cómo se llama tu café internet?  \\

package gls.Inventario.DTO;

import gls.Personas.DTO.Cliente;
import gls.Personas.DTO.Proveedor;
import gls.Personas.DTO.Usuario;

public class Movimiento {

  private int id;
  private double precioUni;
  private int cantidad;
  private Cliente cliente;
  private Articulo articulo;
  private Tiopmovimiento tiopmovimiento;
  private Proveedor proveedor;
  private Usuario usuario;
  private Factura factura;

    /**
     * Devuelve el valor correspondiente a id
     * @return id
     */
  public int getId(){
      return this.id;
  }

    /**
     * Modifica el valor correspondiente a id
     * @param id
     */
  public void setId(int id){
      this.id = id;
  }
    /**
     * Devuelve el valor correspondiente a precioUni
     * @return precioUni
     */
  public double getPrecioUni(){
      return this.precioUni;
  }

    /**
     * Modifica el valor correspondiente a precioUni
     * @param precioUni
     */
  public void setPrecioUni(double precioUni){
      this.precioUni = precioUni;
  }
    /**
     * Devuelve el valor correspondiente a cantidad
     * @return cantidad
     */
  public int getCantidad(){
      return this.cantidad;
  }

    /**
     * Modifica el valor correspondiente a cantidad
     * @param cantidad
     */
  public void setCantidad(int cantidad){
      this.cantidad = cantidad;
  }
    /**
     * Devuelve el valor correspondiente a cliente
     * @return cliente
     */
  public Cliente getCliente(){
      return this.cliente;
  }

    /**
     * Modifica el valor correspondiente a cliente
     * @param cliente
     */
  public void setCliente(Cliente cliente){
      this.cliente = cliente;
  }
    /**
     * Devuelve el valor correspondiente a articulo
     * @return articulo
     */
  public Articulo getArticulo(){
      return this.articulo;
  }

    /**
     * Modifica el valor correspondiente a articulo
     * @param articulo
     */
  public void setArticulo(Articulo articulo){
      this.articulo = articulo;
  }
    /**
     * Devuelve el valor correspondiente a tiopMovimiento
     * @return tiopMovimiento
     */
  public Tiopmovimiento getTiopmovimiento(){
      return this.tiopmovimiento;
  }

    /**
     * Modifica el valor correspondiente a tiopMovimiento
     * @param tiopMovimiento
     */
  public void setTiopmovimiento(Tiopmovimiento tiopmovimiento){
      this.tiopmovimiento = tiopmovimiento;
  }
    /**
     * Devuelve el valor correspondiente a proveedor
     * @return proveedor
     */
  public Proveedor getProveedor(){
      return this.proveedor;
  }

    /**
     * Modifica el valor correspondiente a proveedor
     * @param proveedor
     */
  public void setProveedor(Proveedor proveedor){
      this.proveedor = proveedor;
  }
    /**
     * Devuelve el valor correspondiente a usuario
     * @return usuario
     */
  public Usuario getUsuario(){
      return this.usuario;
  }

    /**
     * Modifica el valor correspondiente a usuario
     * @param usuario
     */
  public void setUsuario(Usuario usuario){
      this.usuario = usuario;
  }
    /**
     * Devuelve el valor correspondiente a factura_id
     * @return factura_id
     */
  public Factura getFactura(){
      return this.factura;
  }

    /**
     * Modifica el valor correspondiente a factura_id
     * @param factura_id
     */
  public void setFactura(Factura factura){
      this.factura = factura;
  }


}
//That´s all folks!