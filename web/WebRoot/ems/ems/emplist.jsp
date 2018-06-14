<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.openlab.Employee"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>emplist</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="css/style.css" />
	</head>
	<body>
		<div id="wrap">
			<div id="top_content"> 
				<div id="header">
					<div id="rightheader">
						<p>
							2018/6/1
							<br />
						</p>
					</div>
					<div id="topheader">
						<h1 id="title">
							<a href="#">main</a>
						</h1>
					</div>
					<div id="navigation">
					</div>
				</div>
				<div id="content">
					<p id="whereami">
					</p>
						
					<h1>
						Welcome!This is the table of employees
					</h1>
				
					<table class="table">
						<tr class="table_header">
							<td>
								ID
							</td>
							<td>
								Name
							</td>
							<td>
								Salary
							</td>
							<td>
								Age
							</td>
							<td>
								Operation
							</td>
						</tr>
						<%  
						String message=(String)request.getAttribute("message");
					
			         ArrayList<Employee> es=(ArrayList<Employee>)request.getAttribute("es");

			             for (int i=0;i<es.size();i++)
			             {
			               Employee e=es.get(i);
					    %>
						<tr class="row">
							<td>
								<%= e.getId() %>
							</td>
							<td>
								<%=e.getName()%>
							</td>
							<td>
								<%= e.getSalary()%>
							</td>
							<td>
								<%= e.getAge()%>
							</td>
							<td>
								<a href=delete?id=<%=e.getId()%>>delete emp</a>&nbsp;<a href="transfertoupdate?id=<%=e.getId()%>&name=<%=e.getName()%>&salary=<%= e.getSalary()%>&age=<%= e.getAge()%>">update emp</a>
								<!-- 目的是使提交的路径变为：ems/ems/delete且id=某某 -->
								<!-- 如点击第一个员工后的delete emp请求路径为：http://127.0.0.1:8080//ems/ems/delete?id=1 -->
							</td>
							
						</tr>
						<%
						}
						 %>
					</table>
					<p>
						<input type="button" class="button" value="Add Employee" onclick="location='addEmp.jsp'"/>
					</p>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
				ABC@126.com
				</div>
			</div>
		</div>
	</body>
</html>
