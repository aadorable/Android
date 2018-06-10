package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//dao 层 封装  数据  访问层
public class Dao {
	ResultSet set;
	String sql1="select * from register";
	Statement stat;
	public Dao(){
		try {
			//注册驱动	
			Class.forName("com.mysql.jdbc.Driver");//根据类名找到类
			//获取连接
			Connection conn=  DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root","1234");//函数第一个参数是找到mysql服务器所在处——IP地址（此处为本机地址）+端口号+数据库名  第二个参数则是root（用户名） 第三个是进入数据库的密码
			String sql1="select * from register";
			stat = conn.createStatement();
			set=stat.executeQuery(sql1);	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();	
		}   //类未找到异常
        catch (SQLException e) {
			e.printStackTrace();
		}//SQL异常
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
