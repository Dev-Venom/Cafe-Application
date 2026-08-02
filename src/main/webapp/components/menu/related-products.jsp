<%@ page import="java.util.List" %>
<%@ page import="com.cafe.Model.Product" %>

<%
List<Product> relatedProducts =
        (List<Product>) request.getAttribute("relatedProducts");
%>

<section class="related-products">

    <div class="container">

        <div class="section-heading">

            <span class="section-tag">

                YOU MAY ALSO LIKE

            </span>

            <h2>

                Related Products

            </h2>

        </div>

        <div class="related-grid">

        <%
        if(relatedProducts != null && !relatedProducts.isEmpty()){

            for(Product related : relatedProducts){
        %>

            <div class="related-card">

                <div class="related-image">

                    <img
                        src="<%=request.getContextPath()%>/assets/images/menu/<%=related.getImage()%>"
                        alt="<%=related.getProductName()%>">

                </div>

                <div class="related-content">

                    <h3>

                        <%=related.getProductName()%>

                    </h3>

                    <p>

                        ₹<%=String.format("%.2f", related.getPrice())%>

                    </p>

                    <a href="<%=request.getContextPath()%>/product?productId=<%=related.getProductId()%>"
                       class="btn btn-primary">

                        View Product

                    </a>

                </div>

            </div>

        <%
            }
        }
        %>

        </div>

    </div>

</section>