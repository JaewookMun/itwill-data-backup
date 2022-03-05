package xyz.itwill.awt;

import java.awt.Button;
import java.awt.Frame;

public class ComponentAddAPP extends Frame {
	private static final long serialVersionUID = 1L;
	
	public ComponentAddAPP(String title) {
		super(title);
		
		//Button : 버튼을 구현한 컴퍼넌트 클래스 - 버튼라벨 설정
			//버튼에 있는 문자열을 라벨명이라고 부른다.
		Button button = new Button("버튼");
		
		//Container.add(Component c) : 컴퍼넌트를 컨테이너에 부착하는 메소드
			//모든 컨테이너에는 컴퍼넌트를 부착하는 방법(규칙)이 내장되어 있다. - 레이아웃
			//레이아웃을 바꿔주어야 원하는 모양으로 컴퍼넌트를 부착할 수 있다.  - LayoutManager
		add(button);
		
		setBounds(600, 100, 300, 300);
		setVisible(true);
	
	}
	public static void main(String[] args) {
		new ComponentAddAPP("컴퍼넌트");
		
		
	}

}
