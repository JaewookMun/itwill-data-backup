package xyz.itwill05.di;

import java.util.List;

	// ����Ͻ� Ŭ������ ������ ���� �������̽��� ���� ���յ��� ���ߴ� ���� ����.
// DAO Ŭ���� : �����ü(File, DBMS ��)�� �࿡ ���� ����, ����, ����, �˻� ����� �����ϴ� Ŭ����
// => �����ü�� ���� �Ǵ� ����� ���� Service Ŭ������ ����� DAO Ŭ���� ���� ����
// => DAO Ŭ������ ����Ǿ Service Ŭ������ ������ �ּ�ȭ �ϱ� ���� �������̽��� ��ӹ޾� �ۼ�
	// �������̽� ���� ������ �����̳ʸ����� Ŭ�������� ���յ��� ���� �� ����.
	// ó�� ���� �� ���������� �Ű澲�� ������ �������̽����� �����ϴ� ��찡 ����.
	// refactor -> Extract Interface �� ���� Ŭ�������� �������̽��� �̾Ƴ� �� �ִ�.   > �ڵ����� implements ��.

	// �������̽��� ��ӹ����� ���α����� ����, �������̽��� ��ǥ �ڷ����� �ȴ�.
	// �ʵ峪 ���������� �ڷ����� �������̽��� ���
public class StudentJdbcDAO implements StudentDAO {
	
	public StudentJdbcDAO() {
		System.out.println("### StudentJdbcDAO Ŭ������ �⺻ ������ ȣ�� ###");
	}
	
	@Override
	public int insertStudent(Student student) {
		System.out.println("*** StudentJdbcDAO Ŭ������ insertStudent(Student student) �޼ҵ� ȣ��");
		return 0;
	}
	@Override
	public int updateStudent(Student student) {
		System.out.println("*** StudentJdbcDAO Ŭ������ updateStudent(Student student) �޼ҵ� ȣ��");
		return 0;
	}
	@Override
	public int deleteStudent(int num) {
		System.out.println("*** StudentJdbcDAO Ŭ������ deleteStudent(int num) �޼ҵ� ȣ��");
		return 0;
	}
	@Override
	public Student selectStudent(int num) {
		System.out.println("*** StudentJdbcDAO Ŭ������ selectStudent(int num) �޼ҵ� ȣ��");
		return null;
	}

	@Override
	public List<Student> selectStudentList() {
		System.out.println("*** StudentJdbcDAO Ŭ������ selectStudent() �޼ҵ� ȣ��");
		return null;
	}
}