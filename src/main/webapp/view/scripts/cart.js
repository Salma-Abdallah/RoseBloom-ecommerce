console.log("START");

function CheckEmptyCart(cartList){
    console.log(cartList);
    if(cartList== undefined || cartList.length==0){
        let CartMoney = document.getElementById("CartMoney");
        let parent = CartMoney.parentNode;
        parent.removeChild(CartMoney);

        let clearCartBtn = document.getElementById("clearCartBtn");
        let parent2 = clearCartBtn.parentNode;
        parent2.removeChild(clearCartBtn);

        if (window.XMLHttpRequest) emptyCartRequest = new XMLHttpRequest();
        else if (window.ActiveXObject) emptyCartRequest = new ActiveXObject(Microsoft.XMLHTTP);

        emptyCartRequest.open("GET", "/roseBloom/view/html/emptyCart.html", true);
        emptyCartRequest.onload = function() {
            if (emptyCartRequest.status === 200) {
                document.getElementById("cartItemsTable").innerHTML = emptyCartRequest.responseText;
            }
        };
        emptyCartRequest.send();

    }
}
function changeQuantityHandler(event){
    if(event.keyCode === 13) {
        let id = event.target.id;
        let productId = id.split("_")[1];
        let newQuantity = parseInt(document.getElementById(id).value);
        changeQuantityTo(productId, newQuantity)
    }
}
function increaseQuantity(event){

    let id = event.currentTarget.id;
    let productId = id.split("_")[1];
    let fieldId = "qty_"+productId;
    let newQuantity = parseInt(document.getElementById(fieldId).value) + 1;

    document.getElementById("qtyMinus_"+productId).disabled = false;
    changeQuantityTo(productId, newQuantity)
}
function decreaseQuantity(event){

    let id = event.currentTarget.id;

    let productId = id.split("_")[1];
    let fieldId = "qty_"+productId;
    let newQuantity = parseInt(document.getElementById(fieldId).value) - 1;
    document.getElementById("qtyPlus_"+productId).disabled = false;
    console.log(newQuantity);
    if(newQuantity<2) document.getElementById("qtyMinus_"+productId).disabled = true;
    if(newQuantity>0) changeQuantityTo(productId, newQuantity)
}
function changeQuantityTo(productId, newQuantity){
    console.log("event");
    if(isNaN(newQuantity) )document.getElementById("error_"+productId).value = "${cartItem.quantity}";//TODO use AJAX to retrive value
    else {
        if (window.XMLHttpRequest) changeQuantityRequest = new XMLHttpRequest();
        else if (window.ActiveXObject) changeQuantityRequest = new ActiveXObject(Microsoft.XMLHTTP);

        // console.log(cartId);
        changeQuantityRequest.onreadystatechange = function () {
            if (changeQuantityRequest.readyState == 4 && changeQuantityRequest.status == 200) {
                let data = JSON.parse(changeQuantityRequest.responseText);
                handleChangeQuantity(newQuantity, productId, data);
            }
        }
        url = "changeQuantity" + "?timeStamp=" + new Date().getTime();
        changeQuantityRequest.open("POST", url, true);
        changeQuantityRequest.setRequestHeader("content-type", "application/x-www-form-urlencoded");
        changeQuantityRequest.send("productId=" + productId + "&newQuantity=" + newQuantity);
    }
}
function handleChangeQuantity(newQuantity, productId, data){
    console.log(data);
    console.log("qty_"+productId);
    if(data.success == true) {
        if (data.message != undefined) {
            document.getElementById("qty_" + productId).value = parseInt(data.message.split(":")[1]);
            document.getElementById("qtyPlus_" + productId).disabled = true;
            document.getElementById("error_" + productId).innerHTML = data.message;
            console.log(data.message);
        } else {
            document.getElementById("qty_" + productId).value = newQuantity;

        }
    }
    if(data.success == false && data.message!= undefined) document.getElementById("error_"+productId).innerHTML = data.message;
}
function deleteCartItem(event){
    let id = event.currentTarget.id;
    console.log(id);
    let productId = id.split("_")[1];

    if (window.XMLHttpRequest) DeleteCartItemRequest = new XMLHttpRequest();
    else if (window.ActiveXObject) DeleteCartItemRequest = new ActiveXObject(Microsoft.XMLHTTP);

    DeleteCartItemRequest.onreadystatechange = function () {
        if (DeleteCartItemRequest.readyState == 4 && DeleteCartItemRequest.status == 200) {
            let data = JSON.parse(DeleteCartItemRequest.responseText);
            handleDeleteCartItem(productId, data);
        }
    }
    url = "deleteCartItem" + "?timeStamp=" + new Date().getTime();
    DeleteCartItemRequest.open("POST", url, true);
    DeleteCartItemRequest.setRequestHeader("content-type", "application/x-www-form-urlencoded");
    DeleteCartItemRequest.send("productId=" + productId);
}
function handleDeleteCartItem(productId, data) {
    if (data.success == true && data.message == undefined) {
        document.getElementById(productId).remove();
    }
}

function addToCart(event,quantity){
    let id = event.currentTarget.id;
    let productId = id.split("_")[1];

    let btn1 = document.getElementById("successMessageFieldId");
    if(btn1 != undefined)btn1.innerHTML = "";
    let btn2 = document.getElementById("errorMessageFieldId")
    if(btn2 != undefined)btn2.innerHTML = "";

        console.log("quantity is: "+quantity);
    if (window.XMLHttpRequest) addCartItemRequest = new XMLHttpRequest();
    else if (window.ActiveXObject) addCartItemRequest = new ActiveXObject(Microsoft.XMLHTTP);

    addCartItemRequest.onreadystatechange = function () {
        if (addCartItemRequest.readyState == 4 && addCartItemRequest.status == 200) {
            let data = JSON.parse(addCartItemRequest.responseText);
            handleAddCartItem(productId, data);
        }
    }

    url = "addCartItem" + "?timeStamp=" + new Date().getTime();
    addCartItemRequest.open("POST", url, true);
    addCartItemRequest.setRequestHeader("content-type", "application/x-www-form-urlencoded");
    addCartItemRequest.send("productId=" + productId+"&quantity="+quantity);
}
function handleAddCartItem(productId, data){
    if (data.success == true && data.message == undefined) {
        document.getElementById("successMessageFieldId").innerHTML = "Product Added Successfully";
    }else{
        document.getElementById("errorMessageFieldId").innerHTML = data.message;
    }
}