package xyz.itwill.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//���� ���尪�� ���� ����Ÿ�� �Է¹޾� ����Ϳ� �����Ͽ� �����ϴ� ���α׷�
public class FileByteLoadApp {
	public static void main(String[] args) throws IOException {
		//FileInputStream : ���Ͽ� ����� ���� ���� �����ͷ� �д� �Է� ��Ʈ���� �����ϱ� ���� Ŭ����
		//=> ���޹��� ���ϰ�ο� ������ ���� ��� FileNotFoundException �߻� - ����ó��(�ʼ�)
			//������ ������ �Է½�Ʈ���� ��������� �ʴ´�. try~catch���� ���� ����ó�� �ʼ�
			//������ try������ �����ϸ� �ٽ� ����� �� ���� ������ �ܺο��� ���� (�������� ����)
			//����� ����. ���Ѱܵ� ��.
		FileInputStream in=null;
		try {
			in=new FileInputStream("c:\\data\\byte.txt");
			
			System.out.println("[�޼���]c:\\data\\byte.txt ���Ͽ� ����� �����Դϴ�.");
			int readByte;
			while(true) {
				//���� �Է� ��Ʈ���� �̿��Ͽ� ���� ���尪�� ���� �����ͷ� �о� ��ȯ�޾� ������ ����
				readByte=in.read();
				//������ ���������� EOF(End Of File)�� �ݵ�� ����
					//���� �Է��ؾ��ϴ� �ְܼ� �޸� ���Ͽ��� ���� ������ ������ �� EOF �� ����. 
				if(readByte == -1) break;
				System.out.write(readByte);
			}
		} catch (FileNotFoundException e) {
			System.out.println("[����]��� ������ ã�� �� �����ϴ�.");
		} finally {
			//FinleInputStream.close() : ���� �Է� ��Ʈ���� �����ϴ� �޼ҵ�
			//���� �Է� ��Ʈ���� finally �������� �����ϴ� ���� ����
			//=> ���� �߻� ������ ������� ���� �Է� ��Ʈ�� ����
			//if ������ �̿��Ͽ� NullPointerException �߻� ����
				//try���� �ۼ��ϸ� ���� �ȵ� �� �ֱ� ������ finally ���� �ۼ��ϴ� ���� ����(�⺻)
				//��Ʈ���� ������ִ� ��� ������ ������ �߻��ϸ� in=null �����̱� ������ if�� ���
				//��, if���� Ȱ���Ͽ� in�� null�� �ƴ� �� close() ���
			if(in!=null) in.close();
		}
		
		//���� ���尪�� �޸𸮿� �����ϴ� ���� = load
		//�޸𸮿� �ִ� ���� ���Ͽ� �����ϴ� ���� = save
	}
}
