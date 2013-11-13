package com.example.planninginsa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Date;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;


public class Analyser {


	public Analyser(){
		super();
	}

	
	public Cours TextToCours (String chaine, String nom){
	
		String[] part1 = new String[50];
		String[] part2 = new String[50];	
		String[] part3 = new String[50];
		String[] part4 = new String[50];
		String[] part5 = new String[50];
		String[] gpes = new String[50];
		
		part1=chaine.split("</strong> "); 
		part2=part1[1].split(" ");
		if(part1.length>4){
			part3=part1[3].split("<br />");		
			part4=part1[4].split("<br />");
		}else{
			part4[0]="Non renseignée";
			part3[0]="Non renseignée";
		}
		part5=part1[2].split(" ");	
		String[] date = part2[0].split("/");
		Date laDate = new Date(Integer.valueOf(date[2])-1900, Integer.valueOf(date[1])-1, Integer.valueOf(date[0]));
		
		String duree = part5[0];
		String salle = part4[0];
		String heure = part2[1].substring(0,part2[1].length()-3);
		ArrayList<String> groupes = new ArrayList<String>();
		gpes=part3[0].split(", ");
		for(int k=0; k<gpes.length; k++)
			groupes.add(gpes[k]);
	
		Cours c = new Cours(laDate, duree, salle, groupes,nom, heure);
	
		return c;
		
	}
	
	
	
	
	public ArrayList<id> URLtoCoursURL(String url) throws IOException{
        
        String[] part1= new String[2000];
        String[] part2 = new String[500];
        String[] part3 = new String[500];
        String[] part4 = new String[500];
        String[] part5 = new String[500];
        String text ="";
        String nomCours ="";
        String basic = "http://www.etud.insa-toulouse.fr/planning/details";
        ArrayList<id> URLCours = new ArrayList<id>();
        
        text=URLReader(url);
        
        part1=text.split("\n");        
        
        for(int i=0; i<part1.length; i++){
        	
        	part2=part1[i].split("href=");
        	if(part2.length>1){
        		
        		//Pour le nom du cours
        		part5=part2[0].split("title=");
        		if(part5.length>1){
        			//System.out.println(part5[1].substring(1,part5[1].length()-2));
        			nomCours=part5[1].substring(1,part5[1].length()-2);
        		}
        		//Pour le reste
        		for(int j=0; j<part2.length; j++){        			
        			part3=part2[j].split(" id");          			
        		}       		
        		if(part3.length>1){ 
        			
        			part4=part3[0].split("details");
        			
        			String fin = basic+part4[1];
        			fin=fin.substring(0,basic.length()+part4[1].length()-1);
        			id ii = new id(fin, nomCours);
        			URLCours.add(ii);        			
        			
        		}
        	}
        }
         
        return URLCours;
   
	}
	
	public static String URLReader(String url) throws IOException{				
		URL oracle = new URL(url);		
	    URLConnection yc = oracle.openConnection();
	    System.out.println("ONEEEEEEEEEEEEEEEEEEEEEEEE");
	    BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
	   
	    String inputLine;
	    String chaine = "";
	   
	    while ((inputLine = in.readLine()) != null){        
	    	chaine=chaine+inputLine+"\n";
	    }
	    in.close();
	    System.out.println("LA chaine : " +chaine);		
		
	   
	    return chaine;    
	}
	
	//TODO
	public ArrayList<Cours> URLCoursToTextCours(ArrayList<id> liste) throws IOException{
		
		
		String[] part1 = new String[100];
		String[] part2 = new String[100];
		String[] part3 = new String[100];
		String chaine="";
		String chaine2="";
		ArrayList<Cours> listeCours = new ArrayList<Cours>();
		
		for(id idCurrent : liste){
			
			chaine=URLReader(idCurrent.getUrl());
		    part1=chaine.split("\n"); 	 
		    for(int i=0; i<part1.length; i++){		        	
		        part2=part1[i].split("<div");		          
		        if(part2.length>1){		        	
		        	for(int j=0; j<part2.length; j++){
		        		part3=part2[j].split("Date :");   
		        			if(part3.length>1){
		        			
		        				chaine2=part3[1];
		        				listeCours.add(TextToCours(chaine2, idCurrent.getNom()));		        				
		        			}
		        	}   
		        }
		
		    }
	     
		}
	   
	    return listeCours;
	}
	
	public String[] listToID(ArrayList<Groupes> lis){
		
		int i=0;
		String[] array = new String[lis.size()];
		for(Groupes g : lis){			
			array[i]=g.getId();
			i++;
		}
		
		return array;
		
	}
	
	public String[] listToNom(ArrayList<Groupes> lis){
		
		int i=0;
		String[] array = new String[lis.size()];
		for(Groupes g : lis){			
			array[i]=g.getNom();
			i++;
		}
		
		return array;
		
	}
	
	
	
	public ArrayList<Groupes> URLtoGroupes(String chaine){
		
		ArrayList<Groupes> g = new ArrayList<Groupes>();
		
		String[] part1 = new String[500];
		String[] part2 = new String[500];
		
		part1=chaine.split("<option></option>");
		part1=part1[1].split("</select>");
		part1=part1[0].split("<option value=");
		
		for(int i=1; i<part1.length; i=i+2){
			if(part1[i].length()>1){				
				part2=part1[i].split(">");
				Groupes gp = new Groupes(part2[1].substring(0, part2[1].length()-8),part2[0].substring(1, part2[0].length()-1)); 
				g.add(gp);				
			}
			
		}
		return g;
		
		
	}
	
}

