package xyz.itwill05.di;

import java.util.List;

// �л������� ó���ϴ� DAO Ŭ������ �ݵ�� ��ӹ޾ƾ� �ϴ� �������̽�
// =>  ��ü���� ���յ��� ���߾� ���������� ȿ���� ����
public interface StudentService {
	void addStudent(Student student);
	void modifyStudent(Student student);
	void removeStudent(int num);
	Student getStudent(int num);
	List<Student> getStudentList();
}
