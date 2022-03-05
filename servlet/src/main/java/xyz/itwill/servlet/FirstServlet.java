package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



// @WebServlet : ���� Ŭ������ �������� ����ϰ� URL �ּҸ� �����ϱ� ���� ������̼�(Annotation)
// => [web.xml] ������ servlet ������Ʈ�� servlet-mapping ������Ʈ�� ������ ��� ����
// ������̼� �Ӽ��� �̿��Ͽ� ���� �̸� �Ǵ� URL �ּҿ� ���� ���� ó�� ���� ����
// => name �Ӽ������� ���� �̸� ����(����) : name �Ӽ��� �����ϸ� Ŭ�������� ���� �̸����� �ڵ� ����
// => value �Ӽ������� URL �ּ� ���� ó��(�ʼ�) : �ٸ� �Ӽ��� ���� ��� �Ӽ����� ���� ����
// => ������̼� �Ӽ��� , ��ȣ�� �����Ͽ� ����
	// value= "url" ���� value ����
	// servlet mapping�� ����� �̷������ ������ WAS�� ������ü�� ���� ����. - ������̼����� �ϴ°� �� ��
	// container - ��ü�� life-cycle�� ����
@WebServlet("/First.itwill")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// Ŭ���̾�Ʈ�� ��� ��û��Ŀ� ���� ��ûó���� ������ �����ϴ� �޼ҵ�
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ���� ����� �������� ���� ��� ���� ����
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
			
		// �����α׷� ���� - ��û ó�� �� Ŭ���̾�Ʈ���� ��� ����
		// => Ŭ���̾�Ʈ���� �ϰ��� �ִ� ������ �����ϴ� ���� �������� �����Ͽ� ����
			// js�� ���� �������� ������ �� ������ Ŭ���̾�Ʈ���� ����Ǳ� ������
			// Ŭ���̾�Ʈ ���� �ٸ� ����� ��Ÿ�� �� �ִ�.
		Date now = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy�� MM�� dd�� HH�� mm�� ss ��");
		String displayNow=simpleDateFormat.format(now);
		
			// servlet�� ���� ū ���� - �������� ����� ���� ������.
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>Servlet</title>");
		out.println("<style type='text/css'>");
		out.println("p { width: 600px; margin: 0 auto; padding: 30px 0; font-size: 2em;"
				+ "font-weight: bold; text-align: center; border: 2px solid black; }");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>���� �ð�</h1>");
		out.println("<hr>");
		out.println("<p>"+displayNow+"</p>");
		out.println("<script type='text/javascript'>");
		out.println("setInterval(function() { location.reload(); }, 1000);");
		out.println("</script>");
		out.println("</body>");
		out.println("</html>");
	
	}
}
