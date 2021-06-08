package fr.diginamic.jdbc.service;

import fr.diginamic.jdbc.dao.FournisseurDao;
import fr.diginamic.jdbc.entites.Fournisseu;

import fr.diginamic.jdbc.jdbc.FournisseurDaoJdbc;

import java.sql.SQLException;

public class FournisseurService {
    private static FournisseurService single;

    private FournisseurService() {}

    public static FournisseurService getSingle() {

        if (null == single) {
            single = new FournisseurService();
        }
        return single;
    }

    public void insert (Fournisseu fournisseur) throws SQLException {
    FournisseurDao dao = new FournisseurDaoJdbc();
    dao.insert(fournisseur);
    }

    public void update (String ancienNom, String nouveauNom) throws SQLException {
    FournisseurDao dao = new FournisseurDaoJdbc();
    dao.update(ancienNom,nouveauNom);
    }

    public void delete (Fournisseu fournisseur) throws SQLException {
    FournisseurDao dao = new FournisseurDaoJdbc();
    dao.delete(fournisseur);
    }

    public void extraire() throws SQLException {
    FournisseurDao dao = new FournisseurDaoJdbc();
    dao.extraire();
    }
    public int findById(int id) throws  SQLException{
        FournisseurDao dao = new FournisseurDaoJdbc();

        return dao.findById(id);

    }

}
