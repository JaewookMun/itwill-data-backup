package xyz.itwill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

// DAO Ŭ���� �ۼ��� ��ӹ޾� ����ϱ� ���� Ŭ����
	/*
	 * Java library
	 * basic - JRE
	 * Web dev - Apache Tomcat
	 * JDBC - DBMS���� ������ library e.g) ojdbc
	 * Connection�� �������� ����� �� ������
	 * Connection Pool�� ���� �̸� Connection�� ������ ����� ���� �ʿ�� ����ϴ� ���� ����
	 */
public abstract class JdbcDAO {
	private static DataSource dataSource;
	
	static {
		try {
			dataSource=(DataSource)new InitialContext().lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
	
	public void close(Connection con) {
		try {
			if(con!=null) con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void close(Connection con, PreparedStatement pstmt) {
		try {
			if(pstmt!=null) pstmt.close();
			if(con!=null) con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(con!=null) con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}