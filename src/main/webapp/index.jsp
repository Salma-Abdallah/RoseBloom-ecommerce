<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->

<!DOCTYPE html>
<html lang="zxx">

<head>
	<title>Home</title>
	<!-- Meta tag Keywords -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta charset="UTF-8" />
	<meta name="keywords"
		content="RoseBloom Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
	<script>
		addEventListener("load", function () {
			setTimeout(hideURLbar, 0);
		}, false);

		function hideURLbar() {
			window.scrollTo(0, 1);
		}
	</script>
	<!--// Meta tag Keywords -->


	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />

	<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js">
	</script>
	<!-- <script type="text/javascript" src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js">
    </script> -->


	<!-- Custom-Files -->
	<link rel="stylesheet" href="view/style/bootstrap.css">
	<!-- Bootstrap-Core-CSS -->
	<link href="view/style/css_slider.css" type="text/css" rel="stylesheet" media="all">
	<!-- banner slider -->
	<link rel="stylesheet" href="view/style/main-style.css" type="text/css" media="all" />
	<!-- Style-CSS -->
	<link href="view/style/font-awesome.min.css" rel="stylesheet">
	<!-- Font-Awesome-Icons-CSS -->
	<!-- //Custom-Files -->

	<!-- Web-Fonts -->
	<link href="//fonts.googleapis.com/css?family=Source+Sans+Pro:200,200i,300,300i,400,400i,600,600i,700,700i,900,900i"
		rel="stylesheet">
	<link href="//fonts.googleapis.com/css?family=Niconne&amp;subset=latin-ext" rel="stylesheet">
	<link
		href="//fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&amp;subset=devanagari,latin-ext"
		rel="stylesheet">
	<!-- //Web-Fonts -->
</head>

