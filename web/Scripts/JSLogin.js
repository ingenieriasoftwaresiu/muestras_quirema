var form;

function cargaBody(){		
        form = document.frmLogin;
	form.txtUsuario.focus();
}


function limpiarFormLogin(){	
	form.txtUsuario.value = "";
	form.txtPwd.value = "";	
	form.txtUsuario.focus();
}

function validarFormLogin(){
        
	var strMsg = "";
	var strHead = "Antes de continuar debe diligenciar los siguientes campos:\n\n";
	
	strMsg += validarCampoVacio(form.txtUsuario,"Usuario");
	strMsg += validarCampoVacio(form.txtPwd,"Contraseña");
	
	if (strMsg != ""){
		strMsg = strHead + strMsg;
		alert(strMsg);
		
                strUsuario = form.txtUsuario.value;
                strPwd = form.txtPwd.value;
                
		if ((strUsuario == "") && (strPwd == "")){
			form.txtUsuario.focus();
		}else{
			if (strUsuario == ""){
				form.txtUsuario.focus();
			}else{
				form.txtPwd.focus();
			}
		}		
		return false;
	}	
        return true;      
}