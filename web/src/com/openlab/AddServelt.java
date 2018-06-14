package com.openlab;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddServelt extends HttpServlet {
	String salary;
	String name;
	String age;

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		name = request.getParameter("name");
		age = request.getParameter("age");
		salary = request.getParameter("salary");
		Service s1 = new Service();
		int confirm = s1.add(name, salary, age);
		if (confirm == 0 || confirm == 4) {

			request.setAttribute("message", "����ʧ�� �����¼���");
			request.getRequestDispatcher("error.jsp")
					.forward(request, response);
		} else if (confirm == 1) {
			request.setAttribute("message", "�ɹ�����");
			ArrayList<Employee> es = s1.acquireEmp();
			request.setAttribute("es", es);
			request.getRequestDispatcher("emplist.jsp").forward(request,
					response);
		}
		// response.sendRedirect("list");//������������Ͳ������������ ����������һ������ �൱���ַ�һ������
		// ������������������ַ�ʱ ������ҳ����utf-8���� �����ݿ���õ���GB���� ���������ݿ�洢�������ַ�ʱ ����뷽ʽ��һ���ͻ��������
		// �����ٴ���ʾ����ҳ��ʱ��������
	}
}
