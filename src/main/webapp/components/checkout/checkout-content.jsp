<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <section class="checkout-section">

    <div class="container">

        <div class="checkout-layout">

            <div class="checkout-left">

                <%@ include file="address-details.jsp" %>

                <%@ include file="payment-section.jsp" %>

            </div>

            <div class="checkout-right">

                <%@ include file="order-summary.jsp" %>

            </div>

        </div>

    </div>

</section>