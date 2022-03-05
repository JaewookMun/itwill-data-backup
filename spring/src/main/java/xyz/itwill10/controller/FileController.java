package xyz.itwill10.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import xyz.itwill10.dto.FileBoard;
import xyz.itwill10.service.FileBoardService;

// ���� ���ε�
// 1. commons-fileupload ���̺귯�� ���� ó�� - pom.xml
// 2. ���� ���ε� ����� �����ϴ� Ŭ������ Spring Bean���� ��� - servlet-context.xml
	// Spring Bean���� ����ؾ� Spring Bean��ü�� �����޾� ������ ���ε��� �� �ִ�.
@Controller
public class FileController {
	@Autowired
	private WebApplicationContext context;
		// SpringMVC���� ����ϴ� Spring Container
	
	@Autowired
	private FileBoardService fileBoardService;
	
	@RequestMapping(value = "/upload", method=RequestMethod.GET)
	public String upload() {
		return "file/upload";
	}
	
	/*
	// MultipartHttpServletRequest : "multipart/form-data"�� ���޵Ǵ� ���� ������ ó���ϱ� ���� ��ü
	@RequestMapping(value = "/upload", method=RequestMethod.POST)
	public String upload(MultipartHttpServletRequest request) throws IOException {
		String uploadName=request.getParameter("uploadName");
		
		// MultipartHttpServletRequest.getFile(String parameterName) : ���޵� ������ 
		// MultipartFile ��ü�� ��ȯ�ϴ� �޼ҵ�
		// MultipartFile : ���޵� ������ ������ �����ϴ� ��ü
			// ���Ͽ� ���� ����.
		MultipartFile uploadFile=request.getFile("uploadFile");
		
		// �������Ͽ� ���� ��ȿ�� �˻� : ���� ����, ���� ����, ���� ũ��
		// MultipartFile.isEmpty() : ���޵� ������ ���� ��� true�� ��ȯ�ϴ� �޼ҵ�
		if(uploadFile.isEmpty()) {
			return "file/upload_fail";
		}
		
		// MultipartFile.getContentType() : ���޵� ������ ����(MimeType)�� ��ȯ�ϴ� �޼ҵ�
		System.out.println("���� ���� = "+uploadFile.getContentType());
		// MultipartFile.getBytes() : ���޵� ������ byte �迭�� ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ�
		System.out.println("���� ũ�� = "+uploadFile.getBytes().length);
		
		// ���޵� ������ ������ �����ϱ� ���� ���ε� ���丮�� �ý��� ��θ� ��ȯ�޾� ����
		String uploadDir=request.getServletContext().getRealPath("/resources/images");
		
		// ���������� ������ �����ϱ� ���� File ��ü ����
		// MultipartFile.getOriginalFilename() : ���������� �̸��� ��ȯ�ϴ� �޼ҵ�
		File file = new File(uploadDir, uploadFile.getOriginalFilename());
		
		// MultipartFile.transferTo(File file) : ���������� ������ �����ϴ� �޼ҵ�
		// => ���� ���ε� ���丮�� ���ε� ���ϰ� ���� �̸��� ������ �ִ� ��� �������Ͽ� ����
			// �����̸��� �����ϴ� �˰����� �����ؾ���.
		uploadFile.transferTo(file); // ���ε� ó��

		request.setAttribute("uploadName", uploadName);
		request.setAttribute("uploadFile", uploadFile.getOriginalFilename());
		
		return "file/upload_ok";
	}
	*/
	
	
	@RequestMapping(value = "/upload", method=RequestMethod.POST)
	public String upload(@RequestParam String uploadName, @RequestParam MultipartFile uploadFile, Model model) throws IOException {
			// ������ MultipartFile�� �޾ƾ���, String�� �ƴϴ�.
			// Front Controller���� ��û�Ͽ� �����͸� ���� �� �ִ�.
		
		if(uploadFile.isEmpty()) {
			return "file/upload_fail";
		}
		
		// WebApplicationContext ��ü�� �̿��Ͽ� ���� ���ε� ���丮�� �ý��� ��θ� ��ȯ�޾� ����
			// WebApplicationContext�� ���ڿ��� ��κ��� ����� �� �ִ�.
		String uploadDir=context.getServletContext().getRealPath("/resources/images");
		File file = new File(uploadDir, uploadFile.getOriginalFilename());
			// Orelly�� �޸� �����̸��� �ߺ��� �� �ڵ����� �̸��� ������� �ʴ´�.
			// commons-fileupload ���̺귯���� Ŭ������ ��������Ʈ �Ǳ⶧���� 
			// �����̸��� ���Ƿ� �����ؾ��Ѵ�. (�˰����� ���� ������ �ʿ�)
			// orelly�׷��� ���ε����� ������ ���ε� �Ǳ� ������ ��ȿ���˻縦 �ǽ��� �� ����.
			// commons�� �������� ���ε尡 �����ϴ�.
		
		// MultipartFile.transferTo(File file) : ���������� ������ �����ϴ� �޼ҵ�
		uploadFile.transferTo(file); // ���ε� ó��
		
		model.addAttribute("uploadName", uploadName);
		model.addAttribute("uploadFile", uploadFile.getOriginalFilename());
		
		return "file/upload_ok";
	}
	
