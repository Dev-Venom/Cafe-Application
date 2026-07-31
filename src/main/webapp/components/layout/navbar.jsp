<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<nav class="navbar">

    <div class="container navbar-container">

      
        <a href="${pageContext.request.contextPath}/index.jsp" class="logo">
            Pour<span> d'Or</span>
        </a>

        
        <div class="nav-menu">

            <ul class="nav-links">

                <li>
                    <a class="active"
                       href="${pageContext.request.contextPath}/index.jsp">
                        Home
                    </a>
                </li>

                <li>
                    <a href="${pageContext.request.contextPath}/pages/menu/menu.jsp">
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

            <a href="${pageContext.request.contextPath}/pages/auth/login.jsp"
               class="btn btn-secondary">

                Login

            </a>

            <a href="${pageContext.request.contextPath}/pages/auth/register.jsp"
               class="btn btn-primary">

                Register

            </a>

        </div>

    </div>

</nav>