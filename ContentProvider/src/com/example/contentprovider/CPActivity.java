package com.example.contentprovider;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.widget.TextView;

public class CPActivity extends Activity {

	Uri contact_uri = Contacts.CONTENT_URI;//联系人的URI
		
	//声明TextView的对象
	TextView textview;
		
	//定义文本颜色
	int textcolor = Color.BLACK;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		//根据main.xml设置程序UI
		setContentView(R.layout.activity_cp);
		
		textview = (TextView)findViewById(R.id.textview);
		
		//调用getContactInfo()方法获取联系人信息
		String result = getContactInfo();
		
		//设置文本框的颜色
		textview.setTextColor(textcolor);
		
		//定义字体大小
		textview.setTextSize(20.0f);
		
		//设置文本框的文本
		textview.setText("记录\t 名字\n"+result);	
	}

	//getContactInfo()获取联系人列表的信息，返回String对象
	public String getContactInfo() {
		// TODO Auto-generated method stub
		String result = "";
		ContentResolver resolver = getContentResolver();
		Cursor cursor = resolver.query(contact_uri, null, null, null, null);
		
		//获取_ID字段索引
		int idIndex = cursor.getColumnIndex(Contacts._ID);
		
		//获取name字段的索引
		int nameIndex = cursor.getColumnIndex(Contacts.DISPLAY_NAME);
		
		//遍历Cursor提取数据
		cursor.moveToFirst();
		for(;!cursor.isAfterLast();cursor.moveToNext()){
			result = result+cursor.getString(idIndex)+"\t\t\t"; 
			result = result+cursor.getString(nameIndex)+"\t\n";
		}
		
		//使用close方法关闭游标
		cursor.close();
		
		//返回结果
		return result;
	}
}

