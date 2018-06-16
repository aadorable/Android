package com.example.load;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity {

	//声明组件
	private Button register,cancel;
	private ToggleButton marriged;
	private RadioButton male,female;
	private EditText username,password;
	private Spinner position;
	private CheckBox reading, swimming;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//根据Id获取组件对象
		username = (EditText)findViewById(R.id.username);
		password = (EditText)findViewById(R.id.password);
		male = (RadioButton)findViewById(R.id.male);
		female = (RadioButton)findViewById(R.id.female);
		reading = (CheckBox)findViewById(R.id.reading);
		swimming = (CheckBox)findViewById(R.id.swimming);
		marriged = (ToggleButton)findViewById(R.id.marriged);
		position = (Spinner)findViewById(R.id.position);
		//创建一个下拉列表选项数组
		String[] strs = {"CEO", "PM", "PL"};
		//创建一个数组适配器
		ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, strs);
		//设置下拉列表的适配器
		position.setAdapter(aa);
		register = (Button)findViewById(R.id.register);
		cancel = (Button)findViewById(R.id.cancel);
		//注册监听
		register.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// 注册
				Log.i("tag", "username:"+username.getText().toString());
				Log.i("tag", "password:"+password.getText().toString());
				if(male.isChecked()){
					Log.i("tag", "sex:male");
				}
				else{
					Log.i("tag", "sex:female");
				}
				String temp = "like";
				if(reading.isChecked()){
					temp += "read";
				}
				if(swimming.isChecked()){
					temp += "swim";
				}
				Log.i("tag", temp);
				if(marriged.isChecked()){
					Log.i("tag", "marriged:Yes");
				}
				else{
					Log.i("tag", "marriged:No");
				}
				Log.i("tag", "position:" + position.getSelectedItem().toString());
				Toast t1 = Toast.makeText(getApplicationContext(), "注册成功", Toast.LENGTH_LONG);
				t1.show();
			}
		});
		cancel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// 取消
				Toast t2 = Toast.makeText(getApplicationContext(), "取消注册", Toast.LENGTH_LONG);
				t2.show();
			}
		});
	}
}
