package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// �Է� ������(form.html)���� ���޵� �Է°��� ��ȯ�޾� Ŭ���̾�Ʈ���� �����ϴ� ����
@WebServlet("/join.itwill")
public class JoinServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		// �Է� ����������(form.html)�� form �±׸� �̿��Ͽ� [POST] ������� ��û�Ͽ� ����Ǵ� ����
		// => ������ [GET] ������� ��û�� ��� ���������� ��û
		// �����α׷��� ���������� ������� ��û�� ��� Ŭ���̾�Ʈ���� �����ڵ带 �����ϰų�
		// ������������ �̵��ǵ��� ó��
			// c.f. ��) �α��� ���� ���� ����ڰ� �α��ε� ����ڰ� ������ �� �ִ� ���α׷��� ������ ��� ���� ����
		// HttpServletRequest.getMethod() : Ŭ���̾�Ʈ�� ��û����� ��ȯ�ϴ� �޼ҵ�
		if(request.getMethod().equals("GET")) { // Ŭ���̾�Ʈ�� [GET] ������� ��û�� ���  // �빮�ڷ� ǥ��
			// HttpServletResponse.sendError(int sc) : Ŭ���̾�Ʈ���� �����ڵ�
			// (StatusCode - 4xx or 5xx)�� �����ϴ� �޼ҵ�
			// �����ڵ�� HttpServletResponse �������̽��� ����ʵ�(Constant Field)�� ����
				// statusCode�� �ٿ��� sc��� ���� ���Ѵ�.
				// 1xx ó���� 2xx �Ϸ� 3xx ���û | 4xx Ŭ���̾�Ʈ ��û���� 5xx Ŭ���̾�Ʈ ��û���� ����
			// response.sendError(HttpServletResponse.SC_BAD_REQUEST); // 400 ��û����� �߸��Ǿ��ٴ� ���� �˷��� �� ��� ����
			// response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED); // 405 �����ڵ� : Method not allowed
				// form �±׸� �̿����� ������ �� get����̴�. (url�ּ��Է� ���� get���)
			// return; // ���� ����
			
			// HttpServletResponse.sendRedirect(String url) : Ŭ���̾�Ʈ���� 301 �����ڵ��
			// URL �ּҸ� �����ϴ� �޼ҵ�
			// => �����ڵ� 301 : ���޹��� URL �ּ��� �����α׷��� ��û�ϱ� ���� �����ڵ�
			// => Ŭ���̾�Ʈ�� �������� URL �ּҸ� �����ϰ� ��û�� �����α׷��� ������ ��� - ������ �̵�
			// => ������ �̿��� ������ �̵� ��� - �����̷�Ʈ �̵�
				// ������ URL�ּҷ� Ŭ���̾�Ʈ�� �ٽ� ��û�ϰ� �Ѵ�.
			response.sendRedirect("error.html");
			return;
		}
		
		// POST ������� �����α׷��� ��û�� ��� ������Ʈ �޼����� BODY�� �Է°��� �����Ͽ� ����
		// => ������Ʈ �޼����� BODY�� �⺻ ĳ���ͼ��� ISO-8859-1(��������)�� ����
		// HttpServletRequest.setCharacterEncoding(String encoding) : ������Ʈ �޼����� BODY��
		// ���޵Ǵ� ���� ���� ĳ���ͼ��� �����ϴ� �޼ҵ�
			// Apache Tomcat10.0������ ��� �Է°����� utf-8�� ����
			// 8.0�̳� 9.0�� ��� ������ ���޵ȴ�.
			// request�� body�� ���� �������.
			// get����� �ʿ� ����.
		
		request.setCharacterEncoding("utf-8"); // post�� ������Ʈ �ٵ𳻿��� �б� ���� �ʿ�.
			// ������ ���� �� ��������� �б� ������ ��������.
			// GET ����� �ʿ����.
		
		// ���� ��û�� ���� ���ް�(����� �Է°�)�� ��ȯ�޾� ����
		// HttpServletRequest.getParameter(String name) : �����α׷� ��û �� ���޵� ���� ����
		// ��ȯ�ϴ� �޼ҵ� - ���ް��� ������ ���ڿ�(String)�� ��ȯ
		// => GET : QueryString���� ���޵� ���� �̸�(�ĺ���)�� �̿��Ͽ� ���ް� ��ȯ
		// => POST : �Է��±��� name �Ӽ����� �̿��Ͽ� ���ް� ��ȯ
		// �̸�(name)�� �ش��ϴ� ���ް��� �������� ���� ��� null�� ��ȯ�ϸ� GET ��Ŀ���
		// �̸��� �ְ� ���ް��� ���� ��� NullString ��ȯ
			// ������ ���� ������ ���� �̸��� �̿��ؼ� �����Ѵ�.
		String id=request.getParameter("id");

			// ��Ⱥ� ���ȹ��� - JS���� ��ȿ�� üũ�� �Ҽ� ������ ������������ ��ȿ���˻� ������ ����.
			// ���Ȼ� JavaScript�� ���� �� ���� ������ java������ �����Ѵٰ� ����ȴ�.
			// ������� ����Ʈ�� ������������ �߿��� ���� ���� �����ϴ� ���� ��Ģ���� ����. 
			// ���������� �� ���� �ϴ� ����� ����.
		if(id==null || id.equals("")) {// ���ް��� ���� ��� - ���������� ��û
			// ���������� JS�� 1�������� �Է°��� ���� ��ȿ���˻縦�Ͽ� submit�� ���� ���ϵ����ؾ���.
			response.sendRedirect("error.html");
				// response.sendRedirect("/servlet/error.html");
			return;
		}
		
		if(!Pattern.matches("^[a-zA-Z]\\w{5,19}$", id)) { // ���ް��� ���Ŀ� ���� ���� ��� - ����������  ��û
			
		}
		
		String pass=request.getParameter("pass");
		String name=request.getParameter("name");
		String addr=request.getParameter("addr");
		String sex=request.getParameter("sex");
		String job=request.getParameter("job");
		// ���� �̸����� ���޵� ���� �ִ� ��� ù��° ���ް��� ��ȯ�޾� ����
		// String hobby=request.getParameter("hobby");
		// HttpServletRequest.getParameterValues(String name) : ���� �̸����� ���޵Ǵ�
		// ��� ������ ���ڿ� �迭�� ��ȯ�ϴ� �޼ҵ�
		// => ���� ���� ����� �Է��±׷� ���޵Ǵ� ���� ��ȯ���� �� ����ϴ� �޼ҵ�
			// e.g. checkbox, select (multiple ����� �ִ� ���)
			// ����x
		String[] hobby=request.getParameterValues("hobby");
		
		String profile=request.getParameter("profile");
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>ȸ������ Ȯ��</h1>");
		out.println("<hr>");
		out.println("<p>���̵� = "+id+"</p>");
		out.println("<p>��й�ȣ = "+pass+"</p>");
		out.println("<p>�̸� = "+name+"</p>");
		out.println("<p>�ּ� = "+addr+"</p>");
		out.println("<p>���� = "+sex+"</p>");
		out.println("<p>���� = "+job+"</p>");
		// out.println("<p>��� = "+hobby+"</p>");
		if(hobby==null) {
			out.println("<p>��� = �̼���</p>");
		} else {
			out.println("<p>��� = ");
			for(int i=0; i<hobby.length; i++) {
				out.println(hobby[i]);
				if(i<hobby.length-1) {// �迭�� ������ ��Ұ� �ƴ� ���
					out.println(",");
				}
			}
			out.println("</p>");
		}
		// textarea �±׷� �ԷµǾ� ���޵� ���� ����(Enter)�� <br> �±׷� ��ȯ�Ͽ� ���
			//  DB�� ������ ���� �״�� ���������� ����� ���� ���¸� ���߾������.
		out.println("<p>�ڱ�Ұ� <br>"+profile.replace("\n", "<br>")+"</p>");
		out.println("</body>");
		out.println("</html>");
	}
}
