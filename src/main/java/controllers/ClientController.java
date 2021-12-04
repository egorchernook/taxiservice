package controllers;

import DataBase.ConnectDB;
import people.users.client.Client;
import people.users.client.ClientCollection;
import сollectionsInterfaces.ConnectedWithDB;

import java.sql.*;
import java.util.Set;

public class ClientController implements ConnectedWithDB<Client> {
    private ClientCollection clientCollection = new ClientCollection();

    public ClientController() {
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
    public void loadFromDB(ConnectDB connectDB){

        try (
                Connection connection = connectDB.getConnection();
                String prepareStatement_ = "SELECT User.ID, User.NAME, User.LOGIN, User.PASSWORD"
                                         + "Client.PHONE_NUMBER, Client.RATE"
                                         + "FROM"
                                         + connectDB.getDBUsername() + ".User"
                                         + connectDB.getDBUsername() + ".Client"
                                         + "WHERE Client.id_User = User.ID"
                                         + "order by name";
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
                this.add( client );
            }

        } catch (SQLException sqlException) {
            System.out.println("userController loadUserStatusFromDB"+ sqlException.getMessage());
        }
        System.out.println("dataBase");
    }

    @Override
    public Long saveToDB(ConnectDB connectDB, Client client, boolean isEdited) {
        Long newId = client.getId();
        if( isEdited ){
            try(Connection connection = connectDB.getConnection() ){
                String query = "update" + connectDB.getDBUsername() + ".User"
                             + " set NAME=?, LOGIN=?, PASSWORD=? where ID=?;"
                             + "update" + connectDB.getDBUsername() + ".Client"
                             + " set PHOME_NUMBER=?, RATE=? where id_User=?;";
                try (PreparedStatement statement = connection.prepareStatement(query);) {
                    statement.setString(1, client.getName());
                    statement.setString(2, client.getLogin());
                    statement.setInt(3, client.getPassword());
                    statement.setLong(4, client.getId());
                    statement.setString(5, client.getPhoneNumber());
                    statement.setInt(6, client.getRate());
                    statement.setLong(7, client.getId());

                    statement.executeUpdate();
                    connection.commit();
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                    connection.rollback();
                }finally {
                    connectDB.closeConnection();
                }
            }catch (SQLException throwables) {
                System.out.println("Cannot create connection");
                throwables.printStackTrace();
            }

        } else {

            try(Connection connection = connectDB.getConnection()){
                String main_query = "select echernook.MAIN_SEQUENCE.nextval from dual";
                String query = "insert into echernook.User(ID, NAME, LOGIN, PASSWORD) values (?, ?, ?, ?);"
                             + "insert into echernook.Client(PHONE_NUMBER, RATE, id_User) values(?, ?, ?);";

                try(Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(main_query)){
                    while(rs.next()){
                        newId = rs.getLong(1);
                    }
                }catch (SQLException throwables) {
                    System.out.println("Cannot select sequence");
                    throwables.printStackTrace();
                }

                try (PreparedStatement statement = connection.prepareStatement(query)) {
                    statement.setLong(1, newId);
                    statement.setString(2, client.getName());
                    statement.setString(3, client.getLogin());
                    statement.setInt(4, client.getPassword());
                    statement.setString(5, client.getPhoneNumber());
                    statement.setInt(6, client.getRate());
                    statement.setLong(7, newId);

                    statement.executeUpdate();
                    connection.commit();

                } catch (SQLException throwables) {
                    System.out.println("Cannot create this parameter");
                    throwables.printStackTrace();
                    connection.rollback();
                }finally {
                    connectDB.closeConnection();
                }
            }catch (SQLException throwables) {
                System.out.println("Cannot create connection");
                throwables.printStackTrace();
            }

        }

        return newId;
    }

    @Override
    public void removeFromDB(ConnectDB connectDB, Long id_) {
        try (Connection connection = connectDB.getConnection()){
            String query = "DELETE FROM echernook.Client WHERE id_User=?;"
                         + "DELETE FROM echernook.User WHERE id=?;";

            try (PreparedStatement statement = connection.prepareStatement(query);){
                statement.setLong(1, id_);
                statement.setLong(2, id_);
                statement.execute();

            } catch (SQLException throwables) {
                System.out.println(throwables.getMessage());
            }finally {
                connectDB.closeConnection();
            }

        }catch (SQLException throwables) {
            System.out.println("Cannot create connection");
            throwables.printStackTrace();
        }

    }
}
