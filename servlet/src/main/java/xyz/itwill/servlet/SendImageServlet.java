package xyz.itwill.servlet;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Ŭ���̾�Ʈ ��û�� ���� �̹��� ���Ϸ� �����ϱ� ���� ����
@WebServlet("/image.itwill")
public class SendImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Ŭ���̾�Ʈ���� �̹��� ���Ϸ� ����ǵ��� ����
		// => �̹��� ���Ϸ� �����ϱ� ������ ĳ���ͼ� �̼���
			// server�� ����Ŭ������ �� ������ ������ ���� �ϴܿ� mime mapping���� ����Ȯ�� ����
		response.setContentType("image/jpeg");
		
		// Ŭ���̾�Ʈ���� ����� �̹��� ������ �����ϱ� ���� ��� ��Ʈ���� ��ȯ�޾� ����
		ServletOutputStream out = response.getOutputStream();
		
		// ������ ����� �̹��� ������ �ý��� ��θ� ��ȯ�޾� ����
		// HttpServletRequest.getServletContext() : ServletContext �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
		// ServletContext : Ŭ���̾�Ʈ�� ��û�� ���ؽ�Ʈ�� ������ ������ �ν��Ͻ�
		// => ���ؽ�Ʈ(Context) : �� ���� �ڿ��� ����� �׷� - ��Ŭ������ ������Ʈ
		// ServletContext.getRealPath(String contextFilePath) : ���ؽ�Ʈ�� �����ϴ� ������
		// �ý��� ��θ� ��ȯ�ϴ� �޼ҵ�
			// �ý��� ��δ� ���� ��θ� �ǹ� (�ü�� ���) 
			// ���ؽ�Ʈ ������ ���� ���ؽ�Ʈ�� �����ϴ� ������ ���� ��θ� ��ȯ (WAS�� �о���� �� �ִ� �ڿ��� ���� ���)
			// WAS�� ����ġ ��Ĺ ������ webapps ������ �����Ͽ� �����ø����̼��� ó���Ѵ�.
			// webapp���� client�� ������ �� ���� private ������ �����ϸ� ������ ���ٰ���
		String filePath=request.getServletContext().getRealPath("/WEB-INF/Koala.jpg");
		
		// ������ �����ϴ� �̹��� ������ �б� ���� �Է� ��Ʈ���� �����Ͽ� ����
		FileInputStream in=new FileInputStream(filePath);
		
		// �Է� ��Ʈ��(���� �̹��� ����)���� ���� �����͸� �о� ��� ��Ʈ��(Ŭ���̾�Ʈ
		// ���� ����)���� ���� - �ݺ� ó��
		while(true) {
			int readByte=in.read();
			if(readByte==-1) break;
			out.write(readByte);
		}
		
		// �Է� ��Ʈ�� ����
		in.close();
	}
}
