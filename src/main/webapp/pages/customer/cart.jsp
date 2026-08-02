<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.cafe.Model.CartItemDetails"%>

<%
List<CartItemDetails> cartItems =
(List<CartItemDetails>)request.getAttribute("cartItems");

Double subtotal =
(Double)request.getAttribute("subtotal");

if(subtotal == null){
    subtotal = 0.0;
}
%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Shopping Cart | Pour d'Or</title>

<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/css/main.css">

</head>

<body>

<%@ include file="../../components/layout/navbar.jsp" %>

<main class="cart-page">

    <%@ include file="../../components/cart/cart-header.jsp" %>

    <%@ include file="../../components/cart/cart-content.jsp" %>

</main>

<%@ include file="../../components/layout/footer.jsp" %>

</body>

</html>