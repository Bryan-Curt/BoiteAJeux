/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pendu2;

import boiteajeux.Connecte;

/**
 *
 * @author rggelel
 */
public class Game {
	
	int tries;//nombre dessais
	Word word;//Objet word 
	int[] tab;//tab des lettres utilisées non utilisé indice à 0 sinon 1
	Connecte p;//Objet joueur (ncessaire pour faciliter lenregistrement du tableau des highscore
	String wordGame;//etat du mot en cours du jeux, necessaire a mettre dans le champ pour mettre a jour le panneau
	
  
  
  public Game(Connecte p){
	this.tries =7;
  	this.word = new Word();
  	this.tab = new int[26];
  	//this.p = new Connecte();
  	String tmp ="";
  	for(int i =0; i<this.word.getLength();i++) {
  		tmp += '*';
  	}
  	this.wordGame = tmp;
  }

  public void reset() {//remet le jeux a zero pour rejouer et sauvegarde les points
	  this.tries = 7;
	  this.word = new Word();
	  this.tab = new int[26];
	  
   }
  
  public boolean isOver() {
	  if(this.tries == 0)
		  return true;
	  return false;
  }
 
  public void play(char c) {//on met à jour les données pour un caractere quelconque
	  int tmp = (int)c;
	  this.tab[tmp-65] = 1;
	  //System.out.println("LE C EST DE *" + c+ "* LE TMP EST DE *" +tmp+"* LE I est de " +(tmp-65));
          
	  this.wordGame = wordGame();
	  //calcul des points
	 
	  
  }




public Word getWord(){
  return this.word;
}




public int getTab(int n) {
	return this.tab[n];
}

public void setTab(int n) {
	this.tab[n] = 1;
}

public int getTries() {
	return this.tries;
}

public void setTries(int n) {
	this.tries = n;
}



public boolean isUsed(char c) {//pas necessaire avec lapplication graphique
  int tmp = (int) c;
  tmp = tmp - 65;
  if(this.tab[tmp] == 1)
  	return true;
  else    
  return false;   
}
  

  
public boolean inTheWord(char c) { // renvoie vraie si le char est dans le mot
  boolean a = false;
  char[] tmp = this.word.getString().toCharArray();
  for(int i =0; i< this.word.getLength(); i++){
    if(tmp[i]==c)
      a = true;
    }
  return a;
}
  
public String wordGame() {
//creer tableau taille du mot mystere	
  char[] tmp = new char[this.word.getLength()];
  char[] tmpw = this.word.getString().toCharArray();
  //on remplie le tableau d'étoile
  for(int i = 0; i<tmp.length; i++){
    tmp[i] = '*';
  }

  
//on parcourt le tebleau des lettres si c est egale a 1 c'est OK 
	for( int i =0; i< this.tab.length; i++){ 
            //verifie que c'est bien dans le mot
		if(tab[i]==1 && inTheWord((char)(65+i))){
			// on parcourt le mot mystere  on remplace l'étoile par le caractere
                        for(int j = 0; j<tmp.length; j++){
				if(tmpw[j]== (char)(65+i)){
					tmp[j] = tmpw[j];
				}
			}
		}


   }
	
	  String s ="";
	  for(char c:tmp) {
		  s +=c;
	  }
	return s;
}

	
public Connecte getPlayer() {
	return this.p;
}

public boolean win() {
	return(wordGame().equals(this.word.getString()));
		
}



public void test() {
	this.wordGame =wordGame();
	System.out.println("Nombre d'essais " + this.tries + " Mot mystère " + this.word.getString() + " Etat du mot :" + this.wordGame);
	for(int i =0; i<26; i++) {
		System.out.print((char)(65+i));
	}
	System.out.println("\nSont il egaux = " +(wordGame().equals(this.word)));
	
	for(int i =0; i<26; i++) {
		System.out.print(tab[i]);
	}
}
}

  