	@RequestMapping(value = "/file_upload", method = RequestMethod.GET)
	public String fileUpload() {
		return "file/file_upload";
	}

	@RequestMapping(value = "/file_upload", method = RequestMethod.POST)
	public String fileUpload(@ModelAttribute FileBoard fileBoard) throws IllegalStateException, IOException {
		if(fileBoard.getFile().isEmpty()) { // ������ ���޵��� ���� ���
			return "file/file_upload";
		}
		
		String uploadDir=context.getServletContext().getRealPath("/WEB-INF/upload");
			// �ڷ���� ����� ���� WEB-INF ���� �ؿ� ������ ����� ���ε��θ� ���� - �������� ���� ���ҽ��� ������ �� ������ ����
			// �����̸��� �����Ͽ� ����
			// ���� 1. ���Ȼ��� ���� / ���� 2. �����̸� �ߺ����� - overwrite ȸ��
			// �ش� ������ apache-tomcat�� �������� Ȯ�� ����
		
		// �������ϸ��� ��ȯ�޾� ����
		String origin=fileBoard.getFile().getOriginalFilename();
		
		// ���ε� ���ϸ��� ������(���� �ý����� TimeStamp�� ���)���� �����Ͽ� ����
		// => ���ε� ���ϸ��� �ߺ����� �ʵ��� ����
			// �������� ��� ����� �پ� cf. UUID(�������� �����ϴ� Ŭ����), ��¥�� �ð��� ���� ������ ������� ������ �� �ִ�.
		String upload=System.currentTimeMillis()+"";
		
		// ���� ���ε�
		fileBoard.getFile().transferTo(new File(uploadDir, upload));
		
		// DTO ��ü�� �ʵ尪 ����
		fileBoard.setOrigin(origin);
		fileBoard.setUpload(upload);
	
		fileBoardService.addFileBoard(fileBoard);
		
		return "redirect:/file_list";
	}
	
	@RequestMapping("/file_list")
	public String fileList(Model model) {
		model.addAttribute("fileBoardList", fileBoardService.getFileBoardList());
		return "file/file_list";
	}
	
	@RequestMapping("/file_delete/{num}")
	public String fileDelete(@PathVariable int num) {
			// URL �ּҷ� ǥ���� ���� �Ű������� ���޹޾� ����
		// ���� ���丮�� ����� ���ε� ���� ����
		FileBoard fileBoard=fileBoardService.getFileBoard(num);
			// �ش� �Խñۿ� ���� ���ε� ���ϵ� �����ؾ���. - ���Ϻ��� �����Ѵ�.
		
		String uploadDir=context.getServletContext().getRealPath("/WEB-INF/upload");
		new File(uploadDir, fileBoard.getUpload()).delete();

		// FILEBOARD ���̺� ����� �Խñ� ����
		fileBoardService.removeFileBoard(num);
		
		
		return "redirect:/file_list";
	}
	
	// ��û ó�� �޼ҵ忡�� ��û ó�� �� �ٿ�ε� ���α׷��� �����Ͽ� ����
	// => ��ȯ�Ǵ� ���ڿ��� �̿��Ͽ� ���α׷� ����ǵ��� ViewResolver ���� - servlet-context.xml
		// ���ϴ� ��ȣ�� �ش��ϴ� ������ �ٿ�ε�ް� ó��
		// ���ݱ��� ��� ViewName�� ��ȯ�Ͽ� JSP�� ����
	@RequestMapping("/file_download/{num}")
	public String fildDownload(@PathVariable int num, Model model) {
		FileBoard fileBoard=fileBoardService.getFileBoard(num);
		
		// �ٿ�ε� ���������� �ٿ�ε� ���α׷�(Spring Bean)���� ����
		model.addAttribute("uploadDir", context.getServletContext().getRealPath("WEB-INF/upload"));
		model.addAttribute("uploadFilename", fileBoard.getUpload());
		model.addAttribute("originFilename", fileBoard.getOrigin());
		
		// ���α׷�(Spring Bean)�� beanName ��ȯ
		
		return "fileDownload";
			// upload Ŭ������ ���� ���̺귯���� ���������� �ٿ�ε�� �����Ǵ� Ŭ����(���̺귯��)�� �������� �ʴ´�.
	}
		// ���ڿ��� ��ȯ�Ǹ� �ش��ϴ� spring bean�� ã�� �� �ش��ϴ� ���α׷��� ������
		// ���� ������ ViewResolver�� ����Ǿ� JSP ������ ã�´�.
	
	
	
	
}
