var form;

function cargaBody(){	
        form = document.frmMuestra;        
        var strAccion = form.txtAccion.value;       
        
        if (strAccion == "C"){
            form.txtFechaRecep.value = obtiene_fecha();
        }
	               
}

function limpiarFormMuestra(){	
    
        form.txtConsecutivo.value = "Por asignar";
        form.txtCedula.value = "S";
        form.txtCedula.text = "Seleccione una opción";
        form.txtEstado.value = "S";
        form.txtEstado.text = "Seleccione una opción";
        form.txtFechaEntrega.value = "";
        form.txtFechaRecep.value = obtiene_fecha();
        form.txtUsuarioEntrega.value = "";
        form.txtCantidadMuestras.value = "";
        form.txtTipoAnalisis.value = "S";
        form.txtRespAnalisis.value = "S";
        form.txtEstado.value = "R"
        form.txtFechaEntrega.value = "";        
        form.txtDescripcion.value = "";
        form.txtCostoServicio.value = "";
        form.txtFechaEntregaR.value = "";        
        
        ocultarDIV();
}

function ocultarDIV(){
    document.getElementById("dMensaje").style.display = "none";
}

function validarFormMuestra(){
        
        var strMsg = "";
        var strHead = "Antes de continuar debe diligenciar los siguientes campos:\n\n";
        
        var strTipoMuestra = form.txtTipoMuestra.value;
        
        if (strTipoMuestra == "R"){
        
            strMsg += validarCampoSelect(form.txtCedula,"- Nombre del cliente");
            strMsg += validarCampoVacio(form.txtUsuarioEntrega,"- Usuario que entrega");
            strMsg += validarCampoVacio(form.txtCantidadMuestras,"- Cantidad de muestras");
            strMsg += validarCampoSelect(form.txtTipoAnalisis,"- Tipo de análisis");
            strMsg += validarCampoSelect(form.txtRespAnalisis,"- Responsable del análisis");        
            strMsg += validarCampoSelect(form.txtEstado,"- Estado");
            strMsg += validarCampoVacio(form.txtFechaEntrega,"- Fecha estimada de entrega");

            if (strMsg != ""){
                strMsg = strHead + strMsg;
                alert(strMsg);
                return false;
             }                     
        }
        
        if (strTipoMuestra == "E"){
        
            strMsg += validarCampoSelect(form.txtCedula,"- Nombre del proveedor");
            strMsg += validarCampoVacio(form.txtUsuarioEntrega,"- Usuario que entregó");
            strMsg += validarCampoVacio(form.txtCantidadMuestras,"- Cantidad de muestras");
            strMsg += validarCampoSelect(form.txtTipoAnalisis,"- Tipo de análisis");
            strMsg += validarCampoSelect(form.txtRespAnalisis,"- Responsable del análisis");        
            strMsg += validarCampoSelect(form.txtEstado,"- Estado");
            strMsg += validarCampoVacio(form.txtFechaEntrega,"- Fecha estimada de entrega");

            if (strMsg != ""){
                strMsg = strHead + strMsg;
                alert(strMsg);
                return false;
             }                     
        }
    
    
}

