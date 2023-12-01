package projet_lachevauchee_fantastique_graphique;

import projet_lachevauchee_fantastique.GrilleDeJeu;
import projet_lachevauchee_fantastique.Partie;
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
       int nbLigne ;
        int nbColonne ; 
        int i;
        int j;
        boolean partieterminee = false;
       
      
    /**
     * Creates new form FenetrePrincipale
     */
    public FenetrePrincipale(int nbLignes, int nbColonnes, int nbTours ) {
      initComponents();  
      nbColonne=nbColonnes;
      nbLigne=nbLignes;
      this.setLocationRelativeTo(null);
      this.setExtendedState(JFrame.MAXIMIZED_BOTH);
     
        
        this.grille = new GrilleDeJeu(nbLignes,nbColonnes);
     //   getContentPane().add(PanneauGrille, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20,
     //   nbColonnes*40, nbLignes*40));
     //   this.pack();
     //   this.revalidate();
         
        
         PanneauGrille.setLayout(new GridLayout(nbLignes, nbColonnes));
         
         
         
         for (int i=0; i < nbLignes; i++) {
         for (int j=0; j < nbColonnes; j++ ) {
         CelluleGraphique bouton_cellule = new CelluleGraphique( grille.matriceCellules[i][j], 35,35);
         PanneauGrille.add(bouton_cellule); // ajout au Jpanel PanneauGrille
         
         
         this.setVisible(true);
         
 }
         
}
       
  
   //  getContentPane().add(PanneauBoutonsVerticaux, new
    //org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 1 * 40, nbLignes * 40));
    // this.pack();
    // this.revalidate();
    
     
  //   getContentPane().add(PanneauBoutonsHorizontaux, new
  //  org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, nbColonnes * 40, 1 * 40));
   //  this.pack();
    // this.revalidate();
        
    

     // création du panneau de boutons verticaux (pour les lignes)
 for (i = 0; i < nbLignes; i++) {
 
 ActionListener ecouteurClick = new ActionListener() {
    final int j = i;
 @Override

 public void actionPerformed(ActionEvent e) {



if(nbTours==nbTours){
    PageDefaite d = new PageDefaite();
    d.setVisible(true);
    FenetrePrincipale.this.dispose();
            
 }

if(grille.cellulesToutesEteintes()==true){
      PageVictoire f = new PageVictoire();
      f.setVisible(true);
     FenetrePrincipale.this.dispose();
     
  }
}

    


    
 
 };
 



 }

 
        


     // création du panneau de boutons verticaux (pour les lignes)
 for (j = 0; j < nbColonnes; j++) {
 JButton bouton_colonne = new JButton(""+j);
 ActionListener ecouteurClick = new ActionListener() {
    final int i= j;
 @Override
 
 public void actionPerformed(ActionEvent e) {


if(nbTours==nbTours){
    PageDefaite d = new PageDefaite();
    d.setVisible(true);
    FenetrePrincipale.this.dispose();
 }    
 
if(grille.cellulesToutesEteintes()==true){
      PageVictoire f = new PageVictoire();
      f.setVisible(true);
      FenetrePrincipale.this.dispose();
     
     
  }


 }

 };
 
 }


 
    }
public void initialiserPartie() {
 grille.eteindreToutesLesCellules();
 
 
 }
public void AfficherMessage(){
     if(grille.cellulesToutesEteintes()) {
         PageVictoire f = new PageVictoire() ;
          f.setVisible(true) ;
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

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
        getContentPane().add(PanneauGrille, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 440, 450));

        jButton1.setText("Quitter le jeu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 290, -1, -1));

        jButton2.setText("Recommencer");
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 180, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegleActionPerformed
        Regles f = new Regles();
        f.setVisible(true);
        ;
    }//GEN-LAST:event_RegleActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanneauGrille;
    private javax.swing.JButton Regle;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    // End of variables declaration//GEN-END:variables
 
}
