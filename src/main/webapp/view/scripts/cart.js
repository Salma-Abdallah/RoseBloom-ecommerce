console.log("START");
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