<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@page import="com.cafe.Model.User"%>

<%
User loggedInUser = (User) session.getAttribute("loggedInUser");
%>

<%
Integer cartCount =
(Integer)request.getAttribute("cartCount");

if(cartCount == null){

    cartCount = 0;

}
%>

<nav class="navbar">

    <div class="container navbar-container">

      
        <a href="${pageContext.request.contextPath}/" class="logo">
            Pour<span> d'Or</span>
        </a>

        
        <div class="nav-menu">

            <ul class="nav-links">

                <li>
                    <a class="active"
                       href="${pageContext.request.contextPath}/">
                        Home
                    </a>
                </li>

                <li>
                    <a href="${pageContext.request.contextPath}/menu">
                        Menu
                    </a>
                </li>

                <li>
                    <a href="${pageContext.request.contextPath}/pages/about/about.jsp">
                        About
                    </a>
                </li>

                <li>
                    <a href="${pageContext.request.contextPath}/pages/contact/contact.jsp">
                        Contact
                    </a>
                </li>

            </ul>

        </div>

        

        <div class="nav-actions">
        
        <% if(loggedInUser != null){ %>

    <a href="${pageContext.request.contextPath}/cart"
       class="cart-btn">

        🛒

        <span class="cart-count">

            <%=cartCount%>

        </span>

    </a>

<% } %>

<% if(loggedInUser == null){ %>

    <a href="${pageContext.request.contextPath}/pages/auth/login.jsp"
       class="btn btn-outline">

        Login

    </a>

    <a href="${pageContext.request.contextPath}/pages/auth/register.jsp"
       class="btn btn-primary">

        Register

    </a>

<% } else { %>

    <span class="nav-user">

        Hi, <%= loggedInUser.getUserName() %>

    </span>

    <a href="${pageContext.request.contextPath}/logout"
       class="btn btn-primary">

        Logout

    </a>

<% } %>

</div>

    </div>

</nav>