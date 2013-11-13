package com.project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.project.addcours_popup.Actionlistenvalidate;

public class ihm {
	
	private JFrame fenetre;
	public ihm(){
		JFrame fenetre = new JFrame();
		
		JPanel fond = new JPanel();

		
		fond.setLayout(null);
		JLayeredPane jp = fenetre.getLayeredPane();
		
		fenetre.setSize(1180, 720);
		fenetre.setTitle("Surf Trip");		
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//fond.add(new background_image("src/com/project/surftrip.jpg"));
		
		
		
		JPanel photo = new background_image("src/com/project/surftrip.jpg");
		photo.setBounds(0,0,1180,720);
		jp.add(photo, new Integer(1));
		
		JButton dem = new JButton();	   
	    dem.setForeground(Color.black);	    
	    dem.setText("Liste Moniteurs");
	    dem.setBackground(Color.white);
	    dem.setBounds(700, 350, 150, 50);
	    dem.addActionListener(new ActionListener() {			
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
	    jp.add(dem, new Integer(2));
	    
		JButton addm = new JButton();	   
	    addm.setForeground(Color.black);	
	    addm.setText("Ajouter Moniteur");
	    addm.setBackground(Color.white);
	    addm.setBounds(900, 350, 150, 50);
	    addm.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent arg0) {			
				addmono_popup pop = new addmono_popup();			
			}
		});
	    jp.add(addm, new Integer(2));
	    
		JButton liste = new JButton();	   
	    liste.setForeground(Color.black);	
	    liste.setText("Liste Eleves");
	    liste.setBackground(Color.white);
	    liste.setBounds(700, 420, 150, 50);
	    liste.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent arg0) {			
				
				String[] data = {"51321", "654534", "65465", "54441"};
				JList liste = new JList(data);
				JScrollPane scroll = new JScrollPane(liste);
				scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			
				scroll.setBounds(0, 0, 300, 500);
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
	    jp.add(liste, new Integer(2));
	    
		JButton addel = new JButton();	   
	    addel.setForeground(Color.black);	
	    addel.setText("Ajouter Eleve");
	    addel.setBackground(Color.white);
	    addel.setBounds(900, 420, 150, 50);
		addel.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent arg0) {			
				addeleve_popup pop = new addeleve_popup();			
			}
		});
	    jp.add(addel, new Integer(2));
	    
		JButton plan = new JButton();			
	    plan.setForeground(Color.black);	
	    plan.setText("Voir semaine courante");
	    plan.setBackground(Color.white);
	    plan.setBounds(380, 420, 170, 50);
	    plan.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent arg0) {	
				Semaine s1 = new Semaine (-1,-1,-1);
				Main.semaine_courante=s1;
				plot_semaine p = new plot_semaine(Main.fenetre_courante,Main.pane_courant,s1);						
			}
		});
	    jp.add(plan, new Integer(2));	    

	    
		JButton ajoutCours = new JButton();			
		ajoutCours.setForeground(Color.black);	
		ajoutCours.setText("Ajouter Cours");
		ajoutCours.setBackground(Color.white);
		ajoutCours.setBounds(380, 350, 170, 50);
	    ajoutCours.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent arg0) {			
				addcours_popup pop = new addcours_popup();			
			}
		});
		/*listeCours.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent arg0) {	
				Semaine s1 = new Semaine ();
				plot_semaine p = new plot_semaine(Main.fenetre_courante,Main.pane_courant,s1);						
			}
		});*/
	    jp.add(ajoutCours, new Integer(2));
	    
	    fenetre.add(fond);
		fenetre.setLocation(100, 5);
		fenetre.setVisible(true);
	}

}
