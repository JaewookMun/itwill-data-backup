package xyz.itwill.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import xyz.itwill.dto.Student;

public class StudentDAO {
	private static StudentDAO _dao;
	
	private StudentDAO() {
		
	}
	
	static {
		_dao=new StudentDAO();
	}
	
	public static StudentDAO getDAO() {
		return _dao;
	}
	
		// @@@@@
	// SqlSessionFactory �ν��Ͻ��� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
	// => mybatis ȯ�漳�������� �о� SqlSessionFactory �ν��Ͻ� ����
	// SqlSessionFactory : SqlSession �ν��Ͻ��� �����Ͽ� �����ϴ� �ν��Ͻ�
	private SqlSessionFactory getSqlSessionFactory() {
		// String resource="xyz/itwill/dao/mybatis-config.xml";
			// xyz.itwill.dao ��Ű�� �ȿ� config ������ �������� ���.
			// �ڹ� ������ �ƴҰ�� /�� ���� ��� ǥ��
		String resource="mybatis-config.xml";
			// ���⼭ error�� �߻��ϸ� environment or mapper���� ������ �ִ� ���̴�.
		
		InputStream inputStream=null;
		try {
			// mybatis ȯ�漳�������� �б� ���� �Է½�Ʈ���� �����Ͽ� ����
			// Resources.getResourceAsStream(String resource) : ������Ʈ�� �����ϴ� ���ҽ�
			// ����(XML)�� ��θ� �����޾� �Է½�Ʈ���� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
			inputStream=Resources.getResourceAsStream(resource);
				// org.apache.ibatis.io ���
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}

		// SqlSessionFactoryBuilder : SqlSessionFactory �ν��Ͻ��� �����ϴ� ����� �����ϴ� �޼ҵ�
		// SqlSessionFactoryBuilder.build(InputStream inputStream) : mybatis ȯ�漳�������� ������
		// �Է½�Ʈ���� �̿��Ͽ� �����޾� SqlSessionFactory �ν��Ͻ��� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
		return new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	// STUDENT ���̺� ����� ��� �л������� �˻��Ͽ� ��ȯ�ϴ� �޼ҵ�
	public List<Student> selectStudentList(){
		// SqlSessionFactory.openSession() : SqlSession �ν��Ͻ��� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
		// SqlSession : ���� ���Ͽ� ��ϵ� SQL ����� ���� DBMS ������ �����Ͽ� �����ϰ�
		// SQL����� �������� Java �ڷ����� ����� �ڵ� �����Ͽ� ��ȯ�ϴ� �ν��Ͻ�
		SqlSession sqlSession=getSqlSessionFactory().openSession();
		
		try {
			// SqlSession.selectList(String elementId) : ���� ���Ͽ� ��ϵ� SELECT ����� �����޾�
			// DBMS ������ �����Ͽ� �����ϰ� �˻������ �����Ͽ� List �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
			// elementId : ���� ������ mapper ������Ʈ�� namespace �Ӽ����� select ������Ʈ��
			// id �Ӽ����� �̿��Ͽ� ���� ���Ͽ� ��ϵ� SQL ����� �����޾� ���
			return sqlSession.selectList("xyz.itwill.mapper.StudentMapper.selectStudentList");
		} finally {
			// SqlSession.close() : SqlSession �ν��Ͻ��� �����ϴ� �޼ҵ�
				// SqlSession �� ����� ��� sql ���� �ν��Ͻ� ����
			sqlSession.close();
		}
				// MyBatis�� ���� ������ ó������
			/*
				error �߻� ��
				1. config 
				2. mapper����
			 */
	}
	
}
