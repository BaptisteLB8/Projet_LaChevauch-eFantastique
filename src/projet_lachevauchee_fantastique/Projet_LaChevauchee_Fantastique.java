/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projet_lachevauchee_fantastique;

/**
 *
 * @author bapti
 */
public class Projet_LaChevauchee_Fantastique {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // hello
        
        GrilleDeJeu nouvelle_grille = new GrilleDeJeu (5,5);
        nouvelle_grille.initialiserMatrice(5, 5, 5);
        System.out.println(nouvelle_grille);
    }
    
}
