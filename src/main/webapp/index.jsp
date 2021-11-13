<%--
  Created by IntelliJ IDEA.
  User: egor
  Date: 13.11.2021
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset = "UTF-8">
    <link rel="stylesheet" href="beauties/css/style.css">
    <link rel="icon" href="beauties/icons/Timmy_logo_color.png" type="image/x-icon"/>
    <title> Timmy</title>
</head>
<body>
<header class="header">
    <div class="header_inner">
        <div class="logo"><a href="beauties/html/clientAuth.html"></a></div>
        <nav class="nav">
            <a class="nav_link" href="beauties/img/oks.jpg"> Пользователям </a>
            <a class="nav_link" href="beauties/img/oks.jpg"> Водителям </a>
        </nav>
        <nav class="nav">
            <a class="nav_link" href="beauties/html/clientAuth.html">
                <img src="beauties/icons/Login%20Icon.png" alt="logo">
                Войти
            </a>
            <a class="reg" href="beauties/html/reg.html">
                Зарегестрироваться
            </a>
        </nav>
    </div>
</header>

<hr class="line_h_1" />
<div class="container">
    <div class="body__inner">
        <div class="block_buttons">
            <form id="route" action="" method="post">
                <div class="grey__button"> <i class="circle"></i>
                    <label>
                        <input type="text" name="landing_address" placeholder= "Укажите место посадки" autocomplete="on" required>
                    </label>
                </div>
                <div class="grey__button"> <i class="circle"></i>
                    <label>
                        <input type="text" name="address_1" placeholder="Первая остановка" autocomplete="on" >
                    </label>
                </div>
                <div class="grey__button"> <i class="circle"></i>
                    <label>
                        <input type="text" name="address_2" placeholder="Вторая остановка" autocomplete="on" >
                    </label>
                </div>
                <div class="grey__button"> <i class="circle"></i>
                    <label>
                        <input type="text" name="destination_address" placeholder="Укажите пункт назначения" autocomplete="on" required>
                    </label>
                </div>
            </form>

            <div class="block_buttons">
                <button class="plus-button"> <i class="plus"></i> Добавить остановку </button>
                <button class="plus-button"> <i class="cross"></i> Убрать остановку </button>
            </div>
            <button class="submit-button" type="submit" form="route"> Заказать сейчас </button>
            <form id="pending order" action="" method="get"> <button> Запланировать заранее</button> </form>
        </div>
        <div class="map"> </div>
    </div>
</div>

<hr class="line_h_2" />

<footer class="footer">
    <div class="footer__inner">
        <div class="nav_2"> © 2021 ООО «Timmy» </div>
        <nav class="nav_3">
            <a class="nav_link" href="beauties/img/oks.jpg"> Пользовательское соглашение </a>
            <a class="nav_link" href="beauties/img/oks.jpg"> Согласие на обработку данных </a>
        </nav>
    </div>

</footer>
</body>
</html>
