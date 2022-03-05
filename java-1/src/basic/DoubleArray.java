package basic;

public class DoubleArray {
	public static void main(String[] args) {
		int[][] num = new int[2][3];
		
		// 8,9,10은 해시코드가 출력된다.
		System.out.println("num ="+num);		// 참조변수
		System.out.println("num[0] ="+num[0]);	// 참조요소
		System.out.println("num[1] ="+num[1]);	// 참조요소
		// 사용할땐 값을 갖고있는 요소를 읽어야한다.
		System.out.println("=============================================");
		System.out.println("num[0][0] = "+num[0][0]);	// 값을 저장한 요소
		System.out.println("num[0][1] = "+num[0][1]);
		System.out.println("num[0][2] = "+num[0][2]);
		
		System.out.println("num[1][0] = "+num[1][0]);
		System.out.println("num[1][1] = "+num[1][1]);
		System.out.println("num[1][2] = "+num[1][2]);
		System.out.println("=============================================");
		System.out.println("num.length = "+num.length);
		System.out.println("num[0].length = "+num[0].length);
		System.out.println("num[1].length = "+num[1].length);
		System.out.println("=============================================");
		
		for(int i=0; i<num.length; i++) { //행 1차원 배열의 갯수만큼 반복
			for(int j=0; j<num[i].length; j++) {// 요소의 갯수만큼 반복
				System.out.print(num[i][j] +"\t");
			}
			System.out.println();
		}
		System.out.println("=============================================");
		// 원하는 값 출력
		// int[][] su = new int[][] {{10, 20, 30}, {40, 50, 60}, {70, 80, 90}}; // heap
		int[][] su = {{10, 20, 30}, {40, 50, 60}, {70, 80, 90}}; // static
		
		for(int[] array:su) {// 1차원 배열을 제공받아 참조변수에 저장하여 반복처리
			for(int temp:array) {// 요소값을 제공받아 변수에 저장하여 반복처리
				System.out.print(temp+"\t");
			}
			System.out.println();
		}
		System.out.println("================================================");
		// 1차원 배열이 없는 2차원 배열 생성 (1차원 배열 요소의 개수를 정의하지 않았음)
		// 1차원 배열 정보를 저장할 수 있는 참조요소만 생성
		int[][] number = new int[3][];
		
		// 1차원 배열이 없으므로 2차원 배열의 참조요소에는 자동으로 null 저장.
		// => 참조형은 기본값이 null이기 때문에...
		System.out.println("number[0] = "+number[0]);
		System.out.println("number[1] = "+number[1]);
		System.out.println("number[2] = "+number[2]);
		
		//1차원 배열이 없는 경우 요소를 표현하면 예외 발생
		// => NullPointerException 발생 - NULL이 저장된 참조요소를 이용하여 참조할 경우 발생
		//System.out.println("number[0][0] = "+number[0][0]);
	
		//2차원 배열의 참조요소에 1차원 배열을 생성하여 배열정보저장
		// => 1차원 배열의 요소의 갯수를 다르게 생성하여 저장 - 가변배열 (4차원에서 나옴.)
		// => 쓸모없는 요소를 만드는것을 방지하기 위해 사용하는 방식이나 불편해서 잘 안쓰인다.
		// 자바에서는 사용할 일이 크게 없음.
		number[0]=new int[3];
		number[1]=new int[2];
		number[2]=new int[4];
		
		/* 위에서 참조요소들에 1차원 배열을 생성하여 배열정보를 저장하고 난 후 아래 코드들을 실행하면 해시코드(메모리주소)가 출력된다.
		System.out.println("number[0] = "+number[0]);
		System.out.println("number[1] = "+number[1]);
		System.out.println("number[2] = "+number[2]);
		*/
		
		number[0][0]=10;
		number[0][1]=20;
		number[0][2]=30;
		
		number[1][0]=40;
		number[1][1]=50;
		
		number[2][0]=60;
		number[2][1]=70;
		number[2][2]=80;
		number[2][3]=90;
		
		// 위처럼 만드는 것보다는 아래처럼 만드는 것이 더 낫다. 이것도 가변배열
		int[][] towArray= {{10,20,30}, {40,50}, {60,70,80,90}};
		System.out.println(towArray);
		System.out.println(towArray[0]);
	}
}
