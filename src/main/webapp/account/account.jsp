
<%--
  Created by IntelliJ IDEA.
  User: egor
  Date: 06.11.2021
  Time: 1:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="currentClient" class="people.users.client.Client" scope="session"/>

<html>
<head>
    <title>Просто Лучшее Такси</title>
</head>
<body>
    <div class="lk">
        <table>
            <tr>
                <td>
                    <p>Имя :</p>
                </td>
                <td>
                    <p><%=currentClient.getName()%></p>
                </td>
            </tr>
            <tr>
                <td>
                    <p>Логин :</p>
                </td>
                <td>
                    <p><%=currentClient.getLogin()%></p>
                </td>
            </tr>
            <tr>
                <td>
                    <p>Номер телефона :</p>
                </td>
                <td>
                    <p><%=currentClient.getPhoneNumber()%></p>
                </td>
            </tr>
            <tr>
                <td>
                    <p>Рейтинг :</p>
                </td>
                <td>
                    <p><%=currentClient.getRate()%></p>
                </td>
            </tr>
        </table>
    </div>
</body>
</html>
