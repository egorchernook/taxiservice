<%@ page import="people.users.client.Client" %><%--
  Created by IntelliJ IDEA.
  User: egor
  Date: 13.11.2021
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="currentClient" class="people.users.client.Client" scope="session"/>
<jsp:useBean id="ClientService" class="controllers.ClientController" scope="application"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Подтверждение номера</title>
    <link rel="stylesheet" href="/taxi/beauties/css/style_confirmation.css">
    <link rel="icon" href="/taxi/beauties/icons/logo.svg" type="image/x-icon"/>
</head>
<body>
<%
    String code = request.getParameter("code");
    if( code != null ){
        if( code.equals("0000") ){
            currentClient.setId(0L);
            %>
            <jsp:forward page="../index.jsp"/>
            <%
        }
    }

    String phone_number = request.getParameter("phone_number");
    if(phone_number != null){
        Client temp = ClientService.find(phone_number);
        if( temp != null ){
            %>
            <jsp:forward page="../beauties/html/auth_client.html"/>
            <%
        }
    }

    String name = request.getParameter("name");
    if( name != null){
        currentClient.setName( name);
    }
    String password = request.getParameter("password");
    if( password != null){
        currentClient.setPassword( password.hashCode() );
    }
%>
<div class="card">
    <div class="card-title">
        <a href="/taxi/beauties/html/reg.html"><div class="card-title-back"></div></a>
        <a href="/taxi/index.jsp"><div class="card-title-logo"></div></a>

        <div class="card-title-name">Регистрация</div>
    </div>

    <%

        if( phone_number != null ){
            currentClient.setPhoneNumber("phone_number");
            currentClient.setLogin("phone_number");
        } else {
            phone_number = currentClient.getPhoneNumber();
        }
        String tel = phone_number.substring(0,2) + " "
                   + phone_number.substring(2,5) + " "
                   + phone_number.substring(5,8) + " "
                   + phone_number.substring(8,10) + " "
                   + phone_number.substring(10);
    %>

    <div class="number_confirm">Подтвердите номер: <%=tel%>> </div>
    <form action="/taxi/registration/confirmation.jsp" method="post">
        <label>
            <span>Вам отправлено SMS с кодом для подтверждения</span>
            <input type="password" name="code" placeholder= "....." required>
        </label>
        <button class="submit-button" type="submit">Отправить</button>
    </form>
    <div class="agreement"></div>
</div>
</body>
</html>
