function getProducts(event) {
    //var req;
    // if (window.XMLHttpRequest)
    //        req2 = new XMLHttpRequest();
    //    else if
    //        (window.ActiveXObject) req2 = new
    //            ActiveXObject(Microsoft.XMLHTTP);
    //    //req2.onreadystatechange = handleStateChange;
    //    //var yourvalue = document.getElementById("name").value;
    //    url = "/roseBloom/OpenProductsPageServlet" + "?category=" + $(event.target).text() ;
    //    req2.open("GET", url, true);
    //    req2.send(null);
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

                    '<div class="product-image" >' +

                    ' <a href="#">' +

                    '<div class="gallery-demo">' +

                    ' <img src="'+dataa.productsJson[i].productImages[0].image+'" alt=" " class="img-fluid" />' +

                    '</div>' +
                    ' <!-- End image -->' +
                    ' <!-- Hover image -->' +
                    '<img class="hover blur-up lazyload"' +
                    'data-src="'+dataa.productsJson[i].productImages[1].image+'"' +
                    ' src="'+dataa.productsJson[i].productImages[1].image+'" alt="image"' +
                    ' title="product">' +
                    '<!-- End hover image -->' +
                    '  <!-- product label -->' +
                    ' <div class="product-labels rectangular">' +
                    '<span class="lbl on-sale">-16%</span>' +
                    ' <span class="lbl pr-label1">new</span></div>' +
                    '  <!-- End product label -->' +
                    '  </a>' +
                    '<!-- end product image -->' +
                    ' <!-- Start product button -->' +
                    '  <form class="variants add" action="#"' +
                    'onclick="window.location.href="cart.html" " method="post">' +
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
                    '   <a href="#">LAVENDER</a>' +
                    '  </div>' +
                    '   <!-- End product name -->' +
                    '<!-- product price -->' +
                    '   <div class="product-price">' +
                    '<span class="old-price">EGP 45.00</span>' +
                    '  <span class="price">EGP 25.00</span>' +
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
            // $("#grid--view-items").append("<p>helloo </p>");
        }
        // $.each(data.jsonArray, function(index) {
        //     console.log(data.jsonArray[index])
    });
}
//         console.log("**");
//          window.location.href="view/html/product_grid.jsp";
//location.href = "/../html/product_grid.jsp";
//             var receivedData = [];
//             console.log("**");
//             //var dataa = JSON.parse(evt.productsJson);
//             console.log(evt.productsJson[0].id);
//             // $.each(data.jsonArray, function(index) {
//             //     console.log(data.jsonArray[index])
//             // });


