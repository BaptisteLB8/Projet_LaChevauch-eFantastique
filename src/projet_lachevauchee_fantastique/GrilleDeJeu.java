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
    int b = 8;

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

    public void initialiserMatrice(int nbTours, int nblignes, int nbcolonnes) {
        Random nbalea = new Random(nblignes);
        int nb1 = nbalea.nextInt();
        Random nbalea2 = new Random(nbcolonnes);
        int nb2 = nbalea2.nextInt();
        matriceCellules[nb1][nb2].activerCellule();

        for (int i = 0; i < nbTours; i++) {
            ArrayList<ArrayList<Integer>> Tabcoupspossibles = coupspossibles(nb1, nb2, nblignes, nbcolonnes);
            Random nbalea3 = new Random(Tabcoupspossibles.size());
            int nb3 = nbalea3.nextInt();
            ArrayList<Integer> coupchoisi = Tabcoupspossibles.get(nb3);
            nb1 += coupchoisi.get(0);
            nb2 += coupchoisi.get(1);
            matriceCellules[nb1][nb2].activerCellule();

        }
    }

    public ArrayList<ArrayList<Integer>> coupspossibles(int lignecaval, int colonnecaval, int nblignes, int nbcolonnes) {
        ArrayList<ArrayList<Integer>> listecoupspossibles = new ArrayList<ArrayList<Integer>>();

        if (lignecaval - 2 > 0 && colonnecaval + 1 <= nbcolonnes) {
            ArrayList<Integer> a1 = new ArrayList<Integer>();
            a1.add(-2);
            a1.add(1);
            listecoupspossibles.add(a1);
        }

        if (lignecaval - 1 > 0 && colonnecaval + 2 <= nbcolonnes) {
            ArrayList<Integer> a2 = new ArrayList<Integer>();
            a2.add(-1);
            a2.add(2);
            listecoupspossibles.add(a2);
        }

        if (lignecaval + 1 <= nblignes && colonnecaval + 2 <= nbcolonnes) {
            ArrayList<Integer> a3 = new ArrayList<Integer>();
            a3.add(1);
            a3.add(2);
            listecoupspossibles.add(a3);
        }

        if (lignecaval + 2 <= nblignes && colonnecaval + 1 <= nbcolonnes) {
            ArrayList<Integer> a4 = new ArrayList<Integer>();
            a4.add(2);
            a4.add(1);
            listecoupspossibles.add(a4);
        }

        if (lignecaval + 2 <= nblignes && colonnecaval - 1 > 0) {
            ArrayList<Integer> a5 = new ArrayList<Integer>();
            a5.add(2);
            a5.add(-1);
            listecoupspossibles.add(a5);
        }

        if (lignecaval + 1 <= nblignes && colonnecaval - 2 > 0) {
            ArrayList<Integer> a6 = new ArrayList<Integer>();
            a6.add(1);
            a6.add(-2);
            listecoupspossibles.add(a6);
        }

        if (lignecaval - 1 > 0 && colonnecaval - 2 > 0) {
            ArrayList<Integer> a7 = new ArrayList<Integer>();
            a7.add(-1);
            a7.add(-2);
            listecoupspossibles.add(a7);
        }

        if (lignecaval - 2 > 0 && colonnecaval - 1 > 0) {
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
            chaine_a_retourner += " " + i + " |";
        }
        chaine_a_retourner += "\n----";
        for (int j = 0; j < nbColonnes; j++) {
            chaine_a_retourner += "----";
        }

        for (int k = 0; k < nbLignes; k++) {
            chaine_a_retourner += "\n " + k + " |";
            for (int l = 0; l < nbColonnes; l++) {
                chaine_a_retourner += " " + matriceCellules[k][l].toString() + " |";
            }
            chaine_a_retourner += "\n";
            for (int m = 0; m < nbColonnes + 1; m++) {
                chaine_a_retourner += "----";
            }
        }

        return chaine_a_retourner;
    }

}
