function getProducts(event) {

    console.log($("#categoryName").text());
    var categoryName = JSON.stringify($("#categoryName").text());


    $.ajax({

        type: "GET",
        url: "/roseBloom/ProductServlet" + "?categoryName=" + categoryName,


        success: function (evt) {

            var receivedData = [];
            console.log("**");
            const dataa = JSON.parse(evt);
            for (let i = 0; i < dataa.productsJson.length; i++) {
                console.log(dataa.productsJson[i].productImages[0].image);
                $("#grid--view-items").append('<div class="col-6 col-sm-6 col-md-4 col-lg-2 item">' +
                   ' <jsp:useBean id="category" class="com.rosebloom.dtos.CategoryDto" scope="session" >'+
                        '<jsp:setProperty name="category" property="categoryId"'+
                           ' value='+dataa.productsJson[i].id+'/>'+
                        '<div class="product-image"  style="height:200px">' +
                     
                            ' <a href="../../productDetails?productId='+dataa.productsJson[i].id+'">' +

                                '<img class="primary blur-up lazyload" data-src="' + dataa.productsJson[i].productImages[0].image + '"' +
                                ' src="' + dataa.productsJson[i].productImages[0].image + '" alt="image"' +
                    'title="product">' +

                                ' <img class="hover blur-up lazyload"' +
                                '  data-src="' + dataa.productsJson[i].productImages[1].image + '"' +
                                'src="' + dataa.productsJson[i].productImages[1].image + '" alt="image"' +
                    'title="product">' +
                                '  </a>' +
                            '<!-- end product image -->' +
                            ' <!-- Start product button -->' +
                            '  <form class="variants add" action="#"' +
                    'onclick="window.location.href="productDetails.jsp" " method="post">' +
                            '  <button class="btn btn-addto-cart" type="button">ADD TO CART</button>' +
                            '</form>' +
                        ' <div class="button-set">' +
                            '   <a href="javascript:void(0)" title="Quick View"' +
                            ' class="quick-view-popup quick-view" data-toggle="modal"' +
                    ' data-target="#content_quickview">' +
                            ' <i class="icon anm anm-search-plus-r"></i>' +
                            '  </a>' +
                        '<div class="wishlist-btn">' +
                            '  <a class="wishlist add-to-wishlist" href="#"' +
                    ' title="Add to Wishlist">' +
                            ' <i class="icon anm anm-heart-l"></i>' +
                            ' </a>' +
                        '  </div>' +

                    '  </div>' +
                    ' <!-- end product button -->' +
                    ' </div>' +
                    '  <!-- end product image -->' +

                    '  <!--start product details -->' +
                    ' <div class="product-details text-center">' +

                    '  <div class="product-name">' +
                    '   <a href="#">' + dataa.productsJson[i].name + '</a>' +
                    '  </div>' +
                    '   <!-- End product name -->' +
                    '<!-- product price -->' +
                    '   <div class="product-price">' +

                    // '<span class="old-price">EGP '+dataa.productsJson[i].oldPrice+'</span>' +
                    '  <span class="price">EGP ' + dataa.productsJson[i].price + '</span>' +
                    '   </div>' +
                    '<!-- End product price -->' +

                    ' <div class="product-review">' +
                    '<i class="font-13 fa fa-star"></i>' +
                    ' <i class="font-13 fa fa-star"></i>' +
                    '    <i class="font-13 fa fa-star"></i>' +
                    '<i class="font-13 fa fa-star-o"></i>' +
                    ' <i class="font-13 fa fa-star-o"></i>' +
                    '</div></div>' +
                    '   <!-- End product details -->' +
                    ' </div>');
            }

        }

    });
}


