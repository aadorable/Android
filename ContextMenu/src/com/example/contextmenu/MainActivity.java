package com.example.contextmenu;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
	private static final int ITEM1=Menu.FIRST;
	private static final int ITEM2=Menu.FIRST+1;
	private static final int ITEM3=Menu.FIRST+3;
	private static final int ITEM4=Menu.FIRST+4;
	private static final int ITEM5=Menu.FIRST+5;
	//�����ı���ͼ
	private TextView myTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //����id��ȡ�ı���ͼ
        myTV = (TextView)findViewById(R.id.TextView);
        //���ı���ͼ��ע�������Ĳ˵�
        registerForContextMenu(myTV);
    }
    
    /**
     * ��дonCreateOptions�������ѡ��˵�
     */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// ��Ӳ˵���
		menu.add(0,ITEM1,0,"��ʼ");
		menu.add(0,ITEM2,0,"�˳�");
		return true;
	}
	
    /**
     * ��дonOptionsItemSelected��������Ӧѡ��˵��������¼�
     */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
		case ITEM1:
			//����Activity�ı���
			setTitle("��ʼ��Ϸ��");
			break;
		case ITEM2:
			setTitle("�˳���");
			break;
		}
		return true;
	}
	
	/**
	 * ��дonCreateContextMenu������������Ĳ˵�
	 */
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// ��Ӳ˵���
		menu.add(0,ITEM3,0,"��ɫ����");
		menu.add(0,ITEM4,0,"��ɫ����");
		menu.add(0,ITEM5,0,"��ɫ����");
	}
	
	/**
	 * ��д��������Ӧ�����Ĳ˵��������¼�
	 */
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		switch(item.getItemId()){
		case ITEM3:
				// �����ı���ͼ�ı�����ɫ
			myTV.setBackgroundColor(Color.RED);
			break;
		case ITEM4:
			myTV.setBackgroundColor(Color.GREEN);
			break;
		case ITEM5:
			myTV.setBackgroundColor(Color.WHITE);
			break;
		}
		return true;
	}
}
