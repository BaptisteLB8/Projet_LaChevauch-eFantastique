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
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author bapti
 */
public class CelluleGraphique extends JButton {

    int largeur; // largeur en pixel de la cellule
    int hauteur; // hauteur en pixel de la cellule
    CelluleLumineuse celluleLumineuseAssociee;
    // constructeur (appel� depuis FenetrePrincipale)
    
 


    public CelluleGraphique(CelluleLumineuse celluleLumineuseAssociee, int largeur, int hauteur) {
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.celluleLumineuseAssociee = celluleLumineuseAssociee;

        // D�finir la taille du bouton
        setPreferredSize(new Dimension(largeur, hauteur));

        // D�sactiver le rendu par d�faut des boutons pour dessiner notre propre contenu
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);

        // Ajouter un �couteur d'�v�nements pour le clic sur le bouton
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Inverser l'�tat de la celluleLumineuseAssociee
                celluleLumineuseAssociee.activerCellule();

                // Redessiner le bouton pour refl�ter le nouvel �tat
                repaint();
                
                
            }
        });
        if(celluleLumineuseAssociee.estEteint()){
                    setEnabled(false);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        int w = getWidth();
        int h = getHeight();

        if (celluleLumineuseAssociee.estEteint()) {
            g.setColor(Color.red);
            
        } else {
            g.setColor(Color.orange);
        }

        // Dessiner un cercle au lieu d'un ovale
        g.fillRect(0, 0, w, h);

        // Appeler la m�thode paintComponent du parent pour le rendu du bouton
        super.paintComponent(g);
    }
    
}
