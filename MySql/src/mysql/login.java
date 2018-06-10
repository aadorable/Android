package mysql;

import java.awt.*;
import javax.swing.*;

public class login extends JFrame{

	public JLabel la1;
	public JLabel la2;
	public JTextField tx1;
	public JPasswordField pa1;
	public JButton bt1;
	public JButton bt2;
		
	public login()
	{
		this.setSize(500, 380);
		this.setLocation(760, 390);
		this.setTitle("登录窗体");
		
		//创建用户名标签
		la1=new JLabel("用户名");
		la1.setSize(90, 40);
		la1.setLocation(80, 60);
		
		//创建密码标签
		la2=new JLabel("密   码");
		la2.setSize(90, 40);
		la2.setLocation(80, 130);
		
		//定义用户名标签的位置
		tx1=new JTextField();
		tx1.setSize(260, 40);
		tx1.setLocation(140, 60);
		
		//定义密码标签的位置
		pa1=new JPasswordField();
		pa1.setSize(260, 40);
		pa1.setLocation(140, 130);
			
		bt1=new JButton("登录");
		bt1.setSize(70, 40);
		bt1.setLocation(160, 210);
			
		bt2=new JButton("退出");
		bt2.setSize(70, 40);
		bt2.setLocation(290, 210);
		this.setLayout(null);
		//设置容器的默认布局方式为空
		this.add(la1);
		this.add(la2);
		this.add(tx1);
		this.add(pa1);
		this.add(bt1);
		this.add(bt2);
			
		this.setVisible(true);
	}

}

