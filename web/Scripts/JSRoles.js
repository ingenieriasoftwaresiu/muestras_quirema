var form;

function cargaBody(){	
        form = document.frmRol;	             
        strAccion = form.txtAccion.value;
        
        if (strAccion == "C"){
            form.txtCodigo.focus();  
        }else{
            form.txtNombre.focus();
        }
}

function limpiarFormRol(){	
	form.txtCodigo.value = "";
        form.txtNombre.value = "";
        
	form.txtCodigo.focus();   
        
        ocultarDIV();
}

function ocultarDIV(){
    document.getElementById("dMensaje").style.display = "none";
}

function validarFormRol(){
        
	var strMsg = "";
	var strHead = "Antes de continuar debe diligenciar los siguientes campos:\n\n";
	
	strMsg += validarCampoVacio(form.txtCodigo,"Código");
        strMsg += validarCampoVacio(form.txtNombre,"Nombre");
	
	if (strMsg != ""){
		strMsg = strHead + strMsg;
		alert(strMsg);
		
                strCodigo = form.txtCodigo.value;
                strNombre = form.txtNombre.value;
                
		if ((strCodigo == "") && (strNombre == "")){
			form.txtCodigo.focus();
		}else{
			if (strCodigo == ""){
				form.txtCodigo.focus();
			}else{
				form.txtNombre.focus();
			}
		}
                
		return false;
	}
        
        strAccion = form.txtAccion.value;
        document.getElementById("dMensaje").style.display = "block";
        getXMLHTTPRequest("Registro?txtForm=" + form.txtForm.value +"&txtCodigo=" + form.txtCodigo.value + "&txtNombre=" + encodeURIComponent(form.txtNombre.value) + "&txtAccion=" + strAccion + "&txtCodigoM=" + form.txtCodigoM.value,"dMensaje");
        
       if (form.txtAccion.value == "C"){
            form.txtCodigo.value = "";
            form.txtNombre.value = "";
            form.txtCodigo.focus();
       }else{
           form.txtNombre.focus();
       }
}