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
function SomeDeleteRowFunction(id,event) {
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
    var name=document.getElementById("name").value;
    if(name=="")
        return false;
}
const form = document.querySelector('#addForm');


form.addEventListener('submit', function (e) {
    var name=document.getElementById("name").value;
    if(name=="")
    // prevent the form from submitting
        e.preventDefault();

});
function checkIsPlant() {
    var e = document.getElementById("categoryOption");

    var categoryName = e.options[e.selectedIndex].text;
    $.ajax({
        type: "POST",
        url: "ViewProductsServlet",
        
        data:{
            categoryName : categoryName
        },
        success: function (evt) {
           
            if(evt="true") {
                console.log(evt);
                document.getElementById("fieldset").style.display = "block";
            }
            else
            {
                document.getElementById("fieldset").style.display = "none";
            }
        }
    });
}