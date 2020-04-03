/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jorge.correa
 */
public class Visualizacion extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            HttpSession session = request.getSession(true);
            String strAccion = request.getParameter("txtAccion");   
            String strRol = "";
            if (request.getParameter("txtAccion") != null){
                 strRol = (String) session.getAttribute("strRol"); 
            }      
            
            String strSQL = "";
            String strTitulo = "";
            String strHTML = "";         
            String strTipoConsulta = "";
            String strCabecera = "";
            String strBusqueda = "";
                                   
            if (strAccion.equals("consecutivo")){  
                strTipoConsulta = "VISUALIZACION";
                strTitulo = "LISTADO DE MUESTRAS RECIBIDAS";
                strCabecera = "<td colspan='8' class='TITULOMENU'>" + strTitulo + "</td>";    
                strBusqueda = strBusqueda + "<form id='frmBusqueda' name='frmBusqueda' method='POST' action='#'>";
                strBusqueda = strBusqueda + "<table cellpadding='0' cellspacing='0' border='0' width='100%' class='TABLAFORM'>";
                strBusqueda = strBusqueda + "<tr>";
                strBusqueda = strBusqueda + "<td class ='TITULOBUSQUEDA'>";
                strBusqueda = strBusqueda + "BÚSQUEDA DE MUESTRAS";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class ='LABELFORM'>";
                strBusqueda = strBusqueda + "Críterio:&nbsp;";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDACAMPOFORM'>";
                strBusqueda = strBusqueda + "<select name='txtCriterio' id='txtCriterio' class='CAMPOFORM' style='height: 23px;' OnKeyPress='return disableKeyPress(event)'>&nbsp;";
                strBusqueda = strBusqueda + "<option value='S'>Seleccione una opción</option>";
                strBusqueda = strBusqueda + "<option value='C'>Consecutivo</option>";
                strBusqueda = strBusqueda + "<option value='FR'>Fecha de recepción</option>";
                strBusqueda = strBusqueda + "<option value='NU'>Nombre del usuario</option>";
                strBusqueda = strBusqueda + "<option value='E'>Estado</option>";
                strBusqueda = strBusqueda + "<option value='FE'>Fecha de entrega</option>";                
                strBusqueda = strBusqueda + "</select>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class ='LABELFORM'>";
                strBusqueda = strBusqueda + "Clave:&nbsp;";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDACAMPOFORM'>";
                strBusqueda = strBusqueda + "<input type='text' name='txtClave' id='txtClave' class='CAMPOFORM' OnKeyPress='return disableKeyPress(event)'>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDAIMAGEN'>";
                strBusqueda = strBusqueda + "<a href=\"#\" onclick=\"buscarRegistro('" + strAccion + "')\"><img src='Images/lupa.gif'id='Buscar' class='IMAGENBUSQUEDA'></a>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "</tr>";
                strBusqueda = strBusqueda + "</table>";
                strBusqueda = strBusqueda + "</form>";
                strSQL = "select m.strConsecutivo, m.dtFechaRecepcion, p.strNombre, e.strNombre, m.dtFechaEntrega, t.strNombre, p2.strNombre, m.strCodigo from tbl_muestras m, tbl_estados e, tbl_personas p, tbl_tipos_analisis t, tbl_personas p2 where (m.strEstado = e.strCodigo) and (m.intPersona = p.intCedula) and (m.strTipoAnalisis = t.strCodigo) and (m.strResponsable = p2.intCedula) ORDER BY CAST(m.strConsecutivo as SIGNED)";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Consecutivo</td>\n";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Fecha de recepción<br />(aaaa-mm-dd)</td>\n";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Nombre del cliente</td>\n";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Estado de la muestra</td>\n";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Fecha estimada de entrega<br />(aaaa-mm-dd)</td>\n";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Tipo de análisis</td>\n";             
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Responsable</td>\n";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>¿Eliminar?</td>";                       
            }
            
            if (strAccion.equals("enviadas")){  
                strTipoConsulta = "VISUALIZACION";
                strTitulo = "LISTADO DE MUESTRAS ENVIADAS";
                strCabecera = "<td colspan='8' class='TITULOMENU'>" + strTitulo + "</td>";    
                strBusqueda = strBusqueda + "<form id='frmBusqueda' name='frmBusqueda' method='POST' action='#'>";
                strBusqueda = strBusqueda + "<table cellpadding='0' cellspacing='0' border='0' width='100%' class='TABLAFORM'>";
                strBusqueda = strBusqueda + "<tr>";
                strBusqueda = strBusqueda + "<td class ='TITULOBUSQUEDA'>";
                strBusqueda = strBusqueda + "BÚSQUEDA DE MUESTRAS";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class ='LABELFORM'>";
                strBusqueda = strBusqueda + "Críterio:&nbsp;";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDACAMPOFORM'>";
                strBusqueda = strBusqueda + "<select name='txtCriterio' id='txtCriterio' class='CAMPOFORM' style='height: 23px;' OnKeyPress='return disableKeyPress(event)'>&nbsp;";
                strBusqueda = strBusqueda + "<option value='S'>Seleccione una opción</option>";
                strBusqueda = strBusqueda + "<option value='C'>Consecutivo</option>";
                strBusqueda = strBusqueda + "<option value='FR'>Fecha de recepción</option>";
                strBusqueda = strBusqueda + "<option value='NU'>Nombre del usuario</option>";
                strBusqueda = strBusqueda + "<option value='E'>Estado</option>";
                strBusqueda = strBusqueda + "<option value='FE'>Fecha de entrega</option>";                
                strBusqueda = strBusqueda + "</select>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class ='LABELFORM'>";
                strBusqueda = strBusqueda + "Clave:&nbsp;";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDACAMPOFORM'>";
                strBusqueda = strBusqueda + "<input type='text' name='txtClave' id='txtClave' class='CAMPOFORM' OnKeyPress='return disableKeyPress(event)'>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDAIMAGEN'>";
                strBusqueda = strBusqueda + "<a href=\"#\" onclick=\"buscarRegistro('" + strAccion + "')\"><img src='Images/lupa.gif'id='Buscar' class='IMAGENBUSQUEDA'></a>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "</tr>";
                strBusqueda = strBusqueda + "</table>";
                strBusqueda = strBusqueda + "</form>";
                strSQL = "select m.strConsecutivo, m.dtFechaRecepcion, p.strNombre, e.strNombre, m.dtFechaEntrega, t.strNombre, p2.strNombre, m.strCodigo from tbl_muestras_enviadas m, tbl_estados e, tbl_personas p, tbl_tipos_analisis t, tbl_personas p2 where (m.strEstado = e.strCodigo) and (m.intPersona = p.intCedula) and (m.strTipoAnalisis = t.strCodigo) and (m.strResponsable = p2.intCedula) ORDER BY CAST(m.strConsecutivo as SIGNED)";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Consecutivo</td>\n";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Fecha de recepción<br />(aaaa-mm-dd)</td>\n";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Nombre del cliente</td>\n";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Estado de la muestra</td>\n";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Fecha estimada de entrega<br />(aaaa-mm-dd)</td>\n";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Tipo de análisis</td>\n";             
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Responsable</td>\n";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>¿Eliminar?</td>";                       
            }
            
            if (strAccion.equals("nombre")){    
                strTipoConsulta = "VISUALIZACION";
                strTitulo = "CONSULTA DE MUESTRAS POR NOMBRE DEL USUARIO";
                strCabecera = "<td colspan='7' class='TITULOMENU'>" + strTitulo + "</td>";
                strBusqueda = strBusqueda + "<form id='frmBusqueda' name='frmBusqueda' method='POST' action='#'>";
                strBusqueda = strBusqueda + "<table cellpadding='0' cellspacing='0' border='0' width='100%' class='TABLAFORM'>";
                strBusqueda = strBusqueda + "<tr>";
                strBusqueda = strBusqueda + "<td class ='TITULOBUSQUEDA'>";
                strBusqueda = strBusqueda + "BÚSQUEDA DE MUESTRAS";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class ='LABELFORM'>";
                strBusqueda = strBusqueda + "Críterio:&nbsp;";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDACAMPOFORM'>";
                strBusqueda = strBusqueda + "<select name='txtCriterio' id='txtCriterio' class='CAMPOFORM' style='height: 23px;' OnKeyPress='return disableKeyPress(event)'>&nbsp;";
                strBusqueda = strBusqueda + "<option value='S'>Seleccione una opción</option>";
                strBusqueda = strBusqueda + "<option value='C'>Consecutivo</option>";
                strBusqueda = strBusqueda + "<option value='FR'>Fecha de recepción</option>";
                strBusqueda = strBusqueda + "<option value='NU'>Nombre del usuario</option>";
                strBusqueda = strBusqueda + "<option value='E'>Estado</option>";
                strBusqueda = strBusqueda + "<option value='FE'>Fecha de entrega</option>";
                strBusqueda = strBusqueda + "<option value='D'>Descripción</option>";
                strBusqueda = strBusqueda + "</select>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class ='LABELFORM'>";
                strBusqueda = strBusqueda + "Clave:&nbsp;";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDACAMPOFORM'>";
                strBusqueda = strBusqueda + "<input type='text' name='txtClave' id='txtClave' class='CAMPOFORM' OnKeyPress='return disableKeyPress(event)'>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDAIMAGEN'>";
                strBusqueda = strBusqueda + "<a href=\"#\" onclick=\"buscarRegistro('" + strAccion + "')\"><img src='Images/lupa.gif'id='Buscar' class='IMAGENBUSQUEDA'></a>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "</tr>";
                strBusqueda = strBusqueda + "</table>";
                strBusqueda = strBusqueda + "</form>";
                strSQL = "select m.strConsecutivo, m.dtFechaRecepcion, p.strNombre, e.strNombre, m.dtFechaEntrega, m.strDescripcion, m.strCodigo from tbl_muestras m, tbl_estados e, tbl_personas p where (m.strEstado = e.strCodigo) and (m.intPersona = p.intCedula) ORDER BY p.strNombre";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Nombre del usuario</td>\n";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Consecutivo</td>\n";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Fecha de recepción</td>\n";                
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Estado</td>\n";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Fecha de entrega</td>\n";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Descripción</td>\n";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>¿Eliminar?</td>"; 
            }
            
            if (strAccion.equals("estado")){ 
                strTipoConsulta = "VISUALIZACION";
                strTitulo = "CONSULTA DE MUESTRAS POR ESTADO";
                strCabecera = "<td colspan='7' class='TITULOMENU'>" + strTitulo + "</td>";
                strBusqueda = strBusqueda + "<form id='frmBusqueda' name='frmBusqueda' method='POST' action='#'>";
                strBusqueda = strBusqueda + "<table cellpadding='0' cellspacing='0' border='0' width='100%' class='TABLAFORM'>";
                strBusqueda = strBusqueda + "<tr>";
                strBusqueda = strBusqueda + "<td class ='TITULOBUSQUEDA'>";
                strBusqueda = strBusqueda + "BÚSQUEDA DE MUESTRAS";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class ='LABELFORM'>";
                strBusqueda = strBusqueda + "Críterio:&nbsp;";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDACAMPOFORM'>";
                strBusqueda = strBusqueda + "<select name='txtCriterio' id='txtCriterio' class='CAMPOFORM' style='height: 23px;' OnKeyPress='return disableKeyPress(event)'>&nbsp;";
                strBusqueda = strBusqueda + "<option value='S'>Seleccione una opción</option>";
                strBusqueda = strBusqueda + "<option value='C'>Consecutivo</option>";
                strBusqueda = strBusqueda + "<option value='FR'>Fecha de recepción</option>";
                strBusqueda = strBusqueda + "<option value='NU'>Nombre del usuario</option>";
                strBusqueda = strBusqueda + "<option value='E'>Estado</option>";
                strBusqueda = strBusqueda + "<option value='FE'>Fecha de entrega</option>";
                strBusqueda = strBusqueda + "<option value='D'>Descripción</option>";
                strBusqueda = strBusqueda + "</select>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class ='LABELFORM'>";
                strBusqueda = strBusqueda + "Clave:&nbsp;";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDACAMPOFORM'>";
                strBusqueda = strBusqueda + "<input type='text' name='txtClave' id='txtClave' class='CAMPOFORM' OnKeyPress='return disableKeyPress(event)'>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDAIMAGEN'>";
                strBusqueda = strBusqueda + "<a href=\"#\" onclick=\"buscarRegistro('" + strAccion + "')\"><img src='Images/lupa.gif'id='Buscar' class='IMAGENBUSQUEDA'></a>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "</tr>";
                strBusqueda = strBusqueda + "</table>";
                strBusqueda = strBusqueda + "</form>";
                strSQL = "select m.strConsecutivo, m.dtFechaRecepcion, p.strNombre, e.strNombre, m.dtFechaEntrega, m.strDescripcion, m.strCodigo from tbl_muestras m, tbl_estados e, tbl_personas p where (m.strEstado = e.strCodigo) and (m.intPersona = p.intCedula) ORDER BY e.strNombre";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Estado</td>\n";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Consecutivo</td>\n";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Fecha de recepción</td>\n";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Nombre del usuario</td>\n";                
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Fecha de entrega</td>\n";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Descripción</td>\n";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>¿Eliminar?</td>"; 
            }
            
            if (strAccion.equals("fechaRecepcion")){  
                strTipoConsulta = "VISUALIZACION";
                strTitulo = "CONSULTA DE MUESTRAS POR FECHA DE RECEPCIÓN";
                strCabecera = "<td colspan='7' class='TITULOMENU'>" + strTitulo + "</td>";
                strBusqueda = strBusqueda + "<form id='frmBusqueda' name='frmBusqueda' method='POST' action='#'>";
                strBusqueda = strBusqueda + "<table cellpadding='0' cellspacing='0' border='0' width='100%' class='TABLAFORM'>";
                strBusqueda = strBusqueda + "<tr>";
                strBusqueda = strBusqueda + "<td class ='TITULOBUSQUEDA'>";
                strBusqueda = strBusqueda + "BÚSQUEDA DE MUESTRAS";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class ='LABELFORM'>";
                strBusqueda = strBusqueda + "Críterio:&nbsp;";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDACAMPOFORM'>";
                strBusqueda = strBusqueda + "<select name='txtCriterio' id='txtCriterio' class='CAMPOFORM' style='height: 23px;' OnKeyPress='return disableKeyPress(event)'>&nbsp;";
                strBusqueda = strBusqueda + "<option value='S'>Seleccione una opción</option>";
                strBusqueda = strBusqueda + "<option value='C'>Consecutivo</option>";
                strBusqueda = strBusqueda + "<option value='FR'>Fecha de recepción</option>";
                strBusqueda = strBusqueda + "<option value='NU'>Nombre del usuario</option>";
                strBusqueda = strBusqueda + "<option value='E'>Estado</option>";
                strBusqueda = strBusqueda + "<option value='FE'>Fecha de entrega</option>";
                strBusqueda = strBusqueda + "<option value='D'>Descripción</option>";
                strBusqueda = strBusqueda + "</select>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class ='LABELFORM'>";
                strBusqueda = strBusqueda + "Clave:&nbsp;";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDACAMPOFORM'>";
                strBusqueda = strBusqueda + "<input type='text' name='txtClave' id='txtClave' class='CAMPOFORM' OnKeyPress='return disableKeyPress(event)'>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDAIMAGEN'>";
                strBusqueda = strBusqueda + "<a href=\"#\" onclick=\"buscarRegistro('" + strAccion + "')\"><img src='Images/lupa.gif'id='Buscar' class='IMAGENBUSQUEDA'></a>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "</tr>";
                strBusqueda = strBusqueda + "</table>";
                strBusqueda = strBusqueda + "</form>";
                strSQL = "select m.strConsecutivo, m.dtFechaRecepcion, p.strNombre, e.strNombre, m.dtFechaEntrega, m.strDescripcion, m.strCodigo from tbl_muestras m, tbl_estados e, tbl_personas p where (m.strEstado = e.strCodigo) and (m.intPersona = p.intCedula) ORDER BY m.dtFechaRecepcion";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Fecha de recepción</td>\n";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Consecutivo</td>\n";                
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Nombre del usuario</td>\n";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Estado</td>\n";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Fecha de entrega</td>\n";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Descripción</td>\n";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>¿Eliminar?</td>"; 
            }
            
            if (strAccion.equals("fechaEntrega")){    
                strTipoConsulta = "VISUALIZACION";
                strTitulo = "CONSULTA DE MUESTRAS POR FECHA DE ENTREGA";
                strCabecera = "<td colspan='7' class='TITULOMENU'>" + strTitulo + "</td>";
                strBusqueda = strBusqueda + "<form id='frmBusqueda' name='frmBusqueda' method='POST' action='#'>";
                strBusqueda = strBusqueda + "<table cellpadding='0' cellspacing='0' border='0' width='100%' class='TABLAFORM'>";
                strBusqueda = strBusqueda + "<tr>";
                strBusqueda = strBusqueda + "<td class ='TITULOBUSQUEDA'>";
                strBusqueda = strBusqueda + "BÚSQUEDA DE MUESTRAS";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class ='LABELFORM'>";
                strBusqueda = strBusqueda + "Críterio:&nbsp;";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDACAMPOFORM'>";
                strBusqueda = strBusqueda + "<select name='txtCriterio' id='txtCriterio' class='CAMPOFORM' style='height: 23px;' OnKeyPress='return disableKeyPress(event)'>&nbsp;";
                strBusqueda = strBusqueda + "<option value='S'>Seleccione una opción</option>";
                strBusqueda = strBusqueda + "<option value='C'>Consecutivo</option>";
                strBusqueda = strBusqueda + "<option value='FR'>Fecha de recepción</option>";
                strBusqueda = strBusqueda + "<option value='NU'>Nombre del usuario</option>";
                strBusqueda = strBusqueda + "<option value='E'>Estado</option>";
                strBusqueda = strBusqueda + "<option value='FE'>Fecha de entrega</option>";
                strBusqueda = strBusqueda + "<option value='D'>Descripción</option>";
                strBusqueda = strBusqueda + "</select>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class ='LABELFORM'>";
                strBusqueda = strBusqueda + "Clave:&nbsp;";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDACAMPOFORM'>";
                strBusqueda = strBusqueda + "<input type='text' name='txtClave' id='txtClave' class='CAMPOFORM' OnKeyPress='return disableKeyPress(event)'>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDAIMAGEN'>";
                strBusqueda = strBusqueda + "<a href=\"#\" onclick=\"buscarRegistro('" + strAccion + "')\"><img src='Images/lupa.gif'id='Buscar' class='IMAGENBUSQUEDA'></a>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "</tr>";
                strBusqueda = strBusqueda + "</table>";
                strBusqueda = strBusqueda + "</form>";
                strSQL = "select m.strConsecutivo, m.dtFechaRecepcion, p.strNombre, e.strNombre, m.dtFechaEntrega, m.strDescripcion, m.strCodigo from tbl_muestras m, tbl_estados e, tbl_personas p where (m.strEstado = e.strCodigo) and (m.intPersona = p.intCedula) ORDER BY m.dtFechaEntrega";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Fecha de entrega</td>\n";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Consecutivo</td>\n";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Fecha de recepción</td>\n";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Nombre del usuario</td>\n";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Estado</td>\n";                
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Descripción</td>\n";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>¿Eliminar?</td>"; 
            }

            if (strAccion.equals("rol")){
                strTipoConsulta = "MAESTROS";
                strTitulo = "CONSULTA DE ROLES";
                strCabecera = "<td colspan='5' class='TITULOMENU'>" + strTitulo + "</td>";
                strBusqueda = strBusqueda + "<form id='frmBusqueda' name='frmBusqueda' method='POST' action='#'>";
                strBusqueda = strBusqueda + "<table cellpadding='0' cellspacing='0' border='0' width='100%' class='TABLAFORM'>";
                strBusqueda = strBusqueda + "<tr>";
                strBusqueda = strBusqueda + "<td class ='TITULOBUSQUEDA'>";
                strBusqueda = strBusqueda + "BÚSQUEDA DE ROLES";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class ='LABELFORM'>";
                strBusqueda = strBusqueda + "Críterio:&nbsp;";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDACAMPOFORM'>";
                strBusqueda = strBusqueda + "<select name='txtCriterio' id='txtCriterio' class='CAMPOFORM' style='height: 23px;' OnKeyPress='return disableKeyPress(event)'>&nbsp;";
                strBusqueda = strBusqueda + "<option value='S'>Seleccione una opción</option>";
                strBusqueda = strBusqueda + "<option value='C'>Código</option>";
                strBusqueda = strBusqueda + "<option value='N'>Nombre</option>";
                strBusqueda = strBusqueda + "</select>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class ='LABELFORM'>";
                strBusqueda = strBusqueda + "Clave:&nbsp;";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDACAMPOFORM'>";
                strBusqueda = strBusqueda + "<input type='text' name='txtClave' id='txtClave' class='CAMPOFORM' OnKeyPress='return disableKeyPress(event)'>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDAIMAGEN'>";
                strBusqueda = strBusqueda + "<a href=\"#\" onclick=\"buscarRegistro('" + strAccion + "')\"><img src='Images/lupa.gif'id='Buscar' class='IMAGENBUSQUEDA'></a>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "</tr>";
                strBusqueda = strBusqueda + "</table>";
                strBusqueda = strBusqueda + "</form>";
                if (strRol.equals("D")){
                    strSQL = "select r.strCodigo as Id, r.strNombre as Nombre from tbl_roles r ORDER BY r.strNombre";
                }else{
                    strSQL = "select r.strCodigo as Id, r.strNombre as Nombre from tbl_roles r where (r.strCodigo != 'D') ORDER BY r.strNombre";
                }                
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Código</td>\n";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Nombre</td>\n";                
                if (strRol.equals("D")){
                    strHTML = strHTML + "<td class='SUBTITULOMENU'>¿Eliminar?</td>";                     
                }
            }
            
            if (strAccion.equals("estados")){   
                strTipoConsulta = "MAESTROS";
                strTitulo = "CONSULTA DE ESTADOS";
                strCabecera = "<td colspan='5' class='TITULOMENU'>" + strTitulo + "</td>";
                strBusqueda = strBusqueda + "<form id='frmBusqueda' name='frmBusqueda' method='POST' action='#'>";
                strBusqueda = strBusqueda + "<table cellpadding='0' cellspacing='0' border='0' width='100%' class='TABLAFORM'>";
                strBusqueda = strBusqueda + "<tr>";
                strBusqueda = strBusqueda + "<td class ='TITULOBUSQUEDA'>";
                strBusqueda = strBusqueda + "BÚSQUEDA DE ESTADOS";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class ='LABELFORM'>";
                strBusqueda = strBusqueda + "Críterio:&nbsp;";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDACAMPOFORM'>";
                strBusqueda = strBusqueda + "<select name='txtCriterio' id='txtCriterio' class='CAMPOFORM' style='height: 23px;' OnKeyPress='return disableKeyPress(event)'>&nbsp;";
                strBusqueda = strBusqueda + "<option value='S'>Seleccione una opción</option>";
                strBusqueda = strBusqueda + "<option value='C'>Código</option>";
                strBusqueda = strBusqueda + "<option value='N'>Nombre</option>";
                strBusqueda = strBusqueda + "</select>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class ='LABELFORM'>";
                strBusqueda = strBusqueda + "Clave:&nbsp;";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDACAMPOFORM'>";
                strBusqueda = strBusqueda + "<input type='text' name='txtClave' id='txtClave' class='CAMPOFORM' OnKeyPress='return disableKeyPress(event)'>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDAIMAGEN'>";
                strBusqueda = strBusqueda + "<a href=\"#\" onclick=\"buscarRegistro('" + strAccion + "')\"><img src='Images/lupa.gif'id='Buscar' class='IMAGENBUSQUEDA'></a>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "</tr>";
                strBusqueda = strBusqueda + "</table>";
                strBusqueda = strBusqueda + "</form>";
                strSQL = "select e.strCodigo as Id, e.strNombre as Nombre from tbl_estados e ORDER BY e.strNombre";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Código</td>\n";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Nombre</td>\n";                
                strHTML = strHTML + "<td class='SUBTITULOMENU'>¿Eliminar?</td>"; 
            }
            
            if (strAccion.equals("tipo_analisis")){   
                strTipoConsulta = "MAESTROS";
                strTitulo = "CONSULTA DE TIPOS DE ANÁLISIS";
                strCabecera = "<td colspan='5' class='TITULOMENU'>" + strTitulo + "</td>";
                strBusqueda = strBusqueda + "<form id='frmBusqueda' name='frmBusqueda' method='POST' action='#'>";
                strBusqueda = strBusqueda + "<table cellpadding='0' cellspacing='0' border='0' width='100%' class='TABLAFORM'>";
                strBusqueda = strBusqueda + "<tr>";
                strBusqueda = strBusqueda + "<td class ='TITULOBUSQUEDA'>";
                strBusqueda = strBusqueda + "BÚSQUEDA DE TIPOS DE ANÁLISIS";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class ='LABELFORM'>";
                strBusqueda = strBusqueda + "Críterio:&nbsp;";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDACAMPOFORM'>";
                strBusqueda = strBusqueda + "<select name='txtCriterio' id='txtCriterio' class='CAMPOFORM' style='height: 23px;' OnKeyPress='return disableKeyPress(event)'>&nbsp;";
                strBusqueda = strBusqueda + "<option value='S'>Seleccione una opción</option>";
                strBusqueda = strBusqueda + "<option value='C'>Código</option>";
                strBusqueda = strBusqueda + "<option value='N'>Nombre</option>";
                strBusqueda = strBusqueda + "</select>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class ='LABELFORM'>";
                strBusqueda = strBusqueda + "Clave:&nbsp;";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDACAMPOFORM'>";
                strBusqueda = strBusqueda + "<input type='text' name='txtClave' id='txtClave' class='CAMPOFORM' OnKeyPress='return disableKeyPress(event)'>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDAIMAGEN'>";
                strBusqueda = strBusqueda + "<a href=\"#\" onclick=\"buscarRegistro('" + strAccion + "')\"><img src='Images/lupa.gif'id='Buscar' class='IMAGENBUSQUEDA'></a>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "</tr>";
                strBusqueda = strBusqueda + "</table>";
                strBusqueda = strBusqueda + "</form>";
                strSQL = "select e.strCodigo as Id, e.strNombre as Nombre from tbl_tipos_analisis e ORDER BY e.strNombre";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Código</td>\n";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Nombre</td>\n";                
                strHTML = strHTML + "<td class='SUBTITULOMENU'>¿Eliminar?</td>"; 
            }
                        
            if (strAccion.equals("persona")){
                strTipoConsulta = "VISUALIZACION";
                strTitulo = "CONSULTA DE PERSONAS";
                strCabecera = "<td colspan='8' class='TITULOMENU'>" + strTitulo + "</td>";
                strBusqueda = strBusqueda + "<form id='frmBusqueda' name='frmBusqueda' method='POST' action='#'>";
                strBusqueda = strBusqueda + "<table cellpadding='0' cellspacing='0' border='0' width='100%' class='TABLAFORM'>";
                strBusqueda = strBusqueda + "<tr>";
                strBusqueda = strBusqueda + "<td class ='TITULOBUSQUEDA'>";
                strBusqueda = strBusqueda + "BÚSQUEDA DE PERSONAS";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class ='LABELFORM'>";
                strBusqueda = strBusqueda + "Críterio:&nbsp;";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDACAMPOFORM'>";
                strBusqueda = strBusqueda + "<select name='txtCriterio' id='txtCriterio' class='CAMPOFORM' style='height: 23px;' OnKeyPress='return disableKeyPress(event)'>&nbsp;";
                strBusqueda = strBusqueda + "<option value='S'>Seleccione una opción</option>";
                strBusqueda = strBusqueda + "<option value='I'>Identificación</option>";
                strBusqueda = strBusqueda + "<option value='NC'>Nombre completo</option>";
                strBusqueda = strBusqueda + "<option value='D'>Dirección</option>";
                strBusqueda = strBusqueda + "<option value='T'>Teléfono</option>";
                strBusqueda = strBusqueda + "<option value='E'>E-Mail</option>";
                strBusqueda = strBusqueda + "<option value='UA'>Usuario de acceso</option>";
                strBusqueda = strBusqueda + "<option value='R'>Rol</option>";
                strBusqueda = strBusqueda + "</select>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class ='LABELFORM'>";
                strBusqueda = strBusqueda + "Clave:&nbsp;";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDACAMPOFORM'>";
                strBusqueda = strBusqueda + "<input type='text' name='txtClave' id='txtClave' class='CAMPOFORM' OnKeyPress='return disableKeyPress(event)'>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "<td class='CELDAIMAGEN'>";
                strBusqueda = strBusqueda + "<a href=\"#\" onclick=\"buscarRegistro('" + strAccion + "')\"><img src='Images/lupa.gif'id='Buscar' class='IMAGENBUSQUEDA'></a>";
                strBusqueda = strBusqueda + "</td>";
                strBusqueda = strBusqueda + "</tr>";
                strBusqueda = strBusqueda + "</table>";
                strBusqueda = strBusqueda + "</form>";
                if (strRol.equals("D")){
                    strSQL = "select p.intCedula, p.strNombre, p.strDireccion, p.strTelefono, p.strEmail, p.strUsuario, r.strNombre from tbl_personas p, tbl_roles r where (p.strRol = r.strCodigo) ORDER BY p.intCedula";
                }else{
                    strSQL = "select p.intCedula, p.strNombre, p.strDireccion, p.strTelefono, p.strEmail, p.strUsuario, r.strNombre from tbl_personas p, tbl_roles r where (p.strRol = r.strCodigo) and (p.strRol != 'D') ORDER BY p.intCedula";
                }                
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Identificación</td>\n";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Nombre completo</td>\n";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Dirección</td>\n";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Teléfono</td>\n";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>E-Mail</td>\n";                
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Usuario de acceso</td>\n";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>Rol</td>\n";
                strHTML = strHTML + "<td class='SUBTITULOMENU'>¿Eliminar?</td>"; 
            }
           
            if (request.getParameter("txtEvento") != null){
                String strEvento = request.getParameter("txtEvento");
                if (strEvento.equals("busqueda")){
                    String strCriterio = request.getParameter("txtCriterio");
                    String strClave = request.getParameter("txtClave");
                    
                    if ((strAccion.equals("consecutivo")) || (strAccion.equals("nombre")) || (strAccion.equals("estado")) || (strAccion.equals("fechaRecepcion")) || (strAccion.equals("fechaEntrega"))){
                  
                        if (strCriterio.equals("C")){
                            strSQL = "select m.strConsecutivo, m.dtFechaRecepcion, p.strNombre, e.strNombre, m.dtFechaEntrega, m.strDescripcion, m.strCodigo from tbl_muestras m, tbl_estados e, tbl_personas p where (m.strEstado = e.strCodigo) and (m.intPersona = p.intCedula) and (m.strConsecutivo = '" + strClave + "') ORDER BY m.strConsecutivo";
                        }

                        if (strCriterio.equals("FR")){
                            strSQL = "select m.strConsecutivo, m.dtFechaRecepcion, p.strNombre, e.strNombre, m.dtFechaEntrega, m.strDescripcion, m.strCodigo from tbl_muestras m, tbl_estados e, tbl_personas p where (m.strEstado = e.strCodigo) and (m.intPersona = p.intCedula) and (m.dtFechaRecepcion = '" + strClave + "') ORDER BY m.strConsecutivo";
                        }

                        if (strCriterio.equals("NU")){
                            strSQL = "select m.strConsecutivo, m.dtFechaRecepcion, p.strNombre, e.strNombre, m.dtFechaEntrega, m.strDescripcion, m.strCodigo from tbl_muestras m, tbl_estados e, tbl_personas p where (m.strEstado = e.strCodigo) and (m.intPersona = p.intCedula) and (p.strNombre like '%" + strClave + "%') ORDER BY m.strConsecutivo";
                        }

                        if (strCriterio.equals("E")){
                            strSQL = "select m.strConsecutivo, m.dtFechaRecepcion, p.strNombre, e.strNombre, m.dtFechaEntrega, m.strDescripcion, m.strCodigo from tbl_muestras m, tbl_estados e, tbl_personas p where (m.strEstado = e.strCodigo) and (m.intPersona = p.intCedula) and (e.strNombre like '%" + strClave + "%') ORDER BY m.strConsecutivo";
                        }

                        if (strCriterio.equals("FE")){
                            strSQL = "select m.strConsecutivo, m.dtFechaRecepcion, p.strNombre, e.strNombre, m.dtFechaEntrega, m.strDescripcion, m.strCodigo from tbl_muestras m, tbl_estados e, tbl_personas p where (m.strEstado = e.strCodigo) and (m.intPersona = p.intCedula) and (m.dtFechaEntrega = '" + strClave + "') ORDER BY m.strConsecutivo";
                        }

                        if (strCriterio.equals("D")){
                            strSQL = "select m.strConsecutivo, m.dtFechaRecepcion, p.strNombre, e.strNombre, m.dtFechaEntrega, m.strDescripcion, m.strCodigo from tbl_muestras m, tbl_estados e, tbl_personas p where (m.strEstado = e.strCodigo) and (m.intPersona = p.intCedula) and (m.strDescripcion like '%" + strClave + "%') ORDER BY m.strConsecutivo";
                        }  
                    }
                    
                    if (strAccion.equals("enviadas")){
                  
                        if (strCriterio.equals("C")){
                            strSQL = "select m.strConsecutivo, m.dtFechaRecepcion, p.strNombre, e.strNombre, m.dtFechaEntrega, m.strDescripcion, m.strCodigo from tbl_muestras_enviadas m, tbl_estados e, tbl_personas p where (m.strEstado = e.strCodigo) and (m.intPersona = p.intCedula) and (m.strConsecutivo = '" + strClave + "') ORDER BY m.strConsecutivo";
                        }

                        if (strCriterio.equals("FR")){
                            strSQL = "select m.strConsecutivo, m.dtFechaRecepcion, p.strNombre, e.strNombre, m.dtFechaEntrega, m.strDescripcion, m.strCodigo from tbl_muestras_enviadas m, tbl_estados e, tbl_personas p where (m.strEstado = e.strCodigo) and (m.intPersona = p.intCedula) and (m.dtFechaRecepcion = '" + strClave + "') ORDER BY m.strConsecutivo";
                        }

                        if (strCriterio.equals("NU")){
                            strSQL = "select m.strConsecutivo, m.dtFechaRecepcion, p.strNombre, e.strNombre, m.dtFechaEntrega, m.strDescripcion, m.strCodigo from tbl_muestras_enviadas m, tbl_estados e, tbl_personas p where (m.strEstado = e.strCodigo) and (m.intPersona = p.intCedula) and (p.strNombre like '%" + strClave + "%') ORDER BY m.strConsecutivo";
                        }

                        if (strCriterio.equals("E")){
                            strSQL = "select m.strConsecutivo, m.dtFechaRecepcion, p.strNombre, e.strNombre, m.dtFechaEntrega, m.strDescripcion, m.strCodigo from tbl_muestras_enviadas m, tbl_estados e, tbl_personas p where (m.strEstado = e.strCodigo) and (m.intPersona = p.intCedula) and (e.strNombre like '%" + strClave + "%') ORDER BY m.strConsecutivo";
                        }

                        if (strCriterio.equals("FE")){
                            strSQL = "select m.strConsecutivo, m.dtFechaRecepcion, p.strNombre, e.strNombre, m.dtFechaEntrega, m.strDescripcion, m.strCodigo from tbl_muestras_enviadas m, tbl_estados e, tbl_personas p where (m.strEstado = e.strCodigo) and (m.intPersona = p.intCedula) and (m.dtFechaEntrega = '" + strClave + "') ORDER BY m.strConsecutivo";
                        }

                        if (strCriterio.equals("D")){
                            strSQL = "select m.strConsecutivo, m.dtFechaRecepcion, p.strNombre, e.strNombre, m.dtFechaEntrega, m.strDescripcion, m.strCodigo from tbl_muestras_enviadas m, tbl_estados e, tbl_personas p where (m.strEstado = e.strCodigo) and (m.intPersona = p.intCedula) and (m.strDescripcion like '%" + strClave + "%') ORDER BY m.strConsecutivo";
                        }  
                    }
                                                            
                    if (strAccion.equals("rol")){                        
                        if (strCriterio.equals("C")){
                            if (strRol.equals("D")){
                                strSQL = "select r.strCodigo as Id, r.strNombre as Nombre from tbl_roles r where r.strCodigo = '" + strClave + "' ORDER BY r.strNombre";
                            }else{
                                strSQL = "select r.strCodigo as Id, r.strNombre as Nombre from tbl_roles r where (r.strCodigo != 'D') and (r.strCodigo = '" + strClave + "') ORDER BY r.strNombre";
                            }
                        }
                        
                        if (strCriterio.equals("N")){
                            if (strRol.equals("D")){
                                strSQL = "select r.strCodigo as Id, r.strNombre as Nombre from tbl_roles r where r.strNombre like '%" + strClave + "%' ORDER BY r.strNombre";
                            }else{
                                strSQL = "select r.strCodigo as Id, r.strNombre as Nombre from tbl_roles r where (r.strCodigo != 'D') and (r.strNombre like '%" + strClave + "%') ORDER BY r.strNombre";
                            }
                        }                        
                    } 
                
                    if (strAccion.equals("estados")){
                        if (strCriterio.equals("C")){
                            strSQL = "select e.strCodigo as Id, e.strNombre as Nombre from tbl_estados e where e.strCodigo = '" + strClave + "' ORDER BY e.strNombre";
                        }
                        
                        if (strCriterio.equals("N")){
                            strSQL = "select e.strCodigo as Id, e.strNombre as Nombre from tbl_estados e where e.strNombre like '%" + strClave + "%' ORDER BY e.strNombre";
                        }                        
                    }
                    
                    if (strAccion.equals("tipo_analisis")){
                        if (strCriterio.equals("C")){
                            strSQL = "select e.strCodigo as Id, e.strNombre as Nombre from tbl_tipos_analisis e where e.strCodigo = '" + strClave + "' ORDER BY e.strNombre";
                        }
                        
                        if (strCriterio.equals("N")){
                            strSQL = "select e.strCodigo as Id, e.strNombre as Nombre from tbl_tipos_analisis e where e.strNombre like '%" + strClave + "%' ORDER BY e.strNombre";
                        }                        
                    }
                    
                    if (strAccion.equals("persona")){
                        if (strCriterio.equals("I")){
                            if (strRol.equals("D")){
                                strSQL = "select p.intCedula, p.strNombre, p.strDireccion, p.strTelefono, p.strEmail, p.strUsuario, r.strNombre from tbl_personas p, tbl_roles r where (p.strRol = r.strCodigo) and (p.intCedula like '%" + strClave + "%') ORDER BY p.intCedula";
                            }else{
                                strSQL = "select p.intCedula, p.strNombre, p.strDireccion, p.strTelefono, p.strEmail, p.strUsuario, r.strNombre from tbl_personas p, tbl_roles r where (p.strRol = r.strCodigo) and (p.strRol != 'D') and (p.intCedula like '%" + strClave + "%') ORDER BY p.intCedula";
                            }
                        }
                        
                        if (strCriterio.equals("NC")){
                            if (strRol.equals("D")){
                                strSQL = "select p.intCedula, p.strNombre, p.strDireccion, p.strTelefono, p.strEmail, p.strUsuario, r.strNombre from tbl_personas p, tbl_roles r where (p.strRol = r.strCodigo) and (p.strNombre like '%" + strClave + "%') ORDER BY p.intCedula";
                            }else{
                                strSQL = "select p.intCedula, p.strNombre, p.strDireccion, p.strTelefono, p.strEmail, p.strUsuario, r.strNombre from tbl_personas p, tbl_roles r where (p.strRol = r.strCodigo) and (p.strRol != 'D') and (p.strNombre like '%" + strClave + "%') ORDER BY p.intCedula";
                            }
                        }
                        
                        if (strCriterio.equals("D")){
                            if (strRol.equals("D")){
                                strSQL = "select p.intCedula, p.strNombre, p.strDireccion, p.strTelefono, p.strEmail, p.strUsuario, r.strNombre from tbl_personas p, tbl_roles r where (p.strRol = r.strCodigo) and (p.strDireccion like '%" + strClave + "%') ORDER BY p.intCedula";
                            }else{
                                strSQL = "select p.intCedula, p.strNombre, p.strDireccion, p.strTelefono, p.strEmail, p.strUsuario, r.strNombre from tbl_personas p, tbl_roles r where (p.strRol = r.strCodigo) and (p.strRol != 'D') and (p.strDireccion like '%" + strClave + "%') ORDER BY p.intCedula";
                            }
                        }
                        
                        if (strCriterio.equals("T")){
                            if (strRol.equals("D")){
                                strSQL = "select p.intCedula, p.strNombre, p.strDireccion, p.strTelefono, p.strEmail, p.strUsuario, r.strNombre from tbl_personas p, tbl_roles r where (p.strRol = r.strCodigo) and (p.strTelefono like '%" + strClave + "%') ORDER BY p.intCedula";
                            }else{
                                strSQL = "select p.intCedula, p.strNombre, p.strDireccion, p.strTelefono, p.strEmail, p.strUsuario, r.strNombre from tbl_personas p, tbl_roles r where (p.strRol = r.strCodigo) and (p.strRol != 'D') and (p.strTelefono like '%" + strClave + "%') ORDER BY p.intCedula";
                            }
                        }
                        
                        if (strCriterio.equals("E")){
                            if (strRol.equals("D")){
                                strSQL = "select p.intCedula, p.strNombre, p.strDireccion, p.strTelefono, p.strEmail, p.strUsuario, r.strNombre from tbl_personas p, tbl_roles r where (p.strRol = r.strCodigo) and (p.strEmail like '%" + strClave + "%') ORDER BY p.intCedula";
                            }else{
                                strSQL = "select p.intCedula, p.strNombre, p.strDireccion, p.strTelefono, p.strEmail, p.strUsuario, r.strNombre from tbl_personas p, tbl_roles r where (p.strRol = r.strCodigo) and (p.strRol != 'D') and (p.strEmail like '%" + strClave + "%') ORDER BY p.intCedula";
                            }
                        }
                        
                        if (strCriterio.equals("UA")){
                            if (strRol.equals("D")){
                                strSQL = "select p.intCedula, p.strNombre, p.strDireccion, p.strTelefono, p.strEmail, p.strUsuario, r.strNombre from tbl_personas p, tbl_roles r where (p.strRol = r.strCodigo) and (p.strUsuario like '%" + strClave + "%') ORDER BY p.intCedula";
                            }else{
                                strSQL = "select p.intCedula, p.strNombre, p.strDireccion, p.strTelefono, p.strEmail, p.strUsuario, r.strNombre from tbl_personas p, tbl_roles r where (p.strRol = r.strCodigo) and (p.strRol != 'D') and (p.strUsuario like '%" + strClave + "%') ORDER BY p.intCedula";
                            }
                        }
                        
                        if (strCriterio.equals("R")){
                            if (strRol.equals("D")){
                                strSQL = "select p.intCedula, p.strNombre, p.strDireccion, p.strTelefono, p.strEmail, p.strUsuario, r.strNombre from tbl_personas p, tbl_roles r where (p.strRol = r.strCodigo) and (r.strNombre like '%" + strClave + "%') ORDER BY p.intCedula";
                            }else{
                                strSQL = "select p.intCedula, p.strNombre, p.strDireccion, p.strTelefono, p.strEmail, p.strUsuario, r.strNombre from tbl_personas p, tbl_roles r where (p.strRol = r.strCodigo) and (p.strRol != 'D') and (r.strNombre like '%" + strClave + "%') ORDER BY p.intCedula";
                            }
                        }                        
                    }                
                }
            }             
                       
            Vector arrDatos = GestionSQL.consultaSQL(strSQL,strTipoConsulta);
            
            if (arrDatos == null){            
                out.println("<html>");
                out.println("<head>");                
                out.println("</head>");
                out.println("<body OnKeyPress='return disableKeyPress(event)'>");
                out.println("<div class='TEXTOFALLO'>");
                out.println("No hay registros disponibles para la consulta.");
                out.println("</div>");
                out.println("</body>");
                out.println("</html>");
            }else{             
                out.println("<html>");
                out.println("<head>");                
                out.println("</head>");
                out.println("<body OnKeyPress='return disableKeyPress(event)'>");
                out.println(strBusqueda);
                out.println("<br>");
                out.println("<table cellpadding='5' cellspacing='0' border='0' width='100%' class='TABLARESULT'>");
                out.println("<tr>");
                out.println(strCabecera);
                out.println("</tr>");
                out.println("<tr>");
                out.println(strHTML);
                out.println("</tr>");
                
                String[] strTemp = null;                   
                
                for(int i=0;i<arrDatos.size();i++){
                    strTemp = arrDatos.get(i).toString().split(",");                      
                    out.println("<tr class='FILARESULT'>");                    
                    
                     if (strAccion.equals("consecutivo")){
                        out.println("<td class=\"TEXTORESULT\"><a href=\"#\" onclick=\"abrirFormMuestra('" + strTemp[0] + "')\">" + validarVacio(strTemp[0]) + "</a></td>");
                        out.println("<td class='TEXTORESULT'><a href=\"#\" onclick=\"abrirFormMuestra('" + strTemp[0] + "')\">" + validarVacio(strTemp[1]) + "</a></td>");
                        out.println("<td class='TEXTORESULT'><a href=\"#\" onclick=\"abrirFormMuestra('" + strTemp[0] + "')\">" + validarVacio(strTemp[2]) + "</a></td>");
                        out.println("<td class='TEXTORESULT'><a href=\"#\" onclick=\"abrirFormMuestra('" + strTemp[0] + "')\">" + validarVacio(strTemp[3]) + "</a></td>");
                        out.println("<td class='TEXTORESULT'><a href=\"#\" onclick=\"abrirFormMuestra('" + strTemp[0] + "')\">" + validarVacio(strTemp[4]) + "</a></td>");
                        out.println("<td class='TEXTORESULT'><a href=\"#\" onclick=\"abrirFormMuestra('" + strTemp[0] + "')\">" + validarVacio(strTemp[5]) + "</a></td>");
                        out.println("<td class='TEXTORESULT'><a href=\"#\" onclick=\"abrirFormMuestra('" + strTemp[0] + "')\">" + validarVacio(strTemp[6]) + "</a></td>");
                        out.println("<td class='TEXTORESULT'><input type=\"button\" class=\"BOTONELIMINAR\" onclick=\"eliminarRegistroMuestra('" + strTemp[0] + "')\"></td>");
                     }
                     
                     if (strAccion.equals("enviadas")){
                        out.println("<td class=\"TEXTORESULT\"><a href=\"#\" onclick=\"abrirFormMuestraEnviada('" + strTemp[0] + "')\">" + validarVacio(strTemp[0]) + "</a></td>");
                        out.println("<td class='TEXTORESULT'><a href=\"#\" onclick=\"abrirFormMuestraEnviada('" + strTemp[0] + "')\">" + validarVacio(strTemp[1]) + "</a></td>");
                        out.println("<td class='TEXTORESULT'><a href=\"#\" onclick=\"abrirFormMuestraEnviada('" + strTemp[0] + "')\">" + validarVacio(strTemp[2]) + "</a></td>");
                        out.println("<td class='TEXTORESULT'><a href=\"#\" onclick=\"abrirFormMuestraEnviada('" + strTemp[0] + "')\">" + validarVacio(strTemp[3]) + "</a></td>");
                        out.println("<td class='TEXTORESULT'><a href=\"#\" onclick=\"abrirFormMuestraEnviada('" + strTemp[0] + "')\">" + validarVacio(strTemp[4]) + "</a></td>");
                        out.println("<td class='TEXTORESULT'><a href=\"#\" onclick=\"abrirFormMuestraEnviada('" + strTemp[0] + "')\">" + validarVacio(strTemp[5]) + "</a></td>");
                        out.println("<td class='TEXTORESULT'><a href=\"#\" onclick=\"abrirFormMuestraEnviada('" + strTemp[0] + "')\">" + validarVacio(strTemp[6]) + "</a></td>");
                        out.println("<td class='TEXTORESULT'><input type=\"button\" class=\"BOTONELIMINAR\" onclick=\"eliminarRegistroMuestraEnviada('" + strTemp[0] + "')\"></td>");
                     }
                                                               
                     if (strAccion.equals("nombre")){
                        out.println("<td class=\"TEXTORESULT\"><a href=\"#\" onclick=\"abrirFormMuestra('" + strTemp[6] + "')\">" + validarVacio(strTemp[2]) + "</a></td>");
                        out.println("<td class='TEXTORESULT'><a href=\"#\" onclick=\"abrirFormMuestra('" + strTemp[6] + "')\">" + validarVacio(strTemp[0]) + "</a></td>");
                        out.println("<td class='TEXTORESULT'><a href=\"#\" onclick=\"abrirFormMuestra('" + strTemp[6] + "')\">" + validarVacio(strTemp[1]) + "</a></td>");
                        out.println("<td class='TEXTORESULT'><a href=\"#\" onclick=\"abrirFormMuestra('" + strTemp[6] + "')\">" + validarVacio(strTemp[3])+ "</a></td>");
                        out.println("<td class='TEXTORESULT'><a href=\"#\" onclick=\"abrirFormMuestra('" + strTemp[6] + "')\">" + validarVacio(strTemp[4]) + "</a></td>");
                        out.println("<td class='TEXTORESULT' style='text-align: left;'><a href=\"#\" onclick=\"abrirFormMuestra('" + strTemp[6] + "')\">" + validarVacio(strTemp[5]) + "</a></td>");
                        out.println("<td class='TEXTORESULT'><input type=\"button\" class=\"BOTONELIMINAR\" onclick=\"eliminarRegistroMuestra('" + strTemp[6] + "')\"></td>");
                     }
                     
                     if (strAccion.equals("estado")){
                        out.println("<td class=\"TEXTORESULT\"><a href=\"#\" onclick=\"abrirFormMuestra('" + strTemp[6] + "')\">" + validarVacio(strTemp[3]) + "</a></td>");
                        out.println("<td class='TEXTORESULT'><a href=\"#\" onclick=\"abrirFormMuestra('" + strTemp[6] + "')\">" + validarVacio(strTemp[0]) + "</a></td>");
                        out.println("<td class='TEXTORESULT'><a href=\"#\" onclick=\"abrirFormMuestra('" + strTemp[6] + "')\">" + validarVacio(strTemp[1]) + "</a></td>");
                        out.println("<td class='TEXTORESULT'><a href=\"#\" onclick=\"abrirFormMuestra('" + strTemp[6] + "')\">" + validarVacio(strTemp[2]) + "</a></td>");
                        out.println("<td class='TEXTORESULT'><a href=\"#\" onclick=\"abrirFormMuestra('" + strTemp[6] + "')\">" + validarVacio(strTemp[4]) + "</a></td>");
                        out.println("<td class='TEXTORESULT' style='text-align: left;'><a href=\"#\" onclick=\"abrirFormMuestra('" + strTemp[6] + "')\">" + validarVacio(strTemp[5]) + "</a></td>");
                        out.println("<td class='TEXTORESULT'><input type=\"button\" class=\"BOTONELIMINAR\" onclick=\"eliminarRegistroMuestra('" + strTemp[6] + "')\"></td>");
                     }
                     
                     if (strAccion.equals("fechaRecepcion")){
                        out.println("<td class=\"TEXTORESULT\"><a href=\"#\" onclick=\"abrirFormMuestra('" + strTemp[6] + "')\">" + validarVacio(strTemp[1]) + "</a></td>");
                        out.println("<td class='TEXTORESULT'><a href=\"#\" onclick=\"abrirFormMuestra('" + strTemp[6] + "')\">" + validarVacio(strTemp[0]) + "</a></td>");
                        out.println("<td class='TEXTORESULT'><a href=\"#\" onclick=\"abrirFormMuestra('" + strTemp[6] + "')\">" + validarVacio(strTemp[2]) + "</a></td>");
                        out.println("<td class='TEXTORESULT'><a href=\"#\" onclick=\"abrirFormMuestra('" + strTemp[6] + "')\">" + validarVacio(strTemp[3]) + "</a></td>");
                        out.println("<td class='TEXTORESULT'><a href=\"#\" onclick=\"abrirFormMuestra('" + strTemp[6] + "')\">" + validarVacio(strTemp[4]) + "</a></td>");
                        out.println("<td class='TEXTORESULT' style='text-align: left;'><a href=\"#\" onclick=\"abrirFormMuestra('" + strTemp[6] + "')\">" + validarVacio(strTemp[5]) + "</a></td>");
                        out.println("<td class='TEXTORESULT'><input type=\"button\" class=\"BOTONELIMINAR\" onclick=\"eliminarRegistroMuestra('" + strTemp[6] + "')\"></td>");
                     }
                     
                     if (strAccion.equals("fechaEntrega")){
                        out.println("<td class=\"TEXTORESULT\"><a href=\"#\" onclick=\"abrirFormMuestra('" + strTemp[6] + "')\">" + validarVacio(strTemp[4]) + "</a></td>");
                        out.println("<td class='TEXTORESULT'><a href=\"#\" onclick=\"abrirFormMuestra('" + strTemp[6] + "')\">" + validarVacio(strTemp[0]) + "</a></td>");
                        out.println("<td class='TEXTORESULT'><a href=\"#\" onclick=\"abrirFormMuestra('" + strTemp[6] + "')\">" + validarVacio(strTemp[1]) + "</a></td>");
                        out.println("<td class='TEXTORESULT'><a href=\"#\" onclick=\"abrirFormMuestra('" + strTemp[6] + "')\">" + validarVacio(strTemp[2]) + "</a></td>");
                        out.println("<td class='TEXTORESULT'><a href=\"#\" onclick=\"abrirFormMuestra('" + strTemp[6] + "')\">" + validarVacio(strTemp[3]) + "</a></td>");
                        out.println("<td class='TEXTORESULT' style='text-align: left;'><a href=\"#\" onclick=\"abrirFormMuestra('" + strTemp[6] + "')\">" + validarVacio(strTemp[5]) + "</a></td>");
                        out.println("<td class='TEXTORESULT'><input type=\"button\" class=\"BOTONELIMINAR\" onclick=\"eliminarRegistroMuestra('" + strTemp[6] + "')\"></td>");  
                     }
                     
                     if (strAccion.equals("rol")){
                         out.println("<td class=\"TEXTORESULT\"><a href=\"#\" onclick=\"abrirFormRol('" + strTemp[0] + "')\">" + validarVacio(strTemp[0]) + "</a></td>");
                         out.println("<td class='TEXTORESULT'><a href=\"#\" onclick=\"abrirFormRol('" + strTemp[0] + "')\">" + validarVacio(strTemp[1]) + "</a></td>");
                         if (strRol.equals("D")){
                            out.println("<td class='TEXTORESULT'><input type=\"button\" class=\"BOTONELIMINAR\" onclick=\"eliminarRegistroRol('" + strTemp[0] + "')\"></td>");
                         }
                     }
                     
                     if (strAccion.equals("estados")){
                         out.println("<td class=\"TEXTORESULT\"><a href=\"#\" onclick=\"abrirFormEstado('" + strTemp[0] + "')\">" + validarVacio(strTemp[0]) + "</a></td>");
                         out.println("<td class='TEXTORESULT'><a href=\"#\" onclick=\"abrirFormEstado('" + strTemp[0] + "')\">" + validarVacio(strTemp[1]) + "</a></td>");
                         out.println("<td class='TEXTORESULT'><input type=\"button\" class=\"BOTONELIMINAR\" onclick=\"eliminarRegistroEstado('" + strTemp[0] + "')\"></td>");
                     }
                     
                     if (strAccion.equals("tipo_analisis")){
                         out.println("<td class=\"TEXTORESULT\"><a href=\"#\" onclick=\"abrirFormTipoAnalisis('" + strTemp[0] + "')\">" + validarVacio(strTemp[0]) + "</a></td>");
                         out.println("<td class='TEXTORESULT'><a href=\"#\" onclick=\"abrirFormTipoAnalisis('" + strTemp[0] + "')\">" + validarVacio(strTemp[1]) + "</a></td>");
                         out.println("<td class='TEXTORESULT'><input type=\"button\" class=\"BOTONELIMINAR\" onclick=\"eliminarRegistroTipoAnalisis('" + strTemp[0] + "')\"></td>");
                     }
                                                               
                     if (strAccion.equals("persona")){
                        out.println("<td class=\"TEXTORESULT\"><a href=\"#\" onclick=\"abrirFormPersona('" + strTemp[0] + "')\">" + validarVacio(strTemp[0]) + "</a></td>");
                        out.println("<td class='TEXTORESULT'><a href=\"#\" onclick=\"abrirFormPersona('" + strTemp[0] + "')\">" + validarVacio(strTemp[1]) + "</a></td>");
                        out.println("<td class='TEXTORESULT'><a href=\"#\" onclick=\"abrirFormPersona('" + strTemp[0] + "')\">" + validarVacio(strTemp[2]) + "</a></td>");
                        out.println("<td class='TEXTORESULT'><a href=\"#\" onclick=\"abrirFormPersona('" + strTemp[0] + "')\">" + validarVacio(strTemp[3]) + "</a></td>");
                        out.println("<td class='TEXTORESULT'><a href=\"#\" onclick=\"abrirFormPersona('" + strTemp[0] + "')\">" + validarVacio(strTemp[4]) + "</a></td>");
                        out.println("<td class='TEXTORESULT'><a href=\"#\" onclick=\"abrirFormPersona('" + strTemp[0] + "')\">" + validarVacio(strTemp[5]) + "</a></td>");
                        out.println("<td class='TEXTORESULT'><a href=\"#\" onclick=\"abrirFormPersona('" + strTemp[0] + "')\">" + validarVacio(strTemp[6]) + "</a></td>");
                        out.println("<td class='TEXTORESULT'><input type=\"button\" class=\"BOTONELIMINAR\" onclick=\"eliminarRegistroPersona('" + strTemp[0] + "')\"></td>");
                     }                                        
                    out.println("</tr>");                    
                }                
                out.println("</table>");
                out.println("</body>");
                out.println("</html>");
            }
            
        } finally {            
            out.close();
        }
    }
    
    private String validarVacio(String strValor){
        
        if ((strValor == null) || (strValor.equals("")) || (strValor.equals(" "))){
            return "N/A";
        }else{
            return strValor;
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
