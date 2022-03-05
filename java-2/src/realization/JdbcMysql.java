package realization;

//��Ŭ������ �̿��Ͽ� Ŭ������ �������̽��� �����Ͽ� �����ϴ� ���
//Ŭ���� >> Refactor >> Extract Interface >> �������̽��� �Է� �� �޼ҵ� ���� >> OK

//Mysql DBMS(DataBase Management System)�� �̿��� �л����� ����� �����ϴ� Ŭ����
public class JdbcMysql implements Jdbc {
	@Override
	public void insert() {
		System.out.println("[Mysql]�л������� ���� �Ͽ����ϴ�.");
	}
	@Override
	public void update() {
		System.out.println("[Mysql]�л������� ���� �Ͽ����ϴ�.");
	}
	@Override
	public void delete() {
		System.out.println("[Mysql]�л������� ���� �Ͽ����ϴ�.");
	}
	@Override
	public void select() {
		System.out.println("[Mysql]�л������� �˻� �Ͽ����ϴ�.");
	}
	
}
