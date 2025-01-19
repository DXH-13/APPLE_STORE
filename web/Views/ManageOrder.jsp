<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/order.css"/>
        <title>Manage Order</title>
    </head>
    <body>
        <div class="containerbig">
            <div class="container">
                <div class="order-info">
                    <h2>Latest Orders</h2>
                    <table>
                        <tr>
                            <th>Name</th>
                            <th>Order Date</th>
                            <th>Price</th>
                        </tr>
                        <c:forEach var="o" items="${listO}">
                            <tr>
                                <td>${o.acc.firstName} ${o.acc.lastName}</td>
                                <td>${o.orderDate}</td>
                                <td style="color: green;">+ ${o.totalPrice}</td>
                            </tr>
                        </c:forEach>

                    </table>
                </div>
                <div class="customer-info">
                    <h2>Top Buyer</h2>
                    <br>
                    <div class="containerC">
                        <div><img class="lav-link-apple" src="./assets/icons8-diamond-heart-48.png" alt="Apple Icon"
                                  style="margin: 8.4px; width: 30px; height: 30px;"><div style="color: rgb(237, 237, 45);">Kien Nguyen</div></div>
                        <div>50<img class="lav-link-apple" src="./assets/icons8-cart-64.png" alt="Apple Icon"
                                    style="margin: 8.4px; width: 30px; height: 30px;"></div>
                    </div>
                </div>
            </div>
            <br>
            <div class="container">
                <div class="customers">
                    <h2>Potential Customers</h2>
                    <div class="containerC">
                        <div><img class="lav-link-apple" src="./assets/icons8-king-48.png" alt="Apple Icon"
                                  style="margin: 8.4px; width: 30px; height: 30px;"><div style="color: rgb(237, 237, 45);">Kien Nguyen</div></div>
                        <div><img class="lav-link-apple" src="./assets/icons8-money-100.png" alt="Apple Icon"
                                  style="margin: 8.4px; width: 64px; height: 64px;">$${ah.money}</div>
                    </div>
                </div>
                <div class="container">
                    <div class="customersC">
                        <br>
                        <br>
                        <div class="containerC">
                            <div>${sl}<img class="lav-link-apple" src="./assets/icons8-cart-64.png" alt="Apple Icon"
                                        style="margin: 8.4px; width: 50px; height: 50px;"></div>
                        </div>
                    </div>
                    <div class="customersC">
                        <br>
                        <br>
                        <div class="containerC">
                            <div>${mn}<img class="lav-link-apple" src="./assets/icons8-order-64.png" alt="Apple Icon"
                                           style="margin: 8.4px; width: 50px; height: 50px;"></div>
                        </div>
                    </div>
                </div>

            </div>
            <div class="empty-div">
                <div>Lorem ipsum dolor sit amet consectetur adipisicing elit. Corporis fuga sequi esse totam, ipsa quos
                    ducimus qui quas iure nam? Repudiandae ut ipsam explicabo laborum totam ea quis nulla dolorum!</div>
            </div>
        </div>
    </body>
</html>
