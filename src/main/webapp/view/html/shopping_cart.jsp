<%@taglib prefix="c" uri="jakarta.tags.core" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Shopping Cart &ndash; RoseBloom </title>
    <!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous"> -->
    <!-- <link rel="stylesheet" href="style.css"> TODO CHANGE ICON-->
    <link rel="shortcut icon" href="/roseBloom/view/images/favicon.png"/>
    <!-- Plugins CSS -->
    <link rel="stylesheet" href="/roseBloom/view/style/plugins.css">
    <!-- Bootstap CSS -->
    <link rel="stylesheet" href="/roseBloom/view/style/bootstrap.min.css">
    <!-- Main Style CSS -->
    <link rel="stylesheet" href="/roseBloom/view/style/style.css">
    <link rel="stylesheet" href="/roseBloom/view/style/responsive.css">
    <!-- Main Script -->
    <script src="/roseBloom/view/scripts/cart.js"></script>
</head>

<body onload="CheckEmptyCart(${cartList})">
<!-- <header>
  <h1>Shopping Cart</h1>
</header> -->
<main>
    <%@ include file ="header.jsp" %>

    <div class="page section-header text-center">
        <div class="page-title"><br><br>
            <div class="wrapper"><h1 class="page-width">Shopping Cart</h1></div><br><br><br>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-12 col-sm-12 col-md-12 col-lg-8 main-col table-responsive">
                <!-- <div class="alert alert-success text-uppercase" role="alert">
                  <i class="icon anm anm-truck-l icon-large"></i> &nbsp;<strong>Congratulations!</strong> You've got free shipping
                </div>!-->
<%--                <form action="####" method="post" class="cart style2">--%>
                    <table class="cart___table" id="cartItemsTable">
                        <thead class="cart__row cart__header">
                        <tr>
                            <th colspan="2" class="text-center">Product</th>
                            <th class="text-center">Price</th>
<%--                            <th class="text-center small--hide">Quantity</th>--%>
                            <th class="text-center">Quantity & Total</th>
<%--                            <th class="action">&nbsp;</th>--%>
                        </tr>
                        </thead>
                        <tbody >
                        <c:forEach items="${cartList}" var="cartItem">
                            <tr id="${cartItem.product.id}" class="cart__row">
<%--                                class="cart__image-wrapper cart-flex-item"--%>
                                <td colspan="2" class="cart th  centAllig">
                                    <c:forEach var="images" items="${cartItem.product.productImages}" varStatus="status">
                                        <c:if test="${status.index == 0}">
                                            <div class="cart__image-wrapper inlineDivs">
                                            <a href="">
                                                <img class="cart__image" src="${images.image}"
                                                    alt="" width="100" height="100">
                                            </a>
                                            </div>
                                        </c:if>
                                    </c:forEach>
                                    <!-- assets/images/product-images/product-image30.jpg -->
<%--                                </td>--%>
<%--    class="cart__meta small--text-left"--%>
<%--                                <td class="cart th ">--%>
                                    <div class="list-view-item__title inlineDivs">
                                        <a class="list-view-item__title inlineDivs" href="">${cartItem.product.name} </a> <br>
<%--                                    </div>--%>

                                        <div class="cart__meta-text inlineDivs">
                                            Color: ${cartItem.product.color}<br>
                                            Size: ${cartItem.product.size}<br>
                                        </div>
                                    </div>
                                </td>
<%--    class="cart__price-wrapper text-center"--%>
                                <td class="cart th vAll">
<%--                                    <span class="money">--%>
                                        EGP ${cartItem.product.price}
<%--                                    </span>--%>
                                </td>
<%--                                cart__update-wrapper--%>
                                <td colspan="1" class="text-right cart th">
<%--                                    class="cart__qty text-center"--%>
<%--    class="qtyField"--%>
                                    <div class="qtyField">
                                        <div class="divBlock">
                                            <a class="qtyBtn minus" onclick="decreaseQuantity(event)" id="qtyPlus_${cartItem.product.id}">
<%--                                                href="javascript:void(0);"--%>
                                                <i class="icon icon-minus"></i>
                                            </a>
                                            <input class="cart__qty-input qty" type="text"  name="updates[]" id="qty_${cartItem.product.id}"
                                                   value="${cartItem.quantity}" pattern="[0-9]*" onkeydown="changeQuantityHandler(event)" onblur="changeQuantityTo(event)" disabled>
