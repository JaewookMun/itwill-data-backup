package xyz.itwill.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

//NTP 서버에 접속하여 서버에서 보내온 날짜와 시간정보를 받아 출력하는 클라이언트 프로그램
public class TimeClientApp {
	public static void main(String[] args) throws ClassNotFoundException {
		try {
			//Socket 인스턴스 생성 - 서버 접속
				//서버의 컴퓨터이름 or IP주소를 입력하여 접속
			Socket socket = new Socket("172.30.1.53", 3000);
			
			//Socket.getInputStream() : Socket 인스턴스의 입력스트림(InputStream 인스턴스)를 반환하는 메소드
			//=> 접속된 원격 컴퓨터에서 보내온 원시 데이터를 받기위한 입력스트림
			InputStream in = socket.getInputStream();
			
			//Socket 인스턴스의 입력 스트림을 전달받아 객체를 읽을 수 있는 입력스트림
			//(ObjectInputStream 인스턴스)로 확장
			ObjectInputStream stream = new ObjectInputStream(in);
			
			//서버가 보내온 Date 인스턴스를 반환받아 저장
			Date data=(Date)stream.readObject();
			
			//Date 인스턴스를 원하는 형식의 문자열로 변환하여 출력
			System.out.println("[결과]서버가 제공한 날짜와 시간 = "+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(data));
			
			//접속 종료
			socket.close();
		} catch (IOException e) {
			System.out.println("[에러]서버에 접속할 수 없습니다.");
		}
		
	}
}
