<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/TechWorldAdmin/URLToReachResourcesFolder/css/Login.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
<title>Admin - Login</title>
</head>
<body>
	<div class="bg-img">
         <div class="content">
            <header>Login Form</header>
            <form action="login" method="post">
               <div class="field">
                  <span class="fa fa-user"></span>
                  <input type="text" placeholder="Username" id="userName" name="username" required>
                  <div class="error-message"></div>
               </div>
               <div class="field space">
                  <span class="fa fa-lock"></span>
                  <input type="password" class="pass-key" placeholder="Password" id="passWord" name="password" required>
                  <span class="show">SHOW</span>
                  <div class="error-message"></div>
               </div>
               <div class="pass">
                  <a href="#">Forgot Password?</a>
               </div>
               <div class="field">
                  <input type="submit" value="LOGIN">
               </div>
            </form>
         </div>
      </div>
      <script>
         const pass_field = document.querySelector('.pass-key');
         const showBtn = document.querySelector('.show');
         showBtn.addEventListener('click', function(){
          if(pass_field.type === "password"){
            pass_field.type = "text";
            showBtn.textContent = "HIDE";
            showBtn.style.color = "#3498db";
          }else{
            pass_field.type = "password";
            showBtn.textContent = "SHOW";
            showBtn.style.color = "#222";
          }
         });
      </script>
</body>
</html>