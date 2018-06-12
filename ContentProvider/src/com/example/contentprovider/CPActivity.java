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

	Uri contact_uri = Contacts.CONTENT_URI;//��ϵ�˵�URI
		
	//����TextView�Ķ���
	TextView textview;
		
	//�����ı���ɫ
	int textcolor = Color.BLACK;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		//����main.xml���ó���UI
		setContentView(R.layout.activity_cp);
		
		textview = (TextView)findViewById(R.id.textview);
		
		//����getContactInfo()������ȡ��ϵ����Ϣ
		String result = getContactInfo();
		
		//�����ı������ɫ
		textview.setTextColor(textcolor);
		
		//���������С
		textview.setTextSize(20.0f);
		
		//�����ı�����ı�
		textview.setText("��¼\t ����\n"+result);	
	}

	//getContactInfo()��ȡ��ϵ���б����Ϣ������String����
	public String getContactInfo() {
		// TODO Auto-generated method stub
		String result = "";
		ContentResolver resolver = getContentResolver();
		Cursor cursor = resolver.query(contact_uri, null, null, null, null);
		
		//��ȡ_ID�ֶ�����
		int idIndex = cursor.getColumnIndex(Contacts._ID);
		
		//��ȡname�ֶε�����
		int nameIndex = cursor.getColumnIndex(Contacts.DISPLAY_NAME);
		
		//����Cursor��ȡ����
		cursor.moveToFirst();
		for(;!cursor.isAfterLast();cursor.moveToNext()){
			result = result+cursor.getString(idIndex)+"\t\t\t"; 
			result = result+cursor.getString(nameIndex)+"\t\n";
		}
		
		//ʹ��close�����ر��α�
		cursor.close();
		
		//���ؽ��
		return result;
	}
}

