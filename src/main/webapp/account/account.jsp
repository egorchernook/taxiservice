
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
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/taxi/beauties/css/style_main.css">
    <title>Просто Лучшее Такси</title>
</head>
<body>
    <%
        String name_ = request.getParameter( "clientName");
        String login_ = request.getParameter( "clientLogin");

        if( name_ != null && !name_.equals( currentClient.getName())){
            currentClient.setName( name_ );
        }
        if( login_ != null && !login_.equals( currentClient.getLogin())){
            currentClient.setLogin( login_ );
        }
    %>
    <div>
        <form action="account.jsp" method="post">
            <table>
                <tr>
                    <td>
                        <p>Имя :</p>
                    </td>
                    <td>
                        <label>
                            <input type="text" name="clientName" value=<%=currentClient.getName()%>>
                        </label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>Логин :</p>
                    </td>
                    <td>
                        <label>
                            <input type="text" name="clientLogin" value=<%=currentClient.getLogin()%>>
                        </label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>Номер телефона :</p>
                    </td>
                    <td>
                        <label>
                            <input type="text" name="clientPhone" value=<%=currentClient.getPhoneNumber()%>; readonly>
                        </label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>Рейтинг :</p>
                    </td>
                    <td>
                        <label>
                            <input type="text" name="clientRate" value=<%=currentClient.getRate()%>; readonly>
                        </label>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Сохранить изменения">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
