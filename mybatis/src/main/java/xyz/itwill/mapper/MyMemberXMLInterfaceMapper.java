package xyz.itwill.mapper;

import java.util.List;

import xyz.itwill.dto.MyMember;

	// MyMemberXMLInterfaceMapper.xml과 하나의 mapper처럼 동작.
	// 바인딩 시 mapper xml 파일이 꼭 같은 디렉토리에 있어야할 필요는 없다.
	// sql 명령이 등록된 엘리먼트들을 추상메소드로 표현
	/*
		element id - 추상메소드
	 */
public interface MyMemberXMLInterfaceMapper {
	int insertMember(MyMember member);
	int updateMember(MyMember member);
	int deleteMember(String id);
	MyMember selectMember(String id);
	List<MyMember> selectMemberList();
}
