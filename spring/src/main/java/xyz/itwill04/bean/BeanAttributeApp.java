package xyz.itwill04.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanAttributeApp {
	public static void main(String[] args) {
		System.out.println("========== Spring Container �ʱ�ȭ �� =======");
		ApplicationContext context=new ClassPathXmlApplicationContext("04-2_beanAttribute.xml");
			// Spring Container�� �����Ǹ� xml ������ �о���� �� ������ �� �������Ͽ� ��ϵǾ��ִ� ����� ��ü�� ��� �����Ѵ�.
			// xml ������ �о� Spring container�� �ʱ�ȭ �۾� ����
		System.out.println("========== Spring Container �ʱ�ȭ �� =======");
		// ApplicationContext.getBean(String beanName) : beanName�� �����Ͽ� Spring Container�� ����
		// Spring Bean�� �˻��Ͽ� ��ȯ�ϴ� �޼ҵ�
		// => Object Ÿ������ Spring Bean�� ��ȯ�ϹǷ� ����� ��ü ����ȯ�Ͽ� ���
		// InitDestroyMethodBean bean=(InitDestroyMethodBean)context.getBean("initDestroyMethodBean");
		
		// ApplicationContext.getBean(String beanName, Class<T> clazz) : beanName�� Clazz��
		// �����Ͽ� Spring Container�κ��� Spring Bean�� �˻��Ͽ� ��ü ����ȯ �� ��ȯ�ϴ� �޼ҵ�
			// ���������� ����ȯ�Ͽ� ���� - ���� �޼ҵ庸�� �������� �� ����.
			// �� ���� ���Ǵ� getBean �޼ҵ� - ����.
		InitDestroyMethodBean bean=context.getBean("initDestroyMethodBean", InitDestroyMethodBean.class);
		
		//bean.init();
		bean.display();
		//bean.destroy();
			// �ڵ�ȣ�� �ǵ��� �������Ͽ��� ������ �� �ִ�.
			// �ʱ�ȭ �۾��� ���ִ� �������̽��� ������ ����. - ~Aware interface  but ���Ź��
			// init ������� - ���� �ϴ������� check;
		
		System.out.println("===================================================");
		context.getBean("lazyInitBean", LazyInitBean.class);
			// bean ������Ʈ�� �Ӽ����� �����Ͽ� container �ʱ�ȭ �� ��ü�� �������� ���� �� ����.
		System.out.println("===================================================");
		ScopeBean bean1=context.getBean("singleton", ScopeBean.class);
		ScopeBean bean2=context.getBean("singleton", ScopeBean.class);
		ScopeBean bean3=context.getBean("singleton", ScopeBean.class);
		
		System.out.println("bean1 = "+bean1);
		System.out.println("bean2 = "+bean2);
		System.out.println("bean3 = "+bean3);
			// bean1,2,3 �� ��� ���� ��ü�̴�. (hash�ڵ尪�� ��� ����) - �̱��� ������ �ƴϿ��� ��ü�� �ϳ��� �����ȴ�.
			// Ŭ���� ������ singleton ������ ������ Ŭ������ ���Ƿ� ���� �ʿ䰡 ����. - Spring Container�� �ϳ��� ��ü�� �������ֱ� ������...
			// Singleton Ŭ������ ����� �ȵǱ� ������ Ŭ������ ��Ӽ��� �����Ѵ�.
		
		System.out.println("===================================================");
		ScopeBean bean4=context.getBean("prototype", ScopeBean.class);
		ScopeBean bean5=context.getBean("prototype", ScopeBean.class);
		ScopeBean bean6=context.getBean("prototype", ScopeBean.class);
			// getBean �Ҷ����� ��ü�� �����Ͽ� ��ȯ - ��κ� �̱��ϼӼ� ���
		
		System.out.println("bean4 = "+bean4);
		System.out.println("bean5 = "+bean5);
		System.out.println("bean6 = "+bean6);
		
		System.out.println("===================================================");
		((ClassPathXmlApplicationContext)context).close();
		System.out.println("===================================================");
	}
}
