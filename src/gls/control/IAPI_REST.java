/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gls.control;

import gls.control.DTO.Carrito_venta;
import gls.control.DTO.Carrito_Compra;

/**
 *
 * @author DiegoCarrascal
 */
public interface IAPI_REST {
    
    public Carrito_venta post_vender_articulos(String json);
    
     public Carrito_Compra post_comprar_articulos(String json);
    
}
