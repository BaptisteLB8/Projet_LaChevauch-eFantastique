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
     * initialise l'etat en �teint
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
     * initialise en �teint
     *
     * @return: renvoie �teint
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
     * �teint la cellule
     *
     * @return: �teint
     */
    public void eteindreCellule() {
        etat = false;

    }

    /**
     * v�rifie si la cellule est actuellement �teint
     *
     * @return 
     * @return: renvoie l'inverse de son �tat
     */
    public boolean estEteint() {
        return !etat;
    }

    /**
     * donne l'�tat actuel de la cellule
     *
     * @return �tat
     */
    public boolean getEtat() {
        return etat;
    }

    /**
     * donne comme valeur X si elle est allum� 
     *
     * @return X si elle est allum� 
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
