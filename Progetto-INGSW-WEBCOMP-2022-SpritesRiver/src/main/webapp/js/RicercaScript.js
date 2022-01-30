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
					console.log(element.imagePath)
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
					
					var Space = document.createElement('div');
			        Space.classList.add("GameSpace");
			        Space.className = "GameSpace"
			        var Reference = document.createElement('a');
					console.log(element.descrizione)
					Reference.setAttribute("href","goToGamePage?idsioco="+element.id_Sprite)
			        Space.append(Reference)
					Space.append(Reference)
			        var Img = document.createElement('div')
			        Img.classList.add("GameImage")
			        Img.style.backgroundImage = "url("+"'"+element.imagePath+"'"+")"
					console.log(element.imagePath)
			        var Name = document.createElement('div');
			        Name.classList.add("GameName");
			        Name.textContent = element.titolo
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