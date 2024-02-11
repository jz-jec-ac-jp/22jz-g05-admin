<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <link rel="stylesheet" href="assets/css/style.css">
    <title>ログイン画面</title>
</head>

<body class="login-admin">
    <div class="login-container">
        <h2 class="login-title">管理者ログイン</h2>
        <div class="login-form">
          <form action="Login" method="post">
           <% if (request.getAttribute("msg") != null) { %>
            <p style="color: red;"><%= request.getAttribute("msg") %></p>
        <% } %>
                <div class="form-group">
                    <label for="username">管理者ID:</label>
                    <input type="text" id="username" name="username" required>
                </div>
                <div class="form-group">
                    <label for="password">パスワード:</label>
                    <input type="password" id="password" name="password" required>
                </div>
                <div class="form-group">
                    <button type="submit">ログイン</button>
                </div>
            </form>
        </div>
    </div>
</body>

</html>
