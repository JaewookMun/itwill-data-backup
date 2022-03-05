package xyz.itwill.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//파일 저장값을 원시 데이타로 입력받아 모니터에 전달하여 저장하는 프로그램
public class FileByteLoadApp {
	public static void main(String[] args) throws IOException {
		//FileInputStream : 파일에 저장된 값을 원시 데이터로 읽는 입력 스트림을 생성하기 위한 클래스
		//=> 전달받은 파일경로에 파일이 없는 경우 FileNotFoundException 발생 - 예외처리(필수)
			//파일이 없으면 입력스트림이 만들어지지 않는다. try~catch문을 통해 예외처리 필수
			//변수를 try문에서 선언하면 다시 사용할 수 없기 때문에 외부에서 선언 (지역변수 문제)
			//출력은 선택. 떠넘겨도 됨.
		FileInputStream in=null;
		try {
			in=new FileInputStream("c:\\data\\byte.txt");
			
			System.out.println("[메세지]c:\\data\\byte.txt 파일에 저장된 내용입니다.");
			int readByte;
			while(true) {
				//파일 입력 스트림을 이용하여 파일 저장값을 원시 데이터로 읽어 반환받아 변수에 저장
				readByte=in.read();
				//파일의 마지막에는 EOF(End Of File)가 반드시 존재
					//직접 입력해야하는 콘솔과 달리 파일에는 눈에 보이지 않지만 다 EOF 가 존재. 
				if(readByte == -1) break;
				System.out.write(readByte);
			}
		} catch (FileNotFoundException e) {
			System.out.println("[에러]대상 파일을 찾을 수 없습니다.");
		} finally {
			//FinleInputStream.close() : 파일 입력 스트림을 제거하는 메소드
			//파일 입력 스트림은 finally 영역에서 제거하는 것을 권장
			//=> 예외 발생 유무와 상관없이 파일 입력 스트림 제거
			//if 구문을 이용하여 NullPointerException 발생 방지
				//try문에 작성하면 실행 안될 수 있기 때문에 finally 문에 작성하는 것을 권장(기본)
				//스트림을 만들어주는 명령 이전에 에러가 발생하면 in=null 상태이기 때문에 if문 사용
				//즉, if문을 활용하여 in이 null이 아닐 떄 close() 사용
			if(in!=null) in.close();
		}
		
		//파일 저장값을 메모리에 저장하는 행위 = load
		//메모리에 있는 값을 파일에 저장하는 행위 = save
	}
}
