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
  <link href="../css/CommonStyle.css" rel="stylesheet" type="text/css">
<title>${titolo}</title>
<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
    <script src="https://apis.google.com/js/platform.js" async defer></script>
    <script src="https://apis.google.com/js/platform.js?onload=init" async defer></script>
    <script src="https://kit.fontawesome.com/5f2af914a2.js" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"> type="text/javascript"</script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
 
</head>
<body>
<nav class="navbar">

        <div class="nav_container" id="nav">
        	<a href="/" class="nav_logo" id="logo">
        	<img alt="SpritesRiver" src="/images/backgrounds/tumblr_nod0ne1JzZ1t4034jo1_400.gif" id="immagine">
        	<img alt="SpritesRive" src="images/icons/spritesriver text.png">
        	
        	</a>
         </div>
     	
        
        <div class="nav_container">
        	<a href="goToSpriteLoad" class="nav_logo" id="anima">
        		
        	</a>
         </div>    
       
         <div class="search-bar" id = "ricerca">
            <input class="input__field" type="search" placeholder="Cerca.." name="cerca" value="" id="cerca">
            <a class="search-btn" id="sb">
                <i class="fas fa-search"></i>
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
 <div class="main">
        <!--Image Section-->

   	<div class="Background" id="sfondo" >
   				
        
		 
		 <div class="container" id="GodT">
		 	${titolo}
		 </div>
       
        <div class="container" id="sezione_principale">
		
            <div class="container" id="foto" >
            
                   
            <img alt="" src="${immagine}">
					
					            
            </div>
            <div class="container" id="year">
            	Data di uscita ${data}<br>
            	Piattaforma ${piattaforma}<br>
            	Genere ${genere}
            </div>
            <div class="container" id="info">
               ${descrizione}
            </div>

        </div>        
		
         <div class="container" id="sezione_secondaria">
				<div class="game_container" id="games">
				
            		
        </div>           
        </div>
              
        </div>  
    </div>
         
  <script language ="JavaScript" type ="text/JavaScript">
				<c:if test="${sprites==null}">
				var GameContainer=document.getElementById("games")	
				GameContainer.innerText="QUESTO GIOCO NON HA ANCORA NESSUNO SPRITE CARICATO"
				</c:if>
				<c:if test="${sprites!=null}">
				<c:forEach var="sptr" items="${sprites}">
				
				    var GameContainer=document.getElementById("games")
			        var Space = document.createElement('div');
			        Space.classList.add("GameSpace");
			        Space.className = "GameSpace"
			        var Reference = document.createElement('a');
			        Reference.setAttribute("href","goToSpritePage?idsprite="+"${sptr.getID_Sprite()}")
			        Space.append(Reference)
			        var Img = document.createElement('div')
			        Img.classList.add("GameImage")
			        Img.style.backgroundImage = "url('${sptr.getImmaginePersonaggio()}')"
			        var Name = document.createElement('div');
			        Name.classList.add("GameName");
			        Name.textContent = "${sptr.getPersonaggio()}"
			        Reference.append(Img);
			        Space.append(Name);
			        GameContainer.append(Space);
			    	    
				
				</c:forEach>
				
				</c:if>
</script>
<script async defer>
function doRicerca(){

    var button=document.getElementById("sb")
	button.addEventListener("click", function(event){

		event.preventDefault()
		request()
	})
}

async function request(){

var te=document.getElementById("cerca").value
var totsize=0;
$.ajax({
	type:'POST',
	url:"doRicercaGiochi",
	data:{testo:te},
	success:function(response){
		totsize+=response.length
		$('#GoD').remove()
		$('#GodT').remove()
		$('#sezione_principale').remove()
		var GC=document.getElementById("games")
		 while (GC.firstChild) {
        		GC.removeChild(GC.firstChild);
  			  }
	
		response.forEach(function(element){
					if(totsize>0){
					var Space = document.createElement('div');
			        Space.classList.add("GameSpace");
			        Space.className = "GameSpace"
			        var Reference = document.createElement('a');
					console.log(element.descrizione)
					Reference.setAttribute("href","goToGamePage?idgioco="+element.id_Gioco)
			        Space.append(Reference)
					Space.append(Reference)
			        var Img = document.createElement('div')
			        Img.classList.add("GameImage")
			        Img.style.backgroundImage = "url("+"'"+element.imagePath+"'"+")"
			        var Name = document.createElement('div');
			        Name.classList.add("GameName");
			        Name.textContent = element.titolo
			        Reference.append(Img);
			        Space.append(Name);
			        GC.append(Space);
		
			}
			}
		)
		
	
	
	},
	fail: function(){
	
		alert:"ricerca fallita"
	}



});
$.ajax({
	type:'POST',
	url:"doRicercaSprite",
	data:{testo:te},
	success:function(response){
		totsize+=response.length
	    if(totsize>0){
		response.forEach(function(element){
					console.log(element)
			var GC=document.getElementById("games")
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
        	GC.textContent="LA RICERCA NON HA PRODOTTO RISULTATI"
        }
		
	
	
	},
	fail: function(){
	
		alert:"ricerca fallita"
	}



});
}
$( document ).ready(doRicerca());
</script>
</body>
</html>