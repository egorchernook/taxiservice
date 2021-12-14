<%@ page import="java.util.Iterator" %>
<%@ page import="address.Address" %>
<%@ page import="address.AddressCollection" %><%--
  Created by IntelliJ IDEA.
  User: egor
  Date: 13.11.2021
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="ClientService" class="controllers.ClientController" scope="application"/>
<jsp:useBean id="DataBase" class="DataBase.ConnectDB" scope="application"/>
<jsp:useBean id="currentClient" class="people.users.client.Client" scope="session"/>
<jsp:useBean id="currentOrder" class="order.Order" scope="session"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang = "en">
<head>
    <meta charset = "UTF-8">
    <link rel="stylesheet" type="text/css" href="/taxi/beauties/css/style.css">
    <link rel="icon" href="/taxi/beauties/icons/logo.svg" type="image/x-icon"/>
    <title> Timmy</title>

    <link rel="stylesheet" href="https://unpkg.com/leaflet@1.7.1/dist/leaflet.css"
          integrity="sha512-xodZBNTC5n17Xt2atTPuE1HxjVMSvLVW9ocqUKLsCC5CXdbqCmblAshOMAS6/keqq/sMZMZ19scR4PsZChSR7A=="
          crossorigin=""/>

    <script src="https://unpkg.com/leaflet@1.7.1/dist/leaflet.js"
            integrity="sha512-XQoYMqMTK8LvdxXYG3nZ448hOEQiglfqkJs1NOQV44cWnUrBc8PkAOcXy20w0vlaXaVUearIOBhiXZ5V3ynxwA=="
            crossorigin=""></script>

</head>
<body>

<header class="header">
    <div class="header_inner">
        <div class="logo"><a href="/taxi/beauties/html/auth_client.html"></a></div>
        <nav class="nav">
            <a class="nav_link" href="/taxi/beauties/img/oks.jpg"> Пользователям </a>
            <a class="nav_link" href="/taxi/beauties/img/oks.jpg"> Водителям </a>
        </nav>
        <nav class="nav">
            <%
                if( currentClient.getId() == -1 ){
                    %>
                    <a class="nav_link" href="/taxi/beauties/html/auth_client.html"> <div class="login"></div> Войти </a>
                    <a class="reg" href="/taxi/beauties/html/reg.html"> Зарегистрироваться </a>
                    <%
                } else {
                    %>
                    <a class="nav_link" href="/taxi/account/profile.jsp"> <div class="profile"></div> Личный кабинет </a>
                    <%
                }
            %>
        </nav>
    </div>
