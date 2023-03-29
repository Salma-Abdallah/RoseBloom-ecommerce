function validation(){
    passwordValidate();
    confirmPasswordValidate();
    nameValidate();
    phoneValidate();

}



function passwordValidate(){
    let password=document.getElementById("password").value;
    let regex =/(.+){8}/;

    let result=regex.test(password);

    if(result){
        document.getElementById("msgPassword").innerHTML="Valid Password";
        document.getElementById("msgPassword").style.color="green";
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
    }
        
}

function nameValidate(){
    let name=document.getElementById("")
    let regex=/[A-Za-z]+$/;

    let result=regex.test(name);

    return result;
    
}

function phoneValidate(){
    let phone = document.getElementById("");
    let regex = /01(2|1|0|5)[0-9]{8}$/;
    let result = regex.test(phone);

    return result;
}

function birthdateValidation(){

}

function creditLimitValidation(){

}

function addressValidation(){

}

function emailValidation(){
    
}