<%-- 
    Document   : muestra
    Created on : 18/04/2012, 11:00:36 AM
    Author     : jorge.correa
--%>

<%@page import="Negocio.dao.impl.MuestraDAOImpl"%>
<%@page import="Negocio.dao.MuestraDAO"%>
<%@page import="Negocio.dto.Muestra"%>
<%@page import="java.util.Vector"%>
<%@ page import="Negocio.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String strNombre = (String) session.getAttribute("strNombre");
    String strUsuario = (String) session.getAttribute("strUsuario");   
    String strAccion = (String) request.getParameter("txtAccion");    
    String strCodigo = (String) request.getParameter("txtCodigo");    
    String strTipoMuestra = (String) request.getParameter("txtTipoMuestra");    
    
     String strConsecutivo = "";
     Vector arrCedulas = new Vector();
     Vector arrNombres = new Vector();
     Vector arrCodigos = new Vector();
     Vector arrNombresE = new Vector();
     Vector arrTipoAnalisisI = new Vector();
     Vector arrTipoAnalisisN = new Vector();
     Vector arrRespI = new Vector();
     Vector arrRespN = new Vector();
     String[] strDatosMuestra = null;    
     Muestra muestra = null;
             
     if ((strNombre == null) || (strUsuario == null) || (strAccion == null)) {
        response.sendRedirect("cerrar.jsp");        
     }else{
         
        String[] strTemp = null;
        Vector arrUsuarios = GestionSQL.consultaSQL("select p.intCedula as Id, p.strNombre as Nombre from tbl_personas p where p.strRol = 'C' ORDER BY p.strNombre","MAESTROS");
        
        for (int i=0;i<arrUsuarios.size();i++){
            strTemp = arrUsuarios.get(i).toString().split(",");
            arrCedulas.add(strTemp[0]);
            arrNombres.add(strTemp[1]);
        }       
        
        strTemp = null;
        Vector arrResponsables = GestionSQL.consultaSQL("select p.intCedula as Id, p.strNombre as Nombre from tbl_personas p where p.strRol = 'G' ORDER BY p.strNombre","MAESTROS");
        
        for (int i=0;i<arrResponsables.size();i++){
            strTemp = arrResponsables.get(i).toString().split(",");
            arrRespI.add(strTemp[0]);
            arrRespN.add(strTemp[1]);
        }

        strTemp = null;
        Vector arrEstados = GestionSQL.consultaSQL("select e.strCodigo as Id, e.strNombre as Nombre from tbl_estados e ORDER BY e.strNombre","MAESTROS");

        for (int i=0;i<arrEstados.size();i++){
            strTemp = arrEstados.get(i).toString().split(",");
            arrCodigos.add(strTemp[0]);
            arrNombresE.add(strTemp[1]);
        } 
        
         strTemp = null;         
         Vector arrTiposAnalisis = GestionSQL.consultaSQL("select e.strCodigo as Id, e.strNombre as Nombre from tbl_tipos_analisis e ORDER BY e.strNombre","MAESTROS");
         
         for (int i=0;i<arrTiposAnalisis.size();i++){
            strTemp = arrTiposAnalisis.get(i).toString().split(",");
            arrTipoAnalisisI.add(strTemp[0]);
            arrTipoAnalisisN.add(strTemp[1]);
        } 
        
         if (strAccion.equals("C")){
             strConsecutivo = "Por asignar";             
         }

        if (strAccion.equals("V")){
            MuestraDAO muestraDAO = new MuestraDAOImpl();
            muestra = muestraDAO.obtenerUna(strCodigo,strTipoMuestra);            
        }
      }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="SHORTCUT ICON" href="Images/favicon.ico" />
        <link rel="stylesheet" type="text/css" href="Styles/StylesComunes.css" />
        <link rel="stylesheet" type="text/css" href="Styles/StylesMuestras.css" />
        <link rel="stylesheet" type="text/css" href="Styles/calendar-system.css" />
        <script type="text/javascript" src="Scripts/jquery-1.7.2.min.js"></script>
        <script type="text/javascript" charset="UTF-8" src="Scripts/JSComunes.js"></script>
        <script type="text/javascript" src="Scripts/JSCalendar.js"></script>
        <script type="text/javascript" src="Scripts/JSCalendar-es.js"></script>
        <script type="text/javascript" src="Scripts/JSCalendar-setup.js"></script>        
        <script type="text/javascript" src="Scripts/JSAjax.js"></script>
        <script type="text/javascript" charset="UTF-8" src="Scripts/JSMuestras.js"></script>
        <title>Muestra</title>
    </head>
    <body onload="cargaBody()">
        <div align="center">
           <header>
                <jsp:include page="header.jsp" />
            </header>
            <br>
            <%if(strTipoMuestra.equals("R")){%>
                <% if (strAccion.equals("C")){%>           
                    <table cellspacing="0" cellpadding="0" width="900px" border="0">
                        <tr>
                            <td class="TITULOFORM">NUEVO REGISTRO DE MUESTRA RECIBIDA</td>
                        </tr>
                        <tr>
                            <td>
                                <form method="POST" action="RegistroMuestra" id="frmMuestra" name="frmMuestra" onsubmit="return validarFormMuestra()" accept-charset="UTF-8">
                                    <input type="hidden" name="txtForm" id="txtForm" value="frmMuestra">
                                    <input type="hidden" name="txtAccion" id="txtAccion" value="C">
                                    <input type="hidden" name="txtCodigoM" id="txtCodigoM" value=" ">
                                    <input type="hidden" name="txtTipoMuestra" id="txtTipoMuestra" value="<%=strTipoMuestra%>">
                                    <table cellspacing="0" cellpadding="5" width="100%" border="0" class="TABLAHEAD">
                                        <tr><td colspan="4" style="height: 10px;"></td></tr>
                                        <tr>
                                            <td class="LABELFORM">Autor:</td>
                                            <td class="CELDACAMPOFORM"><input type="text" name="txtAutor" id="txtAutor" class="CAMPOFORM" value="<%=strUsuario%>" onclick="ocultarDIV()" readonly></td>
                                            <td class="LABELFORM"> Consecutivo:</td>
                                            <td class="CELDACAMPOFORM"><input type="text" name="txtConsecutivo" id="txtConsecutivo" value="<%=strConsecutivo%>" class="CAMPOFORM" onclick="ocultarDIV()" readonly></td>
                                        </tr>
                                        <tr>
                                            <td class="LABELFORM">* Fecha de recepción:<br> (aaaa-mm-dd)</td>
                                            <td class="CELDACAMPOFORM"><input type="text" name="txtFechaRecep" id="txtFechaRecep" class="CAMPOFORM" onclick="ocultarDIV()" style="width: 160px;" readonly>&nbsp;<img src="Images/Calendario.JPG" id="imgFechaRecep"></td>
                                            <td class="LABELFORM">* Nombre del cliente:</td>
                                            <td class="CELDACAMPOFORM">
                                                <select name="txtCedula" id="txtCedula" class="CAMPOFORM" onclick="ocultarDIV()">
                                                    <option value="S">Seleccione una opción</option>    
                                                     <%for (int i=0;i<arrCedulas.size();i++){%>
                                                     <option value="<%=arrCedulas.get(i)%>"><%=arrNombres.get(i)%></option>
                                                    <%}%>
                                                </select>                                       
                                            </td>
                                        </tr>                                    
                                        <tr>
                                            <td class="LABELFORM">* Usuario que entrega:</td>
                                            <td class="CELDACAMPOFORM"><input type="text" name="txtUsuarioEntrega" id="txtUsuarioEntrega" class="CAMPOFORM" onclick="ocultarDIV()"></td>
                                            <td class="LABELFORM">* Cantidad de muestras:</td>
                                            <td class="CELDACAMPOFORM"><input type="text" name="txtCantidadMuestras" id="txtCantidadMuestras" class="CAMPOFORM" onclick="ocultarDIV()"></td>
                                        </tr>
                                        <tr><td colspan="4" style="height: 10px;"></td></tr>
                                        <tr>
                                            <td class="LABELFORM">* Tipo de análisis:</td>
                                            <td class="CELDACAMPOFORM">
                                                <select name="txtTipoAnalisis" id="txtTipoAnalisis" class="CAMPOFORM" onclick="ocultarDIV()">
                                                    <option value="S">Seleccione una opción</option>    
                                                     <%for (int i=0;i<arrTipoAnalisisI.size();i++){%>
                                                     <option value="<%=arrTipoAnalisisI.get(i)%>"><%=arrTipoAnalisisN.get(i)%></option>
                                                    <%}%>
                                                </select>   
                                            </td>
                                            <td class="LABELFORM">* Responsable del análisis:</td>
                                            <td class="CELDACAMPOFORM">
                                                <select name="txtRespAnalisis" id="txtRespAnalisis" class="CAMPOFORM" onclick="ocultarDIV()">
                                                    <option value="S">Seleccione una opción</option>    
                                                     <%for (int i=0;i<arrRespI.size();i++){%>
                                                     <option value="<%=arrRespI.get(i)%>"><%=arrRespN.get(i)%></option>
                                                    <%}%>
                                                </select>   
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="LABELFORM">* Estado:</td>
                                            <td class="CELDACAMPOFORM">
                                                <select name="txtEstado" id="txtEstado" class="CAMPOFORM" onclick="ocultarDIV()">
                                                    <option value="S">Seleccione una opción</option>    
                                                     <%for (int i=0;i<arrCodigos.size();i++){%>
                                                        <option value="<%=arrCodigos.get(i)%>"><%=arrNombresE.get(i)%></option>
                                                    <%}%>
                                                    <script type="text/javascript">                                            
                                                        $("#txtEstado option[value='R']").attr('selected', 'selected');
                                                    </script>
                                                </select>
                                            </td>
                                            <td class="LABELFORM">* Fecha estimada de entrega:<br> (aaaa-mm-dd)</td>
                                            <td class="CELDACAMPOFORM"><input type="text" name="txtFechaEntrega" id="txtFechaEntrega" class="CAMPOFORM" onclick="ocultarDIV()" style="width: 160px;" readonly>&nbsp;<img src="Images/Calendario.JPG" id="imgFechaEstimada"></td>
                                        </tr>
                                        <tr>
                                            <td class="LABELFORM">Comentario:</td>
                                            <td colspan="3" class="CELDACAMPODESCR"><input type="text" name="txtDescripcion" id="txtDescripcion" class="CAMPOFORM" style="width: 650px;"></td>
                                        </tr>                
                                        <tr>
                                            <td class="LABELFORM">Costo del servicio ($):</td>
                                            <td class="CELDACAMPOFORM"><input type="text" name="txtCostoServicio" id="txtCostoServicio" class="CAMPOFORM" onclick="ocultarDIV()"></td>
                                            <td class="LABELFORM">Fecha de entrega real:<br> (aaaa-mm-dd)</td>
                                            <td class="CELDACAMPOFORM"><input type="text" name="txtFechaEntregaR" id="txtFechaEntregaR" class="CAMPOFORM" onclick="ocultarDIV()" style="width: 160px;" readonly>&nbsp;<img src="Images/Calendario.JPG" id="imgFechaEntregaR"></td>                                              
                                        </tr> 
                                        <tr><td colspan="4" style="height: 10px;"></td></tr>
                                        <tr><td colspan="4" class="CELDABOTONFORM"><input type="submit" value="Guardar" class="BOTONFORM">&nbsp;&nbsp;<input type="button" value="Limpiar" class="BOTONFORM" onclick="limpiarFormMuestra()"> &nbsp;&nbsp;<input type="button" value="Salir" class="BOTONFORM" onclick="javascript:window.close();"></td></tr>
                                        <tr>
                                            <td colspan="4" class="MSGAVISOOBLG">Los campos marcados con (*) son obligatorios.</td>                                       
                                        </tr>                                    
                                    </table>
                                </form>
                            </td>
                        </tr>
                    </table>
                 <%}else{%>
                    <table cellspacing="0" cellpadding="0" width="900px" border="0">
                        <tr>
                            <td class="TITULOFORM">REGISTRO DE MUESTRA RECIBIDA</td>
                        </tr>
                        <tr>
                            <td>
                                <form method="POST" action="RegistroMuestra" id="frmMuestra" name="frmMuestra" onsubmit="return validarFormMuestra()" accept-charset="UTF-8">
                                    <input type="hidden" name="txtForm" id="txtForm" value="frmMuestra">
                                    <input type="hidden" name="txtAccion" id="txtAccion" value="V">                             
                                    <input type="hidden" name="txtCodigoM" id="txtCodigoM" value="<%=strCodigo%>">
                                    <input type="hidden" name="txtTipoMuestra" id="txtTipoMuestra" value="<%=strTipoMuestra%>">
                                    <table cellspacing="0" cellpadding="5" width="100%" border="0" class="TABLAHEAD">
                                        <tr><td colspan="4" style="height: 10px;"></td></tr>
                                        <tr>
                                            <td class="LABELFORM">Autor:</td>
                                            <td class="CELDACAMPOFORM"><input type="text" name="txtAutor" id="txtAutor" class="CAMPOFORM" value="<%=muestra.getAutor()%>" onclick="ocultarDIV()" readonly></td>
                                            <td class="LABELFORM"> Consecutivo:</td>
                                            <td class="CELDACAMPOFORM"><input type="text" name="txtConsecutivo" id="txtConsecutivo" value="<%=muestra.getConsecutivo()%>" class="CAMPOFORM" onclick="ocultarDIV()" readonly></td>
                                        </tr>
                                        <tr>
                                            <td class="LABELFORM">* Fecha de recepción:<br> (aaaa-mm-dd)</td>
                                            <td class="CELDACAMPOFORM"><input type="text" name="txtFechaRecep" id="txtFechaRecep" class="CAMPOFORM" value="<%=muestra.getFechaRecepcion()%>" onclick="ocultarDIV()" style="width: 160px;" readonly>&nbsp;<img src="Images/Calendario.JPG" id="imgFechaRecep"></td>
                                            <td class="LABELFORM">* Nombre del cliente:</td>
                                            <td class="CELDACAMPOFORM">
                                                <select name="txtCedula" id="txtCedula" class="CAMPOFORM" onclick="ocultarDIV()">
                                                    <option value="S">Seleccione una opción</option>    
                                                     <%for (int i=0;i<arrCedulas.size();i++){%>
                                                     <option value="<%=arrCedulas.get(i)%>"><%=arrNombres.get(i)%></option>
                                                    <%}%>
                                                </select>              
                                                <script type="text/javascript">
                                                    $("#txtCedula option[value='<%=muestra.getCodigoCliente()%>']").attr('selected', 'selected');
                                               </script>
                                            </td>
                                        </tr>                                    
                                        <tr>
                                            <td class="LABELFORM">* Usuario que entrega:</td>
                                            <td class="CELDACAMPOFORM"><input type="text" name="txtUsuarioEntrega" id="txtUsuarioEntrega" class="CAMPOFORM" value="<%=muestra.getUsuarioEntrega()%>" onclick="ocultarDIV()"></td>
                                            <td class="LABELFORM">* Cantidad de muestras:</td>
                                            <td class="CELDACAMPOFORM"><input type="text" name="txtCantidadMuestras" id="txtCantidadMuestras" class="CAMPOFORM" value="<%=muestra.getCantidadMuestras()%>" onclick="ocultarDIV()"></td>
                                        </tr>
                                        <tr><td colspan="4" style="height: 10px;"></td></tr>
                                        <tr>
                                            <td class="LABELFORM">* Tipo de análisis:</td>
                                            <td class="CELDACAMPOFORM">
                                                <select name="txtTipoAnalisis" id="txtTipoAnalisis" class="CAMPOFORM" onclick="ocultarDIV()">
                                                    <option value="S">Seleccione una opción</option>    
                                                     <%for (int i=0;i<arrTipoAnalisisI.size();i++){%>
                                                     <option value="<%=arrTipoAnalisisI.get(i)%>"><%=arrTipoAnalisisN.get(i)%></option>
                                                    <%}%>
                                                </select>   
                                                <script type="text/javascript">
                                                    $("#txtTipoAnalisis option[value='<%=muestra.getTipoAnalisis()%>']").attr('selected', 'selected');
                                               </script>
                                            </td>
                                            <td class="LABELFORM">* Responsable del análisis:</td>
                                            <td class="CELDACAMPOFORM">
                                                <select name="txtRespAnalisis" id="txtRespAnalisis" class="CAMPOFORM" onclick="ocultarDIV()">
                                                    <option value="S">Seleccione una opción</option>    
                                                     <%for (int i=0;i<arrRespI.size();i++){%>
                                                     <option value="<%=arrRespI.get(i)%>"><%=arrRespN.get(i)%></option>
                                                    <%}%>
                                                </select>   
                                                <script type="text/javascript">
                                                    $("#txtRespAnalisis option[value='<%=muestra.getResponsable()%>']").attr('selected', 'selected');
                                               </script>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="LABELFORM">* Estado:</td>
                                            <td class="CELDACAMPOFORM">
                                                <select name="txtEstado" id="txtEstado" class="CAMPOFORM" onclick="ocultarDIV()">
                                                    <option value="S">Seleccione una opción</option>    
                                                     <%for (int i=0;i<arrCodigos.size();i++){%>
                                                        <option value="<%=arrCodigos.get(i)%>"><%=arrNombresE.get(i)%></option>
                                                    <%}%>
                                                    <script type="text/javascript">                                            
                                                        $("#txtEstado option[value='<%=muestra.getEstado()%>']").attr('selected', 'selected');
                                                    </script>                                       
                                                </select>
                                            </td>
                                            <td class="LABELFORM">* Fecha estimada de entrega:<br> (aaaa-mm-dd)</td>
                                            <td class="CELDACAMPOFORM"><input type="text" name="txtFechaEntrega" id="txtFechaEntrega" class="CAMPOFORM" value="<%=muestra.getFechaEstimadaEntrega()%>" onclick="ocultarDIV()" style="width: 160px;" readonly>&nbsp;<img src="Images/Calendario.JPG" id="imgFechaEstimada"></td>
                                        </tr>
                                        <tr>
                                            <td class="LABELFORM">Comentario:</td>
                                            <td colspan="3" class="CELDACAMPODESCR"><input type="text" name="txtDescripcion" id="txtDescripcion" class="CAMPOFORM" value="<%=muestra.getComentario()%>" style="width: 650px;"></td>
                                        </tr>                
                                        <tr>
                                            <td class="LABELFORM">Costo del servicio ($):</td>
                                            <td class="CELDACAMPOFORM"><input type="text" name="txtCostoServicio" id="txtCostoServicio" class="CAMPOFORM" value="<%=muestra.getCostoServicio()%>" onclick="ocultarDIV()"></td>
                                            <td class="LABELFORM">Fecha de entrega real:<br> (aaaa-mm-dd)</td>
                                            <td class="CELDACAMPOFORM">
                                                <%if (muestra.getFechaEntregaReal() != null){%>
                                                    <input type="text" name="txtFechaEntregaR" id="txtFechaEntregaR" class="CAMPOFORM" onclick="ocultarDIV()" value="<%=muestra.getFechaEntregaReal()%>" style="width: 160px;" readonly>&nbsp;<img src="Images/Calendario.JPG" id="imgFechaEntregaR"></td>                                              
                                                <%}else{%>
                                                    <input type="text" name="txtFechaEntregaR" id="txtFechaEntregaR" class="CAMPOFORM" onclick="ocultarDIV()" value="" style="width: 160px;" readonly>&nbsp;<img src="Images/Calendario.JPG" id="imgFechaEntregaR"></td>                                              
                                                <%}%>

                                        </tr> 
                                        <tr><td colspan="4" style="height: 10px;"></td></tr>
                                        <tr><td colspan="4" class="CELDABOTONFORM"><input type="submit" value="Guardar" class="BOTONFORM">&nbsp;&nbsp;<input type="button" value="Salir" class="BOTONFORM" onclick="javascript:window.close();"></td></tr>
                                        <tr>
                                            <td colspan="4" class="MSGAVISOOBLG">Los campos marcados con (*) son obligatorios.</td>                                       
                                        </tr>                                    
                                    </table>
                                </form>
                            </td>
                        </tr>
                    </table>
                 <%}%>
             <%}else{%>
                <% if (strAccion.equals("C")){%>           
                    <table cellspacing="0" cellpadding="0" width="900px" border="0">
                        <tr>
                            <td class="TITULOFORM">NUEVO REGISTRO DE MUESTRA ENVIADA</td>
                        </tr>
                        <tr>
                            <td>
                                <form method="POST" action="RegistroMuestra" id="frmMuestra" name="frmMuestra" onsubmit="return validarFormMuestra()" accept-charset="UTF-8">
                                    <input type="hidden" name="txtForm" id="txtForm" value="frmMuestra">
                                    <input type="hidden" name="txtAccion" id="txtAccion" value="C">
                                    <input type="hidden" name="txtCodigoM" id="txtCodigoM" value=" ">
                                    <input type="hidden" name="txtTipoMuestra" id="txtTipoMuestra" value="<%=strTipoMuestra%>">
                                    <table cellspacing="0" cellpadding="5" width="100%" border="0" class="TABLAHEAD">
                                        <tr><td colspan="4" style="height: 10px;"></td></tr>
                                        <tr>
                                            <td class="LABELFORM">Autor:</td>
                                            <td class="CELDACAMPOFORM"><input type="text" name="txtAutor" id="txtAutor" class="CAMPOFORM" value="<%=strUsuario%>" onclick="ocultarDIV()" readonly></td>
                                            <td class="LABELFORM"> Consecutivo:</td>
                                            <td class="CELDACAMPOFORM"><input type="text" name="txtConsecutivo" id="txtConsecutivo" value="<%=strConsecutivo%>" class="CAMPOFORM" onclick="ocultarDIV()" readonly></td>
                                        </tr>
                                        <tr>
                                            <td class="LABELFORM">* Fecha de entrega:<br> (aaaa-mm-dd)</td>
                                            <td class="CELDACAMPOFORM"><input type="text" name="txtFechaRecep" id="txtFechaRecep" class="CAMPOFORM" onclick="ocultarDIV()" style="width: 160px;" readonly>&nbsp;<img src="Images/Calendario.JPG" id="imgFechaRecep"></td>
                                            <td class="LABELFORM">* Nombre del proveedor</td>
                                            <td class="CELDACAMPOFORM">
                                                <select name="txtCedula" id="txtCedula" class="CAMPOFORM" onclick="ocultarDIV()">
                                                    <option value="S">Seleccione una opción</option>    
                                                     <%for (int i=0;i<arrCedulas.size();i++){%>
                                                     <option value="<%=arrCedulas.get(i)%>"><%=arrNombres.get(i)%></option>
                                                    <%}%>
                                                </select>                                       
                                            </td>
                                        </tr>                                    
                                        <tr>
                                            <td class="LABELFORM">* Usuario que entregó:</td>
                                            <td class="CELDACAMPOFORM"><input type="text" name="txtUsuarioEntrega" id="txtUsuarioEntrega" class="CAMPOFORM" onclick="ocultarDIV()"></td>
                                            <td class="LABELFORM">* Cantidad de muestras:</td>
                                            <td class="CELDACAMPOFORM"><input type="text" name="txtCantidadMuestras" id="txtCantidadMuestras" class="CAMPOFORM" onclick="ocultarDIV()"></td>
                                        </tr>
                                        <tr><td colspan="4" style="height: 10px;"></td></tr>
                                        <tr>
                                            <td class="LABELFORM">* Tipo de análisis:</td>
                                            <td class="CELDACAMPOFORM">
                                                <select name="txtTipoAnalisis" id="txtTipoAnalisis" class="CAMPOFORM" onclick="ocultarDIV()">
                                                    <option value="S">Seleccione una opción</option>    
                                                     <%for (int i=0;i<arrTipoAnalisisI.size();i++){%>
                                                     <option value="<%=arrTipoAnalisisI.get(i)%>"><%=arrTipoAnalisisN.get(i)%></option>
                                                    <%}%>
                                                </select>   
                                            </td>
                                            <td class="LABELFORM">* Responsable del análisis:</td>
                                            <td class="CELDACAMPOFORM">
                                                <select name="txtRespAnalisis" id="txtRespAnalisis" class="CAMPOFORM" onclick="ocultarDIV()">
                                                    <option value="S">Seleccione una opción</option>    
                                                     <%for (int i=0;i<arrRespI.size();i++){%>
                                                     <option value="<%=arrRespI.get(i)%>"><%=arrRespN.get(i)%></option>
                                                    <%}%>
                                                </select>   
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="LABELFORM">* Estado:</td>
                                            <td class="CELDACAMPOFORM">
                                                <select name="txtEstado" id="txtEstado" class="CAMPOFORM" onclick="ocultarDIV()">
                                                    <option value="S">Seleccione una opción</option>    
                                                     <%for (int i=0;i<arrCodigos.size();i++){%>
                                                        <option value="<%=arrCodigos.get(i)%>"><%=arrNombresE.get(i)%></option>
                                                    <%}%>
                                                    <script type="text/javascript">                                            
                                                        $("#txtEstado option[value='R']").attr('selected', 'selected');
                                                    </script>
                                                </select>
                                            </td>
                                            <td class="LABELFORM">* Fecha estimada de entrega:<br> (aaaa-mm-dd)</td>
                                            <td class="CELDACAMPOFORM"><input type="text" name="txtFechaEntrega" id="txtFechaEntrega" class="CAMPOFORM" onclick="ocultarDIV()" style="width: 160px;" readonly>&nbsp;<img src="Images/Calendario.JPG" id="imgFechaEstimada"></td>
                                        </tr>
                                        <tr>
                                            <td class="LABELFORM">Comentario:</td>
                                            <td colspan="3" class="CELDACAMPODESCR"><input type="text" name="txtDescripcion" id="txtDescripcion" class="CAMPOFORM" style="width: 650px;"></td>
                                        </tr>                
                                        <tr>
                                            <td class="LABELFORM">Costo del servicio ($):</td>
                                            <td class="CELDACAMPOFORM"><input type="text" name="txtCostoServicio" id="txtCostoServicio" class="CAMPOFORM" onclick="ocultarDIV()"></td>
                                            <td class="LABELFORM">Fecha de entrega real:<br> (aaaa-mm-dd)</td>
                                            <td class="CELDACAMPOFORM"><input type="text" name="txtFechaEntregaR" id="txtFechaEntregaR" class="CAMPOFORM" onclick="ocultarDIV()" style="width: 160px;" readonly>&nbsp;<img src="Images/Calendario.JPG" id="imgFechaEntregaR"></td>                                              
                                        </tr> 
                                        <tr><td colspan="4" style="height: 10px;"></td></tr>
                                        <tr><td colspan="4" class="CELDABOTONFORM"><input type="submit" value="Guardar" class="BOTONFORM">&nbsp;&nbsp;<input type="button" value="Limpiar" class="BOTONFORM" onclick="limpiarFormMuestra()"> &nbsp;&nbsp;<input type="button" value="Salir" class="BOTONFORM" onclick="javascript:window.close();"></td></tr>
                                        <tr>
                                            <td colspan="4" class="MSGAVISOOBLG">Los campos marcados con (*) son obligatorios.</td>                                       
                                        </tr>                                    
                                    </table>
                                </form>
                            </td>
                        </tr>
                    </table>
                 <%}else{%>
                    <table cellspacing="0" cellpadding="0" width="900px" border="0">
                        <tr>
                            <td class="TITULOFORM">REGISTRO DE MUESTRA ENVIADA</td>
                        </tr>
                        <tr>
                            <td>
                                <form method="POST" action="RegistroMuestra" id="frmMuestra" name="frmMuestra" onsubmit="return validarFormMuestra()" accept-charset="UTF-8">
                                    <input type="hidden" name="txtForm" id="txtForm" value="frmMuestra">
                                    <input type="hidden" name="txtAccion" id="txtAccion" value="V">                             
                                    <input type="hidden" name="txtCodigoM" id="txtCodigoM" value="<%=strCodigo%>">
                                    <input type="hidden" name="txtTipoMuestra" id="txtTipoMuestra" value="<%=strTipoMuestra%>">
                                    <table cellspacing="0" cellpadding="5" width="100%" border="0" class="TABLAHEAD">
                                        <tr><td colspan="4" style="height: 10px;"></td></tr>
                                        <tr>
                                            <td class="LABELFORM">Autor:</td>
                                            <td class="CELDACAMPOFORM"><input type="text" name="txtAutor" id="txtAutor" class="CAMPOFORM" value="<%=muestra.getAutor()%>" onclick="ocultarDIV()" readonly></td>
                                            <td class="LABELFORM"> Consecutivo:</td>
                                            <td class="CELDACAMPOFORM"><input type="text" name="txtConsecutivo" id="txtConsecutivo" value="<%=muestra.getConsecutivo()%>" class="CAMPOFORM" onclick="ocultarDIV()" readonly></td>
                                        </tr>
                                        <tr>
                                            <td class="LABELFORM">* Fecha de entrega:<br> (aaaa-mm-dd)</td>
                                            <td class="CELDACAMPOFORM"><input type="text" name="txtFechaRecep" id="txtFechaRecep" class="CAMPOFORM" value="<%=muestra.getFechaRecepcion()%>" onclick="ocultarDIV()" style="width: 160px;" readonly>&nbsp;<img src="Images/Calendario.JPG" id="imgFechaRecep"></td>
                                            <td class="LABELFORM">* Nombre del proveedor</td>
                                            <td class="CELDACAMPOFORM">
                                                <select name="txtCedula" id="txtCedula" class="CAMPOFORM" onclick="ocultarDIV()">
                                                    <option value="S">Seleccione una opción</option>    
                                                     <%for (int i=0;i<arrCedulas.size();i++){%>
                                                     <option value="<%=arrCedulas.get(i)%>"><%=arrNombres.get(i)%></option>
                                                    <%}%>
                                                </select>              
                                                <script type="text/javascript">
                                                    $("#txtCedula option[value='<%=muestra.getCodigoCliente()%>']").attr('selected', 'selected');
                                               </script>
                                            </td>
                                        </tr>                                    
                                        <tr>
                                            <td class="LABELFORM">* Usuario que entregó:</td>
                                            <td class="CELDACAMPOFORM"><input type="text" name="txtUsuarioEntrega" id="txtUsuarioEntrega" class="CAMPOFORM" value="<%=muestra.getUsuarioEntrega()%>" onclick="ocultarDIV()"></td>
                                            <td class="LABELFORM">* Cantidad de muestras:</td>
                                            <td class="CELDACAMPOFORM"><input type="text" name="txtCantidadMuestras" id="txtCantidadMuestras" class="CAMPOFORM" value="<%=muestra.getCantidadMuestras()%>" onclick="ocultarDIV()"></td>
                                        </tr>
                                        <tr><td colspan="4" style="height: 10px;"></td></tr>
                                        <tr>
                                            <td class="LABELFORM">* Tipo de análisis:</td>
                                            <td class="CELDACAMPOFORM">
                                                <select name="txtTipoAnalisis" id="txtTipoAnalisis" class="CAMPOFORM" onclick="ocultarDIV()">
                                                    <option value="S">Seleccione una opción</option>    
                                                     <%for (int i=0;i<arrTipoAnalisisI.size();i++){%>
                                                     <option value="<%=arrTipoAnalisisI.get(i)%>"><%=arrTipoAnalisisN.get(i)%></option>
                                                    <%}%>
                                                </select>   
                                                <script type="text/javascript">
                                                    $("#txtTipoAnalisis option[value='<%=muestra.getTipoAnalisis()%>']").attr('selected', 'selected');
                                               </script>
                                            </td>
                                            <td class="LABELFORM">* Responsable del análisis:</td>
                                            <td class="CELDACAMPOFORM">
                                                <select name="txtRespAnalisis" id="txtRespAnalisis" class="CAMPOFORM" onclick="ocultarDIV()">
                                                    <option value="S">Seleccione una opción</option>    
                                                     <%for (int i=0;i<arrRespI.size();i++){%>
                                                     <option value="<%=arrRespI.get(i)%>"><%=arrRespN.get(i)%></option>
                                                    <%}%>
                                                </select>   
                                                <script type="text/javascript">
                                                    $("#txtRespAnalisis option[value='<%=muestra.getResponsable()%>']").attr('selected', 'selected');
                                               </script>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="LABELFORM">* Estado:</td>
                                            <td class="CELDACAMPOFORM">
                                                <select name="txtEstado" id="txtEstado" class="CAMPOFORM" onclick="ocultarDIV()">
                                                    <option value="S">Seleccione una opción</option>    
                                                     <%for (int i=0;i<arrCodigos.size();i++){%>
                                                        <option value="<%=arrCodigos.get(i)%>"><%=arrNombresE.get(i)%></option>
                                                    <%}%>
                                                    <script type="text/javascript">                                            
                                                        $("#txtEstado option[value='<%=muestra.getEstado()%>']").attr('selected', 'selected');
                                                    </script>                                       
                                                </select>
                                            </td>
                                            <td class="LABELFORM">* Fecha estimada de entrega:<br> (aaaa-mm-dd)</td>
                                            <td class="CELDACAMPOFORM"><input type="text" name="txtFechaEntrega" id="txtFechaEntrega" class="CAMPOFORM" value="<%=muestra.getFechaEstimadaEntrega()%>" onclick="ocultarDIV()" style="width: 160px;" readonly>&nbsp;<img src="Images/Calendario.JPG" id="imgFechaEstimada"></td>
                                        </tr>
                                        <tr>
                                            <td class="LABELFORM">Comentario:</td>
                                            <td colspan="3" class="CELDACAMPODESCR"><input type="text" name="txtDescripcion" id="txtDescripcion" class="CAMPOFORM" value="<%=muestra.getComentario()%>" style="width: 650px;"></td>
                                        </tr>                
                                        <tr>
                                            <td class="LABELFORM">Costo del servicio ($):</td>
                                            <td class="CELDACAMPOFORM"><input type="text" name="txtCostoServicio" id="txtCostoServicio" class="CAMPOFORM" value="<%=muestra.getCostoServicio()%>" onclick="ocultarDIV()"></td>
                                            <td class="LABELFORM">Fecha de entrega real:<br> (aaaa-mm-dd)</td>
                                            <td class="CELDACAMPOFORM">
                                                <%if (muestra.getFechaEntregaReal() != null){%>
                                                    <input type="text" name="txtFechaEntregaR" id="txtFechaEntregaR" class="CAMPOFORM" onclick="ocultarDIV()" value="<%=muestra.getFechaEntregaReal()%>" style="width: 160px;" readonly>&nbsp;<img src="Images/Calendario.JPG" id="imgFechaEntregaR"></td>                                              
                                                <%}else{%>
                                                    <input type="text" name="txtFechaEntregaR" id="txtFechaEntregaR" class="CAMPOFORM" onclick="ocultarDIV()" value="" style="width: 160px;" readonly>&nbsp;<img src="Images/Calendario.JPG" id="imgFechaEntregaR"></td>                                              
                                                <%}%>

                                        </tr> 
                                        <tr><td colspan="4" style="height: 10px;"></td></tr>
                                        <tr><td colspan="4" class="CELDABOTONFORM"><input type="submit" value="Guardar" class="BOTONFORM">&nbsp;&nbsp;<input type="button" value="Salir" class="BOTONFORM" onclick="javascript:window.close();"></td></tr>
                                        <tr>
                                            <td colspan="4" class="MSGAVISOOBLG">Los campos marcados con (*) son obligatorios.</td>                                       
                                        </tr>                                    
                                    </table>
                                </form>
                            </td>
                        </tr>
                    </table>
                 <%}%>
             <%}%>
            <br>
            <div id="dMensaje">                
            </div>
        </div>
        <div style="padding-top: 20px;"></div>			
        <footer>
            <jsp:include page="footer.jsp" />     
        </footer>	
        <script language="javascript" type="text/javascript">
            cargarCalendarios();
        </script>
    </body>
</html>