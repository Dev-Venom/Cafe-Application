<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Menu | Pour d'Or</title>

<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/css/main.css">

</head>

<body>

<%@ include file="../../components/layout/navbar.jsp" %>

<main class="menu-page">

    <%@ include file="../../components/menu/menu-header.jsp" %>

    <%@ include file="../../components/menu/search-bar.jsp" %>
    
    <%@ include file="../../components/menu/product-card.jsp" %>


</main>

<%@ include file="../../components/layout/footer.jsp" %>

</body>

</html>