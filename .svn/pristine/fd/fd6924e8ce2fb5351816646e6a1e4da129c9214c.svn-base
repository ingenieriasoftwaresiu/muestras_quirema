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
 * @author Jorge.correa
 */
public class Registro extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        PrintWriter out = response.getWriter();

        try {            
           HttpSession session = request.getSession(true);
           String strForm = request.getParameter("txtForm");  
           String strAccion = request.getParameter("txtAccion");    
           String strCedulaUserSession = (String) session.getAttribute("strCedula");
               
           String strSQL = "";
           String strMensaje = "";
           String strResult = null;          
           
           if (strForm.equals("frmGeneral")){
               String strConsecutivo = request.getParameter("txtConsecutivo");
               String strRutaArchivoPlano = request.getParameter("txtRutaArchivoPlano");
               String strConsecutivoEnviadas = request.getParameter("txtConsecutivoEnviadas");
               String strNombreServidor = request.getParameter("txtNombreServidor");
               String strNumeroPuerto = request.getParameter("txtNumeroPuerto");
               String strUsuario = request.getParameter("txtUsuario");
               String strPassword = request.getParameter("txtPassword");
               String strAsunto = request.getParameter("txtAsunto");
               String strFirma = request.getParameter("txtFirma");
               
               strFirma = strFirma.replace("?", "");
              
               //Creación
               
               if (strAccion.equals("C")){                           
                    strSQL = "INSERT INTO tbl_generales (strCodigo,strNombreServidor,strNumeroPuerto,strUsuario,strPassword,strAsunto,strFirma,txtConsecutivoActual,txtRutaArchivoPlano,txtConsecutivoActualEnviadas) VALUES('" + strForm + "','" + strNombreServidor + "','" + strNumeroPuerto + "','" + strUsuario +  "','" + strPassword + "','" + strAsunto + ",'" + strFirma + "','" + strConsecutivo + "','" + strRutaArchivoPlano + "','" + strConsecutivoEnviadas + "');";                    
               }
               
               //Consulta
              
               if (strAccion.equals("V")){                   
                   strSQL = "update tbl_generales set strNombreServidor = '" + strNombreServidor + "', strNumeroPuerto = '" + strNumeroPuerto + "', strUsuario = '" + strUsuario + "', strPassword = '" + strPassword + "', strAsunto = '" + strAsunto + "', strFirma = '" + strFirma + "', txtConsecutivoActual = '" + strConsecutivo + "', txtRutaArchivoPlano = '" + strRutaArchivoPlano + "', txtConsecutivoActualEnviadas = '" + strConsecutivoEnviadas + "' where strCodigo = 'frmGeneral'";
               }                    
           }

           if (strForm.equals("frmRol")){

               String strCodigo = request.getParameter("txtCodigo");
               String strNombre = request.getParameter("txtNombre");
               
               //Creación
               
               if (strAccion.equals("C")){   
                    //Validar existencia
                    strResult = validarRegistro(strCodigo,"R","D");
                    
                    if (strResult != null){
                        out.println(strResult);
                    }else{                
                        strSQL = "INSERT INTO tbl_roles (strCodigo,strNombre) VALUES('" + strCodigo + "','" + strNombre + "');";
                    }
               }
               
               //Consulta
               
               if (strAccion.equals("V")){
                   String strCodigoM = request.getParameter("txtCodigoM");             
                   strSQL = "update tbl_roles set strNombre = '" + strNombre + "' where strCodigo = '" + strCodigoM +"'";
               }     
               
               //Eliminación
               
               if (strAccion.equals("E")){
                   String strCodigoM = request.getParameter("txtCodigoM"); 
                   
                   strResult = validarRegistro(strCodigoM,"R","E");
                   
                   if (strResult != null){
                       out.println(strResult);
                    }else{
                       strSQL = "delete from tbl_roles where strCodigo = '" + strCodigoM + "'"; 
                   }                   
               }
           }
           
           if (strForm.equals("frmEstado")){
               String strCodigo = request.getParameter("txtCodigo");
               String strNombre = request.getParameter("txtNombre");
               
               if (strAccion.equals("C")){   
                    //Validar existencia
                    
                    strResult = validarRegistro(strCodigo,"E","D");
                    
                    if (strResult != null){
                        out.println(strResult);      
                    }else{                
                        strSQL = "INSERT INTO tbl_estados (strCodigo,strNombre) VALUES('" + strCodigo + "','" + strNombre + "');";
                    }
               }
               
               //Consulta
               
               if (strAccion.equals("V")){               
                   String strCodigoM = request.getParameter("txtCodigoM");             
                   strSQL = "update tbl_estados set strNombre = '" + strNombre + "' where strCodigo = '" + strCodigoM +"'";
               }      
               
               //Eliminación
               
               if (strAccion.equals("E")){
                   String strCodigoM = request.getParameter("txtCodigoM"); 
                   
                   strResult = validarRegistro(strCodigoM,"E","E");
                   
                   if (strResult != null){
                        out.println(strResult);
                   }else{
                        strSQL = "delete from tbl_estados where strCodigo = '" + strCodigoM + "'";
                   }
               }
           }
           
           if (strForm.equals("frmTipoAnalisis")){
               String strCodigo = request.getParameter("txtCodigo");
               String strNombre = request.getParameter("txtNombre");
               
               if (strAccion.equals("C")){   
                    //Validar existencia
                    
                    strResult = validarRegistro(strCodigo,"TA","D");
                    
                    if (strResult != null){
                        out.println(strResult);      
                    }else{                
                        strSQL = "INSERT INTO tbl_tipos_analisis (strCodigo,strNombre) VALUES('" + strCodigo + "','" + strNombre + "');";
                    }
               }
               
               //Consulta
               
               if (strAccion.equals("V")){               
                   String strCodigoM = request.getParameter("txtCodigoM");             
                   strSQL = "update tbl_tipos_analisis set strNombre = '" + strNombre + "' where strCodigo = '" + strCodigoM +"'";
               }      
               
               //Eliminación
               
               if (strAccion.equals("E")){
                   String strCodigoM = request.getParameter("txtCodigoM"); 
                   
                   strResult = validarRegistro(strCodigoM,"TA","E");
                   
                   if (strResult != null){
                        out.println(strResult);
                   }else{
                        strSQL = "delete from tbl_tipos_analisis where strCodigo = '" + strCodigoM + "'";
                   }
               }
           }

           if (strForm.equals("frmPersona")){
                String strID = request.getParameter("txtId");
                String strNombre = request.getParameter("txtNombre");
                String strDireccion = request.getParameter("txtDireccion");
                String strTelefono = request.getParameter("txtTelefono");
                String strEmail = request.getParameter("txtEmail");
                String strRol = request.getParameter("txtRol");
                String strUsuario = request.getParameter("txtUsuario");
                String strPwd = request.getParameter("txtPassword");      
                                
                if (strAccion.equals("C")){   
                    //Validar existencia
                    
                    strResult = validarRegistro(strID,"P","D");
                    
                    if (strResult != null){
                        out.println(strResult);
                    }else{                
                        strSQL = "INSERT INTO tbl_personas (intCedula,strNombre,strDireccion,strTelefono,strEmail,strUsuario,strPassword,strRol) VALUES('" + strID + "','" + strNombre + "','" + strDireccion + "','" + strTelefono + "','" + strEmail + "','" + strUsuario + "','" + strPwd + "','" + strRol + "');";
                    }
               }
                
                //Consulta
               
               if (strAccion.equals("V")){               
                   String strCodigoM = request.getParameter("txtCodigoM");             
                   strSQL = "update tbl_personas set intCedula = '" + strID + "', strNombre = '" + strNombre + "', strDireccion = '" + strDireccion + "', strTelefono = '" + strTelefono + "', strEmail = '" + strEmail + "', strUsuario = '" + strUsuario + "', strPassword = '" + strPwd + "', strRol = '" + strRol + "' where intCedula = '" + strID + "'";
               }      
               
               //Eliminación
               
               if (strAccion.equals("E")){
                   String strCodigoM = request.getParameter("txtCodigoM"); 
                   
                   if (strCedulaUserSession.equals(strCodigoM)){
                       out.println("<html>");
                        out.println("<head>");
                        out.println("</head>");
                        out.println("<body>");
                        out.println("<div class='TEXTOFALLO'>");
                        out.println("No se puede eliminar el registro de la persona que actualmente se encuentra en sesión. Por favor seleccione otro registro de persona a eliminar o inicie sesión con un usuario diferente.");
                        out.println("</div>");
                        out.println("</body>");
                        out.println("</html>"); 
                       strSQL = "";
                   }else{
                        strResult = validarRegistro(strCodigoM,"P","E");
                   
                        if (strResult != null){
                            out.println(strResult);
                        }else{
                            strSQL = "delete from tbl_personas where intCedula = '" + strCodigoM + "'"; 
                        }
                   }
               }                          
           }

           if (strForm.equals("frmMuestra")){    
                String strAutor = request.getParameter("txtAutor");
                String strFechaRecep = request.getParameter("txtFechaRecep");
                String strConsecutivo = request.getParameter("txtConsecutivo");
                String strCedula = request.getParameter("txtCedula");
                String strEstado = request.getParameter("txtEstado");
                String strFechaEntrega = request.getParameter("txtFechaEntrega");
                String strDescripcion = request.getParameter("txtDescripcion");
                String strTipoMuestra = request.getParameter("txtTipoMuestra");
                    
               if (strAccion.equals("C")){   
                    //Validar existencia del consecutivo

                    strResult = validarRegistro(strConsecutivo,"M","D");
                    
                    if (strResult != null){
                        out.println(strResult);
                    }else{                
                        strSQL = "INSERT INTO tbl_muestras (strConsecutivo,strDescripcion,dtFechaRecepcion,dtFechaEntrega,strEstado,intPersona,strAutor) VALUES('" + strConsecutivo + "','" + strDescripcion + "','" + strFechaRecep + "','" + strFechaEntrega + "','" + strEstado + "','" + strCedula + "','" + strAutor + "');";
                        enviarNotificacion(strCedula,strConsecutivo,strEstado);
                    }
               }
               
               //Consulta
               
               if (strAccion.equals("V")){ 
                   String strCodigoM = request.getParameter("txtCodigoM");             
                   strSQL = "update tbl_muestras set strConsecutivo = '"+ strConsecutivo + "',strDescripcion = '"+ strDescripcion +"',dtFechaEntrega = '"+ strFechaEntrega +"',strEstado = '"+ strEstado +"',intPersona = '"+ strCedula +"' where strCodigo = '" + strCodigoM +"'";
                   enviarNotificacion(strCedula,strConsecutivo,strEstado);
               }              
               
               //Eliminación
               
               if (strAccion.equals("E")){      
                    String strCodigoM = request.getParameter("txtCodigoM");                     
                                        
                    if (strTipoMuestra.equals("R")){
                        strSQL = "delete from tbl_muestras where strConsecutivo = '" + strCodigoM + "'";            
                    }else{
                        strSQL = "delete from tbl_muestras_enviadas where strConsecutivo = '" + strCodigoM + "'";            
                    }
                                                           
               }
           }      

           if (strSQL != ""){
               strMensaje = GestionSQL.ejecuta(strSQL);

               if (strMensaje == null){
                   //Inserción exitosa                     
                   out.println("<html>");
                   out.println("<head>");
                   out.println("<script language='JavaScript' type='text/javascript' src='Scripts/JSMuestras.js'></script>");
                   out.println("</head>");
                   out.println("<body>");
                   out.println("<div class='TEXTOEXITO'>");
                   if ((strAccion.equals("C")) || (strAccion.equals("V"))){                                            
                       out.println("El registro fue ingresado correctamente!.");
                   }else{
                       out.println("El registro fue eliminado correctamente!.");
                   }
                   out.println("</div>");                   
                   out.println("</body>");
                   out.println("</html>");                   
               }else{
                   //Inserción fallida                   
                   out.println("<html>");
                   out.println("<head>");
                   out.println("</head>");
                   out.println("<body>");
                   out.println("<div class='TEXTOFALLO'>");
                   out.println("Se produjo el siguiente error el insertar el registro: " + strMensaje);
                   out.println("</div>");                  
                   out.println("</body>");
                   out.println("</html>");
               }
           }
        } finally {
            out.close();
        }        
    }
    
    private void enviarNotificacion(String intCedula, String strConsecutivo, String strCodEstado){
        String strMensaje = "";
        String strDestino = "";
        String strEstado = "";
        String strSQL = "";
        String[] strEstadoActual = null;
        
        strSQL = "SELECT m.strEstado FROM tbl_muestras m where m.strConsecutivo = '" + strConsecutivo +  "'";       
        strEstadoActual = GestionSQL.getFila(strSQL);        
        
        if (strEstadoActual != null){                      
            if (!strCodEstado.equals(strEstadoActual[0])){
                EnviarEmail mail = new EnviarEmail();
        
                String[] strEstados = null;        
                String[] strPersonas = null;
                String[] strDatosGenerales = null;

                strEstados = GestionSQL.getFila("select e.strNombre from tbl_estados e where e.strCodigo = '" + strCodEstado + "'");

                if (strEstados != null){
                    strEstado = strEstados[0];
                }else{
                    strEstado = strCodEstado;
                }

                strPersonas = GestionSQL.getFila("select p.strEmail from tbl_personas p where p.intCedula = '" + intCedula + "'");

                if (strPersonas != null){
                    strDestino = strPersonas[0];
                }else{
                    strDestino = "";
                }
                
                strMensaje = strMensaje + "Cordial saludo.\n\n";
                strMensaje = strMensaje + "La muestra con consecutivo " + strConsecutivo + " se encuentra en el estado " + strEstado + ".\n\n";
                strMensaje = strMensaje + "Para mayor detalle, ingrese con el NIT (Sin puntos ni guión) para empresas o Cédula (Sin puntos) para persona natual en usuario y contraseña desde la dirección http://siuweb.udea.edu.co:8080/muestras_quirema/.\n\n";
                strMensaje = strMensaje + "Cordialmente,\n\n";
                
                strDatosGenerales = GestionSQL.getFila("SELECT g.strFirma FROM tbl_generales g where g.strCodigo = 'frmGeneral'");
                
                if (strDatosGenerales != null){
                    String[] arrCadena = null;
                    
                    arrCadena = strDatosGenerales[0].split(";");
                    
                    for(int i=0;i<arrCadena.length;i++){
                        if (i==arrCadena.length){
                            strMensaje = strMensaje + arrCadena[i];
                        }else{
                            strMensaje = strMensaje + arrCadena[i] + "\n";
                        }                        
                    }                    
                }
                mail.sendMail(strDestino, strMensaje);
            }             
        }
        
       
       
    }
    
    private String validarRegistro(String strClave,String strAccion, String strEvento){
        
        String[] strResult = null;
        String strSQL = null;
        String strMensaje = null;
        
        // Eventos
        // D: Duplicidad de Registros.
        // E: Eliminación de Registro.
                
        if (strAccion.equals("R")){
            if (strEvento.equals("D")){
                strSQL = "select r.strCodigo, r.strNombre from tbl_roles r where r.strCodigo = '" + strClave + "'";
                strMensaje = "<html>\n";
                strMensaje = strMensaje + "<head>\n";
                strMensaje = strMensaje + "<body>\n";
                strMensaje = strMensaje + "<div class='TEXTOFALLO'>\n";
                strMensaje = strMensaje + "Ya existe un registro de rol con el código " + strClave + ". Por favor ingrese un código diferente.\n";
                strMensaje = strMensaje + "</div>\n";
                strMensaje = strMensaje + "</body>\n";
                strMensaje = strMensaje + "</html>";  
            }
            
            if (strEvento.equals("E")){
                strSQL = "select p.intCedula from tbl_personas p where p.strRol = '" + strClave + "'";
                strMensaje = "<html>\n";
                strMensaje = strMensaje + "<head>\n";
                strMensaje = strMensaje + "<body>\n";
                strMensaje = strMensaje + "<div class='TEXTOFALLO'>\n";
                strMensaje = strMensaje + "No se puede eliminar el registro de rol seleccionado debido a que se encuentra asociado con personas ya creadas.\n";
                strMensaje = strMensaje + "</div>\n";
                strMensaje = strMensaje + "</body>\n";
                strMensaje = strMensaje + "</html>";
            }            
        }
        
        if (strAccion.equals("E")){
           if (strEvento.equals("D")){        
                strSQL = "select e.strCodigo, e.strNombre from tbl_estados e where e.strCodigo = '" + strClave + "'";
                strMensaje = "<html>\n";
                strMensaje = strMensaje + "<head>\n";
                strMensaje = strMensaje + "</head>\n";
                strMensaje = strMensaje + "<body>\n";
                strMensaje = strMensaje + "<div class='TEXTOFALLO'>\n";
                strMensaje = strMensaje + "Ya existe un registro de estado con el código " + strClave + ". Por favor ingrese un código diferente.\n";
                strMensaje = strMensaje + "</div>\n";
                strMensaje = strMensaje + "</body>\n";
                strMensaje = strMensaje + "</html>";
           }
           
           if (strEvento.equals("E")){
                strSQL = "select m.strCodigo from tbl_muestras m where m.strEstado = '" + strClave + "'";
                strMensaje = "<html>\n";
                strMensaje = strMensaje + "<head>\n";
                strMensaje = strMensaje + "<body>\n";
                strMensaje = strMensaje + "<div class='TEXTOFALLO'>\n";
                strMensaje = strMensaje + "No se puede eliminar el registro de estado seleccionado debido a que se encuentra asociado con muestras ya creadas.\n";
                strMensaje = strMensaje + "</div>\n";
                strMensaje = strMensaje + "</body>\n";
                strMensaje = strMensaje + "</html>";
            }
        }
        
        if (strAccion.equals("TA")){
           if (strEvento.equals("D")){        
                strSQL = "select e.strCodigo, e.strNombre from tbl_tipos_analisis e where e.strCodigo = '" + strClave + "'";
                strMensaje = "<html>\n";
                strMensaje = strMensaje + "<head>\n";
                strMensaje = strMensaje + "</head>\n";
                strMensaje = strMensaje + "<body>\n";
                strMensaje = strMensaje + "<div class='TEXTOFALLO'>\n";
                strMensaje = strMensaje + "Ya existe un registro de tipo de análisis con el código " + strClave + ". Por favor ingrese un código diferente.\n";
                strMensaje = strMensaje + "</div>\n";
                strMensaje = strMensaje + "</body>\n";
                strMensaje = strMensaje + "</html>";
           }
           
           if (strEvento.equals("E")){
                strSQL = "select m.strCodigo from tbl_muestras m where m.strTipoAnalisis = '" + strClave + "'";
                strMensaje = "<html>\n";
                strMensaje = strMensaje + "<head>\n";
                strMensaje = strMensaje + "<body>\n";
                strMensaje = strMensaje + "<div class='TEXTOFALLO'>\n";
                strMensaje = strMensaje + "No se puede eliminar el registro de tipo de análisis seleccionado debido a que se encuentra asociado con muestras ya creadas.\n";
                strMensaje = strMensaje + "</div>\n";
                strMensaje = strMensaje + "</body>\n";
                strMensaje = strMensaje + "</html>";
            }
        }
        
        if (strAccion.equals("P")){
            if (strEvento.equals("D")){
                strSQL = "select p.intCedula from tbl_personas p where p.intCedula = '" + strClave + "'";
                strMensaje = "<html>\n";
                strMensaje = strMensaje + "<head>\n";
                strMensaje = strMensaje + "</head>\n";
                strMensaje = strMensaje + "<body>\n";
                strMensaje = strMensaje + "<div class='TEXTOFALLO'>\n";
                strMensaje = strMensaje + "Ya existe un registro de persona con la identificación " + strClave + ". Por favor ingrese una identificación diferente.\n";
                strMensaje = strMensaje + "</div>\n";
                strMensaje = strMensaje + "</body>\n";
                strMensaje = strMensaje + "</html>";
            }
            
            if (strEvento.equals("E")){
                strSQL = "select m.strCodigo from tbl_muestras m where m.intPersona = '" + strClave + "'";
                strMensaje = "<html>\n";
                strMensaje = strMensaje + "<head>\n";
                strMensaje = strMensaje + "<body>\n";
                strMensaje = strMensaje + "<div class='TEXTOFALLO'>\n";
                strMensaje = strMensaje + "No se puede eliminar el registro de persona seleccionado debido a que se encuentra asociado con muestras ya creadas.\n";
                strMensaje = strMensaje + "</div>\n";
                strMensaje = strMensaje + "</body>\n";
                strMensaje = strMensaje + "</html>";
            }
        }
        
        if (strAccion.equals("M")){
            if (strEvento.equals("D")){
                strSQL = "select m.strConsecutivo from tbl_muestras m where m.strConsecutivo = '" + strClave + "'";
                strMensaje = "<html>\n";
                strMensaje = strMensaje + "<head>\n";
                strMensaje = strMensaje + "</head>\n";
                strMensaje = strMensaje + "<body>\n";
                strMensaje = strMensaje + "<div class='TEXTOFALLO'>\n";
                strMensaje = strMensaje + "Ya existe un registro de muestra con el consecutivo " + strClave + ". Por favor ingrese un consecutivo diferente.\n";
                strMensaje = strMensaje + "</div>\n";
                strMensaje = strMensaje + "</body>\n";
                strMensaje = strMensaje + "</html>"; 
            }
        }
        
        if (strSQL != null){
            strResult = GestionSQL.getFila(strSQL);
            
            if (strResult != null){
                return strMensaje;
            }else{
                 return null;
            }
        }else{
            return null;
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
