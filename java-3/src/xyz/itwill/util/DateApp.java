package xyz.itwill.util;

import java.util.Date;

//java.util.Date : 날짜와 시간정보를 저장하기 위한 클래스
public class DateApp {
	public static void main(String[] args) {
		
		//Date 클래스의 매개변수가 없는 생성자로 인스턴스를 생성하면 시스템의 현재 날짜와
		//시간정보가 인스턴스에 저장
		Date now = new Date();
		
		//Date.toString() : Date 인스턴스에 저장된 날짜와 시간정보를 문자열로 변환하여 반환하는 메소드
		//System.out.println("now.toString() = "+now.toString());
		System.out.println("now = "+now); //toString() 메소드 자동호출
		
		String[] day= {"일","월","화","수","목","금","토"};
		@SuppressWarnings("deprecation")
		String printDate=(now.getYear()+1900+"년 "+(now.getMonth()+1)+"월 "+now.getDate()+"일 "+day[now.getDay()]+"요일");
		
		System.out.println("현재 = "+printDate);
		
		//Date.getTime() : Date 인스턴스에 저장된 날짜와 시간정보를 long 타입의 정수값
		//(TimeStamp)으로 변환하여 반환하는 메소드
		//타임스탬프(TimeStamp) : 1970년 1월 1일부터 1ms마다 1씩 증가된 정수값    (millisecond)
		//=> 날짜와 시간정보를 정수값으로 표현하여 연산하기 위해 사용
			//특정한 시간을 정수값으로 표현하기 위해 만들어짐
		//long nowTime=now.getTime();
		//System.currentTimeMillis(); : 시스템의 현재 날짜와 시간정보에 대한 타임 스탬프를 반환하는 메소드 
		long nowTime=System.currentTimeMillis();
		System.out.println("nowTime = "+nowTime);

		@SuppressWarnings("deprecation")
		Date wantDate = new Date(100, 0, 1);//2000년 1월 1일 0시 0분 0초
		System.out.println("wantDate = "+wantDate);
		
		long wantTime=wantDate.getTime();
		System.out.println("연산결과(초) = "+(nowTime-wantTime)/1000);
	}
}
