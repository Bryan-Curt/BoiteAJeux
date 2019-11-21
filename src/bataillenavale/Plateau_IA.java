/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bataillenavale;

import static bataillenavale.BatailleNavale1.joueur;
import boiteajeux.Connecte;
import boiteajeux.InterfaceJeu;
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
 * @author soulh
 */
public class Plateau_IA extends JPanel {

    protected ArrayList<Bateau> lesBateaux = new ArrayList<>();
    private static final int SIZE = 10; // nombre de lignes et colonnes
    protected static Case[][] lesCases; // un tableau pour ranger toutes les cases de la grille, leur état et les bateaux en leur sein.
    private boolean placement = true;
    protected int place = 0;
    Random rand = new Random();
    protected int cpt2 = 0;
    protected int cpt3 = 0;
    protected int cpt4 = 0;
    protected int cpt5 = 0;
    protected int X = rand.nextInt(10);
    protected int Y = rand.nextInt(10);
    protected Connecte joueur;

    //Création des cases qui sont ajoutées au plateau de l'IA.
    //Similaire au plateau du joueur.
    public Plateau_IA(Connecte joueur) {
        this.joueur=joueur;
        //Sur toute cette section, création des cases de la bataille navale.
        //Elles sont ajoutées au plateau du joueur : grille de 10x10.
        //Génération identique à celle de plateau_joueur.
        final Icon grillevideicon = new ImageIcon("case_vide.jpg");
        lesCases = new Case[SIZE][SIZE];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int x = i;
                int y = j;
                lesCases[i][j] = new Case(i, j);
                lesCases[i][j].setEtats(Etats.MER);
                lesCases[i][j].setIcon(grillevideicon);
                lesCases[i][j].setEnabled(false);
                lesCases[i][j].addActionListener(event -> caseClick(lesCases[x][y]));
                this.add(lesCases[i][j]);
                this.repaint();
            }
        }
        // création de la vue des cases
        this.setVisible(true);
        this.setSize(400, 400);
        this.setLayout(new GridLayout(SIZE, SIZE));
    }

    //Méthode de placement des bateaux.
    //Test divers : un pour vérifier que la grille est assez grande pour contenir le bateau
    //L'autre pour vérifier qu'il n'y a pas de bateaux sur le chemin du placement.
    //La méthode fonctionne d'une manière commune à celle du Plateau_joueur.
    //Seule différence : on ne récupère pas les coordonnées d'une case, mais on génère deux coordonnées X et Y aléatoires.
    protected void placerBateaux(JButton button, int x, int y) {
        x = Y;
        y = Y;
        
        switch (place) {
            case 0:
                int horiz2 = rand.nextInt(2);
                if (horiz2 == 0) {
                    Bateau2 b2 = new Bateau2();
                    if (y + b2.taille - 1 < 10) {
                        for (int i = 0; i < 2; i++) {
                            if (lesCases[x][y + i].getEtat() == Etats.MER) {
                                cpt2++;
                            }
                        }
                        if (cpt2 == 2) {
                            for (int i = 0; i < 2; i++) {
                                placer(lesCases, x, y + i, b2);
                                lesBateaux.add(b2);
                                place = 1;
                                X = rand.nextInt(10);
                                Y = rand.nextInt(10);
                            }
                        } else {
                            cpt2 = 0;
                            X = rand.nextInt(10);
                            Y = rand.nextInt(10);
                        }
                    } else {
                        X = rand.nextInt(10);
                        Y = rand.nextInt(10);
                    }
                } else if (horiz2 == 1) {
                    Bateau2 b2 = new Bateau2();
                    if (x + b2.taille - 1 < 10) {
                        for (int i = 0; i < 2; i++) {
                            if (lesCases[x + i][y].getEtat() == Etats.MER) {
                                cpt2++;
                            }
                        }
                        if (cpt2 == 2) {
                            for (int i = 0; i < 2; i++) {
                                placer(lesCases, x + i, y, b2);
                                lesBateaux.add(b2);
                                place = 1;
                                X = rand.nextInt(10);
                                Y = rand.nextInt(10);
                            }
                        } else {
                            cpt2 = 0;
                            X = rand.nextInt(10);
                            Y = rand.nextInt(10);
                        }
                    } else {
                        X = rand.nextInt(10);
                        Y = rand.nextInt(10);
                    }
                }
                break;
            case 1:
                int horiz3 = rand.nextInt(2);
                if (horiz3 == 0) {
                    Bateau3 b3 = new Bateau3();
                    if (y + b3.taille - 1 < 10) {
                        for (int i = 0; i < 3; i++) {
                            if (lesCases[x][y + i].getEtat() == Etats.MER) {
                                cpt3++;
                            }
                        }
                        if (cpt3 == 3) {
                            for (int i = 0; i < 3; i++) {
                                placer(lesCases, x, y + i, b3);
                                lesBateaux.add(b3);
                                place = 2;
                                X = rand.nextInt(10);
                                Y = rand.nextInt(10);
                            }
                        } else {
                            cpt3 = 0;
                            X = rand.nextInt(10);
                            Y = rand.nextInt(10);
                        }
                    } else {
                        X = rand.nextInt(10);
                        Y = rand.nextInt(10);
                    }
                } else if (horiz3 == 1) {
                    Bateau3 b3 = new Bateau3();
                    if (x + b3.taille - 1 < 10) {
                        for (int i = 0; i < 3; i++) {
                            if (lesCases[x + i][y].getEtat() == Etats.MER) {
                                cpt3++;
                            }
                        }
                        if (cpt3 == 3) {
                            for (int i = 0; i < 3; i++) {
                                placer(lesCases, x + i, y, b3);
                                lesBateaux.add(b3);
                                place = 2;
                                X = rand.nextInt(10);
                                Y = rand.nextInt(10);
                            }
                        } else {
                            cpt3 = 0;
                            X = rand.nextInt(10);
                            Y = rand.nextInt(10);
                        }
                    } else {
                        X = rand.nextInt(10);
                        Y = rand.nextInt(10);
                    }
                }
                break;
            case 2:
                int horiz4 = rand.nextInt(2);
                if (horiz4 == 0) {
                    Bateau4 b4 = new Bateau4();
                    if (y + b4.taille - 1 < 10) {
                        for (int i = 0; i < 4; i++) {
                            if (lesCases[x][y + i].getEtat() == Etats.MER) {
                                cpt4++;
                            }
                        }
                        if (cpt4 == 4) {
                            for (int i = 0; i < 4; i++) {
                                placer(lesCases, x, y + i, b4);
                                lesBateaux.add(b4);
                                place = 3;
                                X = rand.nextInt(10);
                                Y = rand.nextInt(10);
                            }
                        } else {
                            cpt4 = 0;
                            X = rand.nextInt(10);
                            Y = rand.nextInt(10);
                        }

                    } else {
                        X = rand.nextInt(10);
                        Y = rand.nextInt(10);
                    }
                } else if (horiz4 == 1) {
                    Bateau4 b4 = new Bateau4();
                    if (x + b4.taille - 1 < 10) {

                        for (int i = 0; i < 4; i++) {
                            if (lesCases[x + i][y].getEtat() == Etats.MER) {
                                cpt4++;
                            }
                        }
                        if (cpt4 == 4) {
                            for (int i = 0; i < 4; i++) {
                                placer(lesCases, x + i, y, b4);
                                lesBateaux.add(b4);
                                place = 3;
                                X = rand.nextInt(10);
                                Y = rand.nextInt(10);
                            }
                        } else {
                            cpt4 = 0;
                            X = rand.nextInt(10);
                            Y = rand.nextInt(10);
                        }
                    } else {
                        X = rand.nextInt(10);
                        Y = rand.nextInt(10);
                    }
                }
                break;
            case 3:
                int horiz5 = rand.nextInt(2);
                if (horiz5 == 0) {
                    Bateau5 b5 = new Bateau5();
                    if (y + b5.taille - 1 < 10) {
                        for (int i = 0; i < 5; i++) {
                            if (lesCases[x][y + i].getEtat() == Etats.MER) {
                                cpt5++;
                            }
                        }
                        if (cpt5 == 5) {
                            for (int i = 0; i < 5; i++) {
                                placer(lesCases, x, y + i, b5);
                                lesBateaux.add(b5);
                                place = 4;
                                X = rand.nextInt(10);
                                Y = rand.nextInt(10);
                            }
                        } else {
                            cpt5 = 0;
                            X = rand.nextInt(10);
                            Y = rand.nextInt(10);
                        }
                    } else {
                        X = rand.nextInt(10);
                        Y = rand.nextInt(10);
                    }
                } else if (horiz5 == 1) {
                    Bateau5 b5 = new Bateau5();
                    if (x + b5.taille - 1 < 10) {
                        for (int i = 0; i < 5; i++) {
                            if (lesCases[x + i][y].getEtat() == Etats.MER) {
                                cpt5++;
                            }
                        }
                        if (cpt5 == 5) {
                            for (int i = 0; i < 5; i++) {
                                placer(lesCases, x + i, y, b5);
                                lesBateaux.add(b5);
                                place = 4;
                                X = rand.nextInt(10);
                                Y = rand.nextInt(10);
                            }
                        } else {
                            cpt5 = 0;
                            X = rand.nextInt(10);
                            Y = rand.nextInt(10);
                        }
                    } else {
                        X = rand.nextInt(10);
                        Y = rand.nextInt(10);
                    }
                }
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        lesCases[i][j].setEnabled(true);
                        break;
                    }
                }
        }

    }

    //Getter de la grille
    public static Case[][] getGrille() {
        return lesCases;
    }

    //Méthode pour la simplification du placement.
    public void placer(Case[][] grille, int x, int y, Bateau bateau) {
        grille[x][y].setBateau(bateau);
        grille[x][y].setEtats(Etats.BATEAU);
        //Quand on place les bateaux sur la grille de l'IA, ils doivent rester clickables.
        //On se contente donc simplement d'attribuer un bateau à une case.
    }

    //Evénements qui ont lieu lorsque l'on clique sur la grille.
    private void caseClick(Case casecliquee) {
        JOptionPane victoire_joueur;
        victoire_joueur = new JOptionPane();
        JOptionPane bateau_coule = new JOptionPane();
        //Placement du bateau.
        while (place < 4) {
            placerBateaux(lesCases[X][Y], X, Y);
        }
        //Ici, on effectue les actions qui ont lieu lorsque l'utilisateur clique sur une case de la grille IA.
        if (place == 4) {
            if (casecliquee.getEtat() == Etats.MER) {
                casecliquee.setEtats(Etats.MERVIDE);
                casecliquee.setEnabled(false);
                casecliquee.setDisabledIcon(new ImageIcon("case_touche.jpg"));
            } else if (casecliquee.getEtat() == Etats.BATEAU) {
                casecliquee.getBateau().touche();
                if (casecliquee.getBateau().getPdv() != 0) {
                    casecliquee.setEtats(Etats.TOUCHE);
                } else {
                    casecliquee.setEtats(Etats.COULE);
                    bateau_coule.showMessageDialog(null, "Vous avez coulé un bateau.", "Bataille navale", JOptionPane.INFORMATION_MESSAGE);
                    lesBateaux.remove(casecliquee.getBateau());
                }
                casecliquee.setEnabled(false);
                casecliquee.setDisabledIcon(new ImageIcon("case_bateau_touche.jpg"));
            }
            if (lesBateaux.size() == 10) {
                place = 5;
            }
            //Méthode qui effectue le tir de l'IA sur la grille du joueur. Le tour de l'IA est donc quasiment simultané à celui du joueur.
            tirIA();
        }
        //Cas de victoire. Proposition de rejouer ou non.
        if (place == 5) {
            joueur.incrementNbPartiesBatailleNavale();
            joueur.incrementNbVictoireBatailleNavale();
            joueur.actualiserJoueur(joueur);
            victoire_joueur.showMessageDialog(null, "Vous avez gagné la partie", "Bataille navale", JOptionPane.INFORMATION_MESSAGE);
            int rejouer = showConfirmDialog();
            if (rejouer == 0) {
                rejouer();
            }
            if (rejouer == 1) {
                //System.exit(0);
                InterfaceJeu.BN.dispose();
                new InterfaceJeu(joueur).setVisible(true);
            }
        }
    }
    //Cette classe gère les interactions avec la grille joueur une fois le placement fait.
    //Le tir de l'IA est effectué en son sein, et toutes les modifcations nécessaires y sont effectuées.
    private void tirIA() {
        JOptionPane victoire_IA;
        victoire_IA = new JOptionPane();
        boolean jouer = true;
        while (jouer == true) {
            int X = rand.nextInt(10);
            int Y = rand.nextInt(10);
            //System.out.println("X : " + X + "Y : " + Y + "Taille liste : " + lesBateaux.size());
            if ((Plateau_joueur.getGrille()[X][Y].getEtat() == Etats.MERVIDE) || (Plateau_joueur.getGrille()[X][Y].getEtat() == Etats.COULE) || (Plateau_joueur.getGrille()[X][Y].getEtat() == Etats.TOUCHE)) {
                jouer = true;
            } else {
                if (Plateau_joueur.getGrille()[X][Y].getEtat() == Etats.MER) {
                    Plateau_joueur.getGrille()[X][Y].setEtats(Etats.MERVIDE);
                    Plateau_joueur.getGrille()[X][Y].setEnabled(false);
                    Plateau_joueur.getGrille()[X][Y].setDisabledIcon(new ImageIcon("case_touche.jpg"));
                } else if (Plateau_joueur.getGrille()[X][Y].getEtat() == Etats.BATEAU) {
                    Plateau_joueur.getGrille()[X][Y].getBateau().touche();
                    if (Plateau_joueur.getGrille()[X][Y].getBateau().getPdv() != 0) {
                        Plateau_joueur.getGrille()[X][Y].setEtats(Etats.TOUCHE);
                    } else {
                        Plateau_joueur.getGrille()[X][Y].setEtats(Etats.COULE);
                        Plateau_joueur.getBateaux().remove(Plateau_joueur.getGrille()[X][Y].getBateau());
                    }
                    Plateau_joueur.getGrille()[X][Y].setEnabled(false);
                    Plateau_joueur.getGrille()[X][Y].setDisabledIcon(new ImageIcon("case_bateau_touche.jpg"));
                }

                jouer = false;
                if (Plateau_joueur.getBateaux().size() == 10) {
                    joueur.incrementNbPartiesBatailleNavale();
                    joueur.actualiserJoueur(joueur);
                    
                    victoire_IA.showMessageDialog(null, "Vous avez perdu la partie", "Bataille navale", JOptionPane.INFORMATION_MESSAGE);
                    int rejouer = showConfirmDialog();
                    if (rejouer == 0) {
                        rejouer();
                    }
                    if (rejouer == 1) {
                        System.exit(0);
                        new InterfaceJeu(joueur).setVisible(true);
                    }
                }
            }
        }
    }
    //Ci-dessous une méthode qui affiche la fenêtre oui/non pour le choix de rejouer, ou non.
    static int showConfirmDialog() {
        return JOptionPane.showConfirmDialog(
                null,
                "Voulez-vous rejouer?",
                "Bataille navale",
                JOptionPane.YES_NO_OPTION);
    }
    
    //Méthode pour mettre en place une partie propre : vider toutes les listes, remettre les cases à un état vide, etc.
    void rejouer() {
        final Icon grillevideicon = new ImageIcon("case_vide.jpg");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Plateau_joueur.getGrille()[i][j].setEtats(Etats.MER);
                Plateau_joueur.getGrille()[i][j].setEnabled(true);
                Plateau_joueur.getGrille()[i][j].setIcon(grillevideicon);
                Plateau_joueur.getGrille()[i][j].removeBateau();
                lesCases[i][j].setEtats(Etats.MER);
                lesCases[i][j].setEnabled(false);
                lesCases[i][j].setDisabledIcon(grillevideicon);
                lesCases[i][j].removeBateau();
                place = 0;
                Plateau_joueur.setPlaceZero();
            }
        }
        lesBateaux.clear();
        Plateau_joueur.getBateaux().clear();
    }
}
