package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//dao �� ��װ  ����  ���ʲ�
public class Dao {
	ResultSet set;
	String sql1="select * from register";
	Statement stat;
	public Dao(){
		try {
			//ע������	
			Class.forName("com.mysql.jdbc.Driver");//���������ҵ���
			//��ȡ����
			Connection conn=  DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root","1234");//������һ���������ҵ�mysql���������ڴ�����IP��ַ���˴�Ϊ������ַ��+�˿ں�+���ݿ���  �ڶ�����������root���û����� �������ǽ������ݿ������
			String sql1="select * from register";
			stat = conn.createStatement();
			set=stat.executeQuery(sql1);	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();	
		}   //��δ�ҵ��쳣
        catch (SQLException e) {
			e.printStackTrace();
		}//SQL�쳣
	}
	
	public  int insert(String id,String pwd){
		String sql2="insert into register values('";
		sql2=sql2+id+"','"+pwd+"')";
		try {
			int n=stat.executeUpdate(sql2);
			return n;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 4;
		}
	}
	
	public  int update(String id,String pwd){
		String sql3="update register set secret='"+pwd+"' where name='"+id+"'";
		try {
			int n=stat.executeUpdate(sql3);
			return n;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 4;
		}	  
	 }
	
	 public  ResultSet select(String id) {
		String sql4="select secret from register where name='"+id+"'";
		try {
			ResultSet set=stat.executeQuery(sql4);
			return set;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
		
	public ResultSet getSet(){
		return set;
	}
}
