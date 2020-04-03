var form;

function cargaBody(){	
        form = document.frmConsulta;
	form.txtConsecutivo.focus();        
}

function limpiarFormConsulta(){	
        form.txtConsecutivo.value = "";
        form.txtConsecutivo.focus();
        document.getElementById("dResultados").style.display = "none";
        limpiarFormResultado();
}

function limpiarFormResultado(){
    var formR = document.frmResult;
    
    formR.txtConsecutivo.value = "";
    formR.txtCedula.value = "";
    formR.txtFechaRecep.value = "";
    formR.txtFechaEntrega.value = "";
    formR.txtEstado.value = "";
    formR.txtDescripcion.value = "";
    formR.txtNomUsuario.value = "";
}

function validarFormConsulta(){
        
        var strMsg = "";
        var strHead = "Antes de continuar debe diligenciar los siguientes campos:\n\n";

        strMsg += validarCampoVacio(form.txtConsecutivo,"Consecutivo");

        if (strMsg != ""){
                strMsg = strHead + strMsg;
                alert(strMsg);
                form.txtConsecutivo.focus();
                return false;
        }
        document.getElementById("dResultados").style.display = "block";
        
        getXMLHTTPRequest("consulta?txtConsecutivo=" + form.txtConsecutivo.value + "&txtCedula=" + form.txtCedula.value,"dResultados");
}