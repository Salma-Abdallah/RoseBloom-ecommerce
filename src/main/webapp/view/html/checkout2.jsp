<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<!-- belle/checkout.html   11 Nov 2019 12:44:33 GMT -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Checkout &ndash; RoseBloom</title>
<meta name="description" content="description">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Favicon -->
<link rel="shortcut icon" href="/roseBloom/view/images/favicon.png" />
<!-- Plugins CSS -->
<link rel="stylesheet" href="/roseBloom/view/style/plugins.css">
<!-- Bootstap CSS -->
<link rel="stylesheet" href="/roseBloom/view/style/bootstrap.min.css">
<!-- Main Style CSS -->
<link rel="stylesheet" href="/roseBloom/view/style/style.css">
<link rel="stylesheet" href="/roseBloom/view/style/responsive.css">

<body class="page-template belle">
<%@ include file="header.jsp" %>
<div class="pageWrapper">
    <!--Body Content-->
    <div id="page-content">
    	<!--Page Title-->
    	<div class="page section-header text-center">
			<div class="page-title">
        		<div class="wrapper"><h1 class="page-width">Checkout</h1></div>
      		</div>
		</div>
        <!--End Page Title-->
        
        <div class="container">

            <div class="row billing-fields mar-top">
                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12 sm-margin-30px-bottom">
                    <div class="create-ac-content bg-light-gray padding-20px-all">
                        <form>
                            <fieldset>
                                <h2 class="login-title mb-3">Billing details</h2>
                                <div class="row">
                                    <div class="form-group col-md-6 col-lg-6 col-xl-6 required">
                                        <label>Name</label><br>
                                        <label id ="username" class="UserInfolabels"> ${sessionScope.User.name}</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="form-group col-md-6 col-lg-6 col-xl-6 required">
                                        <label>Telephone </label><br>
                                        <label id="phoneNumber" class="UserInfolabels"> ${sessionScope.User.phone}</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="form-group col-md-6 col-lg-6 col-xl-6 required">
                                        <label for=>E-Mail</label><br>
                                        <label id="email" class="UserInfolabels"> ${sessionScope.User.email}</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="form-group col-md-6 col-lg-6 col-xl-6 required">
                                        <label>Address</label><br>
                                        <label>
                                            <input type="radio" name="answer" value="userAddress" id="currentAddressBtn" checked>
                                            Current Address<br>
                                            <span id="address">${sessionScope.User.address}</span><br>
                                        </label><br>
                                        <label>
                                            <input type="radio" name="answer" value="userAddress" id="diffAddressBtn" >
                                            Different Address<br>
                                        </label>
                                        <input type="text" id="differentAddress" style="display:none;">
                                    </div>
                                </div>
                            </fieldset>
                        </form>
                    </div>
                </div>

                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12">
                    <div class="your-order-payment">
                        <div class="your-order">
                            <h2 class="order-title mb-4">Your Order</h2>

                            <div class="table-responsive-sm order-table"> 
                                <table class="bg-white table table-bordered table-hover text-center">
                                    <thead>
                                        <tr>
                                            <th class="text-left">Product Name</th>
                                            <th>Price</th>
                                            <th>Size</th>
                                            <th>color</th>
                                            <th>Qty</th>
                                            <th>Subtotal</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${cartList}" var="cartItem">
                                            <tr>
                                                <td class="text-left">${cartItem.product.name}</td>
                                                <td>EGP ${cartItem.product.price}</td>
                                                <td>${cartItem.product.size}</td>
                                                <td>${cartItem.product.color}</td>
                                                <td>${cartItem.quantity}</td>
                                                <td>EGP ${cartItem.quantity*cartItem.product.price}</td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                    <tfoot class="font-weight-600">
                                        <tr>
                                            <td colspan="5" class="text-right">Shipping </td>
                                            <td>EGP 50</td>
                                        </tr>
                                        <tr>
                                            <td colspan="5" class="text-right">Total</td>
                                            <td>EGP ${total+50}</td>
                                        </tr>
                                    </tfoot>
                                </table>
                            </div>
                        </div>
                        
                        <hr />

                        <div class="your-payment">
                            <h2 class="payment-title mb-3">payment method</h2>
                            <div class="payment-method">
                                <div class="payment-accordion UserInfolabels">
                                    Credit Limit<br>
                                    Availabe: EGP ${sessionScope.User.creditLimit}<br>

                                </div>

                                <div class="order-button-payment">
                                    <button class="btn" value="Place order" onclick="placeOrder()">Place order</button>
                                </div>
                                <div class="errorMessage" id="placeOrderErrorMessage">

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
    </div>
    <!--End Body Content-->

    <!--Scoll Top-->
    <span id="site-scroll"><i class="icon anm anm-angle-up-r"></i></span>
    <!--End Scoll Top-->
    <%@ include file ="footer.html" %>
     <!-- Including Jquery -->
     <script src="/roseBloom/view/scripts/vendor/jquery-3.3.1.min.js"></script>
     <script src="/roseBloom/view/scripts/vendor/jquery.cookie.js"></script>
     <script src="/roseBloom/view/scripts/vendor/modernizr-3.6.0.min.js"></script>
     <script src="/roseBloom/view/scripts/vendor/wow.min.js"></script>
     <!-- Including Javascript -->
     <script src="/roseBloom/view/scripts/bootstrap.min.js"></script>
     <script src="/roseBloom/view/scripts/plugins.js"></script>
     <script src="/roseBloom/view/scripts/popper.min.js"></script>
     <script src="/roseBloom/view/scripts/lazysizes.js"></script>
     <script src="/roseBloom/view/scripts/main.js"></script>
    <script src="/roseBloom/view/scripts/checkout.js"></script>
</div>
</body>

<!-- belle/checkout.html   11 Nov 2019 12:44:33 GMT -->
</html>