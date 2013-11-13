package com.example.planninginsa;

import java.net.*;
import java.util.ArrayList;
import java.io.*;





public class URLConnexionReader {
	
	public URLConnexionReader(){
		super();
	}
	
	public ArrayList<Groupes> groupe() throws IOException{
		
    	//Recupération des groupes actuels de l'INSA
    	Analyser analyse = new Analyser();
    	ArrayList<Groupes> lesGpes = new ArrayList<Groupes>();
    	String[] lesGroupes;
    	lesGpes=analyse.URLtoGroupes(analyse.URLReader("https://www.etud.insa-toulouse.fr/planning/"));
    	lesGroupes=analyse.listToNom(lesGpes);
    	for(Groupes gg : lesGpes)
    		System.out.println(gg.toString());
    	
    	return lesGpes;
	}
    	
    	
    	
  

    
    }
