package fr.diginamic.jdbc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionD {

    private static  ConnectionD single;

    private static final String DB_USER;
    private static final String DB_DB;
    private static final String DB_PASSWORD;

    private Connection connection;

    static {
        ResourceBundle bundle = ResourceBundle.getBundle("database");
        DB_DB = bundle.getString("ADDON_DB");
        DB_PASSWORD = bundle.getString("ADDON_PASSWORD");
        DB_USER = bundle.getString("ADDON_USER");
    }
    private ConnectionD() throws SQLException {
        connection= DriverManager.getConnection(DB_DB,DB_USER,DB_PASSWORD);
    }

    public static ConnectionD getSingle() throws SQLException {
       if(null == single){
           single= new ConnectionD();
       }
       return single;
    }

    public Connection getConnection() {
        return connection;
    }
}