<%--                                            TODO we may add this functionality--%>
                                            <a class="qtyBtn plus" id="qtyMinus_${cartItem.product.id}" onclick="increaseQuantity(event)">
                                                <i class="icon icon-plus"></i>
                                            </a>
                                        </div>



<%--                                </td>--%>
<%--&lt;%&ndash;    small--hide cart-price&ndash;%&gt;--%>
<%--                                <td class="text-right cart th">--%>
<%--    class="cart__qty"--%>

<%--                                </td>--%>
<%--                                <td class="text-center small--hide">--%>
<%--    class="cart__qty"--%>
                                        <div class="inlineDivs marginsoforDivs">EGP
                                            <div class="">${cartItem.quantity*cartItem.product.price}</div>
                                            <a class="btn btn--secondary cart__remove" title="Remove Item" id="remove_${cartItem.product.id}" onclick="deleteCartItem(event)">
                                                <i class="icon icon anm anm-times-l"></i>
                                            </a>
                                        </div>
                                    </div>
                                    <div class="errorMessage" id = "error_${cartItem.product.id}">dfghfgdhfdgh</div>
                                </td>
                            </tr>
                        </c:forEach>

                        </tbody>
                        <tfoot>
                        <tr>
                            <td colspan="2" class="text-left">
                                <a href="/roseBloom/" class="btn btn-secondary btn--small cart-continue">
                                    Continue shopping
                                </a>
                            </td>
                            <td colspan="3" class="text-right">
                                <button type="submit" name="clear" class="btn btn-secondary btn--small  small--hide" id="clearCartBtn">
                                    Clear Cart
                                </button>
<%--                                <button type="submit" name="update"--%>
<%--                                        class="btn btn-secondary btn--small cart-continue ml-2">Update Cart--%>
<%--                                </button>--%>
                            </td>
                        </tr>
                        </tfoot>
                    </table>
<%--                </form>--%>
            </div>
            <div class="col-12 col-sm-12 col-md-12 col-lg-4 cart__footer" id="CartMoney">
                <div class="solid-border">
                    <div class="row border-bottom pb-2">
                        <span class="col-12 col-sm-6 cart__subtotal-title">Subtotal</span>
                        <span class="col-12 col-sm-6 text-right">EGP <span class="money" id="subtotal">${total}</span></span>
                    </div>
<%--                    <div class="row border-bottom pb-2 pt-2">--%>
<%--                        <span class="col-12 col-sm-6 cart__subtotal-title">Tax</span>--%>
<%--                        <span class="col-12 col-sm-6 text-right">EGP 10.00</span>--%>
<%--                    </div>--%>
                    <div class="row border-bottom pb-2 pt-2">
                        <span class="col-12 col-sm-6 cart__subtotal-title">Shipping</span>
                        <span class="col-12 col-sm-6 text-right">EGP <span id="shipping">50</span></span>
                    </div>
                    <div class="row border-bottom pb-2 pt-2">
                        <span class="col-12 col-sm-6 cart__subtotal-title"><strong>Grand Total</strong></span>
                        <span class="col-12 col-sm-6 cart__subtotal-title cart__subtotal text-right">EGP <span
                                class="money">${total+50}</span></span>
                    </div>
<%--                    <div class="cart__shipping">Shipping &amp; taxes calculated at checkout</div>--%>
<%--                    <p class="cart_tearm">--%>
<%--                        <label>--%>
<%--                            <input type="checkbox" name="tearm" class="checkbox" value="tearm" required="">--%>
<%--                            I agree with the terms and conditions--%>
<%--                        </label>--%>
<%--                    </p>--%>
                    <form method="POST" action="Checkout" id="CheckoutButton">
                        <input type="submit" name="checkout" id="cartCheckout" class="btn btn--small-wide checkout"
                               value="Proceed To Checkout">
                    </form>
                    <!-- <div class="paymnet-img"><img src="assets/images/payment-img.jpg" alt="Payment"></div>
                    <p><a href="#;">Checkout with Multiple Addresses</a></p> -->
                </div>
            </div>
        </div>
    </div>
    <%@ include file ="footer.html" %>
    <!-- <section class="cart-summary">
      <h2>Cart Summary</h2>
      <ul>
        <li>
          <span>Subtotal:</span>
          <span>$44.98</span>
        </li>
        <li>
          <span>Tax:</span>
          <span>$4.50</span>
        </li>
        <li>
          <span>Total:</span>
          <span>$49.48</span>
        </li>
      </ul>
      <button>Checkout</button>
    </section> -->
</main>

<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"--%>
<%--        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"--%>
<%--        crossorigin="anonymous"></script>--%>
</body>
</html>
