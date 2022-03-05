package oop;

//this : �޼ҵ忡 ������ �ִ� �Ű�����
//=> �޼ҵ带 ȣ���� �ν��Ͻ��� ������ �����ϱ� ���� ��������
//=> �ν��Ͻ��� �޼ҵ带 ȣ���� ��� ȣ�� �ν��Ͻ��� ������ �ڵ����� ���޹޾� ����
//=> �޼ҵ��� ��ɿ��� �ν��Ͻ��� �ʵ� �Ǵ� �޼ҵ忡 �����ϱ� ���� ���
//=> this �Ű������� ǥ������ �ʾƵ� �ν��Ͻ� �ʵ� �Ǵ� �޼ҵ忡 ���� ����


//�޼ҵ忡 this �Ű������� �ʿ��� ����
//=> �ʵ�� �ν��Ͻ����� �޸𸮿� ���� ���������� �޼ҵ�� �ν��Ͻ��� ������ ������� �޸𸮿� �ϳ��� ����
//	�޸𸮿� �ϳ��� ������ = ������Ÿ�� Ŭ����(Prototype Class)
//=> �޼ҵ忡�� �ʵ� �Ǵ� �޼ҵ忡 ������ ��� ��Ȯ�ϰ� �ν��Ͻ��� �����Ͽ� �ʵ� �Ǵ� 
//	 �޼ҵ忡 �����ϱ� ���� this �ʿ�


//this �Ű������� ����ϴ� ���
//1*. �޼ҵ忡�� �Ű������� �ʵ��� �̸��� ���� ��� this�� �̿��Ͽ� �ʵ� ǥ��
//=> this�� ������ �Ű������� ó��
	//���α׷�������� ���Ǽ��� ���ؼ� �޼ҵ��� �Ű����� �̸��� �ʵ�� ���� �Ѵ�. 
//2. �����ڿ��� �ٸ� �����ڸ� ȣ���ϱ� ���� this ���.
//=> this�� �����ڸ� ȣ���ϴ� ��� ���� �ٸ� ����� �ۼ��� ��� ���� �߻�
//3. �̺�Ʈ ó�� ���α׷� �Ǵ� ���� ������ ���α׷��� �޼ҵ忡�� �ν��Ͻ��� ǥ���Ͽ� ó��


//ȸ������(���̵�, �̸�, �̸���)�� �����ϱ� ���� Ŭ���� : VO(Value Object) Ŭ����
	//���� �����ϱ����� Ŭ����(���� ���� ����� �ɰ���)
	//VOŬ������ �ʵ�� getter&setter�� ����� ��찡 ��ټ� (������ �޼ҵ����)
public class Member {
	//�ʵ�(Field) ����
	//=> �ν��Ͻ� ������ �ʵ忡 �⺻�� �ڵ� ����(������:0, ����:false, ������:null)
	//=> �ν��Ͻ� ������ �ʵ忡 ����Ǵ� �⺻�� ����
	private String id="NoId";
	private String name="NoName";
	private String email="NoEmail";

	//������(Constructor) ���� 
	//=> �����ڸ� �������� ������ ���������� �⺻ ������(default constructor)�� ����
	//=> �����ڸ� �ϳ��� �����ϸ� �⺻ �����ڴ� ������
	
	//������(Constructor) - �ν��Ͻ��� �����ϱ� ���� Ư���� �޼ҵ�
	//=> ������ �ۼ� ��Ģ - ��ȯ���� ������ �޼ҵ���� Ŭ������� �����ϰ� �ۼ�
	//=> �����ε� ���� ���� : �Ű������� �ٸ� �������� ������ ���� ����
	//=> �ʱ�ȭ �۾� ���� : ���� �ν��Ͻ��� �ʵ忡 ���ϴ� �ʱⰪ�� ����ǵ��� ��� �ۼ�
	
	//�Ű������� ���� ������ - �⺻ �����ڿ� ����
	//=> �Ϲ������� �ʱ�ȭ �۾��� �̱���
	//=> �Ű������� ���� �����ڸ� �������� ���� ��� ��Ӱ��� ������ �߻��� �� �����Ƿ� �����ϴ� ���� ����
	//�Ű������� ���� ������ �ڵ� �ϼ� : [Ctrl] + [Space]
	
	public Member() {
		/*
		id="NoId";
		name="NoName";
		email="NoEmail";
		*/
		//Member(String, String, String) �����ڸ� ȣ���Ͽ� �ʱ�ȭ �۾�
		//this("NoId", "NoName", "NoEmail"); (���� �� �ʿ䰡 ����)
	}
	
	//�Ű������� ����� ������
	//=> �Ű������� ���޵� ���� �̿��Ͽ� �ʵ尪 ���� - �ʱ�ȭ �۾�
	//=> �ʵ忡 ���ϴ� ���� ����� �ν��Ͻ��� �����ϱ� ���� �����ڸ� �ۼ�
	//�Ű������� ����� ������ �ڵ��ϼ� : [Alt]+[Shift]+[S] >> �˾��޴� >> [O] >> �����޴� >> �ʱ�ȭ �ʵ� ���� >> Generate
		//Generate Constructor using Fields
	public Member(String id) {
		//this.id = id;
		
		//this(id,"NoName","NoEmail"); //�ٸ� �����ڸ� �̿��ؼ� �ʱ�ȭ ����
	}

	public Member(String id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public Member(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	
	//�޼ҵ�(Method) ����
		//����ȭ�� �ʵ��� getter/setter�� ���� ������ش�. when creating getter & setter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	//�ʵ尪�� ����ϴ� �޼ҵ� >> �ʵ尪 Ȯ��
		//Ŭ���� ���ο��� ���ٰ���.
	public void display() {
		System.out.println("���̵� = "+id);
		System.out.println("�̸� = "+name);
		System.out.println("�̸��� = "+email);
	}
	
	
}
