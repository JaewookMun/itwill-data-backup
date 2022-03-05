package xyz.itwill.mapper;

import java.util.List;

import xyz.itwill.dto.MyMember;

	// MyMemberXMLInterfaceMapper.xml�� �ϳ��� mapperó�� ����.
	// ���ε� �� mapper xml ������ �� ���� ���丮�� �־���� �ʿ�� ����.
	// sql ����� ��ϵ� ������Ʈ���� �߻�޼ҵ�� ǥ��
	/*
		element id - �߻�޼ҵ�
	 */
public interface MyMemberXMLInterfaceMapper {
	int insertMember(MyMember member);
	int updateMember(MyMember member);
	int deleteMember(String id);
	MyMember selectMember(String id);
	List<MyMember> selectMemberList();
}
