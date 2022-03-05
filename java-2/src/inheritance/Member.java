package inheritance;

//회원정보(아이디, 이름)를 저장하기 위한 클래스
public class Member {
	private String id;
	private String name;
	
	//ctrl + space >> Constructor 선택(엔터)
	public Member() {
		// 기본생성자를 안만들면 상속이 안됨.
	}
	// alt+shift+s >> o >> choose the field >> generate
	public Member(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	// alt+shift+s >> r >> choose the field >> generate
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//자식 클래스에서 오버라이드 선언된 부모 클래스의 메소드는 숨겨진 메소드(Hide Method)로 처리된다.
	//=> 부모 클래스의 숨겨진 메소드에 접근하면 자동으로 자식 클래스의 오버라이드 메소드 호출
	public void display() {
		System.out.println("아이디 = "+id);
		System.out.println("이름 = "+name);
	}
	
}
