package сollectionsInterfaces;

import DataBase.ConnectDB;

public interface ConnectedWithDB {
    void loadFromDB(ConnectDB connectDB);
    Long saveToDB(ConnectDB connectDB, final Long id_, boolean isEdited);
    void removeFromDB(ConnectDB connectDB, final Long id_);
}
