/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bataillenavale;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Utilisateur
 */
public class Plateau_joueur extends JPanel {
    protected static ArrayList<Bateau> lesBateaux = new ArrayList<>(); //Liste des bateaux du joueur.
    private static final int SIZE = 10; // nombre de lignes et colonnes
    protected static Case[][] lesCases; // un tableau pour ranger toutes les cases de la grille, leur état et les bateaux en leur sein.
    protected static int place = -1;//variable de placement utilisée dans un switch. Lorsqu'elle arrive à 4, on passe au jeu.
    Random rand = new Random();

    public Plateau_joueur() {
        //Sur toute cette section, création des cases de la bataille navale.
        //Elles sont ajoutées au plateau du joueur : grille de 10x10.
        final Icon grillevideicon = new ImageIcon("case_vide.jpg");
        lesCases = new Case[SIZE][SIZE];
        this.setVisible(true);
        this.setSize(400, 400);
        this.setLayout(new GridLayout(SIZE, SIZE));
        this.revalidate();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int x = i;
                int y = j;
                lesCases[i][j] = new Case(i, j);
                lesCases[i][j].setEtats(Etats.MER);//Toutes les cases sont initialisées à un état de mer.
                lesCases[i][j].setIcon(grillevideicon);//On attribue une icone, initialisée plus haut. Les images sont fournies dans le package.
                lesCases[i][j].addActionListener(event -> caseClick(lesCases[x][y]));
                lesCases[i][j].setSize(40,40);
                lesCases[i][j].setBorderPainted(true);
                lesCases[i][j].setVisible(true);
                this.add(lesCases[i][j]);//Ajout de la grille de cases au JPanel
            }
        }
        //création de la vue des cases
    }

    //Méthode de placement des bateaux.
    //Test divers : un pour vérifier que la grille est assez grande pour contenir le bateau
    //L'autre pour vérifier qu'il n'y a pas de bateaux sur le chemin du placement.
    private void placerBateaux(JButton button, int x, int y) {
        JOptionPane msgerreur = new JOptionPane();
        JOptionPane début = new JOptionPane();
        JOptionPane jouer = new JOptionPane();
        JOptionPane choix = new JOptionPane();
        String lesTextes[] ={"Horizontalement","Verticalement","Ailleurs"};
        switch (place) {
            case -1:
                début.showMessageDialog(null, "Bienvenue dans notre bataille navale. Commencez par placer vos bateaux sur la grille de gauche.", "Bataille navale", JOptionPane.INFORMATION_MESSAGE);
                place = 0;
            case 0:
                int horiz = choix.showOptionDialog(this, "Comment voulez vous placer votre bateau ?", "Bataille navale", 0,JOptionPane.INFORMATION_MESSAGE, null, lesTextes, lesTextes[0]);//Variable de d'orientation de bateau. Si horiz==0, on place horizontalement.
                //Si horiz==1, on place verticalement.
                if (horiz == 0) {
                    Bateau2 b2 = new Bateau2();
                    int cpt2 = 0;//Variable qui sert à vérifier que le bateau ne va pas se superposer sur un autre.
                    for (int i = 0; i < 2; i++) {
                        if ((y + b2.taille - 1 < 10)) {
                            if (lesCases[x][y + i].getEtat() == Etats.MER) { //Test de superposition.
                                cpt2++;
                            }
                        }
                    }
                    System.out.println(cpt2);
                    //Ici on vérifie les deux conditions : le bateau peut rentrer dans la grille ET ne se superposera pas.
                    if ((y + b2.taille - 1 < 10) && (cpt2 == 2)) {
                        for (int i = 0; i < 2; i++) {
                            placer(lesCases, x, y + i, b2);
                            lesBateaux.add(b2);
                            place = 1;
                            System.out.println(place);
                        }
                    } else {
                        //Dans le cas où une de ces conditions n'est pas vérifiée, on retourne ce message d'erreur, et on attend un nouveau clic.
                        //Le nouveau clic effectuera repassera par le même case du switch, la variable de placement n'ayant pas été incrémentée.
                        msgerreur.showMessageDialog(null, "Le bateau ne rentre pas en longueur, ou chevauche un autre bateau. Veuillez le replacer.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    }
                } else if (horiz == 1) {
                    Bateau2 b2 = new Bateau2();
                    int cpt2 = 0;
                    for (int i = 0; i < 2; i++) {
                        if ((x + b2.taille - 1 < 10)) {
                            if (lesCases[x + i][y].getEtat() == Etats.MER) {
                                cpt2++;
                            }
                        }
                    }
                    if ((x + b2.taille - 1 < 10) && (cpt2 == 2)) {
                        for (int i = 0; i < 2; i++) {
                            placer(lesCases, x + i, y, b2);
                            lesBateaux.add(b2);
                            place = 1;
                        }
                    } else {
                        msgerreur.showMessageDialog(null, "Le bateau ne rentre pas en longueur, ou chevauche un autre bateau. Veuillez le replacer.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    }
                }
                break;
            case 1:
                int horiz3 = choix.showOptionDialog(this, "Comment voulez vous placer votre bateau ?", "Bataille navale", 0,JOptionPane.INFORMATION_MESSAGE, null, lesTextes, lesTextes[0]);
                if (horiz3 == 0) {
                    Bateau3 b3 = new Bateau3();
                    int cpt3 = 0;
                    if ((y + b3.taille - 1 < 10)) {
                        for (int i = 0; i < 3; i++) {
                            if (lesCases[x][y + i].getEtat() == Etats.MER) {
                                cpt3++;
                            }
                        }
                    }
                    if ((y + b3.taille - 1 < 10) && (cpt3 == 3)) {
                        for (int i = 0; i < 3; i++) {
                            placer(lesCases, x, y + i, b3);
                            lesBateaux.add(b3);
                            place = 2;
                        }
                    } else {
                        msgerreur.showMessageDialog(null, "Le bateau ne rentre pas en longueur, ou chevauche un autre bateau. Veuillez le replacer.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    }
                } else if (horiz3 == 1) {
                    Bateau3 b3 = new Bateau3();
                    int cpt3 = 0;
                    if ((x + b3.taille - 1 < 10)) {
                        for (int i = 0; i < 3; i++) {
                            if (lesCases[x + i][y].getEtat() == Etats.MER) {
                                cpt3++;
                            }
                        }
                    }
                    if ((x + b3.taille - 1 < 10) && (cpt3 == 3)) {
                        for (int i = 0; i < 3; i++) {
                            placer(lesCases, x + i, y, b3);
                            lesBateaux.add(b3);
                            place = 2;
                        }
                    } else {
                        msgerreur.showMessageDialog(null, "Le bateau ne rentre pas en longueur, ou chevauche un autre bateau. Veuillez le replacer.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    }
                }
                break;
            case 2:
                int horiz4 = choix.showOptionDialog(this, "Comment voulez vous placer votre bateau ?", "Bataille navale", 0,JOptionPane.INFORMATION_MESSAGE, null, lesTextes, lesTextes[0]);
                if (horiz4 == 0) {
                    Bateau4 b4 = new Bateau4();
                    int cpt4 = 0;
                    if ((y + b4.taille - 1 < 10)) {
                        for (int i = 0; i < 4; i++) {
                            if (lesCases[x][y + i].getEtat() == Etats.MER) {
                                cpt4++;
                            }
                        }
                    }
                    if ((y + b4.taille - 1 < 10) && (cpt4 == 4)) {
                        for (int i = 0; i < 4; i++) {
                            placer(lesCases, x, y + i, b4);
                            lesBateaux.add(b4);
                            place = 3;
                        }
                    } else {
                        msgerreur.showMessageDialog(null, "Le bateau ne rentre pas en longueur, ou chevauche un autre bateau. Veuillez le replacer.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    }
                } else if (horiz4 == 1) {
                    Bateau4 b4 = new Bateau4();
                    int cpt4 = 0;
                    if ((x + b4.taille - 1 < 10)) {
                        for (int i = 0; i < 4; i++) {
                            if (lesCases[x + i][y].getEtat() == Etats.MER) {
                                cpt4++;
                            }
                        }
                    }
                    if ((x + b4.taille - 1 < 10) && (cpt4 == 4)) {
                        for (int i = 0; i < 4; i++) {
                            placer(lesCases, x + i, y, b4);
                            lesBateaux.add(b4);
                            place = 3;
                        }
                    } else {
                        msgerreur.showMessageDialog(null, "Le bateau ne rentre pas en longueur, ou chevauche un autre bateau. Veuillez le replacer.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    }
                }
                break;
            case 3:
                int horiz5 = choix.showOptionDialog(this, "Comment voulez vous placer votre bateau ?", "Bataille navale", 0,JOptionPane.INFORMATION_MESSAGE, null, lesTextes, lesTextes[0]);
                if (horiz5 == 0) {
                    Bateau5 b5 = new Bateau5();
                    int cpt5 = 0;
                    if ((y + b5.taille - 1 < 10)) {
                        for (int i = 0; i < 5; i++) {
                            if (lesCases[x][y + i].getEtat() == Etats.MER) {
                                cpt5++;
                            }
                        }
                    }
                    if ((y + b5.taille - 1 < 10) && (cpt5 == 5)) {
                        for (int i = 0; i < 5; i++) {
                            placer(lesCases, x, y + i, b5);
                            lesBateaux.add(b5);

                        }
                        place = 4;
                    } else {
                        msgerreur.showMessageDialog(null, "Le bateau ne rentre pas en longueur, ou chevauche un autre bateau. Veuillez le replacer.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    }
                } else if (horiz5 == 1) {
                    Bateau5 b5 = new Bateau5();
                    int cpt5 = 0;
                    if ((x + b5.taille - 1 < 10)) {
                        for (int i = 0; i < 5; i++) {
                            if (lesCases[x + i][y].getEtat() == Etats.MER) {
                                cpt5++;
                            }
                        }
                    }
                    if ((x + b5.taille - 1 < 10) && (cpt5 == 5)) {
                        for (int i = 0; i < 5; i++) {
                            placer(lesCases, x + i, y, b5);
                            lesBateaux.add(b5);
                            for (int k = 0; k < 10; k++) {
                                for (int j = 0; j < 10; j++) {
                                    lesCases[i][j].setEnabled(false);
                                }
                            }
                        }

                        place = 4;
                    } else {
                        msgerreur.showMessageDialog(null, "Le bateau ne rentre pas en longueur, ou chevauche un autre bateau. Veuillez le replacer.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    }
                }
                break;
        }
        if (place == 4) {
            //Ici, on rend les cases du joueur non cliquables pendant le jeu, n'étant plus utiles.
            //On définit leur image quand elles sont désactivées afin d'avoir un meilleur rendu esthétique.
            //Par contre, on active celle de l'IA, pour pouvoir effectuer les phases de tir.
            for (int k = 0; k < 10; k++) {
                for (int j = 0; j < 10; j++) {
                    lesCases[k][j].setEnabled(false);
                    Plateau_IA.getGrille()[k][j].setEnabled(true);
                    if (lesCases[k][j].getEtat() == Etats.MER) {
                        lesCases[k][j].setDisabledIcon(new ImageIcon("case_vide.jpg"));
                    }
                }
            }
            //Mesage indicatif.
            jouer.showMessageDialog(null, "Maintenant, jouez en cliquant sur la grille de droite.", "Bataille Navale", JOptionPane.INFORMATION_MESSAGE);
        }

    }
    //Getter de la grille.
    public static Case[][] getGrille() {
        return lesCases;
    }
    //Getter de la liste des bateaux.
    public static ArrayList<Bateau> getBateaux() {
        return lesBateaux;
    }
    //Reinitialisation de la valeur de placement. Utile pour la modifier depuis le plateau_IA.
    public static void setPlaceZero() {
        place = 0;
    }

    //Méthode pour simplifier la méthode PlacerBateau.
    public void placer(Case[][] grille, int x, int y, Bateau bateau) {
        grille[x][y].setBateau(bateau);
        grille[x][y].setDisabledIcon(new ImageIcon("case_bateau.jpg"));
        grille[x][y].setEtats(Etats.BATEAU);
        grille[x][y].setEnabled(false);
    }

    //Ici, c'est les interactions qui ont lieu lorsqu'on clique sur une case.
    //En réalite, cela sera modifié pour avoir un comportement sur l'autre plateau
    //(le joueur clique sur le plateau de l'IA pour attaquer, pas le sien).
    private void caseClick(Case casecliquee) {
        if (place < 5) {
            placerBateaux(casecliquee, casecliquee.X, casecliquee.Y);
        }
    }
}
