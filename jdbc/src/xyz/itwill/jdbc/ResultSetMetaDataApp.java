package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

//STUDENT 테이블에 저장된 모든 학생정보를 검색하여 출력하는 프로그램
public class ResultSetMetaDataApp {
	public static void main(String[] args) throws SQLException {
		Connection con=ConnectionFactory.getConnection();
		
		Statement st = con.createStatement();
		
		String sql="SELECT * FROM STUDENT ORDER BY NO";
		//String sql="SELECT no,name,phone FROM STUDENT ORDER BY NO";
		//ResultSet : 검색결과를 저장하기 위한 인스턴스
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
			System.out.println("학번 = "+rs.getInt("no")+", 이름 = "+rs.getString("name"));
		}
		System.out.println("==============================================================");
		//ResultSet.getMetaData() : 검색행(ResultSet 인스턴스)에 대한 부가적인 정보를
		//저장하고 있는 ResultSetMetaData 인스턴스를 반환하는 메소드
			//metadata : 보조적인 정보 
			//e.g. 휴대폰으로 사진을 찍을 때 이미지 정보 : 메인데이터 
			//     사진이미지의 타입,압축률,날짜,위치 등 보조적인 정보 : 메타데이터
		
		ResultSetMetaData rsmd=rs.getMetaData();
		
		//ResultSetMetaData.getColumnCout() : 검색행의 컬럼 갯수를 반환하는 메소드
		int columnCount=rsmd.getColumnCount();
		System.out.println("검색행의 컬럼 갯수 = "+columnCount);
		
		for(int i=1; i<columnCount; i++) {
			//ResultSetMetaData.getColumnLabel(int columnIndex) : columnIndex 위치의
			//컬럼명을 반환하는 메소드
			String columnLabel=rsmd.getColumnLabel(i);
			
			//ResultSetMetaData.isNullable(int columnIndex) : columnIndex 위치의
			//컬럼명에 대한 NULL 허용 유무값(0 or 1)을 반환하는 메소드
			int isNull=rsmd.isNullable(i);
			String nullResult ="NULL";
			if(isNull==ResultSetMetaData.columnNoNulls) {
				nullResult="NOT NULL";
			}
			
			//ResultSetMetaData.getColumnTypeName(int columnIndex) : columnIndex 위치의
			//컬럼의 오라클 자료형을 반환하는 메소드
			String columnTypeName=rsmd.getColumnTypeName(i);
			
			//ResultSetMetaData.getColumnDisplaySize(int columnIndex) : columnIndex 위치의
			//컬럼에 대한 출력크기를 반환하는 메소드
			int columnDisplaySize=rsmd.getColumnDisplaySize(i);
			
			System.out.println("컬럼명 = "+columnLabel);
			System.out.println("NULL 허용 유무 = "+nullResult);
			System.out.println("컬럼 자료형 = "+columnTypeName);
			System.out.println("컬럼 출력크기 = "+columnDisplaySize);
			System.out.println("==============================================================");
		}
		System.out.println("==============================================================");
		ConnectionFactory.close(con,st,rs);
		
	}
}
