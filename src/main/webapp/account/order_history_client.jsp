<%--
  Created by IntelliJ IDEA.
  User: egor
  Date: 21.12.2021
  Time: 0:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang = "en">
<head>
    <meta charset = "UTF-8">
    <meta name="viewport" content="width=1000, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link rel="stylesheet" href="/taxi/beauties/css/style_order_history_client.css">
    <link rel="icon" href="/taxi/beauties/icons/logo.svg" type="image/x-icon"/>
    <title> Timmy</title>
</head>
<body>
<div class="flex-container">
    <header>
        <nav>
            <div class="title-back"><a href="/taxi/registration/reg.jsp"></a></div>
            <div class="logo"><a href="/taxi/index.jsp"></a></div>
            <a class="link" href="/taxi/index.jsp"> История поездок </a>
        </nav>
    </header>
    <hr class="line_h_1" />
    <main>
        <aside></aside>
        <section>
            <div class="column">
                <div class="card">
                    <div class="block_inf">
                        <div class="price"><span>350</span> ₽, <span>комфорт</span></div>
                        <div class="date"><span>30</span> <span>ноября</span>, <span>вторник</span></div>
                        <div class="date"><span>11:30</span> - <span>11:50</span></div>
                        <div class="place"><div class="circle"></div><span>Место посадки</span></div>
                        <div class="place"><div class="circle"></div><span>Первая остановка</span></div>
                        <div class="place"><div class="circle"></div><span>Вторая остановка</span></div>
                        <div class="place"><div class="circle"></div><span>Пункт назначения</span></div>
                    </div>
                    <div class="map"></div>
                </div>
            </div>

        </section>
        <aside></aside>
    </main>
    <footer class="">Footer</footer>
</div>
</body>
</html>