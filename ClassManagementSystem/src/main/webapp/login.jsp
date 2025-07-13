<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
            min-height: 100vh;
            display: flex;
            align-items: center;
        }
        
        .login-card {
            background: white;
            padding: 2.5rem;
            border-radius: 1rem;
            box-shadow: 0 0.5rem 1rem rgba(0, 0, 0, 0.1);
            max-width: 500px;
            width: 100%;
            margin: 2rem auto;
        }
        
        .login-title {
            color: #2c3e50;
            font-weight: 700;
            margin-bottom: 0.5rem;
            text-align: center;
        }
        
        .login-subtitle {
            color: #7f8c8d;
            text-align: center;
            margin-bottom: 2rem;
        }
        
        .form-control {
            border-radius: 0.5rem;
            padding: 0.75rem 1.25rem;
            transition: all 0.3s ease;
            border: 2px solid #e9ecef;
        }
        
        .form-control:focus {
            border-color: #3498db;
            box-shadow: 0 0 0 0.2rem rgba(52, 152, 219, 0.25);
        }
        
        .form-label {
            font-weight: 500;
            color: #2c3e50;
            margin-bottom: 0.5rem;
        }
        
        .btn-login {
            background: linear-gradient(135deg, #3498db, #2980b9);
            border: none;
            padding: 0.75rem 2rem;
            font-weight: 600;
            transition: all 0.3s ease;
            width: 100%;
            border-radius: 0.5rem;
            color: white;
        }
        
        .btn-login:hover {
            transform: translateY(-2px);
            box-shadow: 0 5px 15px rgba(52, 152, 219, 0.3);
            color: white;
        }
        
        .register-link {
            text-align: center;
            margin-top: 1.5rem;
            color: #7f8c8d;
        }
        
        .register-link a {
            color: #3498db;
            text-decoration: none;
            font-weight: 500;
            transition: color 0.3s ease;
        }
        
        .register-link a:hover {
            color: #2980b9;
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="login-card">
            <h1 class="login-title">Log In</h1>
            <p class="login-subtitle">Please sign in to continue</p>

            <form action="${pageContext.request.contextPath}/login" method="post">
                <div class="mb-4">
                    <label for="username" class="form-label">Username</label>
                    <input type="text" class="form-control" id="username" name="username" required>
                </div>

                <div class="mb-4">
                    <label for="password" class="form-label">Password</label>
                    <input type="password" class="form-control" id="password" name="password" required>
                </div>

                <button type="submit" class="btn btn-login">Sign In</button>
            </form>

            <p class="register-link">
                Don't have an account? <a href="${pageContext.request.contextPath}/register.jsp">Create account</a>
            </p>
        </div>
    </div>
</body>
</html>
