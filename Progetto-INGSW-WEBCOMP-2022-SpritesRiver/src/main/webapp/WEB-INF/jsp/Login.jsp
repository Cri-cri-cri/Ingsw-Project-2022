<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SpritesRiver-Login</title>
</head>
<link href="../css/CommonStyle.css" rel="stylesheet" type="text/css">
    <link href="../css/SingUp.css" rel="stylesheet" type="text/css">
    <meta name="google-signin-scope" content="profile email">
    <meta name="google-signin-client_id" content="98707488730-ammo9gtj9eet510bvilg7uh4sue1jocv.apps.googleusercontent.com">
    <script src="https://apis.google.com/js/platform.js" async defer></script>

    <!-- Optional JavaScript -->
    <script defer src="../js/LoginScript.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"> type="text/javascript"</script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<body>
<nav class="navbar">

        <div class="nav_container" id="nav">
        	<a href="/" class="nav_logo" id="logo">
        	<img alt="SpritesRiver" src="/images/backgrounds/tumblr_nod0ne1JzZ1t4034jo1_400.gif" id="immagine">
        	<img alt="SpritesRive" src="images/icons/spritesriver text.png">
        	
        	</a>
         </div>
     
</nav> 
<div class="container" id="Log-mod">
        <form id="login-form">
            <div class="input">
                <input class="input__field" type="text" placeholder="Username" name="username" value="" id="user" required>

            </div>
            <div class="input">
                <input class="input__field" type="password" placeholder="Password" name="password" value="" id="psw" required>
            </div>
            <button class="button button_fill button_medium" type="submit" id="login">Login</button>
        </form>
        
            <div class="page__additional">
                <div class="g-signin2" data-onsuccess="onSignIn" data-theme="dark" id = "google-log"></div>
       
        </div>
    </div>
</body>
</html>