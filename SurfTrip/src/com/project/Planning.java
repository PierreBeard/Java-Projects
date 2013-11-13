package com.project;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Planning extends JFrame{
	private JFrame fenetre;

	
	public Planning(){
		
		/*this.setTitle("Ma premi�re fen�tre Java");
	    this.setSize(1300, 700);
	    this.setLocationRelativeTo(null);               
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setContentPane(new PlanningBackground());	 
	    this.setVisible(true);*/
		super();
		build();
		
	}
	
	private void build(){
		setTitle("Recupération données SP7 EULER / SP6 CAP"); //On donne un titre à l'application
		setSize(600,600); //On donne une taille à notre fenêtre
		setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
		setResizable(false); //On interdit la redimensionnement de la fenêtre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
		setContentPane(getContentPane());
	}

	
	public JFrame get_frame(){
		return this.fenetre;
	}


	
	
}
