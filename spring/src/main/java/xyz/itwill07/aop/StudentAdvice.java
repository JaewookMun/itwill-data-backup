package xyz.itwill07.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Advice 클래스 : 횡단관심모듈이 선언된 클래스
// 횡단관심모듈(CrossCutting Concern Module) : 횡단관심코드가 작성된 메소드
// 횡단관심코드 : 핵심관심코드 실행 전 또는 후에 실행될 부가적인 명령
// => 로그, 보안(권한 처리), 트랜젝션 처리, 예외처리 등의 명령
public class StudentAdvice {
	private static final Logger logger=LoggerFactory.getLogger(StudentAdvice.class);
	
	// 타겟메소드(핵심관심모듈)의 동작 전 삽입되어 실행될 명령을 작성하기 위한 메소드(횡단관심모듈)
	// => JoinPoint : Before Advice
	// JoinPoint : 핵심관심모듈을 기준으로 횡단관심모듈이 삽입될 위치 표현
		// 핵심관심모듈에서 원하는 메소드만 타겟메소드라 부른다.
	public void beforeLog() {
		logger.info("[before]핵심관심코드 동작 전 삽입되어 실행될 횡단관심코드");
			// 로그이벤트를 발생시키고 log4j라는 로그 구현체가 기록을 해준다.
	}
	
	// 타겟메소드의 동작 후 삽입되어 실행될 명령을 작성하기 위한 메소드
	// => 타겟메소드에서 발생되는 예외와 상관없이 무조건 삽입되어 실행
	// => JoinPoint : After Advice
		// JoinPoint가 'After' 이다.
	public void afterLog() {
		logger.info("[after]핵심관심코드 동작 후 무조건 삽입되어 실행될 횡단관심코드");
	}

	// 타겟메소드의 동작 후 삽입되어 실행될 명령을 작성하기 위한 메소드
	// => 타겟메소드에서 예외가 발생되지 않은 경우 삽입되어 실행
	// => JoinPoint : After Returning Advice
	public void afterReturningLog() {
		logger.info("[after-returning]핵심관심코드 정상 동작 후 삽입되어 실행될 횡단관심코드");
	}
	
	// 타겟메소드의 동작 후 삽입되어 실행될 명령을 작성하기 위한 메소드
	// => 타겟메소드에서 예외가 발생된 경우에만 삽입되어 실행
	// => JoinPoint : After Throwing Advice
	public void afterThrowingLog() {
		logger.info("[after-throwing]핵심관심코드 동작시 예외가 발생된 후 삽입되어 실행될 횡단관심코드");
	}
		// 예외처리할 때 많이 사용되는 편 - '예외로그'
	
	
	// 타겟메소드의 동작 전후 삽입되어 실행될 명령을 작성하기 위한 메소드
	// => JoinPoint : Around Advice
		// 가장 많이 사용되는 join point
	public Object aroundLog(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.info("[around]핵심관심코드 동작 전 삽입되어 실행될 횡단관심코드");
		Object object = joinPoint.proceed(); // 타겟메소드 호출 - 핵심관심코드 실행
		logger.info("[around]핵심관심코드 동작 후 삽입되어 실행될 횡단관심코드");
		return object;
			// 타겟메소드를 반드시 호출하여 핵심관심코드를 실행시켜야한다.
	}
	
	

		// Advice 클래스 메소드는 JoinPoint에 따라 사용할 수 있는 매개변수가 다르다.


}
