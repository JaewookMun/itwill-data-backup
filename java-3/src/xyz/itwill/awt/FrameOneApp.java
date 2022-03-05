package xyz.itwill.awt;

import java.awt.Frame;

//컴퍼넌트(Component) : GUI 프로그램의 디자인 요소를 구현한 클래스
//=> Button, Label, Canvas, List, CheckBox, Choice, Scrollbar, TextField, TextArea 등
//컨테이너(Container) : 컴퍼넌트를 담을 수 있는 컴퍼넌트
//=> Frame, Window, Dialog, Panel, ScrollPane 등
		//GUI프로그램을 만들 때 가장 중요한 요소
		//container -> 컴퍼넌트를 그룹화
		//scrollbar - 위치를 이동시켜서 값을 얻을 수 있는것  & scrollpan - 위치만 이동
public class FrameOneApp {
	public static void main(String[] args) {
		//Frame : 메뉴가 있는 창을 만들기 위한 컨테이너
		//Frame f = new Frame(); //제목이 없는 프레임 생성
		Frame f = new Frame("프레임"); //제목이 있는 프레임 생성
			//메모리상에 생성 - 실제눈으로는 확인할 수 없음.
		
		//Frame.setTitle(String title) : 프레임의 제목을 변경하는 메소드
		//f.setTitle("프레임");
		
		//Component.setSize(int width, int height) : 컴퍼넌트의 크기(폭과 높이)를 변경하는 메소드
		//=> GUI 프로그램에서는 위치 또는 크기 단위로 픽셀 사용
		//픽셀(Pixel) : 하나의 색을 출력할 수 있는 점(Dot)
			//해상도 1920 x 1080 : 가로로 1920개 세로로 1080개 찍을 수 있다.
			//해상도가 높다. : 색을 많이 찍을 수 있다. 해상도가 낮다 : 색을 적게 찍을 있다.
		//f.setSize(300, 400);
		
		//Component.setLocation(int x, int y) : 컴퍼넌트의 출력위치(x좌표와 y좌표)를 변경하는 메소드
		//f.setLocation(600, 100);
		
		//Component.setBounds(int x, int y, int width, int height); : 컴퍼넌트의
		//출력위치와 크기를 변경하는 메소드
		f.setBounds(600, 100, 300, 400);

		//Frame.setResizable(boolean b) : 프레임의 크기 변경 여부를 설정하는 메소드
		//=> false : 크기 변경 불가능, true : 크기 변경 가능(기본값)
			//프레임에만 있는 메소드 (컴퍼넌트, 다른 컨테이너에 없음)
		f.setResizable(false);
		
		//Component.setVisible(boolean b) : 컴퍼넌트의 화면 출력 여부를 설정하는 메소드
			//프레임을 눈에 보이게 만듬
		//=> false : 미출력(기본), true : 출력
		//=> 컨테이너에 대한 설정은 컨테이너에 부착된 컴퍼넌트에 영향
			//무조건은 아님
		f.setVisible(true);
			//프레임에 추가가 된 컴퍼넌트들도 영향을 받아서 visible된다.
			//왼쪽상단에 조그맣게 생성됨.
		
		
		
	}
}
