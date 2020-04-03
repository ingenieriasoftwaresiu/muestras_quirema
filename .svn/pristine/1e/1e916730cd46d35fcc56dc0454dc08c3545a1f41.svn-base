var form;

function cargaBody(){	
        form = document.frmGeneral;	             
        strAccion = form.txtAccion.value;
        
        form.txtConsecutivo.focus();
}

function limpiarFormGeneral(){	
        form.txtConsecutivo.value = "";
        form.txtRutaArchivoPlano.value = "";
        form.txtConsecutivoEnviadas.value = "";
        form.txtNombreServidor.value = "";
        form.txtNumeroPuerto.value = "";
        form.txtUsuario.value = "";
        form.txtPassword.value = "";
        form.txtAsunto.value = "";
            
        form.txtNombreServidor.focus();
        
        ocultarDIV();
}

function ocultarDIV(){
    document.getElementById("dMensaje").style.display = "none";
}

function validarFormGeneral(){
        
        var strMsg = "";
        var strHead = "Antes de continuar debe diligenciar los siguientes campos:\n\n";

        strMsg += validarCampoVacio(form.txtConsecutivo,"Consecutivo recibidas");    
        strMsg += validarCampoVacio(form.txtRutaArchivoPlano,"Ruta archivo plano");    
        strMsg += validarCampoVacio(form.txtConsecutivoEnviadas,"Consecutivo enviadas");
        strMsg += validarCampoVacio(form.txtNombreServidor,"Nombre del servidor");
        strMsg += validarCampoVacio(form.txtUsuario,"Usuario");
        strMsg += validarCampoVacio(form.txtPassword,"Contraseña");
        strMsg += validarCampoVacio(form.txtAsunto,"Asunto del mensaje");
        strMsg += validarCampoVacio(form.txtFirma,"Firma del mensaje");

        if (strMsg != ""){
                strMsg = strHead + strMsg;
                alert(strMsg);           
                
                strConsecutivo = form.txtConsecutivo.value;
                strRutaArchivoPlano = form.txtRutaArchivoPlano.value;
                strConsecutivoEnviadas = form.txtConsecutivoEnviadas.value;
                strNombreServidor = form.txtNombreServidor.value;
                strUsuario = form.txtUsuario.value;
                strPassword = form.txtPassword.value;
                strAsunto = form.txtAsunto.value;
                strFirma = form.txtFirma.value;

               if ((strConsecutivo == "") && (strNombreServidor == "") && (strUsuario == "") && (strPassword == "") && (strAsunto == "") && (strFirma == "")){
                        form.txtConsecutivo.focus();
                }else{
                        if (strConsecutivo == ""){
                            form.txtConsecutivo.focus();
                        }else{
                            if (strNombreServidor == ""){
                                   form.txtNombreServidor.focus();
                            }else{
                                    if (strUsuario == ""){
                                       form.txtUsuario.focus();
                                    }else{
                                        if (strPassword == ""){
                                             form.txtPassword.focus();
                                        }else{
                                            if (strAsunto == ""){
                                                form.txtAsunto.focus();
                                            }else{
                                                form.txtFirma.focus();
                                            }                                        
                                        }                                    
                                    }
                            }
                        }
                }

                return false;
        }
     
        if (form.txtNumeroPuerto.value == ""){   
            form.txtNumeroPuerto.value = "N/A";
        } 
                
        strFirma = form.txtFirma.value.split(/\r\n|\r|\n/);
        var i = 0;
        var strCadenaFirma = "";

        while (i<strFirma.length){
            if ((i+1) == strFirma.length){
                 strCadenaFirma = strCadenaFirma + trim(strFirma[i]);
            }else{
                strCadenaFirma = strCadenaFirma + trim(strFirma[i]) + ";";
            }          
            i++;
        }
                
        strAccion = form.txtAccion.value;
        document.getElementById("dMensaje").style.display = "block";
        getXMLHTTPRequest("Registro?txtForm=" + form.txtForm.value +"&txtConsecutivo=" + form.txtConsecutivo.value  + "&txtRutaArchivoPlano=" + form.txtRutaArchivoPlano.value  + "&txtConsecutivoEnviadas=" + form.txtConsecutivoEnviadas.value  + "&txtNombreServidor=" + form.txtNombreServidor.value + "&txtNumeroPuerto=" + form.txtNumeroPuerto.value + "&txtUsuario=" + form.txtUsuario.value + "&txtPassword=" + form.txtPassword.value + "&txtAsunto=" +encodeURIComponent(form.txtAsunto.value) + "&txtFirma="+ encodeURIComponent(strCadenaFirma) +"&txtAccion=" + strAccion,"dMensaje");

       if (form.txtAccion.value == "C"){
            form.txtConsecutivo.value = "";
            form.txtRutaArchivoPlano.value = "";
            form.txtConsecutivoEnviadas.value = "";
            form.txtNombreServidor.value = "";
            form.txtNumeroPuerto.value = "";
            form.txtUsuario.value = "";
            form.txtPassword.value = "";
            form.txtAsunto.value = "";                
       }
       
       form.txtConsecutivo.focus();
       
}