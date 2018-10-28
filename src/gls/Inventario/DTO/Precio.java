/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Has encontrado la frase #1024 ¡Felicidades! Ahora tu proyecto funcionará a la primera  \\

package gls.Inventario.DTO;

import gls.Inventario.DTO.Articulo;

public class Precio {

  private Articulo articulo;
  private double precioCompra;
  private double precioVenta;

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
     * Devuelve el valor correspondiente a precioCompra
     * @return precioCompra
     */
  public double getPrecioCompra(){
      return this.precioCompra;
  }

    /**
     * Modifica el valor correspondiente a precioCompra
     * @param precioCompra
     */
  public void setPrecioCompra(double precioCompra){
      this.precioCompra = precioCompra;
  }
    /**
     * Devuelve el valor correspondiente a precioVenta
     * @return precioVenta
     */
  public double getPrecioVenta(){
      return this.precioVenta;
  }

    /**
     * Modifica el valor correspondiente a precioVenta
     * @param precioVenta
     */
  public void setPrecioVenta(double precioVenta){
      this.precioVenta = precioVenta;
  }


}
//That´s all folks!