package xyz.itwill02.factory;

public class HelloMessageObject implements MessageObject {

	@Override
	public String getMessage() {
		return "Hello!";
	}
}
	/*
		Factory Design ������ �ٽ� - �������̽��� ���� ���� ������ Ŭ������ ����� ������ �ο�
		IoC (���յ� ����Ʈ����) - 1. ������ (Factory Pattern), 2. Container 
		
		���������� ��
		
		Interface > ��� Ŭ���� 
			Factory > �������̽��� ��ӹ��� Ŭ������ �����Ͽ� ����
			�ٸ� Ŭ�������� factory Ŭ�������� ������ �ν��Ͻ��� Ȱ��
			App���� �̸� ��� 
	 */

