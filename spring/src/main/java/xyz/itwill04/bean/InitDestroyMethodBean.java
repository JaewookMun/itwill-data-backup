package xyz.itwill04.bean;

/*
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanNameAware;
*/
// 초기 방식
// Annotation을 이용하면 되기 때문에 Aware인터페이스를 상속받을 큰 이유가 없다.

public class InitDestroyMethodBean /* implements BeanNameAware, BeanClassLoaderAware */ {
	public InitDestroyMethodBean() {
		System.out.println("### InitDestroyMethodBean 클래스의 기본 생성자 호출 ###");
	}
	
	// 객체 생성 후 초기화 작업을 위해 한번만 호출하기 위한 메소드
	public void init() {
		System.out.println("*** InitDestroyMethodBean 클래스의 init() 메소드 호출 ***");
	}
	
	// 객체 소멸 전 마무리 작업을 위해 한번만 호출하기 위한 메소드
	public void destroy() {
		System.out.println("*** InitDestroyMethodBean 클래스의 destroy() 메소드 호출 ***");
	}
	
	public void display() {
		System.out.println("*** InitDestroyMethodBean 클래스의 display() 메소드 호출 ***");
	}

	
	/*
	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBeanName(String name) {
		// TODO Auto-generated method stub
		
	}
	*/
}
