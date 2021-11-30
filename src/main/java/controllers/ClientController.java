package controllers;

import DataBase.ConnectDB;
import people.users.client.Client;
import people.users.client.ClientCollection;
import сollectionsInterfaces.ConnectedWithDB;

import java.sql.*;
import java.util.Set;

public class ClientController implements ConnectedWithDB {
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
        /*
        try (Connection connection = connectDB.getConnection();
             String prepareStatement_ = "SELECT User.NAME, User.LOGIN, User.PASSWORD"
                                        + "Client.PHONE_NUMBER, Client.RATE" + "FROM"
                                        + connectDB.getDBUsername() + ".User"
                                        + connectDB.getDBUsername() + ".Client"
                                        + "WHERE Client.id_User = User.id"
                                        + "order by name";
             PreparedStatement statement = connection.prepareStatement(prepareStatement_);
             ResultSet resultSet = statement.executeQuery();) {
            while (resultSet.next()) {
                UserStatus userStatus = new UserStatus();
                userStatus.setId(resultSet.getLong(1));
                userStatus.setStatus(resultSet.getString(2));
                userStatusFromDB.put(userStatus.getId(), userStatus);
            }

        } catch (SQLException | SQLException sqlException) {
            System.out.println("userController loadUserStatusFromDB"+ sqlException.getMessage());
        }
        System.out.println("dataBase" + userStatusFromDB.values());
        */
    }

    @Override
    public Long saveToDB(ConnectDB connectDB, Long id_, boolean isEdited) {
        return null;
    }

    @Override
    public void removeFromDB(ConnectDB connectDB, Long id_) {

    }
}
