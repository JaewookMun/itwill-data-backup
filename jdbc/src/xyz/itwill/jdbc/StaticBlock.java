package xyz.itwill.jdbc;

public class StaticBlock {
	//��������(Static Block) : ClassLoader ���α׷��� ���� Ŭ������ �޸𸮿� ����� �� 
	//�ڵ����� ����� ������ �ۼ��ϴ� ���� - ���������� ������ ���α׷����� �ѹ��� ����
	static {
		System.out.println("### StaticBlock Ŭ������ ���������� �ۼ��� ���� ���� ###");
		
			//������������ �ڽ��� �����ڸ� �̿��Ͽ� �ν��Ͻ��� ����� �޼ҵ带 ȣ����.
		StaticBlock sb=new StaticBlock();
		sb.display();
	}
	
	public StaticBlock() {
		System.out.println("### StaticBlock Ŭ������ ������ ȣ�� - �ν��Ͻ� ���� ###");
	}
	
	
	public void display() {
		System.out.println("### StaticBlock Ŭ������ display() �޼ҵ� ȣ�� ���� ###");
		
	}
}