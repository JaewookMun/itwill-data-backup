package xyz.itwill05.di;

import java.util.List;

// Service Ŭ���� : ���α׷� ���࿡ �ʿ��� ����� �����ϱ� ���� Ŭ���� - ���۳�Ʈ(���)
// => DAO Ŭ������ �޼ҵ带 ȣ���Ͽ� ���α׷� ���࿡ �ʿ��� ����� �޼ҵ�� ����
// => Service Ŭ������ �޼ҵ�� DAO Ŭ������ �޼ҵ带 ȣ���Ͽ� ���α׷� ���࿡ �ʿ��� ����� ����
// => Service Ŭ������ ����Ǿ ���α׷��� ������ �ּ�ȭ �ϱ� ���� �������̽��� ��ӹ޾� �ۼ�
	// ���߿� test�� ������ �� �� Ŭ������ �׽�Ʈ
public class StudentServiceImpl implements StudentService {
	/*
	// StudentJdbcDAO ��ü�� �ʵ忡 �����ؾ� ���԰��� ����
	// => Constructor �Ǵ� Setter �޼ҵ带 �̿��Ͽ� ��ü�� ���޹޾� �ʵ忡 ����
		// ���� �ϸ� null�� �����Ǿ� ����. ��ü�� �����ؾ� ���谡 �����ȴ�.
	//private StudentJdbcDAO studentJdbcDAO;
	
	// �ʵ��� �ڷ����̳� �̸��� ����� ��� �ʵ� ���� �����ڿ� �޼ҵ带 ��� ����
	private StudentMybatisDAO studentJdbcDAO;
	
	public StudentServiceImpl() {
		System.out.println("### StudentServiceImpl Ŭ������ �⺻ ������ ȣ�� ###");
	}
	
	public StudentServiceImpl(StudentJdbcDAO studentJdbcDAO) {
		System.out.println("### StudentServiceImpl Ŭ������ �Ű������� ����� ������ ȣ�� ###");
		this.studentJdbcDAO = studentJdbcDAO;
	}
	

	public StudentJdbcDAO getStudentJdbcDAO() {
		return studentJdbcDAO;
	}

	public void setStudentJdbcDAO(StudentJdbcDAO studentJdbcDAO) {
		this.studentJdbcDAO = studentJdbcDAO;
		System.out.println("*** StudentServiceImple Ŭ������ setStudentJdbcDAO() �޼ҵ� ȣ��");
	}

	@Override
	public void addStudent(Student student) {
		System.out.println("*** StudentServiceImple Ŭ������ addStudent() �޼ҵ� ȣ��");
		studentJdbcDAO.insertStudent(student);
	}

	@Override
	public void modifyStudent(Student student) {
		System.out.println("*** StudentServiceImple Ŭ������ modifyStudent() �޼ҵ� ȣ��");
		studentJdbcDAO.updateStudent(student);
	}

	@Override
	public void removeStudent(int num) {
		System.out.println("*** StudentServiceImple Ŭ������ removeStudent() �޼ҵ� ȣ��");
		studentJdbcDAO.deleteStudent(num);
	}

	@Override
	public Student getStudent(int num) {
		System.out.println("*** StudentServiceImple Ŭ������ getStudent() �޼ҵ� ȣ��");
		return studentJdbcDAO.selectStudent(num);
	}

	@Override
	public List<Student> getStudentList() {
		System.out.println("*** StudentServiceImple Ŭ������ getStudentList() �޼ҵ� ȣ��");
		return studentJdbcDAO.selectStudentList();
	}
	*/
	
	// DAO Ŭ������ �θ� �������̽��� �̿��Ͽ� �ʵ带 �����ϸ� �ʵ忡�� ��� �ڽ� Ŭ������
	// ������ ��ü�� ���޹޾� ���� - ��������
	// => �������̽� �ʵ�� �޼ҵ带 ȣ���ϸ� �ʵ忡 ����� �ڽ�Ŭ���� ��ü�� �޼ҵ� ȣ�� - �������̵忡 ���� ������
	// => ��ü���� ���յ��� ���߾� ���������� ȿ���� ���� - �ڽ�Ŭ������ ��ü�� ����ǵ� Ŭ������ ��ġ�� ������ �ּ�ȭ
		// �������̽��� �ʵ�� Ȱ���Ͽ� Ŭ�������� ���յ��� ���߾� ���������� ���Ǽ��� �����ų �� �ִ�.
		// ���������� �θ� or �������̽��� ����� ����
	private StudentDAO studentDAO;

	
	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	public StudentServiceImpl() {
		System.out.println("### StudentServiceImpl Ŭ������ �⺻ ������ ȣ�� ###");
	}
	
	public StudentServiceImpl(StudentDAO studentDAO) {
		System.out.println("### StudentServiceImpl Ŭ������ �Ű������� ����� ������ ȣ�� ###");
		this.studentDAO = studentDAO;
	}
	
	@Override
	public void addStudent(Student student) {
		System.out.println("*** StudentServiceImple Ŭ������ addStudent() �޼ҵ� ȣ��");
		studentDAO.insertStudent(student);
	}

	@Override
	public void modifyStudent(Student student) {
		System.out.println("*** StudentServiceImple Ŭ������ modifyStudent() �޼ҵ� ȣ��");
		studentDAO.updateStudent(student);
	}

	@Override
	public void removeStudent(int num) {
		System.out.println("*** StudentServiceImple Ŭ������ removeStudent() �޼ҵ� ȣ��");
		studentDAO.deleteStudent(num);
	}

	@Override
	public Student getStudent(int num) {
		System.out.println("*** StudentServiceImple Ŭ������ getStudent() �޼ҵ� ȣ��");
		return studentDAO.selectStudent(num);
	}

	@Override
	public List<Student> getStudentList() {
		System.out.println("*** StudentServiceImple Ŭ������ getStudentList() �޼ҵ� ȣ��");
		return studentDAO.selectStudentList();
	}
}
