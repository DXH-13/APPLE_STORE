<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Navbar -->

<header class="header">
    <form action="SearchControl" method="post">
        <div class="container">
            <nav class="lav-main">
                <ul class="lav-list">
                    <li class="lav-item"> <a href="HomeControl" class="lav-link"><img class="lav-link-apple" src="./assets/icons/doge2.png" alt="Apple Icon" style="margin: 8.4px; width: 18px; height: 18px;"></a></li>
                    <li class="lav-item"> <a href="" class="lav-link"><img class="lav-link-apple" src="./assets/icons/cate2.png" alt="Apple Icon" style="margin: 8.4px; width: 18px; height: 18px;"></a></li>
                    <li class="lav-item"> <a href="StoreControl" class="lav-link">Shop</a></li>
                    <li class="lav-item"> <a href="ManageControl" class="lav-link">Manage</a></li>
                        <c:if test="${sessionScope.account==null}">
                        <li class="lav-item"> <a href="login" class="lav-link">Login</a></li>
                        </c:if>
                    <li class="lav-item" style="position: relative;">
                        <a href="#" class="lav-link" id="userDropdownToggle">
                            <img class="lav-link-apple" src="./assets/icons/user.png" alt="Apple Icon" style="margin: 8.4px; width: 18px; height: 18px;">
                        </a>
                        <ul id="userDropdown" class="dropdown-content" style="position: absolute; top: 100%; left: 0; display: none;">
                            <c:if test="${sessionScope.account != null}">
                                <a href="Profile"><li style="color: black; font-size: 12px;">${sessionScope.account.username}</li></a>
                                <li class="lav-item"><a href="logout" class="lav-link"><img class="lav-link-apple" src="./assets/icons/logout.png" alt="Apple Icon" style="margin: 8.4px; width: 16px; height: 16px;"></a></li>
                                </c:if>
                        </ul>
                    </li>
                    <li class="lav-item"> <a href="#" class="lav-link"><img class="lav-link-search" src="./assets/icons/search.png" alt="Search Icon" style="margin: 8.4px; width: 18px; height: 18px;"></a></li>
                    <input name="txt" type="text" id="searchInput" style="display: none;" /><button type="submit" id="searchButton" style="display: none;">Search</button>
                    
                    <!-- Bag Icon with JavaScript Login Check -->
                    <li id="bag" class="lav-item">
                        <a href="#" class="lav-link" id="bagLink">
                            <img class="lav-link-bag" src="./assets/icons/bag.png" alt="Bag Icon" style="margin: 8.4px; width: 18px; height: 18px;">
                        </a>
                    </li>
                    
                    <!-- Hidden input for login status -->
                    <input type="hidden" id="isLoggedIn" value="${sessionScope.account != null}" />
                </ul>
            </nav>
        </div>
    </form>
</header>

<script>
    const searchIcon = document.querySelector('.lav-link-search');
    const searchInput = document.querySelector('#searchInput');
    const searchButton = document.querySelector('#searchButton');
    const isLoggedIn = document.querySelector('#isLoggedIn').value === 'true';
    const bagLink = document.querySelector('#bagLink');

    // Toggle search input display
    searchIcon.addEventListener('click', function () {
        if (searchInput.style.display === 'none' || searchInput.style.display === '') {
            searchInput.style.display = 'block';
            searchButton.style.display = 'block';
        } else {
            searchInput.style.display = 'none';
            searchButton.style.display = 'none';
        }
    });

    // Toggle user dropdown display
    const userDropdownToggle = document.getElementById('userDropdownToggle');
    const userDropdown = document.getElementById('userDropdown');

    userDropdownToggle.addEventListener('click', function () {
        if (userDropdown.style.display === 'none' || userDropdown.style.display === '') {
            userDropdown.style.display = 'block';
        } else {
            userDropdown.style.display = 'none';
        }
    });

    // Redirect to login if not logged in when clicking on the bag icon
    bagLink.addEventListener('click', function (event) {
        event.preventDefault();
        if (!isLoggedIn) {
            window.location.href = 'login';
        } else {
            window.location.href = 'ShowControl';
        }
    });
</script>
