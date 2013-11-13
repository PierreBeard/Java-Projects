package com.project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.project.addcours_popup.Actionlistencancel;
import com.project.addcours_popup.Actionlistenvalidate;
import com.project.addcours_popup.MyWindowAdapter;

public class addeleve_popup {

	public static int compteur =3;
	
	public addeleve_popup(){

	    //System.out.println("bufff");
		//this.chemin_photo="";
		
		JFrame popup = new JFrame();
		JPanel panel = new JPanel();
		JLayeredPane jlp = popup.getLayeredPane();
		
		Font font1 = new Font("arial", Font.BOLD, 30);
		Font font2 = new Font("arial",0, 15);		
		panel.setLayout(null);
		
		popup.setTitle("Ajouter un eleve à la base");
		popup.setSize(600, 600);
		popup.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);				
		popup.addWindowListener( new MyWindowAdapter(popup));					
		popup.getContentPane().setBackground(Color.white);
		
		JLabel text = new JLabel();
		text.setText("Ajouter un eleve");	
		text.setFont(font1);
		text.setBounds(0,0,300,100);
		text.setLocation(130,-20);
		panel.add(text);
		panel.setBackground(Color.white);
		
		JLabel text1 = new JLabel();
		text1.setText("Saisir le nom : ");	
		text1.setFont(font2);
		text1.setBounds(0,0,400,100);
		text1.setLocation(20,40);
		panel.add(text1);
		
		JLabel text3 = new JLabel();
		text3.setText("Saisir le prénom : ");	
		text3.setFont(font2);
		text3.setBounds(0,0,400,100);
		text3.setLocation(20,80);
		panel.add(text3);
		
		JLabel text4 = new JLabel();
		text4.setText("Saisir la date de naissance : ");	
		text4.setFont(font2);
		text4.setBounds(0,0,400,100);
		text4.setLocation(20,160);
		panel.add(text4);
		
		JLabel text5 = new JLabel();
		text5.setText("Saisir l'adresse email : ");	
		text5.setFont(font2);
		text5.setBounds(0,0,400,100);
		text5.setLocation(20,120);
		panel.add(text5);
		
		JLabel text6 = new JLabel();
		text6.setText("Choisir une photo : ");	
		text6.setFont(font2);
		text6.setBounds(0,0,400,100);
		text6.setLocation(20,200);
		panel.add(text6);
		
		JLabel text7 = new JLabel();
		text7.setText("Photo courante : ");	
		text7.setFont(font2);
		text7.setBounds(0,0,400,100);
		text7.setLocation(20,260);
		panel.add(text7);
		
		JLabel text8 = new JLabel();
		text8.setText("Chemin de la photo : " + Main.lechemincourant);	
		text8.setFont(font2);
		text8.setBounds(0,0,500,100);
		text8.setLocation(20,390);
		panel.add(text8).revalidate();
		
		JButton annuler = new JButton();
	    annuler.setForeground(Color.white);
	    annuler.setText("Annuler");
	    annuler.setBackground(Color.black);
	    annuler.setBounds(300, 480, 120, 50);
	    annuler.addActionListener(new Actionlistencancel(popup));
	    panel.add(annuler);
	    
	    JTextField usernameField = new JTextField(8);
        usernameField.setLocation(210, 75);
        usernameField.setSize(210, 20);
        panel.add(usernameField);
        
	    JTextField surnameField = new JTextField(8);
        surnameField.setLocation(210, 120);
        surnameField.setSize(210, 20);
        panel.add(surnameField);
        
	    JTextField ageField = new JTextField(8);
        ageField.setLocation(210, 200);
        ageField.setSize(210, 20);
        panel.add(ageField);
        
	    JTextField adressField = new JTextField(8);
        adressField.setLocation(210, 160);
        adressField.setSize(210, 20);
        panel.add(adressField);
        
    	
	    JButton valider = new JButton();
	    valider.setForeground(Color.white);
	    valider.setText("Valider");
	    valider.setBackground(Color.black);
	    valider.setBounds(140, 480, 120, 50);
	    valider.addActionListener(new Actionlistenvalidate(popup,usernameField,surnameField, ageField, adressField,Main.lechemincourant));
	    panel.add(valider);    
	   
	    
	    JPanel back = new addmono_popup_background(Main.lechemincourant);
		back.setBounds(160, 203,210, 200);	
		
		 JButton importe = new JButton();
		 importe.setForeground(Color.white);
		 importe.setText("Importer une photo");
		 importe.setBackground(Color.black);
		 importe.setBounds(210, 240, 210, 25);
		 importe.addActionListener(new Actionimporte(popup,jlp,text8));
		 panel.add(importe);
		 panel.setBounds(0, 0, 600, 600);

		jlp.add(back, new Integer(2));
	    jlp.add(panel, new Integer(1));
	   
		popup.setVisible(true);
	
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
    
class Actionimporte implements ActionListener{
        
		JFrame fenetre = new JFrame();       
        JFileChooser jf = new JFileChooser();
        JLayeredPane jpp ;
        JLabel chem;
        
        Actionimporte(JFrame laf, JLayeredPane pp, JLabel ch){
            this.fenetre=laf;
            this.jpp=pp;
            this.chem=ch;
        }   
        @Override
		public void actionPerformed(ActionEvent e) {
				        	
				int status = this.jf.showOpenDialog(null);
				
				if( status == JFileChooser.APPROVE_OPTION){
					Main.lechemincourant=this.jf.getSelectedFile().toString();
			     	
					JPanel jp;
			     	this.chem.setText("Chemin courant : "+Main.lechemincourant);
			     	jp=new addmono_popup_background(Main.lechemincourant);
			     	jp.setBounds(160, 203,210, 200);		
			     	this.jpp.add(jp, new Integer(addmono_popup.compteur));
			     	addmono_popup.compteur++;	    		    	
			    	
				}    	
        	
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
    
    class Actionlistenvalidate implements ActionListener{
        
        JFrame fo = new JFrame(); 
        JTextField username = new JTextField(8);
        JTextField surname = new JTextField(8);
        JTextField age = new JTextField(8);
        JTextField email = new JTextField(8);
       	String chm;
       	
        Actionlistenvalidate(JFrame laf,JTextField usernam,JTextField surnam,JTextField ag,JTextField mel, String s ){
                this.fo = laf;    
                this.username=usernam;
                this.surname=surnam;
                this.age=ag;
                this.email=mel;
                this.chm=s;
        }   
        @Override
		public void actionPerformed(ActionEvent e) {
        	
        	
        	Eleve el = new Eleve(this.username.getText(),this.surname.getText(),Integer.valueOf(this.age.getText()),this.email.getText(), Main.lechemincourant);
			Main.liste_eleve.add(el);
			Main.lechemincourant="src/com/project/missing.jpg";
        	this.fo.setVisible(false);	
        	addmono_popup.compteur=3;
			
		}
    }
	
}
