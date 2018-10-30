/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gls.Inventario;

import gls.Inventario.DTO.Articulo;
import gls.Inventario.DTO.Bodega;
import gls.Inventario.DTO.Factura;
import gls.Inventario.DTO.Grupo;
import gls.Inventario.DTO.Limbo;
import gls.Inventario.DTO.Movimiento;
import java.util.ArrayList;

/**
 *
 * @author Fredy Arciniegas
 */
public interface Inventario {
    
    public ArrayList<Bodega> listBodegas();
    
    public int insertBodega(int id);

    public ArrayList<Articulo> listArticulos();

    public ArrayList<Grupo> listGrupos();

    public int insertFactura(Factura factura);

    public void updateArticulo(Articulo articulo);

    public int insertMovimiento(Movimiento movimiento);    
    
    public ArrayList<Movimiento> listMovimientosByFactura(Factura factura);

    public void updateLimbo(Limbo limbo);

    public void insertLimbo(Limbo limbo);

    public Limbo selectLimbo(Limbo limbo);

    public void updateFactura(Factura factura);    
    
}
