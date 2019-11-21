/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bataillenavale;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;

/**
 *
 * @author soulh
 */
//Classe me servent à définir l'image de fond d'un JPanel.
public class PanelFond extends JPanel
 {
    Image image;
      public PanelFond()
   {
     image = Toolkit.getDefaultToolkit().getImage("bckground.jpg");
       }
  
   public void paintComponent(Graphics g)
   {
     super.paintComponent(g);
  
     g.drawImage (image, 0, 0, null);
     repaint();
   }
   }
