package example;

public class MultiForExample {
	public static void main(String[] args) {
		//�ڡڡڡڡ�
		//�ڡڡڡ�
		//�ڡڡ�
		//�ڡ�
		//��
		
		for(int i=1; i<=5; i++) {
			for(int j=1; j<= 6-i; j++) {
				System.out.print("��");
			}
			System.out.println();
		}
		
	
		System.out.println("==================================");		
		//�ڡڡڡڡ�
		//�١ڡڡڡ�
		//�١١ڡڡ�
		//�١١١ڡ�
		//�١١١١�
		
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=5 ; j++) {
				if(i<=j) {
					System.out.print("��");
				} else {
					System.out.print("��");
				}
				
			}
			System.out.println();
		}
		
		/*			<< ����� >>
		 * 2���� ����� ���� Ǯ�� (�ݺ�ó����İ� ������¹��)
		 * 
		 */
		
		System.out.println("==================================");
		//��
		//�ڡڡ�
		//�ڡڡڡڡ�
		//�ڡڡڡڡڡڡ�
		//�ڡڡڡڡڡڡڡڡ�
		
		// @ ¦�� �����: 2n			@ Ȧ�� �����: 2n-1 
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=2*i-1; j++) {
				System.out.print("��");
			}
			System.out.println();
		}
		
		
		
		System.out.println("==================================");
		//�ڡ١١١�
		//�١ڡ١ڡ�
		//�١١ڡ١�
		//�١ڡ١ڡ�
		//�ڡ١١١�

		/*
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=5; j++) {
				if(i==j) {
					System.out.print("��");
				} else if(j==6-i) {
					System.out.print("��");
					
				} else {
					System.out.print("��");
				}
			}
			System.out.println();
		}
		*/
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=5; j++) {
				if(i==j || i+j==6) {
					System.out.print("��");
				} else {
					System.out.print("��");
				}
			}
			System.out.println();
		}

		// �˰����� �����Ϸ��� ���� for���� ���̺����� -> �ݺ��� �����ϱ� ���ؼ�
		
	}
}
