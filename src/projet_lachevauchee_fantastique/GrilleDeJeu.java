package projet_lachevauchee_fantastique;

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

    /**
     *Permet de représente une grille de cellules lumineuses
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
    
    public boolean cellulesToutesEteintes(){
        int nb_cellules_allumes=0;
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                if (matriceCellules[i][j].estEteint()==false){
                    nb_cellules_allumes++;
                }
            }
        }
        if (nb_cellules_allumes==0){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void initialiserMatrice(int nbTours) {
        
    }
    
    public ArrayList<Integer> coupspossibles(int lignecaval, int colonnecaval,int nblignes,int nbcolonnes){
        ArrayList<Integer> listecoupspossibles = new ArrayList<Integer>();
        
    }

}
