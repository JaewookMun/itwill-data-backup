package basic;

import java.util.Scanner;

public class ScannerApp {

	public static void main(String[] args) {
		//Scanner Ŭ���� : �Է���ġ
		//Scanner Ŭ������ ��ü�� �����Ͽ� ������ ���� - ������ ����� ��ü�� �޼ҵ� ȣ��
		// => Ű����κ��� ���� �Է¹ޱ� ���� Scanner ��ü ����
		// => System.in : Ű���� �Է� ��Ʈ�� - Ű����� �Էµ� ���� �����ϴ� ��ü (Ű���� ��)
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("�̸� �Է� >> ");
		// Scanner.nextLine() : �Է°��� ���ڿ��� ��ȯ�ϴ� �޼ҵ�
		// ����� Ű����� �Է¹��� ���ڿ��� ������ ����
		// => Ű���� �Է°��� ���� ��� ���α׷��� �帧(thread ������)�� �Ͻ� ����
		// => ����� Ű����� ���� �Է��� �� ���͸� �Է��ϸ� ������ �����
		String name = scanner.nextLine();
		
		System.out.print("���� �Է� >> ");
		// Scanner.nextInt() : �Է°��� ���������� ��ȯ�ϴ� �޼ҵ�
		// ����� Ű����� �Է¹��� �������� ������ ����
		// => Ű���� �Է°��� �������� �ƴ� ��� ����(Exception)�߻�
		int age = scanner.nextInt();

		System.out.println("[���]"+name+"���� "+age+"�� �Դϴ�.");
		
		//Scanner.close() : Scanner ��ü�� ��Ʈ���� �����ϴ� �޼ҵ�
		scanner.close();    //Scanner ��ü�� �������ִ� ��Ʈ���� ���ŵǾ���. - meaning
	}
}