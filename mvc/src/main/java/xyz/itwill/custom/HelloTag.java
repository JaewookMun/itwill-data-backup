package xyz.itwill.custom;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

// 커스텀 태그(Custom Tag) : JSP 문서에서 사용하기 위해 개발자가 직접 만든 태그
// => 태그 클래스 작성 > TLD 파일에 커스텀 태그 등록 > JSP 문서에서 커스텀 태그 사용

// 태그 클래스 : JSP 문서에 커스텀 태그 사용시 호출될 메소드가 선언된 클래스
// => TagSupport, BodyTagSupport, SimpleTagSupport 클래스 중 하나를 상속받아 작성
// => 커스텀 태그 사용시 호출되는 메소드는 부모 클래스의 메소드를 오버라이드 선언하여 작성

// 태그 속성과 태그 내용이 없는 커스텀 태그의 태그 클래스
	// 태그 속성과 태그 내용이 있으면 다소 바뀌게 된다.
public class HelloTag extends TagSupport {
	private static final long serialVersionUID = 1L;

	// JSP 문서에서 커스텀 태그를 사용할 경우 태그 클래스를 인스턴스로 생성하기 위해 자동 호출 - 1번
	public HelloTag() {
		System.out.println("[정보]HelloTag 클래스의 생성자 호출 - 인스턴스 생성");
	}
		// 원래 생성자를 만들 필요는 없다. - 생성자가 생성되는 것을 보여주기 위해 작성함..
	
	// JSP 문서에서 커스텀 태그의 시작태그 사용시 자동 호출되는 메소드 - 필수
	@Override
	public int doStartTag() throws JspException {
		// System.out.println("[정보]HelloTag 클래스의 doStartTag() 메소드 호출");
		try {
			// 부모클래스(TagSupport)에서 제공되는 pageContext 인스턴스로 웹프로그램 작성에
			// 필요한 인스턴스를 제공받아 사용
			// pageContext.getOut() : 응답결과를 생성하기 위한 출력스트림을 반환하는 메소드
			// => 출력스트림의 메소드를 호출하여 클라이언트에게 HTML 전달
			pageContext.getOut().println("<div>안녕하세요</div>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// doStartTag 메소드의 반환값(상수) : SKIP_BODY, EVAL_BODY_INCLUDE, EVAL_BODY_AGAIN
		// => SKIP_BODY : 태그내용을 클라이언트에게 전달하지 않을 경우 사용하는 반환값
		// => EVAL_BODY_INCLUDE : 태그내용을 클라이언트에게 전달할 경우 사용하는 반환값(기본)
			// 상속 시 오버라이드하면 적용됨
		// => EVAL_BODY_AGAIN : 태그내용을 클라이언트에게 다시 한번 전달할 경우 사용하는 반환값
		return super.doStartTag();
	}
		// 시작태그와 종료태그는 하나의 쌍으로 묶여져 있어야 한다.
	
	// JSP 문서에서 커스텀 태그의 태그내용 실행후 자동 호출되는 메소드 - 선택
		// 잘사용되지 않음. & 태그내용이 없으면 사용할 이유가 없음.
	@Override
	public int doAfterBody() throws JspException {
		// System.out.println("[정보]HelloTag 클래스의 doAfterBody() 메소드 호출");
		return super.doAfterBody();
	}
	
	// JSP 문서에서 커스텀 태그의 종료태그 사용시 자동 호출되는 메소드 - 선택
	@Override
	public int doEndTag() throws JspException {
		// System.out.println("[정보]HelloTag 클래스의 doEndTag() 메소드 호출");
		// doEndTag 메소드의 반환값(상수) : SKIP_PAGE, EVAL_PAGE
		// => SKIP_PAGE : 태그 실행 후 JSP 문서를 강제로 종료하는 반환값
		// => EVAL_PAGE : 태그 실행 후 JSP 문서를 계속 처리하는 반환값(기본)
		return EVAL_PAGE;
			// return 을 SKIP_PAGE로 변경하면 페이지출력이 종료된다. (이후 페이지 내용 x)
	}
}
