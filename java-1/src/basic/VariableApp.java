package basic;

public class VariableApp {

	public static void main(String[] args) {
		int su;
		su = 100;
		System.out.print("�ʱⰪ = ");
		System.out.println(su);
		
		su= 200;
		System.out.print("���氪 = ");
		System.out.println(su);
		System.out.println("=============================================");
		
		int num = 100;
		System.out.println("num = "+num);
		System.out.println("=============================================");
		System.out.println("���ش� "+2+0+2+1+"���Դϴ�.");
		System.out.println(2+0+2+1+"���� �Ҷ����Դϴ�.");
		System.out.println(""+2+0+2+1+"���� �Ҷ����Դϴ�.");
		System.out.println("=============================================");
		
		// ������ �ڷ����� ������ ',' ��ȣ�� ���ؼ� ������ �� ����.
		int num1=100, num2=200;
		System.out.println("������ = "+ (num1+num2));
		System.out.println("������ = "+ (num1*num2)); // 28��� ������ �� �� ����.
		System.out.println("������ = "+ num1*num2);
		System.out.println("=============================================");
		
		int kor=88, eng=90;
		int tot = kor+eng;
		
		System.out.println("�����հ� = "+ tot);
		System.out.println("=============================================");
		/*
		int number;
		������ ���� ����Ǿ����� ���� ���·� ����ϸ� ����
		System.out.println("number =" + number);
		*/
		
		// int number= 10.0; // ������ ������ �� ���� ���� ������ ��� ���� �߻�
	}
}
