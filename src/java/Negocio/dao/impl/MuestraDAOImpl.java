/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio.dao.impl;

import Negocio.GestionSQL;
import Negocio.Log;
import Negocio.dao.MuestraDAO;
import Negocio.dto.Muestra;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author jorge.correa
 */
public class MuestraDAOImpl implements MuestraDAO{
    
    @Override
    public List<Muestra> obtenerTodas(String strAccion) {
        
        String OBTENER_TODAS = "";
        
        if (strAccion.equals("R")){
            OBTENER_TODAS = "SELECT * FROM muestras_quirema.tbl_muestras ORDER BY CAST(strConsecutivo as SIGNED)";
        }else{
            OBTENER_TODAS = "SELECT * FROM muestras_quirema.tbl_muestras_enviadas ORDER BY CAST(strConsecutivo as SIGNED)";
        }
        
        Vector arrMuestras = GestionSQL.consultaSQL(OBTENER_TODAS, "MUESTRAS_TODO");
        List<Muestra> muestras = null;
        String[] strTemp = null;
        Muestra muestra = null;
                
         if (arrMuestras != null){
             muestras = new ArrayList<Muestra>();
             
             for(int i=0;i<arrMuestras.size();i++){        
                strTemp = arrMuestras.get(i).toString().split(",");
                
                muestra = new Muestra();
                muestra.setCodigo(Integer.parseInt(strTemp[0]));
                muestra.setConsecutivo(strTemp[1]);
                muestra.setComentario(strTemp[2]);                                
                muestra.setFechaRecepcion(strTemp[3]);                                               
                muestra.setFechaEstimadaEntrega(strTemp[4]);
                muestra.setEstado(strTemp[5]);
                muestra.setCodigoCliente(strTemp[6]);
                muestra.setAutor(strTemp[7]);
                muestra.setCantidadMuestras(Integer.parseInt(strTemp[8]));
                muestra.setUsuarioEntrega(strTemp[9]);
                muestra.setTipoAnalisis(strTemp[10]);
                muestra.setResponsable(strTemp[11]);
                muestra.setCostoServicio(strTemp[12]);                 
                muestra.setFechaEntregaReal(strTemp[13]);
                muestras.add(muestra);
             }             
         }
         
        return muestras;
    }

    @Override
    public Muestra obtenerUna(String strConsecutivo, String strTipoMuestra) {
        
        String OBTENER_UNA = "";        
        String[] strTemp = null;
        Muestra muestra = null;
        
        if (strTipoMuestra.equals("R")){
            OBTENER_UNA = "SELECT * FROM muestras_quirema.tbl_muestras WHERE strConsecutivo = '" + strConsecutivo + "'";            
        }else{
            OBTENER_UNA = "SELECT * FROM muestras_quirema.tbl_muestras_enviadas WHERE strConsecutivo = '" + strConsecutivo + "'";
        }
                       
        strTemp = GestionSQL.getFila(OBTENER_UNA);
        
        if (strTemp != null){
            
                muestra = new Muestra();
                muestra.setCodigo(Integer.parseInt(strTemp[0]));
                muestra.setConsecutivo(strTemp[1]);
                muestra.setComentario(strTemp[2]);                                
                muestra.setFechaRecepcion(strTemp[3]);                                              
                muestra.setFechaEstimadaEntrega(strTemp[4]);
                muestra.setEstado(strTemp[5]);
                muestra.setCodigoCliente(strTemp[6]);
                muestra.setAutor(strTemp[7]);
                muestra.setCantidadMuestras(Integer.parseInt(strTemp[8]));
                muestra.setUsuarioEntrega(strTemp[9]);
                muestra.setTipoAnalisis(strTemp[10]);
                muestra.setResponsable(strTemp[11]);
                muestra.setCostoServicio(strTemp[12]);                                 
                muestra.setFechaEntregaReal(strTemp[13]);            
        }
        
        return muestra;
    }

