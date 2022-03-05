package oop;

// ������ ������ Ŭ���� - �ν��Ͻ�(��ü) ������ ���� Ŭ����
public class Method {
	//Ŭ������ �����ϸ� Ŭ���� ���ο��� �Ű������� ���� ������(Default Constructor)�� 
	//����� ������ �ν�
	
	//�޼ҵ� ����
	//�޼ҵ�� ȣ���ؾ� ���ϴ� ����� ������ �� �ִ�.
	
	//Ŭ������ Ư�� ���α׷��� ���ӵǾ�� �ȵȴ�. -> �������� �۾�����.
	//����±���� �� �޼���� ���� �޼���� �ƴϴ�. (������ Ư�� ���α׷��� ���ӵ�.)
	//web�� desktop app�� ����� ����� �ٸ�.
	// �Ʒ�ó�� �����ϸ� desktop app �װ͵� �ֿܼ����� ��� ����...
	// �Ϲ� ���α׷� �ֿܼ����� System.out.println���� ��� ���������� 
	// Gui desktop (e.g. ����) -> component
	// Android - ����, Web - HTML
	// ����������� ���� Ư�����α׷������� ��밡���ϴ�.
	//Ŭ������ �޼��忡 ����� ����� ����ִ� ���� ������� �ʴ´�.
	// -> �ڵ��� ������ ���ؼ�.
	//=> ������� ���α׷��� ���ִ°�. �޼���� ó���ϴ� ��ɸ� ����.
	//=> �޼���� ����ϴ� ��ɴ�� ��ȯ (return)�� ���
	// �޼��忡�� ��ȯ�Ǵ� ����� �����Ͽ� ���α׷����� ���.
	void displayOne() {
		System.out.println("Method Ŭ������ displayOne() �޼ҵ� ȣ��");
	}
	
	void displayTwo() {
		System.out.println("Method Ŭ������ displayTwo() �޼ҵ� ȣ��");
	}
	
	void printOne() {
		int tot=0;
		for(int i=1; i<=100; i++) {
			tot+=i;
		}
		System.out.println("1~100 ������ �������� �հ� = "+tot);
	}
	void printTwo(int num) {
		//�Ű������� ���޵Ǿ� ����� ���� ���� ��ȿ�� �˻� (�����.) -> ��������� ��������. (���ϴ� ����� ������ؼ�...)
		if(num<=0) { //���������� �Ű������� ���޵� ���
			System.out.println("[����]�Ű��������� 0���� ū ���� ���޵Ǿ�� �˴ϴ�.");
			return;	// �޼ҵ� ��������
		}
		
		int tot=0;
		for(int i=1; i<=num; i++) {
			tot+=i;
		}
		System.out.println("1~"+num+" ������ �������� �հ� = "+tot);
	}
	
	void printThree(int num1, int num2) {
		/*
		if(num1>num2) {
			System.out.println("[����]ù��° �Ű������� ���޵� ���� �ι��� �Ű������� ���޵� ������ �۾ƾ� �˴ϴ�.");
			return;
		}
		*/
		// �߸��� ���� �ԷµǾ��� �� ������ �����ϴ� ���� �˸��� ����̴�.
		if(num1>num2) {
			int temp=num1;
			num1=num2;
			num2=temp;
		}
		
		int tot=0;
		for(int i=num1; i<=num2; i++) {
			tot+=i;
		}
		System.out.println(num1+"~"+num2+" ������ �������� �հ� = "+tot);
	}
	
	int returnTot(int num1, int num2) {
		if(num1>num2) {
			int temp=num1;
			num1=num2;
			num2=temp;
		}
		
		int tot=0;
		for(int i=num1; i<=num2; i++) {
			tot+=i;
		}
		//=> �޼ҵ��� ��ȯ���� ���� �ڷ����� ���� ��ȯ
		return tot;
	}
	
	//�Ű������� ���޵� �������� Ȧ���� ��� false, ¦���� ��� true ��ȯ
	//�޼��� �̸��� is�� ���۵Ǹ� ��κ� true or false�� ��ȯ�ϴ� �޼����̴�.
	boolean isOddEven(int num) {
		if(num%2 != 0) {
			return false;
		}
		return true; // �޼��尡 ������� ���� ���� true�� ��ȯ�ϰڴٴ� �ǹ�
	}

	//�Ű������� ��ü�� ���޹ްų� ��ü ��ȯ ����
	String nameHello(String name) {
		return name+"�� �ȳ��ϼ���.";
		// return name+"�� �ȳ��ϼ���."; �޼ҵ忡�� return�� �Ѱ��� ��밡��
	}
	
	// ���� ������ ��ȯ�ϰ� �ʹٸ� �迭�� �����Ͽ� �迭�� ��ȯ�ؾ���. (�迭�� �ؽ��ڵ带 ��ȯ�ϴ� ����)
	// => ��Ģ������ �޼ҵ�� ���� �ϳ��� ��ȯ�� �� ����.
	// �迭�� ��ȯ�ϴ� �޼ҵ� - �迭�� ��� ��Ұ��� ������ �� �ִ�.
	int[] returnArray() {	// �Լ� returnArray�� ��ȯ���� int[]
		/*
		int[] array= {10,20,30,40,50};
		return array;
		*/
		
		return new int[] {10,20,30,40,50}; // �������� ���� ��ȯ�Ǵ� �迭�� ���� ��.
		// return {10,20,30,40,50} �� ���� �߻� �߰�ȣ�� ���� �迭�� �ƴϴ�.
	}
	
	// 3���� �Ű������� �������� ���޹޾� �հ踦 ����Ͽ� ��ȯ�ϴ� �޼���
	int sumOne(int num1, int num2, int num3) {
		return num1+num2+num3;
	}
	
	//�Ű������� �迭�� ���޹޾� �迭 ��ҵ��� �հ踦 ����Ͽ� ��ȯ�ϴ� �޼ҵ�
	int sumTwo(int[] num) {
		int tot=0;
		for(int temp:num) {
			tot+=temp;
		}
		return tot;
	}
	
	// <JDK 1.5 version �̻����>
	//�Ű����� ������ȣ(...)�� ����� �Ű������� ������ ��� ���� 0�� �̻� ���޹޾�
	//�迭 �������� ��밡�� - �迭ó�� ó��
	// => ���ϴ� ������ŭ ��밡�� (0�� �̻�)
	int sumThree(int... num) {
		int tot=0;
		for(int temp:num) {
			tot+=temp;
		}
		return tot;
	}
	
}
