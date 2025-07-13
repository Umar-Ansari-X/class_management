<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
            min-height: 100vh;
            display: flex;
            align-items: center;
        }
        
        .registration-card {
            background: white;
            padding: 2.5rem;
            border-radius: 1rem;
            box-shadow: 0 0.5rem 1rem rgba(0, 0, 0, 0.1);
            max-width: 500px;
            width: 100%;
            margin: 2rem auto;
        }
        
        .registration-title {
            color: #2c3e50;
            font-weight: 700;
            margin-bottom: 0.5rem;
            text-align: center;
        }
        
        .registration-subtitle {
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
        
        .btn-register {
            background: linear-gradient(135deg, #3498db, #2980b9);
            border: none;
            padding: 0.75rem 2rem;
            font-weight: 600;
            transition: all 0.3s ease;
            width: 100%;
            border-radius: 0.5rem;
        }
        
        .btn-register:hover {
            transform: translateY(-2px);
            box-shadow: 0 5px 15px rgba(52, 152, 219, 0.3);
        }
        
        .login-link {
            text-align: center;
            margin-top: 1.5rem;
            color: #7f8c8d;
        }
        
        .login-link a {
            color: #3498db;
            text-decoration: none;
            font-weight: 500;
            transition: color 0.3s ease;
        }
        
        .login-link a:hover {
            color: #2980b9;
            text-decoration: underline;
        }
        
        #userFields {
            transition: all 0.3s ease;
            overflow: hidden;
        }
    </style>
<script>
    function toggleFields() {
        var role = document.getElementById("role").value;
        var usernameLabel = document.getElementById("usernameLabel");
        var userFields = document.getElementById("userFields");
        var nameField = document.getElementById("name");

        if (role === "admin") {
            usernameLabel.innerHTML = "Admin Username";
            userFields.style.opacity = "0";
            userFields.style.height = "0";
            userFields.style.margin = "0";
            nameField.removeAttribute("required");
        } else {
            usernameLabel.innerHTML = "Student ID";
            userFields.style.opacity = "1";
            userFields.style.height = "auto";
            userFields.style.margin = "1rem 0";
            nameField.setAttribute("required", "required");
        }
    }

    window.onload = toggleFields;
</script>
</head>
<body>
    <div class="container">
        <div class="registration-card">
            <h1 class="registration-title">Create Account</h1>
            <p class="registration-subtitle">Register as admin or student</p>

            <form action="${pageContext.request.contextPath}/register" method="post">
                <div class="mb-4">
                    <label for="role" class="form-label">Select Role</label>
                    <select class="form-select" id="role" name="role" onchange="toggleFields()" required>
                        <option value="admin">Admin</option>
                        <option value="user">Student</option>
                    </select>
                </div>

                <div class="mb-4">
                    <label for="username" class="form-label" id="usernameLabel">Username</label>
                    <input type="text" class="form-control" id="username" name="username" required>
                </div>

                <div class="mb-4">
                    <label for="password" class="form-label">Password</label>
                    <input type="password" class="form-control" id="password" name="password" required>
                </div>

                <div id="userFields">
                    <div class="mb-4">
                        <label for="name" class="form-label">Full Name</label>
                        <input type="text" class="form-control" id="name" name="name">
                    </div>
                </div>

                <button type="submit" class="btn btn-register">Register Now</button>
            </form>

            <p class="login-link">
                Already registered? <a href="${pageContext.request.contextPath}/login.jsp">Sign in here</a>
            </p>
        </div>
    </div>
</body>
</html>