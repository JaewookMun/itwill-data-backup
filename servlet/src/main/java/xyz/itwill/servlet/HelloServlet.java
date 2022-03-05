package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// ����(������ ����Ǵ� ���α׷�) �ۼ� ���
// 1. HttpServlet Ŭ������ ��ӹ޾� �ۼ� - ���� Ŭ����
// => HttpServlet Ŭ������ ��ӹ��� �ڽ�Ŭ������ ��ü ����ȭ Ŭ������ serialVersionUID �ʵ带 �����ϴ� ���� ����
	// JavaEE API�� ����. - Apache Tomcat library�� �⺻���� �� ���̺귯�� �ڷ� ����

public class HelloServlet extends HttpServlet{
	private static final long serialVersionUID = 1L; // Ŭ������ �����ϱ����� �������� default�ص� ��� ����.
	
	// 2. doGet()�Ǵ� doPost() �޼ҵ带 �������̵� ����
	// => Ŭ���̾�Ʈ ��û�� ���� ó���� ó�����(HTML)�� �����ϱ� ���� �޼ҵ� - WAS(Web Application Server)�� ���� �ڵ� ȣ��
	// => doGet() : Ŭ���̾�Ʈ�� GET ������� ��û�� ��� ȣ��Ǵ� �޼ҵ�
	// => doPost() : Ŭ���̾�Ʈ�� POST ������� ��û�� ��� ȣ��Ǵ� �޼ҵ� 
	// doGet() �Ǵ� doPost() �޼ҵ� ��� service() �޼ҵ带 �������̵� ����
	// => service() : Ŭ���̾�Ʈ�� ��� ��û�� ���� ȣ��Ǵ� �޼ҵ�
	// => doGet() �Ǵ� doPost() �޼ҵ庸�� service() �޼ҵ��� ȣ�� ������ ���� ����
	// WAS�� ���� �޼ҵ尡 ȣ��� �� HttpServletRequest �ν��Ͻ��� HttpServletResponse �ν��Ͻ���
	// �Ű������� �ڵ����� ���޵Ǿ� ����ȴ�.
		// doGet, doPost�� �ΰ��� �������̵� �ص� �������. desktop ���� main() �̶�� ��������
		// Ŭ���̾�Ʈ�� GET������� ��û�ߴµ� doPost �ۿ� ������ ���� �߻�
		// service() �޼ҵ�� GET��� �Ǵ� POST����� �������� �ʴ´�.
		// service() �޼ҵ尡 �������̵� �Ǿ� ������ doGet, doPost �޼ҵ带 ���� �������̵����� �ʴ´�.
		// �ش� �޼ҵ�� WAS�� �ڵ����� ȣ���Ѵ�.
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// HttpServletRequest : ������Ʈ �޼���(��û����)�� ����� �ν��Ͻ�
		// HttpServletResponse : �������� �޼���(��������)�� ����� �ν��Ͻ�
			// �� �� �ν��Ͻ��� ���� �����α׷��� ����� �ȴ�. - �� Ŭ������ �ִ� �޼ҵ�� �� �ϱ��ؾ��Ѵ�. ��!@!@
		
		// 3. Ŭ���̾�Ʈ���� ������ ����(����)�� ����(Mime Type) ����(����)
		// => ���� �������� ������ ��� ������ ĳ���ͼ�(CharacterSet : �������� - ���ڵ�) ����
		// => �⺻ ���� ���� ���� : text/html, ĳ���ͼ� : ISO-8859-1 (��������)
		// HttpServletResponse.setContentType(String mimeType[;charset=encoding])
			// doGet �޼ҵ尡 ��û�� ���� ó���� �Ϸ��ϰ� ������� ������ ���ΰ�?
			// ������ ���� ĳ���ͼ��� �������� �ʾƵ� �ȴ�. ������ ���� �� ���
		response.setContentType("text/html;charset=utf-8");
			// text/html �������·� ������� �����ϸ� ���� ���� utf-8�̴�.
			// ó���� �Ұ��̸� �� �۾��� ���ص� ������, ó������� �ֱ� ���ؼ��� �������.
			// ��ټ��� �������� ó�� �� ����� ������ ����.
		
		// 4. Ŭ���̾�Ʈ���� ��û�� ���� ó�� ����� ����(����)�ϱ� ���� ��� ��Ʈ���� ��ȯ�޾� ����
		// ����) HttpServletResponse.getOutputStream() : ���� ������(1Byte)�� ������ �� �ִ�
		// ��� ��Ʈ��(ServletOutputStream �ν��Ͻ�)�� ��ȯ�ϴ� �޼ҵ�
		// => �׸�, ����, �������� ���� Ŭ���̾�Ʈ���� �����ϱ� ���� ����ϴ� ��� ��Ʈ��
		// ����) HttpServletResponse.getWriter() : ���ڵ� ó���� ���� ������(2Byte)�� ������
		// �� �ִ� ��� ��Ʈ��(PrintWriter �ν��Ͻ�)�� ��ȯ�ϴ� �޼ҵ�
		// => PlainText, HTML, XML ���� ���� Ŭ���̾�Ʈ���� �����ϱ� ���� ����ϴ� ��� ��Ʈ��
		PrintWriter out=response.getWriter();
		
		// 5. ��û ó�� �� ó�� ����� ����(����)�� ���� - ����
		// => ��� ��Ʈ���� �̿��Ͽ� ó�� ����� �����ϸ� ����(����) ����
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>����(Servlet)</h1>");
		out.println("<hr>");
		out.println("<p>Hello, Servlet!!!</p>");
		out.println("</body>");
		out.println("</html>");
		
		// 6. ���� Ŭ������ �����α׷����� ��� ����
		// => [web.xml] ���Ͽ��� ���� Ŭ������ �������� ����ϰ� URL �ּҸ� ���� ����
		// => ���ε� URL �ּҷ� Ŭ���̾�Ʈ�� ��û�ϸ� WAS�� ��ϵ� ������ �����Ͽ� ����
		
	}
}
