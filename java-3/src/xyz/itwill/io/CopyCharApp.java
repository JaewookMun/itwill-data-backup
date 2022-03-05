package xyz.itwill.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//원본파일에 저장된 값을 인코딩 처리된 문자 데이터로 읽어 대상파일에 전달하여 저장하는 프로그램
//=> 원본파일을 인코딩 처리하여 대상파일로 전달하므로 정상적인 복사 불가능
//=> 텍스트 파일만 복사 가능
	//원본파일의 데이터를 하나하나 읽어서 전달해야 하는데 2개씩 묶어 전달하기 때문에
	//문자데이터로 전달 받아 원본데이터가 깨진다.
	//이미지, 음악, 동영상, 실행파일 등 모두 복사 불가능. 
	//-> 파일입출력을 위해서는 FileInputStream과 FileOutputStream을 사용해야함.
	//텍스트파일만 제어할 때 Reader & Writer 사용
public class CopyCharApp {
	public static void main(String[] args) throws IOException {
		//BufferedReader : Reader 인스턴스를 전달받아 대량의 인코딩 처리된 문자 데이터를 얻어
		//오는 기능을 제공하는 입력 스트림을 생성하기 위한 확장 클래스
		BufferedReader in = null;

		//BufferedWriter : Writer 인스턴스를 전달받아 대량의 인코딩 처리된 문자 데이터를 전달
		//하는 기능을 제공하는 출력 스트림을 생성하기 위한 확장 클래스		
		BufferedWriter out = null;
		
		try {
			//in=new BufferedReader(new FileReader("c:/data/zoom.txt"));
			//out=new BufferedWriter(new FileWriter("c:/data/zoom_byte.txt"));
			
				//복사된 대상 파일이 제대로 동작하지 않는다. (인코딩처리 때문에)
			in=new BufferedReader(new FileReader("c:/data/zip.exe"));
			out=new BufferedWriter(new FileWriter("c:/data/zip_byte.exe"));
			
			int readByte;
			while(true) {
				readByte=in.read();
				if(readByte==-1) break;
				
				out.write(readByte);
			}
			System.out.println("[메세지]파일을 성공적으로 복사 하였습니다.");
		} catch (Exception e) {
			System.out.println("[에러]원본 파일을 찾을 수 없습니다.");
		} finally {
			if(in != null) in.close();
			if(out != null) out.close();
		}
		
	}
}
