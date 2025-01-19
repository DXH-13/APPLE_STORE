<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/style.css"/>
        <link rel="stylesheet" href="css/detail2.css">
        <title>Doge</title>
        <link rel="icon" href="./assets/icons/doge.png">
    </head>
    <body>
        <!-- Navbar -->
        <jsp:include page="Navbar.jsp"></jsp:include>
            <!-- Offer -->
            <div class="offers2">
                <p>Set up to ?8000 instant savings on selected products with eligible HDFC Bank cards. Plus No Cost EMI from most leading banks.<a class="a-inline" href="#"> See Offers</a></p>
            </div>

            <!-- Product Detail -->
            <div class="header-product">
                <h1>Buy ${DetailControl.p.productName}</h1>
            <p>From $${DetailControl.price} or $29.12/mo.per month for 24 months*</p>
        </div>
        <form name="f" action="" method="post">
            <div class="container-product">
                <div class="product-detail">
                    <div class="product-image">
                        <img src="${DetailControl.photo1}" alt="">
                    </div>
                    <div class="product-content">
                        <h2 class="product-name">${DetailControl.p.productName}</h2>
                        <div class="product-price">$${DetailControl.price}</div>
                        <div class="product-description">${DetailControl.p.description}</div>
                        <!-- <section class="radio-section">
                                <div class="radio-list">
                                        <div class="radio-item"><input name="radio" id="radio1" type="radio"><label for="radio1">iPhone 14</label></div>
                                        <div class="radio-item"><input name="radio" id="radio2" type="radio"><label for="radio2">iPhone 14 Pro</label></div>
                                </div>
                        </section> -->
                        <div class="product-buttons2">
                            <input type="submit" value="Check Out">
                            <input type="submit" onclick="buy('${p.productOptionID}')" value="Add To Cart">
                        </div>
                    </div>
                </div>
            </div>
        </form>
        <!-- Footer -->
        <jsp:include page="Footer.jsp"></jsp:include>
    </body>
</html>
<script type="text/javascript">
    function buy(id) {
        var m = document.f.num.value;
        document.f.action = "BuyControl?id=" + id + "&num=" + m;
        document.f.submit();
    }
</script>