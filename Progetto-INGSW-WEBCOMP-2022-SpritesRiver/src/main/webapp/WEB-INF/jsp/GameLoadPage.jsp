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
<title>Carica Gioco</title>
<script src="https://apis.google.com/js/platform.js" async defer></script>
     <script defer src="../js/GameLoadPage.js"></script>
    <script src="https://apis.google.com/js/platform.js?onload=init" async defer></script>
    <script src="https://kit.fontawesome.com/5f2af914a2.js" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.js"></script>

   
</head>
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

<c:if test="${usernamelogged==null}">
                    
    <script>
    console.log("gioco")
    document.onload=window.location.href="goToLogin";
    
    </script>
                    
 </c:if>
 
    <div class="container2" id= "segno">Aggiungi Gioco <i class="fas fa-tools fa-lg" id = "icona_impo"></i> </div>
    <div class="container2" id = "main">

            <div class="container" id="dati">
                <ul id = "dati">
                    <li id = "dato">
                        Titolo :
                    </li>

                    
                    <li id = "dato">
                        Genere :
                    </li>
                    
                    <li id = "dato">
                        Piattaforma:
                    </li>
                    <li id = "dato">
                        Descrizione:
                    </li>
                    <li id = "dato">
                        Percorso immagine
                    </li>
                  
                   
                </ul>
            </div>
            <div class="container" id="risultati">
           
                <div class="input">
                    <input class="campo_risultato"  type="text"  placeholder="Titolo" name="titolo" value="" id="titolo" required>
                </div>
                
                <div class="input">
                    <input class="campo_risultato" type="text"  placeholder="Genere" name="genere"  value="" id="genere" required>
                </div>
                 <div class="input">
                    <input class="campo_risultato" type="text"  placeholder="Piattaforma" name="piattaforma" value="" id="piattaforma" required>
                </div>
                <div class="input">
                    <input class="campo_risultato" type="text"  placeholder="Descrizione" name="descrizione" value="" id="descrizione" required>
                </div>
                <div class="input">
                   
 						 <label for="birthday">Data di Rilascio:</label>
 						<input type="date" id="data" name="data" required><br><br>
 						
					
                </div>
                <div class="input">
                    
 								 <label for="myfile">Scegli l'immagine :</label>
 								 <input type="file" id="immagine" name="immagine" required ><br><br>
								<button class="button"  id="save" >Salva</button> 	
                </div>
                
                
                
                
            </div>
</body>
</html>