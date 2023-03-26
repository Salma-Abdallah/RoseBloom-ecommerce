<%--
  Created by IntelliJ IDEA.
  User: abdo_
  Date: 25/03/2023
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Checkout</title>
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
<body>

<main>
  <div class="page section-header text-center">
    <div class="page-title">
      <div class="wrapper"><h1 class="page-width">Shopping Cart</h1></div>
    </div>
  </div>
  <div class="container">
    <div class="row">
      <div class="col-12 col-sm-12 col-md-12 col-lg-8 main-col">
        <!-- <div class="alert alert-success text-uppercase" role="alert">
          <i class="icon anm anm-truck-l icon-large"></i> &nbsp;<strong>Congratulations!</strong> You've got free shipping
        </div>!-->
        <%--                <form action="####" method="post" class="cart style2">--%>
        <table class="cart___table">
          <thead class="cart__row cart__header">
          <tr>
            <th colspan="2" class="text-center">Product</th>
<%--            <th class="text-center">Price</th>--%>
            <th class="text-center small--hide">Quantity</th>
            <th class="text-right">Total</th>
            <%--                            <th class="action">&nbsp;</th>--%>
          </tr>
          </thead>
          <tbody>
          <c:forEach items="${cartList}" var="cartItem">
            <tr id="${cartItem.product.id}">
                <%--                                class="cart__image-wrapper cart-flex-item"--%>
              <td colspan="2" class="cart th  ">
                <c:forEach var="images" items="${cartItem.product.productImages}" varStatus="status">
                  <c:if test="${status.index == 0}">
                    <div class="cart__image-wrapper inlineDivs">
                      <a href="">
                        <img class="cart__image" src="${images.image}"
                             alt="Elastic Waist Dress - Navy / Small" >
                      </a>
                    </div>
                  </c:if>
                </c:forEach>
                <div class="list-view-item__title inlineDivs">
                  <a class="list-view-item__title inlineDivs" href="">${cartItem.product.name} </a> <br>

                  <div class="cart__meta-text inlineDivs">
                    Color: ${cartItem.product.color}<br>
                    Size: ${cartItem.product.size}<br>
                  </div>
                </div>
              </td>

<%--              <td class="cart th ">--%>
<%--                EGP ${cartItem.product.price}--%>
<%--              </td>--%>
              <td colspan="2" class="text-right cart th">
                <div class="qtyField">
                      ${cartItem.quantity}
                </div>
                <div class="inlineDivs marginsoforDivs">
                  EGP ${cartItem.quantity*cartItem.product.price}
                </div>
              </td>
            </tr>
          </c:forEach>

          </tbody>
        </table>
        <%--                </form>--%>
      </div>

      <div class="col-12 col-sm-12 col-md-12 col-lg-4 cart__footer">
        <div class="solid-border">

          <div class="row border-bottom pb-2">
            <span class="col-12 col-sm-6 cart__subtotal-title">Subtotal</span>
            <span class="col-12 col-sm-6 text-right">EGP <span class="money" id="subtotal">${total}</span></span>
          </div>
          <div class="row border-bottom pb-2 pt-2">
            <span class="col-12 col-sm-6 cart__subtotal-title">Shipping</span>
            <span class="col-12 col-sm-6 text-right">EGP <span id="shipping">50</span></span>
          </div>
          <div class="row border-bottom pb-2 pt-2">
            <span class="col-12 col-sm-6 cart__subtotal-title"><strong>Grand Total</strong></span>
            <span class="col-12 col-sm-6 cart__subtotal-title cart__subtotal text-right">EGP <span
                    class="money">${total+50}</span></span>
          </div>
          <input type="submit" name="checkout" id="cartCheckout" class="btn btn--small-wide checkout"
                 value="Proceed To Checkout" disabled="disabled">
        </div>
      </div>

      <div class="col-12 col-sm-12 col-md-12 col-lg-4 cart__footer">
        <div class="solid-border">
          <div class="row border-bottom pb-2">
            <span class="col-12 col-sm-6 cart__subtotal-title">Subtotal</span>
            <span class="col-12 col-sm-6 text-right">EGP <span class="money" id="subtotal">${total}</span></span>
          </div>
          <div class="row border-bottom pb-2 pt-2">
            <span class="col-12 col-sm-6 cart__subtotal-title">Shipping</span>
            <span class="col-12 col-sm-6 text-right">EGP <span id="shipping">50</span></span>
          </div>
          <div class="row border-bottom pb-2 pt-2">
            <span class="col-12 col-sm-6 cart__subtotal-title"><strong>Grand Total</strong></span>
            <span class="col-12 col-sm-6 cart__subtotal-title cart__subtotal text-right">EGP <span
                    class="money">${total+50}</span></span>
          </div>
          <input type="submit" name="checkout" id="cartCheckout" class="btn btn--small-wide checkout"
                 value="Proceed To Checkout" disabled="disabled">
        </div>
      </div>
    </div>
  </div>
</main>
</body>
</html>

