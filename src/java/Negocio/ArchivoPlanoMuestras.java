/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio;

import Negocio.dao.MuestraDAO;
import Negocio.dao.impl.MuestraDAOImpl;
import Negocio.dto.Muestra;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jorge.correa
 */
public class ArchivoPlanoMuestras extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
            String strRuta = null, strNombreArchivo=null, strCaracter=null, strRutaArchivo=null, strCadena="", strComentario="";
            String[] strParametros=null;
            List<Muestra> muestras = null, muestras_enviadas = null;
            BufferedWriter bw;
            MuestraDAO muestrasDAO = new MuestraDAOImpl();
            ValoresMuestra valoresMuestra = new ValoresMuestra();
            
            strParametros = GestionSQL.getFila("SELECT g.txtRutaArchivoPlano FROM tbl_generales g where g.strCodigo = 'frmGeneral'");
            
            if (strParametros != null){
                strRuta = strParametros[0];
                
                if (strRuta != null){
                    muestras = muestrasDAO.obtenerTodas("R");
                    muestras_enviadas = muestrasDAO.obtenerTodas("E");
                    strNombreArchivo = "/archivoplanomuestras.txt";                
                    strCaracter = ";";
                     
                    strRutaArchivo = strRuta + strNombreArchivo;
                                        
                    File archivo = new File(strRutaArchivo);                               
                    bw = new BufferedWriter(new FileWriter(archivo));
                    
                     // Conformación de la cabecera.
                
                    strCadena = strCadena + "Consecutivo" + strCaracter;
                    strCadena = strCadena + "Fecha de recepción" + strCaracter;
                    strCadena = strCadena + "Fecha estimada de entrega" + strCaracter;
                    strCadena = strCadena + "Estado" + strCaracter;
                    strCadena = strCadena + "Nombre del cliente" + strCaracter;
                    strCadena = strCadena + "Autor" + strCaracter;
                    strCadena = strCadena + "Cantidad de muestras" + strCaracter;
                    strCadena = strCadena + "Usuario que entrega" + strCaracter;
                    strCadena = strCadena + "Tipo de análisis" + strCaracter;
                    strCadena = strCadena + "Responsable" + strCaracter;
                    strCadena = strCadena + "Costo del servicio" + strCaracter;
                    strCadena = strCadena + "Fecha de entrega real" + strCaracter;
                    strCadena = strCadena + "Tipo de muestra" + strCaracter;
                    strCadena = strCadena + "Comentario" + "\r\n";
                                        
                    bw.write(strCadena);
                    
                    for(Muestra muestra : muestras){
                        strCadena = "";
                                    
                        strCadena = strCadena + muestra.getConsecutivo() + strCaracter;
                        strCadena = strCadena + muestra.getFechaRecepcion() + strCaracter;
                        strCadena = strCadena + muestra.getFechaEstimadaEntrega() + strCaracter;
                        strCadena = strCadena + valoresMuestra.obtenerEstado(muestra.getEstado()) + strCaracter;
                        strCadena = strCadena + valoresMuestra.obtenerPersona(muestra.getCodigoCliente()) + strCaracter;
                        strCadena = strCadena + muestra.getAutor() + strCaracter;
                        strCadena = strCadena + muestra.getCantidadMuestras().toString() + strCaracter;
                        strCadena = strCadena + muestra.getUsuarioEntrega() + strCaracter;
                        strCadena = strCadena + valoresMuestra.obtenerTipoAnalisis(muestra.getTipoAnalisis()) + strCaracter;
                        strCadena = strCadena + valoresMuestra.obtenerPersona(muestra.getResponsable()) + strCaracter;
                        strCadena = strCadena + valoresMuestra.obtenerVacioNulo(muestra.getCostoServicio()) + strCaracter;
                        strCadena = strCadena + valoresMuestra.obtenerVacioNulo(muestra.getFechaEntregaReal()) + strCaracter;
                        strCadena = strCadena + "Recibida" + strCaracter;
                        
                        strComentario = muestra.getComentario();                        
                        strCadena = strCadena + valoresMuestra.obtenerVacioNulo(strComentario) + "\r\n";
                        
                        bw.write(strCadena);
                        strComentario = "";
                    }
                    
                    for(Muestra muestra : muestras_enviadas){
                        strCadena = "";
                                    
                        strCadena = strCadena + muestra.getConsecutivo() + strCaracter;
                        strCadena = strCadena + muestra.getFechaRecepcion() + strCaracter;
                        strCadena = strCadena + muestra.getFechaEstimadaEntrega() + strCaracter;
                        strCadena = strCadena + valoresMuestra.obtenerEstado(muestra.getEstado()) + strCaracter;
                        strCadena = strCadena + valoresMuestra.obtenerPersona(muestra.getCodigoCliente()) + strCaracter;
                        strCadena = strCadena + muestra.getAutor() + strCaracter;
                        strCadena = strCadena + muestra.getCantidadMuestras().toString() + strCaracter;
                        strCadena = strCadena + muestra.getUsuarioEntrega() + strCaracter;
                        strCadena = strCadena + valoresMuestra.obtenerTipoAnalisis(muestra.getTipoAnalisis()) + strCaracter;
                        strCadena = strCadena + valoresMuestra.obtenerPersona(muestra.getResponsable()) + strCaracter;
                        strCadena = strCadena + valoresMuestra.obtenerVacioNulo(muestra.getCostoServicio()) + strCaracter;
                        strCadena = strCadena + valoresMuestra.obtenerVacioNulo(muestra.getFechaEntregaReal()) + strCaracter;
                        strCadena = strCadena + "Enviada" + strCaracter;
                        
                        strComentario = muestra.getComentario();
                        strCadena = strCadena + valoresMuestra.obtenerVacioNulo(strComentario) + "\r\n";
                        
                        bw.write(strCadena);
                        strComentario = "";
                    }

                    bw.close();

                    out.println("<div class='TEXTOEXITO'>");
                    out.println("El archivo plano fue generado satisfactoriamente!.");
                    out.println("<br /><br />");
                    out.println("<input type='button' id='btnDescargar' name='btnDescargar' value='Descargar' class='BOTONFORM' onclick=\"descargarArchivo('" + strRutaArchivo + "'); \" />");
                    out.println("</div>");
                    
                }else{
                    out.println("<div class='TEXTOFALLO>");
                    out.println("No se tiene configurada la ruta para la creación del archivo plano. Por favor contacte al Administrador del Sistema!.");
                    out.println("</div>");
                    Log.registroTraza("No se pudo recuperar la ruta del archivo plano");
                }
            }else{
                Log.registroTraza("No se pudieron obtener los parámetros generales");
            }            
            
        } finally {
            out.close();
        }
    }
       
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
