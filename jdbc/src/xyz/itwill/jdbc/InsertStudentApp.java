package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//JDBC ���α׷��� �ۼ��ϱ� ���� JDBC Driver ���� Ŭ������ ���Ե� ���̺귯���� ���� ó��
//=> Oracle JDBC Driver : ojdbc6.jar 
	//build ó��

//STUDENT ���̺� : �й�(������-PRIMARY KEY),�̸�(������),��ȭ��ȣ(������),�ּ�(������),�������(��¥��)
//CREATE TABLE STUDENT(NO NUMBER(4) PRIMARY KEY, NAME VARCHAR2(30), PHONE VARCHAR2(20)
//, ADDRESS VARCHAR2(100), BIRTHDAY DATE);
	//JDBC�� ���� ���� ������ �������� ����

//STUDENT ���̺� �л�����(��)�� �����Ͽ� �����ϴ� JDBC ���α׷�
public class InsertStudentApp {
	public static void main(String[] args) {
		//JDBC ���� �ν��Ͻ��� �����ϱ� ���� ���������� try ���� �ۿ��� ����
		//=> ��� �������� ���������� ����Ͽ� �޼ҵ� ȣ�� ����
		Connection con=null;
		Statement stmt=null;
		
		try {
			//1.OracleDriver Ŭ������ �ν��Ͻ��� �����Ͽ� DriverManager Ŭ������ JDBC Driver�� ���
				//DriverŬ������ library���� �ٸ�. 
			//JDBC Driver : DriverManager Ŭ������ ��ϵ� �ټ��� Driver �ν��Ͻ�
			//=> Driver �ν��Ͻ� : DBMS ������ ������ �� �ִ� ��� ����
			//=> ���� URL �ּҷ� DBMS ������ ������ �� �ִ� ��� ���� 
				//Oracle, MySQL, ... etc. Driver ����
			
			//DriverManager Ŭ���� : JDBC Driver�� �����ϱ� ���� ����� �����ϴ� Ŭ����
				//DriverManager���� �پ��� DBMS�� ������ �� �ִ� Driver���� �� �� �ִ�.
			
			/*
			//DriverManager.registerDriver(Driver driver) : Driver �ν��Ͻ��� DriverManager
			//Ŭ������ JDBC Driver�� ����ϴ� �޼ҵ�
			//OracleDriver Ŭ������ �ټ��� �ν��Ͻ��� �����Ͽ� JDBC Driver�� ��� ����
			//=> ���ʿ��� JDBC Driver�� ���� ����
				//Driver�� ������ ����� �ʿ䰡 ���� - SQL Developer�� ������ ��ġ�ϴ� �Ͱ� ����.
				//�޸𸮿� ���ʿ��� ����̹��� ��ϵ� �� ���� - DriverManager �ȿ� ���� ����̹��� 2���� ����
			DriverManager.registerDriver(new OracleDriver());
				//�� ����� ����ϸ� OricleDriver�� JDBC ����̹��� 2�� ��ϵȴ�. 
				  - Ŭ���� �ε�� 1��, ~.registerDriver() �ڵ� �ۼ��� 1��
			*/
			
			//OracleDriver Ŭ������ �о� �޸𸮿� ����
			//=> OracleDriver Ŭ������  ���� �������� OracleDriver Ŭ������ �ν��Ͻ��� �����Ͽ�
			//   DriverManager Ŭ������ JDBC Driver�� ��� ó�� - 1�� ����
				//�Ȱ��� ����̹��� ������ ���� ����ϴ� ���� �߻������ʴ´�.
				//OracleDriver Ŭ������ �̹� ������ ������������ �ν��Ͻ��� �����ȴ�.
				//�ش� �ڵ带 �ߺ� �ۼ��ص� ����̹� ó���� 1�� �߻��Ǳ� ������ ���ʿ��� ����̹��� ��ϵ��� �ʴ´�.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. JDBC Driver�� �̿��Ͽ� DBMS ������ �����ϰ� ��������(Connection �ν��Ͻ�)��
			//��ȯ�޾� ����
			//DriverManager.getConnection(String url, String user, String password)
			//=> DBMS ������ �����ϴ� �޼ҵ� - ���� ������ Connection �ν��Ͻ��� ��ȯ
			//=> �޼ҵ��� �Ű������� ���޵� URL ������ ���� Ư�� DBMS ������ ����
			//=> ���� ������ �����ϸ� SQLException �߻�
			//SQLException : JDBC ���� �ν��Ͻ��� �޼ҵ忡�� �߻��Ǵ� ����
			//=> DBMS���� ���� ���� �Ǵ� SQL ��ɿ� ������ �ִ� ��� ��� ���ܰ� �߻�
				//������ ���� ������ ���� �ν��Ͻ� ��ȯ
			
			//URL : ���ͳݿ� �����ϴ� �ڿ��� ǥ���ϱ� ���� �ּ�
			//=> Protocol:ServerName:Port:Resource - ex) https:www.daum.net:80
			//Oracle DBMS Server�� ���� JDBC URL
			//����)jdbc:oracle:thin:@ServerName:Port:SID
				//jdbc: - main protocol , oracle: & thin: - sub protocol
				//thin : �����ϰ� �����ϰڴٴ� �ǹ�
				//SID : ����DB�� ������(�ĺ���)
				//https - protocol
				//locolhost : �ڱ� ��ǻ�� - �ٸ� ��ǻ�� ���ӽ� IP�ּ� ǥ��
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="scott";
			String password="tiger";
			//Connection : DBMS ������ ���������� �����ϱ� ���� �ν��Ͻ�
			//=> Connection �������̽��� �ڽ� Ŭ������ �ν��Ͻ��� ��ȯ�޾� ����
			con= DriverManager.getConnection(url, user, password);
			
			//3. ���ӵ� DBMS������ SQL ����� �����ϱ� ���� Statement �ν��Ͻ��� ��ȯ�޾� ����
			//Connection.createStatement() : Connection �ν��Ͻ��κ��� SQL ����� ������
			//�� �ִ� Statement �ν��Ͻ��� �����Ͽ� �����ϴ� �޼ҵ� - SQLException �߻�
			//Statement : ���ӵ� DBMS ������ SQL ����� �����ϱ� ���� �ν��Ͻ�
			//=> Statement �������̽��� �ڽ� Ŭ������ �ν��Ͻ��� ��ȯ�޾� ����
			stmt = con.createStatement();
			
			//4. Statement �ν��Ͻ��� ���ӵ� DBMS ������ SQL ����� �����Ͽ� �����ϰ� ����� 
			//������� ��ȯ�޾� ����
			//Statement.executeUpdate(String sql) : INSERT, UPDATE, DELETE ����� ������ �����ϴ� �޼ҵ� - SQLException �߻�
			//=> �������� ����(int) ��ȯ
			//Statement.executeQuery(String sql) : SELECT ����� ������ �����ϴ� �޼ҵ� - SQLException �߻�
			//=> �˻���(ResultSet �ν��Ͻ�) ��ȯ
				//insert, update, delete�� ���� ����
			//String sql = "insert into student values(1000,'ȫ�浿','010-4635-5123','����� ������','1999-12-31')";
			//String sql = "insert into student values(2000,'�Ӳ���','010-7841-8711','������ �ȴޱ�','2000-01-01')";
			String sql = "insert into student values(3000,'����ġ','010-2871-7888','��õ�� ���̱�','1997-05-06')";
			int rows=stmt.executeUpdate(sql);
			
			//5. SQL ����� �������� ó�� - ��� �Ǵ� ��ȯ
				//��� - ���α׷� / ��ȯ - �޼ҵ�
			System.out.println("[�޼���]"+rows+"���� �л������� ���� �Ͽ����ϴ�.");
			
				//�ڹٿ����� �ν��Ͻ��� �ڵ������� �������� �ʴ´�. (GC�� ���ֱ� �ϴµ� ���� ���������� �𸥴�.)
			
		} catch (ClassNotFoundException e) {
				//�Ʒ� ��ɹ��� ����ȴٸ� Driver�� Build�� �ȵǾ��ų� �̸��� �߸� ǥ���� ����̴�.
			System.out.println("[����]OracleDriver Ŭ������ ã�� �� �����ϴ�.");
		} catch (SQLException e) {
			System.out.println("[����]JDBC ���� ����"+e.getMessage());
				// ��� Oracle DB���� ������ �߻��ϸ� JDBC���� �߻�
			
		} finally {//���ܿ� ������� ����� ����� �ۼ�
				//������ �߻����ο� ������� ������ ���� ���� finally�ܿ� ����.
			//6. JDBC ���� �ν��Ͻ� ���� - close() �޼ҵ� ȣ�� - SQLException �߻�
			//=> �ν��Ͻ� ������ �ݴ� ������� ����
			try {
				//if ������ �̿��Ͽ� NullPointerException �߻� ����
				if(stmt!=null) stmt.close();
				if(con!=null) con.close();//DBMS ���� ���� ����
					//����Ŭ�� ���̼����� ����� �� ���������� ���� ���Ѵ�. - connection�� �� �����������.
			} catch (SQLException e) {
					//SQL ���� �޼ҵ�� ��� �߻� SQLException  
				e.printStackTrace();
			}
			
		}
		
		
		
	}
}
