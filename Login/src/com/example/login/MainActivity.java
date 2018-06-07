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
	//声明组件	
	private EditText username;
	private EditText password;
	private Button login;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//无标题设置
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		
		//初始化控件，根据Id获取组件对象
		username = (EditText)findViewById(R.id.username);
		password = (EditText)findViewById(R.id.password);
		login = (Button)findViewById(R.id.login);
		
		//注册监听
		login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// 登录
				Log.i("tag", "username:"+username.getText().toString());
				Log.i("tag", "password:"+password.getText().toString());
				Toast t1 = Toast.makeText(getApplicationContext(), "登录成功", Toast.LENGTH_LONG);
				t1.show();		
			}
		});
	}
}
