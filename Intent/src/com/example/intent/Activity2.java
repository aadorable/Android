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
		//根据布局文件activity_activity2.xml生成界面
		setContentView(R.layout.activity_activity2);
		button_back=(Button)findViewById(R.id.button_back);
		//生成文本框对象
		TextView textview = (TextView)findViewById(R.id.textview);
		button_back.setOnClickListener(new ButtonClickListener());
		//获取Activity传递的Intent
		Intent myintent = this.getIntent();
		//获取Intent对象中Extra属性的内容
		String selected_radiobutton = myintent.getStringExtra("selected");
		if(selected_radiobutton == "null")
			textview.setText("没有选中任何系统");
		else
			textview.setText(selected_radiobutton+"被选中");
	}
	
	class ButtonClickListener implements OnClickListener{
		public void onClick(View arg0){
			//创建一个Intent对象，并指定启动程序Activity1
			Intent myintent=new Intent();
			//指定Intent对象的目标组件是Activity1
			myintent.setClass(Activity2.this, Activity1.class);
			//利用startActivity()启动新的Activity
			Activity2.this.startActivity(myintent);
			//关闭当前Activity	
			Activity2.this.finish();
			
		}
	}
}
