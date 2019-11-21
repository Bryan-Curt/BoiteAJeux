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
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;



public class About extends JFrame{
	
	public About() {
		this.setTitle("Pendu");
		this.setSize(900, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		
		Font font = new Font("Arial",Font.BOLD,30);
		Font font1 = new Font("Arial",Font.BOLD,15);
		Font font2 = new Font("Arial",Font.BOLD,8);
		
		JLabel a =  new JLabel("A propos :");
		a.setFont(font);
		a.setHorizontalAlignment(JLabel.CENTER);

		
		JTextArea b = new JTextArea();
		b.setFont(font);
		JLabel c = new JLabel("By Curt Bryan, Delpy Valentin, Rezig Gelel © 2018 ");
		c.setFont(font2);
		
		b.setFont(font1);
		b.setText("\n\n\nVous avez sept coups pour trouver le mot caché. "
                        + 
				"Avec un dictionnaire 226 000 mots ");
				
		b.setEditable(false);		
		
	

		
		
		
		
		
		
		JPanel top = new JPanel();
		JPanel middle = new JPanel();
		JPanel bottom = new JPanel();
		
		
		top.add(a);
		middle.add(b);
		bottom.add(c);
		
		top.setBackground(Color.WHITE);
		middle.setBackground(Color.WHITE);
		bottom.setBackground(Color.WHITE);
		
		this.setLayout(new BorderLayout());
		this.add(top,BorderLayout.NORTH);
		this.add(middle,BorderLayout.CENTER);
		this.add(bottom,BorderLayout.SOUTH);
		
		this.setVisible(true);
		



	}

}
