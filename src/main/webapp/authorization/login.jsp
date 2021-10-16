<%@ page import="people.users.User" %><%--
  Created by IntelliJ IDEA.
  User: egor
  Date: 16.10.2021
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="currentPerson" class="people.Person" scope="session"/>
<jsp:useBean id="userController" class="controllers.UserController" scope="application">

<html>
<head>
    <title>login page</title>
</head>
<body>

    <%
        Long id = null;
        User user = null;
        String id_ = request.getParameter("id");

        try {

            id = Long.parseLong(id_);

            if (id == -1){
                user = new User();
    %>
                <form action="userController.jsp" method="post" >
                    <input type="hidden" name="action" value="edit"/>
                    <input type="hidden" name="id" value="-1"/>
                    Имя: <input type="text" name="name" value=""/> <br>
                    Логин: <input type="text" name="login" value=""/> <br>
                    Пароль: <input type="text" name="pwd" value=""/> <br>
                    <input type="submit" value="Save"/>
                </form>
    <%
            } else {
                user = userController.find(id_);
    %>
                <form action="userController.jsp" method="post">
                    <input type="hidden" name="action" value="edit"/>
                    <input type="hidden" name="id" value="<%= id %>">
                    Имя: <input type="text" name="name" value="<%=user.getName()%>"/> <br>
                    Логин: <input type="text" name="login" value="<%=user.getLogin()%>"/> <br>
                    Пароль: <input type="text" name="pwd" value=""/> <br>
                    <input type="submit" value="Save"/>
                </form>
    <%
            }
        } catch (NumberFormatException e){
            out.println("Cannot resolve the expression" + e.getMessage());
        }
    %>

</body>
</html>
