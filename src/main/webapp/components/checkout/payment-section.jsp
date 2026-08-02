<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<section class="checkout-card">

    <h2>Payment Method</h2>

    <div class="payment-options">

        <label class="payment-option">

            <input
                type="radio"
                name="paymentMethod"
                value="COD"
                checked>

            <span>Cash on Delivery (COD)</span>

        </label>

        <br><br>

        <label class="payment-option">

            <input
                type="radio"
                name="paymentMethod"
                value="UPI">

            <span>UPI</span>

        </label>

        <br><br>

        <label class="payment-option">

            <input
                type="radio"
                name="paymentMethod"
                value="CARD">

            <span>Credit / Debit Card</span>

        </label>

        <br><br>

        <label class="payment-option">

            <input
                type="radio"
                name="paymentMethod"
                value="NET_BANKING">

            <span>Net Banking</span>

        </label>

    </div>

</section>