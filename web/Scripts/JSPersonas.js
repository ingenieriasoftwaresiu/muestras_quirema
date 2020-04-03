var form;

function cargaBody(){	
        form = document.frmPersona;        
        strAccion = form.txtAccion.value;
        
        if (strAccion == "C"){
            form.txtId.focus();  
        }else{
            form.txtNombre.focus();
            document.getElementById("dtxtPasswordC").style.display = "none";
            document.getElementById("dtxtPassword").style.display = "block";            
        }         
}

function limpiarFormPersona(){	
        form.txtId.value = "";
        form.txtNombre.value = "";
        form.txtDireccion.value = "";
        form.txtTelefono.value = "";
        form.txtEmail.value = "";
        form.txtRol.value = "S";
        form.txtRol.text = "Seleccione una opción";
        form.txtUsuario.value = "";
        form.txtPassword.value = "";
        
        form.txtId.focus();       
        
        ocultarDIV();
}

function ocultarDIV(){
    document.getElementById("dMensaje").style.display = "none";
}

function copiarDatos(){
    var id = form.txtId.value;
    
    form.txtUsuario.value = id;
    form.txtPassword.value = id;
}

function validarFormPersona(){
        
        var strMsg = "";
        var strHead = "Antes de continuar debe diligenciar los siguientes campos:\n\n";

        strMsg += validarCampoVacio(form.txtId,"Identificación");
        strMsg += validarCampoVacio(form.txtNombre,"Nombre completo");
        strMsg += validarCampoVacio(form.txtTelefono,"Teléfono");
        strMsg += validarCampoVacio(form.txtEmail,"E-Mail");
        strMsg += validarCampoSelect(form.txtRol,"Rol");        
	
        if (strMsg != ""){
                strMsg = strHead + strMsg;
                alert(strMsg);

                strID = form.txtId.value;
                strNombre = form.txtNombre.value;
                strRol = form.txtRol.value;

                if ((strID == "") && (strNombre == "") && (strRol == "")){
                        form.txtId.focus();
                }else{
                        if (strID == ""){
                                form.txtId.focus();
                        }else{
                                if (strNombre == ""){
                                    form.txtNombre.focus();
                                }else{
                                    form.txtRol.focus();
                                }
                        }
                }

                return false;
        } 
        
        var strDireccion = form.txtDireccion.value;
        
        if (strDireccion != ""){            
            form.txtDireccion.value = deleteSpecialSigns(strDireccion)
        }
        
        document.getElementById("dMensaje").style.display = "block";  
        
        strAccion = form.txtAccion.value;
        getXMLHTTPRequest("Registro?txtForm=" + form.txtForm.value +"&txtId=" + form.txtId.value + "&txtNombre=" + encodeURIComponent(form.txtNombre.value) + "&txtDireccion=" + encodeURIComponent(form.txtDireccion.value) + "&txtTelefono=" + form.txtTelefono.value + "&txtEmail=" + form.txtEmail.value + "&txtRol=" + form.txtRol.value + "&txtUsuario=" + form.txtUsuario.value + "&txtPassword=" + form.txtPassword.value + "&txtAccion=" + strAccion + "&txtCodigoM=" + form.txtCodigoM.value,"dMensaje");
        
        if (form.txtAccion.value == "C"){
            form.txtId.value = "";
            form.txtNombre.value = "";
            form.txtDireccion.value = "";
            form.txtTelefono.value = "";
            form.txtEmail.value = "";
            form.txtRol.value = "S";
            form.txtRol.text = "Seleccione una opción";
            form.txtUsuario.value = "";
            form.txtPassword.value = "";        
            form.txtId.focus();   
        }else{
            form.txtNombre.focus();
        }
}

function ocultarPassword(){
    
    if (form.cbOcultar.checked){
        document.getElementById("dtxtPasswordC").style.display = "block";
        document.getElementById("dtxtPassword").style.display = "none";
    }else{
        document.getElementById("dtxtPasswordC").style.display = "none";
        document.getElementById("dtxtPassword").style.display = "block";
    }
}