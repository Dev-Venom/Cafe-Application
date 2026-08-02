<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="com.cafe.Model.Orders"%>

<%
Orders order =
(Orders)request.getAttribute("order");
%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Order Successful | Pour d'Or</title>

<link rel="stylesheet"
href="<%=request.getContextPath()%>/assets/css/main.css">

</head>

<body>

<%@ include file="../../components/layout/navbar.jsp" %>

<section class="success-page">

    <div class="container">

        <div class="success-card">

            <h1>🎉 Order Placed Successfully!</h1>

            <p>

                Thank you for choosing Pour d'Or.

            </p>

            <br>

            <p>

                <strong>Order ID :</strong>

                #<%=order.getOrderId()%>

            </p>

            <p>

                <strong>Total :</strong>

                ₹<%=String.format("%.2f",
                order.getTotalAmount())%>

            </p>

            <p>

                <strong>Status :</strong>

                <%=order.getOrderStatus()%>

            </p>

            <br>

            <a
            href="<%=request.getContextPath()%>/orders"
            class="btn btn-primary">

                View My Orders

            </a>

        </div>

    </div>

</section>

<%@ include file="../../components/layout/footer.jsp" %>

</body>

</html>