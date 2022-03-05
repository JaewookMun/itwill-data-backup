package xyz.itwill.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

//BorderLayout : 컴퍼넌트를 동,서,남,북, 중앙으로 구분하여 부착하는 배치 관리자 클래스
//=> add() 메소드 호출시 위치를 지정하여 컴퍼넌트를 부착
//=> Frame, Window, Dialog 등의 컨테이너는 BorderLayout을 기본 배치 관리자로 설정
public class BorderLayoutApp extends Frame {
	private static final long serialVersionUID = 1L;

	public BorderLayoutApp(String title) {
		super(title);
		
		//프레임의 배치 관리자를 BorderLayout으로 변경
		//BorderLayout layout = new BorderLayout();
		//setLayout(layout);
			//프로그램을 만들 때 변수를 많이 만드는 것을 권장하지 않는다.
		
		//Frame의 기본 배치 관리자는 BorderLayout이므로 배치 관리자 변경 무의미
		//setLayout(new BorderLayout());
		
		Button button1 = new Button("버튼-1");
		Button button2 = new Button("버튼-2");
		Button button3 = new Button("버튼-3");
		Button button4 = new Button("버튼-4");
		Button button5 = new Button("버튼-5");
		
		//Container.add(Component c, Object constraints) : 컴퍼넌트를 원하는 컨테이너
		//위치에 배치하는 메소드
		//=> 컴퍼넌트 배치 위치는 BorderLayout 클래스의 상수필드 이용
		//=> 컴퍼넌트 배치 위치가 생략된 경우 무조건 중앙에 부착
		//=> 중앙에는 반드시 컴퍼넌트를 배치해야 하지만 동,서,남,북 위치에는 컴퍼넌트 배치 생략가능 
			// constraints는 문자열, 상수가 와도 되지만 상수필드를 권장한다.
		add(button1, BorderLayout.EAST);
		add(button2, BorderLayout.WEST);
		add(button3, BorderLayout.SOUTH);
		add(button4, BorderLayout.NORTH);
		add(button5, BorderLayout.CENTER);
		
		setBounds(600, 100, 400, 400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new BorderLayoutApp("BorderLayout");
	}
}
