<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="check" %>

<%@taglib prefix="ce" uri="jakarta.tags.core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
                <check:choose>
                    <check:when test="${loggedIn=='true'}">
                        <h3 style="color:aliceblue">Welcome ${User.name}</h3>
                    </check:when>
                    <check:otherwise>
                        <div class="currency-picker">
                            <span class="selected-currency">EGY</span>
                        </div>
                        <div class="language-dropdown">
                            <span class="language-dd">English</span>
                        </div>
                        <p class="phone-no"><i class="anm anm-phone-s"></i> +440 0(111) 044 833</p>
                    </check:otherwise>
                </check:choose>

            </div>
            <div class="col-sm-4 col-md-4 col-lg-4 d-none d-lg-none d-md-block d-lg-block">
                <div class="text-center"><p class="top-header_middle-text"> Worldwide Express Shipping</p></div>
            </div>
            <div class="col-2 col-sm-4 col-md-3 col-lg-4 text-right">
                <span class="user-menu d-block d-lg-none"><i class="anm anm-user-al" aria-hidden="true"></i></span>
                <ul class="customer-links list-inline">
                    <!-- loggedIn -->
                <check:choose>                   
                    <check:when test ="${loggedIn=='true'}">
                        <li><a href="userProfile.jsp">User Profile</a></li>
                        <li><a href="wishlist.html">Logout</a></li>
                    </check:when>
                    <check:otherwise>
                        <li><a href="login2.html">Login</a></li>
                        <li><a href="signup2.html">Create Account</a></li>
                    </check:otherwise>
                </check:choose> 
                    
                    
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
                <a href="index.jsp">
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
                        <li class="lvl1 parent megamenu"><a href="ProductServlet?categoryName=Plants">Plants <i class="anm anm-angle-down-l"></i></a>
                            <div class="megamenu style4">
                                <ul class="grid grid--uniform mmWrapper">
                                    <li class="grid__item lvl-1 col-md-3 col-lg-3"><a href="#" class="site-nav lvl-1">Plants Types</a>
                                        <ul class="subLinks">
                                            <li class="lvl-2"><a href="ProductServlet?categoryName=Indoors" class="site-nav lvl-2">Indoors</a></li>
                                            <li class="lvl-2"><a href="ProductServlet?categoryName=Outdoors" class="site-nav lvl-2">Outdoors</a></li>
                                            <li class="lvl-2"><a href="ProductServlet?categoryName=Trees" class="site-nav lvl-2">Trees</a></li>
                                            <!-- <li class="lvl-2"><a href="ProductServlet?categoryName=Cacti" class="site-nav lvl-2">Cacti & succulents</a></li> -->
                                            <li class="lvl-2"><a href="ProductServlet?categoryName=Seeds" class="site-nav lvl-2">Seeds</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                        </li>
                        <li class="lvl1 parent megamenu"><a href="ProductServlet?categoryName=Pots">Pots <i class="anm anm-angle-down-l"></i></a>
                            <div class="megamenu style2">
                                <ul class="grid mmWrapper">
                                    <li class="grid__item one-whole">
                                        <ul class="grid">
                                            <li class="grid__item lvl-1 col-md-3 col-lg-3"><a href="#" class="site-nav lvl-1">Pots Types</a>
                                                <ul class="subLinks">
                                                    <li class="lvl-2"><a href="ProductServlet?categoryName=Clay Pots" class="site-nav lvl-2">Clay Pots</a></li>
                                                    <li class="lvl-2"><a href="ProductServlet?categoryName=Plastic Pots" class="site-nav lvl-2">Plastic Pots</a></li>
                                                    <li class="lvl-2"><a href="ProductServlet?categoryName=Hanging Pots" class="site-nav lvl-2">Hanging Pots</a></li>
                                                    <li class="lvl-2"><a href="" class="site-nav lvl-2">Table-top Pots</a></li>
                                                </ul>
                                            </li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                        </li>
                        <li class="lvl1 parent megamenu"><a href="ProductServlet?categoryName=Garden Supplies">Garden Supplies <i class="anm anm-angle-down-l"></i></a>
                            <div class="megamenu style2">
                                <ul class="grid mmWrapper">
                                    <li class="grid__item lvl-1 col-md-3 col-lg-3"><a href="#" class="site-nav lvl-1">Supplies Types</a>
                                        <ul class="subLinks">
                                            <li class="lvl-2"><a href="ProductServlet?categoryName=Gardening Tools" class="site-nav lvl-2">Gardening Tools</a></li>
                                            <li class="lvl-2"><a href="ProductServlet?categoryName=Soil" class="site-nav lvl-2">Soil</a></li>
                                            <li class="lvl-2"><a href="ProductServlet?categoryName=Fertilizer" class="site-nav lvl-2">Fertilizer</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                        </li>
                        <li class="lvl1 parent megamenu"><a href="ProductServlet?categoryName=Gifts">Gifts<i class="anm anm-angle-down-l"></i></a>
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
                    <a href="index.jsp">
                        <img src="view/images/rosebloom2.png" alt="Belle Multipurpose Html Template" title="Belle Multipurpose Html Template" />
                    </a>
                </div>
            </div>
            <!--Mobile Logo-->
            <div class="col-4 col-sm-3 col-md-3 col-lg-2">
                <div class="site-cart">
                    <a href="#;" class="site-header__cart" title="Cart">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-basket3-fill" viewBox="0 0 16 16">
                            <path d="M5.757 1.071a.5.5 0 0 1 .172.686L3.383 6h9.234L10.07 1.757a.5.5 0 1 1 .858-.514L13.783 6H15.5a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5H.5a.5.5 0 0 1-.5-.5v-1A.5.5 0 0 1 .5 6h1.717L5.07 1.243a.5.5 0 0 1 .686-.172zM2.468 15.426.943 9h14.114l-1.525 6.426a.75.75 0 0 1-.729.574H3.197a.75.75 0 0 1-.73-.574z"/>
                          </svg>
                        <span id="CartCount" class="site-header__cart-count" data-cart-render="item_count">${fn:length(cartList)}</span>
                    </a>
                    <!--Minicart Popup-->
                    <div id="header-cart" class="block block-cart">
                        <ul class="mini-products-list">
                            <ce:forEach items="${cartList}" var="cartItem">
                                <li class="item">
                                    <a class="product-image" href="#">
                                        <ce:forEach var="images" items="${cartItem.product.productImages}" varStatus="status">
                                            <ce:if test="${status.index == 0}">
                                                <img src="${images.image}" alt="" title="" />
                                            </ce:if>
                                        </ce:forEach>
                                    </a>
                                    <div class="product-details">
                                        <a href="" class="remove"><i class="anm anm-times-l" aria-hidden="true"></i></a>
