package xyz.itwill.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// DAO(Data Access Object) Ŭ���� : �����ü�� ���� �������� ����,����,����,�˻� ����� �����ϴ� Ŭ����
// => �����ü : �����͸� ��(���ڵ�) ������ �����ϱ� ���� �ϵ���� �Ǵ� ����Ʈ����
// => �������̽��� ��ӹ޾� �ۼ��ϴ� ���� ���� - �޼ҵ��� �ۼ� ��Ģ ���� : ���������� ȿ���� ����
// => �̱��� Ŭ����(���α׷��� �ν��Ͻ��� �ϳ��� �����ϴ� Ŭ����)�� �ۼ��ϴ� ���� ����
	// Oracle DB �̿뿹��
	// DAO Ŭ������ �����ü�� �ٲ�� ��찡 �ִ�. 
	// �������̽��� ��ӹ޾� �ۼ��ϸ� �����ü�� �ٲ���� �޼ҵ���� �ٲ� �ʿ䰡 ���
	// ���α׷��� ���������� ���ϴ�. - �������̽� �ۼ� : Ŭ�������� ���յ��� �����.
	// ���ʿ��� �ν��Ͻ��� ������ �ʱ� ���ؼ� �̱����������� �ۼ��Ѵ�.
	// ���� �޼ҵ帶�� JDBC programming 6 step�� ���� 
	// => Connection ����, SQL��� ����, ����

// STUDENT ���̺� �л������� ���� ����(����),����,����,�˻� ����� �޼ҵ�� �����ϴ� Ŭ���� 
// => DAO Ŭ������ �޼ҵ�� �ϳ��� SQL ����� �����Ͽ� ����� ����� ��ȯ�ϵ��� �ۼ�
// => Connection �ν��Ͻ��� DBCP�κ��� �����ްų� JDBC ���� �ν��Ͻ��� �����ϱ� ���� �޼ҵ尡
// ����� Ŭ������ ��ӹ޾� �ۼ��ϴ� ���� ����
public class StudentDAO extends JdbcDAO {
	// �̱��� ������ ������ ����� Ŭ���� �ۼ� ���
	// 1.Ŭ������ �ν��Ͻ��� �����ϱ� ���� �����ʵ� ���� - �ý��� �ʵ�
	private static StudentDAO _dao;
	
	// 2.�������� ����ȭ ���� - Ŭ���� �ܺο��� �����ڷ� �ν��Ͻ� ���� �Ұ���
	private StudentDAO() {
		
	}
		// static ������ Ŭ������ �޸𸮿� �ε�� �� �ѹ��� ����Ǵ� ����
		// Singleton Ŭ������ ����� ��� �� ��ǥ���� ���.

	// 3.������������ Ŭ������ �ν��Ͻ��� �����Ͽ� �����ʵ忡 ����
	static {
		_dao=new StudentDAO();
	}
	
	// 4.�����ʵ忡 ����� �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ� �ۼ�
	public static StudentDAO getDAO() {
		/*
		// ���������� �ۼ����� �ʴ� ���
			// �ش� ����� �������� �ʴ´�.
		if(_dao=null) {
			_dao=new StudentDAO();
		}
		*/
		return _dao;
	}
	
	// �л������� ���޹޾� STUDENT ���̺� ���ο� ������ �����Ͽ� �л������� �����ϰ� �������� ������ ��ȯ�ϴ� �޼ҵ�
	public int insertStudent(StudentDTO student) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();
			
