package xyz.itwill10.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.itwill10.dao.StudentDAO;
import xyz.itwill10.dto.Student;

// Service Ŭ���� : ���α׷� �ۼ��� �ʿ��� ����� �����ϴ� Ŭ����
// => Service Ŭ������ �޼ҵ�� DAO Ŭ������ �޼ҵ带 ȣ���Ͽ� ��� ����
	// Controller���� ����ϱ� ���� Spring Bean���� ��ϵǾ�� �Ѵ�.

// @Service : Service Ŭ������ Spring Bean���� ����ϴ� ������̼�
// => ����ó�� ����� �����޾� ���
// Spring Container�� ������̼��� ó���ϱ� ���� Bean Configuration File(servlet-context.xml)����
// component-scan ������Ʈ�� ����Ͽ� Service Ŭ������ �ۼ��� ��Ű���� ����
	// ExceptionHandler
@Service
public class StudentServiceImpl implements StudentService{
	// DAO Ŭ������ ��ϵ� Spring Bean�� �ʵ忡 ������ ó��
	// => Service Ŭ������ �޼ҵ忡�� DAO ��ü�� �޼ҵ� ȣ�� ����
	@Autowired
	private StudentDAO studentDAO;
		// �ٸ� Ŭ������ �޼ҵ带 ����ϱ� ���ؼ� ���԰��踦 �����Ѵ�. - �ش� Ŭ������ ��ü�� ������ ó��
	
	@Override
	public void addStudent(Student student) {
		studentDAO.insertStudent(student);
		
	}

	@Override
	public List<Student> getStudentList() {
		return studentDAO.selectStudentList();
	}

}
