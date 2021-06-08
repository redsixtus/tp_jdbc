package fr.diginamic.jdbc.entites;

import java.io.Serializable;

public class Article implements Serializable {
   private int id;
   private String ref;
   private String designation;
   private double prix;
   private Fournisseu fournisseur;

    public Article(int id, String string, double prix, String designation, Fournisseu fournisseur) {
        this.id = id;
        this.designation=designation;
    }

    public Article(String designation, double prix) {
        this.designation = designation;
        this.prix = prix;
    }

    public Article(String s, String ref, Double prix, int fournisseu) {
        this.ref = ref;
    }



    public Article(int id, String ref, String designation, double prix, Fournisseu fournisseur) {
        this.id = id;
        this.ref = ref;
        this.designation = designation;
        this.prix = prix;
        this.fournisseur = fournisseur;
    }

    public Article(String ref, String designation, double prix, Fournisseu fournisseur) {
        this.ref = ref;
        this.designation = designation;
        this.prix = prix;
        this.fournisseur = fournisseur;
    }





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public fr.diginamic.jdbc.entites.Fournisseu getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(fr.diginamic.jdbc.entites.Fournisseu fournisseur) {
        this.fournisseur = fournisseur;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", ref='" + ref + '\'' +
                ", designation='" + designation + '\'' +
                ", prix=" + prix +
                ", fournisseur=" + fournisseur +
                '}';
    }
}
