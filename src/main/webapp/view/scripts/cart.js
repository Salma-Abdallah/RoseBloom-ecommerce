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

    let qtyField = document.getElementById("qty_"+productId);
    if(qtyField == undefined) qtyField = document.getElementById("head_qty_"+productId);

    let newQuantity = parseInt(qtyField.value) + 1;

    let minusBtn = document.getElementById("qtyMinus_"+productId)
    if(minusBtn != undefined)minusBtn.disabled = false;
    let minusBtnHead = document.getElementById("head_qtyMinus_"+productId)
    if(minusBtnHead != undefined)minusBtnHead.disabled = false;

    changeQuantityTo(productId, newQuantity)
}
function decreaseQuantity(event){

    let id = event.currentTarget.id;
    let productId = id.split("_")[1];

    let qtyField = document.getElementById("qty_"+productId);
    if(qtyField == undefined) qtyField = document.getElementById("head_qty_"+productId);

    let newQuantity = parseInt(document.getElementById(fieldId).value) - 1;

    let plusBtn = document.getElementById("qtyPlus_"+productId)
    if(plusBtn != undefined)plusBtn.disabled = false;
    let plusBtnHead = document.getElementById("head_qtyPlus_"+productId)
    if(plusBtnHead != undefined)plusBtnHead.disabled = false;

    let errorMessage = document.getElementById("error_" + productId);
    if(errorMessage!= undefined)errorMessage.innerHTML = "";
    let errorMessageHead = document.getElementById("head_error_" + productId);
    if(errorMessageHead!= undefined)errorMessageHead.innerHTML = "";


    console.log(newQuantity);
    if(newQuantity<2) {
        let minusBtn = document.getElementById("qtyMinus_"+productId)
        if(minusBtn != undefined)minusBtn.disabled = true;
        let minusBtnHead = document.getElementById("head_qtyMinus_"+productId)
        if(minusBtnHead != undefined)minusBtnHead.disabled = true;
    }
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
            let qtyField = document.getElementById("qty_" + productId)
            if(qtyField != undefined) qtyField.value = parseInt(data.message.split(":")[1]);
            let qtyFieldHead = document.getElementById("head_qty_" + productId)
            if(qtyFieldHead != undefined) qtyFieldHead.value = parseInt(data.message.split(":")[1]);

            let plusBtn = document.getElementById("qtyPlus_"+productId)
            if(plusBtn != undefined)plusBtn.disabled = true;
            let plusBtnHead = document.getElementById("head_qtyPlus_"+productId)
            if(plusBtnHead != undefined)plusBtnHead.disabled = true;

            let errorMessage = document.getElementById("error_" + productId);
            if(errorMessage!= undefined)errorMessage.innerHTML = data.message;
            let errorMessageHead = document.getElementById("head_error_" + productId);
            if(errorMessageHead!= undefined)errorMessageHead.innerHTML = data.message;

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
        let elem1 = document.getElementById(productId);
        if(elem1 != undefined)elem1.remove();
        let elem2 = document.getElementById("head_"+productId);
        if(elem2 != undefined)elem2.remove();
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