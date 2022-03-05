package xyz.itwill.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

//InetAddress : ��Ʈ��ũ ����(IP Address�� HostName)�� �����ϱ� ���� Ŭ����
	//HostName : IP address��� ����� �� �ִ� ��ǻ�� �̸�(���ڿ��� ����)
public class InetAddressApp {

	public static void main(String[] args) throws UnknownHostException {
		//InetAddress.getLocalHost() : ���� ��ǻ���� ��Ʈ��ũ ������ InetAddress �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
		//=> UnknownHostException �߻� : HostName�� ��ǻ�͸� �˻��� �� ���� ��� �߻��Ǵ� ����
		//=> ���� ��ǻ�Ϳ��� [127.0.0.1]�� IP Address�� [localhost]�� HostName�� �ڵ� ����
			//[127.0.0.1] : ������ IP�ּ� ��� �Ҹ� (- Q: ������ǻ���� ip�ּҸ� ȣ��?)
		InetAddress myComputer = InetAddress.getLocalHost();
		//InetAdderess.toString() : InetAddress �ν��Ͻ��� ����� ��Ʈ��ũ ������ ���ڿ���
		//��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ� - �������� ��½� �ڵ� ȣ��Ǵ� �޼ҵ�
			//IP������ ȣ��Ʈ����
		System.out.println("myComputer = "+myComputer);
		
		//InetAddress.getHostName() : InetAddress �ν��Ͻ��� ����� ��Ʈ��ũ ���� ��
		//��ǻ�͸��� ���ڿ��� ��ȯ�ϴ� �޼ҵ�
		System.out.println("myComputer = "+myComputer.getHostName());
		
		//InetAddress.getHostAddress() : InetAddress �ν��Ͻ��� ����� ��Ʈ��ũ ���� ��
		//IP �ּҸ� ���ڿ��� ��ȯ�ϴ� �޼ҵ�
			//��Ʈ��ũ���� �߿��Ѱ��� IP�ּҰ� �߿���
			//���� ��Ʈ��ũ �׷쿡���� HostName���� ������ �� ������
			//�ٸ� �׷쿡���� HostName���� ������ �� ����. 
		System.out.println("myComputer = "+myComputer.getHostAddress());
		System.out.println("=========================================================");
		//InetAddress.getByName(String host) : ���޹��� ��ǻ���̸��� ���� ��Ʈ��ũ ������
		//����� InetAddress �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
			//ȣ��Ʈ�̸��� �����ؼ� �ش� ȣ��Ʈ����(��ǻ��)�� ���� ������ �����ϴ� �ν��Ͻ��� ��ȯ�Ѵ�.
		InetAddress itwill=InetAddress.getByName("www.itwill.xyz");
			//������ ������ �� IP�ּҸ� ���� �����ϴ� ���� ����
		System.out.println("[www.itwill.xyz]�� IP�ּ� = "+itwill.getHostAddress());
		System.out.println("=========================================================");
			//��Ż���� ��� �л�ó���� ���� ���� �̸��� ��ǻ�Ͱ� ������ �ִ�. - �����̸��� ��ǻ�� ������ ���� ����(�л�ó��)
			//�ϳ��� �޴� ���� �ƴ϶� �Ʒ�ó�� getAllByName�� Ȱ���Ͽ� ȣ��Ʈ���ӿ� �Ҵ�� IP�ּҸ� ��´�.
		//InetAddress.getAllByName(String host) : ���޹��� ��ǻ�͸� ���� ��� ��Ʈ��ũ 
		//������ ����� InetAddress �ν��Ͻ� �迭�� ��ȯ�ϴ� �޼ҵ�
			//cmd�� nslookup ��ɾ�� ����
			//Host������ ������ IP�ּҴ� �ٸ��� �����ؾ��Ѵ�. (�ټ��� ��ǻ�͸� �ϳ��� ��ǻ��ó�� ��� ��)
		InetAddress[] daum=InetAddress.getAllByName("www.daum.net");
		
		for(InetAddress address:daum) {
			System.out.println("[www.daum.net]�� IP�ּ� = "+address.getHostAddress());
		}
		System.out.println("=========================================================");
		
		
	}
}
