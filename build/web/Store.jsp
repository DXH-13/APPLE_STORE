<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./css/store2.css">
        <title>Apple</title>
    </head>
    <body>
        <!-- Navbar -->
        <header class="header">
            <div class="container">
                <nav class="lav-main">
                    <ul class="lav-list">
                        <li class="lav-item"> <a href="storepage.html" class="lav-link lav-link-apple"></a></li>
                        <li class="lav-item"> <a href="StoreControl" class="lav-link">Shop</a></li>
                        <li class="lav-item"> <a href="#" class="lav-link">Mac</a></li>
                        <li class="lav-item"> <a href="#" class="lav-link">iPad</a></li>
                        <li class="lav-item"> <a href="#" class="lav-link">iPhone</a></li>
                        <li class="lav-item"> <a href="#" class="lav-link">Watch</a></li>
                        <li class="lav-item"> <a href="#" class="lav-link">AirPods</a></li>	
                        <li class="lav-item"> <a href="#" class="lav-link">Support</a></li>
                        <li class="lav-item"> <a href="#" class="lav-link lav-link-search"></a></li>
                        <li class="lav-item"> <a href="#" class="lav-link lav-link-bag"></a></li>
                        <!-- <li class="lav-item"> <a href="#" class="lav-link lav-link-user"></a></li> -->
                    </ul>
                </nav>
            </div>
        </header>
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

        <!-- Sort -->
        <!-- <div class="container2">
                <form class="sort">
                        <div class="sort-item">
                                <input type="text" placeholder="Enter min">
                        </div>
                        <div class="sort-item">
                                <input type="text" placeholder="Enter max">
                        </div>
                        <div class="sort-search">
                                <input class="sort-search-button" type="button" value="Search">
                        </div>
                </form>
        </div> -->

        <!-- Cards Latest -->
        <div class="card-container">
            <h1>The latest. <span>Take a look at what?s new right now.</span> </h1>
            <div class="cards">
                <div class="card">
                    <span>LIMITED TIME OFFER</span>
                    <h1>Save on Mac or iPad for university.</h1>
                    <p>You?ll also save on Apple Pencil, Magic Keyboard for iPad</p>
                    <img src="./images/Apple_new-macbookair-wallpaper-screen_11102020_big.jpg.large.jpg" alt="macbook">
                </div>
                <div class="card">
                    <span>LIMITED TIME OFFER</span>
                    <h1>MacBook Air 15. Buy Now </h1>
                    <p>You?ll also save on Apple Pencil, Magic Keyboard for iPad</p>
                    <img src="./images/Apple-WWDC23-MacBook-Air-15-in-hero-230605.jpg.news_app_ed.jpg" alt="macbook">
                </div>
                <div style="background: black;" class="card">
                    <span style="color: white;" >LIMITED TIME OFFER</span>
                    <h1 style="color: white;" >iPhone 15 Pro. Buy Now</h1>
                    <p style="color: white;">You?ll also save on Apple Pencil, Magic Keyboard for iPad, get 20% off AppleCare+, and more.²</p>
                    <img style="height: 180px;" src="./images/gsmarena_001.jpg" alt="iphone">
                </div>
            </div>
        </div>

        <!-- Filter -->
        <div class="container2">
            <form class="filter">
                <div class="filter-dropdown">
                    <div class="filter-item">
                        <label for="">Select Model</label><br>
                        <select name="category" id="">	
                            <option value="">Select An Option</option>
                            <option value="iPhone">iPhone</option>
                            <option value="Mac">Mac</option>
                            <option value="iPad">Watch</option>
                            <option value="iPad">AirPods</option>
                            <option value="iPad">iPad</option>
                        </select>
                    </div>
                    <div class="filter-item">
                        <label for="">Select Model</label><br>
                        <select name="category" id="">	
                            <option value="">Select An Option</option>
                            <option value="iPhone">iPhone</option>
                            <option value="Mac">Mac</option>
                            <option value="iPad">Watch</option>
                            <option value="iPad">AirPods</option>
                            <option value="iPad">iPad</option>
                        </select>
                    </div>
                    <div class="filter-item">
                        <label for="">Select Model</label><br>
                        <select name="category" id="">	
                            <option value="">Select An Option</option>
                            <option value="iPhone">iPhone</option>
                            <option value="Mac">Mac</option>
                            <option value="iPad">Watch</option>
                            <option value="iPad">AirPods</option>
                            <option value="iPad">iPad</option>
                        </select>
                    </div>
                    <div class="filter-item">
                        <label for="">Select Realease</label><br>
                        <select name="category" id="">	
                            <option value="">Select An Option</option>
                            <option value="2023">2023</option>
                            <option value="2022">2022</option>
                            <option value="2021">2021	</option>
                        </select>
                    </div>
                    <div class="filter-item">
                        <label for="">Select Color</label><br>
                        <select name="category" id="">	
                            <option value="">Select An Option</option>
                            <option value="Black">Black</option>
                            <option value="White">White</option>
                            <option value="Blue">Blue</option>
                        </select>
                    </div>
                    <div class="filter-item">
                        <label for="">Select Storage</label><br>
                        <select name="category" id="">	
                            <option value="">Select An Option</option>
                            <option value="Black">256GB</option>
                            <option value="White">512GB</option>
                            <option value="Blue">1TB</option>
                        </select>
                    </div>
                </div>
                <div class="sort-search">
                    <input class="sort-search-button" type="submit" value="Filter">
                </div>
            </form>
        </div>

        <!-- Cards Mac -->
        <div class="card-container-product">
            <h1>The latest. <span>Take a look at what?s new right now.</span> </h1>
            <div class="cards-product">
                <c:forEach items="${dao.prodop}" var="p" begin="0" end="11" >
                    <a href="DetailControl?pid=${p.productOptionID}&productName=${dao.prod[p.productID].productName}
                       &description=${dao.prod[p.productID].description}&colorName=${dao.color[p.colorID].colorName}">
                        <div class="card-product">
                            <img src="${p.photo2}"
                                 alt="macbook">
                            <p class="card-product-title">New</p>
                            <h1 class="card-product-name">${dao.prod[p.productID].productName}</h1>
                            <p class="card-product-price">${dao.color[p.colorID].colorName}</p>
                            <p class="card-product-price">$${p.price}</p>
                        </div>
                    </a>
                </c:forEach>
            </div>
        </div>

        <!-- Footer -->
        <footer class="footer">
            <div class="container-footer">
                <div class="upper-text-container">
                    <p>
                        1. Trade In: Trade?in values vary. iPhone 15 and iPhone 15 Pro
                        promotional pricing is after trade?in of iPhone 13 Pro and iPhone 13 Pro Max
                        in good condition. Additional trade?in values require purchase of a
                        new iPhone, subject to availability and limits. Must be at least 18.
                        Apple or its trade-in partners reserve the right to refuse or limit
                        any Trade In transaction for any reason. In?store trade?in requires
                        presentation of a valid, government-issued photo ID (local law may
                        require saving this information). Sales tax may be assessed on full
                        value of new iPhone. Additional terms from Apple or Apple?s trade-in
                        partners may apply. Monthly pricing: Available to qualified
                        customers and requires 0% APR, 24-month installment loan with
                        Citizens One or Apple Card Monthly Installments and iPhone
                        activation with AT&T, Sprint, T-Mobile, or Verizon. Taxes and
                        shipping not included. Additional Apple Card Monthly Installments
                        terms are in the
                        <a class="a-inline"
                           href="https://www.goldmansachs.com/terms-and-conditions/Apple-Card-Customer-Agreement.pdf"
                           target="_blank">
                            Customer Agreement</a
                        >. Additional iPhone Payments terms are
                        <a class="a-inline"
                           href="https://www.apple.com/legal/sales-support/iphoneinstallments_us/">
                            here</a
                        >.<br/><br/>
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
                <div class="footer-links-wrapper">
                    <div class="links-wrapper-1">
                        <h3 id="one">Shop and Learn</h3>
                        <ul>
                            <li><a href="#">Mac</a></li>
                            <li><a href="#">iPad</a></li>
                            <li><a href="#">iPhone</a></li>
                            <li><a href="#">Watch</a></li>
                            <li><a href="#">TV</a></li>
                            <li><a href="#">Music</a></li>
                            <li><a href="#">AirPods</a></li>
                            <li><a href="#">HomePod</a></li>
                            <li><a href="#">iPod touch</a></li>
                            <li><a href="#">Accessories</a></li>
                            <li><a href="#">Gift Cards</a></li>
                        </ul>
                    </div>
                    <div class="links-wrapper-2">
                        <h3 id="two">Services</h3>
                        <ul>
                            <li><a href="#">Apple Music</a></li>
                            <li><a href="#">Apple News+</a></li>
                            <li><a href="#">Apple TV+</a></li>
                            <li><a href="#">Apple Arcade</a></li>
                            <li><a href="#">Apple Card</a></li>
                            <li><a href="#">iCloud</a></li>
                        </ul>
                        <h3>Account</h3>
                        <ul>
                            <li><a href="#">Manage Your Apple ID</a></li>
                            <li><a href="#">Apple Store Account</a></li>
                            <li><a href="#">iCloud.com</a></li>
                        </ul>
                    </div>
                    <div class="links-wrapper-3">
                        <h3>Apple Store</h3>
                        <ul>
                            <li><a href="#">Find a Store</a></li>
                            <li><a href="#">Genius Bar</a></li>
                            <li><a href="#">Today at Apple</a></li>
                            <li><a href="#">Apple Camp</a></li>
                            <li><a href="#">Field Trip</a></li>
                            <li><a href="#">Apple Store App</a></li>
                            <li><a href="#">Refurbished and Clearance</a></li>
                            <li><a href="#">Financing</a></li>
                            <li><a href="#">Apple Trade In</a></li>
                            <li><a href="#">Order Status</a></li>
                            <li><a href="#">Shopping Help</a></li>
                        </ul>
                    </div>
                    <div class="links-wrapper-4">
                        <h3>For Business</h3>
                        <ul>
                            <li><a href="#">Apple and Business</a></li>
                            <li><a href="#">Shop for Business</a></li>
                        </ul>
                        <h3>For Education</h3>
                        <ul>
                            <li><a href="#">Apple and Education</a></li>
                            <li><a href="#">Shop for College</a></li>
                        </ul>
                        <h3>For Healthcare</h3>
                        <ul>
                            <li><a href="#">Manage Your Apple ID</a></li>
                            <li><a href="#">Apple Store Account</a></li>
                            <li><a href="#">iCloud.com</a></li>
                        </ul>
                        <h3>For Government</h3>
                        <ul>
                            <li><a href="#">Apple and Education</a></li>
                            <li><a href="#">Shop for College</a></li>
                        </ul>
                    </div>
                    <div class="links-wrapper-5">
                        <h3>Apple Values</h3>
                        <ul>
                            <li><a href="#">Find a Store</a></li>
                            <li><a href="#">Genius Bar</a></li>
                            <li><a href="#">Today at Apple</a></li>
                            <li><a href="#">Apple Camp</a></li>
                            <li><a href="#">Field Trip</a></li>
                            <li><a href="#">Apple Store App</a></li>
                        </ul>
                        <h3>About Apple</h3>
                        <ul>
                            <li><a href="#">Find a Store</a></li>
                            <li><a href="#">Genius Bar</a></li>
                            <li><a href="#">Today at Apple</a></li>
                            <li><a href="#">Apple Camp</a></li>
                            <li><a href="#">Field Trip</a></li>
                            <li><a href="#">Apple Store App</a></li>
                        </ul>
                    </div>
                </div>
                <div class="copyright-wrapper row">
                    <div class="footer-links-terms col-sm-12 order-3 col-lg-6 order-lg-2">
                        <ul>
                            <li><a href="#">Privacy Policy</a></li>
                            <li><a href="#">Terms of Use</a></li>
                            <li><a href="#">Sales and Refunds</a></li>
                            <li><a href="#">Legal</a></li>
                            <li><a href="#">Site Map</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </footer>
</body>
</html>