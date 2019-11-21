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
import javax.swing.JButton;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
// boutton qui prend un seul carectere
public class Button1 extends JButton implements MouseListener{

	public char c;
	
	public Button1(char c) {
		this.c = c;
		String s;
		s = "" + c;
		this.setText(s);
		this.addMouseListener(this);
	}
	
	public char getValue() {
		return this.c;
	}

	public void mouseClicked(MouseEvent event) { 
		// desactiver le boutton
                this.setEnabled(false);
		
	}
	
	public void mouseEntered(MouseEvent event) {
		  
	}
	
	public void mouseExited(MouseEvent event) {
		  
	}
	  
	public void mousePressed(MouseEvent event) { }
	  public void mouseReleased(MouseEvent event) { }       

	}

	

