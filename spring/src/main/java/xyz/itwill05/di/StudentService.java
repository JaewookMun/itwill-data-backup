package xyz.itwill05.di;

import java.util.List;

// 학생정보를 처리하는 DAO 클래스가 반드시 상속받아야 하는 인터페이스
// =>  객체간의 결합도를 낮추어 유지보수의 효율성 증가
public interface StudentService {
	void addStudent(Student student);
	void modifyStudent(Student student);
	void removeStudent(int num);
	Student getStudent(int num);
	List<Student> getStudentList();
}
