<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

  <head>
    <title>Product List - Waggy</title>
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
    <header>
      <div class="container py-2">
        <div class="row py-4 pb-0 pb-sm-4 align-items-center">
          <div class="col-sm-4 col-lg-3 text-center text-sm-start">
            <div class="main-logo">
              <a href="index.html">
                <img src="images/logo.png" alt="logo" class="img-fluid">
              </a>
            </div>
          </div>
          <div class="col-sm-6 offset-sm-2 offset-md-0 col-lg-5 d-none d-lg-block">
            <div class="search-bar border rounded-2 px-3 border-dark-subtle">
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
    </header>

    <section id="product-list" class="my-5">
      <div class="container">
        <div class="d-flex justify-content-between align-items-center mb-3">
          <h2 class="display-4 fw-normal">Product List</h2>
          <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">Add Product</button>
        </div>

        <!-- Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
          <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
            <form action="addProduct" method="POST" enctype="multipart/form-data">
              <div class="modal-content">
                <div class="modal-header">
                  <h5 class="modal-title" id="exampleModalLabel">Add a new product</h5>
                  <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                  <label for="productName" class="form-label">Product Name</label>
                  <div class="input-group mb-3">
                    <input type="text" class="form-control" name="productName" id="productName" aria-describedby="basic-addon3">
                  </div>

                  <label for="productDescription" class="form-label">Description</label>
                  <div class="input-group mb-3">
                    <textarea id="productDescription" name="productDescription" class="form-control" aria-label="With textarea"></textarea>
                  </div>

                  <label for="price" class="form-label">Price</label>
                  <div class="input-group mb-3">
                    <span class="input-group-text">$</span>
                    <input id="price" name="price" type="text" class="form-control" aria-label="Amount (to the nearest dollar)">
                    <span class="input-group-text">.00</span>
                  </div>

                  <label for="stock" class="form-label">Stock Quantity</label>
                  <div class="input-group mb-3">
                    <input type="text" class="form-control" name="stock" id="stock" aria-describedby="basic-addon3">
                  </div>

                  <div class="mb-3">
                    <label for="formFile" class="form-label">Product Image</label>
                    <input class="form-control" accept="image/*" name="image" type="file" id="formFile">
                  </div>

                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                  <button type="submit" class="btn btn-primary">Save changes</button>
                </div>
              </div>
            </form>

          </div>
        </div>

        <div class="table-responsive">
          <table class="table table-striped table-bordered">
            <thead class="table-light">
              <tr>
                <th scope="col">Product ID</th>
                <th scope="col">Product Name</th>
                <th scope="col">Description</th>
                <th scope="col">Price</th>
                <th scope="col">Stock Quantity</th>
                <th scope="col">Actions</th>
              </tr>
            </thead>
            <tbody>
              <!-- Example row, replace with dynamic content -->
              <tr>
                <td>1</td>
                <td>Grey Hoodie</td>
                <td>This grey hoodie is perfect for your pet.</td>
                <td>$18.00</td>
                <td>50</td>
                <td>
                  <button class="btn btn-secondary btn-sm">Edit</button>
                  <button class="btn btn-danger btn-sm">Delete</button>
                </td>
              </tr>
              <!-- Add more rows as needed -->
            </tbody>
          </table>
        </div>
      </div>
    </section>

    <footer id="footer" class="my-5">
      <div class="container py-5 my-5">
        <div class="row">
          <div class="col-md-3">
            <div class="footer-menu">
              <img src="images/logo.png" alt="logo">
              <p class="blog-paragraph fs-6 mt-3">Subscribe to our newsletter to get updates about our grand offers.</p>
              <div class="social-links">
                <ul class="d-flex list-unstyled gap-2">
                  <li class="social">
                    <a href="#">
                      <iconify-icon class="social-icon" icon="ri:facebook-fill"></iconify-icon>
                    </a>
                  </li>
                  <li class="social">
                    <a href="#">
                      <iconify-icon class="social-icon" icon="ri:twitter-fill"></iconify-icon>
                    </a>
                  </li>
                  <li class="social">
                    <a href="#">
                      <iconify-icon class="social-icon" icon="ri:pinterest-fill"></iconify-icon>
                    </a>
                  </li>
                  <li class="social">
                    <a href="#">
                      <iconify-icon class="social-icon" icon="ri:instagram-fill"></iconify-icon>
                    </a>
                  </li>
                  <li class="social">
                    <a href="#">
                      <iconify-icon class="social-icon" icon="ri:youtube-fill"></iconify-icon>
                    </a>
                  </li>
                </ul>
              </div>
            </div>
          </div>
          <div class="col-md-3">
            <div class="footer-menu">
              <h3>Quick Links</h3>
              <ul class="menu-list list-unstyled">
                <li class="menu-item">
                  <a href="#" class="nav-link">Home</a>
                </li>
                <li class="menu-item">
                  <a href="#" class="nav-link">About us</a>
                </li>
                <li class="menu-item">
                  <a href="#" class="nav-link">Offer</a>
                </li>
                <li class="menu-item">
                  <a href="#" class="nav-link">Services</a>
                </li>
                <li class="menu-item">
                  <a href="#" class="nav-link">Contact Us</a>
                </li>
              </ul>
            </div>
          </div>
          <div class="col-md-3">
            <div class="footer-menu">
              <h3>Help Center</h3>
              <ul class="menu-list list-unstyled">
                <li class="menu-item">
                  <a href="#" class="nav-link">FAQs</a>
                </li>
                <li class="menu-item">
                  <a href="#" class="nav-link">Payment</a>
                </li>
                <li class="menu-item">
                  <a href="#" class="nav-link">Returns & Refunds</a>
                </li>
                <li class="menu-item">
                  <a href="#" class="nav-link">Checkout</a>
                </li>
                <li class="menu-item">
                  <a href="#" class="nav-link">Delivery Information</a>
                </li>
              </ul>
            </div>
          </div>
          <div class="col-md-3">
            <div>
              <h3>Our Newsletter</h3>
              <p class="blog-paragraph fs-6">Subscribe to our newsletter to get updates about our grand offers.</p>
              <div class="search-bar border rounded-pill border-dark-subtle px-2">
                <form class="text-center d-flex align-items-center" action="" method="">
                  <input type="text" class="form-control border-0 bg-transparent" placeholder="Enter your email here" />
                  <iconify-icon class="send-icon" icon="tabler:location-filled"></iconify-icon>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </footer>

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
  </body>

</html>