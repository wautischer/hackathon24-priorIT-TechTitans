<%--
  Created by IntelliJ IDEA.
  User: laurin
  Date: 28.06.24
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background-color: #333;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            color: white;
        }

        .login-container {
            background: #444;
            padding: 40px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 300px;
            text-align: center;
        }

        .login-container h2 {
            margin-bottom: 20px;
            color: white;
        }

        .input-field {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #888;
            border-radius: 4px;
            box-sizing: border-box;
            background: #555;
            color: white;
        }

        .login-btn {
            width: 100%;
            padding: 10px;
            background-color: #cc0033;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }

        .login-btn:hover {
            background-color: #a30026;
        }

        .forgot-password {
            margin-top: 15px;
            color: #cc0033;
            text-decoration: none;
            display: block;
        }

        .forgot-password:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="login-container">
    <h2>Login</h2>
    <form action="login" method="get">
        <label>
            <input type="text" id="username" name="uname" class="input-field" placeholder="Benutzername" value=""
                   required>
        </label>
        <label>
            <input type="password" id="password" name="pword" class="input-field" placeholder="Password" value=""
                   required>
        </label>
        <button type="submit" class="login-btn">Einloggen</button>
    </form>
</div>
</body>
</html>
