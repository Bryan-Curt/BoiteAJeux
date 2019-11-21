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
// objet avec 2 attributs string et int 
import java.io.*;
import java.util.Random;


public class Word {
    
    private String word;
    private int length;
    
public Word(){
	// nombre aleatoire dans le dictionnaire
	 int nb = new Random().nextInt(196696);
  
    
    String line ="PasDEMOT";
 
    try {
    	   // lire dans le fichier 
      	int cpt = 0;
    	  FileReader file = new FileReader ("dictionnaireauth.txt" );
    	  
    	  BufferedReader buff = new BufferedReader (file);
    	  //String line;
    	 
          // lire ligne par ligne jusqu au random
          while ((line = buff.readLine()) != null && cpt != nb) {
    	  	cpt++;
    	  }
      	this.word = line;
      	this.length = line.length();
    	  buff.close();
    	  file.close();
    	   }
    	    catch (IOException e){
    	   
    	    System.out.println("Erreur --" + e.toString());
    	   }
    	  


	
    

}
//on peut recuperer taille et mot
public int getLength(){
    return length;
}

public String getString(){
    return this.word;
	}
}