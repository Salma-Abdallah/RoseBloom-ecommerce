<!------ Include the above in your HEAD tag ---------->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="cd" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>RoseBloom Product Detail</title>

    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700" rel="stylesheet">
    <link rel="shortcut icon" href="/roseBloom/view/images/favicon.png"/>
    <!-- Plugins CSS -->
    <link rel="stylesheet" href="/roseBloom/view/style/plugins.css">
    <!-- Bootstap CSS -->
    <link rel="stylesheet" href="/roseBloom/view/style/bootstrap.min.css">
    <!-- Main Style CSS -->
    <link rel="stylesheet" href="/roseBloom/view/style/style.css">
    <link rel="stylesheet" href="/roseBloom/view/style/responsive.css">
    <link rel="stylesheet" href="view/style/product_style.css">

    <script src="/roseBloom/view/scripts/cart.js"></script>
    <style>
        .table td, .table th {
        border: 1px solid #dee2e6;
        }
    </style>
</head>

<body>
<main>
    <%@ include file ="header.jsp" %>

    <div class="container">
        <div class="card" style="background-color: white;">
            <div class="container-fliud">
                <div class="wrapper row">
                    <div class="preview col-md-6">

                        <div class="preview-pic tab-content">
                         
                           

                            <div class="tab-pane active" id="pic-1"><img class="prod_detail_img" src="${product.productImages.get(0).image}" /></div>
                            <cd:if test="${fn:length(product.productImages) >1}">
                                <div class="tab-pane" id="pic-2"><img class="prod_detail_img" src="${product.productImages.get(1).image}" /></div>
                            </cd:if>
                            <cd:if test="${fn:length(product.productImages) >2}">
                                <div class="tab-pane" id="pic-3"><img class="prod_detail_img" src="${product.productImages.get(2).image}" /></div>
                            </cd:if>


                       
                        </div>
                        <ul class="preview-thumbnail nav nav-tabs">
                            <li class="active"><a data-target="#pic-1" data-toggle="tab"><img class="prod_detail_img" style="height: 100px;" src="${product.productImages.get(0).image}" /></a></li>
                            <cd:if test="${fn:length(product.productImages) >1}">
                                <li><a data-target="#pic-2" data-toggle="tab"><img class="prod_detail_img" style="height: 100px;" src="${product.productImages.get(1).image}" /></a></li>
                            </cd:if>
                            <cd:if test="${fn:length(product.productImages) >2}">
                                <li><a data-target="#pic-3" data-toggle="tab"><img class="prod_detail_img" style="height: 100px;" src="${product.productImages.get(2).image}" /></a></li>
                            </cd:if>

                        </ul>

                    </div>
                    <div class="details col-md-6">
                        <h3 class="product-title">${product.name}</h3>
<%--                        <div class="rating">--%>
<%--                            <div class="stars">--%>
<%--                                <span class="fa fa-star checked"></span>--%>
<%--                                <span class="fa fa-star checked"></span>--%>
<%--                                <span class="fa fa-star checked"></span>--%>
<%--                                <span class="fa fa-star"></span>--%>
<%--                                <span class="fa fa-star"></span>--%>
<%--                            </div>--%>
<%--                            <span class="review-no">41 reviews</span>--%>
<%--                        </div>--%>
                        <br>
                        <p class="product-description">${product.description}</p>
                        <h4 class="price">Price: <span>EGP ${product.price}</span></h4>
<%--                        <p class="vote"><strong>91%</strong> of buyers enjoyed this product! <strong>(87 votes)</strong>--%>
<%--                        </p>--%>
                        <h4 class="sizes">Colour: ${product.color}</h4>
                        <h4 class="sizes">size: ${product.size}</h4>


                        <div class="quantity">
                            Quantity:
                            <a href="#" class="quantity__minus"><span>-</span></a>
                            <input name="quantity" id="quantityFieldId" type="text" class="quantity__input" value="1" disabled>
                            <a href="#" class="quantity__plus"><span>+</span></a>
                        </div>

                        <label class="errorMessage" id="errorMessageFieldId"></label><br>
                        <div class="action">
                            <button class="add-to-cart btn btn-default" type="button" id="add_${product.id}"
                                    onclick='addToCart(event, document.getElementById("quantityFieldId").value, "${current.id}", "${current.name}", "${current.productImages[0].image}" , "${current.color}", "${current.price}")'>add to cart</button>
<%--                            <button class="like btn btn-default" type="button"><span--%>
<%--                                    class="fa fa-heart"></span></button>--%>
                        </div>
                        <label class="successMessageField" id="successMessageFieldId"></label><br>
                    </div>



                </div>
            </div>

            <cd:if test="${not empty product.plantdescription.sun}">
                <div class=" mt-5 text-center">
                    <img src="view/images/leaves1.PNG" />
                    <div>
                        <table class=" table">

                            <tbody>
                                <tr>
                                    <th scope="row">Sun</th>
                                    <td>${product.plantdescription.sun}</td>
    <%--                                <td>image</td>--%>
                                </tr>
                                <tr>
                                    <th scope="row">Soil</th>
                                    <td>${product.plantdescription.soil}</td>
    <%--                                <td>Thornton</td>--%>
                                </tr>
                                <tr>
                                    <th scope="row">Water</th>
                                    <td>${product.plantdescription.water}</td>
    <%--                                <td>the Bird</td>--%>
                                </tr>
                                <tr>
                                    <th scope="row">Growth Cycle</th>
                                    <td>${product.plantdescription.growthCycle}</td>
    <%--                                <td>the Bird</td>--%>
                                </tr>
                                <tr>
                                    <th scope="row">Growth Rate</th>
                                    <td>${product.plantdescription.growthRate}</td>
    <%--                                <td>the Bird</td>--%>
                                </tr>
                                <tr>
                                    <th scope="row">maintenance</th>
                                    <td>${product.plantdescription.maintenance}</td>
    <%--                                <td>the Bird</td>--%>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <img src="view/images/leaves1.PNG" />
                </div>
            </cd:if>

        </div>
    </div>
    <%@ include file ="footer.html" %>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

    <script src="view/scripts/productsScript.js"></script>

</main>
</body>

</html>