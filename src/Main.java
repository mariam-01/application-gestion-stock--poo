import model.Produit;
import java.util.Scanner;

import static service.ProduitService.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            printMenu();
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1 -> ajouterUnProduit(scanner);
                case 2 -> modifierUnProduit(scanner);
                case 3 -> supprimerUnProduit(scanner);
                case 4 -> afficherProduits();
                case 5 -> rechercherUnProduit(scanner);
                case 6 -> calculerValeurStock();
                case 0 -> System.out.println("Au revoir !");
                default -> System.out.println("Choix invalide.");
            }
        } while (choix != 0);

        scanner.close();
    }

    public static void printMenu() {
        System.out.println("\n--- Menu ---");
        System.out.println("1. Ajouter un produit");
        System.out.println("2. Modifier un produit");
        System.out.println("3. Supprimer un produit");
        System.out.println("4. Afficher la liste des produits");
        System.out.println("5. Rechercher un produit");
        System.out.println("6. Calculer la valeur du stock");
        System.out.println("0. Quitter");
        System.out.print("Choix: ");
    }

    public static void ajouterUnProduit(Scanner scanner) {
        System.out.print("Entrez le code du produit: ");
        int code = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        System.out.print("Entrez le nom du produit: ");
        String nom = scanner.nextLine();

        System.out.print("Entrez la quantité du produit: ");
        int quantite = scanner.nextInt();

        System.out.print("Entrez le prix du produit: ");
        double prix = scanner.nextDouble();

        Produit produit = new Produit(code, nom, quantite, prix);
        ajouterProduit(produit); // Direct static method call
    }

    public static void modifierUnProduit(Scanner scanner) {
        System.out.print("Entrez le code du produit à modifier: ");
        int code = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        System.out.print("Entrez le nouveau nom: ");
        String nom = scanner.nextLine();

        System.out.print("Entrez la nouvelle quantité: ");
        int quantite = scanner.nextInt();

        System.out.print("Entrez le nouveau prix: ");
        double prix = scanner.nextDouble();

        modifierProduit(code, nom, quantite, prix);
    }

    public static void supprimerUnProduit(Scanner scanner) {
        System.out.print("Entrez le code du produit à supprimer: ");
        int code = scanner.nextInt();

        supprimerProduit(code);
    }

    public static void rechercherUnProduit(Scanner scanner) {
        System.out.print("Entrez le nom du produit à rechercher: ");
        String nom = scanner.nextLine();

        rechercherProduit(nom);
    }
}
