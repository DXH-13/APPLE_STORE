<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./css/login1.css">
        <title>Doge</title>
        <link rel="icon" href="./assets/icons/doge.png">
    </head>
    <body>
        <form action="login" method="post">
            <div class="login">
                <div class="title">Sign In!</div>
                <div class="des">Welcome back you've been missed!</div>
                <div class="group">
                    <input type="text" name="username"
                           placeholder="Enter username">
                </div>
                <div class="group">
                    <input type="password" name="password"
                           placeholder="Password">
                </div>
                <div class="signIn">
                    <input type='submit' value='Sign In'>
                </div>
                <div class="register">
                <a href="run">Forgot Password?</a>
                </div>
                <div class="register">
                    Not a member? <a href="signup">Register</a>
                    <p style="color: red">${requestScope.msg}<p>
                </div>
            </div>
        </form>
    </body>
</html>
