package xyz.itwill.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Date;
	
	//Data~StreamŬ������ �⺻���� ������ �� ������ Object~Stream�� ��ü�� ������ �� �ִ�. 
	//�޸����� ��� �����͸� ���ڵ� ���·� ���� ������ ��������
	//��ü������ ������ �͵� ���� �����.
public class ObjectOutputStreamApp {
	public static void main(String[] args) throws IOException {
		//ObjectOutputStream : OutputStream �ν��Ͻ��� ���޹޾� ���ϴ� �ڷ��� �Ǵ� �ν��Ͻ��� 
		//���� �����ͷ� ��ȯ�Ͽ� �����ϴ� ����� �����ϴ� ��� ��Ʈ���� �����ϱ� ���� Ȯ�� Ŭ����
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("c:/data/object.txt"));
		
		//ObjectOutputStream.writeObject(Object obj) : ��ü(�ν��Ͻ�)�� ��� ��Ʈ������ �����ϴ� �޼ҵ�
			//��ü�� �����Ѵ�.
		out.writeObject("ȫ�浿");//String �ν��Ͻ�
		out.writeObject(new Date());//Date �ν��Ͻ� ����
		out.writeObject(Arrays.asList("�Ӳ���","����ġ","������"));//ArrayList �ν��Ͻ� ����
		
		out.close();
		
		System.out.println("c:\\data\\Object.txt ���Ͽ� �پ��� �ڷ����� ������ ���� �Ͽ����ϴ�.");
	
	}
}