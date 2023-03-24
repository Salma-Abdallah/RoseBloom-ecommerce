<!DOCTYPE html>
<html lang="zxx">

<head>
    <title>User Profile</title>
    <link rel="shortcut icon" href="view/images/leaf2.png" />
    <!-- Meta tag Keywords -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="UTF-8" />
    <meta name="keywords" content="RoseBloom Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-bera1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <script>
		addEventListener("load", function () {
			setTimeout(hideURLbar, 0);
		}, false);

		function hideURLbar() {
			window.scrollTo(0, 1);
		}
	</script>
    <!--// Meta tag Keywords -->

    <!-- Custom-Files -->
    <link rel="stylesheet" href="view/style/bootstrap.css">
    <!-- Bootstrap-Core-CSS -->
    <link href="view/style/css_slider.css" type="text/css" rel="stylesheet" media="all">
    <!-- banner slider -->
    <link rel="stylesheet" href="view/style/style.css" type="text/css" media="all" />
    <!-- Style-CSS -->
    <link href="view/style/font-awesome.min.css" rel="stylesheet">
    <!-- Font-Awesome-Icons-CSS -->

    <link rel="stylesheet" href="view/style/plugins.css">
<!-- Bootstap CSS -->
<link rel="stylesheet" href="view/style/bootstrap.min.css">
<link rel="stylesheet" href="view/style/bootstrap.css">
<!-- Main Style CSS -->
<link rel="stylesheet" href="view/style/style.css">
<link rel="stylesheet" href="view/style/responsive.css">

<link rel="stylesheet" href="view/style/main-style.css" type="text/css" media="all">


    <link rel="stylesheet" href="view/style/userProfile.css">
    <!-- Signup-CSS -->

    <!-- //Custom-Files -->

    <!-- Web-Fonts -->
    <link href="//fonts.googleapis.com/css?family=Source+Sans+Pro:200,200i,300,300i,400,400i,600,600i,700,700i,900,900i"
          rel="stylesheet">
    <link href="//fonts.googleapis.com/css?family=Niconne&amp;subset=latin-ext" rel="stylesheet">
    <link href="//fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&amp;subset=devanagari,latin-ext"
          rel="stylesheet">
    <!-- //Web-Fonts -->
