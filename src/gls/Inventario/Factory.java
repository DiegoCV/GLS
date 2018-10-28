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
public class Factory implements Inventario {

    private static ArticuloDao articuloDao;
    private static BodegaDao bodegaDao;
    private static GrupoDao grupoDao;
    private static LimboDao limboDao;
    private static PrecioDao precioDao;

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
    
    private static PrecioDao getPrecioDao() {
        if (precioDao == null) {
            precioDao = new PrecioDao();
        }
        return precioDao;
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

}
