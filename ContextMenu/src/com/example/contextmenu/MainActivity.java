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
	//声明文本视图
	private TextView myTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //根据id获取文本视图
        myTV = (TextView)findViewById(R.id.TextView);
        //在文本视图上注册上下文菜单
        registerForContextMenu(myTV);
    }
    
    /**
     * 重写onCreateOptions方法添加选项菜单
     */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// 添加菜单项
		menu.add(0,ITEM1,0,"开始");
		menu.add(0,ITEM2,0,"退出");
		return true;
	}
	
    /**
     * 重写onOptionsItemSelected方法，响应选项菜单被单击事件
     */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
		case ITEM1:
			//设置Activity的标题
			setTitle("开始游戏！");
			break;
		case ITEM2:
			setTitle("退出！");
			break;
		}
		return true;
	}
	
	/**
	 * 重写onCreateContextMenu方法添加上下文菜单
	 */
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// 添加菜单项
		menu.add(0,ITEM3,0,"红色背景");
		menu.add(0,ITEM4,0,"绿色背景");
		menu.add(0,ITEM5,0,"白色背景");
	}
	
	/**
	 * 重写方法，响应上下文菜单被单击事件
	 */
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		switch(item.getItemId()){
		case ITEM3:
				// 设置文本视图的背景颜色
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
