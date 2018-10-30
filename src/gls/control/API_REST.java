/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gls.control;

import com.google.gson.Gson;
import gls.control.DTO.Carrito_Compra;
import gls.control.DTO.Carrito_venta;

/**
 *
 * @author DiegoCarrascal
 */
public class API_REST implements IAPI_REST {

    private final Gson gson;

    private static API_REST api;

    private API_REST() {
        this.gson = new Gson();
    }

    public static API_REST getSingletonInstance() {
        if (api == null) {
            api = new API_REST();
        }
        return api;
    }

    @Override
    public Carrito_venta post_vender_articulos(String json) {
        return gson.fromJson(json, Carrito_venta.class);
    }

    @Override
    public Carrito_Compra post_comprar_articulos(String json) {
        return this.gson.fromJson(json, Carrito_Compra.class);
    }

   

}
