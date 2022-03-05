package xyz.itwill.app;

//import : 다른 패키지의 자료형(참조형)을 명확하게 표현하기 위해 사용하는 키워드
//=> 이클립스에서는 자료형을 자동완성(Ctrl+Space)하면 자동으로 import 구현
//import 설정을 정리하는 단축키 : [Ctrl]+[Shift]+[O]
import xyz.itwill.subject.OracleSubject;
import xyz.uniwill.subject.NetworkSubject;
import xyz.itwill.subject.JavaSubject;
//같은 이름의 자료형은 import 설정 불가능 - 하나의 자료형만 import 설정 가능
//import xyz.uniwill.subject.JavaSubject;


public class SubjectApp {
	public static void main(String[] args) {
		//같은 패키지의 자료형(참조형)은 패키지 표현없이 자료형만 명시하여 사용 가능
		//다른 패키지의 자료형은 패키지를 표현하여 자료형을 명시해야만 사용 가능 - 패키지.자료형
		//xyz.itwill.subject.OracleSubject subject1 = new xyz.itwill.subject.OracleSubject(); 
		
		//import  설정된 자료형은 패키지 표현없이 자료형만 명시하여 사용 가능
		OracleSubject subject1 = new OracleSubject();
		subject1.display();
		
		NetworkSubject subject2=new NetworkSubject();
		subject2.display();
		
		//같은 이름의 자료형이 존재할 경우 패키지를 고려하여 import 설정
		JavaSubject subject3=new JavaSubject();
		subject3.display();
		
		//같은 이름의 자료형은 import 설정되지 않기 때문에 패키지를 명시하여 자료형 사용
		xyz.uniwill.subject.JavaSubject subject4=new xyz.uniwill.subject.JavaSubject();
		subject4.display();
		
	}
	
}
