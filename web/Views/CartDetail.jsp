<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Doge</title>
        <link rel="icon" href="./assets/icons/doge.png">
        <link rel="stylesheet" href="./css/style.css"/>
        <link rel="stylesheet" href="./css/cart.css"/>
        <link rel="stylesheet" href="./css/store2.css">
        <link rel="stylesheet" href="./css/store2.css">
        <link rel="stylesheet" href="./css/cate.css">
        <link rel="stylesheet" href="./css/comment.css">
        <link rel="stylesheet" href="css/cmt2.css"/>
    </head>
    <body>

        <!-- Navbar -->
        <jsp:include page="Navbar.jsp"></jsp:include>
            <!-- Offer -->
            <div class="offers2">
                <p>Set up to ?8000 instant savings on selected products with eligible HDFC Bank cards. Plus No Cost EMI from most leading banks.<a class="a-inline" href="#"> See Offers</a></p>
            </div>
            <!-- Section Store -->
            <div class="section">
                <div class="titles">
                    <h1>Store.<span style="color: rgb(121, 122, 124);">The best way to buy the products you love.</span></h1>
                </div>
                <div class="services">
                    <p>Need a Shopping help ? </p>
                    <a href="#">Ask a Specialist</a> <br>
                    <p>Visit an Apple Store</p>
                    <a href="#">Find One Near You</a>
                </div>
            </div>
            <div class="products">
                <div class="product">
                    <img src="./assets/5ec26e0b6c295800046c81db.png" alt="product">
                    <a href="#">Macbook</a>
                </div>
                <div class="product">
                    <img src="./assets/61d4a6218b51e20004664d4c.png" alt="product">
                    <a href="#">iPad</a>
                </div>
                <div class="product">
                    <img src="./assets/darkbomber-552585104b2a15720d3c0b661ce5945c.png" alt="product">
                    <a href="#">iPhone</a>
                </div>
                <div class="product">
                    <img src="./assets/Apple-Watch-PNG-Transparent.png" alt="product">
                    <a href="#" >iWatch</a>
                </div>
                <div class="product">
                    <img src="./assets/airpods-32430.png" alt="product">
                    <a href="#">AirPods</a>
                </div>
            </div>

            <h1>Shopping Cart Online</h1>
            <div style="display: flex; justify-content: center;">
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th style="width: 40%;">Product </th>

                            <th>Price</th>
                            <th>Quantity</th>

                            <th>Subtotal</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:set var="o" value="${requestScope.cart}" />
                    <c:set var="tt" value="0" />
                    <c:forEach items="${o.items}" var="i">
                        <c:set var="tt" value="${tt+1}"/>
                        <tr>
                            <td style="display: flex; align-items: center; gap: 10px; ">
                                <img style="width: 190px; border-radius: 20px;" class="img-manage" src="${i.productOption.photo1}" alt="macbook">
                                <span>${i.productOption.p.productName} ${i.productOption.cl.colorName} ${i.productOption.s.storage}</span>
                            </td>
                            <td class="tr" style="text-align: center">$${i.price}</td>
                            <td style="text-align: center">
                                <button><a href="ProcessControl?num=-1&id=${i.productOption.productOptionID}">-</a></button>
                                ${i.quantity}
                                <button><a href="ProcessControl?num=1&id=${i.productOption.productOptionID}">+</a></button>
                            </td>
                            <td style="text-align: center" class="tr">$${(i.price*i.quantity)}</td>
                            <td style="text-align: center">
                                <form action="ProcessControl" method="post">
                                    <input type='hidden' name='id' value='${i.productOption.productOptionID}'>
                                    <input type='submit' value='Return Item'>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <div style="margin-right: 270px; margin-bottom: 50px;">
            <div class="href"><h3>Total Money: $${o.totalMoney}</h3>
                <form action="CheckOutControl" method="post">
                    <input type='submit' name='' value='Check Out'>
                </form>
                <a href="StoreControl">Continue Shopping</a></div>
            <p style="color: red">${requestScope.msg}<p>
        </div>

        <div class="footer">
            <div class="upper-text-container">
                <p>
                    1. Trade-in values will vary based on the condition, year, and configuration of your eligible
                    trade-in device. Not all devices are eligible for credit. You must be at least 18 years old to
                    be eligible to trade in for credit or for an Apple Gift Card. Trade-in value may be applied toward
                    qualifying new device purchase, or added to an Apple Gift Card. Actual value awarded is based on receipt
                    of a qualifying device matching the description provided when estimate was made. Sales tax may be assessed
                    on full value of a new device purchase. In-store trade-in requires presentation of a valid photo ID (local law
                    may require saving this information). Offer may not be available in all stores, and may vary between in-store and
                    online trade-in. Some stores may have additional requirements. Apple or its trade-in partners reserve the right to
                    refuse or limit quantity of any trade-in transaction for any reason. More details are available from Apple’s trade-in
                    partner for trade-in and recycling of eligible devices. Restrictions and limitations may apply.<br/><br/>
                <p>Apple Vision Pro has not been authorized as required by the rules of the Federal
                    Communications Commission. This device is not, and may not be,
                    offered for sale or lease, or sold or leased, until authorization is obtained.</p>
                <p>To access and use all Apple Card features and products available
                    only to Apple Card users, you must add Apple Card to Wallet on
                    an iPhone or iPad that supports and has the latest version of
                    iOS or iPadOS. Apple Card is subject to credit approval, available
                    only for qualifying applicants in the United States,
                    and issued by Goldman Sachs Bank USA, Salt Lake City Branch.</p><br/>    
                </p>
                <p>
                    2. Subscription required.<br />
                    Magic Keyboard sold separately.<br />
                    Apple TV+ is $4.99/month after free trial. One subscription per
                    Family Sharing group. Offer good for 3 months after eligible device
                    activation. Plan automatically renews until cancelled. Restrictions
                    and other <a class="a-inline" href="https://www.apple.com/promo/">terms </a> apply.
                </p>
            </div>
        </div>


    </body>
</html>
