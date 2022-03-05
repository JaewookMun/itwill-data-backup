package xyz.itwill.io;

import java.io.FileOutputStream;
import java.io.IOException;

//키보드 입력값을 원시 데이타로 입력받아 파일에 전달하여 저장하는 프로그램
//=> EOF(End Of File : 입력 종료 - Ctrl+Z) 신호를 전달하면 프로그램 종료
public class FileByteSaveApp {

	public static void main(String[] args) throws IOException {
		System.out.println("[메세지]키보드를 눌러 값을 입력해 주세요.[종료:Ctrl+Z]");
		
		//FileOutputStream : 파일에 원시 데이타를 전달하여 저장하는 출력 스트림을 생성하기 위한 클래스
		//FileOutputStream(String name) : 파일경로를 전달받아 파일 출력 스트림을 생성하는 생성자
		//=> 전달받은 파일경로에 파일이 없는 경우 FileNotFoundException 발생 - 예외처리
			//굳이 try~catch로 예외처리 안해도됨. - 예외처리 안하고떠넘김
		//=> 전달받은 파일경로에 파일이 없는 경우 파일을 자동으로 만들어 출력 스트림을 생성하여 반환
		//=> 전달받은 파일경로에 파일이 있는 경우 기존 파일의 내용 대신 새로운 내용을 전달받아 저장 - 덮어 씌우기(OverWrite)
			// 파일의 커서위치가 첫위치에 있기 때문
		//FileOutputStream out = new FileOutputStream("C:\\data\\byte.txt");

		//FileOutputStream(String name, boolean append) : 파일경로와 논리값을 전달받아 파일
		//출력 스트림을 생성하는 생성자
		//=> false : 기존 내용 덮어쓰기(기본), true : 기존 내용 이어쓰기
		FileOutputStream out = new FileOutputStream("C:\\data\\byte.txt", true);
		
		int readByte;
		while(true) {
			//키보드 입력 스트림의 값을 원시 데이터로 읽어 변수에 저장
			//FileNotFoundException 클래스는 IOException 클래스의 자식 클래스
			readByte=System.in.read();
			
			if(readByte==-1) break;
			//원시 데이터가 저장된 변수값을 파일 출력 스트림에 전달 - 파일 저장
			out.write(readByte);
			
		}
		//FileOutputStream.close() : 파일 출력 스트림을 제거하는 메소드
		//=> 파일에는 입력 스트림과 출력 스트림을 각각 하나만 생성 가능
		//=> 파일 처리를 위해 생성된 스트림은 사용 후 반드시 제거
			//스트림이 제거가 안되면 다른 프로그램에서 해당 파일에 대해서 출력스트림을 만들 수 없다.
			//스트림을 하나밖에 못만들기 때문에 파일은 여러사람이 동시에 접속하지 못한다. (다중사용자환경의 프로그램 불가능)
			//문법적 에러는 발생하지 않으나 다른 프로그램에서 사용시 문제가 발생할 수 있음
		out.close();
		
		System.out.println("[메세지]C:\\data\\byte.txt 파일에 키보드 입력값이 저장 되었습니다.");
		
		
		
		
	}
}
