package xyz.itwill.net;

import java.io.IOException;
import java.io.ObjectOutputStream;
//import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

//접속 클라이언트에게 서버 컴퓨터의 날짜와 시간정보를 전달하는 서버 프로그램
//=> NTP(Network Time Protocol) Server : 날짜와 시간정보를 제공하는 컴퓨터
public class TimeServerApp {
	public static void main(String[] args) {
		ServerSocket ntpServer = null;
		
		try {
			//ServerSocket 인스턴스 생성 - 서버 동작
				//클라이언트가 접속할 수 있도록 포트를 활성화시킨다고 생각하면 됨.
			ntpServer = new ServerSocket(3000);
			System.out.println("[메세지]NTP Server Running...");
			
			//서버 프로그램은 다수의 클라이언트 접속을 허용하기 위해 무한루프를 이용하여 처리
				//만일 while문을 사용하지 않으면 접속할 수 있는 클라이언트는 단 하나이다.
			while(true) {
				//ServerSocket.accept() : 클라이언트의 접속을 기다리는 메소드
				//=> 클라이언트 접속 전까지 스레드 일시 중지
				//=> 클라이언트가 접속되면 클라이언트의 소켓과 연결될 Socket 인스턴스를 생성하여 반환하고 스레드가 실행
				//=> 현재 접속중인 클라이언트 수만큼 Socket 인스턴스 생성
					//스레드 일시중지는 System.in의 read()메소드를 참고할수 있을것으로 생각된다.
					//인스턴스 생성 - fort 생성
					//accept()는 준비완료를 의미
					//서버의 소켓 수는 클라이언트 수와 같다.
				Socket socket=ntpServer.accept();

				/*
				//Socket.getOutputStream() : Socket 인스턴스의 출력스트림(OutputStream 인스턴스)을 반환하는 메소드
				//=> 접속된 원격 컴퓨터에 원시 데이터를 전달하는 출력 스트림
					//socket이 가지고 있는 메소드 중 가장 중요
					//소켓과 소켓이 연결되면 자동적으로 스트림이 생성된다.
				OutputStream out =socket.getOutputStream();
				
				//Socket 인스턴스의 출력 스트림을 전달받아 객체를 전달할 수 있는 출력스트림
				//(ObjectOutputStream 인스턴스)로 확장
				ObjectOutputStream stream = new ObjectOutputStream(out);
				
				//클라이언트에게 전달할 날짜와 시간정보가 저장된 Date 인스턴스 생성
				Date date = new Date();
				
				//시스템의 날짜와 시간정보가 저장된 Date 인스턴스를 출력 스트림으로 전달
				//=> 클라이언트에게 Date 인스턴스 전달
				stream.writeObject(date);
				*/
					//불필요한 참조변수가 많기에 이를 한줄로 정리.
				new ObjectOutputStream(socket.getOutputStream()).writeObject(new Date());
				
				//로그(Log) 출력
					//프로그램(특히 네트워크)에서 '기록'은 굉장히 중요. - 로그라고 표현
					//서버측에서 기록하는 것. 중요
				System.out.println("[로그]클라이언트["+socket.getInetAddress().getHostAddress()+"]에게 날짜와 시간정보를 제공 하였습니다.");
				
				//소켓 제거 - 접속 종료
					//서버측에서 종료 (제공할 데이터를 모두 제공했기 때문에...)
				socket.close();
			}
			
		} catch (IOException e) {	//포트충돌 or 네트워크 등 문제가 발생할 수 있기 대문에 예외처리
			System.out.println("[에러]서버에 네트워크 문제가 발생 하였습니다.");
		}
	}
}