<%--                                        <a href="" class="edit-i remove"><i class="anm anm-edit" aria-hidden="true"></i></a>--%>
                                        <a class="pName" href="cart.html">${cartItem.product.name}</a>
                                        <div class="variant-cart">${cartItem.product.color} / ${cartItem.product.size}</div>
                                        <div class="wrapQtyBtn">
                                            <div class="qtyField">
                                                <span class="label">Qty:</span>
                                                <a class="qtyBtn minus" href="javascript:void(0);" id="qtyPlus_${cartItem.product.id}"><i class="fa anm anm-minus-r" aria-hidden="true"></i></a>
                                                <input type="text" id="Quantity3" name="quantity" value="${cartItem.quantity}" class="product-form__input qty" id="qty_${cartItem.product.id}" disabled>
                                                <a class="qtyBtn plus" href="javascript:void(0);" id="qtyMinus_${cartItem.product.id}"><i class="fa anm anm-plus-r" aria-hidden="true"></i></a>
                                            </div>
                                        </div>
                                        <div class="priceRow">
                                            <div class="product-price">EGP
                                                <span class="money" id="totalAmount_${cartItem.product.id}">${cartItem.quantity*cartItem.product.price}</span>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                            </ce:forEach>
                            <li class="item">
                                <a class="product-image" href="#">
                                    <img src="assets/images/product-images/cape-dress-2.jpg" alt="Elastic Waist Dress - Black / Small" title="" />
                                </a>
                                <div class="product-details">
                                    <a href="#" class="remove"><i class="anm anm-times-l" aria-hidden="true"></i></a>
                                �   <a h ef="#" �lass="e it-i re�ove"><i class="�nm anm-edit" aria-hidden="true"></i></a>
                                    <� class= pName" �ref="ca t.html"�Elastic Waist D�ess</a>
                                    <div class="variant-cart"> ray / X�L</div> 
                                    <d v class="wrapQtyBtn">
                                        <div cla s="qtyF eld">
                                            <span class="label">Qty:</span>
                                            <a clas ="qtyBt  minus" href="j vascrip :void(0 ;"><i class="fa anm anm-minus-r" aria-hidden="true"></i></a>
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
                                <span class="label">Cart Subtotal:</span><span class="product-price">EGP <span class="money">${total}</span></span>
                            </div>
                            <div class="buttonSet text-center">
                                <a href="cart" class="btn btn-secondary btn--small">View Cart</a>
                                <a href="Checkout" class="btn btn-secondary btn--small">Checkout</a>
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
        <li class="lvl1 parent megamenu"><a href="index.jsp">Home </a>
        </li>

        <li class="lvl1 parent megamenu"><a href="ProductServlet?categoryName=Plants">Plants<i class="anm anm-plus-l"></i></a>
            <ul>
                <li><a href="ProductServlet?categoryName=Indoors" class="site-nav">InDoor</a></li>
                <li><a href="ProductServlet?categoryName=Outdoors" class="site-nav">OutDoor</a></li>
                <li><a href="ProductServlet?categoryName=Trees" class="site-nav">Trees</a></li>
                <!-- <li><a href="ProductServlet?categoryName=Cacti" class="site-nav">Cacti & succulents</a></li> -->
                <li><a href="ProductServlet?categoryName=Seeds" class="site-nav">Seeds</a></li>

            </ul>
        </li>
        <li class="lvl1 parent megamenu"><a href="ProductServlet?categoryName=Pots">Pots<i class="anm anm-plus-l"></i></a>
            <ul>
                <li><a href="ProductServlet?categoryName=Clay Pots" class="site-nav">Clay Pots</a></li>
                <li><a href="ProductServlet?categoryName=Plastic Pots" class="site-nav">Plastic Pots</a></li>
                <li><a href="ProductServlet?categoryName=Hanging Pots" class="site-nav">Hanging Pots</a></li>
                <li><a href="ProductServlet?categoryName=Table-top Pots" class="site-nav">Table-top Pots</a></li>

            </ul>
        </li>
        <li class="lvl1 parent megamenu"><a href="ProductServlet?categoryName=Garden Supplies">Garden Supplies<i class="anm anm-plus-l"></i></a>
            <ul>
                <li><a href="ProductServlet?categoryName=Gardening Tools" class="site-nav">Gardening Tools</a></li>
                <li><a href="ProductServlet?categoryName=Soil" class="site-nav">Soil</a></li>
                <li><a href="ProductServlet?categoryName=Fertilizer" class="site-nav">Fertilizer</a></li>

            </ul>
        </li>
        <li class="lvl1 parent megamenu"><a href="ProductServlet?categoryName=Gifts">Gifts </a>
        <li class="lvl1 parent megamenu"><a href="blog-left-sidebar.html">Guids </a>
            <!-- </li>
                <li class="lvl1"><a href="#"><b>Buy Now!</b></a>
            </li> -->
    </ul>
</div>
<!--End Mobile Menu-->
