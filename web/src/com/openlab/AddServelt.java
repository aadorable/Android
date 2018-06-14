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

			request.setAttribute("message", "加入失败 请重新加入");
			request.getRequestDispatcher("error.jsp")
					.forward(request, response);
		} else if (confirm == 1) {
			request.setAttribute("message", "成功加入");
			ArrayList<Employee> es = s1.acquireEmp();
			request.setAttribute("es", es);
			request.getRequestDispatcher("emplist.jsp").forward(request,
					response);
		}
		// response.sendRedirect("list");//告诉浏览器发送参数代表的请求 （这是另外一次请求 相当于又发一次请求）
		// 当加入的数据是中文字符时 由于网页采用utf-8编码 而数据库采用的是GB编码 所以在数据库存储该中文字符时 因编码方式不一样就会产生乱码
		// 进而再次显示到网页上时就是乱码
	}
}
