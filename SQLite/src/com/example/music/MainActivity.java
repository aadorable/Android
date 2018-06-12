package com.example.music;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.Contacts;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	Uri contact_uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;//联系人的URI
	
	//声明组件
	private Button bt;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		//根据main.xml设置程序UI
		setContentView(R.layout.activity_main);
		
		//获取组件
		bt=(Button)findViewById(R.id.button);
		
		//设置监听器
        bt.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
			
				//跳转到QueryActivity，显示联系人列表
				Intent intent = new Intent(MainActivity.this,QueryActivity.class);
				startActivity(intent);
			}
	    });
 }
			
	//getContactInfo()获取联系人列表的信息，返回String对象
	public String getContactInfo() {
		// TODO Auto-generated method stub
		String result = "";
		ContentResolver resolver = getContentResolver();
		Cursor cursor = resolver.query(contact_uri, null, null, null, null);
		
		//获取_ID字段索引
		//int idIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.CONTACT_ID);
				
		//获取name字段的索引
		int nameIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
				
		//获取phonenum字段的索引
		int phonenumIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
		
		//遍历Cursor提取数据
		cursor.moveToFirst();
		for(;!cursor.isAfterLast();cursor.moveToNext()){

			result = result+cursor.getString(nameIndex)+"\t\t";
			result = result+cursor.getString(phonenumIndex)+"\t\n";
			
			String name=cursor.getString(nameIndex);
			String phonenum=cursor.getString(phonenumIndex);
			
			ContentValues values=new ContentValues();
			values.put("name", name);
			values.put("phonenum", phonenum);

			//创建数据库工具类DBHelper
			DBHelper helper = new DBHelper(getApplicationContext());
			
			//调用insert()方法插入数据
			helper.insert(values);
			
		}		
		
		//使用close方法关闭游标
		cursor.close();
		
		//返回结果
		return result;
	}
}
