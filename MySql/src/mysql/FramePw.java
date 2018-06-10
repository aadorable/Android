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
		this.setTitle("�޸����봰��");
		this.setLocation(760, 390);  //���ô�����ʾλ��    ʹ���������ʾ����ͨ���鿴�ֱ���ȷ��ֵ       1366/2-400/2=483    768/2-300/2=234
		this.setSize(400, 300);
	    this.setContentPane(createContentPanel()); 
	    this.setVisible(true); //����һ���������(���м��������Ҫ�����������)
	}
	public JPanel createContentPanel(){
		JPanel panel=new JPanel();
		panel.setLayout(new BorderLayout());   //ʹ�ñ߿򲼾�  
		//����һ����ǩ
		labelx=new JLabel("�޸��������",JLabel.CENTER); 
		Font font=new Font("����",Font.BOLD,25);
		labelx.setFont(font);
		
		panel.add(BorderLayout.NORTH,labelx);
		//����һ���в����
		panel.add(BorderLayout.CENTER,createCenterPanel());
		panel.add(BorderLayout.SOUTH,createBottomPanel());
		
	    return panel;	
	}
	
	public JPanel createCenterPanel(){
		JPanel panel = new JPanel();
		panel.setLayout(null);
		Font font = new Font("����",Font.BOLD,18);
		Font font1 = new Font("����", Font.BOLD, 16);
		
		JLabel label = new JLabel("�����룺");
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
		b1=new JButton("ȷ���޸�");
		panel.add(b1);
		b2=new JButton("ȡ��");
		panel.add(b2);
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Service s1=new Service();
				String pwd = pass.getText();
				int confirm=s1.rewrite(id,pwd);
				if(confirm==0||confirm==4){
					JOptionPane.showMessageDialog(FramePw.this, "�޸�ʧ�� ");
				}
				else if(confirm==1){
					JOptionPane.showMessageDialog(FramePw.this, "�ɹ��޸�");
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

