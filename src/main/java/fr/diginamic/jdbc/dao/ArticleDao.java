package fr.diginamic.jdbc.dao;

import fr.diginamic.jdbc.entites.Article;

import java.sql.SQLException;
import java.util.List;

public interface ArticleDao {

    List<Article> extraireArticle() throws SQLException;
    void insertArticle(Article article) throws SQLException;
    int updateArticle(String ancienNom, String nouveauNom) throws SQLException;
    boolean deleteArticle(Article article) throws SQLException;

}
