package xyz.itwill10.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.itwill10.dao.StudentDAO;
import xyz.itwill10.dto.Student;

// Service 클래스 : 프로그램 작성에 필요한 기능을 제공하는 클래스
// => Service 클래스의 메소드는 DAO 클래스의 메소드를 호출하여 기능 구현
	// Controller에서 사용하기 위해 Spring Bean으로 등록되어야 한다.

// @Service : Service 클래스를 Spring Bean으로 등록하는 어노테이션
// => 예외처리 기능을 제공받아 사용
// Spring Container가 어노테이션을 처리하기 위해 Bean Configuration File(servlet-context.xml)에서
// component-scan 엘리먼트를 사용하여 Service 클래스가 작성된 패키지를 지정
	// ExceptionHandler
@Service
public class StudentServiceImpl implements StudentService{
	// DAO 클래스로 등록된 Spring Bean을 필드에 인젝션 처리
	// => Service 클래스의 메소드에서 DAO 객체로 메소드 호출 가능
	@Autowired
	private StudentDAO studentDAO;
		// 다른 클래스의 메소드를 사용하기 위해서 포함관계를 구현한다. - 해당 클래스의 객체를 인젝션 처리
	
	@Override
	public void addStudent(Student student) {
		studentDAO.insertStudent(student);
		
	}

	@Override
	public List<Student> getStudentList() {
		return studentDAO.selectStudentList();
	}

}
