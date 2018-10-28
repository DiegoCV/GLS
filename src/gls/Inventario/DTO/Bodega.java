/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Trabajo individual singifica ganancia individual  \\

package gls.Inventario.DTO;

public class Bodega {

  private int id;
  private String nombre;
  private String detalles;

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
     * Devuelve el valor correspondiente a nombre
     * @return nombre
     */
  public String getNombre(){
      return this.nombre;
  }

    /**
     * Modifica el valor correspondiente a nombre
     * @param nombre
     */
  public void setNombre(String nombre){
      this.nombre = nombre;
  }
    /**
     * Devuelve el valor correspondiente a detalles
     * @return detalles
     */
  public String getDetalles(){
      return this.detalles;
  }

    /**
     * Modifica el valor correspondiente a detalles
     * @param detalles
     */
  public void setDetalles(String detalles){
      this.detalles = detalles;
  }


}
//That´s all folks!