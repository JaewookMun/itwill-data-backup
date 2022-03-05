package realization;

//DBMS�� �̿��� �л� ���� ���α׷�
public class JdbcApp {
	public static void main(String[] args) {
		/*
		JdbcMysql mysql=new JdbcMysql();
		
			//MySQL�� �ӵ��� ��������� ������ ū �����͸� �ٷ�� ��ƴ�.
			//MariaDB (MySQL �����ڰ� �ι�°�� ���� DBMS)
			//ù°�� �̸� My, ��°�� Maria
			//Java�� �����ý��� ���࿡ �����ϴ�. 
			//Oracle�� ������.
		mysql.insert();
		mysql.update();
		mysql.delete();
		mysql.select();
		*/
			//���������� �ƴ϶� ���ο� �ý����� �̿��� '�����۾�'���� �� �� �ִ�.
		
		/*
		//�ý��� ���濡 ���� Ŭ���� ����� ���α׷��� ��κ��� ���� ó�� - �޼ҵ尡 �ٸ��� ������.
		//=> Ŭ���� ���� ���յ��� ���� ���������� ȿ���� ����
		JdbcOracle oracle = new JdbcOracle();
		
		oracle.add();
		oracle.modify();
		oracle.remove();
		oracle.search();
		*/
			//Mysql, oracle�� ���鶧 ��Ģ�� ���� �������� ����. -> �������̽��� ���ؼ� ��Ģ�� ������ش�.

		//�������̽��� �̿��Ͽ� Ŭ������ �ۼ��� ��� �ý��� ���濡 ���� Ŭ���� �����
		//���α׷��� �Ϻκи� ���� ó�� ����
		//=> Ŭ���� ���� ���յ��� ���� ���������� ȿ���� ����
		//JdbcMysql jdbc=new JdbcMysql();
		//JdbcOracle jdbc=new JdbcOracle();
		
		//���������� �θ� �������̽��� �̿��Ͽ� �����ϴ� ���� ����
		//Jdbc jdbc=new JdbcMysql();
			//�������̽��� �̿��ϸ� ���ٸ� ������ ���� �� �ִ�.
		Jdbc jdbc=new JdbcOracle();
				
		jdbc.insert();
		jdbc.update();
		jdbc.delete();
		jdbc.select();
	}
}
