package xyz.itwill00.log;

public class HelloWorldApp {
	public static void main(String[] args) {
		System.out.println("HelloWorldApp Ŭ������ main �޼ҵ� - ����");
		HelloWorld hw=new HelloWorld();
		String message=hw.helloMessage("ȫ�浿");
		System.out.println("message = "+message);
		System.out.println("HelloWorldApp Ŭ������ main �޼ҵ� - ����");
			// �α�ó���� �ϴ� ���α׷��� ���� ���� ��� Ŭ���� ���ο��� ���� ����ϵ��� ����.
			// main �����带 �����ϴ� �ϳ��� ����� �Ǳ� ������ �ӵ� ����
			// �α� ����ü�� ������� ������ 1. ������(����ӵ�)�� �������� 2. ���α׷��� ���� ������� �����ϱ� ��ƴ�.
			// => ����� ���� ���α׷��� �ʿ��ϰ� log4j�� ���
	}
}
