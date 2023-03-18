function getProducts(event){
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
//    console.log( $(event.target).text());
    var categoryName=JSON.stringify($(event.target).text());


     $.ajax({

        type: "POST",
        url: "ProductServlet",
        dataType: "json",
         data: categoryName
        ,
         success : function(evt) {
         console.log("**");
          window.location.href="view/html/product_grid.jsp";
//location.href = "/../html/product_grid.jsp";
//             var receivedData = [];
//             console.log("**");
//             //var dataa = JSON.parse(evt.productsJson);
//             console.log(evt.productsJson[0].id);
//             // $.each(data.jsonArray, function(index) {
//             //     console.log(data.jsonArray[index])
//             // });

         }
    });
 }