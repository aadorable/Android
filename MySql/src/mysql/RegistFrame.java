package mysql;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class RegistFrame extends JFrame{
	static JTextField text;
	static JPasswordField pass;
	static JButton b1;
    static JButton b2;
    static JButton b3;
	
	public RegistFrame(){
		//初始化窗口
		init();
	}
	public void init(){
		this.setTitle("注册窗口");
		this.setContentPane(createContenPanel());
		this.setSize(400,300);
		this.setLocation(760, 390);
		this.setVisible(true);
		
		//三段式	
	}
	public JPanel createContenPanel(){
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());     //设置边框布局
		Font font = new Font("黑体",Font.BOLD,25);
		
		JLabel label = new JLabel("注册界面",JLabel.CENTER);
		panel.add(BorderLayout.NORTH,label);
		label.setFont(font);
	
		panel.add(BorderLayout.CENTER,createCenterPanel());
		
		panel.add(BorderLayout.SOUTH,createSouthPanel());
		
		return panel;
	}
	
//	public JPanel createCenterPanel(){
//		JPanel panel = new JPanel();
//		panel.setLayout(new BorderLayout());
//		Icon image = new ImageIcon("C:/Users/ASUS/Pictures/Saved Pictures/QQ图片2");
//		JLabel label = new JLabel(image);
//		panel.add(BorderLayout.CENTER,label);
//		panel.add(BorderLayout.SOUTH,createIdOrPwdPanel());	
//	}
	
	public JPanel createCenterPanel(){
		JPanel panel = new JPanel();
		panel.setLayout(null);
		Font font = new Font("黑体",Font.BOLD,18);
		Font font1 = new Font("宋体", Font.BOLD, 16);
		
		//添加用户名和密码
		JLabel label1 = new JLabel("用户名：");
		label1.setSize(90, 40);
		label1.setLocation(50, 50);
		label1.setFont(font);
		
		JLabel label2 = new JLabel("密  码：");
		label2.setSize(90, 40);
		label2.setLocation(50, 100);
		label2.setFont(font);
		
		text = new JTextField();
		text.setSize(190, 40);
		text.setLocation(140, 50);
		text.setFont(font1);
		
		pass = new JPasswordField();
		pass.setSize(190, 40);	
		pass.setLocation(140, 100);
		pass.setFont(font1);
		
		panel.add(label1);
		panel.add(text);
		panel.add(label2);
		panel.add(pass);

		
		return panel;
	}
	
	public JPanel createSouthPanel(){
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());      //流布局
		Font font = new Font("黑体",Font.BOLD,15);
		
		b1 = new JButton("注册");
		b1.setFont(font);
		
		b2 = new JButton("登录");
		b2.setFont(font);
		
		b3 = new JButton("取消");
		b3.setFont(font);
		
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Service s1=new Service();
				String id = text.getText();
				String pwd = pass.getText();
				int confirm=s1.regist(id,pwd);
				if(confirm==0||confirm==4){
					JOptionPane.showMessageDialog(RegistFrame.this, "注册失败，请重新注册");
				}
				else if(confirm==1){
					JOptionPane.showMessageDialog(RegistFrame.this, "成功注册");
				}
				else if(confirm==2){
					JOptionPane.showMessageDialog(RegistFrame.this, "该用户已被注册过");
				}
			}
		});
		
b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Service s1=new Service();
				String id = text.getText();
				String pwd = pass.getText();
				int confirm=s1.login(id, pwd);
			    if(confirm==0){
			    JOptionPane.showMessageDialog(RegistFrame.this, "密码错误请重新登录");
			    }
				else if(confirm==1){
					
				JOptionPane.showMessageDialog(RegistFrame.this, "成功登录");
				FunctionFrame ff=new FunctionFrame(id);
				}
				else if(confirm==2){
					JOptionPane.showMessageDialog(RegistFrame.this, "该用户还未被注册，请先注册");
				}
					
			}	
		});
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				RegistFrame.this.setVisible(false);				
			}
		});
		
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		return panel;
	}

}
