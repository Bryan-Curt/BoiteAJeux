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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
//boutton pour chaine de carateres
public class Button2 extends JButton implements MouseListener{

	public String s;
	
	public Button2(String s) {
		this.s = s;
		this.setText(s);
		this.addMouseListener(this);
	}
	
	public char[] getValue() {
		return this.s.toCharArray();
	}

	public void mouseClicked(MouseEvent event) { 
		System.out.print("Testbouton2");
		
	}
	
	public void mouseEntered(MouseEvent event) {
		  
	}
	
	public void mouseExited(MouseEvent event) {
		  
	}
	  
	public void mousePressed(MouseEvent event) { }
	  public void mouseReleased(MouseEvent event) { }       

	}

	

