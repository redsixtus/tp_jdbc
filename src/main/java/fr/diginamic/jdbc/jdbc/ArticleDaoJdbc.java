package fr.diginamic.jdbc.jdbc;

import fr.diginamic.jdbc.dao.ArticleDao;
import fr.diginamic.jdbc.entites.Article;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticleDaoJdbc implements ArticleDao {
    private static final String SELECT_ARTICLE_QUERY = "SELECT ID, DESIGNATION, PRIX, REF FROM ARTICLE";
    private static final String INSERT_ARTICLE_QUERY = "INSERT INTO ARTICLE (DESIGNATION,PRIX) VALUES (?,?)";
    private static final String UPDATE_ARTICLE_QUERY = "UPDATE ARTICLE SET DESIGNATION=?  WHERE DESIGNATION=?";
    private static final String DELETE_ARTICLE_QUERY = "DELETE FROM ARTICLE WHERE  DESIGNIATION=? AND ID=?";


    @Override
    public List<Article> extraireArticle() throws SQLException {
        Connection connection = ConnectionD.getSingle().getConnection();

        List<Article> list = new ArrayList<>();
        try (PreparedStatement pst = connection.prepareStatement(SELECT_ARTICLE_QUERY)) {

            try (ResultSet rs = pst.executeQuery()) {

                while (rs.next()) {
                    //  list.add(new Article(rs.getInt("ID"),rs.getString("REF"), rs.getString("DESIGNATION"),rs.getDouble("PRIX")));
                }
                for (Article item : list) {
                    System.out.println(item);
                }
            }
        }
        return list;
    }

    @Override
    public void insertArticle(Article article) throws SQLException {
        Connection connection = ConnectionD.getSingle().getConnection();

        try (PreparedStatement pst = connection.prepareStatement(INSERT_ARTICLE_QUERY)) {
            pst.setString(1, article.getDesignation());
            pst.setDouble(2, article.getPrix());
            int nb = pst.executeUpdate();
        }
    }

    @Override
    public int updateArticle(String ancienNom, String nouveauNom) throws SQLException {
        Connection connection = ConnectionD.getSingle().getConnection();

        int nb;
        try (PreparedStatement pst = connection.prepareStatement(UPDATE_ARTICLE_QUERY)) {
            pst.setString(1, nouveauNom);
            pst.setString(2, ancienNom);
            nb = pst.executeUpdate();
            System.out.println(nb);
        }
        return nb;
    }

    @Override
    public boolean deleteArticle(Article article) throws SQLException {
        Connection connection = ConnectionD.getSingle().getConnection();

        int nb = 0;
        try (PreparedStatement pst = connection.prepareStatement(DELETE_ARTICLE_QUERY)) {
            System.out.println(connection);
            pst.setString(1, article.getDesignation());
            pst.setInt(2, article.getId());
            nb = pst.executeUpdate();
            System.out.println(nb);
        }
        return nb == 1;
    }

}
