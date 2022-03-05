package xyz.itwill.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//PreparedStatement : ���ӵ� DBMS ������ SQL ����� �����Ͽ� ����� ����� ��ȯ�ϴ� ����� �����ϴ� �ν��Ͻ�
//���� : InParameter�� �̿��Ͽ� ���� ���޹޾� SQL ��� �ۼ�
//=> InParameter�� ����Ͽ� �������� ���������� ȿ���� ����
//=> InSQL ��ŷ ��� ��ȿȭ ó�� - ����� �Է°��� ������ SQL ����� ������ ó��
//���� : PreparedStatement �ν��Ͻ��� �ϳ��� SQL ��ɸ��� �����Ͽ� ���� ����
	//SQL����� ������ŭ PreparedStatement �ν��Ͻ��� �������� �Ѵ�.
	//web ���α׷��� ���� ����ڰ� ���� �Է��ϴ� ���α׷��� ���� ���� PreparedStatement�� ��� (���ȼ�)
	//SQL��ɹ��� �����ڰ� �ۼ��ϴ� ���α׷��� ���� ���� Statement�� ��� - 'Statement'�� �⺻�̴�. (super) / PreparedStatement, CallableStatement (sub) 
	//[e.g. SQL Developer]
public class PreparedStatementApp {

	public static void main(String[] args) throws IOException, SQLException {
		/*
		//Ű����� �л������� �Է¹޾� STUDENT ���̺� �����Ͽ� �����ϰ� STUDENT ���̺�
		//����� ��� �л������� �˻��Ͽ� ����ϴ� JDBC ���α׷�
		
		//Ű����� �л������� �Է¹ޱ� ���� �Է� ��Ʈ�� ����
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		//Ű����� �л������� �Է¹޾� ����
			//Basically, validation test should be carried out.
		System.out.println("<< �л����� �Է�>>");
		System.out.print("�й� �Է� >> ");
		int no = Integer.parseInt(in.readLine());
		System.out.print("�̸� �Է� >> ");
		String name = in.readLine();
		System.out.print("��ȭ��ȣ �Է� >> ");
		String phone = in.readLine();
		System.out.print("�ּ� �Է� >> ");
		String address = in.readLine();
		System.out.print("������� �Է� >> ");
		String birthday = in.readLine();
		System.out.println("============================================================");
		//�Էµ� �л������� STUDENT ���̺� ������ �����Ͽ� ����
		Connection con=ConnectionFactory.getConnection();
		
		//con.prepareStatement(String sql) : ���ӵ� DBMS ������ ���޵� SQL ����� 
		//������ PreparedStatement �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
		//=> PreparedStatement �ν��Ͻ��� ����� SQL ��ɿ��� ?(InParameter) ��ȣ ���
		//InParameter : Java �������� �����޾� SQL ����� ������ ǥ���ϱ� ���� ��ȣ
		//=> ��� InParameter���� �ݵ�� Java �������� ���޵Ǿ�߸� SQL ����� �ϼ��Ͽ� ���� ����
		//PreparedStatement.setXXX(int parameterIndex, XXX value)
		//=> ���ϴ� ��ġ�� InParameter�� Java �������� �����ϴ� �޼ҵ�
		//=> XXX�� Java �ڷ����� ǥ���ϸ� �޼ҵ�� InParameter�� ������ŭ ȣ��
			//PreparedStatement�� �̸� sql������ �����ؾ��Ѵ�.
		String sql1="INSERT INTO student VALUES(?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql1);
			//ù��° InParameter���� no�� �ι�° ���Ķ���Ϳ��� name�� ... 
		pstmt.setInt(1, no);
		pstmt.setString(2, name);
		pstmt.setString(3, phone);
		pstmt.setString(4, address);
		pstmt.setString(5, birthday);
		
		//PreparedStatement.executeUpdate() : PreparedStatement �ν��Ͻ��� ����� SQL ���
		//(INSERT, UPDATE, DELETE)�� �����ϴ� �޼ҵ� - �������� ����(int) ��ȯ
			//PreparedStatement �ν��Ͻ��� �̹� SQL����� �ϼ��Ǿ� ����Ǿ� �ֱ� ������ �޼ҵ��� ��ȣ�� �Ű������� ���� �ʴ´�.
		int rows=pstmt.executeUpdate();
		System.out.println("[���]"+rows+"���� �л������� ���� �Ͽ����ϴ�.");
		System.out.println("============================================================");
		//STUDENT ���̺� ����� ��� ��(�л�����)�� �˻��Ͽ� ���
		String sql2="SELECT * FROM student ORDER BY no";
		pstmt=con.prepareStatement(sql2);
		
		//PreparedStatement.executeQuery() : PreparedStatement �ν��Ͻ��� ����� SQL ���
		//(SELECT)�� �����ϴ� �޼ҵ� - ������(ResultSet �ν��Ͻ�) ��ȯ
		ResultSet rs=pstmt.executeQuery();
		
		System.out.println("<<�л���� ���>>");
		while(rs.next()) {
			System.out.println("�й� = "+rs.getInt("no")+", �̸� = "+rs.getString("name"));
		}
		ConnectionFactory.close(con, pstmt, rs);
		System.out.println("============================================================");
		*/
		
		//Ű����� �л������� �Է¹޾� STUDENT ���̺� �����Ͽ� �����ϰ� STUDENT ���̺�
		//����� ��� �л������� �˻��Ͽ� ����ϴ� JDBC ���α׷�
		
		//Ű����� �л������� �Է¹ޱ� ���� �Է� ��Ʈ�� ����
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		//Ű����� �л������� �Է¹޾� ����
			//Basically, validation test should be carried out.
		System.out.println("<< �л����� �˻�>>");
		System.out.print("�̸� �Է� >> ");
		String name = in.readLine();
		System.out.println("============================================================");
		//�Էµ� �л������� STUDENT ���̺� ������ �����Ͽ� ����
		Connection con=ConnectionFactory.getConnection();
		
		//InParameter�� Java �������� ������ SQL ����� �����θ� �νĵǾ� ó��
			//InSQL ��ŷ����� ����� �� ����. - Java�� ������� ���� PreparedStatement ��� 
		String sql = "SELECT * FROM student WHERE name=? ORDER BY no";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, name);
		
		ResultSet rs=pst.executeQuery();
		
		if(rs.next()) {
			do { //���� �̸��� ���� ����� ���� �� �ֱ� ������ �ݺ�ó��
				System.out.println("�й� = "+rs.getInt("no")+", �̸� = "+rs.getString("name"));
			} while(rs.next());
		} else {
			System.out.println("�˻��� �л������� �����ϴ�.");
		}
		
		ConnectionFactory.close(con, pst, rs);
		System.out.println("============================================================");
	}
}
