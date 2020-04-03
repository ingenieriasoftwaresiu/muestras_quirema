<%-- 
    Document   : principal
    Created on : 18/04/2012, 11:00:36 AM
    Author     : jorge.correa
--%>

<%@page import="Negocio.GestionSQL"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    
    String strCedula = (String) session.getAttribute("strCedula");
    String strNombre = (String) session.getAttribute("strNombre");
    String strUsuario = (String) session.getAttribute("strUsuario");
    String strRol = (String) session.getAttribute("strRol");       
    String[] strDatosMuestra = null;
           
    strDatosMuestra = GestionSQL.getFila("select g.strCodigo from tbl_generales g where g.strCodigo = 'frmGeneral'");
      
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="SHORTCUT ICON" href="Images/favicon.ico" />
        <link rel="stylesheet" type="text/css" href="Styles/StylesComunes.css" />
        <link rel="stylesheet" type="text/css" href="Styles/StylesPpal.css" />
        <script language="JavaScript" type="text/javascript" src="Scripts/JSAjax.js"></script>
        <script language="JavaScript" type="text/javascript" src="Scripts/JSComunes.js"></script>
        <script language='JavaScript' type='text/javascript' src='Scripts/JSVisualizacion.js'></script>
        <script language="javascript">
            function disableKeyPress(evt){               
                var evt = (evt) ? evt : ((event) ? event : null); 
                var node = (evt.target) ? evt.target : ((evt.srcElement) ? evt.srcElement : null); 
                if ((evt.keyCode == 13) && (node.type=="text"))  {return false;} 
            }
        </script>
        <title>Menú Principal</title>
    </head>
    <body OnLoad="onLoadBody()" OnKeyPress="return disableKeyPress(event)">
        <%
            if (strNombre == null){
                response.sendRedirect("cerrar.jsp");
            }
        %>
        <div align="center">
            <header>
                <jsp:include page="header.jsp" />
            </header>
            <br>
            <table cellspacing="0" cellpadding="0" width="90%" border="0">
                <tr>
                    <td class="USERLOGED"><b>Bienvenido,</b> <%=strNombre%></td>                    
                    <td class="CIERRESESION"><a href="#" onclick="cerrarSesion()">Cerrar sesión</td>                    
                </tr>
            </table>
            <br>
             <table cellspacing="0" cellpadding="0" width="90%" border="0">
                <tr>
                    <td width="250px" style="vertical-align: text-top;">
                        <table cellspacing="0" cellpadding="6" width="250px" border="0" class="TABLAMENU">
                            <tr><td class="TITULOMENU" style="font-size: 15px;">MENU PRINCIPAL</td></tr>
                            <tr><td class="SUBTITULOMENU">Creación de Muestras</td></tr>
                            <tr><td class="ITEMMENU"><a href="#" onclick="javascript:window.open('muestra.jsp?txtTipoMuestra=R&txtAccion=C&txtCodigo=-1','Muestra_Recibida','width=1250px,height=800px')">Nuevo registro de muestra recibida</a></td></tr>
                            <tr><td class="ITEMMENU"><a href="#" onclick="javascript:window.open('muestra.jsp?txtTipoMuestra=E&txtAccion=C&txtCodigo=-1','Muestra_Enviada','width=1250px,height=800px')">Nuevo registro de muestra enviada</a></td></tr>
                            <tr><td class="SUBTITULOMENU">Consulta de Muestras</td></tr>
                            <tr><td class="ITEMMENU"><a href="#" onclick="getXMLHTTPRequest('Visualizacion?txtAccion=consecutivo','dMostrar');">Listado de muestras recibidas</a></td></tr>
                            <tr><td class="ITEMMENU"><a href="#" onclick="getXMLHTTPRequest('Visualizacion?txtAccion=enviadas','dMostrar');">Listado de muestras enviadas</a></td></tr>
                            <tr><td class="ITEMMENU"><a href="#" onclick="generarArchivoPlanoContrato()">Generar archivo plano de Muestras</a></td></tr>  
                            <!--<tr><td class="ITEMMENU"><a href="#" onclick="getXMLHTTPRequest('Visualizacion?txtAccion=nombre','dMostrar');">Nombre del usuario</a></td></tr>-->
                            <!--<tr><td class="ITEMMENU"><a href="#" onclick="getXMLHTTPRequest('Visualizacion?txtAccion=estado','dMostrar');">Estado</a></td></tr>-->
                            <!--<tr><td class="ITEMMENU"><a href="#" onclick="getXMLHTTPRequest('Visualizacion?txtAccion=fechaRecepcion','dMostrar');">Fecha de recepción</a></td></tr>-->
                            <!--<tr><td class="ITEMMENU"><a href="#" onclick="getXMLHTTPRequest('Visualizacion?txtAccion=fechaEntrega','dMostrar');">Fecha de entrega</a></td></tr>-->
                            <tr><td class="SUBTITULOMENU">Parámetros del Sistema</td></tr>
                            <%if (strRol.equals("D")){%>
                                <tr><td class="ITEMMENU"><b>Roles:</b> <a href="#" onclick="javascript:window.open('rol.jsp?txtAccion=C&txtCodigo=-1','Rol','width=1250px,height=600px')">Crear</a> / <a href="#" onclick="getXMLHTTPRequest('Visualizacion?txtAccion=rol','dMostrar');">Consultar</td></tr>                            
                                <%if (strDatosMuestra == null){%> 
                                    <tr><td class="ITEMMENU"><b>Generales:</b> <a href="#" onclick="javascript:window.open('general.jsp?txtAccion=C&txtCodigo=-1','General','width=1250px,height=800px')">Crear</a></td></tr>
                                <%}else{%>
                                    <tr><td class="ITEMMENU"><b>Generales:</b> <a href="#" onclick="javascript:window.open('general.jsp?txtAccion=V&txtCodigo=-1','General','width=1250px,height=800px')">Consultar</a></td></tr>
                                <%}%> 
                            <%}%>                                               
                            <tr><td class="ITEMMENU"><b>Estados:</b> <a href="#" onclick="javascript:window.open('estado.jsp?txtAccion=C&txtCodigo=-1','Estado','width=1250px,height=600px')">Crear</a> / <a href="#" onclick="getXMLHTTPRequest('Visualizacion?txtAccion=estados','dMostrar');">Consultar</a></td></tr>
                            <tr><td class="ITEMMENU"><b>Personas:</b> <a href="#" onclick="javascript:window.open('persona.jsp?txtAccion=C&txtCodigo=-1','Persona','width=1250px,height=800px')">Crear</a> / <a href="#" onclick="getXMLHTTPRequest('Visualizacion?txtAccion=persona','dMostrar');">Consultar</a></td></tr>                           
                            <tr><td class="ITEMMENU"><b>Tipos de análisis:</b> <a href="#" onclick="javascript:window.open('tipoAnalisis.jsp?txtAccion=C&txtCodigo=-1','Tipo_Analisis','width=1250px,height=800px')">Crear</a> / <a href="#" onclick="getXMLHTTPRequest('Visualizacion?txtAccion=tipo_analisis','dMostrar');">Consultar</a></td></tr>                           
                            </table>
                    </td>
                    <td width="20px"></td>
                    <td style="text-align: center;vertical-align: top;">
                        <div id="dMostrar">                            
                        </div>
                    </td>
                </tr>
            </table>
	</div>
        <div style="padding-top: 70px;"></div>			
        <footer>
            <jsp:include page="footer.jsp" />     
        </footer>
     </body>
</html>
