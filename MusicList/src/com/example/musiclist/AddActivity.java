package com.example.musiclist;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends Activity {
	private EditText et1, et2;
	private Button b1;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add);
		this.setTitle("����ղ���Ϣ");
		et1 = (EditText)findViewById(R.id.EditTextName);
		et2 = (EditText)findViewById(R.id.EditTextSinger);
		b1 = (Button)findViewById(R.id.ButtonAdd);
		b1.setOnClickListener(new OnClickListener() {	
			public void onClick(View v) {
				// ��ȡ�û�������ı���Ϣ
				String name = et1.getText().toString();
				String singer = et2.getText().toString();
				
				//����ContentValues���󡣷�װ��¼��Ϣ    key �� values ֵ�ɶԳ���
				ContentValues values = new ContentValues();
				values.put("name", name);
				values.put("singer", singer);
				
				//�������ݿ⹤����DBHelper
				DBHelper helper = new DBHelper(getApplicationContext());
				
				//����insert()������������
				helper.insert(values);
				
				//��ת��QueryActivity����ʾ�����б�
				Intent intent = new Intent(AddActivity.this, QueryActivity.class);
				startActivity(intent);
			}
		});
	}
}

