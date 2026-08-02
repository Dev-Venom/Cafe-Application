<%@ page import="java.util.List"%>
<%@ page import="com.cafe.Model.Address"%>

<%
List<Address> addresses =
        (List<Address>) request.getAttribute("addresses");
%>

<section class="checkout-card">

    <h2>Delivery Address</h2>

    <% if(addresses != null && !addresses.isEmpty()) { %>

        <% for(Address address : addresses) { %>

            <label class="address-option">

                <input
                    type="radio"
                    name="addressId"
                    value="<%=address.getAddressId()%>"
                    <%=address == addresses.get(0) ? "checked" : ""%>>

                <strong>
                    <%=address.getHouseNo()%>
                </strong>

                <br>

                <%=address.getStreet()%>

                <br>

                <%=address.getCity()%>,
                <%=address.getState()%>

                -

                <%=address.getPincode()%>

            </label>

            <br><br>

        <% } %>

    <% } else { %>

        <p>No delivery address found.</p>

        <a href="<%=request.getContextPath()%>/profile">

            Add Address

        </a>

    <% } %>

</section>