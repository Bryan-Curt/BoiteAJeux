/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boiteajeux;

import static boiteajeux.InterfaceDeConnexion.sauvegardeAnnuaire;
import static boiteajeux.Serialisation.lecture;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author bryancurt
 */
public class Connecte implements Serializable {
    protected String pseudo;
    private String motDePasse;
    public String getPseudo;
    protected int nbPartiesBatailleNavale;
    protected int nbVictoiresBatailleNavale;
    protected int nbPartiesPendu;
    protected int nbVictoiresPendu;
    public Connecte(String pseudo,String motDePasse, int nbPartiesBatailleNavale, int nbVictoiresBatailleNavale, int nbPartiesPendu, int nbVictoiresPendu){
        this.pseudo=pseudo;
        this.motDePasse=motDePasse;
        this.nbPartiesBatailleNavale=0;
        this.nbVictoiresBatailleNavale=0;
        this.nbPartiesPendu=0;
        this.nbVictoiresPendu=0;
    }
    
    
    public String getPseudo(){ 
        return this.pseudo;
    }
    
    public String getMotDePasse(){
        return motDePasse;
    }
    
    public int getNbPartiesBatailleNavale(){
        return nbPartiesBatailleNavale;
    }
    
    public int getNbVictoiresBatailleNavale(){
        return nbVictoiresBatailleNavale;
    }
    
    public void incrementNbPartiesBatailleNavale(){
        nbPartiesBatailleNavale+=1;
    }
    
    public void incrementNbVictoireBatailleNavale(){
        nbVictoiresBatailleNavale+=1;
    }
    
    public int getNbPartiesPendu(){
        return nbPartiesPendu;
    }
    
    public int getNbVictoiresPendu(){
        return nbVictoiresPendu;
    }
    
    public void incrementNbPartiesPendu(){
        nbPartiesPendu+=1;
    }
    
    public void incrementNbVictoiresPendu(){
        nbVictoiresPendu+=1;
    }
    
      public void setNbPartiesBatailleNavale(int n){
        nbPartiesBatailleNavale=n;
    }
    
    public void setNbVictoiresBatailleNavale(int n){
        nbVictoiresBatailleNavale=n;
    }
    
    public void setNbPartiesPendu(int n){
        nbPartiesPendu=n;
    }
    
    public void setNbVictoiresPendu(int n){
        nbVictoiresPendu=n;
    }
    
    public void actualiserJoueur(Connecte joueur){ //fait le lien vers la classe annuaire pour actualiser un joueur qui aurait son score changé

        Annuaire annuaire = sauvegardeAnnuaire();
        annuaire.actualisationJoueur(joueur);
    }
    
public static Annuaire sauvegardeAnnuaire() { //convertit la liste qui est serialisée en un objet annuaire
        Annuaire annuaire = new Annuaire();
        ArrayList<Connecte> liste = lecture();
        for (int i = 0; i < liste.size(); i++) {
            annuaire.ajouterUtilisateur(liste.get(i));
        }
        return annuaire;
    }


public String toString(){
    return (pseudo+'/'+nbPartiesBatailleNavale+'/'+nbVictoiresBatailleNavale);
}
    
    
}
