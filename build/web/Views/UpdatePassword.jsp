<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/login1.css"/>
        <title>Update Password</title>
    </head>
    <body>
        <form action="UpdatePassword" method="post">
            <div class="login">
                <div class="title">Repass</div>
                <div class="des">Welcome back you've been missed!</div>
                <input type="hidden" name="username" value="${sessionScope.account.username}">
                <div class="group">
                    <input type="password" name="cpassword" id="password" placeholder="Current Password">
                </div>
                <div class="group">
                    <input type="password" name="npassword" id="password" placeholder="New Password">
                </div>
                <div class="group">
                    <input type="password" name="rpassword" id="password" placeholder="Re-enter New Password">
                </div>
                <div class="signIn">
                    <input type="submit" class="btn-info" name='btnUpdate' value="Change">
                </div>
                <div class="register">
                    Anything change? <a href="Profile">Get back</a>
                    <p style="color: red">${requestScope.msg}<p>
                </div>
                ${cpassword}
                ${npassword}
                ${rpassword}
            </div>
        </form>
    </body>
</html>
