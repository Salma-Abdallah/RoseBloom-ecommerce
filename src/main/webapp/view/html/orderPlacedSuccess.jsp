<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Shopping Cart &ndash; RoseBloom </title>
  <!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous"> -->
  <!-- <link rel="stylesheet" href="style.css"> TODO CHANGE ICON-->
  <link rel="shortcut icon" href="/roseBloom/view/images/favicon.png"/>
  <!-- Plugins CSS -->
  <link rel="stylesheet" href="/roseBloom/view/style/plugins.css">
  <!-- Bootstap CSS -->
  <link rel="stylesheet" href="/roseBloom/view/style/bootstrap.min.css">
  <!-- Main Style CSS -->
  <link rel="stylesheet" href="/roseBloom/view/style/style.css">
  <link rel="stylesheet" href="/roseBloom/view/style/responsive.css">
  <!-- Main Script -->
  <script src="/roseBloom/view/scripts/cart.js"></script>
  <link href="https://fonts.googleapis.com/css?family=Nunito+Sans:400,400i,700,900&display=swap" rel="stylesheet">
</head>
<link rel="stylesheet" href="/roseBloom/view/style/OrderPlacesSuccessStyle.css">
<body>
<main>
<%@ include file ="header.jsp" %>
  <br><br><br><br><br><br><br>
<div class="card">
  <div style="border-radius:200px; height:200px; width:400px; background: #F8FAF5; margin:0 auto;">
    <i class="checkmark">Great!</i>
  </div>
  <h1 class="successMessage">Success</h1>
  <p class="OrderReceived">We received your Order;<br/> we'll be in touch shortly!</p>
</div>

<%@ include file ="footer.html" %>
</main>
</body>
</html>