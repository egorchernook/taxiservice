<%@ page import="people.users.client.Client" %>

<%--
  Created by IntelliJ IDEA.
  User: egor
  Date: 23.10.2021
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="clientsList" class="controllers.ClientController" scope="application"/>
<jsp:useBean id="currentClient" class="people.users.client.Client" scope="session"/>

<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../beauties/css/style_main.css">
    <title>Просто Лучшее Такси</title>
</head>
<body>

    <%
        String action_ = request.getParameter("action");

        // it seems like switch statement only works normally ( with equals() ) with java 7 or bigger
        switch( action_ ) {
            case "fast":
                String phoneNumber_ = request.getParameter("phoneNumber");
                currentClient.copy( new Client( phoneNumber_ ) );
                %>
                <jsp:forward page="../index.jsp"/>
                <%
                break;
            case "default":
                String login_ = request.getParameter("login");
                Integer password_ = request.getParameter("password").hashCode();

                String userType_ = request.getParameter("userType");
                if( userType_ != null ){
                    switch ( userType_) {
                        case "client" :
                            if ( clientsList.find(login_) != null ) {
                                if( password_.equals( clientsList.find(login_).getPassword() ) ) {
                                    currentClient.copy( clientsList.find(login_) );
                                    %>
                                    <jsp:forward page="../index.jsp"/>
                                    <%
                                }
                            } else {
                                %>
                                <jsp:forward page="../beauties/img/oks.jpg"/>
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
                }
                break;
        }
    %>

</body>
</html>
