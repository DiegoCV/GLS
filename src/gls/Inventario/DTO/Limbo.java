/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Sólo relájate y deja que alguien más lo haga  \\

package gls.Inventario.DTO;

import gls.Inventario.DTO.Articulo;

public class Limbo {

  private Articulo articulo;
  private int cantidad;
  private String timestamp;

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
     * Devuelve el valor correspondiente a timestamp
     * @return timestamp
     */
  public String getTimestamp(){
      return this.timestamp;
  }

    /**
     * Modifica el valor correspondiente a timestamp
     * @param timestamp
     */
  public void setTimestamp(String timestamp){
      this.timestamp = timestamp;
  }


}
//That´s all folks!