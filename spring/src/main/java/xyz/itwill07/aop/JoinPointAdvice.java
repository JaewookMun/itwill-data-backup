package xyz.itwill07.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

// 횡단관심모듈이 선언된 클래스
public class JoinPointAdvice {
	// Around Advice를 제외한 Advice 메소드는 반환형을 void로 작성하고 매개변수를
	// 미작성 하거나 JoinPoint를 자료형으로 하는 매개변수 작성 가능
	// JoinPoint : 타겟메소드(핵심관심모듈)의 정보를 저장하기 위한 객체
	// => Spring Container가 Advice 메소드를 호출할 때 타겟메소드의 정보(JoinPoint 객체)가 자동으로 JoinPoint 매개변수에 전달되어 저장
	// => Advice 메소드(횡단관심코드)에서 타겟메소드의 정보가 필요한 경우 JoinPoint 매개변수 작성
	public void displayTarget(JoinPoint joinPoint) {// before Advice
		// System.out.println("[before] 핵심관심모듈 동작 전 삽입되어 실행될 횡단관심모듈");
		
		// JoinPoint.getTarget() : 타겟메소드를 호출하는 Spring Bean 객체를 반환하는 메소드
		// => 타겟메소드가 선언된 클래스 객체를 Object 타입으로 반환
		// Object.getClass() : 객체에 대한 클래스 정보(Class 객체 - Clazz)를 반환하는 메소드
			// Clazz : 메모리에 로딩(저장)된 클래스 정보를 의미한다.
		// Class.getName() : Class 객체(Clazz)의 클래스명(패키지 포함)을 반환하는 메소드
		// System.out.println(joinPoint.getTarget().getClass().getName());
		// Class.getSimpleName() : Class 객체(Clazz)의 클래스명(패키지 미포함)을 반환하는 메소드
		// System.out.println(joinPoint.getTarget().getClass().getSimpleName());
		
		// JoinPoint.getSignature() : 타겟메소드의 정보(Signature 객체)를 반환하는 메소드
		// Signature.getName() : Signature 객체의 타겟메소드명을 반환하는 메소드
		// System.out.println(joinPoint.getSignature().getName());
		
		String className=joinPoint.getTarget().getClass().getSimpleName();
		String methodName=joinPoint.getSignature().getName();
		
		// System.out.println("[before]"+className+" 클래스의 "+methodName+"() 메소드 호출");
		
		// JoinPoint.getArgs() : 타겟메소드의 매개변수에 저장된 모든 값을 Object 배열로 반환하는 메소드
		Object[] objects=joinPoint.getArgs();
	
		/*
		if(methodName.equals("remove")) {
			int num=(Integer)objects[0];
			System.out.println("[결과]"+methodName+"() 메소드의 매개변수에 전달된 값 = "+num);
		}
		*/
		
		System.out.println("[before]"+className+" 클래스의 "+methodName+"() 메소드에 선언된 매개변수의 갯수 = "+objects.length);
			// 타겟 클래스의 이름, 메소드명, 메소드의 매개변수를 JoinPoint로 횡단관심코드에서 사용가능 - Around Advice 제외
	}
	
	// After Returning Advice 메소드에는 JoinPoint 매개변수와 Object 타입의 매개변수 작성 가능
	// => Object 타입의 매개변수에는 타겟메소드의 반환값을 전달받아 저장
	// => 타겟메소드의 반환값의 자료형이 고정된 경우 Object 타입 대신 반환값의 자료형(클래스) 작성 가능
	// after-returning 엘리먼트의 returning 속성에 매개변수명을 속성값으로 반드시 설정해야만
	// 타겟메소드의 반환값이 매개변수에 전달되어 저장
	public void displayName(Object object) { // After Returning Advice
		// System.out.println("[after-returning] 핵심관심모듈이 정상적으로 동작된 후 삽입되어 실행될 횡단관심모듈");
		if(object instanceof String) {
			String name=(String)object;
			System.out.println("[after-returning]"+name+"님, 환영합니다.");
		}
	}
	
	// After Throwing Advice 메소드에는 JoinPoint 매개변수와 Exception 타입의 매개변수 작성 가능
	// => Exception 매개변수에는 타겟메소드에서 발생된 예외(Exception 객체)를 전달받아 저장
	// after-throwing 엘리먼트의 throwing 속성에 매개변수명을 속성값으로 반드시 설정해야만
	// 타겟메소드의 예외(Exception 객체)가 매개변수에 전달되어 저장
	public void displayException(Exception exception) { // After Throwing Advice
		// System.out.println("[after-throwing] 핵심관심모듈 동작시 예외가 발생된 후 삽입되어 실행될 횡단관심모듈");
		
		System.out.println("[after-throwing]타겟메소드에서 발생된 예외 메세지 = "+exception.getMessage());
	}
	
	// Around Advice 메소드는 반환형을 Object 타입으로 작성하고 ProceedingJoinPoint 매개변수 작성 
	// => Around Advice 메소드는 타겟메소드의 반환값을 반환하기 위해 반환형을 Object로 작성
	// ProceedingJoinPoint : 타겟메소드의 정보를 저장하기 위한 객체
	// => 타겟 메소드를 호출할 수 있는 기능 제공 - Throwable 객체 발생
	// => Throwable 객체(프로그램에서 발생되는 모든 오류 정보를 저장한 객체) 전달
		// 일반 joinpoint는 타겟메소드의 정보만 가지고 있는 반면에 ProceedingJoinPoint는 타겟메소드의 정보 외에 호출할 수 있는 기능도 가지고 있다.
	public Object display(ProceedingJoinPoint joinPoint) throws Throwable { // Around Advice
		System.out.println("[around] 핵심관심모듈 동작 전에 삽입되어 실행되는 횡단관심모듈");
		// ProceedingJoinPoint.proceed() : 타겟메소드를 호출하는 메소드 - 핵심관심모듈 동작
		// => 타겟메소드의 반환값을 반환받아 저장
		// => Throwable 객체(오류 정보) 발생 - 예외 처리
		Object object=joinPoint.proceed();
		System.out.println("[around] 핵심관심모듈 동작 후에 삽입되어 실행되는 횡단관심모듈");
		
		return object; // 타겟메소드의 반환값을 반환
	}
	
}

/*
	Advice 클래스의 메소드를 선언할 때,
	식별자(이름)는 임의로 작성해도 상관 없으나
	반환형과 매개변수는 정해진 규칙대로 선언한다.
	
	Advice 클래스 메소드는 Spring Container가 호출한다.
 */

