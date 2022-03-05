package xyz.itwill.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

//키보드로 메세지를 입력받아 서버에 접속하여 접속 서버에 메세지를 전달하는 클라이언트 프로그램
public class EchoClientApp {
	public static void main(String[] args) throws IOException {
			//BufferedWriter 보다는 PrintWriter를 더 많이 사용
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("전달 메세지 입력 >> ");
		String message = in.readLine();
		
		try {
			//서버 접속
			Socket socket=new Socket(InetAddress.getLocalHost().getHostAddress(), 4000);
			
			//소켓의 출력 스트림을 반환받아 문자열을 전달할 수 있도록 확장
			/*
			BufferedWriter out=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			out.write(message);
				//buffer에 다 모아서 보내려는 성질이 있기 때문에 flush를 사용해야함.
			out.flush();
			*/
			
			PrintWriter out = new PrintWriter(socket.getOutputStream());
				//println() 메소드를 사용 가능
				//어떤 값을 가져오더라도 문자열로 보낼 수 있다.
			out.println(message);
			out.flush();
			
			socket.close();
		} catch (IOException e) {
			System.out.println("[에러]서버에 접속할 수 없습니다.");
		}
		
	}
}
