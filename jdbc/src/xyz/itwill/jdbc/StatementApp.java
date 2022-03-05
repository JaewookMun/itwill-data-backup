package xyz.itwill.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

//Statement : 접속된 DBMS 서버에 SQL 명령을 전달하여 실행된 결과를 반환하는 기능을 제공하는 인스턴스
//장점 : 하나의 Statement 인스턴스로 다수의 SQL 명령을 전달하여 실행 가능
//단점 : SQL 명령에 Java 변수값을 포함하고자 할 경우 문자열 결합 기능 이용
//=> 문자열 결합을 이용할 경우 가독성 및 유지보수의 효율성 감소
//=> InSQL 해킹 기술(값 대신 부분적인 SQL 명령을 포함하는 기술)에 취약
	//사용자가 입력한 값을 Statement SQL문으로 구성하면 보안과 관련해서 문제가 발생할 수 있다.
	//=> 사용자로부터 입력된 값을 SQL문에 포함시킬 때 Statement를 사용하면 안된다. - 행안부에서 Web application에서 Statement를 사용하지 말라고 공고함.
	// c.f.)  ' or '1'='1 을 검색하면 모든 행을 다 검색해버린다.
	//       웹의 경우 password가 달라도 관리자계정으로 접속할 가능성이 있다.

public class StatementApp {
	public static void main(String[] args) throws Exception {
		/*
		//키보드로 학생정보를 입력받아 STUDENT 테이블에 삽입하여 저장하고 STUDENT 테이블에
		//저장된 모든 학생정보를 검색하여 출력하는 JDBC 프로그램
		
		//키보드로 학생정보를 입력받기 위한 입력 스트림 생성
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		//키보드로 학생정보를 입력받아 저장
			//Basically, validation test should be carried out.
		System.out.println("<< 학생정보 입력>>");
		System.out.print("학번 입력 >> ");
		int no = Integer.parseInt(in.readLine());
		System.out.print("이름 입력 >> ");
		String name = in.readLine();
		System.out.print("전화번호 입력 >> ");
		String phone = in.readLine();
		System.out.print("주소 입력 >> ");
		String address = in.readLine();
		System.out.print("생년월일 입력 >> ");
		String birthday = in.readLine();
		
		System.out.println("============================================================");
		//입력된 학생정보를 STUDENT 테이블에 행으로 삽입하여 저장
		Connection con=ConnectionFactory.getConnection();
		
		Statement st=con.createStatement();
		
		String sql1="INSERT INTO student VALUES("+no+",'"+name+"','"
				+phone+"','"+address+"','"+birthday+"')";
		int rows=st.executeUpdate(sql1);
		
		System.out.println("[결과]"+rows+"명의 학생정보를 저장 하였습니다.");
		System.out.println("============================================================");
		//STUDENT 테이블에 저장된 모든 행(학생정보)을 검색하여 출력
		String sql2="SELECT no,name,phone,address,birthday FROM student ORDER BY no";
		ResultSet rs=st.executeQuery(sql2);
		
		System.out.println("<<학생목록 출력>>");
			//컬럼값들을 뽑아내서 출력하는 것을 'Fetch'라고 이야기한다.
		while(rs.next()) {
			System.out.println("학번 = "+rs.getInt("no")+", 이름 = "+rs.getString("name"));
		}
		ConnectionFactory.close(con, st, rs);
		System.out.println("============================================================");
		*/
		
		//키보드로 이름을 입력받아 STUDENT 테이블에 저장된 학생정보를 입력한 이름으로 검색
		//하여 출력하는 JDBC 프로그램 작성
		
		//키보드로 학생정보를 입력받아 STUDENT 테이블에 삽입하여 저장하고 STUDENT 테이블에
		//저장된 모든 학생정보를 검색하여 출력하는 JDBC 프로그램
		
		//키보드로 학생정보를 입력받기 위한 입력 스트림 생성
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		//키보드로 이름을 입력받아 저장
			//Basically, validation test should be carried out.
		System.out.println("<< 학생정보 검색>>");
		System.out.print("이름 입력 >> ");
		String name = in.readLine();
		System.out.println("============================================================");
		//STUDENT 테이블에 저장된 학생정보 중 입력된 이름의 학생정보를 검색하여 출력
		Connection con=ConnectionFactory.getConnection();
		Statement st=con.createStatement();
		
		String sql="SELECT * FROM student WHERE name='"+name+"' order by no";
		ResultSet rs=st.executeQuery(sql);
				
		System.out.println("<<검색결과 출력>>");
			//조건식이 맞지 않으면 행이 검색되지 않을 수 있기 때문에 아래처럼 if문을 통해 행이 검색되지 않을 경우를 고려
		if(rs.next()) {
			do { //같은 이름을 가진 사람이 있을 수 있기 때문에 반복처리
				System.out.println("학번 = "+rs.getInt("no")+", 이름 = "+rs.getString("name"));
			} while(rs.next());
		} else {
			System.out.println("검색된 학생정보가 없습니다.");
		}
		ConnectionFactory.close(con, st, rs);
		System.out.println("============================================================");

		
		
	}
}