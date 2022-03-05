package xyz.itwill05.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationStudentApp {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("05-4_diAnnotation.xml");
		System.out.println("======================================================================");
		StudentService service=context.getBean("studentService", StudentService.class);
		service.addStudent(null);
		System.out.println("======================================================================");
		((ClassPathXmlApplicationContext)context).close();
	}
}

/*
	직접 만들어서 사용하는 클래스는 어노테이션 (ex. DAO, Service, etc.)
	배포받아 사용하는 클래스는 bean 엘리먼트 (cf. 배포받아 사용하는 클래스는 소스를 수정할 수 없기 때문에 어노테이션 불가능..) 
	사용 권장
 */
