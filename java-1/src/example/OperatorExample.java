package example;

public class OperatorExample {
	public static void main(String[] args) {
		//245678초를 일시분초 형식으로 변환하여 출력하세요.	- 'D-day' program만들 떄 사용
		
		int defaultCount = 245678;
		int day = defaultCount/(60*60*24); 
		int hours = defaultCount%(60*60*24)/(60*60);
		int minutes = (defaultCount%(60*60*24))%(60*60)/60;
		int seconds = ((defaultCount%(60*60*24))%(60*60))%60;
		
		System.out.println("245678초는 "+day+"일 "+hours+"시 "+minutes+"분 "+seconds+"초 입니다.");

		
		/* 			<< 강사님 풀이 : 복합대입연산자 활용 >>
		 * e.g.
		 * defaultCount %= 86400			
		 * defaultCount %= 3600;
		 * 하루는 86400초 (60*60*24)
		 */
		
		
		System.out.println("===============================================");
		//한대의 가격이 1억 5천원만인 비행기를 20대 구매할 경우 지불해야될 금액을 계산하여 
		//출력하세요. 
		//단, 15대 이상 구매할 경우 1대당 25%의 할인율을 적용하여 계산하세요. 
		
		int pricePerPlane = 150_000_000, buyNumber = 20;
		double salesRate = 0.25;
		long totalPrice = (long)pricePerPlane*buyNumber;
		
		System.out.println("할인율을 적용하여 계산된 총 지불금액: "+ (buyNumber>=15?(long)(totalPrice*(1-salesRate)):(totalPrice)));
		
		/*			<< 강사님 풀이 >>
		 * 개당 가격 변수를 int 형 자료형으로 만듬.
		 * 1억5천은 21억 미만이기 때문에 long으로 잡으면 불필요한 메모리를 할당하게 된다. -> int 형
		 * 지불금액변수에 삼항연산자처리를 해서 대입을함.
		 * 할인율을 (1-0.25)를 계산하심 
		 */
		
		
		System.out.println("===============================================");
	}
}
