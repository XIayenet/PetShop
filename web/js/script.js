(function($) {

  "use strict";

  var initPreloader = function() {
    $(document).ready(function($) {
    var Body = $('body');
        Body.addClass('preloader-site');
    });
    $(window).load(function() {
        $('.preloader-wrapper').fadeOut();
        $('body').removeClass('preloader-site');
    });
  }

  // init Chocolat light box
	var initChocolat = function() {
		Chocolat(document.querySelectorAll('.image-link'), {
		  imageSize: 'contain',
		  loop: true,
		})
	}

  var initSwiper = function() {

    var swiper = new Swiper(".main-swiper", {
      speed: 500,
      pagination: {
        el: ".swiper-pagination",
        clickable: true,
      },
    });

    var bestselling_swiper = new Swiper(".bestselling-swiper", {
      slidesPerView: 4,
      spaceBetween: 30,
      speed: 500,
      breakpoints: {
        0: {
          slidesPerView: 1,
        },
        768: {
          slidesPerView: 3,
        },
        991: {
          slidesPerView: 4,
        },
      }
    });

    var testimonial_swiper = new Swiper(".testimonial-swiper", {
      slidesPerView: 1,
      speed: 500,
      pagination: {
        el: ".swiper-pagination",
        clickable: true,
      },
    });

    var products_swiper = new Swiper(".products-carousel", {
      slidesPerView: 4,
      spaceBetween: 30,
      speed: 500,
      breakpoints: {
        0: {
          slidesPerView: 1,
        },
        768: {
          slidesPerView: 3,
        },
        991: {
          slidesPerView: 4,
        },

      }
    });

  }

  var initProductQty = function(){

    $('.product-qty').each(function(){

      var $el_product = $(this);
      var quantity = 0;

      $el_product.find('.quantity-right-plus').click(function(e){
          e.preventDefault();
          var quantity = parseInt($el_product.find('#quantity').val());
          $el_product.find('#quantity').val(quantity + 1);
      });

      $el_product.find('.quantity-left-minus').click(function(e){
          e.preventDefault();
          var quantity = parseInt($el_product.find('#quantity').val());
          if(quantity>0){
            $el_product.find('#quantity').val(quantity - 1);
          }
      });

    });

  }

  // init jarallax parallax
  var initJarallax = function() {
    jarallax(document.querySelectorAll(".jarallax"));

    jarallax(document.querySelectorAll(".jarallax-keep-img"), {
      keepImg: true,
    });
  }

  // document ready
  $(document).ready(function() {
    
    initPreloader();
    initSwiper();
    initProductQty();
    initJarallax();
    initChocolat();

        // product single page
        var thumb_slider = new Swiper(".product-thumbnail-slider", {
          spaceBetween: 8,
          slidesPerView: 3,
          freeMode: true,
          watchSlidesProgress: true,
        });
    
        var large_slider = new Swiper(".product-large-slider", {
          spaceBetween: 10,
          slidesPerView: 1,
          effect: 'fade',
          thumbs: {
            swiper: thumb_slider,
          },
        });

    window.addEventListener("load", (event) => {
      //isotope
      $('.isotope-container').isotope({
        // options
        itemSelector: '.item',
        layoutMode: 'masonry'
      });


      var $grid = $('.entry-container').isotope({
        itemSelector: '.entry-item',
        layoutMode: 'masonry'
      });


      // Initialize Isotope
      var $container = $('.isotope-container').isotope({
        // options
        itemSelector: '.item',
        layoutMode: 'masonry'
      });

      $(document).ready(function () {
        //active button
        $('.filter-button').click(function () {
          $('.filter-button').removeClass('active');
          $(this).addClass('active');
        });
      });

      // Filter items on button click
      $('.filter-button').click(function () {
        var filterValue = $(this).attr('data-filter');
        if (filterValue === '*') {
          // Show all items
          $container.isotope({ filter: '*' });
        } else {
          // Show filtered items
          $container.isotope({ filter: filterValue });
        }
      });

    });

  }); // End of a document

// Search functionality
document.addEventListener('DOMContentLoaded', function() {
    const searchInput = document.querySelector('#search-form-body input');
    const tagCheckboxes = document.querySelectorAll('#filter-form input[type="checkbox"]');
    
    // Debounce function to limit API calls
    const debounce = (func, delay) => {
        let timeout;
        return (...args) => {
            clearTimeout(timeout);
            timeout = setTimeout(() => func.apply(this, args), delay);
        };
    };

    // Search function
    const performSearch = debounce(async () => {
        const searchTerm = searchInput.value;
        const selectedTags = Array.from(tagCheckboxes)
            .filter(checkbox => checkbox.checked)
            .map(checkbox => checkbox.value);

        try {
            const response = await fetch('/SearchServlet', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    query: searchTerm,
                    tags: selectedTags
                })
            });
            
            const results = await response.json();
            updateSearchResults(results);
        } catch (error) {
            console.error('Search error:', error);
        }
    }, 300);

    // Event listeners
    searchInput.addEventListener('input', performSearch);
    tagCheckboxes.forEach(checkbox => 
        checkbox.addEventListener('change', performSearch)
    );

    // Update results in DOM
    function updateSearchResults(products) {
        const resultsContainer = document.getElementById('search-results');
        resultsContainer.innerHTML = products.length > 0 
            ? products.map(product => createProductCard(product)).join('')
            : '<p class="text-center">No products found matching your criteria</p>';
    }

    // Create product card HTML
    function createProductCard(product) {
        return `
            <div class="item dog col-md-4 col-lg-3 my-4">
                <div class="card position-relative">
                    <a href="single-product.html?id=${product.ProductID}">
                        <img src="${product.Image}" class="img-fluid rounded-4" alt="${product.ProductName}">
                    </a>
                    <div class="card-body p-0">
                        <a href="single-product.html?id=${product.ProductID}">
                            <h3 class="card-title pt-4 m-0">${product.ProductName}</h3>
                        </a>
                        <div class="card-text">
                            <h3 class="secondary-font text-primary">$${product.Price.toFixed(2)}</h3>
                            <div class="d-flex flex-wrap mt-3">
                                <button class="btn-cart me-3 px-4 pt-3 pb-3" 
                                    onclick="addToCart(${product.ProductID})">
                                    <h5 class="text-uppercase m-0">Add to Cart</h5>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        `;
    }
});
})(jQuery);