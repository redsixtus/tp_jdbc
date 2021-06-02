package fr.diginamic.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TestConnexionJdbc {
    public static void main(String[] args) {
        ResourceBundle bundle = ResourceBundle.getBundle("database");
        String url= bundle.getString("ADDON_DB");
        String password = bundle.getString("ADDON_PASSWORD");
        String user = bundle.getString("ADDON_USER");


        try(Connection connection = DriverManager.getConnection(url,user,password)) {
            System.out.println(connection);
        } catch (SQLException e) {
          System.out.println(e.getMessage());
        }
    }
}
