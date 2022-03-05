package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//STUDENT 테이블에 저장된 모든 학생정보를 검색하여 출력하는 JDBC 프로그램
public class SelectStudentApp {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
				
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			//String url="jdbc:oracle:thin:@172.30.1.28:1521:xe";
				//localhost 1521사이를 슬래시로 구분할 수 도 있지만 모두 콜론을 통해 구분하는 것이 정석이다.
			String user ="scott";
			String pw = "tiger";
			
			con=DriverManager.getConnection(url, user, pw);
			stmt=con.createStatement();
			
			String sql="select * from student order by no";
			//Statement.executeQuery(String sql) : SQL 명령(SELECT)을 전달하는 메소드
			//=> SELECT 명령을 실행하여 검색된 행을 ResultSet 인스턴스에 저장하여 반환
			//ResultSet : 검색결과를 테이블(2차원 배열) 형식으로 저장한 인스턴스
			//=> ResultSet 인터페이스의 참조변수에 자식 클래스의 인스턴스를 반환받아 저장
			
			rs=stmt.executeQuery(sql);
			
			//ResultSet 인스턴스에 저장된 검색행을 행단위로 처리하기 위해 내부적인 커서(Cursor) 제공 - ResultSet Cursor
			//=> ResultSet 커서는 최초 BOF(Before Of File) 영역에 위치
			//ResultSet.next() : ResultSet 커서를 다음행으로 이동하는 메소드 - boolean 반환
			//=> false : ResultSet 커서 위치에 처리행이 없는 경우의 반환값 - EOF(End Of File)
			//=> true : ResultSet 커서 위치에 처리행이 있는 경우의 반환값 
				//ResultSet은 커서를 이용하여 테이블 데이터를 행단위로 처리가능하다.
				/*
				 * 		BOF(Before of File)		- rs.next(); : true (최초위치)
				 * ===========================	- rs.next(); : true
				 * ===========================	- rs.next(); : true
				 * ===========================	- rs.next(); : true
				 * ===========================	- rs.next(); : false
				 * 		EOF(End of File)		 
				 * 
				 */
			
			
			if(rs.next()) {
				//System.out.println("[메세지]검색된 학생정보가 있습니다.");
				
				//반복문을 이용하여 ResultSet 커서를 다음행으로 이동하여 행을 하나씩 처리
				//=> ResultSet 커서 위치에 처리행이 없는 경우 반복문 종료
					//이미 if문에서 커서를 한번 내렸기 때문에 do ~ while문 사용
				do {
					//RsultSet 커서 위치의 처리행의 컬럼값을 반환받아 저장
					//ResultSet.getXXX(int columnIndex) 또는 ResultSet.getXXX(int columnLabel)
					//=> ResultSet 커서 위치의 처리행에 컬럼값을 반환하는 메소드
					//=> XXX는 컬럼값을 반환받기 위한 java 자료형을 표현
					//=> columnIndex : 검색대상에 대한 컬럼 위치값(Index : 1부터 1씩 증가되는 정수값) 
					//=> columnLabel : 검색대상에 대한 컬럼명 또는 별칭
						//컬럼인덱스보다는 컬럼라벨을 더 많이 사용한다. - 컬럼인덱스 : 특별한 경우 
						//변수와 컬럼의 이름은 동일하게 하는 것을 권장
					//int no=rs.getInt(1);
					int no=rs.getInt("no");
					String name=rs.getString("name");
					String phone=rs.getString("phone");
					String address=rs.getString("address");
						//java.util의 Date는 시스템의 시간정보를 저장. 오라클의 Date자료형은 저장할 수 없다.
					//Date birthday=rs.getDate("birthday");
					//ResultSet 커서 위치의 처리행에 컬럼값은 오라클 자료형에 상관없이
					//getString() 메소드를 호출하여 문자열(String 인스턴스)로 반환 가능
					String birthday=rs.getString("birthday");
					
					
					System.out.println("학번 = "+no);
					System.out.println("이름 = "+name);
					System.out.println("전화번호 = "+phone);
					System.out.println("주소 = "+address);
					System.out.println("생년월일 = "+birthday.substring(0, 10));
					System.out.println("==================================");
					
				} while(rs.next());
				
			} else {
				System.out.println("[메세지]검색된 학생정보가 없습니다.");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("[에러]OracleDriver 클래스를 찾을 수 없습니다.");
		} catch (SQLException e) {
			System.out.println("[에러]JDBC 관련 오류 = "+e.getMessage());
		} finally {
			try {	//connection을 닫는 것이 가장 중요함. ResultSet, Statement를 닫는 것은 connection을 닫기위한 사전준비이다.
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(con!=null) con.close();
			} catch (SQLException e2) {
				// TODO: handle exception
			}
		} 
	}
}
