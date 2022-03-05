package xyz.itwill.io;

import java.io.Serializable;

//ȸ������(���̵�,�̸�,��ȭ��ȣ)�� �����ϱ� ���� Ŭ����
//=> ��ü ������ �Է� �Ǵ� ��� ó���Ǵ� Ŭ������ �ݵ�� ��ü ����ȭ Ŭ������ ����
//��ü ����ȭ(Object Serialization) : �ν��Ͻ��� byte �迭(���� ������ ����)�� ��ȯ�Ͽ�
//�Է� �Ǵ� ��� �ϴ� ����� ����

//��ü ����ȭ Ŭ������ �����ϴ� ���
//1. java.io.Serializable �������̽��� ��ӹ޾� ����
//=> �ν��Ͻ��� ��� �ʵ尪�� byte �迭�� ��ȯ�Ͽ� �Է� �Ǵ� ����ϴ� ��� ����
//2. java.io.Externalizable �������̽��� ��ӹ޾� ����
//=> �������̽��� �߻� �޼ҵ带 �������̵� �����Ͽ�  �Է� �Ǵ� ��¿� ���� �ʵ尪 ��ȯ ó��
//=> �ν��Ͻ��� Ư�� �ʵ尪�� byte �迭�� ��ȯ�Ͽ� �Է� �Ǵ� ����ϴ� ��� ����

//��ü ����ȭ Ŭ������ Ŭ������ �����ϱ� ���� �������� �ο��ϴ� �ʵ�(serialVersionUID)�� �����ϴ� ���� ����
//=> ��Ŭ����������  serialVersionUID �ʵ尪�� �ڵ����� �����ϴ� ��� ����
	//�⺻�ڷ����� ũ�Ⱑ ������ ������ �ν��Ͻ��� ũ�Ⱑ ������ ���� �ʱ� ������ ��𿡼� ���������ϴ��� �� �� ����.
	//e.g. ��Ʈ������ �⺻���� int��� ���� ������ 4�� (4byte)�� ������ ���� �� ����.
	//Member�� Member�� ������� �ν��Ͻ��� ����Ʈ ũ�Ⱑ ������ �� �� ����.
	//�� Byte¥�� ����Ʈ�迭�� ������ �˷��ִ� �۾��� ��ü ����ȭ��� �̾߱��Ѵ�.
	//Serializable�� ��ӹ޴� ���� ������ ��� (Externalizable�� Ư���� ���)
	//Externalizable�� ���ϴ� �ʵ常 �����ų� ���� �� �ִ�. - �����ؾ��ϴ� ������ ���� ��(�ʵ尡 ���� ��)
	//Ŭ������ �����ϸ� ���߿� ����ȯ�� �� ����
	//serialVersionUID �ʵ带 �ȸ��� ������ �߻����� ������ ������ ����� �ӵ� ���.
	//��ü���� ����� x - defualt
	//��ü���� �����   - generated serial version ID
public class Member implements Serializable {
	private static final long serialVersionUID = 3461321862275769514L;
	private String id;
	private String name;
	private String phone;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String id, String name, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
	}

	
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "���̵� = "+id+", �̸� = "+name+", ��ȭ��ȣ = "+phone;
	}
	
}
