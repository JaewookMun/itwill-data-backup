package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//EMP 테이블에서 모든 사원의 사원번호,사원이름,업무,급여를 급여순으로 내림차순 정렬되도록
//검색하여 출력하는 JDBC 프로그램
public class SelectEmpApp {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="scott";
			String pw="tiger";
			
			con=DriverManager.getConnection(url, user, pw);
			stmt=con.createStatement();
			
			
			String sql="select empno,ename,job,sal from EMP order by sal desc";
			rs=stmt.executeQuery(sql);
				
				System.out.printf("%5s %5s %7s %8s \n", "사원번호","사원이름","업무","급여");
			while(rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int sal = rs.getInt("sal");
				
				System.out.printf("%-8d %-8s %-10s %6d\n",empno,ename,job,sal);
				
				
				/*
				System.out.print(empno+"\t");
				System.out.print(ename+"\t");
				System.out.print(job+"\t");
				System.out.print(" "+sal+"\n");
				*/
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("[에러] OracleDriver를 찾을 수 없습니다.");
		} catch (SQLException e) {
			System.out.println("[에러] JDBC 오류 = "+e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(con!=null) con.close();
			} catch (SQLException e2) {
				// TODO: handle exception
			}
		}
	}
}
