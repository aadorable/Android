package com.example.music;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class QueryActivity extends ListActivity {
	
	//�б���ͼ
	private ListView listView = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//��ȡlistview�������ñ�����ʵ������
		listView=getListView();
		
		this.setTitle("��ϵ����Ϣ");
		final DBHelper helpter = new DBHelper(this);
		
		//��ѯ���ݣ���ȡ�α�
		Cursor c = helpter.query();
		
		//�б�������
		String[] from = {"_id","name","phonenum"};
		
		//�б���ID
		int[] to = {R.id.text0,R.id.text1,R.id.text2 };
		
		//������,Ϊ�б���ͼ���������
		SimpleCursorAdapter  adapter = new  SimpleCursorAdapter(
				this, R.layout.activity_query, c, from, to);
		listView.setAdapter(adapter);
		
		//helpter.close();		
		
	}
}

