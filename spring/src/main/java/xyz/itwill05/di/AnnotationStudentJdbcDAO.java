package xyz.itwill05.di;

import java.util.List;

import org.springframework.stereotype.Repository;

// @Component : 클래스를 Spring Bean으로 등록하기 위한 어노테이션
// => 기본적으로 클래스명을 beanName으로 설정하며 value 속성을 사용하여 beanName 변경 가능
	// Component 어노테이션이 spring bean으로 등록하는 가장 기본적인 어노테이션 
	// transaction manager를 사용 못한다.
// @Component(value = "studentDAO")

// @Repository : DAO 클래스를 Spring Bean으로 등록하기 위한 어노테이션
// => 기본적으로 클래스명을 beanName으로 설정하며 value 속성을 사용하여 beanName 변경 가능
	// Component와 달리 트랜젝션 매니저를 통해 트랜잭션 관리를 할 수 있다. (commit, rollback 등)
	// DAO 클래스를 Spring Bean으로 등록할 때는 트랜젝션 매니저를 이용하기 위해 repository 어노테이션 사용
	// Repository ~ DAO 클래스
// @Repository("studentDAO")
@Repository
public class AnnotationStudentJdbcDAO implements StudentDAO {
	public AnnotationStudentJdbcDAO() {
		System.out.println("### AnnotationStudentJdbcDAO 클래스의 기본 생성자 호출 ###");
	}
	
	@Override
	public int insertStudent(Student student) {
		System.out.println("*** AnnotationStudentJdbcDAO 클래스의 insertStudent(Student student) 메소드 호출 ***");
		return 0;
	}

	@Override
	public int updateStudent(Student student) {
		System.out.println("*** AnnotationStudentJdbcDAO 클래스의 updateStudent(Student student) 메소드 호출 ***");
		return 0;
	}

	@Override
	public int deleteStudent(int num) {
		System.out.println("*** AnnotationStudentJdbcDAO 클래스의 deleteStudent(int num) 메소드 호출 ***");
		return 0;
	}

	@Override
	public Student selectStudent(int num) {
		System.out.println("*** AnnotationStudentJdbcDAO 클래스의 selectStudent(int num) 메소드 호출 ***");
		return null;
	}

	@Override
	public List<Student> selectStudentList() {
		System.out.println("*** AnnotationStudentJdbcDAO 클래스의 selectStudentList() 메소드 호출 ***");
		return null;
	}

}
