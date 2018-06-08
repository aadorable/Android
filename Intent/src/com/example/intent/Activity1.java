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
		//根据布局文件activity_activity1.xml生成界面
		setContentView(R.layout.activity_activity1);
		//根据XML定义生成取得RadioGroup、RadioButton、Button对象
		RG_OS = (RadioGroup)findViewById(R.id.RG_OS);
		RG_OS_RB1 = (RadioButton)findViewById(R.id.RG_OS_RB1);
		RG_OS_RB2 = (RadioButton)findViewById(R.id.RG_OS_RB2);
		RG_OS_RB3 = (RadioButton)findViewById(R.id.RG_OS_RB3);
		button_submit=(Button)findViewById(R.id.button_submit);
		//使用setOnClickListener注册按钮单击事件监听器
		button_submit.setOnClickListener(new ButtonClickListener());
	}
	
	//定义按钮button_submit单击监听器。当单击button_submit按钮时，onClick方法被调用
	class ButtonClickListener implements OnClickListener{
		public void onClick(View arg0){
			//创建一个Intent对象
			Intent myintent = new Intent();
			//指定Intent对象的目标组件是Activity2
			myintent.setClass(Activity1.this, Activity2.class);
			
			//根据用户选择不同的单选按钮，向Intent对象的Extra属性中存不同的值
			if(RG_OS_RB1.isChecked())
				myintent.putExtra("selected",(String)RG_OS_RB1.getText());
			else if(RG_OS_RB2.isChecked())
				myintent.putExtra("selected",(String)RG_OS_RB2.getText());
			else if(RG_OS_RB3.isChecked())
				myintent.putExtra("selected",(String)RG_OS_RB3.getText());
			else
				myintent.putExtra("selected","null");
				
			//利用startActivity()启动新的Activity，即Activity2
			Activity1.this.startActivity(myintent);
			//关闭当前Activity	
			Activity1.this.finish();
		}
	}
}
