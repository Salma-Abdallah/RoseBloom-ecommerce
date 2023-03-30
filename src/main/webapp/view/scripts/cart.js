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
// function changeQuantityHandler(event){
//     if(event.keyCode === 13) {
//         let id = event.target.id;
//         let productId = id.split("_")[1];
//         let newQuantity = parseInt(document.getElementById(id).value);
//         changeQuantityTo(productId, newQuantity)
//     }
// }
function increaseQuantity(event, price){

    let id = event.currentTarget.id;
    let productId = id.split("_")[1];
    console.log(productId);
    console.log(document.getElementById("qty_"+productId));
    console.log(document.getElementById("qty_2"));
    let qtyField = document.getElementById("qty_"+productId);
    if(qtyField == undefined) qtyField = document.getElementById("head-qty_"+productId);

    let oldQuantity = parseInt(qtyField.value);
    let newQuantity = oldQuantity + 1;

    let minusBtn = document.getElementById("qtyMinus_"+productId);
    if(minusBtn != undefined)minusBtn.disabled = false;
    let minusBtnHead = document.getElementById("head-qtyMinus_"+productId);
    if(minusBtnHead != undefined)minusBtnHead.disabled = false;

    changeQuantityTo(productId, oldQuantity, newQuantity, price);
}
function decreaseQuantity(event, price){

    let id = event.currentTarget.id;
    let productId = id.split("_")[1];

    let qtyField = document.getElementById("qty_"+productId);
    if(qtyField == undefined) qtyField = document.getElementById("head-qty_"+productId);

    let oldQuantity = parseInt(qtyField.value);
    let newQuantity = oldQuantity - 1;

    let plusBtn = document.getElementById("qtyPlus_"+productId);
    if(plusBtn != undefined)plusBtn.disabled = false;
    let plusBtnHead = document.getElementById("head-qtyPlus_"+productId);
    if(plusBtnHead != undefined)plusBtnHead.disabled = false;

    let errorMessage = document.getElementById("error_" + productId);
    if(errorMessage!= undefined)errorMessage.innerHTML = "";
    let errorMessageHead = document.getElementById("head-error_" + productId);
    if(errorMessageHead!= undefined)errorMessageHead.innerHTML = "";


    console.log(newQuantity);
    if(newQuantity<2) {
        let minusBtn = document.getElementById("qtyMinus_"+productId);
        if(minusBtn != undefined)minusBtn.disabled = true;
        let minusBtnHead = document.getElementById("head-qtyMinus_"+productId);
        if(minusBtnHead != undefined)minusBtnHead.disabled = true;
    }
    if(newQuantity>0) changeQuantityTo(productId,oldQuantity, newQuantity, price);
}
function changeQuantityTo(productId, oldQuantity, newQuantity, price){
    console.log("event");
    if(isNaN(newQuantity) )document.getElementById("error_"+productId).value = "${cartItem.quantity}";//TODO use AJAX to retrive value
    else {
        if (window.XMLHttpRequest) changeQuantityRequest = new XMLHttpRequest();
        else if (window.ActiveXObject) changeQuantityRequest = new ActiveXObject(Microsoft.XMLHTTP);

        // console.log(cartId);
        changeQuantityRequest.onreadystatechange = function () {
            if (changeQuantityRequest.readyState == 4 && changeQuantityRequest.status == 200) {
                let data = JSON.parse(changeQuantityRequest.responseText);
                handleChangeQuantity(productId, oldQuantity, newQuantity, price, data);
            }
        }
        url = "changeQuantity" + "?timeStamp=" + new Date().getTime();
        changeQuantityRequest.open("POST", url, true);
        changeQuantityRequest.setRequestHeader("content-type", "application/x-www-form-urlencoded");
        changeQuantityRequest.send("productId=" + productId + "&newQuantity=" + newQuantity);
    }
}
function handleChangeQuantity(productId, oldQuantity, newQuantity, price, data){
    console.log(data);
    console.log("qty_"+productId);
    if(data.success == true) {
        if (data.message != undefined) {
            let qtyField = document.getElementById("qty_" + productId)
            if(qtyField != undefined) qtyField.value = parseInt(data.message.split(":")[1]);
            let qtyFieldHead = document.getElementById("head-qty_" + productId)
            if(qtyFieldHead != undefined) qtyFieldHead.value = parseInt(data.message.split(":")[1]);

            let plusBtn = document.getElementById("qtyPlus_"+productId)
            if(plusBtn != undefined)plusBtn.disabled = true;
            let plusBtnHead = document.getElementById("head-qtyPlus_"+productId)
            if(plusBtnHead != undefined)plusBtnHead.disabled = true;

            let errorMessage = document.getElementById("error_" + productId);
            if(errorMessage!= undefined)errorMessage.innerHTML = data.message;
            let errorMessageHead = document.getElementById("head-error_" + productId);
            if(errorMessageHead!= undefined)errorMessageHead.innerHTML = data.message;

            console.log(data.message);
        } else {
            let qtyField = document.getElementById("qty_" + productId)
            if(qtyField != undefined) qtyField.value = newQuantity;
            let qtyFieldHead = document.getElementById("head-qty_" + productId)
            if(qtyFieldHead != undefined) qtyFieldHead.value = newQuantity;

            let itemtotalFieldHead = document.getElementById("head-itemTotal_"+ productId);
            let itemtotalField = document.getElementById("itemTotal_"+ productId);
            let itemtotal = parseInt(itemtotalFieldHead.innerHTML);
            itemtotal += price*(newQuantity - oldQuantity);
            itemtotalFieldHead.innerHTML = itemtotal;
            if(itemtotalField!=undefined)itemtotalField.innerHTML = itemtotal;


            let subtotalFieldHead = document.getElementById("head-subtotal");
            let subtotalField = document.getElementById("subtotal");
            let totalAmountField = document.getElementById("totalMoney");
            let subtotal = parseInt(subtotalFieldHead.innerHTML);
            subtotal += price*(newQuantity - oldQuantity);
            subtotalFieldHead.innerHTML = subtotal;
            if(subtotalField!=undefined)subtotalField.innerHTML = subtotal;
            if(totalAmountField!=undefined)totalAmountField.innerHTML = (subtotal+50);
        }
    }
    if(data.success == false && data.message!= undefined) document.getElementById("error_"+productId).innerHTML = data.message;
}
function deleteCartItem(event,quantity, price){
    let id = event.currentTarget.id;
    console.log(id);
    let productId = id.split("_")[1];

    if (window.XMLHttpRequest) DeleteCartItemRequest = new XMLHttpRequest();
    else if (window.ActiveXObject) DeleteCartItemRequest = new ActiveXObject(Microsoft.XMLHTTP);

    DeleteCartItemRequest.onreadystatechange = function () {
        if (DeleteCartItemRequest.readyState == 4 && DeleteCartItemRequest.status == 200) {
            let data = JSON.parse(DeleteCartItemRequest.responseText);
            handleDeleteCartItem(productId, data, quantity, price);
        }
    }
    url = "deleteCartItem" + "?timeStamp=" + new Date().getTime();
    DeleteCartItemRequest.open("POST", url, true);
    DeleteCartItemRequest.setRequestHeader("content-type", "application/x-www-form-urlencoded");
    DeleteCartItemRequest.send("productId=" + productId);
}
function handleDeleteCartItem(productId, data, quantity, price) {
    if (data.success == true && data.message == undefined) {
        let elem1 = document.getElementById(productId);
        if(elem1 != undefined)elem1.remove();
        let elem2 = document.getElementById("head_"+productId);
        if(elem2 != undefined)elem2.remove();

        if(parseInt(document.getElementById("CartCount").innerHTML)==1){
            document.getElementById("miniCartList").remove();
            document.getElementById("miniCartBtns").remove();
            document.getElementById("emtyMiniCart").style.display="block";
        }
        document.getElementById("CartCount").innerHTML = parseInt(document.getElementById("CartCount").innerHTML)-1;
        let subtotalFieldHead = document.getElementById("head-subtotal");
        let subtotalField = document.getElementById("subtotal");
        let totalAmountField = document.getElementById("totalMoney");
        let subtotal = parseInt(subtotalFieldHead.innerHTML);
        subtotal -= price*quantity;
        subtotalFieldHead.innerHTML = subtotal;
        if(subtotalField!=undefined)subtotalField.innerHTML = subtotal;
        if(totalAmountField!=undefined)totalAmountField.innerHTML = (subtotal+50);
    }
}

