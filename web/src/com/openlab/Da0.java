package com.openlab;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Da0 {
	Statement stat;

	public Da0() {
		try {
			// ע������
			Class.forName("com.mysql.jdbc.Driver");// ���������ҵ���
			// ��ȡ����
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/test", "root", "1234");// ������һ���������ҵ�mysql���������ڴ�����IP��ַ���˴�Ϊ������ַ��+�˿ں�+���ݿ���
			// �ڶ�����������root���û�����
			// �������ǽ������ݿ������

			stat = conn.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} // ��δ�ҵ��쳣
		catch (SQLException e) {
			e.printStackTrace();

		}// SQL�쳣
	}

	public int insert(String id, String pwd, String name, String sex) {
		String sql1 = "insert into custom values('";
		sql1 = sql1 + id + "','" + pwd + "','" + name + "','" + sex + "')";
		try {
			int n = stat.executeUpdate(sql1);
			return n;
		} catch (SQLException e) {

			e.printStackTrace();
			return 4;
		}
	}

	public int add(String name, String salary, String age) {
		String sql2 = "insert into emp(name,salary,age) values('";
		sql2 = sql2 + name + "'," + salary + "," + age + ")";
		try {
			int n = stat.executeUpdate(sql2);
			return n;
		} catch (SQLException e) {

			e.printStackTrace();
			return 4;
		}
	}

	public int delete(String id) {
		String sql4 = "delete from emp where id=" + id;
		try {
			int n = stat.executeUpdate(sql4);
			return n;
		} catch (SQLException e) {

			e.printStackTrace();
			return 4;
		}
	}

	public int update(String id, String name, String salary, String age) {
		String sql5 = "update emp set name='" + name + "',salary=" + salary
				+ ",age=" + age + " where id=" + id;
		try {
			int n = stat.executeUpdate(sql5);
			return n;
		} catch (SQLException e) {

			e.printStackTrace();
			return 4;
		}
	}

	public ResultSet selectAll() {
		String sql3 = "select * from emp";
		try {
			ResultSet set = stat.executeQuery(sql3);
			return set;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Statement getStat() {
		return stat;
	}
}
