/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boiteajeux;

import static boiteajeux.Serialisation.ecriture;
import static boiteajeux.Serialisation.lecture;
import java.awt.Graphics;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bryancurt
 */
public class InterfaceEnregistrement extends javax.swing.JFrame {

    /**
     * Creates new form InterfaceEnregistrement
     */
    public InterfaceEnregistrement() {
        initComponents();
        this.setLocationRelativeTo(null);
        jLabelErreurMDP.setVisible(false);
        jLabelErreurPseudoDejaPris.setVisible(false);
        jLabelErreurPseudo.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1Valider = new javax.swing.JButton();
        jLabelErreurMDP = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPasswordField = new javax.swing.JPasswordField();
        jLabelErreurPseudo = new javax.swing.JLabel();
        jLabelErreurPseudoDejaPris = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        retourButton = new javax.swing.JButton();
        jTextFieldPseudo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(24, 31, 61));
        jPanel1.setForeground(new java.awt.Color(24, 31, 61));

        jButton1Valider.setText("Valider");
        jButton1Valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ValiderActionPerformed(evt);
            }
        });

        jLabelErreurMDP.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabelErreurMDP.setForeground(new java.awt.Color(255, 0, 0));
        jLabelErreurMDP.setText("Le mot de passe doit être entre 7 et 30 caractères");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Mot de passe");

        jLabelErreurPseudo.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabelErreurPseudo.setForeground(new java.awt.Color(255, 0, 0));
        jLabelErreurPseudo.setText("Pseudo invalide");

        jLabelErreurPseudoDejaPris.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabelErreurPseudoDejaPris.setForeground(new java.awt.Color(255, 0, 0));
        jLabelErreurPseudoDejaPris.setText("Le pseudo est déjà pris");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Pseudo");

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Création de compte");

        retourButton.setText("retour");
        retourButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retourButtonActionPerformed(evt);
            }
        });

        jTextFieldPseudo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPseudoActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/boiteajeux/gamepad.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(237, 237, 237)
                .addComponent(jButton1Valider)
                .addGap(138, 138, 138)
                .addComponent(jLabel6)
                .addGap(0, 33, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(retourButton)
                .addGap(38, 38, 38))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(jLabelErreurPseudo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelErreurPseudoDejaPris))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(jLabel2))
                                    .addComponent(jLabel3))
                                .addGap(75, 75, 75)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldPseudo, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jLabelErreurMDP)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(37, 37, 37)
                    .addComponent(jLabel1)
                    .addContainerGap(440, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(retourButton)
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelErreurPseudo)
                    .addComponent(jLabelErreurPseudoDejaPris))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldPseudo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addComponent(jLabelErreurMDP)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1Valider)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(51, 51, 51))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(47, 47, 47)
                    .addComponent(jLabel1)
                    .addContainerGap(437, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldPseudoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPseudoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPseudoActionPerformed

    private void jButton1ValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ValiderActionPerformed
        Annuaire annuaire = sauvegardeAnnuaire();

        String pseudo = jTextFieldPseudo.getText(); //Récupère la valeur du champ pseudo
        String motDePasse = jPasswordField.getText(); //récupère la valeur du mot de passe

        if (estPseudoValide(annuaire, pseudo) && estMotDePasseValide(motDePasse)) { //si le pseudo et le mot de passe sont valides:
            try {
                creationNouveauCompte(annuaire, pseudo, motDePasse); //on créé un nouveau compte
                new InterfaceDeConnexion().setVisible(true);  //le nouveau compte est créé on peut directement aller se connecter
                dispose();
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(InterfaceEnregistrement.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ValiderActionPerformed

    private void retourButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retourButtonActionPerformed
        new Interface1().setVisible(true); //bouton de retour en arrière
        dispose();
    }//GEN-LAST:event_retourButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfaceEnregistrement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceEnregistrement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceEnregistrement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceEnregistrement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceEnregistrement().setVisible(true);
            }
        });
    }

    //créé un nouveau compte
    public static void creationNouveauCompte(Annuaire annuaire, String pseudo, String motDePasse) throws NoSuchAlgorithmException {        
        annuaire.ajouterUtilisateur(new Connecte(pseudo, encoderMotDePasse(motDePasse),0,0,0,0));
        ecriture(annuaire.getListe());
    }

    //Renvoie true si le mot de passe est valide, false si le mot de passe n'est pas valide
    public static boolean estMotDePasseValide(String motDePasse) {
        boolean estValide = false;
        // Un mot de passe contient de 7 à 30 caractères
        estValide = (motDePasse != null) && motDePasse.length() >= 7 && motDePasse.length() <= 30;

        if (!estValide) {
            jLabelErreurMDP.setVisible(true);
             }

        return estValide;
    }

    //renvoie true si le pseudo est valide, false si le pseudo n'est pas valide
    public static boolean estPseudoValide(Annuaire annuaire, String pseudo) {
        boolean estValide = false;
        char c;

        // Un pseudo contient de 4 à 30 caractères
        estValide = (pseudo != null) && pseudo.length() >= 4 && pseudo.length() <= 30;

        // Un pseudo se limite aux caractères A-Za-z0-9
        if (estValide) {

            for (int i = 0; i < pseudo.length(); i++) {
                c = pseudo.charAt(i);
                estValide = (c >= '0' && c <= '9')
                        || (c >= 'A' && c <= 'Z')
                        || (c >= 'a' && c <= 'z');
            }
        }

        // Un pseudo doit commencer par une lettre
        if (estValide) {
            c = pseudo.charAt(0);
            estValide = (c >= 'A');
            
        }

        if (!estValide) {
            jLabelErreurPseudo.setVisible(true);
            
        }
        if (!annuaire.estPseudoDejaPris(pseudo)) {
            estValide = false;
            jLabelErreurPseudoDejaPris.setVisible(true);
        }

        return estValide;
    }

    //convertit une arraylist en objet annuaire
    public static Annuaire sauvegardeAnnuaire() {
        Annuaire annuaire = new Annuaire();
        ArrayList<Connecte> liste = lecture();
        for (int i = 0; i < liste.size(); i++) {
            annuaire.ajouterUtilisateur(liste.get(i));
        }
        return annuaire;
    }
    
    //encode le mot de passe en utilisant l'encodage SHA-246
    public static String encoderMotDePasse(String mdp) throws NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(mdp.getBytes());

        byte byteData[] = md.digest();

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }

        return (sb.toString());
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1Valider;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private static javax.swing.JLabel jLabelErreurMDP;
    private static javax.swing.JLabel jLabelErreurPseudo;
    private static javax.swing.JLabel jLabelErreurPseudoDejaPris;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JTextField jTextFieldPseudo;
    private javax.swing.JButton retourButton;
    // End of variables declaration//GEN-END:variables
}
