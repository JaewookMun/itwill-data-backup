package xyz.itwill.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import xyz.itwill.dto.MyHewon;

public interface MyHewonMapper {
	int insertHewon(MyHewon hewon);
	List<MyHewon> selectHewonList();
	List<MyHewon> selectDiscriminatorHewonList();
	List<MyHewon> selectStateHewonList(int state);
	String selectBeanHewonId(MyHewon hewon);
	// Map 인터페이스의 제네릭은 맵키 : String, 맵값 : Object 설정하여 사용
		// ㄴ일반적인 설정방식
	String selectMapHewonId(Map<String, Object> map);
	int insertMapHewon(Map<String, Object> map);
	List<Map<String, Object>> selectMapHewonList();
	
		// bean을 전달받음. bean=vo=dto 다 같은 이야기.
		// 일반적인 클래스는 다 vo 클래스다.
	// @Param : 추상메소드의 매개변수에 저장된 값을 XML 맵퍼의 엘리먼트에 등록된 SQL 명령에서
	// 사용할 수 있도록 제공하는 어노테이션
	// => value 속성값으로 SQL 명령에서 사용할 수 있는 이름 지정
	// => 다른 속성이 없는 경우 속성값만 설정 가능
	String selectParamHewonId(@Param(value="name") String name,@Param("phone") String phone);
		// 3.5버전에 나온것이기 때문에 이전버전에서는 사용할 수 없음.
	List<MyHewon> selectSearchHewonList(Map<String, Object> map);
	List<MyHewon> selectNameHewonList(String name);
	List<MyHewon> selectNameDynamicHewonList(Map<String, Object> map);
	List<MyHewon> selectDynamicHewonList(Map<String, Object> map);
	int updateHewon(MyHewon hewon);
	int updateDynamicHewon(MyHewon hewon);
	List<MyHewon> selectMultiDynamicHewonList(List<String> idList);
		
}
