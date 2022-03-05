package xyz.itwill.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

//Panel : 컴퍼넌트를 배치하기 위한 컨테이너 클래스
//=> 다른 컨테이너에 배치하여 동작되는 종속적인 컨테이너
	//독립적으로 눈에 보여질 수 없다. - 다른 컨테이너에 부착되어 보여짐 
	//패널을 활용해서 복합적인 배치를 통해 디자인할 수 있다.
public class PanelApp extends Frame {
	private static final long serialVersionUID = 1L;

	public PanelApp(String title) {
		super(title);
		
			//빛의 3원소 (RGB) (컴퓨터에서 표현할 수 있는 색) - 색의 3원소와 다름
		Button red = new Button("빨간색");
		Button green = new Button("초록색");
		Button blue = new Button("파란색");
		
		//패널의 기본 배치 관리자는 FlowLayout으로 설정
		Panel panel=new Panel();
		
		//패널에 컴퍼넌트 배치
		panel.add(red);
		panel.add(green);
		panel.add(blue);
		
		//TextArea : 텍스트를 여러 줄 입력하거나 출력하기 위한 컴퍼넌트
		TextArea textArea = new TextArea();
	
		//TextField : 텍스트를 한 줄 입력하거나 출력하기 위한 컴퍼넌트
		TextField textField = new TextField();

		//프레임의 기본 배치 관리자는 BorderLayout으로 설정
		//프레임에 컴퍼넌트(컨테이너)를 배치
		add(panel, BorderLayout.NORTH);
		add(textArea, BorderLayout.CENTER);
		add(textField, BorderLayout.SOUTH);
		
		//Component.setFont(Font F) : 컴퍼넌트의 글자 관련 속성을 변경하는 메소드
		//Font : 글자 관련 속성을 저장하기 위한 클래스
		//=> Font(String name, int style, int size) : name(글꼴), style(스타일), size(크기)
		//=> 컨테이너의 디자인 관련 속성을 변경하면 종속된 컴퍼넌트의 디자인 관련 속성도 변경
			//awt에서는 dialog, sans serif, serif 밖에 없음. [SERIF/맑은 고딕]이 window의 기본글꼴
		panel.setFont(new Font(Font.SERIF, Font.BOLD, 16));
		textArea.setFont(new Font(Font.SERIF, Font.PLAIN, 16));
		textField.setFont(new Font(Font.SERIF, Font.BOLD+Font.ITALIC, 16));
		
		//Component.setForeground(Color c) : 컴퍼넌트의 글자색을 변경하는 메소드
		//Color : 색상정보(RED:0~255, GREEN:0~255, BLUE:0~255)를 저장하기 위한 클래스
			//16만개의 색을 표현가능
		red.setForeground(new Color(255, 0, 0));
		green.setForeground(new Color(0, 255, 0));
		blue.setForeground(new Color(0, 0, 255));
		
		//Component.setBackground(Color c) : 컴퍼넌트의 배경색을 변경하는 메소드
		//=> Color 클래스에서는 대표적인 색을 상수필드로 제공
		//=> 컨테이너의 배경색을 변경한 경우 종속된 컴퍼넌트의 배경색은 미변경
			//글자의 경우 패널의 속성변경에 종속되지만 배경색은 함께 바뀌지 않는다.
		panel.setBackground(Color.GRAY);
		
		//Component.setEnabled(boolean b) : 컴퍼넌트의 활성 여부를 설정하기 위한 메소드
		//=> false : 컴퍼넌트 비활성, true : 컴퍼넌트 활성(기본)
			//비활성화되면 동작이 안된다. (눌러지는 행위자체가 구현되지 않는다.)
		red.setEnabled(false);
		
		//TextComponent.setEditable(boolean b) : 텍스트 컴퍼넌트의 텍스트 입력 기능 사용여부를 설정하기 위한 메소드
		//=> false : 입력 기능 비활성, true : 입력 기능 활성(기본)
			//텍스트컴퍼넌트은 에어리아와 필드 2가지밖에 없음.
		//textArea.setEditable(false);
		
		//Component.setFocusable(boolean b) : 컴퍼넌트의 입력 촛점 위치 여부를 설정하기위한 메소드
		//=> false : 입력 촛점(focus) 위치 불가능, true : 입력 촛점 위치 가능(기본)
		textArea.setFocusable(false);
	
		
		
		setBounds(600, 100, 300, 400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new PanelApp("Panel");

	
	
	}
}
