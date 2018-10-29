/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Nuestra empresa cuenta con una división sólo para las frases. Disfrútalas  \\

package gls.Personas.DTO;

public class Usuario {

  private String user;
  private String password;
  private int tipo;

    /**
     * Devuelve el valor correspondiente a user
     * @return user
     */
  public String getUser(){
      return this.user;
  }

    /**
     * Modifica el valor correspondiente a user
     * @param user
     */
  public void setUser(String user){
      this.user = user;
  }
    /**
     * Devuelve el valor correspondiente a password
     * @return password
     */
  public String getPassword(){
      return this.password;
  }

    /**
     * Modifica el valor correspondiente a password
     * @param password
     */
  public void setPassword(String password){
      this.password = password;
  }
    /**
     * Devuelve el valor correspondiente a tipo
     * @return tipo
     */
  public int getTipo(){
      return this.tipo;
  }

    /**
     * Modifica el valor correspondiente a tipo
     * @param tipo
     */
  public void setTipo(int tipo){
      this.tipo = tipo;
  }


}
//That´s all folks!