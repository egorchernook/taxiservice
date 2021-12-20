<%--
  Created by IntelliJ IDEA.
  User: egor
  Date: 21.12.2021
  Time: 0:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Регистрация</title>
    <link rel="stylesheet" href="/taxi/beauties/css/style_reg.css">
    <link rel="icon" href="/taxi/beauties/icons/logo.svg" type="image/x-icon"/>
</head>
<body>
<div class="card">
    <div class="card-title">
        <a href="/taxi/index.jsp"><div class="card-title-logo"></div></a>
        <div class="card-title-name">Регистрация</div>
    </div>
    <form action="/taxi/registration/confirmation.jsp" method="post">
        <label>
            <span>Имя</span>
            <input type="text" name="name" placeholder="Как вас зовут?" required>
        </label>
        <label>
            <span>Номер телефона</span>
            <input type="tel" name="phone_number" placeholder="+7 800 555 35 35" required>
        </label>
        <label>
            <span>Пароль</span>
            <input type="password" name="password" placeholder= ".........." required>
        </label>
        <button class="submit-button" type="submit">Зарегистрироваться</button>
    </form>
    <div class="agreement">Нажимая «Зарегистрироваться», вы соглашаетесь с <a href="">Условиями использования Timmy</a> и подтверждаете прочтение <a href="">Политики конфиденциальности</a>.</div>
</div>
</body>
</html>