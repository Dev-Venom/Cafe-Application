<%@ page import="java.util.List" %>
<%@ page import="com.cafe.Model.Product" %>

<%
@SuppressWarnings("unchecked")
List<Product> menuProducts =
        (List<Product>) request.getAttribute("products");
%>

<section class="menu-section">

    <div class="container">

        <div class="menu-grid">

        <%
        if(menuProducts != null && !menuProducts.isEmpty()){

            for(Product product : menuProducts){
        %>

            <div class="menu-card">

                <div class="menu-card-image">

                    <img
                        src="<%=request.getContextPath()%>/assets/images/menu/<%=product.getImage()%>"
                        alt="<%=product.getProductName()%>">

                </div>

                <div class="menu-card-content">

                    <span class="menu-rating">

                        ⭐ <%=product.getRating()%>

                    </span>

                    <h3>

                        <%=product.getProductName()%>

                    </h3>

                    <p>

                        <%=product.getDescription()%>

                    </p>

                    <div class="menu-card-footer">

                        <span class="menu-price">

                            ₹<%=String.format("%.2f", product.getPrice())%>

                        </span>

                        <a href="<%=request.getContextPath()%>/product?productId=<%=product.getProductId()%>"
                           class="btn btn-primary">

                            View Details

                        </a>

                    </div>

                </div>

            </div>

        <%
            }
        } else {
        %>

            <div class="empty-menu">

                <h2>No Products Available</h2>

                <p>

                    Our coffee menu is being prepared.
                    Please check back later.

                </p>

            </div>

        <%
        }
        %>

        </div>

    </div>

</section>