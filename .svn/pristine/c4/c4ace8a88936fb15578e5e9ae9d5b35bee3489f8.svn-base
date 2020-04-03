function abrirFormMuestra(strCodigo){
    window.open("muestra.jsp?txtTipoMuestra=R&txtAccion=V&txtCodigo=" + strCodigo,"Muestra","width=1250px,height=800px");
}

function abrirFormMuestraEnviada(strCodigo){
    window.open("muestra.jsp?txtTipoMuestra=E&txtAccion=V&txtCodigo=" + strCodigo,"Muestra","width=1250px,height=800px");
}

function abrirFormRol(strCodigo){
    window.open("rol.jsp?txtAccion=V&txtCodigo=" + strCodigo,"Rol","width=1250px,height=800px");
}

function abrirFormEstado(strCodigo){
    window.open("estado.jsp?txtAccion=V&txtCodigo=" + strCodigo,"Estado","width=1250px,height=800px");
}

function abrirFormTipoAnalisis(strCodigo){
    window.open("tipoAnalisis.jsp?txtAccion=V&txtCodigo=" + strCodigo,"Estado","width=1250px,height=800px");
}

function abrirFormPersona(strCodigo){
    window.open("persona.jsp?txtAccion=V&txtCodigo=" + strCodigo,"Persona","width=1250px,height=800px");
}

function eliminarRegistroMuestra(strCodigo){
        
    if (confirm('¿Está seguro que desea eliminar el registro seleccionado?')){    
        getXMLHTTPRequest("Registro?txtForm=frmMuestra&txtTipoMuestra=R&txtAccion=E&txtCodigoM=" + strCodigo,"dMostrar");            
   }
}

function eliminarRegistroMuestraEnviada(strCodigo){
        
    if (confirm('¿Está seguro que desea eliminar el registro seleccionado?')){    
        getXMLHTTPRequest("Registro?txtForm=frmMuestra&txtTipoMuestra=E&txtAccion=E&txtCodigoM=" + strCodigo,"dMostrar");            
   }
}

function eliminarRegistroRol(strCodigo){
        
    if (confirm('¿Está seguro que desea eliminar el registro seleccionado?')){    
        getXMLHTTPRequest("Registro?txtForm=frmRol&txtAccion=E&txtCodigoM=" + strCodigo,"dMostrar");            
   }
}

function eliminarRegistroEstado(strCodigo){
        
    if (confirm('¿Está seguro que desea eliminar el registro seleccionado?')){    
        getXMLHTTPRequest("Registro?txtForm=frmEstado&txtAccion=E&txtCodigoM=" + strCodigo,"dMostrar");            
   }
}

function eliminarRegistroTipoAnalisis(strCodigo){
        
    if (confirm('¿Está seguro que desea eliminar el registro seleccionado?')){    
        getXMLHTTPRequest("Registro?txtForm=frmTipoAnalisis&txtAccion=E&txtCodigoM=" + strCodigo,"dMostrar");            
   }
}

function eliminarRegistroPersona(strCodigo){
        
    if (confirm('¿Está seguro que desea eliminar el registro seleccionado?')){    
        getXMLHTTPRequest("Registro?txtForm=frmPersona&txtAccion=E&txtCodigoM=" + strCodigo,"dMostrar");            
   }
}

function buscarRegistro(strAccion){
    form = document.frmBusqueda;  

    var strMsg = "";
    var strHead = "Antes de continuar debe diligenciar los siguientes campos:\n\n";
	
    strMsg += validarCampoSelect(form.txtCriterio,"Criterio");
    strMsg += validarCampoVacio(form.txtClave,"Clave");
    
    if (strMsg != ""){
        strMsg = strHead + strMsg;
        alert(strMsg);

        strCriterio = form.txtCriterio;
        strClave = form.txtClave.value;                

        if ((strCriterio.selectedIndex == 0) && (strClave == "")){
                form.txtCriterio.focus();
        }else{
                if (strCriterio.selectedIndex == 0){
                        form.txtCriterio.focus();
                }else{
                        form.txtClave.focus();
                }
        }

        return false;
      }
      getXMLHTTPRequest('Visualizacion?txtAccion=' + strAccion + '&txtEvento=busqueda&txtCriterio=' + form.txtCriterio.value + '&txtClave=' + form.txtClave.value,'dMostrar');
}

function onLoadBody(){
    getXMLHTTPRequest('Visualizacion?txtAccion=consecutivo','dMostrar');
}

function generarArchivoPlanoContrato(){    
    if(confirm('¿Está seguro que desea generar el archivo plano de muestras?')){
        
        var elemento = document.getElementById("dMostrar");
        var strLoad = "";
                
        strLoad = strLoad + "<div align='center' class='TEXTOEXITO'>";        
        strLoad = strLoad + "<img src='Images/loader.gif' style='vertical-align: middle;' />&nbsp;&nbsp;Generando archivo...";
        strLoad = strLoad + "</div>";
        elemento.innerHTML = strLoad;
        
        getXMLHTTPRequest("ArchivoPlanoMuestras","dMostrar");  
    }
}