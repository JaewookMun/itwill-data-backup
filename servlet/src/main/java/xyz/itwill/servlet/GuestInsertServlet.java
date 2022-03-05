package xyz.itwill.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xyz.itwill.dao.GuestDAO;
import xyz.itwill.dto.GuestDTO;

// �Է�������(insert.html)���� ���޵� ���� �Խñ��� ��ȯ�޾� GUEST ���̺� �����ϰ�
// ���������(select.itwill)�� ��û�Ͽ� �̵��ϴ� ������ �����ϴ� ���� - ó��������(����)
	// html�������� ���� �������� �ʴ´�. (�ڷ��� ó���� �����ϴ� ���α׷�)
@WebServlet("/insert.itwill")
public class GuestInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ���������� ��û�� ���� ó��
		if(request.getMethod().equals("GET")) {
			response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return;
		}
		
		// ������Ʈ �޼����� �ٵ� ����� �Է°��� ���� ĳ���ͼ� ����
			// POST�� ������ ������ ��� �о���� ������ �����Ѵ�.
		request.setCharacterEncoding("utf-8");
		
		// ���ް�(�Է°�)�� ��ȯ�޾� ����
		// => ���ް��� �� �Ǵ� ���� ������ ������ �� ����
		// => XSS ���ݿ� ���� �� ���� �±� ���� ��ȣ�� ȸ��(Escape)���ڷ� ��ȯ�Ͽ� ����
		// XSS(Cross Site Scripting) : �Է��±׿� �������� ��ũ��Ʈ�� �Է��Ͽ� �������� ����
		// ��Ű�ų� ���� ������ Ư�� ����Ʈ�� �����ϴ� ����
			// �Է��� �� �� ����ڰ� ������ �Է��� �� �ֱ� ������
			// �Խñ��� ���뿡 HTML or script �±׸� ����ִ� ��� ����.
			// replace("<", "&lt;").replace(">","&gt;") �� ���� �ּ����� �� �� �� �ִ�. 
		String name=request.getParameter("name").trim().replace("<", "&lt;").replace(">","&gt;");
		String title=request.getParameter("title").trim().replace("<", "&lt;").replace(">","&gt;");
		String content=request.getParameter("content").trim().replace("<", "&lt;").replace(">","&gt;");
		
		// DTO �ν��Ͻ��� �����Ͽ� ��ȯ���� ���ް����� �ʵ尪 ����
		GuestDTO guest=new GuestDTO();
		guest.setName(name);
		guest.setTitle(title);
		guest.setContent(content);
		
		// GUEST ���̺� ������ �Խñ��� �����ϴ� DAO Ŭ������ �޼ҵ� ȣ��
		GuestDAO.getDAO().insertGuest(guest);
		
		// Ŭ���̾�Ʈ�� ���������(select.itwill)�� ���� ��û URL �ּ� ���� - �����̷�Ʈ �̵�
		response.sendRedirect("select.itwill");
		

	}
}
