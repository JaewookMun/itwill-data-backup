package example;

public class VariableExample {
	public static void main(String[] args) {
		//������ ���̰� 7�̰� ������ ���̰� 10�� �簢���� ���̸� ����Ͽ� ����ϼ���.
		int width = 7, height = 10;
		int recArea = width*height;
		
		System.out.println("�簢�� ���̴� = " +recArea);
		
		//���̰� 9�̰� �غ��� ���̰� 7�� �ﰢ���� ���̸� ����Ͽ� ����ϼ���.
		width = 7;
		height = 9;
		double triArea = (double)(width*height)/2;
		
		System.out.println("�ﰢ�� ���̴� = " + triArea);
		
		
		//10�� ��ü �����԰� 759Kg�� ��� ��� �����Ը� ����Ͽ� ����ϼ���.
		int count = 10, totalWeight = 759;
		double avgWeight = (double)totalWeight/count;
		
		System.out.println("��� ������ = " +avgWeight);
				
		//�̸��� [ȫ�浿]�� �л��� �������� 89��, �������� 93��, �������� 95���� ���� ���
		//������ ����� ����Ͽ� �̸�, ����, ����� ����ϼ���.
		//��, ����� �Ҽ��� ���ڸ������� ����ϰ� �������� ����ó���ϼ���.
		
		String name = "ȫ�浿";
		int kor=89, eng=93, math=95;
		
		int total = kor+eng+math;
		double average = (double)total/3;
		
		System.out.println("�̸�: "+name+ ", ����: "+total+", ���: "+(int)(average*10)/10.);
		// ������ ������ �����͸� �����ϴ� ���� ������� �ʰ� ����� �� ���ǿ� ���߾� �����ϴ� ���� ��õ��.
	}
}