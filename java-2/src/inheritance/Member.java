package inheritance;

//ȸ������(���̵�, �̸�)�� �����ϱ� ���� Ŭ����
public class Member {
	private String id;
	private String name;
	
	//ctrl + space >> Constructor ����(����)
	public Member() {
		// �⺻�����ڸ� �ȸ���� ����� �ȵ�.
	}
	// alt+shift+s >> o >> choose the field >> generate
	public Member(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	// alt+shift+s >> r >> choose the field >> generate
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
	
	//�ڽ� Ŭ�������� �������̵� ����� �θ� Ŭ������ �޼ҵ�� ������ �޼ҵ�(Hide Method)�� ó���ȴ�.
	//=> �θ� Ŭ������ ������ �޼ҵ忡 �����ϸ� �ڵ����� �ڽ� Ŭ������ �������̵� �޼ҵ� ȣ��
	public void display() {
		System.out.println("���̵� = "+id);
		System.out.println("�̸� = "+name);
	}
	
}
