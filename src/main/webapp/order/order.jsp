<%@ page import="people.users.client.Client" %>
<%@ page import="address.Address" %>
<%@ page import="controllers.AddressController" %>
<%@ page import="static java.lang.Integer.*" %>
<%@ page import="address.AddressCollection" %>

<%--
  Created by IntelliJ IDEA.
  User: egor
  Date: 23.10.2021
  Time: 5:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="currentClient" class="people.users.client.Client" scope="session"/>
<jsp:useBean id="currentOrder" class="order.Order" scope="session"/>

<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../beauties/css/style_main.css">
    <title>Просто Лучшее Такси</title>
</head>
<body>
    <%
        int i = 0;
        AddressController addressController = new AddressController();

        if( currentOrder.getAddressCollection().isEmpty() ){
            while( i < 2) {
                addressController.add( new Address(""));
                ++i;
            }
        } else {
            while ( currentOrder.getAddressCollection().getCollectionIterator().hasNext()) {
                String address = request.getParameter(i + "Address");
                if (address != null) {
                    addressController.add(new Address(address));
                } else {
                    addressController.add(new Address(""));
                }
                currentOrder.getAddressCollection().getCollectionIterator().next();
                ++i;
            }
        }
        currentOrder.setAddressCollection( addressController.getAddressCollection() );

        String action_ = request.getParameter("action");
        switch( action_ ){
            case "addDestination":
                addressController.setAddressCollection( currentOrder.getAddressCollection());
                addressController.add( new Address("") );
                break;
            case "deleteDestination":
                addressController.setAddressCollection( currentOrder.getAddressCollection());
                addressController.getAddressCollection().delete_back();
                break;
            case "check":
                while ( currentOrder.getAddressCollection().getCollectionIterator().hasNext() ) {
                    if ( currentOrder.getAddressCollection().getCollectionIterator().next() == null ||
                         currentOrder.getAddressCollection().getCollectionIterator().next().toString().equals("") ) {
                        /*
                        String errorMessage = "Заполните все поля";
                        */
                        %>
                        <%--
                        <jsp:include page="../utility/errorFrame.jsp">
                            <jsp:param name="message" value="<%=errorMessage%>"/>
                        </jsp:include>
                        --%>
                        <%
                    } else {
                        %>
                        <jsp:forward page="order.jsp?action=acceptOrder"/>
                        <%
                    }
                }
                break;
            case "acceptOrder":
                /*
                String errorMessage = "Заказ сделан";
                */
                %>
                <%--
                    <jsp:include page="../utility/errorFrame.jsp">
                        <jsp:param name="message" value="<%=errorMessage%>"/>
                    </jsp:include>
                --%>
                <%
                break;
            default:
                break;
        }
        currentOrder.setAddressCollection( addressController.getAddressCollection() );
    %>
    <div>

        <form action="../order/order.jsp" method="post">
            <table>
                <%
                    if( currentOrder.getAddressCollection().size() == 2 ) {
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
                        String firstValue = currentOrder.getAddressCollection().getCollectionIterator().next().getName();
                        if( !firstValue.equals("") ){
                            %>
                            <tr>
                                <td>
                                    <label>
                                        <input type="text" name="Address" placeholder="Откуда?" value=<%=firstValue%>>
                                    </label>
                                </td>
                            </tr>
                            <%
                        } else {
                            %>
                            <tr>
                                <td>
                                    <label>
                                        <input type="text" name="Address" placeholder="Откуда?">
                                    </label>
                                </td>
                            </tr>
                            <%
                        }
                        i = 0;
                        addressController.setAddressCollection( currentOrder.getAddressCollection());
                        while ( addressController.getIterator().hasNext() ) {
                            String value_ = addressController.getIterator().next().getName();
                            ++i;
                            String name_ = i + "Address";
                            if( !value_.equals("")){
                                %>
                                <tr>
                                    <td>
                                        <label>
                                            <input type="text" name=<%=name_%>; placeholder="Куда?" value=<%=value_%>>
                                        </label>
                                    </td>
                                </tr>
                                <%
                            } else {
                                %>
                                <tr>
                                    <td>
                                        <label>
                                            <input type="text" name=<%=name_%>; placeholder="Куда?">
                                        </label>
                                    </td>
                                </tr>
                                <%
                            }

                        }
                    }
                %>
                <tr>
                    <td>
                        <input type="hidden" name="action" value=""> <%--addDestination --%>
                        <input type="submit" value="Добавить остановку">
                    </td>
                    <td>
                        <input type="hidden" name="action" value=""> <%--deleteDestination --%>
                        <input type="submit" value="Удалить остановку">
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="hidden" name="action" value=""> <%--check --%>
                        <input type="submit" value="Сделать заказ">
                    </td>
                </tr>
            </table>
        </form>

    </div>

    <div>
        <form action="../account/account.jsp" method="post">
            <input type="submit" value="Профиль">
        </form>
    </div>
</body>
</html>
