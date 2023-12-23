package projet_lachevauchee_fantastique_graphique;

import projet_lachevauchee_fantastique.*;
import projet_lachevauchee_fantastique_graphique.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.*;
import javax.swing.Timer;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.LayoutStyle;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author bapti
 */
public class FenetrePrincipale extends javax.swing.JFrame {

    GrilleDeJeu grille;

    int nbTours;
    int nbLigne;
    int nbColonne;
    int i;
    int j;
    boolean partieterminee = false;
    private Timer timer;
    private int secondsRemaining;
    private JLabel timerLabel;

    /**
     * Creates new form FenetrePrincipale
     */
    public FenetrePrincipale(int nbLignes, int nbColonnes, int nbTours, int seconde) {
        initComponents();
        nbColonne = nbColonnes;
        nbLigne = nbLignes;
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        this.grille = new GrilleDeJeu(nbLignes, nbColonnes);
  

        PanneauGrille.setLayout(new GridLayout(nbLignes, nbColonnes));
        grille.initialiserMatrice(nbTours);
        for (int i = 0; i < nbLigne; i++) {
            for (int j = 0; j < nbColonne; j++) {
                CelluleGraphique bouton_cellule = new CelluleGraphique(grille.matriceCellules[i][j], 35, 35);
                PanneauGrille.add(bouton_cellule); // ajout au Jpanel PanneauGrille

                this.setVisible(true);

            }

        }

        for (i = 0; i < nbLignes; i++) {

            ActionListener ecouteurClick = new ActionListener() {
                final int j = i;

                @Override

                public void actionPerformed(ActionEvent e) {
                    if (grille.cellulesToutesEteintes() == true) {
                        timer.stop();
                        PageVictoire f = new PageVictoire();
                        f.setVisible(true);
                        FenetrePrincipale.this.dispose();

                    }
                }

            };

        }

// Initialisation du compte à rebours
        secondsRemaining = seconde;
        timerLabel = new JLabel("Time: " + secondsRemaining);

        ActionListener timerAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                secondsRemaining--;
                timerLabel.setText("Time: " + secondsRemaining);

                // Vérifier si le temps est écoulé
                if (secondsRemaining <= 0) {
                    timer.stop();// arrete le timer
                    JOptionPane.showMessageDialog(FenetrePrincipale.this, "Time's up!");// affcihe une fenetre pour dire que le temps est dépassé
                    PageDefaite f = new PageDefaite();// crée la page défaite 
                    f.setVisible(true);// affiche la page défaite 
                    FenetrePrincipale.this.dispose();// suprime la fenetre principale
                }

            }
        };

        timer = new Timer(1000, timerAction);
        timer.start();
        getContentPane().add(timerLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 430, 360, 30));// Ajout du label du compte à rebours à la fenêtre
    }

    public void AfficherMessage() {
        if (grille.cellulesToutesEteintes()) {
            PageVictoire f = new PageVictoire();
            f.setVisible(true);
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PageAcceuil().setVisible(true);
            }
        });
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
        Recommencer = new javax.swing.JButton();
        NiveauTermine = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 255, 102));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Regle.setText("Regles");
        Regle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegleActionPerformed(evt);
            }
        });
        getContentPane().add(Regle, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 100, -1, -1));

        PanneauGrille.setPreferredSize(new java.awt.Dimension(360, 360));
        getContentPane().add(PanneauGrille, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, -1, -1));

        Recommencer.setText("Recommencer");
        Recommencer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RecommencerActionPerformed(evt);
            }
        });
        getContentPane().add(Recommencer, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 290, -1, -1));

        NiveauTermine.setText("Niveau Terminé");
        NiveauTermine.setActionCommand("Recommencer");
        NiveauTermine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NiveauTermineActionPerformed(evt);
            }
        });
        getContentPane().add(NiveauTermine, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 190, -1, -1));
        NiveauTermine.getAccessibleContext().setAccessibleName("Recommencer");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegleActionPerformed
        Regles f = new Regles();
        f.setVisible(true);
        ;
    }//GEN-LAST:event_RegleActionPerformed

    private void RecommencerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RecommencerActionPerformed
PageDefaite f = new PageDefaite();
f.setVisible(true);
this.dispose();
    }//GEN-LAST:event_RecommencerActionPerformed

    private void NiveauTermineActionPerformed(java.awt.event.ActionEvent evt){
    if (grille.cellulesToutesEteintes()){
        PageVictoire f = new PageVictoire();
        f.setVisible(true);
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton NiveauTermine;
    private javax.swing.JPanel PanneauGrille;
    private javax.swing.JButton Recommencer;
    private javax.swing.JButton Regle;
    // End of variables declaration//GEN-END:variables

}
