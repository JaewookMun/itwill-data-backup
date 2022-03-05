package xyz.itwill.util;

public class Utility {
	// JSON 형식의 텍스트 데이터를 전달받아 자바스크립트 객체의 속성값으로 표현할 수 없는 문자를
	// 회피문자(Escape Character)로 변환하여 반환하는 메소드
		// 속성값에 엔터가 있으면 문제가 발생. 엔터 이후까지 속성값으로 인식을 못함.
		// 엔터, 더블쿼테이션 등등.
	public static String toJSON(String source) {
		return source.replace("\\", "\\\\").replace("\"", "\\\"")
				.replace("\n", "\\n").replace("\r\n", "\\n");
	}
	
	
}
