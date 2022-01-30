function doLoadGame(){
    var buttonLogin=document.getElementById("save")
    buttonLogin.addEventListener("click",function () {

	
		request()

    })

}

async function request(){
var formData= new FormData()
    var tit=document.getElementById("titolo").value
    formData.append("titolo",tit)
    var gnr=document.getElementById("genere").value
    formData.append("genere",gnr)
    var ptf=document.getElementById("piattaforma").value
    formData.append("piattaforma",ptf)
    var dt=document.getElementById("data").value
	formData.append("data",dt)
	var dscr=document.getElementById("descrizione").value
	formData.append("descrizione",dscr)
	var img=document.getElementsByName("immagine")[0].files[0]
	formData.append("immagine",img)
	  $.ajax({

      		url:"doGioco",
              type:"POST",
              data:formData,
			   processData: false,
    			contentType: false,
              success:function (response)
              {
               if (response=="aggiunto")
				{
					
					alert("Gioco aggiunto correttamente")
					
					window.location.href="goToGamePageL?titolo="+tit+"&genere="+gnr+"&piattaforma="+ptf+"&descrizione="+dscr+"&data="+dt+"&immagine=../images/GameImages/"+img.name
				}
				if(response=="presente")
				{
				 alert("Gioco gia presnete nell'archivio")
					window.location.reload()
				}
				if(response=="fallito")
				{
				 alert("Qualcosa è andato storto")
				window.location.reload()
				}
				
              },
              fail: function( jqXHR, textStatus ) {
                  alert( "Request failed: " + textStatus );
              }
      		    })
}
document.onload=doLoadGame()
    