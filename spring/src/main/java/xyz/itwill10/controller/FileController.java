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

// 파일 업로드
// 1. commons-fileupload 라이브러리 빌드 처리 - pom.xml
// 2. 파일 업로드 기능을 제공하는 클래스를 Spring Bean으로 등록 - servlet-context.xml
	// Spring Bean으로 등록해야 Spring Bean객체를 제공받아 파일을 업로드할 수 있다.
@Controller
public class FileController {
	@Autowired
	private WebApplicationContext context;
		// SpringMVC에서 사용하는 Spring Container
	
	@Autowired
	private FileBoardService fileBoardService;
	
	@RequestMapping(value = "/upload", method=RequestMethod.GET)
	public String upload() {
		return "file/upload";
	}
	
	/*
	// MultipartHttpServletRequest : "multipart/form-data"로 전달되는 값과 파일을 처리하기 위한 객체
	@RequestMapping(value = "/upload", method=RequestMethod.POST)
	public String upload(MultipartHttpServletRequest request) throws IOException {
		String uploadName=request.getParameter("uploadName");
		
		// MultipartHttpServletRequest.getFile(String parameterName) : 전달된 파일을 
		// MultipartFile 객체로 반환하는 메소드
		// MultipartFile : 전달된 파일의 정보를 저장하는 객체
			// 파일에 대한 정보.
		MultipartFile uploadFile=request.getFile("uploadFile");
		
		// 전달파일에 대한 유효성 검사 : 파일 유무, 파일 형식, 파일 크기
		// MultipartFile.isEmpty() : 전달된 파일이 없는 경우 true를 반환하는 메소드
		if(uploadFile.isEmpty()) {
			return "file/upload_fail";
		}
		
		// MultipartFile.getContentType() : 전달된 파일의 형식(MimeType)을 반환하는 메소드
		System.out.println("파일 형식 = "+uploadFile.getContentType());
		// MultipartFile.getBytes() : 전달된 파일을 byte 배열로 변환하여 반환하는 메소드
		System.out.println("파일 크기 = "+uploadFile.getBytes().length);
		
		// 전달된 파일을 서버에 저장하기 위한 업로드 디렉토리의 시스템 경로를 반환받아 저장
		String uploadDir=request.getServletContext().getRealPath("/resources/images");
		
		// 전달파일을 서버에 저장하기 위한 File 객체 생성
		// MultipartFile.getOriginalFilename() : 전달파일의 이름을 반환하는 메소드
		File file = new File(uploadDir, uploadFile.getOriginalFilename());
		
		// MultipartFile.transferTo(File file) : 전달파일을 서버에 저장하는 메소드
		// => 서버 업로드 디렉토리에 업로드 파일과 같은 이름의 파일이 있는 경우 덮어씌우기하여 저장
			// 파일이름을 변경하는 알고리즘을 구현해야함.
		uploadFile.transferTo(file); // 업로드 처리

		request.setAttribute("uploadName", uploadName);
		request.setAttribute("uploadFile", uploadFile.getOriginalFilename());
		
		return "file/upload_ok";
	}
	*/
	
	
	@RequestMapping(value = "/upload", method=RequestMethod.POST)
	public String upload(@RequestParam String uploadName, @RequestParam MultipartFile uploadFile, Model model) throws IOException {
			// 파일은 MultipartFile로 받아야함, String이 아니다.
			// Front Controller에게 요청하여 데이터를 받을 수 있다.
		
		if(uploadFile.isEmpty()) {
			return "file/upload_fail";
		}
		
		// WebApplicationContext 객체를 이용하여 서버 업로드 디렉토리의 시스템 경로를 반환받아 저장
			// WebApplicationContext는 웹자원의 대부분을 사용할 수 있다.
		String uploadDir=context.getServletContext().getRealPath("/resources/images");
		File file = new File(uploadDir, uploadFile.getOriginalFilename());
			// Orelly와 달리 파일이름이 중복될 때 자동으로 이름이 변경되지 않는다.
			// commons-fileupload 라이브러리의 클래스는 오버라이트 되기때문에 
			// 파일이름을 임의로 변경해야한다. (알고리즘을 통해 수정이 필요)
			// orelly그룹의 업로드방식은 무조건 업로드 되기 때문에 유효성검사를 실시할 수 없다.
			// commons는 선택적인 업로드가 가능하다.
		
		// MultipartFile.transferTo(File file) : 전달파일을 서버에 저장하는 메소드
		uploadFile.transferTo(file); // 업로드 처리
		
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
		if(fileBoard.getFile().isEmpty()) { // 파일이 전달되지 않은 경우
			return "file/file_upload";
		}
		
		String uploadDir=context.getServletContext().getRealPath("/WEB-INF/upload");
			// 자료실을 만들기 위해 WEB-INF 폴더 밑에 폴더를 만들어 업로드경로를 설정 - 브라우저가 직접 리소스를 접근할 수 없도록 설정
			// 파일이름을 변경하여 저장
			// 이유 1. 보안상의 이유 / 이유 2. 파일이름 중복방지 - overwrite 회피
			// 해당 파일은 apache-tomcat의 폴더에서 확인 가능
		
		// 전달파일명을 반환받아 저장
		String origin=fileBoard.getFile().getOriginalFilename();
		
		// 업로드 파일명을 고유값(현재 시스템의 TimeStamp를 사용)으로 설정하여 저장
		// => 업로드 파일명이 중복되지 않도록 설정
			// 고유값을 얻는 방법은 다양 cf. UUID(고유값을 제공하는 클래스), 날짜와 시간이 가장 간단한 방식으로 생각될 수 있다.
		String upload=System.currentTimeMillis()+"";
		
		// 파일 업로드
		fileBoard.getFile().transferTo(new File(uploadDir, upload));
		
		// DTO 객체의 필드값 변경
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
			// URL 주소로 표현된 값을 매개변수에 전달받아 저장
		// 서버 디렉토리에 저장된 업로드 파일 삭제
		FileBoard fileBoard=fileBoardService.getFileBoard(num);
			// 해당 게시글에 대한 업로드 파일도 삭제해야함. - 파일부터 삭제한다.
		
		String uploadDir=context.getServletContext().getRealPath("/WEB-INF/upload");
		new File(uploadDir, fileBoard.getUpload()).delete();

		// FILEBOARD 테이블에 저장된 게시글 삭제
		fileBoardService.removeFileBoard(num);
		
		
		return "redirect:/file_list";
	}
	
