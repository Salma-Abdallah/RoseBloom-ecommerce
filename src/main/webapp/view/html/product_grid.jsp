<%@ page import="java.util.Enumeration" %>

    <%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html class="no-js" lang="en">

        <!-- belle/shop-grid-5.html   11 Nov 2019 12:39:07 GMT -->

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
            <meta http-equiv="x-ua-compatible" content="ie=edge">
            <title>RoseBloom</title>
            <meta name="description" content="description">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <!-- Favicon -->
            <link rel="shortcut icon" href="view/images/leaf2.png" />
            <!-- Plugins CSS -->
            <link rel="stylesheet" href="view/style/plugins.css">
            <!-- Bootstap CSS -->
            <link rel="stylesheet" href="view/style/bootstrap.min.css">
            <!-- Main Style CSS -->
            <link rel="stylesheet" href="view/style/style.css">
            <link rel="stylesheet" href="view/style/responsive.css">

            <link rel="stylesheet" href="view/style/main-style2.css" type="text/css" media="all">
            <style>
                .flex-i img{height: 100%;width:100%;object-fit: cover;}
            </style>
        </head>

        <body class="template-collection belle">
            <%@ include file="header.jsp" %>
                <div class="pageWrapper" style="margin-top: 130px;">

                    <!--

        <div id="page-content">

            <div class="collection-header">
                <div class="collection-hero">
                    <div class="collection-hero__image"><img class="blur-up lazyload" data-src="plants.jpg"
                            src="view/images/plants.jpg" alt="Women" title="Women" /></div>
                    <div class="collection-hero__title-wrapper">
                        <h1 class="collection-hero__title page-width">Shop Grid 5 Column</h1>
                    </div>
                </div>
            </div>
            -->

                    <div class="container">
                        <div class="row">
                            <!--Sidebar-->
                            <div class="col-12 col-sm-12 col-md-3 col-lg-3 sidebar filterbar" style="margin-top: 50px;">
                                <div class="closeFilter d-block d-md-none d-lg-none"><i
                                        class="icon icon anm anm-times-l"></i>
                                </div>
                                <div class="sidebar_tags">
                                    <!--Categories-->
                                    <div class="sidebar_widget categories filter-widget">
                                        <div class="widget-title">
                                            <h2>Categories</h2>
                                        </div>
                                        <div class="widget-content">
                                            <ul class="sidebar_categories">
                                                <li class="level1 sub-level"><a href="#" class="site-nav"><a href="#">Plants</a></a>                                                    <ul class="sublinks">
                                                        <li class="level2"><a href="ProductServlet?categoryName=Outdoors" class="site-nav">Outdoors</a>
                                                        </li>
                                                        <li class="level2"><a href="ProductServlet?categoryName=Indoors" class="site-nav">Indoors</a>
                                                        </li>
                                                        <li class="level2"><a href="ProductServlet?categoryName=Trees" class="site-nav">Trees</a></li>
                                                        <!-- <li class="level2"><a href="ProductServlet?categoryName=Cacti" class="site-nav">Cacti &
                                                                succulents</a>
                                                        </li> -->
                                                    </ul>
                                                </li>
              
                                                <li class="level1 sub-level"><a href="#" class="site-nav">Pots</a>
                                                    <ul class="sublinks">
                                                        <li class="level2"><a href="ProductServlet?categoryName=Clay Pots" class="site-nav">Clay Pots</a></li>
                                                        <li class="level2"><a href="ProductServlet?categoryName=Plastic Pots" class="site-nav">Plastic Pots</a>
                                                            <li class="level2"><a href="ProductServlet?categoryName=Hanging Pots" class="site-nav">Hanging Pots</a>
                                                                <li class="level2"><a href="ProductServlet?categoryName=Table-top Pots" class="site-nav">Table-top Pots</a>
                                                        </li>
                                                    
                                                    </ul>
                                                </li>
                                                <li class="level1 sub-level"><a href="#" class="site-nav">Garden Supplies</a>
                                                    <ul class="sublinks">
                                                        <li class="level2"><a href="ProductServlet?categoryName=Gardening Tools" class="site-nav">Gardening Tools</a></li>
                                                        <li class="level2"><a href="ProductServlet?categoryName=Soil" class="site-nav">Soil</a>
                                                            <li class="level2"><a href="ProductServlet?categoryName=Fertilizer" class="site-nav">Fertilizer</a>
                                                              
                                                        </li>
                                                    
                                                    </ul>
                                                </li>
                                               
                                                <li class="lvl-1"><a href="ProductServlet?categoryName=Gifts" class="site-nav">Gifts</a></li>

                                            </ul>
                                        </div>
                                    </div>
                                    <!--Categories-->
                                    <!--Price Filter-->
                                    <div class="sidebar_widget filterBox filter-widget">
                                        <div class="widget-title">
                                            <h2>Price</h2>
                                        </div>
                                        <form action="#" method="post" class="price-filter">
                                            <div id="slider-range"
                                                class="ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all">
                                                <div class="ui-slider-range ui-widget-header ui-corner-all"></div>
                                                <span class="ui-slider-handle ui-state-default ui-corner-all"
                                                    tabindex="0"></span>
                                                <span class="ui-slider-handle ui-state-default ui-corner-all"
                                                    tabindex="0"></span>
                                            </div>
                                            <div class="row">
                                                <div class="col-6">
                                                    <p class="no-margin"><input id="amount" type="text"></p>
                                                </div>
                                                <div class="col-6 text-right margin-25px-top">
                                                    <button class="btn btn-secondary btn--small">filter</button>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                    <!--End Price Filter-->
                                    <!-- Size Swatches
                                <div class="sidebar_widget filterBox filter-widget size-swacthes">
                                    <div class="widget-title">
                                        <h2>Size</h2>
                                    </div>
                                    <div class="filter-color swacth-list">
                                        <ul>
                                            <li><span class="swacth-btn checked">X</span></li>
                                            <li><span class="swacth-btn">XL</span></li>
                                            <li><span class="swacth-btn">XLL</span></li>
                                            <li><span class="swacth-btn">M</span></li>
                                            <li><span class="swacth-btn">L</span></li>
                                            <li><span class="swacth-btn">S</span></li>
                                            <li><span class="swacth-btn">XXXL</span></li>
                                            <li><span class="swacth-btn">XXL</span></li>
                                            <li><span class="swacth-btn">XS</span></span></li>
                                        </ul>
                                    </div>
                                </div>
                                End Size Swatches -->

                                    <!-- Color Swatches
                                <div class="sidebar_widget filterBox filter-widget">
                                    <div class="widget-title">
                                        <h2>Color</h2>
                                    </div>
                                    <div class="filter-color swacth-list clearfix">
                                        <span class="swacth-btn black"></span>
                                        <span class="swacth-btn white checked"></span>
                                        <span class="swacth-btn red"></span>
                                        <span class="swacth-btn blue"></span>
                                        <span class="swacth-btn pink"></span>
                                        <span class="swacth-btn gray"></span>
                                        <span class="swacth-btn green"></span>
                                        <span class="swacth-btn orange"></span>
                                        <span class="swacth-btn yellow"></span>
                                        <span class="swacth-btn blueviolet"></span>
                                        <span class="swacth-btn brown"></span>
                                        <span class="swacth-btn darkGoldenRod"></span>
                                        <span class="swacth-btn darkGreen"></span>
                                        <span class="swacth-btn darkRed"></span>
                                        <span class="swacth-btn dimGrey"></span>
                                        <span class="swacth-btn khaki"></span>
                                    </div>
                                </div>
                                End Color Swatches-->
                                    <!--Brand
                                <div class="sidebar_widget filterBox filter-widget">
                                    <div class="widget-title">
                                        <h2>Brands</h2>
                                    </div>
                                    <ul>
                                        <li>
                                            <input type="checkbox" value="allen-vela" id="check1">
                                            <label for="check1"><span><span></span></span>Allen Vela</label>
                                        </li>
                                        <li>
                                            <input type="checkbox" value="oxymat" id="check3">
                                            <label for="check3"><span><span></span></span>Oxymat</label>
                                        </li>
                                        <li>
                                            <input type="checkbox" value="vanelas" id="check4">
                                            <label for="check4"><span><span></span></span>Vanelas</label>
                                        </li>
                                        <li>
                                            <input type="checkbox" value="pagini" id="check5">
                                            <label for="check5"><span><span></span></span>Pagini</label>
                                        </li>
                                        <li>
                                            <input type="checkbox" value="monark" id="check6">
                                            <label for="check6"><span><span></span></span>Monark</label>
                                        </li>
                                    </ul>
                                </div>
                                End Brand-->
                                    <!--Popular Products
                                <div class="sidebar_widget">
                                    <div class="widget-title">
                                        <h2>Popular Products</h2>
                                    </div>
                                    <div class="widget-content">
                                        <div class="list list-sidebar-products">
                                            <div class="grid">
                                                <div class="grid__item">
                                                    <div class="mini-list-item">
                                                        <div class="mini-view_image">
                                                            <a class="grid-view-item__link" href="#">
                                                                <img class="grid-view-item__image"
                                                                    src="view/images/product-images/mini-product-img.jpg"
                                                                    alt="" />
                                                            </a>
                                                        </div>
                                                        <div class="details"> <a class="grid-view-item__title"
                                                                href="#">Cena
                                                                Skirt</a>
                                                            <div class="grid-view-item__meta"><span
                                                                    class="product-price__price"><span class="money">EGP
                                                                        173.60</span></span></div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="grid__item">
                                                    <div class="mini-list-item">
                                                        <div class="mini-view_image"> <a class="grid-view-item__link"
                                                                href="#"><img class="grid-view-item__image"
                                                                    src="view/images/product-images/mini-product-img1.jpg"
                                                                    alt="" /></a> </div>
                                                        <div class="details"> <a class="grid-view-item__title"
                                                                href="#">Block
                                                                Button Up</a>
                                                            <div class="grid-view-item__meta"><span
                                                                    class="product-price__price"><span class="money">EGP
                                                                        378.00</span></span></div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="grid__item">
                                                    <div class="mini-list-item">
                                                        <div class="mini-view_image"> <a class="grid-view-item__link"
                                                                href="#"><img class="grid-view-item__image"
                                                                    src="view/images/product-images/mini-product-img2.jpg"
                                                                    alt="" /></a> </div>
                                                        <div class="details"> <a class="grid-view-item__title"
                                                                href="#">Balda
                                                                Button Pant</a>
                                                            <div class="grid-view-item__meta"><span
                                                                    class="product-price__price"><span class="money">EGP
                                                                        278.60</span></span></div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="grid__item">
                                                    <div class="mini-list-item">
                                                        <div class="mini-view_image"> <a class="grid-view-item__link"
                                                                href="#"><img class="grid-view-item__image"
                                                                    src="view/images/product-images/mini-product-img3.jpg"
                                                                    alt="" /></a> </div>
                                                        <div class="details"> <a class="grid-view-item__title"
                                                                href="#">Border
                                                                Dress in Black/Silver</a>
                                                            <div class="grid-view-item__meta"><span
                                                                    class="product-price__price"><span class="money">EGP
                                                                        228.00</span></span></div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                End Popular Products-->



                                </div>
                            </div>
                            <!--End Sidebar-->
                            <!--Main Content-->
                            <jsp:useBean id="category" class="com.rosebloom.dtos.CategoryDto" scope="session" />
                            <div class="col-12 col-sm-12 col-md-9 col-lg-9 main-col shop-grid-5">
                                <div class="productList">
                                    <div class="category-description">
                                        <h3 id="categoryName">
                                            ${categoryName}
                                        </h3>

                                    </div>
                                    <hr>
                                    <!--Toolbar-->
                                    <button type="button" class="btn btn-filter d-block d-md-none d-lg-none"> Product
                                        Filters</button>
                                    <!-- <div class="toolbar">
                                        <div class="filters-toolbar-wrapper">
                                            <div class="row">
                                                <div
                                                    class="col-4 col-md-4 col-lg-4 filters-toolbar__item collection-view-as d-flex justify-content-start align-items-center">
                                                    <a href="shop-left-sidebar.html" title="Grid View"
                                                        class="change-view change-view--active">
                                                        <img src="view/images/grid.jpg" alt="Grid" />
                                                    </a>
                                                    <a href="shop-listview.html" title="List View" class="change-view">
                                                        <img src="view/images/list.jpg" alt="List" />
                                                    </a>
                                                </div>

                                                <div class="col-4 col-md-4 col-lg-4 text-right">
                                                    <div class="filters-toolbar__item">
                                                        <label for="SortBy" class="hidden">Sort</label>
                                                        <select name="SortBy" id="SortBy"
                                                            class="filters-toolbar__input filters-toolbar__input--sort">
                                                            <option value="title-ascending" selected="selected">Sort
                                                            </option>
                                                            <option>Best Selling</option>
                                                            <option>Alphabetically, A-Z</option>
                                                            <option>Alphabetically, Z-A</option>
                                                            <option>Price, low to high</option>
                                                            <option>Price, high to low</option>
                                                            <option>Date, new to old</option>
                                                            <option>Date, old to new</option>
                                                        </select>
                                                        <input class="collection-header__default-sort" type="hidden"
                                                            value="manual">
                                                    </div>
                                                </div>

                                            </div>
                                        </div>
                                    </div> -->
                                    <!--End Toolbar-->
                                    <div class="grid-products grid--view-items">
                                        <div class="row" id="grid--view-items">
                                            <f:forEach items="${products}" var="current">
                                                <div class="col-6 col-sm-6 col-md-4 col-lg-2 item">

                                                    <div class="product-image" >

                                                        <a href="productDetails?productId=${current.id}">

                                                            <img class="primary blur-up lazyload"
                                                                data-src="${current.productImages[0].image}"
                                                                src="${current.productImages[0].image}" alt="image"
                                                                title="product" style="min-height: 200px; max-height: 200px;" >

                                                                <img class="hover blur-up lazyload"
                                                                data-src="${current.productImages[1].image}"
                                                                src="${current.productImages[1].image}" alt="image"
                                                                title="product" style="min-height: 200px; max-height: 200px;">
                                                        </a>
                                                        <!-- end product image -->
                                                        <!-- Start product button -->
                                                        <form class="variants add" action="#"
                                                            onclick="productDetails.jsp" method="post">
                                                            <button class="btn btn-addto-cart" type="button">ADD TO
                                                                CART</button>
                                                        </form>
                                                        <div class="button-set">
                                                            <a href="javascript:void(0)" title="Quick View"
                                                                class="quick-view-popup quick-view" data-toggle="modal"
                                                                data-target="#content_quickview">
                                                                <i class="icon anm anm-search-plus-r"></i>
                                                            </a>
                                                            <div class="wishlist-btn">
                                                                <a class="wishlist add-to-wishlist" href="#"
                                                                    title="Add to Wishlist">
                                                                    <i class="icon anm anm-heart-l"></i>
                                                                </a>
                                                            </div>

                                                        </div>
                                                        <!-- end product button -->
                                                    </div>
                                                    <!-- end product image -->

                                                    <!--start product details -->
                                                    <div class="product-details text-center">

                                                        <div class="product-name">
                                                            <a href="#">${current.name} </a>
                                                        </div>
                                                        <!-- End product name -->
                                                        <!-- product price -->
                                                        <div class="product-price">

                                                            <!-- // '<span class="old-price">EGP '+dataa.productsJson[i].oldPrice+'</span>' + -->
                                                            <span class="price">EGP ${current.price}</span>
                                                        </div>
                                                        <!-- End product price -->

                                                        <div class="product-review">
                                                            <i class="font-13 fa fa-star"></i>
                                                            <i class="font-13 fa fa-star"></i>
                                                            <i class="font-13 fa fa-star"></i>
                                                            <i class="font-13 fa fa-star-o"></i>
                                                            <i class="font-13 fa fa-star-o"></i>
                                                        </div>
                                                    </div>
                                                    <!-- End product details -->
                                                </div>
                                            </f:forEach>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                    <!--Footer-->
                    <%@ include file="footer.html" %>
                        <!--End Footer-->
                        <!--End Quick View popup-->

                        <!-- Including Jquery -->
                        <script src="view/scripts/vendor/jquery-3.3.1.min.js"></script>
                        <script src="view/scripts/vendor/jquery.cookie.js"></script>
                        <script src="view/scripts/vendor/modernizr-3.6.0.min.js"></script>
                        <script src="view/scripts/vendor/wow.min.js"></script>
                        <!-- Including Javascript -->
                        <script src="view/scripts/bootstrap.min.js"></script>
                        <script src="view/scripts/plugins.js"></script>
                        <script src="view/scripts/popper.min.js"></script>
                        <script src="view/scripts/lazysizes.js"></script>
                        <script src="view/scripts/main.js"></script>
                        <script src="view/scripts/product.js"></script>
                </div>

        </body>

        <!-- belle/shop-grid-5.html   11 Nov 2019 12:39:07 GMT -->

        </html>