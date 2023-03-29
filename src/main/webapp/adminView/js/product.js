const input = document.querySelector('input[type=file]');
function setcategory(category) {
    console.log(category);
    document.getElementById('categoryOption').value = category;

}
//input.addEventListener('change', updateImageDisplay(event));
function updateImageDisplay(event, image) {
    console.log(event.target.files[0]);
    document.getElementById(image).src = URL.createObjectURL(event.target.files[0]);
}
// private Integer id;
//     private int price;
//     private String name;
//     private int quantity;
//     private String type;
//     private String category;
//     private String description;
//     private String color;
//     private Integer size;
//     private Integer oldPrice;
//     private Timestamp createdAt;
//     private PlantdescriptionDto plantdescription;
//     private List<ProductImageDto> productImages;
function update() {
    const product = {
        id: document.getElementById("productId").value,
        price: document.getElementById("price").value,
        name: document.getElementById("name").value,
        quantity: document.getElementById("stock").value,
        // type = Plant,
        // category = Flowers,
        description: document.getElementById("description").innerHTML,
        // color = Red,
        // size = null,
        oldPrice: document.getElementById("oldPrice").value,
        //createdAt = 2023 - 03 - 14 21: 25: 39.0,
        // plantdescription = PlantdescriptionDto(sun = Full sun, soil = Well - drained soil, growthCycle = Annual, growthRate = Annual, maintenance = Low, water = Moderate),
        //productImages =[ProductImageDto(image = view / images / LAVENDER.jpg), ProductImageDto(image = view / images / LAVENDER2.jpg)]
    };
    var p = JSON.stringify(product);
    // console.log(msgg)
    $.ajax({
        type: "POST",
        url: "editProduct",
        dataType: "json",
        data: p
    });
}
// input.addEventListener('fileInput2', updateImageDisplay);
// input.addEventListener('fileInput3', updateImageDisplay);
function SomeDeleteRowFunction(id, event) {
    $.ajax({
        type: "Get",
        url: "/roseBloom/deleteProduct?ProductId=" + id,



    });
    console.log("**");
    // event.target will be the input element.
    var td = event.target.parentNode;
    var tr = td.parentNode; // the row to be removed
    console.log(tr);
    tr = tr.parentNode;
    console.log(tr);
    tr.parentNode.removeChild(tr);
}

function validateForm() {
    console.log("ss");
    var name = document.getElementById("nameInput").value;
    var desc = document.getElementById("description").value;
    var price = document.getElementById("price").value;
    var categoryOption = document.getElementById("categoryOption").value;
    var stock = document.getElementById("stock").value;
    var img1=document.getElementById("img1").getAttribute('src');
    var img2=document.getElementById("img2").getAttribute('src');
    var img3=document.getElementById("img3").getAttribute('src');
  //  console.log(img1.getAttribute('src'));
    if (name == "" || desc==""|| price==""||categoryOption == "Select Category" || stock=="") {
       // return false;
    }
   
   else if(img1=="" && img2=="" && img3=="") {
    //return false;
   }
   else {
    $("#addForm").submit();
   }
}
const form = document.querySelector('#addForm');

var namee = document.getElementById("name");
form.addEventListener('input', function (e) {
    console.log(e.target.value);
    if (e.target.id == "nameInput") {
        if (e.target.value == "") {
            document.getElementById('nameReq').style.display = "block";
        }

        else {
            document.getElementById('nameReq').style.display = "none";
        }
    }
    if (e.target.id == "categoryOption") {
        if (e.target.options[e.target.selectedIndex].text == "Select Category") {
            document.getElementById('catReq').style.display = "block";
        }

        else {
            document.getElementById('catReq').style.display = "none";
        }
    }
    if (e.target.id == "price") {
        if (e.target.value == "") {
            document.getElementById('priceReq').style.display = "block";
        }

        else {
            document.getElementById('priceReq').style.display = "none";
        }
    }
    if (e.target.id == "stock") {
        if (e.target.value == "") {
            document.getElementById('stockReq').style.display = "block";
        }

        else {
            document.getElementById('stockReq').style.display = "none";
        }
    }
    if (e.target.id == "description") {
        if (e.target.value == "") {
            document.getElementById('descReq').style.display = "block";
        }

        else {
            document.getElementById('descReq').style.display = "none";
        }
    }
});
// const form2 = document.querySelector('#addForm');
// form2.addEventListener('submit', function (e) {
//     console.log("ss");
//     var name = document.getElementById("name").value;
//     var desc = document.getElementById("description").value;
//     var price = document.getElementById("price").value;
//     var categoryOption = document.getElementById("categoryOption").value;
//     var stock = document.getElementById("stock").value;
//     if (name == "" || desc==""|| price==""||categoryOption.options[categoryOption.selectedIndex].text == "Select Category" || stock=="") {
//         e.preventDefault();
//     }
//     var img1=document.getElementById("img1").src;
//     var img2=document.getElementById("img2").src;
//     var img3=document.getElementById("img3").src;
//     console.log(img1);
//    if(img1=="" && img2=="" && img3=="") {
//     e.preventDefault();
//    }

// });
function checkIsPlant(e) {
    var e = document.getElementById("categoryOption");

    var categoryName = e.options[e.selectedIndex].text;
    $.ajax({
        type: "POST",
        url: "ViewProductsServlet",

        data: {
            categoryName: categoryName
        },
        success: function (evt) {
            const dataa = JSON.parse(evt);
            console.log(dataa);
            if (dataa == true) {
                console.log(evt);
                document.getElementById("fieldset").style.display = "block";
            }
            else {
                document.getElementById("fieldset").style.display = "none";
            }
        }
    });
}