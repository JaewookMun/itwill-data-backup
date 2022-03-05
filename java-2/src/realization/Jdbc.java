package realization;

//DBMS를 이용하여 학생관리 기능을 제공하는 클래스가 반드시 상속받아야 되는 인터페이스
//=> 상속받은 자식 클래스에게 메소드 작성 규칙 제공
public interface Jdbc {
	void insert();
	void update();
	void delete();
	void select();
}