package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//STUDENT ���̺� ����� �л� ���� �� �й��� [3000]�� �л������� �����ϴ� JDBC ���α׷� ����
public class DeleteStudentApp {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="scott";
			String pw = "tiger";
			
			con=DriverManager.getConnection(url,user,pw);
			stmt=con.createStatement();
			
			String sql="delete from student where no=3000";
			int rows=stmt.executeUpdate(sql);
			if(rows>0) {
				System.out.println("[�޼���]"+rows+"���� �л������� �����Ͽ����ϴ�.");
			} else {
				System.out.println("[�޼���]�����ϰ��� �ϴ� �й��� �л������� ã�� �� �����ϴ�.");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("[����] OracleDriver�� ã�� �� �����ϴ�.");
		} catch (SQLException e) {
			System.out.println("[����] JDBC ���� = "+e.getMessage());
		} finally {
			try {
				if(stmt!=null) stmt.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
		}
		
	}
}
