<%--
  Created by IntelliJ IDEA.
  User: egor
  Date: 23.10.2021
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Просто Лучшее Такси</title>
</head>
<body>
    <%
        /*
        String errorMessage = request.getParameter("error");
        */
        %>
        <%--
        <jsp:include page="../utility/errorFrame.jsp">
            <jsp:param name="message" value="<%=errorMessage%>"/>
        </jsp:include>
        --%>
        <%
        String userType_ = request.getParameter("userType");
        String placeholder_ = "";
        String pattern_ = "";
        String labelText = "";
        switch (userType_) {
            case "client":
                placeholder_ = "Номер телефона";
                pattern_ = "[0-9]{10}";
                labelText = "Например: 950 123 12 12";
                break;
            case "driver":
                placeholder_ = "Логин";
                pattern_ = "[A-Za-z]{3,20}";
                labelText = "Ваш логин при регистрации";
                break;
            case "operator":
                placeholder_ = "Табельный номер";
                pattern_ = "[0-9]{6}";
                labelText = "Ваш табельный номер";
                break;
        }
        // it seems like switch statement only works normally ( with equals() ) with java 7 or bigger
    %>
    <div class="loginField">
        <form action="userAuth.jsp" method="post">
            <input type="hidden" name="action" value="default">
             <table>
                 <tr>
                     <td>
                         <input type="hidden" name="userType" value=<%=userType_%>>
                         <label>
                             <input type="text" name="login" placeholder=<%=placeholder_%> pattern=<%=pattern_%> required/>
                             <span> <%=labelText%> </span>
                         </label>
                     </td>
                 </tr>
                 <tr>
                     <td>
                         <label>
                             <input type="password" name="password" placeholder="Пароль" required>
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
    </div>
</body>
</html>
