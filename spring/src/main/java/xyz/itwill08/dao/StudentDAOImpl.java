package xyz.itwill08.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

// StudentDAO ����� �̿��Ͽ� DAO Ŭ���� �ۼ� - spring-jdbc ���̺귯��
// => JdbcTemplate Ŭ������ ���ø� �޼ҵ带 ȣ���Ͽ� DAO Ŭ���� �ۼ�
	// select - ����, ����SQL �� �����ϱ� ������ Spring DAO ����� �����ϰ� MyBatis�� ����Ѵ�.
	// insert, delete, update�� ����ϱ� �ſ� ����.
public class StudentDAOImpl implements StudentDAO {
	// Bean Configuration File���� StudentDAOImpl Ŭ������ Spring Bean���� ����� ��
	// JdbcTemplate Ŭ������ Spring Bean�� �ʵ忡 �������Ͽ� �������� ���� - DI(Dependency Injection)
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insertStudent(Student student) {
		String sql="insert into student values(?,?,?,?,?)";
		// JdbcTemplate.update(String sql, Object ...args) : SQL ����(INSERT, UPDATE, DELETE)��
		// DBMS ������ �����Ͽ� �����ϴ� �޼ҵ� - �������� ����(int) ��ȯ
		// => �Ű������� SQL ���ɰ� InParameter�� ����� ���� ���ʴ�� �����Ͽ� �޼ҵ� ȣ��
		return jdbcTemplate.update(sql, student.getNo(),student.getName(),
				student.getPhone(), student.getAddress(), student.getBirthday());
	}

	@Override
	public int updateStudent(Student student) {
		String sql="update student set name=?,phone=?,address=?,birthday=? where no=?";
		
		return jdbcTemplate.update(sql, student.getName(), student.getPhone()
				, student.getAddress(), student.getBirthday(), student.getNo());
	}

	@Override
	public int deleteStudent(int no) {
		
		return jdbcTemplate.update("delete from student where no=?",no);
	}

	@Override
	public Student selectStudent(int no) {
		try {
			String sql="select * from student where no=?";
			
			// JdbcTemplate.queryForObject(String sql, RowMapper<T> rowMapper, Object... args)
			// => SQL ����(SELECT)�� DBMS ������ �����Ͽ� �����ϴ� �޼ҵ�
			// => �������� �˻������ RowMapper�� ���׸����� ������ ��ü�� ��ȯ�� ��� ����ϴ� �޼ҵ�
			// => SQL ����, RowMapper ��ü(��������), InParameter�� ���ް��� �Ű������� �����Ͽ� �޼ҵ� ȣ��
			// => RowMapper ��ü�� ���޹޾� �˻������ Java ��ü(���׸�)�� �����Ͽ� ��ȯ
			// => InParameter ���ް��� �Ű������� �̿��Ͽ� ���ʴ�� �����Ͽ� ����
				// deprecated : as of 5.3
			/*
			return jdbcTemplate.queryForObject(sql, new RowMapper<Student>() {
				// �˻����� �÷����� ���׸����� ������ ��ü�� �ʵ忡 ����ǵ��� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
				@Override
				public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
					Student student=new Student();
					student.setNo(rs.getInt("no"));
					student.setName(rs.getString("name"));
					student.setPhone(rs.getString("phone"));
					student.setAddress(rs.getString("address"));
					student.setBirthday(rs.getString("birthday"));
	
					return student;
				}
			}, no);
			*/
			return jdbcTemplate.queryForObject(sql, new StudentRowMapper(), no);
		} catch (EmptyResultDataAccessException e) {
			//EmptyResultDataAccessException : queryForObject() �޼ҵ忡 ���� ���޵� SQL ������
			//�˻������ �������� ���� ��� �߻��Ǵ� ����
			return null;
		}
	}

	@Override
	public List<Student> selectStudentList() {
		// JdbcTemplate.queryForObject(String sql, RowMapper<T> rowMapper, Object... args)
		// => SQL ����(SELECT)�� DBMS ������ �����Ͽ� �����ϴ� �޼ҵ�
		// => �������� �˻������ ���׸����� ������ ��ü�� ��ҷ��ϴ� List ��ü�� ��ȯ�� ��� ����ϴ� �޼ҵ�
		String sql="select * from student order by no";
		/*
		return jdbcTemplate.query(sql, new RowMapper<Student>() {
			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student student=new Student();
				student.setNo(rs.getInt("no"));
				student.setName(rs.getString("name"));
				student.setPhone(rs.getString("phone"));
				student.setAddress(rs.getString("address"));
				student.setBirthday(rs.getString("birthday"));

				return student;
			}
		});
		*/
		return jdbcTemplate.query(sql, new StudentRowMapper());
	}
	
	// RowMapper �������̽��� ��ӹ��� �ڽ�Ŭ���� - ���� ����� �����ϴ� Ŭ����
	public class StudentRowMapper implements RowMapper<Student> {

		@Override
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			Student student=new Student();
			student.setNo(rs.getInt("no"));
			student.setName(rs.getString("name"));
			student.setPhone(rs.getString("phone"));
			student.setAddress(rs.getString("address"));
			student.setBirthday(rs.getString("birthday"));

			return student;
		}
		
	}
}