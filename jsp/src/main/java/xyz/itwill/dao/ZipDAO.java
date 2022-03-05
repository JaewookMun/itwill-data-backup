package xyz.itwill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import xyz.itwill.dto.ZipDTO;

public class ZipDAO extends JdbcDAO{
	
	private static ZipDAO _dao;
	
	private ZipDAO() {
		
	}
	
	static {
		_dao=new ZipDAO();
	}
	
	public static ZipDAO getDAO() {
		return _dao;
	}
	
	// 동이름을 전달받아 Zip 테이블에 저장된 우편번호 관련 정보를 검색하여 반환하는 메소드
	// => 전달받은 동이름으로 시작되는 모든 우편번호정보 검색
	public List<ZipDTO> selectZipList(String dong){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<ZipDTO> zipList=new ArrayList<ZipDTO>();
		
		try {
			con=getConnection();
			String sql="SELECT * FROM zip WHERE dong LIKE ?||'%' ORDER BY zipcode";
				// ?로 시작되는 모든 문자
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, dong);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				ZipDTO zip = new ZipDTO();
				zip.setZipcode(rs.getString("zipcode"));
				zip.setDong(rs.getString("dong"));
				zip.setAddress(rs.getString("address"));
				zipList.add(zip);
			}
			
		} catch (SQLException e) {
			System.out.println("[에러]selectZipList() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return zipList;
	}
		// insert, delete, update가 필요없다.
}
