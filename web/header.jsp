<%@page import="entity.UserEntity"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">

  <head>

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

    <div class="preloader-wrapper">
      <div class="preloader">
      </div>
    </div>

    <div class="offcanvas offcanvas-end" data-bs-scroll="true" tabindex="-1" id="offcanvasCart" aria-labelledby="My Cart">
      <div class="offcanvas-header justify-content-center">
        <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
      </div>
      <div class="offcanvas-body">
        <div class="order-md-last">
          <h4 class="d-flex justify-content-between align-items-center mb-3">
            <span class="text-primary">Your cart</span>
            <span class="badge bg-primary rounded-circle pt-2">3</span>
          </h4>
          <ul class="list-group mb-3">
            <li class="list-group-item d-flex justify-content-between lh-sm">
              <div>
                <h6 class="my-0">Gay Hoodie</h6>
                <small class="text-body-secondary">Brief description</small>
              </div>
              <span class="text-body-secondary">$12</span>
            </li>
            <li class="list-group-item d-flex justify-content-between lh-sm">
              <div>
                <h6 class="my-0">Dog Food</h6>
                <small class="text-body-secondary">Brief description</small>
              </div>
              <span class="text-body-secondary">$8</span>
            </li>
            <li class="list-group-item d-flex justify-content-between lh-sm">
              <div>
                <h6 class="my-0">Soft Toy</h6>
                <small class="text-body-secondary">Brief description</small>
              </div>
              <span class="text-body-secondary">$5</span>
            </li>
            <li class="list-group-item d-flex justify-content-between">
              <span class="fw-bold">Total (USD)</span>
              <strong>$20</strong>
            </li>
          </ul>

          <button class="w-100 btn btn-primary btn-lg" type="submit">Continue to checkout</button>
        </div>
      </div>
    </div>

    <div class="offcanvas offcanvas-end" data-bs-scroll="true" tabindex="-1" id="offcanvasSearch"
         aria-labelledby="Search">
      <div class="offcanvas-header justify-content-center">
        <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
      </div>
      <div class="offcanvas-body">

        <div class="order-md-last">
          <h4 class="text-primary text-uppercase mb-3">
            Search
          </h4>
          <div class="search-bar border rounded-2 border-dark-subtle">
            <form id="search-form" class="text-center d-flex align-items-center" action="" method="">
              <input type="text" class="form-control border-0 bg-transparent" placeholder="Search Here" />
              <iconify-icon icon="tabler:search" class="fs-4 me-3"></iconify-icon>
            </form>
          </div>
        </div>
      </div>
    </div>

    <header>
  <div class="container py-2">
    <div class="row py-4 pb-0 pb-sm-4 align-items-center ">

      <div class="col-sm-4 col-lg-3 text-center text-sm-start">
        <div class="main-logo">
          <a href="homePage">
            <img src="images/logo.png" alt="logo" class="img-fluid">
          </a>
        </div>
      </div>

      <div class="col-sm-6 offset-sm-2 offset-md-0 col-lg-5 d-none d-lg-block">
        <div class="search-bar border rounded-2 px-3 border-dark-subtle ">
          <form id="search-form" class="text-center d-flex align-items-center" action="" method="">
            <input type="text" class="form-control border-0 bg-transparent"
                   placeholder="Search for more than 10,000 products" />
            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24">
            <path fill="currentColor"
                  d="M21.71 20.29L18 16.61A9 9 0 1 0 16.61 18l3.68 3.68a1 1 0 0 0 1.42 0a1 1 0 0 0 0-1.39ZM11 18a7 7 0 1 1 7-7a7 7 0 0 1-7 7Z" />
            </svg>
          </form>
        </div>
      </div>

      <div
          class="col-sm-8 col-lg-4 d-flex justify-content-end gap-2 align-items-center mt-4 mt-sm-0 justify-content-center justify-content-sm-end">
        <div class="support-box text-end d-none d-lg-block">
          <span class="fs-6 secondary-font text-muted">Phone</span>
          <h5 class="mb-0">0966907482</h5>
        </div>
        <div class="support-box text-end d-none d-lg-block">
          <span class="fs-6 secondary-font text-muted">Email</span>
          <h5 class="mb-0">canhndhe161293@fpt.edu.vn</h5>
        </div>
      </div>
    </div>
  </div>

  <div class="container-fluid">
    <hr class="m-0">
  </div>

  <div class="container">
    <nav class="main-menu d-flex navbar navbar-expand-lg ">

      <div class="d-flex d-lg-none align-items-end mt-3">
        <ul class="d-flex justify-content-end list-unstyled m-0">
          <li>
            <a href="account.html" class="mx-3">
              <iconify-icon icon="healthicons:person" class="fs-4"></iconify-icon>
            </a>
          </li>
          <li>
            <a href="wishlist.html" class="mx-3">
              <iconify-icon icon="mdi:heart" class="fs-4"></iconify-icon>
            </a>
          </li>

          <li>
            <a href="#" class="mx-3" data-bs-toggle="offcanvas" data-bs-target="#offcanvasCart"
               aria-controls="offcanvasCart">
              <iconify-icon icon="mdi:cart" class="fs-4 position-relative"></iconify-icon>
              <span class="position-absolute translate-middle badge rounded-circle bg-primary pt-2">
                03
              </span>
            </a>
          </li>

          <li>
            <a href="#" class="mx-3" data-bs-toggle="offcanvas" data-bs-target="#offcanvasSearch"
               aria-controls="offcanvasSearch">
              <iconify-icon icon="tabler:search" class="fs-4"></iconify-icon>
              </span>
            </a>
          </li>
        </ul>

      </div>

      <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar"
              aria-controls="offcanvasNavbar">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">

        <div class="offcanvas-header justify-content-center">
          <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
        </div>

        <div class="offcanvas-body justify-content-between">
          <select class="filter-categories border-0 mb-0 me-5">
            <option>Shop by Category</option>
            <option>Clothes</option>
            <option>Food</option>
            <option>Food</option>
            <option>Toy</option>
          </select>

          <ul class="navbar-nav menu-list list-unstyled d-flex gap-md-3 mb-0">
            <li class="nav-item">
              <a href="index.html" class="nav-link active">Home</a>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" role="button" id="pages" data-bs-toggle="dropdown"
                 aria-expanded="false">Pages</a>
              <ul class="dropdown-menu" aria-labelledby="pages">
                <li><a href="index.html" class="dropdown-item">About Us</a></li>
                <li><a href="index.html" class="dropdown-item">Shop</a></li>
                <li><a href="index.html" class="dropdown-item">Single Product</a></li>
                <li><a href="index.html" class="dropdown-item">Cart</a></li>
                <li><a href="index.html" class="dropdown-item">Wishlist</a></li>
                <li><a href="index.html" class="dropdown-item">Checkout</a></li>
                <li><a href="index.html" class="dropdown-item">Blog</a></li>
                <li><a href="index.html" class="dropdown-item">Single Post</a></li>
                <li><a href="index.html" class="dropdown-item">Contact</a></li>
                <li><a href="index.html" class="dropdown-item">FAQs</a></li>
                <li><a href="index.html" class="dropdown-item">Account</a></li>
                <li><a href="index.html" class="dropdown-item">Thankyou</a></li>
                <li><a href="index.html" class="dropdown-item">Error 404</a></li>
                <li><a href="index.html" class="dropdown-item">Styles</a></li>
              </ul>
            </li>
            <li class="nav-item">
              <a href="index.html" class="nav-link">Shop</a>
            </li>
            <li class="nav-item">
              <a href="index.html" class="nav-link">Blog</a>
            </li>
            <li class="nav-item">
              <a href="index.html" class="nav-link">Contact</a>
            </li>
            <li class="nav-item">
              <a href="index.html" class="nav-link">Others</a>
            </li>
          </ul>

          <div class="d-none d-lg-flex align-items-end">
            <ul class="d-flex justify-content-end list-unstyled m-0">
              <li>
                <div class="dropdown">
                  <a href="#" role="button" class="mx-3 dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                    <iconify-icon icon="healthicons:person" class="fs-4"></iconify-icon>
                  </a>
                  <ul class="dropdown-menu m-3 p-4">
                    <li>
                      <% UserEntity user = (UserEntity) session.getAttribute("user");%>
                      <c:if test="${user==null}">
                          <p class="">
                            <span class="text-primary fw-bold">Log in </span> to receive all features
                          </p>
                          <a href="login" class="btn btn-outline-secondary btn-sm text-uppercase fs-6 rounded-1">
                            login
                            <svg width="24" height="24" viewBox="0 0 24 24" class="mb-1">
                            <use xlink:href="#arrow-right"></use>
                            </svg></a>
                      </c:if>
                      <c:if test="${user!=null}">
                          <p class="">
                            Good morning, <span class="text-primary fw-bold">${user.getEmail()}</span>
                          </p>
                          <a href="login" class="btn btn-outline-secondary btn-sm text-uppercase fs-6 rounded-1">
                            logout
                            <svg width="24" height="24" viewBox="0 0 24 24" class="mb-1">
                            <use xlink:href="#arrow-right"></use>
                            </svg></a>
                      </c:if>

                    </li>
                  </ul>
                </div>
              </li>
              <li class="">
                <a href="index.html" class="mx-3" data-bs-toggle="offcanvas" data-bs-target="#offcanvasCart"
                   aria-controls="offcanvasCart">
                  <iconify-icon icon="mdi:cart" class="fs-4 position-relative"></iconify-icon>
                  <span class="position-absolute translate-middle badge rounded-circle bg-primary pt-2">
                    03
                  </span>
                </a>
              </li>
            </ul>

          </div>

        </div>

      </div>

    </nav>



  </div>
</header>
  </body>

</html>