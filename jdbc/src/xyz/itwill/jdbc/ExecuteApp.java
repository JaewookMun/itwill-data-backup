package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteApp {
	public static void main(String[] args) throws SQLException {
		Connection con=ConnectionFactory.getConnection();
		
		Statement stmt=con.createStatement();
		
		/*
		String sql1="update student set nam='임꺽정' where no=2000";
		int rows=stmt.executeUpdate(sql1);
		
		System.out.println("[결과]"+rows+"명의 학생정보를 변경하였습니다.");
		System.out.println("====================================================");
		String sql2="select * from student order by no";
		ResultSet rs = stmt.executeQuery(sql2);
			//select 명령을 exe~update로, insert&update&delete 명령을 exe~query로 실행해도 되지만
			//실행에 대한 적절한 결과를 받을 수 없다. - 쿼리에 따라 적합한 메소드 사용
		
		while(rs.next()) {
			System.out.println("학번 = "+rs.getInt("no") + ", 이름 = "+rs.getString("name"));
		}
		
		ConnectionFactory.close(con,stmt,rs);
		System.out.println("====================================================");
		*/
		
		int choice=3;
		
		String sql="";
		if(choice==1) {
			sql="update student set nam='임꺽정' where no=2000";
		} else {
			sql="select * from student order by no";
		}

		//Statement.execute(String sql) : SQL 명령을 전달하여 실행하는 메소드 - boolean 반환
		//=> false 반환 : DML 명령(INSERT, UPDATE, DELETE)을 전달하여 실행한 경우의 반환값
		//=> true 반환 : DQL 명령(SELECT)을 전달하여 실행한 경우의 반환값
			//어떤 sql 명령이라도 실행하는 메소드
		boolean result=stmt.execute(sql);
		
		ResultSet rs=null;
		
		if(result) {//DQL 명령을 전달하여 실행한 경우
			//Statement.getResultSet() : SELECT 명령의 실행결과(검색행)를 ResultSet
			//인스턴스로 반환하는 메소드
			rs=stmt.getResultSet();
			
			while(rs.next()) {
				System.out.println("학번 = "+rs.getInt("no")+", 이름 = "+rs.getString("name"));
			}
			
		} else {//DML 명령을 전달하여 실행한 경우
			//Statement.getUpdateCount() : INSERT,UPDATE,DELETE 명령의 실행결과를(조작행의 갯수)
			//정수값으로 반환하는 메소드
			int rows=stmt.getUpdateCount();
			
			System.out.println("[결과]"+rows+"명의 학생정보를 확인하였습니다.");
		}
				//어떤 명령을수행해야 할지 모르는 경우 존재 > 이때, execute() 메소드 사용
				//사용할 일이 크게 많지는 않음. 
				//text file로 sql파일을 받을 때 해당 방식 사용가능
				//앞으로 만들 프로그램은 사용해야할 sql문이 명확히 정해진 편
		
		
	}
}
