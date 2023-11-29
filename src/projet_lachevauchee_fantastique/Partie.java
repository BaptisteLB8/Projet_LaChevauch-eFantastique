/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projet_lachevauchee_fantastique;

import java.util.Scanner;

/**
 *
 * @author Utilisateur
 */
public class Partie {

    private GrilleDeJeu grille;

    public Partie() {
        grille = new GrilleDeJeu(6, 6);
    }

    public String obtenirCoupJoueur() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez la ligne (A-G) :");
        String ligne = scanner.nextLine().toUpperCase(); // Convertir en majuscules pour être insensible à la casse

        // Vérifier si la ligne est entre A et G
        if (!ligne.matches("[A-G]")) {
            System.out.println("Ligne invalide. Entrez une lettre entre A et G.");
            return obtenirCoupJoueur(); // Redemander la ligne
        }

        System.out.println("Entrez la colonne (1-7) :");
        int colonne = scanner.nextInt();

        // Vérifier si la colonne est entre 1 et 7
        if (colonne < 1 || colonne > 7) {
            System.out.println("Colonne invalide. Entrez un nombre entre 1 et 7.");
            return obtenirCoupJoueur(); // Redemander la colonne
        }

        scanner.nextLine(); //
        return null;
    }

    public void configurerNiveauDifficulte() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choisissez un niveau de difficulté :");
        System.out.println("1. Facile");
        System.out.println("2. Moyen");
        System.out.println("3. Difficile");

        int choix = scanner.nextInt();

        switch (choix) {
            case 1:
                grille = new GrilleDeJeu(8 ,8); // Met à jour la grille actuelle avec une grille 5x5
                break;
            case 2:
                grille = new GrilleDeJeu(9, 9); // Met à jour la grille actuelle avec une grille 6x6
                break;
            case 3:
                grille = new GrilleDeJeu(10, 10); // Met à jour la grille actuelle avec une grille 7x7
                break;
            default:
                System.out.println("Choix invalide. Sélectionnez un niveau de difficulté valide.");
                return;
        }
    }

    /**
     * initialise le lancemant de partie gere la boucle de jeu ( demande le coup
     * jouer, modifie le plateau, donne le resultat de la partie)
     */
    public void lancerPartie() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenue dans La Chevauchée Fantastique!");
        System.out.println("Grille de départ :");
        System.out.println(grille);

        while (!grille.cellulesToutesEteintes()) {
            String coup = obtenirCoupJoueur();
        }

        if (grille.cellulesToutesEteintes()) {
            System.out.println("Bravo ! Vous avez éteint toutes les cellules.");
        }
    }
}
