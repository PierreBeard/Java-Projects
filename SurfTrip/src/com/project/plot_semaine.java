package com.project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class plot_semaine {

	private Semaine las;
	
	public plot_semaine(JFrame fen, JLayeredPane lp, Semaine lase ){
		
		this.las=lase;
		
		fen.setSize(1300, 1000); 
		
		Font font1 = new Font("arial", Font.BOLD, 35);
		Font font2 = new Font("arial",0, 15);
		    
		//Visuel
	    JButton prec = new JButton();
	    prec.setForeground(Color.white);
	    prec.setText("Semaine precedente");
	    prec.setBackground(Color.blue);
	    prec.setBounds(110, 30, 152, 30);
	    prec.addActionListener(new Actionprec(this.las.getDateCourante().get(Calendar.WEEK_OF_YEAR),this.las.getAn(),1,this.las.getDateCourante()));	    

	    
	
	    JButton suiv = new JButton();
	    suiv.setForeground(Color.white);
	    suiv.setText("Semaine suivante");
	    suiv.setBackground(Color.blue);
	    suiv.setBounds(1080, 30, 152, 30);
	    suiv.addActionListener(new Actionprec(this.las.getDateCourante().get(Calendar.WEEK_OF_YEAR),this.las.getAn(),2,this.las.getDateCourante()));	    
	    
		JButton newcours = new JButton();
		newcours.setForeground(Color.white);
		newcours.setText("Add Cours");
	    newcours.setBackground(Color.black);
		newcours.setBounds(5, 200, 100, 30);
	    newcours.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent arg0) {			
				addcours_popup pop = new addcours_popup();			
			}
		});
	    
		JButton retour = new JButton();
		retour.setForeground(Color.white);
		retour.setText("Retour Menu");
	    retour.setBackground(Color.red);
		retour.setBounds(750, 620, 200, 50);
	    retour.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent arg0) {			
				//ihm l = new ihm();			
				Main.fenetre_courante.dispose();
			}
		});
	    
		JButton neweleve = new JButton();
		neweleve.setForeground(Color.white);
		neweleve.setText("Add Eleve");
		neweleve.setBackground(Color.black);
		neweleve.setBounds(5, 440, 100, 30);
		neweleve.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent arg0) {			
				addeleve_popup pop = new addeleve_popup();			
			}
		});
	    
		JButton newmono = new JButton();
		newmono.setForeground(Color.white);
		newmono.setText("Add Mono");
	    newmono.setBackground(Color.black);
		newmono.setBounds(5, 280, 100, 30);
	    newmono.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent arg0) {			
				addmono_popup pop = new addmono_popup();			
			}
		});
	    
	    JButton listemono = new JButton();
		listemono.setForeground(Color.white);
		listemono.setText("Liste Mono");
	    listemono.setBackground(Color.black);
		listemono.setBounds(5, 360, 100, 30);
	    listemono.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent arg0) {			
				
				
				JFrame lafen = new JFrame();
				JLayeredPane lay = lafen.getLayeredPane();
				
				JPanel pa = new JPanel ();
				JPanel pa2 = new JPanel ();
				lafen.setSize(1100, 500);
				lafen.getContentPane().setBackground(Color.white);
		
				Font font1 = new Font("arial", Font.BOLD, 35);
				
				JLabel titre = new JLabel();
				titre.setFont(font1);
				titre.setBounds(0,0,800,100);
				titre.setLocation(100,-15);
				titre.setText("LISTE DES MONITEURS COURANTS");			
				lay.add(titre, new Integer(1));
				
				JLabel tt = new JLabel();
				tt.setText("NOM                                                       PRENOM                                           AGE                                     PHOTO");
				tt.setBounds(0,0,800,300);
				tt.setLocation(30,-60);
				lay.add(tt, new Integer(2));
				
				int inc=-50;
				for(Moniteur mon : Main.liste_mono) {
					System.out.println(inc);
					inc=inc+40;
					JLabel tt2 = new JLabel();
					tt2.setText(mon.getNom());
					tt2.setBounds(0,0,100, 300);
					tt2.setLocation(30,inc);	
					
					JLabel tt3 = new JLabel();
					tt3.setText(mon.getPrenom());
					tt3.setBounds(0,0,1100, 300);
					tt3.setLocation(225,inc);
					
					JLabel tt4 = new JLabel();
					tt4.setText(String.valueOf(mon.getAge()));
					tt4.setBounds(0,0,1100, 300);
					tt4.setLocation(402,inc);	
					
					JLabel tt5 = new JLabel();
					tt5.setText(mon.getChemin());
					tt5.setBounds(0,0,1100, 300);
					tt5.setLocation(535,inc);
					
					JButton more = new JButton();
					more.setText("Fiche detail");
					more.setBackground(Color.red);
					more.setBounds(850, 140+inc, 120, 20);
					
					lay.add(tt2, new Integer(2));	
					lay.add(tt3, new Integer(2));
					lay.add(tt4, new Integer(2));
					lay.add(tt5, new Integer(2));
					lay.add(more, new Integer(2));
				
				}
			
				lafen.setVisible(true);
				
			}
		});
	    
	    JButton listeeleve = new JButton();
		listeeleve.setForeground(Color.white);
		listeeleve.setText("Liste Eleve");
	    listeeleve.setBackground(Color.black);
		listeeleve.setBounds(5, 520, 100, 30);
	    listeeleve.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent arg0) {			
				
				String[] data = {"51321", "654534", "65465", "54441"};
				JList liste = new JList(data);
				JScrollPane scroll = new JScrollPane(liste);
				scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			
				scroll.setBounds(0, 100, 100, 500);
				scroll.setLocation(40,40);
				JFrame lafen = new JFrame();
				JLayeredPane lay = lafen.getLayeredPane();
	
				lafen.setSize(1100, 500);
				lafen.getContentPane().setBackground(Color.white);
		
				Font font1 = new Font("arial", Font.BOLD, 35);
				
				JLabel titre = new JLabel();
				titre.setFont(font1);
				titre.setBounds(0,0,800,100);
				titre.setLocation(100,-15);
				titre.setText("LISTE DES ELEVES COURANTS");			
				lay.add(titre, new Integer(1));
				
				JLabel tt = new JLabel();
				tt.setText("NOM                              PRENOM                              AGE                              MAIL                                           PHOTO");
				tt.setBounds(0,0,600,300);
				tt.setLocation(30,-80);
				lay.add(tt, new Integer(2));
				
				int inc=-60;
				for(Eleve el : Main.liste_eleve) {
					System.out.println(inc);
					inc=inc+20;
					JLabel tt2 = new JLabel();
					tt2.setText(el.getNom()+"                             "+el.getPrenom()+"                             "+el.getAge()+"                             "+el.getMail()+"                               "+el.getChemin());
					tt2.setBounds(0,0,1100, 300);
					tt2.setLocation(30,inc);				
					lay.add(tt2, new Integer(2));			
				
				}
			
				lay.add(scroll, new Integer(3));
				lafen.setVisible(true);
				
			}
		});
		
		JLabel text = new JLabel();
		text.setText("Planning de la semaine n°="+lase.getDateCourante().get(Calendar.WEEK_OF_YEAR)+" de l'année "+lase.getAn());	
		text.setFont(font1);
		text.setBounds(0,0,800,100);
		text.setLocation(300,-15);
		lp.add(text, new Integer(2));
		
		JLabel text2 = new JLabel();
		
		text2.setText("Semaine du ="+lase.getLund()+"/"+(lase.getDateCourante().get(Calendar.MONTH)+1));	
		text2.setFont(font1);
		text2.setBounds(0,0,800,100);
		text2.setLocation(300,600);
		lp.add(text2, new Integer(2));
		
		
	  
		JPanel back = new PlanningBackground(lase.getLund(),lase.getDateCourante().get(Calendar.MONTH),lase.getDateCourante().get(Calendar.YEAR));
		back.setBounds(0, 0,1960, 700);
	    lp.add(back, new Integer(1));
	    lp.add(prec,new Integer(2));
	    lp.add(suiv,new Integer(2));
	    lp.add(newcours,new Integer(2));
	    lp.add(listemono, new Integer(2));
	    lp.add(neweleve, new Integer(2));
	    lp.add(listeeleve, new Integer(2));
	    lp.add(retour, new Integer(2));
	  
	    lp.add(newmono,new Integer(2));
	    fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    fen.setVisible(true); 
	    
	    for (Cours c : this.las.getListe()){
	    	this.plotCours(c);
	    }
	    
	}
	
	public void plotCours(Cours lecour){	
		
		//Changer taille du texte
		//Si plusieurs cours au meme moment, mettre un bouton avec le nombre de cours qui sont prévu a ce moment
		//et en cliquant dessus, voirs les cours et pouvoir cliquer dessus
	    JButton cours = new JButton();
	    cours.setForeground(Color.white);
	    cours.setText(lecour.toString());
	    cours.setBackground(lecour.getMono().get_color());
	    cours.setBounds(lecour.getBoundx(), lecour.getBoundy(), 149, 49);
	 //   System.out.println(lecour.getBoundx( )+" "+lecour.getBoundy());
	 //   System.out.println(lecour);
	    Main.pane_courant.add(cours,new Integer(2));	    
	    cours.addActionListener(new ActionListenerCours(lecour));


	}
	
    class ActionListenerCours implements ActionListener{
        
        Cours lecours;      
        ActionListenerCours(Cours uncours){
              this.lecours=uncours;
        }   
        @Override
		public void actionPerformed(ActionEvent e) {
			cours_popup popup = new cours_popup(this.lecours);
        }
    }

    
    class Actionprec implements ActionListener{
        
    	Calendar cad ;
    	int numero_semaine=0;
    	int annee=0;
    	int mode =0;
    	
        Actionprec(int n, int a, int mod, Calendar cade){ 
        	this.numero_semaine=n;
        	this.annee=a;
        	this.mode=mod;	//precedent ou suivant
        	this.cad=cade;
        }   
        @Override
		public void actionPerformed(ActionEvent e) {
					
        		int l=0;
        		int lenumero=0;
        		
        		if(mode==1)
        			lenumero=this.numero_semaine-1;	//Precedent
        		if(mode==2)
        			lenumero=this.numero_semaine+1;	//Suivant
				Main.fenetre_courante.dispose();					
			    Main.fenetre_courante = new JFrame();
			    Main.pane_courant= Main.fenetre_courante.getLayeredPane();			    
			    Main.fenetre_courante.setVisible(true);	
			    
			    if( Main.liste_semaines.size()>0){
			    	for(Semaine s : Main.liste_semaines){
			    		if(s.getDateCourante().get(Calendar.WEEK_OF_YEAR)==(lenumero)){
			    			if(this.annee==s.getAn()){
			    				System.out.println("Anné du truc : "+s.getAn());
			    				Main.semaine_courante=s;
			    				plot_semaine p = new plot_semaine(Main.fenetre_courante,Main.pane_courant,Main.semaine_courante);
			    				l=1;
			    				break;
			    			}
			    		}
			    	}
			    }
			    
			    if(l==0){
			    	Semaine s=null;
			    	if(mode==1)
			    		s = new Semaine(cad.get(Calendar.YEAR), cad.get(Calendar.MONTH), cad.get(Calendar.DAY_OF_MONTH)-7);
			    		//s.setlaDate(cad.get(Calendar.YEAR), cad.get(Calendar.MONTH), cad.get(Calendar.DAY_OF_MONTH)-7);
			    	if(mode==2)
			    		s = new Semaine(cad.get(Calendar.YEAR), cad.get(Calendar.MONTH), cad.get(Calendar.DAY_OF_MONTH)+7);
			    		//s.setlaDate(cad.get(Calendar.YEAR), cad.get(Calendar.MONTH), cad.get(Calendar.DAY_OF_MONTH)+7);
			    	System.out.println(s.getDateCourante().get(Calendar.MONTH));
			    	Main.liste_semaines.add(s);
			    	Main.semaine_courante=s;
			    	plot_semaine p = new plot_semaine(Main.fenetre_courante,Main.pane_courant,Main.semaine_courante);
			    }
			    
			    
			}
	
		}
 }
    


