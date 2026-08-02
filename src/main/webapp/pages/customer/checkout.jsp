<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Checkout | Pour d'Or</title>

<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/css/main.css">

</head>

<body>

<%@ include file="../../components/layout/navbar.jsp" %>

<main class="checkout-page">

    <%@ include file="../../components/checkout/checkout-header.jsp" %>

    <%@ include file="../../components/checkout/checkout-content.jsp" %>

</main>

<%@ include file="../../components/layout/footer.jsp" %>

</body>

</html>