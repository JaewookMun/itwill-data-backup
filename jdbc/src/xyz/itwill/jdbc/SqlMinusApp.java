package xyz.itwill.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

//Ű����� SQL ���(INSERT,UPDATE,DELETE,SELECT)�� �Է¹޾� DBMS ������ �����Ͽ� �����
//����� ����ϴ� JDBC ���α׷�
//=> SQL ����� ��� �Է¹޾� DBMS ������ �����Ͽ� ����� ����� ���
//=> SQL ��� ��� [EXIT]�� �Է��� ��� ���α׷� ���� - ��ҹ��� �̱���
//=> Ű����� �Էµ� SQL ����� �߸��� ��� ���� �޼��� ��� - SQLException�� ���� ����ó��
//=> SQLPLUS ���α׷��� �����Ͽ� ó�� ��� ���
	//����ڰ� � ����� �Է��� �� �𸣴ϱ� execute() �޼ҵ带 ����ؾ���.
	//�÷����� ����ؾ��ϱ� ������ ResultSetMetadata�� �˾ƾ���.
public class SqlMinusApp {
	public static void main(String[] args) throws Exception {
		//Ű����� SQL ����� �Է¹ޱ� ���� �Է� ��Ʈ�� ����
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));	
		
		Connection con=ConnectionFactory.getConnection();
		Statement st = con.createStatement();
		ResultSet rs=null;
		
		while(true) {
			//Ű����� SQL ����� �Է¹޾� ����
			System.out.print("SQL> ");
			String sql=in.readLine().trim();
			
			if(sql.equalsIgnoreCase("exit")) break;
			if(sql==null || sql.equals("")) continue;
			
			try {
				//Ű����� �Է¹��� SQL ����� �����Ͽ� ����
				if(st.execute(sql)) { //DQL
					rs=st.getResultSet();
					
					
					if(rs.next()) { //�˻����� �ִ� ���
						//�˻��࿡ ���� �ΰ����� ������ ��ȯ�޾� ����
						ResultSetMetaData rsmd = rs.getMetaData();
						
						//�˻��࿡ ���� �÷��� ������ ��ȯ�޾� ����
						int columnCount = rsmd.getColumnCount();
						
						System.out.println("=========================================================");
						//�˻����� �÷����� ��ȯ�޾� ���
						for(int i=1; i<=columnCount; i++) {
							System.out.print(rsmd.getColumnLabel(i)+"\t");
						}
						System.out.println();
						System.out.println("=========================================================");
						//�˻����� �÷����� ��ȯ�޾� ��� - �ݺ� ó��
						do {
							for(int i=1; i<=columnCount; i++) {
								String columnValue=rs.getString(i);
								if(rsmd.getColumnTypeName(i).equals("DATE")) {
									columnValue=columnValue.substring(0, 10);
								}
								if(columnValue==null) {
									columnValue="    ";
								}
								System.out.print(columnValue+"\t");
							}
							System.out.println();
							
						} while(rs.next());
						
					} else { //�˻����� ���� ���
						System.out.println("�˻��� ����� �����ϴ�.");
					}
					
					
				} else { //DML
					int rows = st.getUpdateCount();
					System.out.println(rows+"���� ���� "+sql.substring(0,6).toUpperCase()+" �Ͽ����ϴ�.");
				}
				
			} catch (SQLException e) {
				//Ű����� �Է¹޾� �����Ͽ� ����� SQL ����� �߸��� ��� SQLException �߻�
				System.out.println("SQL ���� = "+e.getMessage());
			} 
			
		}
		
		ConnectionFactory.close(con, st, rs);
		System.out.println("[�޼���]SQLMinus ���α׷��� �����մϴ�.");
	}
}
