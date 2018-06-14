package com.openlab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

//业务层   
public class Service {
	ResultSet set;
	Statement stat;
	String sql1 = "select * from custom";
	String sql2 = "select * from emp";
	Da0 dao = new Da0();

	// 注册
	public int regist(String id, String pwd, String name, String sex) {
		int i = 0;
		int j = 0;
		int confirm = 4;
		stat = dao.getStat();
		try {
			set = stat.executeQuery(sql1);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			while (set.next()) {
				j++;
				String username = set.getString("username");
				if (id.equals(username)) {
					break;
				} else {
					i++;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (i == j) {
			confirm = dao.insert(id, pwd, name, sex);
		} else {
			confirm = 2;
		}

		return confirm;

	}

	// 登录
	public int login(String id, String pwd) {
		int i = 0;
		int j = 0;
		int confirm = 4;
		stat = dao.getStat();
		try {
			set = stat.executeQuery(sql1);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			while (set.next()) {
				j++;
				String username = set.getString("username");
				String Pwd = set.getString("pwd");
				if (id.equals(username) && pwd.equals(Pwd)) {
					confirm = 1;
					break;
				} else if (id.equals(username) && !(pwd.equals(Pwd))) {

					confirm = 0;
					break;
				} else {
					i++;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (i == j) {
			confirm = 2;
		}
		return confirm;

	}

	// 添加员工至数据库emp表中
	public int add(String name, String salary, String age) {

		int confirm = 4;
		stat = dao.getStat();
		try {
			set = stat.executeQuery(sql2);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		confirm = dao.add(name, salary, age);
		return confirm;
	}

	// 从数据库emp表中删除员工
	public int delete(String id) {

		int confirm = 4;
		stat = dao.getStat();
		try {
			set = stat.executeQuery(sql2);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		confirm = dao.delete(id);
		return confirm;
	}

	public int update(String id, String name, String salary, String age) {

		int confirm = 4;
		stat = dao.getStat();
		try {
			set = stat.executeQuery(sql2);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		confirm = dao.update(id, name, salary, age);
		return confirm;
	}

	public ArrayList<Employee> acquireEmp() {
		ArrayList<Employee> es = new ArrayList<Employee>();
		set = dao.selectAll();
		try {
			while (set.next()) {
				int id = set.getInt("id");
				String name = set.getString("name");
				int salary = set.getInt("salary");
				int age = set.getInt("age");
				Employee e = new Employee(id, name, salary, age);
				es.add(e);
			}
			return es;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

}
