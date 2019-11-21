/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pendu2;

/**
 *
 * @author rggelel
 */
import boiteajeux.Connecte;
import boiteajeux.InterfaceJeu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.JOptionPane;
import java.util.ArrayList;

// lien entre entre framep et game 
public class ControllerFrameP {

    public FrameP f;
    public Game g;
    private Connecte joueur;

    public ControllerFrameP(FrameP f, Game g, Connecte joueur) {
        this.f = f;
        this.g = g;
        this.joueur = joueur;
        this.f.setInfo(transform(new String(joueur.getPseudo()), g.getTries()));

        this.f.addFramePListener(new FramePListener());
    }
    // a chaque qu'on joue c'est mis à jour image, mot...

    public void updateFrame() {
        f.setPicture(g.getTries());
        f.setInfo(transform(new String(joueur.getPseudo()), g.getTries()-1));
        f.setMW(g.wordGame().toString());
        //f.revalidate();
        //System.out.println("UPDATE");
    }

    public void frameLose() {
        JOptionPane jop1 = new JOptionPane();//on informe du mot et des points gagnés
        jop1.showMessageDialog(null, "Le mot recherché était " + g.getWord().getString() + " dommage", " rejouer ?", JOptionPane.INFORMATION_MESSAGE);//+*" , votre score est de "+g.getPlayer().getFinalPoints()+ " points", "Game Over", JOptionPane.INFORMATION_MESSAGE);
        joueur.incrementNbPartiesPendu();
        joueur.actualiserJoueur(joueur);
        new InterfaceJeu(joueur).setVisible(true);
        f.dispose();
        InterfaceJeu.ff.dispose();
    }

    public void frameWin() {
        JOptionPane jop1 = new JOptionPane();//on informe du mot et des points gagnés
        jop1.showMessageDialog(null, "Le mot était " + g.getWord().getString() + " bien joué", " rejouer ?", JOptionPane.INFORMATION_MESSAGE);
        joueur.incrementNbPartiesPendu();
        joueur.incrementNbVictoiresPendu();
        joueur.actualiserJoueur(joueur);
        new InterfaceJeu(joueur).setVisible(true);
        f.dispose();
        InterfaceJeu.ff.dispose();
    }

    public String transform(String s, int m) {
        String tmp = "Nom : " + s + " Essais restants : " + m;
        System.out.println(tmp);
        return tmp;
    }

    class FramePListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //action apres clique:

            char rep = ((Button1) e.getSource()).getValue();//On récupère  le caractère du bouton cliqué
            System.out.println("Touche enfoncée " + rep);

            System.out.println("Essaie numero " + g.getTries());
            updateFrame();

            if (g.getTries() == 0) {//plus dessais on arrete tout

                updateFrame();
                frameLose();
            } else {
                if (g.inTheWord(rep)) {                  //si le caractere est dans le mot mystere
                    g.play(rep);                           //on met à jour
                    g.test();
                    updateFrame();
                    if (g.win()) {                          //si le mot est trouvé

                        frameWin();
                        updateFrame();
                    } else {                            //sinon le caractere nest pas dans le mot mystere
                        //on met a jour 
                        updateFrame();
                        g.test();
                    }

                } else {
                    g.setTries(g.getTries() - 1);
                    g.play(rep);//Si le char nest pas dans le mot
                    f.setPicture(g.getTries());
                    if (g.getTries() - 1 == 0) {
                        updateFrame();
                        frameLose();
                    }

                }

            }

        }

    }

}
