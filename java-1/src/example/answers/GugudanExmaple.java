package example.answers;

import java.util.Scanner;

//Ű����� �������� �Է¹޾� 1~9 ������ �������� ���� ����� ����ϴ� ���α׷��� �ۼ��ϼ���.
//��,�Էµ� �������� 2~9 ������ �������� ���Ǹ� ���� ���� �������� �Է��� ��� �޼��� ��� �� ���Է�
//ex) �� �Է�[2~9] >> 7
//    7 * 1 = 7
//    7 * 2 = 14
//    ...
//    7 * 8 = 56
//    7 * 9 = 63
public class GugudanExmaple {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		int dan;
		while(true) {
			System.out.print("�� �Է�[2~9] >> ");
			dan=scanner.nextInt();
			if(dan>=2 && dan<=9) break;//�������� �Է°��� ��� �ݺ��� ����
			System.out.println("[����]2~9 ������ �������� �Է� �����մϴ�.");			
		}
		
		for(int i=1;i<=9;i++) {
			System.out.println(dan+" * "+i+" = "+(dan*i));
		}
		
		scanner.close();
	}
}





