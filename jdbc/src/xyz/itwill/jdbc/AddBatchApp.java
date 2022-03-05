package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

//다수의 행을 삽입하거나 변경하고자 할 경우 Batch 영역에 SQL 명령을 저장하여
//한꺼번에 SQL 명령을 전달하여 실행하는 방법
	//프로그램을 만들 때 잘 사용하지 않지만, Test 서버를 만들 때 행이 많아야 할 경우 사용
	//사용할 때 AutoCommit 기능을 비활성화 시킨 다음에 정상적으로 명령이 실행되었을 때 commit 처리를 한다.
	// > 데이터를 여러개 입력할 때 중간에 에러가 발생할 경우 이전 정보를 롤백처리해야한다.
public class AddBatchApp {
	public static void main(String[] args) throws Exception {
		Connection con=ConnectionFactory.getConnection();
		
		String sql="INSERT INTO student VALUES(?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		
		pstmt.setInt(1, 5000);
		pstmt.setString(2, "장길산");
		pstmt.setString(3, "010-5746-2178");
		pstmt.setString(4, "서울시 도봉구");
		pstmt.setString(5, "1996-05-07");
		//PreparedStatement.addBatch() : PreparedStatement 영역에 저장된 SQL 명령을 Batch 영역에 추가하는 메소드
		pstmt.addBatch();
		
		pstmt.setInt(1, 6000);
		pstmt.setString(2, "홍경래");
		pstmt.setString(3, "010-2456-2178");
		pstmt.setString(4, "부산시 사하구");
		pstmt.setString(5, "1995-11-27");
		pstmt.addBatch();
		
		pstmt.setInt(1, 7000);
		pstmt.setString(2, "로빈훗");
		pstmt.setString(3, "010-7314-9811");
		pstmt.setString(4, "서울시 관악구");
		pstmt.setString(5, "1999-09-09");
		pstmt.addBatch();
		
		//PreparedStatement.executeBatch() : Batch 영역에 추가된 모든 SQL 명령을 접속된
		//DBMS 서버에 전달하여 실행하는 메소드 - int[] 반환
			//삽입하거나 변경할 때 사용하는 메소드
		pstmt.executeBatch();
		
		System.out.println("SQL 명령에 대한 배치 작업 완료");
		
		ConnectionFactory.close(con, pstmt);
		
	}
}
