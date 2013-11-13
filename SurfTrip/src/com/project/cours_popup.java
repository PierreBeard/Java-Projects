package com.project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.project.addmono_popup.Actionlistenvalidate;
import com.project.addmono_popup.MyWindowAdapter;

public class cours_popup {

	public Cours lecours;
	
	public cours_popup(Cours lec){
		
		this.lecours=lec;
		
		JFrame popup = new JFrame();
		JPanel panel = new JPanel();
		Font font1 = new Font("arial", Font.BOLD, 30);
		Font font2 = new Font("arial",0, 15);		
		panel.setLayout(null);
		
		popup.setTitle("Action possible sur le cours");
		popup.setSize(700, 500);
		popup.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);				
		popup.addWindowListener( new MyWindowAdapter(popup));					
		popup.getContentPane().setBackground(Color.white);
		
		JLabel text = new JLabel();
		text.setText("Cliquer sur une action a faire : ");	
		text.setFont(font1);
		text.setBounds(0,0,500,100);
		text.setLocation(130,-20);
		panel.add(text);
		panel.setBackground(Color.white);
		
	    JButton suppr = new JButton();
	    suppr.setForeground(Color.white);
	    suppr.setText("Supprimer ce cours");
	    suppr.setBackground(Color.black);
	    suppr.setBounds(250,90, 150, 40);   
	    suppr.addActionListener(new Actionlistendel(this.lecours,popup));
	    panel.add(suppr);
	    
	    JButton addeleve = new JButton();
	    addeleve.setForeground(Color.white);
	    addeleve.setText("Ajouter un eleve au cours");
	    addeleve.setBackground(Color.black);
	    addeleve.setBounds(235,160, 180, 40);   
	    addeleve.addActionListener(new Actionadd(this.lecours));
	    panel.add(addeleve);
	    
	    JButton liste = new JButton();
	    liste.setForeground(Color.white);
	    liste.setText("Voir la liste des eleves suivant le cours");
	    liste.setBackground(Color.black);
	    liste.setBounds(190,230, 270, 40);   
	    liste.addActionListener(new ActionListe(this.lecours));
	    panel.add(liste);
	    
	    JButton appel = new JButton();
	    appel.setForeground(Color.white);
	    appel.setText("Commencer l'appel");
	    appel.setBackground(Color.black);
	    appel.setBounds(190,300, 270, 40);   
	    appel.addActionListener(new ActionAppel(this.lecours));
	    panel.add(appel);
	    
