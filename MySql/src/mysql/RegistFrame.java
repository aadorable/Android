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
		//��ʼ������
		init();
	}
	public void init(){
		this.setTitle("ע�ᴰ��");
		this.setContentPane(createContenPanel());
		this.setSize(400,300);
		this.setLocation(760, 390);
		this.setVisible(true);
		
		//����ʽ	
	}
	public JPanel createContenPanel(){
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());     //���ñ߿򲼾�
		Font font = new Font("����",Font.BOLD,25);
		
		JLabel label = new JLabel("ע�����",JLabel.CENTER);
		panel.add(BorderLayout.NORTH,label);
		label.setFont(font);
	
		panel.add(BorderLayout.CENTER,createCenterPanel());
		
		panel.add(BorderLayout.SOUTH,createSouthPanel());
		
		return panel;
	}
	
//	public JPanel createCenterPanel(){
//		JPanel panel = new JPanel();
//		panel.setLayout(new BorderLayout());
//		Icon image = new ImageIcon("C:/Users/ASUS/Pictures/Saved Pictures/QQͼƬ2");
//		JLabel label = new JLabel(image);
//		panel.add(BorderLayout.CENTER,label);
//		panel.add(BorderLayout.SOUTH,createIdOrPwdPanel());	
//	}
	
	public JPanel createCenterPanel(){
		JPanel panel = new JPanel();
		panel.setLayout(null);
		Font font = new Font("����",Font.BOLD,18);
		Font font1 = new Font("����", Font.BOLD, 16);
		
		//����û���������
		JLabel label1 = new JLabel("�û�����");
		label1.setSize(90, 40);
		label1.setLocation(50, 50);
		label1.setFont(font);
		
		JLabel label2 = new JLabel("��  �룺");
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
		panel.setLayout(new FlowLayout());      //������
		Font font = new Font("����",Font.BOLD,15);
		
		b1 = new JButton("ע��");
		b1.setFont(font);
		
		b2 = new JButton("��¼");
		b2.setFont(font);
		
		b3 = new JButton("ȡ��");
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
					JOptionPane.showMessageDialog(RegistFrame.this, "ע��ʧ�ܣ�������ע��");
				}
				else if(confirm==1){
					JOptionPane.showMessageDialog(RegistFrame.this, "�ɹ�ע��");
				}
				else if(confirm==2){
					JOptionPane.showMessageDialog(RegistFrame.this, "���û��ѱ�ע���");
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
			    JOptionPane.showMessageDialog(RegistFrame.this, "������������µ�¼");
			    }
				else if(confirm==1){
					
				JOptionPane.showMessageDialog(RegistFrame.this, "�ɹ���¼");
				FunctionFrame ff=new FunctionFrame(id);
				}
				else if(confirm==2){
					JOptionPane.showMessageDialog(RegistFrame.this, "���û���δ��ע�ᣬ����ע��");
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
