/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

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
public class Ingreso extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
            
           String strUsuario = request.getParameter("txtUsuario");
           String strPwd = request.getParameter("txtPwd");
                     
           String[] strDatos = GestionSQL.getFila("select P.intCedula, p.strNombre, p.strUsuario, p.strRol from tbl_personas p where p.strUsuario = '" + strUsuario + "' and p.strPassword = '" + strPwd +"'");
           
           if (strDatos == null){               
               out.println("<html>");
               out.println("<head>");
               out.println("<link rel='SHORTCUT ICON' href='Images/favicon.ico' />");
               out.println("<META HTTP-EQUIV='Refresh' content='5;url=index.jsp'>");
               out.println("<link rel='stylesheet' type='text/css' href='Styles/StylesLogin.css'/>"); 
               out.println("<link rel='stylesheet' type='text/css' href='Styles/StylesComunes.css'/>");
               out.println("<title>Autenticación fallida</title>");
               out.println("</head>");
               out.println("<body>");
               out.println("<div align='center'>");
               out.println("<table cellspacing='0' cellpadding='0' width='1200px' class='TABLAHEAD'>");
               out.println("<tr>");
               out.println("<td class='CELDAHEAD' rowspan='2' style='width: 180px;'><img src='Images/log-grupo.gif' class='LOGOGRUPO'></td>");
               out.println("<td class='CELDAHEAD' rowspan='2'><H1>SISTEMA DE GESTIÓN DE MUESTRAS</H1><h3>Química de Recursos Energéticos y Medio Ambiente</h3></td>");
               out.println("<td class='CELDAHEAD' rowspan='2' style='width: 180px;'><img src='Images/log-udea.gif' class='LOGOUDEA'></td>");
               out.println("</tr><tr></tr>");
               out.println("</table>");
               out.println("</div>");               
               out.println("<div class='TEXTOFALLO'>");
               out.println("Los datos ingresados son incorrectos o no cuentas con autorización para ingresar. <br>");
               out.println("Si deseas intentar de nuevo, presiona <a href='index.jsp'>aquí</a>.");
               out.println("</div");
               out.println("<br><br><br><br><br><br><br><br><br><br><br>");
               out.println("<table cellspacing='0' cellpadding='0' class='TABLAFOOT'>");
               out.println("<tr>");
               out.println("<td class='TEXTOFOOT'>");
               out.println("Sede de Investigación Universitaria - Universidad de Antioquia<br>");
               out.println("&#169Copyright <b><a href='mailto:jorge.correaj@udea.edu.co'>Ingeniería de Software</a></b> -<b>SIU</b>-<br>");
               out.println("2016");
               out.println("</td>");
               out.println("</tr>");
               out.println("</table>");        
               out.println("</body>");
               out.println("</html>");
           }else{
               String strCedula = strDatos[0];
               String strNombre = strDatos[1];
               strUsuario = strDatos[2];
               String strRol = strDatos[3];
               
               HttpSession session = request.getSession(true);
               
               session.setAttribute("strCedula", strCedula);
               session.setAttribute("strNombre", strNombre);
               session.setAttribute("strUsuario", strUsuario);
               session.setAttribute("strRol", strRol);        
                           
               if ((strRol.equals("G")) || (strRol.equals("D"))){
                   response.sendRedirect("principal.jsp");
               }else{
                   response.sendRedirect("busqueda.jsp");
               }        
           }
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
