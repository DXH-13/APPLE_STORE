<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/customer.css">
    <title>Document</title>
</head>

<body>
    <div class="header">
        <hr>
        <h1>CUSTOMER <span style="color: #203A43;">PROFILE</span></h1>
    </div>
    <section>
        <form action="" method="post">
            <div class="container">
                <h2 class="text-image">Loyal <span style="color: #203A43;">Customer</span></h2>
                <div class="info-list">
                    <div class="info-left">
                        <div class="info-cover">
                            <div class="left">
                                <h3>Name</h3>
                                <div>${sessionScope.account.firstName} ${sessionScope.account.lastName}</div>
                            </div>
                            <div class="right">
                                <div><img class="lav-link-apple" src="./assets/icons8-name-64.png" alt="Apple Icon"
                                        style="margin: 8.4px; width: 35px; height: 35px;"></div>
                            </div>
                        </div>
                        <div class="info-cover">
                            <div class="left">
                                <h3>Email</h3>
                                <div>${sessionScope.account.email}</div>
                            </div>
                            <div class="right">
                                <div><img class="lav-link-apple" src="./assets/icons8-email-26.png" alt="Apple Icon"
                                        style="margin: 8.4px; width: 35px; height: 35px;"></div>
                            </div>
                        </div>
                        <div class="info-cover">
                            <div class="left">
                                <h3>Birthday</h3>
                                <div>${sessionScope.account.birthDay}</div>
                            </div>
                            <div class="right">
                                <div><img class="lav-link-apple" src="./assets/icons8-calendar-48.png" alt="Apple Icon"
                                        style="margin: 8.4px; width: 35px; height: 35px;"></div>
                            </div>
                        </div>
                    </div>
                    <div class="info-center">
                        <img src="./assets/profile-circle-icon-2048x2048-cqe5466q.png" alt="">
                    </div>
                    <div class="info-left">
                        <div class="info-cover">
                            <div class="left">
                                <h3>Gender</h3>
                                <div>${sessionScope.account.gender?"Male":"Female"}</div>
                            </div>
                            <div class="right">
                                <div><img class="lav-link-apple" src="./assets/icons8-drag-gender-neutral-50.png"
                                        alt="Apple Icon" style="margin: 8.4px; width: 35px; height: 35px;"></div>
                            </div>
                        </div>
                        <div class="info-cover">
                            <div class="left">
                                <h3>Address</h3>
                                <div>${sessionScope.account.address}</div>
                            </div>
                            <div class="right">
                                <div><img class="lav-link-apple" src="./assets/icons8-address-64.png" alt="Apple Icon"
                                        style="margin: 8.4px; width: 35px; height: 35px;"></div>
                            </div>
                        </div>
                        <div class="info-cover">
                            <div class="left">
                                <h3>Phone</h3>
                                <div>${sessionScope.account.phone}</div>
                            </div>
                            <div class="right">
                                <div><img class="lav-link-apple" src="./assets/icons8-contact-50.png" alt="Apple Icon"
                                        style="margin: 8.4px; width: 35px; height: 35px;"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
                            <a href="UpdateProfile">Update Profile</a>
                            <a href="UpdatePassword">Change Password</a>
        </form>
        <div class="price">
            <div class="">
                <h3>Wallet <img class="lav-link-apple" src="./assets/icons8-wallet-50.png" alt="Apple Icon"
                        style="margin: 0 6px; width: 18px; height: 18px;"></h3>
                <div>$${sessionScope.account.money}</div>
            </div>
        </div>
        <div class="text-image2">
            <h2 style="color: #203A43;">
                Costumer
            </h2><br>
            <p>
                Lorem ipsum, dolor sit amet consectetur adipisicing elit. Eveniet earum quod voluptates corporis
                perferendis! Optio ad voluptatibus aliquid libero architecto sed. Ipsa obcaecati perspiciatis asperiores
                quis cumque doloribus quidem quasi!
            </p>
        </div>
    </section>

</body>

</html>