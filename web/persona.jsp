<%-- 
    Document   : persona
    Created on : 20/04/2012, 11:05:28 AM
    Author     : Jorge.correa
--%>

<%@page import="java.util.Vector"%>
<%@page import="Negocio.GestionSQL"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%

    String strAccion = (String) request.getParameter("txtAccion");    
    String strCodigo = (String) request.getParameter("txtCodigo");
    String strRol = (String) session.getAttribute("strRol");
    String strNombre = (String) session.getAttribute("strNombre");
    String[] strDatosMuestra = null;
    Vector arrRoles;
    Vector arrCodigos = new Vector();
    Vector arrNombres = new Vector();
    String[] strTemp = null;
    
    if ((strNombre == null) || (strRol == null) || (strAccion == null)) {
        response.sendRedirect("cerrar.jsp");
     }else{
        if (strRol.equals("D")){
            arrRoles = GestionSQL.consultaSQL("select r.strCodigo as Id, r.strNombre as Nombre from tbl_roles r ORDER BY r.strNombre","MAESTROS");
        }else{
            arrRoles = GestionSQL.consultaSQL("select r.strCodigo as Id, r.strNombre as Nombre from tbl_roles r where r.strCodigo <> 'D' ORDER BY r.strNombre","MAESTROS");
        }            

        for (int i=0;i<arrRoles.size();i++){
            strTemp = arrRoles.get(i).toString().split(",");
            arrCodigos.add(strTemp[0]);
            arrNombres.add(strTemp[1]);
        }

        if (strAccion.equals("V")){
            strDatosMuestra = GestionSQL.getFila("select p.intCedula, p.strNombre, p.strDireccion, p.strTelefono, p.strEmail, p.strUsuario, p.strPassword, p.strRol from tbl_personas p where p.intCedula = '" + strCodigo + "'");
        }
     }    
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">             
        <link rel="SHORTCUT ICON" href="Images/favicon.ico" />
        <link rel="stylesheet" type="text/css" href="Styles/StylesComunes.css" />
        <link rel="stylesheet" type="text/css" href="Styles/StylesPersonas.css" />
        <script language="JavaScript" type="text/javascript" src="Scripts/JSAjax.js"></script>
        <script language="JavaScript" type="text/javascript" src="Scripts/JSComunes.js"></script>
        <script language="JavaScript" type="text/javascript" src="Scripts/JSPersonas.js"></script>
        <title>Administración: Crear nueva Persona</title>
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
                        <td class="TITULOFORM">NUEVO REGISTRO DE PERSONA</td>
                    </tr>
                    <tr>
                        <td class="SUBTITULOMENU1">Datos Generales</td>
                    </tr>
                    <tr>
                        <td>
                            <form method="POST" action="Registro" id="frmPersona" name="frmPersona">
                                <input type="hidden" name="txtForm" id="txtForm" value="frmPersona">
                                <input type="hidden" name="txtAccion" id="txtAccion" value="C">
                                <input type="hidden" name="txtCodigoM" id="txtCodigoM" value=" ">
                                <table cellspacing="0" cellpadding="5" width="800px" border="0" class="TABLAHEAD">
                                    <tr><td colspan="4" style="height: 10px;"></td></tr>
                                    <tr>
                                        <td class="LABELFORM">* Identificación:</td>
                                        <td class="CELDACAMPOFORM"><input type="text" name="txtId" id="txtId" class="CAMPOFORM" onclick="ocultarDIV()" onBlur="copiarDatos()"></td>
                                        <td class="LABELFORM">* Nombre completo:</td>
                                        <td class="CELDACAMPOFORM"><input type="text" name="txtNombre" id="txtNombre" class="CAMPOFORM" onclick="ocultarDIV()"></td>
                                    </tr>
                                    <tr>
                                        <td class="LABELFORM">Dirección:</td>
                                        <td class="CELDACAMPOFORM"><input type="text" name="txtDireccion" id="txtDireccion" class="CAMPOFORM" onclick="ocultarDIV()"></td>
                                        <td class="LABELFORM">* Teléfono:</td>
                                        <td class="CELDACAMPOFORM"><input type="text" name="txtTelefono" id="txtTelefono" class="CAMPOFORM" onclick="ocultarDIV()"></td>
                                    </tr>
                                    <tr>
                                        <td class="LABELFORM">* E-Mail:</td>
                                        <td class="CELDACAMPOFORM"><input type="text" name="txtEmail" id="txtEmail" class="CAMPOFORM" onclick="ocultarDIV()"></td>
                                        <td class="LABELFORM">* Rol:</td>
                                        <td class="CELDACAMPOFORM">                                        
                                            <select name="txtRol" id="txtRol" class="CAMPOFORM" onclick="ocultarDIV()">
                                                <option value="S">Seleccione una opción</option>    
                                                 <%for (int i=0;i<arrCodigos.size();i++){%>
                                                 <option value="<%=arrCodigos.get(i)%>"><%=arrNombres.get(i)%></option>
                                                <%}%>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr><td colspan="4" style="height: 10px;"></td></tr>
                                    <tr>
                                        <td colspan="4" class="SUBTITULOMENU2" style="height: 5px;">Datos de Inicio de Sesión</td>
                                    </tr>
                                    <tr><td colspan="4" style="height: 10px;"></td></tr>
                                    <tr>
                                        <td class="LABELFORM">Usuario:</td>
                                        <td class="CELDACAMPOFORM"><input type="text" name="txtUsuario" id="txtUsuario" class="CAMPOFORM" onclick="ocultarDIV()"></td>
                                        <td class="LABELFORM">Contraseña:</td>
                                        <td class="CELDACAMPOFORM" style="vertical-align: middle;">                                       
                                                <input type="text" name="txtPassword" id="txtPassword" class="CAMPOFORM" onclick="ocultarDIV()">
                                        </td>                                        
                                    </tr>
                                    <tr>
                                        <td style="height: 10px;"></td>
                                        <td style="height: 10px;"></td>
                                        <td style="height: 10px;"></td>
                                        <td style="height: 10px;"></td>
                                    </tr>
                                    <tr><td colspan="4" style="height: 10px;"></td></tr>
                                    <tr><td colspan="4" class="CELDABOTONFORM"><input type="button" value="Guardar" class="BOTONFORM" onclick="validarFormPersona()">&nbsp;&nbsp;<input type="button" value="Limpiar" class="BOTONFORM" onclick="limpiarFormPersona()"> &nbsp;&nbsp;<input type="button" value="Salir" class="BOTONFORM" onclick="javascript:window.close();"></td></tr>
                                    <tr><td colspan="4" class="MSGAVISOOBLG">Los campos marcados con (*) son obligatorios.</td></tr>
                                </table>
                            </form>
                        </td>
                    </tr>
                </table>
            <%}else{%>
                <table cellspacing="0" cellpadding="0" width="800px" border="0">
                    <tr>
                        <td class="TITULOFORM">REGISTRO DE PERSONA</td>
                    </tr>
                    <tr>
                        <td class="SUBTITULOMENU1">Datos Generales</td>
                    </tr>
                    <tr>
                        <td>
                            <form method="POST" action="Registro" id="frmPersona" name="frmPersona">
                                <input type="hidden" name="txtForm" id="txtForm" value="frmPersona">
                                <input type="hidden" name="txtAccion" id="txtAccion" value="V">
                                <input type="hidden" name="txtCodigoM" id="txtCodigoM" value="<%=strDatosMuestra[0]%>">
                                <table cellspacing="0" cellpadding="5" width="800px" border="0" class="TABLAHEAD">
                                    <tr><td colspan="4" style="height: 10px;"></td></tr>
                                    <tr>
                                        <td class="LABELFORM">* Identificación:</td>
                                        <td class="CELDACAMPOFORM"><input type="text" name="txtId" id="txtId" value="<%=strDatosMuestra[0]%>" class="CAMPOFORM" onclick="ocultarDIV()" readonly></td>
                                        <td class="LABELFORM">* Nombre completo:</td>
                                        <td class="CELDACAMPOFORM"><input type="text" name="txtNombre" id="txtNombre" value="<%=strDatosMuestra[1]%>" class="CAMPOFORM" onclick="ocultarDIV()"></td>
                                    </tr>
                                    <tr>
                                        <td class="LABELFORM">Dirección:</td>
                                        <td class="CELDACAMPOFORM"><input type="text" name="txtDireccion" id="txtDireccion" value="<%=strDatosMuestra[2]%>" class="CAMPOFORM" onclick="ocultarDIV()"></td>
                                        <td class="LABELFORM">* Teléfono:</td>
                                        <td class="CELDACAMPOFORM"><input type="text" name="txtTelefono" id="txtTelefono" value="<%=strDatosMuestra[3]%>" class="CAMPOFORM" onclick="ocultarDIV()"></td>
                                    </tr>
                                    <tr>
                                        <td class="LABELFORM">* E-Mail:</td>
                                        <td class="CELDACAMPOFORM"><input type="text" name="txtEmail" id="txtEmail" value="<%=strDatosMuestra[4]%>" class="CAMPOFORM" onclick="ocultarDIV()"></td>
                                        <td class="LABELFORM">* Rol:</td>
                                        <td class="CELDACAMPOFORM">                                        
                                            <select name="txtRol" id="txtRol" class="CAMPOFORM" onclick="ocultarDIV()">
                                                <option value="S">Seleccione una opción</option>    
                                                 <%for (int i=0;i<arrCodigos.size();i++){%>
                                                 <option value="<%=arrCodigos.get(i)%>"><%=arrNombres.get(i)%></option>
                                                <%}%>
                                            </select>
                                            <script language="javascript" type="text/javascript">                                                                                                          
                                                element = document.getElementById("txtRol");
                                                element.value = "<%=strDatosMuestra[7].toString()%>";                                                
                                            </script>
                                        </td>
                                    </tr>
                                    <tr><td colspan="4" style="height: 10px;"></td></tr>
                                    <tr>
                                        <td colspan="4" class="SUBTITULOMENU2" style="height: 5px;">Datos de Inicio de Sesión</td>
                                    </tr>
                                    <tr><td colspan="4" style="height: 10px;"></td></tr>
                                    <tr>
                                        <td class="LABELFORM">Usuario:</td>
                                        <td class="CELDACAMPOFORM"><input type="text" name="txtUsuario" id="txtUsuario" value="<%=strDatosMuestra[5]%>" class="CAMPOFORM" onclick="ocultarDIV()"></td>
                                        <td class="LABELFORM">Contraseña:</td>
                                        <td class="CELDACAMPOFORM" style="vertical-align: middle;">                                            
                                            <div id="dtxtPasswordC">
                                                <input type="text" name="txtPasswordC" id="txtPasswordC" value="<%=strDatosMuestra[6]%>" class="CAMPOFORM" onclick="ocultarDIV()">
                                            </div>
                                            <div id="dtxtPassword">
                                                <input type="password" name="txtPassword" id="txtPassword" value="<%=strDatosMuestra[6]%>" class="CAMPOFORM" onclick="ocultarDIV()">
                                            </div>                                            
                                        </td>                                        
                                    </tr>
                                    <tr>
                                        <td style="height: 10px;"></td>
                                        <td style="height: 10px;"></td>
                                        <td style="height: 10px;"></td>
                                        <td class="LABELOCULTAR"><input type="checkbox" name="cbOcultar" value="" onChange="ocultarPassword();">Mostrar caracteres</td>
                                    </tr>
                                    <% if (strAccion.equals("C")){%>
                                        <tr><td colspan="4" class="CELDABOTONFORM"><input type="button" value="Guardar" class="BOTONFORM" onclick="validarFormPersona()">&nbsp;&nbsp;<input type="button" value="Limpiar" class="BOTONFORM" onclick="limpiarFormPersona()"> &nbsp;&nbsp;<input type="button" value="Salir" class="BOTONFORM" onclick="javascript:window.close();"></td></tr>
                                    <%}else{%>
                                        <tr><td colspan="4" class="CELDABOTONFORM"><input type="button" value="Guardar" class="BOTONFORM" onclick="validarFormPersona()">&nbsp;&nbsp;<input type="button" value="Salir" class="BOTONFORM" onclick="javascript:window.close();"></td></tr>
                                    <%}%>    
                                        <tr><td colspan="4" class="MSGAVISOOBLG">Los campos marcados con (*) son obligatorios.</td></tr>
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
