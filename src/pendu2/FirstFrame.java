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
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.Box;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;


//Fenetre Principal 
//herite Jframe 
public class FirstFrame extends JFrame implements ActionListener{
	
	public Button2 go;
	public Button2 about;



	public Connecte joueur; 
  public FirstFrame(Connecte joueur){
	  this.setTitle("Pendu");
	  this.setSize(900, 600);
	  this.setLocationRelativeTo(null);
	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  this.go = new Button2("Jouer");
	  this.about = new Button2("A propos");
	  this.go.addActionListener(this);
	  this.about.addActionListener(this);
          this.joueur=joueur;

	  //Mise en page
	  ImagePanel img = new ImagePanel(0);
	  img.setBackground(Color.WHITE);
	  
	  JPanel a = new JPanel();
	  JPanel b = new JPanel();
	  JPanel c = new JPanel();
	  
	  a.setBackground(Color.WHITE);
	  b.setBackground(Color.WHITE);
	  c.setBackground(Color.WHITE);
	  
	  a.add(this.go);
	  b.add(this.about);
	  // emplacement  
	  Box b1 = Box.createVerticalBox();
	  b1.add(a);
	  b1.add(b);
	  b1.add(c);
	 
	  Box b2 = Box.createHorizontalBox();
	  b2.add(b1);
	  b2.add(img);
	  b2.validate();
	  
	  this.add(b2);
	  //affichier fenetre
	  this.setVisible(true);
	  
	
	  
	  
	  
	 //Chargement de l'ensemble des Joueurs dans un tableau
	  
	  
  }
  
  
  

  public void actionPerformed(ActionEvent evt) {
	
	  String rp = evt.getActionCommand();
          //on regarde ce qu on recupere
	  if(rp == "A propos") {
		  new About();
	  }
	  else if(rp == "Jouer") {
              //ouvre la fenetre pour ecrire le nom
		  JOptionPane jop = new JOptionPane();
		 
                  //creer le nom joueur

	
		  Game g = new Game(joueur); //lance le jeu 
		  FrameP f = new FrameP(g);
		  new ControllerFrameP(f,g,joueur);
		  f.setVisible(true);
                  System.out.println(this.joueur.getPseudo);
	  }

	  }
  }


