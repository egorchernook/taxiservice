package controllers;

import DataBase.ConnectDB;
import DataBase.ConnectionException;
import address.Address;
import address.AddressCollection;
import order.Order;
import order.OrderCollection;
import people.users.client.Client;
import people.users.client.ClientCollection;
import сollectionsInterfaces.ConnectedWithDB;

import java.sql.*;
import java.util.Set;

public class ClientController implements ConnectedWithDB<Client> {
    private ClientCollection clientCollection = new ClientCollection();

    //TODO: добавить записи в базу и проверить правильно ли работает контроллер. Если да - сделать такой же для драйвера и оператора.
    public ClientController() {
        /*
        this.add( new Client( 1L, "Егор", "+78888888888", "1".hashCode(), "+78888888888", 500, null ) );
        this.add( new Client( 2L, "Гоша", "+77777777777",  "1".hashCode(), "+77777777777", 500, null ) );
        this.add( new Client( 3L,  "Мадина", "+76666666666",  "1".hashCode(), "+76666666666", 500, null ) );
        this.add( new Client( 4L,  "Клава", "+75555555555",  "1".hashCode(), "+75555555555", 500, null) );
        */
    }

    public void add(Client client){
        clientCollection.add(client);
    }

    public void delete(Client client){
        clientCollection.delete(client);
    }

    public void clear(){
        clientCollection.clear();
    }

    public boolean isEmpty(){
        return clientCollection.isEmpty();
    }

    public Client find(String pattern){
        return clientCollection.find(pattern);
    }

    public Set<Client> findAll(String pattern){
        return clientCollection.findAll(pattern);
    }

    @Override
    public void loadFromDB(ConnectDB connectDB) throws ConnectionException {

        String prepareStatement_ = "SELECT USERS.ID, USERS.NAME, USERS.LOGIN, USERS.PASSWORD, " +
                "CLIENTS.PHONE_NUMBER, CLIENTS.RATE " +
                "FROM echernook.USERS, echernook.CLIENTS " +
                "WHERE CLIENTS.ID_USER = USERS.ID order by NAME";

        System.out.println( prepareStatement_);
        try (
                Connection connection = connectDB.getConnection();

                PreparedStatement statement = connection.prepareStatement(prepareStatement_);
                ResultSet resultSet = statement.executeQuery())
        {
            while (resultSet.next()) {

                Client client = new Client( resultSet.getLong(1),
                                            resultSet.getString(2),
                                            resultSet.getString(3),
                                            resultSet.getInt(4),
                                            resultSet.getString(5),
                                            resultSet.getInt(6),
                                null);

                    String orderPrepareStatement_ = "SELECT ORDERS.ID, ORDERS.NUM, ORDERS.FEEDBACK, ORDERS.PRICE, " +
                            "ORDERS.ORDER_DATE, ORDER_STATUS.NAME " +
                            "FROM echernook.ORDERS, echernook.ORDER_STATUS WHERE ORDER_STATUS.ID = ORDERS.ID_Status " +
                            "AND ORDERS.ID = " + client.getId().toString();

                    OrderCollection orderCollection = new OrderCollection();
                    System.out.println( orderPrepareStatement_);
                    try(
                            PreparedStatement orderStatement = connection.prepareStatement( orderPrepareStatement_);
                            ResultSet orderResultSet = orderStatement.executeQuery();
                            )
                    {
                        while( orderResultSet.next() ){
                            Order order = new Order( orderResultSet.getLong(1),
                                                     orderResultSet.getString(2),
                                                     null,
                                                     orderResultSet.getString(6),
                                                     orderResultSet.getInt(3),
                                                     orderResultSet.getInt(4),
                                                     orderResultSet.getDate(5));

                            String addressPrepareStatement_ = "SELECT Address.NAME " +
                                    " FROM echernook.Address, " +
                                    "echernook.Order_Address " +
                                    "WHERE Order_Address.id_Address = Address.id " +
                                    "AND Order_Address.id_Address = " + order.getId().toString();

                            AddressCollection addressCollection = new AddressCollection();

                            System.out.println( addressPrepareStatement_);
                            try(
                                    PreparedStatement addressStatement = connection.prepareStatement( addressPrepareStatement_);
                                    ResultSet addressResultSet = addressStatement.executeQuery();
                            ){
                                while( addressResultSet.next() ){
                                    Address address = new Address( addressResultSet.getString(1));

                                    addressCollection.add( address );
                                }
                            } catch (SQLException sqlException) {
                                    System.err.println("userController loadUserStatusFromDB address loading" + sqlException.getMessage());
                                    throw new ConnectionException("userController loadUserStatusFromDB address loading "+ sqlException.getMessage());
                            }
                            order.setAddressCollection( addressCollection);
                            orderCollection.add( order );
                        }
                    } catch (SQLException sqlException) {
                        System.err.println("userController loadUserStatusFromDB order loading " + sqlException.getMessage());
                        throw new ConnectionException("userController loadUserStatusFromDB order loading " + sqlException.getMessage());
                    }

                client.setOrderCollection( orderCollection);
                this.add( client );
            }

        } catch (SQLException sqlException) {
            System.err.println("clientsController loadFromDB cannot connect to DB " + sqlException.getMessage());
            throw new ConnectionException("clientsController loadFromDB cannot connect to DB " + sqlException.getMessage());
        }
        System.out.println("load clients from dataBase");
    }

