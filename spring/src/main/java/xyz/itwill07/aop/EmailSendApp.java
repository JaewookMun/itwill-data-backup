package xyz.itwill07.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmailSendApp {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("07-4_email.xml");
		System.out.println("========================================================================================================");
		EmailSendBean bean=context.getBean("emailSendBean", EmailSendBean.class);
		bean.sendEmail("stoneface123@naver.com", "메일 전송 테스트"
				, "JavaMail 기능을 이용한 이메일 전송 테스트 입니다.");
		
		System.out.println("========================================================================================================");
		((ClassPathXmlApplicationContext)context).close();
	}
}
