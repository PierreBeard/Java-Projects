package com.example.planninginsa;

import java.sql.Date;
import java.util.ArrayList;


public class Cours {

	private Date date;
	private String duree;
	private ArrayList<String> groupes;
	private String salle;
	private String titre;
	private String heure;
	
	
	
	
	public String getHeure() {
		return heure;
	}
	public void setHeure(String heure) {
		this.heure = heure;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDuree() {
		return duree;
	}
	public void setDuree(String duree) {
		this.duree = duree;
	}
	public ArrayList<String> getGroupes() {
		return groupes;
	}
	public void setGroupes(ArrayList<String> groupes) {
		this.groupes = groupes;
	}
	public String getSalle() {
		return salle;
	}
	public void setSalle(String salle) {
		this.salle = salle;
	}
	public Cours(Date date, String duree, String salle, ArrayList<String> groupes, String n, String heure) {
		super();
		this.date = date;
		this.duree = duree;
		this.groupes = groupes;
		this.salle = salle;
		this.titre=n;
		this.heure=heure;
	}
	@Override
	public String toString() {
		return "Cours [date=" + date + ", duree=" + duree +", salle=" + salle + ", titre=" + titre
				+ ", heure=" + heure + "]";
	}


	
	
	

	
}
