/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gls.control;
import gls.Inventario.DTO.Cliente;
import gls.Inventario.DTO.Articulo;
import javax.servlet.http.HttpServletRequest;
/**
 *
 * @author DiegoCarrascal
 */
public class Filtro {
    private HttpServletRequest request;

    public Filtro(HttpServletRequest request) {
        this.request = request;
    }
      
    //<editor-fold defaultstate="collapsed" desc="Faturacion">
    public Articulo filtrarArticulos(){
        return new Articulo();
    }
    
    public Cliente filtrarCliente(){
        return new Cliente(
                request.getParameter("cedula")
        );
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="compras">
     public Articulo filtrarProveedores(){
        return new Articulo();
    }
//</editor-fold>
    
}
