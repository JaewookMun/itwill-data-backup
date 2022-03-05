package xyz.itwill10.dao;

import java.util.List;
import java.util.Map;

import xyz.itwill10.dto.RestBoard;

public interface RestBoardDAO {
	int insertRestBoard(RestBoard board);
	int updateRestBoard(RestBoard board);
	int deleteRestBoard(int num);
	int selectRestBoardCount();
	RestBoard selectRestBoard(int num);
	List<RestBoard> selectRestBoardList(Map<String, Object> map);
		// mapper와 DAO의 메소드 이름이 같을 필요는 없음. - sql명령을 전달하기 때문에 똑같이 사용한다고 하심.
}
