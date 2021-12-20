<%--
  Created by IntelliJ IDEA.
  User: egor
  Date: 15.12.2021
  Time: 0:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="currentClient" class="people.users.client.Client" scope="session"/>
<html lang = "en">
<head>
  <meta charset = "UTF-8">
  <link rel="stylesheet" href="/taxi/beauties/css/style_profile.css">
  <link rel="icon" href="/taxi/beauties/icons/logo.svg" type="image/x-icon"/>
  <title> Timmy</title>
</head>
<body>
<header class="header">
  <div class="header__inner">
    <a class="nav" href="/taxi/index.jsp"><div class="logo"></div> Личный кабинет </a>
  </div>
</header>

<hr class="line_h_1" />

<div class="container">
  <div class="body__inner">
    <div class="person">
      <div class="name"><%=currentClient.getName()%></div>
      <span>Рейтинг</span>
      <div class="rating"><p><%=(double) currentClient.getRate()/50%></p></div>
    </div>
    <div class="block_buttons">
      <div class="grey_button"> <a href="/taxi/account/order_history_client.jsp"> История поездок </a></div>
      <div class="grey_button"> <a href="/taxi/account/im_client"> Личные данные </a></div>
      <%--<div class="grey_button"> <a href=""> Доход </a></div>--%>
    </div>
  </div>
</div>
<hr class="line_h_2" />
<footer class="footer">
  <div class="footer__inner">
    <div class="nav_2"> © 2021 ООО «Timmy» </div>
    <nav class="nav_3">
      <a class="nav_link" href=""> Пользовательское соглашение </a>
      <a class="nav_link" href=""> Согласие на обработку данных </a>
    </nav>
  </div>
</footer>
</body>
</html>