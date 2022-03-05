package xyz.itwill.dbcp;

import java.sql.Connection;
import java.sql.SQLException;

//DBCP(DataBase ConnectionPool) : Connection 인스턴스를 미리 여러 개 생성하여 저장하고
//Connection을 반환하는 기능을 제공하기 위한 클래스
//=> Connection 인스턴스를 생성하기 위한 정보에 대한 변경이 용이
//=> Connection 인스턴스를 미리 만들어 사용하므로 JDBC 프로그램의 실행 속도 증가
//=> Connection 인스턴스의 갯수 제한 가능
	//Connection Pool이 바뀌면 프로그램을 바꿔야함. (e.g. 메소드가 바뀌기 때문에..)
	//Connection pool의 표준은 인터페이스로 제공. - DataSource인터페이스
	//DataSource를 상속받는 클래스 - UCP라이브러리 (표준인터페이스 상속).
	// 라이센스 계약을 할 때 동시접속자수를 지정하는데 Connection pool을 활용하여 
	// 미리 이를 지정할 수 있음.
	// ConnectionPool은 SunMicro에서 내부적으로 사용하기 위해 사용
	// ConnectionPool은 이제 DataSource 인터페이스를 상속받는 클래스를 사용.
public class ConnectionPoolApp {
	public static void main(String[] args) throws SQLException {
		//ConnectionPool 인스턴스를 반환받아 저장
		//=> 싱글톤 디자인 패턴이 적용된 클래스이므로 프로그램에 인스턴스를 하나만 제공
		//=> Connection 인스턴스를 미리 여러 개 생성하여 콜렉션 필드에 저장
		ConnectionPool cp=ConnectionPool.getInstance();
		
		//ConnectionPool.getConnection() : 미리 생성되어 저장된 Connection 인스턴스 중
		//하나를 반환하는 메소드
		Connection con1=cp.getConnection();
		System.out.println("con1 = "+con1);
		//ConnectionPool.freeConnection(Connection con) : 제공받은 Connection 인스턴스를 다시 ConnectionPool
		//인스턴스에 돌려주는 메소드
		//cp.freeConnection(con1);
		
		Connection con2=cp.getConnection();
		System.out.println("con2 = "+con2);
		//cp.freeConnection(con2);
		
		Connection con3=cp.getConnection();
		System.out.println("con3 = "+con3);
		cp.freeConnection(con3);
		
		Connection con4=cp.getConnection();
		System.out.println("con4 = "+con4);
		cp.freeConnection(con4);
	}
}
