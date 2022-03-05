package xyz.itwill.net;

import java.io.IOException;
import java.net.ServerSocket;

//ServerSocket : TCP 기반의 네트워크 프로그램에서 서버를 구현하기 위한 클래스
//=> 클라이언트가 접속하기 위한 특정 Port를 활성화하여 인스턴스 생성
//=> 클라이언트가 서버에 접속된 후 연결된 클라이언트와 데이터 전달 가능

//서버(Server) : 다른 컴퓨터가 접속할 수 있는 환경을 제공하는 컴퓨터(시스템)
//클라이언트(Client) : 서버에 접속하는 컴퓨터(시스템)
	//remote computer & local computer

//ServerSocket 클래스로 사용가능한 Port 번호를 검색하는 프로그램
	//멀티미디어를 제외한 프로그램은 일반적으로 TCP를 기반으로 제작한다.
public class ServerSocketApp {
	public static void main(String[] args) {
		for(int i=445; i<=9000; i+=1000) {
			try {
				//ServerSocket(int port) : Port 번호를 전달받아 ServerSocket 인스턴스를 생성하는 생성자
				//=> 전달된 Port 번호를 다른 네트워크 프로그램에서 사용중인 경우 IOException 발생
					//포트를 열어서 클라이언트가 접속할 수 있는 환경을 만드는 것.
				ServerSocket serverSocket = new ServerSocket(i);
				
				System.out.println("[메세지]"+i+"번 Port는 사용 가능합니다.");
				
				//ServerSocket.close() : 서버 기능을 제거하는 메소드
					//포트를 닫아서 클라이언트가 접속되지 않게 하는것.
				serverSocket.close();
			} catch (IOException e) {
				System.out.println("[에러]"+i+"번 Port는 이미 사용중입니다.");
			}
		}
		
		
	}
}
