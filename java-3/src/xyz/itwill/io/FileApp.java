package xyz.itwill.io;

import java.io.File;
import java.io.IOException;

//File : 파일 정보(파일경로, 파일권한, 파일크기 등)을 저장하기 위한 클래스
//=> 폴더(디렉토리)도 파일로 인식되어 File 클래스로 표현 가능
	//파일은 값을 반 영구적으로 저장하기위해 만든 시스템장치
	//폴더 : 논리적 영역 - 크기가 없다.
	//디렉토리 : 물리적 영역 - 파일처럼 크기를 가지고 있다. - 파일로 인식
	//근본적 정의는 다르지만 같은 개념으로 봐도 무방
public class FileApp {
	public static void main(String[] args) throws IOException {
		//File(String pathname) : 시스템의 파일경로를 전달받아 File 인스턴스를 생성하는 생성자
		//시스템 파일경로(System File Path) : 시스템에 존재하는 파일 위치를 표현하기 위한 방법
		//=> 절대경로 표현방법, 상대경로 표현방법
		//절대경로 : 최상위 디렉토리(드라이브)를 기준으로 파일의 위치를 표현하는 방법
		//상대경로 : 현재 실행 프로그램의 작업 디렉토리를 기준으로 파일의 위치를 표현하는 방법
		//=> 이클립스에서는 프로젝트 디렉토리를 작업디렉토리로 처리
			//default? 작업디렉토리의 최상단은 workspace이기 때문에
			//상대경로가 /project_name/src 로 시작하는것이라 판단됨.
		//Windows 운영체제에서는 디렉토리(드라이브)와 파일을 구분하기 위해 \ 기호 사용
		//=> Java에서는 \ 기호를 Escape 문자를 표현하는 용도로 사용
		//=> \ 기호를 문자로 표현하기 위해서는 \\ 형태로 표현
			//운영체제를 시스템 or 플랫폼이라고 표현
			//\를 한번만 사용하면 제어문자로 인식해서 사용 못함. 두번을 눌러야 된다.
			//디렉토리를 모두 '폴더'로 바꿔서 표기함 (위의 설명에서)
			// 윈도우 : "C:\\data", Mac : "/data"
		File fileOne=new File("C:\\data");
		
		//File.exists() : File 인스턴스에 저장된 파일경로에 파일이 존재하지 않을 경우 false를
		//반환하고 존재하는 경우 true를 반환하는 메소드
		if(fileOne.exists()) {
			System.out.println("C:\\data 폴더가 존재합니다.");
		} else {
			//File.mkdir() : File 인스턴스에 저장된 파일경로에 폴더를 생성하는 메소드
			fileOne.mkdir();
			System.out.println("C:\\data 폴더를 생성하였습니다.");
		}
		System.out.println("=========================================================================");
		//File fileTwo = new File("C:\\data\\abc.txt");
		//Windows 운영체제를 제외한 나머지 운영체제에서는 디렉토리(드라이브)와 파일을 구분하기
		//위해 / 기호 사용 - 파일 경로를 표현할 때 \ 기호 대신 / 기호를 사용하는 것을 권장
			//Java 언어에서는 역슬래시(\) 대신 슬래시(/)를 써도 경로를 표시할 수 있도록 처리됨 - 윈도우에선 역슬래시 \ 가 경로 기본
		File fileTwo = new File("C:/data/abc.txt");
		
		if(fileTwo.exists()) {
			System.out.println("c:\\data\\abc.txt 파일이 존재합니다.");
		} else {
			//File.createNewFile() : File 인스턴스에 저장된 파일경로에 파일을 생성하는 메소드
				//권한문제 때문에 생성하지 못할 경우가 있기 때문에 IOException을 예외처리 해줘야함
			fileTwo.createNewFile();
			System.out.println("C:\\data\\abc.txt 파일을 생성하였습니다.");
		}
		System.out.println("=========================================================================");
		//File fileThree = new File("C:/data/xyz.txt");
		
		//File(File parent, String child) 생성자 또는 File(Stirng parent, String child) 생성자
		//=> 파일경로를 부모(폴더 경로)와 자식(파일명)으로 구분하여 File 인스턴스를 생성하는 생성자
		//File fileThree=new File(fileOne, "xyz.txt");
		File fileThree = new File("c:/data", "xyz.txt");
	
		if(fileThree.exists()) {
			fileThree.delete();
			System.out.println("C:\\data\\xyz.txt 파일을 삭제 하였습니다.");
		}else {
			System.out.println("C:\\data\\xyz.txt 파일이 존재하지 않습니다.");
		}
		System.out.println("=========================================================================");
		//파일경로를 상대경로 표현방법으로 전달하여 File 인스턴스 생성
		//=> 현재 작업 폴더는 기본적으로 프로젝트 폴더로 설정
		//=> [..] 형식으로 상위 폴더를 표현하며 [폴더(파일)] 형식으로 하위 폴더 또는 파일 표시
			//"src" : 현재 작업하고 있는 java-3폴더 아래에 있는 src를 의미
		
		
		File fileFour = new File("src");
		
		if(fileFour.exists()) {
			//File.toString() : File 인스턴스에 저장된 파일경로를 문자열로 변환하여 반환하는 메소드
			//System.out.println("파일 경로 = "+fileFour.toString());
			System.out.println("파일 경로 = "+fileFour);
			
			//File.getAbsolutePath() : File 인스턴스에 저장된 파일경로를 절대경로 표현방식의
			//문자열로 변환하여 반환하는 메소드
				//개발자들은 절대경로를 주로 사용 - 상대경로는 불확실성이 증가할 가능성 존재
			System.out.println("파일 경로 = "+fileFour.getAbsolutePath());
		} else {
			System.out.println("작업 폴더에 src 하위 폴더가 존재하지 않습니다.");
		}
		System.out.println("=========================================================================");
			//윈도우는 저장장치를 표현 , Mac & 리눅스는 디렉토리를 표현
		File fileFive=new File("C:/");
		
		//File.isDirectory() : File 인스턴스에 저장된 파일경로가 폴더가 아닌 경우
		//false를 반환하고 폴더인 경우 true를 반환하는 메소드
		if(fileFive.isDirectory()) {
			//File.listFiles() : File 인스턴스에 저장된 파일경로의 자식 파일 목록을 File
			//인스턴스 배열로 반환하는 메소드
				//폴더를 포함하여 반환
			File[] subFiles = fileFive.listFiles();
			
			System.out.println(fileFive+"폴더의 자식 목록 >>");
			for(File file : subFiles) {
				//File.isFile() : File 인스턴스에 저장된 파일경로가 파일이 아닌 경우
				//false를 반환하고 파일인 경우 true를 반환하는 메소드
				if(file.isFile()) {
					System.out.println("파일 = "+file);
				} else {
					System.out.println("폴더 = "+file);
				}
			}
		}
	}
}
