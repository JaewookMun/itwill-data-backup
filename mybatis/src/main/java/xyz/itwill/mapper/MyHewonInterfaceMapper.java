package xyz.itwill.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import xyz.itwill.dto.MyHewon;

public interface MyHewonInterfaceMapper {
	// @Results : 검색행의 컬럼값을 클래스의 필드에 매핑할 수 있는 정보를 제공하는 어노테이션
	// => XML 맵퍼의 resultMap 엘리먼트와 유사한 기능을 제공하는 어노테이션
	// value 속성 : 매핑정보를 속성값으로 설정 - 속성값으로 배열을 사용하여 매핑정보 제공
	// @Results 어노테이션은 다른 추상메소드의 SQL 명령에 대한 매핑 정보 제공 불가능
	// => 매핑정보 재사용 불가능
		// 배열을 표기
	@Results(value={
			// @Result : 검색행의 컬럼값을 클래스 필드에 매핑하는 어노테이션
			// => XML 맵퍼의 id 엘리먼트 또는 result 엘리먼트와 유사한 기능 제공
			// column 속성 : 검색행의 컬럼명을 속성값으로 설정
			// property 속성 : 클래스의 필드명을 속성값으로 설정
			@Result(column="hewon_id", property = "id"),
			@Result(column="hewon_name", property = "name"),
			@Result(column="hewon_phone", property = "phone"),
			@Result(column="hewon_email", property = "email"),
			@Result(column="hewon_state", property = "state")
	})
	@Select("select * from myhewon order by hewon_id")
	List<MyHewon> selectHewonList();
	
	@Results(value={
			@Result(column="hewon_id", property = "id"),
			@Result(column="hewon_name", property = "name"),
			@Result(column="hewon_phone", property = "phone"),
			@Result(column="hewon_email", property = "email"),
			@Result(column="hewon_state", property = "state")
	})
	@Select("select * from myhewon where hewon name=#{name} order by hewon_id")
	List<MyHewon> selectNameHewonList(String name);
		// 아래 메소드도 매핑작업을 해줘야한다.
		// 이전에 등록한 Results 어노테이션을 재사용할 수 없음. (수동매핑 정보를 다시 사용 불가능)
		// 매핑정보를 select를 사용할 때마다 표기해야함.
		// XML의 resultMap은 재사용성, 상속 가능. -> XML 맵퍼를 함께 사용하는 이유. 
	
	@Results(value={
			@Result(column="hewon_id", property = "id"),
			@Result(column="hewon_name", property = "name"),
			@Result(column="hewon_phone", property = "phone"),
			@Result(column="hewon_email", property = "email"),
			@Result(column="hewon_state", property = "state")
	})
	// @SelectProvider : SELECT 명령이 반환되는 클래스의 메소드를 호출하여 SELECT 명령을
	// 등록하는 어노테이션 - 동적 SQL 기능을 제공하기 위한 클래스 작성
	// type 속성 : SQL 명령을 반환하는 메소드가 작성된 클래스(Clazz)를 속성값으로 설정
	// method 속성 : SQL 명령을 반환하는 메소드 명령을 속성값으로 설정
	@SelectProvider(type=MyHewonProvider.class, method = "selectDynamicHewonList")
	List<MyHewon> selectDynamicHewonList(Map<String, Object> map);

		// 단점 - 인터페이스 맵퍼만 단독으로 사용하는 것이 불편하기 때문에... 바인딩하여 사용
		// 1. 매핑정보를 재사용할 수 없다.
		// 2. provider 클래스 생성
	
		// 맵퍼 바인딩을 통해 sql 명령은 xml 맵퍼에 표기하고 dao에서 사용할 명령은 인터페이스를 이용한다. 
		// *resultMap & 동적 SQL 중요.*
}
