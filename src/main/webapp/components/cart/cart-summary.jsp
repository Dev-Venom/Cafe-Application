<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
if (subtotal == null) {
    subtotal = 0.0;
}

double shipping = subtotal > 0 ? 49.0 : 0.0;
double total = subtotal + shipping;
%>

<div class="cart-summary">

    <h2>Order Summary</h2>

    <div class="summary-row">

        <span>Subtotal</span>

        <span>₹<%=String.format("%.2f", subtotal)%></span>

    </div>

    <div class="summary-row">

        <span>Shipping</span>

        <span>₹<%=String.format("%.2f", shipping)%></span>

    </div>

    <hr>

    <div class="summary-row total-row">

        <span>Total</span>

        <span>₹<%=String.format("%.2f", total)%></span>

    </div>

    <a href="<%=request.getContextPath()%>/checkout"
       class="btn btn-primary summary-btn">

        Proceed to Checkout

    </a>

</div>