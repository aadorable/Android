package mysql;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class FunctionFrame extends JFrame{
	JButton b1;
	JButton b2;
	JButton b3;
    String id;

	public FunctionFrame(String id){
		this.id=id;
		init();
	}
	public void init(){
		this.setTitle("功能界面");
	    this.setLocation(483,234);  //设置窗体显示位置    使窗体居中显示——通过查看分辨率确认值       1366/2-400/2=483    768/2-300/2=234
		this.setSize(600, 400);
	    this.setContentPane(createContentPanel()); 
	    this.setVisible(true); //创建一个内容面板(在中间添加所需要的组件或分面板)
	}
	public JPanel createContentPanel(){
		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(1,4,5,5));   //使用边框布局  
		//加入一个标签
		b1=new JButton("修改密码");
		panel.add(b1);
		b2=new JButton("查看密码");
		panel.add(b2);
		b3=new JButton("退出登录");
		panel.add(b3);
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			 FramePw fp=new FramePw(id);
						}
		});
		b2.addActionListener(new ActionListener() {
			
  			@Override
  			public void actionPerformed(ActionEvent arg0) {
  				Service s1=new Service();
  				String pwd=s1.check(id);
  				if(pwd==null){
  					JOptionPane.showMessageDialog(FunctionFrame.this, "查询失败");
  				}
  				else  {
  					JOptionPane.showMessageDialog(FunctionFrame.this, "您的密码是: "+pwd);
  				}
  			}
  		});
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			FunctionFrame.this.setVisible(false);	
			}
		});
		return panel;	
	}
}
