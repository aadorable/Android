package com.openlab;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//   ������ �˱��  
public class RegistServelt extends HttpServlet {
	String id;
	String pwd;
	String name;
	String sex;

	@Override
	protected void service(HttpServletRequest request,// request�Ǵ���ҳ��ȡ����
			HttpServletResponse response)// response���ǽ����ݴ�����ҳ
			throws ServletException, IOException {
		// ���ñ�������������򡪡�������ҳ�޷���������ַ�(��Ӣ���ַ������)
		response.setContentType("text/html; charset=UTF-8");// charset:�ַ���
															// �þ�������out.println�е��������ݱ�����ʹ��utf-8
															// ��ô�����ȥ����ʱҲ�����utf-8����ʱ����ҳ�Ҽ��鿴���벻���ǲ��ù���GB2312b����
															// ���ǲ���utf-8�ˣ�
		// ���� �ͻ��� �� ������ ������
		// ��Ӧ ������ ��ͻ��� �ش�����
		id = request.getParameter("username");
		name = request.getParameter("name");
		pwd = request.getParameter("pwd");
		sex = request.getParameter("sex");
		Service s1 = new Service();
		int confirm = s1.regist(id, pwd, name, sex);
		PrintWriter out = response.getWriter();
		if (confirm == 0 || confirm == 4) {

			request.setAttribute("message", "ע��ʧ�� ������ע��");
			request.getRequestDispatcher("regist.jsp").forward(request,
					response);
			// out.println("ע��ʧ�� ������ע��");//��Ϣ��ʾ����һ��������
		} else if (confirm == 1) {
			request.setAttribute("message", "�ɹ�ע��");// ������ʾ��������Ϊ��Ϣ ��������
			request.getRequestDispatcher("regist.jsp").forward(request,
					response);// ת������
			// out.println("�ɹ�ע��");//��Ϣ��ʾ����һ��������
		} else if (confirm == 2) {
			request.setAttribute("message", "���û��Ѿ���ע��");
			request.getRequestDispatcher("regist.jsp").forward(request,
					response);
			// out.println("���û��Ѿ���ע��");//��Ϣ��ʾ����һ��������
		}
	}
}
