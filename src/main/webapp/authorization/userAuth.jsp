<%@ page import="people.users.client.Client" %>

<%--
  Created by IntelliJ IDEA.
  User: egor
  Date: 23.10.2021
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="TITLE" class="java.lang.String" scope="application"/>
<jsp:useBean id="clientsList" class="controllers.ClientController" scope="application"/>
<jsp:useBean id="currentUser" class="people.users.User" scope="session"/>

<html>
<head>
    <title><%=TITLE%></title>
</head>
<body>

    <%
        String action_ = request.getParameter("action");

        // it seems like switch statement only works normally ( with equals() ) with java 7 or bigger
        switch( action_ ) {
            case "fast":
                String phoneNumber_ = request.getParameter("phoneNumber");
                currentUser = new Client( phoneNumber_ );
                %>
                <jsp:forward page="../order/order.jsp"/>
                <%
                break;
            case "default":
                String login_ = request.getParameter("login");
                Integer password_ = request.getParameter("password").hashCode();

                String userType_ = request.getParameter("userType");
                switch ( userType_) {
                    case "client" :
                        if ( clientsList.find(login_) != null ) {
                            currentUser = clientsList.find(login_);
                            %>
                            <jsp:forward page="../order/order.jsp"/>
                            <%
                        } else {
                            %>
                            <jsp:forward page="auth.jsp?error=Такого пользователя нет"/>
                            <%
                        }
                        break;
                    case "driver" :
                        //TODO : Сделать авторизацию и перенаправление зашедшего водителя
                        break;
                    case "operator" :
                        //TODO : Сделать авторизацию и перенаправление зашедшего оператора
                        break;
                }

                //TODO : Сделать проверку логина и пароля

                break;
        }
    %>

</body>
</html>
