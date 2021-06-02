package fr.diginamic.jdbc.dao;


import java.util.List;
import fr.diginamic.jdbc.entites.Fournisseu;
import java.sql.SQLException;


public interface FournisseurDao {
        List<Fournisseu> extraire() throws SQLException;
        void insert(Fournisseu fournisseur) throws SQLException;
        int update(String ancienNom, String nouveauNom) throws SQLException;
        boolean delete(Fournisseu fournisseur) throws SQLException;


}
