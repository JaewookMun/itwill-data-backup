package xyz.itwill.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//키보드로 생년월일을 입력받아 오늘까지 살아온 날짜(일)을 계산하여 출력하는 프로그램을 작성하세요
//ex) 생년월일 입력[ex.2000-01-01] >> 2021-05-16
//    [결과]태어난지 1일 지났습니다.
//=> 형식에 맞지 않는 생년월일을 입력한 경우 에러 메세지 출력 후 프로그램 종료
public class DayCalculateApp {
	
	public static String transToDate(long millisecond) {
		millisecond /= 1000;
		long result = millisecond/86400; // 86,400 = 60*60*24
		
		return "[결과]태어난지 "+result+"일 지났습니다.";
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date birthDay=null;
		long liveTime;
		
		/**
		 * 형식에 맞지 않은 경우 프로그램을 종료시키라고 했는데
		 * 제대로 읽지 않고 while구문을 사용... 
		 */
		
		while(true) {
			System.out.print("생년월일 입력[ex.2000-01-01] >> ");
			String input = sc.nextLine().replace(" ", "");
			try {
				birthDay = dateformat.parse(input);
			} catch (ParseException e) {
				System.out.println("[에러] 형식에 맞추어 생년월일을 입력해주세요");
				continue;
			}
			break;		
		}
		sc.close();
		
		//굳이 메소드를 따로 만들지 않고 여기서 계산하는 것이 좀더 깔끔
		liveTime= System.currentTimeMillis()-birthDay.getTime();
		
		System.out.println(transToDate(liveTime));
		
		
	}
}
