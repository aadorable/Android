package day2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sql = "select * from branch";
		
		String sql1 = "desc branch";
		
		String s1 = "select * from staff";
		
		String s2 = "select branchId,MAX(salary) from staff group by branchId";
		
		//ע������
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//��ȡ����
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "1234");
			//����һ��������  ��������  ���ݵ�����
			Statement stat = conn.createStatement();
			//���ݼ���
			ResultSet set1 = stat.executeQuery(sql);
			while(set1.next()){   //�ж���û����һ������
				String branchId = set1.getString("branchId");
				String branchName = set1.getString("branchName");
				String city = set1.getString("city");
				
				System.out.println(branchId+" "+branchName+" "+city);
				//�α�
			}
			System.out.println();
			
			ResultSet set2 = stat.executeQuery(sql1);
			while(set2.next()){   //�ж���û����һ������
				String field = set2.getString("Field");
				String type = set2.getString("type");
				String isnull = set2.getString("Null");
				String key = set2.getString("Key");
				String isdefault = set2.getString("Default");
				String extra = set2.getString("Extra");
				
				System.out.println(field+" "+type+" "+isnull+" "+key+" "+isdefault+" "+extra);
				//�α�
			}
			System.out.println();
			
			ResultSet st1 = stat.executeQuery(s1);
			while(st1.next()){
				String sId = st1.getString("sId");
				String sName = st1.getString("sName");
				String sex = st1.getString("sex");
				double salary = st1.getDouble("salary");
				String sDate = st1.getString("sDate");
				String leaderName = st1.getString("leaderName");
				String branchId = st1.getString("branchId");
		
				System.out.println(sId+" "+sName+"  "+sex+"  "+salary+"  "+sDate+"  "+leaderName+"  "+branchId);
			}
			System.out.println();
			
			ResultSet st2 = stat.executeQuery(s2);
			while(st2.next()){
				double MAXsalary = st2.getDouble("MAX(salary)");
				String branchId = st2.getString("branchId");
		
				System.out.println(branchId+" "+MAXsalary);
			}
			System.out.println();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
