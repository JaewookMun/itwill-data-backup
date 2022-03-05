package xyz.itwill.util;

import java.util.Random;
import java.util.UUID;

//새로운 비밀번호를 제공하는 프로그램
	//웹사이트에서 비밀번호를 찾을 때 임시비밀번호를 제공하기 위해 사용될 수 있음.
public class NewPasswordApp {
	//새로운 비밀번호를 반환하는 메소드
	public static String newPasswordOne() {  //think : 복합적인 비밀번호를 만들기에는 이게 더 유리. str에 특수문자를 추가할 수 있음.
		Random random=new Random();	//think: 임시비밀번호 생성
		
		//비밀번호로 사용될 문자들을 저장한 문자열 생성
		String str="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		String newPassword="";	
		for(int i=1; i<=10; i++) {
			newPassword+=str.charAt(random.nextInt(str.length()));
		}
		return newPassword;
	}
	
	public static String newPasswordTwo() {
		//java.util.UUID : 범용적으로 사용되는 고유값을 생성하여 제공하기 위한 클래스
		//UUID.randomUUID() : 고유값이 저장된 UUID 인스턴스를 반환하는 메소드
		//=> 고유값 : 숫자와 알파벳(소문자), -(4개)의 36개 문자들로 구성된 문자열
		//UUID.toString() : UUID인스턴스에 저장된 고유값을 문자열(String)로 반환하는 메소드
		
		return UUID.randomUUID().toString().replace("-", "").substring(0,10).toUpperCase();
	}
	
	
	public static void main(String[] args) {
		System.out.println("임시비밀번호-1 = "+newPasswordOne());
		System.out.println("임시비밀번호-2 = "+newPasswordTwo());
		
	}
}
