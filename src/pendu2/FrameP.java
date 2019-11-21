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
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Box;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.*;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.Font;

//Fenetre Principal 
public class FrameP extends JFrame {
	
	public int numPict;//numéro image
	//public ImagePanel pic; 
	public JLabel info;//affichage des informatioons
	public JLabel mw; //affichage du mot
	public JLabel img;
	public Button1[] keyboard;
	public ImageIcon[] tabP;

	
  public FrameP(Game g){
	    
	this.numPict =7;
	this.tabP = new ImageIcon[8];
	for(int i=0; i<8; i++) {
		
		tabP[i] = new ImageIcon("images/pendu"+i+".jpg");
	
	}
	//pic.setPreferredSize(new Dimension(350,320));
	int[] t = new int[26];
    this.setTitle("Pendu");
    this.setSize(900, 600);
    this.setLocationRelativeTo(null);
    this.setResizable(false);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JPanel right =new JPanel();
    JPanel left = new JPanel();
    
    
    //On prépare le coté visuel
    JPanel keybP = new JPanel();
    keybP.setBackground(Color.WHITE);
    keybP.setLayout(new FlowLayout());
    keybP.setPreferredSize(new Dimension(200, 200));
    this.keyboard = new Button1[26];//Boutons du clavier
    for(int i =0; i< 26; i++) {
    	char c = (char)(65 + i);
    	this.keyboard[i] = new Button1(c);
    	keybP.add(this.keyboard[i]);
    }
    
    Border border = BorderFactory.createLineBorder(Color.BLACK);
    Font font = new Font("Arial",Font.BOLD,45);
    Font font2 = new Font("Arial",Font.BOLD,15);
    
    this.info = new JLabel();
    this.info.setFont(font2);
   // this.info.setText("Nom : " + new String(g.getPlayer().getName()) + "  Score : "+ g.getPlayer().getFinalPoints()+ " points   Essais restants : "+g.getTries());
    this.info.setBorder(border);
    this.info.setPreferredSize(new Dimension(400, 150));
    
    this.info.setHorizontalAlignment(JLabel.CENTER);
    
   
    
    JPanel infoP = new JPanel();
    infoP.setBackground(Color.WHITE);
    infoP.add(info);
    
    this.mw = new JLabel();
    mw.setFont(font);
    this.mw.setText(g.wordGame());
    this.mw.setBorder(border);
    this.mw.setPreferredSize(new Dimension(400, 100));
    this.mw.setHorizontalAlignment(JLabel.CENTER);
    
    
    JPanel mwP = new JPanel();
    mwP.setBackground(Color.WHITE);
    mwP.add(mw);
    
    this.img = new JLabel(tabP[this.numPict]);
    img.setPreferredSize(new Dimension(400, 360));
    
    left.setLayout(new BoxLayout(left, BoxLayout.PAGE_AXIS));
    left.add(infoP);
    left.add(mwP);
    left.add(keybP);
    
    right.add(img);
    right.validate();
    
    left.setBackground(Color.WHITE);
    right.setBackground(Color.WHITE);
    
    JPanel fin = new JPanel();
    fin.setLayout(new BoxLayout(fin, BoxLayout.LINE_AXIS));
    fin.add(left);
    fin.add(right);
    
    add(fin);
    
    
    
    

   
    
    

  }
  
  public void setInfo(String s) {
	  this.info.setText(s);
  }
  
  public void setMW(String s) {
    this.mw.setText(s);
  }
  
  public void setPicture(int n) {
	  this.numPict =n;
	  this.img.setIcon(tabP[n]);
	  
	  
  }
  
  public void reset() {
	  for(Button1 b : this.keyboard) {
		  b.setEnabled(true);
	  }
  }
  
  void addFramePListener(ActionListener listenFrame1){
	  for(int i=0; i<26; i++)
		  this.keyboard[i].addActionListener(listenFrame1);
	  }

}