<%--
  Created by IntelliJ IDEA.
  User: egor
  Date: 23.10.2021
  Time: 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="TITLE" class="java.lang.String" scope="application"/>

<html>
<head>
    <title><%=TITLE%></title>
</head>
<body>
    <%
        String message = request.getParameter("message");
    %>
    <p><%=message%></p>
</body>
</html>
