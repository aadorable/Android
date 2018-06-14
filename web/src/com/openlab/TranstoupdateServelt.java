package com.openlab;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TranstoupdateServelt extends HttpServlet {
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		String name = request.getParameter("name");
		String ssalary = request.getParameter("salary");
		int salary = Integer.parseInt(ssalary);
		String sage = request.getParameter("age");
		int age = Integer.parseInt(sage);
		Employee esingle = new Employee(id, name, salary, age);
		request.setAttribute("esingle", esingle);
		request.getRequestDispatcher("updateEmp.jsp")
				.forward(request, response);
	}
}
