/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio;

/**
 *
 * @author Jorge.correa
 */
public class ValoresMuestra {
    
    private String strSQL;
    private String[] strTemp;
    
    public ValoresMuestra(){
        this.strSQL = null;
        this.strTemp = null;
    }
    
    public String obtenerPersona(String strCodigo){
        String strPersona = null;
        
        this.strSQL = "SELECT p.strNombre FROM muestras_quirema.tbl_personas p WHERE p.intCedula = '" + strCodigo + "'";
        this.strTemp = GestionSQL.getFila(this.strSQL);
        
        if (this.strTemp != null){
            strPersona = this.strTemp[0];
        }
        
        return strPersona;
    }
    
    public String obtenerEstado(String strCodigo){
        String strEstado = null;
        
        this.strSQL = "SELECT p.strNombre FROM muestras_quirema.tbl_estados p WHERE p.strCodigo = '" + strCodigo + "'";
        this.strTemp = GestionSQL.getFila(this.strSQL);
        
        if (this.strTemp != null){
            strEstado = this.strTemp[0];
        }
        
        return strEstado;
    }
    
    public String obtenerTipoAnalisis(String strCodigo){
        String strTipoAnalisis = null;
        
        this.strSQL = "SELECT p.strNombre FROM muestras_quirema.tbl_tipos_analisis p WHERE p.strCodigo = '" + strCodigo + "'";
        this.strTemp = GestionSQL.getFila(this.strSQL);
        
        if (this.strTemp != null){
            strTipoAnalisis = this.strTemp[0];
        }
        
        return strTipoAnalisis;
    }
    
    public String obtenerVacioNulo(String strValor){
        String strRpta = "";
        
        if ((strValor == null) || (strValor.equals("")) || (strValor.equals("null"))){
            strRpta = "-";
        }else{
            strRpta = strValor.trim();
        }
        
        return strRpta;
    }
}
