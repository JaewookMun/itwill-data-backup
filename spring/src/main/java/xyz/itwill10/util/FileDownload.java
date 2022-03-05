package xyz.itwill10.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

// ���� �ٿ�ε� ����� �����ϴ� Ŭ���� - Spring Bean ��� >> servlet-context.xml
// BeanNameViewResolver�� ���� ����Ǵ� Ŭ������ �ݵ�� AbstractView Ŭ������ ��ӹ޾� �ۼ�
// => renderMergedOutputModel() �޼ҵ带 �������̵� �����Ͽ� ���� ó���� ����� ����� �ۼ�
	// ������̼��� ����ص� ���ڸ� �������鿡�� bean element�� ��� (comp:scan�� �� �ۼ��������.)
public class FileDownload extends AbstractView {
	// Ŭ���̾�Ʈ���� ������ ��������(MimeType) ���� - ���� �ٿ�ε� ���
	public FileDownload() {
		// AbstractView.setContentType(String mimeType) : ���� ���������� �����ϴ� �޼ҵ�
		setContentType("application/download; utf-8");
	}
	
	// BeanNameViewResolver�� ���� �ڵ� ȣ��Ǵ� �޼ҵ�
	// => Map �ڷ����� �Ű������� ��û ó�� �޼ҵ忡�� Model ��ü�� ���� �����Ǵ� ���� ����
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// ��Ű�� �̿��Ͽ� �ʰ��� ��ȯ�޾� ���� - �ٿ�ε� ���� ����
		// => Object Ÿ���� ��ü�� ��ȯ�ǹǷ� �ݵ�� ����� ��ü ����ȯ�Ͽ� ���
		String uploadDir=(String)model.get("uploadDir");
		String uploadFilename=(String)model.get("uploadFilename");
		String originFilename=(String)model.get("originFilename");
		
		// �ٿ�ε� ������ �̿��� File ��ü ����
		File downloadFile=new File(uploadDir, uploadFilename);
		
		// Ŭ���̾�Ʈ���� ������ �����ϱ� ���� �������� ����
			// ������ ������ contentType�� ������ ���� - �ٿ�ε�
		response.setContentType(getContentType());
		response.setContentLength((int)downloadFile.length());
		
		// Ŭ���̾�Ʈ���� �ٿ�ε� ���ϸ� ����
		originFilename=URLEncoder.encode(originFilename, "utf-8");
			// ���������� �ϴ� ����� ���ݾ� �ٸ���.
			// �ֽŹ����� �̷��� �ص� ������ ������ if���� ����Ͽ� ������ ������ Ȯ���Ͽ� ����
		response.setHeader("Content-Disposition", "attachement;filename=\""+originFilename+"\";");
			//response.setHeader("Content-Disposition", "attachment;filename=\""+originFilename+"\";");
			// e�� ���� �ȵǴ��� Ȯ���غ���
		
		// Ŭ���̾�Ʈ���� ���õ����͸� �����ϱ� ���� ��½�Ʈ���� ��ȯ�޾� ����
		OutputStream out=response.getOutputStream();
		
		FileInputStream in=null;
		try {
			// �ٿ�ε� ������ ���õ����ͷ� �б� ���� �Է½�Ʈ���� �����Ͽ� ����
			in=new FileInputStream(downloadFile);
			
			// FileCopyUtils.copy(InputStream in, OutputStream out) : �Է½�Ʈ���� �̿��Ͽ�
			// ���õ����͸� �о� ��½�Ʈ������ �ݺ��ؼ� �����ϴ� �޼ҵ� - ���� ����
			FileCopyUtils.copy(in, out); // �ٿ�ε�
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				in.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
