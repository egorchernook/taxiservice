<%@ page import="java.util.Date" %><%--

  Created by IntelliJ IDEA.
  User: chernookegor
  Date: 02.10.2021
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="tempOrder" class="controllers.OrderController" scope="session" />
<jsp:useBean id="currentPerson" class="people.Person" scope="session">
</jsp:useBean>

<html>
<head>
    <title>Просто Лучшее Такси</title>
</head>

<body bgcolor="#fffff0">

    <div class="content">

        <%--
        <div class="phoneField">
            <form name="clientPhone" action="" method="get">
                <input type="text" placeholder="Введите номер">
            </form>
        </div>
        --%>
        <div class="addressesField">
            <div class="address">
                <table>
                    <tr>
                        <form name="addressField" method="get">
                            <td>
                                <input type="text" id="startAddress" placeholder="Откуда?" required>
                            </td>
                            <td>
                                <input type="submit" value="Отправить">
                            </td>
                        </form>
                    </tr>
                </table>
            </div>
            <div class="address">
                <table>
                    <tr>
                        <form name="addressField" method="get">
                            <td>
                                <input type="text" id="finishAddress" placeholder="Куда?" required>
                            </td>
                            <td>
                                <input type="submit" value="Отправить">
                            </td>
                        </form>
                    </tr>
                </table>
            </div>
        </div>
    </div>
    <div>
        <p>
            <%
                out.println(currentPerson.toString());
            %>
        </p>
    </div>
    <div>
        <p>
            <%
                out.println( new Date() );
            %>
        </p>
    </div>
</body>

</html>
