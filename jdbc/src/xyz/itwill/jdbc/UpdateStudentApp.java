package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//STUDENT 테이블에 저장된 학생정보 중 학번이 [2000]인 학생의 이름을 [임걱정]으로 변경하고
//주소를 [부천시 원미구]로 변경하는 JDBC 프로그램
public class UpdateStudentApp {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		
			//JDBC관련 내용은 다 SQLException이 발생하기 때문에.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
				//문자열로 표현된 클래스를 읽어서 메모리에 저장.
				//-> 드라이버를 읽어들어서 DriverManager에 드라이버를 등록시켜준다.
			
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="scott";
			String pw = "tiger";
			con=DriverManager.getConnection(url,user,pw);
			
			stmt=con.createStatement();
			
			String sql="update STUDENT set name='임걱정', address='부천시 원미구' where no=2000";
			int rows=stmt.executeUpdate(sql);
			System.out.println("[메세지]"+rows+"명의 학생정보를 변경 하였습니다.");
		} catch (ClassNotFoundException e) {
			System.out.println("[에러]OracleDriver 클래스를 찾을 수 없습니다.");
		} catch (SQLException e) {
			System.out.println("[에러]JDBC 관련 오류 = "+e.getMessage());
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
