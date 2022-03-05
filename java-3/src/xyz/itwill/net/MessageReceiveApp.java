package xyz.itwill.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

//접속 컴퓨터에서 보내온 메세지를 전달받아 출력하는 UDP 기반의 네트워크 프로그램
	//UDP는 신뢰할수 없지만 데이터를 받아서 곧바로 활용가능 - TCP처럼 접속하는 행위는 없다.
	//TCP기반으로 네트워크를 구성하는 것이 일반적이다.
public class MessageReceiveApp {
	public static void main(String[] args) throws IOException {
		//DatagramSocket(int port) 생성자로 데이터를 전달받기 위한 소켓 생성
		//=> 다른 컴퓨터의 접속 허용
		DatagramSocket socket=new DatagramSocket(5000);
		
		//전달받을 데이터를 저장하기 위한 byte 배열 선언
		byte[] data = new byte[1024];
		
		//접속 컴퓨터에서 보내온 패킷을 저장하기 위한 DatagramPacket 인스턴스 생성
		//=> DatagramPacket(byte[] buf, int length) 생성자 이용
			//받을 때는 IP주소와 port 없음
		DatagramPacket packet = new DatagramPacket(data,data.length);
		
		System.out.println("메세지 수신 중...");
		//DatagramSocket.receive(DatagramPacket packet) : 접속 컴퓨터에서 보내온 패킷을 저장하는 메소드
		//=> 패킷을 받기 전까지 스레드 일시 중지
		socket.receive(packet);
		
		//DatagramPacket 인스턴스에 저장된 byte 배열을 String 인스턴스로 변환하여 저장
		String message=new String(data);
		
		System.out.println("[결과]메세지 = "+message);
		
		socket.close();
	}
}
