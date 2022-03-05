package oop;

//�ڵ����� ǥ���ϱ� ���� Ŭ���� 
	//=> Ŭ������ �ڵ����� ǥ���ϱ����� �ڷ���(data type)�� ��
//=> Ŭ������ �ۼ��� �� �ʵ� �Ǵ� �޼ҵ忡 ���� �����ڸ� �����Ͽ� ���� ���� ����
//���� ������(Access Modifier) : private, package, protected, public
//=> Ŭ����, �ʵ�, ������, �޼ҵ忡 �����Ͽ� ���� ������ �����ϴ� Ű����
//private : Ŭ���� ���ο����� ���� �����ϸ� �ܺο����� ���� �Ұ����ϵ��� �����ϴ� ������
//=> �ʵ� ����� ��� : �ν��Ͻ� �ʵ��� �������� ���� ���� - ����ȭ(Information Hiding)
//public : ��� ��Ű���� Ŭ�������� ���� �����ϵ��� �����ϴ� ������
//=> �޼ҵ� ����� ��� : �޼ҵ带 ��� Ŭ�������� �����Ͽ� ����� �� �ֵ��� ����
	// �ʵ忡 �߸��� ���� ���� ���ɼ� ����. (�޼ҵ�� �̸� �˰������� ó���� ����, �ʵ�� �̰��� �Ұ���..)
	//- Ŭ�������� public, package�� ��밡��
	//������ - Ŭ����,�ʵ�,�޼ҵ忡 Ư�� ����� �����ϱ� ���� ���
	//�ʵ带 ������ ���� private�� ����Ͽ� '����ȭ'�ϴ� ���� ����ȴ�.
	//public ���� �޼ҵ带 �����ϸ� ���� ��Ű���������� ���� �����ϴ�.
public class Car {
	//�ʵ�(Field) : ǥ����� ���� �Ӽ� ���� - �Ӽ��� ����
	//field���� camel case ���
	//=> Ŭ������ ����� ��� �޼ҵ忡�� �ʵ� ���ٰ���
	private String aliasName;		//�̸�(��Ī) - ������
	private boolean engineStatus;	//��������(�õ�����) - false : Off, true : On
	private int currentSpeed;		//����ӵ�
	//ǥ������� ������ ���� ǥ������� ������ �� �ִ� �������� �����ϴ� �ʵ嵵 �ʿ��ϴ�.
	
	/*	[Modelling]
	 *  ���α׷��� ���� Ŭ������ ���� �� ǥ������� ��Ȯ�� ������ �� �ִ�
	 * �������� ������ �� �ִ� �Ӽ��� �ִ� ���� ����.
	 * e.g. �̸����� ���� �ߺ��� �� ������ �̸��� or ��ȭ��ȣ�� ȸ�����Խ� �޴� ���  
	 */
	
	//������(Constructor) : ��ü(�ν��Ͻ�)�� �����ϱ� ���� Ư���� �޼ҵ�
	// => �ϳ��� �����ڵ� �������� ������ �Ű������� ���� �⺻�����ڰ� �����ϴ� ������ ó�� 
	// �����ڰ� ���� Ŭ������ �������� �ʴ´�.
	
	//�޼ҵ�(Method) : ǥ�� ��� ���� ������ ���� - ��ɵ��� �̿��� ��� ����
	//e.g.) �ڵ����� �̷��� �� �ִ� �ൿ��
	// => �ʵ带 �̿��Ͽ� ǥ�� ����� ������ ����� ���� ������� ����
	//	�ո��� �ൿ / �µ�.
	
	//for �ڵ����� �����ϴ� ����
	//�õ��� Ű�� ������ ǥ���� �޼��� - engineStatus �ʵ尪 ����
	public void startEngine() {
		engineStatus=true;
		System.out.println(aliasName+"�� �õ��� �׽��ϴ�.");
	}
	
	//�õ�� ���� ������ ǥ���� �޼���
	public void stoptEngine() {
		//Ŭ������ ������ �� �׳� return�� ���� Ȥ�� �Ʒ�ó�� ǥ���� ���� �ִ�.
		if(currentSpeed != 0) { //���� �ӵ��� 0�� �ƴ� ���
			
			/* speedZero()�� ���� �޼���� �����ϴ�
			currentSpeed=0;
			System.out.println(aliasName+"�� �ڵ����� ������ϴ�.");
			*/
			//Ŭ���� ���ο� ����� �޼ҵ�� ���� ȣ�Ⱑ��
			// => �ڵ��� �ߺ��� �ּ�ȭ : ���������� ȿ���� ����
			speedZero();
		}
		
		engineStatus=false;
		System.out.println(aliasName+"�� �õ��� �����ϴ�.");
	}
	
