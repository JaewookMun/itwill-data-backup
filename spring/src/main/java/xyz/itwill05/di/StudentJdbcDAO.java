package xyz.itwill05.di;

import java.util.List;

	// 비즈니스 클래스를 생성할 때는 인터페이스를 만들어서 결합도를 낮추는 것이 좋다.
// DAO 클래스 : 저장매체(File, DBMS 등)에 행에 대한 삽입, 변경, 삭제, 검색 기능을 제공하는 클래스
// => 저장매체의 종류 또는 방법에 따라 Service 클래스가 사용할 DAO 클래스 변경 가능
// => DAO 클래스가 변경되어도 Service 클래스의 영향을 최소화 하기 위해 인터페이스를 상속받아 작성
	// 인터페이스 없이 스프링 컨테이너만으로 클래스간의 결합도를 낮출 수 없다.
	// 처음 만들 때 유지보수를 신경쓰지 않으면 인터페이스없이 생성하는 경우가 많음.
	// refactor -> Extract Interface 를 통해 클래스에서 인터페이스를 뽑아낼 수 있다.   > 자동으로 implements 됨.

	// 인터페이스를 상속받으면 내부구조가 동일, 인터페이스가 대표 자료형이 된다.
	// 필드나 참조변수의 자료형을 인터페이스로 사용
public class StudentJdbcDAO implements StudentDAO {
	
	public StudentJdbcDAO() {
		System.out.println("### StudentJdbcDAO 클래스의 기본 생성자 호출 ###");
	}
	
	@Override
	public int insertStudent(Student student) {
		System.out.println("*** StudentJdbcDAO 클래스의 insertStudent(Student student) 메소드 호출");
		return 0;
	}
	@Override
	public int updateStudent(Student student) {
		System.out.println("*** StudentJdbcDAO 클래스의 updateStudent(Student student) 메소드 호출");
		return 0;
	}
	@Override
	public int deleteStudent(int num) {
		System.out.println("*** StudentJdbcDAO 클래스의 deleteStudent(int num) 메소드 호출");
		return 0;
	}
	@Override
	public Student selectStudent(int num) {
		System.out.println("*** StudentJdbcDAO 클래스의 selectStudent(int num) 메소드 호출");
		return null;
	}

	@Override
	public List<Student> selectStudentList() {
		System.out.println("*** StudentJdbcDAO 클래스의 selectStudent() 메소드 호출");
		return null;
	}
}