package projet_lachevauchee_fantastique;

import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Utilisateur
 */
public class GrilleDeJeu {

    CelluleLumineuse[][] matriceCellules;
    int nbLignes;
    int nbColonnes;
    static Random generateur_aleat = new Random();
    public Cavalier cavalier;

    /**
     * Permet de représente une grille de cellules lumineuses
     *
     * @param p_nbLignes
     * @param p_nbColonnes
     */
    public GrilleDeJeu(int p_nbLignes, int p_nbColonnes) {
        nbLignes = p_nbLignes;
        nbColonnes = p_nbColonnes;
        matriceCellules = new CelluleLumineuse[nbLignes][nbColonnes];

        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                matriceCellules[i][j] = new CelluleLumineuse();
            }
        }
         cavalier = new Cavalier(240, 240);
    }

    public void eteindreToutesLesCellules() {
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                matriceCellules[i][j].eteindreCellule();
            }
        }
    }

    public boolean cellulesToutesEteintes() {
        int nb_cellules_allumes = 0;
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                if (matriceCellules[i][j].estEteint() == false) {
                    nb_cellules_allumes++;
                }
            }
        }
        if (nb_cellules_allumes == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int getnbLignes() {
        return nbLignes;
    }

    public int getnbColonnes() {
        return nbColonnes;
    }

    public void initialiserMatrice(int nbTours) {
        Random nbalea = new Random();
        int nb1 = nbalea.nextInt(nbLignes);
        int nb2 = nbalea.nextInt(nbColonnes);
        matriceCellules[nb1][nb2].activerCellule();

        for (int i = 0; i < nbTours - 1; i++) {
            ArrayList<ArrayList<Integer>> Tabcoupspossibles = coupspossibles(nb1, nb2);

            ArrayList<Integer> coup_a_enlever = new ArrayList<Integer>();

            for (int j = 0; j < Tabcoupspossibles.size(); j++) {
                ArrayList<Integer> coup = Tabcoupspossibles.get(j);

                int x = nb1 + coup.get(0);
                int y = nb2 + coup.get(1);
                if (matriceCellules[x][y].getEtat()) {
                    coup_a_enlever.add(j);
                }
            }

            for (int k = coup_a_enlever.size() - 1; k >= 0; k--) {
                Tabcoupspossibles.remove((int) coup_a_enlever.get(k));
            }

            if (Tabcoupspossibles.isEmpty()) {
                // Aucun coup possible, arrêtez la boucle
                initialiserMatrice(nbTours);
            }

            int nb3 = nbalea.nextInt(Tabcoupspossibles.size());
            ArrayList<Integer> coupchoisi = Tabcoupspossibles.get(nb3);
            nb1 += coupchoisi.get(0);
            nb2 += coupchoisi.get(1);
            matriceCellules[nb1][nb2].allumer();
        }
    }

    public ArrayList<ArrayList<Integer>> coupspossibles(int lignecaval, int colonnecaval) {
        ArrayList<ArrayList<Integer>> listecoupspossibles = new ArrayList<ArrayList<Integer>>();

        if (lignecaval - 2 >= 0 && colonnecaval + 1 < nbColonnes) {
            ArrayList<Integer> a1 = new ArrayList<Integer>();
            a1.add(-2);
            a1.add(1);
            listecoupspossibles.add(a1);
        }

        if (lignecaval - 1 >= 0 && colonnecaval + 2 < nbColonnes) {
            ArrayList<Integer> a2 = new ArrayList<Integer>();
            a2.add(-1);
            a2.add(2);
            listecoupspossibles.add(a2);
        }

        if (lignecaval + 1 < nbLignes && colonnecaval + 2 < nbColonnes) {
            ArrayList<Integer> a3 = new ArrayList<Integer>();
            a3.add(1);
            a3.add(2);
            listecoupspossibles.add(a3);
        }

        if (lignecaval + 2 < nbLignes && colonnecaval + 1 < nbColonnes) {
            ArrayList<Integer> a4 = new ArrayList<Integer>();
            a4.add(2);
            a4.add(1);
            listecoupspossibles.add(a4);
        }

        if (lignecaval + 2 < nbLignes && colonnecaval - 1 >= 0) {
            ArrayList<Integer> a5 = new ArrayList<Integer>();
            a5.add(2);
            a5.add(-1);
            listecoupspossibles.add(a5);
        }

        if (lignecaval + 1 < nbLignes && colonnecaval - 2 >= 0) {
            ArrayList<Integer> a6 = new ArrayList<Integer>();
            a6.add(1);
            a6.add(-2);
            listecoupspossibles.add(a6);
        }

        if (lignecaval - 1 >= 0 && colonnecaval - 2 >= 0) {
            ArrayList<Integer> a7 = new ArrayList<Integer>();
            a7.add(-1);
            a7.add(-2);
            listecoupspossibles.add(a7);
        }

        if (lignecaval - 2 >= 0 && colonnecaval - 1 >= 0) {
            ArrayList<Integer> a8 = new ArrayList<Integer>();
            a8.add(-2);
            a8.add(-1);
            listecoupspossibles.add(a8);
        }

        return listecoupspossibles;
    }

    /**
     * Permet d'afficher la grille avec les cellules
     *
     * @return
     */
    @Override
    public String toString() {
        String chaine_a_retourner = "   |";

        for (int i = 0; i < nbColonnes; i++) {
            int t = i + 1;
            chaine_a_retourner += " " + t + " |";
        }
        chaine_a_retourner += "\n----";
        for (int j = 0; j < nbColonnes; j++) {
            chaine_a_retourner += "----";
        }

        for (int k = 0; k < nbLignes; k++) {
            int w = k + 1;
            chaine_a_retourner += "\n " + w + " |";
            for (int l = 0; l < nbColonnes; l++) {
                if (cavalier.getCoordonnees().get(0) == k && cavalier.getCoordonnees().get(1) == l) {
                    chaine_a_retourner += " C |"; // Afficher le cavalier à ses coordonnées
                } else {
                    chaine_a_retourner += " " + matriceCellules[k][l].toString() + " |";
                }
            }
            chaine_a_retourner += "\n";
            for (int m = 0; m < nbColonnes + 1; m++) {
                chaine_a_retourner += "----";
            }
        }

        return chaine_a_retourner;
    }

}
