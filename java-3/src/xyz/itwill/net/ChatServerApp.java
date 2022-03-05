package xyz.itwill.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

//채팅 서버 프로그램 - 다중 스레드
//=> 클라이언트가 보내온 메세지를 전달받아 접속된 모든 클라이언트에게 전달하는 기능
//=> 클라이언트와 연결된 소켓은 새로운 스레드를 생성하여 독립적으로 동작되도록 구현
	//main()스레드 외 소켓의 갯수만큼 스레드가 생성되어야 한다. - 접속된 클라이언트의 수만큼 생성
public class ChatServerApp {
	//접속 클라이언트의 소켓과 연결된 모든 소켓정보를 저장하기 위한 콜렉션 필드
	private List<SocketThread> clientList;
	
	public ChatServerApp() {
		ServerSocket chatServer=null;
		try {
			chatServer = new ServerSocket(6000);
			System.out.println("[메세지]채팅 서버 동작 중...");
						clientList = new ArrayList<SocketThread>();
			
			while(true) {
				try {
					Socket client = chatServer.accept();
					
					System.out.println("[접속로그]"+client.getInetAddress().getHostAddress()
							+"의 컴퓨터에서 접속 하였습니다.");
					
					//클라이언트의 소켓과 연결된 소켓정보를 저장한 SocketThread 인스턴스 생성
						//SocketThread에는 소켓정보와 입출력시스템이 저장되어있다.
					SocketThread socketThread=new SocketThread(client);
					
					//콜렉션 필드의 요소에 소켓정보(SocketThread 인스턴스)를 추가
					clientList.add(socketThread);
					
					//SocketThread 인스턴스로 새로운 스레드를 생성하여 run() 메소드의 명령 실행
					socketThread.start();
				} catch (IOException e) {
						//클라이언트가 접속종료시
					System.out.println("[에러로그]클라이언트의 접속 관련 문제가 발생 되었습니다.");
				}
				
			}
		} catch (IOException e) {
				//port 충돌시
			System.out.println("[에러로그]서버가 정상적으로 동작되지 않습니다.");
		}
	}
	
	public static void main(String[] args) {	//main은 static이기 때문에 
		new ChatServerApp();
	}	// main()는 클라이언트 관련 기록만 해주면됨. 입출력기능은 새로운 스레드를 통해 구현
	
	
	//메세지를 전달받아 현재 접속중인 모든 클라이언트에게 메세지를 전달하는 메소드
	public void sendMessage(String message) {
		//콜렉션 필드에 저장된 SocketThread 인스턴스를 제공받아 일괄 처리
		for(SocketThread socketThread : clientList) {
			//클라이언트와 연결된 출력 스트림을 이용하여 메세지 전달
			socketThread.out.println(message);
		}
	}
	
	
	
	//클라이언트와 연결된 소켓을 이용하여 입출력 기능을 제공하기 위한 클래스
	//=> 독립적인 입력과 출력 기능을 제공하기 위해 새로운 스레드를 생성하여 동작되도록 구현
		//입출력 스트림 생성
	public class SocketThread extends Thread {
		//클라이언트의 소켓과 연결된 소켓정보를 저장하기 위한 필드
		private Socket socket;
		
		//클라이언트가 보내온 메세지를 전달받을 입력 스트림을 저장하기 위한 필드
		private BufferedReader in;
		
		//클라이언트에게 메세지를 전달할 출력 스트림을 저장하기 위한 필드
		private PrintWriter out;
		
		public SocketThread(Socket socket) {
			this.socket=socket;
		}
		
		//새로운 스레드가 실행하기 위한 명령 작성
		//=> 클라이언트의 메세지를 전달받아 모든 접속 클라이언트에게 전달하는 기능
		@Override
		public void run() {
			String aliasName=null;//클라이언트의 대화명을 저장하기 위한 변수
			
			try {
				//소켓의 입력 스트림을 제공받아 문자열로 읽을 수 있는 스트림으로 확장하여 필드에 저장
				in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				
				//소켓의 출력 스트림을 제공받아 문자열로 전달할 수 있는 스트림으로 확장하여 필드에 저장
				//out=new PrintWriter(socket.getOutputStream()); //출력 버퍼를 이용
					//출력버퍼를 이용하면 일정크기에 도달하지 않으면 전송되지 않는다.
				//PrintWriter(outputStream out, boolean autoFlush)
				//=> autoFlush 매개변수에 true를 전달하면 출력 버퍼를 사용하지 않고 전달하는 기능 제공
					//true를 넣으면 flush() 메소드를 사용하지 않아도 된다.
				out=new PrintWriter(socket.getOutputStream(), true);
				
				//클라이언트에서 보내온 대화명을 입력 스트림으로 반환받아 저장
					//입력스트림에 읽을 수 있는 데이터가 없으면 스레드는 일시 중지된다.
				aliasName=in.readLine();
				
				//현재 접속된 모든 클라이언트에게 입장 메세지를 전달
					//클라이언트들의 소켓정보가 모두 기록된 저장매체가 필요함.
				sendMessage("["+aliasName+"]님이 입장 하였습니다.");
				//out.flush();
				
				//클라이언트에서 보내온 메세지를 전달받아 현재 접속중인 모든 클라이언트에게 전달
				//=> 클라이언트가 접속을 종료하기 전까지 반복 처리
				//=> 클라이언트가 접속을 종료하면 입력과 출력 스트림이 제거되므로 IOException 발생
				while(true) {
					sendMessage("["+aliasName+"]"+in.readLine());
				}
				
			} catch (IOException e) {
				//클라이언트가 접속을 종료하면 실행될 명령 작성
				//=> 콜렉션 필드에서 현재 접속된 클라이언트와 연결된 소켓정보 제거
				//=> 현재 접속중인 모든 클라이언트에게 퇴장 메세지를 전달
				clientList.remove(this);
				sendMessage("["+aliasName+"]님이 퇴장 하였습니다.");
				
				System.out.println("[해제로그]"+socket.getInetAddress().getHostAddress()
						+"의 컴퓨터에서 접속을 종료 하였습니다.");
			}
		
		}
	}
}
