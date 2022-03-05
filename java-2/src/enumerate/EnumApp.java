package enumerate;

public class EnumApp {
	public static void main(String[] args) {
		//나열형에 선언된 상수필드 출력 -> 상수필드명 출력
		//=> 나열형의 상수필드는 고유값(대표값)으로 사용 가능
		//=> 상수필드값 대신 의미 있는 문자열 출력
			//내부적으로는 0,1,2,3으로 저장되지만 출력시 상수필드명으로 출력된다.
		System.out.println("삽입 = "+EnumOne.INSERT);
		System.out.println("변경 = "+EnumOne.UPDATE);
		System.out.println("삭제 = "+EnumOne.DELETE);
		System.out.println("검색 = "+EnumOne.SELECT);
		System.out.println("===============================================================");
		System.out.println("삽입 = "+EnumTwo.ADD);
		System.out.println("변경 = "+EnumTwo.MODIFY);
		System.out.println("삭제 = "+EnumTwo.REMOVE);
		System.out.println("검색 = "+EnumTwo.SEARCH);
		System.out.println("===============================================================");
		//상수필드의 자료형과 동일한 자료형의 변수에 상수필드 저장 불가능
		//=> 나열형의 상수필드는 선언된 자료형(Enum Type)의 변수에만 저장 가능
		//int choice = EnumOne.INSERT;
		
		//나열형(EnumType)으로 변수 선언
		//=> 변수의 자료형과 같은 나열형(EnumType)의 상수필드만 저장 가능
		//=> 상수필드가 선언된 나열형은 자료형의 의미가 부여된다.
		EnumOne choice = EnumOne.INSERT;
		System.out.println("choice = "+choice);
		System.out.println("===============================================================");
		//나열형의 변수는 변수의 자료형(나열형)의 상수필드만 비교 가능
		switch(choice) {
		case INSERT:
			System.out.println("# 학생정보를 저장합니다.");
			break;
		case UPDATE:
			System.out.println("# 학생정보를 변경합니다.");
			break;
		case DELETE:
			System.out.println("# 학생정보를 삭제합니다.");
			break;
		case SELECT:
			System.out.println("# 학생정보를 검색합니다.");
			break;
		}
	}
}
