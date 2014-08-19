package com.example.egintentapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends Activity {
	
	Button backButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		Intent a = getIntent();
		
	    String data = a.getExtras().getString("Key");
	      
		if (data!= null) {		   
			   Toast.makeText(this, data , Toast.LENGTH_LONG).show();
			   Log.v("Key passed with value : ",data);
		}        
		else {
			   Log.v("No : ", "its null");
		 }
		   
		backButton = (Button)findViewById(R.id.button3);
		backButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 
				Intent backIntent = new Intent(getApplicationContext(), MainActivity.class);
				startActivity(backIntent);
				
			}
		});
	}
	
}
