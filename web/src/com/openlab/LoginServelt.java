package com.openlab;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServelt extends HttpServlet {
	String id;
	String pwd;

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		id = request.getParameter("name");
		pwd = request.getParameter("pwd");
		Service s1 = new Service();
		PrintWriter out = response.getWriter();
		int confirm = s1.login(id, pwd);
		if (confirm == 0) {
			request.setAttribute("message", "��¼ʧ�� �����µ�¼");
			request.getRequestDispatcher("error.jsp")
					.forward(request, response);

		} else if (confirm == 1) {
			request.setAttribute("message", "�ɹ���¼");
			response.sendRedirect("list");
			// ������������Ͳ������������ ����������һ������ �൱���ַ�һ������

		} else if (confirm == 2) {

			request.setAttribute("message", "���û���δ��ע��,����ע��");
			request.getRequestDispatcher("inexistent.jsp").forward(request,
					response);
		}

	}

}
