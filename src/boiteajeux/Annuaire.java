/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boiteajeux;


import static boiteajeux.Serialisation.lecture;
import static boiteajeux.Serialisation.ecriture;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.TreeSet;

/**
 *
 * @author bryancurt
 */
public class Annuaire {

    private ArrayList<Connecte> lesUtilisateurs;

    public Annuaire() {
        lesUtilisateurs = new ArrayList();
    }

    public void ajouterUtilisateur(Connecte u) { //ajoute un utilisateur
        lesUtilisateurs.add(u);
    }

    public void supprimerUtilisateur(String pseudo) { //supprime un utilisateur
        boolean utilisateurExiste = false;
        for (Connecte c : lesUtilisateurs) {
            if (c.getPseudo().equals(pseudo)) {
                lesUtilisateurs.remove(c);
                utilisateurExiste = true;
                break;
            }
        }
        if (!utilisateurExiste) {
            System.out.println("Cet utilisateur n'existe pas");
        }

    }

    public void actualisationJoueur(Connecte joueur) { //met à jour un joueur qui a un nouveau score

        ArrayList<Connecte> liste = new ArrayList<Connecte>();
        liste = lecture();
        for (int i = 0; i < liste.size(); i++) {
            if (liste.get(i).getPseudo().equals(joueur.getPseudo())) {
                liste.set(i, joueur);
            }
        }
        ecriture(liste);
    }

    public ArrayList getListe() { //renvoie la liste
        return lesUtilisateurs;
    }

    public String toString() {
        String liste = "";
        for (Connecte c : lesUtilisateurs) {
            liste += c.getPseudo() + c.getMotDePasse() + "; " + c.getNbPartiesBatailleNavale() + "; " + c.getNbVictoiresBatailleNavale();

        }
        return liste;
    }

    public boolean estPseudoDejaPris(String Pseudo) { //renvoie true si le pseudo est libre, false si le pseudo est déjà pris
        boolean estCompteValide = true;
        for (Connecte c : lesUtilisateurs) {
            if (Pseudo.equals(c.getPseudo())) {
                estCompteValide = false;
                break;
            }
        }
        return estCompteValide;
    }
}
