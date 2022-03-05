package xyz.itwill04.bean;

/*
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanNameAware;
*/
// �ʱ� ���
// Annotation�� �̿��ϸ� �Ǳ� ������ Aware�������̽��� ��ӹ��� ū ������ ����.

public class InitDestroyMethodBean /* implements BeanNameAware, BeanClassLoaderAware */ {
	public InitDestroyMethodBean() {
		System.out.println("### InitDestroyMethodBean Ŭ������ �⺻ ������ ȣ�� ###");
	}
	
	// ��ü ���� �� �ʱ�ȭ �۾��� ���� �ѹ��� ȣ���ϱ� ���� �޼ҵ�
	public void init() {
		System.out.println("*** InitDestroyMethodBean Ŭ������ init() �޼ҵ� ȣ�� ***");
	}
	
	// ��ü �Ҹ� �� ������ �۾��� ���� �ѹ��� ȣ���ϱ� ���� �޼ҵ�
	public void destroy() {
		System.out.println("*** InitDestroyMethodBean Ŭ������ destroy() �޼ҵ� ȣ�� ***");
	}
	
	public void display() {
		System.out.println("*** InitDestroyMethodBean Ŭ������ display() �޼ҵ� ȣ�� ***");
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
