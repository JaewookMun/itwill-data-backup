package xyz.itwill10.mapper;

import java.util.List;
import java.util.Map;

import xyz.itwill10.dto.RestBoard;

public interface RestBoardMapper {
	int insertRestBoard(RestBoard board);
	int updateRestBoard(RestBoard board);
	int deleteRestBoard(int num);
	int selectRestBoardCount();
	RestBoard selectRestBoard(int num);
	List<RestBoard> selectRestBoardList(Map<String, Object> map);
	
	
		// 만약 검색기능을 구현하려면 매개변수에 Map이 있어야 한다.
}
