package xyz.itwill.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//원본파일에 저장된 값을 원시 데이터로 읽어 대상파일에 전달하여 저장하는 프로그램
//=> 모든 파일복사 가능
public class CopyByteApp {
	public static void main(String[] args) throws IOException {
		//BufferedInputStream : InputStream 인스턴스를 전달받아 대량의 원시 데이터를 얻어
		//오는 기능을 제공하는 입력 스트림을 생성하기 위한 확장 클래스
		BufferedInputStream in = null;
		
		//BufferedOutputStream : OutputStream 인스턴스를 전달받아 대량의 원시 데이터를 전달
		//하는 기능을 제공하는 출력 스트림을 생성하기 위한 확장 클래스
		BufferedOutputStream out = null;
			//Buffered 단어가 들어가는 입출력 클래스는 값들을 모아놨다가 한번에 보내거나 받을 수 있다.
			//-> 읽거나 보내는 속도가 빠르다.
		
		try {
			//in=new BufferedInputStream(new FileInputStream("c:/data/zoom.txt"));
			//out=new BufferedOutputStream(new FileOutputStream("c:/data/zoom_byte.txt"));
			
				//text파일 뿐아니라 실행파일(exe; execute)도 읽어들이고 전송할 수 있다. 그림파일 역시가능
				//데이터 변동없이 원시데이터를 그대로 읽어들이기 때문에 파일복사가 제대로 된다.
			in=new BufferedInputStream(new FileInputStream("c:/data/zip.exe"));
			out=new BufferedOutputStream(new FileOutputStream("c:/data/zip_byte.exe"));
			
			
			int readByte;
			while(true) {
				readByte=in.read();
				if(readByte==-1) break;
				
				out.write(readByte);
			}
			System.out.println("[메세지]파일을 성공적으로 복사 하였습니다.");
		} catch (FileNotFoundException e) {
			System.out.println("[에러]원본 파일을 찾을 수 없습니다.");
		} finally {
			if(in != null) in.close();
			if(out != null) out.close();
		}
	}
}
