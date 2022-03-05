package xyz.itwill.util;

import java.util.Random;

//java.util.Random : 난수 관련 기능을 제공하는 클래스
	//Random - 게임에 가장 많이 사용된다고 생각할 수 있다.
public class RandomApp {
	public static void main(String[] args) {
		Random random = new Random();
			//seed값이 같으면 계속 동일한 난수가 발생. -> 인자에 아무것도 안넣어야 동일한 난수가 발생하지 않는다.
			//시간에 따라 seed값이 바뀌는 효과 발생. (=같은 난수 발생x)
		
		for(int i=1; i<=5; i++) {
			//Random.nextInt(int bound) : 0~bound-1 범위의 정수난수를 발생하여 반환하는 메소드
			System.out.println(i+"번째 정수난수 = "+random.nextInt(100));// 0~99
		}
		
	}
}
