package com.openlab;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteServelt extends HttpServlet {
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		Service s1 = new Service();
		String id = request.getParameter("id");
		int confirm = s1.delete(id);
		if (confirm == 0 || confirm == 4) {

			request.setAttribute("message", "ɾ��ʧ�� ������ɾ��");
			request.getRequestDispatcher("error.jsp")
					.forward(request, response);
		} else if (confirm == 1) {
			request.setAttribute("message", "�ɹ�ɾ��");
			response.sendRedirect("list");
			// ������������Ͳ������������ ����������һ������ �൱���ַ�һ������7
		}
	}
}
