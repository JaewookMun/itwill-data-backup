package xyz.itwill.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

//파일 저장값을 원시 데이타로 입력받아 모니터에 전달하여 저장하는 프로그램
public class FileCharLoadApp {
	public static void main(String[] args) throws IOException {
		//FileReader : 파일에 저장된 값을 인코딩 처리된 문자 데이터로 읽는 입력 스트림을 생성
		FileReader in = null;
		
		try {
			//FileReader(String name) : 파일경로를 전달받아 파일 입력 스트림을 생성하는 생성자
			//=> 전달받은 파일경로에 파일이 없는 경우 FileNotFoundException 발생 - 예외처리(필수)
			in = new FileReader("c:\\data\\char.txt");
			
			//모니터의 인코딩 처리된 문자 데이터를 전달하는 출력 스트림 생성 - 확장
			OutputStreamWriter out = new OutputStreamWriter(System.out);
			
			int readByte;
			while(true) {
				readByte=in.read();
				if(readByte==-1) break;
				out.write(readByte);
					//모니터에 보낼때는 한번에 모아서 보내려는 성질이 있어서 flush() 사용 권장?
				out.flush();
			}
		} catch (FileNotFoundException e) {
			System.out.println("[에러]대상 파일을 찾을 수 없습니다.");
		} finally {
			if(in!=null) in.close();
		}
		
		
	}
}
