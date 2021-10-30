<%@ page import="people.users.client.Client" %>
<%@ page import="address.Address" %>
<%@ page import="controllers.AddressController" %>

<%--
  Created by IntelliJ IDEA.
  User: egor
  Date: 23.10.2021
  Time: 5:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="currentUser" class="people.users.User" scope="session"/>
<jsp:useBean id="currentOrder" class="order.Order" scope="session"/>

<html>
<head>
    <title>Просто Лучшее Такси</title>
</head>
<body>
    <%
        Integer i = 0;
        AddressController addressController = new AddressController();

        while ( currentOrder.getAddressCollection().getCollectionIterator().hasNext() ){
            String address = request.getParameter( i + "Address" );
            if( address != null ){
                addressController.add( new Address ( address) );
            }
            currentOrder.getAddressCollection().getCollectionIterator().next();
        };
        currentOrder.setAddressCollection( addressController.getAddressCollection() );

        String action_ = request.getParameter("action");
        switch( action_ ){
            case "addDestination":
                currentOrder.getAddressCollection().add( new Address() );
                break;
            case "deleteDestination":
                currentOrder.getAddressCollection().delete_back();
                break;
            case "check":
                while ( currentOrder.getAddressCollection().getCollectionIterator().hasNext() ) {
                    if ( currentOrder.getAddressCollection().getCollectionIterator().next() == null ||
                         currentOrder.getAddressCollection().getCollectionIterator().next().toString().equals("") ) {
                        String errorMessage = "Заполните все поля";
                        %>
                        <jsp:include page="../utility/errorFrame.jsp">
                            <jsp:param name="message" value="<%=errorMessage%>"/>
                        </jsp:include>
                        <%
                    } else {
                        %>
                        <jsp:forward page="order.jsp?action=acceptOrder"/>
                        <%
                    }
                }
                break;
            case "acceptOrder":
                String errorMessage = "Заказ сделан";
                %>
                    <jsp:include page="../utility/errorFrame.jsp">
                        <jsp:param name="message" value="<%=errorMessage%>"/>
                    </jsp:include>
                <%
                break;
                //TODO : Доделать принятие заказа ( необходима строка Client temp = (Client) currentUser; - downcast, но оно не работает)
        }

    %>
    <div class="order-content">

        <form action="../order/order.jsp" method="post">
            <table>
                <%
                    if( currentOrder.getAddressCollection().isEmpty() ) {
                        %>
                        <tr>
                            <td>
                                <label>
                                    <input type="text" placeholder="Откуда?">
                                </label>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>
                                    <input type="text" placeholder="Куда?">
                                </label>
                            </td>
                        </tr>
                        <%
                    } else {
                        String firstValue = currentOrder.getAddressCollection().getCollectionIterator().next().toString();
                        %>
                        <tr>
                            <td>
                                <label>
                                    <input type="text" name="Address" placeholder="Откуда?" value=<%=firstValue%>>
                                </label>
                            </td>
                        </tr>
                        <%
                        i = 0;
                        while ( currentOrder.getAddressCollection().getCollectionIterator().hasNext() ) {
                            String value_ = currentOrder.getAddressCollection().getCollectionIterator().next().toString();
                            ++i;
                            String name_ = i + "Address";
                            %>
                            <tr>
                                <td>
                                    <label>
                                        <input type="text" name=<%=name_%>; placeholder="Куда?" value=<%=value_%>>
                                    </label>
                                </td>
                            </tr>
                            <%
                        }
                    }
                %>
                <tr>
                    <td>
                        <input type="hidden" name="action" value="addDestination">
                        <input type="submit" value="Добавить остановку">
                    </td>
                    <td>
                        <input type="hidden" name="action" value="deleteDestination">
                        <input type="submit" value="Удалить остановку">
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="hidden" name="action" value="check">
                        <input type="submit" name="Сделать заказ">
                    </td>
                </tr>
            </table>
        </form>

    </div>

    <div>
        <%
            out.print(currentUser);
        %>
    </div>
</body>
</html>
