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
<title>${nomesprite}</title>
<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
<script src="https://kit.fontawesome.com/5f2af914a2.js" crossorigin="anonymous"></script> 
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<link href="../css/CommonStyle.css" rel="stylesheet" type="text/css">
<link href="../css/SpriteSheet.css" rel="stylesheet" type="text/css">
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
            <div class="search-btn" id="sb">
                <i class="fas fa-search"></i>
            </div>
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
</head>
<body>

<div class="main">

<div class="Background" id="sfondo">

<div class="container"  id="sezione_principale">
	<table class="info-table">
		
		<colgroup>
		<col style="width:114px;">
		<col>
		</colgroup>
	
	<tbody style="margin-left:20px;">
		<tr>
		<td>Titolo</td>
		<td>
		${nomesprite}
		</td>
		</tr>
		<tr>
		<td>Gioco</td>
		<td>
		${gioco}
		</td>
		</tr>
		<tr>
		<td>
		Piattaforma
		</td>
		<td>
		${piattaforma}
		</td>
		</tr>
		<tr>
		<td>
		Data di uscita
		</td>
		<td>
		${data}
		</td>
		</tr>
		<tr>
		<td>
		Genere
		</td>
		<td>
		${genere}
		</td>
		</tr>
		<tr>
		<td>
		Caricato Da
		</td>
		<td>
		${utente}
		</td>
		</tr>
		

	
	</tbody>
	
</table>
</div>
 <div class="container" id="sezione_secondaria">
				
				
					<img alt="Flik" src="${spritesheet}">
				
<div class="container" id="Commenti">

<c:if test="${usernamelogged!=null }">
<div class="container">
	<input  type="text" placeholder="Scrivi commento..." name="commenta" value="" id="commento" style="width:inherit;">
	<button class="button" id="pubblica" >Pubblica</button>
</div>	

</c:if>
<c:if test="${usernamelogged==null }">
<div class="container">
	ACCEDI PER COMMENTARE
</div>
</c:if>
<script>

async function request1(){
	console.log("aiutami")
	$.ajax({

      		url:"getCommenti",
              type:"GET",
              data:{idsprite:${idsprite}},
              success:function (response)
              {
               if(response.length>0)
				{
            	   response.forEach(function(element){
            		   console.log(element)
					var comsec=document.getElementById("Commenti")
					var comm=document.createElement('div')
					comm.classList.add("container")
					comm.className="container"
					comm.id="commento"
					var header=document.createElement('div')
					header.classList.add("container")
					header.className="container"
					header.id="headercommento"
					var namecont=document.createElement('div')
					namecont.setAttribute("style","float:left")
					var name=document.createElement('p')
					name.setAttribute("style","text-decoration:none;color:white;padding-left:10px")
					name.innerText=element.user
					var data=document.createElement('div')
					data.setAttribute("style","float:right ;padding-right:10px")
					data.innerText=element.data.toString();
					namecont.append(name)
					header.append(namecont)
					header.append(data)
					comm.append(header)
					var commtest=document.createElement('div')
					commtest.classList.add("container")
					commtest.className="container"
					commtest.id="testocommento"
					commtest.innerText=element.commento
					comm.append(commtest)
					comsec.append(comm)
            	   })	
				}
               else
               {
            	   
   					var comsec=document.getElementById("Commenti")
   					var comm=document.createElement('div')
   					comm.classList.add("container")
   					comm.className="container"
   					comm.id="commento"
   					comm.innerText="NON CI SONO COMMENTI"
   					comm.setAttribute("style","text-align: center")
   					comsec.append(comm)
               }
				
              },
              fail: function( jqXHR, textStatus ) {
                  alert( "Request failed: " + textStatus );
              }
      		    })}
document.onload=request1()


</script>

</div>
             
</div>

<script type="text/javascript" async defer>
function doCommento(){
    var button=document.getElementById('pubblica')
    button.addEventListener("click",function () {
    	console.log("aiutami")
		request2()
 
    })
    }
async function request2(){
	
    var com=document.getElementById("commento").value
	$.ajax({

      		url:"doCommento",
              type:"POST",
              data:{commento:com,idsprite:${idsprite}},
              success:function (response)
              {console.log("AIUTAMI")
               if(response!=null)
				{console.log("AIUTAMI")
					var comsec=document.getElementById("Commenti")
					var comm=document.createElement('div')
					comm.classList.add("container")
					comm.className="container"
					comm.id="commento"
					var header=document.createElement('div')
					header.classList.add("container")
					header.className="container"
					header.id="headercommento"
					var namecont=document.createElement('div')
					namecont.setAttribute("style","float:left")
					var name=document.createElement('p')
					name.setAttribute("style","text-decoration:none;color:white;padding-left:10px")
					name.innerText="${nomeUtente}"
					var data=document.createElement('div')
					data.setAttribute("style","float:right ;padding-right:10px")
					data.innerText=response.data.toString();
					namecont.append(name)
					header.append(namecont)
					header.append(data)
					comm.append(header)
					var commtest=document.createElement('div')
					commtest.classList.add("container")
					commtest.className="container"
					commtest.id="testocommento"
					commtest.innerText=com
					comm.append(commtest)
					comsec.append(comm)
					var commenta=document.getElementsByName("commenta")[0]
					commenta.value=""
					
				}
				
              },
              fail: function( jqXHR, textStatus ) {
                  alert( "Request failed: " + textStatus );
              }
      		    })
}
doCommento()
</script>
<script async defer>
function doRicerca(){

    var button=document.getElementById("sb")
	button.addEventListener("click", function(event){

		event.preventDefault()
		request3()
	})
}

async function request3(){

var te=document.getElementById("cerca").value
var totsize=0;
$.ajax({
	type:'POST',
	url:"doRicercaGiochi",
	data:{testo:te},
	success:function(response){
		totsize+=response.length
		$('#sezione_secondaria').remove()
		var szp=document.getElementById("sezione_principale")
		 while (szp.firstChild) {
			 szp.removeChild(szp.firstChild);
  			  }
		var GC=document.createElement('div')
		GC.classList.add("game_container")
		GC.className="game_container"
		GC.id="games"
		szp.append(GC)
	
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
doRicerca()
</script>
</body>
</html>