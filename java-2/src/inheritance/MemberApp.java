package inheritance;

public class MemberApp {
	public static void main(String[] args) {
		Member member1 = new Member();
		
			//default 생성자로 객체를 만들었고 매개변수 값이 있다면 setter를 통해서 필드를 초기화
		member1.setId("abc123");
		member1.setName("홍길동");
		
		member1.display();
		System.out.println("==============================================================");
		Member member2 = new Member("xyz789", "임꺽정");
		member2.display();
		System.out.println("==============================================================");
		
	}
}
