package oop;

public class SingletonApp {
	public static void main(String[] args) {
		/*
		//new �����ڰ� �����ڸ� �ҷ��� �ν��Ͻ��� �����Ͽ� ���������� ����
		//=> ���������� �̿��Ͽ� �ν��Ͻ��� �޼ҵ� ȣ��
		//=> �ν��Ͻ��� �޼ҵ带 ���������� ȣ���ϰ��� �� ��� ���
		Singleton singleton = new Singleton();
		singleton.display();
		
		//new �����ڰ� �����ڸ� �ҷ��� �ν��Ͻ��� �����ϰ� �޼ҵ带 ����ȣ��
		//=> �ν��Ͻ� ���� �� �޼ҵ带 �ϳ��� ȣ���� ��� ���
			// �޼ҵ带 �ѹ��� ����ϰ� ���� ��� �Ʒ�ó�� ���
		new Singleton().display();
		*/
		
		/*
		//new �����ڷ� ������ �ν��Ͻ��� ���� �ٸ� �ν��Ͻ�
		//=> �Ϲ����� Ŭ������ �ν��Ͻ��� ���� �� ���� ����
		Singleton singleton1=new Singleton();
		Singleton singleton2=new Singleton();
		
		System.out.println("singleton1 = "+singleton1);
		System.out.println("singleton2 = "+singleton2);
		
			//�޼ҵ带 ȣ���ؼ� ���� �� �ִ� ����� �Ȱ���. - ���� �ν��Ͻ��� ������ ���� �ʿ䰡 ����.
			//�����ϰ� �ν��Ͻ��� �ϳ��� ���� �� �ִ� Ŭ���� -> �̱�������
		singleton1.display();
		singleton1.display();
		*/
		
		//�̱��� Ŭ�������� �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ带 ȣ���Ͽ� �ν��Ͻ� ��ȯ�޾� ����
		//=> Ŭ������ �޸𸮿� ����� �� �̸� ������ ������ �ν��Ͻ��� ��ȯ
		Singleton singleton1=Singleton.getInSingleton();
		Singleton singleton2=Singleton.getInSingleton();
		
		System.out.println("singleton1 = "+singleton2);
		System.out.println("singleton2 = "+singleton2);
		System.out.println("====================================================");
		singleton1.display();
		singleton2.display();
		System.out.println("====================================================");
		//�̱��� Ŭ������ �������� ���� �ν��Ͻ��� ��ȯ�޾� ���� �޼ҵ� ȣ���Ͽ� ���
			//�ĺ��ڸ� ���� ������� ���α׷��� ���������� �� ����������.
		Singleton.getInSingleton().display();
		Singleton.getInSingleton().display();
		System.out.println("====================================================");
	}
}