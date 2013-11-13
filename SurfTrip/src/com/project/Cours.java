package com.project;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Cours {
	private Calendar date;
	private Moniteur mono;
	private ArrayList<Eleve> eleves;
	private ArrayList<Eleve> eleves_absents;
	private int id_cours ;
	private int present;
	public static int nbr_cours=2;
	
	
	public Cours(Calendar ladate, Moniteur lemono, JFrame frame,JLayeredPane lp){
		this.date=ladate;
		this.mono=lemono;
		this.eleves=new ArrayList<Eleve>();
		this.eleves_absents=new ArrayList<Eleve>();
		this.id_cours=nbr_cours;
		this.present=0;
		nbr_cours++;
	}
	
	public ArrayList<Eleve> getListe(){
		return this.eleves;
	}
	
	public Calendar getDate(){
		return this.date;
	}
	
	public int getId(){
		return this.id_cours;
	}

	public Moniteur getMono(){
		return this.mono;
	}
	public ArrayList<Eleve> getEleves(){
		return this.eleves;
	}
	public ArrayList<Eleve> getEleveAbsents(){
		return this.eleves_absents;
	}
	
	public void ajouterEleve(Eleve e){
		this.eleves.add(e);
	}
	public void setColor(Color col){
		this.getMono().setColor(col);
	}
	
	public String toString(){
		return "Mono= "+this.mono.getNom()+" Id="+this.id_cours;
	}
	public int getBoundx(){	
		int position=0;
		int jour=this.getDate().get(this.getDate().DAY_OF_WEEK)-1;
		
		if (jour==0)		//Pour le dimanche
			jour=7;
		
    	position=(150*jour)+31;  
    	
    	return position;
	}

	public int getBoundy(){
		return (50*(this.getDate().get(this.getDate().HOUR_OF_DAY)-8+2))+1+15;

	}
	
	public int getPresent(){
		return this.present;
	}
	public void setPresent(int i){
		this.present+=i;
	}
}
