<%
Double subtotal =
        (Double) request.getAttribute("subtotal");

if(subtotal == null){

    subtotal = 0.0;

}

double shipping = subtotal > 0 ? 49.0 : 0.0;

double total = subtotal + shipping;
%>

<section class="checkout-card">

    <h2>

        Order Summary

    </h2>

    <div>

        <p>

            Subtotal :
            ₹<%=String.format("%.2f", subtotal)%>

        </p>

        <p>

            Shipping :
            ₹<%=String.format("%.2f", shipping)%>

        </p>

        <hr>

        <h3>

            Total :
            ₹<%=String.format("%.2f", total)%>

        </h3>

    </div>

    <br>

   <form action="<%=request.getContextPath()%>/place-order"
      method="post">

    <button type="submit"
            class="btn btn-primary summary-btn">

        Place Order

    </button>

</form>

</section>