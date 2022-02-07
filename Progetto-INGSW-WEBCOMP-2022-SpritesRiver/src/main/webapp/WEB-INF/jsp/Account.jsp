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
<title>Account</title>
<link href="../css/CommonStyle.css" rel="stylesheet" type="text/css">
  <link href="../css/AccountStyle.css" rel="stylesheet" type="text/css">
  <script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
    <script src="https://apis.google.com/js/platform.js" async defer></script>
    <script src="https://apis.google.com/js/platform.js?onload=init" async defer></script>
    <script src="https://kit.fontawesome.com/5f2af914a2.js" crossorigin="anonymous"></script> 
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
</head>
<body>
<nav class="navbar">

        <div class="nav_container" id="nav">
        	<a href="/" class="nav_logo" id="logo">
        	<img alt="SpritesRiver" src="/images/backgrounds/tumblr_nod0ne1JzZ1t4034jo1_400.gif" id="immagine">
        	<img alt="SpritesRive" src="images/icons/spritesriver text.png">
        	
        	</a>
         </div>
     	
        <c:if test="${usernamelogged==null}">
                    
    <div class="account-buttons">
            <a  href="goToLogin">
            <button  id="login">
                     
            </button>
            </a>
            <a  href="goToRegistrazione">
            <button  id="registrati">
                  
            </button>
            </a>
    </div>
                    
 </c:if>
 <c:if test="${usernamelogged!=null}">
                    
    <div class="account-buttons">
            <a  href="doAccount">
            <button  id="account">
                     
            </button>
            </a>
            <a  href="doLogout">
            <button  id="logout">
                  
            </button>
            </a>
    </div>
                    
 </c:if>
</nav> 
 <c:if test="${usernamelogged==null}">
                    
    <script>
    
    document.onload=window.location.href="goToLogin";
    
    </script>
                    
 </c:if>

<div class="main">
    <!--Image Section-->
 

    <div class="Background" id="sfondo" >

        <div class="container" id="user">
            <div class="name">
                <p id = "nome_utente">Ciao ${username}</p>
            </div>
            <div id="settings">
                <button class="button" onclick="window.location.href='doImpostazioni'" id="settaggi">Impostazioni<i class="fas fa-cog" id = "set-ico"></i></button>
            </div>
        </div>
        
        <div class= "container" id ="button-bar">
            <div class="accountbutton">
                <button class="button"  id="liblista">Sprite</button>
            </div>
            </div>

        <div class="container" id="sezione_secondaria">
        <div class="game_container" id="games">
        </div>
        </div>
    </div>
</div>
<script async defer>

async function request(){
	clean()
	$.ajax({
	         type:'POST',
	         url:"doRicercaSpriteUtente",
	         data:{idaccount:${idutente}},
	         success:function(response){
	              if(response.length>0){
	                 response.forEach(function(element){
	                	
	                	 
	                   var GC=document.getElementById('games')
	                   var Space = document.createElement('div');
	                   Space.classList.add("GameSpace");
	                   Space.className = "GameSpace"
	                   var Reference = document.createElement('a');
	                	Reference.setAttribute("href","goToSpritePage?idsprite="+element.id_Sprite)
	                	Space.append(Reference)
	                   		Space.append(Reference)
	                   			        var Img = document.createElement('div')
	                   			        Img.classList.add("GameImage")
	                   			        Img.style.backgroundImage = "url("+"'"+element.immaginePersonaggio+"'"+")"
	                   			        var Name = document.createElement('div');
	                   			        Name.classList.add("GameName");
	                   			        Name.textContent = element.personaggio
	                   			        Reference.append(Img);
	                   			        Space.append(Name);
	                   			        GC.append(Space);

	                   			}


	                   		)
	                   		}
	                           else
	                           {
	                           	console.log("Eccomi")
	                   			var GC=document.getElementById("games")
	                           	GC.textContent="ANCORA NESSUNO SPRITE CARICATO"
	                           }



	                   	},
	                   	fail: function(){

	                   		alert:"ricerca fallita"
	                   	}
				 });

}
function clean(){
	
	var GC=document.getElementById("games")
    if(GC.firstChild == null){
        GC.innerText = "";
    }
        
    while (GC.firstChild) {
        GC.removeChild(GC.firstChild);
    }
	
}
document.onload=request();
   </script>
</body>
</html>