package xyz.itwill.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

//키보드로 정수값 2개를 입력받아 나눈 몺을 출력하는 프로그램 작성
public class CalcApp {
	public CalcApp() throws InputMismatchException, ArithmeticException {
		Scanner scanner=new Scanner(System.in);
			//예외를 전달시켜서 (모아서) 나중에 한꺼번에 처리하는 효과 발생
		
		System.out.print("첫번째 정수 입력 >>");
		//Scanner.nextInt() : 입력값을 정수값으로 변환하여 반환하는 메소드
		//=> 입력값이 정수값으로 변환되지 못할 경우 InputMissMatchException 발생
		int num1=scanner.nextInt();

		System.out.print("두번째 정수 입력 >>");
		int num2=scanner.nextInt();
		
		//0으로 나눈 경우 ArithmeticException 발생
		System.out.println("[결과]"+num1+"/"+num2+" = " + (num1/num2));
		
		scanner.close();
	}
	
	public static void main(String[] args) {
		/*
		try {
			//생성자를 이용하여 인스턴스 생성 >> 생성자의 명령 실행
			new CalcApp();	//생성자를 이용하여 인스턴스 생성 >> 생성자의 명령 실행
		} catch (InputMismatchException e) {
			System.out.println("[에러]정수만 입력 가능합니다.");
		} catch (ArithmeticException e) {
			System.out.println("[에러]0으로 나눌 수 없습니다.");
		} catch (Exception e) {
			//Exception : 모든 예외 클래스의 부모 클래스
			//=> 모든 예외를 전달받아 예외 처리 - 맨 마지막에.
			System.out.println("[에러]프로그램에 예기치 못한 오류가 발생 되었습니다.");
		}
		*/
		
		try {
			new CalcApp();
		} catch (InputMismatchException | ArithmeticException e) {
			//JDK7 이상에서는 예외 클래스를 |연산자로 연결하여 예외처리 가능
			System.out.println("[에러]형식에 맞게 값을 입력해 주세요.");
		} catch (Exception e) {
			System.out.println("[에러]프로그램에 예기치 못한 오류가 발생 되었습니다.");
		}
		
	}
}
