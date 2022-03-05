package xyz.itwill.mvc;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 컨트롤러(Controller) : 클라이언트의 모든 요청을 받아 요청에 대한 처리를 모델(Model - 클래스)을
// 통해 구현하고 처리결과를 뷰(View : JSP)에게 전달하여 응답되도록 이동하는 웹프로그램(서블릿)

	// Controller를 맡는 서블릿의 역할
// 1. 클라이언트의 모든 요청을 받을 수 있는 단일 진입점의 기능 설정
// @WebServlet("URL") : 클래스를 웹프로그램(서블릿)으로 등록하고 URL 주소를 매핑하는 어노테이션
// => URL 주소에 패턴기호(* 또는 ?)를 사용하여 설정 가능
	// *, ? 등을 와일드 캐릭터(와일드 카드)라고 부름 - 모든 문자를 지칭
// => @WebServlet("*.do") : 클라이언트가 XXX.do 형식의 URL 주소로 요청한 경우 서블릿 동작
	// .do 말고 다른 단어를 확장자로 사용해도 됨. - 일반적으로 do처럼 큰 의미 없는 단어 사용 e.g. 고용센터, OK cashBag
// => @WebServlet 어노테이션 대신 web.xml 파일에서 서블릿 등록과 서블릿 매핑 설정 가능
// @WebServlet("*.do")
	// 세부적인 설정을 위해 web.xml에서 서블릿 매핑설정
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 요청정보(Key)와 모델 인스턴스(Value)를 저장하기 위한 콜렉션 필드
		// key를 통해 map을 빠르게 검색하기 위한 자료구조 클래스
	private Map<String, Action> actionMap;
	
	// 클라이언트 요청에 의해 서블릿 클래스가 인스턴스로 생성된 후 가장 먼저 자동 호출하는 메소드
	// => 인스턴스 생성 후 한번만 호출 - 초기화 작업
		// 서블릿에서 생성자 대신 초기화 작업에 사용 (ServletConfig 땜시...)
	@Override
	public void init(ServletConfig config) throws ServletException {
		// System.out.println("ControllerServlet 클래스의 init() 메소드 호출");
		
		// 콜렉션 필드에 HashMap 인스턴스를 생성하여 저장
		actionMap=new HashMap<String, Action>();
		
		/*
		//  콜렉션 필드에 엔트리(요청정보 - Key, 모델 인스턴스 - Value)를 추가하여 저장
		actionMap.put("/loginForm.do", new LoginFormModel());
		actionMap.put("/login.do", new LoginModel());
		actionMap.put("/logout.do", new LogoutModel());
		actionMap.put("/writeForm.do", new WriteFormModel());
		actionMap.put("/write.do", new WriteModel());
		actionMap.put("/list.do", new ListModel());
		actionMap.put("/view.do", new ViewModel());
		actionMap.put("/modifyForm.do", new ModifyFormModel());
		actionMap.put("/modify.do", new ModifyModel());
		actionMap.put("/remove.do", new RemoveModel());
		actionMap.put("/error.do", new ErrorModel());
		*/
			// if문을 활용하는 것보다 더 효율적임.
			// web.xml에서 load-on-startup 엘리먼트를 설정하면 WAS가 동작될 때 init()메소드가 실행되어
			// 위의 엔트리들이 저장된다.
			// 하지만, 엔트리가 변결될 때마다 컨트롤러의 변경이 필요한 사실은 그대로임
			// 완성된 컨트롤러의 변경을 막기 위하여 .properties 파일 활용
		
		// Properties 파일의 요청정보와 모델 클래스를 저장하고 파일의 내용을 읽어 콜렉션
		// 필드의 엔트리로 추가 - 유지보수의 효율성 증가
		// Properties 파일(XXX.properties) : 프로그램 실행에 필요한 값을 제공하는 텍스트 파일
		
		// Properties 파일의 내용을 읽어 저장하기 위한 Properties 인스턴스(Map) 생성
		Properties properties=new Properties();
		
		// Properties 파일의 시스템 경로를 반환받아 저장
		// String configFilePath=config.getServletContext().getRealPath("/WEB-INF/model.properties");
		
		// ServletConfig.getInitParameter(String name) : web.xml 파일에서 servlet 엘리먼트의
		// 자식 엘리먼트 중 init-param 엘리먼트로 제공되는 값을 얻어와 반환하는 메소드
		String configFile=config.getInitParameter("configFile");
		String configFilePath=config.getServletContext().getRealPath(configFile);
		
		try {
			// Properties 파일에 대한 입력스트림을 생성하여 저장
			FileInputStream in=new FileInputStream(configFilePath);
			
			// Properties 파일에 저장된 내용으로 Properties 인스턴스의 엔트리로 추가
			properties.load(in);
				// HashMap에는 value로 객체를 저장할 수 있지만 properties는 둘다 문자열만 가능
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Properties 인스턴스의 엔트리(요청정보와 모델클래스)를 읽어 콜렉션 필드의
		// 엔트리(요청정보와 모델 인스턴스)로 추가
		// Properties.keySet() : Properties 인스턴스에 저장된 모든 키(Key)들을 Set 인스턴스로 반환하는 메소드
		for(Object key:properties.keySet()) { // Set 인스턴스의 요소(Key)를 차례대로 제공받아 처리
			String actionCommand=(String)key; // 요청정보 저장
			
			// Properties.get(Object key) : Properties 인스턴스의 엔트리 중 키(Key - 요청정보)를 전달
			// 받아 값(Value - 모델클래스)을 반환하는 메소드
			String actionClass=(String)properties.get(key); // 모델클래스 저장
			
			try {
				// 모델클래스를 이용하여 모델 인스턴스를 생성 - 리플렉션 기능 이용
				// 리플렉션(Reflection) : 프로그램 실행시 클래스를 읽어 인스턴스를 생성하여
				// 인스턴스의 요소(필드 또는 메소드)에 접근 가능하도록 제공하는 기능
					// runtime 시 클래스를 읽음.
				// Class.forName(String className) : 전달받은 문자열의 클래스를 이용하여
				// 메모리에 저장하는 메소드 - Class 인스턴스(Clazz) 반환
				// Class.getDeclaredConstructor().newInstance() : 메모리에 저장된 클래스(Clazz)를 
				// 이용하여 인스턴스를 생성하여 반환하는 메소드
				Action actionObject=(Action)Class.forName(actionClass).getDeclaredConstructor().newInstance();
				
				// 콜렉션 필드에 엔트리(Key - 요청정보, Value - 모델 인스턴스) 추가
				actionMap.put(actionCommand, actionObject);
			} catch (Exception e) {
				e.printStackTrace();
			}
				// if문보다는 직관적이진 않지만 위와같은 형태로 사용.
		}
	}
	
	// 클라이언트의 요청을 처리하기 위해 자동 호출되는 메소드
	// => 클라이언트의 요청이 있을 때마다 반복적으로 호출
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// System.out.println("ControllerServlet 클래스의 service() 메소드 호출");

		// 2. 클라이언트의 요청 분석 : 요청하는 URL 주소 이용 - https://localhost:8000/mvc/XXX.do
		// HttpServletRequest.getRequestURI() : 클라이언트의 요청 URI 주소를 반환하는 메소드
		String requestURI=request.getRequestURI();
		// System.out.println("requestURI = "+requestURI); // "/mvc/*.do"
		
		// HttpServletRequest.getContextPath() : 요청 URL 주소의 컨텍스트 경로를 반환하는 메소드
		String contextPath=request.getContextPath();
		// System.out.println("contextPath = "+contextPath); // "/mvc"
		
		// 요청 URL 주소의 [/XXX.do]를 이용하여 요청에 대한 처리와 응답 구분
		String command=requestURI.substring(contextPath.length());
		// System.out.println("command = "+command); // "/XXX.do"
		
		// 3. 클라이언트 요청에 대한 처리
		// => 모델(Model) 역할의 클래스로 인스턴스를 생성하여 요청처리 메소드 호출
		// => 모델 클래스의 요청 처리 메소드는 뷰 관련 정보를 반환
		/*
			 클라이언트 요청에 대한 모델 클래스 매핑 설계
			 => 모델 클래스는 인터페이스를 상속받아 동일한 구조로 작성 - 유지보수의 효율성 증가
			/loginForm.do : LoginFormModel 클래스 - 로그인정보 입력페이지 또는 환영메세지 출력페이지
			/login.do : LoginModel 클래스 - 로그인 처리페이지
			/logout.do : LogoutModel 클래스 - 로그아웃 처리페이지
			/writeForm.do : WriteFormModel 클래스 - 회원정보 입력페이지
			/write.do : WriteModel 클래스 - 회원정보 등록 처리페이지
			/list.do : ListModel 클래스 - 회원목록 출력페이지
			/view.do : ViewModel 클래스 - 회원정보 상세 출력페이지
			/modifyForm.do : ModifyFormModel 클래스 - 회원정보 변경 입력페이지
			/modify.do : ModifyModel 클래스 - 회원정보 변경 처리페이지
			/remove.do : RemoveModel 클래스 - 회원정보 삭제 처리페이지
			/error.do : ErrorModel 클래스 - 에러메세지 출력페이지
		 */
			// 위처럼 매핑할 클래스를 설계 및 작성해야함.
			// 이때, 모델클래스들을 만들기 전에 상속받을 인터페이스를 먼저 작성

			// 요청처리 클래스는 동일한 형태의 메소드를 사용하는 것을 권장 - 인터페이스
		
		// 인터페이스를 사용하여 참조변수 생성
		// => 참조변수에는 인터페이스를 상속받은 모든 자식클래스의 인스턴스 저장 가능
		
		/*
		Action action=null;
		
		if(command.equals("/loginForm.do")) {
			action=new LoginFormModel();
		} else if(command.equals("/login.do")) {
			action=new LoginModel();
		} else if(command.equals("/logout.do")) {
			action=new LogoutModel();
		} else if(command.equals("/writeForm.do")) {
			action=new WriteFormModel();
		} else if(command.equals("/write.do")) {
			action=new WriteModel();
		} else if(command.equals("/list.do")) {
			action=new ListModel();
		} else if(command.equals("/view.do")) {
			action=new ViewModel();
		} else if(command.equals("/modifyForm.do")) {
			action=new ModifyFormModel();
		} else if(command.equals("/modify.do")) {
			action=new ModifyModel();
		} else if(command.equals("/remove.do")) {
			action=new RemoveModel();
		} else if(command.equals("/error.do")) {
			action=new ErrorModel();
		} else { // 클라이언트 요청에 대한 Model 클래스가 없는 경우
			action=new ErrorModel();
		}
		*/
			/*
			 * 클라이언트 요청을 구분하기 위해 if문을 사용했는데
			 * 이 같은 경우에는 가독성이 좋지 않다.
			 * -> 가독성을 좋게 하기위해 수정 (HashMap - actionMap 사용)
			 */
		
		// 콜렉션 필드에 저장된 엔트리에서 요청정보(Key - command)를 전달하여 모델 인스턴스(Value)를
		// 반환받아 부모 인터페이스의 참조변수에 저장 - 가독성 증가
		Action action=actionMap.get(command);
		if(action==null) { // 클라이언트 요청에 대한 모델 인스턴스가 없는 경우
			action=new ErrorModel();
		}
		
		
		// 부모 인터페이스의 추상메소드를 호출하면 참조변수에 저장된 자식 인스턴스(모델)의
		// 오버라이드 메소드 호출 - 메소드 오버라이드에 의한 다형성
		// => 요청 처리 메소드를 호출하면 뷰 관련 정보를 반환받아 저장
		ActionForward actionForward=action.execute(request, response);
		
		// 4. 반환받은 뷰 관련 정보를 이용하여 클라이언트에게 응답 처리
		if(actionForward.isForward()) { // forward 필드값이 [true]인 경우 - 포워드 이동
			// 컨트롤러에서 뷰(View - JSP 문서)로 스레드를 이동하여 클라이언트에게
			// HTML을 전달하여 응답 처리 
			request.getRequestDispatcher(actionForward.getPath()).forward(request, response);
		} else { // forward 필드값이 [false]인 경우 - 리다이렉트 이동
			// 클라이언트에게 URL 주소(/XXX.do)를 전달하여 재요청하도록 응답 처리
			response.sendRedirect(actionForward.getPath());
		}
	}
	
	
	/*
		모든 요청의 기준은 Controller
		=> controller에 요청을 해야한다.
		
		대형 사이트를 java로 만들어주는 이유가 model 2 때문이다.
		
		Model - Service 클래스 사용, try~catch 구문으로 예외 일괄처리
		
	 */
}
