/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gls.Inventario;

import gls.Inventario.DTO.*;
import gls.Inventario.DAO.*;
import java.util.ArrayList;

/**
 *
 * @author Fredy Arciniegas
 */
public class InventarioF implements Inventario {

    private static ArticuloDao articuloDao;
    private static BodegaDao bodegaDao;
    private static FacturaDao facturaDao;
    private static GrupoDao grupoDao;
    private static LimboDao limboDao;
    private static MovimientoDao movimientoDao;
    private static PrecioDao precioDao;
    private static TiopmovimientoDao tiopmovimientoDao;

    private static ArticuloDao getArticuloDao() {
        if (articuloDao == null) {
            articuloDao = new ArticuloDao();
        }
        return articuloDao;
    }

    private static BodegaDao getBodegaDao() {
        if (bodegaDao == null) {
            bodegaDao = new BodegaDao();
        }
        return bodegaDao;
    }

    private static FacturaDao getFacturaDao() {
        if (facturaDao == null) {
            facturaDao = new FacturaDao();
        }
        return facturaDao;
    }

    private static GrupoDao getGrupoDao() {
        if (grupoDao == null) {
            grupoDao = new GrupoDao();
        }
        return grupoDao;
    }

    private static LimboDao getLimboDao() {
        if (limboDao == null) {
            limboDao = new LimboDao();
        }
        return limboDao;
    }

    private static MovimientoDao getMovimientoDao() {
        if (movimientoDao == null) {
            movimientoDao = new MovimientoDao();
        }
        return movimientoDao;
    }

    private static PrecioDao getPrecioDao() {
        if (precioDao == null) {
            precioDao = new PrecioDao();
        }
        return precioDao;
    }

    private static TiopmovimientoDao getTiopmovimientoDao() {
        if (tiopmovimientoDao == null) {
            tiopmovimientoDao = new TiopmovimientoDao();
        }
        return tiopmovimientoDao;
    }

    @Override
    public int insertBodega(int id) {
        Bodega bodega = new Bodega();
        bodega.setId(id);
        return getBodegaDao().insert(bodega);
    }

    @Override
    public ArrayList<Bodega> listBodegas() {
        return getBodegaDao().listAll();
    }

    @Override
    public ArrayList<Articulo> listArticulos() {
        return getArticuloDao().listAll();
    }

    @Override
    public ArrayList<Grupo> listGrupos() {
        return getGrupoDao().listAll();
    }

    @Override
    public int insertFactura(Factura factura) {
        return getFacturaDao().insert(factura);
    }

    @Override
    public void updateArticulo(Articulo articulo) {
        getArticuloDao().update(articulo);
    }

    @Override
    public int insertMovimiento(Movimiento movimiento) {
        return getMovimientoDao().insert(movimiento);
    }

    @Override
    public ArrayList<Movimiento> listMovimientosByFactura(Factura factura) {
        return getMovimientoDao().listByFactura(factura);
    }

    @Override
    public void updateLimbo(Limbo limbo) {
        getLimboDao().update(limbo);
    }

    @Override
    public void insertLimbo(Limbo limbo) {
        getLimboDao().insert(limbo);
    }

    @Override
    public Limbo selectLimbo(Limbo limbo) {
        return getLimboDao().select(limbo);
    }

    @Override
    public void updateFactura(Factura factura) {
        getFacturaDao().update(factura);
    }

}
