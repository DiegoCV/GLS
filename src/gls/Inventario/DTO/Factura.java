/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Hey ¿cómo se llama tu café internet?  \\

package gls.Inventario.DTO;

public class Factura {

  private int id;
  private double total;
  private String timestamp;

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
     * Devuelve el valor correspondiente a total
     * @return total
     */
  public double getTotal(){
      return this.total;
  }

    /**
     * Modifica el valor correspondiente a total
     * @param total
     */
  public void setTotal(double total){
      this.total = total;
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