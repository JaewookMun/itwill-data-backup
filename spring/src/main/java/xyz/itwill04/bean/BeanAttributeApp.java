package xyz.itwill04.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanAttributeApp {
	public static void main(String[] args) {
		System.out.println("========== Spring Container 초기화 전 =======");
		ApplicationContext context=new ClassPathXmlApplicationContext("04-2_beanAttribute.xml");
			// Spring Container가 생성되며 xml 파일을 읽어들일 때 스프링 빈 설정파일에 등록되어있는 빈들의 객체를 모두 생성한다.
			// xml 파일을 읽어 Spring container의 초기화 작업 수행
		System.out.println("========== Spring Container 초기화 후 =======");
		// ApplicationContext.getBean(String beanName) : beanName을 전달하여 Spring Container로 부터
		// Spring Bean을 검색하여 반환하는 메소드
		// => Object 타입으로 Spring Bean을 반환하므로 명시적 객체 형변환하여 사용
		// InitDestroyMethodBean bean=(InitDestroyMethodBean)context.getBean("initDestroyMethodBean");
		
		// ApplicationContext.getBean(String beanName, Class<T> clazz) : beanName과 Clazz를
		// 전달하여 Spring Container로부터 Spring Bean을 검색하여 객체 형변환 후 반환하는 메소드
			// 내부적으로 형변환하여 전달 - 위의 메소드보다 가독성이 더 높음.
			// 더 많이 사용되는 getBean 메소드 - 권장.
		InitDestroyMethodBean bean=context.getBean("initDestroyMethodBean", InitDestroyMethodBean.class);
		
		//bean.init();
		bean.display();
		//bean.destroy();
			// 자동호출 되도록 설정파일에서 지정할 수 있다.
			// 초기화 작업을 해주는 인터페이스가 굉장히 많다. - ~Aware interface  but 과거방식
			// init 설정방식 - 참고만 하는정도로 check;
		
		System.out.println("===================================================");
		context.getBean("lazyInitBean", LazyInitBean.class);
			// bean 엘리먼트의 속성값을 수정하여 container 초기화 때 객체를 생성하지 않을 수 있음.
		System.out.println("===================================================");
		ScopeBean bean1=context.getBean("singleton", ScopeBean.class);
		ScopeBean bean2=context.getBean("singleton", ScopeBean.class);
		ScopeBean bean3=context.getBean("singleton", ScopeBean.class);
		
		System.out.println("bean1 = "+bean1);
		System.out.println("bean2 = "+bean2);
		System.out.println("bean3 = "+bean3);
			// bean1,2,3 은 모두 같은 객체이다. (hash코드값이 모두 같음) - 싱글턴 패턴이 아니여도 객체가 하나만 생성된다.
			// 클래스 생성시 singleton 패턴을 적용한 클래스를 임의로 만들 필요가 없다. - Spring Container가 하나의 객체만 생성해주기 때문에...
			// Singleton 클래스는 상속이 안되기 때문에 클래스의 상속성을 위반한다.
		
		System.out.println("===================================================");
		ScopeBean bean4=context.getBean("prototype", ScopeBean.class);
		ScopeBean bean5=context.getBean("prototype", ScopeBean.class);
		ScopeBean bean6=context.getBean("prototype", ScopeBean.class);
			// getBean 할때마다 객체를 생성하여 반환 - 대부분 싱글턴속성 사용
		
		System.out.println("bean4 = "+bean4);
		System.out.println("bean5 = "+bean5);
		System.out.println("bean6 = "+bean6);
		
		System.out.println("===================================================");
		((ClassPathXmlApplicationContext)context).close();
		System.out.println("===================================================");
	}
}
