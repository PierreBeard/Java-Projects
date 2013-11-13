package com.project;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class addmono_popup_background extends JPanel{
	
	private String chemin;
	
	public addmono_popup_background(String ch){
		this.chemin=ch;
	}
	
	 public void paintComponent(Graphics g){		

		Graphics2D g2d=(Graphics2D)(g);
		
		Image image = null;
		try {
			image = ImageIO.read(new File(this.chemin));
			JLabel viewer = new JLabel(new ImageIcon(image));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
 	
	    RenderingHints rh =new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
	    rh.put(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
	    g2d.setRenderingHints(rh);
	     
		g2d.drawImage(image,100,100,null);

	 }

}