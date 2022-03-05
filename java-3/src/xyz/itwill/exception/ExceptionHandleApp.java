package xyz.itwill.exception;

public class ExceptionHandleApp {
	public static void main(String[] args) {
		int[] array= {10,20,30,40,50};
			//모든 명령을 try안에 넣는 것은 권장하지 않는다. catch()가 계속 대기해야하기 때문에
			//실행속도가 느려진다. try안에는 예외가 발생할 가능성이 있는 명령을 작성.
		
		//예외가 발생 가능한 명령을 try 영역에 작성
		//=> 예외가 발생될 경우 예외 관련 인스턴스 생성 
		//=> catch 구문에서 예외 인스턴스를 전달받아 예외 처리
		try {
			//배열 요소 표현시 첨자를 잘못 사용한 경우 ArrayIndexOutOfBoundsException 발생
			//=> ArrayIndexOutOfBoundsException이 발생된 경우 JVM에 의해 자동으로 예외 처리
			//=> JVM의 예외처리는 예외가 발생된 경로를 상세하게 표현하여 출력 - 개발자 중심
			//=> 사용자 중심의 프로그램을 만들기 위해 직접 예외 처리하는 것을 권장

				//ArrayIndexOutOfBoundsException는 RuntimeException 클래스를 상속
				//문법적으로 오류가 없기 때문에 컴파일러는 잘못되었는지 인지하지 못함.
			for(int i=0; i<=array.length; i++) {
				System.out.println("array["+i+"] = "+array[i]);
			}
			
			//예외가 발생된 명령 하단에 존재하는 명령은 미실행
			//=> 예외가 발생되면 catch 구문으로 스레드(프로그램의 실행 흐름) 이동
			System.out.println("[메세지]프로그램이 정상적으로 실행 되었습니다.");
		} catch (ArrayIndexOutOfBoundsException e) {//예외 인스턴스를 전달받아 참조변수에 저장
			//catch 영역에 설정된 예외 클래스에 대한 예외 처리 명령 작성 - 메세지 출력
			//System.out.println("[에러]프로그램 실행에 예기치 못한 오류가 발생되었습니다.");
				// -> 사용자 중심
			
			//Throwable.getMssage() : 예외 인스턴스의 오류 메세지를 반환하는 메소드
			//System.out.println("예외 메세지 = "+e.getMessage());
				// -> 개발자 중심
			
			//Throwable.printStackTrace() : 예외가 발생된 경로를 상세하게 표현하여 출력하는 메소드 
				//JVM이 호출해서 사용하는 예외처리 메세지
			e.printStackTrace();
		} finally {
			//예외와 상관없이 무조건 실행될 명령을 작성하는 영역 : 생략 가능
			//=> 자원에 대한 제거 명령을 구현할 경우 사용
				//e.g. Scanner class의 close() 메소드
			System.out.println("[메세지]무조건 실행되는 명령");
		}
	}
}
