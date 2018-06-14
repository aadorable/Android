package com.openlab;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateServelt extends HttpServlet {
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		Service s1 = new Service();
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String salary = request.getParameter("salary");
		String age = request.getParameter("age");
		int confirm = s1.update(id, name, salary, age);
		if (confirm == 0 || confirm == 4) {

			request.setAttribute("message", "更新失败 请重新更新");
			request.getRequestDispatcher("error.jsp")
					.forward(request, response);
		} else if (confirm == 1) {
			request.setAttribute("message", "成功更新");
			ArrayList<Employee> es = s1.acquireEmp();
			request.setAttribute("es", es);
			request.getRequestDispatcher("emplist.jsp").forward(request,
					response);
		}
	}
}
