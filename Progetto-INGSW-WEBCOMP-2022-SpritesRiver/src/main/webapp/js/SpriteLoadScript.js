function doLoadSprite(){
    var buttonLogin=document.getElementById("save")
    buttonLogin.addEventListener("click",function () {
		event.preventDefault()
		request()

    })

}

async function request(){
	var formData= new FormData()
    var nomesprite=document.getElementById("nomepersonaggio").value
    formData.append("nomepersonaggio",nomesprite)
	var ngioco=document.getElementById("nomegioco").value
    formData.append("nomegioco",ngioco)
	var datarilascio=document.getElementById("data").value
    formData.append("data",datarilascio)
	var ipersonaggio=document.getElementsByName("immaginepersonaggio")[0].files[0]
	formData.append("immaginepersonaggio",ipersonaggio)    
	var sheet=document.getElementsByName("spritesheet")[0].files[0]
    formData.append("spritesheet",sheet)
	$.ajax({
        url:"doSprite",
        type:"POST",
        data:formData,
		processData: false,
    	contentType: false,
        success:function (response)
        {
            if (response==true)
            {
                window.location.href="goToGamePageS?titolo="+ngioco+"&data="+datarilascio
            }
            else if(response==false)
            {
                
				alert("Gioco non presente nell'archivio,aggiugnilo")
                window.location.href="goToGameLoad"
            }
        },
        fail: function( jqXHR, textStatus ) {
            alert( "Request failed: " + textStatus );
        }
    });
}
document.onload=doLoadSprite()