package example;

import java.util.Scanner;

//��ǻ�ͷκ��� �������� ���� �������� Ű����� �Է��Ͽ� ���ߴ� ���α׷��� �ۼ��ϼ���
// => 1~100 ������ ���� �������� �����޵��� �ۼ�
// => �������� ���� �� �ִ� ��ȸ�� 10���� �����ǵ��� �ۼ�
// => Ű���� �Է°��� 1~100������ �ƴ� ��� �޼��� ��� �� ���Է�
// => ������ �Է°��� ���� ��� �Է� Ƚ�� ��� �� ���α׷� ����
// => �������� �Է°��� �ٸ� ��� "ū�� �Է�" �Ǵ� "������ �Է�" ������ �޼��� ���
// => �������� 10�� �ȿ� ������ ���� ��� �������� ��µǵ��� �ۼ�
public class UpAndDownExample {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		// => 1~100 ������ ���� ������
		int random = (int)(Math.random()*100)+1;
		int count = 0;
		
		System.out.println("1~100 ������ ������ ������ �����Ǿ����ϴ�. ���ڸ� �����ϼ���. "+"\n��, ��ȸ�� 10ȸ �Դϴ�.");
		// 10���� ��ȸ
		
		/*
		 * 10���� �Է±�ȸ�� �����ϴ� �ݺ���
		 * => �������� �Է¹޾� �������� ��
		 * ���� ���� ���������� �����ϱ� ���� ���� ����
		 * => false : ������ ������ ���� ����, true : ������ ���� ����
		 * boolean result = false;
		 */
		
		
		loop:
		while(true) {
			for(int i=1; i<=10; i++) {
				System.out.print("���ڸ� ����ּ��� >> ");
				int input = scanner.nextInt();
				count++;
				
				// �������� ��� ���
				if(input<1 || input>100) {
					System.out.println("�־��� ����[1~100]�� ������ϴ�. ���Է����ּ���.");
					continue;
				}
				// �����ȿ� �� ���
				if(input==random) {
					System.out.println("�����մϴ�. "+count+"�� �õ� �� ������ϴ�.");
					break loop;
				} else if(input>random) {
					System.out.println(input+"���� �������� �Է��� ������");
				} else {
					System.out.println(input+"���� ū���� �Է��� ������");
				}
				
				System.out.println();
				
			}
			System.out.println("�־��� ��ȸ�� ��� �����Ͽ����ϴ�. "+"\n������ ���ڴ� "+random+"�Դϴ�.");
			break;
		}
		scanner.close();
		
	}
}
