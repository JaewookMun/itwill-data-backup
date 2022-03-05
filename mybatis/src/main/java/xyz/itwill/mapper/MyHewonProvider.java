package xyz.itwill.mapper;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

// Provider 클래스 : SQL 명령을 반환하는 메소드가 선언된 클래스
// => 동적 SQL 기능을 Java 명령으로 구현하여 제공
public class MyHewonProvider {
	public String selectDynamicHewonList(Map<String, Object> map) {
		// SQL 클래스 : SQL 명령을 저장하여 제공하기 위한 클래스
		// => SQL 명령 작성에 필요한 메소드를 호출하여 SQL 명령 작성
		// SQL.toString() 메소드를 호출하여 SQL 인스턴스에 저장된 SQL 명령을 문자열로 변경하여 반환
		return new SQL() {{
			SELECT("*");
			FROM("myhewon");
			if(map.get("name")!=null && !map.get("name").equals("")) {
				WHERE("hewon_name=#{name}");
			}
			ORDER_BY("hewon_id");
		}}.toString();
	}
}

	// mapping - XML 맵퍼(Mapper) & DAO 작성 - 인터페이스 추상 메소드