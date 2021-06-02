package fr.diginamic.jdbc.service;

import fr.diginamic.jdbc.dao.ArticleDao;
import fr.diginamic.jdbc.entites.Article;
import fr.diginamic.jdbc.jdbc.ArticleDaoJdbc;

import java.sql.SQLException;

public class ArticleService {
    private static ArticleService single;
    private ArticleService() {}

    public static ArticleService getSingle() {

        if (null == single) {
            single = new ArticleService();
        }
        return single;
    }
    public void insertArticle (Article article) throws SQLException {
        ArticleDao dao = new ArticleDaoJdbc();
        dao.insertArticle(article);
    }
    public void updateArticle (String ancienNom, String nouveauNom) throws SQLException {
        ArticleDao dao = new ArticleDaoJdbc();
        dao.updateArticle(ancienNom,nouveauNom);
    }

    public void deleteArticle (Article article) throws SQLException {
        ArticleDao dao = new ArticleDaoJdbc();
        dao.deleteArticle(article);
    }
    public void extraireArticle() throws SQLException {
        ArticleDao dao = new ArticleDaoJdbc();
        dao.extraireArticle();
    }

}
