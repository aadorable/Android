package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

//ҵ���
public class Service {
	ResultSet set;
    Dao dao = new Dao();
	//ע��  ���� ����  ���� ��������
	public int regist(String id, String pwd){
		//��ȥ���ݿ���ң������ʾ�Ѿ�ע�����û�������ֱ�Ӳ���
		int i=0;
		int j=0;
		int confirm=4;
		set=dao.getSet();
		try {
			while(set.next()){
				j++;
				String name=set.getString("name");
				if(id.equals(name)){
					break;
				}
				else {
					i++;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(i==j){
			confirm=dao.insert(id, pwd);
		}
		else {
			confirm=2;
		}
		return confirm;
 }
		
	//��¼
	public int login(String id,String pwd){
		int i=0;
		int j=0;
		int confirm=4;
		set=dao.getSet();
		try {
			while(set.next()){
				j++;
				String name=set.getString("name");
				String secret=set.getString("secret");
	            if(id.equals(name) && pwd.equals(secret)){
	            	confirm=1;
	            	break;
	            }
 	            else if(id.equals(name) && !(pwd.equals(secret))){
	            	confirm=0;
	            	break;
			    }
	            else{
	            	i++;
	            }
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(i==j){
			confirm=2;
		} 
        return confirm;
	}
	//�޸�����
	public int rewrite(String id,String pwd){
		int confirm=4;
		confirm=dao.update(id, pwd); 
		return confirm; 
	}
	//�鿴����
	public String check(String id){
		try { 
			ResultSet set=dao.select(id);
			set.next();
			String secret=set.getString("secret");
			return secret;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}	   
	}
}
