package basic;

import java.util.Scanner;

// Ű����� ������ �Է¹޾� ������ ����Ͽ� ����ϴ� ���α׷��� �ۼ��ϼ���
// => 100~90 : A, 89~80: B, 79~70: C, 69~60: D, 59~0: F
// => �Էµ� ������ 0~100 ������ �������� �ƴ� ��� �޼��� ��� �� ���Է�
public class InputCheckApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		/*
		System.out.print("���� �Է�[0~100] >> ");
		int score = scanner.nextInt();
		*/
		// ���� ���� �ڵ�� ���������� ���� �Էµ� ��� �������� ���� �Էµ� �� �ֵ��� ó���� �� ����.
		// �������� ���� �Էµ� �� ���� �����ؾ��ϱ� ������ while�� ���
		
		
		/*
		//���������� ���� �Էµ� ��� �ݺ� ó�� - �������� ���� �ԷµǸ� �ݺ��� ����
		//�ݺ����� ���ǽ��� ���̵Ǵ� ���ǰ��� ������ ����
		 * 
		
		int score= -1;
		while(score<0 || score>100) {
			System.out.print("���� �Է�[0~100] >> ");
			score= scanner.nextInt(); 
			if(score<0 || score>100) {
				System.out.println("[����]������ 0~100 ������ �������� �Է� �����մϴ�.");
			}
		}
		*/
		
		
		// ���ǽ��� �̸� ó�� ���ص� �ȴ�. (socore ���� �̸� �������� �ʾƵ� ��.)
		// ���ǹ��� �ι����;��ؼ� ��ȿ��
		/*
		int score;
		do {
			System.out.print("���� �Է�[0~100] >> ");
			score= scanner.nextInt(); 
			if(score<0 || score>100) {
				System.out.println("[����]������ 0~100 ������ �������� �Է� �����մϴ�.");
		} while (score<0 || score>100);
		*/
		
		/*
		 * [while���� true�� ����� ���ѷ����� ���� ���¿��� �������� �� ������ �ϴ� ����
		 * �� �� ��޽����� ����̴�.]
		 *  <���� �ڵ�麸�� ���� 3���� ����> 
		 * 1. ���������� �����ٴ� �������� ���� ǥ���ϴ� ���� �� ����.
		 * 2. ���ǽ��� �ߺ����� �ʴ� ��
		 * 3. �ݺ����� �߰����� (���� ���� ��) �����Ҽ� �ִ� ��
		 */
		// do-while���� ���� �ʾƵ� �ǰ� if-break�� ���� ���� ���� �� ���� �� �ֵ��� ó���� �� �ִ�. 
		
		int score;
		while(true) {	//���ǽ� ��� true �ۼ� : ������ �� - ���ѷ���
			System.out.print("���� �Է�[0~100] >> ");
			score = scanner.nextInt(); 
			// �������� ���� �Էµ� ��� �ݺ��� ����
			if(score>=0 && score<=100) break;
			// ���������� ���� �Էµ� ��� ����� ��� 
			System.out.println("[����]������ 0~100 ������ �������� �Է� �����մϴ�.");
		}
		
		
		String grade;
		switch (score/10) {
		case 10:
		case 9:	grade="A"; break;
		case 8: grade="B"; break;
		case 7: grade="C"; break;
		case 6: grade="D"; break;
		default: grade="F";
		}
		
		System.out.println("[���]"+score+"�� >> "+grade+"����");
		scanner.close();
	}
}
