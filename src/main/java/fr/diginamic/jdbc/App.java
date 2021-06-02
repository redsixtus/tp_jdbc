package fr.diginamic.jdbc;

import fr.diginamic.jdbc.entites.Article;

import fr.diginamic.jdbc.entites.Fournisseu;
import fr.diginamic.jdbc.service.ArticleService;
import fr.diginamic.jdbc.service.FournisseurService;

import java.sql.SQLException;

public class App {
    public static void main(String[] args)  {


    voirArticle();

    }
    public static void ajoutArticle(String desigiation,Double prix ){
        ArticleService service = ArticleService.getSingle();
        try {
            service.insertArticle(new Article(desigiation,prix));
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    public static void changeArticle(String ancien, String nouveau ){
        ArticleService service = ArticleService.getSingle();

        try {
            service.updateArticle(ancien,nouveau);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }
    public static void deleteArticle(int delete_id,String delete_designiation){
        ArticleService service = ArticleService.getSingle();
        try {
            service.deleteArticle(new Article(delete_designiation, delete_id));
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    public static void voirArticle(){
        ArticleService service = ArticleService.getSingle();
        try {
            service.extraireArticle();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void ajoutFournisseur(String nom){
        FournisseurService service = FournisseurService.getSingle();
        try {
            service.insert(new Fournisseu(nom));
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    public static void changeFournisseur(String ancien, String nouveau ){
        FournisseurService service = FournisseurService.getSingle();

        try {
            service.update(ancien,nouveau);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }
    public static void deleteFournisseur(int delete_id,String delete_nom){
        FournisseurService service = FournisseurService.getSingle();
        try {
            service.delete(new Fournisseu(delete_id,delete_nom));
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void voirFournisseur(){
        FournisseurService service = FournisseurService.getSingle();
        try {
            service.extraire();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

}
