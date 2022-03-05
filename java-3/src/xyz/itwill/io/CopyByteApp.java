package xyz.itwill.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//�������Ͽ� ����� ���� ���� �����ͷ� �о� ������Ͽ� �����Ͽ� �����ϴ� ���α׷�
//=> ��� ���Ϻ��� ����
public class CopyByteApp {
	public static void main(String[] args) throws IOException {
		//BufferedInputStream : InputStream �ν��Ͻ��� ���޹޾� �뷮�� ���� �����͸� ���
		//���� ����� �����ϴ� �Է� ��Ʈ���� �����ϱ� ���� Ȯ�� Ŭ����
		BufferedInputStream in = null;
		
		//BufferedOutputStream : OutputStream �ν��Ͻ��� ���޹޾� �뷮�� ���� �����͸� ����
		//�ϴ� ����� �����ϴ� ��� ��Ʈ���� �����ϱ� ���� Ȯ�� Ŭ����
		BufferedOutputStream out = null;
			//Buffered �ܾ ���� ����� Ŭ������ ������ ��Ƴ��ٰ� �ѹ��� �����ų� ���� �� �ִ�.
			//-> �аų� ������ �ӵ��� ������.
		
		try {
			//in=new BufferedInputStream(new FileInputStream("c:/data/zoom.txt"));
			//out=new BufferedOutputStream(new FileOutputStream("c:/data/zoom_byte.txt"));
			
				//text���� �Ӿƴ϶� ��������(exe; execute)�� �о���̰� ������ �� �ִ�. �׸����� ���ð���
				//������ �������� ���õ����͸� �״�� �о���̱� ������ ���Ϻ��簡 ����� �ȴ�.
			in=new BufferedInputStream(new FileInputStream("c:/data/zip.exe"));
			out=new BufferedOutputStream(new FileOutputStream("c:/data/zip_byte.exe"));
			
			
			int readByte;
			while(true) {
				readByte=in.read();
				if(readByte==-1) break;
				
				out.write(readByte);
			}
			System.out.println("[�޼���]������ ���������� ���� �Ͽ����ϴ�.");
		} catch (FileNotFoundException e) {
			System.out.println("[����]���� ������ ã�� �� �����ϴ�.");
		} finally {
			if(in != null) in.close();
			if(out != null) out.close();
		}
	}
}
