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
	
	// ���̸��� ���޹޾� Zip ���̺� ����� �����ȣ ���� ������ �˻��Ͽ� ��ȯ�ϴ� �޼ҵ�
	// => ���޹��� ���̸����� ���۵Ǵ� ��� �����ȣ���� �˻�
	public List<ZipDTO> selectZipList(String dong){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<ZipDTO> zipList=new ArrayList<ZipDTO>();
		
		try {
			con=getConnection();
			String sql="SELECT * FROM zip WHERE dong LIKE ?||'%' ORDER BY zipcode";
				// ?�� ���۵Ǵ� ��� ����
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
			System.out.println("[����]selectZipList() �޼ҵ��� SQL ���� = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return zipList;
	}
		// insert, delete, update�� �ʿ����.
}
