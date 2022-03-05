package xyz.itwill.net;

import java.io.IOException;
import java.io.ObjectOutputStream;
//import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

//���� Ŭ���̾�Ʈ���� ���� ��ǻ���� ��¥�� �ð������� �����ϴ� ���� ���α׷�
//=> NTP(Network Time Protocol) Server : ��¥�� �ð������� �����ϴ� ��ǻ��
public class TimeServerApp {
	public static void main(String[] args) {
		ServerSocket ntpServer = null;
		
		try {
			//ServerSocket �ν��Ͻ� ���� - ���� ����
				//Ŭ���̾�Ʈ�� ������ �� �ֵ��� ��Ʈ�� Ȱ��ȭ��Ų�ٰ� �����ϸ� ��.
			ntpServer = new ServerSocket(3000);
			System.out.println("[�޼���]NTP Server Running...");
			
			//���� ���α׷��� �ټ��� Ŭ���̾�Ʈ ������ ����ϱ� ���� ���ѷ����� �̿��Ͽ� ó��
				//���� while���� ������� ������ ������ �� �ִ� Ŭ���̾�Ʈ�� �� �ϳ��̴�.
			while(true) {
				//ServerSocket.accept() : Ŭ���̾�Ʈ�� ������ ��ٸ��� �޼ҵ�
				//=> Ŭ���̾�Ʈ ���� ������ ������ �Ͻ� ����
				//=> Ŭ���̾�Ʈ�� ���ӵǸ� Ŭ���̾�Ʈ�� ���ϰ� ����� Socket �ν��Ͻ��� �����Ͽ� ��ȯ�ϰ� �����尡 ����
				//=> ���� �������� Ŭ���̾�Ʈ ����ŭ Socket �ν��Ͻ� ����
					//������ �Ͻ������� System.in�� read()�޼ҵ带 �����Ҽ� ���������� �����ȴ�.
					//�ν��Ͻ� ���� - fort ����
					//accept()�� �غ�ϷḦ �ǹ�
					//������ ���� ���� Ŭ���̾�Ʈ ���� ����.
				Socket socket=ntpServer.accept();

				/*
				//Socket.getOutputStream() : Socket �ν��Ͻ��� ��½�Ʈ��(OutputStream �ν��Ͻ�)�� ��ȯ�ϴ� �޼ҵ�
				//=> ���ӵ� ���� ��ǻ�Ϳ� ���� �����͸� �����ϴ� ��� ��Ʈ��
					//socket�� ������ �ִ� �޼ҵ� �� ���� �߿�
					//���ϰ� ������ ����Ǹ� �ڵ������� ��Ʈ���� �����ȴ�.
				OutputStream out =socket.getOutputStream();
				
				//Socket �ν��Ͻ��� ��� ��Ʈ���� ���޹޾� ��ü�� ������ �� �ִ� ��½�Ʈ��
				//(ObjectOutputStream �ν��Ͻ�)�� Ȯ��
				ObjectOutputStream stream = new ObjectOutputStream(out);
				
				//Ŭ���̾�Ʈ���� ������ ��¥�� �ð������� ����� Date �ν��Ͻ� ����
				Date date = new Date();
				
				//�ý����� ��¥�� �ð������� ����� Date �ν��Ͻ��� ��� ��Ʈ������ ����
				//=> Ŭ���̾�Ʈ���� Date �ν��Ͻ� ����
				stream.writeObject(date);
				*/
					//���ʿ��� ���������� ���⿡ �̸� ���ٷ� ����.
				new ObjectOutputStream(socket.getOutputStream()).writeObject(new Date());
				
				//�α�(Log) ���
					//���α׷�(Ư�� ��Ʈ��ũ)���� '���'�� ������ �߿�. - �α׶�� ǥ��
					//���������� ����ϴ� ��. �߿�
				System.out.println("[�α�]Ŭ���̾�Ʈ["+socket.getInetAddress().getHostAddress()+"]���� ��¥�� �ð������� ���� �Ͽ����ϴ�.");
				
				//���� ���� - ���� ����
					//���������� ���� (������ �����͸� ��� �����߱� ������...)
				socket.close();
			}
			
		} catch (IOException e) {	//��Ʈ�浹 or ��Ʈ��ũ �� ������ �߻��� �� �ֱ� �빮�� ����ó��
			System.out.println("[����]������ ��Ʈ��ũ ������ �߻� �Ͽ����ϴ�.");
		}
	}
}
