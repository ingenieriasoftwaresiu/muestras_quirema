/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio;

import Negocio.dao.MuestraDAO;
import Negocio.dao.impl.MuestraDAOImpl;
import Negocio.dto.Muestra;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jorge.correa
 */
public class RegistroMuestra extends HttpServlet {

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
           HttpSession session = request.getSession(true);
           String strConsecutivo=null, strAutor=null, strIdCliente=null, strUsuarioEntrega=null, strTipoAnalisis=null, strResponsable=null, strEstado=null, strComentario=null, strCosto=null, strMensaje=null;
           String strFechaRecepcion=null, strFechaEstimadaEntrega=null, strFechaEntregaReal=null, strAccion=null, strTipoMuestra=null;
           Integer intNumMuestras=null;
           String[] strParametros=null;
           Integer intConsecutivo=0;
           Muestra muestra =null;
           MuestraDAO muestraDAO = new MuestraDAOImpl();
           String strSQL = null;
           Boolean inserto = null;
           
           strAccion = request.getParameter("txtAccion");
           strAutor = request.getParameter("txtAutor");
           strIdCliente = request.getParameter("txtCedula");
           strUsuarioEntrega = request.getParameter("txtUsuarioEntrega");
           strTipoAnalisis = request.getParameter("txtTipoAnalisis");
           strResponsable = request.getParameter("txtRespAnalisis");
           strEstado = request.getParameter("txtEstado");
           strComentario = request.getParameter("txtDescripcion");
           strCosto = request.getParameter("txtCostoServicio");
           intNumMuestras = Integer.parseInt(request.getParameter("txtCantidadMuestras"));                      
           strFechaRecepcion = request.getParameter("txtFechaRecep");           
           strFechaEstimadaEntrega = request.getParameter("txtFechaEntrega");           
           strTipoMuestra = request.getParameter("txtTipoMuestra");           
                        
           if (request.getParameter("txtFechaEntregaR") != null){
                strFechaEntregaReal = request.getParameter("txtFechaEntregaR");
           }else{       
               strFechaEntregaReal = "";
           }
                            
           strComentario= new String(strComentario.getBytes("iso-8859-1"),"UTF-8");   
           strUsuarioEntrega= new String(strUsuarioEntrega.getBytes("iso-8859-1"),"UTF-8");   
           
          if (strTipoMuestra.equals("R")){           
            if (strAccion.equals("C")){
                 strParametros = GestionSQL.getFila("SELECT g.txtConsecutivoActual FROM tbl_generales g where g.strCodigo = 'frmGeneral'");

                  if (strParametros != null){
                      intConsecutivo = Integer.parseInt(strParametros[0]);
                      intConsecutivo++;
                      strConsecutivo = intConsecutivo.toString();
                  }else{
                      Log.registroTraza("No se pudo recuperar el consecutivo de las muestras recibidas desde los parámetros generales!.");
                   }      
             }else{
                 strConsecutivo = request.getParameter("txtConsecutivo");
             }
          }else{
               if (strAccion.equals("C")){
                 strParametros = GestionSQL.getFila("SELECT g.txtConsecutivoActualEnviadas FROM tbl_generales g where g.strCodigo = 'frmGeneral'");

                  if (strParametros != null){
                      intConsecutivo = Integer.parseInt(strParametros[0]);
                      intConsecutivo++;
                      strConsecutivo = intConsecutivo.toString();
                  }else{
                      Log.registroTraza("No se pudo recuperar el consecutivo de las muestras enviadas desde los parámetros generales!.");
                   }      
             }else{
                 strConsecutivo = request.getParameter("txtConsecutivo");
             }
          }
                                                   
        muestra = new Muestra();
        muestra.setConsecutivo(strConsecutivo);
        muestra.setComentario(strComentario);
        muestra.setFechaRecepcion(strFechaRecepcion);
        muestra.setFechaEstimadaEntrega(strFechaEstimadaEntrega);
        muestra.setEstado(strEstado);
        muestra.setCodigoCliente(strIdCliente);
        muestra.setAutor(strAutor);
        muestra.setCantidadMuestras(intNumMuestras);
        muestra.setUsuarioEntrega(strUsuarioEntrega);
        muestra.setTipoAnalisis(strTipoAnalisis);
        muestra.setResponsable(strResponsable);
        muestra.setCostoServicio(strCosto);
        muestra.setFechaEntregaReal(strFechaEntregaReal);
        
        if (strTipoMuestra.equals("R")){
            if (strAccion.equals("C")){

                inserto = muestraDAO.insertar(muestra, strTipoMuestra);

                if (inserto){

                    strSQL = "UPDATE tbl_generales g set g.txtConsecutivoActual = '" + strConsecutivo + "' where g.strCodigo = 'frmGeneral'";

                    if (GestionSQL.ejecuta(strSQL) == null){
                        strMensaje = "La muestra fue almacenada con el consecutivo " + strConsecutivo + ".";
                        session.setAttribute("mensaje", strMensaje);

                        request.getRequestDispatcher("notificacion.jsp").forward(request, response);
                    }else{
                        Log.registroTraza("No actualizó correctamente el consecutivo en los parámetros generales");
                    }                    
                }else{
                    Log.registroTraza("No insertó correctamente la muestra con consecutivo " + strConsecutivo);
                }    
            }else{

                inserto = muestraDAO.actualizar(muestra, strTipoMuestra);

                if (inserto){               
                    strMensaje = "La muestra fue actualizada correctamente!.";
                    session.setAttribute("mensaje", strMensaje);
                    request.getRequestDispatcher("notificacion.jsp").forward(request, response);                       
                }else{
                    Log.registroTraza("No actualizó correctamente la muestra con consecutivo " + strConsecutivo);
                }
            }       
        }else{
            if (strAccion.equals("C")){

                inserto = muestraDAO.insertar(muestra, strTipoMuestra);

                if (inserto){

                    strSQL = "UPDATE tbl_generales g set g.txtConsecutivoActualEnviadas = '" + strConsecutivo + "' where g.strCodigo = 'frmGeneral'";

                    if (GestionSQL.ejecuta(strSQL) == null){
                        strMensaje = "La muestra fue almacenada con el consecutivo " + strConsecutivo + ".";
                        session.setAttribute("mensaje", strMensaje);

                        request.getRequestDispatcher("notificacion.jsp").forward(request, response);
                    }else{
                        Log.registroTraza("No actualizó correctamente el consecutivo en los parámetros generales");
                    }                    
                }else{
                    Log.registroTraza("No insertó correctamente la muestra con consecutivo " + strConsecutivo);
                }    
            }else{

                inserto = muestraDAO.actualizar(muestra, strTipoMuestra);

                if (inserto){               
                    strMensaje = "La muestra fue actualizada correctamente!.";
                    session.setAttribute("mensaje", strMensaje);
                    request.getRequestDispatcher("notificacion.jsp").forward(request, response);                       
                }else{
                    Log.registroTraza("No actualizó correctamente la muestra con consecutivo " + strConsecutivo);
                }
            } 
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
