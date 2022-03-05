package xyz.itwill.student;

// DTO(Data Transfer Object) 클래스 : DAO 클래스의 메소드에서 행정보를 전달받거나 반환하기
// 위한 목적의 클래스 - VO(Value Object) 클래스
// => 테이블의 컬럼과 1:1로 매칭되는 필드 선언 - Getter & Setter
// => 필드명은 테이블의 컬럼명과 동일하게 작성하는 것을 권장
	// 값들을 전달받거나 반환하기 위해 만드는 클래스

	// [2021.06.21 edited]
	// 보통 테이블 하나당 DAO, DTO를 하나씩 배정한다.
	// 하지만 DAO & DTO의 갯수는 테이블 갯수보다 더 많아 질 수 있다. => JOIN 케이스 고려
	// 1.기획 -> 2.화면설계 -> 3-1.디자인 			->		   	      6.'App'
	//		            -> 3-2.DB설계 -> 4.Table -> 5.DTO & DAO -> 6.'App'
	// 설계가 잘못되면 프로그램을 다시 만들어야하는 경우 발생
	// 팀프로젝트는 기획을 하면서 담당을 설정해야한다. - 업무분담 : 구매, 회원, 장바구니 등
	// => 업무분담을 맡은 사람들이 화면의 디자인을 같이 해줘야한다.
	// => 마지막에 합쳐서 프로그램을 테스트를 진행

/*
이름       널?       유형            
-------- -------- ------------- 
NO       NOT NULL NUMBER(4)     
NAME              VARCHAR2(30)  
PHONE             VARCHAR2(20)  
ADDRESS           VARCHAR2(100) 
BIRTHDAY          DATE          
*/

// STUDENT 테이블의 행정보(학생정보)를 저장하여 전달하기 위한 클래스
	// 저장만을(VO) 위한 목적이 아니라 메소드를 통해 전달하거나 전달받기 위한 기능이 추가됨. (DTO)
public class StudentDTO {
	private int no;
	private String name;
	private String phone;
	private String address;
	private String birthday;
	
		// 컬럼명을 스네이크표기법을 사용해서 표기했다면 카멜표기법으로 바꾸어 선언해준다.
		// e.g. USER_NAME  => userName
	
	public StudentDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public StudentDTO(int no, String name, String phone, String address, String birthday) {
		super();
		this.no = no;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.birthday = birthday;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	
	
}
