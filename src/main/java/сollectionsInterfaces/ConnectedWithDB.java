package сollectionsInterfaces;

import DataBase.ConnectDB;
import people.users.User;

public interface ConnectedWithDB< User > {
    void loadFromDB(ConnectDB connectDB) throws Exception;
    Long saveToDB(ConnectDB connectDB, User user, boolean isEdited) throws Exception;
    void removeFromDB(ConnectDB connectDB, final Long id_) throws Exception;
}

//TODO : сделать свой exception