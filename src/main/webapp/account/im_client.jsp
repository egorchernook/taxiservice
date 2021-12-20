<%--
  Created by IntelliJ IDEA.
  User: egor
  Date: 21.12.2021
  Time: 0:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang = "en">
<head>
    <meta charset = "UTF-8">
    <link rel="stylesheet" href="/taxi/beauties/css/style_im.css">
    <link rel="icon" href="/taxi/beauties/icons/logo.svg" type="image/x-icon"/>
    <title> Timmy</title>
</head>
<body>
<div class="flex-container">
    <header>
        <nav>
            <div class="logo"><a href="/taxi/index.jsp"></a></div>
            <a class="link" href="/taxi/index.jsp"> Личный кабинет </a>
        </nav>
    </header>
    <hr class="line_h_1" />
    <main>
        <aside></aside>
        <section>
            <form class="form-column" action>
                <label class="input-label" for="name">
                    <span class="input-title">Имя</span>
                </label>
                <input class="input" type="text" name="name" id="name" placeholder="Георгий">

                <label class="input-label" for="login">
                    <span class="input-title">Логин</span>
                </label>
                <input class="input" type="text" name="login" id="login" placeholder="Georgiy">

                <label class="input-label" for="phone_number">
                    <span class="input-title">Номер телефона</span>
                </label>
                <input class="input" type="text" name="phone_number" id="phone_number" placeholder="+7 800 555 35 35">

                <label class="input-label" for="password">
                    <span class="input-title">Пароль</span>
                </label>
                <input class="input" type="password" name="password" id="password" placeholder= ".........." required>
                <button class="submit-button" type="submit">Подтвердить</button>
            </form>
        </section>
        <aside></aside>
    </main>
    <footer class="">Footer</footer>
</div>
</body>
</html>
