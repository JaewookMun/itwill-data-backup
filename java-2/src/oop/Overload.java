package oop;

public class Overload {
	public void displayInt(int param) {
		System.out.println("������ = "+param);
	}
	
	public void displayBoolean(boolean param) {
		System.out.println("���� = "+param);
	}
	
	public void displayString(String param) {
		System.out.println("���ڿ� = "+param);
	}
		// ������ ����� ����ϴ� �޼ҵ�� �޼ҵ� �̸��� ���ϼ� �ְ� ����� ���� ����
	
		//�޼ҵ�� �Ű��������� �ĺ��ڷ� �ν��ϱ� ������ �Ʒ� 3���� �޼ҵ�� �̸��� ������ ���� 
		// ���� �ٸ������� �ν�
		// ��, �޼ҵ��� �̸��� ������ "�Ű������� ����(�ڷ���, ����)�� �ٸ��� �ٸ� ������ �ν�"�Ǳ� ������
		// �����ε��Ͽ� ��� ����.
	
	//�޼ҵ� �����ε�(Method Overload) ���� : �ϳ��� Ŭ�������� ������ ����� �����ϴ� 
	//�޼ҵ尡 �Ű������� ���� ���� �� ����Ǿ�� �� ��� �޼ҵ���� ���� �����ϴ� ���
	//=> �Ű������� ���� �Ǵ� �ڷ����� ���� �ʵ��� ����
	//=> ���� ������ �Ǵ� ��ȯ���� �����ε� ����� ����
		// ���⼭ �߿��� ������ "������ ����� �����ϴ� ���"��.
	public void display(int param) {
		System.out.println("������ = "+param);
	}
	
	public void display(boolean param) {
		System.out.println("���� = "+param);
	}
	
	public void display(String param) {
		System.out.println("���ڿ� = "+param);
	}
	
}
