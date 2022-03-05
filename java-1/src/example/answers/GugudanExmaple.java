package example.answers;

import java.util.Scanner;

//키보드로 정수값을 입력받아 1~9 범위의 정수값을 곱한 결과를 출력하는 프로그램을 작성하세요.
//단,입력된 정수값은 2~9 범위의 정수값만 허용되며 범위 밖의 정수값을 입력한 경우 메세지 출력 후 재입력
//ex) 단 입력[2~9] >> 7
//    7 * 1 = 7
//    7 * 2 = 14
//    ...
//    7 * 8 = 56
//    7 * 9 = 63
public class GugudanExmaple {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		int dan;
		while(true) {
			System.out.print("단 입력[2~9] >> ");
			dan=scanner.nextInt();
			if(dan>=2 && dan<=9) break;//정상적인 입력값인 경우 반복문 종료
			System.out.println("[에러]2~9 범위의 정수값만 입력 가능합니다.");			
		}
		
		for(int i=1;i<=9;i++) {
			System.out.println(dan+" * "+i+" = "+(dan*i));
		}
		
		scanner.close();
	}
}






