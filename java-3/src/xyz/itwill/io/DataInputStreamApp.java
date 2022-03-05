package xyz.itwill.io;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

	//Object ����� ��Ʈ���� �� ���� ���
public class DataInputStreamApp {
	public static void main(String[] args) throws IOException {
		//DataInputStream : InputStream �ν��Ͻ��� ���޹޾� ���� �����͸� ���ϴ� �ڷ�����
		//������ ��ȯ�Ͽ� ��ȯ�ϴ� ����� �����ϴ� �Է� ��Ʈ���� �����ϱ� ���� Ȯ�� Ŭ����
		DataInputStream in = new DataInputStream(new FileInputStream("c:/data/data.txt"));
		
		//�ݵ�� ���Ͽ� ����� ������� ���� �о� ���
		//=> ���Ͽ� ����� ���� �б� ���� �޼ҵ� ȣ�� �� EOFException �߻�
		//=> EOFExcception : �Է� �޼ҵ� ȣ�� �� ���� Ŀ���� EOF ��ġ�� ������ ��� �߻��Ǵ� ����
		
		//DataInputStream.readInt() : �Է� ��Ʈ���� ���� �����͸� �о� ���������� ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ�
		int value1=in.readInt();
		
		//DataInputStream.readBoolean() : �Է� ��Ʈ���� ���� �����͸� �������� ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ�
		boolean value2 = in.readBoolean();
		
		//DataInputStream.readUTF() : �Է� ��Ʈ���� ���� �����͸� ���ڿ��� ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ�
			//���ڿ� �� ������ null���� �����ϸ� �̰ͱ��� �� �о���δ�.
		String value3=in.readUTF();
		
		in.close();
		
		System.out.println("value1 = "+value1);
		System.out.println("value2 = "+value2);
		System.out.println("value3 = "+value3);
		
	}
}
