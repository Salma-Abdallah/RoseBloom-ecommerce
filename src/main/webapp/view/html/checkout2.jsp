<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<!-- belle/checkout.html   11 Nov 2019 12:44:33 GMT -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Checkout &ndash; Belle Multipurpose Bootstrap 4 Template</title>
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

            <div class="row billing-fields">
                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12 sm-margin-30px-bottom">
                    <div class="create-ac-content bg-light-gray padding-20px-all">
                        <form>
                            <fieldset>
                                <h2 class="login-title mb-3">Billing details</h2>
                                <div class="row">
                                    <div class="form-group col-md-6 col-lg-6 col-xl-6 required">
<%--                                        TODO Load user data--%>
                                        <label>Name</label><br>
                                        <label id ="username" class="UserInfolabels"> asdasd</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="form-group col-md-6 col-lg-6 col-xl-6 required">
                                        <label>Telephone </label><br>
                                        <label id="phoneNumber" class="UserInfolabels"> aasd</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="form-group col-md-6 col-lg-6 col-xl-6 required">
                                        <label for=>E-Mail</label><br>
                                        <label id="email" class="UserInfolabels"> asdasd</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="form-group col-md-6 col-lg-6 col-xl-6 required">
                                        <label>Address</label><br>
                                        <label>
                                            <input type="radio" name="answer" value="userAddress" id="currentAddressBtn" checked>
                                            Current Address<br>
                                            <span id="address">asdasdsda</span><br>
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
                                <div class="payment-accordion UserInfolabels"> Credit Limit
<!--                                    <div id="accordion" class="payment-section">-->
<!--                                        <div class="card mb-2">-->
<!--                                            <div class="card-header">-->
<!--                                                <a class="card-link" data-toggle="collapse" href="#collapseOne">Direct Bank Transfer </a>-->
<!--                                            </div>-->
<!--                                            <div id="collapseOne" class="collapse" data-parent="#accordion">-->
<!--                                                <div class="card-body">-->
<!--                                                    <p class="no-margin font-15">Make your payment directly into our bank account. Please use your Order ID as the payment reference. Your order won't be shipped until the funds have cleared in our account.</p>-->
<!--                                                </div>-->
<!--                                            </div>-->
<!--                                        </div>-->
<!--                                        <div class="card mb-2">-->
<!--                                            <div class="card-header">-->
<!--                                                <a class="collapsed card-link" data-toggle="collapse" href="#collapseTwo">Cheque Payment</a>-->
<!--                                            </div>-->
<!--                                            <div id="collapseTwo" class="collapse" data-parent="#accordion">-->
<!--                                                <div class="card-body">-->
<!--                                                    <p class="no-margin font-15">Please send your cheque to Store Name, Store Street, Store Town, Store State / County, Store Postcode.</p>-->
<!--                                                </div>-->
<!--                                            </div>-->
<!--                                        </div>-->
<!--                                        <div class="card margin-15px-bottom border-radius-none">-->
<!--                                            <div class="card-header">-->
<!--                                                <a class="collapsed card-link" data-toggle="collapse" href="#collapseThree"> PayPal </a>-->
<!--                                            </div>-->
<!--                                            <div id="collapseThree" class="collapse" data-parent="#accordion">-->
<!--                                                <div class="card-body">-->
<!--                                                    <p class="no-margin font-15">Pay via PayPal; you can pay with your credit card if you don't have a PayPal account.</p>-->
<!--                                                </div>-->
<!--                                            </div>-->
<!--                                        </div>-->
<!--                                        <div class="card mb-2">-->
<!--                                            <div class="card-header">-->
<!--                                                <a class="collapsed card-link" data-toggle="collapse" href="#collapseFour"> Payment Information </a>-->
<!--                                            </div>-->
<!--                                            <div id="collapseFour" class="collapse" data-parent="#accordion">-->
<!--                                                <div class="card-body">-->
<!--                                                    <fieldset>-->
<!--                                                        <div class="row">-->
<!--                                                            <div class="form-group col-md-6 col-lg-6 col-xl-6 required">-->
<!--                                                                <label for="input-cardname">Name on Card <span class="required-f">*</span></label>-->
<!--                                                                <input name="cardname" value="" placeholder="Card Name" id="input-cardname" class="form-control" type="text">-->
<!--                                                            </div>-->
<!--                                                            <div class="form-group col-md-6 col-lg-6 col-xl-6 required">-->
<!--                                                                <label for="input-country">Credit Card Type <span class="required-f">*</span></label>-->
<!--                                                                <select name="country_id" class="form-control">-->
<!--                                                                    <option value=""> -&#45;&#45; Please Select -&#45;&#45; </option>-->
<!--                                                                    <option value="1">American Express</option>-->
<!--                                                                    <option value="2">Visa Card</option>-->
<!--                                                                    <option value="3">Master Card</option>-->
<!--                                                                    <option value="4">Discover Card</option>-->
<!--                                                                </select>-->
<!--                                                            </div>-->
<!--                                                        </div>-->
<!--                                                        <div class="row">-->
<!--                                                            <div class="form-group col-md-6 col-lg-6 col-xl-6 required">-->
<!--                                                                <label for="input-cardno">Credit Card Number  <span class="required-f">*</span></label>-->
<!--                                                                <input name="cardno" value="" placeholder="Credit Card Number" id="input-cardno" class="form-control" type="text">-->
<!--                                                            </div>-->
<!--                                                            <div class="form-group col-md-6 col-lg-6 col-xl-6 required">-->
<!--                                                                <label for="input-cvv">CVV Code <span class="required-f">*</span></label>-->
<!--                                                                <input name="cvv" value="" placeholder="Card Verification Number" id="input-cvv" class="form-control" type="text">-->
<!--                                                            </div>-->
<!--                                                        </div>-->
<!--                                                        <div class="row">-->
<!--                                                            <div class="form-group col-md-6 col-lg-6 col-xl-6 required">-->
<!--                                                                <label>Expiration Date <span class="required-f">*</span></label>-->
<!--                                                                <input type="date" name="exdate" class="form-control">-->
<!--                                                            </div>-->
<!--                                                            <div class="form-group col-md-6 col-lg-6 col-xl-6 required">-->
<!--                                                                <img class="padding-25px-top xs-padding-5px-top" src="assets/images/payment-img.jpg" alt="card" title="card" />-->
<!--                                                            </div>-->
<!--                                                        </div>-->
<!--                                                    </fieldset>-->

<!--                                                </div>-->
<!--                                            </div>-->
<!--                                        </div>-->
<!--                                    </div>-->
                                </div>

                                <div class="order-button-payment">
                                    <button class="btn" value="Place order" onclick="placeOrder()">Place order</button>
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