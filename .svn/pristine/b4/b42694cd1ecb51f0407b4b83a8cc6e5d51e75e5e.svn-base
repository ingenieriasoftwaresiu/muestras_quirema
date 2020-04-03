<%-- 
    Document   : index
    Created on : 16/04/2012, 09:35:00 AM
    Author     : jorge.correa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingreso al Sistema de Muestras</title>
        <link rel="stylesheet" type="text/css" href="Styles/StylesLogin.css" />   
        <link rel="stylesheet" type="text/css" href="Styles/StylesComunes.css" />
        <link rel="SHORTCUT ICON" href="Images/favicon.ico" />
        <script language="JavaScript" type="text/javascript" src="Scripts/JSLogin.js"></script>
        <script language="JavaScript" type="text/javascript" src="Scripts/JSComunes.js"></script>
        <script language="JavaScript" type="text/javascript" src="Scripts/JSAjax.js"></script>        
    </head>
    <body onload="cargaBody()">
    	<div align="center">
                                            <header>
                                                <jsp:include page="header.jsp" />
                                            </header>	
			<div style="padding-top: 80px;"></div>	
			<form id="frmLogin" name="frmLogin" method="POST" action="Ingreso">
				<table cellspacing="0" cellpadding="0" width="280px" class="TABLAFORM">
					<tr>
						<td colspan="2" style="text-align: center;" class="TITULOFORM">INICIO DE SESIÓN</td>				
					</tr>
					<tr>
						<td class="LABELFORM">Usuario:</td>
						<td class="CELDACAMPOFORM"><input type="text" name="txtUsuario" id="txtUsuario" class="CAMPOFORM"></td>
					</tr>
					<tr>
						<td class="LABELFORM">Contraseña:</td>
						<td class="CELDACAMPOFORM"><input type="password" name="txtPwd" id="txtPwd" class="CAMPOFORM"></td>
					</tr>
					<tr>
						<td colspan="2" class="CELDABOTONFORM">
							<input type="submit" value="Ingresar" id="btnIngresar" class="BOTONFORM" onclick="return validarFormLogin()">
							<input type="button" value="Limpiar" id="btnLimpiar" class="BOTONFORM" onclick="limpiarFormLogin()">
						</td>		
					</tr>
				</table>				
			</form>
	</div>
        <br>
        <br>
        <div style="padding-top: 140px;"></div>			
        <footer>
            <jsp:include page="footer.jsp" />     
        </footer>	
    </body>
</html>
