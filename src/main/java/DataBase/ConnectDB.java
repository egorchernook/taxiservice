package DataBase;

import java.sql.*;
import oracle.jdbc.*;
import oracle.jdbc.pool.OracleDataSource;

public class ConnectDB {
    static private final String URL = "jdbc:oracle:thin:@oracle.para-lab.ru:1521:XE";
    private String PASSWORD = "1";
    private String DBUsername = "ECHERNOOK";
    private OracleDataSource oracleDataSource;
    private Connection connection;

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public String getDBUsername() {
        return DBUsername;
    }

    public void setDBUsername(String DBUsername) {
        this.DBUsername = DBUsername;
    }

    public ConnectDB(){
        try{
            this.oracleDataSource = new OracleDataSource();
            oracleDataSource.setURL(URL);
            oracleDataSource.setUser(DBUsername);
            oracleDataSource.setPassword(PASSWORD);

        } catch (SQLException sqlException) {
            System.out.println("ERROR! " + sqlException.getMessage());
            sqlException.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        connection = this.oracleDataSource.getConnection();
        connection.setAutoCommit(false);
        return this.connection;
    }

    public void closeConnection() throws SQLException {
        this.connection.close();
    }

}
