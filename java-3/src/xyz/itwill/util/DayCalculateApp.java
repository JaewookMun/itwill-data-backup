package xyz.itwill.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//Ű����� ��������� �Է¹޾� ���ñ��� ��ƿ� ��¥(��)�� ����Ͽ� ����ϴ� ���α׷��� �ۼ��ϼ���
//ex) ������� �Է�[ex.2000-01-01] >> 2021-05-16
//    [���]�¾�� 1�� �������ϴ�.
//=> ���Ŀ� ���� �ʴ� ��������� �Է��� ��� ���� �޼��� ��� �� ���α׷� ����
public class DayCalculateApp {
	
	public static String transToDate(long millisecond) {
		millisecond /= 1000;
		long result = millisecond/86400; // 86,400 = 60*60*24
		
		return "[���]�¾�� "+result+"�� �������ϴ�.";
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date birthDay=null;
		long liveTime;
		
		/**
		 * ���Ŀ� ���� ���� ��� ���α׷��� �����Ű��� �ߴµ�
		 * ����� ���� �ʰ� while������ ���... 
		 */
		
		while(true) {
			System.out.print("������� �Է�[ex.2000-01-01] >> ");
			String input = sc.nextLine().replace(" ", "");
			try {
				birthDay = dateformat.parse(input);
			} catch (ParseException e) {
				System.out.println("[����] ���Ŀ� ���߾� ��������� �Է����ּ���");
				continue;
			}
			break;		
		}
		sc.close();
		
		//���� �޼ҵ带 ���� ������ �ʰ� ���⼭ ����ϴ� ���� ���� ���
		liveTime= System.currentTimeMillis()-birthDay.getTime();
		
		System.out.println(transToDate(liveTime));
		
		
	}
}
