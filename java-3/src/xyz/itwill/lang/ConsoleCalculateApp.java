package xyz.itwill.lang;

import java.util.Scanner;

//키보드로 연산식을 입력받아 연산결과를 출력하는 프로그램을 작성하세요
//ex) 연산식 입력 >> 20 + 10
//    [결과] 30
//=> 입력 연산식에서 사용 가능한 연산자는 사칙 연산자(*,/,+,-)만 허용
//=> 형식에 맞지 않은 연산식이 입력된 경우 에러 메세지 출력 후 프로그램 종료
//=> 입력 연산식에 공백이 입력 가능 하도록 처리
	//magic number => 임의로 정의한 상수 (indexOf() = -1)
public class ConsoleCalculateApp {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String input = "";
		int result=0;
		//String[] values;
		
		while(true) {
			System.out.print("연산식 입력 >> ");
			input = sc.nextLine().replace(" ", "");
			
			if(input.indexOf("-")!=-1 || input.indexOf("+")!=-1 || input.indexOf("*")!=-1 || input.indexOf("/")!=-1) break;
			System.out.println("[에러] 형식에 맞는 연산식을 입력해주세요");
		}
		sc.close();
		
		/**사용할 연산자들을 저장할 배열 선언
		 * String[] operatorArray = {"+","-","*","/"};
		 * 
		 * for문을 사용하여 연산식에 연산자를 검색하여 연산자의 시작위치를 반환받아 저장
		 * indexOf(String s)가 아니라 lastIndexOf(String s)를 사용
		 * indexOf()는 음수의 연산을 못하기 때문에 > e.g.) -20+10
		 * 
		 * 
		 * - 연산식에 연산자가 없거나 연산자의 위치가 잘못된 경우 프로그램을 종료.
		 *  if(연산자가 맨앞에 있거나 맨뒤에 입력되었을 경우)
		 *  
		 * - try~catch 구문 사용(parseInt()는 NumberFormatException 발생 가능하기 때문에.
		 *   연산식에서 연산자와 피 연산자를 분리하여 저장
		 *   e.g.) num1, operator, num2로 각각 저장
		 *   
		 */
		
		/*
		if(input.indexOf("-")!=-1) values = input.split("-");
		if(input.indexOf("+")!=-1) values = input.split("+");
		if(input.indexOf("*")!=-1) values = input.split("*");
		if(input.indexOf("/")!=-1) values = input.split("/");
		*/
		
		if(input.indexOf("-")!=-1) {
			result = Integer.parseInt(input.substring(0, input.indexOf("-"))) - Integer.parseInt(input.substring(input.indexOf("-")+1));
		}
		if(input.indexOf("+")!=-1) {
			result = Integer.parseInt(input.substring(0, input.indexOf("+"))) + Integer.parseInt(input.substring(input.indexOf("+")+1));
		}
		if(input.indexOf("*")!=-1) {
			result = Integer.parseInt(input.substring(0, input.indexOf("*"))) * Integer.parseInt(input.substring(input.indexOf("*")+1));
		}
		if(input.indexOf("/")!=-1) {
			result = Integer.parseInt(input.substring(0, input.indexOf("-"))) / Integer.parseInt(input.substring(input.indexOf("/")+1));
		}
		
		System.out.println(result);

	}
}
