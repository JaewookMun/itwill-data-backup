package oop;

import java.util.Arrays;

//배열의 요소값을 오름차순 정렬하여 출력하는 프로그램을 작성하세요
public class ArraySortApp {
	public static void main(String[] args) {
		// 요소값들을 차례로 다시 저장하여 출력.
		int[] array = {30,50,10,40,20};
		
		/*	<자바스럽지 않다.>
		System.out.print("정렬 전 >> ");
		for(int num: array) {
			System.out.print(num+" ");
		}
		System.out.println();

		// 아래 알고리즘을 이용한 방식 => 절차지향 프로그램
		//배열의 요소값들을 선택 정렬 알고리즘을 이용하여 오름차순 정렬처리 (Selection Sort Algorithm)
		// >> 요소들을 서로 비교해야함.
		// 반복문, 조건문 등을 활용하여 프로그램을 흐름을 관리
		for(int i=0; i<array.length-1; i++) { //비교요소의 첨자
			for(int j=i+1; j<array.length; j++) { //피비교 요소의 첨자 : 비교+1 ~ 마지막까지.
				//요소값을 비교하여 요소에 저장된 값을 서로 치환
				if(array[i]>array[j]) {
					int temp=array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		
		System.out.print("정렬 후 >> ");
		for(int num: array) {
			System.out.print(num+" ");
		}
		System.out.println();
		*/
		
		// <자바스럽게 변경 - 객체지향>
		System.out.print("정렬 전 >> ");
		//Arrays : 배열에 대한 다양한 기능(메소드)을 제공하는 클래스
		//Arrays.toString(Object[] array) : 배열정보를 전달받아 요소값을 문자열로
		//변환하여 반환하는 메소드
		System.out.println(Arrays.toString(array));
		
		//Arrays.sort(Object[] array) : 배열 정보를 전달받아 배열의 요소값을 정렬하는 메소드
		Arrays.sort(array);
		
		System.out.print("정렬 후 >> ");
		// 원래는 클래스가 가지고 있는 요소를 사용하려면 인스턴스를 만들어줘야함.
		System.out.println(Arrays.toString(array));
		
		// Jdk를 다운받으면 자바개발을 위한 클래스들을 library로 받을 수 있다. 
		// 컴파일된 클래스 파일(jar)들이 빌드되어있다.
		// Library가 연결되어있다면(빌드) 소스를 작성할 때 클래스를 활용할 수 있다.
		// 자바는 클래스가 가지고 있는 메소드를 호출해서 어떻게 사용할 지가 중요 (흐름)
		// 시스템엔지니어가 배포한 자료를 가져다 라이브러리에 넣어서 가져다 쓰면된다.
		// 자바는 만드는 것이 아니라 클래스가 갖고있는 메소드를 잘 가져다 쓰면 된다.
		// 자바는 복잡한 제어문이 필요없음. 클래스를 만들어 객체를 통해 잘 가져오는 것이 중요.
		// 절차지향 - flow chart	/ 객체지향 - diagram  을 이용해서 프로그램 설계
	}
}
