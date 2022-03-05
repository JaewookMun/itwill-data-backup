package xyz.itwill.lang;

import java.util.Scanner;

//Ű����� ������� �Է¹޾� �������� ����ϴ� ���α׷��� �ۼ��ϼ���
//ex) ����� �Է� >> 20 + 10
//    [���] 30
//=> �Է� ����Ŀ��� ��� ������ �����ڴ� ��Ģ ������(*,/,+,-)�� ���
//=> ���Ŀ� ���� ���� ������� �Էµ� ��� ���� �޼��� ��� �� ���α׷� ����
//=> �Է� ����Ŀ� ������ �Է� ���� �ϵ��� ó��
	//magic number => ���Ƿ� ������ ��� (indexOf() = -1)
public class ConsoleCalculateApp {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String input = "";
		int result=0;
		//String[] values;
		
		while(true) {
			System.out.print("����� �Է� >> ");
			input = sc.nextLine().replace(" ", "");
			
			if(input.indexOf("-")!=-1 || input.indexOf("+")!=-1 || input.indexOf("*")!=-1 || input.indexOf("/")!=-1) break;
			System.out.println("[����] ���Ŀ� �´� ������� �Է����ּ���");
		}
		sc.close();
		
		/**����� �����ڵ��� ������ �迭 ����
		 * String[] operatorArray = {"+","-","*","/"};
		 * 
		 * for���� ����Ͽ� ����Ŀ� �����ڸ� �˻��Ͽ� �������� ������ġ�� ��ȯ�޾� ����
		 * indexOf(String s)�� �ƴ϶� lastIndexOf(String s)�� ���
		 * indexOf()�� ������ ������ ���ϱ� ������ > e.g.) -20+10
		 * 
		 * 
		 * - ����Ŀ� �����ڰ� ���ų� �������� ��ġ�� �߸��� ��� ���α׷��� ����.
		 *  if(�����ڰ� �Ǿտ� �ְų� �ǵڿ� �ԷµǾ��� ���)
		 *  
		 * - try~catch ���� ���(parseInt()�� NumberFormatException �߻� �����ϱ� ������.
		 *   ����Ŀ��� �����ڿ� �� �����ڸ� �и��Ͽ� ����
		 *   e.g.) num1, operator, num2�� ���� ����
		 *   
		 */
		
		/*
		if(input.indexOf("-")!=-1) values = input.split("-");
		if(input.indexOf("+")!=-1) values = input.split("+");
		if(input.indexOf("*")!=-1) values = input.split("*");
		if(input.indexOf("/")!=-1) values = input.split("/");
		*/
		
		if(input.indexOf("-")!=-1) {
			result = Integer.parseInt(input.substring(0, input.indexOf("-"))) - Integer.parseInt(input.substring(input.indexOf("-")+1));
		}
		if(input.indexOf("+")!=-1) {
			result = Integer.parseInt(input.substring(0, input.indexOf("+"))) + Integer.parseInt(input.substring(input.indexOf("+")+1));
		}
		if(input.indexOf("*")!=-1) {
			result = Integer.parseInt(input.substring(0, input.indexOf("*"))) * Integer.parseInt(input.substring(input.indexOf("*")+1));
		}
		if(input.indexOf("/")!=-1) {
			result = Integer.parseInt(input.substring(0, input.indexOf("-"))) / Integer.parseInt(input.substring(input.indexOf("/")+1));
		}
		
		System.out.println(result);

	}
}
