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
        <form action="forgotPassword" method="post">
            <div class="login">
                <div class="title">Get Password</div>
                <div class="des">You've missed something!</div>
                <div class="group">
                    <input type="text" name="email"
                           placeholder="Enter your email addresss" required="">
                </div>
                <div class="signIn">
                    <input type='submit' value='Get new Password'>
                </div>
                <div class="register">
                    Get back to login? <a href="login">Login</a>
                </div>
            </div>
        </form>
    </body>
</html>
