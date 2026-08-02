<%@ page import="com.cafe.Model.Product"%>



<section class="product-gallery">

    <div class="product-image">

        <img
            src="<%=request.getContextPath()%>/assets/images/menu/<%=product.getImage()%>"
            alt="<%=product.getProductName()%>">

    </div>

</section>