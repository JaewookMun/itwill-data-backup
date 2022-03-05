package xyz.itwill.lang;

import java.util.Scanner;

//Ű����� �ֹε�Ϲ�ȣ�� �Է¹޾� ������ϰ� ������ ����ϴ� ���α׷��� �ۼ��ϼ���
//=> �ֹι�ȣ�� 14�ڸ��̸� 7��° �ڸ����� - ���� ����
//=> ���������� �ֹε�Ϲ�ȣ�� �Էµ� ��� ���� �޼��� ��� �� ���Էµǵ��� ó��
//ex) �ֹε�Ϲ�ȣ �Է� ex. 901225-1234567 >> 000101-3456789
//	  [���]������� = 2000�� 01�� 01��, ���� = ����
public class PersonNumberApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//�ֹε�Ϲ�ȣ �Է� >> �Է°� ����
		String number;
		while(true) {
			System.out.print("�ֹε�Ϲ�ȣ �Է�[ex.901225-1234567] >> ");
			//�Էµ� ���ڿ��� �յ� ������ �����ϰ� ������ ����
			number = scanner.nextLine().trim();
			//if(number.length()==14 && number.charAt(6)=='-') break;
			if(number.length()==14 && number.indexOf("-")==6) break;
			System.out.println("[����]���Ŀ� �´� �ֹε�Ϲ�ȣ�� �Է��� �ּ���.");
		}
		
		scanner.close();
		
		//�ֹε�Ϲ�ȣ�� 8��° ��ġ�� ���ڿ� �ϳ��� �и��Ͽ� ����
		String seperation = number.substring(7,8);
		//System.out.println("seperation = "+seperation);
		
		//�ֹε�Ϲ�ȣ���� ��������� �и��Ͽ� ����
		String birthday="";
		if(seperation.equals("1") || seperation.equals("2")) {
			birthday+="19";
		} else if (seperation.equals("3") || seperation.equals("4")) {
			birthday+="20";
		}
		
		birthday+=number.substring(0,2)+"�� ";
		birthday+=number.substring(2,4)+"�� ";
		birthday+=number.substring(4,6)+"�� ";
		
		//�ֹε�Ϲ�ȣ���� ������ ���Ͽ� ����
		String gender="";
		if(seperation.equals("1") || seperation.equals("3")) {
			gender+="����";
		} else if (seperation.equals("2") || seperation.equals("4")) {
			gender+="����";
		}
		
		System.out.println("[���]������� = "+birthday+", ���� = "+gender);
		
		
		
		
	}
}
