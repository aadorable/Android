package com.openlab;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListServelt  extends  HttpServlet{
	protected void service(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException 
			 {
		        response.setContentType("text/html; charset=UTF-8");
		        Service s1=new Service();
		        ArrayList<Employee> es=s1.acquireEmp();
		        request.setAttribute("es",es);
		        request.getRequestDispatcher("emplist.jsp").forward(request, response);
			 }
}
