<%-- 
    Document   : Login1
    Created on : Oct 15, 2023, 12:01:37 AM
    Author     : wongun78
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./css/login1.css">
        <style>
            body {
                background: #0F2027;
                background: -webkit-linear-gradient(to right, #2C5364, #203A43, #0F2027);
                background: linear-gradient(to right, #2C5364, #203A43, #0F2027);
            }
            .login .signIn button {
                background-color: #2C5364;
                box-shadow: 0 10px 20px hsla(209, 84%, 17%, 0.6);
            }
        </style>
        <title>Doge</title>
        <link rel="icon" href="./assets/icons/doge.png">
    </head>
    <body>
        <form action="signup" method="post">
            <div class="login">
                <div class="title">Sign Up!</div>
                <div class="des">Welcome back you've been missed!</div>
                <div class="group">
                    <input type="text" name="username"
                           placeholder="Enter username" autocomplete="off">
                </div>
                <div class="group">
                    <input type="email" name="email"
                           placeholder="Enter email" autocomplete="off">
                </div>
                <div class="group">
                    <input type="password" name="password"
                           placeholder="Password" autocomplete="off">
                </div>
                <div class="group">
                    <input type="password" name="repassword"
                           placeholder="Repeat Password" autocomplete="off">
                </div>
                <div class="signIn">
                    <input type='submit' value='Sign Up'>
                </div>
                <div class="register">
                    Get back to login? <a href="login">Login</a>
                        <p style="color: red">${requestScope.msg}</p>
                </div>
            </div>
        </form>
    </body>
</html>
