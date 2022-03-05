package xyz.itwill.io;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamApp {
	public static void main(String[] args) throws IOException {
	
		//DataOutputStream : OutputStream �ν��Ͻ��� ���޹޾� ���ϴ� �ڷ����� ���� ����
		//�����ͷ� ��ȯ�Ͽ� �����ϴ� ����� �����ϴ� ��� ��Ʈ���� �����ϱ� ���� Ȯ�� Ŭ����
		DataOutputStream out = new DataOutputStream(new FileOutputStream("c:/data/data.txt"));
		
		//DataOutputStream.writeInt(int value) : �������� ��� ��Ʈ������ �����ϴ� �޼ҵ�
			//4byte�� ��°�� �����Ѵٴ� �ǹ�
		out.writeInt(100);
		
		//DataOutputStream.writeBoolean(boolean b) : ������ ��� ��Ʈ������ �����ϴ� �޼ҵ�
		out.writeBoolean(true);
	
		//DataOutputStream.writeUTF(String value) : ���ڿ��� ��� ��Ʈ������ �����ϴ� �޼ҵ�
			//������. UTF�� ������ ���� ����
		out.writeUTF("ȫ�浿");
	
		out.close();
		
		System.out.println("c:\\data\\data.txt ���Ͽ� �پ��� �ڷ����� ������ ���� �Ͽ����ϴ�.");
	
	}
}