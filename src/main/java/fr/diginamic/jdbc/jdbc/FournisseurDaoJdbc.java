package fr.diginamic.jdbc.jdbc;

import fr.diginamic.jdbc.dao.FournisseurDao;
import fr.diginamic.jdbc.entites.Fournisseu;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class FournisseurDaoJdbc implements FournisseurDao {

    private static final String SELECT_QUERY = "SELECT ID, NOM FROM FOURNISSEUR";
    private static final String INSERT_FOURNISSEUR_QUERY = "INSERT INTO FOURNISSEUR (NOM) VALUES (?)";
    private static final String UPDATE_FOURNISSEUR_QUERY = "UPDATE FOURNISSEUR SET NOM=?  WHERE NOM =?";
    private static final String DELETE_FOURNISSEUR_QUERY = "DELETE FROM FOURNISSEUR WHERE  NOM=? AND ID=?";
    private static final String SELECT_FOURNISSEUR_QUERY = "SELECT ID FROM FOURNISSEUR WHERE ID=?";


    @Override
    public List<Fournisseu> extraire() throws SQLException {

        Connection connection = ConnectionD.getSingle().getConnection();

        List<Fournisseu> list = new ArrayList<>();
        try (PreparedStatement pst = connection.prepareStatement(SELECT_QUERY)) {

            try (ResultSet rs = pst.executeQuery()) {

                while (rs.next()) {
                    list.add(new Fournisseu(rs.getInt("ID"), rs.getString("NOM")));
                }
                for (Fournisseu item : list) {
                    System.out.println(item);
                }
            }
        }
        return list;
    }

    @Override
    public void insert(Fournisseu fournisseur) throws SQLException {

        Connection connection = ConnectionD.getSingle().getConnection();

        try (PreparedStatement pst = connection.prepareStatement(INSERT_FOURNISSEUR_QUERY)) {
            pst.setString(1, fournisseur.getNom());
            int nb = pst.executeUpdate();

        }
    }

    @Override
    public int update(String ancienNom, String nouveauNom) throws SQLException {
        Connection connection = ConnectionD.getSingle().getConnection();


        int nb;
        try (PreparedStatement pst = connection.prepareStatement(UPDATE_FOURNISSEUR_QUERY)) {
            pst.setString(1, nouveauNom);
            pst.setString(2, ancienNom);
            nb = pst.executeUpdate();
            System.out.println(nb);
        }
        return nb;
    }

    @Override
    public boolean delete(Fournisseu fournisseur) throws SQLException {
        Connection connection = ConnectionD.getSingle().getConnection();

        int nb = 0;
        try (PreparedStatement pst = connection.prepareStatement(DELETE_FOURNISSEUR_QUERY)) {
            System.out.println(connection);
            pst.setString(1, fournisseur.getNom());
            pst.setInt(2, fournisseur.getId());
            nb = pst.executeUpdate();
            System.out.println(nb);
        }
        return nb == 1;
    }



    @Override
    public int findById (int id ) throws SQLException {
        Connection connection = ConnectionD.getSingle().getConnection();
        int nb;
        try (PreparedStatement pst = connection.prepareStatement(SELECT_FOURNISSEUR_QUERY)) {
            pst.setInt(1, id );
             nb = pst.executeUpdate();



        }
        return nb;

    }
}
