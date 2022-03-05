package xyz.itwill07.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExecutionTimeApp {
	public static void main(String[] args) {
		ApplicationContext context= new ClassPathXmlApplicationContext("07-3_timer.xml");
		System.out.println("========================================================================================================");
		ExecutionTimeBean bean=context.getBean("executionTimeBean", ExecutionTimeBean.class);
		
		bean.run();
		System.out.println("========================================================================================================");
		((ClassPathXmlApplicationContext)context).close();
	}
}