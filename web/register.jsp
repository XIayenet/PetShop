<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <title>Register</title>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="format-detection" content="telephone=no">
  <meta name="apple-mobile-web-app-capable" content="yes">
  <meta name="author" content="">
  <meta name="keywords" content="">
  <meta name="description" content="">

  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css" />
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
  <link rel="stylesheet" type="text/css" href="css/vendor.css">
  <link rel="stylesheet" type="text/css" href="style.css">
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Chilanka&family=Montserrat:wght@300;400;500&display=swap"
    rel="stylesheet">
</head>

<body>
    <jsp:include page="header.jsp" />
  
  <section id="register " style="background: url('images/background-img.png ' ) repeat-y; ">
    <div class="container-fluid">
        <hr class="m-0 ">
      </div>
    <div class="container">
      <div class="row my-5 py-5">
        <div class="offset-md-3 col-md-6 ">
          <h2 class="display-3 fw-normal text-center " style="text-transform: none;">
            <span class="text-primary">Start caring for your pets now</span>
          </h2>
          <form action="register" method="post" id="register-form" class="needs-validation" novalidate>
              <div class="mb-3">
                 <p class="text-light-emphasis fs-6 text-xxl-end">*Required</p>
              <input type="email" class="form-control form-control-lg" name="email" id="email"
                placeholder="Enter Your Email Address" required>
              <div class="invalid-feedback">
                Please enter a valid email address.
              </div>
            </div>
              <div class="mb-3">
                  <p class="text-light-emphasis fs-6 text-xxl-end">*Required</p>
              <input type="password" class="form-control form-control-lg" name="password1" id="password1"
                placeholder="Create Password" required>
              <div class="invalid-feedback">
                Please create a password.
              </div>
            </div>
            <div class="mb-3">
                <p class="text-light-emphasis fs-6 text-xxl-end">*Required</p>
              <input type="password" class="form-control form-control-lg" name="password2" id="password2"
                placeholder="Repeat Password" required>
              <div class="invalid-feedback">
                Please repeat your password.
              </div>
            </div>
              <div class="mb-3">
              <input type="firstname" class="form-control form-control-lg" name="firstname" id="firstname"
                placeholder="First Name." required >
              <div class="invalid-feedback">
                 Please enter your first name
              </div>
            </div>
              <div class="mb-3">
                <p class="text-light-emphasis fs-6 text-xxl-end p-sm-1">*Required</p>
              <input type="lastname" class="form-control form-control-lg" name="lastname" id="lastname"
                placeholder="Last Name"  >
              <div class="invalid-feedback">
                Last Name.
              </div>
            </div>
              <div class="mb-3">
              <input type="phoneNumbers" class="form-control form-control-lg" name="phoneNumbers" id="phoneNumbers"
                placeholder="Enter Your Phone Numbers" >
              <div class="invalid-feedback">
                Please enter a valid email address.
              </div>
              </div>
            <div class="mb-3">
              <input type="address" class="form-control form-control-lg" name="address" id="address"
                placeholder="Enter Your Adress" >
              <div class="invalid-feedback">
                Please enter a valid  address.
              </div>
            </div>
            <div class="d-grid gap-2 mb-5">
              <button type="submit" class="btn btn-dark btn-lg rounded-1">Register</button>
            </div>
              <h6 class="display-3 fw-normal text-center" style="text-transform: none;">
            <span class="text-secondary">${errorMessage}</span>
          </h6>
          </form>
        </div>
      </div>
    </div>
  </section>

    <jsp:include page="footer.jsp" />

  <div id="footer-bottom">
    <div class="container">
      <hr class="m-0">
      <div class="row mt-3">
        <div class="col-md-6 copyright">
          <p class="secondary-font">Â© 2023 PRJ302 PetShop. All rights reserved.</p>
        </div>
      </div>
    </div>
  </div>

  <script src="js/jquery-1.11.0.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
    crossorigin="anonymous"></script>
  <script src="js/plugins.js"></script>
  <script src="js/script.js"></script>
  <script src="https://code.iconify.design/iconify-icon/1.0.7/iconify-icon.min.js"></script>
  <script>
    // Example starter JavaScript for disabling form submissions if there are invalid fields
    (function () {
      'use strict'

      // Fetch all the forms we want to apply custom Bootstrap validation styles to
      var forms = document.querySelectorAll('.needs-validation')

      // Loop over them and prevent submission
      Array.prototype.slice.call(forms)
        .forEach(function (form) {
          form.addEventListener('submit', function (event) {
            if (!form.checkValidity()) {
              event.preventDefault()
              event.stopPropagation()
            }

            form.classList.add('was-validated')
          }, false)
        })
    })()
  </script>
</body>

</html>