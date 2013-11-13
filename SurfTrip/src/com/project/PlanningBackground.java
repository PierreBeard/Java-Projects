package com.project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PlanningBackground extends JPanel{
	
	private int year;
	private int lundi_courant;
	private int mois;
	private int lejour=0;
	public PlanningBackground(int l, int m, int mm){
		this.lundi_courant=l;
		this.mois=m;
		this.year=mm;
	}
	//PREVOIR UNE FONCTION POUR AJOUTER UN COURS
	 public void paintComponent(Graphics g){
		
		 int semaine=2;
		 Graphics2D g2d=(Graphics2D)(g);
		 	
	     RenderingHints rh =new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
	     rh.put(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
	     g2d.setRenderingHints(rh);
		 //Couleur de fond
		 g2d.setColor(Color.white);
		 g2d.fillRect(0,0, 1960, 700);
		 
		 //Titre du planning
		/* Font font = new Font("Arial", Font.BOLD, 40);
		 g2d.setFont(font);
		 g2d.setColor(Color.black);
		 g2d.drawString("Planning de la semaine numéro : " + semaine ,350, 50);
		 
		 Font font2 = new Font("Arial", Font.TYPE1_FONT, 10);
		 g2d.setFont(font2);*/
		 //Creation du tableau
		 g2d.setColor(Color.black);		
		 g2d.drawLine(110, 70, 1230, 70);
		 g2d.drawLine(110, 70, 110, 615);
		 for (int i=180; i<1630; i=i+150)
			 	g2d.drawLine(i, 70, i, 615);
		 g2d.drawLine(180, 100, 180, 100);
		 for (int i=115; i<650; i=i+50)
			 	g2d.drawLine(110, i, 1230, i);	
		 
		 //Grisement de la case en haut à gauche
		 g2d.setColor(Color.gray);
		 g2d.fillRect(110,70, 70, 45);
		 
		 //Legende 		 
		 
		 
		// if(this.lundi_courant>22){
			if((this.mois==3)||(this.mois==5)||(this.mois==8)||(this.mois==10)){
				 System.out.println("Moi de 30");
				 this.lejour=30;
			}
		 	if((this.mois==0)||(this.mois==2)||(this.mois==4)||(this.mois==6)||(this.mois==7)||(this.mois==9)||(this.mois==11)){
		 		System.out.println("Moi de 31");
		 		this.lejour=31;
		 	}
		 	
		 	if(this.mois==1){
		 		System.out.println("Fevrier");
		 		this.lejour=28;
		 	}
		 //	else
		 //		this.lejour=0;
		 	
		 g.drawString("Lundi",240,90);
		 g.drawString(dateAff(this.lundi_courant,this.mois,this.year),225,105);
		 g.drawString("Mardi",390,90);
		 g.drawString(dateAff(this.lundi_courant+1,this.mois,this.year),375,105);	
		 g.drawString("Mercredi",530,90);
		 g.drawString(dateAff(this.lundi_courant+2,this.mois,this.year),522,105);
		 g.drawString("Jeudi",690,90);
		 g.drawString(dateAff(this.lundi_courant+3,this.mois,this.year),675,105);
		 g.drawString("Vendredi",830,90);
		 g.drawString(dateAff(this.lundi_courant+4,this.mois,this.year),825,105);
		 g.drawString("Samedi",985,90);
		 g.drawString(dateAff(this.lundi_courant+5,this.mois,this.year),975,105);
		 g.drawString("Dimanche",1130,90);
		 g.drawString(dateAff(this.lundi_courant+6,this.mois,this.year),1130,105);
		// }
		 
		 g.drawString("10h -> 11h",116,145);
		 g.drawString("11h -> 12h",116,195);
		 g.drawString("12h -> 13h",116,245);
		 g.drawString("13h -> 14h",116,295);
		 g.drawString("14h -> 15h",116,345);
		 g.drawString("15h -> 16h",116,395);
		 g.drawString("16h -> 17h",116,445);
		 g.drawString("17h -> 18h",116,495);
		 g.drawString("18h -> 19h",116,545);
		 g.drawString("19h -> 20h",116,595);
		 

		

		    
		 
		 
	
	}
	 
	 //Faire dans cette fontion la conversion pour eviter les 33 34 35 ...
	 public String dateAff(int day, int month, int year){
		 
		 String ladateAffiche="";	
		 
		if((this.lejour==30)&&(day>30)){
			day=day-30;
			month++;
		}
		if((this.lejour==31)&&(day>31)){
			day=day-31;
			month++;
		}
		if((this.lejour==28)&&(day>28)){
			day=day-28;
			month++;
		}
				if(month<9){	
				if(day<10)
					ladateAffiche="0"+day+"/0"+(month+1)+"/"+year;
				else
					ladateAffiche=day+"/0"+(month+1)+"/"+year;
			}
			else {
				if(day<10)
					ladateAffiche="0"+day+"/"+(month+1)+"/"+year;
				else 
					ladateAffiche=day+"/"+(month+1)+"/"+year;
			}
			
			
			
			System.out.println(ladateAffiche);
			
			return ladateAffiche;
		 
		 
	 }

	 

}
