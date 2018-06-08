package com.example.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends Activity {

	Button button_back;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//���ݲ����ļ�activity_activity2.xml���ɽ���
		setContentView(R.layout.activity_activity2);
		button_back=(Button)findViewById(R.id.button_back);
		//�����ı������
		TextView textview = (TextView)findViewById(R.id.textview);
		button_back.setOnClickListener(new ButtonClickListener());
		//��ȡActivity���ݵ�Intent
		Intent myintent = this.getIntent();
		//��ȡIntent������Extra���Ե�����
		String selected_radiobutton = myintent.getStringExtra("selected");
		if(selected_radiobutton == "null")
			textview.setText("û��ѡ���κ�ϵͳ");
		else
			textview.setText(selected_radiobutton+"��ѡ��");
	}
	
	class ButtonClickListener implements OnClickListener{
		public void onClick(View arg0){
			//����һ��Intent���󣬲�ָ����������Activity1
			Intent myintent=new Intent();
			//ָ��Intent�����Ŀ�������Activity1
			myintent.setClass(Activity2.this, Activity1.class);
			//����startActivity()�����µ�Activity
			Activity2.this.startActivity(myintent);
			//�رյ�ǰActivity	
			Activity2.this.finish();
			
		}
	}
}
