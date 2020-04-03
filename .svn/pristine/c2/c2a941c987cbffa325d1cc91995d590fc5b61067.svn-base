function validarCampoVacio(campo,nombre){
	
	if (campo.value == ""){
		return nombre + "\n";
	}	
	return "";	
}

function validarCampoSelect(campo,nombre){
    if (campo.selectedIndex == 0){
        return nombre + "\n";
    }
    return "";
}

function cerrarSesion(){
    window.location = "cerrar.jsp";
}

function obtiene_fecha() {  
      
    var fecha_actual = new Date()  
  
    var dia = fecha_actual.getDate();  
    var mes = fecha_actual.getMonth() + 1;
    var anio = fecha_actual.getFullYear();  
  
    if (mes < 10)  
        mes = '0' + mes;  
  
    if (dia < 10)  
        dia = '0' + dia; 
  
    return (anio + "-" + mes + "-" + dia);
}

function setCalendario(campo,imagen){
    Calendar.setup({
        inputField: campo,
        ifFormat: "%Y-%m-%d",
        button: imagen,
        align: "TI",
        singleClick: true
    });
}

function cargarCalendarios(){
    setCalendario("txtFechaRecep","imgFechaRecep");
    setCalendario("txtFechaEntrega","imgFechaEstimada");
    setCalendario("txtFechaEntregaR","imgFechaEntregaR");
}

function deleteSpecialSigns(strCadena){   
    
    strCadena = strCadena.replace("#","N°");   
    
    return strCadena;
    
}

function trim(strCadena){
    
    return strCadena.replace(/^\s+/g,'').replace(/\s+$/g,'');
}

function descargarArchivo(strRuta){    
    while(strRuta.indexOf("/") != -1){
        strRuta = strRuta.replace("/","\\");
    }    
    
    window.open("Descargar.jsp?txtRuta=" + strRuta);    
}

