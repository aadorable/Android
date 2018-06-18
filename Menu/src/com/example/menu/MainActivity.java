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
	 * 重写onCreateOptinsMenu()方法添加选项菜单
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		//添加菜单
		menu.add(0, ITEM, 0, "开始");	
		menu.add(0, ITEM+1, 0, "退出");
		return true;
	}
	
	/**
	 * 重写onOptionsItemSelected()方法，响应选项菜单被单击事件
	 */
	public boolean onOptionsItemSelected(MenuItem item){
		switch(item.getItemId()){
		case ITEM:
			//设置Activity标题
			setTitle("开始游戏！");
			break;
		case ITEM+1:
			setTitle("退出！");
		break;
		}
		return true;
	}

}
