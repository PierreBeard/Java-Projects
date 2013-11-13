package com.project;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;

public class Moniteur {
	//Attributs 
	private String nom;
	private String prenom;
	private int age;
	private String chemin_img;
	private ArrayList<Date> disponibilite;
	private ArrayList<Cours> listeCours;
	private Color couleur;
	
	//Constructeur
	public Moniteur(String lenom, String leprenom, int leage,Color col, String chem){
		this.nom=lenom;
		this.prenom=leprenom;
		this.age=leage;
		this.disponibilite=new ArrayList<Date>();
		this.listeCours=new ArrayList<Cours>();
		this.couleur=col;
		this.chemin_img=chem;
		
		System.out.println("Le chemin courant : " +this.chemin_img);
	}
	
	//Getteurs
	public String getChemin(){
		return this.chemin_img;		
	}
	public String getNom(){
		return this.nom;		
	}
	public String getPrenom(){
		return this.prenom;
	}
	public int getAge(){
		return this.age;
	}
	public ArrayList<Date> getDispo(){
		return this.disponibilite;
	}
	public ArrayList<Cours> getListe(){
		return this.listeCours;
	}
	public Color get_color(){
		return this.couleur;
	}
	public void setColor(Color col){
		this.couleur=col;
	}
	
	public void ajouterCours(Cours c){
		this.listeCours.add(c);
	}
	
	public String toString(){
		return this.nom;
	}
	public void setChemin(String s){
		this.chemin_img=s;
	}

}
