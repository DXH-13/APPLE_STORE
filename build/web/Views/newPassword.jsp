<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/login1.css"/>
        <title>Forget Password</title>
    </head>
    <body>
        <form action="newPassword" method="post">
            <div class="login">
                <div class="title">Forget</div>
                <div class="des">Welcome back you've been missed!</div>
                <input type="hidden" name="email" value="${sessionScope.email}">
                <div class="group">
                    <input type="password" name="npassword" id="password" placeholder="New Password">
                </div>
                <div class="group">
                    <input type="password" name="rpassword" id="password" placeholder="Re-enter New Password">
                </div>
                <div class="signIn">
                    <input type="submit" class="btn-info" value="Change">
                </div>
                <div class="register">
                    Anything change? <a href="Profile">Get back</a>
                    <p style="color: red">${requestScope.msg}<p>
                </div>
            </div>
        </form>
    </body>
</html>
