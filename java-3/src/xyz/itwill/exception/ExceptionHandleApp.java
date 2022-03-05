package xyz.itwill.exception;

public class ExceptionHandleApp {
	public static void main(String[] args) {
		int[] array= {10,20,30,40,50};
			//��� ����� try�ȿ� �ִ� ���� �������� �ʴ´�. catch()�� ��� ����ؾ��ϱ� ������
			//����ӵ��� ��������. try�ȿ��� ���ܰ� �߻��� ���ɼ��� �ִ� ����� �ۼ�.
		
		//���ܰ� �߻� ������ ����� try ������ �ۼ�
		//=> ���ܰ� �߻��� ��� ���� ���� �ν��Ͻ� ���� 
		//=> catch �������� ���� �ν��Ͻ��� ���޹޾� ���� ó��
		try {
			//�迭 ��� ǥ���� ÷�ڸ� �߸� ����� ��� ArrayIndexOutOfBoundsException �߻�
			//=> ArrayIndexOutOfBoundsException�� �߻��� ��� JVM�� ���� �ڵ����� ���� ó��
			//=> JVM�� ����ó���� ���ܰ� �߻��� ��θ� ���ϰ� ǥ���Ͽ� ��� - ������ �߽�
			//=> ����� �߽��� ���α׷��� ����� ���� ���� ���� ó���ϴ� ���� ����

				//ArrayIndexOutOfBoundsException�� RuntimeException Ŭ������ ���
				//���������� ������ ���� ������ �����Ϸ��� �߸��Ǿ����� �������� ����.
			for(int i=0; i<=array.length; i++) {
				System.out.println("array["+i+"] = "+array[i]);
			}
			
			//���ܰ� �߻��� ��� �ϴܿ� �����ϴ� ����� �̽���
			//=> ���ܰ� �߻��Ǹ� catch �������� ������(���α׷��� ���� �帧) �̵�
			System.out.println("[�޼���]���α׷��� ���������� ���� �Ǿ����ϴ�.");
		} catch (ArrayIndexOutOfBoundsException e) {//���� �ν��Ͻ��� ���޹޾� ���������� ����
			//catch ������ ������ ���� Ŭ������ ���� ���� ó�� ��� �ۼ� - �޼��� ���
			//System.out.println("[����]���α׷� ���࿡ ����ġ ���� ������ �߻��Ǿ����ϴ�.");
				// -> ����� �߽�
			
			//Throwable.getMssage() : ���� �ν��Ͻ��� ���� �޼����� ��ȯ�ϴ� �޼ҵ�
			//System.out.println("���� �޼��� = "+e.getMessage());
				// -> ������ �߽�
			
			//Throwable.printStackTrace() : ���ܰ� �߻��� ��θ� ���ϰ� ǥ���Ͽ� ����ϴ� �޼ҵ� 
				//JVM�� ȣ���ؼ� ����ϴ� ����ó�� �޼���
			e.printStackTrace();
		} finally {
			//���ܿ� ������� ������ ����� ����� �ۼ��ϴ� ���� : ���� ����
			//=> �ڿ��� ���� ���� ����� ������ ��� ���
				//e.g. Scanner class�� close() �޼ҵ�
			System.out.println("[�޼���]������ ����Ǵ� ���");
		}
	}
}
