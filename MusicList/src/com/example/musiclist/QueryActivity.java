package com.example.musiclist;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.CursorAdapter;
import android.text.AlteredCharSequence;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class QueryActivity extends ListActivity {
	//�б���ͼ
	private ListView listView = null;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setTitle("��������б���Ϣ");
		final DBHelper helpter = new DBHelper(this);
		
		//��ȡlistview�������ñ�����ʵ��������
		listView = getListView();
		
		//��ѯ���ݣ���ȡ�α�
		Cursor c = helpter.query();
		
		//�б�������
		String[] from = {"_id", "name", "singer"};
		
		//�б���ID
		int[] to = {R.id.text0, R.id.text1, R.id.text2};
		
		//������
		SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.activity_query, c, from, to);   //Ϊ�б���ͼ���������
		listView.setAdapter(adapter);
		
		//��ʾ�Ի���
		final AlertDialog.Builder builder = new AlertDialog.Builder(this);
		
		//����ListView����������
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?>arg0, View arg1, int arg2, long arg3){
				final long temp = arg3;
				builder.setMessage("���Ҫɾ���ü�¼��").setPositiveButton("��", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						//ɾ������
						helpter.del((int)temp);
						//���²�ѯ����
						Cursor c = helpter.query();
						String[] from = {"_id", "name", "singer"};
						int[] to = {R.id.text0, R.id.text1, R.id.text2};
						SimpleCursorAdapter adapter = new SimpleCursorAdapter(getApplicationContext(), R.layout.activity_query, c, from, to);   //Ϊ�б���ͼ���������
						listView.setAdapter(adapter);
					}
				}).setNegativeButton("��", null);
				AlertDialog ad = builder.create();
				ad.show();
			}
		});
		helpter.close();
	}
}
