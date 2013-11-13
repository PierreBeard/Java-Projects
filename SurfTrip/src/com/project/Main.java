package com.project;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Main {

	//Attributs	
	public static String lechemincourant="src/com/project/missing.jpg";
	public static Semaine semaine_courante;
	public static JFrame fenetre_courante= new JFrame();
	public static JLayeredPane pane_courant = fenetre_courante.getLayeredPane();
	public static ArrayList<Moniteur> liste_mono = new ArrayList<Moniteur>();
	public static ArrayList<Eleve> liste_eleve = new ArrayList<Eleve>();
	public static ArrayList<Semaine> liste_semaines = new ArrayList<Semaine>();

	public static void main(String[] args) {

		Semaine s1 = new Semaine (-1,-1,-1);
	    liste_semaines.add(s1);
	    semaine_courante=s1;	    
	    
	    ihm interf = new ihm();
	
	}

}
