package xyz.itwill.dbcp;

import java.sql.Connection;
import java.sql.SQLException;

import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;

//javax.sql.DataSource : DBCP Ŭ������ �ۼ��ϱ� ���� ��ӹ޴� �������̽�
//=> DBCP Ŭ������ ������ �̸��� �޼ҵ尡 ����ǵ��� �޼ҵ� �ۼ� ��Ģ�� ����

//UCP(Universal Connection Pool) ���̺귯���� DBCP ���� Ŭ������ �̿��� JDBC ���α׷�
	//���� Apache�� Spring�� DBCP ����� �� ������ �⺻ ���ڴ� ����. - DataSource ���
public class DataSourceApp {
	public static void main(String[] args) throws SQLException {
		//PoolDataSource : DBCP ����� �����ϱ� ���� �ν��Ͻ�
		//PoolDataSourceFactory.getPoolDataSource() : PoolDataSource �ν��Ͻ��� �����Ͽ� ��ȯ 
			//Factory Ŭ������ ��κ� �̱��� �������������� ���� - �ν��Ͻ��� ���� ��ȯ�ϴ� Ŭ����
			//Factory Ŭ������ ������ �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ带 ���.
			// Factory Ŭ���� - Ư�� Ŭ������ �ν��Ͻ��� ����� �̸� �����ϱ� ���� Ŭ����(?)
			// Factory���� Design Pattern Ȯ��
		//DataSource ds=PoolDataSourceFactory.getPoolDataSource();
		PoolDataSource pds=PoolDataSourceFactory.getPoolDataSource();
		
		//Connection �ν��Ͻ��� �����ϱ� ���� PoolDataSource �ν��Ͻ��� �ʵ尪 ����
		//PoolDataSource.setConnectionFactoryClassName(String driver) : Driver Ŭ������ �����ϴ� �޼ҵ�
		pds.setConnectionFactoryClassName("oracle.jdbc.driver.OracleDriver");
		//PoolDataSource.setURL(String url) : DBMS ������ URL�� �����ϴ� �޼ҵ�
		pds.setURL("jdbc:oracle:thin:@localhost:1521:xe");
		//PoolDataSource.setUser(String user) : ����ڸ� �����ϴ� �޼ҵ�
		pds.setUser("scott");
		//PoolDataSource.setPassword(String password) : ��й�ȣ�� �����ϴ� �޼ҵ�
		pds.setPassword("tiger");
		
		//PoolDataSource �ν��Ͻ��� �̸� �����Ǿ� ����� Connection �ν��Ͻ��� ���Ѱ�����
		//�����ϱ� ���� �޼ҵ� ȣ�� - ���� ������ �������� ���� ��� �⺻�� ���
			//default ������ 10����.
		pds.setInitialPoolSize(2);//���� �����Ǵ� Connection �ν��Ͻ��� ���� ����
		pds.setMaxPoolSize(3);//�ִ� ���� ������ Connection �ν��Ͻ��� ���� ����
		
		//PoolDataSource.getConnection() : PoolDataSource �ν��Ͻ��� �̸� �����Ǿ� �����
		//Connection �ν��Ͻ� �� �ϳ��� ��ȯ�ϴ� �޼ҵ�
		Connection con1=pds.getConnection();
		System.out.println("con1 = "+con1);
		//PoolDataSource.getAvailableConnectionsCount() : ��� ������ Connection �ν��Ͻ���
		//������ ��ȯ�ϴ� �޼ҵ�
		System.out.println("��� ������ Connection �ν��Ͻ��� ���� = "
				+pds.getAvailableConnectionsCount());
		
		//Connection �ν��Ͻ��� �����ϸ� �ڵ����� PoolDataSource �ν��Ͻ��� ���ο�
		//Connection �ν��Ͻ��� �����Ͽ� �߰� - Connection ���� ����
		con1.close();
		
		System.out.println("��� ������ Connection �ν��Ͻ��� ���� = "
				+pds.getAvailableConnectionsCount());
		System.out.println("===========================================================================================================");
		Connection con2=pds.getConnection();
		System.out.println("con2 = "+con2);
		con2.close();
		System.out.println("===========================================================================================================");
		Connection con3=pds.getConnection();
		System.out.println("con3 = "+con3);
		con3.close();
		System.out.println("===========================================================================================================");
		Connection con4=pds.getConnection();
		System.out.println("con4 = "+con4);
		con4.close();
		System.out.println("===========================================================================================================");
		
	}
}