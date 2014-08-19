package com.example.calcapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	
	EditText myNumber1;
	EditText myNumber2;
	EditText answer;
	Button addButton;
	
	Float result,op1,op2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 myNumber1 = (EditText)findViewById(R.id.number1);
		 myNumber2 = (EditText)findViewById(R.id.number2);
		 addButton = (Button)findViewById(R.id.button1);
		 answer = (EditText)findViewById(R.id.answer);
		 
		 addButton.setOnClickListener(new View.OnClickListener() {
	    	    public void onClick(View v) {
	    	    	
	    	    	// on click the + button
	    	       
	    	       op1 = Float.parseFloat(myNumber1.getText().toString()); 
	    	       op2 = Float.parseFloat(myNumber2.getText().toString()); 
	    	       result = op1 + op2;   
	    	       answer.setText(String.valueOf(result));
	    	       
	    	    }
	    	});
	       
		 
	}

	 
}
