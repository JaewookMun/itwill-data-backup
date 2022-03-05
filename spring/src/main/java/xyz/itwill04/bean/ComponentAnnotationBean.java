package xyz.itwill04.bean;

import org.springframework.stereotype.Component;

// @Component : Ŭ������ Spring Bean���� ����ϱ� ���� ������̼�
// => �⺻������ Ŭ�������� beanName���� ���� - ù���ڴ� �ҹ��ڷ� ��ȯ
// @Component ������̼��� value �Ӽ��� ����Ͽ� beanName ���� ����
// => �ٸ� �Ӽ��� ���� ��� �Ӽ����� ����
	// beanName ������ �������� �ʴ´�.
@Component("bean") // (value="bean")���� ǥ���ص� �������
public class ComponentAnnotationBean {
	public ComponentAnnotationBean() {
		System.out.println("### ComponentAnnotationBean Ŭ������ �⺻ ������ ȣ�� ###");
	}
	
	public void display() {
		System.out.println("*** ComponentAnnotationBean Ŭ������ display() �޼ҵ� ȣ�� ***");
	}
}
	/*
		Component ������̼� ���� �Ӽ� ������̼��� ���� bean Attribute�� ������ �� �ִ�.
		������ Ŭ������ ����� ���� XML ������ ���� ����ϴ� ���ۿ� ����. ���� ����� Ŭ������ ������̼� Ȱ�밡��
		�Ϲ����� Ŭ������ bean���� ����ϴ� ������̼� - Component
		Ư���� Ŭ������ ������������ ����ϴ� ������̼� ���� ������. 
	 */
