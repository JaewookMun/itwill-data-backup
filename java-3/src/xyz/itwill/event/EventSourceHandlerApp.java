package xyz.itwill.event;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//디자인 클래스와 이벤트 핸들러 클래스를 하나의 클래스로 선언한 경우
//=> 이벤트 핸들러 메소드에서 디자인 클래스의 컴퍼넌트 또는 컨테이너 제어 가능
public class EventSourceHandlerApp extends Frame implements ActionListener {
	private static final long serialVersionUID = 1L;

	public EventSourceHandlerApp(String title) {
		super(title);
		
		setLayout(new FlowLayout());
		
		Button button = new Button("프로그램 종료");
		add(button);
		
			//this: 클래스 메소드에서 자신을 표현할 때 사용.
		button.addActionListener(this);
		
		setBounds(800, 200, 300, 300);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
	
	public static void main(String[] args) {
		new EventSourceHandlerApp("EventHandle");
	
	}

}
