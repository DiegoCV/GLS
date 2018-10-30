/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gls.control.compras;

import gls.control.MyServlet;
import gls.control.API_REST;
import gls.control.DTO.Carrito_Compra;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DiegoCarrascal
 */
public class Comprar_Articulos extends MyServlet {

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        API_REST api = API_REST.getSingletonInstance();
        Carrito_Compra cc = api.post_comprar_articulos(request.getQueryString());
        /*
            Su logica
         */
        response.setContentType("application/json");      
        PrintWriter out = response.getWriter();  
        out.print("jsonObject");
        out.flush();
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
