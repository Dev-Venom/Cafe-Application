<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="UTF-8">

<meta name="viewport"
      content="width=device-width, initial-scale=1.0">

<title>Register | Pour d'Or</title>

<link rel="stylesheet"
      href="${pageContext.request.contextPath}/assets/css/main.css">

</head>

<body>

<section class="login-page">

    <div class="login-container">

        <!-- Left Side -->

        <div class="login-image">

            <img
                src="${pageContext.request.contextPath}/assets/images/auth/register.jpg"
                alt="Coffee">

        </div>

        <!-- Right Side -->

        <div class="login-content">

            <span class="section-tag">
                JOIN POUR D'OR
            </span>

            <h1>Create Account</h1>

            <p>
                Become part of our premium coffee community.
            </p>

            <form class="login-form">

                <div class="form-group">

                    <label>Full Name</label>

                    <input
                        type="text"
                        placeholder="Enter your full name">

                </div>

                <div class="form-group">

                    <label>Email</label>

                    <input
                        type="email"
                        placeholder="Enter your email">

                </div>

                <div class="form-group">

                    <label>Password</label>

                    <input
                        type="password"
                        placeholder="Create a password">

                </div>

                <div class="form-group">

                    <label>Confirm Password</label>

                    <input
                        type="password"
                        placeholder="Confirm password">

                </div>

                <button
                    class="btn btn-primary login-btn">

                    Create Account

                </button>

            </form>

            <div class="login-divider">

                <span>OR</span>

            </div>

            <p class="register-link">

                Already have an account?

                <a href="${pageContext.request.contextPath}/pages/auth/login.jsp">

                    Sign In

                </a>

            </p>

        </div>

    </div>

</section>

</body>

</html>