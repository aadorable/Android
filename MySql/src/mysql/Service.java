package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

//业务层
public class Service {
	ResultSet set;
    Dao dao = new Dao();
	//注册  —— 方法  —— 功能描述
	public int regist(String id, String pwd){
		//先去数据库查找，有则表示已经注册过，没有则可以直接插入
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
		
	//登录
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
	//修改密码
	public int rewrite(String id,String pwd){
		int confirm=4;
		confirm=dao.update(id, pwd); 
		return confirm; 
	}
	//查看密码
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
