package realization;

//이클립스를 이용하여 클래스로 인터페이스를 추출하여 생성하는 방법
//클래스 >> Refactor >> Extract Interface >> 인터페이스명 입력 및 메소드 선택 >> OK

//Mysql DBMS(DataBase Management System)를 이용해 학생관리 기능을 제공하는 클래스
public class JdbcMysql implements Jdbc {
	@Override
	public void insert() {
		System.out.println("[Mysql]학생정보를 저장 하였습니다.");
	}
	@Override
	public void update() {
		System.out.println("[Mysql]학생정보를 변경 하였습니다.");
	}
	@Override
	public void delete() {
		System.out.println("[Mysql]학생정보를 삭제 하였습니다.");
	}
	@Override
	public void select() {
		System.out.println("[Mysql]학생정보를 검색 하였습니다.");
	}
	
}
