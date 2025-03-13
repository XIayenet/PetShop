<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Payment - PetShop</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="css/vendor.css">
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <div class="container my-5">
        <div class="row">
            <div class="col-md-12 text-center">
                <h1 class="display-4">Thank You for Your Order!</h1>
                <p class="lead">We will contact you as soon as possible.</p>
                <hr class="my-4">
                <p>Please follow the instructions below to complete your payment:</p>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">1. Open your banking app.</li>
                    <li class="list-group-item">2. Scan the QR code below.</li>
                    <li class="list-group-item">3. Confirm the payment.</li>
                </ul>
                <div class="my-4">
                    <img src="images/qr-code.png" alt="QR Code for Bank Transfer" class="img-fluid">
                </div>
                <a href="index.jsp" class="btn btn-primary btn-lg">Back to Home</a>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
            crossorigin="anonymous"></script>
</body>
</html>
