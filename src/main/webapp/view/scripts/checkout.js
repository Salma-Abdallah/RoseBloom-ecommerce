function displayDiffAddressInput(event){
  if(document.getElementById(event.target.id).checked)
  document.getElementById("differentAddress").style.display = "block";
}
function hideDiffAddressInput(event){
  console.log("start");
  console.log(event);
  if(document.getElementById(event.target.id).checked)
  document.getElementById("differentAddress").style.display = "none";
}

document.getElementById("currentAddressBtn").addEventListener("change",hideDiffAddressInput);
document.getElementById("diffAddressBtn").addEventListener("change",displayDiffAddressInput);

function placeOrder(){
  if(document.getElementById("currentAddressBtn").checked){
    address = document.getElementById("address").innerHTML;
  }else{
    address = document.getElementById("differentAddress").value;
  }
  if (window.XMLHttpRequest) newOrderRequest = new XMLHttpRequest();
  else if (window.ActiveXObject) newOrderRequest = new ActiveXObject(Microsoft.XMLHTTP);

  // console.log(cartId);
  newOrderRequest.onreadystatechange = function () {
    if (newOrderRequest.readyState == 4 && newOrderRequest.status == 200) {
        let data = JSON.parse(newOrderRequest.responseText);
        handlePlaceOrder(data);
    }
  }
  url = "NewOrder" + "?timeStamp=" + new Date().getTime();
  newOrderRequest.open("POST", url, true);
  newOrderRequest.setRequestHeader("content-type", "application/x-www-form-urlencoded");
  newOrderRequest.send("address=" + address);
}

function handlePlaceOrder(data){
  if (data.success == false) {
    document.getElementById("placeOrderErrorMessage").innerHTML = "<br>" + data.message;
  }else{
    console.log("order placed");
    window.location.href = "/roseBloom/orderPlaced";
  }
}

