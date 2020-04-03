var url;
var id;

function getXMLHTTPRequest(strUrl,strId){    
    try{
        req = new XMLHttpRequest();
    }catch(err1){
        try{
            req = new ActiveXObject("Msxml2.XMLHTPP");
        }catch(err2){
            try{
                req = new ActiveXObject("Microsoft.XMLHTPP");
            }catch(err3){
                req = false;
            }
        }	
    }    
    
    if (req != ""){         
        url = strUrl;
        id = strId;

        req.onreadystatechange = procesarRespuesta;
        req.open("POST",url,true);       
        req.send(null);       

    }
}

function procesarRespuesta(){   
    contenido = document.getElementById(id);   

    if (req.readyState==4 && req.status==200){        
        contenido.innerHTML = req.responseText;        
    }   
}