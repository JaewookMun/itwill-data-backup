package xyz.itwill.app;

import java.util.Date;
import java.util.Scanner;

//키보드로 이름과 태어난 년도를 입력받아 이름과 나이를 출력하는 프로그램을 작성하세요
//ex> 이름 입력 >> 홍길동
//    태어난 년도 입력 >> 2000
//    [결과]홍길동님의 나이는 22살입니다.
public class CalcAgeApp {
	public static void main(String[] args) {
		//키보드 입력값을 제공받기 위한 Scanner 인스턴스 생성
		Scanner scanner = new Scanner(System.in);
		
		//키보드로 이름과 태어난 년도를 입력받아 변수에 저장
		System.out.print("이름 입력 >> ");
		String name = scanner.nextLine();
		
		System.out.print("태어난 년도 입력 >> ");
		int birthYear=scanner.nextInt();

		
		//java.util.Date 클래스로 인스턴스 생성
		//=> java.util.Date : 날짜(시간)정보를 저장하기 위한 클래스
		//Date 클래스의 매개변수가 없는 생성자로 인스턴스를 생성하면 시스템(운영체제 - OS)의
		//현재 날짜(시간)정보를 저장한 Date 인스턴스 생성
		Date now = new Date();
		//Date.toString() : Date 인스턴스에 저장된 날짜(시간)정보를 문자열로 변환하여 반환하는 메소드
		//=> 참조변수를 출력할 경우 toString() 메소드 호출생략가능 - 자동 호출
		//System.out.println("now.toString() = "+now.toString());
		//System.out.println("now = "+now);
		
		//Date.getYear() : Date 인스턴스의 저장된 값 중 년도를 반환하는 메소드
		//=> 1900년부터 1씩 증가된 정수값 반환 -> 1900을 더해야 올바른 년도로 표현
		//=> @Deprecated 어노테이션이 적용된 메소드
		//@Deprecated : 메소드 사용을 권장하지 않도록 설정하는 어노테이션(Annotation)
		//=> @Deprecated 어노테이션이 적용된 메소드 호출시 경고 발생
		//@SuppressWarnings : 경고를 제거하는 어노테이션
		//=> 어노테이션의 value 속성에 제거할 경고 속성값을 설정하여 제거
		//=> 다른 어노테이션 속성이 없는 경우 속성값만 설정 가능
		@SuppressWarnings("deprecation")
		int currentYear=now.getYear()+1900;
		
		//나이를 계산하여 변수에 저장
		//int age=2021-birthYear+1;
		int age=currentYear-birthYear+1;
		//결과 출력
		System.out.println("[결과]"+name+"님의 나이는 "+age+"입니다.");
		
		scanner.close();
	}
}
