/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projet_lachevauchee_fantastique_graphique;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JButton;
import projet_lachevauchee_fantastique.CelluleLumineuse;
import projet_lachevauchee_fantastique.CelluleLumineuse;

/**
 *
 * @author bapti
 */
public class CelluleGraphique extends JButton {
 int largeur; // largeur en pixel de la cellule
 int hauteur; // hauteur en pixel de la cellule
 CelluleLumineuse celluleLumineuseAssociee;
 // constructeur (appelé depuis FenetrePrincipale)
 public CelluleGraphique(CelluleLumineuse celluleLumineuseAssociee, int largeur,
int hauteur) {
 this.largeur = largeur;
 this.hauteur = hauteur;
 this.celluleLumineuseAssociee = celluleLumineuseAssociee;
 }

 @Override
  protected void paintComponent(Graphics g) {
 int w = this.getWidth();
 int h = this.getHeight();
 if (celluleLumineuseAssociee.estEteint() == true) {
 g.setColor(Color.red);
 } else {
 g.setColor(Color.orange);
 }
 g.fillOval(2, 2, w - 4, h - 4);
 }

}