			String sql="INSERT INTO student VALUES(?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, student.getNo());
			pstmt.setString(2, student.getName());
			pstmt.setString(3, student.getPhone());
			pstmt.setString(4, student.getAddress());
			pstmt.setString(5, student.getBirthday());
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[����]insertStudent() �޼ҵ��� SQL ���� = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		
		return rows;
	}
	
	// �л������� ���޹޾� STUDENT ���̺� ����� �л������� �����ϰ� �������� ������ ��ȯ�ϴ� �޼ҵ�
	public int updateStudent(StudentDTO student) {
		Connection con=null;
		PreparedStatement pstmt = null;
		int rows=0;
		try {
			con=getConnection();
			
			String sql="UPDATE student SET name=?, phone=?, address=?, birthday=? where no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, student.getName());
			pstmt.setString(2, student.getPhone());
			pstmt.setString(3, student.getAddress());
			pstmt.setString(4, student.getBirthday());
			pstmt.setInt(5, student.getNo());
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[����]updateStudent() �޼ҵ��� SQL ���� = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		
		
		return rows;
	}
	
	// �й��� ���޹޾� STUDENT ���̺� ����� �л������� �����ϰ� �������� ������ ��ȯ�ϴ� �޼ҵ�
	public int deleteStudent(int no) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows = 0;
		
		try {
			con=getConnection();
			
			String sql="DELETE FROM student WHERE no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			rows=pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("[����]deleteStudent() �޼ҵ��� SQL ���� = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	
	// �й��� ���޹޾� STUDENT ���̺� ����� �л����� �� �ش� �й��� �л������� �˻��Ͽ� ��ȯ�ϴ� �޼ҵ�
	// => ������ �˻� : �˻����� �ϳ��� ��� - �� �Ǵ� DTO �ν��Ͻ� ��ȯ
	public StudentDTO selectNoStudent(int no) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		StudentDTO student=null;
		
		try {
			con=getConnection();
			
			String sql="SELECT * FROM student WHERE no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs=pstmt.executeQuery();
			
			// �˻����� �ִ� ��� DTO �ν��Ͻ��� �����ϰ� �˻����� �÷����� ��ȯ�޾�
			// DTO �ν��Ͻ��� �ʵ尪���� ����
			if(rs.next()) {
				// DTO �ν��Ͻ� ���� - �ν��Ͻ� �ʵ忡�� �⺻�� ����
				student=new StudentDTO();
				// �˻����� �÷����� ��ȯ�޾� DTO �ν��Ͻ��� �ʵ尪���� ���� ó�� (Oraclel >> Java)
					// '�����Ѵ�' : �������� �����Ѵٶ�� �ǹ�
				student.setNo(rs.getInt("no"));
				student.setName(rs.getString("name"));
				student.setPhone(rs.getString("phone"));
				student.setAddress(rs.getString("address"));
				student.setBirthday(rs.getString("birthday").substring(0,10));
			} 
			
		} catch (SQLException e) {
			System.out.println("[����]selectNoStudent() �޼ҵ��� SQL ���� = "+e.getMessage());
		} finally {
			close(con,pstmt,rs);
		}
		// �˻����� ���� ��� null ��ȯ, �˻����� �ִ� ��� DTO �ν��Ͻ� ��ȯ
		return student;
	}
	
	// �̸��� ���޹޾� STUDENT ���̺� ����� �л����� �� �ش� �̸��� �л������� �˻��Ͽ� ��ȯ�ϴ� �޼ҵ�
	// => ������ �˻� : �˻��� ���� �������� ��� List �ν��Ͻ� ��ȯ
	public List<StudentDTO> selectNameStudentList(String name) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<StudentDTO> studentList = new ArrayList<StudentDTO>();
		
		try {
			con=getConnection();
			
			String sql="SELECT * FROM student WHERE name=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, name);
			rs=pstmt.executeQuery();
			
			// �˻����� �ִ� ���
			// => DTO �ν��Ͻ��� �����Ͽ� �˻����� �÷����� ��ȯ�޾� DTO �ν��Ͻ��� �ʵ尪���� ����
			// => DTO �ν��Ͻ��� List �ν��Ͻ��� ��ҷ� �߰�
			while(rs.next()) {
				StudentDTO student = new StudentDTO();
				student.setNo(rs.getInt("no"));
				student.setName(rs.getString("name"));
				student.setPhone(rs.getString("phone"));
				student.setAddress(rs.getString("address"));
				student.setBirthday(rs.getString("birthday").substring(0,10));
				
				studentList.add(student);
			}
		} catch (SQLException e) {
			System.out.println("[����]selectNameStudent() �޼ҵ��� SQL ���� = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return studentList;
	}
	
	// STUDENT ���̺� ����� ��� �л������� �˻��Ͽ� ��ȯ�ϴ� �޼ҵ�
	public List<StudentDTO> selectAllStudentList() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<StudentDTO> studentList = new ArrayList<StudentDTO>();
		
		try {
			con=getConnection();
			
			String sql="SELECT * FROM student ORDER BY no";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				StudentDTO student = new StudentDTO();
				student.setNo(rs.getInt("no"));
				student.setName(rs.getString("name"));
				student.setPhone(rs.getString("phone"));
				student.setAddress(rs.getString("address"));
				student.setBirthday(rs.getString("birthday").substring(0,10));
				
				studentList.add(student);
			}
		} catch (SQLException e) {
			System.out.println("[����]selectAllStudent() �޼ҵ��� SQL ���� = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return studentList;
	}
	
}
