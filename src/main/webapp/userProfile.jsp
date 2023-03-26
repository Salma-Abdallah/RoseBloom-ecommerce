<!DOCTYPE html>
<html lang="zxx">

<head>
    <title>User Profile</title>
    <link rel="shortcut icon" href="view/images/leaf2.png" />
    <!-- Meta tag Keywords -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="UTF-8" />
    <meta name="keywords" content="RoseBloom Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
    </script>

    <script>
		addEventListener("load", function () {
			setTimeout(hideURLbar, 0);
		}, false);

		function hideURLbar() {
			window.scrollTo(0, 1);
		}
	</script>
    <!--// Meta tag Keywords -->

    <!-- Custom-Files -->
    <!-- <link rel="stylesheet" href="view/style/bootstrap.css"> -->
    <!-- Bootstrap-Core-CSS -->
    <!-- <link href="view/style/css_slider.css" type="text/css" rel="stylesheet" media="all"> -->
    <!-- banner slider -->
    <!-- <link rel="stylesheet" href="view/style/style.css" type="text/css" media="all" /> -->
    <!-- Style-CSS -->
    <!-- <link href="view/style/font-awesome.min.css" rel="stylesheet"> -->
    <!-- Font-Awesome-Icons-CSS -->
<!-- 
    <link rel="stylesheet" href="view/style/plugins.css"> -->
    <!-- Bootstap CSS -->
    <link rel="stylesheet" href="view/style/bootstrap.min.css">
    <!-- Main Style CSS -->
    <link rel="stylesheet" href="view/style/style.css">
    <link rel="stylesheet" href="view/style/responsive.css">

    <link rel="stylesheet" href="view/style/main-style2.css" type="text/css" media="all">


    <link rel="stylesheet" href="view/style/userProfile.css">
    <!-- Signup-CSS -->

    <!-- //Custom-Files -->

    <!-- Web-Fonts -->
    <link href="//fonts.googleapis.com/css?family=Source+Sans+Pro:200,200i,300,300i,400,400i,600,600i,700,700i,900,900i"
          rel="stylesheet">
    <link href="//fonts.googleapis.com/css?family=Niconne&amp;subset=latin-ext" rel="stylesheet">
    <link href="//fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&amp;subset=devanagari,latin-ext"
          rel="stylesheet">
    <!-- //Web-Fonts -->
</head>
<body>

    <%@ include file ="view/html/header.jsp" %>
   
    <div class="mainBody">
        <div class="detailsContainer" style="margin-top: 120px; align-items: center;">
            <div class="title"> Your Profile </div>

            <form action="userProfile" method="post">

                <div class="user-details">
                    <div class="input-box">
                        <span class="details">Full Name</span>
                        <input type="text" name="userName" id="userName" value="${User.name}" required>
                        <label name="msgUsername" id="msgUsername"></label>
                    </div>
                    <div class="input-box">
                        <span class="details">Birthday</span>
                        <input type="date" name="birthday" id="birthday" value="${User.birthdate}" required>
                        <label name="msgBirthday" id="msgBirthday"></label>
                    </div>
                    <div class="input-box">
                        <span class="details">Email</span>
                        <input type="email" name="email" id="email" value="${User.email}" required>
                        <label name="msgEmail" id="msgEmail"></label>
                    </div>
                    <div class="input-box">
                        <span class="details">Phone Number</span>
                        <input type="tel" name="phoneNo" id="phoneNo" value="${User.phone}" required>
                        <label name="msgPhoneNo" id="msgPhoneNo"></label>
                    </div>
                    <div class="input-box">
                        <span class="details">Password</span>
                        <input type="password" name="password" id="password" value="${User.password}" required>
                        <label name="msgPassword" id="msgPassword"></label>
                    </div>
                    <div class="input-box">
                        <span class="details">Confirm Password</span>
                        <input type="password" name="confirmPassword" id="confirmPassword" value="${User.password}" required>
                        <label name="msgConfirmPass" id="msgConfirmPass"></label>
                    </div>
                    <div class="input-box">
                        <span class="details">Address</span>
                        <input type="text" name="address" id="address" value="${User.address}" required>
                        <label name="msgAddress" id="msgAddress"></label>
                    </div>
                    <div class="input-box">
                        <span class="details">Credit Limit  </span>
                        <input type="number" name="creditLimit" id="creditLimit" value="${User.creditLimit}" required>
                        <label name="msgCredit" id="msgCredit"></label>
                    </div>
                    <div class="input-box">
                        <span class="details">Job  </span>
                        <input type="text" name="job" id="job" placeholder="Enter your job" value="${User.job}"required>
                        <label name="msgCredit" id="msgJob"></label>
                    </div>
                </div>
        
                <div class="button">
                    <input type="submit" value="Update Your Profile ">
                </div>
        
        
            </form>
        
        </div>
    </div>
<footer style="margin-top: 100px;">
    
    <%@ include file ="view/html/footer.html" %>
</footer>
</body>

</html>