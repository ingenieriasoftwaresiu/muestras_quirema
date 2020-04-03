<%-- 
    Document   : tipoAnalisis
    Created on : 24/02/2016, 09:38:06 AM
    Author     : Jorge.correa
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
            strDatosMuestra = GestionSQL.getFila("select e.strCodigo, e.strNombre from tbl_tipos_analisis e where e.strCodigo = '" + strCodigo +"' ORDER BY e.strNombre");
        }
     }    
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="SHORTCUT ICON" href="Images/favicon.ico" />
        <link rel="stylesheet" type="text/css" href="Styles/StylesComunes.css" />
        <link rel="stylesheet" type="text/css" href="Styles/StylesEstados.css" />
        <script language="JavaScript" type="text/javascript" src="Scripts/JSAjax.js"></script>
        <script language="JavaScript" type="text/javascript" src="Scripts/JSComunes.js"></script>
        <script language="JavaScript" type="text/javascript" src="Scripts/JSTiposAnalisis.js"></script>
        <title>Administración: Tipo de análisis</title>
    </head>
    <body onload="cargaBody()">
        <div align="center">
            <header>
                  <jsp:include page="header.jsp" />
            </header>
            <br>
            <% if (strAccion.equals("C")){%>
                <table cellspacing="0" cellpadding="0" width="800px" border="0">
                    <tr>
                        <td class="TITULOFORM">NUEVO REGISTRO DE TIPO DE ANÁLISIS</td>
                    </tr>                
                    <tr>
                        <td>
                            <form method="POST" action="Registro" id="frmTipoAnalisis" name="frmTipoAnalisis">
                                <input type="hidden" name="txtForm" id="txtForm" value="frmTipoAnalisis">
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
                                        <tr><td colspan="4" class="CELDABOTONFORM"><input type="button" value="Guardar" class="BOTONFORM" onclick="validarFormTipoAnalisis()">&nbsp;&nbsp;<input type="button" value="Limpiar" class="BOTONFORM" onclick="limpiarFormTipoAnalisis()"> &nbsp;&nbsp;<input type="button" value="Salir" class="BOTONFORM" onclick="javascript:window.close();"></td></tr>
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
                        <td class="TITULOFORM">REGISTRO DE TIPO DE ANÁLISIS</td>
                    </tr>                
                    <tr>
                        <td>
                            <form method="POST" action="Registro" id="frmTipoAnalisis" name="frmTipoAnalisis">
                                <input type="hidden" name="txtForm" id="txtForm" value="frmTipoAnalisis">
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
                                            <tr><td colspan="4" class="CELDABOTONFORM"><input type="button" value="Guardar" class="BOTONFORM" onclick="validarFormTipoAnalisis()">&nbsp;&nbsp;<input type="button" value="Limpiar" class="BOTONFORM" onclick="limpiarFormTipoAnalisis()"> &nbsp;&nbsp;<input type="button" value="Salir" class="BOTONFORM" onclick="javascript:window.close();"></td></tr>
                                        <%}else{%>
                                            <tr><td colspan="4" class="CELDABOTONFORM"><input type="button" value="Guardar" class="BOTONFORM" onclick="validarFormTipoAnalisis()">&nbsp;&nbsp;<input type="button" value="Salir" class="BOTONFORM" onclick="javascript:window.close();"></td></tr>
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
        <br><br>
        <footer>
            <jsp:include page="footer.jsp" />     
        </footer>
    </body>
</html>
