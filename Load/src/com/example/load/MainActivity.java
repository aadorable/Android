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

	//�������
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
		
		//����Id��ȡ�������
		username = (EditText)findViewById(R.id.username);
		password = (EditText)findViewById(R.id.password);
		male = (RadioButton)findViewById(R.id.male);
		female = (RadioButton)findViewById(R.id.female);
		reading = (CheckBox)findViewById(R.id.reading);
		swimming = (CheckBox)findViewById(R.id.swimming);
		marriged = (ToggleButton)findViewById(R.id.marriged);
		position = (Spinner)findViewById(R.id.position);
		//����һ�������б�ѡ������
		String[] strs = {"CEO", "PM", "PL"};
		//����һ������������
		ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, strs);
		//���������б��������
		position.setAdapter(aa);
		register = (Button)findViewById(R.id.register);
		cancel = (Button)findViewById(R.id.cancel);
		//ע�����
		register.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// ע��
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
				Toast t1 = Toast.makeText(getApplicationContext(), "ע��ɹ�", Toast.LENGTH_LONG);
				t1.show();
			}
		});
		cancel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// ȡ��
				Toast t2 = Toast.makeText(getApplicationContext(), "ȡ��ע��", Toast.LENGTH_LONG);
				t2.show();
			}
		});
	}
}
