package com.project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;


public class addcours_popup extends JPanel {
	
	public static String listeJours[]={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	public addcours_popup(){
		
	
	
	
	JComboBox mois = new JComboBox();
	JComboBox annee = new JComboBox();
	

	
	JFrame popup = new JFrame();
	JPanel panel = new JPanel();
	Font font1 = new Font("arial", Font.BOLD, 30);
	Font font2 = new Font("arial",0, 15);
	panel.setLayout(null);
	
	//Parcours de la liste de mono pour la liste deroulante
	Moniteur mononull = new Moniteur("Aucun moniteur", "", 0, Color.green, "src/com/project/006.jpg");
	Moniteur listeCourante[] = new Moniteur[50];
	int i=0;	
	if(Main.liste_mono.size()>0){
		for(Moniteur mon : Main.liste_mono){
			System.out.println(mon.toString());
			listeCourante[i]=mon;	
			i++;
		}
	}
	else
		listeCourante[0]=mononull;
	
	JComboBox menu = new JComboBox(listeCourante);	
	menu.setBounds(0, 0, 200, 20);
	menu.setLocation(210, 280);
	panel.add(menu);

	String listeCreneaux[]={"10h => 11h","11h => 12h","12h => 13h","13h => 14h","14h => 15h","15h => 16h","16h => 17h","17h => 18h","18h => 19h","19h => 20h"};
	JComboBox creneaux = new JComboBox(listeCreneaux);	
	creneaux.setBounds(0,0,200,20);
	creneaux.setLocation(350,80);
	panel.add(creneaux);

	JComboBox jours = new JComboBox(addcours_popup.listeJours);
	jours.setBounds(0,0,200,20);
	jours.setLocation(350, 120);
	panel.add(jours);	
	
	
	mois.addItem("Janvier");
	mois.addItem("Fevrier");
	mois.addItem("Mars");
	mois.addItem("Avril");
	mois.addItem("Mai");
	mois.addItem("Juin");
	mois.addItem("Juillet");
	mois.addItem("Aout");
	mois.addItem("Septembre");
	mois.addItem("Octobre");
	mois.addItem("Novembre");
	mois.addItem("Decembre");
	mois.setForeground(Color.blue);
	mois.setBounds(0,0,200,20);
	mois.setLocation(350, 160);
	mois.addActionListener(new Actionlistenmonth(mois));
	panel.add(mois);
	
	
	annee.addItem("2013");
	annee.addItem("2014");
	annee.addItem("2015");
	annee.addItem("2016");
	annee.setBounds(0,0,200,20);
	annee.setLocation(350, 200);
	panel.add(annee);

	popup.setTitle("Ajouter un putain de cours");
	popup.setSize(700, 500);
	popup.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);				
	popup.addWindowListener( new MyWindowAdapter(popup));					
	popup.getContentPane().setBackground(Color.white);
	
	JLabel text = new JLabel();
	text.setText("Ajouter un cours");	
	text.setFont(font1);
	text.setBounds(0,0,300,100);
	text.setLocation(130,-20);
	panel.add(text);
	panel.setBackground(Color.white);
	
	JLabel text1 = new JLabel();
	text1.setText("Selectionner la date du cours :          Creneaux :  ");	
	text1.setFont(font2);
	text1.setBounds(0,0,400,100);
	text1.setLocation(20,40);
	panel.add(text1);
	
	JLabel text2 = new JLabel();
	text2.setText("Selectionner un moniteur : ");	
	text2.setFont(font2);
	text2.setBounds(0,0,340,100);
	text2.setLocation(20,240);
	panel.add(text2);
	
	JLabel text3 = new JLabel();
	text3.setText("Jour : ");	
	text3.setFont(font2);
	text3.setBounds(0,0,400,100);
	text3.setLocation(290,80);
	panel.add(text3);
	
	JLabel text4 = new JLabel();
	text4.setText("Mois : ");	
	text4.setFont(font2);
	text4.setBounds(0,0,400,100);
	text4.setLocation(290,120);
	panel.add(text4);
	
	JLabel text5 = new JLabel();
	text5.setText("Année : ");	
	text5.setFont(font2);
	text5.setBounds(0,0,400,100);
	text5.setLocation(280,160);
	panel.add(text5);
	
    JButton valider = new JButton();
    valider.setForeground(Color.white);
    valider.setText("Valider");
    valider.setBackground(Color.black);
    valider.setBounds(80, 380, 120, 50);
    valider.addActionListener(new Actionlistenvalidate(popup,creneaux, jours, mois, annee,menu));
    panel.add(valider);
    
    JButton annuler = new JButton();
    annuler.setForeground(Color.white);
    annuler.setText("Annuler");
    annuler.setBackground(Color.black);
    annuler.setBounds(220, 380, 120, 50);
    annuler.addActionListener(new Actionlistencancel(popup));
    panel.add(annuler);
    
	popup.add(panel);			
	popup.setVisible(true);

	}
	
