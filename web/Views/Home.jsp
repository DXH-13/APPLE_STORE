<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./css/style.css">
        <link rel="stylesheet" href="./css/user.css"/>
        <title>Doge</title>
        <link rel="icon" href="./assets/icons/doge.png">
    </head>
    <body>
        <!-- Navbar -->
        <jsp:include page="Navbar.jsp"></jsp:include>
        <!-- <section class="top-paragraph">
                        <div class="container">
                                <div class="title">We?re open for you.</div>
                                <div class="text">
                                        Our retail stores are closed, but you can buy our products here online
                                        and get fast, free delivery. If you need help finding the right
                                        product or have a question on your order, chat online with a
                                        Specialist or call 1-800-MY-APPLE.<br />
                                        For service and support, visit
                                        <a class="a-inline" href="https://support.apple.com/">support.apple.com</a>
                                </div>
                        </div>
                </section> -->
        <!-- Video 1 -->
        <div class="title-video">
            <div class="container">
                <div class="title-hero-video">
                    <h2 class="title-heading-video" style="font-family: 'Lora', serif;">iPhone 15 Pro</h2>
                    <h3 class="title-sub-heading-video" style="font-family: 'Lora', serif;">Titanium.So strong.So light.So Pro</h3>
                </div>
            </div>
        </div>
        <div class="back-video">
            <video autoplay loop muted play-inline >
                <source src="assets/large_2x.mp4"  type="video/mp4">  
            </video>
        </div>

        <section class="hero iphone-15">
            <div class="container">
                <div class="title-hero title-dark">
                    <h2 class="title-heading">iPhone 15</h2>
                    <h3 class="title-sub-heading">New camera.New design.Newphoria</h3>
                </div>
                <div class="cta">
                    <a href="#" class="cta-link cta-link-darker">Learn more</a>
                    <a href="#" class="cta-link cta-link-darker">Buy</a>
                </div>
                <div class="image-wrapper">
            <img src="assets/iphone-15-large-4.jpg" alt="iphone-15-large-4"/>
        </div>
            </div>
        </section>
        <!-- Video 2 -->
        <div class="title-video-2">
            <div class="container">
                <div class="title-hero-video-2">
                    <p class="title-new">New</p>
                    <h2 class="title-heading-video-2">iPad Pro</h2>
                    <h3 class="title-sub-heading-video-2">Supercharged with</h3>
                    <img src="assets/m2_logo__90ungfqgnsiu_large.png" alt="m2-logo">
                </div>
                <div class="cta-video-2">
                    <a href="#" class="cta-link-video-2 cta-link-darker-video-2">Learn more</a>
                    <a href="http://localhost:9999/AppleProject/DetailControl?pid=126" class="cta-link-video-2 cta-link-darker-video-2">Buy</a>
                </div>
            </div>
        </div>

        <div class="back-video-2">
            <video autoplay loop muted play-inline >
                <source src="assets/large.mp4"  type="video/mp4">  
            </video>
        </div>
    </div>
    <!-- Apple Events -->
    <div class="event-pictures-2">
        <img class="even-pictures-image-2" src="./assets/event1.jpg" alt="events">
    </div>
    <div class="apple-events">
        <div class="event-pictures">
            <div class="event-label">
                <h1 style="font-family: 'Lora', serif; color: rgb(178, 178, 178);">An immersive way to experience entertainment.</h1>
                <p style="font-family: 'Lora', serif; color: rgb(155, 155, 154);" >Built on the foundation of macOS, iOS, and iPadOS, visionOS enables powerful spatial experiences. Control Apple Vision Pro with your eyes, hands, and voice ? interactions feel intuitive and magical. Simply look at an element, tap your fingers together to select, and use the virtual keyboard or dictation to type.</p> 	
            </div>
            <img src="./assets/event2.jpg" alt="events">
        </div>

    </div>
    <!-- Footer -->
    <jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>