</head>
<body>

    <div class="search">
        <div class="search__form">
            <form class="search-bar__form" action="#">
                <button class="go-btn search__button" type="submit"><i class="icon anm anm-search-l"></i></button>
                <input class="search__input" type="search" name="q" value="" placeholder="Search entire store..." aria-label="Search" autocomplete="off">
            </form>
            <button type="button" class="search-trigger close-btn"><i class="anm anm-times-l"></i></button>
        </div>
    </div>
    <!--End Search Form Drawer-->
    <!--Top Header-->
    <div class="top-header">
        <div class="container-fluid">
            <div class="row">
                <div class="col-10 col-sm-8 col-md-5 col-lg-4">
                    <div class="currency-picker">
                        <span class="selected-currency">USD</span>
                        <ul id="currencies">
                            <li data-currency="INR" class="">INR</li>
                            <li data-currency="GBP" class="">GBP</li>
                            <li data-currency="CAD" class="">CAD</li>
                            <li data-currency="USD" class="selected">USD</li>
                            <li data-currency="AUD" class="">AUD</li>
                            <li data-currency="EUR" class="">EUR</li>
                            <li data-currency="JPY" class="">JPY</li>
                        </ul>
                    </div>
                    <div class="language-dropdown">
                        <span class="language-dd">English</span>
                        <ul id="language">
                            <li class="">German</li>
                            <li class="">French</li>
                        </ul>
                    </div>
                    <p class="phone-no"><i class="anm anm-phone-s"></i> +440 0(111) 044 833</p>
                </div>
                <div class="col-sm-4 col-md-4 col-lg-4 d-none d-lg-none d-md-block d-lg-block">
                    <div class="text-center"><p class="top-header_middle-text"> Worldwide Express Shipping</p></div>
                </div>
                <div class="col-2 col-sm-4 col-md-3 col-lg-4 text-right">
                    <span class="user-menu d-block d-lg-none"><i class="anm anm-user-al" aria-hidden="true"></i></span>
                    <ul class="customer-links list-inline">
                        <li><a href="userProfile.jsp">User Profile</a></li>
                        <li><a href="login2.html">Login</a></li>
                        <li><a href="signup2.html">Create Account</a></li>
                        <li><a href="wishlist.html">Wishlist</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <!--End Top Header-->
    <!--Header-->
    <div class="header-wrap classicHeader animated d-flex"  style="background: #fff;">
        <div class="container-fluid">
            <div class="row align-items-center">
                <!--Desktop Logo-->
                <div class="logo col-md-2 col-lg-2 d-none d-lg-block">
                    <a href="index.html">
                        <img src="view/images/rosebloom2.png" alt="RoseBloom" title="Belle Multipurpose Html Template" />
                    </a>
                </div>
                <!--End Desktop Logo-->
                <div class="col-2 col-sm-3 col-md-3 col-lg-8">
                    <div class="d-block d-lg-none">
                        <button type="button" class="btn--link site-header__menu js-mobile-nav-toggle mobile-nav--open">
                            <i class="icon anm anm-times-l"></i>
                            <i class="anm anm-bars-r"></i>
                        </button>
                    </div>
                    <!--Desktop Menu-->
                    <nav class="grid__item" id="AccessibleNav"><!-- for mobile -->
                        <ul id="siteNav" class="site-nav medium center hidearrow">
                            <li class="lvl1 parent megamenu"><a href="#">Home <i class="anm anm-angle-down-l"></i></a>
                            </li>
                            <li class="lvl1 parent megamenu"><a href="#">Plants <i class="anm anm-angle-down-l"></i></a>
                                <div class="megamenu style4">
                                    <ul class="grid grid--uniform mmWrapper">
                                        <li class="grid__item lvl-1 col-md-3 col-lg-3"><a href="#" class="site-nav lvl-1">Plants Types</a>
                                            <ul class="subLinks">
                                                <li class="lvl-2"><a href="" class="site-nav lvl-2">Indoor</a></li>
                                                <li class="lvl-2"><a href="" class="site-nav lvl-2">OutDoor</a></li>
                                                <li class="lvl-2"><a href="" class="site-nav lvl-2">Trees</a></li>
                                                <li class="lvl-2"><a href="" class="site-nav lvl-2">Cacti & succulents</a></li>
                                                <li class="lvl-2"><a href="" class="site-nav lvl-2">Seeds</a></li>
                                            </ul>
                                        </li>
                                    </ul>
                                </div>
                            </li>
                            <li class="lvl1 parent megamenu"><a href="#">Pots <i class="anm anm-angle-down-l"></i></a>
                                <div class="megamenu style2">
                                    <ul class="grid mmWrapper">
                                        <li class="grid__item one-whole">
                                            <ul class="grid">
                                                <li class="grid__item lvl-1 col-md-3 col-lg-3"><a href="#" class="site-nav lvl-1">Pots Types</a>
                                                    <ul class="subLinks">
                                                        <li class="lvl-2"><a href="" class="site-nav lvl-2">Clay Pots</a></li>
                                                        <li class="lvl-2"><a href="" class="site-nav lvl-2">Plastic Pots</a></li>
                                                        <li class="lvl-2"><a href="" class="site-nav lvl-2">Hanging Pots</a></li>
                                                        <li class="lvl-2"><a href="" class="site-nav lvl-2">Table-top Pots</a></li>
                                                    </ul>
                                                </li>
                                            </ul>
                                        </li>
                                    </ul>
                                </div>
                            </li>
                            <li class="lvl1 parent megamenu"><a href="#">Garden Supplies <i class="anm anm-angle-down-l"></i></a>
                                <div class="megamenu style2">
                                    <ul class="grid mmWrapper">
                                        <li class="grid__item lvl-1 col-md-3 col-lg-3"><a href="#" class="site-nav lvl-1">Supplies Types</a>
                                            <ul class="subLinks">
                                                <li class="lvl-2"><a href="" class="site-nav lvl-2">Gardening Tools</a></li>
                                                <li class="lvl-2"><a href="" class="site-nav lvl-2">Soil</a></li>
                                                <li class="lvl-2"><a href="" class="site-nav lvl-2">Fertilizer</a></li>
                                                <li class="lvl-2"><a href="" class="site-nav lvl-2">Table-top Pots</a></li>
                                            </ul>
                                        </li>
                                    </ul>
                                </div>
                            </li>
                            <li class="lvl1 parent megamenu"><a href="#">Gifts<i class="anm anm-angle-down-l"></i></a>
                            </li>
                            <li class="lvl1 parent megamenu"><a href="#">Guides<i class="anm anm-angle-down-l"></i></a>
                            </li>
                        </ul>
                    </nav>
                    <!--End Desktop Menu-->
                </div>
                <!--Mobile Logo-->
                <div class="col-6 col-sm-6 col-md-6 col-lg-2 d-block d-lg-none mobile-logo">
                    <div class="logo">
                        <a href="index.html">
                            <img src="view/images/rosebloom2.png" alt="Belle Multipurpose Html Template" title="Belle Multipurpose Html Template" />
                        </a>
                    </div>
                </div>
                <!--Mobile Logo-->
                <div class="col-4 col-sm-3 col-md-3 col-lg-2">
                    <div class="site-cart">
                        <a href="#;" class="site-header__cart" title="Cart">
                            <i class="icon anm anm-bag-l"></i>
                            <span id="CartCount" class="site-header__cart-count" data-cart-render="item_count">2</span>
                        </a>
                        <!--Minicart Popup-->
                        <div id="header-cart" class="block block-cart">
                            <ul class="mini-products-list">
                                <li class="item">
                                    <a class="product-image" href="#">
                                        <img src="assets/images/product-images/cape-dress-1.jpg" alt="3/4 Sleeve Kimono Dress" title="" />
                                    </a>
                                    <div class="product-details">
                                        <a href="#" class="remove"><i class="anm anm-times-l" aria-hidden="true"></i></a>
                                        <a href="#" class="edit-i remove"><i class="anm anm-edit" aria-hidden="true"></i></a>
                                        <a class="pName" href="cart.html">Sleeve Kimono Dress</a>
                                        <div class="variant-cart">Black / XL</div>
                                        <div class="wrapQtyBtn">
                                            <div class="qtyField">
                                                <span class="label">Qty:</span>
                                                <a class="qtyBtn minus" href="javascript:void(0);"><i class="fa anm anm-minus-r" aria-hidden="true"></i></a>
                                                <input type="text" id="Quantity3" name="quantity" value="1" class="product-form__input qty">
                                                <a class="qtyBtn plus" href="javascript:void(0);"><i class="fa anm anm-plus-r" aria-hidden="true"></i></a>
                                            </div>
                                        </div>
                                        <div class="priceRow">
                                            <div class="product-price">
                                                <span class="money">$59.00</span>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                                <li class="item">
                                    <a class="product-image" href="#">
                                        <img src="assets/images/product-images/cape-dress-2.jpg" alt="Elastic Waist Dress - Black / Small" title="" />
                                    </a>
                                    <div class="product-details">
                                        <a href="#" class="remove"><i class="anm anm-times-l" aria-hidden="true"></i></a>
                                        <a href="#" class="edit-i remove"><i class="anm anm-edit" aria-hidden="true"></i></a>
                                        <a class="pName" href="cart.html">Elastic Waist Dress</a>
                                        <div class="variant-cart">Gray / XXL</div>
                                        <div class="wrapQtyBtn">
                                            <div class="qtyField">
                                                <span class="label">Qty:</span>
                                                <a class="qtyBtn minus" href="javascript:void(0);"><i class="fa anm anm-minus-r" aria-hidden="true"></i></a>
                                                <input type="text" id="Quantity2" name="quantity" value="1" class="product-form__input qty">
                                                <a class="qtyBtn plus" href="javascript:void(0);"><i class="fa anm anm-plus-r" aria-hidden="true"></i></a>
                                            </div>
                                        </div>
                                        <div class="priceRow">
                                            <div class="product-price">
                                                <span class="money">$99.00</span>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                            <div class="total">
                                <div class="total-in">
                                    <span class="label">Cart Subtotal:</span><span class="product-price"><span class="money">$748.00</span></span>
                                </div>
                                <div class="buttonSet text-center">
                                    <a href="cart.html" class="btn btn-secondary btn--small">View Cart</a>
                                    <a href="checkout.html" class="btn btn-secondary btn--small">Checkout</a>
                                </div>
                            </div>
                        </div>
                        <!--EndMinicart Popup-->
                    </div>
                    <div class="site-header__search">
                        <button type="button" class="search-trigger"><i class="icon anm anm-search-l"></i></button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--End Header-->
    <!--Mobile Menu-->
    <div class="mobile-nav-wrapper" role="navigation">
        <div class="closemobileMenu"><i class="icon anm anm-times-l pull-right"></i> Close Menu</div>
        <ul id="MobileNav" class="mobile-nav">
            <li class="lvl1 parent megamenu"><a href="index.html">Home </a>
            </li>
    
            <li class="lvl1 parent megamenu"><a href="#">Plants<i class="anm anm-plus-l"></i></a>
                <ul>
                    <li><a href="" class="site-nav">InDoor</a></li>
                    <li><a href="" class="site-nav">OutDoor</a></li>
                    <li><a href="" class="site-nav">Trees</a></li>
                    <li><a href="" class="site-nav">Cacti & succulents</a></li>
                    <li><a href="" class="site-nav">Seeds</a></li>
    
                </ul>
            </li>
            <li class="lvl1 parent megamenu"><a href="product-layout-1.html">Pots<i class="anm anm-plus-l"></i></a>
                <ul>
                    <li><a href="" class="site-nav">Clay Pots</a></li>
                    <li><a href="" class="site-nav">Plastic Pots</a></li>
                    <li><a href="" class="site-nav">Hanging Pots</a></li>
                    <li><a href="" class="site-nav">Table-top Pots</a></li>
    
                </ul>
            </li>
            <li class="lvl1 parent megamenu"><a href="about-us.html">Garden Supplies<i class="anm anm-plus-l"></i></a>
                <ul>
                    <li><a href="" class="site-nav">Gardening Tools</a></li>
                    <li><a href="" class="site-nav">Soil</a></li>
                    <li><a href="" class="site-nav">Fertilizer</a></li>
    
                </ul>
            </li>
            <li class="lvl1 parent megamenu"><a href="blog-left-sidebar.html">Gifts </a>
            <li class="lvl1 parent megamenu"><a href="blog-left-sidebar.html">Guids </a>
                <!-- </li>
                    <li class="lvl1"><a href="#"><b>Buy Now!</b></a>
                </li> -->
        </ul>
    </div>
    <!--End Mobile Menu-->
    
   
    <div class="mainBody">
        <div class="detailsContainer" style="margin-top: 120px; align-items: center;">
            <div class="title"> Your Profile </div>

            <form action="userProfile" method="post">

                <div class="user-details">
                    <div class="input-box">
                        <span class="details">Full Name</span>
                        <input type="text" name="userName" id="userName" value="${User.name}" required>
                        <label name="msgUsername" id="msgUsername"></label>
                    </div>
                    <div class="input-box">
                        <span class="details">Birthday</span>
                        <input type="date" name="birthday" id="birthday" value="${User.birthdate}" required>
                        <label name="msgBirthday" id="msgBirthday"></label>
                    </div>
                    <div class="input-box">
                        <span class="details">Email</span>
                        <input type="email" name="email" id="email" value="${User.email}" required>
                        <label name="msgEmail" id="msgEmail"></label>
                    </div>
                    <div class="input-box">
                        <span class="details">Phone Number</span>
                        <input type="tel" name="phoneNo" id="phoneNo" value="${User.phone}" required>
                        <label name="msgPhoneNo" id="msgPhoneNo"></label>
                    </div>
                    <div class="input-box">
                        <span class="details">Password</span>
                        <input type="password" name="password" id="password" value="${User.password}" required>
                        <label name="msgPassword" id="msgPassword"></label>
                    </div>
                    <div class="input-box">
                        <span class="details">Confirm Password</span>
                        <input type="password" name="confirmPassword" id="confirmPassword" value="${User.password}" required>
                        <label name="msgConfirmPass" id="msgConfirmPass"></label>
                    </div>
                    <div class="input-box">
                        <span class="details">Address</span>
                        <input type="text" name="address" id="address" value="${User.address}" required>
                        <label name="msgAddress" id="msgAddress"></label>
                    </div>
                    <div class="input-box">
                        <span class="details">Credit Limit  </span>
                        <input type="number" name="creditLimit" id="creditLimit" value="${User.creditLimit}" required>
                        <label name="msgCredit" id="msgCredit"></label>
                    </div>
                    <div class="input-box">
                        <span class="details">Job  </span>
                        <input type="text" name="job" id="job" placeholder="Enter your job" value="${User.job}"required>
                        <label name="msgCredit" id="msgJob"></label>
                    </div>
                </div>
        
                <div class="button">
                    <input type="button" value="Update Your Profile ">
                </div>
        
        
            </form>
        
        </div>
    </div>
<footer style="margin-top: 100px;">
    
    <%@ include file ="view/html/footer.html" %>
</footer>
</body>

</html>