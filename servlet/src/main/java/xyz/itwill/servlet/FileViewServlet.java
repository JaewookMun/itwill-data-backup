package xyz.itwill.servlet;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// �Է�������(file_view.html)���� ���޵� �Է°��� �Է������� ������ ��ȯ�޾� Ŭ���̾�Ʈ���� �����ϴ� ������
@WebServlet("/view.itwill")
public class FileViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		if(request.getMethod().equals("GET")) {
			response.sendRedirect("file_view.html"); // �Է��������� �̵� ó��
			return;
		}
		
		// ���ް��� ���� ĳ���ͼ� ����
		request.setCharacterEncoding("utf-8");
		
		// ���ް��� ��ȯ�޾� ����
		// ��Ƽ��Ʈ �������ͷ� ���޵� ���� HttpServletRequest �ν��Ͻ��� getParameter()
		// �޼ҵ�θ� ȣ���Ͽ� ��ȯ �Ұ���
		// String name=request.getParameter("name");
		// String fileOne=request.getParameter("fileOne");
		
		// ó�� ��� ����
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>�Է°��� �Է�����</h1>");
		out.println("<hr>");
		/*
		out.println("<p>�ø��� = "+name+"</p>");
		out.println("<p>���ϸ� = "+fileOne+"</p>");
		*/
		
		// ��Ƽ��Ʈ �������ͷ� ���޵� ���� �б� ���� �Է½�Ʈ���� ��ȯ�޾� ����
		// HttpServletRequest.getInputStream() : ������Ʈ �޼����� BODY�� ����Ǿ� ���޵�
		// ��Ƽ��Ʈ �������͸� �б� ���� �Է½�Ʈ��(ServletInputStream �ν��Ͻ�)�� ��ȯ�ϴ� �޼ҵ�
		// ServletInputStream in = request.getInputStream();
		InputStreamReader in = new InputStreamReader(request.getInputStream());
		
		// �Է� ��Ʈ���� �̿��Ͽ� ��Ƽ��Ʈ �������͸� ���� Ŭ���̾�Ʈ���� ����
			// ��Ƽ��Ʈ �������͸� ó���ϴ� Ŭ������ ���� ���̺귯���� ���ԵǾ� �ִ�.
		out.println("<p>[��Ƽ��Ʈ �������� ����]</p>");
		out.println("<pre>");
		while(true) {
			int readByte=in.read();
			if(readByte==-1) break;
			out.write(readByte);
		}
		out.println("</pre>");
		
		out.println("</body>");
		out.println("</html>");
		
	}
}