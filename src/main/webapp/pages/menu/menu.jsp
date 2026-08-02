<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.cafe.Model.Product" %>

<%
List<Product> products =
        (List<Product>) request.getAttribute("products");
%>

<!DOCTYPE html>

<html lang="en">

<head>

<meta charset="UTF-8">

<meta name="viewport"
      content="width=device-width, initial-scale=1.0">

<title>Menu | Pour d'Or</title>

<link rel="stylesheet"
      href="${pageContext.request.contextPath}/assets/css/main.css">

</head>

<body>

<%@ include file="../../components/layout/navbar.jsp" %>

<main class="menu-page">

    <%@ include file="../../components/menu/menu-header.jsp" %>
    
    
<%@ include file="../../components/menu/category-filter.jsp" %>

    <%@ include file="../../components/menu/search-bar.jsp" %>

   

    <%@ include file="../../components/menu/menu-grid.jsp" %>

</main>

<%@ include file="../../components/layout/footer.jsp" %>

</body>

</html>