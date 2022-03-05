package xyz.itwill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import xyz.itwill.dto.BoardDTO;

public class BoardDAO extends JdbcDAO {
	private static BoardDAO _dao;
	
	private BoardDAO() {
		
	}
	
	static {
		_dao=new BoardDAO();
	}
	
	public static BoardDAO getDAO() {
		return _dao;
	}
	
	// BOARD 테이블에 저장된 전체 게시글에 갯수를 검색하여 반환하는 메소드
	// => 검색 기능을 제공하기 위해 매개변수에 검색 관련 값을 전달받아 저장
	// public int selectBoardCount() {
	public int selectBoardCount(String search, String keyword) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count=0;
		
		try {
			con=getConnection();
			
			// 메소드의 매개변수에 저장된 값에 따라 다른 SQL 명령을 전달하여 실행되도록 설정
			// => 동적 SQL(Dynamic SQL)
				// 프로그램 생성시 굉장히 많이 사용된다.
			if(keyword.equals("")) { // 검색 기능을 사용하지 않은 경우
				String sql="select count(*) from board";
				pstmt=con.prepareStatement(sql);
			} else { // 검색 기능을 사용한 경우
				String sql="select count(*) from board WHERE "+search+" like '%'||?||'%' and status!=9";
					// keyword가 포함된 글을 검색 (삭제글이 아닌 경우)
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, keyword);
			}
			
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				count=rs.getInt(1);
					// 단일 컬럼이기 때문에 첫번째 값을 반환받아 저장
			}
			
		} catch (SQLException e) {
			System.out.println("[에러]selectBoardCount() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}

		return count;
	}
	
	
	// 게시글 시작 행번호화 게시글 종료 행번호를 전달받아 BOARD 테이블에 저장된 게시글에서
	// 시작행부터 종료행 범위의 게시글 목록을 검색하여 반환하는 DAO 클래스의 메소드 호출
	// public List<BoardDTO> selectBoardList(int startRow, int endRow){
	public List<BoardDTO> selectBoardList(int startRow, int endRow, String search, String keyword){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<BoardDTO> boardList = new ArrayList<BoardDTO>();
		
		try {
			con=getConnection();
			if(keyword.equals("")) {
				String sql="SELECT * FROM (SELECT rownum rn, temp.* "
						+ "FROM (SELECT * FROM board ORDER BY ref desc, re_step) temp) "
						+ "WHERE rn BETWEEN ? and ?";
				// 인라인뷰를 통해 rownum을 rn이라는 컬럼으로 표현 및 검색 한뒤 조건에 맞추어 검색
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
			} else {
				String sql="SELECT * FROM (SELECT rownum rn, temp.* "
						+ "FROM (SELECT * FROM board WHERE "+search+" like '%'||?||'%' and status!=9 "
						+ "ORDER BY ref desc, re_step) temp) WHERE rn BETWEEN ? and ? ";
				// 인라인뷰를 통해 rownum을 rn이라는 컬럼으로 표현 및 검색 한뒤 조건에 맞추어 검색
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, keyword);
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
			}
			
			rs=pstmt.executeQuery();
			while(rs.next()) {
				BoardDTO board = new BoardDTO();
				board.setNum(rs.getInt("num"));
				board.setId(rs.getString("id"));
				board.setWriter(rs.getString("writer"));
				board.setSubject(rs.getString("subject"));
				board.setRegDate(rs.getString("reg_date"));
				board.setReadcount(rs.getInt("readcount"));
				board.setRef(rs.getInt("ref"));
				board.setReStep(rs.getInt("re_step"));
				board.setReLevel(rs.getInt("re_level"));
				board.setContent(rs.getString("content"));
				board.setIp(rs.getString("ip"));
				board.setStatus(rs.getInt("status"));
				boardList.add(board);
			}
			
		} catch (SQLException e) {
			System.out.println("[에러]selectBoardList() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		
		return boardList;
	}
	
	// BOARD_SEQ 시퀀스 객체의 다음값(자동 증가값)을 검색하여 반환하는 메소드
	public int selectNextNum() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int nextNum=0;
		
		try {
			con=getConnection();
			
			String sql="SELECT board_seq.nextval FROM dual";
			pstmt=con.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				nextNum=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			System.out.println("[에러]selectNextNum() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return nextNum;
	}

	// 답글 관련 정보를 전달받아 BOARD 테이블에 저장된 게시글 관련 컬럼값을 변경하고 변경행의 갯수를 반환하는 메소드
	// => 게시글의 그룹번호가 부모글의 그룹번호와 같고 게시글의 글순서가 부모글의 글순서보다
	// 큰 게시글의 글순서 컬럼값이 1 증가되도록 변경
	public int updateReStep(int ref, int reStep) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		
		try {
			con=getConnection();
			String sql="UPDATE board SET re_step=re_step+1 WHERE ref=? AND re_step>?";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, ref);
			pstmt.setInt(2, reStep);
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]updateReStep() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		
		return rows;
	}

	// 게시글을 전달받아 BOARD 테이블에 삽입하여 저장하고 삽입행의 갯수를 반환하는 메소드
	public int insertBoard(BoardDTO board) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		
		try {
			con=getConnection();
			String sql="INSERT INTO board VALUES(?,?,?,?,sysdate,0,?,?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, board.getNum());
			pstmt.setString(2, board.getId());
			pstmt.setString(3, board.getWriter());
			pstmt.setString(4, board.getSubject());
			pstmt.setInt(5, board.getRef());
			pstmt.setInt(6, board.getReStep());
			pstmt.setInt(7, board.getReLevel());
			pstmt.setString(8, board.getContent());
			pstmt.setString(9, board.getIp());
			pstmt.setInt(10, board.getStatus());
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]insertBoard() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		
		return rows;
	}
	
	// 글번호를 전달받아 BOARD 테이블에 저장된 해당 글번호의 게시글을 검색하여 반환하는 메소드
	public BoardDTO selectNumBoard(int num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		BoardDTO board=null;
		
		try {
			con=getConnection();
			
			String sql="SELECT * FROM board WHERE num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				board=new BoardDTO();
				
				board.setNum(rs.getInt("num"));
				board.setId(rs.getString("id"));
				board.setWriter(rs.getString("writer"));
				board.setSubject(rs.getString("subject"));
				board.setRegDate(rs.getString("reg_date"));
				board.setReadcount(rs.getInt("readcount"));
				board.setRef(rs.getInt("ref"));
				board.setReStep(rs.getInt("re_step"));
				board.setReLevel(rs.getInt("re_level"));
				board.setContent(rs.getString("content"));
				board.setIp(rs.getString("ip"));
				board.setStatus(rs.getInt("status"));
			}
			
			
		} catch (SQLException e) {
			System.out.println("[에러]selectNumBoard() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		
		return board;
	}
	
	// 글번호를 전달받아 BOARD 테이블에 저장된 해당 글번호의 게시글 조회수를 변경하고 변경행의 갯수를 반환하는 메소드
	public int updateReadCount(int num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		
		try {
			con=getConnection();
			String sql="UPDATE board SET readcount=readcount+1 WHERE num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]updateReadCount() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	
	// 글번호를 전달받아 BOARD 테이블에 저장된 해당 글번호의 게시글을 삭제 처리하고 처리행의 갯수를 반환하는 메소드
		// 삭제된 것처럼 표현
	public int deleteBoard(int num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		
		try {
			con=getConnection();
			String sql="UPDATE board SET status=9 WHERE num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]deleteBoard() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	
	// 게시글을 전달받아 BOARD 테이블에 저장된 게시글을 변경하고 변경행의 갯수를 반환하는 메소드
	public int updateBoard(BoardDTO board) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		
		try {
			con=getConnection();
			String sql="UPDATE board SET subject=?, content=?, status=? WHERE num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, board.getSubject());
			pstmt.setString(2, board.getContent());
			pstmt.setInt(3, board.getStatus());
			pstmt.setInt(4, board.getNum());
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]updateBoard() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
}
