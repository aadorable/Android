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

			request.setAttribute("message", "删除失败 请重新删除");
			request.getRequestDispatcher("error.jsp")
					.forward(request, response);
		} else if (confirm == 1) {
			request.setAttribute("message", "成功删除");
			response.sendRedirect("list");
			// 告诉浏览器发送参数代表的请求 （这是另外一次请求 相当于又发一次请求）7
		}
	}
}
