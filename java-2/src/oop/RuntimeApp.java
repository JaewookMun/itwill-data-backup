package oop;

//Runtime : Java ���α׷��� �����ϴ� JVM(Java Virtual Machine) ���� ������ �����ϴ� Ŭ����
//=> �����ڰ� ����ȭ ����Ǿ� new �����ڷ� �ν��Ͻ� ���� �Ұ���
//=> getRuntime() ���� �޼ҵ带 ȣ���Ͽ� �ν��Ͻ��� ��ȯ�޾� ���
//=> ���α׷��� �ν��Ͻ��� �ϳ��� �����ϴ� Ŭ���� - �̱��� Ŭ���� (��ǥ���� Ŭ������)
	//JVM�� �ϳ��ۿ� �������� ����. �׷��� ������ �ν��Ͻ��� ������ ����� ���� ��ȿ�����̴�.
public class RuntimeApp {
	public static void main(String[] args) {
		//Runtime runtime = new Runtime();
		
		//Runtime.getRuntime() : Runtime �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
		//=> �޼ҵ带 ������ ȣ���ص� ���� �ν��Ͻ� ��ȯ
		Runtime runtime1 = Runtime.getRuntime();
		Runtime runtime2 = Runtime.getRuntime();
		
		System.out.println("runtime1 = "+runtime1);
		System.out.println("runtime2 = "+runtime2);
		System.out.println("===========================================================");
		//�ν��Ͻ��� ��ȯ�޾� ���������� �������� �ʰ� ���� �޼ҵ� ȣ��
		//Runtime.totalMemory() : JVM�� ����� �� �ִ� ��ü �޸� ũ�⸦ ��ȯ�ϴ� �޼ҵ�
		//Runtime.freeMemory() : JVM ���α׷��� ����� �� �ִ� ���� �޸� ũ�⸦ ��ȯ�ϴ� �޼ҵ�
		
		System.out.println("û�� �� ��� �޸� ũ�� = "+(Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory())+"Byte");
			//�������÷��ʹ� JVM���� ���ʿ��� ��ü�� �����ϴ� ������ ��
		//Runtime.gc() : Garbage Collector ���α׷��� �����ϴ� �޼ҵ�
		//=> System.gc() �޼ҵ� ȣ��� ������ ��� ���� 
		//Runtime.getRuntime().gc();
		System.gc();
		System.out.println("û�� �� ��� �޸� ũ�� = "+(Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory())+"Byte");
		System.out.println("===========================================================");
	}
}
