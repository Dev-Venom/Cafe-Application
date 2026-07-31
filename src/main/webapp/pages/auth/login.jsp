<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Login | Pour d'Or</title>

<link rel="stylesheet"
      href="${pageContext.request.contextPath}/assets/css/main.css">

</head>

<body>

<section class="login-page">

    <div class="login-container">

        <!-- Left Side -->
        <div class="login-image">

            <img
                src="${pageContext.request.contextPath}/assets/images/auth/login.jpg"
                alt="Coffee">

        </div>

        <!-- Right Side -->
        <div class="login-content">

            <span class="section-tag">
                Welcome Back
            </span>

            <h1>Sign In</h1>

            <p>
                Continue your premium coffee journey with Pour d'Or.
            </p>

            <form action="${pageContext.request.contextPath}/login"
                  method="post"
                  class="login-form">

                <div class="form-group">

                    <label for="email">Email</label>

                    <input
                        type="email"
                        id="email"
                        name="email"
                        placeholder="Enter your email"
                        required>

                </div>

                <div class="form-group">

                    <label for="password">Password</label>

                    <input
                        type="password"
                        id="password"
                        name="password"
                        placeholder="Enter your password"
                        required>

                </div>

                <div class="login-options">

                    <label>

                        <input
                            type="checkbox"
                            name="remember">

                        Remember Me

                    </label>
                   

                    <a href="#">Forgot Password?</a>

                </div>

                <button
                    type="submit"
                    class="btn btn-primary login-btn">

                    Sign In

                </button>

            </form>

            <div class="login-divider">
                <span>OR</span>
            </div>

            <p class="register-link">

                Don't have an account?

                <a href="${pageContext.request.contextPath}/pages/auth/register.jsp">

                    Register

                </a>

            </p>

        </div>

    </div>

</section>

</body>

</html>