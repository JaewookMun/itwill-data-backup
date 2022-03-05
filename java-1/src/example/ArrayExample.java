package example;
// 동일한 자료형의 값을 여러개 저장할 수 있도록 하는 방법 - 배열
// c.f.) 변수는 한개밖에 안됨.

// B반은 한자리 건너앉기자리에 앉아서 하면 됨.
public class ArrayExample {
	public static void main(String[] args) {
		//사람들의 나이를 저장한 배열 선언 (10대부터 60대까지)
		int[] age= {27,16,22,36,57,60,43,23,14,29,44,52,69,51,39,33,11};
		//배열에 저장된 사람들의 평균 나이를 계산하여 출력하세요.
		//ex) 평균 나이 = 36살
		int sum=0;
		
		// 변형된 for문 사용하심.
		for(int i=0; i<age.length; i++) {
			sum+=age[i];
		}
		int avgAge = sum/age.length;
		System.out.println("평균 나이 = "+avgAge);
		
		
		System.out.println("=================================================");
		//배열에 저장된 사람들의 나이를 연령별로 구분하여 인원수를 계산해서 출력하세요
		//ex) 10대 = 3명
		//	  20대 = 4명
		//    ...
		//    60대 = 2명
		
		/*			<< 풀이 - 여러개 >> 
		 * 1. 향상된 for문 (if-문) e.g. 'if(nai>=10 && nai<20) ten10++;'
		 *    비슷하지만 마지막 출력부분이 살짝 다름.
		 * 결과를 만드는 것은 당연하다. 가독성이 좋고 나중에 쉽게 고칠 수 있는 것이 좋은 프로그램이다.
		 * 2. int 변수 6개를 만드는 것이 아니라 처음부터 요소를 6개 갖는 배열을 만듬.
		 * 배열을 사용하는 목적 => 일괄처리를 통해 한번에 처리
		 * 3. 배열 & 향상된 for문 사용
		 * 4(final). 비교 없이 한문장으로 표현.
		 *   >> index내 숫자는 연산해도 된다.
		 */
		int ten1=0, ten2=0, ten3=0, ten4=0, ten5=0, ten6=0;
		
		// case number에서 number는 몫이다.
		// 나이를 비교하지 않아도 값을 얻을 수 있다. (값비교)
		for(int i=0; i<age.length; i++) {
			switch(age[i]/10) {
			case 1:	ten1++;	break;
			case 2:	ten2++; break;
			case 3: ten3++; break;
			case 4: ten4++; break;
			case 5: ten5++; break;
			case 6: ten6++; break;
			}
		}
		
		int[] result = new int[] {ten1, ten2, ten3, ten4, ten5, ten6};
		
		for(int i=0; i<6; i++) {
			System.out.println((i+1)+"0대 = "+result[i]+"명");
		}
		
		
		
		
		System.out.println("=================================================");
	}
}
