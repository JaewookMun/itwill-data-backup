package xyz.itwill10.dao;

import java.util.List;

import xyz.itwill10.dto.PointBoard;

public interface PointBoardDAO {
	int insertPointBoard(PointBoard board);
	int deletePointBoard(int num);
	PointBoard selectPointBoard(int num);
	List<PointBoard> selectPointBoardList();
}

	// interface mapper와 interface DAO를 같은걸로 사용해도 된다. 하지만 분리시켜서 사용하심.
