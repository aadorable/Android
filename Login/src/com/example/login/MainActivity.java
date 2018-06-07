package com.example.login;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity {
	//�������	
	private EditText username;
	private EditText password;
	private Button login;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//�ޱ�������
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		
		//��ʼ���ؼ�������Id��ȡ�������
		username = (EditText)findViewById(R.id.username);
		password = (EditText)findViewById(R.id.password);
		login = (Button)findViewById(R.id.login);
		
		//ע�����
		login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// ��¼
				Log.i("tag", "username:"+username.getText().toString());
				Log.i("tag", "password:"+password.getText().toString());
				Toast t1 = Toast.makeText(getApplicationContext(), "��¼�ɹ�", Toast.LENGTH_LONG);
				t1.show();		
			}
		});
	}
}
