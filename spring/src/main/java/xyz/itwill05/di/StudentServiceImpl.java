package xyz.itwill05.di;

import java.util.List;

// Service 클래스 : 프로그램 실행에 필요한 기능을 제공하기 위한 클래스 - 컴퍼넌트(모듈)
// => DAO 클래스의 메소드를 호출하여 프로그램 실행에 필요한 기능을 메소드로 제공
// => Service 클래스의 메소드는 DAO 클래스의 메소드를 호출하여 프로그램 실행에 필요한 기능을 제공
// => Service 클래스가 변경되어도 프로그램에 영향을 최소화 하기 위해 인터페이스를 상속받아 작성
	// 나중에 test를 진행할 때 이 클래스를 테스트
public class StudentServiceImpl implements StudentService {
	/*
	// StudentJdbcDAO 객체를 필드에 저장해야 포함관계 성립
	// => Constructor 또는 Setter 메소드를 이용하여 객체를 전달받아 필드에 저장
		// 선언만 하면 null로 설정되어 있음. 객체를 저장해야 관계가 설정된다.
	//private StudentJdbcDAO studentJdbcDAO;
	
	// 필드의 자료형이나 이름이 변경된 경우 필드 관련 생성자와 메소드를 모두 변경
	private StudentMybatisDAO studentJdbcDAO;
	
	public StudentServiceImpl() {
		System.out.println("### StudentServiceImpl 클래스의 기본 생성자 호출 ###");
	}
	
	public StudentServiceImpl(StudentJdbcDAO studentJdbcDAO) {
		System.out.println("### StudentServiceImpl 클래스의 매개변수가 선언된 생성자 호출 ###");
		this.studentJdbcDAO = studentJdbcDAO;
	}
	

	public StudentJdbcDAO getStudentJdbcDAO() {
		return studentJdbcDAO;
	}

	public void setStudentJdbcDAO(StudentJdbcDAO studentJdbcDAO) {
		this.studentJdbcDAO = studentJdbcDAO;
		System.out.println("*** StudentServiceImple 클래스의 setStudentJdbcDAO() 메소드 호출");
	}

	@Override
	public void addStudent(Student student) {
		System.out.println("*** StudentServiceImple 클래스의 addStudent() 메소드 호출");
		studentJdbcDAO.insertStudent(student);
	}

	@Override
	public void modifyStudent(Student student) {
		System.out.println("*** StudentServiceImple 클래스의 modifyStudent() 메소드 호출");
		studentJdbcDAO.updateStudent(student);
	}

	@Override
	public void removeStudent(int num) {
		System.out.println("*** StudentServiceImple 클래스의 removeStudent() 메소드 호출");
		studentJdbcDAO.deleteStudent(num);
	}

	@Override
	public Student getStudent(int num) {
		System.out.println("*** StudentServiceImple 클래스의 getStudent() 메소드 호출");
		return studentJdbcDAO.selectStudent(num);
	}

	@Override
	public List<Student> getStudentList() {
		System.out.println("*** StudentServiceImple 클래스의 getStudentList() 메소드 호출");
		return studentJdbcDAO.selectStudentList();
	}
	*/
	
	// DAO 클래스의 부모 인터페이스를 이용하여 필드를 선언하면 필드에는 모든 자식 클래스로
	// 생성된 객체를 전달받아 저장 - 의존관계
	// => 인터페이스 필드로 메소드를 호출하면 필드에 저장된 자식클래스 객체의 메소드 호출 - 오버라이드에 의한 다형성
	// => 객체간의 결합도를 낮추어 유지보수의 효율성 증가 - 자식클래스의 객체가 변경되도 클래스에 미치는 영향을 최소화
		// 인터페이스를 필드로 활용하여 클래스간의 결합도를 낮추어 유지보수의 편의성을 증대시킬 수 있다.
		// 참조변수를 부모 or 인터페이스로 만드는 이유
	private StudentDAO studentDAO;

	
	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	public StudentServiceImpl() {
		System.out.println("### StudentServiceImpl 클래스의 기본 생성자 호출 ###");
	}
	
	public StudentServiceImpl(StudentDAO studentDAO) {
		System.out.println("### StudentServiceImpl 클래스의 매개변수가 선언된 생성자 호출 ###");
		this.studentDAO = studentDAO;
	}
	
	@Override
	public void addStudent(Student student) {
		System.out.println("*** StudentServiceImple 클래스의 addStudent() 메소드 호출");
		studentDAO.insertStudent(student);
	}

	@Override
	public void modifyStudent(Student student) {
		System.out.println("*** StudentServiceImple 클래스의 modifyStudent() 메소드 호출");
		studentDAO.updateStudent(student);
	}

	@Override
	public void removeStudent(int num) {
		System.out.println("*** StudentServiceImple 클래스의 removeStudent() 메소드 호출");
		studentDAO.deleteStudent(num);
	}

	@Override
	public Student getStudent(int num) {
		System.out.println("*** StudentServiceImple 클래스의 getStudent() 메소드 호출");
		return studentDAO.selectStudent(num);
	}

	@Override
	public List<Student> getStudentList() {
		System.out.println("*** StudentServiceImple 클래스의 getStudentList() 메소드 호출");
		return studentDAO.selectStudentList();
	}
}
