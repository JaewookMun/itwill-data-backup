package oop;

//Car Ŭ������ �̿��Ͽ� �ۼ��� ���α׷�
public class CarApp {
	public static void main(String[] args) {
		//Ŭ������ ��ü(�ν��Ͻ�)�� �����Ͽ� ���������� ����
		//����) Ŭ������ ��������=new Ŭ������();
		// => ��ü(�ν��Ͻ�)�� �����ϸ� �ν��Ͻ� �ʵ忡�� �⺻���� �ڵ����� ����Ǿ� �ʱ�ȭ�ȴ�. 
		// => �⺻�� - ������:0, ����:false, ������: null
		Car carOne = new Car();
		Car carTwo = new Car();
		System.out.println("carOne = "+carOne);
		System.out.println("carTwo = "+carTwo);
		/*
		 * ������ Ŭ������ ���� ���� �ٸ� ��ü�� �����ȴ�.
		 * carOne = oop.Car@4926097b
		 * carTwo = oop.Car@762efe5d
		 */
		System.out.println("==================================================");
		//���������� �̿��Ͽ� ���������� ����� ��ü(�ν��Ͻ�)�� ��ҿ� �����Ͽ� ���
		// => . �����ڸ� �̿��Ͽ� ��ü(�ν��Ͻ�)�� ��ҿ� ����
			// �⺻���� ������ �ʵ忡 �����Ͽ� �ٲ� �� ����.
		//������) �ν��Ͻ��� �ʵ忡 �������� ������ ����� ��� ���������� �� ���忡
		//���� ����(limit)�� �� �� ���� �������� �߸��Ǵ� �����߻� ����
		//�ذ��) �ν��Ͻ��� �ʵ忡 �������� ������ ������� �ʵ��� �ʵ��� ����ȭ ó��
		// => ����ȭ ����� �ʵ忡 ������ ��� ���� �߻� The field ' ' is not visible.
		//=> Getter �޼ҵ�� Setter �޼ҵ带 ȣ���Ͽ� �ʵ带 ���������� �����Ͽ� ����
		//carOne.aliasName="Ƽ��";
		carOne.setAliasName("Ƽ��"); //Setter �޼ҵ带 ȣ���Ͽ� �ʵ尪 ����
		//carOne.engineStatus=false;
		carOne.setEngineStatus(false);
		//carOne.currentSpeed=0;
		carOne.setCurrentSpeed(0);
		
		//System.out.println("ù��° �ڵ����� ��Ī = "+carOne.aliasName);
		//Getter �޼ҵ带 ȣ���Ͽ� �ʵ尪�� ��ȯ�޾� ���
		System.out.println("ù��° �ڵ����� ��Ī = "+carOne.getAliasName());
		//System.out.println("ù��° �ڵ����� �������� = "+carOne.engineStatus);
		System.out.println("ù��° �ڵ����� �������� = "+carOne.isEngineStatus());
		//System.out.println("ù��° �ڵ����� ����ӵ� = "+carOne.currentSpeed);
		System.out.println("ù��° �ڵ����� ����ӵ� = "+carOne.getCurrentSpeed());
		System.out.println("==================================================");
		//carTwo.aliasName="��Ÿ��";	// aliasName�� null�� �� ������ ����
		carTwo.setAliasName("��Ÿ��");
		
		//System.out.println("�ι�° �ڵ����� ��Ī = "+carTwo.aliasName);
		System.out.println("�ι�° �ڵ����� ��Ī = "+carTwo.getAliasName());
		//System.out.println("�ι�° �ڵ����� �������� = "+carTwo.engineStatus);
		System.out.println("�ι�° �ڵ����� �������� = "+carTwo.isEngineStatus());
		//System.out.println("�ι�° �ڵ����� ����ӵ� = "+carTwo.currentSpeed);
		System.out.println("�ι�° �ڵ����� ����ӵ� = "+carTwo.getCurrentSpeed());
		// => ��ü(�ν��Ͻ�)�� �����ϸ� �ν��Ͻ� �ʵ忡�� �⺻���� �ڵ����� ����Ǿ� �ʱ�ȭ�ȴ�. 
		// �ʵ峻���� ���� �ٲ��� �ʾƵ� �⺻���� �ν��Ͻ��� ������ ���� �⺻���� �����
		System.out.println("==================================================");
		//��ü(�ν��Ͻ�)�� �̿��Ͽ� �޼ҵ� ȣ�� - ��� ����
			//�޼��带 ȣ���� ���� ������ �ִ�. - ���ʴ�� ȣ������ �ʾ��� �� ���۵��� �ʴ� ���� �߰�.
		carOne.startEngine();
		carOne.speedUp(30);
		carOne.speedUp(50);
		carOne.speedDown(40); // �߸��� ���� ������ �� �޼ҵ尡 ���۵��� �ʵ��� �ؾ���.
		carOne.speedZero();
		carOne.stoptEngine();
		System.out.println("==================================================");
		// ��ü�� ���� �ʵ峪 �޼��带 Ȱ���Ͽ� ���α׷���
	}
}
