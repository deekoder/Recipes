package com.example.lifecycleeg;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.v("LifeCycle Eg:--->", "OnCreate");
		 
	}

	@Override
	public void onStart() {
	    super.onStart(); 
	    Log.v("LifeCycle Eg:--->", "OnStart");
		 
	    
	}
	 
	@Override
	public void onPause() {
	    super.onPause(); 
	    Log.v("LifeCycle Eg:--->", "OnPause");
		 
	    
	}
	
	@Override
	public void onStop() {
	    super.onStop(); 
	    Log.v("LifeCycle Eg:--->", "OnStop");
		 
	    
	}
	@Override
	public void onResume() {
	    super.onResume(); 
	    Log.v("LifeCycle Eg:--->", "OnResume");
	 
	    
	}
	
	@Override
	public void onDestroy() {
	    super.onDestroy(); 
	    Log.v("LifeCycle Eg:--->", "OnDestroy");
		 
	    
	}
	
	
	
}
