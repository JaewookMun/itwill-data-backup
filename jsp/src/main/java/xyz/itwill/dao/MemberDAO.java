package xyz.itwill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import xyz.itwill.dto.MemberDTO;

public class MemberDAO extends JdbcDAO{
	private static MemberDAO _dao;
	
	private MemberDAO() {
		
	}
	
	static {
		_dao=new MemberDAO();
	}
	
	public static MemberDAO getDAO() {
		return _dao;
	}
	
	// 회원정보를 전달받아 MEMBER 테이블에 삽입하여 저장하고 삽입행의 갯수를 반환하는 메소드
	public int insertMember(MemberDTO member) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		
		try {
			con=getConnection();
	
			String sql="INSERT INTO member VALUES(?,?,?,?,?,?,?,?,SYSDATE,null,1)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPasswd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getMobile());
			pstmt.setString(6, member.getZipcode());
			pstmt.setString(7, member.getAddress1());
			pstmt.setString(8, member.getAddress2());
			
			rows=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("[SQL] insertMember() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		
		return rows;
	}
	
	// 아이디를 전달받아 MEMBER 테이블에 저장된 회원정보를 검색하여 반환하는 메소드
	public MemberDTO selectIdMember(String id) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		MemberDTO member=null;
			// rs.next가 없을 경우 null이 반환된다.
		
		try {
			con=getConnection();
			
			String sql="SELECT * FROM member WHERE id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs=pstmt.executeQuery();
			if(rs.next()) {
					// 존재할 경우 생성하여 제공
				member=new MemberDTO();
				member.setId(rs.getString("id"));
				member.setPasswd(rs.getString("passwd"));
				member.setName(rs.getString("name"));
				member.setEmail(rs.getString("email"));
				member.setMobile(rs.getString("mobile"));
				member.setZipcode(rs.getString("zipcode"));
				member.setAddress1(rs.getString("address1"));
				member.setAddress2(rs.getString("address2"));
				member.setJoinDate(rs.getString("join_date"));
				member.setLastLogin(rs.getString("last_login"));
				member.setStatus(rs.getInt("status"));
				
			}
			
		} catch (SQLException e) {
			System.out.println("[SQL] insertMember() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		
		return member;
	}
	
	
	// 아이디를 전달받아 MEMBER 테이블에 저장된 해당 회원정보의 마지막 로그인 날짜를 변경하고
	// 변경행의 갯수를 반환하는 메소드
	public int updateLastLogin(String id) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		
		try {
			con=getConnection();
			String sql="UPDATE member SET last_login=sysdate WHERE id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[SQL] updateLastLogin() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		
		return rows;
	}
	
	
	// 회원정보를 전달받아 MEMBER 테이블에 저장된 회원정보를 변경하고 변경행의 갯수를 반환하는 메소드
	public int updateMember(MemberDTO member) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		
		try {
			con=getConnection();
			String sql="UPDATE member SET passwd=?, name=?, email=?, mobile=?, zipcode=?, address1=?, address2=? WHERE id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, member.getPasswd());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getEmail());
			pstmt.setString(4, member.getMobile());
			pstmt.setString(5, member.getZipcode());
			pstmt.setString(6, member.getAddress1());
			pstmt.setString(7, member.getAddress2());
			pstmt.setString(8, member.getId());
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[SQL] updateMember() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		
		return rows;
	}
	
	
	// 아이디를 전달받아 MEMBER 테이블에 저장된 해당 아이디의 회원정보를 삭제하고 삭제행의 
	// 갯수를 반환하는 메소드
	public int deleteMember(String id) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		
		try {
			con=getConnection();
			String sql="DELETE FROM member WHERE id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[SQL] deleteMember() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		
		return rows;
			// (현업에서는)실제로는 회원이 탈퇴한다고해서 회원정보를 테이블에서 삭제하는 것은 아니다.
			// update를 통해서 status를 0으로 변경하여 보이지 않게 처리. 
			// 완전히 삭제하는 것이 아니라 삭제된 것처럼 처리
			// delete보다는 update를 많이 사용
	}
	
	
	// MEMBER 테이블에 저장된 모든 회원정보를 검색하여 반환하는 메소드
	public List<MemberDTO> selectAllMemberList() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		List<MemberDTO> memberList = new ArrayList<MemberDTO>();
		
		try {
			con=getConnection();
			
			String sql="SELECT * FROM member ORDER BY id";
			pstmt=con.prepareStatement(sql);
			
			rs=pstmt.executeQuery();

			while(rs.next()) {
				MemberDTO member=new MemberDTO();
				
				member.setId(rs.getString("id"));
				member.setPasswd(rs.getString("passwd"));
				member.setName(rs.getString("name"));
				member.setEmail(rs.getString("email"));
				member.setMobile(rs.getString("mobile"));
				member.setZipcode(rs.getString("zipcode"));
				member.setAddress1(rs.getString("address1"));
				member.setAddress2(rs.getString("address2"));
				member.setJoinDate(rs.getString("join_date"));
				member.setLastLogin(rs.getString("last_login"));
				member.setStatus(rs.getInt("status"));
				
				memberList.add(member);
			}
			
		} catch (SQLException e) {
			System.out.println("[SQL] selectAllMemberList() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		
		return memberList;
	}
	
	
	// 아이디와 상태를 전달받아 MEMBER 테이블에 저장된 해당 아이디의 회원상태를 변경하고
	// 변경행의 갯수를 반환하는 메소드
	public int updateStatus(String id, int status) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		
		try {
			con=getConnection();
			String sql="UPDATE member SET status=? WHERE id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, status);
			pstmt.setString(2, id);
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[SQL] updateStatus() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
		
}
