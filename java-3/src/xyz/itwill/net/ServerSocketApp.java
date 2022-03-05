package xyz.itwill.net;

import java.io.IOException;
import java.net.ServerSocket;

//ServerSocket : TCP ����� ��Ʈ��ũ ���α׷����� ������ �����ϱ� ���� Ŭ����
//=> Ŭ���̾�Ʈ�� �����ϱ� ���� Ư�� Port�� Ȱ��ȭ�Ͽ� �ν��Ͻ� ����
//=> Ŭ���̾�Ʈ�� ������ ���ӵ� �� ����� Ŭ���̾�Ʈ�� ������ ���� ����

//����(Server) : �ٸ� ��ǻ�Ͱ� ������ �� �ִ� ȯ���� �����ϴ� ��ǻ��(�ý���)
//Ŭ���̾�Ʈ(Client) : ������ �����ϴ� ��ǻ��(�ý���)
	//remote computer & local computer

//ServerSocket Ŭ������ ��밡���� Port ��ȣ�� �˻��ϴ� ���α׷�
	//��Ƽ�̵� ������ ���α׷��� �Ϲ������� TCP�� ������� �����Ѵ�.
public class ServerSocketApp {
	public static void main(String[] args) {
		for(int i=445; i<=9000; i+=1000) {
			try {
				//ServerSocket(int port) : Port ��ȣ�� ���޹޾� ServerSocket �ν��Ͻ��� �����ϴ� ������
				//=> ���޵� Port ��ȣ�� �ٸ� ��Ʈ��ũ ���α׷����� ������� ��� IOException �߻�
					//��Ʈ�� ��� Ŭ���̾�Ʈ�� ������ �� �ִ� ȯ���� ����� ��.
				ServerSocket serverSocket = new ServerSocket(i);
				
				System.out.println("[�޼���]"+i+"�� Port�� ��� �����մϴ�.");
				
				//ServerSocket.close() : ���� ����� �����ϴ� �޼ҵ�
					//��Ʈ�� �ݾƼ� Ŭ���̾�Ʈ�� ���ӵ��� �ʰ� �ϴ°�.
				serverSocket.close();
			} catch (IOException e) {
				System.out.println("[����]"+i+"�� Port�� �̹� ������Դϴ�.");
			}
		}
		
		
	}
}
