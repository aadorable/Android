package com.example.music;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class QueryActivity extends ListActivity {
	
	//列表视图
	private ListView listView = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//获取listview对象，引用变量和实例对象
		listView=getListView();
		
		this.setTitle("联系人信息");
		final DBHelper helpter = new DBHelper(this);
		
		//查询数据，获取游标
		Cursor c = helpter.query();
		
		//列表项数组
		String[] from = {"_id","name","phonenum"};
		
		//列表项ID
		int[] to = {R.id.text0,R.id.text1,R.id.text2 };
		
		//适配器,为列表视图添加适配器
		SimpleCursorAdapter  adapter = new  SimpleCursorAdapter(
				this, R.layout.activity_query, c, from, to);
		listView.setAdapter(adapter);
		
		//helpter.close();		
		
	}
}

