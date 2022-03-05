package realization;

//DBMS를 이용한 학생 관리 프로그램
public class JdbcApp {
	public static void main(String[] args) {
		/*
		JdbcMysql mysql=new JdbcMysql();
		
			//MySQL은 속도가 상대적으로 느리고 큰 데이터를 다루기 어렵다.
			//MariaDB (MySQL 개발자가 두번째로 만든 DBMS)
			//첫째딸 이름 My, 둘째딸 Maria
			//Java는 대형시스템 구축에 적합하다. 
			//Oracle을 사용권장.
		mysql.insert();
		mysql.update();
		mysql.delete();
		mysql.select();
		*/
			//유지보수가 아니라 새로운 시스템을 이용한 '개발작업'으로 볼 수 있다.
		
		/*
		//시스템 변경에 의한 클래스 변경시 프로그램의 대부분을 변경 처리 - 메소드가 다르기 때문에.
		//=> 클래스 간의 결합도가 높아 유지보수의 효율성 감소
		JdbcOracle oracle = new JdbcOracle();
		
		oracle.add();
		oracle.modify();
		oracle.remove();
		oracle.search();
		*/
			//Mysql, oracle을 만들때 규칙이 없이 마음데로 만듬. -> 인터페이스를 통해서 규칙을 만들어준다.

		//인터페이스를 이용하여 클래스를 작성할 경우 시스템 변경에 의한 클래스 변경시
		//프로그램의 일부분만 변경 처리 가능
		//=> 클래스 간의 결합도를 낮춰 유지보수의 효율성 증가
		//JdbcMysql jdbc=new JdbcMysql();
		//JdbcOracle jdbc=new JdbcOracle();
		
		//참조변수는 부모 인터페이스를 이용하여 생성하는 것을 권장
		//Jdbc jdbc=new JdbcMysql();
			//인터페이스를 이용하면 별다른 수정이 없을 수 있다.
		Jdbc jdbc=new JdbcOracle();
				
		jdbc.insert();
		jdbc.update();
		jdbc.delete();
		jdbc.select();
	}
}
