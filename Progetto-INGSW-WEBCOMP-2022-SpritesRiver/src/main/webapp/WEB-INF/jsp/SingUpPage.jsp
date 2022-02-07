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
<title>Benvenuto in SpritesRiver</title>
</head>
<script defer src="../js/SingUpScript.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link href="../css/CommonStyle.css" rel="stylesheet" type="text/css">
    <link href="../css/SingUp.css" rel="stylesheet" type="text/css">
<body>
<nav class="navbar">

        <div class="nav_container" id="nav">
        	<a href="/" class="nav_logo" id="logo">
        	<img alt="SpritesRiver" src="/images/backgrounds/tumblr_nod0ne1JzZ1t4034jo1_400.gif" id="immagine">
        	<img alt="SpritesRive" src="images/icons/spritesriver text.png">
        	
        	</a>
         </div>
     	
</nav> 
<div class="container" id="Sign-mod">
  <div class="page__additional_sign">
    Benvenuto in SpritesRiver!
  </div>
  <form id="signup-form">
    <div class="input">
      <input class="input__field" type="text" placeholder="Username" value="" name="username" id="user" required>
    </div>
    <div class="input">
      <input class="input__field" type="password" placeholder="Password" value="" name="password" id="psw" required>
    </div>
    <div class="input">
      <input class="input__field" type="email" placeholder="Email"  value="" name="email" id="email"required>
    </div>
    <button class="button button_fill button_medium" type="submit" id="reg">Registrati</button>
  </form>
</div>
</body>
</html>