<%-- 
    Document   : rol
    Created on : 19/04/2012, 02:13:44 PM
    Author     : jorge.correa
--%>

<%@page import="Negocio.GestionSQL"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
    String strAccion = (String) request.getParameter("txtAccion");    
    String strCodigo = (String) request.getParameter("txtCodigo");
    String strNombre = (String) session.getAttribute("strNombre");
    String[] strDatosMuestra = null;
    
     if ((strNombre == null) || (strAccion == null)) {
        response.sendRedirect("cerrar.jsp");
     }else{
         if (strAccion.equals("V")){
            strDatosMuestra = GestionSQL.getFila("select r.strCodigo, r.strNombre from tbl_roles r where r.strCodigo = '" + strCodigo +"' ORDER BY r.strNombre");
        }
     }           
%>
<html>
    <head>        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="SHORTCUT ICON" href="Images/favicon.ico" />
        <link rel="stylesheet" type="text/css" href="Styles/StylesComunes.css" />
        <link rel="stylesheet" type="text/css" href="Styles/StylesRoles.css" />
        <script language="JavaScript" type="text/javascript" src="Scripts/JSAjax.js"></script>
        <script language="JavaScript" type="text/javascript" src="Scripts/JSComunes.js"></script>
        <script language="JavaScript" type="text/javascript" src="Scripts/JSRoles.js"></script>
        <title>Administración: Crear nuevo Rol</title>
    </head>
    <body onload="cargaBody()">
        <div align="center">
            <header>
                <jsp:include page="header.jsp" />
            </header>
            <br><br><br>
            <% if (strAccion.equals("C")){%>
                <table cellspacing="0" cellpadding="0" width="800px" border="0">
                    <tr>
                        <td class="TITULOFORM">NUEVO REGISTRO DE ROL</td>
                    </tr>                
                    <tr>
                        <td>
                            <form method="POST" action="Registro" id="frmRol" name="frmRol">
                                <input type="hidden" name="txtForm" id="txtForm" value="frmRol">
                                <input type="hidden" name="txtAccion" id="txtAccion" value="C">
                                <input type="hidden" name="txtCodigoM" id="txtCodigoM" value=" ">
                                <table cellspacing="0" cellpadding="5" width="800px" border="0" class="TABLAHEAD">
                                    <tr><td style="height: 10px;"></td></tr>
                                    <tr>
                                        <td class="LABELFORM">* Código:</td>
                                        <td class="CELDACAMPOFORM"><input type="text" name="txtCodigo" id="txtCodigo" class="CAMPOFORM" onclick="ocultarDIV()"></td>
                                        <td class="LABELFORM">* Nombre:</td>
                                        <td class="CELDACAMPOFORM"><input type="text" name="txtNombre" id="txtNombre" class="CAMPOFORM" onclick="ocultarDIV()"></td>
                                        <tr><td colspan="4" style="height: 10px;"></td></tr>
                                        <tr><td colspan="4" class="CELDABOTONFORM"><input type="button" value="Guardar" class="BOTONFORM" onclick="validarFormRol()">&nbsp;&nbsp;<input type="button" value="Limpiar" class="BOTONFORM" onclick="limpiarFormRol()"> &nbsp;&nbsp;<input type="button" value="Salir" class="BOTONFORM" onclick="javascript:window.close();"></td></tr>
                                        <tr><td colspan="4" class="MSGAVISOOBLG">Los campos marcados con (*) son obligatorios.</td></tr>
                                    </tr>
                                </table>
                            </form>
                        </td>
                    </tr>
                </table>
            <%}else{%>
                <table cellspacing="0" cellpadding="0" width="800px" border="0">
                    <tr>
                        <td class="TITULOFORM">REGISTRO DE ROL</td>
                    </tr>                
                    <tr>
                        <td>
                            <form method="POST" action="Registro" id="frmRol" name="frmRol">
                                <input type="hidden" name="txtForm" id="txtForm" value="frmRol">
                                <input type="hidden" name="txtAccion" id="txtAccion" value="V">
                                <input type="hidden" name="txtCodigoM" id="txtCodigoM" value="<%=strDatosMuestra[0]%>">
                                <table cellspacing="0" cellpadding="5" width="800px" border="0" class="TABLAHEAD">
                                    <tr><td style="height: 10px;"></td></tr>
                                    <tr>
                                        <td class="LABELFORM">* Código:</td>
                                        <td class="CELDACAMPOFORM"><input type="text" name="txtCodigo" id="txtCodigo" value="<%=strDatosMuestra[0]%>" class="CAMPOFORM" onclick="ocultarDIV()" readonly></td>
                                        <td class="LABELFORM">* Nombre:</td>
                                        <td class="CELDACAMPOFORM"><input type="text" name="txtNombre" id="txtNombre" value="<%=strDatosMuestra[1]%>" class="CAMPOFORM" onclick="ocultarDIV()"></td>
                                        <tr><td colspan="4" style="height: 10px;"></td></tr>
                                        <% if (strAccion.equals("C")){%>
                                            <tr><td colspan="4" class="CELDABOTONFORM"><input type="button" value="Guardar" class="BOTONFORM" onclick="validarFormRol()">&nbsp;&nbsp;<input type="button" value="Limpiar" class="BOTONFORM" onclick="limpiarFormRol()"> &nbsp;&nbsp;<input type="button" value="Salir" class="BOTONFORM" onclick="javascript:window.close();"></td></tr>
                                        <%}else{%>
                                            <tr><td colspan="4" class="CELDABOTONFORM"><input type="button" value="Guardar" class="BOTONFORM" onclick="validarFormRol()">&nbsp;&nbsp;<input type="button" value="Salir" class="BOTONFORM" onclick="javascript:window.close();"></td></tr>
                                        <%}%>                                        
                                        <tr><td colspan="4" class="MSGAVISOOBLG">Los campos marcados con (*) son obligatorios.</td></tr>
                                    </tr>
                                </table>
                            </form>
                        </td>
                    </tr>
                </table>
            <%}%>
            <br><br>
            <div id="dMensaje">                
            </div>
        </div>
        <div style="padding-top: 80px;"></div>			
        <footer>
            <jsp:include page="footer.jsp" />     
        </footer>	
    </body>
</html>