    class Actionlistencancel implements ActionListener{
        
        JFrame fo = new JFrame();       
        Actionlistencancel(JFrame laf){
                this.fo = laf;
        }   
        @Override
		public void actionPerformed(ActionEvent e) {
			this.fo.setVisible(false);			
		}
    }
    
    class Actionlistenmonth implements ActionListener{
        
        JComboBox mois = new JComboBox();
        Actionlistenmonth(JComboBox j){ 
        	this.mois=j;
        }   
        @Override
		public void actionPerformed(ActionEvent e) {
			if(this.mois.getSelectedItem().toString()=="Janvier"){
				addcours_popup.listeJours[0]="40";
				System.out.println("nov");
			}
		}
    }
    
    class Actionlistenvalidate implements ActionListener{
        
        JFrame fo = new JFrame();   
        
        JComboBox heure = new JComboBox();
        JComboBox mois = new JComboBox();
        JComboBox jour = new JComboBox();
        JComboBox annee = new JComboBox();
        JComboBox mono = new JComboBox();
        
        
        
        Actionlistenvalidate(JFrame laf, JComboBox heur, JComboBox jou, JComboBox moi, JComboBox anne, JComboBox mon){
                this.fo = laf;
                this.mois=moi;
                this.jour=jou;
                this.heure=heur;
                this.annee=anne; 
                this.mono=mon;
        }   
        @Override
		public void actionPerformed(ActionEvent e) {
        	
        	//Semaine s1 = new Semaine ();
        	Date ladate= new Date(this.annee.getSelectedIndex()+2013, this.mois.getSelectedIndex(), this.jour.getSelectedIndex(), this.heure.getSelectedIndex()+8,0);
            Calendar cad = Calendar.getInstance();
      
            cad.set(this.annee.getSelectedIndex()+2013, this.mois.getSelectedIndex(), this.jour.getSelectedIndex()+1, this.heure.getSelectedIndex()+8, 0);
      
            
			Main.fenetre_courante.dispose();					
		    Main.fenetre_courante = new JFrame();
		    Main.pane_courant= Main.fenetre_courante.getLayeredPane();			    
		    Main.fenetre_courante.setVisible(true);
		   
		    Cours lecours = new Cours(cad, (Moniteur) this.mono.getSelectedItem(),Main.fenetre_courante,Main.pane_courant);				    
		   	//1==dimanche
		   // Main.semaine_courante.addCours(lecours);
		    int test=0;
		    //Si exite déja des semaines, on les compare et on regarde si une a été crée 
		    //pour ces date la, si oui on y ajoute le cours et on la plote
		    //si non on la crée et on la plote
		    //probleme sur les numéro de semaine a debugger
		    if(Main.liste_semaines.size()>0){
		    	for(Semaine s : Main.liste_semaines){
		    		System.out.println("caalend" +cad.get(Calendar.WEEK_OF_YEAR));
		    		System.out.println("2 "+s.getDateCourante().get(Calendar.WEEK_OF_YEAR));
		    		if(cad.get(Calendar.WEEK_OF_YEAR)==s.getDateCourante().get(Calendar.WEEK_OF_YEAR)){		    			
		    			if(cad.get(Calendar.YEAR)==s.getAn()){
			    			s.addCours(lecours);			    			
			    			for (Cours c : Main.semaine_courante.getListe()){
			    		    	System.out.println("Cours :"+c.getId());
			    		    }
			    			Main.semaine_courante=s;		    			
			    			test=1;
			    			break;
		    			}
		    		}
		    	}
		    	
		    }		 
		    if(test==0){		    	
		    	Semaine s = new Semaine(cad.get(Calendar.YEAR), cad.get(Calendar.MONTH), cad.get(Calendar.DAY_OF_MONTH));
		    	System.out.println("1" +s.getDateCourante().get(Calendar.WEEK_OF_YEAR));
		    	//s.setlaDate(cad.get(Calendar.YEAR), cad.get(Calendar.MONTH), cad.get(Calendar.DAY_OF_MONTH));		    
		    	System.out.println("2 "+s.getDateCourante().get(Calendar.WEEK_OF_YEAR));
		    	Main.liste_semaines.add(s);
		    	s.addCours(lecours);
    			Main.semaine_courante=s;
		    	
		    }  
		    
		    
		    plot_semaine p = new plot_semaine(Main.fenetre_courante,Main.pane_courant,Main.semaine_courante);
	 
			this.fo.setVisible(false);	
			
		}
    }
	
    class MyWindowAdapter extends WindowAdapter{
        
        JFrame fo = new JFrame();       
        MyWindowAdapter(JFrame laf){
                this.fo = laf;
        }       
        //implement windowClosing method
        public void windowClosing(WindowEvent e) {
                //hide the window when window's close button is clicked
                fo.setVisible(false);                    
        }
    }
}
