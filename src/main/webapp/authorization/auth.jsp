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
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Аутентификация</title>
    <link rel="stylesheet" href="../beauties/css/style_auth.css">
    <link rel="icon" href="../beauties/icons/Timmy_logo_color.png" type="image/x-icon"/>
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
    <div class="card">
        <form autocomplete="on" action="userAuth.jsp" method="post">
            <input type="hidden" name="action" value="default">
            <div class="card-title">
                <img src="../beauties/icons/Timmy_logo_color.png" alt="Logo">
            </div>
            <input type="hidden" name="userType" value=<%=userType_%>>
            <label>
                <span>Номер телефона</span>
                <input type="text" name="login" placeholder=<%=placeholder_%> pattern=<%=pattern_%> required/>
                <span> <%=labelText%> </span>
            </label>

            <label>
                <span>Пароль</span>
                <input type="password" name="password" placeholder=".........." required>
            </label>

            <button class="submit-button" type="submit">Войти</button>
        </form>

        <form action="../beauties/img/oks.jpg" method="get">
            <button>Зарегистрироваться</button>
        </form>
    </div>
</body>
</html>
