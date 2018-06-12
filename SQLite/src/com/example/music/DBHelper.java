package com.example.music;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper  extends SQLiteOpenHelper{
	
	private static final String DB_NAME ="content.db"; //数据库名
	private static final String TBL_NAME="Message"; //表名
	private SQLiteDatabase   db;  //声明SQLiteDatabase对象
	
	//构造函数
	public DBHelper(Context c) {
		super(c, DB_NAME, null, 2);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		
		 //获取SQLiteDatabase对象
	     this.db=db;
	     
	     //创建表
	     String CREATE_TBL = "create table Message(_id integer primary key autoincrement,name text,phonenum text)";
	     db.execSQL(CREATE_TBL);
		
	}
	
	//插入
		public void insert(ContentValues values){
			SQLiteDatabase  db= getWritableDatabase();
			db.insert(TBL_NAME, null, values);
			db.close();
		}
	
	//查询
	public Cursor query(){
		SQLiteDatabase  db = getWritableDatabase();
		Cursor  c = db.query(TBL_NAME, null, null, null, null, null, null );
		return c;
	}
	
	//关闭数据库
	public void close(){
		if(db!=null){
			db.close();
		}
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
}