function addToCart(event,quantity,id, name, image, color, price){
    let eventId = event.currentTarget.id;
    let productId = eventId.split("_")[1];

    let btn1 = document.getElementById("successMessageFieldId");
    if(btn1 != undefined)btn1.innerHTML = "";
    let btn2 = document.getElementById("errorMessageFieldId")
    if(btn2 != undefined)btn2.innerHTML = "";

    console.log("quantity is: "+quantity);
    if (window.XMLHttpRequest) addCartItemRequest = new XMLHttpRequest();
    else if (window.ActiveXObject) addCartItemRequest = new ActiveXObject(Microsoft.XMLHTTP);

    addCartItemRequest.onreadystatechange = function () {
        if (addCartItemRequest.readyState == 4 && addCartItemRequest.status == 200) {
            console.log(addCartItemRequest.responseText);
            let data = JSON.parse(addCartItemRequest.responseText);
            handleAddCartItem(id, name, image, color, price, data,quantity);
        }
    }

    url = "addCartItem" + "?timeStamp=" + new Date().getTime();
    addCartItemRequest.open("POST", url, true);
    addCartItemRequest.setRequestHeader("content-type", "application/x-www-form-urlencoded");
    addCartItemRequest.send("productId=" + productId+"&quantity="+quantity);
}
function handleAddCartItem(id, name, image, color, price, data, quantity){
    if (data.success == true && data.message == undefined) {
        document.getElementById("successMessageFieldId").innerHTML = "Product Added Successfully";
        let miniCart = document.getElementById("header-cart");
        let miniCartList = document.getElementById("miniCartList");
        if(miniCartList == undefined){
            document.getElementById("emtyMiniCart").style.display="none";
            document.getElementById("CartCount").innerHTML = '1';
            miniCart.innerHTML+='<ul class="mini-products-list" id="miniCartList"></ul>';
            miniCartList = document.getElementById("miniCartList");
            miniCartList.innerHTML+= cartItemCard(id, name, image, color, price, data, quantity);
            miniCart.innerHTML+= '<div class="total" id="miniCartBtns">\n' +
                '                                    <div class="total-in">\n' +
                '                                        <span class="label">Cart Subtotal:</span><span class="product-price">EGP <span class="money" id="head-subtotal">'+(price*quantity)+'</span></span>\n' +
                '                                    </div>\n' +
                '                                    <div class="buttonSet text-center">\n' +
                '                                        <a href="cart" class="btn btn-secondary btn--small">View Cart</a>\n' +
                '                                        <a href="Checkout" class="btn btn-secondary btn--small">Checkout</a>\n' +
                '                                    </div>\n' +
                '                                </div>';

        }else{
            miniCartList.innerHTML+= cartItemCard(id, name, image, color, price, data, quantity);
            let subtotalField = document.getElementById("head-subtotal");
            let subtotal = parseInt(subtotalField.innerHTML);
            subtotal += price*quantity;
            subtotalField.innerHTML = subtotal;
            document.getElementById("CartCount").innerHTML = parseInt(document.getElementById("CartCount").innerHTML)+1;
        }
    }else{
        document.getElementById("errorMessageFieldId").innerHTML = data.message;
    }
}

