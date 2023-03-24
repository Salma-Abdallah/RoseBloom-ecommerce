        var emailReq = null;
        function submitForm() {
            if(window.XMLHttpRequest)
                emailReq= new XMLHttpRequest();
            else if(window.ActiveXObject)
                emailReq = new ActiveXObject(Microsoft.XMLHTTP);

            emailReq.onreadystatechange = handleReq;

            yourValue = document.getElementById("email").value;
            console.log("loginjs");

            emailReq.open("GET","../../LoginPage?userEmail="+yourValue,true);
            emailReq.send(null);

        }

        function handleReq() {
            if (emailReq.readyState == 4 && emailReq.status == 200) {
                xmlvalue = emailReq.responseText;
                document.getElementById("msgEmail").innerHTML = xmlvalue;
            }

        }