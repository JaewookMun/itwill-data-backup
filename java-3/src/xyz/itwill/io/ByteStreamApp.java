package xyz.itwill.io;

import java.io.IOException;

//Byte Stream : ���õ�����(1Byte)�� �����ϱ� ���� �Է� �Ǵ� ��� ��Ʈ��
//=> InputStream Ŭ���� �Ǵ� OutputStream Ŭ������ ��� ���� �ڽ� Ŭ������ ������ ��Ʈ��(�ν��Ͻ�)

//Ű���� �Է°��� ���õ����ͷ� �Է¹޾� ����Ϳ� ����ϴ� ���α׷�
//=> EOF(End Of File : �Է� ���� - Ctrl+Z) ��ȣ�� �����ϸ� ���α׷� ����
	//Window - EOF�� �����Ű�� ����Ű (shortcut)		������ Ŀ��
	//Mac - Ctrl+D								������ Ŀ��
public class ByteStreamApp {
	public static void main(String[] args) throws IOException {
		System.out.println("[�޼���]Ű���带 ���� ���� �Է��� �ּ���.[����:Ctrl+Z]");
		
		//Ű���� �Է°��� ��ȯ�޾� �����ϱ� ���� ����
		int readByte;
		
		while(true) {
			//System.in : Java���� �⺻������ �����Ǵ� Ű���� �Է� ��Ʈ��
			//=> InputStream Ŭ������ ��ӹ��� �ڽ�Ŭ������ ������ ��Ʈ��
			//InputStream.read() : �Է� ��Ʈ���� �����ϴ� ���� ���� ����Ÿ(1Byte)�� �о� ��ȯ�ϴ� �޼ҵ�
			//=> �Է� ��Ʈ���� ���� ���� ��� ������ �Ͻ� ����
			//=> Ű���带 ���� �Է� ��Ʈ���� ���� �����ϰ� ���͸� ���� ������ �����
			//��� �Է� �Ǵ� ��� ��Ʈ���� �޼ҵ忡���� IOException �߻� - ���� ó��
			//=> IOException : �Է� �Ǵ� ��� ��Ʈ���� ������ �ִ� ��� �߻��Ǵ� ����
				//read()�� ���� InputStream�� �����ϴ� ���� 1Byte�� �о� �鿩�� ��ȯ�ϴ� �޼ҵ��̴�.
				//int���� ���� �ڷ����� ����� int���ȴ�. �׷��� ������ read()�� ��ȯ�޴� �����ʹ� int�� ����
				//���� ���� ���̴�. (�ڵ尪 13) �׷��� ������ �о���� �� �ִ�.
				//IOException : ��Ʈ���� �߰��� �������� �߻�.
				//Ű����&������� ��� �߻��� ���� ���� ���� > throws �� ���� JVM�� ����
				//��Ʈ��ũ or ���� : try~catch ������ ���� ���� ó��
				//read() : �Է� �⺻�޼ҵ�
			readByte=System.in.read();
			
			//�Է� ���� ��ȣ(Ctrl+Z : EOF >> -1)�� ���޵� ��� �ݺ��� ����
			if(readByte == -1) break;
			
			//System.out : Java���� �⺻������ �����Ǵ� ����� ��� ��Ʈ��
			//=> OutputStream Ŭ������ ��ӹ��� �ڽ�Ŭ����(PrintStream)�� ������ ��Ʈ��
			//OutputStream.write(int b) : ���õ�����(1Byte)�� ��� ��Ʈ������ �����ϴ� �޼ҵ�
				//write() : ��� �⺻�޼ҵ�
				//PrintStream�� write() �̴�.
				//Desktop application - input by keyboard and print by monitor (CUI : character user interface / console)
			System.out.write(readByte);
		}
	}
}
