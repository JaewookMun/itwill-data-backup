package xyz.itwill.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

//���� ���尪�� ���� ����Ÿ�� �Է¹޾� ����Ϳ� �����Ͽ� �����ϴ� ���α׷�
public class FileCharLoadApp {
	public static void main(String[] args) throws IOException {
		//FileReader : ���Ͽ� ����� ���� ���ڵ� ó���� ���� �����ͷ� �д� �Է� ��Ʈ���� ����
		FileReader in = null;
		
		try {
			//FileReader(String name) : ���ϰ�θ� ���޹޾� ���� �Է� ��Ʈ���� �����ϴ� ������
			//=> ���޹��� ���ϰ�ο� ������ ���� ��� FileNotFoundException �߻� - ����ó��(�ʼ�)
			in = new FileReader("c:\\data\\char.txt");
			
			//������� ���ڵ� ó���� ���� �����͸� �����ϴ� ��� ��Ʈ�� ���� - Ȯ��
			OutputStreamWriter out = new OutputStreamWriter(System.out);
			
			int readByte;
			while(true) {
				readByte=in.read();
				if(readByte==-1) break;
				out.write(readByte);
					//����Ϳ� �������� �ѹ��� ��Ƽ� �������� ������ �־ flush() ��� ����?
				out.flush();
			}
		} catch (FileNotFoundException e) {
			System.out.println("[����]��� ������ ã�� �� �����ϴ�.");
		} finally {
			if(in!=null) in.close();
		}
		
		
	}
}
