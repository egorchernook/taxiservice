<%@ page import="java.util.Iterator" %>
<%@ page import="address.Address" %>
<%@ page import="address.AddressCollection" %>
<%@ page import="DataBase.ConnectionException" %>
<%@ page import="java.util.GregorianCalendar" %>
<%@ page import="org.graalvm.compiler.core.common.type.ArithmeticOpTable" %>
<%--
  Created by IntelliJ IDEA.
  User: sharoglazovgeorge
  Date: 25.12.2021
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="ClientService" class="controllers.ClientController" scope="application"/>
<jsp:useBean id="DataBase" class="DataBase.ConnectDB" scope="application"/>
<jsp:useBean id="currentClient" class="people.users.client.Client" scope="session"/>
<jsp:useBean id="currentOrder" class="order.Order" scope="session"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset = "UTF-8">
    <link rel="stylesheet" type="text/css" href="/taxi/beauties/css/style.css">
    <link rel="icon" href="/taxi/beauties/icons/logo.svg" type="image/x-icon"/>
    <meta name="viewport" content="width=1000, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link rel="stylesheet" href="/taxi/beauties/css/style_order_history_client.css">
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
<%
    request.setCharacterEncoding("UTF-8");
%>
<div class="flex-container">
    <header>
        <nav>
            <div class="title-back"><a href="/taxi/registration/reg.jsp"></a></div>
            <div class="logo"><a href="/taxi/index.jsp"></a></div>
            <a class="link" href="/taxi/index.jsp"> Покатаемся?))0) </a>
        </nav>
    </header>
    <hr class="line_h_1" />
    <main>
        <aside></aside>
        <section>
            <div class="column">
                <div class="card">
                    <div class="block_inf">
                        <%
                            Iterator<Address> iter = currentOrder.getAddressCollection().getCollectionIterator();
                            String fst = iter.next().getName();
                            String fth = iter.next().getName();
                            String snd = "";
                            if(iter.hasNext()){
                                snd = iter.next().getName();
                            }
                            String thd = "";
                            if(iter.hasNext()) {
                                thd = iter.next().getName();
                            }
                        %>
                        <div class="price"><span><%=currentOrder.getPrice()%></span> ₽, <span>комфорт</span></div>
                        <div class="date"><%=currentOrder.getOrderDate()%></div>
                        <div class="date"><%=new Integer(currentOrder.getOrderDate().getHours()).toString() + ":" + new Integer(currentOrder.getOrderDate().getMinutes()).toString()%></div>
                        <div class="place"><div class="circle"></div><span><%=fst%></span></div>
                        <div class="place"><div class="circle"></div><span><%=snd%></span></div>
                        <div class="place"><div class="circle"></div><span><%=thd%></span></div>
                        <div class="place"><div class="circle"></div><span><%=fth%></span></div>
                    </div>
                    <div class="map" id="map"></div>

                </div>
            </div>

        </section>
        <aside></aside>
    </main>
    <footer class=""></footer>
</div>

    <script>
        const map = new L.map('map').setView([54.9824, 73.3680], 13);

        L.tileLayer('https://api.mapbox.com/styles/v1/{id}/tiles/{z}/{x}/{y}?access_token={accessToken}', {
            attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
            maxZoom: 18,
            id: 'egorchernook/ckx979xds03x514nnjt3jcugt',
            tileSize: 512,
            zoomOffset: -1,
            accessToken: 'pk.eyJ1IjoiZWdvcmNoZXJub29rIiwiYSI6ImNreDd3bm5uYjJ0aTgycXB6a29mbDN1N2IifQ.JjQ7VA90Qzj1U9euUNqLzQ'
        }).addTo(map);
    </script>


</body>
</html>
