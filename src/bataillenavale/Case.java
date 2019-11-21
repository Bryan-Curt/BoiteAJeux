/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bataillenavale;

import java.awt.Graphics;
import javax.swing.JButton;

/**
 *
 * @author Utilisateur
 */
public class Case extends JButton {
//Classe héritant des propriétés  des JButton.
    protected int X;
    protected int Y;
    protected Etats e;
    protected Bateau b;

    //On crée une case avec des coordonnées (X,Y)
    public Case(int x, int y) {
        X = x;
        Y = y;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    //Setter de l'état d'une case (MER,BATEAU,...).
    public void setEtats(Etats et) {
        e = et;
    }

    //Setter de bateau d'une case.
    public void setBateau(Bateau bat) {
        b = bat;
    }

    //Méthode pour enlever un bateau. Utilisé pour la réinitialisation du jeu.
    public void removeBateau() {
        b = null;
    }

    //Getter de l'état d'une case (MER,BATEAU,...).
    public Etats getEtat() {
        return e;
    }

    //Getter du bateau d'une case.
    public Bateau getBateau() {
        return b;
    }



}
