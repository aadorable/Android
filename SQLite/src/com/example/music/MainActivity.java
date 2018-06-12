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

	Uri contact_uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;//��ϵ�˵�URI
	
	//�������
	private Button bt;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		//����main.xml���ó���UI
		setContentView(R.layout.activity_main);
		
		//��ȡ���
		bt=(Button)findViewById(R.id.button);
		
		//���ü�����
        bt.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
			
				//��ת��QueryActivity����ʾ��ϵ���б�
				Intent intent = new Intent(MainActivity.this,QueryActivity.class);
				startActivity(intent);
			}
	    });
 }
			
	//getContactInfo()��ȡ��ϵ���б����Ϣ������String����
	public String getContactInfo() {
		// TODO Auto-generated method stub
		String result = "";
		ContentResolver resolver = getContentResolver();
		Cursor cursor = resolver.query(contact_uri, null, null, null, null);
		
		//��ȡ_ID�ֶ�����
		//int idIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.CONTACT_ID);
				
		//��ȡname�ֶε�����
		int nameIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
				
		//��ȡphonenum�ֶε�����
		int phonenumIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
		
		//����Cursor��ȡ����
		cursor.moveToFirst();
		for(;!cursor.isAfterLast();cursor.moveToNext()){

			result = result+cursor.getString(nameIndex)+"\t\t";
			result = result+cursor.getString(phonenumIndex)+"\t\n";
			
			String name=cursor.getString(nameIndex);
			String phonenum=cursor.getString(phonenumIndex);
			
			ContentValues values=new ContentValues();
			values.put("name", name);
			values.put("phonenum", phonenum);

			//�������ݿ⹤����DBHelper
			DBHelper helper = new DBHelper(getApplicationContext());
			
			//����insert()������������
			helper.insert(values);
			
		}		
		
		//ʹ��close�����ر��α�
		cursor.close();
		
		//���ؽ��
		return result;
	}
}
