<%--
  Created by IntelliJ IDEA.
  User: egor
  Date: 21.12.2021
  Time: 1:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Аутентификация</title>
    <link rel="stylesheet" href="../css/style_auth_client.css">
    <link rel="icon" href="../icons/logo.svg" type="image/x-icon"/>
</head>
<body>
<div class="card">
    <div class="card-title">
        <a href="/taxi/registration/reg.jsp"><div class="card-title-back"></div></a>
        <a href="/taxi/index.jsp"><div class="card-title-logo"></div></a>
        <div class="card-title-name">Вход</div>
    </div>
    <form action="" method="post">
        <label>
            <span>Номер телефона</span>
            <input type="tel" name="phone_number" placeholder="+7 800 555 35 35" required>
        </label>
        <label>
            <span>Пароль</span>
            <input type="password" name="password" placeholder= ".........." required>
        </label>
        <button class="submit-button" type="submit">Войти</button>
    </form>
    <form action="/taxi/registration/reg.jsp" method="get">
        <button>Зарегистрироваться</button>
    </form>
</div>
</body>
</html>