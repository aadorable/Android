package mysql;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class FramePw extends JFrame{
	JTextField pass;
	JLabel labelx;
	JButton b1;
	JButton b2;
	String id;
	public FramePw(String id){
		this.id=id;
		init();
	}
	public void init(){
		this.setTitle("修改密码窗口");
		this.setLocation(760, 390);  //设置窗体显示位置    使窗体居中显示——通过查看分辨率确认值       1366/2-400/2=483    768/2-300/2=234
		this.setSize(400, 300);
	    this.setContentPane(createContentPanel()); 
	    this.setVisible(true); //创建一个内容面板(在中间添加所需要的组件或分面板)
	}
	public JPanel createContentPanel(){
		JPanel panel=new JPanel();
		panel.setLayout(new BorderLayout());   //使用边框布局  
		//加入一个标签
		labelx=new JLabel("修改密码界面",JLabel.CENTER); 
		Font font=new Font("黑体",Font.BOLD,25);
		labelx.setFont(font);
		
		panel.add(BorderLayout.NORTH,labelx);
		//创建一个中部面板
		panel.add(BorderLayout.CENTER,createCenterPanel());
		panel.add(BorderLayout.SOUTH,createBottomPanel());
		
	    return panel;	
	}
	
	public JPanel createCenterPanel(){
		JPanel panel = new JPanel();
		panel.setLayout(null);
		Font font = new Font("黑体",Font.BOLD,18);
		Font font1 = new Font("宋体", Font.BOLD, 16);
		
		JLabel label = new JLabel("新密码：");
		label.setSize(90, 40);
		label.setLocation(50, 75);
		label.setFont(font);
		
		pass = new JPasswordField();
		pass.setSize(190, 40);	
		pass.setLocation(140, 75);
		pass.setFont(font1);
		
		panel.add(label);
		panel.add(pass);
		return panel;
	}
	
	public JPanel createBottomPanel(){
		JPanel panel=new JPanel();
		panel.setLayout(new FlowLayout(1,18,18));
		b1=new JButton("确认修改");
		panel.add(b1);
		b2=new JButton("取消");
		panel.add(b2);
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Service s1=new Service();
				String pwd = pass.getText();
				int confirm=s1.rewrite(id,pwd);
				if(confirm==0||confirm==4){
					JOptionPane.showMessageDialog(FramePw.this, "修改失败 ");
				}
				else if(confirm==1){
					JOptionPane.showMessageDialog(FramePw.this, "成功修改");
				}
			}	
		});
		
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				FramePw.this.setVisible(false);
			}
		});
	return panel;
	}
}

