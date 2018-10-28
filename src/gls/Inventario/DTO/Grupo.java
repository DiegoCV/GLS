/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Hey ¿cómo se llama tu café internet?  \\

package gls.Inventario.DTO;

public class Grupo {

  private int id;
  private String nombre;
  private String unidadMedida;

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
     * Devuelve el valor correspondiente a unidadMedida
     * @return unidadMedida
     */
  public String getUnidadMedida(){
      return this.unidadMedida;
  }

    /**
     * Modifica el valor correspondiente a unidadMedida
     * @param unidadMedida
     */
  public void setUnidadMedida(String unidadMedida){
      this.unidadMedida = unidadMedida;
  }


}
//That´s all folks!