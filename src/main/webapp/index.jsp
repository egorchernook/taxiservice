
<%--
  Created by IntelliJ IDEA.
  User: chernookegor
  Date: 02.10.2021
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="currentUser" class="people.users.User" scope="session"/>

<html>
<head>
    <title>Просто Лучшее Такси</title>
</head>

<body>

    <div class="entrance">

        <form action="authorization/userAuth.jsp" method="post">
            <table>
                <tr>
                    <td>
                        <input type="hidden" name="action" value="fast">
                        <label>
                            <input type="text" name="phoneNumber" placeholder="(XXX)-XXX-XXXX" pattern="[0-9]{10}" required>
                        </label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="Войти"/>
                    </td>
                </tr>
            </table>
        </form>
        <p>----------------ИЛИ---------------</p>
        <form action="authorization/auth.jsp" method="post">
            <input type="hidden" name="userType" value="client">
            <input type="submit" value="Авторизоваться"/>
        </form>

    </div>

</body>

</html>
