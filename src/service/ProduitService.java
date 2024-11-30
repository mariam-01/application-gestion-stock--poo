package service;

import model.Produit;

public class ProduitService {

    private static Produit[] produits = new Produit[100];
    private static int nbProduits = 0;


    // Méthode pour ajouter un produit
    public static boolean ajouterProduit(Produit produit) {
        if (nbProduits < produits.length) {
            // Vérifier l'unicité du code produit
            for (int i = 0; i < nbProduits; i++) {
                if (produits[i].getCode() == produit.getCode()) {
                    System.out.println("Erreur : Le code produit existe déjà.");
                    return false;
                }
            }
            produits[nbProduits++] = produit;
            System.out.println("Produit ajouté avec succès.");
            return true;
        } else {
            System.out.println("Erreur : Le stock est plein.");
            return false;
        }
    }

    // Méthode pour modifier un produit
    public static boolean modifierProduit(int code, String nouveauNom, int nouvelleQuantite, double nouveauPrix) {
        for (int i = 0; i < nbProduits; i++) {
            if (produits[i].getCode() == code) {
                produits[i].setNom(nouveauNom);
                produits[i].setQuantite(nouvelleQuantite);
                produits[i].setPrix(nouveauPrix);
                System.out.println("Produit modifié avec succès.");
                return true;
            }
        }
        System.out.println("Produit non trouvé.");
        return false;
    }

    // Méthode pour supprimer un produit
    public static boolean supprimerProduit(int code) {
        for (int i = 0; i < nbProduits; i++) {
            if (produits[i].getCode() == code) {
                // Décalage des produits pour supprimer
                for (int j = i; j < nbProduits - 1; j++) {
                    produits[j] = produits[j + 1];
                }
                produits[--nbProduits] = null;  // Libérer la dernière position
                System.out.println("Produit supprimé avec succès.");
                return true;
            }
        }
        System.out.println("Produit non trouvé.");
        return false;
    }

    // Méthode pour afficher tous les produits
    public static void afficherProduits() {
        if (nbProduits == 0) {
            System.out.println("Aucun produit en stock.");
        } else {
            for (int i = 0; i < nbProduits; i++) {
                System.out.println(produits[i]);
            }
        }
    }

    // Méthode pour rechercher un produit par nom
    public static void rechercherProduit(String nom) {
        boolean trouve = false;
        for (int i = 0; i < nbProduits; i++) {
            if (produits[i].getNom().equalsIgnoreCase(nom)) {
                System.out.println(produits[i]);
                trouve = true;
            }
        }
        if (!trouve) {
            System.out.println("Produit non trouvé.");
        }
    }

    // Méthode pour calculer la valeur totale du stock
    public static void calculerValeurStock() {
        double valeurTotal = 0;
        for (int i = 0; i < nbProduits; i++) {
            valeurTotal += produits[i].calculerValeur();
        }
        System.out.println("La valeur totale du stock est : " + valeurTotal);
    }
}
