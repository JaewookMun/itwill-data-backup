package inheritance;

//학원 인적자원(학생, 강사, 직원) 관리 프로그램
public class AcademyApp {
	public static void main(String[] args) {
		/*
		//학생정보를 저장하기 위한 요소들이 존재하는 배열 선언
		AcademyStudent[] students = new AcademyStudent[300];
		
		//강사정보를 저장하기 위한 요소들이 존재하는 배열 선언
		AcademyInstructor[] instructors = new AcademyInstructor[50];
		
		//직원정보를 저장하기 위한 요소들이 존재하는 배열 선언
		AcademyStaff[] staffs = new AcademyStaff[100];
		*/
		
		//학원 인적자원정보(학생,강사,직원)을 저장하기 위한 요소들이 존재하는 배열 선언
			//AcademyPerson으로 만들어진 인스턴스를 저장하는 배열을 선언 (자식 인스턴스들을 다 저장할 수 있기때문에)
			//부모를 통해 자식정보는 참조할 수 없지만 객체형변환을 통해서 자식정보를 참조할 수 있다.
		AcademyPerson[] persons=new AcademyPerson[5];
		
		//부모 클래스로 생성된 배열의 요소에 자식 클래스의 생성자로 인스턴스를 생성하여 저장
		//=> 자식 클래스의 생성자를 이용하면 상속관계의 부모 인스턴스와 자식 인스턴스가 생성
		//=> 배열 요소에는 부모 인스턴스가 저장되어 참조 가능
		//=> 객체 형변환을 이용하여 자식 인스턴스 참조 가능 
			//부모클래스로 참조변수를 만들어주면 모든 자식들을 확인할 수 있기 때문에 좀더 쉽게 관리할 수 있다.
		persons[0]=new AcademyStudent(1000, "홍길동", "웹 개발자 과정");
		persons[1]=new AcademyInstructor(2000, "임꺽정", "Java 프로그래밍");
		persons[2]=new AcademyStaff(3000, "전우치", "영업팀");
		persons[3]=new AcademyStudent(4000, "일지매", "웹 디자인 과정");
		persons[4]=new AcademyStaff(5000, "장길산", "경영회계팀");
		
		for(AcademyPerson person:persons) {
			//instanceof : 클래스의 상속관계를 구분하기위한 연산자
			//형식) 부모참조변수 instanceof 자식클래스
			//=> 참조변수에 저장된 부모 인스턴스와 상속관계로 설정된 자식 인스턴스의 클래스인
			//   경우 true를 제공하고 아닌 경우 false 제공
			//=> 명시적 객체 형변환 전에 사용하는 연산자 - ClassCastException 발생 방지
			if(person instanceof AcademyStudent) {
			//오버라이드 선언되지 않은 메소드는 명시적 객체 형변환 후 자식 인스턴스의 메소드 호출 가능
			//=> 상속 관계가 아닌 클래스로 명시적 객체 형변환을 할 경우 ClassCastException 발생
				//오버라이드 되었기 때문에 자동 형변환가능.
			System.out.println(((AcademyStudent)person).getCourse()+"수강정보 >> ");
			} else if (person instanceof AcademyInstructor) {
				System.out.println(((AcademyInstructor)person).getSubject()+"강의정보 >> ");
			} else if (person instanceof AcademyStaff) {
				System.out.println(((AcademyStaff)person).getDepart()+"부서정보 >> ");
			}
			//오버라이드 선언된 메소드를 호출하면 묵시적 객체 형변화에 의해 부모 인스턴스의
			//메소드 대신 자식 인스턴스의 메소드 호출
			//묵시적 객체 형변환은 부모 인스턴스와 상속 관계로 설정된 자식 인스턴스의
			//클래스로 자동 형변환되어 자식 인스턴스의 메소드가 호출
			//=> 메소드 오버라이드에 의한 다형성 - 자식 인스턴스에 따라 메소드 선택 호출
			person.display();
			System.out.println("==================================================================");
		}
		
	}
}