    @Override
    public Boolean insertar(Muestra muestra, String strTipoMuestra) {
        String strConsecutivo=null, strComentario=null, strFechaRecepcion=null,strFechaEntrega=null,strEstado=null,strCodPersona=null,strAutor=null,strCantidadMuestras=null,strUsuarioEntrega=null;
        String strTipoAnalisis=null,strResponsable=null,strCostoServicio=null,strFechaEntregaReal=null;
        String strMensaje = null, INSERTAR=null;
        Boolean correcto = Boolean.FALSE;
        
        if (muestra != null){
            strConsecutivo = muestra.getConsecutivo();
            strComentario = muestra.getComentario();
            strFechaRecepcion  = muestra.getFechaRecepcion();
            strFechaEntrega  = muestra.getFechaEstimadaEntrega().toString();            
            strEstado  = muestra.getEstado();
            strCodPersona  = muestra.getCodigoCliente();
            strAutor  = muestra.getAutor();
            strCantidadMuestras  = muestra.getCantidadMuestras().toString();
            strUsuarioEntrega  = muestra.getUsuarioEntrega();
            strTipoAnalisis  = muestra.getTipoAnalisis();
            strResponsable = muestra.getResponsable();
            strCostoServicio  = muestra.getCostoServicio();
            strFechaEntregaReal = muestra.getFechaEntregaReal();
            
            if (strTipoMuestra.equals("R")){
                if (!strFechaEntregaReal.equals("")){

                    INSERTAR = "INSERT INTO muestras_quirema.tbl_muestras(strConsecutivo,strDescripcion,dtFechaRecepcion,dtFechaEntrega,strEstado,intPersona,strAutor,intCantidadMuestras,strUsuarioEntrega,strTipoAnalisis,strResponsable,strCostoServicio,dtFechaEntregaReal) " + 
                                                   "VALUES('" + strConsecutivo + "','" + strComentario + "','" + strFechaRecepcion + "','" + strFechaEntrega + "','" + strEstado + "','" + strCodPersona + "','" + strAutor + "','" + strCantidadMuestras + "','" + strUsuarioEntrega + "','" + strTipoAnalisis + "','" + strResponsable + "','" + strCostoServicio+ "','" + strFechaEntregaReal + "')";
                }else{
                    INSERTAR = "INSERT INTO muestras_quirema.tbl_muestras(strConsecutivo,strDescripcion,dtFechaRecepcion,dtFechaEntrega,strEstado,intPersona,strAutor,intCantidadMuestras,strUsuarioEntrega,strTipoAnalisis,strResponsable,strCostoServicio) " + 
                                                   "VALUES('" + strConsecutivo + "','" + strComentario + "','" + strFechaRecepcion + "','" + strFechaEntrega + "','" + strEstado + "','" + strCodPersona + "','" + strAutor + "','" + strCantidadMuestras + "','" + strUsuarioEntrega + "','" + strTipoAnalisis + "','" + strResponsable + "','" + strCostoServicio+ "')";
                }
            }else{
                if (!strFechaEntregaReal.equals("")){

                    INSERTAR = "INSERT INTO muestras_quirema.tbl_muestras_enviadas(strConsecutivo,strDescripcion,dtFechaRecepcion,dtFechaEntrega,strEstado,intPersona,strAutor,intCantidadMuestras,strUsuarioEntrega,strTipoAnalisis,strResponsable,strCostoServicio,dtFechaEntregaReal) " + 
                                                   "VALUES('" + strConsecutivo + "','" + strComentario + "','" + strFechaRecepcion + "','" + strFechaEntrega + "','" + strEstado + "','" + strCodPersona + "','" + strAutor + "','" + strCantidadMuestras + "','" + strUsuarioEntrega + "','" + strTipoAnalisis + "','" + strResponsable + "','" + strCostoServicio+ "','" + strFechaEntregaReal + "')";
                }else{
                    INSERTAR = "INSERT INTO muestras_quirema.tbl_muestras_enviadas(strConsecutivo,strDescripcion,dtFechaRecepcion,dtFechaEntrega,strEstado,intPersona,strAutor,intCantidadMuestras,strUsuarioEntrega,strTipoAnalisis,strResponsable,strCostoServicio) " + 
                                                   "VALUES('" + strConsecutivo + "','" + strComentario + "','" + strFechaRecepcion + "','" + strFechaEntrega + "','" + strEstado + "','" + strCodPersona + "','" + strAutor + "','" + strCantidadMuestras + "','" + strUsuarioEntrega + "','" + strTipoAnalisis + "','" + strResponsable + "','" + strCostoServicio+ "')";
                }
            }
             
            strMensaje = GestionSQL.ejecuta(INSERTAR);

            if (strMensaje == null){
                correcto = Boolean.TRUE;
                Log.registroTraza("La muestra con consecutivo " + strConsecutivo + " se insertó correctamente!");
            }else{
                correcto = Boolean.FALSE;
                Log.registroTraza("La muestra con consecutivo " + strConsecutivo + " NO se insertó correctamente!");
            }                        
        }
        
        return correcto;
    }

