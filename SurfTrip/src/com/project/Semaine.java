package com.project;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Semaine extends JFrame {

	
	//Attributs
	public ArrayList<Cours> listeCours ;	
	private  Calendar date_courante = Calendar.getInstance();	
	private int lund;
	private int dim;

	public ArrayList<Cours> getListe(){
		return this.listeCours;
	}
	public int setWeek(){
		int d = date_courante.getWeeksInWeekYear();
		return d++;
	}	
	public void setlaDate(int annee, int mois, int jour){
		this.date_courante.set(annee, mois, jour);		
	}
	public int getAn(){
		return this.date_courante.get(Calendar.YEAR);
	}
	
	public Calendar getDateCourante(){
		return this.date_courante;
	}
	
	public Semaine(int year, int month, int day){
		this.listeCours = new ArrayList<Cours>();    
		//Mettre le jour courant au lundi 
		System.out.println("Date : "+ month+ " " +day +" " + year);
		if((year!=-1)&&(month!=-1)&&(day!=-1)){
			System.out.println("THE WEEK ");
			this.setlaDate(year, month, day);
			System.out.println("Date : "+this.date_courante.get(Calendar.DAY_OF_MONTH) + "Argument "+ month);
		}
		else 
			this.date_courante=Calendar.getInstance();
		
		int jour= this.date_courante.get(Calendar.DAY_OF_WEEK);
		System.out.println("Yo la date : "+this.date_courante.get(Calendar.DAY_OF_MONTH)+"  jour :"+ jour);
		if(jour>1){
			//Le probleme est que on prend tout le temps la date courante, il faut prendre la date du cours !!!
			//this.date_courante.set(this.date_courante.get(Calendar.YEAR), this.date_courante.get(Calendar.MONTH), this.date_courante.get(Calendar.DAY_OF_MONTH)-jour+2);
			lund=this.date_courante.get(Calendar.DAY_OF_MONTH)-jour+2;
			dim=lund+7;
			System.out.println("Lund = " + lund);
		}
		if(jour==0){
			lund=this.date_courante.get(Calendar.DAY_OF_MONTH)+2;
			dim=lund+7;
		}
		System.out.println("Yo la date : "+this.date_courante.get(Calendar.DAY_OF_MONTH));
	}

	public void addCours(Cours lecours){
		this.listeCours.add(lecours);	
	}
	
	public int getLund(){
		return this.lund;		
	}
	public int getDim(){
		return this.dim;
	}
	


	
}
