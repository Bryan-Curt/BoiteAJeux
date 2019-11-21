/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bataillenavale;

import javax.swing.ImageIcon;

/**
 *
 * @author Utilisateur
 */
public class Bateau {

    protected int pdv;
    protected int taille;

    public Bateau() {

    }
    
    //getter de pdv du bateau
    public int getPdv() {
        return this.pdv;
    }
    //Getter de taille.
    public int getTaille() {
        return this.taille;
    }
    //Méthode pour baisser les pdv d'un bateau.
    public void touche() {
        this.pdv--;
    }
    //Methode pour fixer un bateau coulé.
    public void coule() {
        pdv = 0;
    }

}
