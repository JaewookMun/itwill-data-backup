package xyz.itwill.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//java.text ��Ű�� : ����(��)�� ���ϴ� ������ �������� ǥ���ϱ� ���� �ڷ����� ����� ��Ű��

//java.text.SimpleDateFormat : ��¥�� �ð������� ���� ������ �����ϱ� ���� Ŭ����
//=> Date �ν��Ͻ��� String �ν��Ͻ��� ���� ��ȯ�ϴ� �޼ҵ� ����
public class SimpleDateFormatApp {
	public static void main(String[] args) {
		Date now = new Date();
		
		//SimpleDateFormat(String pattern) : ��¥�� �ð� ���� ���������� �����Ͽ� 
		//SimpleDateFormat �ν��Ͻ��� �����ϴ� ������
		//=> �������� : ���Ϲ��ڸ� �̿��Ͽ� ������ ���ڿ�
		//=> ���Ϲ��� : y(��),M(��),d(��),H(��),m(��),s(��),E(����)��
			//��ҹ��� ���е�
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy�� MM�� dd�� E����");
		
		//SimpleDateFormat.format(Date date) : Date �ν��Ͻ��� ���޹޾� ���ϴ� ������
		//���ڿ�(String)���� ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ�
		String printDate = dateformat.format(now);
		
		System.out.println("���� = "+printDate);
		
		//SimpleDateFormat.applyPattern(String pattern) : SimpleDateFormat �ν��Ͻ���
		//����� ���������� �����ϴ� �޼ҵ�
		dateformat.applyPattern("yyyy-MM-dd HH:mm:ss");
		System.out.println("���� = "+dateformat.format(now));
		
		String want="2000-01-01 00:00:00";
			
			Date wantDate;
			try {
				//SimpleDateFormat.parse(String str) : SimpleDateFormat �ν��Ͻ��� �����
				//���������� ���ڿ�(String)�� ���޹޾� Date �ν��Ͻ��� ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ�
				//=> ���������� �ٸ� ���ڿ��� ���޵� ��� ParseException �߻� - ����ó��
				wantDate = dateformat.parse(want);
				System.out.println("wantDate = "+wantDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

					//�Ϲ������� calendar Ŭ������ �������� SimpleDateFormat Ŭ������ Ȱ���Ͽ�
					//���ϴ� ���·� ������ �� �־ ������ ���鶧 DateȰ��
	
	}
}
