package enumerate;

public class EnumApp {
	public static void main(String[] args) {
		//�������� ����� ����ʵ� ��� -> ����ʵ�� ���
		//=> �������� ����ʵ�� ������(��ǥ��)���� ��� ����
		//=> ����ʵ尪 ��� �ǹ� �ִ� ���ڿ� ���
			//���������δ� 0,1,2,3���� ��������� ��½� ����ʵ������ ��µȴ�.
		System.out.println("���� = "+EnumOne.INSERT);
		System.out.println("���� = "+EnumOne.UPDATE);
		System.out.println("���� = "+EnumOne.DELETE);
		System.out.println("�˻� = "+EnumOne.SELECT);
		System.out.println("===============================================================");
		System.out.println("���� = "+EnumTwo.ADD);
		System.out.println("���� = "+EnumTwo.MODIFY);
		System.out.println("���� = "+EnumTwo.REMOVE);
		System.out.println("�˻� = "+EnumTwo.SEARCH);
		System.out.println("===============================================================");
		//����ʵ��� �ڷ����� ������ �ڷ����� ������ ����ʵ� ���� �Ұ���
		//=> �������� ����ʵ�� ����� �ڷ���(Enum Type)�� �������� ���� ����
		//int choice = EnumOne.INSERT;
		
		//������(EnumType)���� ���� ����
		//=> ������ �ڷ����� ���� ������(EnumType)�� ����ʵ常 ���� ����
		//=> ����ʵ尡 ����� �������� �ڷ����� �ǹ̰� �ο��ȴ�.
		EnumOne choice = EnumOne.INSERT;
		System.out.println("choice = "+choice);
		System.out.println("===============================================================");
		//�������� ������ ������ �ڷ���(������)�� ����ʵ常 �� ����
		switch(choice) {
		case INSERT:
			System.out.println("# �л������� �����մϴ�.");
			break;
		case UPDATE:
			System.out.println("# �л������� �����մϴ�.");
			break;
		case DELETE:
			System.out.println("# �л������� �����մϴ�.");
			break;
		case SELECT:
			System.out.println("# �л������� �˻��մϴ�.");
			break;
		}
	}
}