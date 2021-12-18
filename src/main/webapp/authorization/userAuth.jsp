<%@ page import="people.users.client.Client" %>

<%--
  Created by IntelliJ IDEA.
  User: egor
  Date: 23.10.2021
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="ClientService" class="controllers.ClientController" scope="application"/>
<jsp:useBean id="currentClient" class="people.users.client.Client" scope="session"/>

<html>
<head>
    <meta charset = "UTF-8">
    <link rel="stylesheet" type="text/css" href="/taxi/beauties/css/style.css">
    <link rel="icon" href="/taxi/beauties/icons/Timmy_logo_color.png" type="image/x-icon"/>
    <title> Timmy</title>
</head>
<body>
    <%
        String phone_number = request.getParameter("phone_number");
        Integer password_ = request.getParameter("password").hashCode();

        String userType_ = request.getParameter("userType");
        if( userType_ != null ){
            switch ( userType_) {
                case "client" :
                    if ( ClientService.find(phone_number) != null ) {
                        if(password_.equals(ClientService.find(phone_number).getPassword())) {
                            currentClient.copy( ClientService.find(phone_number) );
                            %>
                                <jsp:forward page="../index.jsp"/>
                            <%
                        }
                    } else {
                        %>
                            <jsp:forward page="../index.jsp"/>
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
        } else {
            %>
                <jsp:forward page="../index.jsp"/>
            <%
        }
    %>

</body>
</html>
