package xyz.itwill.jdbc;

public class StaticBlock {
	//정적영역(Static Block) : ClassLoader 프로그램에 의해 클래스가 메모리에 저장된 후 
	//자동으로 실행될 명령을 작성하는 영역 - 정적영역의 명령은 프로그램에서 한번만 실행
	static {
		System.out.println("### StaticBlock 클래스의 정적영역에 작성된 명령 실행 ###");
		
			//정적영역에서 자신의 생성자를 이용하여 인스턴스를 만들어 메소드를 호출함.
		StaticBlock sb=new StaticBlock();
		sb.display();
	}
	
	public StaticBlock() {
		System.out.println("### StaticBlock 클래스의 생성자 호출 - 인스턴스 생성 ###");
	}
	
	
	public void display() {
		System.out.println("### StaticBlock 클래스의 display() 메소드 호출 생성 ###");
		
	}
}
