<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Impostazioni</title>
</head>
<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
<link href="../css/CommonStyle.css" rel="stylesheet" type="text/css">
    <link href="../css/SettingStyle.css" rel="stylesheet" type="text/css">
<body>
<nav class="navbar">

        <div class="nav_container" id="nav">
        	<a href="/" class="nav_logo" id="logo">
        	<img alt="SpritesRiver" src="/images/backgrounds/tumblr_nod0ne1JzZ1t4034jo1_400.gif" id="immagine">
        	<img alt="SpritesRive" src="images/icons/spritesriver text.png">
        	
        	</a>
         </div>
     	
      
</nav> 
 <div class="main">
       <c:if test="${usernamelogged==null}">
                    
    <script>
    
    document.onload=window.location.href="goToLogin";
    
    </script>
                    
 </c:if>
        
    </div>
    <div class="container2" id= "segno"> Impostazioni <i class="fas fa-tools fa-lg" id = "icona_impo"></i> </div>
    <div class="container2" id = "main">

            <div class="container" id="dati">
                <ul id = "dati">
                    <li id = "dato">
                        Username :
                    </li>

                    <li id = "dato">
                        Password :
                    </li>
                    <li id = "dato">
                        Conferma Password :
                    </li>
                    <li id = "dato">
                        Email :
                    </li>
                </ul>
            </div>
            <div class="container" id="risultati">
                <div class="input">
                    <input class="campo_risultato" type="text" placeholder="Username" name="username" value="" id="username">
                </div>
                <div class="input">
                    <input class="campo_risultato" type="password" placeholder="Password" name="username" value="" id="password">
                </div>
                <div class="input">
                    <input class="campo_risultato" type="password" placeholder="Conferma Password" name="username" value="" id="confermaPassword">
                </div>
                <div class="input">
                    <input class="campo_risultato" type="email" placeholder="Email" name="username" value="" id="email" >
                </div>
                <div class="button"  id="save">Salva</div>
            </div>
            <script type="text/javascript" async defer>
            var button=document.getElementById("save")

            button.addEventListener("click", function (){
                request()
            })

            async function request()
            {
                    var user=document.getElementById("username").value
                    var password=document.getElementById("password").value
                    var confPassword=document.getElementById("confermaPassword").value
                    var email=document.getElementById("email").value
            		var regexEmail= /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/

            		if(!regexEmail.test(email) && email!==""){
            			alert("L'email inserita non e' corretta!")
            			return
            		}
            		if(password !== confPassword) {
            			alert("Le due password inserite non coincidono")
            			return
            		}
            		if(password.length < 5 && password!==""){
            			alert("La nuova password deve contenere almeno 5 caratteri")
            			return
            		}
            	    $.ajax({
            	        url:"doModificheAccount",
            	        type:"POST",
            	            data:{username:user, password:password, email:email},
            	            success:function(response){
            	                    if(response==="Modifiche effettuate con successo") {
            	                        alert("Modifiche effettuate con successo")
            							window.location.href="/"
            	                    }
            		                else if(response==="Email e username gia' esistenti") {
            			                alert("Email e username gia' esistenti")
            			            }
            						else if(response==="Username gia' esistente") {
            							alert("Username gia' esistente")
            						}
            						else if(response==="Email gia' esistente"){
            							alert("Email gia' esistente")
            						}
            						else {
            							alert("La nuova password e' uguale a quella precedente")
            						}
            	            },
            	        	fail: function( jqXHR, textStatus ) {
            	            	alert( "Request failed: " + textStatus );
            	        	}
            	        });
            }
            </script>
</body>
</html>