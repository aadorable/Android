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
	//列表视图
	private ListView listView = null;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setTitle("浏览音乐列表信息");
		final DBHelper helpter = new DBHelper(this);
		
		//获取listview对象，引用变量和实例化对象
		listView = getListView();
		
		//查询数据，获取游标
		Cursor c = helpter.query();
		
		//列表项数组
		String[] from = {"_id", "name", "singer"};
		
		//列表项ID
		int[] to = {R.id.text0, R.id.text1, R.id.text2};
		
		//适配器
		SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.activity_query, c, from, to);   //为列表视图添加适配器
		listView.setAdapter(adapter);
		
		//提示对话框
		final AlertDialog.Builder builder = new AlertDialog.Builder(this);
		
		//设置ListView单击监听器
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?>arg0, View arg1, int arg2, long arg3){
				final long temp = arg3;
				builder.setMessage("真的要删除该记录吗？").setPositiveButton("是", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						//删除数据
						helpter.del((int)temp);
						//重新查询数据
						Cursor c = helpter.query();
						String[] from = {"_id", "name", "singer"};
						int[] to = {R.id.text0, R.id.text1, R.id.text2};
						SimpleCursorAdapter adapter = new SimpleCursorAdapter(getApplicationContext(), R.layout.activity_query, c, from, to);   //为列表视图添加适配器
						listView.setAdapter(adapter);
					}
				}).setNegativeButton("否", null);
				AlertDialog ad = builder.create();
				ad.show();
			}
		});
		helpter.close();
	}
}
