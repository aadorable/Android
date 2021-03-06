package com.example.musiclist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class DBHelper extends SQLiteOpenHelper{
	private static final String DB_NAME = "music.db";    //数据库名称
	private static final String TBL_NAME = "MusicTbl";    //表名
	private SQLiteDatabase db;    //声明SQLiteDatabase对象
	
	//构造函数
	DBHelper(Context c){
		super(c, DB_NAME, null, 2);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db){
		//获取SQLiteDatabase对象
		this.db = db;
		//创建表
		String CREATE_TBL = "create table MusicTbl(_id integer primary key autoincrement, name text, singer text)";
		db.execSQL(CREATE_TBL);
	}
	
	//插入
	public void insert(ContentValues values){
		SQLiteDatabase db = getWritableDatabase();
		db.insert(TBL_NAME, null, values);
		db.close();
	}
	
	//查询
	public Cursor query(){
		SQLiteDatabase db = getWritableDatabase();
		Cursor c = db.query(TBL_NAME, null, null, null, null, null, null);
		return c;
	}

	//删除
	public void del(int id){
		if(db == null){
			db = getWritableDatabase();
		}
		db.delete(TBL_NAME, "_id=?", new String[]{String.valueOf(id)});
	}
	
	//关闭数据库
	public void close(){
		if(db != null){
			db.close();
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}
}
