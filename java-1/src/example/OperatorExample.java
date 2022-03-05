package example;

public class OperatorExample {
	public static void main(String[] args) {
		//245678�ʸ� �Ͻú��� �������� ��ȯ�Ͽ� ����ϼ���.	- 'D-day' program���� �� ���
		
		int defaultCount = 245678;
		int day = defaultCount/(60*60*24); 
		int hours = defaultCount%(60*60*24)/(60*60);
		int minutes = (defaultCount%(60*60*24))%(60*60)/60;
		int seconds = ((defaultCount%(60*60*24))%(60*60))%60;
		
		System.out.println("245678�ʴ� "+day+"�� "+hours+"�� "+minutes+"�� "+seconds+"�� �Դϴ�.");

		
		/* 			<< ����� Ǯ�� : ���մ��Կ����� Ȱ�� >>
		 * e.g.
		 * defaultCount %= 86400			
		 * defaultCount %= 3600;
		 * �Ϸ�� 86400�� (60*60*24)
		 */
		
		
		System.out.println("===============================================");
		//�Ѵ��� ������ 1�� 5õ������ ����⸦ 20�� ������ ��� �����ؾߵ� �ݾ��� ����Ͽ� 
		//����ϼ���. 
		//��, 15�� �̻� ������ ��� 1��� 25%�� �������� �����Ͽ� ����ϼ���. 
		
		int pricePerPlane = 150_000_000, buyNumber = 20;
		double salesRate = 0.25;
		long totalPrice = (long)pricePerPlane*buyNumber;
		
		System.out.println("�������� �����Ͽ� ���� �� ���ұݾ�: "+ (buyNumber>=15?(long)(totalPrice*(1-salesRate)):(totalPrice)));
		
		/*			<< ����� Ǯ�� >>
		 * ���� ���� ������ int �� �ڷ������� ����.
		 * 1��5õ�� 21�� �̸��̱� ������ long���� ������ ���ʿ��� �޸𸮸� �Ҵ��ϰ� �ȴ�. -> int ��
		 * ���ұݾ׺����� ���׿�����ó���� �ؼ� ��������.
		 * �������� (1-0.25)�� ����Ͻ� 
		 */
		
		
		System.out.println("===============================================");
	}
}
