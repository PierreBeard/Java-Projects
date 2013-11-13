package com.project;


import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;


public class FileChoose  implements ActionListener{
	    
	    JFileChooser jo;
	    JFrame f,fen;
	    JLayeredPane pane;
	    JLabel jol;
	
	    
	    public FileChoose(JFileChooser j, JFrame fo, JFrame fenetre_chooser, JLayeredPane ff, JLabel tt){
	    	this.jo=j;
	    	this.f=fo;
	    	this.fen=fenetre_chooser;
	    	this.pane=ff;
	    	this.jol=tt;
	    	
	    }
	    @Override
		public void actionPerformed(ActionEvent e) {
	    	JPanel jp;
	    	
	    	this.f.setVisible(false);   	

		    	Main.lechemincourant=this.jo.getSelectedFile().toString();
		     	
		     	this.jol.setText("chemin courant : "+Main.lechemincourant);
		     	jp=new addmono_popup_background(Main.lechemincourant);
		     	jp.setBounds(60, 180,300, 220);
		     	this.pane.add(jp, new Integer(addmono_popup.compteur));
		     	addmono_popup.compteur++;

		    	Main.lechemincourant="src/com/project/missing.jpg";	    	



			     	
			    	this.f.setVisible(true);
			    	this.fen.dispose();
	   

	    }
	}


