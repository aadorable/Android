package com.openlab;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//   服务器 端编程  
public class RegistServelt extends HttpServlet {
	String id;
	String pwd;
	String name;
	String sex;

	@Override
	protected void service(HttpServletRequest request,// request是从网页获取数据
			HttpServletResponse response)// response则是将数据传至网页
			throws ServletException, IOException {
		// 设置编码规则与解码规则——否则网页无法输出中文字符(但英文字符可输出)
		response.setContentType("text/html; charset=UTF-8");// charset:字符集
															// 该句语句告诉out.println中的文字内容编码是使用utf-8
															// 那么浏览器去解码时也会采用utf-8（此时在网页右键查看编码不再是采用国标GB2312b编码
															// 而是采用utf-8了）
		// 请求 客户端 向 服务器 发数据
		// 响应 服务器 向客户端 回传数据
		id = request.getParameter("username");
		name = request.getParameter("name");
		pwd = request.getParameter("pwd");
		sex = request.getParameter("sex");
		Service s1 = new Service();
		int confirm = s1.regist(id, pwd, name, sex);
		PrintWriter out = response.getWriter();
		if (confirm == 0 || confirm == 4) {

			request.setAttribute("message", "注册失败 请重新注册");
			request.getRequestDispatcher("regist.jsp").forward(request,
					response);
			// out.println("注册失败 请重新注册");//信息提示到另一个界面上
		} else if (confirm == 1) {
			request.setAttribute("message", "成功注册");// 设置显示文字类型为信息 及其内容
			request.getRequestDispatcher("regist.jsp").forward(request,
					response);// 转发机制
			// out.println("成功注册");//信息提示到另一个界面上
		} else if (confirm == 2) {
			request.setAttribute("message", "该用户已经被注册");
			request.getRequestDispatcher("regist.jsp").forward(request,
					response);
			// out.println("该用户已经被注册");//信息提示到另一个界面上
		}
	}
}
