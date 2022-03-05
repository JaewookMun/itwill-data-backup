package xyz.itwill01.old;

public class MessagePrintApp {
	public static void main(String[] args) {
		/*
		HelloMessagePrint print=new HelloMessagePrint();
		print.helloMessagePrint();
		*/
		
		HiMessagePrint print=new HiMessagePrint();
		print.hiMessagePrint();
	}
}

/*
	MessagePrintApp < HelloMessagePrint < HelloMessageObject
	
	결합도가 굉장히 높기 때문에 유지보수가 힘들다.
	HelloMessageObject를 다른 클래스로 바꿀 경우 
	이를 사용하는 HelloMessagePrint와 MessagePrintApp 역시 이에 맞추어 바꿔줘야한다.
	
	- 결합도가 높기 때문에 다른 클래스 및 프로그램까지 변경이 필요함.
	> 유지보수가 아니라 새로 개발하는 것과 같은 효과를 가져옴.
 */
