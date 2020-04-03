<%-- 
    Document   : busqueda
    Created on : 18/04/2012, 11:00:36 AM
    Author     : jorge.correa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    // Recuperar los parámetros desde la sesión.

    String strNombre = (String) session.getAttribute("strNombre");
    String strUsuario = (String) session.getAttribute("strUsuario");
    String strCedula = (String) session.getAttribute("strCedula");
    
    if ((strNombre == null) || (strUsuario == null) || (strCedula == null)){
        response.sendRedirect("cerrar.jsp");
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' type='text/css' href='Styles/StylesComunes.css'/>
        <link rel='stylesheet' type='text/css' href='Styles/StylesBusqueda.css'/>
        <link rel="SHORTCUT ICON" href="Images/favicon.ico" />
        <script language="JavaScript" type="text/javascript" src="Scripts/JSAjax.js"></script>
        <script language="JavaScript" type="text/javascript" src="Scripts/JSBusqueda.js"></script>
        <script language="JavaScript" type="text/javascript" src="Scripts/JSComunes.js"></script>
        <title>Consulta de Muestras</title>
        <script language="javascript">
            function disableKeyPress(evt){               
                var evt = (evt) ? evt : ((event) ? event : null); 
                var node = (evt.target) ? evt.target : ((evt.srcElement) ? evt.srcElement : null); 
                if ((evt.keyCode == 13) && (node.type=="text"))  {return false;} 
            }
        </script>
    </head>
    <body onload="cargaBody()" OnKeyPress='return disableKeyPress(event)'>
        <div align='center'>
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
            <form id="frmConsulta" name="frmConsulta" method="POST" action="consulta">
                <input type="hidden" name="txtCedula" id="txtCedula" value="<%=strCedula%>">
                <table cellspacing="0" cellpadding="0" width="280px" class="TABLAFORM">
                        <tr>
                                <td colspan="2" style="text-align: center;" class="TITULOFORM">CONSULTA DE MUESTRA</td>				
                        </tr>
                        <tr>
                                <td class="LABELFORM">* Consecutivo:</td>
                                <td class="CELDACAMPOFORM"><input type="text" name="txtConsecutivo" id="txtConsecutivo" class="CAMPOFORM" OnKeyPress='return disableKeyPress(event)' onkeydown='return disableKeyPress(event)'></td>
                        </tr>          
                        <tr>
                                <td colspan="2" class="CELDABOTONFORM">
                                        <input type="button" value="Consultar" id="btnConsultar" class="BOTONFORM" onclick="validarFormConsulta()" OnKeyPress='return disableKeyPress(event)'>
                                        <input type="button" value="Limpiar" id="btnLimpiar" class="BOTONFORM" onclick="limpiarFormConsulta()" OnKeyPress='return disableKeyPress(event)'>
                                </td>		
                        </tr>
                </table>
            </form>           
        </div> 
        <br><br>
        <div id="dResultados" align='center'>            
        </div>
        <br><br>
        <div style="padding-top: 100px;"></div>			
        <footer>
            <jsp:include page="footer.jsp" />     
        </footer>
    </body>
</html>
