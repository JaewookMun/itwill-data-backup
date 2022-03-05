package xyz.itwill03.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// Spring Container로 객체를 생성하여 제공받아 사용
// => 개발자가 아닌 Spring Container가 객체 관리 -  Spring IoC
// => Spring Bean Configuration File(XML)을 이용하여 객체 생성과 객체간의 의존관계 설정
	// src/main/resources 폴더에 생성 - 원활한 관리를 위해
	// 위 SBC 파일을 만드는건 일반적인 XML 파일을 만드는 방식과 다르다.
	// new > Spring Bean Configuration
public class MessagePrintApp {
	public static void main(String[] args) {
		/*
		HelloMessageObject object = new HelloMessageObject();
		MessagePrint print=new MessagePrint();
		print.setObject(object); // 포함관계(의존관계) 성립
		print.messagePrint();
			// 위의 관계는 결합도가 높은 관계이다.
		 */
		
		// ApplicationContext 객체(Spring Container) 생성
		// => Spring Bean Configuration File을 제공받아 Spring Bean을 생성하여 관리
			// ApplicationContext를 생성받은 자식 클래스
			// GenericApplicationContext를 사용해도 됨
			// bean Configuration 파일을 읽어서 Spring Container를 만드는 것을 컨테이너 초기화라고 한다.
		ApplicationContext context=new ClassPathXmlApplicationContext("03_message.xml");
		
		// Spring Container가 관리하는 Spring Bean을 제공받아 저장
		// => bean 엘리먼트의 식별자(beanName)를 전달하여 Spring Container로부터 Spring Bean 반환
		MessagePrint print=(MessagePrint)context.getBean("messagePrint");
		print.messagePrint();
		
		// Spring Container 제거 - Spring Container가 관리하는 모든 Spring Bean 제거
			// 제거안하더라도 GC에 의해 자동 제거되어 제거 안해도 상관없음. 하지만 안하면 경고가 발생하기 때문에 이를 막기 위해 제거
		((ClassPathXmlApplicationContext)context).close();
		
			// Spring Container를 활용하여 결합도를 최대로 낮춤
	}
}
