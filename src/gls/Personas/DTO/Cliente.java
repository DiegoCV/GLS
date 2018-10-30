/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Mi satisfacción es hacerte un poco más vago  \\

package gls.Personas.DTO;

public class Cliente {

  private String cedula;
  private String nombre;
  private String telefono;


    /**
     * Devuelve el valor correspondiente a cedula
     * @return cedula
     */
  public String getCedula(){
      return this.cedula;
  }

    /**
     * Modifica el valor correspondiente a cedula
     * @param cedula
     */
  public void setCedula(String cedula){
      this.cedula = cedula;
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