package xyz.itwill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import xyz.itwill.dto.GuestDTO;

public class GuestDAO extends JdbcDAO {
	private static GuestDAO _dao;
	
	static {
		_dao= new GuestDAO();
	}
	
	public static GuestDAO getDAO() {
		return _dao;
	}
	
	
	// 방명록 게시글을 전달받아 GUEST 테이블에 삽입하여 저장하고 삽입행의 갯수를 반환하는 메소드
	public int insertGuest(GuestDTO guest) {
		Connection con = null;
		PreparedStatement pstmt =null;
		int rows=0;
		
		try {
			con=getConnection();
			
			String sql="INSERT INTO guest VALUES(guest_seq.nextval, ?, sysdate, ?, ?)";
				// 자동생성 sequence 객체(글번호), oracle 시스템이 제공해주는 날짜 시스템
				// 시퀀스를 테이블에 적용하기 위해서는 INSERT 문을 이용해서 데이터를 입력하는 곳에 
				// "시퀀스명.NEXTVAL"를 입력하면 된다.(시퀀스는 대부분 INSERT 문과 사용)
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, guest.getName());
			pstmt.setString(2, guest.getTitle());
			pstmt.setString(3, guest.getContent());
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]insertGuest 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		
		return rows;
	}
	
	// 방명록 게시글의 글번호를 전달받아 GUEST 테이블에 저장된 해당 글번호의 방명록 게시글을 
	// 삭제하고 삭제행의 갯수를 반환하는 메소드
	public int deleteGuest(int no) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		
		try {
			con=getConnection();
			
			String sql="DELETE FROM guest WHERE no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			rows=pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("[에러]deleteGuest 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	
	// GUEST 테이블에 저장된 모든 게시글을 검색하여 반환하는 메소드
	public List<GuestDTO> selectAllGuestList() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<GuestDTO> guestList = new ArrayList<GuestDTO>();
		try {
			con = getConnection();
			String sql="SELECT * FROM guest ORDER BY no DESC";
				// 다중행은 order by를 통해 정렬해주는 것을 권장
			pstmt=con.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			while(rs.next()) {
				GuestDTO guest = new GuestDTO();
				guest.setNo(rs.getInt("no"));
				guest.setName(rs.getString("name"));
				guest.setRegDate(rs.getString("regdate"));
				guest.setTitle(rs.getString("title"));
				guest.setContent(rs.getString("content"));
				guestList.add(guest);
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectAllGuestList 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return guestList;
	}
	
		// ` Table 생성 > DTO 생성 > DAO 생성 > 웹프로그램 제작
}