	// 요청 처리 메소드에서 요청 처리 후 다운로드 프로그램을 실행하여 응답
	// => 반환되는 문자열을 이용하여 프로그램 실행되도록 ViewResolver 설정 - servlet-context.xml
		// 원하는 번호에 해당하는 파일을 다운로드받게 처리
		// 지금까지 계속 ViewName을 반환하여 JSP로 응답
	@RequestMapping("/file_download/{num}")
	public String fildDownload(@PathVariable int num, Model model) {
		FileBoard fileBoard=fileBoardService.getFileBoard(num);
		
		// 다운로드 파일정보를 다운로드 프로그램(Spring Bean)에게 제공
		model.addAttribute("uploadDir", context.getServletContext().getRealPath("WEB-INF/upload"));
		model.addAttribute("uploadFilename", fileBoard.getUpload());
		model.addAttribute("originFilename", fileBoard.getOrigin());
		
		// 프로그램(Spring Bean)의 beanName 반환
		
		return "fileDownload";
			// upload 클래스는 관련 라이브러리가 존재하지만 다운로드는 제공되는 클래스(라이브러리)가 존재하지 않는다.
	}
		// 문자열이 반환되면 해당하는 spring bean을 찾은 뒤 해당하는 프로그램이 없으면
		// 다음 순위의 ViewResolver가 적용되어 JSP 문서를 찾는다.
	
	
	
	
}
