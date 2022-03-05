package xyz.itwill.event;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//디자인 클래스는 외부 클래스로 선언하고 이벤트 핸들러 클래스는 내부 클래스로 선언한 경우
//=> 이벤트 핸들러 메소드에서 디자인 클래스의 컴퍼넌트 또는 컨테이너 제어 가능
public class EventSourceInnerHandlerApp extends Frame {
	private static final long serialVersionUID = 1L;

	public EventSourceInnerHandlerApp(String title) {
		super(title);
		
		setLayout(new FlowLayout());
		Button button = new Button("프로그램 종료");
		add(button);
		
		button.addActionListener(new ActionEventInnerHandler());
		
		
		setBounds(800, 200, 300, 300);
		setVisible(true);
		
	}
	
	
	public static void main(String[] args) {
		new EventSourceInnerHandlerApp("EventHandle"); 
	}
		
		//외부클래스는 메소드에서 내부클래스의 인스턴스 생성이 가능
		//내부클래스는 외부클래스의 필드와 메소드에 접근 가능하다.
	public class ActionEventInnerHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
		
	}
}
