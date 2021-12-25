<%@ page import="DataBase.ConnectionException" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: egor
  Date: 21.12.2021
  Time: 0:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="currentClient" class="people.users.client.Client" scope="session"/>
<jsp:useBean id="ClientService" class="controllers.ClientController" scope="application"/>
<jsp:useBean id="DataBase" class="DataBase.ConnectDB" scope="application"/>
<html lang = "en">
<head>
    <meta charset = "UTF-8">
    <link rel="stylesheet" href="/taxi/beauties/css/style_im.css">
    <link rel="icon" href="/taxi/beauties/icons/logo.svg" type="image/x-icon"/>
    <title> Timmy</title>
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
%>
<div class="flex-container">
    <header>
        <nav>
            <div class="logo"><a href="/taxi/index.jsp"></a></div>
            <a class="link" href="/taxi/index.jsp"> Личный кабинет </a>
        </nav>
    </header>
    <hr class="line_h_1" />
    <main>
        <aside></aside>
        <section>
            <%
                if( currentClient.getId().equals(-1L)){
                    %>
                    <jsp:forward page="../authorization/auth_client.jsp"/>
                    <%
                }

                long ts = (new Date()).getTime();

                String name = request.getParameter("name");
                String login = request.getParameter("login");
                String phone_number = request.getParameter("phone_number");
                String password = request.getParameter("password");

                if( password != null ){
                    Integer password_ = password.hashCode();
                    if( password_.equals(currentClient.getPassword())) {
                        if (name != null && !name.equals(currentClient.getName())) {
                            currentClient.setName(name);
                        }
                        if (login != null && !login.equals(currentClient.getLogin())) {
                            currentClient.setLogin(login);
                        }
                        if (phone_number != null && !phone_number.equals(currentClient.getPhoneNumber())) {
                            currentClient.setPhoneNumber(phone_number);
                        }

                        try {
                            ClientService.saveToDB(DataBase, currentClient, true);
                        } catch (ConnectionException e) {
                            System.err.println(e.getMessage());
                            e.printStackTrace();
                        }
                    }
                }
            %>
            <form class="form-column" action="/taxi/account/im_client.jsp" method="post">
                <label class="input-label" for="name">
                    <span class="input-title">Имя</span>
                </label>

                <input type="hidden" name="lol" value=<%=ts%>>
                <p>
                    <%System.err.println(currentClient);%>
                </p>
                <input class="input" type="text" name="name" id="name" value="<%=currentClient.getName()%>">

                <label class="input-label" for="login">
                    <span class="input-title">Логин</span>
                </label>
                <input class="input" type="text" name="login" id="login" value="<%=currentClient.getLogin()%>">

                <label class="input-label" for="phone_number">
                    <span class="input-title">Номер телефона</span>
                </label>
                <input class="input" type="tel" name="phone_number" id="phone_number" value="<%=currentClient.getPhoneNumber()%>">

                <label class="input-label" for="password">
                    <span class="input-title">Пароль</span>
                </label>
                <input class="input" type="password" name="password" id="password" placeholder= ".........." required>
                <button class="submit-button" type="submit">Подтвердить</button>
            </form>
        </section>
        <aside></aside>
    </main>
    <footer class="">Footer</footer>
</div>
</body>
</html>
