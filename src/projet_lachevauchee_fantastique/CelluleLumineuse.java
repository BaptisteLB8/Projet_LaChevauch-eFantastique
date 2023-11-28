/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projet_lachevauchee_fantastique;

/**
 *
 * @author Utilisateur
 */
public class CelluleLumineuse {

    private boolean etat;

    /**
     * initialise l'etat en éteint
     */
    public CelluleLumineuse() {
        etat = false;
    }

    /**
     * initialise en allumer
     */
    public void allumer() {
        etat = true;
    }

    /**
     * initialise en éteint
     *
     * @return: renvoie éteint
     */
    public void eteindre() {
        etat = false;
    }

    /**
     * active la cellule lumineuse en inversant son etat
     *
     * @return: renvoie l'inverse de son etat
     */
    public void activerCellule() {
        etat = !etat;
    }

    /**
     * éteint la cellule
     *
     * @return: éteint
     */
    public void eteindreCellule() {
        etat = false;

    }

    /**
     * vérifie si la cellule est actuellement éteint
     *
     * @return 
     * @return: renvoie l'inverse de son état
     */
    public boolean estEteint() {
        return !etat;
    }

    /**
     * donne l'état actuel de la cellule
     *
     * @return état
     */
    public boolean getEtat() {
        return etat;
    }

    /**
     * donne comme valeur X si elle est allumé 
     *
     * @return X si elle est allumé 
     */
    @Override
    public String toString() {
        if (etat) {
            return "X";
    }
        else{
            return "O";
        }
    }
}
