package fr.diginamic.jdbc.test;

import fr.diginamic.jdbc.entites.Fournisseu;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TestSelect {
    public static void main(String[] args) {
        ResourceBundle bundle = ResourceBundle.getBundle("database");
        String url= bundle.getString("ADDON_DB");
        String password = bundle.getString("ADDON_PASSWORD");
        String user = bundle.getString("ADDON_USER");


        try(Connection connection = DriverManager.getConnection(url,user,password)) {
            Statement st = connection.createStatement();
            try (ResultSet rs = st.executeQuery("SELECT ID, NOM FROM FOURNISSEUR")){
                List<Fournisseu> list = new ArrayList<>();
                while(rs.next()){
                    list.add(new Fournisseu(rs.getInt("ID"), rs.getString("NOM")));
                }
                for (Fournisseu item : list){
                    System.out.println(item);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
