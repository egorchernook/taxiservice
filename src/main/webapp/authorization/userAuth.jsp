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
<jsp:useBean id="currentUser" class="people.users.User" scope="session"/>

<html>
<head>
    <title><%=TITLE%></title>
</head>
<body>

    <%
        String action_ = request.getParameter("action");

        if( action_.equals("fast") ) {
            String phoneNumber_ = request.getParameter("phoneNumber");
            currentUser = new Client( phoneNumber_ );
            %>
            <jsp:forward page="../order/order.jsp">
            <%
        }
    %>

</body>
</html>
