package xyz.itwill04.bean;

import org.springframework.stereotype.Component;

// @Component : 클래스를 Spring Bean으로 등록하기 위한 어노테이션
// => 기본적으로 클래스명을 beanName으로 설정 - 첫문자는 소문자로 변환
// @Component 어노테이션의 value 속성을 사용하여 beanName 변경 가능
// => 다른 속성이 없는 경우 속성값만 설정
	// beanName 변경은 권장하지 않는다.
@Component("bean") // (value="bean")으로 표기해도 상관없음
public class ComponentAnnotationBean {
	public ComponentAnnotationBean() {
		System.out.println("### ComponentAnnotationBean 클래스의 기본 생성자 호출 ###");
	}
	
	public void display() {
		System.out.println("*** ComponentAnnotationBean 클래스의 display() 메소드 호출 ***");
	}
}
	/*
		Component 어노테이션 역시 속성 어노테이션을 통해 bean Attribute를 설정할 수 있다.
		배포된 클래스를 사용할 때는 XML 설정을 통해 사용하는 수밖에 없다. 직접 만드는 클래스만 어노테이션 활용가능
		일반적인 클래스를 bean으로 등록하는 어노테이션 - Component
		특별한 클래스를 스프링빈으로 등록하는 어노테이션 역시 존재함. 
	 */
