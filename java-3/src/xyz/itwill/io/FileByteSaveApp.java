package xyz.itwill.io;

import java.io.FileOutputStream;
import java.io.IOException;

//Ű���� �Է°��� ���� ����Ÿ�� �Է¹޾� ���Ͽ� �����Ͽ� �����ϴ� ���α׷�
//=> EOF(End Of File : �Է� ���� - Ctrl+Z) ��ȣ�� �����ϸ� ���α׷� ����
public class FileByteSaveApp {

	public static void main(String[] args) throws IOException {
		System.out.println("[�޼���]Ű���带 ���� ���� �Է��� �ּ���.[����:Ctrl+Z]");
		
		//FileOutputStream : ���Ͽ� ���� ����Ÿ�� �����Ͽ� �����ϴ� ��� ��Ʈ���� �����ϱ� ���� Ŭ����
		//FileOutputStream(String name) : ���ϰ�θ� ���޹޾� ���� ��� ��Ʈ���� �����ϴ� ������
		//=> ���޹��� ���ϰ�ο� ������ ���� ��� FileNotFoundException �߻� - ����ó��
			//���� try~catch�� ����ó�� ���ص���. - ����ó�� ���ϰ��ѱ�
		//=> ���޹��� ���ϰ�ο� ������ ���� ��� ������ �ڵ����� ����� ��� ��Ʈ���� �����Ͽ� ��ȯ
		//=> ���޹��� ���ϰ�ο� ������ �ִ� ��� ���� ������ ���� ��� ���ο� ������ ���޹޾� ���� - ���� �����(OverWrite)
			// ������ Ŀ����ġ�� ù��ġ�� �ֱ� ����
		//FileOutputStream out = new FileOutputStream("C:\\data\\byte.txt");

		//FileOutputStream(String name, boolean append) : ���ϰ�ο� ������ ���޹޾� ����
		//��� ��Ʈ���� �����ϴ� ������
		//=> false : ���� ���� �����(�⺻), true : ���� ���� �̾��
		FileOutputStream out = new FileOutputStream("C:\\data\\byte.txt", true);
		
		int readByte;
		while(true) {
			//Ű���� �Է� ��Ʈ���� ���� ���� �����ͷ� �о� ������ ����
			//FileNotFoundException Ŭ������ IOException Ŭ������ �ڽ� Ŭ����
			readByte=System.in.read();
			
			if(readByte==-1) break;
			//���� �����Ͱ� ����� �������� ���� ��� ��Ʈ���� ���� - ���� ����
			out.write(readByte);
			
		}
		//FileOutputStream.close() : ���� ��� ��Ʈ���� �����ϴ� �޼ҵ�
		//=> ���Ͽ��� �Է� ��Ʈ���� ��� ��Ʈ���� ���� �ϳ��� ���� ����
		//=> ���� ó���� ���� ������ ��Ʈ���� ��� �� �ݵ�� ����
			//��Ʈ���� ���Ű� �ȵǸ� �ٸ� ���α׷����� �ش� ���Ͽ� ���ؼ� ��½�Ʈ���� ���� �� ����.
			//��Ʈ���� �ϳ��ۿ� ������� ������ ������ ��������� ���ÿ� �������� ���Ѵ�. (���߻����ȯ���� ���α׷� �Ұ���)
			//������ ������ �߻����� ������ �ٸ� ���α׷����� ���� ������ �߻��� �� ����
		out.close();
		
		System.out.println("[�޼���]C:\\data\\byte.txt ���Ͽ� Ű���� �Է°��� ���� �Ǿ����ϴ�.");
		
		
		
		
	}
}
