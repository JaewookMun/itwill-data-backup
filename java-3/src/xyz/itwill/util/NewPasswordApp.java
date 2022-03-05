package xyz.itwill.util;

import java.util.Random;
import java.util.UUID;

//���ο� ��й�ȣ�� �����ϴ� ���α׷�
	//������Ʈ���� ��й�ȣ�� ã�� �� �ӽú�й�ȣ�� �����ϱ� ���� ���� �� ����.
public class NewPasswordApp {
	//���ο� ��й�ȣ�� ��ȯ�ϴ� �޼ҵ�
	public static String newPasswordOne() {  //think : �������� ��й�ȣ�� ����⿡�� �̰� �� ����. str�� Ư�����ڸ� �߰��� �� ����.
		Random random=new Random();	//think: �ӽú�й�ȣ ����
		
		//��й�ȣ�� ���� ���ڵ��� ������ ���ڿ� ����
		String str="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		String newPassword="";	
		for(int i=1; i<=10; i++) {
			newPassword+=str.charAt(random.nextInt(str.length()));
		}
		return newPassword;
	}
	
	public static String newPasswordTwo() {
		//java.util.UUID : ���������� ���Ǵ� �������� �����Ͽ� �����ϱ� ���� Ŭ����
		//UUID.randomUUID() : �������� ����� UUID �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
		//=> ������ : ���ڿ� ���ĺ�(�ҹ���), -(4��)�� 36�� ���ڵ�� ������ ���ڿ�
		//UUID.toString() : UUID�ν��Ͻ��� ����� �������� ���ڿ�(String)�� ��ȯ�ϴ� �޼ҵ�
		
		return UUID.randomUUID().toString().replace("-", "").substring(0,10).toUpperCase();
	}
	
	
	public static void main(String[] args) {
		System.out.println("�ӽú�й�ȣ-1 = "+newPasswordOne());
		System.out.println("�ӽú�й�ȣ-2 = "+newPasswordTwo());
		
	}
}
