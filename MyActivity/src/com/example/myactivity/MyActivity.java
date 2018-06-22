package com.example.myactivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MyActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my);
		Log.d("MyActivity","onCreate");
	}
	
	protected void onStart(){
		super.onStart();
		Log.d("MyActivity","onStart");
	}
	  
	protected void onRestart(){
		super.onRestart();
		Log.d("MyActivity","onRestart");
	}
	
	protected void onResume(){
		super.onResume();
		Log.d("MyActivity","onResume");
	}
	
	protected void onPause(){
		super.onPause();
		Log.d("MyActivity","onPause");
	}
	
	protected void onStop(){
		super.onStop();
		Log.d("MyActivity","onStop");
	}
	
	protected void onDestroy(){
		super.onDestroy();
		Log.d("MyActivity","onDestroy");
	}
}