<body>
	<div id="home">
		<!-- header -->
		
		<header style="text-align: center; height: 100px;">
			<div class="container-menu-desktop">
				<a href="view/html/login.html">login</a>
				<a href="view/html/signup.html">SignUp</a>
				
			</div>
			<!-- fixed top -->
			<div class="header-style ">
				<div class="container">

					<div class="header d-lg-flex justify-content-between align-items-center">
						<!-- logo -->
						<h1 class="logo text-center">
							<!-- <a href="index.html">Plants<i class="fa fa-pagelines" aria-hidden="true"></i> -->
							<img src="view/images/rosebloom.png" alt="" height="55" width="95">
							<!-- <img src="images/rosebloom2.png" alt="" height="60" width="150"> -->
							</a>
						</h1>
						<!-- //logo -->
						<!-- nav -->
						<div class="nav_w3ls">
							<nav>
								<label for="drop" class="toggle toogle-2">Menu</label>
								<input type="checkbox" id="drop" />
								<ul class="menu">
									<li class="active ml-0"><a href="index.html">Home</a></li>
									<!-- <li><a href="#about">About Us</a></li>
									<li><a href="#team">Our Team</a></li> -->
									<li>
										<!-- First Tier Drop Down -->
										<label for="drop-2" class="toggle toggle-drop">Plants<span
												class="fa fa-angle-down" aria-hidden="true"></span>
										</label>

										<a onclick="getProducts(event);">Plants<span class="fa fa-angle-down" aria-hidden="true"></span></a>

										<input type="checkbox" id="drop-2" />

										<ul class="list-unstyled">
											<li><a onclick="getProducts(event);" class="drop-text" >Outdoors</a></li>
											<li class="my-2"><a onclick="getProducts(event); " class="drop-text" >Indoors</a></li>
											<li><a onclick="getProducts(event);" class="drop-text">Trees</a></li>
											<li><a onclick="getProducts(event);" class="drop-text">Cacti & succulents</a></li>
										</ul>
									</li>
									<li><a onclick="getProducts(event); "  href="">Pots</a></li>
									<li><a onclick="getProducts(event); ">supplies</a></li>
									<li><a onclick="getProducts(event); ">Gifts</a></li>
									<li><a href="#gallery">Guides</a></li>
									<li class="mr-0"><a href="#contact">Contact Us</a></li>
								</ul>
							</nav>
							<div class="wrap-icon-header flex-w flex-r-m m-r-15" >
								<div class="icon-header-item cl2 hov-cl1 trans-04 p-r-11 js-show-modal-search" style="background: #00BFA5;">
									<!-- <i class="zmdi zmdi-search"></i> -->
									<iconify-icon icon="zmdi:search"></iconify-icon>
								</div>
				
								<div class="icon-header-item cl2 hov-cl1 trans-04 p-r-11 p-l-10 icon-header-noti js-show-cart" data-notify="2">
									<i class="zmdi zmdi-shopping-cart"></i>
								</div>
				
								<a href="#" class="dis-block icon-header-item cl2 hov-cl1 trans-04 p-r-11 p-l-10 icon-header-noti" data-notify="0">
									<i class="zmdi zmdi-favorite-outline"></i>
								</a>
							</div>
							
						</div>
						<!-- //nav -->
					</div>
				</div>
			</div>
		</header>

		<!-- //header -->

		<!-- banner -->
		<div class="banner_w3lspvt">
			<div class="csslider infinity" id="slider1">
				<input type="radio" name="slides" checked="checked" id="slides_1" />
				<input type="radio" name="slides" id="slides_2" />
				<input type="radio" name="slides" id="slides_3" />
				<input type="radio" name="slides" id="slides_4" />
				<ul>
					<li>
						<div class="banner-top">
							<div class="container">
								<div class="w3layouts-banner-info text-center">
									<h3 class="text-wh">Welcome to RoseBloom</h3>
									<p class="text-li mx-auto mt-2">Ut enim ad minim quis nostrud exerci sed do eiusmod
										tempor incididunt ut
										labore et
										dolore magna aliqua.</p>
									<a href="#about" class="button-style scroll mt-sm-5 mt-4">Read More</a>
								</div>
							</div>
						</div>
					</li>
					<li>
						<div class="banner-top1">
							<div class="container">
								<div class="w3layouts-banner-info text-center">
									<h3 class="text-wh">RoseBloom For Healthy</h3>
									<p class="text-li mx-auto mt-2">Ut enim ad minim quis nostrud exerci sed do eiusmod
										tempor incididunt ut
										labore et
										dolore magna aliqua.</p>
									<a href="#about" class="button-style scroll mt-sm-5 mt-4">Read More</a>
								</div>
							</div>
						</div>
					</li>
					<li>
						<div class="banner-top2">
							<div class="container">
								<div class="w3layouts-banner-info text-center">
									<h3 class="text-wh">Welcome to RoseBloom</h3>
									<p class="text-li mx-auto mt-2">Ut enim ad minim quis nostrud exerci sed do eiusmod
										tempor incididunt ut
										labore et
										dolore magna aliqua.</p>
									<a href="#about" class="button-style scroll mt-sm-5 mt-4">Read More</a>
								</div>
							</div>
						</div>
					</li>
					<li>
						<div class="banner-top3">
							<div class="container">
								<div class="w3layouts-banner-info text-center">
									<h3 class="text-wh">RoseBloom For Healthy</h3>
									<p class="text-li mx-auto mt-2">Ut enim ad minim quis nostrud exerci sed do eiusmod
										tempor incididunt ut
										labore et
										dolore magna aliqua.</p>
									<a href="#about" class="button-style scroll mt-sm-5 mt-4">Read More</a>
								</div>
							</div>
						</div>
					</li>
				</ul>
				<div class="arrows">
					<label for="slides_1"></label>
					<label for="slides_2"></label>
					<label for="slides_3"></label>
					<label for="slides_4"></label>
				</div>
			</div>
			<div class="icon-w3">
				<a href="#about" class="scroll">
					<i class="fa fa-angle-double-down" aria-hidden="true"></i>
				</a>
			</div>
		</div>
		<!-- //banner -->
	</div>
	<!-- //main -->

	<section class="portfolio py-5" id="gallery">
		<div class="container py-xl-5 py-lg-3">
			<h3 class="w3ls-title text-center font-weight-bold mb-5">Newest <span
					class="font-weight-light">Arrivals</span></h3>
			<div class="row pt-4">
				<div class="col-md-3 gal-grid-wthree">
					<div class="gallery-demo">
						<a href="#gal1">
							<img src="view/images/g1.jpg" alt=" " class="img-fluid" />
						</a>
					</div>
				</div>
				<div class="col-md-3 gal-grid-wthree my-md-0 my-4">
					<div class="gallery-demo">
						<a href="#gal2">
							<img src="view/images/g2.jpg" alt=" " class="img-fluid" />
						</a>
					</div>
				</div>
				<div class="col-md-3 gal-grid-wthree">
					<div class="gallery-demo">
						<a href="#gal3">
							<img src="view/images/g3.jpg" alt=" " class="img-fluid" />
						</a>
					</div>
				</div>
				<div class="col-md-3 gal-grid-wthree mt-md-0 mt-4">
					<div class="gallery-demo">
						<a href="#gal4">
							<img src="view/images/g4.jpg" alt=" " class="img-fluid" />
						</a>
					</div>
				</div>
			</div>
			<div class="row mt-4">
				<div class="col-md-3 gal-grid-wthree">
					<div class="gallery-demo">
						<a href="#gal5">
							<img src="view/images/g5.jpg" alt=" " class="img-fluid" />
						</a>
					</div>
				</div>
				<div class="col-md-3 gal-grid-wthree my-md-0 my-4">
					<div class="gallery-demo">
						<a href="#gal6">
							<img src="view/images/g6.jpg" alt=" " class="img-fluid" />
						</a>
					</div>
				</div>
				<div class="col-md-3 gal-grid-wthree">
					<div class="gallery-demo">
						<a href="#gal7">
							<img src="view/images/g7.jpg" alt=" " class="img-fluid" />
						</a>
					</div>
				</div>
				<div class="col-md-3 gal-grid-wthree mt-md-0 mt-4">
					<div class="gallery-demo">
						<a href="#gal8">
							<img src="view/images/g8.jpg" alt=" " class="img-fluid" />
						</a>
					</div>
				</div>
			</div>
		</div>
	</section>

	<!-- about -->
	<section class="about" id="about">
		<div class="container">
			<div class="row">
				<div class="col-lg-4 about-left-w3pvt offset-lg-1">
					<div class="main-img">
						<img src="view/images/ab.jpg" alt="" class="img-fluid pos-aboimg">
						<img src="view/images/ab2.jpg" alt="" class="img-fluid pos-aboimg2">
					</div>
				</div>
				<div class="col-lg-6 about-right offset-lg-1">
					<h4 class="sub-tittle-w3layouts let">About Us</h4>
					<h3 class="tittle-w3layouts text-uppercase pr-lg-5 mt-2">Duis aute irure olor in cillum solore</h3>
					<p class="mt-4 mb-5">Lorem ipsum dolor sit amet Neque porro quisquam est qui dolorem Lorem int ipsum
						dolor sit
						amet
						when an unknown printer took a galley of type.Vivamus id tempor felis.</p>
					<ul class="author list-unstyled d-flex">
						<li><img class="img-fluid rounded-circle" src="view/images/te1.jpg" alt="">
						</li>
						<li class="ml-4 mt-4"><span>Admin Name</span>Comany Name</li>
					</ul>
				</div>
			</div>
		</div>
	</section>
	<!-- //about -->

	<!-- services -->
	<div class="serives-agile py-5" id="services">
		<div class="container py-xl-5 py-lg-3">
			<div class="row support-bottom text-center">
				<div class="col-md-4 services-w3ls-grid">
					<i class="fa fa-envira" aria-hidden="true"></i>
					<h4 class="text-wh text-uppercase mt-md-5 mt-4 mb-3">Garden Care</h4>
					<p>Ut enim ad minima veniam, quis nostrum ullam corporis suscipit laboriosam.</p>
				</div>
				<div class="col-md-4 services-w3ls-grid my-md-0 my-4">
					<i class="fa fa-tree" aria-hidden="true"></i>
					<h4 class="text-wh text-uppercase mt-md-5 mt-4 mb-3">Plant Renovation</h4>
					<p>Ut enim ad minima veniam, quis nostrum ullam corporis suscipit laboriosam.</p>
				</div>
				<div class="col-md-4 services-w3ls-grid">
					<i class="fa fa-pagelines" aria-hidden="true"></i>
					<h4 class="text-wh text-uppercase mt-md-5 mt-4 mb-3">Always Fresh</h4>
					<p>Ut enim ad minima veniam, quis nostrum ullam corporis suscipit laboriosam.</p>
				</div>
			</div>
		</div>
	</div>
	<!-- //services -->

	<!-- blog -->
	<section class="w3ls-bnrbtm py-5" id="blog">
		<div class="py-xl-5 py-lg-3">
			<div class="row no-gutters">
				<div class="col-xl-5 who-left-w3pvt offset-xl-1 pt-xl-3 pr-xl-0 pr-3">
					<h3 class="w3ls-title text-da text-center font-weight-bold mb-5 pb-lg4">Latest <span
							class="font-weight-light">Blog</span></h3>
					<ul class="timeline">
						<li>
							<a href="#why" class="head-text-w3">Iste natus error sit</a>
							<a href="#why" class="float-right">21 Nov, 2018</a>
							<p>Eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis
								nostrud
								exercitation ullamco laboris.</p>
						</li>
						<li>
							<a href="#why" class="head-text-w3">Totam rem aperiam</a>
							<a href="#why" class="float-right">26 Nov, 2018</a>
							<p>Do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
								quis nostrud
								exercitation ullamco.</p>
						</li>
						<li>
							<a href="#why" class="head-text-w3">Eaque ipsa quae</a>
							<a href="#why" class="float-right">30 Nov, 2018</a>
							<p>Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim
								veniam, quis nostrud.</p>
						</li>
					</ul>
				</div>
				<div class="col-xl-6 mt-xl-0 mt-md-5 mt-4 text-xl-right text-center">
					<img class="img-fluid rounded" src="view/images/blog.jpg" alt="">
				</div>
			</div>
		</div>
	</section>
	<!-- //blog -->

	<!-- why -->
	<section class="blog_w3ls pb-5" id="why">
		<div class="container pb-xl-5 pb-lg-3">
			<h3 class="w3ls-title text-da text-center font-weight-bold mb-5 pb-lg-4">Why <span
					class="font-weight-light">Choose
					Us</span></h3>
			<div class="row">
				<!-- blog grid -->
				<div class="col-lg-4 col-md-6">
					<div class="card border-0 med-blog">
						<div class="card-header p-0">
							<a href="single.html">
								<img class="card-img-bottom" src="view/images/wh1.jpg"
									alt="Card image cap">
							</a>
						</div>
						<div class="card-body border border-top-0">
							<div class="mb-3">
								<h5 class="blog-title card-title m-0">Quality Products
								</h5>
								<div class="blog_w3icon">
									<span>
										Magna Kictum - loremipsum</span>
								</div>
							</div>
							<p>Cras ultricies ligula sed magna dictum porta auris blandita.</p>
						</div>
					</div>
				</div>
				<!-- //blog grid -->
				<!-- blog grid -->
				<div class="col-lg-4 col-md-6 mt-md-0 mt-5">
					<div class="card border-0 med-blog">
						<div class="card-header p-0">
							<a href="single.html">
								<img class="card-img-bottom" src="view/images/wh2.jpg"
									alt="Card image cap">
							</a>
						</div>
						<div class="card-body border border-top-0">
							<div class="mb-3">
								<h5 class="blog-title card-title m-0">Work Smart
								</h5>
								<div class="blog_w3icon">
									<span>
										Magna Kictum - loremipsum</span>
								</div>
							</div>
							<p>Cras ultricies ligula sed magna dictum porta auris blandita.</p>
						</div>
					</div>
				</div>
				<!-- //blog grid -->
				<!-- blog grid -->
				<div class="col-lg-4 col-md-6 mt-lg-0 mt-5">
					<div class="card border-0 med-blog">
						<div class="card-header p-0">
							<a href="single.html">
								<img class="card-img-bottom" src="view/images/wh3.jpg"
									alt="Card image cap">
							</a>
						</div>
						<div class="card-body border border-top-0">
							<div class="mb-3">
								<h5 class="blog-title card-title m-0">Excellent Services
								</h5>
								<div class="blog_w3icon">
									<span>
										Magna Kictum - loremipsum</span>
								</div>
							</div>
							<p>Cras ultricies ligula sed magna dictum porta auris blandita.</p>
						</div>
					</div>
				</div>
				<!-- //blog grid -->
			</div>
		</div>
	</section>
	<!-- //why -->

	<!-- stats-->
	<div class="stats-info py-5">
		<div class="container py-xl-5 py-lg-3">
			<h4 class="stat-text-wthree text-wh mx-auto text-center font-italic mb-sm-5 mb-4">We give you Care tips and
				Ideas on
				what style suits your garden</h4>
			<div class="row py-5">
				<div class="col-lg-3 col-sm-6 stats-grid-w3-agile">
					<div class="row">
						<div class="col-4 icon-right-w3ls text-sm-left text-center">
							<span class="fa fa-smile-o" data-blast="bgColor"></span>
						</div>
						<div class="col-8">
							<p class="counter font-weight-bold text-wh">1280</p>
							<p class="text-li mt-2" data-blast="color">Happy Customers</p>
						</div>
					</div>
				</div>
				<div class="col-lg-3 col-sm-6 stats-grid-w3-agile mt-sm-0 mt-4">
					<div class="row">
						<div class="col-4 icon-right-w3ls text-sm-left text-center">
							<span class="fa fa-shield" data-blast="bgColor"></span>
						</div>
						<div class="col-8">
							<p class="counter font-weight-bold text-wh">920</p>
							<p class="text-li mt-2" data-blast="color">Awards Win</p>
						</div>
					</div>
				</div>
				<div class="col-lg-3 col-sm-6 stats-grid-w3-agile mt-lg-0 mt-4">
					<div class="row">
						<div class="col-4 icon-right-w3ls text-sm-left text-center">
							<span class="fa fa-leaf" data-blast="bgColor"></span>
						</div>
						<div class="col-8">
							<p class="counter font-weight-bold text-wh">1400</p>
							<p class="text-li mt-2" data-blast="color">Products</p>
						</div>
					</div>
				</div>
				<div class="col-lg-3 col-sm-6 stats-grid-w3-agile mt-lg-0 mt-4">
					<div class="row">
						<div class="col-4 icon-right-w3ls text-sm-left text-center">
							<span class="fa fa-thumbs-o-up" data-blast="bgColor"></span>
						</div>
						<div class="col-8">
							<p class="counter font-weight-bold text-wh">1080</p>
							<p class="text-li mt-2" data-blast="color">Ratings</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- //stats -->

	<!-- team -->
	<div class="team py-5" id="team">
		<div class="container py-xl-5 py-lg-3">
			<h3 class="w3ls-title text-da text-center font-weight-bold mb-5 pb-xl-4">Our <span
					class="font-weight-light">Team</span></h3>
			<div class="row team-bottom pt-4 text-center">
				<div class="col-lg-3 col-sm-6 team-grid">
					<img src="view/images/t1.jpg" class="img-fluid" alt="">
					<div class="caption">
						<div class="team-text">
							<h4>Mack Joe</h4>
						</div>
						<ul>
							<li>
								<a href="#">
									<i class="fa fa-facebook f1" aria-hidden="true"></i>
								</a>
							</li>
							<li>
								<a href="#">
									<i class="fa fa-twitter f2" aria-hidden="true"></i>
								</a>
							</li>
							<li>
								<a href="#">
									<i class="fa fa-google-plus f3" aria-hidden="true"></i>
								</a>
							</li>
						</ul>
					</div>
				</div>
				<div class="col-lg-3 col-sm-6 team-grid mt-sm-0 mt-5">
					<img src="view/images/t3.jpg" class="img-fluid" alt="">
					<div class="caption">
						<div class="team-text">
							<h4>Cruz Deo</h4>
						</div>
						<ul>
							<li>
								<a href="#">
									<i class="fa fa-facebook f1" aria-hidden="true"></i>
								</a>
							</li>
							<li>
								<a href="#">
									<i class="fa fa-twitter f2" aria-hidden="true"></i>
								</a>
							</li>
							<li>
								<a href="#">
									<i class="fa fa-google-plus f3" aria-hidden="true"></i>
								</a>
							</li>
						</ul>
					</div>
				</div>
				<div class="col-lg-3 col-sm-6 team-grid mt-lg-0 mt-5">
					<img src="view/images/t2.jpg" class="img-fluid" alt="">
					<div class="caption">
						<div class="team-text">
							<h4>Rochy Jae</h4>
						</div>
						<ul>
							<li>
								<a href="#">
									<i class="fa fa-facebook f1" aria-hidden="true"></i>
								</a>
							</li>
							<li>
								<a href="#">
									<i class="fa fa-twitter f2" aria-hidden="true"></i>
								</a>
							</li>
							<li>
								<a href="#">
									<i class="fa fa-google-plus f3" aria-hidden="true"></i>
								</a>
							</li>
						</ul>
					</div>
				</div>
				<div class="col-lg-3 col-sm-6 team-grid  mt-lg-0 mt-5">
					<img src="view/images/t4.jpg" class="img-fluid" alt="">
					<div class="caption">
						<div class="team-text">
							<h4>Rojo Poy</h4>
						</div>
						<ul>
							<li>
								<a href="#">
									<i class="fa fa-facebook f1" aria-hidden="true"></i>
								</a>
							</li>
							<li>
								<a href="#">
									<i class="fa fa-twitter f2" aria-hidden="true"></i>
								</a>
							</li>
							<li>
								<a href="#">
									<i class="fa fa-google-plus f3" aria-hidden="true"></i>
								</a>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- //team -->

	<!-- testimonials -->
	<section class="clients py-5" id="testi">
		<div class="container py-xl-5 py-lg-3">
			<div class="row py-sm-5">
				<div class="col-lg-6 col-sm-8 col-10">
					<div class="feedback-top">
						<p><i class="fa fa-quote-left" aria-hidden="true"></i>Lorem ipsum dolor sit amet consectetur
							adipisicing
							elit
							sedc dnmo eiusmod. sed do eiusmod tempor
							incididunt
							ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco
							laboris nisi</p>
						<h4 class="mt-4 text-da font-weight-bold mb-4">Mary Jane</h4>
					</div>
				</div>
				<div class="col-lg-6 col-sm-4 col-2"></div>
			</div>
		</div>
	</section>
	<!-- //testimonials -->

	<!-- gallery -->

	<!-- gallery model-->
	<!-- popup-->
	<div id="gal1" class="popup-effect animate">
		<div class="popup">
			<img src="view/images/g1.jpg" alt="Popup Image" class="img-fluid" />
			<h4 class="p-mask">RoseBloom</h4>
			<a class="close" href="#gallery">&times;</a>
		</div>
	</div>
	<!-- //popup -->
	<!-- popup-->
	<div id="gal2" class="popup-effect animate">
		<div class="popup">
			<img src="view/images/g2.jpg" alt="Popup Image" class="img-fluid" />
			<h4 class="p-mask">RoseBloom</h4>
			<a class="close" href="#gallery">&times;</a>
		</div>
	</div>
	<!-- //popup -->
	<!-- popup-->
	<div id="gal3" class="popup-effect animate">
		<div class="popup">
			<img src="view/images/g3.jpg" alt="Popup Image" class="img-fluid" />
			<h4 class="p-mask">RoseBloom</h4>
			<a class="close" href="#gallery">&times;</a>
		</div>
	</div>
	<!-- //popup3 -->
	<!-- popup-->
	<div id="gal4" class="popup-effect animate">
		<div class="popup">
			<img src="view/images/g4.jpg" alt="Popup Image" class="img-fluid" />
			<h4 class="p-mask">RoseBloom</h4>
			<a class="close" href="#gallery">&times;</a>
		</div>
	</div>
	<!-- //popup -->
	<!-- popup-->
	<div id="gal5" class="popup-effect animate">
		<div class="popup">
			<img src="view/images/g5.jpg" alt="Popup Image" class="img-fluid" />
			<h4 class="p-mask">RoseBloom</h4>
			<a class="close" href="#gallery">&times;</a>
		</div>
	</div>
	<!-- //popup -->
	<!-- popup-->
	<div id="gal6" class="popup-effect animate">
		<div class="popup">
			<img src="view/images/g6.jpg" alt="Popup Image" class="img-fluid" />
			<h4 class="p-mask">RoseBloom</h4>
			<a class="close" href="#gallery">&times;</a>
		</div>
	</div>
	<!-- //popup -->
	<!-- popup-->
	<div id="gal7" class="popup-effect animate">
		<div class="popup">
			<img src="view/images/g7.jpg" alt="Popup Image" class="img-fluid" />
			<h4 class="p-mask">RoseBloom</h4>
			<a class="close" href="#gallery">&times;</a>
		</div>
	</div>
	<!-- //popup -->
	<!-- popup-->
	<div id="gal8" class="popup-effect animate">
		<div class="popup">
			<img src="view/images/g8.jpg" alt="Popup Image" class="img-fluid" />
			<h4 class="p-mask">RoseBloom</h4>
			<a class="close" href="#gallery">&times;</a>
		</div>
	</div>
	<!-- //popup -->
	<!-- popup-->
	<div id="gal9" class="popup-effect animate">
		<div class="popup">
			<img src="view/images/g9.jpg" alt="Popup Image" class="img-fluid" />
			<h4 class="p-mask">RoseBloom</h4>
			<a class="close" href="#gallery">&times;</a>
		</div>
	</div>
	<!-- //popup -->
	<!-- //gallery -->

	<!-- contact -->
	<section class="contact py-5" id="contact">
		<div class="container py-xl-5 py-lg-3">
			<h3 class="w3ls-title text-wh text-center font-weight-bold mb-5">Contact <span
					class="font-weight-light">Us</span></h3>
			<div class="row contact-form">
				<div class="offset-lg-2"></div>
				<div class="col-lg-8 wthree-form-left">
					<!-- contact form grid -->
					<fieldset class="contact-top1" data-blast="borderColor">
						<legend class="text-wh let text-capitalize">send us a note</legend>
						<form action="#" method="post" class="f-color">
							<div class="form-group">
								<label for="contactusername">Name</label>
								<input type="text" class="form-control" name="name" id="contactusername" required
									placeholder="Enter your name">
							</div>
							<div class="form-group">
								<label for="contactemail">Email</label>
								<input type="email" class="form-control" name="email" id="contactemail" required
									placeholder="Enter your Email">
							</div>
							<div class="form-group">
								<label for="contactcomment">Your Message</label>
								<textarea class="form-control" rows="5" name="message" id="contactcomment" required
									placeholder="your message"></textarea>
							</div>
							<button type="submit" class="btn btn-block" data-blast="bgColor">Send</button>
						</form>
					</fieldset>
					<!--  //contact form grid ends here -->
				</div>
				<div class="offset-lg-2"></div>
			</div>
			<!-- contact address -->
			<div class="row address bg-li">
				<div class="col-lg-4 address-grid">
					<div class="row address-info">
						<div class="col-md-3 col-4 address-left text-lg-center text-sm-right text-center">
							<i class="fa fa-envelope"></i>
						</div>
						<div class="col-md-9 col-8 address-right">
							<p>
								<a href="mailto:example@email.com"> mail 1@example.com</a>
							</p>
							<p>
								<a href="mailto:example@email.com"> mail 2@example.com</a>
							</p>
						</div>
					</div>
				</div>
				<div class="col-lg-4 address-grid my-lg-0 my-4">
					<div class="row address-info">
						<div class="col-md-3 col-4 address-left text-lg-center text-sm-right text-center">
							<i class="fa fa-phone"></i>
						</div>
						<div class="col-md-9 col-8 address-right">
							<p>+1 234 567 8901</p>
							<p>+1 567 567 9876</p>
						</div>
					</div>
				</div>
				<div class="col-lg-4 address-grid">
					<div class="row address-info">
						<div class="col-md-3 col-4 address-left text-lg-center text-sm-right text-center">
							<i class="fa fa-map"></i>
						</div>
						<div class="col-md-9 col-8 address-right">
							<p> 786 Main Road, hollies</p>
							<p> California, USA</p>
						</div>
					</div>
				</div>
			</div>
			<!-- //contact address -->
		</div>
	</section>
	<!-- //contact -->

	<!-- partners -->
	<section class="partners py-5" id="partners">
		<div class="container py-xl-5 py-4">
			<h3 class="w3ls-title text-da text-center font-weight-bold mb-5">Our <span
					class="font-weight-light">Partners</span></h3>
			<div class="row grid-part text-center pt-4">
				<div class="col-md-2 col-4">
					<div class="parts-w3pvt bg-wh">
						<a href="#"><i class="fa fa-angellist"></i></a>
					</div>
				</div>
				<div class="col-md-2 col-4">
					<div class="parts-w3pvt bg-wh">
						<a href="#"><i class="fa fa-opencart"></i></a>
					</div>
				</div>
				<div class="col-md-2 col-4">
					<div class="parts-w3pvt bg-wh">
						<a href="#"><i class="fa fa-lastfm"></i></a>
					</div>
				</div>
				<div class="col-md-2 col-4 mt-md-0 mt-3">
					<div class="parts-w3pvt bg-wh">
						<a href="#"><i class="fa fa-openid"></i></a>
					</div>
				</div>
				<div class="col-md-2 col-4 mt-md-0 mt-3">
					<div class="parts-w3pvt bg-wh">
						<a href="#"><i class="fa fa-skyatlas"></i></a>
					</div>
				</div>
				<div class="col-md-2 col-4 mt-md-0 mt-3">
					<div class="parts-w3pvt bg-wh">
						<a href="#"><i class="fa fa-ravelry"></i></a>
					</div>
				</div>
				
			</div>
		</div>
	</section>
	<!-- //partners -->

	<!-- footer -->
	<%@ include file ="view/html/footer.html" %>
	<!-- //footer -->

	<!-- move top icon -->
	<a href="#home" class="move-top text-center"></a>
	<!-- //move top icon -->


	<!-- <script src="vendor/jquery/jquery-3.2.1.min.js"></script> -->

	<script src="view/scripts/main.js"></script>
	<script src="view/scripts/product.js"></script>

</body>

</html>