</header>

    <hr class="line_h_1" />
    <div class="container">
        <div class="body__inner">
            <div class="block_buttons">
                <form id="route" action="/taxi/index.jsp" method="post">
                    <%

                        if(currentOrder.getAddressCollection() == null){
                            AddressCollection temp = new AddressCollection();
                            temp.add( new Address("") );
                            temp.add( new Address("") );
                            %>
                            <div class="grey__button"> <i class="circle"></i>
                                <label>
                                    <input type="text" name="landing_address" placeholder= "Укажите место посадки" autocomplete="on" required>
                                </label>
                            </div>
                            <%--
                            <div class="grey__button"> <i class="circle"></i>
                                <label>
                                    <input type="text" name="address_1" placeholder="Первая остановка" autocomplete="on" >
                                </label>
                            </div>
                            <div class="grey__button"> <i class="circle"></i>
                                <label>
                                    <input type="text" name="address_2" placeholder="Вторая остановка" autocomplete="on" >
                                </label>
                            </div>
                            --%>
                            <div class="grey__button"> <i class="circle"></i>
                                <label>
                                    <input type="text" name="destination_address" placeholder="Укажите пункт назначения" autocomplete="on" required>
                                </label>
                            </div>
                            <%
                        }
                        switch ( currentOrder.getAddressCollection().size() ){
                            case 2:
                                String landing_address_ = request.getParameter("landing_address");
                                String destination_address_ = request.getParameter("destination_address");
                                AddressCollection newAddressCollection = new AddressCollection();

                                Iterator<Address> iter = currentOrder.getAddressCollection().getCollectionIterator();
                                String fst = "";
                                String snd = "";
                                if( landing_address_ != null ) {
                                    newAddressCollection.add( new Address(landing_address_));
                                    fst = landing_address_;
                                } else {
                                    fst = iter.next().toString();
                                    newAddressCollection.add( new Address(fst));
                                }
                                if( destination_address_ != null ) {
                                    newAddressCollection.add( new Address(destination_address_));
                                    snd = destination_address_;
                                } else {
                                    snd = iter.next().toString();
                                    newAddressCollection.add( new Address(snd));
                                }

                                if ( fst.equals("") ) {
                                    %>
                                    <div class="grey__button"> <i class="circle"></i>
                                        <label>
                                            <input type="text" name="landing_address" placeholder= "Укажите место посадки" autocomplete="on" required>
                                        </label>
                                    </div>
                                    <%
                                } else {
                                    %>
                                    <div class="grey__button"> <i class="circle"></i>
                                        <label>
                                            <input type="text" name="landing_address" placeholder= "Укажите место посадки" autocomplete="on" value=<%=fst%> required>
                                        </label>
                                    </div>
                                    <%
                                }

                                if ( snd.equals("") ){
                                    %>
                                    <div class="grey__button"> <i class="circle"></i>
                                        <label>
                                            <input type="text" name="destination_address" placeholder="Укажите пункт назначения" autocomplete="on" required>
                                        </label>
                                    </div>
                                    <%
                                } else {
                                    %>
                                    <div class="grey__button"> <i class="circle"></i>
                                        <label>
                                            <input type="text" name="landing_address" placeholder="Укажите пункт назначения" autocomplete="on" value=<%=snd%> required>
                                        </label>
                                    </div>
                                    <%
                                }
                                currentOrder.setAddressCollection( newAddressCollection);

                            case 3:

                            case 4:
                            default:
                                %>
                                <div class="grey__button"> <i class="circle"></i>
                                    <label>
                                        <input type="text" name="landing_address" placeholder= "Укажите место посадки" autocomplete="on" required>
                                    </label>
                                </div>
                                <div class="grey__button"> <i class="circle"></i>
                                    <label>
                                        <input type="text" name="destination_address" placeholder="Укажите пункт назначения" autocomplete="on" required>
                                    </label>
                                </div>
                                <%
                        }
                    %>
                </form>

                <div class="block_buttons">
                    <button name="add_button" value="pressed" class="plus-button"> <i class="plus"></i> Добавить остановку </button>
                    <button name="remove_button" value="pressed" class="plus-button"> <i class="cross"></i> Убрать остановку </button>
                </div>
                <button class="submit-button" type="submit" form="route"> Заказать сейчас </button>
                <form id="pending order" action="" method="get"> <button> Запланировать заранее</button> </form>
            </div>
            <div class="map" id="map">
            </div>

            <script>
                var map = L.map('map').setView([54.58, 73.23], 13);
                L.tileLayer('https://api.mapbox.com/styles/v1/{id}/tiles/{z}/{x}/{y}?access_token={accessToken}', {
                    attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
                    maxZoom: 18,
                    id: 'mapbox/streets-v11',
                    tileSize: 512,
                    zoomOffset: -1,
                    accessToken: 'your.mapbox.access.token'
                }).addTo(map);
            </script>

        </div>
    </div>

    <hr class="line_h_2" />

    <footer class="footer">
        <div class="footer__inner">
            <div class="nav_2"> © 2021 ООО «Timmy» </div>
            <nav class="nav_3">
                <a class="nav_link" href="/taxi/beauties/img/oks.jpg"> Пользовательское соглашение </a>
                <a class="nav_link" href="/taxi/beauties/img/oks.jpg"> Согласие на обработку данных </a>
            </nav>
        </div>

    </footer>
</body>
</html>
