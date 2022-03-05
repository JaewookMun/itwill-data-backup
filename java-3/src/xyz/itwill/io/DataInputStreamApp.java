package xyz.itwill.io;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

	//Object 입출력 스트림을 더 많이 사용
public class DataInputStreamApp {
	public static void main(String[] args) throws IOException {
		//DataInputStream : InputStream 인스턴스를 전달받아 원시 데이터를 원하는 자료형의
		//값으로 변환하여 반환하는 기능을 제공하는 입력 스트림을 생성하기 위한 확장 클래스
		DataInputStream in = new DataInputStream(new FileInputStream("c:/data/data.txt"));
		
		//반드시 파일에 저장된 순서대로 값을 읽어 사용
		//=> 파일에 저장된 값을 읽기 위한 메소드 호출 시 EOFException 발생
		//=> EOFExcception : 입력 메소드 호출 시 파일 커서가 EOF 위치에 존재할 경우 발생되는 예외
		
		//DataInputStream.readInt() : 입력 스트림의 원시 데이터를 읽어 정수값으로 변환하여 반환하는 메소드
		int value1=in.readInt();
		
		//DataInputStream.readBoolean() : 입력 스트림의 원시 데이터를 논리값으로 변환하여 반환하는 메소드
		boolean value2 = in.readBoolean();
		
		//DataInputStream.readUTF() : 입력 스트림의 원시 데이터를 문자열로 변환하여 반환하는 메소드
			//문자열 맨 끝에는 null값이 존재하며 이것까지 다 읽어들인다.
		String value3=in.readUTF();
		
		in.close();
		
		System.out.println("value1 = "+value1);
		System.out.println("value2 = "+value2);
		System.out.println("value3 = "+value3);
		
	}
}
