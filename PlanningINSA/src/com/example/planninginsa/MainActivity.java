package com.example.planninginsa;


import java.io.IOException;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends Activity {

	private String[] tab=new String[100];
	private AutoCompleteTextView autocompletetextview;
	private Analyser an=new Analyser();
	private URLConnexionReader urlConnect = new URLConnexionReader();
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		try {
			this.tab=this.an.listToNom(urlConnect.groupe());
		} catch (IOException e) {
			// TODO Auto-generated catch block	
			e.printStackTrace();
		}		
		//for(int i=0; i<this.tab.length; i++)
		//	System.out.println("Le tableau : " +this.tab[i]);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.select_dialog_item,this.tab);
		   AutoCompleteTextView actv= (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView1);
		   actv.setThreshold(1);
		   actv.setAdapter(adapter);
		   actv.setTextColor(Color.RED);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	


}