    @Override
    public Boolean actualizar(Muestra muestra, String strTipoMuestra) {
        String strConsecutivo=null, strComentario=null, strFechaRecepcion=null,strFechaEntrega=null,strEstado=null,strCodPersona=null,strAutor=null,strCantidadMuestras=null,strUsuarioEntrega=null;
        String strTipoAnalisis=null,strResponsable=null,strCostoServicio=null,strFechaEntregaReal=null;
        String strMensaje = null, ACTUALIZAR=null;
        Boolean correcto = Boolean.FALSE;
        
        if (muestra != null){
            strConsecutivo = muestra.getConsecutivo();
            strComentario = muestra.getComentario();
            strFechaRecepcion  = muestra.getFechaRecepcion().toString();
            strFechaEntrega  = muestra.getFechaEstimadaEntrega().toString();
            strEstado  = muestra.getEstado();
            strCodPersona  = muestra.getCodigoCliente();
            strAutor  = muestra.getAutor();
            strCantidadMuestras  = muestra.getCantidadMuestras().toString();
            strUsuarioEntrega  = muestra.getUsuarioEntrega();
            strTipoAnalisis  = muestra.getTipoAnalisis();
            strResponsable = muestra.getResponsable();
            strCostoServicio  = muestra.getCostoServicio();
            strFechaEntregaReal  = muestra.getFechaEntregaReal().toString();
            
            if (strTipoMuestra.equals("R")){
                if (!strFechaEntregaReal.equals("")){
                    ACTUALIZAR = "UPDATE muestras_quirema.tbl_muestras SET strDescripcion='" + strComentario + "',dtFechaRecepcion='" + strFechaRecepcion + "',dtFechaEntrega='" + strFechaEntrega + "',strEstado='" + strEstado + "',intPersona='" + strCodPersona + "',strAutor='" + strAutor + "',intCantidadMuestras='" + strCantidadMuestras + "',strUsuarioEntrega='" + strUsuarioEntrega + "',strTipoAnalisis='" + strTipoAnalisis + "',strResponsable='" + strResponsable + "',strCostoServicio='" + strCostoServicio + "',dtFechaEntregaReal='" + strFechaEntregaReal + "' WHERE strConsecutivo='" + strConsecutivo + "'";
                }else{
                    ACTUALIZAR = "UPDATE muestras_quirema.tbl_muestras SET strDescripcion='" + strComentario + "',dtFechaRecepcion='" + strFechaRecepcion + "',dtFechaEntrega='" + strFechaEntrega + "',strEstado='" + strEstado + "',intPersona='" + strCodPersona + "',strAutor='" + strAutor + "',intCantidadMuestras='" + strCantidadMuestras + "',strUsuarioEntrega='" + strUsuarioEntrega + "',strTipoAnalisis='" + strTipoAnalisis + "',strResponsable='" + strResponsable + "',strCostoServicio='" + strCostoServicio + "' WHERE strConsecutivo='" + strConsecutivo + "'";
                }
            }else{
                if (!strFechaEntregaReal.equals("")){
                    ACTUALIZAR = "UPDATE muestras_quirema.tbl_muestras_enviadas SET strDescripcion='" + strComentario + "',dtFechaRecepcion='" + strFechaRecepcion + "',dtFechaEntrega='" + strFechaEntrega + "',strEstado='" + strEstado + "',intPersona='" + strCodPersona + "',strAutor='" + strAutor + "',intCantidadMuestras='" + strCantidadMuestras + "',strUsuarioEntrega='" + strUsuarioEntrega + "',strTipoAnalisis='" + strTipoAnalisis + "',strResponsable='" + strResponsable + "',strCostoServicio='" + strCostoServicio + "',dtFechaEntregaReal='" + strFechaEntregaReal + "' WHERE strConsecutivo='" + strConsecutivo + "'";
                }else{
                    ACTUALIZAR = "UPDATE muestras_quirema.tbl_muestras_enviadas SET strDescripcion='" + strComentario + "',dtFechaRecepcion='" + strFechaRecepcion + "',dtFechaEntrega='" + strFechaEntrega + "',strEstado='" + strEstado + "',intPersona='" + strCodPersona + "',strAutor='" + strAutor + "',intCantidadMuestras='" + strCantidadMuestras + "',strUsuarioEntrega='" + strUsuarioEntrega + "',strTipoAnalisis='" + strTipoAnalisis + "',strResponsable='" + strResponsable + "',strCostoServicio='" + strCostoServicio + "' WHERE strConsecutivo='" + strConsecutivo + "'";
                }
            }
                                                            
            strMensaje = GestionSQL.ejecuta(ACTUALIZAR);

            if (strMensaje == null){
                correcto = Boolean.TRUE;                
                Log.registroTraza("La muestra con consecutivo " + strConsecutivo + " se actualizó correctamente!");
            }else{
                correcto = Boolean.FALSE;                
                Log.registroTraza("La muestra con consecutivo " + strConsecutivo + " NO se actualizó correctamente!");
            }
        }
        
         return correcto;
    }

    @Override
    public Boolean eliminar(String strConsecutivo, String strTipoMuestra) {
        
        String strMensaje = null;
        Boolean correcto = Boolean.FALSE;
        String ELIMINAR = "";
        
        if (strTipoMuestra.equals("R")){
            ELIMINAR = "DELETE * FROM muestras_quirema.tbl_muestras WHERE strConsecutivo = '" + strConsecutivo + "'";
        }else{
            ELIMINAR = "DELETE * FROM tbl_muestras_enviadas.tbl_muestras WHERE strConsecutivo = '" + strConsecutivo + "'";
        }
        
        strMensaje = GestionSQL.ejecuta(ELIMINAR);

        if (strMensaje == null){
            correcto = Boolean.TRUE;
            Log.registroTraza("La muestra con consecutivo " + strConsecutivo + " se eliminó correctamente!");
        }else{
             correcto = Boolean.FALSE;
            Log.registroTraza("La muestra con consecutivo " + strConsecutivo + " NO se eliminó correctamente!");
        }
        
         return correcto;
    }    
}
