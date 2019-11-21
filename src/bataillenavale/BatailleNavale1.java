/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bataillenavale;

import boiteajeux.Connecte;
import boiteajeux.InterfaceJeu;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author soulh
 */
public class BatailleNavale1 extends JFrame{
    protected static Connecte joueur;
    public BatailleNavale1(Connecte joueur){
        PanelFond espacement = new PanelFond();
        JPanel panel_joueur = new javax.swing.JPanel();
        JPanel panel_IA = new javax.swing.JPanel();
        JLabel label_joueur = new javax.swing.JLabel();
        JLabel label_IA = new javax.swing.JLabel();
        JButton Quitter = new javax.swing.JButton();
        Plateau_IA plateau_IA = new Plateau_IA(joueur);
        Plateau_joueur plateau_joueur = new Plateau_joueur();
        //On crée les plateaux du joueur et de l'ordinateur ici.
        this.setTitle("Bataille navale");
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.setMaximumSize(new java.awt.Dimension(1366, 768));
        this.setMinimumSize(new java.awt.Dimension(1366, 768));
        this.setPreferredSize(new java.awt.Dimension(1366, 768));
        java.awt.GridBagLayout layout = new java.awt.GridBagLayout();
        layout.columnWidths = new int[] {103, 400, 360, 400, 103};
        layout.rowHeights = new int[] {184, 400, 184};
        this.getContentPane().setLayout(layout);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(new GridBagLayout());
                javax.swing.GroupLayout panel_joueurLayout = new javax.swing.GroupLayout(panel_joueur);
        panel_joueur.setLayout(panel_joueurLayout);
        panel_joueurLayout.setHorizontalGroup(
            panel_joueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        panel_joueurLayout.setVerticalGroup(
            panel_joueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        this.getContentPane().add(panel_joueur, gridBagConstraints);
        
        javax.swing.GroupLayout panel_IALayout = new javax.swing.GroupLayout(panel_IA);
        panel_IA.setLayout(panel_IALayout);
        panel_IALayout.setHorizontalGroup(
            panel_IALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        panel_IALayout.setVerticalGroup(
            panel_IALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        this.getContentPane().add(panel_IA, gridBagConstraints);

        label_joueur.setFont(new java.awt.Font("Nirmala UI", 1, 24)); // NOI18N
        label_joueur.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_joueur.setText("Grille du joueur");
        label_joueur.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        this.getContentPane().add(label_joueur, gridBagConstraints);
        label_joueur.getAccessibleContext().setAccessibleName("Grille Joueur");

        label_IA.setFont(new java.awt.Font("Nirmala UI", 1, 24)); // NOI18N
        label_IA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_IA.setText("Grille de l'ordinateur");
        label_IA.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        label_IA.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        this.getContentPane().add(label_IA, gridBagConstraints);

        Quitter.setText("Abandonner");
        Quitter.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        Quitter.addActionListener(event -> fermer());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        
        this.getContentPane().add(Quitter, gridBagConstraints);
        
        javax.swing.GroupLayout espacementLayout = new javax.swing.GroupLayout(espacement);
        espacement.setLayout(espacementLayout);
        espacementLayout.setHorizontalGroup(
            espacementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        espacementLayout.setVerticalGroup(
            espacementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        this.getContentPane().add(espacement, gridBagConstraints);
        
        panel_joueur.add(plateau_joueur);
        panel_IA.add(plateau_IA);
        this.pack();
        this.setVisible(true);
        
    }
    
    public void fermer(){
        new InterfaceJeu(joueur);
        this.dispose();
    }
    
 
    
}
