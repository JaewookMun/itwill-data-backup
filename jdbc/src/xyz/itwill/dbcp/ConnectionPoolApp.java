package xyz.itwill.dbcp;

import java.sql.Connection;
import java.sql.SQLException;

//DBCP(DataBase ConnectionPool) : Connection �ν��Ͻ��� �̸� ���� �� �����Ͽ� �����ϰ�
//Connection�� ��ȯ�ϴ� ����� �����ϱ� ���� Ŭ����
//=> Connection �ν��Ͻ��� �����ϱ� ���� ������ ���� ������ ����
//=> Connection �ν��Ͻ��� �̸� ����� ����ϹǷ� JDBC ���α׷��� ���� �ӵ� ����
//=> Connection �ν��Ͻ��� ���� ���� ����
	//Connection Pool�� �ٲ�� ���α׷��� �ٲ����. (e.g. �޼ҵ尡 �ٲ�� ������..)
	//Connection pool�� ǥ���� �������̽��� ����. - DataSource�������̽�
	//DataSource�� ��ӹ޴� Ŭ���� - UCP���̺귯�� (ǥ���������̽� ���).
	// ���̼��� ����� �� �� ���������ڼ��� �����ϴµ� Connection pool�� Ȱ���Ͽ� 
	// �̸� �̸� ������ �� ����.
	// ConnectionPool�� SunMicro���� ���������� ����ϱ� ���� ���
	// ConnectionPool�� ���� DataSource �������̽��� ��ӹ޴� Ŭ������ ���.
public class ConnectionPoolApp {
	public static void main(String[] args) throws SQLException {
		//ConnectionPool �ν��Ͻ��� ��ȯ�޾� ����
		//=> �̱��� ������ ������ ����� Ŭ�����̹Ƿ� ���α׷��� �ν��Ͻ��� �ϳ��� ����
		//=> Connection �ν��Ͻ��� �̸� ���� �� �����Ͽ� �ݷ��� �ʵ忡 ����
		ConnectionPool cp=ConnectionPool.getInstance();
		
		//ConnectionPool.getConnection() : �̸� �����Ǿ� ����� Connection �ν��Ͻ� ��
		//�ϳ��� ��ȯ�ϴ� �޼ҵ�
		Connection con1=cp.getConnection();
		System.out.println("con1 = "+con1);
		//ConnectionPool.freeConnection(Connection con) : �������� Connection �ν��Ͻ��� �ٽ� ConnectionPool
		//�ν��Ͻ��� �����ִ� �޼ҵ�
		//cp.freeConnection(con1);
		
		Connection con2=cp.getConnection();
		System.out.println("con2 = "+con2);
		//cp.freeConnection(con2);
		
		Connection con3=cp.getConnection();
		System.out.println("con3 = "+con3);
		cp.freeConnection(con3);
		
		Connection con4=cp.getConnection();
		System.out.println("con4 = "+con4);
		cp.freeConnection(con4);
	}
}