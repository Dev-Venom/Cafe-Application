<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.cafe.Model.Product"%>

<section class="product-info">

    <span class="section-tag">

        Premium Coffee

    </span>

    <h1>

        <%=product.getProductName()%>

    </h1>

    <div class="product-rating">

        ⭐ <%=product.getRating()%> / 5

    </div>

    <p class="product-description">

        <%=product.getDescription()%>

    </p>

    <div class="product-price">

        ₹<%=String.format("%.2f", product.getPrice())%>

    </div>

    <div class="product-quantity">

        <label>Quantity</label>

        <div class="quantity-box">

            <button type="button">−</button>

            <input
                type="number"
                value="1"
                min="1"
                max="<%=product.getStock()%>">

            <button type="button">+</button>

        </div>

    </div>

    <div class="product-actions">

        <div class="product-stock">

            <% if(product.isAvailable()){ %>

                <span class="in-stock">

                    ✓ In Stock (<%=product.getStock()%> available)

                </span>

            <% } else { %>

                <span class="out-stock">

                    ✕ Out of Stock

                </span>

            <% } %>

        </div>

        <div class="product-buttons">

            <% if(product.isAvailable()){ %>

                <a href="<%=request.getContextPath()%>/cart/add?productId=<%=product.getProductId()%>"
                   class="btn btn-primary">

                    Add to Cart

                </a>

                <a href="#"
                   class="btn btn-secondary">

                    Buy Now

                </a>

            <% } else { %>

                <button
                    class="btn btn-disabled"
                    disabled>

                    Currently Unavailable

                </button>

            <% } %>

        </div>

    </div>

    <div class="product-highlights">

        <div class="highlight-item">

            ☕ Freshly Brewed

        </div>

        <div class="highlight-item">

            🌱 100% Premium Arabica Beans

        </div>

        <div class="highlight-item">

            🚚 Fast Delivery

        </div>

        <div class="highlight-item">

            ❤️ Customer Favorite

        </div>

    </div>

    <div class="product-meta">

        <div class="meta-item">

            <strong>Category ID:</strong>

            <span><%=product.getCategoryId()%></span>

        </div>

        <div class="meta-item">

            <strong>Product ID:</strong>

            <span>#<%=product.getProductId()%></span>

        </div>

    </div>

</section>