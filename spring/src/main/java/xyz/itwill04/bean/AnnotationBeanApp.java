package xyz.itwill04.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanApp {
	public static void main(String[] args) {
		System.out.println("========== Spring Container 초기화 전 =======");
		ApplicationContext context=new ClassPathXmlApplicationContext("04-3_beanAnnotation.xml");
			// Spring bean으로 등록되어 있어야 사용가능
		System.out.println("========== Spring Container 초기화 후 =======");
		
		AnnotationBean bean=context.getBean("annotationBean", AnnotationBean.class);
		bean.display();
		System.out.println("==================================================================================");
		((ClassPathXmlApplicationContext)context).close();
	
	}
}
