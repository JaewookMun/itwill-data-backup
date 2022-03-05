package oop;


//������ ������ Ŭ���� - ���α׷�
// => ����ũž ���ø����̼��� �ݵ�� main() �޼ҵ� ����
public class MethodApp {
	//JVM�� ���� �ڵ� ȣ��Ǵ� �޼ҵ�
	public static void main(String[] args) {
		//��ü(�ν��Ͻ�:Instance)�� �����Ͽ� ���������� ����
		//Ŭ������ ��������=new Ŭ������();
		//=> ���� ��Ű���� Ŭ������ ��Ű�� ǥ������ Ŭ������ ǥ���Ͽ� ��밡��
		//=> ������ ��Ű������� ��) oop.Method  (oop��Ű���� �ִ� Ŭ����)
		
		//=> �̷��� ����ϴ� ���� �����ؼ� ������� ���� import �����̴�.
		//=> new Ŭ������() : new �����ڷ� Ŭ������ ������(Constructor)�� ȣ���Ͽ� ��ü ����.
		//=> Ŭ������ �������� : Ŭ������ ������ ��ü�� ������ �����ϱ����� �������� ����
		//=> ���������� �̿��Ͽ� ����� ��ü�� �ʵ� �Ǵ� �޼ҵ忡 �����Ͽ� ���
		Method method=new Method();
		System.out.println("method = "+method);
		
		// method = oop.Method@4926097b
		// method�� oop��Ű���� MethodŬ���� @ �޸��ּ�(�ؽ��ڵ�)  
		// -> ���������� ����� ��ü�� Ŭ���� �̸��� heap�޸� �ּ�
		System.out.println("===========================================================");
		//�޼ҵ� ȣ��
		//����) ��������.�޼ҵ��(��,��,...);
		// => ���������� ����� ��ü(�ν��Ͻ�)�� �޼ҵ� ȣ��
		// => �޼ҵ�� �Ǵ� �Ű������� ���� �߸� ���޵� ��� �޼ҵ� ȣ�� �Ұ���
		//�޼ҵ带 ȣ���ϸ� ������(���α׷� �帧)�� �޼ҵ�� �̵��Ͽ� �޼ҵ��� ���
		//���� �� ��ȯ
		method.displayOne();
		method.displayTwo();
		method.displayOne();
		
		//�ν��Ͻ��� ���� �ʿ��� ����� ��� ȣ���� �� �ִ�.
		System.out.println("============================================================");
		method.printOne();
		System.out.println("============================================================");
		method.printTwo(50);
		method.printTwo(80);
		
		method.printTwo(-30);
		System.out.println("============================================================");
		method.printThree(55, 80);
		method.printThree(2, 49);
		
		method.printThree(70, 40);
		System.out.println("============================================================");
		//�޼ҵ� ȣ��� ��ȯ�Ǵ� ������� ������ ����
		//=>��ȯ�Ǵ� ������� ���������� ����ϰ��� �� ��� ������ ����.
		int total=method.returnTot(36, 79);
		//�Է� �� ��� ����� ���α׷����� �ۼ� - �޼ҵ忡���� ����� ����� ���ۼ�
		System.out.println("�޼ҵ� ȣ�� ��� = "+total);
		
		//�޼ҵ� ȣ�� �� ��ȯ�Ǵ� ����� ��� - ��ȯ�� �Ͻ��� ���
		System.out.println("�հ� = "+method.returnTot(40, 80));
		System.out.println("============================================================");
		boolean result=method.isOddEven(10); //��ȯ���� ����ȴٸ� ���� ���.
		if(result) { //result �������� true�� ���
			System.out.println("¦��");
		}else {
			System.out.println("Ȧ��");
		}
		// if ������ ���ǽ� ��� ������ ��ȯ�ϴ� �޼ҵ� ȣ�� ����
		if(method.isOddEven(11)) {
			System.out.println("¦��");
		}else {
			System.out.println("Ȧ��");
		}
		System.out.println("=============================================================");
		
		String nameResult=method.nameHello("ȫ�浿");
		System.out.println(nameResult);
		System.out.println(method.nameHello("�Ӳ���"));
		System.out.println("=============================================================");
		//�޼ҵ带 ȣ���Ͽ� ��ȯ�� �迭�� �������� ���� 
		int[] num=method.returnArray();
		System.out.print("��ȯ�� ��Ұ� >> ");
		for(int temp:num) {
			System.out.print(temp+" ");
		}
		System.out.println();
		System.out.println("=============================================================");
		System.out.println("�հ� = "+method.sumOne(10, 20, 30));
		//�޼ҵ��� �Ű������� ���� ���������� ���޵��� ���� ��� �޼ҵ� ȣ�� �����߻�
		//System.out.println("�հ� = "+method.sumOne(10, 20, 30, 40, 50, 60));
		System.out.println("=============================================================");
		System.out.println("�հ� = "+method.sumTwo(new int[] {10,20,30}));
		System.out.println("�հ� = "+method.sumTwo(new int[] {10,20,30,40,50}));
		System.out.println("=============================================================");
		System.out.println("�հ� = "+method.sumThree(10,20,30));
		System.out.println("�հ� = "+method.sumThree(10,20,30,40,50));
		
	}
}