function cartItemCard(id, name, image, color, price, data, quantity){
    return '<li class="item" id="head_'+id+'">\n' +
        '                                            <a class="product-image" href="productDetails?productId='+id+'">\n' +
        '                                                <img src="'+image+'" alt="" title="" />\n' +
        '                                            </a>\n' +
        '                                            <div class="product-details">\n' +
        '                                                <a onclick="deleteCartItem(event)" class="remove" id="head-remove_'+id+'"><i class="anm anm-times-l" aria-hidden="true"></i></a>\n' +
        '                                                <a class="pName" href="cart.html">'+name+'</a>\n' +
        '                                                <div class="variant-cart">'+color+' / '+id+'</div>\n' +
        '                                                <div class="wrapQtyBtn">\n' +
        '                                                    <div class="qtyField">\n' +
        '                                                        <span class="label">Qty:</span>\n' +
        '                                                        <a class="qtyBtn minus" onclick="decreaseQuantity(event,'+price+')" id="head-qtyPlus_'+id+'"><i class="fa anm anm-minus-r" aria-hidden="true"></i></a>\n' +
        '                                                        <input type="text" name="quantity" value="'+quantity+'" class="product-form__input qty" id="head-qty_'+id+'" disabled>\n' +
        '                                                        <a class="qtyBtn plus" onclick="increaseQuantity(event, '+price+')" id="head-qtyMinus_'+id+'"><i class="fa anm anm-plus-r" aria-hidden="true"></i></a>\n' +
        '                                                    </div>\n' +
        '                                                </div>\n' +
        '                                                <div class="priceRow">\n' +
        '                                                    <div class="product-price">EGP\n' +
        '                                                        <span class="money" id="head-itemTotal_'+id+'">'+(price*quantity)+'</span>\n' +
        '                                                        <span class="errorMessage" id="head-error_"></span>\n' +
        '                                                    </div>\n' +
        '                                                </div>\n' +
        '                                            </div>\n' +
        '                                        </li>';
}