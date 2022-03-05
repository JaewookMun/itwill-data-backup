package xyz.itwill.dto;

// DTO(Data Transfer Object) Ŭ���� : ���̺��� �� ������ �����Ͽ� �����ϱ� ���� Ŭ����

/*
�̸�      ��?       ����           
------- -------- ------------ 
PHONE   NOT NULL VARCHAR2(20) 
NAME             VARCHAR2(20) 
ADDRESS          VARCHAR2(50) 
 */

// PHONEBOOK ���̺��� �� ������ �����ϱ� ���� Ŭ����
	// �÷������ ��Ī�� �� �ִ� �ʵ� ����
	// DTO Ŭ������ ���̺��� ���� Ŭ������ ����
public class PhonebookDTO {
	private String phone;
	private String name;
	private String address;
	
	// [Ctrl] + [Space] >> Constructor ����
	public PhonebookDTO() {
		// TODO Auto-generated constructor stub
	}

	// [Alt]+[Shift]+[S] >> [O] >> �ʵ� ���� >> [Generate]
	public PhonebookDTO(String phone, String name, String address) {
		super();
		this.phone = phone;
		this.name = name;
		this.address = address;
	}

	
	// [Alt]+[Shift]+[S] >> [R] >> �ʵ� ���� >> [Generate]
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}