package projet_lachevauchee_fantastique_graphique;

import projet_lachevauchee_fantastique.GrilleDeJeu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.*;
import javax.swing.Timer;
import javax.swing.JLabel;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author bapti
 */
public class FenetrePrincipale extends javax.swing.JFrame {

    public FenetrePrincipale() {
        initComponents();
        int nbLignes = 10;
        int nbColonnes = 10;
        PanneauGrille.setLayout(new GridLayout(nbLignes, nbColonnes));
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                JButton bouton_cellule = new JButton(); // création d'un bouton
                PanneauGrille.add(bouton_cellule); // ajout au Jpanel PanneauGrille
            }
        }

    }

    /**
     * Méthode appelée lorsqu'un bouton "Regles" est cliqué. Affiche une fenêtre
     * de règles.
     *
     * @param evt L'événement associé au clic sur le bouton "Rules".
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Regle = new javax.swing.JButton();
        PanneauGrille = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 255, 102));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Regle.setText("Regles");
        Regle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegleActionPerformed(evt);
            }
        });
        getContentPane().add(Regle, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 150, -1, -1));

        PanneauGrille.setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().add(PanneauGrille, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 320, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegleActionPerformed
        Regles f = new Regles();
        f.setVisible(true);
    }//GEN-LAST:event_RegleActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanneauGrille;
    private javax.swing.JButton Regle;
    // End of variables declaration//GEN-END:variables
}
