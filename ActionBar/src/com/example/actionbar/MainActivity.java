package com.example.actionbar;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	private ActionBar actionBar = null;
	private Button btn = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//��ȡӦ�õ�ActionBar
		actionBar = getActionBar();
		
		btn = (Button)findViewById(R.id.btn);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				if(actionBar.isShowing()){
					//����ActionBar
					actionBar.hide();
					btn.setText("Show");
				}
				else{
					//��ʾActionBar
					actionBar.show();
					btn.setText("Hide");
				}
			}
		});
	}
}
