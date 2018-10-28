/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Si crees que las mujeres son difíciles, no conoces Anarchy  \\

package gls.Inventario.DTO;

public class Articulo {

  private int id;
  private String nombre;
  private String descripcion;
  private Grupo grupo;
  private int cantidad;
  private int isServicio;  
  private Bodega bodega;

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
     * Devuelve el valor correspondiente a descripcion
     * @return descripcion
     */
  public String getDescripcion(){
      return this.descripcion;
  }

    /**
     * Modifica el valor correspondiente a descripcion
     * @param descripcion
     */
  public void setDescripcion(String descripcion){
      this.descripcion = descripcion;
  }
    /**
     * Devuelve el valor correspondiente a grupo
     * @return grupo
     */
  public Grupo getGrupo(){
      return this.grupo;
  }

    /**
     * Modifica el valor correspondiente a grupo
     * @param grupo
     */
  public void setGrupo(Grupo grupo){
      this.grupo = grupo;
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
     * Devuelve el valor correspondiente a isServicio
     * @return isServicio
     */
  public int getIsServicio(){
      return this.isServicio;
  }

    /**
     * Modifica el valor correspondiente a isServicio
     * @param isServicio
     */
  public void setIsServicio(int isServicio){
      this.isServicio = isServicio;
  }    

    /**
     * Devuelve el valor correspondiente a bodega
     * @return bodega
     */
  public Bodega getBodega(){
      return this.bodega;
  }

    /**
     * Modifica el valor correspondiente a bodega
     * @param bodega
     */
  public void setBodega(Bodega bodega){
      this.bodega = bodega;
  }


}
//That´s all folks!