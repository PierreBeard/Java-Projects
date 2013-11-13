package com.project;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class plot_cours extends JPanel{

	private Cours lecours;
	
	public plot_cours(Cours lecours){		
		this.lecours=lecours;
	}
	
	public void paint(Graphics g){
		
		int coord_x, coord_y;	//Coordonées du bloc cours		
        Graphics2D g2d = (Graphics2D) g;

    	RenderingHints rh =new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHints(rh);

    	g2d.setColor(this.lecours.getMono().get_color());
    	System.out.println(this.lecours.getMono().get_color().toString());
    	
    	coord_y=(50*(this.lecours.getDate().get(this.lecours.getDate().HOUR_OF_DAY)-8+2))+1;
    	coord_x=(150*(this.lecours.getDate().get(this.lecours.getDate().DAY_OF_WEEK)))+31;
    
    	
    	g2d.fillRect(coord_x,coord_y, 149, 49);	//Rectangle associé au cours
    	g2d.setColor(Color.WHITE);
    	g2d.drawString(this.lecours.getMono().getNom(),coord_x+65,coord_y+20);
   
		
		
		
	}

}
