<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="ISO-8859-1">
<title>Carica la tua Sprite</title>
    <script src="https://apis.google.com/js/platform.js" async defer></script>
     <script defer src="../js/SpriteLoadScript.js"></script>
    <script src="https://apis.google.com/js/platform.js?onload=init" async defer></script>
    <script src="https://kit.fontawesome.com/5f2af914a2.js" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<link href="../css/CommonStyle.css" rel="stylesheet" type="text/css">
    <link href="../css/SettingStyle.css" rel="stylesheet" type="text/css">
</head>
 
<body>
<nav class="navbar">

        <div class="nav_container" id="nav">
        	<a href="/" class="nav_logo" id="logo">
        	<img alt="SpritesRiver" src="/images/backgrounds/tumblr_nod0ne1JzZ1t4034jo1_400.gif" id="immagine">
        	<img alt="SpritesRive" src="images/icons/spritesriver text.png">
        	
        	</a>
         </div>
     	
       
      
</nav> 
<c:if test="${usernamelogged==null}">
                    
    <script>
    console.log("prite")
    document.onload=window.location.href="goToLogin";
    
    </script>
                    
 </c:if>
    <div class="container2" id= "segno"> Carica la tua Sprite! <i class="fas fa-tools fa-lg" id = "icona_impo"></i> </div>
    <div class="container2" id = "main">

            <div class="container" id="dati">
                <ul id = "dati">
                    <li id = "dato">
                        Nome Sprite :
                    </li>

                    
                    <li id = "dato">
                        Nome Gioco :
                    </li>
                  
                   
                </ul>
            </div>
            <div class="container" id="risultati">
                <div class="input">
                    <input class="campo_risultato" type="text" placeholder="Nome Sprite" name="nomepersonaggio" value="" id=nomepersonaggio>
                </div>
                
                <div class="input">
                    <input class="campo_risultato" type="text" placeholder="Nome Gioco" name="nomegioco" value="" id="nomegioco">
                </div>
                <div class="input">
                    
 						 <label for="birthday">Data di Rilascio Gioco:</label>
 						<input type="date" id="data" name="data"><br><br>
 						
					
                </div>
                <div class="input">
                    
 								 <label for="myfile">Scegli l'immagine del Personaggio:</label>
 								 <input type="file" id="immaginepersonaggio" name="immaginepersonaggio"><br><br>
								 
					
                </div>
                 <div class="input">
                    
 								 <label for="myfile">Scegli SpriteSheet:</label>
 								 <input type="file" id="spritesheet" name="spritesheet"><br><br>
								<button class="button"  id="save">Salva</button>				 
					
                </div>
                
                
            </div>
</body>
</html>