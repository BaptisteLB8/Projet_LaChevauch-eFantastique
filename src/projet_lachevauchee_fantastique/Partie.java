/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projet_lachevauchee_fantastique;

import java.util.ArrayList;
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

    public ArrayList<Integer> obtenirCoupJoueur() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez la ligne (1-" + grille.getnbLignes() + ") :");
        int ligne = scanner.nextInt(); // Convertir en majuscules pour �tre insensible � la casse

        // V�rifier si la ligne est entre A et G
        if (ligne < 1 || ligne > grille.getnbLignes()) {
            System.out.println("Ligne invalide. Entrez un nombre entre 1 et " + grille.getnbLignes() + ".");
            return obtenirCoupJoueur(); // Redemander la ligne
        }

        System.out.println("Entrez la colonne (1-" + grille.getnbColonnes() + ") :");
        int colonne = scanner.nextInt();

        // V�rifier si la colonne est entre 1 et 7
        if (colonne < 1 || colonne > grille.getnbColonnes()) {
            System.out.println("Colonne invalide. Entrez un nombre entre 1 et " + grille.getnbColonnes() + "");
            return obtenirCoupJoueur(); // Redemander la colonne
        }

        scanner.nextLine(); //
        ArrayList<Integer> coupJoueur = new ArrayList<>();
        coupJoueur.add(ligne);
        coupJoueur.add(colonne);
        return coupJoueur;
    }

    public void configurerNiveauDifficulte() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choisissez un niveau de difficult� :");
        System.out.println("1. Facile");
        System.out.println("2. Moyen");
        System.out.println("3. Difficile");

        int choix = scanner.nextInt();

        switch (choix) {
            case 1:
                grille = new GrilleDeJeu(8, 8); // Met � jour la grille actuelle avec une grille 5x5
                grille.initialiserMatrice(8);
                break;
            case 2:
                grille = new GrilleDeJeu(9, 9); // Met � jour la grille actuelle avec une grille 6x6
                grille.initialiserMatrice(9);
                break;
            case 3:
                grille = new GrilleDeJeu(10, 10); // Met � jour la grille actuelle avec une grille 7x7
                grille.initialiserMatrice(10);
                break;
            default:
                System.out.println("Choix invalide. S�lectionnez un niveau de difficult� valide.");
                return;
        }
    }

    public ArrayList<Integer> PositionnerCava() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choisissez une cellule allum�e sur laquelle placer le cavalier.\nLigne : ");
            int i = scanner.nextInt();
            System.out.println("Colonne : ");
            int j = scanner.nextInt();

            if (grille.matriceCellules[i - 1][j - 1].estEteint()) {
                System.out.println("Cette cellule n'est pas allum�e. R�essayez.");
            } else {
                grille.matriceCellules[i - 1][j - 1].eteindreCellule();
                ArrayList<Integer> posCava = new ArrayList<>();
                posCava.add(i - 1);
                posCava.add(j - 1);
                return posCava;
            }
        }
    }

    public boolean EstCoupPossible(ArrayList<Integer> coupJoueur) {
        ArrayList<ArrayList<Integer>> coupsPossibles = grille.coupspossibles(
                grille.cavalier.getCoordonnees().get(0), // Ligne
                grille.cavalier.getCoordonnees().get(1) // Colonne
        );

        for (int i = 0;i<coupsPossibles.size();i++) {
            if (coupJoueur.get(0) == grille.cavalier.getCoordonnees().get(0) + coupsPossibles.get(i).get(0)+1 &&
            coupJoueur.get(1) == grille.cavalier.getCoordonnees().get(1) + coupsPossibles.get(i).get(1)+1) {
                return true;
            }
        }

        return false;
    }

    /**
     * initialise le lancemant de partie gere la boucle de jeu ( demande le coup
     * jouer, modifie le plateau, donne le resultat de la partie)
     */
    public void lancerPartie() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenue dans La Chevauch�e Fantastique!");
        configurerNiveauDifficulte();
        System.out.println("Grille de d�part :");
        System.out.println(grille);
        grille.cavalier.deplacer(PositionnerCava());
        System.out.println(grille);

        while (!grille.cellulesToutesEteintes()) {
            ArrayList<Integer> coup = obtenirCoupJoueur();

            if (EstCoupPossible(coup)) {
                int ligne = coup.get(0)-1;
                int colonne = coup.get(1)-1;

                if (!grille.matriceCellules[ligne][colonne].getEtat()) {
                    System.out.println("Perdu.\nLa case touch�e �tait une cellule �teinte.");
                } else {
                    coup.set(0,ligne);
                    coup.set(1,colonne);
                    grille.cavalier.deplacer(coup);
                    int lignecaval = grille.cavalier.getCoordonnees().get(0);
                    int colonnecaval = grille.cavalier.getCoordonnees().get(1);
                    grille.matriceCellules[lignecaval][colonnecaval].activerCellule();
                    System.out.println("Bravo ! Vous avez �teint une cellule.");
                    System.out.println(grille);
                }
            } else {
                System.out.println("Coup demand� impossible.\nVeuillez r�essayer.");
            }
        }

        if (grille.cellulesToutesEteintes()) {
            System.out.println("Bravo ! Vous avez �teint toutes les cellules.");
        }
    }
}
