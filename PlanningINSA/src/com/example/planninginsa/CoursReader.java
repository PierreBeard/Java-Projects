package com.example.planninginsa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;


public class CoursReader {

	private String url;
	
	public CoursReader(String Url){
		this.url=Url;
	}
	
	
	
	
	public String getUrl() {
		return url;
	}




	public void setUrl(String url) {
		this.url = url;
	}




	public String readURL() throws IOException{
		
		
		String[] part1 = new String[100];
		String[] part2 = new String[100];
		String[] part3 = new String[100];
		String chaine2="";
		 URL oracle = new URL(this.url);
	     URLConnection yc = oracle.openConnection();
	     BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
	     String inputLine;
	     String chaine = "";
	     while ((inputLine = in.readLine()) != null){        
	     	chaine=chaine+inputLine+"\n";
	     }
	     in.close();
	     part1=chaine.split("\n");        
	        
	     for(int i=0; i<part1.length; i++){
	        	
	        	part2=part1[i].split("<div");
	        	if(part2.length>1){
	        		for(int j=0; j<part2.length; j++){
	        			part3=part2[j].split("Date :");   
	        			if(part3.length>1)
	        				chaine2+=part3[1];
	        		}   
	        	}
	
	     }
	   
	     return chaine2;
	}
	

}
