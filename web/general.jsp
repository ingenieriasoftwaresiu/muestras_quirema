<%-- 
    Document   : rol
    Created on : 19/04/2012, 02:13:44 PM
    Author     : jorge.correa
--%>

<%@page import="java.util.Vector"%>
<%@page import="Negocio.GestionSQL"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<% 
    String strAccion = (String) request.getParameter("txtAccion");    
    String strCodigo = (String) request.getParameter("txtCodigo");
    String strNombre = (String) session.getAttribute("strNombre");
    String strFirma = "";
    String strCadena = null;
    String[] strDatosGenerales = null;
    String[] arrCadena = null;
    
     if (strAccion == null){
                response.sendRedirect("cerrar.jsp");
     }else{
        if (strAccion.equals("V")){
            strDatosGenerales = GestionSQL.getFila("SELECT g.strNombreServidor, g.strNumeroPuerto, g.strUsuario, g.strPassword, g.strAsunto, g.strFirma, g.txtConsecutivoActual, g.txtRutaArchivoPlano, txtConsecutivoActualEnviadas FROM tbl_generales g where g.strCodigo = 'frmGeneral'");
            
            strCadena = strDatosGenerales[5];            
            arrCadena = strCadena.split(";");                       
        }
     }    
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">           
        <link rel="SHORTCUT ICON" href="Images/favicon.ico" />
        <link rel="stylesheet" type="text/css" href="Styles/StylesComunes.css" />
        <link rel="stylesheet" type="text/css" href="Styles/StylesGenerales.css" />
        <script language="JavaScript" type="text/javascript" src="Scripts/JSAjax.js"></script>
        <script language="JavaScript" type="text/javascript" src="Scripts/JSComunes.js"></script>
        <script language="JavaScript" type="text/javascript" src="Scripts/JSGenerales.js"></script>
        <title>Administración: Crear Parámetros Generales</title>
    </head>
    <body onload="cargaBody()">
        <div align="center">
            <header>
                <jsp:include page="header.jsp" />
            </header>
            <br>
            <% if (strAccion.equals("C")){%>
                <form method="POST" action="Registro" id="frmGeneral" name="frmGeneral">
                    <input type="hidden" name="txtForm" id="txtForm" value="frmGeneral">
                    <input type="hidden" name="txtAccion" id="txtAccion" value="C">
                    <table cellspacing="0" cellpadding="0" width="900px" border="0">
                        <tr>
                            <td class="TITULOFORM" colspan="4">NUEVO REGISTRO DE PARÁMETROS GENERALES</td>
                        </tr>
                        <tr><td colspan="4" style="height: 10px;"></td></tr>
                        <tr>
                            <td class="LABELFORM" style="width: 160px;vertical-align: middle;">* Consecutivo recibidas::</td>
                            <td style="padding-left: 5px;width: 250px;">
                                <input type="text" name="txtConsecutivo" id="txtConsecutivo" class="CAMPOFORM" onclick="ocultarDIV()">
                            </td>
                            <td class="LABELFORM" style="width: 200px;">* Ruta para archivo plano:</td>
                            <td style="padding-left: 5px;">
                                <input type="text" name="txtRutaArchivoPlano" id="txtRutaArchivoPlano" class="CAMPOFORM" style="width: 200px;" onclick="ocultarDIV()">
                            </td>
                        </tr>                        
                        <tr><td colspan="4" style="height: 10px;"></td></tr>
                        <tr>
                            <td class="LABELFORM" style="width: 160px;vertical-align: middle;">* Consecutivo enviadas:</td>
                            <td style="padding-left: 5px;width: 250px;">
                                <input type="text" name="txtConsecutivoEnviadas" id="txtConsecutivoEnviadas" class="CAMPOFORM" onclick="ocultarDIV()">
                            </td>
                            <td class="LABELFORM" style="width: 200px;"></td>
                            <td style="padding-left: 5px;">                                
                            </td>
                        </tr>
                        <tr><td colspan="4" style="height: 10px;"></td></tr>
                        <tr>
                            <td class="SUBTITULOMENU1" colspan="4">Datos para el envío de E-Mails</td>
                        </tr>
                        <tr>
                            <td colspan="4">                                                     
                                <table cellspacing="0" cellpadding="5" width="100%" border="0" class="TABLAHEAD">
                                    <tr><td colspan="4" style="height: 10px;"></td></tr>
                                    <tr>
                                        <td class="LABELFORM">* Nombre del servidor:</td>
                                        <td class="CELDACAMPOFORM">
                                            <input type="text" name="txtNombreServidor" id="txtNombreServidor" class="CAMPOFORM" onclick="ocultarDIV()">
                                        </td>
                                        <td class="LABELFORM">Número del puerto:</td>
                                        <td class="CELDACAMPOFORM">
                                            <input type="text" name="txtNumeroPuerto" id="txtNumeroPuerto" class="CAMPOFORM" onclick="ocultarDIV()">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="LABELFORM">* Usuario:</td>
                                        <td class="CELDACAMPOFORM">
                                            <input type="text" name="txtUsuario" id="txtUsuario" class="CAMPOFORM" onclick="ocultarDIV()">
                                        </td>
                                        <td class="LABELFORM">* Contraseña:</td>
                                        <td class="CELDACAMPOFORM">
                                            <input type="password" name="txtPassword" id="txtPassword" class="CAMPOFORM" onclick="ocultarDIV()">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="LABELFORM">* Asunto del mensaje:</td>
                                        <td colspan ="3" class="CELDACAMPOFORM">
                                            <input type="text" name="txtAsunto" id="txtAsunto" class="CAMPOFORM" onclick="ocultarDIV()" style="width: 500px;">
                                        </td>                      
                                    </tr>
                                    <tr>
                                        <td class="LABELFORM">* Firma del mensaje:</td>
                                        <td colspan ="3" class="CELDACAMPOFORM">
                                            <textarea rows="8" cols="85" name="txtFirma" id="txtFirma" class="TEXTAREA" onclick="ocultarDIV()">                                                
                                            </textarea>
                                        </td>  
                                    </tr>
                                    <tr><td colspan="4" style="height: 10px;"></td></tr>                                            
                                    <tr><td colspan="4" class="CELDABOTONFORM"><input type="button" value="Guardar" class="BOTONFORM" onclick="validarFormGeneral()">&nbsp;&nbsp;<input type="button" value="Limpiar" class="BOTONFORM" onclick="limpiarFormGeneral()"> &nbsp;&nbsp;<input type="button" value="Salir" class="BOTONFORM" onclick="javascript:window.close();"></td></tr>
                                    <tr><td colspan="4" class="MSGAVISOOBLG">Los campos marcados con (*) son obligatorios.</td></tr>
                                </table>                   
                            </td>
                        </tr>
                    </table>
                </form>
            <%}else{%>
                <form method="POST" action="Registro" id="frmGeneral" name="frmGeneral">
                    <input type="hidden" name="txtForm" id="txtForm" value="frmGeneral">
                    <input type="hidden" name="txtAccion" id="txtAccion" value="V">   
                    <table cellspacing="0" cellpadding="0" width="900px" border="0" class="TABLAHEAD">
                        <tr>
                            <td class="TITULOFORM" colspan="4">REGISTRO DE PARÁMETROS GENERALES</td>
                        </tr>
                        <tr><td colspan="4" style="height: 10px;"></td></tr>
                        <tr>
                            <td class="LABELFORM" style="width: 160px;vertical-align: middle;">* Consecutivo recibidas:</td>
                            <td style="padding-left: 5px;width: 250px;">
                                <input type="text" name="txtConsecutivo" value="<%=strDatosGenerales[6]%>" id="txtConsecutivo" class="CAMPOFORM" onclick="ocultarDIV()">
                            </td>
                            <td class="LABELFORM" style="width: 200px;">* Ruta para archivo plano:</td>
                            <td style="padding-left: 5px;">
                                <input type="text" name="txtRutaArchivoPlano" value="<%=strDatosGenerales[7]%>" id="txtRutaArchivoPlano" class="CAMPOFORM" style="width: 200px;" onclick="ocultarDIV()">
                            </td>
                        </tr>
                        <tr><td colspan="4" style="height: 10px;"></td></tr>
                        <tr>
                            <td class="LABELFORM" style="width: 160px;vertical-align: middle;">* Consecutivo enviadas:</td>
                            <td style="padding-left: 5px;width: 250px;">
                                <input type="text" name="txtConsecutivoEnviadas" value="<%=strDatosGenerales[8]%>" id="txtConsecutivoEnviadas" class="CAMPOFORM" onclick="ocultarDIV()">
                            </td>
                            <td class="LABELFORM" style="width: 200px;"></td>
                            <td style="padding-left: 5px;">                                
                            </td>
                        </tr>
                        <tr><td colspan="4" style="height: 10px;"></td></tr>
                        <tr>
                            <td class="SUBTITULOMENU1" colspan="4">Datos para el envío de E-Mails</td>
                        </tr>
                        <tr>
                            <td colspan="4">                          
                                    <table cellspacing="0" cellpadding="5" width="100%" border="0">
                                        <tr><td colspan="4" style="height: 10px;"></td></tr>
                                        <tr>
                                            <td class="LABELFORM">* Nombre del servidor:</td>
                                            <td class="CELDACAMPOFORM">
                                                <input type="text" name="txtNombreServidor" value="<%=strDatosGenerales[0]%>" id="txtNombreServidor" class="CAMPOFORM" onclick="ocultarDIV()">
                                            </td>
                                            <td class="LABELFORM">Número del puerto:</td>
                                            <td class="CELDACAMPOFORM">
                                                <input type="text" name="txtNumeroPuerto" value="<%=strDatosGenerales[1]%>" id="txtNumeroPuerto" class="CAMPOFORM" onclick="ocultarDIV()">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="LABELFORM">* Usuario:</td>
                                            <td class="CELDACAMPOFORM">
                                                <input type="text" name="txtUsuario" value="<%=strDatosGenerales[2]%>" id="txtUsuario" class="CAMPOFORM" onclick="ocultarDIV()">
                                            </td>
                                            <td class="LABELFORM">* Contraseña:</td>
                                            <td class="CELDACAMPOFORM">
                                                <input type="password" name="txtPassword" value="<%=strDatosGenerales[3]%>" id="txtPassword" class="CAMPOFORM" onclick="ocultarDIV()">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="LABELFORM">* Asunto del mensaje:</td>
                                            <td colspan ="3" class="CELDACAMPOFORM">
                                                <input type="text" name="txtAsunto" value="<%=strDatosGenerales[4]%>" id="txtAsunto" class="CAMPOFORM" onclick="ocultarDIV()" style="width: 550px;">
                                            </td>                      
                                        </tr>
                                        <tr>
                                            <td class="LABELFORM">* Firma del mensaje:</td>
                                            <td colspan ="3" class="CELDACAMPOFORM">
                                                <textarea rows="8" cols="85" name="txtFirma" id="txtFirma" class="TEXTAREA" onclick="ocultarDIV()">                                                
                                                </textarea></td>                                         
                                             <script language="javascript" type="text/javascript">  
                                                    element = document.getElementById("txtFirma");
                                                    var strCadena = "";
                                                    <%for (int i=0;i<arrCadena.length;i++){%>                                                    
                                                        strCadena += "<%=arrCadena[i]%>" + "\n";
                                                    <%}%>              
                                                    element.value = strCadena;
                                            </script>
                                        </tr>
                                        <tr>
                                            <td></td>
                                            <td colspan ="3" class="MSGAVISOTEXTAREA">NOTA: Ingrese la firma del mensaje separando cada nueva línea con un Enter.</td>       
                                        </tr>
                                        <tr><td colspan="4" style="height: 10px;"></td></tr>                                   
                                        <% if (strAccion.equals("C")){%>
                                            <tr><td colspan="4" class="CELDABOTONFORM"><input type="button" value="Guardar" class="BOTONFORM" onclick="validarFormGeneral()">&nbsp;&nbsp;<input type="button" value="Limpiar" class="BOTONFORM" onclick="limpiarFormGeneral()"> &nbsp;&nbsp;<input type="button" value="Salir" class="BOTONFORM" onclick="javascript:window.close();"></td></tr>
                                        <%}else{%>
                                            <tr><td colspan="4" class="CELDABOTONFORM"><input type="button" value="Guardar" class="BOTONFORM" onclick="validarFormGeneral()">&nbsp;&nbsp;<input type="button" value="Salir" class="BOTONFORM" onclick="javascript:window.close();"></td></tr>
                                        <%}%>    
                                            <tr><td colspan="4" class="MSGAVISOOBLG">Los campos marcados con (*) son obligatorios.</td></tr>
                                    </table>                            
                            </td>
                        </tr>
                    </table>
                </form>
            <%}%>     
            <br />
            <div id="dMensaje">                
            </div>
        </div>
        <div style="padding-top: 20px;"></div>			
        <footer>
            <jsp:include page="footer.jsp" />     
        </footer>	
    </body>
</html>
