var submit = 0;

function validation(){
    if(submit===8){
        $("#form").submit();
    }
    else{
        document.getElementById("msgSubmit").innerHTML="PLease Enter all data ";
        document.getElementById("msgSubmit").style.color="red";
    }

}



function passwordValidate(){
    let password=document.getElementById("password").value;
    let regex =/(.+){8}/;

    let result=regex.test(password);

    if(result){
        document.getElementById("msgPassword").innerHTML="";
        submit++;
    }
    else{
        document.getElementById("msgPassword").innerHTML="InValid Password";
        document.getElementById("msgPassword").style.color="red";
        
    }
}

function confirmPasswordValidate(){
    let password=document.getElementById("password").value;
    let confirmPassword = document.getElementById("confirmPassword").value;

    if(password!=confirmPassword){
        document.getElementById("msgConfirmPass").innerHTML="InCorrect Password";
        document.getElementById("msgConfirmPass").style.color="red";
        submit++;
    }
    else{
        document.getElementById("msgConfirmPass").innerHTML="";
        
    }
        
}

function nameValidate(){
    let name=document.getElementById("userName").value;
    let regex=/[A-Za-z]+$/;

    let result=regex.test(name);

    if(result) {
        document.getElementById("msgUsername").innerHTML="";
        submit++;
    }
    else {
        document.getElementById("msgUsername").innerHTML="InValid Name";
        document.getElementById("msgUsername").style.color="red";
        
    }
    
}

function phoneValidate(){
    let phone = document.getElementById("phoneNo").value;
    let regex = /01(2|1|0|5)[0-9]{8}$/;
    let result = regex.test(phone);

    if(result) {
        document.getElementById("msgPhoneNo").innerHTML="";
        submit++;
    }
    else{
        document.getElementById("msgPhoneNo").innerHTML="InValid Number";
        document.getElementById("msgPhoneNo").style.color="red";
        
    }
}
function emailValidation(){
    let email = document.getElementById("email").value;
    let regex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    let result = regex.test.apply(email);

    if(result) {
        document.getElementById("msgEmail").innerHTML="";
        submit++;
    }
    else{
        document.getElementById("msgEmail").innerHTML="InValid Number";
        document.getElementById("msgEmail").style.color="red";
    }

}
function birthdateValidation(){
    let birthday = document.getElementById("birthday").value;

    if(birthday==null){
        document.getElementById("msgBirthday").innerHTML="Please enter your birthdate";
        document.getElementById("msgBirthday").style.color="red";
        submit++;
    }
    else {
        document.getElementById("msgBirthday").innerHTML="";
    }

}

function creditLimitValidation(){
    let creditLimit = document.getElementById("creditLimit").value;

    if(creditLimit==null){
        document.getElementById("msgCredit").innerHTML="Please enter your birthdate";
        document.getElementById("msgCredit").style.color="red";
        submit++;
    }
    else {
        document.getElementById("msgCredit").innerHTML="";
    }
}

function addressValidation(){
    let address = document.getElementById("address").value;

    if(creditLimit==null){
        document.getElementById("msgAddress").innerHTML="Please enter your birthdate";
        document.getElementById("msgAddress").style.color="red";
        submit++;
    }
    else {
        document.getElementById("msgAddress").innerHTML="";
    }
}

