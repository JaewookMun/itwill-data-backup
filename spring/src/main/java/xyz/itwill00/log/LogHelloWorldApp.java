package xyz.itwill00.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogHelloWorldApp {
	// Logger : �α� ����ü���� ����� �����ϱ� ���� �ν��Ͻ�
	// LoggerFactory : Logger �ν��Ͻ��� �����ϱ� ���� Ŭ����
	// LoggerFactory.getLogger(Class<T> clazz) : �޸𸮿� ����� Ŭ����(Clazz)���� �߻���
	// ����� �α� ����ü���� �����ϴ� Logger �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
		// log4j�� ������� ������� slf4j (The Simple Logging Facade for Java)
	private static final Logger logger=LoggerFactory.getLogger(LogHelloWorldApp.class);
		// �α� �ν��Ͻ��� �����޾� �α� �޼ҵ带 ���ó��
		// (getLogger�� �Ķ���ͷ� ���޵Ǵ� Ŭ����� ����) Ŭ����� �߻��ϴ� �̺�Ʈ������ �޼����� �����ϴ� �ΰ� �ν��Ͻ� ���
	public static void main(String[] args) {
		// Logger.info(String message) : �α� �̺�Ʈ�� �߻��Ͽ� �α� ����ü���� �޼�����
		// �����ϴ� �޼ҵ�
		logger.info("����");
			// log4j.xml�� logger �� ������ �����Ǿ����� �ʱ� ������ info �޼ҵ�� �̺�Ʈ�� �߻����ѵ�
			// ��ϵ��� �ʴ´�. logger������Ʈ�� �����Ǿ� ���� ������ root �� ������ warn �̻��� �޼����� ����
			// log4j�� ����ϴ� �ٸ� �����带 ���� ���ó�� - ���α׷��� ������ �� �ش�.
		LogHelloWorld hw=new LogHelloWorld();
		String message=hw.hello("ȫ�浿");
		System.out.println("message = "+message);
		logger.info("����");
			// ���� �������� �۾��� �̷������ �� ���� �α׸� ǥ��
	}
}
