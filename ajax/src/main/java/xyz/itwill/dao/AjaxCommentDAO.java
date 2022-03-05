package xyz.itwill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import xyz.itwill.dto.AjaxCommentDTO;

public class AjaxCommentDAO extends JdbcDAO {
	private static AjaxCommentDAO _dao;
	
	private AjaxCommentDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new AjaxCommentDAO();
	}
	
	public static AjaxCommentDAO getDAO() {
		return _dao;
	}
	
	// ��������� ���޹޾� AJAX_COMMENT ���̺��� �����Ͽ� �����ϰ� �������� ������ ��ȯ�ϴ� �޼ҵ�
	public int insertAjaxComment(AjaxCommentDTO ajaxComment) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		
		try {
			con=getConnection();
			String sql="INSERT INTO ajax_comment VALUES(ajax_comment_seq.nextval,?,?,sysdate)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, ajaxComment.getWriter());
			pstmt.setString(2, ajaxComment.getContent());
			
			rows=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("[����] insertAjaxComment() �޼ҵ��� SQL ����"+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		
		return rows;
	}
	
	// ��������� ���޹޾� AJAX_COMMENT ���̺��� ����� �ش� ��������� �����ϰ� �������� ������ ��ȯ�ϴ� �޼ҵ�
	public int updateAjaxComment(AjaxCommentDTO ajaxComment) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		
		try {
			con=getConnection();
			String sql="UPDATE ajax_comment SET writer=?, content=? WHERE num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, ajaxComment.getWriter());
			pstmt.setString(2, ajaxComment.getContent());
			pstmt.setInt(3, ajaxComment.getNum());
			
			rows=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("[����] updateAjaxComment() �޼ҵ��� SQL ����"+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		
		return rows;
	}
	
	// ��۹�ȣ�� ���޹޾� AJAX_COMMENT ���̺��� ����� �ش� ��������� �����ϰ� �������� ������ ��ȯ�ϴ� �޼ҵ�
	public int deleteAjaxComment(int num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		
		try {
			con=getConnection();
			String sql="DELETE FROM ajax_comment WHERE num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rows=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("[����] deleteAjaxComment() �޼ҵ��� SQL ����"+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		
		return rows;
	}
	
	// ��۹�ȣ�� ���޹޾� AJAX_COMMENT ���̺��� ����� �ش� ��������� �˻��Ͽ� ��ȯ�ϴ� �޼ҵ�
	public AjaxCommentDTO selectAjaxComment(int num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		AjaxCommentDTO ajaxComment=null;
		
		try {
			con=getConnection();
			String sql="SELECT * FROM ajax_comment WHERE num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				ajaxComment=new AjaxCommentDTO();
				ajaxComment.setNum(rs.getInt("num"));
				ajaxComment.setWriter(rs.getString("writer"));
				ajaxComment.setContent(rs.getString("content"));
				ajaxComment.setWriteDate(rs.getString("write_date"));
			}
		} catch (SQLException e) {
			System.out.println("[����] selectAjaxComment() �޼ҵ��� SQL ����"+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		
		return ajaxComment;
	}
	
	
	// AJAX_COMMENT ���̺��� ����� ��� ��������� �˻��Ͽ� ��ȯ�ϴ� �޼ҵ�
	public List<AjaxCommentDTO> selectAjaxCommentList(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<AjaxCommentDTO> ajaxCommentList=new ArrayList<AjaxCommentDTO>();
		
		try {
			con=getConnection();
			String sql="SELECT * FROM ajax_comment ORDER BY num DESC";
			pstmt=con.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				AjaxCommentDTO ajaxComment=new AjaxCommentDTO();
				ajaxComment.setNum(rs.getInt("num"));
				ajaxComment.setWriter(rs.getString("writer"));
				ajaxComment.setContent(rs.getString("content"));
				ajaxComment.setWriteDate(rs.getString("write_date"));
				ajaxCommentList.add(ajaxComment);
			}
			
		} catch (SQLException e) {
			System.out.println("[����] selectAjaxCommentList() �޼ҵ��� SQL ����"+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		
		return ajaxCommentList;
	}
	
}