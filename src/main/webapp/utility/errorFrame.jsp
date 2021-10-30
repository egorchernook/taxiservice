<%--
  Created by IntelliJ IDEA.
  User: egor
  Date: 23.10.2021
  Time: 14:51
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
        String message_ = request.getParameter("message");
        String url = "../utility/error.jsp?message=" + message_;
        if ( message_ != null ) {
            %>
            <iframe src=<%=url%>; width="468" height="60" align="centre">
                <%=message_%>
            </iframe>
            <%
        }
    %>
</body>
</html>
