package com.example.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Activity1 extends Activity {

	RadioGroup RG_OS;
	RadioButton RG_OS_RB1,RG_OS_RB2,RG_OS_RB3;
	protected void onCreate(Bundle savedInstanceState) {
		Button button_submit,button_back;
		super.onCreate(savedInstanceState);
		//���ݲ����ļ�activity_activity1.xml���ɽ���
		setContentView(R.layout.activity_activity1);
		//����XML��������ȡ��RadioGroup��RadioButton��Button����
		RG_OS = (RadioGroup)findViewById(R.id.RG_OS);
		RG_OS_RB1 = (RadioButton)findViewById(R.id.RG_OS_RB1);
		RG_OS_RB2 = (RadioButton)findViewById(R.id.RG_OS_RB2);
		RG_OS_RB3 = (RadioButton)findViewById(R.id.RG_OS_RB3);
		button_submit=(Button)findViewById(R.id.button_submit);
		//ʹ��setOnClickListenerע�ᰴť�����¼�������
		button_submit.setOnClickListener(new ButtonClickListener());
	}
	
	//���尴ťbutton_submit������������������button_submit��ťʱ��onClick����������
	class ButtonClickListener implements OnClickListener{
		public void onClick(View arg0){
			//����һ��Intent����
			Intent myintent = new Intent();
			//ָ��Intent�����Ŀ�������Activity2
			myintent.setClass(Activity1.this, Activity2.class);
			
			//�����û�ѡ��ͬ�ĵ�ѡ��ť����Intent�����Extra�����д治ͬ��ֵ
			if(RG_OS_RB1.isChecked())
				myintent.putExtra("selected",(String)RG_OS_RB1.getText());
			else if(RG_OS_RB2.isChecked())
				myintent.putExtra("selected",(String)RG_OS_RB2.getText());
			else if(RG_OS_RB3.isChecked())
				myintent.putExtra("selected",(String)RG_OS_RB3.getText());
			else
				myintent.putExtra("selected","null");
				
			//����startActivity()�����µ�Activity����Activity2
			Activity1.this.startActivity(myintent);
			//�رյ�ǰActivity	
			Activity1.this.finish();
		}
	}
}
