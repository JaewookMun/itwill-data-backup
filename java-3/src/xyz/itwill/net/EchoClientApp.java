package xyz.itwill.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

//Ű����� �޼����� �Է¹޾� ������ �����Ͽ� ���� ������ �޼����� �����ϴ� Ŭ���̾�Ʈ ���α׷�
public class EchoClientApp {
	public static void main(String[] args) throws IOException {
			//BufferedWriter ���ٴ� PrintWriter�� �� ���� ���
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("���� �޼��� �Է� >> ");
		String message = in.readLine();
		
		try {
			//���� ����
			Socket socket=new Socket(InetAddress.getLocalHost().getHostAddress(), 4000);
			
			//������ ��� ��Ʈ���� ��ȯ�޾� ���ڿ��� ������ �� �ֵ��� Ȯ��
			/*
			BufferedWriter out=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			out.write(message);
				//buffer�� �� ��Ƽ� �������� ������ �ֱ� ������ flush�� ����ؾ���.
			out.flush();
			*/
			
			PrintWriter out = new PrintWriter(socket.getOutputStream());
				//println() �޼ҵ带 ��� ����
				//� ���� ���������� ���ڿ��� ���� �� �ִ�.
			out.println(message);
			out.flush();
			
			socket.close();
		} catch (IOException e) {
			System.out.println("[����]������ ������ �� �����ϴ�.");
		}
		
	}
}
