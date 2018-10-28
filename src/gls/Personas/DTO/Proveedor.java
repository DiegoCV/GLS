/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Un tequila, antes de que empiecen los trancazos  \\

package gls.Personas.DTO;

public class Proveedor {

  private int id;
  private String nombre;
  private String telefono;

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
     * Devuelve el valor correspondiente a telefono
     * @return telefono
     */
  public String getTelefono(){
      return this.telefono;
  }

    /**
     * Modifica el valor correspondiente a telefono
     * @param telefono
     */
  public void setTelefono(String telefono){
      this.telefono = telefono;
  }


}
//That´s all folks!