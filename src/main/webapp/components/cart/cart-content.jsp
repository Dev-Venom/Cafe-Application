<%@ page import="com.cafe.Model.CartItemDetails"%>

<section class="cart-section">

    <div class="container">

        <div class="cart-layout">

            <div class="cart-items">

                <%
                if(cartItems != null && !cartItems.isEmpty()){

                    for(CartItemDetails item : cartItems){

                        request.setAttribute("item", item);
                %>

                        <%@ include file="cart-item.jsp" %>

                <%
                    }
                }else{
                %>

                    <div class="empty-cart">

                        <h2>Your cart is empty</h2>

                        <p>

                            Start exploring our premium coffee collection.

                        </p>

                        <a href="<%=request.getContextPath()%>/menu"
                           class="btn btn-primary">

                            Browse Menu

                        </a>

                    </div>

                <%
                }
                %>

            </div>

            <%@ include file="cart-summary.jsp" %>

        </div>

    </div>

</section>