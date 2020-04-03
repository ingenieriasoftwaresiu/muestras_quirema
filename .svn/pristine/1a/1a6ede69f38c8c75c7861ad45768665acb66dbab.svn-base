<%-- 
    Document   : cerrar
    Created on : 18/04/2012, 11:07:33 AM
    Author     : jorge.correa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    session.invalidate();
%>

<html>
    <head>
        <META HTTP-EQUIV='Refresh' content='5;url=index.jsp'>
        <link rel="SHORTCUT ICON" href="Images/favicon.ico" />
        <link rel='stylesheet' type='text/css' href='Styles/StylesCierre.css'/> 
        <link rel='stylesheet' type='text/css' href='Styles/StylesComunes.css'/>
        <title>Sesión finalizada</title>
        <script type="text/javascript">            
            document.onkeydown= function(evt) {         
                if (!evt){
                    evt = event;
                }
                           
                if ((evt.keyCode == 116) || (evt.which == 8) || (evt.ctrlKey && evt.keyCode == 116)){   
                    evt.preventDefault();
                }                                
            }
            
           $(function(){
                var rx = /INPUT|SELECT|TEXTAREA/i;

                $(document).bind("keydown keypress", function(e){
                    if(e.which == 8){ // 8 == backspace
                        if(!rx.test(e.target.tagName) || e.target.disabled || e.target.readOnly ){
                            e.preventDefault();
                        }
                    }
                });
            });
        </script>
    </head>
    <body>
        <div align='center'>
            <header>
                <jsp:include page="header.jsp" />
            </header>
        </div>               
        <div class='TEXTOCIERRE'>
            Ha abandonado la sesión, para ingresar de nuevo presione <a href="index.jsp">aquí</a>.
        </div
        <br><br><br><br><br><br><br><br><br><br><br>
        <footer>
            <jsp:include page="footer.jsp" />     
        </footer>  
    </body>
</html>
           


