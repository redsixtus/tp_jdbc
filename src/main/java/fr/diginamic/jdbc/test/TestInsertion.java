package fr.diginamic.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestInsertion {
    public static void main(String[] args) {
        ResourceBundle bundle = ResourceBundle.getBundle("database");
        String url= bundle.getString("ADDON_DB");
        String password = bundle.getString("ADDON_PASSWORD");
        String user = bundle.getString("ADDON_USER");


        try(Connection connection = DriverManager.getConnection(url,user,password)) {
            System.out.println(connection);
            Statement st = connection.createStatement();
            int nb = st.executeUpdate("INSERT INTO FOURNISSEUR (ID,NOM) VALUES (4, 'La Maison de la Peinture')");
            System.out.println(nb);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
