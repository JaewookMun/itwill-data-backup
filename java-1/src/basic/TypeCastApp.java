package basic;

// ����ȯ(Type Cast) : ���� �ڷ����� �Ͻ������� ��ȯ�Ͽ� ����ϴ� ���
// => �ڵ�����ȯ : JVM, ���� ����ȯ : ���α׷���

public class TypeCastApp {
	public static void main(String[] args) {
		
		
		// �ڵ� ����ȯ : �ڷ����� �ٸ� ���� �����ϱ� ���� JVM(Java Virtual Machine)�� �ڷ����� �Ͻ������� ��ȯ        

		System.out.println("��� = " +(3+1.5)); // 3�� 3.0���� �ٲ�� �ڵ�����ȯ �߻�
		System.out.println("��� = " +(95/10)); // �� �������� ���� ������ �� : ���� 
		System.out.println("��� = " +(95.0/10.0)); // 9.5 
		System.out.println("��� = " +(95/10.0)); // �ڵ�����ȯ 
		
		
		int kor=95, eng=90;
		int tot=kor+eng;
		// double ave=tot/2; //���� �� ����� ������ ���� : 92 
		double ave=tot/2.; // 92.5
		
		System.out.println("���� = " + tot+ ", ��� = "+ave);
		
		byte su1=10, su2=20;
		int su3=su1+su2;
		System.out.println("su3 = " +su3);
		System.out.println("======================================================");

		
		//���� ����ȯ : ���α׷��Ӱ� Cast�����ڸ� �̿��Ͽ� ���ϴ� �ڷ����� ������ �Ͻ������� ��ȯ�Ͽ� ����ϴ� ���  
		
		int num=(int)12.3;
		System.out.println("num= " + num);
		
		int num1=95, num2=10;
		double num3=(double)num1/num2; // ������ ������ �� �����߱� ������ �Ǽ����� ���� �� ����.
		System.out.println("num3 = " +num3);
		
		// �������� ū ��� _�� �̿��Ͽ� ǥ�� ����
		int num4=100_000_000, num5=30;
		long num6 = (long) num4*num5; // �������� int�ڷ����� ǥ�������� �ʰ��� ��� �����Ⱚ �߻�
		System.out.println("num6 = "+num6);
		
		double number = 1.23456789;
		System.out.println("number = "+number);

		// �Ҽ��� 2�ڸ������� ��µǵ��� ���α׷� �ۼ�
		System.out.println("number(����) = "+(int)(number*100)/100.0); //1.23
		System.out.println("number(�ݿø�) = "+(int)(number*100+0.5)/100.0); //1.23
		System.out.println("number(�ø�) = "+(int)(number*100+0.9)/100.0); //1.24

	}
}