package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

// �Է����������� ���޵� ��Ƽ��Ʈ �������͸� ó���ϱ� ���� Ŭ���� �ʿ�
// => Apache �׷쿡�� ������ commons-fileupload ���̺귯���� Ŭ���� ��� - ������ ���� ���ε�
// => Oreilly �׷쿡�� ������ cos ���̺귯���� Ŭ���� ��� - ������ ���� ���ε�
	// Apache �׷��� ���̺귯���� ���ε� ó���� ����������(�������� Ŭ����) cos�� �� �� ����. (��ȿ���˻� ���� �ϸ� ����ġ)

// Oreilly �׷쿡�� ������ cos ���̺귯�� ������ �ٿ�ε� �޾� ������Ʈ�� ����(Build) ó���ϴ� ���
// 1. http://www.servlets.com >> COS File Upload Library �޴� Ŭ�� >> cos-20.08.zip �ٿ�ε�
// 2. cos-20.08.zip ���� ���� Ǯ�� >> ���� ���� >> lib >> cos.jar ����
// 3. ������Ʈ >> src/main/webapp >> WEB-INF >> lib ������ �ٿ��ֱ�
// => ���̺귯���� �ڵ����� ������Ʈ�� ���� ó�� - Web App Libraries Ȯ��
	// MultipartRequest, DefaultFileRenamePolicy �� Ŭ���� �߿�
	// cos : com.oreilly.service �� ����

// �Է�������(file_upload.html)���� ���޵� �Է°��� �Է� ���ϸ��� ��ȯ�޾� Ŭ���̾�Ʈ���� ����
// => �Է������� ���޹޾� ���� ���丮�� ����ǵ��� ó�� - ���ε�(Upload)
@WebServlet("/upload.itwill")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		if(request.getMethod().equals("GET")) {
			response.sendRedirect("file_upload.html"); // �Է��������� �̵� ó��
			return;
		}
		
		// ���޵� ������ �����ϱ� ���� ���� ���丮�� �ý��� ��θ� ��ȯ�޾� ����
		// => �۾� ���丮(WorkSpace)�� �ƴ� �� ���丮(WebApps)�� �ý��� ��� ��ȯ
		// ����) WAS ����� �۾����丮�� ������Ʈ�� �� ���丮�� ���ؽ�Ʈ�� ����ȭ ó��
		// �Ǹ鼭 ���ؽ�Ʈ�� �����ϴ� ���� ���ε� ������ �������� ���� �߻�
			// ��Ŭ������ workspace�� �����丮�� ����ȴ�. (project�� context�� ����)
			// ��Ŭ������ ���ε尡 �Ǵ��� Ȯ���ϸ��.
			// �ƴ϶�� context������ �����ؼ� ��Ŭ������ upload������ �ٿ������� ����ȭ�Ǿ ������.
		String saveDirectory = request.getServletContext().getRealPath("/upload");
		// System.out.println("saveDirectory = "+saveDirectory);
		
		// MultipartRequest Ŭ������ �ν��Ͻ� ����
		// => MultipartRequest : ��Ƽ��Ʈ �������͸� ó���ϱ� ���� ����� �����ϴ� �ν��Ͻ�
		// => MultipartRequest �ν��Ͻ��� �����ϸ� ��� �Է������� ���޹޾� ���� ���丮�� ���ε�
		// MultipartRequest(HttpServletRequest request, String saveDirectory[, int maxPostSize]
		// [, String encoding][, FileRenamePolicy policy]) �����ڸ� ����Ͽ� �ν��Ͻ� ����
		// => request : ��û������ ������ HttpServletRequest �ν��Ͻ� ����
		// => saveDirectory : ���� ������ �����ϱ� ���� ���� ���丮�� �ý��� ��� ����
		// => maxPostSize : ó�� ������ ��Ƽ��Ʈ ���������� �ִ� ũ�� ���� - ���� : Byte
		// => encoding : ��Ƽ��Ʈ �������ͷ� ���޵� �Է°��� ĳ���ͼ� ����
		// => policy : FileRenamePolicy �ν��Ͻ� ����
		// FileRenamePolicy : ���� ���ε� ó���� �Է����ϰ� ���� �̸��� ������ ���ε� �Ǵ�
		// ���� ���丮�� ������ ��� �Է������� �̸��� �ڵ� �����ϴ� �ν��Ͻ�
		// => FileRenamePolicy �ν��Ͻ��� �������� ������ ���� ������ �Է����Ϸ� ������(OverWrite)
			// 30*1024*1024 -> ������ 30 �ް�����Ʈ ���� ���� ����
			// FileRenamePollicy : ������ ������ �ߺ��� ��� ��� ó���� �� ����
			// ������ ��ġ ���� MulitpartRequest �ν��Ͻ��� ����� ������ ���޹޾� ���� ����
			// �ڵ����� ����Ǵ� ���丮�� context������ upload�� �̸����� �Ǿ��ִ�.
			// �����丮�� ���� - upload
		//MultipartRequest mr=new MultipartRequest(request, saveDirectory, 30*1024*1024, "utf-8");
		
		// FileRenamePolicy �������̽��� ��ӹ��� �ڽ�Ŭ������ FileRenamePolicy �ν��Ͻ� ����
		// DefaultFileRenamePolicy : FileRenamePolicy �������̽��� ��ӹ��� �ڽ� Ŭ����
		// => �Է� ���ϸ� �ڿ� ���ڸ� �ٿ� �ڵ����� �����ϴ� ����� ����
		MultipartRequest mr=new MultipartRequest(request, saveDirectory, 30*1024*1024
				, "utf-8", new DefaultFileRenamePolicy());
			// ��ó�� �ν��Ͻ��� ����� �����.
			// Apache Tomcat 10.0�� 9.0���� �����Ͽ� ���� ( error ������ ...)
		
		// �Է°��� ��ȯ�޾� ����
		// MultipartRequest.getParameter(String name) : ��Ƽ��Ʈ ���������� �Է°��� ��ȯ�ϴ� �޼ҵ�
		String name=mr.getParameter("name");
		
		// �Է� ���ϸ��� ��ȯ�޾� ����
		// MultipartRequest.getOriginalFileName(String name) : ��Ƽ��Ʈ ���������� �Է� ���ϸ��� ��ȯ�ϴ� �޼ҵ�
		// String fileOne=mr.getOriginalFileName("fileone");
		// String fileTwo=mr.getOriginalFileName("filetwo");
		
		
		// ���� ���丮�� ����� ���ε� ���ϸ��� ��ȯ�޾� ����
		// MultipartRequest.getFilesystemName(String name) : ���� ���丮�� ���� ����� ���ϸ��� ��ȯ�ϴ� �޼ҵ�
		String fileOne = mr.getFilesystemName("fileone");
		String fileTwo = mr.getFilesystemName("filetwo");

		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>���� ���ε�</h1>");
		out.println("<hr>");
		out.println("<p>�ø��� = "+name+"</p>");
		out.println("<p>����-1 = "+fileOne+"</p>");
		out.println("<p>����-2 = "+fileTwo+"</p>");
		out.println("</body>");
		out.println("</html>");
		
			// ������Ʈ�� �ڿ����� web directory�� ���ؽ�Ʈ�� ����(����ȭ)�Ҷ� 
			// workspace�� �ִ� ���丮�� web directory�� upload ������ ���������.
			// workspace�� webapp�� �ڿ��� ����� WAS�� webapps�� context�� �̵��Ѵ�.
	}
}
