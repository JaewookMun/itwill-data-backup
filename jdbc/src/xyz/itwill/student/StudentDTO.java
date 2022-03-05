package xyz.itwill.student;

// DTO(Data Transfer Object) Ŭ���� : DAO Ŭ������ �޼ҵ忡�� �������� ���޹ްų� ��ȯ�ϱ�
// ���� ������ Ŭ���� - VO(Value Object) Ŭ����
// => ���̺��� �÷��� 1:1�� ��Ī�Ǵ� �ʵ� ���� - Getter & Setter
// => �ʵ���� ���̺��� �÷���� �����ϰ� �ۼ��ϴ� ���� ����
	// ������ ���޹ްų� ��ȯ�ϱ� ���� ����� Ŭ����

	// [2021.06.21 edited]
	// ���� ���̺� �ϳ��� DAO, DTO�� �ϳ��� �����Ѵ�.
	// ������ DAO & DTO�� ������ ���̺� �������� �� ���� �� �� �ִ�. => JOIN ���̽� ���
	// 1.��ȹ -> 2.ȭ�鼳�� -> 3-1.������ 			->		   	      6.'App'
	//		            -> 3-2.DB���� -> 4.Table -> 5.DTO & DAO -> 6.'App'
	// ���谡 �߸��Ǹ� ���α׷��� �ٽ� �������ϴ� ��� �߻�
	// ��������Ʈ�� ��ȹ�� �ϸ鼭 ����� �����ؾ��Ѵ�. - �����д� : ����, ȸ��, ��ٱ��� ��
	// => �����д��� ���� ������� ȭ���� �������� ���� ������Ѵ�.
	// => �������� ���ļ� ���α׷��� �׽�Ʈ�� ����

/*
�̸�       ��?       ����            
-------- -------- ------------- 
NO       NOT NULL NUMBER(4)     
NAME              VARCHAR2(30)  
PHONE             VARCHAR2(20)  
ADDRESS           VARCHAR2(100) 
BIRTHDAY          DATE          
*/

// STUDENT ���̺��� ������(�л�����)�� �����Ͽ� �����ϱ� ���� Ŭ����
	// ���常��(VO) ���� ������ �ƴ϶� �޼ҵ带 ���� �����ϰų� ���޹ޱ� ���� ����� �߰���. (DTO)
public class StudentDTO {
	private int no;
	private String name;
	private String phone;
	private String address;
	private String birthday;
	
		// �÷����� ������ũǥ����� ����ؼ� ǥ���ߴٸ� ī��ǥ������� �ٲپ� �������ش�.
		// e.g. USER_NAME  => userName
	
	public StudentDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public StudentDTO(int no, String name, String phone, String address, String birthday) {
		super();
		this.no = no;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.birthday = birthday;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	
	
}
