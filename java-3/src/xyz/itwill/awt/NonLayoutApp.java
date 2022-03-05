package xyz.itwill.awt;

import java.awt.Button;
import java.awt.Frame;

//모든 컨테이너에는 전달된 컴퍼넌트를 자동 부착하는 기능을 제공하는 배치 관리자가 존재
//배치 관리자(Layout Manager) : 컨테이너에 컴퍼넌트를 배치할 때 컴퍼넌트의 크기와 출력
//위치를 자동으로 변경하는 기능을 제공하는 클래스
//=> BorderLayout, FlowLayout, GridLayout 등
//=> 컨테이너에는 기본 배치 관리자가 존재하며 컨테이너의 배치 관리자는 변경 가능
	//모든 GUI는 배치관리자가 존재 - e.g. 안드로이드 역시 위젯(컴퍼넌트 대신)을 위한 배치관리자 존재
public class NonLayoutApp extends Frame {
	private static final long serialVersionUID = 1L;

	public NonLayoutApp(String title) {
		super(title);
		
		//Container.setLayout(LayoutManager mgr) : 컨테이너의 배치 관리자를 변경하는 메소드
		//=> setLayout()메소드에 (LayoutManager 관련 인스턴스 대신) null을 전달하면 배치 관리자를 사용하지 않도록 설정
			//배치관리자를 사용 안하고 수동으로 설정하겠다는 의미 - 권장x
			//LayoutManager 사용을 권장한다.
		setLayout(null);
		
		Button button1 = new Button("버튼-1");
		Button button2 = new Button("버튼-2");
		
		//배치 관리자를 사용하지 않을 경우 컴퍼넌트의 크기와 출력위치를 변경해야만 컨테이너에 부착 가능
			//기준점은 프레임이 기준이다. (프레임 좌상단 꼭지점을 기준(0,0)으로 삼는다.)
			//속성이 고정되기 때문에 프레임의 변경에 영향을 받지 않는다. - 디자인이 망가질 수 있다.
		button1.setBounds(80, 100, 50, 80);
		button2.setBounds(190, 130, 100, 120);
		
		add(button1);
		add(button2);
		
		
		setBounds(600, 100, 400, 500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new NonLayoutApp("NonLayout");
	}

}
