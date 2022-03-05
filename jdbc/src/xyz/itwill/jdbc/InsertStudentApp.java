package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//JDBC 프로그램을 작성하기 위한 JDBC Driver 관련 클래스가 포함된 라이브러리를 빌드 처리
//=> Oracle JDBC Driver : ojdbc6.jar 
	//build 처리

//STUDENT 테이블 : 학번(숫자형-PRIMARY KEY),이름(문자형),전화번호(문자형),주소(문자형),생년월일(날짜형)
//CREATE TABLE STUDENT(NO NUMBER(4) PRIMARY KEY, NAME VARCHAR2(30), PHONE VARCHAR2(20)
//, ADDRESS VARCHAR2(100), BIRTHDAY DATE);
	//JDBC로 만들 수는 있지만 권장하지 않음

//STUDENT 테이블에 학생정보(행)를 삽입하여 저장하는 JDBC 프로그램
public class InsertStudentApp {
	public static void main(String[] args) {
		//JDBC 관련 인스턴스를 저장하기 위한 참조변수는 try 영역 밖에서 선언
		//=> 모든 영역에서 참조변수를 사용하여 메소드 호출 가능
		Connection con=null;
		Statement stmt=null;
		
		try {
			//1.OracleDriver 클래스로 인스턴스를 생성하여 DriverManager 클래스의 JDBC Driver로 등록
				//Driver클래스는 library마다 다름. 
			//JDBC Driver : DriverManager 클래스에 등록된 다수의 Driver 인스턴스
			//=> Driver 인스턴스 : DBMS 서버에 접속할 수 있는 기능 제공
			//=> 접속 URL 주소로 DBMS 서버에 접속할 수 있는 기능 제공 
				//Oracle, MySQL, ... etc. Driver 존재
			
			//DriverManager 클래스 : JDBC Driver를 관리하기 위한 기능을 제공하는 클래스
				//DriverManager에는 다양한 DBMS에 접속할 수 있는 Driver들이 들어갈 수 있다.
			
			/*
			//DriverManager.registerDriver(Driver driver) : Driver 인스턴스를 DriverManager
			//클래스에 JDBC Driver로 등록하는 메소드
			//OracleDriver 클래스로 다수의 인스턴스를 생성하여 JDBC Driver로 등록 가능
			//=> 불필요한 JDBC Driver가 존재 가능
				//Driver를 여러개 등록할 필요가 없음 - SQL Developer를 여러개 설치하는 것과 같음.
				//메모리에 불필요한 드라이버가 등록될 수 있음 - DriverManager 안에 같은 드라이버가 2개가 저장
			DriverManager.registerDriver(new OracleDriver());
				//위 방식을 사용하면 OricleDriver가 JDBC 드라이버로 2개 등록된다. 
				  - 클래스 로드시 1번, ~.registerDriver() 코드 작성시 1번
			*/
			
			//OracleDriver 클래스를 읽어 메모리에 저장
			//=> OracleDriver 클래스의  정적 영역에서 OracleDriver 클래스를 인스턴스로 생성하여
			//   DriverManager 클래스에 JDBC Driver로 등록 처리 - 1번 실행
				//똑같은 드라이버를 여러개 만들어서 등록하는 일이 발생하지않는다.
				//OracleDriver 클래스에 이미 구현된 정적영역에서 인스턴스가 생성된다.
				//해당 코드를 중복 작성해도 드라이버 처리가 1번 발생되기 때문에 불필요한 드라이버가 등록되지 않는다.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. JDBC Driver를 이용하여 DBMS 서버에 접속하고 접속정보(Connection 인스턴스)를
			//반환받아 저장
			//DriverManager.getConnection(String url, String user, String password)
			//=> DBMS 서버에 접속하는 메소드 - 접속 성공시 Connection 인스턴스를 반환
			//=> 메소드의 매개변수에 전달된 URL 정보에 따라 특정 DBMS 서버에 접속
			//=> 서버 접속이 실패하면 SQLException 발생
			//SQLException : JDBC 관련 인스턴스의 메소드에서 발생되는 예외
			//=> DBMS에서 접속 오류 또는 SQL 명령에 문제가 있는 경우 경우 예외가 발생
				//서버에 접속 성공시 연결 인스턴스 반환
			
			//URL : 인터넷에 존재하는 자원을 표현하기 위한 주소
			//=> Protocol:ServerName:Port:Resource - ex) https:www.daum.net:80
			//Oracle DBMS Server에 대한 JDBC URL
			//형식)jdbc:oracle:thin:@ServerName:Port:SID
				//jdbc: - main protocol , oracle: & thin: - sub protocol
				//thin : 간단하게 접속하겠다는 의미
				//SID : 전역DB의 구분자(식별자)
				//https - protocol
				//locolhost : 자기 컴퓨터 - 다른 컴퓨터 접속시 IP주소 표기
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="scott";
			String password="tiger";
			//Connection : DBMS 서버의 접속정보를 저장하기 위한 인스턴스
			//=> Connection 인터페이스에 자식 클래스의 인스턴스를 반환받아 저장
			con= DriverManager.getConnection(url, user, password);
			
			//3. 접속된 DBMS서버에 SQL 명령을 전달하기 위한 Statement 인스턴스를 반환받아 저장
			//Connection.createStatement() : Connection 인스턴스로부터 SQL 명령을 전달할
			//수 있는 Statement 인스턴스를 생성하여 반한하는 메소드 - SQLException 발생
			//Statement : 접속된 DBMS 서버에 SQL 명령을 전달하기 위한 인스턴스
			//=> Statement 인터페이스에 자식 클래스의 인스턴스를 반환받아 저장
			stmt = con.createStatement();
			
			//4. Statement 인스턴스로 접속된 DBMS 서버에 SQL 명령을 전달하여 실행하고 실행된 
			//결과값을 반환받아 저장
			//Statement.executeUpdate(String sql) : INSERT, UPDATE, DELETE 명령을 서버에 전달하는 메소드 - SQLException 발생
			//=> 조작행의 갯수(int) 반환
			//Statement.executeQuery(String sql) : SELECT 명령을 서버에 전달하는 메소드 - SQLException 발생
			//=> 검색행(ResultSet 인스턴스) 반환
				//insert, update, delete된 행의 숫자
			//String sql = "insert into student values(1000,'홍길동','010-4635-5123','서울시 강남구','1999-12-31')";
			//String sql = "insert into student values(2000,'임꺽정','010-7841-8711','수원시 팔달구','2000-01-01')";
			String sql = "insert into student values(3000,'전우치','010-2871-7888','인천시 월미구','1997-05-06')";
			int rows=stmt.executeUpdate(sql);
			
			//5. SQL 명령의 실행결과를 처리 - 출력 또는 반환
				//출력 - 프로그램 / 반환 - 메소드
			System.out.println("[메세지]"+rows+"명의 학생정보를 저장 하였습니다.");
			
				//자바에서는 인스턴스가 자동적으로 없어지지 않는다. (GC가 없애긴 하는데 언제 없어질지는 모른다.)
			
		} catch (ClassNotFoundException e) {
				//아래 명령문이 실행된다면 Driver의 Build가 안되었거나 이름을 잘못 표기한 경우이다.
			System.out.println("[에러]OracleDriver 클래스를 찾을 수 없습니다.");
		} catch (SQLException e) {
			System.out.println("[에러]JDBC 관련 오류"+e.getMessage());
				// 모두 Oracle DB에서 오류가 발생하면 JDBC에러 발생
			
		} finally {//예외와 상관없이 실행될 명령을 작성
				//예외의 발생여부와 상관없이 접속을 끊기 위해 finally단에 선언.
			//6. JDBC 관련 인스턴스 제거 - close() 메소드 호출 - SQLException 발생
			//=> 인스턴스 생성의 반대 순서대로 제거
			try {
				//if 구문을 이용하여 NullPointerException 발생 방지
				if(stmt!=null) stmt.close();
				if(con!=null) con.close();//DBMS 서버 접속 해제
					//오라클은 라이센스를 계약할 때 동시접속자 수를 정한다. - connection은 꼭 해제해줘야함.
			} catch (SQLException e) {
					//SQL 관련 메소드는 모두 발생 SQLException  
				e.printStackTrace();
			}
			
		}
		
		
		
	}
}
