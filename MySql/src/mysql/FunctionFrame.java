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
		this.setTitle("���ܽ���");
	    this.setLocation(483,234);  //���ô�����ʾλ��    ʹ���������ʾ����ͨ���鿴�ֱ���ȷ��ֵ       1366/2-400/2=483    768/2-300/2=234
		this.setSize(600, 400);
	    this.setContentPane(createContentPanel()); 
	    this.setVisible(true); //����һ���������(���м��������Ҫ�����������)
	}
	public JPanel createContentPanel(){
		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(1,4,5,5));   //ʹ�ñ߿򲼾�  
		//����һ����ǩ
		b1=new JButton("�޸�����");
		panel.add(b1);
		b2=new JButton("�鿴����");
		panel.add(b2);
		b3=new JButton("�˳���¼");
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
  					JOptionPane.showMessageDialog(FunctionFrame.this, "��ѯʧ��");
  				}
  				else  {
  					JOptionPane.showMessageDialog(FunctionFrame.this, "����������: "+pwd);
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
