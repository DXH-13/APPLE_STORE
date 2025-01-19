<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/style.css"/>
        <link rel="stylesheet" href="./css/checkout.css"/>
        <title>Bye</title>
    </head>
    <body>
        <div class="container">
                <div class="billing">
                    <h2>Billing Address</h2>
                    <label for="firstName">First Name:</label>
                    <p>${order.acc.firstName}</p>
                    <label for="lastName">Last Name:</label>
                    <p>${order.acc.lastName}</p>
                    <label for="email">Email:</label>
                    <p>${order.acc.email}</p>
                    <label for="phone">Phone:</label>
                    <p>${order.acc.phone}</p>
                    <label for="birthday">Birthday:</label>
                    <p>${order.acc.birthDay}</p>
                    <label for="gender">Gender:</label>
                    <p>${order.acc.gender?"Male":"Female"}</p>
                    <label for="region">Region:</label>
                    <p>${order.acc.region}</p>
                    <label for="address">Address:</label>
                    <p>${order.acc.address}</p>
                </div>
                <div class="order-summary">
                    <h2>Order Summary</h2>
                    <table>
                        <tr>
                            <th>Name</th>
                            <th>Total Money</th>
                        </tr>
                        <tr>
                            <c:forEach items="${o.items}" var="i">
                            <td>${i.productOption.p.productName}</td>
                            <td class="tr">$${(i.price*i.quantity)}</td>
                            </c:forEach>
                        </tr>
                        <!-- Add more items in the order summary here -->
                    </table>
                    <div class="href">
                        <h3>Sub Total: $${order.totalPrice}</h3>
                        <p>Shipping: $00.00</p>
                        <p>Tax: $00.00</p>
                        <input  type="submit" name="" value="COMPLETE">
                        <a href="HomeControl">m</a>
                    </div>
                </div>

        </div>
    </body>
</html>
