package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//STUDENT ���̺� ����� �л����� �� �й��� [2000]�� �л��� �̸��� [�Ӱ���]���� �����ϰ�
//�ּҸ� [��õ�� ���̱�]�� �����ϴ� JDBC ���α׷�
public class UpdateStudentApp {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		
			//JDBC���� ������ �� SQLException�� �߻��ϱ� ������.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
				//���ڿ��� ǥ���� Ŭ������ �о �޸𸮿� ����.
				//-> ����̹��� �о�� DriverManager�� ����̹��� ��Ͻ����ش�.
			
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="scott";
			String pw = "tiger";
			con=DriverManager.getConnection(url,user,pw);
			
			stmt=con.createStatement();
			
			String sql="update STUDENT set name='�Ӱ���', address='��õ�� ���̱�' where no=2000";
			int rows=stmt.executeUpdate(sql);
			System.out.println("[�޼���]"+rows+"���� �л������� ���� �Ͽ����ϴ�.");
		} catch (ClassNotFoundException e) {
			System.out.println("[����]OracleDriver Ŭ������ ã�� �� �����ϴ�.");
		} catch (SQLException e) {
			System.out.println("[����]JDBC ���� ���� = "+e.getMessage());
		} finally {
				try {
					if(stmt != null) stmt.close();
					if(con != null) con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}
}
