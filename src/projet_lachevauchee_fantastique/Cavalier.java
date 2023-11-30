/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projet_lachevauchee_fantastique;

import java.util.ArrayList;

/**
 *
 * @author Utilisateur
 */
public class Cavalier {
    private ArrayList<Integer> coordonnees;

    public Cavalier(int ligne, int colonne) {
        this.coordonnees = new ArrayList<>();
        this.coordonnees.add(ligne);
        this.coordonnees.add(colonne);
    }

    public ArrayList<Integer> getCoordonnees() {
        return coordonnees;
    }

    public void deplacer(ArrayList<Integer> Positioncava) {
        this.coordonnees.set(0, Positioncava.get(0));
        this.coordonnees.set(1, Positioncava.get(1));
    }
}

