package xyz.itwill.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;


//Ű����� �̸��� �¾ �⵵�� �Է¹޾� �̸��� ���̸� ����ϴ� ���α׷�
	//Ŭ������ �̿����� �ƴ� �����ڴ� Scanner�� ������� �ʴ´�. �ֿܼ��� ����ϱ� ���� ������� Ŭ����
	//���װ� ���� ������ ������� �ʴ´�.
public class ConsoleIOApp {
	public static void main(String[] args) throws IOException {
		//Java���� �����Ǵ� Ű���� �Է� ��Ʈ���� �뷮�� ���� �����͸� �Է� ���� �� �ִ�
		//����� �����ϴ� ��Ʈ������ ��뷮 �Է� ��Ʈ������ Ȯ���Ͽ� ����
		//System.in : Java���� �����Ǵ� Ű���� �Է� ��Ʈ������ ���õ���Ÿ �ϳ��� ��ȯ�ϴ� 
		//����� �����ϴ� ��Ʈ��
		//InputStreamReader : InputStream �ν��Ͻ��� ���޹޾� �Է� ��Ʈ���� Ȯ���Ͽ� ����
		//����Ÿ �ϳ��� ��ȯ�ϴ� ����� �����ϴ� ��Ʈ��
		//BufferedReader : Reader �ν��Ͻ��� ���޹޾� �Է� ��Ʈ���� Ȯ���Ͽ� �뷮�� ����
		//����Ÿ(���ڿ�)�� ��ȯ�ϴ� ����� �����ϴ� ��Ʈ��
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//System.out : Java���� �����Ǵ� ����� ��� ��Ʈ������ ���õ���Ÿ �ϳ��� ��ȯ�ϴ�
		//����� �����ϴ� ��Ʈ�� - PrintStream Ŭ������ �̿��Ͽ� ������ ��� ��Ʈ��
		//=> print() �Ǵ� println() �޼ҵ带 �̿��Ͽ� ��� ���� ���� ����Ÿ�� ��ȯ�Ͽ� ���ް���
			//OutputStream�� Ȯ���Ű�� �ʴ� ����
			//PrintStream�� OutputStream�� �ƴϴ�.
		System.out.print("�̸� �Է� >> ");
		
		//BufferedReader.readLine() : �Է� ��Ʈ���� �����ϴ� ��� �Է°��� ���ڿ��� ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ�
		String name=br.readLine();
		
		System.out.print("�¾ ���� �Է� >> ");
		//Ű���� �Է°��� ���ڿ��� ��ȯ�޾� ���������� ��ȯ�Ͽ� ��
		int birthYear=Integer.parseInt(br.readLine());
		
		int age=Calendar.getInstance().get(Calendar.YEAR)-birthYear+1;
		
		System.out.println("[���]"+name+"���� ���̴� "+age+"���Դϴ�.");
			//Ű����� ���� �����Ǵ� ���̱� ������ ��ĳ��ó�� close()�� ����� �ʿ䰡 ����.

	}
}
