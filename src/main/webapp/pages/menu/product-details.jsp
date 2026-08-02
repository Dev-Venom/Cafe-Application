<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="com.cafe.Model.Product"%>

<%
Product product =
(Product)request.getAttribute("product");
%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title><%=product.getProductName()%></title>

<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/css/main.css">

</head>

<body>

<%@ include file="../../components/layout/navbar.jsp" %>

<main class="product-page">

    <div class="container">

        <div class="product-layout">

            <%@ include file="../../components/menu/product-gallery.jsp" %>

            <%@ include file="../../components/menu/product-info.jsp" %>

        </div>

        <%@ include file="../../components/menu/related-products.jsp" %>

    </div>

</main>
<%@ include file="../../components/layout/footer.jsp" %>

</body>

</html>