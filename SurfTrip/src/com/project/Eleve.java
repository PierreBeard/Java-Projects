package com.project;

import java.util.ArrayList;
import java.util.Date;

public class Eleve {
	
	//Attributs
	private String nom;
	private String prenom;
	private int age;
	private String mail;
	private String chem_img;
	private ArrayList<Cours> cours;
	
	//Constructeur
	public Eleve(String lenom, String leprenom, int leage, String mai, String ch){
		this.nom=lenom;
		this.prenom=leprenom;
		this.age=leage;
		this.cours=new ArrayList<Cours>();
		this.mail=mai;
		this.chem_img=ch;
		
	}
	
	//Getteurs
	public String getChemin(){
		return this.chem_img;
	}
	public String getMail(){
		return this.mail;
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
	public ArrayList<Cours> getCours(){
		return this.cours;
	}
	
	public void ajouterCours(Cours leCours){
		this.cours.add(leCours);
	}
	public String toString(){
		return this.nom+" "+this.prenom;
	}

}