    @Override
    public Long saveToDB(ConnectDB connectDB, Client client, boolean isEdited) throws ConnectionException {
        Long newId = client.getId();
        if( isEdited ){
            String query1 = "UPDATE echernook.Users "
                    + " SET Name=?, Login=?, PASSWORD=? WHERE ID=?";

            String query2 = "UPDATE echernook.Clients "
                    + " SET PHOME_NUMBER=?, RATE=? WHERE id_User=?";
            try(Connection connection = connectDB.getConnection() ){

                try (PreparedStatement statement = connection.prepareStatement(query1)) {
                    statement.setString(1, client.getName());
                    statement.setString(2, client.getLogin());
                    statement.setInt(3, client.getPassword());
                    statement.setLong(4, client.getId());

                    statement.executeUpdate();
                    connection.commit();
                } catch (SQLException sqlException) {
                    System.err.println("Cannot update client");
                    sqlException.printStackTrace();
                    connection.rollback();
                    throw new ConnectionException("Cannot update client" + sqlException.getMessage());
                }finally {
                    connectDB.closeConnection();
                }

                try (PreparedStatement statement = connection.prepareStatement(query2)) {
                    statement.setString(1, client.getPhoneNumber());
                    statement.setInt(2, client.getRate());
                    statement.setLong(3, client.getId());

                    statement.executeUpdate();
                    connection.commit();
                } catch (SQLException sqlException) {
                    System.err.println("Cannot update client");
                    sqlException.printStackTrace();
                    connection.rollback();
                    throw new ConnectionException("Cannot update client" + sqlException.getMessage());
                }finally {
                    connectDB.closeConnection();
                }

            }catch (SQLException exception) {
                System.err.println("Cannot create connection" + exception.getMessage());
                exception.printStackTrace();
                throw new ConnectionException("Cannot create connection" + exception.getMessage());
            }

        } else {
            String main_query = "select echernook.MAIN_SEQUENCE.nextval from dual";
            String query1 = "insert into echernook.Users(ID, NAME, LOGIN, PASSWORD) values (?, ?, ?, ?)";
            String query2 = "insert into echernook.Clients(PHONE_NUMBER, RATE, id_User) values(?, ?, ?)";
            try(Connection connection = connectDB.getConnection()){


                try(Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(main_query)){
                    while(rs.next()){
                        newId = rs.getLong(1);
                    }
                }catch (SQLException exception) {
                    System.err.println("Cannot select sequence" + exception.getMessage() );
                    exception.printStackTrace();
                    throw new ConnectionException("Cannot select sequence" + exception.getMessage());
                }



                try (PreparedStatement statement = connection.prepareStatement(query1)) {
                    statement.setLong(1, newId);
                    statement.setString(2, client.getName());
                    statement.setString(3, client.getLogin());
                    statement.setInt(4, client.getPassword());

                    statement.executeUpdate();
                    connection.commit();

                } catch (SQLException exception) {
                    System.err.println("Cannot save user part of client to DB");
                    exception.printStackTrace();
                    connection.rollback();
                    throw new ConnectionException("Cannot save user part of client to DB" + exception.getMessage());
                }finally {
                    connectDB.closeConnection();
                }

                try (PreparedStatement statement = connection.prepareStatement(query2)) {
                    statement.setString(1, client.getPhoneNumber());
                    statement.setInt(2, client.getRate());
                    statement.setLong(3, newId);

                    statement.executeUpdate();
                    connection.commit();

                } catch (SQLException exception) {
                    System.err.println("Cannot save client to DB");
                    exception.printStackTrace();
                    connection.rollback();
                    throw new ConnectionException("Cannot save client to DB" + exception.getMessage());
                }finally {
                    connectDB.closeConnection();
                }

            }catch (SQLException exception) {
                System.err.println("Cannot create connection" + exception.getMessage());
                exception.printStackTrace();
                throw new ConnectionException("Cannot create connection" + exception.getMessage());
            }

        }

        return newId;
    }

    @Override
    public void removeFromDB(ConnectDB connectDB, Long id_) throws ConnectionException {
        String query1 = "DELETE FROM echernook.Clients WHERE id_User=?";
        String query2 = "DELETE FROM echernook.Users WHERE id=?";
        try (Connection connection = connectDB.getConnection()){

            try (PreparedStatement statement = connection.prepareStatement(query1)){
                statement.setLong(1, id_);
                statement.execute();

            } catch (SQLException exception) {
                System.err.println(exception.getMessage());
                throw new ConnectionException("Cannot remove user" + exception.getMessage());
            }finally {
                connectDB.closeConnection();
            }
            try (PreparedStatement statement = connection.prepareStatement(query2)){
                statement.setLong(2, id_);
                statement.execute();

            } catch (SQLException exception) {
                System.err.println(exception.getMessage());
                throw new ConnectionException("Cannot remove user" + exception.getMessage());
            }finally {
                connectDB.closeConnection();
            }

        }catch (SQLException exception) {
            System.err.println("Cannot create connection");
            exception.printStackTrace();
            throw new ConnectionException("Cannot create connection" + exception.getMessage());
        }

    }
}
