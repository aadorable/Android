package com.example.music;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper  extends SQLiteOpenHelper{
	
	private static final String DB_NAME ="content.db"; //���ݿ���
	private static final String TBL_NAME="Message"; //����
	private SQLiteDatabase   db;  //����SQLiteDatabase����
	
	//���캯��
	public DBHelper(Context c) {
		super(c, DB_NAME, null, 2);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		
		 //��ȡSQLiteDatabase����
	     this.db=db;
	     
	     //������
	     String CREATE_TBL = "create table Message(_id integer primary key autoincrement,name text,phonenum text)";
	     db.execSQL(CREATE_TBL);
		
	}
	
	//����
		public void insert(ContentValues values){
			SQLiteDatabase  db= getWritableDatabase();
			db.insert(TBL_NAME, null, values);
			db.close();
		}
	
	//��ѯ
	public Cursor query(){
		SQLiteDatabase  db = getWritableDatabase();
		Cursor  c = db.query(TBL_NAME, null, null, null, null, null, null );
		return c;
	}
	
	//�ر����ݿ�
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

