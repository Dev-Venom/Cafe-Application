

<div class="cart-item">

    <div class="cart-item-image">

        <img
        src="<%=request.getContextPath()%>/assets/images/menu/<%=item.getImage()%>"
        alt="<%=item.getProductName()%>">

    </div>

    <div class="cart-item-details">

        <h3>

            <%=item.getProductName()%>

        </h3>

        <span class="cart-item-price">

            ₹<%=String.format("%.2f", item.getPrice())%>

        </span>

    </div>

    <div class="cart-item-quantity">

    <a href="<%=request.getContextPath()%>/cart/update?cartItemId=<%=item.getCartItemId()%>&action=decrease"
       class="qty-btn">

        -

    </a>

    <span class="qty-value">

        <%=item.getQuantity()%>

    </span>

    <a href="<%=request.getContextPath()%>/cart/update?cartItemId=<%=item.getCartItemId()%>&action=increase"
       class="qty-btn">

        +

    </a>

</div>

    <div class="cart-item-total">

        ₹<%=String.format("%.2f", item.getItemTotal())%>

    </div>

    <div class="cart-item-action">

        <a href="<%=request.getContextPath()%>/cart/remove?cartItemId=<%=item.getCartItemId()%>"
           class="remove-btn">

            Remove

        </a>

    </div>

</div>