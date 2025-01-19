<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./css/store2.css">
        <link rel="stylesheet" href="./css/cate.css">
        <link rel="stylesheet" href="./css/comment.css">
        <link rel="stylesheet" href="css/cmt2.css"/>
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

            <!-- Cards Latest -->
            <div class="card-container">
                <h1>The latest. <span>Take a look at what's new right now.</span> </h1>
                <div class="cards">
                    <div class="card">
                        <span>LIMITED TIME OFFER</span>
                        <h1>MacBook Air 15. Buy Now</h1>
                        <p>You?ll also save on Apple Pencil, Magic Keyboard for iPad</p>
                        <img src="./assets/macair-small.png" alt="macbook">
                    </div>
                    <div class="card">
                        <span>LIMITED TIME OFFER</span>
                        <h1>MacBook Air 15. Buy Now </h1>
                        <p>You?ll also save on Apple Pencil, Magic Keyboard for iPad</p>
                        <img src="./assets/macpro-small.png" alt="macbook">
                    </div>
                    <div class="card">
                        <span>LIMITED TIME OFFER</span>
                        <h1>MacBook Air 15. Buy Now </h1>
                        <p>You?ll also save on Apple Pencil, Magic Keyboard for iPad</p>
                        <img src="./assets/airpodmax-small.png" alt="macbook">
                    </div>
                </div>
            </div>

            <!-- Filter -->
            <div class="container3">
                <div class="container2">
                    <form class="filter" action="FindControl" method="post">
                        <div class="filter-dropdown">
                            <div class="filter-item">
                                <label for="">Select Model</label><br>
                                <select name="model" id="">	
                                <c:forEach items="${listP}" var="p">
                                    <option value="${p.productID}"
                                            ${p.productID == p.productID ? "selected" : ""}>${p.productName}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="filter-item">
                            <label for="">Select Color</label><br>
                            <select name="color" id="">	
                                <c:forEach items="${listCl}" var="cl">
                                    <option value="${cl.colorID}"
                                            ${cl.colorID == colorID ? "selected" : ""}>${cl.colorName}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="filter-item">
                            <label for="">Select Storage</label><br>
                            <select name="storage" id="">	
                                <c:forEach items="${listS}" var="s">
                                    <option value="${s.storageID}"
                                            ${s.storageID == s.storageID ? "selected" : ""}>${s.storage}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="sort-search">
                        <input class="sort-search-button" type="submit" value="Filter">
                    </div>
                </form>



            </div>

            <div class="container2-small">
                <form class="filter" action="StoreControl" method="post">
                    <div class="filter-item">
                        <label for="">Categories</label><br>
                        <ul class="custom-list">
                            <c:forEach items="${listC}" var="c">
                                <li><a href="FilterCategoryControl?cid=${c.categoryId}">${c.categoryName}</a></li>
                                </c:forEach>
                        </ul>
                    </div>
                </form>
            </div>




            <!-- Cards Mac -->
            <div class="card-container-product">    
                <!--<h1>The latest. <span>Take a look at what's new right now.</span> </h1>-->
                <form name="f" action="" method="post">
                    <input style="text-align: center" type='number' name='num' value='1' hidden>

                    <div class="cards-product">
                        <c:forEach items="${listPO}" var="p">
                            <div class="card-product">
                                <img src="${p.photo2}"
                                     alt="macbook">

                                <p class="card-product-title">New</p>
                                <a class="a-color" href="DetailControl?pid=${p.productOptionID}">
                                    <h1 class="card-product-name">${p.p.productName}</h1>
                                </a>
                                <p class=" card-product-price">Color: ${p.cl.colorName}</p>
                                <p class="card-product-price">Storage: ${p.s.storage}</p>
                                <p class="card-product-price">Price: $${p.price}</p>
                                <div class="product-buttons2">
                                    <input class="hihi" type="button" onclick="buy('${p.productOptionID}')" value="Add To Cart">
                                </div>

                            </div>
                        </c:forEach>
                    </div>
                </form>
                <div class="pagination" style="margin-top: 100px">
                    <c:forEach begin="1" end="${end}" var="i">
                        <a href="StoreControl?index=${i}">${i}</a>
                    </c:forEach>
                </div>
            </div>

            <!-- Reviews -->
            <div class="reviews" style="margin-bottom: 50px">
                <div class="container-reviews">
                    <form name="myform" action="StoreControl" method="post">
                        <input type="hidden" name="accountID" value="${sessionScope.account.accountID}">
                        <input class="bobo" type="text" name="comment" placeholder="Please comment">
                        <br>
                        <input class="product-buttons01" type="submit" value="Send">
                    </form>
                    <div id="mycomment"></div>
                </div>
                <div class="comment-list">
                    <h3>Reviews:</h3>
                    <c:forEach items="${listR}" var="r">
                        <div class="comment-item">
                            <div class="comment-item-header">
                                <h4>${r.a.username}</h4>
                                <span>${r.reviewDate}</span>
                            </div>
                            <span>${r.comment}</span>
                        </div>
                    </c:forEach>
                </div>
            </div>

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