package com.project;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class checkBoxAction implements ActionListener{

	private JCheckBox jc;
	private JLayeredPane jp;
	private Cours lecours;
	
	public checkBoxAction(JCheckBox j, JLayeredPane jpane, Cours c){
		this.jc=j;
		this.jp=jpane;
		this.lecours=c;
	}
	public void actionPerformed(ActionEvent arg0) {
		
		
		if(this.jc.isSelected()==true){							
			this.jc.setText("Present");
			this.jc.setBackground(Color.green);
			this.lecours.setPresent(1);
		}
			
		else if(this.jc.isSelected()==false){	
			this.jc.setText("Absent");
			this.jc.setBackground(Color.red);
			this.lecours.setPresent(-1);
		}

	}

}
