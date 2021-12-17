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
        this.add( new Client( 1L, "Егор", "Егор", "1".hashCode(), "+78888888888", 500, null ) );
        this.add( new Client( 2L, "Гоша", "Гоша",  "1".hashCode(), "+77777777777", 500, null ) );
        this.add( new Client( 3L,  "Мадина", "Мадина",  "1".hashCode(), "+76666666666", 500, null ) );
        this.add( new Client( 4L,  "Клава", "Клава",  "1".hashCode(), "+75555555555", 500, null) );
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

    public Client find(String pattern){
        return clientCollection.find(pattern);
    }

    public Set<Client> findAll(String pattern){
        return clientCollection.findAll(pattern);
    }

    @Override
    public void loadFromDB(ConnectDB connectDB) throws ConnectionException {

        String prepareStatement_ = "SELECT User.ID, User.NAME, User.LOGIN, User.PASSWORD"
                                 + "Client.PHONE_NUMBER, Client.RATE"
                                 + "FROM"
                                 + connectDB.getDBUsername() + ".User"
                                 + connectDB.getDBUsername() + ".Client"
                                 + "WHERE Client.id_User = User.ID"
                                 + "order by name";

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

                    String orderPrepareStatement_ = "SELECT Order.ID, Order.NUM, Order.FEEDBACK, "
                                                  + "Order.PRICE, Order.ORDER_DATE, Order_Status.NAME"
                                                  + "FROM"
                                                  + connectDB.getDBUsername() + ".Order"
                                                  + connectDB.getDBUsername() + ".Order_Status"
                                                  + "WHERE Order_Status.ID = Order.ID_Status"
                                                  + "AND Order.ID = " + client.getId().toString();

                    OrderCollection orderCollection = new OrderCollection();
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

                            String addressPrepareStatement_ = "SELECT Address.NAME"
                                                            + "FROM"
                                                            + connectDB.getDBUsername() + ".Address"
                                                            + connectDB.getDBUsername() + ".Order_Address"
                                                            + "WHERE Order_Address.ID_ADDRESS = Address.id"
                                                            + "AND Order_Address.ID_ORDER = " + order.getId().toString();

                            AddressCollection addressCollection = new AddressCollection();
                            try(
                                    PreparedStatement addressStatement = connection.prepareStatement( addressPrepareStatement_);
                                    ResultSet addressResultSet = addressStatement.executeQuery();
                            ){
                                while( addressResultSet.next() ){
                                    Address address = new Address( addressResultSet.getString(1));

                                    addressCollection.add( address );
                                }
                            } catch (SQLException sqlException) {
                                    System.err.println("userController loadUserStatusFromDB"+ sqlException.getMessage());
                            }
                            order.setAddressCollection( addressCollection);
                            orderCollection.add( order );
                        }
                    } catch (SQLException sqlException) {
                        System.err.println("userController loadUserStatusFromDB"+ sqlException.getMessage());
                    }

                client.setOrderCollection( orderCollection);
                this.add( client );
            }

        } catch (SQLException sqlException) {
            System.err.println("userController loadUserStatusFromDB" + sqlException.getMessage());
        }
        System.out.println("dataBase");
    }

    @Override
    public Long saveToDB(ConnectDB connectDB, Client client, boolean isEdited) throws ConnectionException {
        Long newId = client.getId();
        if( isEdited ){
            String query1 = "update " + connectDB.getDBUsername() + ".User"
                    + " set NAME=?, LOGIN=?, PASSWORD=? where ID=?";

            String query2 = "update " + connectDB.getDBUsername() + ".Client"
                    + " set PHOME_NUMBER=?, RATE=? where id_User=?";
            try(Connection connection = connectDB.getConnection() ){

                try (PreparedStatement statement = connection.prepareStatement(query1)) {
                    statement.setString(1, client.getName());
                    statement.setString(2, client.getLogin());
                    statement.setInt(3, client.getPassword());
                    statement.setLong(4, client.getId());

                    statement.executeUpdate();
                    connection.commit();
                } catch (SQLException sqlException) {
                    System.err.println("Cannot update user");
                    sqlException.printStackTrace();
                    connection.rollback();
                    throw new ConnectionException("Cannot update user" + sqlException.getMessage());
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
                    System.err.println("Cannot update user");
                    sqlException.printStackTrace();
                    connection.rollback();
                    throw new ConnectionException("Cannot update user" + sqlException.getMessage());
                }finally {
                    connectDB.closeConnection();
                }

            }catch (SQLException exception) {
                System.err.println("Cannot create connection");
                exception.printStackTrace();
            }

        } else {
            String main_query = "select echernook.MAIN_SEQUENCE.nextval from dual";
            String query1 = "insert into echernook.User(ID, NAME, LOGIN, PASSWORD) values (?, ?, ?, ?)";
            String query2 = "insert into echernook.Client(PHONE_NUMBER, RATE, id_User) values(?, ?, ?)";
            try(Connection connection = connectDB.getConnection()){


                try(Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(main_query)){
                    while(rs.next()){
                        newId = rs.getLong(1);
                    }
                }catch (SQLException exception) {
                    System.err.println("Cannot select sequence");
                    exception.printStackTrace();
                }



                try (PreparedStatement statement = connection.prepareStatement(query1)) {
                    statement.setLong(1, newId);
                    statement.setString(2, client.getName());
                    statement.setString(3, client.getLogin());
                    statement.setInt(4, client.getPassword());

                    statement.executeUpdate();
                    connection.commit();

                } catch (SQLException exception) {
                    System.err.println("Cannot create this parameter");
                    exception.printStackTrace();
                    connection.rollback();
                    throw new ConnectionException("Cannot update user" + exception.getMessage());
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
                    System.err.println("Cannot create this parameter");
                    exception.printStackTrace();
                    connection.rollback();
                    throw new ConnectionException("Cannot update user" + exception.getMessage());
                }finally {
                    connectDB.closeConnection();
                }

            }catch (SQLException exception) {
                System.err.println("Cannot create connection");
                exception.printStackTrace();
            }

        }

        return newId;
    }

    @Override
    public void removeFromDB(ConnectDB connectDB, Long id_) throws ConnectionException {
        String query1 = "DELETE FROM echernook.Client WHERE id_User=?";
        String query2 = "DELETE FROM echernook.User WHERE id=?";
        try (Connection connection = connectDB.getConnection()){

            try (PreparedStatement statement = connection.prepareStatement(query1)){
                statement.setLong(1, id_);
                statement.execute();

            } catch (SQLException exception) {
                System.err.println(exception.getMessage());
                throw new ConnectionException("Cannot update user" + exception.getMessage());
            }finally {
                connectDB.closeConnection();
            }
            try (PreparedStatement statement = connection.prepareStatement(query2)){
                statement.setLong(2, id_);
                statement.execute();

            } catch (SQLException exception) {
                System.err.println(exception.getMessage());
                throw new ConnectionException("Cannot update user" + exception.getMessage());
            }finally {
                connectDB.closeConnection();
            }

        }catch (SQLException exception) {
            System.err.println("Cannot create connection");
            exception.printStackTrace();
        }

    }
}
