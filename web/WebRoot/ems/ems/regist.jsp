<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%><!-- 该句话表示允许该文件内部使用java语言 内容采用utf-8编码-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>regist</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="css/style.css" />
	</head>
	<!-- html是一种标记语言 不是编程语言  不具有取数据能力  若要进行交互则改为jsp文件 此时可以在文件中写java代码-->
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
						注册界面
					</h1>
					<!-- "%%"该标记表示内部可写java语句-->
					<%  
			            String message=(String)request.getAttribute("message");
			        
					
					
					%>
					<form action="regist" method="get">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									账号:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="username" />
									<!-- "%=%"表示其中是值等号后接-->
									<span style="color:red"><%= message==null?"":message %></span>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									姓名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="name" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									密码:
								</td>
								<td valign="middle" align="left">
									<input type="password" class="inputgri" name="pwd" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									性别:
								</td>
								<td valign="middle" align="left">
									男·
									<input type="radio" class="inputgri" name="sex" value="m" checked="checked"/>
									女
									<input type="radio" class="inputgri" name="sex" value="f"/>
								</td>
							</tr>
							
							
						</table>
						<p>
							<input type="submit" class="button" value="注册" />
						</p>
					</form>
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
