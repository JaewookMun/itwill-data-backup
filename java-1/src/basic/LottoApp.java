package basic;


//1~45 범위의 중복되지 않는 정수난수 6개를 제공받아 오름차순 정렬하여 출력하는 프로그램을 작성하여 출력하세요
//정렬(Sort) : 값을 순서대로 나열하는 기능
// => 오름차순 정렬(Ascending Sort), 내림차순 정렬(Descending Sort)
// 자료구조개론과 같은 책을 보면 알고리즘이 설명됨. (정렬과 같은 방법)
// 알고리즘공부 -> 자료구조개론부터 시작
// 절차지향프로그램언어는 이론적인 내용이 필요하나 OOP는 크게 필요치는 않다.
// 클래스를 활용하면 알고리즘은 크게 필요치 않음.
public class LottoApp {
	public static void main(String[] args) {
		// 6개의 정수난수를 저장하기 위한 배열 선언
		int[] lotto = new int[6];
		
		for(int i=0; i<lotto.length; i++) {//새로운 난수값이 저장되는 요소의 첨자를 표현
			//요소에 저장된 새로운 난수값을 기존 요소의 난수값과 비교하여 모두 다른 경우
			//반복문 종료 - 기존 요소의 난수값과 같은 경우 반복처리
			//-> 요소에 저장되는 난수들의 중복성을 제거하기위해서
			while(true) {
				//요소에 새로운 정수난수를 제공받아 저장
				lotto[i] = (int)(Math.random()*100)%45+1;
				
				//중복 상태정보를 저장하기 위한 변수
				// => false : 미중복, true : 중복
				// 중복성을 회피하는 방법은 여러가지가있음 (가장 간단한 방법 사용)
				boolean result=false;
				
				//기존 요소들의 난수값과 비교하는 반복문
				for(int j=0; j<i;j++) { //기존 요소의 첨자를 표현
					//lotto[i] : 새로운 난수값이 저장된 요소
					//lotto[j] : 기존 난수값이 저장된 요소
					if(lotto[i]==lotto[j]) {
						result=true;
						break;
					}
				}
				
				if(!result) break; //while 구문 종료
			}
		}
		
		//배열의 요소값들을 서로 비교하여 오름차순 정렬하여 저장
		// => 선택 정렬 알고리즘(Selection Sort Algorithm) 이용
		// 장점: 데이터의 개수가 적을 때 정렬 처리속도가 빠름
		//      이해하기 쉬움
		// 요소 끼리 비교했을 때 비교되는 수보다 크기가 더 크면 오른쪽으로 위치를 바꿔준다.
		for(int i=0; i<lotto.length-1;i++) {	//비교 요소의 첨자 : 처음부터 마지막-1
			for(int j=i+1; j<lotto.length; j++) { //피비교 요소의 첨자 : 비교+1 ~ 마지막
				//lotto[i] : 비교 요소, lotto[j] : 피비교 요소
				if(lotto[i]>lotto[j]) { //오름차순 정렬
					//두 요소의 값을 치환(Swap)
					int temp=lotto[i];
					lotto[i]=lotto[j];
					lotto[j]=temp;
				}
			}
		}
		
		
		
		//배열요소값 출력
		System.out.println("행운의 숫자>> ");
		for(int num:lotto) {
			System.out.print(num+" ");
		}
		System.out.println();
		
		/*
		 * 배열의 데이터 처리관련 알고리즘은 굉장히 많다.
		 * 첫번째 문제 : 값의 중복
		 * 두번째 문제 : 오름차순 정렬
		 */
		System.out.println("=======================================================");
	}
}
