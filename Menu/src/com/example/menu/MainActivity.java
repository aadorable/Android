package com.example.menu;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

	private final static int ITEM = Menu.FIRST;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	/**
	 * ��дonCreateOptinsMenu()�������ѡ��˵�
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		//��Ӳ˵�
		menu.add(0, ITEM, 0, "��ʼ");	
		menu.add(0, ITEM+1, 0, "�˳�");
		return true;
	}
	
	/**
	 * ��дonOptionsItemSelected()��������Ӧѡ��˵��������¼�
	 */
	public boolean onOptionsItemSelected(MenuItem item){
		switch(item.getItemId()){
		case ITEM:
			//����Activity����
			setTitle("��ʼ��Ϸ��");
			break;
		case ITEM+1:
			setTitle("�˳���");
		break;
		}
		return true;
	}

}
