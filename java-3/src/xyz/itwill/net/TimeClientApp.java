package xyz.itwill.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

//NTP ������ �����Ͽ� �������� ������ ��¥�� �ð������� �޾� ����ϴ� Ŭ���̾�Ʈ ���α׷�
public class TimeClientApp {
	public static void main(String[] args) throws ClassNotFoundException {
		try {
			//Socket �ν��Ͻ� ���� - ���� ����
				//������ ��ǻ���̸� or IP�ּҸ� �Է��Ͽ� ����
			Socket socket = new Socket("172.30.1.53", 3000);
			
			//Socket.getInputStream() : Socket �ν��Ͻ��� �Է½�Ʈ��(InputStream �ν��Ͻ�)�� ��ȯ�ϴ� �޼ҵ�
			//=> ���ӵ� ���� ��ǻ�Ϳ��� ������ ���� �����͸� �ޱ����� �Է½�Ʈ��
			InputStream in = socket.getInputStream();
			
			//Socket �ν��Ͻ��� �Է� ��Ʈ���� ���޹޾� ��ü�� ���� �� �ִ� �Է½�Ʈ��
			//(ObjectInputStream �ν��Ͻ�)�� Ȯ��
			ObjectInputStream stream = new ObjectInputStream(in);
			
			//������ ������ Date �ν��Ͻ��� ��ȯ�޾� ����
			Date data=(Date)stream.readObject();
			
			//Date �ν��Ͻ��� ���ϴ� ������ ���ڿ��� ��ȯ�Ͽ� ���
			System.out.println("[���]������ ������ ��¥�� �ð� = "+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(data));
			
			//���� ����
			socket.close();
		} catch (IOException e) {
			System.out.println("[����]������ ������ �� �����ϴ�.");
		}
		
	}
}
