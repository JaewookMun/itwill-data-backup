package xyz.itwill.io;

import java.io.IOException;
import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
import java.io.PrintWriter;

//Character Stream : 인코딩 처리된 문자 데이터(2Byte)로 전달하기 위한 입력 또는 출력 스트림
//=> Reader 클래스 또는 Writer 클래스를 상속 받은 자식 클래스로 생성된 스트림(인스턴스)

//키보드 입력값을 인코딩 처리된 문자 데이터로 입력받아 모니터에 출력하는 프로그램
//=> EOF(End Of File : 입력 종료 - Ctrl+Z) 신호를 전달하면 프로그램 종료
public class CharacterStreamApp {
	public static void main(String[] args) throws IOException {
		System.out.println("[메세지]키보드를 눌러 값을 입력해 주세요.[종료:Ctrl+Z]");
		
		//InputStreamReader : 인코딩 처리된 문자 데이터를 반환하기 위한 기능을 제공하는 클래스
		//=> InputStream 인스턴스를 전달받아야 입력 스트림 생성 가능 - 확장 스트림
			//매개변수가 없는 생성자가 없음. - input stream이 무조건 필요함.
			//스트림 연결
			//독립스트림은 전달받지 않아도 만들 수 있음.
			//기본적으로 제공하는 키보드 입력스트림(원시데이터)을 문자데이터를 읽어 들일 수 있는
			//스트림으로 확장하여 in 이라는 변수에 이 스트림을 저장하겠다는 의미 
		InputStreamReader in = new InputStreamReader(System.in);
		
			//InputStream, OutputStream은 독립성이 있지만
			//Writer와 Reader는 독립적으로 사용못한다.
		//OutputStreamWriter : 인코딩 처리된 문자 데이타를 전달하기 위한 기능을 제공하는 클래스
		//=> OutputStream 인스턴스를 전달 받아야 출력 스트림 생성 가능 - 확장 스트림
		//OutputStreamWriter out = new OutputStreamWriter(System.out);
		
		//OutputStreamWriter : 인코딩 처리된 문자 데이타를 전달하기 위한 기능을 제공하는 클래스
		//=> 모든 값을 문자 데이터로 변환하여 전달하는 메소드가 추가된 클래스
			//OutputStreamWriter보다 PrintWriter가 메소드를 더 많이 가지고 있다.
			//e.g. print() or println() method
		
		PrintWriter out = new PrintWriter(System.out);
		
		int readByte;
			//키보드로 입력된 스트림 : System.in 이며 이 스트림을 Read()는 원시데이터로 반환
		while(true) {
			//Reader.read() : 입력 스트림에 존재하는 값을 인코딩 처리된 문자 데이터(2Byte)로
			//읽어 반환하는 메소드
				//byte형 데이터를 두개씩 하나로 묶어서 문자로 읽어들임 = 인코딩
			readByte = in.read();
			
			if(readByte == -1) break;
				
				//한글로 입력하면 출력시 깨짐
				//읽어들일 때는 2바이트로 읽어들었으나 출력할 때는 1바이트로 쪼개서 출력 - 글자가 깨져버린다.
			//System.out.write(readByte);
			
			//Writer.write(int b) : 출력 스트림에 인코딩 처리된 문자 데이타를 전달하는 메소드
			//=> 문자 데이터를 일정 크기만큼 출력 버퍼모아서 한번에 출력 스트림에 전달
				//버퍼 : 임시메모리를 의미
				//Writer의 특징
			out.write(readByte);
			
			//Writer.flush() : 출력 버퍼에 저장된 문자 데이타를 출력 스트림으로 전달하는 메소드
				//이걸 안하면 출력을 확인 못함.
			out.flush();
				//1byte로 읽었으면 1byte로 출력, 2byte로 읽었으면 2byte로 출력해야한다.
		}
		
		System.out.println("[메세지]프로그램을 종료합니다.");
		
	}
}