	//�ӵ��� ������Ű�� ������ ǥ���� �޼ҵ�
	//speed�� �͹��� ���� ���� ������ �� ������ �� �ֵ���
	public void speedUp(int speed) {
		if(!engineStatus) {//������ �����ִ� ���
			System.out.println(aliasName+"�� �õ��� ���� �ֽ��ϴ�.");
			return;
		}
		//�Ű������� ���������� ���� ���޵� ��� (-> 150 �̻��� �ȳ������� �ӵ��� ����.)
		//�Ű������� �߸��� ���� ���޵Ǿ �̸� �ڵ����� �����Ͽ� ���۵ǵ��� 
		// or �޽��� ��µ� ����.
		// �޼ҵ带 ������ ���� �ְ����� �����۵��� �� �ֵ��� ��������.
		// �̰��� Ŭ���� �𵨸��� (�޼ҵ� ����) �ݿ�
		// ���Ǽ��迡 �����ϴ� ���� ���α׷����� ����
		// ������ Ÿ�缺�� ���� ������ �ش� �޼ҵ�� ��ġ�� ����.
		if(currentSpeed+speed>150) {
			speed=150-currentSpeed;
		}
		
		currentSpeed += speed;
		System.out.println(aliasName+"�� �ӵ��� "+
		speed+"km/h ���� �Ǿ����ϴ�. ����ӵ��� "+currentSpeed+"km/h �Դϴ�.");
	}
	
	//�ӵ��� �����ϴ� ������ ǥ���� �޼ҵ�
	public void speedDown(int speed) {
		if(!engineStatus) {//������ �����ִ� ���
			System.out.println(aliasName+"�� �õ��� ���� �ֽ��ϴ�.");
			return;
		}
		// �߸��� ���� ���͵� ����ӵ� ��ŭ ���ҵ� �� �ֵ��� ����
		if(currentSpeed<speed) {
			speed=currentSpeed;
		}
		
		currentSpeed -= speed;
		System.out.println(aliasName+"�� �ӵ��� "+
				speed+"km/h ���� �Ǿ����ϴ�. ����ӵ��� "+currentSpeed+"km/h �Դϴ�.");
	}
	
	//�ڵ����� ���ߴ� ������ �޼ҵ�� ǥ���� �޼ҵ�
	public void speedZero() {
		currentSpeed=0;
		System.out.println(aliasName+"�� �ڵ����� ������ϴ�.");
	}
		// �𵨸��ؼ� ǥ���� Ŭ����
	
		// ������ ���α׷��� ������ ���ԵǾ�� ��.
		// Ŭ���� -> ��ü�� ������ ���α׷��� ����� ���� �����.

	//����ȭ ����� �ʵ带 ���� �ʵ尪�� ��ȯ�ϴ� Getter �޼ҵ�� �ʵ尪�� �����ϴ� 
	//Setter �޼ҵ带 ���� >> ĸ��ȭ - �ʵ� �ڷ����� boolean�� ��� is �޼ҵ� ����.
	//ĸ��ȭ(Getter & Setter) �޼ҵ� �ڵ� ���� ����Ű
	//[Alt]+[Shift]+[S] >> �˾��޴� >> [R] >> ���� �޴� >> �ʵ� ���� >> Generate
		// �� �˾��޴��� �ҽ��޴��� �����ϴ�.
		//eclipse - 'Source'�� ���� getter�� setter�� ������ִ� ����� �ִ�.
	
		//�ý��� ���ο����� ����ϴ� ��� getter, setter�� �ȸ���.
	
	public String getAliasName() { //Getter �޼ҵ� - �޼ҵ�� : get�ʵ��
		return aliasName; //�ʵ尪 ��ȯ
	}
	
	public void setAliasName(String aliasName) { //Setter �޼ҵ� - �޼ҵ�� : set�ʵ��
		//�Ű������� ���޵Ǿ� ����� ������ �ʵ尪 ����
		// => �Ű������� ���޵� ���� ���� ��ȿ�� �˻�
			// think. �ʵ带 ����ȭ�� ���� ���������� ������ �����ϱ� ���ؼ���.
		this.aliasName=aliasName; //�ʵ尪 ����
			//�Ű������� aliasName�� �� ��� set�޼��忡�� aliasName�� �Ű������� �νĵȴ�.
			//�ĺ��ڴ� �켱 ������������ ���� ã�� �� �� �� ���� ã�´�. (�ʵ带 �ļ����� ã��.)
			//get�޼ҵ忡�� �Ű������� ���� ã�ұ� ������ �Ű������� ��.
			//this�� Ŭ������ �ǹ��Ѵ�. this�� ����ϸ� �ʵ尡 �ȴ�.
	}
	
	//����ȭ ����� �ʵ��� �ڷ����� boolean�� ��� Is �޼ҵ�� ����
	public boolean isEngineStatus() {	//true or false ��ȯ
		return engineStatus;
	}

	public void setEngineStatus(boolean engineStatus) {
		this.engineStatus = engineStatus;
	}

	public int getCurrentSpeed() {
		return currentSpeed;
	}

	public void setCurrentSpeed(int currentSpeed) {
		this.currentSpeed = currentSpeed;
	}
	
}
