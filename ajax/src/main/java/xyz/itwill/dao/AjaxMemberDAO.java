package xyz.itwill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import xyz.itwill.dto.AjaxMemberDTO;

public class AjaxMemberDAO extends JdbcDAO {
	private static AjaxMemberDAO _dao;
	
	private AjaxMemberDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new AjaxMemberDAO();
	}
	
	public static AjaxMemberDAO getDAO() {
		return _dao;
	}
	
	// 회원정보를 전달받아 AJAX_MEMBER 테이블에 삽입하여 저장하고 삽입행의 갯수를 반환하는 메소드
	public int insertAjaxMember(AjaxMemberDTO ajaxMember) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		
		try {
			con=getConnection();
			String sql="INSERT INTO ajax_member VALUES(?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, ajaxMember.getId());
			pstmt.setString(2, ajaxMember.getPasswd());
			pstmt.setString(3, ajaxMember.getName());
			pstmt.setString(4, ajaxMember.getEmail());
			
			rows=pstmt.executeUpdate();
			
		} catch(SQLException e) {
			System.out.println("[에러]insertAjaxMember() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	
	// 아이디를 전달받아 AJAX_MEMBER 테이블에 저장된 해당 아이디의 회원정보를 검색하여 반환하는 메소드
	public AjaxMemberDTO selectAjaxMember(String id) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		AjaxMemberDTO ajaxMember=null;
		
		try {
			con=getConnection();
			String sql="SELECT * FROM ajax_member WHERE id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs=pstmt.executeQuery();
			if(rs.next()) {
				ajaxMember=new AjaxMemberDTO();
				ajaxMember.setId(rs.getString("id"));
				ajaxMember.setPasswd(rs.getString("passwd"));
				ajaxMember.setName(rs.getString("name"));
				ajaxMember.setEmail(rs.getString("email"));
			}
			
		} catch (SQLException e) {
			System.out.println("[에러]selectAjaxMember() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		
		return ajaxMember;
	}
	
	// 이름과 이메일을 전달받아 AJAX_MEMBER 테이블에 저장된 해당 회원의 아이디를 검색하여 반환하는 메소드
	public String selectAjaxMemberId(String name, String email) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String searchId=null;
		
		try {
			con=getConnection();
			String sql="SELECT id FROM ajax_member WHERE name=? AND email=?";
				// select *을 할 경우 불필요한 정보까지 모두 검색된다.
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				// searchId=rs.getString(1);
					// 검색행에 컬럼이 하나만 있기 때문에 굳이 컬럼명을 사용하지 않아도 된다.
				searchId=rs.getString("id");
			}
			
		} catch (SQLException e) {
			System.out.println("[에러]selectAjaxMemberId() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		
		return searchId;
	}
	
	// 이름과 이메일이 저장된 회원정보를 전달받아 AJAX_MEMBER 테이블에 저장된 해당 회원의 
	// 아이디를 검색하여 반환하는 메소드
	public String selectAjaxMemberId(AjaxMemberDTO ajaxMember) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String searchId=null;
		
		try {
			con=getConnection();
			String sql="SELECT id FROM ajax_member WHERE name=? AND email=?";
				// select *을 할 경우 불필요한 정보까지 모두 검색된다.
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, ajaxMember.getName());
			pstmt.setString(2, ajaxMember.getEmail());
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				// searchId=rs.getString(1);
					// 검색행에 컬럼이 하나만 있기 때문에 굳이 컬럼명을 사용하지 않아도 된다.
				searchId=rs.getString("id");
			}
			
		} catch (SQLException e) {
			System.out.println("[에러]selectAjaxMemberId() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		
		return searchId;
	}
}
