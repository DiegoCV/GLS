/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gls.Conexion;

/**
 *
 * @author Fredy Arciniegas
 */
public class Cifrador {

    private static final String KEYWORD="GLS";    
        
    /**
     * Desencripta las credenciales de la base de datos con una llave única
     * especificada al momento de generar el proyecto.
     *
     * @param info     
     * @return
     */
    protected static String cifrar(String info) {
        boolean encript=false;
        char[] infoC = info.toCharArray();
        char[] keyC = KEYWORD.toCharArray();
        for (int i = 0; i < keyC.length; i++) {
            for (int j = 0; j < infoC.length; j++) {
                if (encript) {
                    infoC[j] = (char) (infoC[j] + keyC[i]);
                } else {
                    infoC[j] = (char) (infoC[j] - keyC[i]);
                }
            }
        }
        return new String(infoC);
    }
}
