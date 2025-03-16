<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.ProductEntity"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">

  <head>
    <title>Search</title>
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

    <section id="search" class="my-5">
      <div class="container">
        <div class="row">
          <div class="col-md-3">
            <h3>Filter by Tags</h3>
            <form id="search-form" method="GET" action="search">
              <%
                  List<String> allTags = (List<String>) request.getAttribute("allTags");
                  String[] selectedTags = (String[]) request.getAttribute("selectedTags");
                  List<String> selectedTagsList = selectedTags != null ? Arrays.asList(selectedTags) : new ArrayList<>();
                  for (String tag : allTags) {
              %>
              <div class="form-check">
                <input class="form-check-input" type="checkbox" name="tags" value="<%= tag%>" id="tag_<%= tag%>"
                       <%= selectedTagsList.contains(tag) ? "checked" : ""%>>
                <label class="form-check-label" for="tag_<%= tag%>"><%= tag%></label>
              </div>
              <% }%>
              <div>
                <button type="submit" class="btn btn">
              </div>
          </div>
          <div class="col-md-9">
            <div class="search-bar border rounded-2 px-3 border-dark-subtle mb-4">
              <div class="text-center d-flex align-items-center">
                <input type="text" class="form-control border-0 bg-transparent" name="q" 
                       placeholder="Search for more than 10,000 products" 
                       value="<%= request.getAttribute("searchTerm") != null ? request.getAttribute("searchTerm") : ""%>" />
                <button type="submit" class="btn border-0 bg-transparent p-0">
                  <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24">
                  <path fill="currentColor" d="M21.71 20.29L18 16.61A9 9 0 1 0 16.61 18l3.68 3.68a1 1 0 0 0 1.42 0a1 1 0 0 0 0-1.39ZM11 18a7 7 0 1 1 7-7a7 7 0 0 1-7 7Z"/>
                  </svg>
                </button>
              </div>
            </div>
            </form>
            <div id="search-results">
              <div class="isotope-container row">
                
<!--                <div class="item cat col-md-4 col-lg-3 my-4">
                   <div class="z-1 position-absolute rounded-3 m-3 px-3 border border-dark-subtle">
                    New
                  </div> 
                  <div class="card position-relative">
                    <a href="single-product.html"><img src="images/item9.jpg" class="img-fluid rounded-4" alt="image"></a>
                    <div class="card-body p-0">
                      <a href="single-product.html">
                        <h3 class="card-title pt-4 m-0">Grey hoodie</h3>
                      </a>

                      <div class="card-text">
                        <span class="rating secondary-font">
                          <iconify-icon icon="clarity:star-solid" class="text-primary"></iconify-icon>
                          <iconify-icon icon="clarity:star-solid" class="text-primary"></iconify-icon>
                          <iconify-icon icon="clarity:star-solid" class="text-primary"></iconify-icon>
                          <iconify-icon icon="clarity:star-solid" class="text-primary"></iconify-icon>
                          <iconify-icon icon="clarity:star-solid" class="text-primary"></iconify-icon>
                          5.0</span>

                        <h3 class="secondary-font text-primary">$18.00</h3>

                        <div class="d-flex flex-wrap mt-3">
                          <a href="#" class="btn-cart me-3 px-4 pt-3 pb-3">
                            <h5 class="text-uppercase m-0">Add to Cart</h5>
                          </a>
                          <a href="#" class="btn-wishlist px-4 pt-3 ">
                            <iconify-icon icon="fluent:heart-28-filled" class="fs-5"></iconify-icon>
                          </a>
                        </div>


                      </div>

                    </div>
                  </div>
                </div>-->

              
              <%
                  List<ProductEntity> products = (List<ProductEntity>) request.getAttribute("products");
                  if (products != null && !products.isEmpty()) {
                      for (ProductEntity product : products) {
              %>
              <div class="item col-md-4 col-lg-3 my-4">
                <div class="card position-relative">
                  <a href="#">
                    <img src="<%= product.getImage()%>" 
                         class="img-fluid rounded-4" alt="${product.productName}">

                  </a>
                  <div class="card-body p-0">
                    <a href="single-product.html?id=<%= product.getProductID()%>">
                      <h3 class="card-title pt-4 m-0"><%= product.getProductName()%></h3>
                    </a>
                    <div class="card-text">
                      <span class="rating secondary-font">
                        <iconify-icon icon="clarity:star-solid" class="text-primary"></iconify-icon>
                        <iconify-icon icon="clarity:star-solid" class="text-primary"></iconify-icon>
                        <iconify-icon icon="clarity:star-solid" class="text-primary"></iconify-icon>
                        <iconify-icon icon="clarity:star-solid" class="text-primary"></iconify-icon>
                        <iconify-icon icon="clarity:star-solid" class="text-primary"></iconify-icon>
                        5.0
                      </span>
                      <h3 class="secondary-font text-primary">$<%= product.getPrice()%></h3>
                      <div class="d-flex flex-wrap mt-3">
                        <a href="#" class="btn-cart me-3 px-4 pt-3 pb-3">
                          <h5 class="text-uppercase m-0">Add to Cart</h5>
                        </a>
                        <a href="#" class="btn-wishlist px-4 pt-3">
                          <iconify-icon icon="fluent:heart-28-filled" class="fs-5"></iconify-icon>
                        </a>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <%
                  }
              } else if (request.getAttribute("products") != null) {
              %>
              </div>
              <p>No products found.</p>
              <% }%>
            </div>
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
  </body>

</html>