		popup.add(panel);			
		popup.setVisible(true);
	
	
	
	}
	
	class ActionListe implements ActionListener{
		
		Cours lecours;
		
		public ActionListe(Cours c){
			this.lecours=c;
		}
		
		public void actionPerformed(ActionEvent arg0) {			
			
			
			JFrame lafen = new JFrame();
			JLayeredPane lay = lafen.getLayeredPane();
			JCheckBox box1 = new JCheckBox("Case 1");
			lafen.setSize(1100, 500);
			lafen.getContentPane().setBackground(Color.white);
	
			Font font1 = new Font("arial", Font.BOLD, 35);
			lay.add(box1, new Integer(3));
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
			for(Eleve el : this.lecours.getListe()) {
				System.out.println(inc);
				inc=inc+20;
				JLabel tt2 = new JLabel();
				tt2.setText(el.getNom()+"                             "+el.getPrenom()+"                             "+el.getAge()+"                             "+el.getMail()+"                               "+el.getChemin());
				tt2.setBounds(0,0,1100, 300);
				tt2.setLocation(30,inc);				
				lay.add(tt2, new Integer(2));			
			
			}
		
	
		}
		
	}
	
	class ActionAppel implements ActionListener{
		
		Cours lecours;
		public ActionAppel (Cours c){
			this.lecours=c;
		}
		
		public void actionPerformed(ActionEvent arg0) {			
			
			
			JFrame lafen = new JFrame();
			JLayeredPane lay = lafen.getLayeredPane();

			lafen.setSize(1100, 500);
			lafen.getContentPane().setBackground(Color.white);
	
			Font font1 = new Font("arial", Font.BOLD, 35);
			this.lecours.setPresent(0);
			JLabel titre = new JLabel();
			titre.setFont(font1);
			titre.setBounds(0,0,800,100);
			titre.setLocation(300,-15);
			titre.setText("APPEL");			
			lay.add(titre, new Integer(1));
			
			JLabel tt = new JLabel();
			tt.setText("PRESENT 	                   	NOM                              PRENOM                              AGE");
			tt.setBounds(0,0,600,300);
			tt.setLocation(30,-60);
			lay.add(tt, new Integer(2));
			
			int inc=-65;
			for(Eleve el : this.lecours.getListe()) {
				System.out.println(inc);
				inc=inc+40;
				JCheckBox box = new JCheckBox("Etat");
				box.setBackground(Color.white);
				box.setBounds(0,0,80, 30);
				box.setLocation(25,inc+135);
				box.addActionListener(new checkBoxAction(box, lay,lecours));
				JLabel tt2 = new JLabel();
				tt2.setText(el.getNom()+"                                      "+el.getPrenom()+"                                    "+el.getAge());
				tt2.setBounds(0,0,1100, 300);
				tt2.setLocation(145,inc);				
				lay.add(tt2, new Integer(2));			
				lay.add(box, new Integer(2));
			}
			lafen.setVisible(true);
			
			 JButton appel = new JButton();
			    appel.setForeground(Color.white);
			    appel.setText("Valider l'appel");
			    appel.setBackground(Color.black);
			    appel.setBounds(190,300, 270, 40);   
			    appel.addActionListener(new Actionvalida(lafen,this.lecours));
			    lay.add(appel, new Integer(2));
			
		
			lafen.setVisible(true);
			
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
    
    class Actionlistendel implements ActionListener{
        
    	JFrame fo=new JFrame();
      	Cours lecours;      
        Actionlistendel(Cours uncours,JFrame fen){
                this.lecours = uncours;
                this.fo=fen;
        }   
        @Override
		public void actionPerformed(ActionEvent e) {
				Main.semaine_courante.listeCours.remove(this.lecours);
				Main.fenetre_courante.dispose();					
			    Main.fenetre_courante = new JFrame();
			    Main.pane_courant= Main.fenetre_courante.getLayeredPane();			    
			    Main.fenetre_courante.setVisible(true);
			    
			    plot_semaine p = new plot_semaine(Main.fenetre_courante,Main.pane_courant,Main.semaine_courante);
			    
			    for (Cours c : Main.semaine_courante.getListe()){
			    	p.plotCours(c);
			    }		 
				this.fo.setVisible(false);
		}
    }
    
    class Actionadd implements ActionListener{
    	
    	Cours cours;
    	public Actionadd(Cours lec){
    		this.cours=lec;
    	}
    	
    	
		public void actionPerformed(ActionEvent arg0) {	
			
			
			JFrame fen = new JFrame();			
			fen.setSize(250,150);
		
			JPanel panel = new JPanel();
			panel.setLayout(null);
			JLabel text = new JLabel();
			text.setText("Selectionner l'eleve à ajouter : ");					
			text.setBounds(0,0,190,20);
			text.setLocation(20,0);
			panel.add(text);
			panel.setBackground(Color.white);
			
 
			 JButton annuler = new JButton();
			 annuler.setForeground(Color.white);
			 annuler.setText("Annuler");
			 annuler.setBackground(Color.black);
			 annuler.setBounds(130, 60, 80, 30);
			 annuler.addActionListener(new Actionlistencancel(fen));
			 panel.add(annuler);   
			
			Eleve elevenull = new Eleve("Aucun eleve", "", 0,"","src/com/project/006.jpg");
			Eleve listeCourante[] = new Eleve[50];
			int i=0;	
			if(Main.liste_eleve.size()>0){
				for(Eleve el : Main.liste_eleve){
					//System.out.println(el.toString());
					listeCourante[i]=el;	
					i++;
				}
			}
			else
				listeCourante[0]=elevenull;
					
			
			JComboBox jc = new JComboBox(listeCourante);
			jc.setBounds(0, 0, 200, 20);
			jc.setLocation(10, 25);
			panel.add(jc);
			
			 JButton valider = new JButton();
			 valider.setForeground(Color.white);
			 valider.setText("Valider");
			 valider.setBackground(Color.black);
			 valider.setBounds(10, 60, 80, 30);
			 valider.addActionListener(new Actionlistenvalidate(fen,jc,this.cours));
			 panel.add(valider);  
			
			fen.add(panel);
			fen.setVisible(true);			
			
		}
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
class Actionvalida implements ActionListener{
    
    JFrame fo = new JFrame();    
    Cours lecour ;
   	
    Actionvalida(JFrame laf, Cours le){
            this.fo = laf;                
            this.lecour=le;
   
    }   
    @Override
	public void actionPerformed(ActionEvent e) {    	
    	
    	System.out.println("Nombre d'éleve présents : "+this.lecour.getPresent());
    	this.fo.setVisible(false);	
    	
		
	}
}
class Actionlistenvalidate implements ActionListener{
    
    JFrame fo = new JFrame(); 
    JComboBox jc = new JComboBox();
    Cours lecour ;
   	
    Actionlistenvalidate(JFrame laf, JComboBox j, Cours le){
            this.fo = laf;    
            this.jc=j;
            this.lecour=le;
   
    }   
    @Override
	public void actionPerformed(ActionEvent e) {    	
    	
    	this.lecour.getListe().add((Eleve)this.jc.getSelectedItem());
    	
    	this.fo.setVisible(false);	
    	
		
	}
}
    
}
