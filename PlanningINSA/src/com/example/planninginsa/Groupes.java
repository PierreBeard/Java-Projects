package com.example.planninginsa;

public class Groupes {

	private String nom;
	private String id;
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Groupes(String nom, String id) {
		super();
		this.nom = nom;
		this.id = id;
	}
	@Override
	public String toString() {
		return "Groupes [nom=" + nom + ", id=" + id + "]";
	}
	
	

}
