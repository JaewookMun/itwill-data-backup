package basic;

public class BreakApp {
	public static void main(String[] args) {
		// for ������ ���ǽ��� ������ ��� �ݺ��� ����
		for(int i=1; i<=5; i++) {
			if (i==3) break;			// if������ ���ǽ��� ���� ��� �ݺ����� �����ų �� ����
			System.out.print(i+"\t");
		}
		System.out.println();
		System.out.println("===========================================");
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=5; j++) {
				// break ������ �ۼ��� ������ �ݺ��� ����
				if(j==3) break;
				System.out.println("i= "+i+", j = "+j);
			}
		}
		System.out.println("===========================================");
		//�ݺ������� �ݺ����� ������ �� �ִ� �� ���� ����
		// => �󺧸��� �ĺ����̸� �ݷ� :�� ����Ͽ� ����
		loop: 
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=5; j++) {
				if(j==3) break loop;			// for(int i=1; i<=5; i++) �ݺ��� ���� 
				System.out.println("i= "+i+", j = "+j);
			}
		}
		System.out.println("===========================================");
		
	}
}