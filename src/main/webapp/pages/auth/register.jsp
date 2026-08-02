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

           <form action="${pageContext.request.contextPath}/register"
      method="post"
      class="login-form">

    <div class="form-group">

        <label>Full Name</label>

        <input
            type="text"
            name="userName"
            placeholder="Enter your full name"
            required>

    </div>

    <div class="form-group">

        <label>Email</label>

        <input
            type="email"
            name="email"
            placeholder="Enter your email"
            required>

    </div>

    <div class="form-group">

        <label>Phone Number</label>

        <input
            type="text"
            name="phone"
            placeholder="Enter your phone number"
            required>

    </div>

    <div class="form-group">

        <label>Password</label>

        <input
            type="password"
            name="password"
            placeholder="Create a password"
            required>

    </div>

    <div class="form-group">

        <label>Confirm Password</label>

        <input
            type="password"
            name="confirmPassword"
            placeholder="Confirm password"
            required>

    </div>

    <button
        type="submit"
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