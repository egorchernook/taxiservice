package сollectionsInterfaces;

import DataBase.ConnectDB;
import people.users.User;

public interface ConnectedWithDB< User > {
    void loadFromDB(ConnectDB connectDB);
    Long saveToDB(ConnectDB connectDB, User user, boolean isEdited);
    void removeFromDB(ConnectDB connectDB, final Long id_);
}
