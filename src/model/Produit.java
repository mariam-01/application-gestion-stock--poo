package model;

public class Produit {
    // Attributs privés
    private int code;
    private String nom;
    private int quantite;
    private double prix;

    // Constructeur avec tous les attributs
    public Produit(int code, String nom, int quantite, double prix) {
        this.code = code;
        this.nom = nom;
        this.quantite = quantite;
        this.prix = prix;
    }

    // Constructeur par défaut
    public Produit() {
        this.code = 0;
        this.nom = "Inconnu";
        this.quantite = 0;
        this.prix = 0.0;
    }

    // Getters et setters
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        if (quantite >= 0) {
            this.quantite = quantite;
        } else {
            System.out.println("Quantité invalide.");
        }
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        if (prix >= 0) {
            this.prix = prix;
        } else {
            System.out.println("Prix invalide.");
        }
    }

    // Méthode toString
    @Override
    public String toString() {
        return "Code: " + code + ", Nom: " + nom + ", Quantité: " + quantite + ", Prix: " + prix;
    }

    // Méthode pour calculer la valeur totale du produit en stock
    public double calculerValeur() {
        return quantite * prix;
    }

}
